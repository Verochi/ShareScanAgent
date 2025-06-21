package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dh {
    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        java.lang.String simpleName = obj.getClass().getSimpleName();
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str2, (java.lang.String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str2, ((java.lang.Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str2, ((java.lang.Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str2, ((java.lang.Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str2, ((java.lang.Long) obj).longValue());
        }
        edit.commit();
    }

    public static java.lang.Object b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        java.lang.String simpleName = obj.getClass().getSimpleName();
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str2, (java.lang.String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return java.lang.Integer.valueOf(sharedPreferences.getInt(str2, ((java.lang.Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str2, ((java.lang.Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return java.lang.Float.valueOf(sharedPreferences.getFloat(str2, ((java.lang.Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return java.lang.Long.valueOf(sharedPreferences.getLong(str2, ((java.lang.Long) obj).longValue()));
        }
        return null;
    }
}
