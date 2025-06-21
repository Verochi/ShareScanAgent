package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class Rpm extends org.apache.tools.ant.Task {
    public java.io.File B;
    public java.io.File C;
    public java.lang.String u;
    public java.io.File v;
    public java.lang.String w = "-bb";
    public java.lang.String x = null;
    public boolean y = false;
    public boolean z = false;
    public boolean A = false;
    public boolean D = false;
    public boolean E = false;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.FileOutputStream fileOutputStream;
        java.io.OutputStream printStream;
        java.io.FileOutputStream fileOutputStream2;
        java.io.OutputStream printStream2;
        org.apache.tools.ant.taskdefs.PumpStreamHandler pumpStreamHandler;
        java.io.OutputStream outputStream;
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        java.lang.String str = this.x;
        if (str == null) {
            str = guessRpmBuildCommand();
        }
        commandline.setExecutable(str);
        if (this.v != null) {
            commandline.createArgument().setValue("--define");
            commandline.createArgument().setValue("_topdir " + this.v);
        }
        commandline.createArgument().setLine(this.w);
        if (this.y) {
            commandline.createArgument().setValue("--clean");
        }
        if (this.z) {
            commandline.createArgument().setValue("--rmspec");
        }
        if (this.A) {
            commandline.createArgument().setValue("--rmsource");
        }
        commandline.createArgument().setValue("SPECS/" + this.u);
        java.io.OutputStream outputStream2 = null;
        if (this.C == null && this.B == null) {
            pumpStreamHandler = !this.E ? new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 2, 1) : new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 4, 4);
            outputStream = null;
        } else {
            if (this.B != null) {
                try {
                    fileOutputStream = new java.io.FileOutputStream(this.B);
                } catch (java.io.IOException e) {
                    e = e;
                }
                try {
                    printStream = new java.io.PrintStream(new java.io.BufferedOutputStream(fileOutputStream));
                } catch (java.io.IOException e2) {
                    e = e2;
                    outputStream2 = fileOutputStream;
                    org.apache.tools.ant.util.FileUtils.close(outputStream2);
                    throw new org.apache.tools.ant.BuildException(e, getLocation());
                }
            } else {
                printStream = !this.E ? new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 2) : new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 4);
            }
            if (this.C != null) {
                try {
                    fileOutputStream2 = new java.io.FileOutputStream(this.C);
                } catch (java.io.IOException e3) {
                    e = e3;
                }
                try {
                    printStream2 = new java.io.PrintStream(new java.io.BufferedOutputStream(fileOutputStream2));
                } catch (java.io.IOException e4) {
                    e = e4;
                    outputStream2 = fileOutputStream2;
                    org.apache.tools.ant.util.FileUtils.close(outputStream2);
                    throw new org.apache.tools.ant.BuildException(e, getLocation());
                }
            } else {
                printStream2 = !this.E ? new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 1) : new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 4);
            }
            pumpStreamHandler = new org.apache.tools.ant.taskdefs.PumpStreamHandler(printStream, printStream2);
            outputStream = printStream2;
            outputStream2 = printStream;
        }
        org.apache.tools.ant.taskdefs.Execute execute = getExecute(commandline, pumpStreamHandler);
        try {
            try {
                log("Building the RPM based on the " + this.u + " file");
                int execute2 = execute.execute();
                if (org.apache.tools.ant.taskdefs.Execute.isFailure(execute2)) {
                    java.lang.String str2 = "'" + commandline.getExecutable() + "' failed with exit code " + execute2;
                    if (this.D) {
                        throw new org.apache.tools.ant.BuildException(str2);
                    }
                    log(str2, 0);
                }
            } finally {
                org.apache.tools.ant.util.FileUtils.close(outputStream2);
                org.apache.tools.ant.util.FileUtils.close(outputStream);
            }
        } catch (java.io.IOException e5) {
            throw new org.apache.tools.ant.BuildException(e5, getLocation());
        }
    }

    public org.apache.tools.ant.taskdefs.Execute getExecute(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.taskdefs.ExecuteStreamHandler executeStreamHandler) {
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(executeStreamHandler, null);
        execute.setAntRun(getProject());
        if (this.v == null) {
            this.v = getProject().getBaseDir();
        }
        execute.setWorkingDirectory(this.v);
        execute.setCommandline(commandline.getCommandline());
        return execute;
    }

    public java.lang.String guessRpmBuildCommand() {
        java.util.Map<java.lang.String, java.lang.String> environmentVariables = org.apache.tools.ant.taskdefs.Execute.getEnvironmentVariables();
        java.lang.String str = environmentVariables.get("PATH");
        if (str == null && (str = environmentVariables.get("Path")) == null) {
            str = environmentVariables.get("path");
        }
        if (str == null) {
            return "rpm";
        }
        java.lang.String[] list = new org.apache.tools.ant.types.Path(getProject(), str).list();
        for (java.lang.String str2 : list) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("rpmbuild");
            sb.append(org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS) ? ".exe" : "");
            java.io.File file = new java.io.File(str2, sb.toString());
            if (file.canRead()) {
                return file.getAbsolutePath();
            }
        }
        return "rpm";
    }

    public void setCleanBuildDir(boolean z) {
        this.y = z;
    }

    public void setCommand(java.lang.String str) {
        this.w = str;
    }

    public void setError(java.io.File file) {
        this.C = file;
    }

    public void setFailOnError(boolean z) {
        this.D = z;
    }

    public void setOutput(java.io.File file) {
        this.B = file;
    }

    public void setQuiet(boolean z) {
        this.E = z;
    }

    public void setRemoveSource(boolean z) {
        this.A = z;
    }

    public void setRemoveSpec(boolean z) {
        this.z = z;
    }

    public void setRpmBuildCommand(java.lang.String str) {
        this.x = str;
    }

    public void setSpecFile(java.lang.String str) {
        if (str == null || str.trim().length() == 0) {
            throw new org.apache.tools.ant.BuildException("You must specify a spec file", getLocation());
        }
        this.u = str;
    }

    public void setTopDir(java.io.File file) {
        this.v = file;
    }
}
