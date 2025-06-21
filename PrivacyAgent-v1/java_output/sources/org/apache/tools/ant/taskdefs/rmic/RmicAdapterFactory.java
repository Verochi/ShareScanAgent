package org.apache.tools.ant.taskdefs.rmic;

/* loaded from: classes25.dex */
public final class RmicAdapterFactory {
    public static final java.lang.String DEFAULT_COMPILER = "default";
    public static final java.lang.String ERROR_NOT_RMIC_ADAPTER = "Class of unexpected Type: ";
    public static final java.lang.String ERROR_UNKNOWN_COMPILER = "Class not found: ";

    public static org.apache.tools.ant.taskdefs.rmic.RmicAdapter a(java.lang.String str, java.lang.ClassLoader classLoader) throws org.apache.tools.ant.BuildException {
        if (classLoader == null) {
            classLoader = org.apache.tools.ant.taskdefs.rmic.RmicAdapterFactory.class.getClassLoader();
        }
        return (org.apache.tools.ant.taskdefs.rmic.RmicAdapter) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, classLoader, org.apache.tools.ant.taskdefs.rmic.RmicAdapter.class);
    }

    public static org.apache.tools.ant.taskdefs.rmic.RmicAdapter getRmic(java.lang.String str, org.apache.tools.ant.Task task) throws org.apache.tools.ant.BuildException {
        return getRmic(str, task, null);
    }

    public static org.apache.tools.ant.taskdefs.rmic.RmicAdapter getRmic(java.lang.String str, org.apache.tools.ant.Task task, org.apache.tools.ant.types.Path path) throws org.apache.tools.ant.BuildException {
        if ("default".equalsIgnoreCase(str) || str.length() == 0) {
            str = org.apache.tools.ant.taskdefs.rmic.KaffeRmic.isAvailable() ? "kaffe" : org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion("9") ? "forking" : "sun";
        }
        return "sun".equalsIgnoreCase(str) ? new org.apache.tools.ant.taskdefs.rmic.SunRmic() : "kaffe".equalsIgnoreCase(str) ? new org.apache.tools.ant.taskdefs.rmic.KaffeRmic() : org.apache.tools.ant.taskdefs.rmic.WLRmic.COMPILER_NAME.equalsIgnoreCase(str) ? new org.apache.tools.ant.taskdefs.rmic.WLRmic() : "forking".equalsIgnoreCase(str) ? new org.apache.tools.ant.taskdefs.rmic.ForkingSunRmic() : org.apache.tools.ant.taskdefs.rmic.XNewRmic.COMPILER_NAME.equalsIgnoreCase(str) ? new org.apache.tools.ant.taskdefs.rmic.XNewRmic() : a(str, task.getProject().createClassLoader(path));
    }
}
