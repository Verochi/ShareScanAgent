package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class gp {
    private static java.util.HashMap<java.lang.String, java.lang.String> a = new java.util.HashMap<>();

    public static java.lang.String a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str) {
        if (fhVar == null || android.text.TextUtils.isEmpty(fhVar.a())) {
            return null;
        }
        java.lang.String str2 = a.get(fhVar.a() + str);
        if (!android.text.TextUtils.isEmpty(str2)) {
            return str2;
        }
        java.lang.String str3 = str + fhVar.a();
        return (context == null || android.text.TextUtils.isEmpty(str3)) ? "" : com.amap.api.mapcore.util.fi.a(com.amap.api.mapcore.util.et.b(com.amap.api.mapcore.util.fi.e(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
    }

    public static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2) {
        if (fhVar == null || android.text.TextUtils.isEmpty(fhVar.a())) {
            return;
        }
        java.lang.String str3 = str + fhVar.a();
        a.put(fhVar.a() + str, str2);
        if (context == null || android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        java.lang.String g = com.amap.api.mapcore.util.fi.g(com.amap.api.mapcore.util.et.a(com.amap.api.mapcore.util.fi.a(str2)));
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        edit.putString(str3, g);
        edit.commit();
    }
}
