package com.d4l3k.Link.Gate.IO;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class GetTime extends BaseGate{
	public GetTime(SignChangeEvent event)
	{
		this.gateName = "Get Time";
		this.gateID = "[GetTime]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Time";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[1];
		this.gateInputNames[0] = "Update";
		this.gateInputTypes = new String[1];
		this.gateInputTypes[0] = "double";
		this.gateInputs = new Block[1];
		this.gateInputIndexs = new int[1];

		this.gateOutputs[0] = 0.0;
		
		event.setLine(1, Double.toString((Double)this.gateOutputs[0]));
	}
	public GetTime() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		if((Double)Data.getInput(this, 0)<1.0)
			return;
		
		CraftSign sig = new CraftSign(this.gateBlock);
		double time = (double)gateBlock.getWorld().getTime();
		if(!this.gateOutputNames[0].equals(time))
		{
			this.gateOutputs[0] = time;
			Data.updateInput(gateBlock, 0);
		}
		sig.setLine(1, Double.toString((Double)this.gateOutputs[0]));
		sig.update();
		
	}
}
