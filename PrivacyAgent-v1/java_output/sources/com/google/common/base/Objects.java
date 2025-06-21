package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Objects extends com.google.common.base.ExtraObjectsMethodsForWeb {
    public static boolean equal(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object... objArr) {
        return java.util.Arrays.hashCode(objArr);
    }
}
