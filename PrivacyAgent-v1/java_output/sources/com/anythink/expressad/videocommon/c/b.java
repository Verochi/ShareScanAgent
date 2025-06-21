package com.anythink.expressad.videocommon.c;

/* loaded from: classes12.dex */
public final class b {
    private int a;
    private int b;
    private com.anythink.expressad.videocommon.c.a c;

    public b(int i, int i2, com.anythink.expressad.videocommon.c.a aVar) {
        this.a = i;
        this.b = i2;
        this.c = aVar;
    }

    public static java.util.List<com.anythink.expressad.videocommon.c.b> a(org.json.JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    int optInt = optJSONObject.optInt("id");
                    int optInt2 = optJSONObject.optInt("timeout");
                    org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                    arrayList.add(new com.anythink.expressad.videocommon.c.b(optInt, optInt2, optJSONObject2 != null ? com.anythink.expressad.videocommon.c.a.a(optJSONObject2) : null));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }

    private void a(int i) {
        this.a = i;
    }

    private void a(com.anythink.expressad.videocommon.c.a aVar) {
        this.c = aVar;
    }

    private void b(int i) {
        this.b = i;
    }

    private com.anythink.expressad.videocommon.c.a c() {
        return this.c;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }
}
