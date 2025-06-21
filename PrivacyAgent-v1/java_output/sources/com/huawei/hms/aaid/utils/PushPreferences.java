package com.huawei.hms.aaid.utils;

/* loaded from: classes22.dex */
public class PushPreferences {
    public static final java.lang.String TAG = "PushPreferences";
    public android.content.SharedPreferences a;

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
        android.content.SharedPreferences b = b(context, str);
        this.a = b;
        if (b == null) {
            com.huawei.hms.support.log.HMSLog.w(TAG, "get new sharedPreferences failed,start to get from context. ");
            this.a = context.getSharedPreferences(str, 0);
        }
    }

    public final java.io.File a(android.content.Context context, java.lang.String str) {
        java.io.File file;
        java.io.File dataDir;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                dataDir = context.getDataDir();
                sb.append(dataDir);
                sb.append("/shared_prefs");
                file = new java.io.File(sb.toString(), str + ".xml");
            } else {
                file = new java.io.File(context.getFilesDir().getParent() + "/shared_prefs", str + ".xml");
            }
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "get failed error." + e.getMessage());
            return null;
        }
    }

    public final android.content.SharedPreferences b(android.content.Context context, java.lang.String str) {
        java.io.File a = a(context, str);
        if (a == null) {
            return null;
        }
        try {
            java.lang.reflect.Constructor<?> declaredConstructor = java.lang.Class.forName("android.app.SharedPreferencesImpl").getDeclaredConstructor(java.io.File.class, java.lang.Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return (android.content.SharedPreferences) declaredConstructor.newInstance(a, 0);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "get SharedPreferences error." + e.getMessage());
            return null;
        }
    }

    public boolean clear() {
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit().clear().commit();
        }
        return false;
    }

    public boolean containsKey(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public java.util.Map<java.lang.String, ?> getAll() {
        android.content.SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getAll() : new java.util.HashMap();
    }

    public boolean getBoolean(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null && sharedPreferences.getBoolean(str, false);
    }

    public int getInt(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    public long getLong(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0L);
        }
        return 0L;
    }

    public java.lang.String getString(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.a;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    public android.content.ContentValues read() {
        java.util.Map<java.lang.String, ?> all;
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) {
            return null;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        for (java.util.Map.Entry<java.lang.String, ?> entry : all.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.Object value = entry.getValue();
            if (value instanceof java.lang.String) {
                contentValues.put(key, java.lang.String.valueOf(value));
            } else if ((value instanceof java.lang.Integer) || (value instanceof java.lang.Short) || (value instanceof java.lang.Byte)) {
                contentValues.put(key, (java.lang.Integer) value);
            } else if (value instanceof java.lang.Long) {
                contentValues.put(key, (java.lang.Long) value);
            } else if (value instanceof java.lang.Float) {
                contentValues.put(key, (java.lang.Float) value);
            } else if (value instanceof java.lang.Double) {
                contentValues.put(key, java.lang.Float.valueOf((float) ((java.lang.Double) value).doubleValue()));
            } else if (value instanceof java.lang.Boolean) {
                contentValues.put(key, (java.lang.Boolean) value);
            }
        }
        return contentValues;
    }

    public boolean removeKey(java.lang.String str) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (edit = this.a.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }

    public boolean removeKey(java.lang.String[] strArr) {
        if (this.a == null) {
            return false;
        }
        for (java.lang.String str : strArr) {
            if (this.a.contains(str)) {
                this.a.edit().remove(str);
            }
        }
        this.a.edit().commit();
        return true;
    }

    public boolean save(java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return false;
        }
        android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
        if (obj instanceof java.lang.String) {
            edit.putString(str, java.lang.String.valueOf(obj));
        } else if (obj instanceof java.lang.Integer) {
            edit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.Short) {
            edit.putInt(str, ((java.lang.Short) obj).shortValue());
        } else if (obj instanceof java.lang.Byte) {
            edit.putInt(str, ((java.lang.Byte) obj).byteValue());
        } else if (obj instanceof java.lang.Long) {
            edit.putLong(str, ((java.lang.Long) obj).longValue());
        } else if (obj instanceof java.lang.Float) {
            edit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else if (obj instanceof java.lang.Double) {
            edit.putFloat(str, (float) ((java.lang.Double) obj).doubleValue());
        } else if (obj instanceof java.lang.Boolean) {
            edit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        }
        return edit.commit();
    }

    public void saveBoolean(java.lang.String str, boolean z) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putBoolean(str, z).commit();
    }

    public void saveInt(java.lang.String str, java.lang.Integer num) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putInt(str, num.intValue()).commit();
    }

    public void saveLong(java.lang.String str, java.lang.Long l) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(str, l.longValue()).commit();
    }

    public void saveMap(java.util.Map<java.lang.String, java.lang.Object> map) {
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            save(entry.getKey(), entry.getValue());
        }
    }

    public boolean saveString(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor edit;
        android.content.SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public boolean write(android.content.ContentValues contentValues) {
        if (this.a == null || contentValues == null) {
            return false;
        }
        boolean z = true;
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : contentValues.valueSet()) {
            if (!save(entry.getKey(), entry.getValue())) {
                z = false;
            }
        }
        return z;
    }
}
