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
		else if(ID.equalsIgnoreCase("[StringToggle]"))
			((DoubleInverse)gate).Execute();
		else if(ID.equalsIgnoreCase("[LocAdd]"))
			((LocationAdd)gate).Execute();
		else if(ID.equalsIgnoreCase("[MobSpawn]"))
			((MobSpawn)gate).Execute();
		else if(ID.equalsIgnoreCase("[Button]"))
			((Button)gate).Execute();
		else if(ID.equalsIgnoreCase("[Clock]"))
			((Clock)gate).Execute();
	}
	// Gates that execute on click.
	public static void interactBaseGate(BaseGate gate)
	{
		String ID = gate.gateID;
		if(ID.equalsIgnoreCase("[Toggle]"))
			((Toggle)gate).Execute();
		else if(ID.equalsIgnoreCase("[StringToggle]"))
			((StringToggle)gate).Execute();
		else if(ID.equalsIgnoreCase("[Button]"))
			((Button)gate).Execute();
	}
	// Handles creating new gates
	public static BaseGate newBaseGate(String type, SignChangeEvent event)
	{
		BaseGate obj = null;
		if(type.equalsIgnoreCase("[Constant]"))
			obj =  new ConstantValue(event);
		else if(type.equalsIgnoreCase("[Display]"))
			obj =  new Display(event);
		else if(type.equalsIgnoreCase("[Toggle]"))
			obj =  new Toggle(event);
		else if(type.equalsIgnoreCase("[RedstoneIn]"))
			obj =  new RedstoneIn(event);
		else if(type.equalsIgnoreCase("[RedstoneOut]"))
			obj =  new RedstoneOut(event);
		else if(type.equalsIgnoreCase("[StringEqual]"))
			obj =  new StringEqual(event);
		else if(type.equalsIgnoreCase("[StringAdd]"))
			obj =  new StringAdd(event);
		else if(type.equalsIgnoreCase("[Equal]"))
			obj =  new DoubleEqual(event);
		else if(type.equalsIgnoreCase("[Add]"))
			obj =  new DoubleAdd(event);
		else if(type.equalsIgnoreCase("[Divide]"))
			obj =  new DoubleDivide(event);
		else if(type.equalsIgnoreCase("[Greater]"))
			obj =  new DoubleGreater(event);
		else if(type.equalsIgnoreCase("[GreaterEqual]"))
			obj =  new DoubleGreaterEqual(event);
		else if(type.equalsIgnoreCase("[Less]"))
			obj =  new DoubleLess(event);
		else if(type.equalsIgnoreCase("[LessEqual]"))
			obj =  new DoubleLessEqual(event);
		else if(type.equalsIgnoreCase("[Multiply]"))
			obj =  new DoubleMultiply(event);
		else if(type.equalsIgnoreCase("[Subtract]"))
			obj =  new DoubleSubtract(event);
		else if(type.equalsIgnoreCase("[ToString]"))
			obj =  new DoubleToString(event);
		else if(type.equalsIgnoreCase("[Pos]"))
			obj =  new Position(event);
		else if(type.equalsIgnoreCase("[PlayerPos]"))
			obj =  new PlayerPosition(event);
		else if(type.equalsIgnoreCase("[PlayerDetect]"))
			obj =  new PlayerDetect(event);
		else if(type.equalsIgnoreCase("[Teleport]"))
			obj =  new Teleport(event);
		else if(type.equalsIgnoreCase("[LocMake]"))
			obj =  new LocationMake(event);
		else if(type.equalsIgnoreCase("[LocSplit]"))
			obj =  new LocationSplit(event);
		else if(type.equalsIgnoreCase("[Command]"))
			obj =  new Command(event);
		else if(type.equalsIgnoreCase("[IfString]"))
			obj =  new IfString(event);
		else if(type.equalsIgnoreCase("[Inverse]"))
			obj =  new DoubleInverse(event);
		else if(type.equalsIgnoreCase("[StringToggle]"))
			obj =  new StringToggle(event);
		else if(type.equalsIgnoreCase("[LocAdd]"))
			obj =  new LocationAdd(event);
		else if(type.equalsIgnoreCase("[MobSpawn]"))
			obj =  new MobSpawn(event);
		else if(type.equalsIgnoreCase("[Button]"))
			obj =  new Button(event);
		else if(type.equalsIgnoreCase("[Clock]"))
			obj = new Clock(event);
		
		return obj;
	}
	// Handles creating new gates without initializing them
	public static BaseGate newBaseGate(String type)
	{
		BaseGate obj = null;
		if(type.equalsIgnoreCase("[Constant]"))
			obj =  new ConstantValue();
		else if(type.equalsIgnoreCase("[Display]"))
			obj =  new Display();
		else if(type.equalsIgnoreCase("[Toggle]"))
			obj =  new Toggle();
		else if(type.equalsIgnoreCase("[RedstoneIn]"))
			obj =  new RedstoneIn();
		else if(type.equalsIgnoreCase("[RedstoneOut]"))
			obj =  new RedstoneOut();
		else if(type.equalsIgnoreCase("[StringEqual]"))
			obj =  new StringEqual();
		else if(type.equalsIgnoreCase("[StringAdd]"))
			obj =  new StringAdd();
		else if(type.equalsIgnoreCase("[Equal]"))
			obj =  new DoubleEqual();
		else if(type.equalsIgnoreCase("[Add]"))
			obj =  new DoubleAdd();
		else if(type.equalsIgnoreCase("[Divide]"))
			obj =  new DoubleDivide();
		else if(type.equalsIgnoreCase("[Greater]"))
			obj =  new DoubleGreater();
		else if(type.equalsIgnoreCase("[GreaterEqual]"))
			obj =  new DoubleGreaterEqual();
		else if(type.equalsIgnoreCase("[Less]"))
			obj =  new DoubleLess();
		else if(type.equalsIgnoreCase("[LessEqual]"))
			obj =  new DoubleLessEqual();
		else if(type.equalsIgnoreCase("[Multiply]"))
			obj =  new DoubleMultiply();
		else if(type.equalsIgnoreCase("[Subtract]"))
			obj =  new DoubleSubtract();
		else if(type.equalsIgnoreCase("[ToString]"))
			obj =  new DoubleToString();
		else if(type.equalsIgnoreCase("[Pos]"))
			obj =  new Position();
		else if(type.equalsIgnoreCase("[PlayerPos]"))
			obj =  new PlayerPosition();
		else if(type.equalsIgnoreCase("[PlayerDetect]"))
			obj =  new PlayerDetect();
		else if(type.equalsIgnoreCase("[Teleport]"))
			obj =  new Teleport();
		else if(type.equalsIgnoreCase("[LocMake]"))
			obj =  new LocationMake();
		else if(type.equalsIgnoreCase("[LocSplit]"))
			obj =  new LocationSplit();
		else if(type.equalsIgnoreCase("[Command]"))
			obj =  new Command();
		else if(type.equalsIgnoreCase("[IfString]"))
			obj =  new IfString();
		else if(type.equalsIgnoreCase("[Inverse]"))
			obj =  new DoubleInverse();
		else if(type.equalsIgnoreCase("[StringToggle]"))
			obj =  new StringToggle();
		else if(type.equalsIgnoreCase("[LocAdd]"))
			obj =  new LocationAdd();
		else if(type.equalsIgnoreCase("[MobSpawn]"))
			obj =  new MobSpawn();
		else if(type.equalsIgnoreCase("[Button]"))
			obj =  new Button();
		else if(type.equalsIgnoreCase("[Clock]"))
			obj =  new Clock();
		
		return obj;
	}
}
