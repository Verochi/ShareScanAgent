package org.apache.tools.ant.taskdefs.optional.depend;

/* loaded from: classes25.dex */
public class JarFileIterator implements org.apache.tools.ant.taskdefs.optional.depend.ClassFileIterator {
    public java.util.zip.ZipInputStream a;

    public JarFileIterator(java.io.InputStream inputStream) throws java.io.IOException {
        this.a = new java.util.zip.ZipInputStream(inputStream);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.depend.ClassFileIterator
    public org.apache.tools.ant.taskdefs.optional.depend.ClassFile getNextClassFile() {
        try {
            java.util.zip.ZipEntry nextEntry = this.a.getNextEntry();
            org.apache.tools.ant.taskdefs.optional.depend.ClassFile classFile = null;
            while (classFile == null && nextEntry != null) {
                java.lang.String name = nextEntry.getName();
                if (nextEntry.isDirectory() || !name.endsWith(".class")) {
                    nextEntry = this.a.getNextEntry();
                } else {
                    classFile = new org.apache.tools.ant.taskdefs.optional.depend.ClassFile();
                    classFile.read(this.a);
                }
            }
            return classFile;
        } catch (java.io.IOException e) {
            java.lang.String message = e.getMessage();
            java.lang.String name2 = e.getClass().getName();
            if (message != null) {
                name2 = name2 + ": " + message;
            }
            throw new org.apache.tools.ant.BuildException("Problem reading JAR file: " + name2);
        }
    }
}
