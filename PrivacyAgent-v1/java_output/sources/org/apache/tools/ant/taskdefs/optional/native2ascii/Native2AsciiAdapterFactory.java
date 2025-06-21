package org.apache.tools.ant.taskdefs.optional.native2ascii;

/* loaded from: classes25.dex */
public class Native2AsciiAdapterFactory {
    public static org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter a(java.lang.String str, java.lang.ClassLoader classLoader) throws org.apache.tools.ant.BuildException {
        if (classLoader == null) {
            classLoader = org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapterFactory.class.getClassLoader();
        }
        return (org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, classLoader, org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter.class);
    }

    public static final boolean b() {
        return org.apache.tools.ant.util.JavaEnvUtils.isKaffe() || org.apache.tools.ant.util.JavaEnvUtils.isClasspathBased();
    }

    public static final boolean c() {
        return org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5) || org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6) || org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7) || org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_8);
    }

    public static org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter getAdapter(java.lang.String str, org.apache.tools.ant.ProjectComponent projectComponent) throws org.apache.tools.ant.BuildException {
        return getAdapter(str, projectComponent, null);
    }

    public static org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter getAdapter(java.lang.String str, org.apache.tools.ant.ProjectComponent projectComponent, org.apache.tools.ant.types.Path path) throws org.apache.tools.ant.BuildException {
        if ((b() && str == null) || "kaffe".equals(str)) {
            return new org.apache.tools.ant.taskdefs.optional.native2ascii.KaffeNative2Ascii();
        }
        if ((c() && str == null) || "sun".equals(str)) {
            return new org.apache.tools.ant.taskdefs.optional.native2ascii.SunNative2Ascii();
        }
        if (!"builtin".equals(str) && str != null) {
            return a(str, projectComponent.getProject().createClassLoader(path));
        }
        return new org.apache.tools.ant.taskdefs.optional.native2ascii.BuiltinNative2Ascii();
    }

    public static java.lang.String getDefault() {
        return b() ? "kaffe" : c() ? "sun" : "builtin";
    }
}
