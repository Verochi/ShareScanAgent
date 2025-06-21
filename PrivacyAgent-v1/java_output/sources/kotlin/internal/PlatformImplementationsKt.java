package kotlin.internal;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0001\"\u0014\u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "a", "major", "minor", "patch", "", "apiVersionIsAtLeast", "Lkotlin/internal/PlatformImplementations;", "IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class PlatformImplementationsKt {

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlin.internal.PlatformImplementations IMPLEMENTATIONS;

    static {
        kotlin.internal.PlatformImplementations platformImplementations;
        java.lang.Object newInstance;
        java.lang.Object newInstance2;
        int a = a();
        if (a >= 65544 || a < 65536) {
            try {
                newInstance = kotlin.internal.jdk8.JDK8PlatformImplementations.class.newInstance();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                    } catch (java.lang.ClassCastException e) {
                        java.lang.ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        java.lang.ClassLoader classLoader2 = kotlin.internal.PlatformImplementations.class.getClassLoader();
                        if (kotlin.jvm.internal.Intrinsics.areEqual(classLoader, classLoader2)) {
                            throw e;
                        }
                        throw new java.lang.ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                    }
                } catch (java.lang.ClassNotFoundException unused) {
                }
            } catch (java.lang.ClassNotFoundException unused2) {
                java.lang.Object newInstance3 = java.lang.Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance3 == null) {
                        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (kotlin.internal.PlatformImplementations) newInstance3;
                } catch (java.lang.ClassCastException e2) {
                    java.lang.ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                    java.lang.ClassLoader classLoader4 = kotlin.internal.PlatformImplementations.class.getClassLoader();
                    if (kotlin.jvm.internal.Intrinsics.areEqual(classLoader3, classLoader4)) {
                        throw e2;
                    }
                    throw new java.lang.ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
                }
            }
            if (newInstance == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            platformImplementations = (kotlin.internal.PlatformImplementations) newInstance;
            IMPLEMENTATIONS = platformImplementations;
        }
        if (a >= 65543 || a < 65536) {
            try {
                try {
                    newInstance2 = kotlin.internal.jdk7.JDK7PlatformImplementations.class.newInstance();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                    } catch (java.lang.ClassCastException e3) {
                        java.lang.ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                        java.lang.ClassLoader classLoader6 = kotlin.internal.PlatformImplementations.class.getClassLoader();
                        if (kotlin.jvm.internal.Intrinsics.areEqual(classLoader5, classLoader6)) {
                            throw e3;
                        }
                        throw new java.lang.ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                    }
                } catch (java.lang.ClassNotFoundException unused3) {
                    java.lang.Object newInstance4 = java.lang.Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        platformImplementations = (kotlin.internal.PlatformImplementations) newInstance4;
                    } catch (java.lang.ClassCastException e4) {
                        java.lang.ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                        java.lang.ClassLoader classLoader8 = kotlin.internal.PlatformImplementations.class.getClassLoader();
                        if (kotlin.jvm.internal.Intrinsics.areEqual(classLoader7, classLoader8)) {
                            throw e4;
                        }
                        throw new java.lang.ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
                    }
                }
            } catch (java.lang.ClassNotFoundException unused4) {
            }
            if (newInstance2 == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            platformImplementations = (kotlin.internal.PlatformImplementations) newInstance2;
            IMPLEMENTATIONS = platformImplementations;
        }
        platformImplementations = new kotlin.internal.PlatformImplementations();
        IMPLEMENTATIONS = platformImplementations;
    }

    public static final int a() {
        java.lang.String property = java.lang.System.getProperty("java.specification.version");
        if (property == null) {
            return com.igexin.push.b.c.c;
        }
        int indexOf$default = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) property, '.', 0, false, 6, (java.lang.Object) null);
        if (indexOf$default < 0) {
            try {
                return java.lang.Integer.parseInt(property) * 65536;
            } catch (java.lang.NumberFormatException unused) {
                return com.igexin.push.b.c.c;
            }
        }
        int i = indexOf$default + 1;
        int indexOf$default2 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) property, '.', i, false, 4, (java.lang.Object) null);
        if (indexOf$default2 < 0) {
            indexOf$default2 = property.length();
        }
        java.lang.String substring = property.substring(0, indexOf$default);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        java.lang.String substring2 = property.substring(i, indexOf$default2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (java.lang.Integer.parseInt(substring) * 65536) + java.lang.Integer.parseInt(substring2);
        } catch (java.lang.NumberFormatException unused2) {
            return com.igexin.push.b.c.c;
        }
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.PublishedApi
    public static final boolean apiVersionIsAtLeast(int i, int i2, int i3) {
        return kotlin.KotlinVersion.CURRENT.isAtLeast(i, i2, i3);
    }
}
