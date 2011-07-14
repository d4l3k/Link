package com.d4l3k.Link.Gate.Time;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class Latch extends BaseGate{
	public Latch(SignChangeEvent event)
	{
		this.gateName = "Double Latch";
		this.gateID = "[Latch]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		this.gateOutputs[0] = 0;
		
		this.gateInputNames = new String[1];
		this.gateInputNames[0] = "Click";
		this.gateInputTypes = new String[1];
		this.gateInputTypes[0] = "double";
		this.gateInputs = new Block[1];
		this.gateInputIndexs = new int[1];
		
		this.gateDouData = 0.0;
		
	}
	public Latch() {
	}
	public void Execute()
	{
		if(((Double)Data.getInput(gateInputs[0], gateInputIndexs[0], 0.0))>=1.0)
		{
			gateDouData *= -1;
			gateDouData += 1;
		}
		
		if(!gateOutputs[0].equals(gateDouData))
		{
			gateOutputs[0] = gateDouData;
			Data.updateInput(gateBlock, 0);
		}
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, Double.toString(gateDouData));
		sig.update();
		
	}
}
