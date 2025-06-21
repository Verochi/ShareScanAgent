package org.apache.tools.ant.taskdefs.optional.javacc;

/* loaded from: classes25.dex */
public class JJTree extends org.apache.tools.ant.Task {
    public java.lang.String A;
    public final java.util.Hashtable u = new java.util.Hashtable();
    public java.lang.String v = null;
    public java.io.File w = null;
    public java.io.File x = null;
    public java.io.File y = null;
    public org.apache.tools.ant.types.CommandlineJava z;

    public JJTree() {
        org.apache.tools.ant.types.CommandlineJava commandlineJava = new org.apache.tools.ant.types.CommandlineJava();
        this.z = commandlineJava;
        this.A = null;
        commandlineJava.setVm(org.apache.tools.ant.util.JavaEnvUtils.getJreExecutable(com.uc.crashsdk.export.LogType.JAVA_TYPE));
    }

    public final java.lang.String c(java.io.File file, java.lang.String str, java.lang.String str2) {
        java.lang.String g = g(str, str2);
        java.lang.String replace = file.getAbsolutePath().replace('\\', '/');
        if (g == null || g.equals("")) {
            int lastIndexOf = replace.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            if (lastIndexOf >= 0) {
                replace = replace.substring(lastIndexOf + 1);
            }
            int lastIndexOf2 = replace.lastIndexOf(46);
            if (lastIndexOf2 == -1) {
                g = replace + ".jj";
            } else if (replace.substring(lastIndexOf2).equals(".jj")) {
                g = replace + ".jj";
            } else {
                g = replace.substring(0, lastIndexOf2) + ".jj";
            }
        }
        if (str2 == null || str2.equals("")) {
            str2 = d();
        }
        return (str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + g).replace('\\', '/');
    }

    public final java.lang.String d() {
        return getProject().getBaseDir().getAbsolutePath().replace('\\', '/');
    }

    public final java.io.File e(java.io.File file) {
        java.io.File absoluteFile = file.getAbsoluteFile();
        while (absoluteFile.getParent() != null) {
            absoluteFile = absoluteFile.getParentFile();
        }
        return absoluteFile;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file;
        java.util.Enumeration keys = this.u.keys();
        while (keys.hasMoreElements()) {
            java.lang.String str = (java.lang.String) keys.nextElement();
            java.lang.Object obj = this.u.get(str);
            this.z.createArgument().setValue(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + obj.toString());
        }
        java.io.File file2 = this.x;
        if (file2 == null || !file2.isFile()) {
            throw new org.apache.tools.ant.BuildException("Invalid target: " + this.x);
        }
        java.io.File file3 = this.w;
        if (file3 == null) {
            this.z.createArgument().setValue("-OUTPUT_DIRECTORY:" + d());
            file = new java.io.File(c(this.x, this.v, null));
        } else {
            if (!file3.isDirectory()) {
                throw new org.apache.tools.ant.BuildException("'outputdirectory' " + this.w + " is not a directory.");
            }
            this.z.createArgument().setValue("-OUTPUT_DIRECTORY:" + this.w.getAbsolutePath().replace('\\', '/'));
            file = new java.io.File(c(this.x, this.v, this.w.getPath()));
        }
        if (file.exists() && this.x.lastModified() < file.lastModified()) {
            log("Target is already built - skipping (" + this.x + ")", 3);
            return;
        }
        if (this.v != null) {
            this.z.createArgument().setValue("-OUTPUT_FILE:" + this.v.replace('\\', '/'));
        }
        this.z.createArgument().setValue(this.x.getAbsolutePath());
        org.apache.tools.ant.types.Path createClasspath = this.z.createClasspath(getProject());
        createClasspath.createPathElement().setPath(org.apache.tools.ant.taskdefs.optional.javacc.JavaCC.getArchiveFile(this.y).getAbsolutePath());
        createClasspath.addJavaRuntime();
        this.z.setClassname(org.apache.tools.ant.taskdefs.optional.javacc.JavaCC.getMainClass(createClasspath, 2));
        this.z.setMaxmemory(this.A);
        this.z.createVmArgument().setValue("-Dinstall.root=" + this.y.getAbsolutePath());
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 2, 2), null);
        log(this.z.describeCommand(), 3);
        execute.setCommandline(this.z.getCommandline());
        try {
            if (execute.execute() == 0) {
            } else {
                throw new org.apache.tools.ant.BuildException("JJTree failed.");
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Failed to launch JJTree", e);
        }
    }

    public final java.lang.String f(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String d = d();
        int indexOf = d.indexOf(47);
        loop0: while (true) {
            indexOf++;
            while (indexOf > -1 && indexOf < d.length()) {
                stringBuffer.append("/..");
                indexOf = d.indexOf(47, indexOf);
                if (indexOf == -1) {
                }
            }
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public final java.lang.String g(java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        if (str == null) {
            return null;
        }
        if (str2 == null && (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || str.startsWith("\\"))) {
            java.lang.String f = f(str);
            setOutputfile(f);
            return f;
        }
        java.lang.String absolutePath = e(new java.io.File(str)).getAbsolutePath();
        if (absolutePath.length() <= 1 || !str.startsWith(absolutePath.substring(0, absolutePath.length() - 1))) {
            return str;
        }
        throw new org.apache.tools.ant.BuildException("Drive letter in 'outputfile' not supported: " + str);
    }

    public void setBuildnodefiles(boolean z) {
        this.u.put("BUILD_NODE_FILES", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setJavacchome(java.io.File file) {
        this.y = file;
    }

    public void setMaxmemory(java.lang.String str) {
        this.A = str;
    }

    public void setMulti(boolean z) {
        this.u.put("MULTI", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setNodedefaultvoid(boolean z) {
        this.u.put("NODE_DEFAULT_VOID", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setNodefactory(boolean z) {
        this.u.put("NODE_FACTORY", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setNodepackage(java.lang.String str) {
        this.u.put("NODE_PACKAGE", str);
    }

    public void setNodeprefix(java.lang.String str) {
        this.u.put("NODE_PREFIX", str);
    }

    public void setNodescopehook(boolean z) {
        this.u.put("NODE_SCOPE_HOOK", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setNodeusesparser(boolean z) {
        this.u.put("NODE_USES_PARSER", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setOutputdirectory(java.io.File file) {
        this.w = file;
    }

    public void setOutputfile(java.lang.String str) {
        this.v = str;
    }

    public void setStatic(boolean z) {
        this.u.put("STATIC", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setTarget(java.io.File file) {
        this.x = file;
    }

    public void setVisitor(boolean z) {
        this.u.put("VISITOR", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setVisitorException(java.lang.String str) {
        this.u.put("VISITOR_EXCEPTION", str);
    }
}
