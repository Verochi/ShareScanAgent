package com.xiaomi.a.a;

/* loaded from: classes19.dex */
public final class b extends com.xiaomi.a.a.d {
    public java.lang.String a;
    public int b;
    public long c;
    public java.lang.String d;

    @Override // com.xiaomi.a.a.d
    public final org.json.JSONObject a() {
        try {
            org.json.JSONObject a = super.a();
            if (a == null) {
                return null;
            }
            a.put(com.heytap.mcssdk.constant.b.k, this.a);
            a.put("eventType", this.b);
            a.put("eventTime", this.c);
            java.lang.String str = this.d;
            if (str == null) {
                str = "";
            }
            a.put("eventContent", str);
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
