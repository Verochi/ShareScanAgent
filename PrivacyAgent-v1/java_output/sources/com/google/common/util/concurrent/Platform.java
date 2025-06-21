package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class Platform {
    public static boolean a(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th, java.lang.Class<? extends java.lang.Throwable> cls) {
        return cls.isInstance(th);
    }
}
