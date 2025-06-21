package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ExecuteJava implements java.lang.Runnable, org.apache.tools.ant.util.TimeoutObserver {
    public org.apache.tools.ant.types.Commandline n = null;
    public org.apache.tools.ant.types.Path t = null;
    public org.apache.tools.ant.types.CommandlineJava.SysProperties u = null;
    public org.apache.tools.ant.types.Permissions v = null;
    public java.lang.reflect.Method w = null;
    public java.lang.Long x = null;
    public volatile java.lang.Throwable y = null;
    public volatile boolean z = false;
    public boolean A = false;
    public java.lang.Thread B = null;

    public static void setupCommandLineForVMS(org.apache.tools.ant.taskdefs.Execute execute, java.lang.String[] strArr) {
        execute.setVMLauncher(true);
        try {
            java.lang.String[] strArr2 = new java.lang.String[strArr.length - 1];
            java.lang.System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
            java.io.File createVmsJavaOptionFile = org.apache.tools.ant.util.JavaEnvUtils.createVmsJavaOptionFile(strArr2);
            createVmsJavaOptionFile.deleteOnExit();
            execute.setCommandline(new java.lang.String[]{strArr[0], org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION, createVmsJavaOptionFile.getPath()});
        } catch (java.io.IOException unused) {
            throw new org.apache.tools.ant.BuildException("Failed to create a temporary file for \"-V\" switch");
        }
    }

    public void execute(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.AntClassLoader antClassLoader;
        java.lang.Class<?> cls;
        java.lang.String executable = this.n.getExecutable();
        org.apache.tools.ant.AntClassLoader antClassLoader2 = null;
        try {
            try {
                org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties = this.u;
                if (sysProperties != null) {
                    sysProperties.setSystem();
                }
                try {
                    org.apache.tools.ant.types.Path path = this.t;
                    if (path == null) {
                        cls = java.lang.Class.forName(executable);
                        antClassLoader = null;
                    } else {
                        org.apache.tools.ant.AntClassLoader createClassLoader = project.createClassLoader(path);
                        try {
                            createClassLoader.setParent(project.getCoreLoader());
                            createClassLoader.setParentFirst(false);
                            createClassLoader.addJavaLibraries();
                            createClassLoader.setIsolated(true);
                            createClassLoader.setThreadContextLoader();
                            createClassLoader.forceLoadClass(executable);
                            antClassLoader = createClassLoader;
                            cls = java.lang.Class.forName(executable, true, createClassLoader);
                        } catch (java.lang.ClassNotFoundException unused) {
                            throw new org.apache.tools.ant.BuildException("Could not find " + executable + ". Make sure you have it in your classpath");
                        } catch (java.lang.SecurityException e) {
                            throw e;
                        } catch (java.lang.ThreadDeath e2) {
                            throw e2;
                        } catch (org.apache.tools.ant.BuildException e3) {
                            throw e3;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            throw new org.apache.tools.ant.BuildException(th);
                        }
                    }
                } catch (java.lang.ClassNotFoundException unused2) {
                }
            } catch (java.lang.Throwable th2) {
                if (0 != 0) {
                    antClassLoader2.resetThreadContextLoader();
                    antClassLoader2.cleanup();
                }
                org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties2 = this.u;
                if (sysProperties2 != null) {
                    sysProperties2.restoreSystem();
                }
                throw th2;
            }
        } catch (java.lang.SecurityException e4) {
            throw e4;
        } catch (java.lang.ThreadDeath e5) {
            throw e5;
        } catch (org.apache.tools.ant.BuildException e6) {
            throw e6;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        try {
            java.lang.reflect.Method method = cls.getMethod("main", java.lang.String[].class);
            this.w = method;
            if (method == null) {
                throw new org.apache.tools.ant.BuildException("Could not find main() method in " + executable);
            }
            if ((method.getModifiers() & 8) == 0) {
                throw new org.apache.tools.ant.BuildException("main() method in " + executable + " is not declared static");
            }
            if (this.x == null) {
                run();
            } else {
                this.B = new java.lang.Thread(this, "ExecuteJava");
                project.registerThreadTask(this.B, project.getThreadTask(java.lang.Thread.currentThread()));
                this.B.setDaemon(true);
                org.apache.tools.ant.util.Watchdog watchdog = new org.apache.tools.ant.util.Watchdog(this.x.longValue());
                watchdog.addTimeoutObserver(this);
                synchronized (this) {
                    this.B.start();
                    watchdog.start();
                    while (!this.A) {
                        try {
                            wait();
                        } catch (java.lang.InterruptedException unused3) {
                        }
                    }
                    if (this.z) {
                        project.log("Timeout: sub-process interrupted", 1);
                    } else {
                        this.B = null;
                        watchdog.stop();
                    }
                }
            }
            if (this.y != null) {
                throw this.y;
            }
            if (antClassLoader != null) {
                antClassLoader.resetThreadContextLoader();
                antClassLoader.cleanup();
            }
            org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties3 = this.u;
            if (sysProperties3 != null) {
                sysProperties3.restoreSystem();
            }
        } catch (java.lang.SecurityException e7) {
        } catch (java.lang.ThreadDeath e8) {
        } catch (org.apache.tools.ant.BuildException e9) {
        } catch (java.lang.Throwable th4) {
            th = th4;
            throw new org.apache.tools.ant.BuildException(th);
        }
    }

    public int fork(org.apache.tools.ant.ProjectComponent projectComponent) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.CommandlineJava commandlineJava = new org.apache.tools.ant.types.CommandlineJava();
        commandlineJava.setClassname(this.n.getExecutable());
        for (java.lang.String str : this.n.getArguments()) {
            commandlineJava.createArgument().setValue(str);
        }
        if (this.t != null) {
            commandlineJava.createClasspath(projectComponent.getProject()).append(this.t);
        }
        org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties = this.u;
        if (sysProperties != null) {
            commandlineJava.addSysproperties(sysProperties);
        }
        org.apache.tools.ant.taskdefs.Redirector redirector = new org.apache.tools.ant.taskdefs.Redirector(projectComponent);
        org.apache.tools.ant.taskdefs.ExecuteStreamHandler createHandler = redirector.createHandler();
        java.lang.Long l = this.x;
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(createHandler, l == null ? null : new org.apache.tools.ant.taskdefs.ExecuteWatchdog(l.longValue()));
        execute.setAntRun(projectComponent.getProject());
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
            setupCommandLineForVMS(execute, commandlineJava.getCommandline());
        } else {
            execute.setCommandline(commandlineJava.getCommandline());
        }
        try {
            try {
                int execute2 = execute.execute();
                redirector.complete();
                return execute2;
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        } finally {
            this.z = execute.killedProcess();
        }
    }

    public synchronized boolean killedProcess() {
        return this.z;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.Object[] objArr = {this.n.getArguments()};
        try {
            try {
                org.apache.tools.ant.types.Permissions permissions = this.v;
                if (permissions != null) {
                    permissions.setSecurityManager();
                }
                this.w.invoke(null, objArr);
                org.apache.tools.ant.types.Permissions permissions2 = this.v;
                if (permissions2 != null) {
                    permissions2.restoreSecurityManager();
                }
                synchronized (this) {
                    this.A = true;
                    notifyAll();
                }
            } catch (java.lang.Throwable th) {
                org.apache.tools.ant.types.Permissions permissions3 = this.v;
                if (permissions3 != null) {
                    permissions3.restoreSecurityManager();
                }
                synchronized (this) {
                    this.A = true;
                    notifyAll();
                    throw th;
                }
            }
        } catch (java.lang.reflect.InvocationTargetException e) {
            java.lang.Throwable targetException = e.getTargetException();
            if (!(targetException instanceof java.lang.InterruptedException)) {
                this.y = targetException;
            }
            org.apache.tools.ant.types.Permissions permissions4 = this.v;
            if (permissions4 != null) {
                permissions4.restoreSecurityManager();
            }
            synchronized (this) {
                this.A = true;
                notifyAll();
            }
        } catch (java.lang.Throwable th2) {
            this.y = th2;
            org.apache.tools.ant.types.Permissions permissions5 = this.v;
            if (permissions5 != null) {
                permissions5.restoreSecurityManager();
            }
            synchronized (this) {
                this.A = true;
                notifyAll();
            }
        }
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        this.t = path;
    }

    public void setJavaCommand(org.apache.tools.ant.types.Commandline commandline) {
        this.n = commandline;
    }

    public void setOutput(java.io.PrintStream printStream) {
    }

    public void setPermissions(org.apache.tools.ant.types.Permissions permissions) {
        this.v = permissions;
    }

    public void setSystemProperties(org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties) {
        this.u = sysProperties;
    }

    public void setTimeout(java.lang.Long l) {
        this.x = l;
    }

    @Override // org.apache.tools.ant.util.TimeoutObserver
    public synchronized void timeoutOccured(org.apache.tools.ant.util.Watchdog watchdog) {
        if (this.B != null) {
            this.z = true;
            this.B.interrupt();
        }
        this.A = true;
        notifyAll();
    }
}
