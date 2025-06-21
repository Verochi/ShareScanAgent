package org.apache.tools.ant.taskdefs.optional.javah;

/* loaded from: classes25.dex */
public class JavahAdapterFactory {
    public static org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter a(java.lang.String str, java.lang.ClassLoader classLoader) throws org.apache.tools.ant.BuildException {
        if (classLoader == null) {
            classLoader = org.apache.tools.ant.taskdefs.optional.javah.JavahAdapterFactory.class.getClassLoader();
        }
        return (org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, classLoader, org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter.class);
    }

    public static org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter getAdapter(java.lang.String str, org.apache.tools.ant.ProjectComponent projectComponent) throws org.apache.tools.ant.BuildException {
        return getAdapter(str, projectComponent, null);
    }

    public static org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter getAdapter(java.lang.String str, org.apache.tools.ant.ProjectComponent projectComponent, org.apache.tools.ant.types.Path path) throws org.apache.tools.ant.BuildException {
        if ((org.apache.tools.ant.util.JavaEnvUtils.isKaffe() && str == null) || org.apache.tools.ant.taskdefs.optional.javah.Kaffeh.IMPLEMENTATION_NAME.equals(str)) {
            return new org.apache.tools.ant.taskdefs.optional.javah.Kaffeh();
        }
        if ((org.apache.tools.ant.util.JavaEnvUtils.isGij() && str == null) || org.apache.tools.ant.taskdefs.optional.javah.Gcjh.IMPLEMENTATION_NAME.equals(str)) {
            return new org.apache.tools.ant.taskdefs.optional.javah.Gcjh();
        }
        if (org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) && (str == null || "forking".equals(str))) {
            throw new org.apache.tools.ant.BuildException("javah does not exist under Java 10 and higher, use the javac task with nativeHeaderDir instead");
        }
        if ((org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion("9") && str == null) || "forking".equals(str)) {
            return new org.apache.tools.ant.taskdefs.optional.javah.ForkingJavah();
        }
        if (!"sun".equals(str) && str != null) {
            return a(str, projectComponent.getProject().createClassLoader(path));
        }
        return new org.apache.tools.ant.taskdefs.optional.javah.SunJavah();
    }

    public static java.lang.String getDefault() {
        return org.apache.tools.ant.util.JavaEnvUtils.isKaffe() ? org.apache.tools.ant.taskdefs.optional.javah.Kaffeh.IMPLEMENTATION_NAME : org.apache.tools.ant.util.JavaEnvUtils.isGij() ? org.apache.tools.ant.taskdefs.optional.javah.Gcjh.IMPLEMENTATION_NAME : org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion("9") ? "forking" : "sun";
    }
}
