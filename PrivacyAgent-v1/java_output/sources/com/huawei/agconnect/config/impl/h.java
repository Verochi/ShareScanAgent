package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
class h implements com.huawei.agconnect.config.impl.d {
    public final org.json.JSONObject a;

    public h(java.io.InputStream inputStream) {
        this.a = b(inputStream);
    }

    public h(java.io.InputStream inputStream, java.lang.String str) {
        this.a = b(inputStream);
        c(str);
    }

    @Override // com.huawei.agconnect.config.impl.d
    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return str2;
        }
        java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        try {
            org.json.JSONObject jSONObject = this.a;
            for (int i = 1; i < split.length; i++) {
                if (i == split.length - 1) {
                    str = jSONObject.get(split[i]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(split[i]);
            }
        } catch (org.json.JSONException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("JSONException when reading 'path': ");
            sb.append(str);
        }
        return str2;
    }

    public final org.json.JSONObject b(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new org.json.JSONObject(com.huawei.agconnect.config.impl.Utils.toString(inputStream, "UTF-8"));
            } catch (java.io.IOException | org.json.JSONException unused) {
            }
        }
        return new org.json.JSONObject();
    }

    public final void c(java.lang.String str) {
        try {
            org.json.JSONObject e = e(str);
            if (e == null) {
                return;
            }
            java.lang.String a = a("/configuration_version", "");
            java.math.BigDecimal bigDecimal = new java.math.BigDecimal(com.baidu.mobads.sdk.internal.cl.d);
            try {
                bigDecimal = java.math.BigDecimal.valueOf(java.lang.Double.parseDouble(a));
            } catch (java.lang.NumberFormatException unused) {
            }
            if (bigDecimal.compareTo(new java.math.BigDecimal("2.0")) == 0) {
                this.a.getJSONObject("client").put("app_id", e.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new java.math.BigDecimal("3.0")) >= 0) {
                java.util.Iterator<java.lang.String> keys = e.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    if (!"package_name".equals(next)) {
                        d(next, e.get(next), this.a);
                    }
                }
            }
        } catch (org.json.JSONException unused2) {
        }
    }

    public final void d(java.lang.String str, java.lang.Object obj, org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof org.json.JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        org.json.JSONObject jSONObject2 = (org.json.JSONObject) obj;
        java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            d(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    public final org.json.JSONObject e(java.lang.String str) throws org.json.JSONException {
        org.json.JSONArray jSONArray = this.a.getJSONArray("appInfos");
        for (int i = 0; i < jSONArray.length(); i++) {
            org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    public java.lang.String toString() {
        return "InputStreamReader{config=" + this.a.toString().hashCode() + '}';
    }
}
