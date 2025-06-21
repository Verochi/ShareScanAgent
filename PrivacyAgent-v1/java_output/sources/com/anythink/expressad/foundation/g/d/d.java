package com.anythink.expressad.foundation.g.d;

/* loaded from: classes12.dex */
public final class d extends com.anythink.expressad.foundation.g.g.a {
    private static final java.lang.String a = "ImageWorker";
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private boolean h = false;
    private com.anythink.expressad.foundation.g.d.d.a i;

    /* renamed from: com.anythink.expressad.foundation.g.d.d$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.foundation.g.f.f<java.lang.Void> {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
        public final void a() {
        }

        @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
        public final void a(long j, long j2) {
        }

        @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
        public final void a(com.anythink.expressad.foundation.g.f.a.a aVar) {
            com.anythink.expressad.foundation.g.d.d dVar = com.anythink.expressad.foundation.g.d.d.this;
            dVar.b(dVar.f, "load image from http faild because http return code: " + aVar.a + ".image url is " + com.anythink.expressad.foundation.g.d.d.this.f);
        }

        @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
        public final void a(com.anythink.expressad.foundation.g.f.k kVar) {
            java.lang.String unused = com.anythink.expressad.foundation.g.d.d.this.g;
            com.anythink.expressad.foundation.g.d.d.this.d();
        }
    }

    public interface a {
        void a(java.lang.String str, java.lang.String str2);

        void b(java.lang.String str, java.lang.String str2);
    }

    public d(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.e = str;
        this.f = str2;
        this.g = str3;
    }

    private void a(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.foundation.g.d.d.a aVar = this.i;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.foundation.g.d.d.a aVar = this.i;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }

    private java.lang.String h() {
        return this.e;
    }

    private java.lang.String i() {
        return this.f;
    }

    private java.lang.String j() {
        return this.g;
    }

    private boolean k() {
        return this.h;
    }

    private com.anythink.expressad.foundation.g.d.d.a l() {
        return this.i;
    }

    private static void m() {
    }

    private void n() {
        try {
            java.io.File file = new java.io.File(this.g);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            com.anythink.expressad.foundation.g.f.h.a.a(file, this.f, new com.anythink.expressad.foundation.g.d.d.AnonymousClass1());
        } catch (java.lang.Exception e) {
            b(this.f, e.getMessage());
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        } catch (java.lang.OutOfMemoryError e2) {
            b(this.f, e2.getMessage());
        }
    }

    @Override // com.anythink.expressad.foundation.g.g.a
    public final void a() {
        if (this.h) {
            n();
            return;
        }
        if (android.text.TextUtils.isEmpty(this.g)) {
            b(this.f, "save path is null.");
            return;
        }
        java.io.File file = new java.io.File(this.g);
        if (!file.exists() || file.length() <= 0) {
            n();
        } else {
            d();
        }
    }

    public final void a(com.anythink.expressad.foundation.g.d.d.a aVar) {
        this.i = aVar;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    @Override // com.anythink.expressad.foundation.g.g.a
    public final void b() {
    }

    @Override // com.anythink.expressad.foundation.g.g.a
    public final void c() {
    }

    public final void d() {
        if (new java.io.File(this.g).length() <= 0) {
            b(this.f, "load image faild.because file[" + this.g + "] is not exist!");
            return;
        }
        java.lang.String str = this.f;
        java.lang.String str2 = this.g;
        com.anythink.expressad.foundation.g.d.d.a aVar = this.i;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }
}
