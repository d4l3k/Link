package com.d4l3k.Link.Gate.Double;

import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class DoubleAny extends BaseGate{
	public DoubleAny(SignChangeEvent event)
	{
		super(event);
		this.gateName = "Double Any";
		this.gateID = "[Any]";
		this.addOutput("Value", "double");
		this.addInput("Double1", "double");
		this.addInput("Double2", "double");
		this.addInput("Double3", "double");
		this.addInput("Double4", "double");
		this.addInput("Double5", "double");
		this.addInput("Double6", "double");
		this.addInput("Double7", "double");
		this.addInput("Double8", "double");
	}
	public DoubleAny() {
		// TODO Auto-generated constructor stub
	}
	public void Execute(int input, Object oldval, Object newval)
	{
		double data = 0.0;
		for(int i=0;i<8;i++)
		{
			double val = (Double)Data.getInput(this, i, 0.0);
			if(val>=1.0)
			{
				data = 1.0;
				i=8;
			}
		}
		
		this.setOutput(0, data);
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, Double.toString(data));
		sig.update();
	}
}
