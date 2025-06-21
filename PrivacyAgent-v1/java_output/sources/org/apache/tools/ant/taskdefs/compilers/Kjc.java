package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class Kjc extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using kjc compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = setupKjcCommand();
        commandline.setExecutable("at.dms.kjc.Main");
        org.apache.tools.ant.taskdefs.ExecuteJava executeJava = new org.apache.tools.ant.taskdefs.ExecuteJava();
        executeJava.setJavaCommand(commandline);
        return executeJava.fork(getJavac()) == 0;
    }

    public org.apache.tools.ant.types.Commandline setupKjcCommand() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        org.apache.tools.ant.types.Path compileClasspath = getCompileClasspath();
        if (this.deprecation) {
            commandline.createArgument().setValue("-deprecation");
        }
        if (this.destDir != null) {
            commandline.createArgument().setValue("-d");
            commandline.createArgument().setFile(this.destDir);
        }
        commandline.createArgument().setValue("-classpath");
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(this.project);
        org.apache.tools.ant.types.Path bootClassPath = getBootClassPath();
        if (bootClassPath.size() > 0) {
            path.append(bootClassPath);
        }
        org.apache.tools.ant.types.Path path2 = this.extdirs;
        if (path2 != null) {
            path.addExtdirs(path2);
        }
        path.append(compileClasspath);
        org.apache.tools.ant.types.Path path3 = this.compileSourcepath;
        if (path3 != null) {
            path.append(path3);
        } else {
            path.append(this.src);
        }
        commandline.createArgument().setPath(path);
        if (this.encoding != null) {
            commandline.createArgument().setValue("-encoding");
            commandline.createArgument().setValue(this.encoding);
        }
        if (this.debug) {
            commandline.createArgument().setValue("-g");
        }
        if (this.optimize) {
            commandline.createArgument().setValue("-O2");
        }
        if (this.verbose) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE);
        }
        addCurrentCompilerArgs(commandline);
        logAndAddFilesToCompile(commandline);
        return commandline;
    }
}
