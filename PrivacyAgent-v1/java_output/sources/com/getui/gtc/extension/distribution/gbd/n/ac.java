package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class ac {
    public static final java.lang.String a = "us";
    public static final java.lang.String b = "uis";
    public static final java.lang.String c = "ua";
    public static final java.lang.String d = "logkey";
    private static final java.lang.String e = "SpUtils";
    private static final java.lang.String f = "getui_sp";

    private static void a(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(f, 0).edit();
        if (obj instanceof java.lang.String) {
            edit.putString(str, (java.lang.String) obj);
        } else if (obj instanceof java.lang.Integer) {
            edit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.Boolean) {
            edit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        } else if (obj instanceof java.lang.Float) {
            edit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else if (obj instanceof java.lang.Long) {
            edit.putLong(str, ((java.lang.Long) obj).longValue());
        }
        edit.commit();
    }

    private static java.lang.Object b(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(f, 0);
        return obj instanceof java.lang.String ? sharedPreferences.getString(str, (java.lang.String) obj) : obj instanceof java.lang.Integer ? java.lang.Integer.valueOf(sharedPreferences.getInt(str, ((java.lang.Integer) obj).intValue())) : obj instanceof java.lang.Boolean ? java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str, ((java.lang.Boolean) obj).booleanValue())) : obj instanceof java.lang.Float ? java.lang.Float.valueOf(sharedPreferences.getFloat(str, ((java.lang.Float) obj).floatValue())) : obj instanceof java.lang.Long ? java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue())) : obj;
    }
}
