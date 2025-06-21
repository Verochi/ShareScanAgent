package com.getui.gtc.extension.distribution.gbd.n.d.a;

/* loaded from: classes22.dex */
public final class e {
    private e() {
    }

    public static void a(java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("Object must not be null");
        }
    }

    public static void a(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }

    public static void a(java.lang.String str) {
        if (str == null || str.length() == 0) {
            throw new java.lang.IllegalArgumentException("String must not be empty");
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (str == null || str.length() == 0) {
            throw new java.lang.IllegalArgumentException(str2);
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new java.lang.IllegalArgumentException("Must be true");
        }
    }

    public static void a(boolean z, java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }

    public static void a(java.lang.Object[] objArr) {
        for (java.lang.Object obj : objArr) {
            if (obj == null) {
                throw new java.lang.IllegalArgumentException("Array must not contain any null objects");
            }
        }
    }

    private static void a(java.lang.Object[] objArr, java.lang.String str) {
        for (java.lang.Object obj : objArr) {
            if (obj == null) {
                throw new java.lang.IllegalArgumentException(str);
            }
        }
    }

    public static void b(java.lang.String str) {
        throw new java.lang.IllegalArgumentException(str);
    }

    private static void b(boolean z) {
        if (z) {
            throw new java.lang.IllegalArgumentException("Must be false");
        }
    }

    public static void b(boolean z, java.lang.String str) {
        if (z) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }
}
