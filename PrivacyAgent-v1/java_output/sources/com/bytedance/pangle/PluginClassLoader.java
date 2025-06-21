package com.bytedance.pangle;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class PluginClassLoader extends dalvik.system.BaseDexClassLoader {
    private static final java.lang.String TAG = "PluginClassLoader";
    private java.util.HashSet<java.lang.String> allPluginClasses;
    private final java.lang.ClassLoader hostClassLoader;
    private final java.util.List<java.lang.ClassLoader> otherPluginClassLoader;

    public PluginClassLoader(java.lang.String str, java.io.File file, java.lang.String str2, java.util.List<java.lang.ClassLoader> list) {
        super(str, file, str2, java.lang.ClassLoader.getSystemClassLoader().getParent());
        this.hostClassLoader = com.bytedance.pangle.PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = list;
    }

    private java.lang.ClassNotFoundException handleException(java.lang.StringBuilder sb, java.lang.ClassNotFoundException classNotFoundException, java.lang.ClassNotFoundException classNotFoundException2) {
        if (classNotFoundException == null) {
            return classNotFoundException2;
        }
        classNotFoundException.addSuppressed(classNotFoundException2);
        return classNotFoundException;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public java.lang.Class<?> findClass(java.lang.String str) {
        java.util.List<java.lang.ClassLoader> list;
        java.util.HashSet<java.lang.String> hashSet = this.allPluginClasses;
        java.lang.Class<?> cls = null;
        if (hashSet == null || hashSet.contains(str)) {
            try {
                cls = super.findClass(str);
                e = null;
            } catch (java.lang.ClassNotFoundException e) {
                e = e;
            }
        } else {
            e = null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("loadClass from :\n");
        if (cls == null && (list = this.otherPluginClassLoader) != null) {
            java.util.Iterator<java.lang.ClassLoader> it = list.iterator();
            while (it.hasNext()) {
                try {
                    cls = it.next().loadClass(str);
                } catch (java.lang.ClassNotFoundException e2) {
                    e = handleException(sb, e, e2);
                }
            }
        }
        if (cls == null) {
            try {
                cls = this.hostClassLoader.loadClass(str);
            } catch (java.lang.ClassNotFoundException e3) {
                e = handleException(sb, e, e3);
            }
        }
        if (cls != null) {
            return cls;
        }
        if (e != null) {
            throw e;
        }
        throw new java.lang.ClassNotFoundException(str + " class not found in PluginClassLoader");
    }

    public void setAllPluginClasses(java.util.HashSet<java.lang.String> hashSet) {
        this.allPluginClasses = hashSet;
    }
}
