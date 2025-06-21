package com.anythink.expressad.exoplayer.d;

/* loaded from: classes12.dex */
final class a {
    private static final java.lang.String a = "ClearKeyUtil";

    private a() {
    }

    private static java.lang.String a(java.lang.String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    public static byte[] a(byte[] bArr) {
        if (com.anythink.expressad.exoplayer.k.af.a >= 27) {
            return bArr;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.anythink.expressad.exoplayer.k.af.a(bArr));
            java.lang.StringBuilder sb = new java.lang.StringBuilder("{\"keys\":[");
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(b(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(b(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return com.anythink.expressad.exoplayer.k.af.c(sb.toString());
        } catch (org.json.JSONException unused) {
            new java.lang.StringBuilder("Failed to adjust response data: ").append(com.anythink.expressad.exoplayer.k.af.a(bArr));
            return bArr;
        }
    }

    private static java.lang.String b(java.lang.String str) {
        return str.replace('-', '+').replace('_', '/');
    }

    private static byte[] b(byte[] bArr) {
        return com.anythink.expressad.exoplayer.k.af.a >= 27 ? bArr : com.anythink.expressad.exoplayer.k.af.c(com.anythink.expressad.exoplayer.k.af.a(bArr).replace('+', '-').replace('/', '_'));
    }
}
