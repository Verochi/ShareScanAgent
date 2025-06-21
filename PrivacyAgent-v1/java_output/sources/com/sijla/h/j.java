package com.sijla.h;

/* loaded from: classes19.dex */
public final class j {
    private int a = 403;
    private java.lang.Object b;

    public static void a(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        java.lang.String obj2;
        long longValue;
        try {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences("qtsession", 0).edit();
            if (!(obj instanceof java.lang.String)) {
                if (!(obj instanceof java.lang.Integer)) {
                    if (obj instanceof java.lang.Boolean) {
                        edit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
                    } else if (obj instanceof java.lang.Float) {
                        edit.putFloat(str, ((java.lang.Float) obj).floatValue());
                    } else if (obj instanceof java.lang.Long) {
                        longValue = ((java.lang.Long) obj).longValue();
                    } else {
                        obj2 = obj.toString();
                    }
                    edit.apply();
                }
                longValue = ((java.lang.Long) obj).longValue();
                edit.putLong(str, longValue);
                edit.apply();
            }
            obj2 = (java.lang.String) obj;
            edit.putString(str, obj2);
            edit.apply();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static java.lang.Object b(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        try {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("qtsession", 0);
            if (obj instanceof java.lang.String) {
                return sharedPreferences.getString(str, (java.lang.String) obj);
            }
            if (obj instanceof java.lang.Integer) {
                return java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue()));
            }
            if (obj instanceof java.lang.Boolean) {
                return java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str, ((java.lang.Boolean) obj).booleanValue()));
            }
            if (obj instanceof java.lang.Float) {
                return java.lang.Float.valueOf(sharedPreferences.getFloat(str, ((java.lang.Float) obj).floatValue()));
            }
            if (obj instanceof java.lang.Long) {
                return java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue()));
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final int a() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(java.lang.Object obj) {
        this.b = obj;
    }

    public final java.lang.Object b() {
        return this.b;
    }
}
