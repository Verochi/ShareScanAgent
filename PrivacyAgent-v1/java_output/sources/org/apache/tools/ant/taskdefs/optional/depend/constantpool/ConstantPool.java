package org.apache.tools.ant.taskdefs.optional.depend.constantpool;

/* loaded from: classes25.dex */
public class ConstantPool {
    public final java.util.List<org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry> a;
    public final java.util.Map<java.lang.String, java.lang.Integer> b;

    public ConstantPool() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.a = arrayList;
        this.b = new java.util.HashMap();
        arrayList.add(null);
    }

    public int addEntry(org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry constantPoolEntry) {
        int size = this.a.size();
        this.a.add(constantPoolEntry);
        int numEntries = constantPoolEntry.getNumEntries();
        for (int i = 0; i < numEntries - 1; i++) {
            this.a.add(null);
        }
        if (constantPoolEntry instanceof org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo) {
            this.b.put(((org.apache.tools.ant.taskdefs.optional.depend.constantpool.Utf8CPInfo) constantPoolEntry).getValue(), java.lang.Integer.valueOf(size));
        }
        return size;
    }

    public int getClassEntry(java.lang.String str) {
        int size = this.a.size();
        int i = -1;
        for (int i2 = 0; i2 < size && i == -1; i2++) {
            org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry constantPoolEntry = this.a.get(i2);
            if ((constantPoolEntry instanceof org.apache.tools.ant.taskdefs.optional.depend.constantpool.ClassCPInfo) && ((org.apache.tools.ant.taskdefs.optional.depend.constantpool.ClassCPInfo) constantPoolEntry).getClassName().equals(str)) {
                i = i2;
            }
        }
        return i;
    }

    public int getConstantEntry(java.lang.Object obj) {
        int size = this.a.size();
        int i = -1;
        for (int i2 = 0; i2 < size && i == -1; i2++) {
            org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry constantPoolEntry = this.a.get(i2);
            if ((constantPoolEntry instanceof org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo) && ((org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantCPInfo) constantPoolEntry).getValue().equals(obj)) {
                i = i2;
            }
        }
        return i;
    }

    public org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry getEntry(int i) {
        return this.a.get(i);
    }

    public int getFieldRefEntry(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        int size = this.a.size();
        int i = -1;
        for (int i2 = 0; i2 < size && i == -1; i2++) {
            org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry constantPoolEntry = this.a.get(i2);
            if (constantPoolEntry instanceof org.apache.tools.ant.taskdefs.optional.depend.constantpool.FieldRefCPInfo) {
                org.apache.tools.ant.taskdefs.optional.depend.constantpool.FieldRefCPInfo fieldRefCPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.FieldRefCPInfo) constantPoolEntry;
                if (fieldRefCPInfo.getFieldClassName().equals(str) && fieldRefCPInfo.getFieldName().equals(str2) && fieldRefCPInfo.getFieldType().equals(str3)) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public int getInterfaceMethodRefEntry(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        int size = this.a.size();
        int i = -1;
        for (int i2 = 0; i2 < size && i == -1; i2++) {
            org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry constantPoolEntry = this.a.get(i2);
            if (constantPoolEntry instanceof org.apache.tools.ant.taskdefs.optional.depend.constantpool.InterfaceMethodRefCPInfo) {
                org.apache.tools.ant.taskdefs.optional.depend.constantpool.InterfaceMethodRefCPInfo interfaceMethodRefCPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.InterfaceMethodRefCPInfo) constantPoolEntry;
                if (interfaceMethodRefCPInfo.getInterfaceMethodClassName().equals(str) && interfaceMethodRefCPInfo.getInterfaceMethodName().equals(str2) && interfaceMethodRefCPInfo.getInterfaceMethodType().equals(str3)) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public int getMethodRefEntry(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        int size = this.a.size();
        int i = -1;
        for (int i2 = 0; i2 < size && i == -1; i2++) {
            org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry constantPoolEntry = this.a.get(i2);
            if (constantPoolEntry instanceof org.apache.tools.ant.taskdefs.optional.depend.constantpool.MethodRefCPInfo) {
                org.apache.tools.ant.taskdefs.optional.depend.constantpool.MethodRefCPInfo methodRefCPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.MethodRefCPInfo) constantPoolEntry;
                if (methodRefCPInfo.getMethodClassName().equals(str) && methodRefCPInfo.getMethodName().equals(str2) && methodRefCPInfo.getMethodType().equals(str3)) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public int getNameAndTypeEntry(java.lang.String str, java.lang.String str2) {
        int size = this.a.size();
        int i = -1;
        for (int i2 = 0; i2 < size && i == -1; i2++) {
            org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry constantPoolEntry = this.a.get(i2);
            if (constantPoolEntry instanceof org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo) {
                org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo nameAndTypeCPInfo = (org.apache.tools.ant.taskdefs.optional.depend.constantpool.NameAndTypeCPInfo) constantPoolEntry;
                if (nameAndTypeCPInfo.getName().equals(str) && nameAndTypeCPInfo.getType().equals(str2)) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public int getUTF8Entry(java.lang.String str) {
        java.lang.Integer num = this.b.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public void read(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        int i = 1;
        while (i < readUnsignedShort) {
            org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry readEntry = org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry.readEntry(dataInputStream);
            i += readEntry.getNumEntries();
            addEntry(readEntry);
        }
    }

    public void resolve() {
        for (org.apache.tools.ant.taskdefs.optional.depend.constantpool.ConstantPoolEntry constantPoolEntry : this.a) {
            if (constantPoolEntry != null && !constantPoolEntry.isResolved()) {
                constantPoolEntry.resolve(this);
            }
        }
    }

    public int size() {
        return this.a.size();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("\n");
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            sb.append('[');
            sb.append(i);
            sb.append("] = ");
            sb.append(getEntry(i));
            sb.append('\n');
        }
        return sb.toString();
    }
}
