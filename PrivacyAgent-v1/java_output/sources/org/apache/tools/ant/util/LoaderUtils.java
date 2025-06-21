package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class LoaderUtils {
    public static final org.apache.tools.ant.util.FileUtils a = org.apache.tools.ant.util.FileUtils.getFileUtils();

    public static java.io.File a(java.io.File file) {
        if (file == null) {
            return file;
        }
        try {
            return a.normalize(file.getAbsolutePath());
        } catch (org.apache.tools.ant.BuildException unused) {
            return file;
        }
    }

    public static boolean classExists(java.lang.ClassLoader classLoader, java.lang.String str) {
        return classLoader.getResource(classNameToResource(str)) != null;
    }

    public static java.lang.String classNameToResource(java.lang.String str) {
        return str.replace('.', '/') + ".class";
    }

    public static java.io.File getClassSource(java.lang.Class cls) {
        return a(org.apache.tools.ant.launch.Locator.getClassSource(cls));
    }

    public static java.lang.ClassLoader getContextClassLoader() {
        return java.lang.Thread.currentThread().getContextClassLoader();
    }

    public static java.io.File getResourceSource(java.lang.ClassLoader classLoader, java.lang.String str) {
        if (classLoader == null) {
            classLoader = org.apache.tools.ant.util.LoaderUtils.class.getClassLoader();
        }
        return a(org.apache.tools.ant.launch.Locator.getResourceSource(classLoader, str));
    }

    public static boolean isContextLoaderAvailable() {
        return true;
    }

    public static void setContextClassLoader(java.lang.ClassLoader classLoader) {
        java.lang.Thread.currentThread().setContextClassLoader(classLoader);
    }
}
