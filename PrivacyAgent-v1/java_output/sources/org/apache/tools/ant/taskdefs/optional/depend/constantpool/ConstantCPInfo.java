package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public abstract class ConstantCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry {
    public java.lang.Object d;

    public ConstantCPInfo(int i, int i2) {
        super(i, i2);
    }

    public java.lang.Object getValue() {
        return this.d;
    }

    public void setValue(java.lang.Object obj) {
        this.d = obj;
    }
}
