package com.gxk.jvm.instruction;

import com.gxk.jvm.rtda.Frame;


/**
 *
 */
public class DStore0Inst implements Instruction {

  @Override
  public void execute(Frame frame) {
    double tmp = frame.popDouble();
    frame.setDouble(0, tmp);
  }
}
