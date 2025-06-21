package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class Gcj extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    public static final java.lang.String[] c = {"-o", "--main=", org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_CODEDIFF, "-fjni", org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_LABEL};

    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using gcj compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = setupGCJCommand();
        int size = commandline.size();
        logAndAddFilesToCompile(commandline);
        return executeExternalCompile(commandline.getCommandline(), size) == 0;
    }

    public boolean isNativeBuild() {
        java.lang.String[] currentCompilerArgs = getJavac().getCurrentCompilerArgs();
        boolean z = false;
        for (int i = 0; !z && i < currentCompilerArgs.length; i++) {
            int i2 = 0;
            while (!z) {
                java.lang.String[] strArr = c;
                if (i2 < strArr.length) {
                    z = currentCompilerArgs[i].startsWith(strArr[i2]);
                    i2++;
                }
            }
        }
        return z;
    }

    public org.apache.tools.ant.types.Commandline setupGCJCommand() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(this.project);
        org.apache.tools.ant.types.Path bootClassPath = getBootClassPath();
        if (bootClassPath.size() > 0) {
            path.append(bootClassPath);
        }
        org.apache.tools.ant.types.Path path2 = this.extdirs;
        if (path2 != null || this.includeJavaRuntime) {
            path.addExtdirs(path2);
        }
        path.append(getCompileClasspath());
        org.apache.tools.ant.types.Path path3 = this.compileSourcepath;
        if (path3 != null) {
            path.append(path3);
        } else {
            path.append(this.src);
        }
        java.lang.String executable = getJavac().getExecutable();
        if (executable == null) {
            executable = "gcj";
        }
        commandline.setExecutable(executable);
        if (this.destDir != null) {
            commandline.createArgument().setValue("-d");
            commandline.createArgument().setFile(this.destDir);
            if (!this.destDir.exists() && !this.destDir.mkdirs() && !this.destDir.isDirectory()) {
                throw new org.apache.tools.ant.BuildException("Can't make output directories. Maybe permission is wrong. ");
            }
        }
        commandline.createArgument().setValue("-classpath");
        commandline.createArgument().setPath(path);
        if (this.encoding != null) {
            commandline.createArgument().setValue("--encoding=" + this.encoding);
        }
        if (this.debug) {
            commandline.createArgument().setValue("-g1");
        }
        if (this.optimize) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_OUTPUT);
        }
        if (!isNativeBuild()) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_COMMENT);
        }
        if (this.attributes.getSource() != null) {
            java.lang.String source = this.attributes.getSource();
            commandline.createArgument().setValue("-fsource=" + source);
        }
        if (this.attributes.getTarget() != null) {
            java.lang.String target = this.attributes.getTarget();
            commandline.createArgument().setValue("-ftarget=" + target);
        }
        addCurrentCompilerArgs(commandline);
        return commandline;
    }
}
