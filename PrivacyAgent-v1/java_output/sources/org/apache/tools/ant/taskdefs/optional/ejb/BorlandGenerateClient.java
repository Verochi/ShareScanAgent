package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class BorlandGenerateClient extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.Path x;
    public boolean u = false;
    public java.io.File v = null;
    public java.io.File w = null;
    public java.lang.String y = "fork";
    public int z = 4;

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.x.createPath();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.v;
        if (file == null || file.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("invalid ejb jar file.");
        }
        java.io.File file2 = this.w;
        if (file2 == null || file2.isDirectory()) {
            log("invalid or missing client jar file.", 3);
            java.lang.String absolutePath = this.v.getAbsolutePath();
            this.w = new java.io.File(absolutePath.substring(0, absolutePath.lastIndexOf(".")) + "client.jar");
        }
        if (this.y == null) {
            log("mode is null default mode  is java");
            setMode(com.uc.crashsdk.export.LogType.JAVA_TYPE);
        }
        int i = this.z;
        if (i != 5 && i != 4) {
            throw new org.apache.tools.ant.BuildException("version " + this.z + " is not supported");
        }
        log("client jar file is " + this.w);
        if (this.y.equalsIgnoreCase("fork")) {
            executeFork();
        } else {
            executeJava();
        }
    }

    public void executeFork() throws org.apache.tools.ant.BuildException {
        if (this.z == 4) {
            executeForkV4();
        }
        if (this.z == 5) {
            executeForkV5();
        }
    }

    public void executeForkV4() throws org.apache.tools.ant.BuildException {
        try {
            log("mode : fork 4", 4);
            org.apache.tools.ant.taskdefs.ExecTask execTask = new org.apache.tools.ant.taskdefs.ExecTask(this);
            execTask.setDir(new java.io.File("."));
            execTask.setExecutable("iastool");
            execTask.createArg().setValue("generateclient");
            if (this.u) {
                execTask.createArg().setValue("-trace");
            }
            execTask.createArg().setValue("-short");
            execTask.createArg().setValue("-jarfile");
            execTask.createArg().setValue(this.v.getAbsolutePath());
            execTask.createArg().setValue("-single");
            execTask.createArg().setValue("-clientjarfile");
            execTask.createArg().setValue(this.w.getAbsolutePath());
            log("Calling iastool", 3);
            execTask.execute();
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while calling generateclient Details: " + e.toString(), e);
        }
    }

    public void executeForkV5() throws org.apache.tools.ant.BuildException {
        try {
            log("mode : fork 5", 4);
            org.apache.tools.ant.taskdefs.ExecTask execTask = new org.apache.tools.ant.taskdefs.ExecTask(this);
            execTask.setDir(new java.io.File("."));
            execTask.setExecutable("iastool");
            if (this.u) {
                execTask.createArg().setValue("-debug");
            }
            execTask.createArg().setValue("-genclient");
            execTask.createArg().setValue("-jars");
            execTask.createArg().setValue(this.v.getAbsolutePath());
            execTask.createArg().setValue("-target");
            execTask.createArg().setValue(this.w.getAbsolutePath());
            execTask.createArg().setValue("-cp");
            execTask.createArg().setValue(this.x.toString());
            log("Calling iastool", 3);
            execTask.execute();
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while calling generateclient Details: " + e.toString(), e);
        }
    }

    public void executeJava() throws org.apache.tools.ant.BuildException {
        try {
            if (this.z == 5) {
                throw new org.apache.tools.ant.BuildException("java mode is supported only for previous version <=4");
            }
            log("mode : java");
            org.apache.tools.ant.taskdefs.Java java = new org.apache.tools.ant.taskdefs.Java(this);
            java.setDir(new java.io.File("."));
            java.setClassname("com.inprise.server.commandline.EJBUtilities");
            java.setClasspath(this.x.concatSystemClasspath());
            java.setFork(true);
            java.createArg().setValue("generateclient");
            if (this.u) {
                java.createArg().setValue("-trace");
            }
            java.createArg().setValue("-short");
            java.createArg().setValue("-jarfile");
            java.createArg().setValue(this.v.getAbsolutePath());
            java.createArg().setValue("-single");
            java.createArg().setValue("-clientjarfile");
            java.createArg().setValue(this.w.getAbsolutePath());
            log("Calling EJBUtilities", 3);
            java.execute();
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while calling generateclient Details: " + e.toString(), e);
        }
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.x;
        if (path2 == null) {
            this.x = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setClientjar(java.io.File file) {
        this.w = file;
    }

    public void setDebug(boolean z) {
        this.u = z;
    }

    public void setEjbjar(java.io.File file) {
        this.v = file;
    }

    public void setMode(java.lang.String str) {
        this.y = str;
    }

    public void setVersion(int i) {
        this.z = i;
    }
}
