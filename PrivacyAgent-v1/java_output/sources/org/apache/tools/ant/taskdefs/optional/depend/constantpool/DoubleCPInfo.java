package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class DoubleCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo {
    public DoubleCPInfo() {
        super(6, 2);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        setValue(new java.lang.Double(dataInputStream.readDouble()));
    }

    public java.lang.String toString() {
        return "Double Constant Pool Entry: " + getValue();
    }
}
