package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public final class SplitClassLoader extends org.apache.tools.ant.AntClassLoader {
    public final java.lang.String[] G;

    public SplitClassLoader(java.lang.ClassLoader classLoader, org.apache.tools.ant.types.Path path, org.apache.tools.ant.Project project, java.lang.String[] strArr) {
        super(classLoader, project, path, true);
        this.G = strArr;
    }

    @Override // org.apache.tools.ant.AntClassLoader, java.lang.ClassLoader
    public synchronized java.lang.Class loadClass(java.lang.String str, boolean z) throws java.lang.ClassNotFoundException {
        java.lang.Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        if (!p(str)) {
            return super.loadClass(str, z);
        }
        java.lang.Class<?> findClass = findClass(str);
        if (z) {
            resolveClass(findClass);
        }
        return findClass;
    }

    public final boolean p(java.lang.String str) {
        java.lang.String substring = str.substring(str.lastIndexOf(46) + 1);
        for (java.lang.String str2 : this.G) {
            if (!substring.equals(str2)) {
                if (!substring.startsWith(str2 + kotlin.text.Typography.dollar)) {
                }
            }
            return true;
        }
        return false;
    }
}
