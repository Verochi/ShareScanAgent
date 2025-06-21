package com.efs.sdk.base.core.c;

/* loaded from: classes22.dex */
public final class d {
    public com.efs.sdk.base.core.c.a a;

    /* renamed from: com.efs.sdk.base.core.c.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.efs.sdk.base.core.model.LogDto a;

        public AnonymousClass1(com.efs.sdk.base.core.model.LogDto logDto) {
            this.a = logDto;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.efs.sdk.base.core.c.d.this.a.a(this.a);
        }
    }

    public static class a {
        private static final com.efs.sdk.base.core.c.d a = new com.efs.sdk.base.core.c.d((byte) 0);
    }

    private d() {
        this.a = new com.efs.sdk.base.core.c.c();
    }

    public /* synthetic */ d(byte b) {
        this();
    }
}
