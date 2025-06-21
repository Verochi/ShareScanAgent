package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class MethodHandleCPInfo extends org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry {
    public org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry d;
    public org.apache.tools.ant.taskdefs.optional.depend.constantpool.MethodHandleCPInfo.ReferenceKind e;
    public int f;

    public enum ReferenceKind {
        REF_getField(1),
        REF_getStatic(2),
        REF_putField(3),
        REF_putStatic(4),
        REF_invokeVirtual(5),
        REF_invokeStatic(6),
        REF_invokeSpecial(7),
        REF_newInvokeSpecial(8),
        REF_invokeInterface(9);

        private final int referenceKind;

        ReferenceKind(int i) {
            this.referenceKind = i;
        }
    }

    public MethodHandleCPInfo() {
        super(15, 1);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        this.e = org.apache.tools.ant.taskdefs.optional.depend.constantpool.MethodHandleCPInfo.ReferenceKind.values()[dataInputStream.readUnsignedByte() - 1];
        this.f = dataInputStream.readUnsignedShort();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry
    public void resolve(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPool constantPool) {
        org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry entry = constantPool.getEntry(this.f);
        this.d = entry;
        entry.resolve(constantPool);
        super.resolve(constantPool);
    }

    public java.lang.String toString() {
        if (isResolved()) {
            return "MethodHandle : " + this.d.toString();
        }
        return "MethodHandle : Reference kind = " + this.e + "Reference index = " + this.f;
    }
}
