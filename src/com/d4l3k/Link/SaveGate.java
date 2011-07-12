package com.d4l3k.Link;

import java.io.Serializable;

import org.bukkit.block.Block;

public class SaveGate implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;

	public String gateName = "";
	public String gateID = "";
	public GateBlock gateBlock;
	public String[] gateInputNames = new String[0];
	public String[] gateInputTypes = new String[0];
	public GateBlock[] gateInputs = new GateBlock[0];
	public int[] gateInputIndexs = new int[0];
	public String[] gateOutputNames = new String[0];
	public String[] gateOutputTypes = new String[0];
	public Object[] gateOutputs = new Object[0];
	public String gateStrData = "";
	public Double gateDouData = 0.0;
	public SaveGate(BaseGate gate)
	{
		gateName = gate.gateName;
		gateID = gate.gateID;
		gateBlock = new GateBlock(gate.gateBlock);
		gateInputNames = gate.gateInputNames;
		gateInputTypes = gate.gateInputTypes;
		gateInputs = new GateBlock[gate.gateInputs.length];
		for(int i=0;i<gate.gateInputs.length;i++)
		{
			gateInputs[i]=new GateBlock(gate.gateInputs[i]);
		}
		gateInputIndexs = gate.gateInputIndexs;
		gateOutputNames = gate.gateOutputNames;
		gateOutputTypes = gate.gateOutputTypes;
		gateOutputs = gate.gateOutputs;
		gateStrData = gate.gateStrData;
		gateDouData = gate.gateDouData;
	}
	public BaseGate getBaseGate()
	{
		BaseGate gate = GateConfig.newBaseGate(gateID);
		gate.gateName = gateName;
		gate.gateID = gateID;
		gate.gateBlock = gateBlock.getBlock();
		gate.gateInputNames = gateInputNames;
		gate.gateInputTypes = gateInputTypes;
		gate.gateInputs = new Block[gateInputs.length];
		for(int i=0;i<gateInputs.length;i++)
		{
			gate.gateInputs[i]=gateInputs[i].getBlock();
		}
		gate.gateInputIndexs = gateInputIndexs;
		gate.gateOutputNames = gateOutputNames;
		gate.gateOutputTypes = gateOutputTypes;
		gate.gateOutputs = gateOutputs;
		gate.gateStrData = gateStrData;
		gate.gateDouData = gateDouData;
		return gate;
	}
}
