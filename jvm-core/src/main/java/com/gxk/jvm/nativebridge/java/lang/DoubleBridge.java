package com.gxk.jvm.nativebridge.java.lang;

import com.gxk.jvm.rtda.Slot;
import com.gxk.jvm.rtda.MetaSpace;
import com.gxk.jvm.rtda.heap.KClass;
import com.gxk.jvm.rtda.heap.KObject;

public abstract class DoubleBridge {

  public static void registerNatives0() {
    MetaSpace.registerMethod("java/lang/Double_doubleToRawLongBits_(D)J", frame -> {
      java.lang.Double tmp = frame.popDouble();
      long v = java.lang.Double.doubleToRawLongBits(tmp);
      frame.pushLong(v);
    });
    MetaSpace.registerMethod("java/lang/Double_longBitsToDouble_(J)D", frame -> {
      Long tmp = frame.popLong();
      double v = java.lang.Double.longBitsToDouble(tmp);
      frame.pushDouble(v);
    });

    MetaSpace.registerMethod("java/lang/Double_valueOf_(D)Ljava/lang/Double;", frame -> {
      KClass clazz = MetaSpace.findClass("java/lang/Double");
      KObject kObject = clazz.newObject();
      Slot v2 = frame.popSlot();
      Slot v1 = frame.popSlot();
      kObject.setField("value", "D", new Slot[]{v1, v2});
      frame.pushRef(kObject);
    });
  }
}
