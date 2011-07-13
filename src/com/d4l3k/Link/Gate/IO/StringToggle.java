package com.d4l3k.Link.Gate.IO;

import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class StringToggle extends BaseGate{
	public StringToggle(SignChangeEvent event)
	{
		this.gateName = "String Toggle";
		this.gateID = "[StringToggle]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "string";
		this.gateOutputs = new Object[1];
		
		this.gateStrData = event.getLine(1)+event.getLine(2)+event.getLine(3);
		this.gateDouData = 0.0;
		this.gateOutputs[0] = "";
		updateOutput();
		event.setLine(1, Double.toString((Double)this.gateOutputs[0]));
	}
	public StringToggle() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		CraftSign sig = new CraftSign(this.gateBlock);
		updateOutput();
		sig.setLine(1, (String)this.gateOutputs[0]);
		sig.update();
		
	}
	public void updateOutput()
	{
		String[] parse = this.gateStrData.split(",");
		String tog = "";
		try
		{
			int index = (int) Math.round(gateDouData);
			tog = parse[index];
		}
		catch(Exception ex)
		{
			
		}
		this.gateOutputs[0]=tog;
		this.gateDouData+=1;
		if(this.gateDouData>=parse.length)
		{
			this.gateDouData=0.0;
		}
		Data.updateInput(gateBlock, 0);
	}
}
