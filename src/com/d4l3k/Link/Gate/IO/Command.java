package com.d4l3k.Link.Gate.IO;

import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Core;
import com.d4l3k.Link.Data;


public class Command extends BaseGate{
	public Command(SignChangeEvent event)
	{
		this.gateName = "Command Executer";
		this.gateID = "[Command]";
		this.gatePerm = "restricted";
		this.gateBlock = event.getBlock();
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Command";
		this.gateInputNames[1] = "Execute";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "string";
		this.gateInputTypes[1] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
	}
	public Command() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		
		CraftSign sig = new CraftSign(this.gateBlock);
		String msg = (String)Data.getInput(this.gateInputs[0], this.gateInputIndexs[0]);
		if((Double)Data.getInput(this.gateInputs[1], this.gateInputIndexs[1], 0.0)>=1.0)
		{
			Core.server.dispatchCommand(new ConsoleCommandSender(Core.server), msg);
		}
		sig.setLine(1, msg);
		sig.update();
	}
}
