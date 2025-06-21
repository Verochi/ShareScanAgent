package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class Ticker {
    public static final com.google.common.base.Ticker a = new com.google.common.base.Ticker.AnonymousClass1();

    /* renamed from: com.google.common.base.Ticker$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.base.Ticker {
        @Override // com.google.common.base.Ticker
        public long read() {
            return com.google.common.base.Platform.j();
        }
    }

    public static com.google.common.base.Ticker systemTicker() {
        return a;
    }

    public abstract long read();
}
