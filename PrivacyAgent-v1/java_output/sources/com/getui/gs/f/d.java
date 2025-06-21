package com.getui.gs.f;

/* loaded from: classes22.dex */
public final class d extends com.getui.gs.f.a {
    private final int c;
    private final java.lang.String d;
    private final java.lang.String e;
    private java.util.List<com.getui.gs.g.e> f;

    public d(int i) {
        java.lang.String str;
        this.c = i;
        if (i == 8) {
            this.d = "%s/sdk/v2/bbt";
            str = "8";
        } else {
            if (i != 11) {
                throw new java.lang.IllegalArgumentException("illegal type : ".concat(java.lang.String.valueOf(i)));
            }
            this.d = "%s/sdk/v2/bgbt";
            str = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        }
        this.e = str;
    }

    private static java.lang.String a(java.util.List<com.getui.gs.g.e> list, int i, int i2) {
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
        int i = this.c;
        if (i == 8) {
            return com.getui.gs.ias.core.a.d();
        }
        if (i == 11) {
            return com.getui.gs.ias.core.a.e();
        }
        throw new java.lang.IllegalArgumentException("illegal type : " + this.c);
    }

    @Override // com.getui.gs.f.a
    public final void a(int i, int i2) throws java.lang.Throwable {
        com.getui.gs.b.e eVar;
        java.util.List<com.getui.gs.g.e> list = this.f;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f.size();
        if (i < 0 || i2 > size - 1) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        com.getui.gs.e.g.a(this.c, this.d, this.e, this.f, i, i2);
        eVar = com.getui.gs.b.e.a.a;
        eVar.c.a(a(this.f, i, i2));
        com.getui.gs.h.a.a(this + " upload patch success: size(" + ((i2 - i) + 1) + "), " + com.getui.gs.h.d.a(this.f, i, i2) + "， " + e());
    }

    @Override // com.getui.gs.f.a
    public final int b() {
        return com.getui.gs.c.a.a(this.c == 8 ? "sdk.ido.type8.patch.size" : "sdk.ido.type11.patch.size", 5);
    }

    @Override // com.getui.gs.f.a
    public final boolean c() {
        if (java.lang.System.currentTimeMillis() - this.b >= e()) {
            return true;
        }
        com.getui.gs.h.b.a.a.a.d(this + " upload task is waiting for interval : " + e());
        return false;
    }

    @Override // com.getui.gs.f.a
    public final int d() {
        com.getui.gs.b.e eVar;
        eVar = com.getui.gs.b.e.a.a;
        java.util.List<com.getui.gs.g.e> a = eVar.c.a(this.c);
        this.f = a;
        if (a == null) {
            return 0;
        }
        return a.size();
    }

    public final java.lang.String toString() {
        return "type" + this.c;
    }
}
