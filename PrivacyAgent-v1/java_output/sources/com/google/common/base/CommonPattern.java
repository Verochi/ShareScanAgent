package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class CommonPattern {
    public static com.google.common.base.CommonPattern compile(java.lang.String str) {
        return com.google.common.base.Platform.a(str);
    }

    public static boolean isPcreLike() {
        return com.google.common.base.Platform.g();
    }

    public abstract int flags();

    public abstract com.google.common.base.CommonMatcher matcher(java.lang.CharSequence charSequence);

    public abstract java.lang.String pattern();

    public abstract java.lang.String toString();
}
