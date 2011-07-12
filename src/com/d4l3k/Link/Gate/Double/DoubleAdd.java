package com.d4l3k.Link.Gate.Double;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class DoubleAdd extends BaseGate{
	public DoubleAdd(SignChangeEvent event)
	{
		this.gateName = "Double Add";
		this.gateID = "[Add]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[8];
		this.gateInputNames[0] = "Double1";
		this.gateInputNames[1] = "Double2";
		this.gateInputNames[2] = "Double3";
		this.gateInputNames[3] = "Double4";
		this.gateInputNames[4] = "Double5";
		this.gateInputNames[5] = "Double6";
		this.gateInputNames[6] = "Double7";
		this.gateInputNames[7] = "Double8";
		this.gateInputTypes = new String[8];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "double";
		this.gateInputTypes[2] = "double";
		this.gateInputTypes[3] = "double";
		this.gateInputTypes[4] = "double";
		this.gateInputTypes[5] = "double";
		this.gateInputTypes[6] = "double";
		this.gateInputTypes[7] = "double";

		this.gateInputs = new Block[8];
		this.gateInputIndexs = new int[8];
		Execute();
	}
	public DoubleAdd() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		double data = (Double)Data.getInput(gateInputs[0], gateInputIndexs[0], 0.0);
		for(int i=1;i<8;i++)
		{
			if(!Data.getBaseGate(gateInputs[i]).gateName.equalsIgnoreCase(""))
			{
				data+=(Double)Data.getInput(gateInputs[i], gateInputIndexs[i], 0.0);
			}
		}
		
		this.gateOutputs[0]=data;
		Data.updateInput(gateBlock, 0);
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, Double.toString(data));
		sig.update();
	}
}
