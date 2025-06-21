package com.google.common.escape;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class Escaper {
    public final com.google.common.base.Function<java.lang.String, java.lang.String> a = new com.google.common.escape.Escaper.AnonymousClass1();

    /* renamed from: com.google.common.escape.Escaper$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.common.base.Function<java.lang.String, java.lang.String> {
        public AnonymousClass1() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String apply(java.lang.String str) {
            return com.google.common.escape.Escaper.this.escape(str);
        }
    }

    public final com.google.common.base.Function<java.lang.String, java.lang.String> asFunction() {
        return this.a;
    }

    public abstract java.lang.String escape(java.lang.String str);
}
