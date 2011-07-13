package com.d4l3k.Link.Gate.Mechanic;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Core;
import com.d4l3k.Link.Data;
import com.d4l3k.Link.GateLocation;


public class MobSpawn extends BaseGate{
	public MobSpawn(SignChangeEvent event)
	{
		this.gateName = "Mob Spawner";
		this.gateID = "[MobSpawn]";
		this.gatePerm = "danger";
		this.gateBlock = event.getBlock();
		//this.gateOutputNames = new String[1];
		//this.gateOutputNames[0] = "Player";
		//this.gateOutputTypes = new String[1];
		//this.gateOutputTypes[0] = "string";
		//this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[3];
		this.gateInputNames[0] = "Mob";
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
	public MobSpawn() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		CreatureType[] creatures = CreatureType.values();
		String mob = (String)Data.getInput(gateInputs[0], gateInputIndexs[0]);
		if((Double)Data.getInput(gateInputs[2], gateInputIndexs[2], 0.0)>=1.0)
		{
			
			Player plr = Core.server.getPlayer((String)Data.getInput(gateInputs[0], gateInputIndexs[0], ""));
			Location loc = ((GateLocation)Data.getInput(gateInputs[1], gateInputIndexs[1], new GateLocation(plr.getLocation()))).getLocation();
			for(int i=0;i<creatures.length;i++)
			{
				if(creatures[i].name().equalsIgnoreCase(mob))
				{
					gateBlock.getWorld().spawnCreature(loc, creatures[i]);
				}
			}
			if(mob.equalsIgnoreCase("pigzombie"))
			{
				gateBlock.getWorld().spawnCreature(loc, CreatureType.PIG_ZOMBIE);
			}
			else if(mob.equalsIgnoreCase("dog"))
			{
				LivingEntity mobA = gateBlock.getWorld().spawnCreature(loc, CreatureType.WOLF);
				((Wolf) mobA).setSitting(true);
			}
			else if(mob.equalsIgnoreCase("angrywolf"))
			{
				LivingEntity mobA = gateBlock.getWorld().spawnCreature(loc, CreatureType.WOLF);
				((Wolf) mobA).setAngry(true);
			}
		}
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, mob);
		sig.update();
	}
}
