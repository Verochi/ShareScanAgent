package com.anythink.core.c.a;

/* loaded from: classes12.dex */
public final class a {
    public static final int a = 10;
    public static final int b = 4;
    private int c;
    private java.lang.String d;
    private java.lang.String e;
    private int f;
    private java.lang.String g;
    private java.lang.String h;
    private double i;
    private long j;
    private java.lang.String k;

    private static void a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.Object obj) {
        if (obj == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if ((obj instanceof java.lang.String) && ((java.lang.String) obj).isEmpty()) {
            return;
        }
        if ((obj instanceof java.lang.Integer) && ((java.lang.Integer) obj).intValue() == 0) {
            return;
        }
        if ((obj instanceof java.lang.Long) && ((java.lang.Long) obj).longValue() == 0) {
            return;
        }
        if ((obj instanceof java.lang.Double) && ((java.lang.Double) obj).doubleValue() == 0.0d) {
            return;
        }
        if (str.equals("ecpm")) {
            jSONObject.put(str, java.lang.String.valueOf(obj));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public final java.lang.String a() {
        return this.e;
    }

    public final void a(double d) {
        this.i = d;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a(long j) {
        this.j = j;
    }

    public final void a(java.lang.String str) {
        this.e = str;
    }

    public final int b() {
        return this.f;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final void b(java.lang.String str) {
        this.g = str;
    }

    public final java.lang.String c() {
        return this.g;
    }

    public final void c(java.lang.String str) {
        this.h = str;
    }

    public final java.lang.String d() {
        return this.h;
    }

    public final void d(java.lang.String str) {
        this.k = str;
    }

    public final double e() {
        return this.i;
    }

    public final void e(java.lang.String str) {
        this.d = str;
    }

    public final long f() {
        return this.j;
    }

    public final java.lang.String g() {
        return this.k;
    }

    public final org.json.JSONObject h() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            a(jSONObject, com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, this.e);
            a(jSONObject, "unit_id", this.g);
            a(jSONObject, "dsp_id", this.h);
            a(jSONObject, "ecpm", java.lang.Double.valueOf(this.i));
            a(jSONObject, "ts", java.lang.Long.valueOf(this.j));
            a(jSONObject, "lc_id", this.k);
            a(jSONObject, "nw_firm_id", java.lang.Integer.valueOf(this.f));
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    public final java.lang.String i() {
        return this.d;
    }

    public final int j() {
        return this.c;
    }

    public final java.lang.String toString() {
        return "PlacementStatisticsBean{requestId='" + this.e + "', networkFirmId=" + this.f + ", adSourceId='" + this.g + "', dspId='" + this.h + "', price=" + this.i + ", recordTime=" + this.j + ", psId='" + this.k + "', placementId='" + this.d + "', type= " + this.c + '}';
    }
}
