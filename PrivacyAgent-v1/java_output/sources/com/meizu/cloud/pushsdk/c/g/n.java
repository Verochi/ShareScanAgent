package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
public class n {
    public static final com.meizu.cloud.pushsdk.c.g.n a = new com.meizu.cloud.pushsdk.c.g.n.AnonymousClass1();
    private boolean b;
    private long c;

    /* renamed from: com.meizu.cloud.pushsdk.c.g.n$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.meizu.cloud.pushsdk.c.g.n {
        @Override // com.meizu.cloud.pushsdk.c.g.n
        public void a() {
        }
    }

    public void a() throws java.io.IOException {
        if (java.lang.Thread.interrupted()) {
            throw new java.io.InterruptedIOException("thread interrupted");
        }
        if (this.b && this.c - java.lang.System.nanoTime() <= 0) {
            throw new java.io.InterruptedIOException("deadline reached");
        }
    }
}
