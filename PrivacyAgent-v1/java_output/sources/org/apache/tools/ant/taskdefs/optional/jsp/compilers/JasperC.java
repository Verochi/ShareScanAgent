package org.apache.tools.ant.taskdefs.optional.jsp.compilers;

/* loaded from: classes25.dex */
public class JasperC extends org.apache.tools.ant.taskdefs.optional.jsp.compilers.DefaultJspCompilerAdapter {
    public org.apache.tools.ant.taskdefs.optional.jsp.JspMangler b;

    public JasperC(org.apache.tools.ant.taskdefs.optional.jsp.JspMangler jspMangler) {
        this.b = jspMangler;
    }

    public final org.apache.tools.ant.types.Path a() {
        org.apache.tools.ant.types.Path classpath = getJspc().getClasspath();
        return classpath == null ? new org.apache.tools.ant.types.Path(getProject()).concatSystemClasspath(com.tencent.open.SocialConstants.PARAM_ONLY) : classpath.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
    }

    public final boolean b() {
        org.apache.tools.ant.AntClassLoader antClassLoader = null;
        try {
            antClassLoader = getProject().createClassLoader(a());
            antClassLoader.loadClass("org.apache.jasper.tagplugins.jstl.If");
            antClassLoader.cleanup();
            return true;
        } catch (java.lang.ClassNotFoundException unused) {
            if (antClassLoader == null) {
                return false;
            }
            antClassLoader.cleanup();
            return false;
        } catch (java.lang.Throwable th) {
            if (antClassLoader != null) {
                antClassLoader.cleanup();
            }
            throw th;
        }
    }

    public final org.apache.tools.ant.types.CommandlineJava c() {
        org.apache.tools.ant.types.CommandlineJava commandlineJava = new org.apache.tools.ant.types.CommandlineJava();
        org.apache.tools.ant.taskdefs.optional.jsp.JspC jspc = getJspc();
        addArg(commandlineJava, "-d", jspc.getDestdir());
        addArg(commandlineJava, "-p", jspc.getPackage());
        if (b()) {
            getProject().log("this task doesn't support Tomcat 5.x properly, please use the Tomcat provided jspc task instead");
        } else {
            addArg(commandlineJava, "-v" + jspc.getVerbose());
        }
        addArg(commandlineJava, "-uriroot", jspc.getUriroot());
        addArg(commandlineJava, "-uribase", jspc.getUribase());
        addArg(commandlineJava, "-ieplugin", jspc.getIeplugin());
        addArg(commandlineJava, "-webinc", jspc.getWebinc());
        addArg(commandlineJava, "-webxml", jspc.getWebxml());
        addArg(commandlineJava, "-die9");
        if (jspc.isMapped()) {
            addArg(commandlineJava, "-mapped");
        }
        if (jspc.getWebApp() != null) {
            addArg(commandlineJava, "-webapp", jspc.getWebApp().getDirectory());
        }
        logAndAddFilesToCompile(getJspc(), getJspc().getCompileList(), commandlineJava);
        return commandlineJava;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter
    public org.apache.tools.ant.taskdefs.optional.jsp.JspMangler createMangler() {
        return this.b;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        getJspc().log("Using jasper compiler", 3);
        org.apache.tools.ant.types.CommandlineJava c = c();
        try {
            try {
                org.apache.tools.ant.taskdefs.Java java = new org.apache.tools.ant.taskdefs.Java(this.owner);
                org.apache.tools.ant.types.Path a = a();
                if (getJspc().getClasspath() != null) {
                    getProject().log("using user supplied classpath: " + a, 4);
                } else {
                    getProject().log("using system classpath: " + a, 4);
                }
                java.setClasspath(a);
                java.setDir(getProject().getBaseDir());
                java.setClassname("org.apache.jasper.JspC");
                for (java.lang.String str : c.getJavaCommand().getArguments()) {
                    java.createArg().setValue(str);
                }
                java.setFailonerror(getJspc().getFailonerror());
                java.setFork(true);
                java.setTaskName("jasperc");
                java.execute();
                return true;
            } catch (java.lang.Exception e) {
                if (e instanceof org.apache.tools.ant.BuildException) {
                    throw ((org.apache.tools.ant.BuildException) e);
                }
                throw new org.apache.tools.ant.BuildException("Error running jsp compiler: ", e, getJspc().getLocation());
            }
        } finally {
            getJspc().deleteEmptyJavaFiles();
        }
    }
}
