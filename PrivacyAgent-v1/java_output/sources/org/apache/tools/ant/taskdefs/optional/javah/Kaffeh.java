package org.apache.tools.ant.taskdefs.optional.javah;

/* loaded from: classes25.dex */
public class Kaffeh implements org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter {
    public static final java.lang.String IMPLEMENTATION_NAME = "kaffeh";

    public final org.apache.tools.ant.types.Commandline a(org.apache.tools.ant.taskdefs.optional.Javah javah) {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(org.apache.tools.ant.util.JavaEnvUtils.getJdkExecutable(IMPLEMENTATION_NAME));
        if (javah.getDestdir() != null) {
            commandline.createArgument().setValue("-d");
            commandline.createArgument().setFile(javah.getDestdir());
        }
        if (javah.getOutputfile() != null) {
            commandline.createArgument().setValue("-o");
            commandline.createArgument().setFile(javah.getOutputfile());
        }
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(javah.getProject());
        if (javah.getBootclasspath() != null) {
            path.append(javah.getBootclasspath());
        }
        org.apache.tools.ant.types.Path concatSystemBootClasspath = path.concatSystemBootClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
        if (javah.getClasspath() != null) {
            concatSystemBootClasspath.append(javah.getClasspath());
        }
        if (concatSystemBootClasspath.size() > 0) {
            commandline.createArgument().setValue("-classpath");
            commandline.createArgument().setPath(concatSystemBootClasspath);
        }
        if (!javah.getOld()) {
            commandline.createArgument().setValue("-jni");
        }
        commandline.addArguments(javah.getCurrentArgs());
        javah.logAndAddFiles(commandline);
        return commandline;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter
    public boolean compile(org.apache.tools.ant.taskdefs.optional.Javah javah) throws org.apache.tools.ant.BuildException {
        try {
            org.apache.tools.ant.taskdefs.Execute.runCommand(javah, a(javah).getCommandline());
            return true;
        } catch (org.apache.tools.ant.BuildException e) {
            if (e.getMessage().contains("failed with return code")) {
                return false;
            }
            throw e;
        }
    }
}
