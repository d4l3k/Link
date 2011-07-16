package com.d4l3k.Link.Gate.Mechanic;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Core;
import com.d4l3k.Link.Data;
import com.d4l3k.Link.GateLocation;


public class PlayerPosition extends BaseGate{
	public PlayerPosition(SignChangeEvent event)
	{
		this.gateName = "Player Position";
		this.gateID = "[PlayerPos]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Location";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "location";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Update";
		this.gateInputNames[1] = "Player";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "string";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
	}
	public PlayerPosition() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		Location pos = gateBlock.getLocation();
		String plr = (String)Data.getInput(gateInputs[1], gateInputIndexs[1]);
		pos = getPlayer(plr).getLocation();
		
		this.gateOutputs[0]=new GateLocation(pos);
		Data.updateInput(gateBlock, 0);
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, "T: "+gateBlock.getWorld().getName());
		sig.update();
	}
	public Player getPlayer(String search)
	{
		Player[] plrs = Core.server.getOnlinePlayers();
		for(int i=0;i<plrs.length;i++)
		{
			String name = plrs[i].getName();
			if(name.contains(search)&&plrs[i].getWorld().equals(gateBlock.getWorld()))
			{
				return plrs[i];
			}
		}
		return null;
	}
}
