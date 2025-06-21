package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class Jikes extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using jikes compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        org.apache.tools.ant.types.Path path = this.compileSourcepath;
        if (path == null) {
            path = this.src;
        }
        if (path.size() > 0) {
            commandline.createArgument().setValue("-sourcepath");
            commandline.createArgument().setPath(path);
        }
        org.apache.tools.ant.types.Path path2 = new org.apache.tools.ant.types.Path(this.project);
        org.apache.tools.ant.types.Path path3 = this.bootclasspath;
        if (path3 == null || path3.size() == 0) {
            this.includeJavaRuntime = true;
        }
        path2.append(getCompileClasspath());
        java.lang.String property = java.lang.System.getProperty("jikes.class.path");
        if (property != null) {
            path2.append(new org.apache.tools.ant.types.Path(this.project, property));
        }
        org.apache.tools.ant.types.Path path4 = this.extdirs;
        if (path4 != null && path4.size() > 0) {
            commandline.createArgument().setValue("-extdirs");
            commandline.createArgument().setPath(this.extdirs);
        }
        java.lang.String executable = getJavac().getExecutable();
        if (executable == null) {
            executable = "jikes";
        }
        commandline.setExecutable(executable);
        if (this.deprecation) {
            commandline.createArgument().setValue("-deprecation");
        }
        if (this.destDir != null) {
            commandline.createArgument().setValue("-d");
            commandline.createArgument().setFile(this.destDir);
        }
        commandline.createArgument().setValue("-classpath");
        commandline.createArgument().setPath(path2);
        if (this.encoding != null) {
            commandline.createArgument().setValue("-encoding");
            commandline.createArgument().setValue(this.encoding);
        }
        if (this.debug) {
            java.lang.String debugLevel = this.attributes.getDebugLevel();
            if (debugLevel != null) {
                commandline.createArgument().setValue("-g:" + debugLevel);
            } else {
                commandline.createArgument().setValue("-g");
            }
        } else {
            commandline.createArgument().setValue("-g:none");
        }
        if (this.optimize) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_OUTPUT);
        }
        if (this.verbose) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE);
        }
        if (this.depend) {
            commandline.createArgument().setValue("-depend");
        }
        if (this.target != null) {
            commandline.createArgument().setValue("-target");
            commandline.createArgument().setValue(this.target);
        }
        f(commandline);
        if (this.attributes.getSource() != null) {
            commandline.createArgument().setValue("-source");
            java.lang.String source = this.attributes.getSource();
            if (source.equals("1.1") || source.equals("1.2")) {
                this.attributes.log("Jikes doesn't support '-source " + source + "', will use '-source 1.3' instead");
                commandline.createArgument().setValue("1.3");
            } else {
                commandline.createArgument().setValue(source);
            }
        }
        addCurrentCompilerArgs(commandline);
        int size = commandline.size();
        org.apache.tools.ant.types.Path bootClassPath = getBootClassPath();
        if (bootClassPath.size() > 0) {
            commandline.createArgument().setValue("-bootclasspath");
            commandline.createArgument().setPath(bootClassPath);
        }
        logAndAddFilesToCompile(commandline);
        return executeExternalCompile(commandline.getCommandline(), size) == 0;
    }

    public final void f(org.apache.tools.ant.types.Commandline commandline) {
        java.lang.String property = this.project.getProperty("build.compiler.emacs");
        if (property != null && org.apache.tools.ant.Project.toBoolean(property)) {
            commandline.createArgument().setValue("+E");
        }
        java.lang.String property2 = this.project.getProperty("build.compiler.warnings");
        if (property2 != null) {
            this.attributes.log("!! the build.compiler.warnings property is deprecated. !!", 1);
            this.attributes.log("!! Use the nowarn attribute instead. !!", 1);
            if (!org.apache.tools.ant.Project.toBoolean(property2)) {
                commandline.createArgument().setValue("-nowarn");
            }
        }
        if (this.attributes.getNowarn()) {
            commandline.createArgument().setValue("-nowarn");
        }
        java.lang.String property3 = this.project.getProperty("build.compiler.pedantic");
        if (property3 != null && org.apache.tools.ant.Project.toBoolean(property3)) {
            commandline.createArgument().setValue("+P");
        }
        java.lang.String property4 = this.project.getProperty("build.compiler.fulldepend");
        if (property4 == null || !org.apache.tools.ant.Project.toBoolean(property4)) {
            return;
        }
        commandline.createArgument().setValue("+F");
    }
}
