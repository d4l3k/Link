package com.d4l3k.Link.Gate.Location;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;
import com.d4l3k.Link.GateLocation;


public class LocationMake extends BaseGate{
	public LocationMake(SignChangeEvent event)
	{
		this.gateName = "Location Maker";
		this.gateID = "[LocMake]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Location";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "location";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[3];
		this.gateInputNames[0] = "X";
		this.gateInputNames[1] = "Y";
		this.gateInputNames[2] = "Z";
		this.gateInputTypes = new String[3];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "double";
		this.gateInputTypes[2] = "double";
		this.gateInputs = new Block[3];
		this.gateInputIndexs = new int[3];
		Execute();
	}
	public LocationMake() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		
		double x = (Double)Data.getInput(gateInputs[0], gateInputIndexs[0], 0.0);
		double y = (Double)Data.getInput(gateInputs[1], gateInputIndexs[1], 0.0);
		double z = (Double)Data.getInput(gateInputs[2], gateInputIndexs[2], 0.0);
		Location loc = new Location(gateBlock.getWorld(),x,y,z);
		this.gateOutputs[0]=new GateLocation(loc);
		Data.updateInput(gateBlock, 0);
	}
}
