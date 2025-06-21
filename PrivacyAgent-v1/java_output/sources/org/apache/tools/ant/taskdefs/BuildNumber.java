package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class BuildNumber extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.util.FileUtils v = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File u;

    public final int c(java.util.Properties properties) throws org.apache.tools.ant.BuildException {
        java.lang.String trim = properties.getProperty("build.number", "0").trim();
        try {
            return java.lang.Integer.parseInt(trim);
        } catch (java.lang.NumberFormatException e) {
            throw new org.apache.tools.ant.BuildException(this.u + " contains a non integer build number: " + trim, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.util.Properties d() throws org.apache.tools.ant.BuildException {
        java.lang.Throwable th;
        java.io.IOException e;
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                java.util.Properties properties = new java.util.Properties();
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(this.u);
                try {
                    properties.load(fileInputStream2);
                    try {
                        fileInputStream2.close();
                    } catch (java.io.IOException e2) {
                        log("error closing input stream " + e2, 0);
                    }
                    return properties;
                } catch (java.io.IOException e3) {
                    e = e3;
                    throw new org.apache.tools.ant.BuildException(e);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException e4) {
                        log("error closing input stream " + e4, 0);
                    }
                }
                throw th;
            }
        } catch (java.io.IOException e5) {
            e = e5;
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = this.u;
        validate();
        java.util.Properties d = d();
        int c = c(d);
        d.put("build.number", java.lang.String.valueOf(c + 1));
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(this.u);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            d.store(fileOutputStream, "Build Number for ANT. Do not edit!");
            try {
                fileOutputStream.close();
            } catch (java.io.IOException e2) {
                log("error closing output stream " + e2, 0);
            }
            this.u = file;
            getProject().setNewProperty("build.number", java.lang.String.valueOf(c));
        } catch (java.io.IOException e3) {
            e = e3;
            throw new org.apache.tools.ant.BuildException("Error while writing " + this.u, e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException e4) {
                    log("error closing output stream " + e4, 0);
                }
            }
            this.u = file;
            throw th;
        }
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            this.u = v.resolveFile(getProject().getBaseDir(), "build.number");
        }
        if (!this.u.exists()) {
            try {
                v.createNewFile(this.u);
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException(this.u + " doesn't exist and new file can't be created.", e);
            }
        }
        if (!this.u.canRead()) {
            throw new org.apache.tools.ant.BuildException("Unable to read from " + this.u + ".");
        }
        if (this.u.canWrite()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Unable to write to " + this.u + ".");
    }
}
