package com.anythink.basead.f;

/* loaded from: classes12.dex */
public abstract class c implements com.anythink.basead.f.a {
    public static final java.lang.String h = "extra_request_id";
    public static final java.lang.String i = "extra_scenario";
    public static final java.lang.String j = "extra_orientation";
    public java.lang.String b = getClass().getSimpleName();
    protected android.content.Context c;
    protected com.anythink.core.common.f.m d;
    protected java.lang.String e;
    protected boolean f;
    protected com.anythink.core.common.f.z g;

    /* renamed from: com.anythink.basead.f.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.a.b.b.InterfaceC0129b {
        final /* synthetic */ com.anythink.basead.e.c a;

        public AnonymousClass1(com.anythink.basead.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.basead.a.b.b.InterfaceC0129b
        public final void a() {
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdCacheLoaded();
            }
        }

        @Override // com.anythink.basead.a.b.b.InterfaceC0129b
        public final void a(com.anythink.basead.c.e eVar) {
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdLoadFailed(eVar);
            }
        }
    }

    public c(android.content.Context context, com.anythink.core.common.f.m mVar, java.lang.String str, boolean z) {
        this.c = context.getApplicationContext();
        this.d = mVar;
        this.e = str;
        this.f = z;
    }

    private com.anythink.basead.c.e b() {
        if (android.text.TextUtils.isEmpty(this.e) || android.text.TextUtils.isEmpty(this.d.b)) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.v);
        }
        com.anythink.core.common.f.z a = com.anythink.basead.f.a.a.a(this.c).a(this.d.b, this.e);
        this.g = a;
        if (a == null) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.y);
        }
        if (this.d.n == null) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.j, com.anythink.basead.c.f.z);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[Catch: Exception -> 0x0062, TryCatch #0 {Exception -> 0x0062, blocks: (B:2:0x0000, B:5:0x000a, B:8:0x0015, B:10:0x0029, B:12:0x0049, B:15:0x004d, B:17:0x0030, B:19:0x0036, B:21:0x0041), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #0 {Exception -> 0x0062, blocks: (B:2:0x0000, B:5:0x000a, B:8:0x0015, B:10:0x0029, B:12:0x0049, B:15:0x004d, B:17:0x0030, B:19:0x0036, B:21:0x0041), top: B:1:0x0000 }] */
    @Override // com.anythink.basead.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.anythink.basead.e.c cVar) {
        com.anythink.basead.c.e a;
        try {
            if (!android.text.TextUtils.isEmpty(this.e) && !android.text.TextUtils.isEmpty(this.d.b)) {
                com.anythink.core.common.f.z a2 = com.anythink.basead.f.a.a.a(this.c).a(this.d.b, this.e);
                this.g = a2;
                a = a2 == null ? com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.y) : this.d.n == null ? com.anythink.basead.c.f.a(com.anythink.basead.c.f.j, com.anythink.basead.c.f.z) : null;
                if (a == null) {
                    cVar.onAdLoadFailed(a);
                    return;
                }
                com.anythink.basead.f.a.a a3 = com.anythink.basead.f.a.a.a(this.c);
                com.anythink.core.common.f.m mVar = this.d;
                a3.a(mVar.b, this.g, mVar, new com.anythink.basead.f.c.AnonymousClass1(cVar));
                return;
            }
            a = com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.v);
            if (a == null) {
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", e.getMessage()));
        }
    }

    @Override // com.anythink.basead.f.a
    public boolean a() {
        try {
            if (d()) {
                return com.anythink.basead.f.a.a.a(this.c).a(this.g, this.d, this.f);
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void c() {
    }

    public final boolean d() {
        if (this.c == null || android.text.TextUtils.isEmpty(this.d.b) || android.text.TextUtils.isEmpty(this.e)) {
            return false;
        }
        if (this.g != null) {
            return true;
        }
        com.anythink.core.common.f.z a = com.anythink.basead.f.a.a.a(this.c).a(this.d.b, this.e);
        this.g = a;
        return a != null;
    }

    public final com.anythink.core.common.f.z e() {
        return this.g;
    }
}
