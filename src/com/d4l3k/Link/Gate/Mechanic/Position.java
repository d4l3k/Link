package com.d4l3k.Link.Gate.Mechanic;

import org.bukkit.Location;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.GateLocation;

public class Position extends BaseGate{
	public Position(SignChangeEvent event)
	{
		super(event);
		this.gateName = "Sign Position";
		this.gateID = "[Pos]";
		this.addOutput("Location", "location");
	}
	public Position() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		Location pos = gateBlock.getLocation().add(0.5, 0.5, 0.5);
		
		this.setOutput(0, new GateLocation(pos));
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, "W: "+gateBlock.getWorld().getName());
		sig.update();
	}
}
