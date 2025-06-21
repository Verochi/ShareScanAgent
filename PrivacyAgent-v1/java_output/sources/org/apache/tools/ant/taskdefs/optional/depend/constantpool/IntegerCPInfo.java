package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class IntegerCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo {
    public IntegerCPInfo() {
        super(3, 1);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        setValue(new java.lang.Integer(dataInputStream.readInt()));
    }

    public java.lang.String toString() {
        return "Integer Constant Pool Entry: " + getValue();
    }
}
