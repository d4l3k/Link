package com.d4l3k.Link.Gate.Double;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class DoubleToString extends BaseGate{
	public DoubleToString(SignChangeEvent event)
	{
		this.gateName = "Double To String";
		this.gateID = "[ToString]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Output";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "string";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Value";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
		Execute();
	}
	public DoubleToString() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		String data = Double.toString((Double)Data.getInput(this, 0, 0.0));
		if(!gateOutputs[0].equals(data))
		{
			this.gateOutputs[0]=data;
			Data.updateInput(gateBlock, 0);
		}
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, data);
		sig.update();
	}
}
