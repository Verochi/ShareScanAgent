package com.anythink.expressad.foundation.g.f.h;

/* loaded from: classes12.dex */
public final class b {
    public static java.lang.String a = "a";
    public static java.lang.String b = "d";
    public static java.lang.String c = "e";
    private static final java.lang.String d = "b";
    private java.util.Map<java.lang.String, java.lang.String> e = new java.util.LinkedHashMap();
    private java.util.Map<java.lang.String, com.anythink.expressad.foundation.g.f.c.b> f = new java.util.LinkedHashMap();

    public b() {
    }

    private b(java.lang.String str, java.lang.String str2) {
        this.e.put(str, str2);
    }

    private b(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    private b(java.lang.String... strArr) {
        int length = strArr.length;
        if (length % 2 != 0) {
            throw new java.lang.IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < length; i += 2) {
            a(strArr[i], strArr[i + 1]);
        }
    }

    private void a(java.lang.String str) {
        this.e.remove(str);
        this.f.remove(str);
    }

    private void a(java.lang.String str, java.io.File file) {
        if (file == null || !file.exists()) {
            throw new java.io.FileNotFoundException();
        }
        java.lang.String name = android.text.TextUtils.isEmpty(null) ? file.getName() : null;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.f.put(str, new com.anythink.expressad.foundation.g.f.c.b(name, file, name, null));
    }

    private void a(java.lang.String str, java.io.File file, java.lang.String str2) {
        if (file == null || !file.exists()) {
            throw new java.io.FileNotFoundException();
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = file.getName();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.f.put(str, new com.anythink.expressad.foundation.g.f.c.b(str2, file, str2, null));
    }

    private void a(java.lang.String str, java.io.File file, java.lang.String str2, java.lang.String str3) {
        if (file == null || !file.exists()) {
            throw new java.io.FileNotFoundException();
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = file.getName();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.f.put(str, new com.anythink.expressad.foundation.g.f.c.b(str2, file, str2, str3));
    }

    private void a(java.util.Map<java.lang.String, ?> map) {
        if (map != null) {
            for (java.util.Map.Entry<java.lang.String, ?> entry : map.entrySet()) {
                java.lang.Object value = entry.getValue();
                if (value instanceof java.lang.String) {
                    a(entry.getKey(), (java.lang.String) entry.getValue());
                } else if (value instanceof java.io.File) {
                    java.lang.String key = entry.getKey();
                    java.io.File file = (java.io.File) entry.getValue();
                    if (file == null || !file.exists()) {
                        throw new java.io.FileNotFoundException();
                    }
                    java.lang.String name = android.text.TextUtils.isEmpty(null) ? file.getName() : null;
                    if (!android.text.TextUtils.isEmpty(key)) {
                        this.f.put(key, new com.anythink.expressad.foundation.g.f.c.b(name, file, name, null));
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private org.json.JSONObject c() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.e.entrySet()) {
                jSONObject.put(java.net.URLEncoder.encode(entry.getKey(), "UTF-8"), java.net.URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.foundation.g.f.c.b> entry2 : this.f.entrySet()) {
                jSONObject.put(java.net.URLEncoder.encode(entry2.getKey(), "UTF-8"), java.net.URLEncoder.encode("FILE_NAME_" + entry2.getValue().b().getName(), "UTF-8"));
            }
        } catch (java.io.UnsupportedEncodingException unused) {
        } catch (org.json.JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public final java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.e.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(kotlin.text.Typography.amp);
                }
                sb.append(java.net.URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(java.net.URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.e.put(str, str2);
    }

    public final java.util.Map<java.lang.String, java.lang.String> b() {
        return this.e;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(28);
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.e.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(kotlin.text.Typography.amp);
                }
                sb.append(java.net.URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(java.net.URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.foundation.g.f.c.b> entry2 : this.f.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(kotlin.text.Typography.amp);
                }
                sb.append(java.net.URLEncoder.encode(entry2.getKey(), "UTF-8"));
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(java.net.URLEncoder.encode("FILE_NAME_" + entry2.getValue().b().getName(), "UTF-8"));
            }
        } catch (java.io.UnsupportedEncodingException e) {
            e.getMessage();
        }
        return sb.toString();
    }
}
