package com.d4l3k.Link.Gate.Mechanic;

import org.bukkit.Location;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;
import com.d4l3k.Link.GateLocation;


public class Position extends BaseGate{
	public Position(SignChangeEvent event)
	{
		this.gateName = "Sign Position";
		this.gateID = "[Pos]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Location";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "location";
		this.gateOutputs = new Object[1];
		
		/*this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Double1";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];*/
		Execute();
	}
	public Position() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		Location pos = gateBlock.getLocation();
		
		this.gateOutputs[0]=new GateLocation(pos);
		Data.updateInput(gateBlock, 0);
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, "T: "+gateBlock.getWorld().getName());
		sig.update();
	}
}
