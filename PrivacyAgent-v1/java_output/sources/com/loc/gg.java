package com.loc;

/* loaded from: classes23.dex */
public class gg {
    private static final java.lang.ThreadLocal<java.nio.charset.CharsetDecoder> b = new com.loc.gg.AnonymousClass1();
    public static final java.lang.ThreadLocal<java.nio.charset.Charset> a = new com.loc.gg.AnonymousClass2();
    private static final java.lang.ThreadLocal<java.nio.CharBuffer> c = new java.lang.ThreadLocal<>();

    /* renamed from: com.loc.gg$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.ThreadLocal<java.nio.charset.CharsetDecoder> {
        private static java.nio.charset.CharsetDecoder a() {
            return java.nio.charset.Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ java.nio.charset.CharsetDecoder initialValue() {
            return a();
        }
    }

    /* renamed from: com.loc.gg$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.lang.ThreadLocal<java.nio.charset.Charset> {
        private static java.nio.charset.Charset a() {
            return java.nio.charset.Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ java.nio.charset.Charset initialValue() {
            return a();
        }
    }
}
