package com.google.common.escape;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class Platform {
    public static final java.lang.ThreadLocal<char[]> a = new com.google.common.escape.Platform.AnonymousClass1();

    /* renamed from: com.google.common.escape.Platform$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.ThreadLocal<char[]> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static char[] a() {
        return a.get();
    }
}
