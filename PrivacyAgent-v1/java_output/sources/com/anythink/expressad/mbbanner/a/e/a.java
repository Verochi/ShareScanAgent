package com.anythink.expressad.mbbanner.a.e;

/* loaded from: classes12.dex */
public class a {
    private static final java.lang.String a = "a";
    private final android.os.Handler b = new android.os.Handler(android.os.Looper.getMainLooper());
    private boolean c;

    /* renamed from: com.anythink.expressad.mbbanner.a.e.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.mbbanner.a.c.b a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.anythink.expressad.foundation.d.d c;

        public AnonymousClass1(com.anythink.expressad.mbbanner.a.c.b bVar, java.lang.String str, com.anythink.expressad.foundation.d.d dVar) {
            this.a = bVar;
            this.b = str;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.mbbanner.a.c.b bVar = this.a;
            if (bVar != null) {
                com.anythink.expressad.foundation.d.d dVar = this.c;
                boolean unused = com.anythink.expressad.mbbanner.a.e.a.this.c;
                bVar.a(dVar);
            }
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.e.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.mbbanner.a.c.b a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass2(com.anythink.expressad.mbbanner.a.c.b bVar, java.lang.String str, java.lang.String str2) {
            this.a = bVar;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.mbbanner.a.c.b bVar = this.a;
            if (bVar != null) {
                java.lang.String str = this.c;
                boolean unused = com.anythink.expressad.mbbanner.a.e.a.this.c;
                bVar.a(str);
            }
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.e.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.mbbanner.a.c.b a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass3(com.anythink.expressad.mbbanner.a.c.b bVar, java.lang.String str) {
            this.a = bVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.mbbanner.a.c.b bVar = this.a;
            if (bVar != null) {
                boolean unused = com.anythink.expressad.mbbanner.a.e.a.this.c;
                bVar.a();
            }
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.e.a$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.mbbanner.a.c.b a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass4(com.anythink.expressad.mbbanner.a.c.b bVar, java.lang.String str) {
            this.a = bVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.mbbanner.a.c.b bVar = this.a;
            if (bVar != null) {
                boolean unused = com.anythink.expressad.mbbanner.a.e.a.this.c;
                bVar.b();
            }
        }
    }

    private void a(com.anythink.expressad.mbbanner.a.c.b bVar, com.anythink.expressad.foundation.d.d dVar, java.lang.String str) {
        this.b.post(new com.anythink.expressad.mbbanner.a.e.a.AnonymousClass1(bVar, str, dVar));
    }

    private void a(boolean z) {
        this.c = z;
    }

    public final void a(com.anythink.expressad.mbbanner.a.c.b bVar, java.lang.String str) {
        this.b.post(new com.anythink.expressad.mbbanner.a.e.a.AnonymousClass3(bVar, str));
    }

    public final void a(com.anythink.expressad.mbbanner.a.c.b bVar, java.lang.String str, java.lang.String str2) {
        this.b.post(new com.anythink.expressad.mbbanner.a.e.a.AnonymousClass2(bVar, str2, str));
    }

    public final void b(com.anythink.expressad.mbbanner.a.c.b bVar, java.lang.String str) {
        this.b.post(new com.anythink.expressad.mbbanner.a.e.a.AnonymousClass4(bVar, str));
    }
}
