package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ScriptFixBSFPath {
    public static final java.lang.String[] a = {"js", "org.mozilla.javascript.Scriptable", "javascript", "org.mozilla.javascript.Scriptable", "jacl", "tcl.lang.Interp", "netrexx", "netrexx.lang.Rexx", "nrx", "netrexx.lang.Rexx", "jython", "org.python.core.Py", "py", "org.python.core.Py", "xslt", "org.apache.xpath.objects.XObject"};
    public static final java.util.Map b = new java.util.HashMap();

    static {
        int i = 0;
        while (true) {
            java.lang.String[] strArr = a;
            if (i >= strArr.length) {
                return;
            }
            b.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    public final java.io.File a(java.lang.ClassLoader classLoader, java.lang.String str) {
        return org.apache.tools.ant.util.LoaderUtils.getResourceSource(classLoader, org.apache.tools.ant.util.LoaderUtils.classNameToResource(str));
    }

    public final java.io.File b(java.lang.String str) {
        return a(getClass().getClassLoader(), str);
    }

    public void fixClassLoader(java.lang.ClassLoader classLoader, java.lang.String str) {
        if (classLoader == getClass().getClassLoader() || !(classLoader instanceof org.apache.tools.ant.AntClassLoader)) {
            return;
        }
        java.lang.ClassLoader classLoader2 = getClass().getClassLoader();
        org.apache.tools.ant.AntClassLoader antClassLoader = (org.apache.tools.ant.AntClassLoader) classLoader;
        java.io.File b2 = b("org.apache.bsf.BSFManager");
        boolean z = true;
        boolean z2 = b2 == null;
        java.lang.String str2 = (java.lang.String) b.get(str);
        boolean z3 = (b2 == null || str2 == null || org.apache.tools.ant.util.LoaderUtils.classExists(classLoader2, str2) || !org.apache.tools.ant.util.LoaderUtils.classExists(classLoader, str2)) ? false : true;
        if (!z2 && !z3) {
            z = false;
        }
        if (b2 == null) {
            b2 = a(classLoader, "org.apache.bsf.BSFManager");
        }
        if (b2 == null) {
            throw new org.apache.tools.ant.BuildException("Unable to find BSF classes for scripting");
        }
        if (z3) {
            antClassLoader.addPathComponent(b2);
            antClassLoader.addLoaderPackageRoot("org.apache.bsf");
        }
        if (z) {
            antClassLoader.addPathComponent(org.apache.tools.ant.util.LoaderUtils.getResourceSource(antClassLoader, org.apache.tools.ant.util.LoaderUtils.classNameToResource("org.apache.tools.ant.util.optional.ScriptRunner")));
            antClassLoader.addLoaderPackageRoot("org.apache.tools.ant.util.optional");
        }
    }
}
