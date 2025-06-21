package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class i extends com.anythink.core.common.f.x {
    public int a;
    public com.anythink.core.common.f.at b;
    public long c;

    @Override // com.anythink.core.common.f.x
    public final org.json.JSONObject a() {
        org.json.JSONObject F = this.b.F(this.a);
        if (F != null) {
            try {
                F.put("sdk_time", this.c);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return F;
    }
}
