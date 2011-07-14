package com.d4l3k.Link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Data {
	
	public static int serverTickRate = 10;
	
	public static Map<Player, Boolean> playerEditMode = new HashMap<Player, Boolean>();
	public static Map<Player, Integer> playerEditStatus = new HashMap<Player, Integer>();
	public static Map<Player, Integer> playerEditSelection = new HashMap<Player, Integer>();
	public static Map<Player, Block> playerEditFirstGate = new HashMap<Player, Block>();
	public static Map<Player, Block> playerEditSecondGate = new HashMap<Player, Block>();
	public static Map<Player, Integer> playerEditSecondSelection = new HashMap<Player, Integer>();
	
	public static ArrayList<BaseGate> allGates = new ArrayList<BaseGate>();
	public static void saveGates()
	{
		ArrayList<SaveGate> saveGates = new ArrayList<SaveGate>();
		for(int i=0;i<allGates.size();i++)
		{
			saveGates.add(new SaveGate(allGates.get(i)));
		}
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			(new File("./plugins/Link")).mkdirs();
			fos = new FileOutputStream("./plugins/Link/link.ser");
			out = new ObjectOutputStream(fos);
			//for(int i=0;i<allGates.size();i++)
			//{
			//	 out.writeObject(allGates.get(i));
			//}
			out.writeObject(saveGates);
			out.close();
	    }
	    catch(IOException ex)
	    {
	    	Core.debug(ex.toString());
	    }
	}
	
	@SuppressWarnings("unchecked")//The cast warning was irritating me, is there a better way to cast the gate?
	public static void loadGates()
	{
		ArrayList<SaveGate> saveGates = new ArrayList<SaveGate>();
		
		FileInputStream fis = null;
		ObjectInputStream in = null;
		File dir = new File("./plugins/Link");
		String[] children = dir.list();
		if(children==null)
			return;
		
		try
		{
			
			fis = new FileInputStream("./plugins/Link/link.ser");
			in = new ObjectInputStream(fis);
			saveGates = (ArrayList<SaveGate>) in.readObject();
			in.close();
	    }
	    catch(IOException ex)
	    {
	    	Core.debug(ex.toString());
	    } catch (ClassNotFoundException ex) {
	    	Core.debug(ex.toString());
		}
		for(int i=0;i<saveGates.size();i++)
		{
			updateGate(saveGates.get(i).getBaseGate());
		}
	}
	public static void addGate(BaseGate gate)
	{
		allGates.add(gate);
	}
	public static void updateGate(BaseGate gat)
	{
		if(gat.equals(null))
			return;
		
		Block block = gat.gateBlock;
		for(int i=0;i<allGates.size();i++)
		{
			BaseGate gate = allGates.get(i);
			if(gate.gateBlock.equals(block))
			{
				allGates.remove(gate);
			}
		}
		allGates.add(gat);
	}
	public static void removeGate(BaseGate gate)
	{
		allGates.remove(gate);
	}
	public static Object getInput(Block block, int Input)
	{
		return getInput(block,Input,"");
	}
	public static Object getInput(Block block, int Input, Object escape)
	{
		BaseGate gate = getBaseGate(block);
		if(gate.gateOutputs.length>0)
		{
			return gate.gateOutputs[Input];
		}
		return escape;
	}
	
	public static BaseGate getBaseGate(Block block)
	{
		for(int i=0;i<allGates.size();i++)
		{
			BaseGate gate = allGates.get(i);
			if(gate.gateBlock.equals(block))
			{
				return gate;
			}
		}
		return new BaseGate();
	}
	
	public static void updateInput(Block block, int Input)
	{
		for(int i=0;i<allGates.size();i++)
		{
			BaseGate gate = allGates.get(i);
			Block[] Inputs = gate.gateInputs;
			int[] Index = gate.gateInputIndexs;
			for(int r =0;r<Inputs.length;r++)
			{
				if(block.equals(Inputs[r])&&Input==Index[r])
				{
					GateConfig.executeBaseGate(gate);
				}
			}
		}
	}
	
	public static void runSelfTriggered()
	{
		for(int i=0;i<allGates.size();i++)
		{
			BaseGate gate = allGates.get(i);
			if(gate.gateSelfTriggered)
			{
				GateConfig.executeBaseGate(gate);
			}
		}
	}
}
