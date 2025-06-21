package com.getui.gs.f;

/* loaded from: classes22.dex */
public final class b extends com.getui.gs.f.a {
    private final com.getui.gs.d.a.EnumC0289a c;
    private final java.lang.String d;
    private final java.lang.String e;
    private final long f;
    private java.util.List<com.getui.gs.d.a> g;

    public b(com.getui.gs.d.a.EnumC0289a enumC0289a) {
        int a;
        long eventForceUploadSize;
        this.c = enumC0289a;
        if (enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
            this.d = "%s/sdk/v2/uud";
            this.e = "upload profile";
            a = com.getui.gs.c.a.a("sdk.ido.type14.forceUpload.size", 5);
            eventForceUploadSize = com.getui.gs.ias.core.GsConfig.getProfileForceUploadSize();
        } else {
            if (enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL && enumC0289a != com.getui.gs.d.a.EnumC0289a.TYPE_DURATION) {
                throw new java.lang.IllegalArgumentException("illegal type : ".concat(java.lang.String.valueOf(enumC0289a)));
            }
            this.d = "%s/sdk/v2/ued";
            this.e = "upload event";
            a = com.getui.gs.c.a.a("sdk.ido.type13.forceUpload.size", 30);
            eventForceUploadSize = com.getui.gs.ias.core.GsConfig.getEventForceUploadSize();
        }
        this.f = java.lang.Math.max(eventForceUploadSize, a);
    }

    private static java.lang.String a(java.util.List<com.getui.gs.d.a> list, int i, int i2) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (i <= i2) {
            sb.append(list.get(i).a);
            sb.append(",");
            i++;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private long e() {
        com.getui.gs.d.a.EnumC0289a enumC0289a = this.c;
        if (enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
            return com.getui.gs.ias.core.a.g();
        }
        if (enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_NORMAL || enumC0289a == com.getui.gs.d.a.EnumC0289a.TYPE_DURATION) {
            return com.getui.gs.ias.core.a.f();
        }
        throw new java.lang.IllegalArgumentException("illegal type : " + this.c);
    }

    @Override // com.getui.gs.f.a
    public final void a(int i, int i2) throws java.lang.Throwable {
        com.getui.gs.b.e eVar;
        java.util.List<com.getui.gs.d.a> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.g.size();
        if (i < 0 || i2 > size - 1) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        com.getui.gs.e.c.a(this.c, this.d, this.e, this.g, i, i2);
        eVar = com.getui.gs.b.e.a.a;
        eVar.b.a(a(this.g, i, i2));
        com.getui.gs.h.a.a(this + " upload patch success: size(" + ((i2 - i) + 1) + "), " + com.getui.gs.h.d.a(this.g, i, i2) + "， " + e());
    }

    @Override // com.getui.gs.f.a
    public final int b() {
        return com.getui.gs.c.a.a(this.c == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE ? "sdk.ido.type14.patch.size" : "sdk.ido.type13.patch.size", 20);
    }

    @Override // com.getui.gs.f.a
    public final boolean c() {
        com.getui.gs.b.e eVar;
        long a;
        com.getui.gs.b.e eVar2;
        if (java.lang.System.currentTimeMillis() - this.b >= e()) {
            return true;
        }
        if (this.c == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
            eVar2 = com.getui.gs.b.e.a.a;
            a = eVar2.b.c();
        } else {
            eVar = com.getui.gs.b.e.a.a;
            a = eVar.b.a();
        }
        if (a >= this.f) {
            return true;
        }
        com.getui.gs.h.b.a.a.a.d(this + " upload task is waiting for interval : " + e());
        return false;
    }

    @Override // com.getui.gs.f.a
    public final int d() {
        com.getui.gs.b.e eVar;
        java.util.List<com.getui.gs.d.a> b;
        com.getui.gs.b.e eVar2;
        if (this.c == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE) {
            eVar2 = com.getui.gs.b.e.a.a;
            b = eVar2.b.d();
        } else {
            eVar = com.getui.gs.b.e.a.a;
            b = eVar.b.b();
        }
        this.g = b;
        java.util.List<com.getui.gs.d.a> list = this.g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final java.lang.String toString() {
        return this.c == com.getui.gs.d.a.EnumC0289a.TYPE_PROFILE ? com.google.android.gms.common.Scopes.PROFILE : "event";
    }
}
