package com.d4l3k.Link.Gate.Location;

import org.bukkit.Location;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.GateLocation;


public class LocationAdd extends BaseGate{
	public LocationAdd(SignChangeEvent event)
	{
		super(event);
		this.gateName = "Location Adder";
		this.gateID = "[LocAdd]";
		this.addOutput("Location", "location");
		
		this.addInput("Loc1", "location");
		this.addInput("Loc2", "location");

	}
	public LocationAdd() {
		// TODO Auto-generated constructor stub
	}
	public void Execute(int input, Object oldval, Object newval)
	{
		GateLocation pos = new GateLocation(gateBlock.getWorld());
		
		Location loc1 = (Location)this.getInput(0, pos);
		Location loc2 = (Location)this.getInput(1, pos);
		loc1.add(loc2);
		
		this.setOutput(0, loc1);
	}
}
