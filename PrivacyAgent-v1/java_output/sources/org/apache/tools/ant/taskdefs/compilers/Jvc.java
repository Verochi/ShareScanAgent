package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class Jvc extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using jvc compiler", 3);
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(this.project);
        org.apache.tools.ant.types.Path bootClassPath = getBootClassPath();
        if (bootClassPath.size() > 0) {
            path.append(bootClassPath);
        }
        if (this.includeJavaRuntime) {
            path.addExtdirs(this.extdirs);
        }
        path.append(getCompileClasspath());
        org.apache.tools.ant.types.Path path2 = this.compileSourcepath;
        if (path2 != null) {
            path.append(path2);
        } else {
            path.append(this.src);
        }
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        java.lang.String executable = getJavac().getExecutable();
        if (executable == null) {
            executable = "jvc";
        }
        commandline.setExecutable(executable);
        if (this.destDir != null) {
            commandline.createArgument().setValue("/d");
            commandline.createArgument().setFile(this.destDir);
        }
        commandline.createArgument().setValue("/cp:p");
        commandline.createArgument().setPath(path);
        java.lang.String property = getProject().getProperty("build.compiler.jvc.extensions");
        if (property != null ? org.apache.tools.ant.Project.toBoolean(property) : true) {
            commandline.createArgument().setValue("/x-");
            commandline.createArgument().setValue("/nomessage");
        }
        commandline.createArgument().setValue("/nologo");
        if (this.debug) {
            commandline.createArgument().setValue("/g");
        }
        if (this.optimize) {
            commandline.createArgument().setValue("/O");
        }
        if (this.verbose) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.ccm.CCMReconfigure.FLAG_VERBOSE);
        }
        addCurrentCompilerArgs(commandline);
        int size = commandline.size();
        logAndAddFilesToCompile(commandline);
        return executeExternalCompile(commandline.getCommandline(), size, false) == 0;
    }
}
