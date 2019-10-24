package com.gxk.jvm.instruction;

import com.gxk.jvm.rtda.Frame;
import com.gxk.jvm.rtda.heap.KArray;

public class CAStoreInst implements Instruction {

  @Override
  public void execute(Frame frame) {
    Character val = ((char) (frame.operandStack.popInt().intValue()));
    Integer index = frame.operandStack.popInt();
    KArray array = (KArray) frame.operandStack.popRef();
    array.items[index] = val;
  }
}