package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class PLSharedPreferences {
    private static final java.lang.String MOVE_TO_DE_RECORDS = "grs_move2DE_records";
    private static final java.lang.String TAG = "PLSharedPreferences";
    private final android.content.SharedPreferences sp;

    public PLSharedPreferences(android.content.Context context, java.lang.String str) {
        this.sp = getSharedPreferences(context, str);
    }

    private android.content.SharedPreferences getSharedPreferences(android.content.Context context, java.lang.String str) {
        android.content.Context createDeviceProtectedStorageContext;
        boolean moveSharedPreferencesFrom;
        if (context == null) {
            com.huawei.hms.framework.common.Logger.e(TAG, "context is null, must call init method to set context");
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            android.content.SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences(MOVE_TO_DE_RECORDS, 0);
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
        return context.getSharedPreferences(str, 0);
    }

    public void clear() {
        android.content.SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    public android.content.SharedPreferences.Editor edit() {
        android.content.SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    public java.util.Map<java.lang.String, ?> getAll() {
        android.content.SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return null;
        }
        java.util.Map<java.lang.String, ?> all = sharedPreferences.getAll();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("sp size ");
        sb.append(all == null ? 0 : all.size());
        com.huawei.hms.framework.common.Logger.i(TAG, sb.toString());
        return all;
    }

    public java.util.Map<java.lang.String, java.lang.String> getHashMap(java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        android.content.SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return hashMap;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(sharedPreferences.getString(str, ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                org.json.JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i2 = 0; i2 < names.length(); i2++) {
                        java.lang.String string = names.getString(i2);
                        hashMap.put(string, jSONObject.getString(string));
                    }
                }
            }
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w(TAG, "getHashMap parse Json to map error: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
        }
        return hashMap;
    }

    public long getLong(java.lang.String str, long j) {
        android.content.SharedPreferences sharedPreferences = this.sp;
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    public java.lang.String getString(java.lang.String str) {
        return getString(str, "");
    }

    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences sharedPreferences = this.sp;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public void putHashMap(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (this.sp == null || map == null) {
            return;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (org.json.JSONException e) {
                com.huawei.hms.framework.common.Logger.w(TAG, "putHashMap one object error: %s", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(e.getMessage()));
            }
        }
        jSONArray.put(jSONObject);
        this.sp.edit().putString(str, jSONArray.toString()).apply();
    }

    public void putLong(java.lang.String str, long j) {
        android.content.SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public void putString(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public void remove(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public void removeKeyValue(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }
}
