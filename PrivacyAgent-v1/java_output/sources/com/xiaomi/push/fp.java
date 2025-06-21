package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class fp extends com.xiaomi.push.fn {
    java.lang.String a;
    com.xiaomi.push.fp.a b;
    private com.xiaomi.push.fp.b c;
    private int d;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public fp(android.os.Bundle bundle) {
        super(bundle);
        this.c = com.xiaomi.push.fp.b.available;
        this.a = null;
        this.d = Integer.MIN_VALUE;
        this.b = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.c = com.xiaomi.push.fp.b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.a = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.d = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.b = com.xiaomi.push.fp.a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public fp(com.xiaomi.push.fp.b bVar) {
        this.c = com.xiaomi.push.fp.b.available;
        this.a = null;
        this.d = Integer.MIN_VALUE;
        this.b = null;
        if (bVar == null) {
            throw new java.lang.NullPointerException("Type cannot be null");
        }
        this.c = bVar;
    }

    @Override // com.xiaomi.push.fn
    public final android.os.Bundle a() {
        android.os.Bundle a2 = super.a();
        com.xiaomi.push.fp.b bVar = this.c;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        java.lang.String str = this.a;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i = this.d;
        if (i != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i);
        }
        com.xiaomi.push.fp.a aVar = this.b;
        if (aVar != null && aVar != com.xiaomi.push.fp.a.available) {
            a2.putString("ext_pres_mode", aVar.toString());
        }
        return a2;
    }

    public final void a(int i) {
        if (i >= -128 && i <= 128) {
            this.d = i;
            return;
        }
        throw new java.lang.IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
    }

    @Override // com.xiaomi.push.fn
    public final java.lang.String b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<presence");
        if (this.p != null) {
            sb.append(" xmlns=\"");
            sb.append(this.p);
            sb.append("\"");
        }
        if (d() != null) {
            sb.append(" id=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (this.r != null) {
            sb.append(" to=\"");
            sb.append(com.xiaomi.push.fy.a(this.r));
            sb.append("\"");
        }
        if (this.f466s != null) {
            sb.append(" from=\"");
            sb.append(com.xiaomi.push.fy.a(this.f466s));
            sb.append("\"");
        }
        if (this.t != null) {
            sb.append(" chid=\"");
            sb.append(com.xiaomi.push.fy.a(this.t));
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" type=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.a != null) {
            sb.append("<status>");
            sb.append(com.xiaomi.push.fy.a(this.a));
            sb.append("</status>");
        }
        if (this.d != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.d);
            sb.append("</priority>");
        }
        com.xiaomi.push.fp.a aVar = this.b;
        if (aVar != null && aVar != com.xiaomi.push.fp.a.available) {
            sb.append("<show>");
            sb.append(this.b);
            sb.append("</show>");
        }
        sb.append(e());
        com.xiaomi.push.fr frVar = this.v;
        if (frVar != null) {
            sb.append(frVar.b());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
