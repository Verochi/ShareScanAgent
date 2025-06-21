package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public abstract class ConstantPoolEntry {
    public static final int CONSTANT_CLASS = 7;
    public static final int CONSTANT_DOUBLE = 6;
    public static final int CONSTANT_FIELDREF = 9;
    public static final int CONSTANT_FLOAT = 4;
    public static final int CONSTANT_INTEGER = 3;
    public static final int CONSTANT_INTERFACEMETHODREF = 11;
    public static final int CONSTANT_INVOKEDYNAMIC = 18;
    public static final int CONSTANT_LONG = 5;
    public static final int CONSTANT_METHODHANDLE = 15;
    public static final int CONSTANT_METHODREF = 10;
    public static final int CONSTANT_METHODTYPE = 16;
    public static final int CONSTANT_NAMEANDTYPE = 12;
    public static final int CONSTANT_STRING = 8;
    public static final int CONSTANT_UTF8 = 1;
    public int a;
    public int b;
    public boolean c = false;

    public ConstantPoolEntry(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public static org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry readEntry(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry utf8CPInfo;
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        switch (readUnsignedByte) {
            case 1:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo();
                break;
            case 2:
            case 13:
            case 14:
            case 17:
            default:
                throw new java.lang.ClassFormatError("Invalid Constant Pool entry Type " + readUnsignedByte);
            case 3:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.IntegerCPInfo();
                break;
            case 4:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.FloatCPInfo();
                break;
            case 5:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.LongCPInfo();
                break;
            case 6:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.DoubleCPInfo();
                break;
            case 7:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.ClassCPInfo();
                break;
            case 8:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.StringCPInfo();
                break;
            case 9:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.FieldRefCPInfo();
                break;
            case 10:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.MethodRefCPInfo();
                break;
            case 11:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.InterfaceMethodRefCPInfo();
                break;
            case 12:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo();
                break;
            case 15:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.MethodHandleCPInfo();
                break;
            case 16:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.MethodTypeCPInfo();
                break;
            case 18:
                utf8CPInfo = new org.apache.tools.ant.taskdefs.optional.depend.constantpool.InvokeDynamicCPInfo();
                break;
        }
        utf8CPInfo.read(dataInputStream);
        return utf8CPInfo;
    }

    public final int getNumEntries() {
        return this.b;
    }

    public int getTag() {
        return this.a;
    }

    public boolean isResolved() {
        return this.c;
    }

    public abstract void read(java.io.DataInputStream dataInputStream) throws java.io.IOException;

    public void resolve(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool) {
        this.c = true;
    }
}
