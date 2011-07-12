package com.d4l3k.Link;

import org.bukkit.block.Block;

public class BaseGate {
	
	public String gateName = "";
	public String gateID = "";
	public String gatePerm = "basic";
	public Block gateBlock;
	public String[] gateInputNames = new String[0];
	public String[] gateInputTypes = new String[0];
	public Block[] gateInputs = new Block[0];
	public int[] gateInputIndexs = new int[0];
	public String[] gateOutputNames = new String[0];
	public String[] gateOutputTypes = new String[0];
	public Object[] gateOutputs = new Object[0];
	public String gateStrData = "";
	public Double gateDouData = 0.0;
	public BaseGate()
	{
		
	}
	public void Execute()
	{
		
	}
}
