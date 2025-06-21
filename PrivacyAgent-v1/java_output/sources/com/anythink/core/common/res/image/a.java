package com.anythink.core.common.res.image;

/* loaded from: classes12.dex */
public final class a extends com.anythink.core.common.res.image.b {
    com.anythink.core.common.res.e a;
    com.anythink.core.common.res.image.a.InterfaceC0172a b;

    /* renamed from: com.anythink.core.common.res.image.a$a, reason: collision with other inner class name */
    public interface InterfaceC0172a {
        void a(com.anythink.core.common.res.e eVar);

        void a(com.anythink.core.common.res.e eVar, java.lang.String str);
    }

    public a(com.anythink.core.common.res.e eVar) {
        super(eVar.f);
        this.a = eVar;
    }

    @Override // com.anythink.core.common.res.image.b
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(com.anythink.core.common.o.b.d dVar) {
        com.anythink.core.common.o.b.b.a().a(dVar, 4);
    }

    public final void a(com.anythink.core.common.res.image.a.InterfaceC0172a interfaceC0172a) {
        this.b = interfaceC0172a;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.res.image.a.InterfaceC0172a interfaceC0172a = this.b;
        if (interfaceC0172a != null) {
            interfaceC0172a.a(this.a, str2);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    public final boolean a(java.io.InputStream inputStream) {
        com.anythink.core.common.res.d a = com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f());
        com.anythink.core.common.res.e eVar = this.a;
        return a.a(eVar.e, com.anythink.core.common.o.g.a(eVar.f), inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    public final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    public final void c() {
        com.anythink.core.common.res.image.a.InterfaceC0172a interfaceC0172a = this.b;
        if (interfaceC0172a != null) {
            interfaceC0172a.a(this.a);
        }
    }
}
