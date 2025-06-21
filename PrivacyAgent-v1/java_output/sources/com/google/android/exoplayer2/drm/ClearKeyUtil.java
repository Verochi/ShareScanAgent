package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
final class ClearKeyUtil {
    public static byte[] a(byte[] bArr) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 27 ? bArr : com.google.android.exoplayer2.util.Util.getUtf8Bytes(c(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 27) {
            return bArr;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr));
            java.lang.StringBuilder sb = new java.lang.StringBuilder("{\"keys\":[");
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return com.google.android.exoplayer2.util.Util.getUtf8Bytes(sb.toString());
        } catch (org.json.JSONException e) {
            java.lang.String valueOf = java.lang.String.valueOf(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr));
            com.google.android.exoplayer2.util.Log.e("ClearKeyUtil", valueOf.length() != 0 ? "Failed to adjust response data: ".concat(valueOf) : new java.lang.String("Failed to adjust response data: "), e);
            return bArr;
        }
    }

    public static java.lang.String c(java.lang.String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    public static java.lang.String d(java.lang.String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
