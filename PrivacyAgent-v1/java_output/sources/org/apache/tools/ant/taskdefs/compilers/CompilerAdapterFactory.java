package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public final class CompilerAdapterFactory {
    public static boolean a() {
        try {
            try {
                java.lang.Class.forName("com.sun.tools.javac.Main");
                return true;
            } catch (java.lang.ClassNotFoundException unused) {
                java.lang.ClassLoader classLoader = org.apache.tools.ant.taskdefs.compilers.CompilerAdapterFactory.class.getClassLoader();
                if (classLoader == null) {
                    return false;
                }
                classLoader.loadClass("com.sun.tools.javac.Main");
                return true;
            }
        } catch (java.lang.ClassNotFoundException unused2) {
            return false;
        }
    }

    public static org.apache.tools.ant.taskdefs.compilers.CompilerAdapter b(java.lang.String str, java.lang.ClassLoader classLoader) throws org.apache.tools.ant.BuildException {
        if (classLoader == null) {
            classLoader = org.apache.tools.ant.taskdefs.compilers.CompilerAdapterFactory.class.getClassLoader();
        }
        return (org.apache.tools.ant.taskdefs.compilers.CompilerAdapter) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, classLoader, org.apache.tools.ant.taskdefs.compilers.CompilerAdapter.class);
    }

    public static org.apache.tools.ant.taskdefs.compilers.CompilerAdapter getCompiler(java.lang.String str, org.apache.tools.ant.Task task) throws org.apache.tools.ant.BuildException {
        return getCompiler(str, task, null);
    }

    public static org.apache.tools.ant.taskdefs.compilers.CompilerAdapter getCompiler(java.lang.String str, org.apache.tools.ant.Task task, org.apache.tools.ant.types.Path path) throws org.apache.tools.ant.BuildException {
        if (str.equalsIgnoreCase("jikes")) {
            return new org.apache.tools.ant.taskdefs.compilers.Jikes();
        }
        if (str.equalsIgnoreCase("extjavac")) {
            return new org.apache.tools.ant.taskdefs.compilers.JavacExternal();
        }
        if (str.equalsIgnoreCase("classic") || str.equalsIgnoreCase("javac1.1") || str.equalsIgnoreCase("javac1.2")) {
            task.log("This version of java does not support the classic compiler; upgrading to modern", 1);
            str = "modern";
        }
        if (!str.equalsIgnoreCase("modern") && !str.equalsIgnoreCase("javac1.3") && !str.equalsIgnoreCase("javac1.4") && !str.equalsIgnoreCase("javac1.5") && !str.equalsIgnoreCase("javac1.6") && !str.equalsIgnoreCase("javac1.7") && !str.equalsIgnoreCase("javac1.8") && !str.equalsIgnoreCase("javac1.9") && !str.equalsIgnoreCase("javac9") && !str.equalsIgnoreCase("javac10+")) {
            return (str.equalsIgnoreCase("jvc") || str.equalsIgnoreCase("microsoft")) ? new org.apache.tools.ant.taskdefs.compilers.Jvc() : str.equalsIgnoreCase("kjc") ? new org.apache.tools.ant.taskdefs.compilers.Kjc() : str.equalsIgnoreCase("gcj") ? new org.apache.tools.ant.taskdefs.compilers.Gcj() : (str.equalsIgnoreCase("sj") || str.equalsIgnoreCase("symantec")) ? new org.apache.tools.ant.taskdefs.compilers.Sj() : b(str, task.getProject().createClassLoader(path));
        }
        if (a()) {
            return new org.apache.tools.ant.taskdefs.compilers.Javac13();
        }
        throw new org.apache.tools.ant.BuildException("Unable to find a javac compiler;\ncom.sun.tools.javac.Main is not on the classpath.\nPerhaps JAVA_HOME does not point to the JDK.\nIt is currently set to \"" + org.apache.tools.ant.util.JavaEnvUtils.getJavaHome() + "\"");
    }
}
