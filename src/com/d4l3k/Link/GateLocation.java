package com.d4l3k.Link;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.World;

public class GateLocation implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private double locX = 0.0;
	private double locY = 0.0;
	private double locZ = 0.0;
	private String world = "";
	
	public GateLocation(Location loc)
	{
		try
		{
			locX = loc.getX();
			locY = loc.getY();
			locZ = loc.getZ();
			world = loc.getWorld().getName();
		}
		catch(Exception ex)
		{
			
		}
	}
	public Location getLocation()
	{
		World wald = Core.server.getWorld(world);
		Location pos = new Location(wald,locX,locY,locZ);
		try
		{
			return pos;
		}
		catch(Exception ex)
		{
			
		}
		return null;
	}
	
}