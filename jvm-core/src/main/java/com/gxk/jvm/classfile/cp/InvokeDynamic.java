package com.gxk.jvm.classfile.cp;

import com.gxk.jvm.classfile.ConstantInfo;

/**
 * 从 JDK 1.7 开始引入的三个常量之一
 *CONSTANT_InvokeDynamic_info 主要为 invokedynamic 指令提供启动引导方法
 * 调用动态语言
 */
public class InvokeDynamic extends ConstantInfo {

  public final int bootstrapMethodAttrIndex;
  public final int nameAndTypeIndex;

  public InvokeDynamic(int infoEnum, int bootstrapMethodAttrIndex, int nameAndTypeIndex) {
    //tag 18
    super(infoEnum);
    //指向引导方法表 bootstrap_methods[] 数组的索引
    this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
    //指向索引类常量池里的CONSTANT_NameAndType_info，表示方法描述符
    this.nameAndTypeIndex = nameAndTypeIndex;
  }
}
