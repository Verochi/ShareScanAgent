package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Exec extends org.apache.tools.ant.Task {
    public java.lang.String u;
    public java.lang.String v;
    public java.io.File w;
    public java.lang.String x;
    protected java.io.PrintWriter fos = null;
    public boolean y = false;

    public class StreamPumper extends java.lang.Thread {
        public java.io.BufferedReader n;
        public int t;
        public boolean u = false;

        public StreamPumper(java.io.InputStream inputStream, int i) {
            this.n = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
            this.t = i;
        }

        public void a() throws java.io.IOException {
            if (this.u) {
                return;
            }
            java.lang.String readLine = this.n.readLine();
            if (readLine != null) {
                org.apache.tools.ant.taskdefs.Exec.this.outputLog(readLine, this.t);
            } else {
                this.u = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.u) {
                try {
                    try {
                        a();
                        java.lang.Thread.sleep(5L);
                    } catch (java.io.IOException unused) {
                        return;
                    }
                } catch (java.lang.InterruptedException unused2) {
                }
            }
            this.n.close();
        }
    }

    public Exec() {
        java.lang.System.err.println("As of Ant 1.2 released in October 2000, the Exec class");
        java.lang.System.err.println("is considered to be dead code by the Ant developers and is unmaintained.");
        java.lang.System.err.println("Don't use it!");
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        run(this.x);
    }

    public void logFlush() {
        java.io.PrintWriter printWriter = this.fos;
        if (printWriter != null) {
            printWriter.close();
        }
    }

    public void outputLog(java.lang.String str, int i) {
        java.io.PrintWriter printWriter = this.fos;
        if (printWriter == null) {
            log(str, i);
        } else {
            printWriter.println(str);
        }
    }

    public int run(java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.lang.String property = java.lang.System.getProperty("os.name");
        log("Myos = " + property, 3);
        java.lang.String str2 = this.u;
        if (str2 != null && !str2.contains(property)) {
            log("Not found in " + this.u, 3);
            return 0;
        }
        if (this.w == null) {
            this.w = getProject().getBaseDir();
        }
        java.util.Locale locale = java.util.Locale.ENGLISH;
        if (!property.toLowerCase(locale).contains(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS)) {
            java.lang.String property2 = getProject().getProperty("ant.home");
            if (property2 == null) {
                throw new org.apache.tools.ant.BuildException("Property 'ant.home' not found", getLocation());
            }
            str = getProject().resolveFile(property2 + "/bin/antRun").toString() + " " + this.w + " " + str;
        } else if (!this.w.equals(getProject().resolveFile("."))) {
            if (property.toLowerCase(locale).contains("nt")) {
                str = "cmd /c cd " + this.w + " && " + str;
            } else {
                java.lang.String property3 = getProject().getProperty("ant.home");
                if (property3 == null) {
                    throw new org.apache.tools.ant.BuildException("Property 'ant.home' not found", getLocation());
                }
                str = getProject().resolveFile(property3 + "/bin/antRun.bat").toString() + " " + this.w + " " + str;
            }
        }
        int i = -1;
        try {
            log(str, 3);
            java.lang.Process exec = java.lang.Runtime.getRuntime().exec(str);
            if (this.v != null) {
                this.fos = new java.io.PrintWriter(new java.io.FileWriter(this.v));
                log("Output redirected to " + this.v, 3);
            }
            org.apache.tools.ant.taskdefs.Exec.StreamPumper streamPumper = new org.apache.tools.ant.taskdefs.Exec.StreamPumper(exec.getInputStream(), 2);
            org.apache.tools.ant.taskdefs.Exec.StreamPumper streamPumper2 = new org.apache.tools.ant.taskdefs.Exec.StreamPumper(exec.getErrorStream(), 1);
            streamPumper.start();
            streamPumper2.start();
            exec.waitFor();
            streamPumper.join();
            streamPumper2.join();
            exec.destroy();
            logFlush();
            i = exec.exitValue();
            if (i != 0) {
                if (this.y) {
                    throw new org.apache.tools.ant.BuildException("Exec returned: " + i, getLocation());
                }
                log("Result: " + i, 0);
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Error exec: " + str, e, getLocation());
        } catch (java.lang.InterruptedException unused) {
        }
        return i;
    }

    public void setCommand(java.lang.String str) {
        this.x = str;
    }

    public void setDir(java.lang.String str) {
        this.w = getProject().resolveFile(str);
    }

    public void setFailonerror(boolean z) {
        this.y = z;
    }

    public void setOs(java.lang.String str) {
        this.u = str;
    }

    public void setOutput(java.lang.String str) {
        this.v = str;
    }
}
