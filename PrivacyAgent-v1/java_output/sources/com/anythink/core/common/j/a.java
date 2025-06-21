package com.anythink.core.common.j;

/* loaded from: classes12.dex */
public final class a implements com.anythink.core.common.j.d {
    java.lang.String a;
    java.lang.String b;
    com.anythink.core.common.j.b c;
    com.anythink.core.common.m.b d = new com.anythink.core.common.j.a.AnonymousClass1();

    /* renamed from: com.anythink.core.common.j.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.core.common.j.a.this.a()) {
                com.anythink.core.common.j.a.this.a(com.anythink.core.common.b.o.a().E(), 4);
            }
        }
    }

    public a(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.anythink.core.common.j.d
    public final void a(int i) {
        com.anythink.core.common.m.d.a().a(this.d, ((long) java.lang.Math.pow(2.0d, i)) * 1000, false);
    }

    @Override // com.anythink.core.common.j.d
    public final void a(android.content.Context context, int i) {
        com.anythink.core.common.f.v vVar = new com.anythink.core.common.f.v();
        vVar.a(context);
        vVar.d = i;
        com.anythink.core.common.f.a(context, this.a, this.b).b(context, this.b, this.a, vVar, null);
    }

    @Override // com.anythink.core.common.j.d
    public final void a(com.anythink.core.api.AdError adError, int i) {
        if (a()) {
            com.anythink.core.common.m.d.a().a(this.d, ((long) java.lang.Math.pow(2.0d, i)) * 1000, false);
            com.anythink.core.common.j.b bVar = this.c;
            if (bVar != null) {
                bVar.a(this.a, adError);
            }
        }
    }

    @Override // com.anythink.core.common.j.d
    public final void a(com.anythink.core.common.j.b bVar) {
        this.c = bVar;
    }

    @Override // com.anythink.core.common.j.d
    public final boolean a() {
        return com.anythink.core.common.u.a().e(this.a);
    }

    @Override // com.anythink.core.common.j.d
    public final void b() {
        com.anythink.core.common.j.b bVar;
        if (!a() || (bVar = this.c) == null) {
            return;
        }
        bVar.a(this.a);
    }

    @Override // com.anythink.core.common.j.d
    public final void c() {
        com.anythink.core.common.m.d.a().b(this.d);
    }
}
