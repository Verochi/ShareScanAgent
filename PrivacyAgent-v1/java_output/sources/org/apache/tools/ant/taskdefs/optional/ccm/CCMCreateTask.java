package org.apache.tools.ant.taskdefs.optional.ccm;

/* loaded from: classes25.dex */
public class CCMCreateTask extends org.apache.tools.ant.taskdefs.optional.ccm.Continuus implements org.apache.tools.ant.taskdefs.ExecuteStreamHandler {
    public static final java.lang.String FLAG_COMMENT = "/synopsis";
    public static final java.lang.String FLAG_PLATFORM = "/plat";
    public static final java.lang.String FLAG_RELEASE = "/release";
    public static final java.lang.String FLAG_RESOLVER = "/resolver";
    public static final java.lang.String FLAG_SUBSYSTEM = "/subsystem";
    public static final java.lang.String FLAG_TASK = "/task";
    public java.lang.String w = null;
    public java.lang.String x = null;
    public java.lang.String y = null;
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;

    public CCMCreateTask() {
        setCcmAction(org.apache.tools.ant.taskdefs.optional.ccm.Continuus.COMMAND_CREATE_TASK);
    }

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() != null) {
            commandline.createArgument().setValue(FLAG_COMMENT);
            commandline.createArgument().setValue("\"" + getComment() + "\"");
        }
        if (getPlatform() != null) {
            commandline.createArgument().setValue(FLAG_PLATFORM);
            commandline.createArgument().setValue(getPlatform());
        }
        if (getResolver() != null) {
            commandline.createArgument().setValue(FLAG_RESOLVER);
            commandline.createArgument().setValue(getResolver());
        }
        if (getSubSystem() != null) {
            commandline.createArgument().setValue(FLAG_SUBSYSTEM);
            commandline.createArgument().setValue("\"" + getSubSystem() + "\"");
        }
        if (getRelease() != null) {
            commandline.createArgument().setValue(FLAG_RELEASE);
            commandline.createArgument().setValue(getRelease());
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(getCcmCommand());
        commandline.createArgument().setValue(getCcmAction());
        c(commandline);
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline, this))) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
        org.apache.tools.ant.types.Commandline commandline2 = new org.apache.tools.ant.types.Commandline();
        commandline2.setExecutable(getCcmCommand());
        commandline2.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.ccm.Continuus.COMMAND_DEFAULT_TASK);
        commandline2.createArgument().setValue(getTask());
        log(commandline.describeCommand(), 4);
        if (run(commandline2) == 0) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline2.toString(), getLocation());
    }

    public java.lang.String getComment() {
        return this.w;
    }

    public java.lang.String getPlatform() {
        return this.x;
    }

    public java.lang.String getRelease() {
        return this.z;
    }

    public java.lang.String getResolver() {
        return this.y;
    }

    public java.lang.String getSubSystem() {
        return this.A;
    }

    public java.lang.String getTask() {
        return this.B;
    }

    public void setComment(java.lang.String str) {
        this.w = str;
    }

    public void setPlatform(java.lang.String str) {
        this.x = str;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessErrorStream(java.io.InputStream inputStream) throws java.io.IOException {
        java.lang.String readLine = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream)).readLine();
        if (readLine != null) {
            log("err " + readLine, 4);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessInputStream(java.io.OutputStream outputStream) throws java.io.IOException {
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessOutputStream(java.io.InputStream inputStream) throws java.io.IOException {
        try {
            java.lang.String readLine = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream)).readLine();
            if (readLine != null) {
                log("buffer:" + readLine, 4);
                java.lang.String trim = readLine.substring(readLine.indexOf(32)).trim();
                setTask(trim.substring(0, trim.lastIndexOf(32)).trim());
                log("task is " + getTask(), 4);
            }
        } catch (java.lang.NullPointerException e) {
            log("error procession stream, null pointer exception", 0);
            log(org.apache.tools.ant.util.StringUtils.getStackTrace(e), 0);
            throw new org.apache.tools.ant.BuildException(e.getClass().getName());
        } catch (java.lang.Exception e2) {
            log("error procession stream " + e2.getMessage(), 0);
            throw new org.apache.tools.ant.BuildException(e2.getMessage());
        }
    }

    public void setRelease(java.lang.String str) {
        this.z = str;
    }

    public void setResolver(java.lang.String str) {
        this.y = str;
    }

    public void setSubSystem(java.lang.String str) {
        this.A = str;
    }

    public void setTask(java.lang.String str) {
        this.B = str;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void start() throws java.io.IOException {
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void stop() {
    }
}
