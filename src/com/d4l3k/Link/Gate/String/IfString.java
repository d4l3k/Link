package com.d4l3k.Link.Gate.String;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class IfString extends BaseGate{
	public IfString(SignChangeEvent event)
	{
		this.gateName = "If Value Then String";
		this.gateID = "[IfString]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "string";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "If";
		this.gateInputNames[1] = "String";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "string";

		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
		Execute();
	}
	public IfString() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		String output = "";
		if(((Double)Data.getInput(gateInputs[0], gateInputIndexs[0], 0.0))>=1.0)
		{
			output = (String)Data.getInput(gateInputs[1], gateInputIndexs[1], "");
		}
		
		this.gateOutputs[0]=output;
		Data.updateInput(gateBlock, 0);
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, output);
		sig.update();
	}
}
