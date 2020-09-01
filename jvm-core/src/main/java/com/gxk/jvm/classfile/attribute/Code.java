package com.gxk.jvm.classfile.attribute;

import com.gxk.jvm.classfile.Attribute;
import com.gxk.jvm.classfile.Attributes;
import com.gxk.jvm.classfile.ExceptionTable;
import com.gxk.jvm.instruction.Instruction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 包含所有方法的字节码
 * Code 属性表的字段含义如下：
 *
 * 属性名索引（attribute_name_index）占两个字节，指向常量池中 CONSTANT_Utf8_info 常量，
 *
 * 表示属性的名字，比如这里对应的常量池的字符串常量"Code"。
 *
 * 属性长度（attribute_length）占用两个字节，表示属性值大小
 *
 * max_stack 表示操作数栈的最大深度，方法执行的任意期间操作数栈的深度都不会超过这个值。
 *
 * 它的计算规则是有入栈的指令 stack 增加，有出栈的指令 stack 减少，
 *
 * 在整个过程中 stack 的最大值就是 max_stack 的值，增加和减少的值一般都是 1，
 *
 * 但也有例外：LONG 和 DOUBLE 相关的指令入栈 stack 会增加 2，VOID 相关的指令则为 0。
 *
 * max_locals 表示局部变量表的大小，它的值并不是等于方法中所有局部变量的数量之和。
 *
 * 当一个局部作用域结束，它内部的局部变量占用的位置就可以被接下来的局部变量复用了。
 *
 * code_length 和 code 用来表示字节码相关的信息，其中 code_length 表示字节码指令的长度，占用 4 个字节。
 *
 * code 是一个长度为 code_length 的字节数组，存储真正的字节码指令。
 *
 * exception_table_length 和 exception_table 用来表示代码内部的异常表信息，如我们熟知的 try-catch 语法就会生成对应的异常表。
 *
 * attributes_count 和 attributes[] 用来表示 Code 属性相关的附属属性，
 *
 *
 *  Code_attribute {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u2 max_stack;
 *     u2 max_locals;
 *     u4 code_length;
 *     u1 code[code_length];
 *     u2 exception_table_length;
 *     {   u2 start_pc;
 *       u2 end_pc;
 *       u2 handler_pc;
 *       u2 catch_type;
 *     } exception_table[exception_table_length];
 *     u2 attributes_count;
 *     attribute_info attributes[attributes_count];
 *   }
 */
public class Code extends Attribute {

  public final int maxStacks;
  public final int maxLocals;
  //指令数组？
  public final Instruction[] instructions;

  //异常表
  public final ExceptionTable exceptionTable;

  /**
   * Java 虚拟机规定 Code 属性只能包含这四种可选属性：LineNumberTable、LocalVariableTable、LocalVariableTypeTable、StackMapTable。
   *
   *  以LineNumberTable 为例，LineNumberTable 用来存放源码行号和字节码偏移量之间的对应关系，这 LineNumberTable 属于调试信息，
   *
   *  不是类文件运行的必需的属性，默认情况下都会生成。如果没有这两个属性，那么在调试时没有办法在源码中设置断点，
   *
   *  也没有办法在代码抛出异常的时候在错误堆栈中显示出错的行号信息。
   *
   */
  public final Attributes attributes;

  public Code(int maxStacks, int maxLocals, Instruction[] instructions,
      ExceptionTable exceptionTable, Attributes attributes) {
    this.maxStacks = maxStacks;
    this.maxLocals = maxLocals;
    this.instructions = instructions;
    this.exceptionTable = exceptionTable;
    this.attributes = attributes;
  }

  public Map<Integer, Instruction> getInstructions() {
    Map<Integer, Instruction> map = new LinkedHashMap<>(instructions.length);
    int pc = 0;
    for (Instruction instruction : instructions) {
      map.put(pc, instruction);
      pc += instruction.offset();
    }
    return map;
  }
}
