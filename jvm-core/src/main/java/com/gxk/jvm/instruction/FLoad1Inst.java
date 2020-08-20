package com.gxk.jvm.instruction;

import com.gxk.jvm.rtda.Frame;

/**
 *
 */
public class FLoad1Inst implements Instruction {

  @Override
  public void execute(Frame frame) {
    float tmp = frame.getFloat(1);
    frame.pushFloat(tmp);
  }
}