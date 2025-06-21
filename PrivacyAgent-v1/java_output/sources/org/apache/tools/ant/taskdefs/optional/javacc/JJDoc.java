package org.apache.tools.ant.taskdefs.optional.javacc;

/* loaded from: classes25.dex */
public class JJDoc extends org.apache.tools.ant.Task {
    public java.lang.String A;
    public final java.util.Hashtable u = new java.util.Hashtable();
    public java.lang.String v = null;
    public boolean w = false;
    public java.io.File x = null;
    public java.io.File y = null;
    public org.apache.tools.ant.types.CommandlineJava z;

    public JJDoc() {
        org.apache.tools.ant.types.CommandlineJava commandlineJava = new org.apache.tools.ant.types.CommandlineJava();
        this.z = commandlineJava;
        this.A = null;
        commandlineJava.setVm(org.apache.tools.ant.util.JavaEnvUtils.getJreExecutable(com.uc.crashsdk.export.LogType.JAVA_TYPE));
    }

    public final java.lang.String c(java.io.File file, java.lang.String str, boolean z) {
        java.lang.String str2;
        java.lang.String replace = file.getAbsolutePath().replace('\\', '/');
        java.lang.String str3 = z ? ".txt" : ".html";
        if (str == null || str.equals("")) {
            int lastIndexOf = replace.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            if (lastIndexOf >= 0) {
                replace = replace.substring(lastIndexOf + 1);
            }
            int lastIndexOf2 = replace.lastIndexOf(46);
            if (lastIndexOf2 == -1) {
                str2 = replace + str3;
            } else if (replace.substring(lastIndexOf2).equals(str3)) {
                str2 = replace + str3;
            } else {
                str2 = replace.substring(0, lastIndexOf2) + str3;
            }
        } else {
            str2 = str.replace('\\', '/');
        }
        return (getProject().getBaseDir() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2).replace('\\', '/');
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.util.Enumeration keys = this.u.keys();
        while (keys.hasMoreElements()) {
            java.lang.String str = (java.lang.String) keys.nextElement();
            java.lang.Object obj = this.u.get(str);
            this.z.createArgument().setValue(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + obj.toString());
        }
        java.io.File file = this.x;
        if (file == null || !file.isFile()) {
            throw new org.apache.tools.ant.BuildException("Invalid target: " + this.x);
        }
        if (this.v != null) {
            this.z.createArgument().setValue("-OUTPUT_FILE:" + this.v.replace('\\', '/'));
        }
        java.io.File file2 = new java.io.File(c(this.x, this.v, this.w));
        if (file2.exists() && this.x.lastModified() < file2.lastModified()) {
            log("Target is already built - skipping (" + this.x + ")", 3);
            return;
        }
        this.z.createArgument().setValue(this.x.getAbsolutePath());
        org.apache.tools.ant.types.Path createClasspath = this.z.createClasspath(getProject());
        createClasspath.createPathElement().setPath(org.apache.tools.ant.taskdefs.optional.javacc.JavaCC.getArchiveFile(this.y).getAbsolutePath());
        createClasspath.addJavaRuntime();
        this.z.setClassname(org.apache.tools.ant.taskdefs.optional.javacc.JavaCC.getMainClass(createClasspath, 3));
        this.z.setMaxmemory(this.A);
        this.z.createVmArgument().setValue("-Dinstall.root=" + this.y.getAbsolutePath());
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 2, 2), null);
        log(this.z.describeCommand(), 3);
        execute.setCommandline(this.z.getCommandline());
        try {
            if (execute.execute() == 0) {
            } else {
                throw new org.apache.tools.ant.BuildException("JJDoc failed.");
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Failed to launch JJDoc", e);
        }
    }

    public void setJavacchome(java.io.File file) {
        this.y = file;
    }

    public void setMaxmemory(java.lang.String str) {
        this.A = str;
    }

    public void setOnetable(boolean z) {
        this.u.put("ONE_TABLE", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setOutputfile(java.lang.String str) {
        this.v = str;
    }

    public void setTarget(java.io.File file) {
        this.x = file;
    }

    public void setText(boolean z) {
        this.u.put("TEXT", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
        this.w = z;
    }
}
