package com.gxk.jvm.classfile;

import com.gxk.jvm.classfile.attribute.BootstrapMethods;
import com.gxk.jvm.classfile.attribute.SourceFile;

/**
 *
 * Class 格式链接地址如下
 *
 * <a href="https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.1">
 * </a>https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.1</a>
 * <p>
 *
 * 什么是 ClassFile ？
 * 一个 Byte
 * u1
 * 两个 Byte
 * u2
 * 四个 Byte
 * u4
 * 1、2、4 字节无符号整数
 *
 *  ClassFile {
 *     u4             magic;
 *     u2             minor_version;
 *     u2             major_version;
 *     u2             constant_pool_count;
 *     cp_info        constant_pool[constant_pool_count-1];
 *     u2             access_flags;
 *     u2             this_class;
 *     u2             super_class;
 *     u2             interfaces_count;
 *     u2             interfaces[interfaces_count];
 *     u2             fields_count;
 *     field_info     fields[fields_count];
 *     u2             methods_count;
 *     method_info    methods[methods_count];
 *     u2             attributes_count;
 *     attribute_info attributes[attributes_count];
 * }
 *
 * 《Optimizing Java》的作者编了一句顺口溜帮忙记住上面这十部分：
 * "My Very Cute Animal Turns Savage In Full Moon Areas."
 * My             V                  C             A           T            S            I        F        M       A
 * magic  minor&magor_version  constant_pool  access_flags  this_class  super_class interfaces  fields  methods attributes
 *
 */
public class ClassFile {

  /**
   * 魔数
   * Class 文件的头四个字节成为魔数 (Magic Number) ,Class 文件魔法值为 0xCAFEBABE
   * 为什么文件的开头需要魔数值？
   * 文件开头需要魔数，是为了判断文件是否为虚拟机可以接受的 Class 文件，使用魔数是为了对文件的身份合法性识别，也是为了文件的安全性考虑
   */

  public final int magic;
  /**
   * Class 文件版本号
   * Class 文件的 第 5 和第 6 个字节
   * 此字段为 Class 文件的次版本号
   *
   */
  public final int minorVersion;
  /**
   * Class 文件版本号
   * Class 文件的 第  7 和第 8 个字节
   * 从字段为 Class 主版本号
   * 设置版本号的目的是为了让虚拟机判断 Class 文件是否可以执行
   */
  public final int majorVersion;
  /**
   * 常量池中的常量数量（不固定）容量的计算 从 1 开始计算
   * 为什么从 1 开始计算
   */
  public final int constantPoolSize;
  /**
   * 常量池（表类型数据项目）
   * 可以理解成 Class 文件里的资源仓库
   *
   * 为什么需要常量池？
   * 由于 Class 文件不会保存各个方法，字段最终在内存里的布局信息，
   * 这些字段 方法的符号引用不经过虚拟机运行期间的转换的话是无法得到真正的内存入口地址，无法被虚拟机使用
   *
   * 常量池的作用
   * 是为了虚拟机进行类加载时，可以从常量池中获取对应的符号引用，在类创建时或运行时解析，翻译到具体的内存地址中
   *
   */
  public final ConstantPool cpInfo;
  /**
   *
   * 访问标志
   * 用来识别一些类或者接口层次的访问信息。
   * 包括：
   * 当前 Class 是类还是接口；是否定义为 public 类型；是否定义为 abstract 类型；
   * 如果是类的话，是否被声明为 final；
   * 标志位信息：https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4
   *
   * Flag Name          Value(十六进制值)      Interpretation
   * ACC_PUBLIC           1                    标识是否是 public
   * ACC_FINAL            10                   标识是否是 final
   * ACC_SUPER            20                   已经不用了
   * ACC_INTERFACE        200                  标识是类还是接口
   * ACC_ABSTRACT         400                  标识是否是 abstract
   * ACC_SYNTHETIC        1000                 编译器自动生成，不是用户源代码编译生成
   * ACC_ANNOTATION       2000                 标识是否是注解类
   * ACC_ENUM             4000                 标识是否是枚举类
   */
  public final int accessFlags;

  /**
   * 类索引
   */
  public final int thisClass;

  /**
   * 父类索引
   */
  public final int superClass;

  /**
   * 接口索引数量
   */
  public final int interfacesCount;

  /**
   * 接口索引集合 u2 数据集合
   */
  public final Interfaces interfaces;

  /**
   * 字段表数量
   */
  public final int fieldCount;

  /**
   * 字段表
   * 用于表述接口或者类中的声明变量
   */
  public final Fields fields;

  /**
   * 方法表数量
   */
  public final int methodsCount;

  /**
   * 方法表
   */
  public final Methods methods;

  /**
   * 属性表数量
   */
  public final int attributesCount;

  /**
   * 属性表
   */
  public final Attributes attributes;

  /**
   * 设置Class file 得加载路径
   */
  private String source;


  public ClassFile(int magic, int minorVersion, int majorVersion, int constantPoolSize,
      ConstantPool cpInfo, int accessFlags, int thisClass, int superClass, int interfacesCount,
      Interfaces interfaces, int fieldCount, Fields fields, int methodsCount, Methods methods, int attributesCount,
      Attributes attributes) {

    this.magic = magic;
    this.minorVersion = minorVersion;
    this.majorVersion = majorVersion;
    this.constantPoolSize = constantPoolSize;
    this.cpInfo = cpInfo;
    this.accessFlags = accessFlags;
    this.thisClass = thisClass;
    this.superClass = superClass;
    this.interfacesCount = interfacesCount;
    this.interfaces = interfaces;
    this.fieldCount = fieldCount;
    this.fields = fields;
    this.methodsCount = methodsCount;
    this.methods = methods;
    this.attributesCount = attributesCount;
    this.attributes = attributes;

  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getSource() {
    return source;
  }

  public String getSourceFile() {
    for (Attribute attribute : this.attributes.attributes) {
      if (attribute instanceof SourceFile) {
        return ((SourceFile) attribute).name;
      }
    }
    return "unknown";
  }

  public BootstrapMethods getBootstrapMethods() {
    for (Attribute attribute : attributes.attributes) {
      if (attribute instanceof BootstrapMethods) {
        return (BootstrapMethods) attribute;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "ClassFile{" +
      "\n, magic=" + magic +
      "\n, minorVersion=" + minorVersion +
      "\n, majorVersion=" + majorVersion +
      "\n, constantPoolSize=" + constantPoolSize +
      "\n, cpInfo=" + cpInfo +
      "\n, accessFlags=" + accessFlags +
      "\n, thisClass=" + thisClass +
      "\n, superClass=" + superClass +
      "\n, interfacesCount=" + interfacesCount +
      "\n, interfaces=" + interfaces +
      "\n, fieldCount=" + fieldCount +
      "\n, fields=" + fields +
      "\n, methodsCount=" + methodsCount +
      "\n, methods=" + methods +
      "\n, attributesCount=" + attributesCount +
      "\n, attributes=" + attributes +
      "\n}";
  }
}
