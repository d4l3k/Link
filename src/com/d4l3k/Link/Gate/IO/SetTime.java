package com.d4l3k.Link.Gate.IO;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class SetTime extends BaseGate{
	public SetTime(SignChangeEvent event)
	{
		this.gateName = "Set Time";
		this.gateID = "[SetTime]";
		this.gatePerm = "danger";
		this.gateBlock = event.getBlock();
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Time";
		this.gateInputNames[1] = "Update";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
	}
	public SetTime() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		if((Double)Data.getInput(this, 1, 0.0)>=1.0)
		{
			CraftSign sig = new CraftSign(this.gateBlock);
			double time = (Double)Data.getInput(this, 0, 0.0);
			gateBlock.getWorld().setTime((long)time);
			sig.setLine(1, Double.toString(time));
			sig.update();
		}
	}
}
