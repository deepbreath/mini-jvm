package com.gxk.jvm.classfile.cp;
import com.gxk.jvm.classfile.ConstantInfo;

/**
 * 方法 = 方法所属的类 + 方法名 + 方法参数和返回值描述符
 * 这就是 CONSTANT_Methodref_info 的作用，它表示类中方法的符号引用
 * CONSTANT_Methodref_info    tag=10
 *
 *
 *
 *
 */
public class MethodDef extends ConstantInfo {

  public final int classIndex;
  public final int nameAndTypeIndex;

  public MethodDef(int infoEnum, int classIndex, int nameAndTypeIndex) {
    //tag 10
    super(infoEnum);
    //class_index，是一个指向 CONSTANT_Class_info 的常量池索引值
    this.classIndex = classIndex;
    //name_and_type_index，是一个指向 CONSTANT_NameAndType_info 的常量池索引值，表示方法的参数类型和返回值的签名
    this.nameAndTypeIndex = nameAndTypeIndex;
  }
}
