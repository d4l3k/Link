package com.d4l3k.Link.Gate.IO;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class Display extends BaseGate{
	public Display(SignChangeEvent event)
	{
		this.gateName = "Display";
		this.gateID = "[Display]";
		this.gateBlock = event.getBlock();
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Value1";
		this.gateInputNames[1] = "Value2";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "string";
		this.gateInputTypes[1] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
	}
	public Display() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		CraftSign sig = new CraftSign(this.gateBlock);
		String msg = (String)Data.getInput(this.gateInputs[0], this.gateInputIndexs[0]);
		if(!Data.getInput(this.gateInputs[1], this.gateInputIndexs[1]).equals(""))
		{
			msg+=((Double)Data.getInput(this.gateInputs[1], this.gateInputIndexs[1])).toString();
		}
		sig.setLine(1, msg);
		sig.update();
	}
}
