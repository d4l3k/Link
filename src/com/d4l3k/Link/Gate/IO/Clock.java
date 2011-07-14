package com.d4l3k.Link.Gate.IO;

import org.bukkit.block.Block;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class Clock extends BaseGate{
	public Clock(SignChangeEvent event)
	{
		this.gateName = "Constant Value";
		this.gateID = "[Constant]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Tick";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		this.gateOutputs[0] = 0;
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "TickRate";
		this.gateInputNames[1] = "Value";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
		
		this.gateSelfTriggered = true;
		this.gateDouData = 0.0;
		
	}
	public Clock() {

	}
	public void Execute()
	{
		Double tickRate = (Double)Data.getInput(gateInputs[0], gateInputIndexs[0], 100.0);
		gateDouData+=Data.serverTickRate;
		if(gateDouData<=tickRate)
		{
			gateOutputs[0] = (Double)Data.getInput(gateInputs[1], gateInputIndexs[1], 1.0);
			
			gateDouData = 0.0;
		}
	}
}
