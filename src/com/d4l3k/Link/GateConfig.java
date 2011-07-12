package com.d4l3k.Link;

import org.bukkit.event.block.SignChangeEvent;

import com.d4l3k.Link.Gate.IO.*;
import com.d4l3k.Link.Gate.Mechanic.*;
import com.d4l3k.Link.Gate.Double.*;
import com.d4l3k.Link.Gate.String.*;
import com.d4l3k.Link.Gate.Location.*;

public class GateConfig {
	//Handles executing gates.
	public static void executeBaseGate(BaseGate gate) 
	{
		String ID = gate.gateID;
		if(ID.equalsIgnoreCase("[Constant]"))
			((ConstantValue)gate).Execute();
		else if(ID.equalsIgnoreCase("[Display]"))
			((Display)gate).Execute();
		else if(ID.equalsIgnoreCase("[Toggle]"))
			((Toggle)gate).Execute();
		else if(ID.equalsIgnoreCase("[RedstoneIn]"))
			((RedstoneIn)gate).Execute();
		else if(ID.equalsIgnoreCase("[RedstoneOut]"))
			((RedstoneOut)gate).Execute();
		else if(ID.equalsIgnoreCase("[StringEqual]"))
			((StringEqual)gate).Execute();
		else if(ID.equalsIgnoreCase("[StringAdd]"))
			((StringAdd)gate).Execute();
		else if(ID.equalsIgnoreCase("[Equal]"))
			((DoubleEqual)gate).Execute();
		else if(ID.equalsIgnoreCase("[Add]"))
			((DoubleAdd)gate).Execute();
		else if(ID.equalsIgnoreCase("[Divide]"))
			((DoubleDivide)gate).Execute();
		else if(ID.equalsIgnoreCase("[Greater]"))
			((DoubleGreater)gate).Execute();
		else if(ID.equalsIgnoreCase("[GreaterEqual]"))
			((DoubleGreaterEqual)gate).Execute();
		else if(ID.equalsIgnoreCase("[Less]"))
			((DoubleLess)gate).Execute();
		else if(ID.equalsIgnoreCase("[LessEqual]"))
			((DoubleLessEqual)gate).Execute();
		else if(ID.equalsIgnoreCase("[Multiply]"))
			((DoubleMultiply)gate).Execute();
		else if(ID.equalsIgnoreCase("[Subtract]"))
			((DoubleSubtract)gate).Execute();
		else if(ID.equalsIgnoreCase("[ToString]"))
			((DoubleToString)gate).Execute();
		else if(ID.equalsIgnoreCase("[Pos]"))
			((Position)gate).Execute();
		else if(ID.equalsIgnoreCase("[PlayerPos]"))
			((PlayerPosition)gate).Execute();
		else if(ID.equalsIgnoreCase("[PlayerDetect]"))
			((PlayerDetect)gate).Execute();
		else if(ID.equalsIgnoreCase("[Teleport]"))
			((Teleport)gate).Execute();
		else if(ID.equalsIgnoreCase("[LocMake]"))
			((LocationMake)gate).Execute();
		else if(ID.equalsIgnoreCase("[LocSplit]"))
			((LocationSplit)gate).Execute();
		else if(ID.equalsIgnoreCase("[Command]"))
			((Command)gate).Execute();
		else if(ID.equalsIgnoreCase("[IfString]"))
			((IfString)gate).Execute();
		else if(ID.equalsIgnoreCase("[Inverse]"))
			((DoubleInverse)gate).Execute();
	}
	// Handles creating new gates
	public static BaseGate newBaseGate(String type, SignChangeEvent event)
	{
		BaseGate obj = null;
		if(type.equalsIgnoreCase("[Constant]"))
			obj = (BaseGate) new ConstantValue(event);
		else if(type.equalsIgnoreCase("[Display]"))
			obj = (BaseGate) new Display(event);
		else if(type.equalsIgnoreCase("[Toggle]"))
			obj = (BaseGate) new Toggle(event);
		else if(type.equalsIgnoreCase("[RedstoneIn]"))
			obj = (BaseGate) new RedstoneIn(event);
		else if(type.equalsIgnoreCase("[RedstoneOut]"))
			obj = (BaseGate) new RedstoneOut(event);
		else if(type.equalsIgnoreCase("[StringEqual]"))
			obj = (BaseGate) new StringEqual(event);
		else if(type.equalsIgnoreCase("[StringAdd]"))
			obj = (BaseGate) new StringAdd(event);
		else if(type.equalsIgnoreCase("[Equal]"))
			obj = (BaseGate) new DoubleEqual(event);
		else if(type.equalsIgnoreCase("[Add]"))
			obj = (BaseGate) new DoubleAdd(event);
		else if(type.equalsIgnoreCase("[Divide]"))
			obj = (BaseGate) new DoubleDivide(event);
		else if(type.equalsIgnoreCase("[Greater]"))
			obj = (BaseGate) new DoubleGreater(event);
		else if(type.equalsIgnoreCase("[GreaterEqual]"))
			obj = (BaseGate) new DoubleGreaterEqual(event);
		else if(type.equalsIgnoreCase("[Less]"))
			obj = (BaseGate) new DoubleLess(event);
		else if(type.equalsIgnoreCase("[LessEqual]"))
			obj = (BaseGate) new DoubleLessEqual(event);
		else if(type.equalsIgnoreCase("[Multiply]"))
			obj = (BaseGate) new DoubleMultiply(event);
		else if(type.equalsIgnoreCase("[Subtract]"))
			obj = (BaseGate) new DoubleSubtract(event);
		else if(type.equalsIgnoreCase("[ToString]"))
			obj = (BaseGate) new DoubleToString(event);
		else if(type.equalsIgnoreCase("[Pos]"))
			obj = (BaseGate) new Position(event);
		else if(type.equalsIgnoreCase("[PlayerPos]"))
			obj = (BaseGate) new PlayerPosition(event);
		else if(type.equalsIgnoreCase("[PlayerDetect]"))
			obj = (BaseGate) new PlayerDetect(event);
		else if(type.equalsIgnoreCase("[Teleport]"))
			obj = (BaseGate) new Teleport(event);
		else if(type.equalsIgnoreCase("[LocMake]"))
			obj = (BaseGate) new LocationMake(event);
		else if(type.equalsIgnoreCase("[LocSplit]"))
			obj = (BaseGate) new LocationSplit(event);
		else if(type.equalsIgnoreCase("[Command]"))
			obj = (BaseGate) new Command(event);
		else if(type.equalsIgnoreCase("[IfString]"))
			obj = (BaseGate) new IfString(event);
		else if(type.equalsIgnoreCase("[Inverse]"))
			obj = (BaseGate) new DoubleInverse(event);
		
		return obj;
	}
	// Handles creating new gates without initializing them
	public static BaseGate newBaseGate(String type)
	{
		BaseGate obj = null;
		if(type.equalsIgnoreCase("[Constant]"))
			obj = (BaseGate) new ConstantValue();
		else if(type.equalsIgnoreCase("[Display]"))
			obj = (BaseGate) new Display();
		else if(type.equalsIgnoreCase("[Toggle]"))
			obj = (BaseGate) new Toggle();
		else if(type.equalsIgnoreCase("[RedstoneIn]"))
			obj = (BaseGate) new RedstoneIn();
		else if(type.equalsIgnoreCase("[RedstoneOut]"))
			obj = (BaseGate) new RedstoneOut();
		else if(type.equalsIgnoreCase("[StringEqual]"))
			obj = (BaseGate) new StringEqual();
		else if(type.equalsIgnoreCase("[StringAdd]"))
			obj = (BaseGate) new StringAdd();
		else if(type.equalsIgnoreCase("[Equal]"))
			obj = (BaseGate) new DoubleEqual();
		else if(type.equalsIgnoreCase("[Add]"))
			obj = (BaseGate) new DoubleAdd();
		else if(type.equalsIgnoreCase("[Divide]"))
			obj = (BaseGate) new DoubleDivide();
		else if(type.equalsIgnoreCase("[Greater]"))
			obj = (BaseGate) new DoubleGreater();
		else if(type.equalsIgnoreCase("[GreaterEqual]"))
			obj = (BaseGate) new DoubleGreaterEqual();
		else if(type.equalsIgnoreCase("[Less]"))
			obj = (BaseGate) new DoubleLess();
		else if(type.equalsIgnoreCase("[LessEqual]"))
			obj = (BaseGate) new DoubleLessEqual();
		else if(type.equalsIgnoreCase("[Multiply]"))
			obj = (BaseGate) new DoubleMultiply();
		else if(type.equalsIgnoreCase("[Subtract]"))
			obj = (BaseGate) new DoubleSubtract();
		else if(type.equalsIgnoreCase("[ToString]"))
			obj = (BaseGate) new DoubleToString();
		else if(type.equalsIgnoreCase("[Pos]"))
			obj = (BaseGate) new Position();
		else if(type.equalsIgnoreCase("[PlayerPos]"))
			obj = (BaseGate) new PlayerPosition();
		else if(type.equalsIgnoreCase("[PlayerDetect]"))
			obj = (BaseGate) new PlayerDetect();
		else if(type.equalsIgnoreCase("[Teleport]"))
			obj = (BaseGate) new Teleport();
		else if(type.equalsIgnoreCase("[LocMake]"))
			obj = (BaseGate) new LocationMake();
		else if(type.equalsIgnoreCase("[LocSplit]"))
			obj = (BaseGate) new LocationSplit();
		else if(type.equalsIgnoreCase("[Command]"))
			obj = (BaseGate) new Command();
		else if(type.equalsIgnoreCase("[IfString]"))
			obj = (BaseGate) new IfString();
		else if(type.equalsIgnoreCase("[Inverse]"))
			obj = (BaseGate) new DoubleInverse();
		
		return obj;
	}
}
