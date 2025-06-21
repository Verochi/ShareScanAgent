package org.apache.tools.ant.taskdefs.optional.depend;

/* loaded from: classes25.dex */
public class DirectoryIterator implements org.apache.tools.ant.taskdefs.optional.depend.ClassFileIterator {
    public java.util.Stack a = new java.util.Stack();
    public java.util.Enumeration b;

    public DirectoryIterator(java.io.File file, boolean z) throws java.io.IOException {
        this.b = a(file).elements();
    }

    public final java.util.Vector a(java.io.File file) {
        java.util.Vector vector = new java.util.Vector();
        java.lang.String[] list = file.list();
        if (list != null) {
            for (java.lang.String str : list) {
                vector.addElement(new java.io.File(file, str));
            }
        }
        return vector;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.ClassFileIterator
    public org.apache.tools.ant.taskdefs.optional.depend.ClassFile getNextClassFile() {
        org.apache.tools.ant.taskdefs.optional.depend.ClassFile classFile = null;
        while (classFile == null) {
            try {
                if (this.b.hasMoreElements()) {
                    java.io.File file = (java.io.File) this.b.nextElement();
                    if (file.isDirectory()) {
                        this.a.push(this.b);
                        this.b = a(file).elements();
                    } else {
                        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                        try {
                            if (file.getName().endsWith(".class")) {
                                classFile = new org.apache.tools.ant.taskdefs.optional.depend.ClassFile();
                                classFile.read(fileInputStream);
                            }
                            fileInputStream.close();
                        } catch (java.lang.Throwable th) {
                            fileInputStream.close();
                            throw th;
                        }
                    }
                } else {
                    if (this.a.empty()) {
                        break;
                    }
                    this.b = (java.util.Enumeration) this.a.pop();
                }
            } catch (java.io.IOException unused) {
                return null;
            }
        }
        return classFile;
    }
}
