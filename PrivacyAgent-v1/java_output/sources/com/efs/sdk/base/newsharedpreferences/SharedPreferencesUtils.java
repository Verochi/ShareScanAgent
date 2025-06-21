package com.efs.sdk.base.newsharedpreferences;

/* loaded from: classes22.dex */
public class SharedPreferencesUtils {
    private static final java.util.HashMap<java.lang.String, com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.SharedPreferencesWrapper> sSpCache = new java.util.HashMap<>();

    public static class SharedPreferencesWrapper {
        private volatile android.content.SharedPreferences mSharedPreferences;

        private SharedPreferencesWrapper() {
        }

        public /* synthetic */ SharedPreferencesWrapper(com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static android.content.SharedPreferences getNewSharedPreferences(android.content.Context context, java.lang.String str, boolean z) {
        return getNewSharedPreferences(context, str, z, false);
    }

    private static android.content.SharedPreferences getNewSharedPreferences(android.content.Context context, java.lang.String str, boolean z, boolean z2) {
        com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.SharedPreferencesWrapper sharedPreferencesWrapper;
        java.util.HashMap<java.lang.String, com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.SharedPreferencesWrapper> hashMap = sSpCache;
        synchronized (hashMap) {
            sharedPreferencesWrapper = hashMap.get(str);
            if (sharedPreferencesWrapper == null) {
                sharedPreferencesWrapper = new com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.SharedPreferencesWrapper(null);
                hashMap.put(str, sharedPreferencesWrapper);
            }
        }
        if (sharedPreferencesWrapper.mSharedPreferences == null) {
            synchronized (sharedPreferencesWrapper) {
                if (sharedPreferencesWrapper.mSharedPreferences == null && sharedPreferencesWrapper.mSharedPreferences == null) {
                    sharedPreferencesWrapper.mSharedPreferences = new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl(getNewSharedPrefsFile(context, str), z);
                }
            }
        }
        return sharedPreferencesWrapper.mSharedPreferences;
    }

    public static java.io.File getNewSharedPrefsFile(android.content.Context context, java.lang.String str) {
        return new java.io.File(context.getApplicationInfo().dataDir, "shared_prefs" + java.io.File.separatorChar + str + ".sp");
    }

    public static android.content.SharedPreferences getSharedPreferences(android.content.Context context, java.lang.String str) {
        return getSharedPreferences(context, str, false);
    }

    public static android.content.SharedPreferences getSharedPreferences(android.content.Context context, java.lang.String str, boolean z) {
        return getNewSharedPreferences(context, str, z);
    }

    private static synchronized void handleReplace(android.content.Context context, java.lang.String str, boolean z) {
        synchronized (com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.class) {
            if (context == null) {
                return;
            }
            android.content.SharedPreferences newSharedPreferences = getNewSharedPreferences(context, "sp_replace_flag", z, true);
            if (!newSharedPreferences.contains(str)) {
                android.content.SharedPreferences newSharedPreferences2 = getNewSharedPreferences(context, str, z, true);
                android.content.SharedPreferences.Editor edit = newSharedPreferences2.edit();
                if (((com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl) newSharedPreferences2).getModifyID() <= 1) {
                    java.util.Map<java.lang.String, ?> all = context.getSharedPreferences(str, 0).getAll();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("replace ");
                    sb.append(str);
                    sb.append("   ");
                    sb.append(all.size());
                    sb.append("   ");
                    sb.append(newSharedPreferences2.hashCode());
                    if (all.size() > 0) {
                        for (java.util.Map.Entry<java.lang.String, ?> entry : all.entrySet()) {
                            java.lang.String key = entry.getKey();
                            java.lang.Object value = entry.getValue();
                            if (key != null && key.trim().length() > 0 && value != null) {
                                if (value instanceof java.lang.String) {
                                    edit.putString(key, (java.lang.String) value);
                                } else if (value instanceof java.lang.Long) {
                                    edit.putLong(key, ((java.lang.Long) value).longValue());
                                } else if (value instanceof java.lang.Integer) {
                                    edit.putInt(key, ((java.lang.Integer) value).intValue());
                                } else if (value instanceof java.lang.Float) {
                                    edit.putFloat(key, ((java.lang.Float) value).floatValue());
                                } else if (value instanceof java.lang.Boolean) {
                                    edit.putBoolean(key, ((java.lang.Boolean) value).booleanValue());
                                }
                            }
                        }
                        edit.apply();
                    }
                }
                newSharedPreferences.edit().putBoolean(str, true).apply();
            }
        }
    }

    private static java.lang.Object invokeObjectMethod(java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void onDestroy() {
        java.util.HashMap<java.lang.String, com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.SharedPreferencesWrapper> hashMap = sSpCache;
        synchronized (hashMap) {
            if (hashMap.size() > 0) {
                java.util.Iterator<com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.SharedPreferencesWrapper> it = hashMap.values().iterator();
                while (it.hasNext()) {
                    android.content.SharedPreferences sharedPreferences = it.next().mSharedPreferences;
                    if (sharedPreferences != null) {
                        ((com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl) sharedPreferences).onDestroy();
                    }
                }
            }
        }
    }
}
