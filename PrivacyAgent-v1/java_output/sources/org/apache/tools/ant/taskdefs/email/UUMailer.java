package org.apache.tools.ant.taskdefs.email;

/* loaded from: classes25.dex */
class UUMailer extends org.apache.tools.ant.taskdefs.email.PlainMailer {
    @Override // org.apache.tools.ant.taskdefs.email.PlainMailer
    public void a(java.io.File file, java.io.PrintStream printStream) throws java.io.IOException {
        if (!file.exists() || !file.canRead()) {
            throw new org.apache.tools.ant.BuildException("File \"" + file.getName() + "\" does not exist or is not readable.");
        }
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            new org.apache.tools.ant.util.UUEncoder(file.getName()).encode(new java.io.BufferedInputStream(fileInputStream), printStream);
        } finally {
            fileInputStream.close();
        }
    }
}
