package com.d4l3k.Link;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.inventory.ItemStack;

public class WorldListener extends BlockListener{
	public static Core plugin; 
	public WorldListener(Core instance) { 
        plugin = instance;
	}
	public void onSignChange(SignChangeEvent event)
	{
		String type = event.getLine(0);
		BaseGate obj = GateConfig.newBaseGate(type, event);
		
		if(obj==null)
			return;
		
		if (!Core.permissionHandler.has(event.getPlayer(), "link.build")&&!Core.permissionHandler.has(event.getPlayer(), "link."+obj.gatePerm)) {
			event.getPlayer().sendMessage("[LINK] "+ChatColor.RED+"Invalid Permissions");
			event.getBlock().setType(Material.AIR);
			ItemStack iT = new ItemStack(Material.SIGN, 1);
	        event.getPlayer().getInventory().addItem(new ItemStack[] { iT });
	        return;
		}
		event.setLine(0, ChatColor.AQUA+obj.gateID);
		event.getPlayer().sendMessage("[LINK] "+ChatColor.GREEN+"Creation Sucessful! "+obj.gateName);
		Data.addGate(obj);
		Data.saveGates();
	}
	public void onBlockRedstoneChange(BlockRedstoneEvent event)
	{
		if(event.getBlock().getType().equals(Material.WALL_SIGN)||event.getBlock().getType().equals(Material.SIGN_POST))
		{
			BaseGate gate = Data.getBaseGate(event.getBlock());
			if(gate.gateID.equalsIgnoreCase("[RedstoneIn]"))
			{
				GateConfig.executeBaseGate(gate);
			}
		}
	}
	public void onBlockBreak(BlockBreakEvent event)
	{
		Material type = event.getBlock().getType();
		if(type.equals(Material.SIGN_POST)||type.equals(Material.WALL_SIGN))
		{
			BaseGate gate = Data.getBaseGate(event.getBlock());
			if(gate.gateID.equals(""))
				return;
			Data.removeGate(gate);
			Data.saveGates();
			event.getPlayer().sendMessage("[LINK] "+ChatColor.RED+"Gate Destroyed! "+gate.gateName);
		}
	}
}
