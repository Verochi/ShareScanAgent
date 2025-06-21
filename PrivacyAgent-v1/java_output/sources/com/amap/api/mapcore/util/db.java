package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class db {
    public static java.lang.Long a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Long l) {
        java.lang.Object b = b(context, str, str2, l);
        return b != null ? (java.lang.Long) b : l;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Object b = b(context, str, str2, str3);
        return b != null ? (java.lang.String) b : str3;
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        if (context == null) {
            return;
        }
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (obj instanceof java.lang.String) {
            edit.putString(str2, (java.lang.String) obj);
        } else if (obj instanceof java.lang.Integer) {
            edit.putInt(str2, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.Boolean) {
            edit.putBoolean(str2, ((java.lang.Boolean) obj).booleanValue());
        } else if (obj instanceof java.lang.Float) {
            edit.putFloat(str2, ((java.lang.Float) obj).floatValue());
        } else if (obj instanceof java.lang.Long) {
            edit.putLong(str2, ((java.lang.Long) obj).longValue());
        } else {
            edit.putString(str2, obj.toString());
        }
        edit.apply();
    }

    private static java.lang.Object b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        if (context == null) {
            return null;
        }
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (obj instanceof java.lang.String) {
            return sharedPreferences.getString(str2, (java.lang.String) obj);
        }
        if (obj instanceof java.lang.Integer) {
            return java.lang.Integer.valueOf(sharedPreferences.getInt(str2, ((java.lang.Integer) obj).intValue()));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str2, ((java.lang.Boolean) obj).booleanValue()));
        }
        if (obj instanceof java.lang.Float) {
            return java.lang.Float.valueOf(sharedPreferences.getFloat(str2, ((java.lang.Float) obj).floatValue()));
        }
        if (obj instanceof java.lang.Long) {
            return java.lang.Long.valueOf(sharedPreferences.getLong(str2, ((java.lang.Long) obj).longValue()));
        }
        return null;
    }
}
