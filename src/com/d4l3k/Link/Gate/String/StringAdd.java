package com.d4l3k.Link.Gate.String;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.block.CraftSign;
import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.BaseGate;
import com.d4l3k.Link.Data;


public class StringAdd extends BaseGate{
	public StringAdd(SignChangeEvent event)
	{
		this.gateName = "String Add";
		this.gateID = "[StringAdd]";
		this.gateBlock = event.getBlock();
		this.gateOutputNames = new String[1];
		this.gateOutputNames[0] = "Value";
		this.gateOutputTypes = new String[1];
		this.gateOutputTypes[0] = "string";
		this.gateOutputs = new Object[1];
		
		this.gateInputNames = new String[8];
		this.gateInputNames[0] = "String1";
		this.gateInputNames[1] = "String2";
		this.gateInputNames[2] = "String3";
		this.gateInputNames[3] = "String4";
		this.gateInputNames[4] = "String5";
		this.gateInputNames[5] = "String6";
		this.gateInputNames[6] = "String7";
		this.gateInputNames[7] = "String8";
		this.gateInputTypes = new String[8];
		this.gateInputTypes[0] = "string";
		this.gateInputTypes[1] = "string";
		this.gateInputTypes[2] = "string";
		this.gateInputTypes[3] = "string";
		this.gateInputTypes[4] = "string";
		this.gateInputTypes[5] = "string";
		this.gateInputTypes[6] = "string";
		this.gateInputTypes[7] = "string";

		this.gateInputs = new Block[8];
		this.gateInputIndexs = new int[8];
		Execute();
	}
	public StringAdd() {
		// TODO Auto-generated constructor stub
	}
	public void Execute()
	{
		String data = (String)Data.getInput(gateInputs[0], gateInputIndexs[0],"");
		for(int i=1;i<8;i++)
		{
			data+=(String)Data.getInput(gateInputs[i], gateInputIndexs[i],"");
		}
		
		this.gateOutputs[0]=data;
		Data.updateInput(gateBlock, 0);
		CraftSign sig = new CraftSign(this.gateBlock);
		sig.setLine(1, data);
		sig.update();
	}
}
