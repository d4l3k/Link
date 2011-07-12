package com.d4l3k.Link.Gate.IO;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class RedstoneOut extends BaseGate{
	public RedstoneOut(SignChangeEvent event)
	{
		this.gateName = "Redstone Out";
		this.gateID = "[RedstoneOut]";
		this.gateBlock = event.getBlock();
		this.gateInputNames = new String[1];
		this.gateInputNames[0] = "Power";
		this.gateInputTypes = new String[1];
		this.gateInputTypes[0] = "double";
		this.gateInputs = new Block[1];
		this.gateInputIndexs = new int[1];
		
		this.gateStrData = event.getLine(1);
		this.gateDouData = 0.0;
		if(!event.getBlock().getType().equals(Material.WALL_SIGN))
		{
			event.getPlayer().sendMessage("[LINK] "+ChatColor.RED+"Only Wall Signs are supported for this gate.");
			gateName = "";
		}
		event.setLine(1, "Off");
	}
	public RedstoneOut() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		CraftSign sign = new CraftSign(gateBlock);
		Location leverLoc = gateBlock.getLocation();
		byte face = gateBlock.getData();
		if(face==0x4) {//North
			leverLoc.setX(leverLoc.getBlockX()+2);
		}else if(face==0x5) {//South
			leverLoc.setX(leverLoc.getBlockX()-2);
		}else if(face==0x3) {//West
			leverLoc.setZ(leverLoc.getBlockZ()-2);
		}else if(face==0x2) {//East
			leverLoc.setZ(leverLoc.getBlockZ()+2);
		}
		Block block = leverLoc.getBlock();
		if(block.getType().equals(Material.LEVER))
		{
			int levPos = block.getData();
			if(levPos>8)
			{
				levPos-=8;
			}
			double data = (Double)Data.getInput(gateInputs[0], gateInputIndexs[0]);
			if(data<=0)
			{
				block.setData((byte) levPos);
				sign.setLine(1, "Off");
			}
			else
			{
				block.setData((byte)((int)levPos+8));
				sign.setLine(1, "On");
			}
		}
		else
		{
			sign.setLine(1, ChatColor.RED+"NO LEVER");
		}
		sign.update();
	}
}
