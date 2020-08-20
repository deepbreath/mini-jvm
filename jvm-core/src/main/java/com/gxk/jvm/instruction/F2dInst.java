package com.gxk.jvm.instruction;

import com.gxk.jvm.rtda.Frame;

/**
 *
 */
public class F2dInst implements Instruction {

  @Override
  public int offset() {
    return 1;
  }

  @Override
  public void execute(Frame frame) {
    float tmp = frame.popFloat();
    frame.pushDouble(((double) tmp));
  }
}