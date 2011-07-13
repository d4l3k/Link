package com.d4l3k.Link.Gate.Location;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;
import com.d4l3k.Link.GateLocation;


public class LocationAdd extends BaseGate{
	public LocationAdd(SignChangeEvent event)
	{
		this.gateName = "Location Adder";
		this.gateID = "[LocAdd]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Location";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "location";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Loc1";
		this.gateInputNames[1] = "Loc2";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "location";
		this.gateInputTypes[1] = "location";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
		Execute();
	}
	public LocationAdd() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		Location pos = new Location(gateBlock.getWorld(),0.0,0.0,0.0);
		
		Location loc1 = (Location)Data.getInput(gateInputs[0], gateInputIndexs[0], pos);
		Location loc2 = (Location)Data.getInput(gateInputs[0], gateInputIndexs[0], pos);
		
		loc1.setX(loc1.getX()+loc2.getX());
		loc1.setY(loc1.getY()+loc2.getY());
		loc1.setZ(loc1.getZ()+loc2.getZ());
		this.gateOutputs[0]=new GateLocation(loc1);
		Data.updateInput(gateBlock, 0);
	}
}
