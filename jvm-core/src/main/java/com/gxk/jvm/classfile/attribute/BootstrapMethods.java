package com.gxk.jvm.classfile.attribute;

import com.gxk.jvm.classfile.Attribute;

/**
 *记录通过调用动态指令，调用 invokedynamic 规范引用的引导方法
 */
public class BootstrapMethods extends Attribute {

  public final BootstrapMethod[] methods;

  public BootstrapMethods(BootstrapMethod[] methods) {
    this.methods = methods;
  }

  public static class BootstrapMethod {
    public final Integer bootstrapMethodRefInx;
    public final Integer[] argsRefs;

    public BootstrapMethod(Integer bootstrapMethodRefInx, Integer[] argsRefs) {
      this.bootstrapMethodRefInx = bootstrapMethodRefInx;
      this.argsRefs = argsRefs;
    }
  }
}
