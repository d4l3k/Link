package com.d4l3k.Link.Gate.Mechanic;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Core;
import com.d4l3k.Link.Data;


public class Teleport extends BaseGate{
	public Teleport(SignChangeEvent event)
	{
		this.gateName = "Player Teleport";
		this.gateID = "[Teleport]";
		this.gateBlock = event.getBlock();
		//this.gateOutputNames = new String[1];
		//this.gateOutputNames[0] = "Player";
		//this.gateOutputTypes = new String[1];
		//this.gateOutputTypes[0] = "string";
		//this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[3];
		this.gateInputNames[0] = "Player";
		this.gateInputNames[1] = "Target";
		this.gateInputNames[2] = "Execute";
		this.gateInputTypes = new String[3];
		this.gateInputTypes[0] = "string";
		this.gateInputTypes[1] = "location";
		this.gateInputTypes[2] = "double";
		this.gateInputs = new Block[3];
		this.gateInputIndexs = new int[3];
		Execute();
	}
	public Teleport() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		if((Double)Data.getInput(gateInputs[2], gateInputIndexs[2], 0.0)>=1.0)
		{
			Player plr = Core.server.getPlayer((String)Data.getInput(gateInputs[0], gateInputIndexs[0], ""));
			Location loc = (Location)Data.getInput(gateInputs[1], gateInputIndexs[1], plr.getLocation());
			plr.teleport(loc);
			Data.updateInput(gateBlock, 0);
			
			CraftSign sig = new CraftSign(this.gateBlock);
			sig.setLine(1, "T: "+plr.getName());
			sig.update();
		}
	}
}
