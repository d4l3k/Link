package com.d4l3k.Link.Gate.Time;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class Counter extends BaseGate{
	public Counter(SignChangeEvent event)
	{
		this.gateName = "Double Counter";
		this.gateID = "[Counter]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		this.gateOutputs[0] = 0;
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Increment";
		this.gateInputNames[1] = "Reset";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
		
		this.gateSelfTriggered = true;
		this.gateDouData = 0.0;
		
	}
	public Counter() {
	}
	public void Execute()
	{
		if(((Double)Data.getInput(gateInputs[1], gateInputIndexs[1], 0.0))>=1.0)
		{
			gateDouData = 0.0;
		}
		else
		{
			Double tickRate = (Double)Data.getInput(gateInputs[0], gateInputIndexs[0], 1.0);
			gateDouData+= tickRate;
		}
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, Double.toString(gateDouData));
		sig.update();
		if(gateOutputs[0].equals(gateDouData))
		{
			gateOutputs[0] = gateDouData;
			Data.updateInput(gateBlock, 0);
		}
	}
}
