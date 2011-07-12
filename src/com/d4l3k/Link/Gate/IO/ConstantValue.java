package com.d4l3k.Link.Gate.IO;

import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;


public class ConstantValue extends BaseGate{
	public ConstantValue(SignChangeEvent event)
	{
		this.gateName = "Constant Value";
		this.gateID = "[Constant]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "string";
		this.gateOutputs = new Object[1];
		
		this.gateStrData = event.getLine(1);
		
		try
		{
			double parse = Double.parseDouble(this.gateStrData);
			this.gateOutputTypes[0] = "double";
			this.gateOutputs[0] = parse;
		}
		catch(Exception Ex)
		{
			this.gateOutputTypes[0] = "string";
			this.gateOutputs[0] = this.gateStrData;
		}
		
	}
	public ConstantValue() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		
	}
}
