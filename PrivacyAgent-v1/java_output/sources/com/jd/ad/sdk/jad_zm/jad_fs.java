package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public class jad_fs {
    public static final java.util.TimeZone jad_bo = java.util.TimeZone.getTimeZone("GMT");
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> jad_an = new java.util.TreeMap();

    public static java.util.Map<java.lang.String, java.lang.String> jad_an(com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : jad_fsVar.jad_an.entrySet()) {
            linkedHashMap.put(entry.getKey(), android.text.TextUtils.join("; ", entry.getValue()));
        }
        return linkedHashMap;
    }

    public java.lang.String jad_an(java.lang.String str) {
        java.util.List<java.lang.String> list = this.jad_an.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public void jad_an(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        if (!this.jad_an.containsKey(str)) {
            this.jad_an.put(str, new java.util.ArrayList(1));
        }
        this.jad_an.get(str).add(str2);
    }

    public void jad_bo(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.jad_an.remove(str);
        jad_an(str, str2);
    }
}
