package com.hihonor.push.sdk.utils;

/* loaded from: classes22.dex */
public class PushPreferences {
    public android.content.SharedPreferences mSharePreferences;

    public PushPreferences(android.content.Context context, java.lang.String str) {
        android.content.Context createDeviceProtectedStorageContext;
        boolean moveSharedPreferencesFrom;
        if (context == null) {
            throw new java.lang.NullPointerException("context is null!");
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            android.content.SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
            if (!sharedPreferences.getBoolean(str, false)) {
                moveSharedPreferencesFrom = createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str);
                if (moveSharedPreferencesFrom) {
                    android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                }
            }
            context = createDeviceProtectedStorageContext;
        }
        this.mSharePreferences = context.getSharedPreferences(str, 0);
    }

    public boolean clear() {
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.edit().clear().commit();
        }
        return false;
    }

    public boolean containsKey(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public java.util.Map<java.lang.String, ?> getAll() {
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        return sharedPreferences != null ? sharedPreferences.getAll() : new java.util.HashMap();
    }

    public boolean getBoolean(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        return sharedPreferences != null && sharedPreferences.getBoolean(str, false);
    }

    public int getInt(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    public long getLong(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0L);
        }
        return 0L;
    }

    public java.lang.String getString(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    public boolean removeKey(java.lang.String str) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (edit = this.mSharePreferences.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }

    public boolean saveBoolean(java.lang.String str, boolean z) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putBoolean(str, z).commit();
    }

    public boolean saveInt(java.lang.String str, java.lang.Integer num) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putInt(str, num.intValue()).commit();
    }

    public boolean saveLong(java.lang.String str, java.lang.Long l) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putLong(str, l.longValue()).commit();
    }

    public boolean saveString(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }
}
