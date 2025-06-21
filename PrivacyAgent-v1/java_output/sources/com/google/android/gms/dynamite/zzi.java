package com.google.android.gms.dynamite;

/* loaded from: classes22.dex */
final class zzi extends dalvik.system.PathClassLoader {
    public zzi(java.lang.String str, java.lang.ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final java.lang.Class<?> loadClass(java.lang.String str, boolean z) throws java.lang.ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (java.lang.ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z);
    }
}
