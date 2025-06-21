package com.anythink.core.c.b;

/* loaded from: classes12.dex */
public final class b implements com.anythink.core.c.b.a {
    private static final java.lang.String a = "PlacementStatRecWrapper";
    private final com.anythink.core.c.b.a c = new com.anythink.core.c.b.c();
    private final android.os.Handler b = com.anythink.core.common.o.b.b.a().a(11);

    /* renamed from: com.anythink.core.c.b.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.anythink.core.common.f.au c;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.au auVar) {
            this.a = str;
            this.b = str2;
            this.c = auVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.c.b.b.this.c.a(this.a, this.b, this.c);
        }
    }

    /* renamed from: com.anythink.core.c.b.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.at a;
        final /* synthetic */ com.anythink.core.common.f.au b;

        public AnonymousClass2(com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar) {
            this.a = atVar;
            this.b = auVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.c.b.b.this.c.a(this.a, this.b);
        }
    }

    private void a(java.lang.Runnable runnable) {
        android.os.Handler handler = this.b;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.anythink.core.c.b.a
    public final java.util.List<com.anythink.core.c.a.a> a(int i, java.lang.String str, int i2) {
        android.os.Looper.myLooper();
        android.os.Looper.getMainLooper();
        return this.c.a(i, str, i2);
    }

    @Override // com.anythink.core.c.b.a
    public final org.json.JSONObject a(java.lang.String str) {
        return a(str, 0);
    }

    @Override // com.anythink.core.c.b.a
    public final org.json.JSONObject a(java.lang.String str, int i) {
        android.os.Looper.myLooper();
        android.os.Looper.getMainLooper();
        return this.c.a(str, i);
    }

    @Override // com.anythink.core.c.b.a
    public final org.json.JSONObject a(java.lang.String str, int i, int i2) {
        android.os.Looper.myLooper();
        android.os.Looper.getMainLooper();
        return this.c.a(str, i, i2);
    }

    @Override // com.anythink.core.c.b.a
    public final void a(com.anythink.core.common.f.at atVar, com.anythink.core.common.f.au auVar) {
        a(new com.anythink.core.c.b.b.AnonymousClass2(atVar, auVar));
    }

    @Override // com.anythink.core.c.b.a
    public final void a(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.au auVar) {
        a(new com.anythink.core.c.b.b.AnonymousClass1(str, str2, auVar));
    }

    @Override // com.anythink.core.c.b.a
    public final void b(java.lang.String str) {
        this.c.b(str);
    }
}
