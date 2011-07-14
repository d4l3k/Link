package com.d4l3k.Link.Gate.IO;

import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class Button extends BaseGate{
	public Button(SignChangeEvent event)
	{
		this.gateName = "Value Button";
		this.gateID = "[Button]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		
		this.gateStrData = event.getLine(1)+event.getLine(2)+event.getLine(3);
		this.gateDouData = 0.0;
		this.gateOutputs[0] = 0.0;
		double tog = 0.0;
		String[] parse = this.gateStrData.split(",");
		try
		{
			tog = Double.parseDouble(parse[0]);
		}
		catch(Exception ex)
		{
		}
		this.gateOutputs[0]=tog;
		Data.updateInput(gateBlock, 0);
		event.setLine(1, Double.toString(Double.parseDouble(parse[parse.length-1])));
	}
	public Button() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		CraftSign sig = new CraftSign(this.gateBlock);
		String[] parse = this.gateStrData.split(",");
		
		for(int i=1;i<parse.length;i++)
		{
			double tog = 0.0;
			try
			{
				tog = Double.parseDouble(parse[i]);
			}
			catch(Exception ex)
			{
			}
			this.gateOutputs[0]=tog;
			Data.updateInput(gateBlock, 0);
			sig.setLine(1, Double.toString(tog));
		}
		double tog = 0.0;
		try
		{
			tog = Double.parseDouble(parse[0]);
		}
		catch(Exception ex)
		{
		}
		this.gateOutputs[0]=tog;
		Data.updateInput(gateBlock, 0);
		sig.update();
	}
}
