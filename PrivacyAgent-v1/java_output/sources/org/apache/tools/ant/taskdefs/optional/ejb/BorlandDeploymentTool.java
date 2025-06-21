package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class BorlandDeploymentTool extends org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool implements org.apache.tools.ant.taskdefs.ExecuteStreamHandler {
    protected static final java.lang.String BAS_DD = "ejb-inprise.xml";
    protected static final java.lang.String BES_DD = "ejb-borland.xml";
    protected static final java.lang.String DEFAULT_BAS45_EJB11_DTD_LOCATION = "/com/inprise/j2ee/xml/dtds/ejb-jar.dtd";
    protected static final java.lang.String DEFAULT_BAS_DTD_LOCATION = "/com/inprise/j2ee/xml/dtds/ejb-inprise.dtd";
    protected static final java.lang.String JAVA2IIOP = "java2iiop";
    public static final java.lang.String PUBLICID_BORLAND_EJB = "-//Inprise Corporation//DTD Enterprise JavaBeans 1.1//EN";
    protected static final java.lang.String VERIFY = "com.inprise.ejb.util.Verify";
    public java.lang.String C;
    public java.lang.String B = "-ejb.jar";
    public boolean D = false;
    public java.lang.String E = null;
    public boolean F = false;
    public int G = 4;
    public boolean H = true;
    public java.lang.String I = "";
    public java.util.Hashtable J = new java.util.Hashtable();

    /* renamed from: org.apache.tools.ant.taskdefs.optional.ejb.BorlandDeploymentTool$1, reason: invalid class name */
    public class AnonymousClass1 extends org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler {
        public final /* synthetic */ java.io.File A;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(org.apache.tools.ant.Task task, java.io.File file, java.io.File file2) {
            super(task, file);
            this.A = file2;
        }

        @Override // org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler
        public void processElement() {
            if (this.currentElement.equals("type-storage")) {
                java.lang.String str = this.currentText;
                this.ejbFiles.put(str, new java.io.File(this.A, str.substring(9, str.length())));
            }
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
        int i = this.G;
        if (i != 5 && i != 4) {
            throw new org.apache.tools.ant.BuildException("version " + this.G + " is not supported");
        }
        java.lang.String str2 = i == 5 ? BES_DD : BAS_DD;
        log("vendor file : " + str + str2, 4);
        java.io.File file = new java.io.File(getConfig().b, str + str2);
        if (!file.exists()) {
            log("Unable to locate borland deployment descriptor. It was expected to be in " + file.getPath(), 1);
            return;
        }
        log("Borland specific file found " + file, 3);
        hashtable.put("META-INF/" + str2, file);
    }

    public final void b(java.util.Iterator it) {
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(this);
        org.apache.tools.ant.Project project = getTask().getProject();
        execute.setAntRun(project);
        execute.setWorkingDirectory(project.getBaseDir());
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(JAVA2IIOP);
        if (this.D) {
            commandline.createArgument().setValue("-VBJdebug");
        }
        commandline.createArgument().setValue("-VBJclasspath");
        commandline.createArgument().setPath(getCombinedClasspath());
        commandline.createArgument().setValue("-list_files");
        commandline.createArgument().setValue("-no_tie");
        if (this.E != null) {
            log("additional  " + this.E + " to java2iiop ", 0);
            commandline.createArgument().setLine(this.E);
        }
        commandline.createArgument().setValue("-root_dir");
        commandline.createArgument().setValue(getConfig().a.getAbsolutePath());
        commandline.createArgument().setValue("-compile");
        while (it.hasNext()) {
            commandline.createArgument().setValue(it.next().toString());
        }
        try {
            log("Calling java2iiop", 3);
            log(commandline.describeCommand(), 4);
            execute.setCommandline(commandline.getCommandline());
            int execute2 = execute.execute();
            if (org.apache.tools.ant.taskdefs.Execute.isFailure(execute2)) {
                throw new org.apache.tools.ant.BuildException("Failed executing java2iiop (ret code is " + execute2 + ")", getTask().getLocation());
            }
        } catch (java.io.IOException e) {
            log("java2iiop exception :" + e.getMessage(), 0);
            throw new org.apache.tools.ant.BuildException(e, getTask().getLocation());
        }
    }

    public final void c(java.io.File file) {
        getTask().getProject().addTaskDefinition("internal_bas_generateclient", org.apache.tools.ant.taskdefs.optional.ejb.BorlandGenerateClient.class);
        log("generate client for " + file, 2);
        try {
            org.apache.tools.ant.taskdefs.optional.ejb.BorlandGenerateClient borlandGenerateClient = (org.apache.tools.ant.taskdefs.optional.ejb.BorlandGenerateClient) getTask().getProject().createTask("internal_bas_generateclient");
            borlandGenerateClient.setEjbjar(file);
            borlandGenerateClient.setDebug(this.D);
            org.apache.tools.ant.types.Path combinedClasspath = getCombinedClasspath();
            if (combinedClasspath != null) {
                borlandGenerateClient.setClasspath(combinedClasspath);
            }
            borlandGenerateClient.setVersion(this.G);
            borlandGenerateClient.setTaskName("generate client");
            borlandGenerateClient.execute();
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while calling com.inprise.ejb.util.Verify Details: " + e.toString(), e);
        }
    }

    public final java.lang.String d(java.lang.String str) {
        return str.substring(0, str.lastIndexOf(".class")).replace('\\', '.');
    }

    public final java.lang.String e(java.lang.String str) {
        return str.substring(0, str.lastIndexOf(".java")) + ".class";
    }

    public final void f(java.io.File file) {
        int i = this.G;
        if (i == 4) {
            g(file);
            return;
        }
        if (i == 5) {
            h(file);
            return;
        }
        log("verify jar skipped because the version is invalid [" + this.G + "]", 1);
    }

    public final void g(java.io.File file) {
        log("verify BAS " + file, 2);
        try {
            java.lang.String str = this.I + " " + file.getPath();
            org.apache.tools.ant.taskdefs.Java java = new org.apache.tools.ant.taskdefs.Java(getTask());
            java.setTaskName("verify");
            java.setClassname(VERIFY);
            java.createArg().setLine(str);
            org.apache.tools.ant.types.Path combinedClasspath = getCombinedClasspath();
            if (combinedClasspath != null) {
                java.setClasspath(combinedClasspath);
                java.setFork(true);
            }
            log("Calling com.inprise.ejb.util.Verify for " + file.toString(), 3);
            java.execute();
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while calling com.inprise.ejb.util.Verify Details: " + e.toString(), e);
        }
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler getBorlandDescriptorHandler(java.io.File file) {
        org.apache.tools.ant.taskdefs.optional.ejb.BorlandDeploymentTool.AnonymousClass1 anonymousClass1 = new org.apache.tools.ant.taskdefs.optional.ejb.BorlandDeploymentTool.AnonymousClass1(getTask(), file, file);
        java.lang.String str = this.C;
        if (str == null) {
            str = DEFAULT_BAS_DTD_LOCATION;
        }
        anonymousClass1.registerDTD(PUBLICID_BORLAND_EJB, str);
        java.util.Iterator it = getConfig().h.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation dTDLocation = (org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation) it.next();
            anonymousClass1.registerDTD(dTDLocation.getPublicId(), dTDLocation.getLocation());
        }
        return anonymousClass1;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.io.File getVendorOutputJarFile(java.lang.String str) {
        return new java.io.File(getDestDir(), str + this.B);
    }

    public final void h(java.io.File file) {
        log("verify BES " + file, 2);
        try {
            org.apache.tools.ant.taskdefs.ExecTask execTask = new org.apache.tools.ant.taskdefs.ExecTask(getTask());
            execTask.setDir(new java.io.File("."));
            execTask.setExecutable("iastool");
            if (getCombinedClasspath() != null) {
                execTask.createArg().setValue("-VBJclasspath");
                execTask.createArg().setValue(getCombinedClasspath().toString());
            }
            if (this.D) {
                execTask.createArg().setValue("-debug");
            }
            execTask.createArg().setValue("-verify");
            execTask.createArg().setValue("-src");
            execTask.createArg().setValue(file.getPath());
            log("Calling iastool", 3);
            execTask.execute();
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while calling generateclient Details: " + e.toString(), e);
        }
    }

    public void setBASdtd(java.lang.String str) {
        this.C = str;
    }

    public void setDebug(boolean z) {
        this.D = z;
    }

    public void setGenerateclient(boolean z) {
        this.F = z;
    }

    public void setJava2iiopParams(java.lang.String str) {
        this.E = str;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessErrorStream(java.io.InputStream inputStream) throws java.io.IOException {
        java.lang.String readLine = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream)).readLine();
        if (readLine != null) {
            log("[java2iiop] " + readLine, 0);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessInputStream(java.io.OutputStream outputStream) throws java.io.IOException {
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessOutputStream(java.io.InputStream inputStream) throws java.io.IOException {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return;
                } else if (readLine.endsWith(".java")) {
                    java.lang.String e = e(readLine);
                    this.J.put(e.substring(getConfig().a.getAbsolutePath().length() + 1), new java.io.File(e));
                }
            }
        } catch (java.lang.Exception e2) {
            throw new org.apache.tools.ant.BuildException("Exception while parsing  java2iiop output. Details: " + e2.toString(), e2);
        }
    }

    public void setSuffix(java.lang.String str) {
        this.B = str;
    }

    public void setVerify(boolean z) {
        this.H = z;
    }

    public void setVerifyArgs(java.lang.String str) {
        this.I = str;
    }

    public void setVersion(int i) {
        this.G = i;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void start() throws java.io.IOException {
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void stop() {
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void writeJar(java.lang.String str, java.io.File file, java.util.Hashtable hashtable, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        java.util.Vector vector = new java.util.Vector();
        for (java.lang.String str3 : hashtable.keySet()) {
            if (str3.endsWith("Home.class")) {
                java.lang.String d = d(str3);
                vector.add(d);
                log(" Home " + d, 3);
            }
        }
        b(vector.iterator());
        hashtable.putAll(this.J);
        super.writeJar(str, file, hashtable, str2);
        if (this.H) {
            f(file);
        }
        if (this.F) {
            c(file);
        }
        this.J.clear();
    }
}
