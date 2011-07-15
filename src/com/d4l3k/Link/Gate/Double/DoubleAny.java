package com.d4l3k.Link.Gate.Double;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class DoubleAny extends BaseGate{
	public DoubleAny(SignChangeEvent event)
	{
		this.gateName = "Double Any";
		this.gateID = "[Any]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "double";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[8];
		this.gateInputNames[0] = "Double1";
		this.gateInputNames[1] = "Double2";
		this.gateInputNames[2] = "Double3";
		this.gateInputNames[3] = "Double4";
		this.gateInputNames[4] = "Double5";
		this.gateInputNames[5] = "Double6";
		this.gateInputNames[6] = "Double7";
		this.gateInputNames[7] = "Double8";
		this.gateInputTypes = new String[8];
		this.gateInputTypes[0] = "double";
		this.gateInputTypes[1] = "double";
		this.gateInputTypes[2] = "double";
		this.gateInputTypes[3] = "double";
		this.gateInputTypes[4] = "double";
		this.gateInputTypes[5] = "double";
		this.gateInputTypes[6] = "double";
		this.gateInputTypes[7] = "double";

		this.gateInputs = new Block[8];
		this.gateInputIndexs = new int[8];
		Execute();
	}
	public DoubleAny() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
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
		
		if(!gateOutputs[0].equals(data))
		{
			this.gateOutputs[0]=data;
			Data.updateInput(gateBlock, 0);
		}
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, Double.toString(data));
		sig.update();
	}
}
