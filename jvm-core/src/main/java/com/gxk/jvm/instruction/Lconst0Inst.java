package com.gxk.jvm.instruction;

import com.gxk.jvm.rtda.Frame;
/**
 *
 */
public class Lconst0Inst implements Instruction {

  @Override
  public void execute(Frame frame) {
    frame.pushLong(0L);
  }
}
