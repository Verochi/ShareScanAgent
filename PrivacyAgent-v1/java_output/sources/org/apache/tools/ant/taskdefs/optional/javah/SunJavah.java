package org.apache.tools.ant.taskdefs.optional.javah;

/* loaded from: classes25.dex */
public class SunJavah implements org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter {
    public static final java.lang.String IMPLEMENTATION_NAME = "sun";

    public static org.apache.tools.ant.types.Commandline a(org.apache.tools.ant.taskdefs.optional.Javah javah) {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        if (javah.getDestdir() != null) {
            commandline.createArgument().setValue("-d");
            commandline.createArgument().setFile(javah.getDestdir());
        }
        if (javah.getOutputfile() != null) {
            commandline.createArgument().setValue("-o");
            commandline.createArgument().setFile(javah.getOutputfile());
        }
        if (javah.getClasspath() != null) {
            commandline.createArgument().setValue("-classpath");
            commandline.createArgument().setPath(javah.getClasspath());
        }
        if (javah.getVerbose()) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE);
        }
        if (javah.getOld()) {
            commandline.createArgument().setValue("-old");
        }
        if (javah.getForce()) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.CCRmtype.FLAG_FORCE);
        }
        if (javah.getStubs() && !javah.getOld()) {
            throw new org.apache.tools.ant.BuildException("stubs only available in old mode.", javah.getLocation());
        }
        if (javah.getStubs()) {
            commandline.createArgument().setValue("-stubs");
        }
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(javah.getProject());
        if (javah.getBootclasspath() != null) {
            path.append(javah.getBootclasspath());
        }
        org.apache.tools.ant.types.Path concatSystemBootClasspath = path.concatSystemBootClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
        if (concatSystemBootClasspath.size() > 0) {
            commandline.createArgument().setValue("-bootclasspath");
            commandline.createArgument().setPath(concatSystemBootClasspath);
        }
        commandline.addArguments(javah.getCurrentArgs());
        javah.logAndAddFiles(commandline);
        return commandline;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter
    public boolean compile(org.apache.tools.ant.taskdefs.optional.Javah javah) throws org.apache.tools.ant.BuildException {
        java.lang.Class<?> cls;
        org.apache.tools.ant.types.Commandline a = a(javah);
        org.apache.tools.ant.taskdefs.ExecuteJava executeJava = new org.apache.tools.ant.taskdefs.ExecuteJava();
        try {
            try {
                cls = java.lang.Class.forName("com.sun.tools.javah.oldjavah.Main");
            } catch (java.lang.ClassNotFoundException e) {
                throw new org.apache.tools.ant.BuildException("Can't load javah", e, javah.getLocation());
            }
        } catch (java.lang.ClassNotFoundException unused) {
            cls = java.lang.Class.forName("com.sun.tools.javah.Main");
        }
        a.setExecutable(cls.getName());
        executeJava.setJavaCommand(a);
        java.io.File classSource = org.apache.tools.ant.launch.Locator.getClassSource(cls);
        if (classSource != null) {
            executeJava.setClasspath(new org.apache.tools.ant.types.Path(javah.getProject(), classSource.getPath()));
        }
        return executeJava.fork(javah) == 0;
    }
}
