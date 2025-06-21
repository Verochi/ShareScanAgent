package org.apache.tools.ant.taskdefs.optional.javacc;

/* loaded from: classes25.dex */
public class JavaCC extends org.apache.tools.ant.Task {
    protected static final java.lang.String[] ARCHIVE_LOCATIONS = {"JavaCC.zip", "bin/lib/JavaCC.zip", "bin/lib/javacc.jar", "javacc.jar"};
    protected static final int[] ARCHIVE_LOCATIONS_VS_MAJOR_VERSION = {1, 2, 3, 3};
    protected static final java.lang.String COM_JAVACC_CLASS = "javacc.Main";
    protected static final java.lang.String COM_JJDOC_CLASS = "jjdoc.JJDocMain";
    protected static final java.lang.String COM_JJTREE_CLASS = "jjtree.Main";
    protected static final java.lang.String COM_PACKAGE = "COM.sun.labs.";
    protected static final java.lang.String ORG_JAVACC_CLASS = "parser.Main";
    protected static final java.lang.String ORG_JJDOC_CLASS = "jjdoc.JJDocMain";
    protected static final java.lang.String ORG_JJTREE_CLASS = "jjtree.Main";
    protected static final java.lang.String ORG_PACKAGE_3_0 = "org.netbeans.javacc.";
    protected static final java.lang.String ORG_PACKAGE_3_1 = "org.javacc.";
    protected static final int TASKDEF_TYPE_JAVACC = 1;
    protected static final int TASKDEF_TYPE_JJDOC = 3;
    protected static final int TASKDEF_TYPE_JJTREE = 2;
    public final java.util.Hashtable u = new java.util.Hashtable();
    public java.io.File v = null;
    public java.io.File w = null;
    public java.io.File x = null;
    public org.apache.tools.ant.types.CommandlineJava y;
    public java.lang.String z;

    public JavaCC() {
        org.apache.tools.ant.types.CommandlineJava commandlineJava = new org.apache.tools.ant.types.CommandlineJava();
        this.y = commandlineJava;
        this.z = null;
        commandlineJava.setVm(org.apache.tools.ant.util.JavaEnvUtils.getJreExecutable(com.uc.crashsdk.export.LogType.JAVA_TYPE));
    }

    public static int c(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (file == null || !file.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("JavaCC home must be a valid directory.");
        }
        int i = 0;
        while (true) {
            java.lang.String[] strArr = ARCHIVE_LOCATIONS;
            if (i >= strArr.length) {
                throw new org.apache.tools.ant.BuildException("Could not find a path to JavaCC.zip or javacc.jar from '" + file + "'.");
            }
            if (new java.io.File(file, strArr[i]).exists()) {
                return i;
            }
            i++;
        }
    }

    public static java.io.File getArchiveFile(java.io.File file) throws org.apache.tools.ant.BuildException {
        return new java.io.File(file, ARCHIVE_LOCATIONS[c(file)]);
    }

    public static java.lang.String getMainClass(java.io.File file, int i) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(null);
        path.createPathElement().setLocation(getArchiveFile(file));
        path.addJavaRuntime();
        return getMainClass(path, i);
    }

    public static java.lang.String getMainClass(org.apache.tools.ant.types.Path path, int i) throws org.apache.tools.ant.BuildException {
        java.lang.String str;
        org.apache.tools.ant.AntClassLoader antClassLoader = null;
        r1 = null;
        r1 = null;
        java.lang.String str2 = null;
        try {
            org.apache.tools.ant.AntClassLoader newAntClassLoader = org.apache.tools.ant.AntClassLoader.newAntClassLoader(null, null, path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE), true);
            try {
                if (newAntClassLoader.getResourceAsStream("COM.sun.labs.javacc.Main".replace('.', '/') + ".class") != null) {
                    str = COM_PACKAGE;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                            }
                            str2 = "jjdoc.JJDocMain";
                        }
                        str2 = "jjtree.Main";
                    } else {
                        str2 = COM_JAVACC_CLASS;
                    }
                } else {
                    java.io.InputStream resourceAsStream = newAntClassLoader.getResourceAsStream("org.javacc.parser.Main".replace('.', '/') + ".class");
                    if (resourceAsStream != null) {
                        str = ORG_PACKAGE_3_1;
                    } else {
                        resourceAsStream = newAntClassLoader.getResourceAsStream("org.netbeans.javacc.parser.Main".replace('.', '/') + ".class");
                        str = resourceAsStream != null ? ORG_PACKAGE_3_0 : null;
                    }
                    if (resourceAsStream != null) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                }
                                str2 = "jjdoc.JJDocMain";
                            }
                            str2 = "jjtree.Main";
                        } else {
                            str2 = ORG_JAVACC_CLASS;
                        }
                    }
                }
                if (str == null) {
                    throw new org.apache.tools.ant.BuildException("failed to load JavaCC");
                }
                if (str2 == null) {
                    throw new org.apache.tools.ant.BuildException("unknown task type " + i);
                }
                java.lang.String str3 = str + str2;
                newAntClassLoader.cleanup();
                return str3;
            } catch (java.lang.Throwable th) {
                th = th;
                antClassLoader = newAntClassLoader;
                if (antClassLoader != null) {
                    antClassLoader.cleanup();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static int getMajorVersionNumber(java.io.File file) throws org.apache.tools.ant.BuildException {
        return ARCHIVE_LOCATIONS_VS_MAJOR_VERSION[c(file)];
    }

    public final java.io.File d(java.io.File file, java.io.File file2) {
        java.lang.String str;
        java.lang.String path = file2.getPath();
        java.lang.String str2 = java.io.File.separator;
        int lastIndexOf = path.lastIndexOf(str2);
        if (lastIndexOf != -1) {
            path = path.substring(lastIndexOf + 1);
        }
        int lastIndexOf2 = path.lastIndexOf(46);
        if (lastIndexOf2 != -1) {
            str = path.substring(0, lastIndexOf2) + ".java";
        } else {
            str = path + ".java";
        }
        if (file != null) {
            str = file + str2 + str;
        }
        return new java.io.File(str);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.util.Enumeration keys = this.u.keys();
        while (keys.hasMoreElements()) {
            java.lang.String str = (java.lang.String) keys.nextElement();
            java.lang.Object obj = this.u.get(str);
            this.y.createArgument().setValue(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + obj.toString());
        }
        java.io.File file = this.w;
        if (file == null || !file.isFile()) {
            throw new org.apache.tools.ant.BuildException("Invalid target: " + this.w);
        }
        java.io.File file2 = this.v;
        if (file2 == null) {
            this.v = new java.io.File(this.w.getParent());
        } else if (!file2.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("Outputdir not a directory.");
        }
        this.y.createArgument().setValue("-OUTPUT_DIRECTORY:" + this.v.getAbsolutePath());
        java.io.File d = d(this.v, this.w);
        if (d.exists() && this.w.lastModified() < d.lastModified()) {
            log("Target is already built - skipping (" + this.w + ")", 3);
            return;
        }
        this.y.createArgument().setValue(this.w.getAbsolutePath());
        org.apache.tools.ant.types.Path createClasspath = this.y.createClasspath(getProject());
        createClasspath.createPathElement().setPath(getArchiveFile(this.x).getAbsolutePath());
        createClasspath.addJavaRuntime();
        this.y.setClassname(getMainClass(createClasspath, 1));
        this.y.setMaxmemory(this.z);
        this.y.createVmArgument().setValue("-Dinstall.root=" + this.x.getAbsolutePath());
        org.apache.tools.ant.taskdefs.Execute.runCommand(this, this.y.getCommandline());
    }

    public void setBuildparser(boolean z) {
        this.u.put("BUILD_PARSER", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setBuildtokenmanager(boolean z) {
        this.u.put("BUILD_TOKEN_MANAGER", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setCachetokens(boolean z) {
        this.u.put("CACHE_TOKENS", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setChoiceambiguitycheck(int i) {
        this.u.put("CHOICE_AMBIGUITY_CHECK", java.lang.Integer.valueOf(i));
    }

    public void setCommontokenaction(boolean z) {
        this.u.put("COMMON_TOKEN_ACTION", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setDebuglookahead(boolean z) {
        this.u.put("DEBUG_LOOKAHEAD", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setDebugparser(boolean z) {
        this.u.put("DEBUG_PARSER", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setDebugtokenmanager(boolean z) {
        this.u.put("DEBUG_TOKEN_MANAGER", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setErrorreporting(boolean z) {
        this.u.put("ERROR_REPORTING", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setForcelacheck(boolean z) {
        this.u.put("FORCE_LA_CHECK", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setIgnorecase(boolean z) {
        this.u.put("IGNORE_CASE", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setJDKversion(java.lang.String str) {
        this.u.put("JDK_VERSION", str);
    }

    public void setJavacchome(java.io.File file) {
        this.x = file;
    }

    public void setJavaunicodeescape(boolean z) {
        this.u.put("JAVA_UNICODE_ESCAPE", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setKeeplinecolumn(boolean z) {
        this.u.put("KEEP_LINE_COLUMN", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setLookahead(int i) {
        this.u.put("LOOKAHEAD", java.lang.Integer.valueOf(i));
    }

    public void setMaxmemory(java.lang.String str) {
        this.z = str;
    }

    public void setOptimizetokenmanager(boolean z) {
        this.u.put("OPTIMIZE_TOKEN_MANAGER", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setOtherambiguityCheck(int i) {
        this.u.put("OTHER_AMBIGUITY_CHECK", java.lang.Integer.valueOf(i));
    }

    public void setOutputdirectory(java.io.File file) {
        this.v = file;
    }

    public void setSanitycheck(boolean z) {
        this.u.put("SANITY_CHECK", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setStatic(boolean z) {
        this.u.put("STATIC", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setTarget(java.io.File file) {
        this.w = file;
    }

    public void setUnicodeinput(boolean z) {
        this.u.put("UNICODE_INPUT", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setUsercharstream(boolean z) {
        this.u.put("USER_CHAR_STREAM", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }

    public void setUsertokenmanager(boolean z) {
        this.u.put("USER_TOKEN_MANAGER", z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE);
    }
}
