package com.d4l3k.Link.Gate.Location;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;
import com.d4l3k.Link.GateLocation;


public class LocationSplit extends BaseGate{
	public LocationSplit(SignChangeEvent event)
	{
		this.gateName = "Location Splitter";
		this.gateID = "[LocSplit]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[3];
		this.gateOutputNames[0] = "X";
		this.gateOutputNames[1] = "Y";
		this.gateOutputNames[2] = "Z";
		this.gateOutputTypes = new String[3];
		this.gateOutputTypes[0] = "double";
		this.gateOutputTypes[1] = "double";
		this.gateOutputTypes[2] = "double";
		this.gateOutputs = new Object[3];
		
		this.gateInputNames = new String[1];
		this.gateInputNames[0] = "ToSplit";
		this.gateInputTypes = new String[1];
		this.gateInputTypes[0] = "location";
		this.gateInputs = new Block[1];
		this.gateInputIndexs = new int[1];
		Execute();
	}
	public LocationSplit() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		Location loc = ((GateLocation)Data.getInput(gateInputs[0], gateInputIndexs[0], new Location(gateBlock.getWorld(),0.0,0.0,0.0))).getLocation();
		this.gateOutputs[0]=loc.getX();
		this.gateOutputs[1]=loc.getY();
		this.gateOutputs[2]=loc.getZ();
		Data.updateInput(gateBlock, 0);
		Data.updateInput(gateBlock, 1);
		Data.updateInput(gateBlock, 2);
	}
}
