package com.d4l3k.Link.Gate.Double;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class DoubleEqual extends BaseGate{
	public DoubleEqual(SignChangeEvent event)
	{
		this.gateName = "Double Equal";
		this.gateID = "[Equal]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Equal";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Double1";
		this.gateInputNames[1] = "Double2";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
		Execute();
	}
	public DoubleEqual() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		double data = 0.0;
		if(Data.getInput(gateInputs[0], gateInputIndexs[0]).equals(Data.getInput(gateInputs[1], gateInputIndexs[1])))
		{
			data = 1.0;
		}
		
		this.gateOutputs[0]=data;
		Data.updateInput(gateBlock, 0);
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, "Equal: "+Double.toString(data));
		sig.update();
	}
}
