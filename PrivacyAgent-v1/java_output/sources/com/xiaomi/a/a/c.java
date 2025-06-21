package com.xiaomi.a.a;

/* loaded from: classes19.dex */
public final class c extends com.xiaomi.a.a.d {
    public int a;
    public long b = -1;
    public long c = -1;

    @Override // com.xiaomi.a.a.d
    public final org.json.JSONObject a() {
        try {
            org.json.JSONObject a = super.a();
            if (a == null) {
                return null;
            }
            a.put("code", this.a);
            a.put("perfCounts", this.b);
            a.put("perfLatencies", this.c);
            return a;
        } catch (org.json.JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    @Override // com.xiaomi.a.a.d
    public final java.lang.String b() {
        return super.b();
    }
}
