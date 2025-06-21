package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public abstract class AbstractCvsTask extends org.apache.tools.ant.Task {
    public static final int DEFAULT_COMPRESSION_LEVEL = 3;
    public java.lang.String A;
    public java.io.File I;
    public java.io.File K;
    public java.io.File L;
    public org.apache.tools.ant.taskdefs.ExecuteStreamHandler N;
    public java.io.OutputStream O;
    public java.io.OutputStream P;
    public java.lang.String x;
    public java.lang.String y;
    public java.lang.String z;
    public org.apache.tools.ant.types.Commandline u = new org.apache.tools.ant.types.Commandline();
    public java.util.ArrayList<org.apache.tools.ant.taskdefs.AbstractCvsTask.Module> v = new java.util.ArrayList<>();
    public java.util.Vector<org.apache.tools.ant.types.Commandline> w = new java.util.Vector<>();
    public java.lang.String B = null;
    public boolean C = false;
    public boolean D = false;
    public int E = 0;
    public boolean F = false;
    public int G = 0;
    public java.io.File H = null;
    public boolean J = false;
    public boolean M = false;

    public static final class Module {
        public java.lang.String a;

        public java.lang.String getName() {
            return this.a;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }
    }

    public void addCommandArgument(java.lang.String str) {
        addCommandArgument(this.u, str);
    }

    public void addCommandArgument(org.apache.tools.ant.types.Commandline commandline, java.lang.String str) {
        commandline.createArgument().setValue(str);
    }

    public void addConfiguredCommandline(org.apache.tools.ant.types.Commandline commandline) {
        addConfiguredCommandline(commandline, false);
    }

    public void addConfiguredCommandline(org.apache.tools.ant.types.Commandline commandline, boolean z) {
        if (commandline == null) {
            return;
        }
        configureCommandline(commandline);
        if (z) {
            this.w.insertElementAt(commandline, 0);
        } else {
            this.w.addElement(commandline);
        }
    }

    public void addModule(org.apache.tools.ant.taskdefs.AbstractCvsTask.Module module) {
        this.v.add(module);
    }

    public final java.lang.String c(org.apache.tools.ant.taskdefs.Execute execute) {
        java.lang.StringBuffer d = d(org.apache.tools.ant.types.Commandline.describeCommand(execute.getCommandline()));
        java.lang.String str = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        java.lang.String[] environment = execute.getEnvironment();
        if (environment != null) {
            d.append(str);
            d.append(str);
            d.append("environment:");
            d.append(str);
            for (java.lang.String str2 : environment) {
                d.append(str);
                d.append("\t");
                d.append(str2);
            }
        }
        return d.toString();
    }

    public void configureCommandline(org.apache.tools.ant.types.Commandline commandline) {
        if (commandline == null) {
            return;
        }
        commandline.setExecutable("cvs");
        if (this.z != null) {
            commandline.createArgument().setLine(this.z);
        }
        java.util.Iterator<org.apache.tools.ant.taskdefs.AbstractCvsTask.Module> it = this.v.iterator();
        while (it.hasNext()) {
            commandline.createArgument().setValue(it.next().getName());
        }
        int i = this.E;
        if (i > 0 && i <= 9) {
            commandline.createArgument(true).setValue("-z" + this.E);
        }
        if (this.C && !this.D) {
            commandline.createArgument(true).setValue("-q");
        }
        if (this.D) {
            commandline.createArgument(true).setValue("-Q");
        }
        if (this.F) {
            commandline.createArgument(true).setValue("-n");
        }
        if (this.x != null) {
            commandline.createArgument(true).setLine("-d" + this.x);
        }
    }

    public final java.lang.StringBuffer d(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
        int indexOf = str.indexOf("-d:");
        if (indexOf >= 0) {
            str.indexOf("@", indexOf);
            int indexOf2 = str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, indexOf);
            int indexOf3 = str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, indexOf2 + 1) + 1);
            int indexOf4 = str.indexOf("@", indexOf);
            if (indexOf4 >= 0 && indexOf3 > indexOf2 && indexOf3 < indexOf4) {
                int i = indexOf3 + 1;
                while (i < indexOf4) {
                    int i2 = i + 1;
                    stringBuffer.replace(i, i2, "*");
                    i = i2;
                }
            }
        }
        return stringBuffer;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline;
        java.lang.String command = getCommand();
        if (getCommand() == null && this.w.size() == 0) {
            setCommand(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_CHECKOUT);
        }
        java.lang.String command2 = getCommand();
        if (command2 != null) {
            commandline = (org.apache.tools.ant.types.Commandline) this.u.clone();
            commandline.createArgument(true).setLine(command2);
            addConfiguredCommandline(commandline, true);
        } else {
            commandline = null;
        }
        try {
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                runCommand(this.w.elementAt(i));
            }
        } finally {
            if (commandline != null) {
                removeCommandline(commandline);
            }
            setCommand(command);
            org.apache.tools.ant.util.FileUtils.close(this.O);
            org.apache.tools.ant.util.FileUtils.close(this.P);
        }
    }

    public java.lang.String getCommand() {
        return this.B;
    }

    public java.lang.String getCvsRoot() {
        return this.x;
    }

    public java.lang.String getCvsRsh() {
        return this.y;
    }

    public java.io.File getDest() {
        return this.I;
    }

    public java.io.OutputStream getErrorStream() {
        if (this.P == null) {
            if (this.L != null) {
                try {
                    setErrorStream(new java.io.PrintStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(this.L.getPath(), this.J))));
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException(e, getLocation());
                }
            } else {
                setErrorStream(new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 1));
            }
        }
        return this.P;
    }

    public org.apache.tools.ant.taskdefs.ExecuteStreamHandler getExecuteStreamHandler() {
        if (this.N == null) {
            setExecuteStreamHandler(new org.apache.tools.ant.taskdefs.PumpStreamHandler(getOutputStream(), getErrorStream()));
        }
        return this.N;
    }

    public java.util.List<org.apache.tools.ant.taskdefs.AbstractCvsTask.Module> getModules() {
        return (java.util.List) this.v.clone();
    }

    public java.io.OutputStream getOutputStream() {
        if (this.O == null) {
            if (this.K != null) {
                try {
                    setOutputStream(new java.io.PrintStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(this.K.getPath(), this.J))));
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException(e, getLocation());
                }
            } else {
                setOutputStream(new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 2));
            }
        }
        return this.O;
    }

    public java.lang.String getPackage() {
        return this.z;
    }

    public java.io.File getPassFile() {
        return this.H;
    }

    public int getPort() {
        return this.G;
    }

    public java.lang.String getTag() {
        return this.A;
    }

    public void removeCommandline(org.apache.tools.ant.types.Commandline commandline) {
        this.w.removeElement(commandline);
    }

    public void runCommand(org.apache.tools.ant.types.Commandline commandline) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Environment environment = new org.apache.tools.ant.types.Environment();
        if (this.G > 0) {
            org.apache.tools.ant.types.Environment.Variable variable = new org.apache.tools.ant.types.Environment.Variable();
            variable.setKey("CVS_CLIENT_PORT");
            variable.setValue(java.lang.String.valueOf(this.G));
            environment.addVariable(variable);
            org.apache.tools.ant.types.Environment.Variable variable2 = new org.apache.tools.ant.types.Environment.Variable();
            variable2.setKey("CVS_PSERVER_PORT");
            variable2.setValue(java.lang.String.valueOf(this.G));
            environment.addVariable(variable2);
        }
        if (this.H == null) {
            java.io.File file = new java.io.File(java.lang.System.getProperty("cygwin.user.home", java.lang.System.getProperty(org.apache.tools.ant.launch.Launcher.USER_HOMEDIR)) + java.io.File.separatorChar + ".cvspass");
            if (file.exists()) {
                setPassfile(file);
            }
        }
        java.io.File file2 = this.H;
        if (file2 != null) {
            if (file2.isFile() && this.H.canRead()) {
                org.apache.tools.ant.types.Environment.Variable variable3 = new org.apache.tools.ant.types.Environment.Variable();
                variable3.setKey("CVS_PASSFILE");
                variable3.setValue(java.lang.String.valueOf(this.H));
                environment.addVariable(variable3);
                log("Using cvs passfile: " + java.lang.String.valueOf(this.H), 3);
            } else if (this.H.canRead()) {
                log("cvs passfile: " + java.lang.String.valueOf(this.H) + " ignored as it is not a file", 1);
            } else {
                log("cvs passfile: " + java.lang.String.valueOf(this.H) + " ignored as it is not readable", 1);
            }
        }
        if (this.y != null) {
            org.apache.tools.ant.types.Environment.Variable variable4 = new org.apache.tools.ant.types.Environment.Variable();
            variable4.setKey("CVS_RSH");
            variable4.setValue(java.lang.String.valueOf(this.y));
            environment.addVariable(variable4);
        }
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(getExecuteStreamHandler(), null);
        execute.setAntRun(getProject());
        if (this.I == null) {
            this.I = getProject().getBaseDir();
        }
        if (!this.I.exists()) {
            this.I.mkdirs();
        }
        execute.setWorkingDirectory(this.I);
        execute.setCommandline(commandline.getCommandline());
        execute.setEnvironment(environment.getVariables());
        try {
            java.lang.String c = c(execute);
            log(c, 3);
            int execute2 = execute.execute();
            log("retCode=" + execute2, 4);
            if (this.M && org.apache.tools.ant.taskdefs.Execute.isFailure(execute2)) {
                throw new org.apache.tools.ant.BuildException("cvs exited with error code " + execute2 + org.apache.tools.ant.util.StringUtils.LINE_SEP + "Command line was [" + c + "]", getLocation());
            }
        } catch (java.io.IOException e) {
            if (this.M) {
                throw new org.apache.tools.ant.BuildException(e, getLocation());
            }
            log("Caught exception: " + e.getMessage(), 1);
        } catch (org.apache.tools.ant.BuildException e2) {
            e = e2;
            if (this.M) {
                throw e;
            }
            java.lang.Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            log("Caught exception: " + e.getMessage(), 1);
        } catch (java.lang.Exception e3) {
            if (this.M) {
                throw new org.apache.tools.ant.BuildException(e3, getLocation());
            }
            log("Caught exception: " + e3.getMessage(), 1);
        }
    }

    public void setAppend(boolean z) {
        this.J = z;
    }

    public void setCommand(java.lang.String str) {
        this.B = str;
    }

    public void setCompression(boolean z) {
        setCompressionLevel(z ? 3 : 0);
    }

    public void setCompressionLevel(int i) {
        this.E = i;
    }

    public void setCvsRoot(java.lang.String str) {
        if (str != null && str.trim().equals("")) {
            str = null;
        }
        this.x = str;
    }

    public void setCvsRsh(java.lang.String str) {
        if (str != null && str.trim().equals("")) {
            str = null;
        }
        this.y = str;
    }

    public void setDate(java.lang.String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        addCommandArgument(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_CODEDIFF);
        addCommandArgument(str);
    }

    public void setDest(java.io.File file) {
        this.I = file;
    }

    public void setError(java.io.File file) {
        this.L = file;
    }

    public void setErrorStream(java.io.OutputStream outputStream) {
        this.P = outputStream;
    }

    public void setExecuteStreamHandler(org.apache.tools.ant.taskdefs.ExecuteStreamHandler executeStreamHandler) {
        this.N = executeStreamHandler;
    }

    public void setFailOnError(boolean z) {
        this.M = z;
    }

    public void setNoexec(boolean z) {
        this.F = z;
    }

    public void setOutput(java.io.File file) {
        this.K = file;
    }

    public void setOutputStream(java.io.OutputStream outputStream) {
        this.O = outputStream;
    }

    public void setPackage(java.lang.String str) {
        this.z = str;
    }

    public void setPassfile(java.io.File file) {
        this.H = file;
    }

    public void setPort(int i) {
        this.G = i;
    }

    public void setQuiet(boolean z) {
        this.C = z;
    }

    public void setReallyquiet(boolean z) {
        this.D = z;
    }

    public void setTag(java.lang.String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        this.A = str;
        addCommandArgument("-r" + str);
    }
}
