package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Apt extends org.apache.tools.ant.taskdefs.Javac {
    public static final java.lang.String ERROR_IGNORING_COMPILER_OPTION = "Ignoring compiler attribute for the APT task, as it is fixed";
    public static final java.lang.String ERROR_WRONG_JAVA_VERSION = "Apt task requires Java 1.5+";
    public static final java.lang.String EXECUTABLE_NAME = "apt";
    public static final java.lang.String WARNING_IGNORING_FORK = "Apt only runs in its own JVM; fork=false option ignored";
    public java.lang.String i0;
    public org.apache.tools.ant.types.Path j0;
    public java.io.File l0;
    public boolean h0 = true;
    public java.util.Vector<org.apache.tools.ant.taskdefs.Apt.Option> k0 = new java.util.Vector<>();

    public static final class Option {
        public java.lang.String a;
        public java.lang.String b;

        public java.lang.String getName() {
            return this.a;
        }

        public java.lang.String getValue() {
            return this.b;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }

        public void setValue(java.lang.String str) {
            this.b = str;
        }
    }

    public Apt() {
        super.setCompiler(org.apache.tools.ant.taskdefs.compilers.AptExternalCompilerAdapter.class.getName());
        super.setFork(true);
    }

    public org.apache.tools.ant.types.Path createFactoryPath() {
        if (this.j0 == null) {
            this.j0 = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.j0.createPath();
    }

    public org.apache.tools.ant.taskdefs.Apt.Option createOption() {
        org.apache.tools.ant.taskdefs.Apt.Option option = new org.apache.tools.ant.taskdefs.Apt.Option();
        this.k0.add(option);
        return option;
    }

    @Override // org.apache.tools.ant.taskdefs.Javac, org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_8)) {
            throw new org.apache.tools.ant.BuildException("apt does not exist under Java 1.8 and higher");
        }
        super.execute();
    }

    public java.lang.String getAptExecutable() {
        java.lang.String executable = getExecutable();
        return executable != null ? executable : org.apache.tools.ant.util.JavaEnvUtils.getJdkExecutable(EXECUTABLE_NAME);
    }

    @Override // org.apache.tools.ant.taskdefs.Javac
    public java.lang.String getCompiler() {
        return super.getCompiler();
    }

    public java.lang.String getFactory() {
        return this.i0;
    }

    public org.apache.tools.ant.types.Path getFactoryPath() {
        return this.j0;
    }

    public java.util.Vector<org.apache.tools.ant.taskdefs.Apt.Option> getOptions() {
        return this.k0;
    }

    public java.io.File getPreprocessDir() {
        return this.l0;
    }

    public boolean isCompile() {
        return this.h0;
    }

    public void setCompile(boolean z) {
        this.h0 = z;
    }

    @Override // org.apache.tools.ant.taskdefs.Javac
    public void setCompiler(java.lang.String str) {
        log(ERROR_IGNORING_COMPILER_OPTION, 1);
    }

    public void setFactory(java.lang.String str) {
        this.i0 = str;
    }

    public void setFactoryPathRef(org.apache.tools.ant.types.Reference reference) {
        createFactoryPath().setRefid(reference);
    }

    @Override // org.apache.tools.ant.taskdefs.Javac
    public void setFork(boolean z) {
        if (z) {
            return;
        }
        log(WARNING_IGNORING_FORK, 1);
    }

    public void setPreprocessDir(java.io.File file) {
        this.l0 = file;
    }
}
