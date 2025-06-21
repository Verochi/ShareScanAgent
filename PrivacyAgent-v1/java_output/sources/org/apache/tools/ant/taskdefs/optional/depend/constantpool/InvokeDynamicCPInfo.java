package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class InvokeDynamicCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo {
    public int e;
    public int f;
    public org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo g;

    public InvokeDynamicCPInfo() {
        super(18, 1);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.e = dataInputStream.readUnsignedShort();
        this.f = dataInputStream.readUnsignedShort();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void resolve(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool) {
        org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo nameAndTypeCPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo) constantPool.getEntry(this.f);
        this.g = nameAndTypeCPInfo;
        nameAndTypeCPInfo.resolve(constantPool);
        super.resolve(constantPool);
    }

    public java.lang.String toString() {
        if (isResolved()) {
            return "Name = " + this.g.getName() + ", type = " + this.g.getType();
        }
        return "BootstrapMethodAttrIndex inx = " + this.e + "NameAndType index = " + this.f;
    }
}
