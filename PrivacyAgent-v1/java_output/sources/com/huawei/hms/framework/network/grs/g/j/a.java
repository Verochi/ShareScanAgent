package com.huawei.hms.framework.network.grs.g.j;

/* loaded from: classes22.dex */
public class a {
    private static final java.lang.String a = "a";
    private static com.huawei.hms.framework.network.grs.g.k.d b;

    public static synchronized com.huawei.hms.framework.network.grs.g.k.d a(android.content.Context context) {
        synchronized (com.huawei.hms.framework.network.grs.g.j.a.class) {
            com.huawei.hms.framework.network.grs.g.k.d dVar = b;
            if (dVar != null) {
                return dVar;
            }
            java.lang.String a2 = com.huawei.hms.framework.network.grs.h.c.a(com.huawei.hms.framework.network.grs.GrsApp.getInstance().getBrand(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + "grs_sdk_server_config.json", context);
            java.util.ArrayList arrayList = null;
            if (android.text.TextUtils.isEmpty(a2)) {
                return null;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(a2).getJSONObject("grs_server");
                org.json.JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new java.util.ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.get(i).toString());
                    }
                }
                com.huawei.hms.framework.network.grs.g.k.d dVar2 = new com.huawei.hms.framework.network.grs.g.k.d();
                b = dVar2;
                dVar2.a(arrayList);
                b.b(jSONObject.getString("grs_query_endpoint_1.0"));
                b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                b.a(jSONObject.getInt("grs_query_timeout"));
            } catch (org.json.JSONException e) {
                com.huawei.hms.framework.common.Logger.w(a, "getGrsServerBean catch JSONException: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            }
            return b;
        }
    }
}
