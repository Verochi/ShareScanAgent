package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class MethodTypeCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo {
    public int e;
    public java.lang.String f;

    public MethodTypeCPInfo() {
        super(16, 1);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.e = dataInputStream.readUnsignedShort();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void resolve(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool) {
        org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo utf8CPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo) constantPool.getEntry(this.e);
        utf8CPInfo.resolve(constantPool);
        this.f = utf8CPInfo.getValue();
        super.resolve(constantPool);
    }

    public java.lang.String toString() {
        if (isResolved()) {
            return "MethodDescriptor: " + this.f;
        }
        return "MethodDescriptorIndex: " + this.e;
    }
}
