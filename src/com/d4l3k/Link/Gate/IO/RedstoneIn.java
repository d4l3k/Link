package com.d4l3k.Link.Gate.IO;

import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class RedstoneIn extends BaseGate{
	public RedstoneIn(SignChangeEvent event)
	{
		this.gateName = "Redstone In";
		this.gateID = "[RedstoneIn]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Current";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		
		this.gateStrData = event.getLine(1);
		this.gateDouData = 0.0;
		this.gateOutputs[0] = 0.0;
		updateOutput();
		event.setLine(1, Double.toString((Double)this.gateOutputs[0]));
	}
	public RedstoneIn() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		CraftSign sig = new CraftSign(this.gateBlock);
		updateOutput();
		sig.setLine(1, Double.toString((Double)this.gateOutputs[0]));
		sig.update();
		
	}
	public void updateOutput()
	{
		this.gateOutputs[0]=gateBlock.getBlockPower()+0.0;
		Data.updateInput(gateBlock, 0);
	}
}
