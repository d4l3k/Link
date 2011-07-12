package com.d4l3k.Link.Gate.Mechanic;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Core;
import com.d4l3k.Link.Data;


public class PlayerDetect extends BaseGate{
	public PlayerDetect(SignChangeEvent event)
	{
		this.gateName = "Player Detect";
		this.gateID = "[PlayerDetect]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Player";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "string";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[2];
		this.gateInputNames[0] = "Update";
		this.gateInputNames[1] = "Distance";
		this.gateInputTypes = new String[2];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "double";
		this.gateInputs = new Block[2];
		this.gateInputIndexs = new int[2];
		Execute();
	}
	public PlayerDetect() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		double Dist = (Double)Data.getInput(gateInputs[1], gateInputIndexs[1], 5.0);
		String player="";
		Player[] players = Core.server.getOnlinePlayers();
		for(int i = 0; i < players.length; i++)
		{
			if(players[i].getWorld().equals(gateBlock.getWorld()))
			{
				Location loc = players[i].getLocation();
				Location ourLoc = gateBlock.getLocation();
				double xDist = ourLoc.getX()-loc.getX();
				double yDist = ourLoc.getY()-loc.getY();
				double zDist = ourLoc.getZ()-loc.getZ();
				if(xDist<=Dist||-xDist<=Dist||yDist<=Dist||-yDist<=Dist||zDist<=Dist||-zDist<=Dist)
				{
					player = players[i].getName();
					i = players.length;
				}
			}
			
		}
		this.gateOutputs[0]=player;
		Data.updateInput(gateBlock, 0);
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, "T: "+player);
		sig.update();
	}
}
