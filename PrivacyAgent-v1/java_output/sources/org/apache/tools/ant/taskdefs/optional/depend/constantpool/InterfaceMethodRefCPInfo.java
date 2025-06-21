package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class InterfaceMethodRefCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry {
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public int g;
    public int h;

    public InterfaceMethodRefCPInfo() {
        super(11, 1);
    }

    public java.lang.String getInterfaceMethodClassName() {
        return this.d;
    }

    public java.lang.String getInterfaceMethodName() {
        return this.e;
    }

    public java.lang.String getInterfaceMethodType() {
        return this.f;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.g = dataInputStream.readUnsignedShort();
        this.h = dataInputStream.readUnsignedShort();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void resolve(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool) {
        org.apache.tools.ant.taskdefs.optional.depend.constantpool.ClassCPInfo classCPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.ClassCPInfo) constantPool.getEntry(this.g);
        classCPInfo.resolve(constantPool);
        this.d = classCPInfo.getClassName();
        org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo nameAndTypeCPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo) constantPool.getEntry(this.h);
        nameAndTypeCPInfo.resolve(constantPool);
        this.e = nameAndTypeCPInfo.getName();
        this.f = nameAndTypeCPInfo.getType();
        super.resolve(constantPool);
    }

    public java.lang.String toString() {
        if (!isResolved()) {
            return "InterfaceMethod : Class index = " + this.g + ", name and type index = " + this.h;
        }
        return "InterfaceMethod : Class = " + this.d + ", name = " + this.e + ", type = " + this.f;
    }
}
