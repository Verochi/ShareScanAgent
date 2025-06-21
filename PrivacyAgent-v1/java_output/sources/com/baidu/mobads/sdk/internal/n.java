package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class n {
    private int a;
    private java.lang.String b;

    private static com.baidu.mobads.sdk.internal.n a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        java.lang.String optString = jSONObject.optString("name", "");
        if (optInt == -1 || android.text.TextUtils.isEmpty(optString)) {
            return null;
        }
        com.baidu.mobads.sdk.internal.n nVar = new com.baidu.mobads.sdk.internal.n();
        nVar.a = optInt;
        nVar.b = optString;
        return nVar;
    }

    public static java.util.List<com.baidu.mobads.sdk.api.CpuChannelResponse> a(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    com.baidu.mobads.sdk.internal.n a = a(jSONArray.getJSONObject(i));
                    if (a != null) {
                        arrayList.add(new com.baidu.mobads.sdk.api.CpuChannelResponse(a));
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public int a() {
        return this.a;
    }

    public java.lang.String b() {
        return this.b;
    }
}
