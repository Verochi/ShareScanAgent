package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class v {
    public static final java.lang.String a = "H+tU+FeXHM==";
    public static final java.lang.String b = "cv";
    private static final java.lang.String c = "anythink_share_date";

    private static void a() {
        android.content.SharedPreferences.Editor edit = com.anythink.expressad.foundation.b.a.b().d().getApplicationContext().getSharedPreferences(b, 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void a(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(c, 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        java.lang.String simpleName = obj.getClass().getSimpleName();
        if (context == null) {
            return;
        }
        android.content.SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(c, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, (java.lang.String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((java.lang.Long) obj).longValue());
        }
        edit.apply();
    }

    private static void a(android.content.Context context, java.lang.String... strArr) {
        android.content.SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(c, 0).edit();
        for (java.lang.String str : strArr) {
            edit.remove(str);
        }
        edit.apply();
    }

    private static void a(java.lang.String str) {
        android.content.SharedPreferences.Editor edit = com.anythink.expressad.foundation.b.a.b().d().getApplicationContext().getSharedPreferences(b, 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static java.lang.Object b(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        if (context == null) {
            return obj;
        }
        java.lang.String simpleName = obj != null ? obj.getClass().getSimpleName() : "";
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(c, 0);
        return "String".equals(simpleName) ? sharedPreferences.getString(str, (java.lang.String) obj) : "Integer".equals(simpleName) ? java.lang.Integer.valueOf(sharedPreferences.getInt(str, ((java.lang.Integer) obj).intValue())) : "Boolean".equals(simpleName) ? java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str, ((java.lang.Boolean) obj).booleanValue())) : "Float".equals(simpleName) ? java.lang.Float.valueOf(sharedPreferences.getFloat(str, ((java.lang.Float) obj).floatValue())) : "Long".equals(simpleName) ? java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue())) : obj;
    }

    private static void c(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        java.lang.String simpleName = obj.getClass().getSimpleName();
        android.content.SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(b, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, (java.lang.String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((java.lang.Long) obj).longValue());
        }
        edit.apply();
    }

    private static java.lang.Object d(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        java.lang.String simpleName = obj != null ? obj.getClass().getSimpleName() : "";
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(b, 0);
        return "String".equals(simpleName) ? sharedPreferences.getString(str, (java.lang.String) obj) : "Integer".equals(simpleName) ? java.lang.Integer.valueOf(sharedPreferences.getInt(str, ((java.lang.Integer) obj).intValue())) : "Boolean".equals(simpleName) ? java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str, ((java.lang.Boolean) obj).booleanValue())) : "Float".equals(simpleName) ? java.lang.Float.valueOf(sharedPreferences.getFloat(str, ((java.lang.Float) obj).floatValue())) : "Long".equals(simpleName) ? java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue())) : obj;
    }
}
