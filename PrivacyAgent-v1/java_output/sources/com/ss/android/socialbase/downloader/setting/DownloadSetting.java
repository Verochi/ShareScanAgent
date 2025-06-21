package com.ss.android.socialbase.downloader.setting;

/* loaded from: classes19.dex */
public class DownloadSetting {
    private static final int POOL_SIZE = 16;
    private static org.json.JSONObject sDisabledTaskKeys;
    private static java.lang.Boolean sGlobalBugFixDefault;
    private static org.json.JSONObject sGlobalBugFixSetting;

    @java.lang.Deprecated
    private static org.json.JSONObject sGlobalSetting;
    private static com.ss.android.socialbase.downloader.setting.DownloadSetting sLastSetting;
    private static boolean sTaskSettingDisabled;
    private final java.lang.Boolean mBugFixDefault;
    private final org.json.JSONObject mBugFixSetting;
    private int mDownloadId;
    private final org.json.JSONObject mTaskSetting;
    private static final com.ss.android.socialbase.downloader.utils.LruCache<java.lang.Integer, com.ss.android.socialbase.downloader.setting.DownloadSetting> sCache = new com.ss.android.socialbase.downloader.utils.LruCache<>(16, 16);
    private static final com.ss.android.socialbase.downloader.setting.DownloadSetting sGlobal = new com.ss.android.socialbase.downloader.setting.DownloadSetting(null);

    static {
        init();
    }

    private DownloadSetting(org.json.JSONObject jSONObject) {
        java.lang.Boolean bool;
        this.mTaskSetting = jSONObject;
        org.json.JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        java.lang.Boolean bool2 = null;
        if (jSONObject == null || isTaskKeyDisabled(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BUG_FIX)) {
            bool = null;
        } else {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BUG_FIX);
            if (optJSONObject != null && optJSONObject.has("default") && !isTaskKeyDisabled("default")) {
                bool2 = java.lang.Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            java.lang.Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.mBugFixSetting = jSONObject2;
        this.mBugFixDefault = bool;
    }

    public static void addTaskDownloadSetting(int i, org.json.JSONObject jSONObject) {
        com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting;
        if (jSONObject == null || jSONObject == getGlobalSettings() || sTaskSettingDisabled) {
            return;
        }
        com.ss.android.socialbase.downloader.utils.LruCache<java.lang.Integer, com.ss.android.socialbase.downloader.setting.DownloadSetting> lruCache = sCache;
        synchronized (lruCache) {
            com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting2 = sLastSetting;
            if (downloadSetting2 == null || downloadSetting2.mTaskSetting != jSONObject) {
                java.util.Iterator<com.ss.android.socialbase.downloader.setting.DownloadSetting> it = lruCache.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        downloadSetting = null;
                        break;
                    }
                    downloadSetting = it.next();
                    if (downloadSetting.mTaskSetting == jSONObject) {
                        downloadSetting.mDownloadId = i;
                        break;
                    }
                }
                if (downloadSetting == null) {
                    downloadSetting2 = new com.ss.android.socialbase.downloader.setting.DownloadSetting(jSONObject);
                    downloadSetting2.mDownloadId = i;
                } else {
                    downloadSetting2 = downloadSetting;
                }
                sLastSetting = downloadSetting2;
            } else {
                downloadSetting2.mDownloadId = i;
            }
            sCache.put(java.lang.Integer.valueOf(i), downloadSetting2);
        }
    }

    private static com.ss.android.socialbase.downloader.setting.DownloadSetting create(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        if (sTaskSettingDisabled) {
            return sGlobal;
        }
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        return (appContext == null || (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(appContext).getDownloadInfo(i)) == null) ? sGlobal : create(downloadInfo);
    }

    private static com.ss.android.socialbase.downloader.setting.DownloadSetting create(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (sTaskSettingDisabled) {
            return sGlobal;
        }
        try {
            java.lang.String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!android.text.TextUtils.isEmpty(downloadSettingString)) {
                return new com.ss.android.socialbase.downloader.setting.DownloadSetting(new org.json.JSONObject(downloadSettingString));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return sGlobal;
    }

    @androidx.annotation.NonNull
    public static org.json.JSONObject getGlobalSettings() {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadSetting();
    }

    public static void init() {
        java.lang.Boolean bool;
        org.json.JSONObject downloadSetting = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadSetting();
        sTaskSettingDisabled = downloadSetting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DISABLE_TASK_SETTING, 0) == 1;
        sDisabledTaskKeys = downloadSetting.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DISABLED_TASK_KEYS);
        org.json.JSONObject optJSONObject = downloadSetting.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BUG_FIX);
        if (optJSONObject == null || !optJSONObject.has("default")) {
            bool = null;
        } else {
            bool = java.lang.Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        sGlobalBugFixSetting = optJSONObject;
        sGlobalBugFixDefault = bool;
    }

    public static boolean isTaskKeyDisabled(java.lang.String str) {
        org.json.JSONObject jSONObject = sDisabledTaskKeys;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.downloader.setting.DownloadSetting obtain(int i) {
        return obtain(i, null);
    }

    private static com.ss.android.socialbase.downloader.setting.DownloadSetting obtain(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting;
        com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting2 = sLastSetting;
        if (downloadSetting2 != null && downloadSetting2.mDownloadId == i) {
            return downloadSetting2;
        }
        com.ss.android.socialbase.downloader.utils.LruCache<java.lang.Integer, com.ss.android.socialbase.downloader.setting.DownloadSetting> lruCache = sCache;
        synchronized (lruCache) {
            downloadSetting = lruCache.get(java.lang.Integer.valueOf(i));
        }
        if (downloadSetting == null) {
            downloadSetting = downloadInfo == null ? create(i) : create(downloadInfo);
            synchronized (lruCache) {
                lruCache.put(java.lang.Integer.valueOf(i), downloadSetting);
            }
        }
        downloadSetting.mDownloadId = i;
        sLastSetting = downloadSetting;
        return downloadSetting;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.downloader.setting.DownloadSetting obtain(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo == null ? sGlobal : obtain(downloadInfo.getId(), downloadInfo);
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.downloader.setting.DownloadSetting obtain(org.json.JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == getGlobalSettings() || sTaskSettingDisabled) {
            return sGlobal;
        }
        com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting = sLastSetting;
        if (downloadSetting != null && downloadSetting.mTaskSetting == jSONObject) {
            return downloadSetting;
        }
        com.ss.android.socialbase.downloader.utils.LruCache<java.lang.Integer, com.ss.android.socialbase.downloader.setting.DownloadSetting> lruCache = sCache;
        synchronized (lruCache) {
            for (com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting2 : lruCache.values()) {
                if (downloadSetting2.mTaskSetting == jSONObject) {
                    sLastSetting = downloadSetting2;
                    return downloadSetting2;
                }
            }
            com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting3 = new com.ss.android.socialbase.downloader.setting.DownloadSetting(jSONObject);
            sLastSetting = downloadSetting3;
            return downloadSetting3;
        }
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.downloader.setting.DownloadSetting obtainGlobal() {
        return sGlobal;
    }

    public static void removeTaskDownloadSetting(int i) {
        com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting = sLastSetting;
        if (downloadSetting != null && downloadSetting.mDownloadId == i) {
            sLastSetting = null;
        }
        com.ss.android.socialbase.downloader.utils.LruCache<java.lang.Integer, com.ss.android.socialbase.downloader.setting.DownloadSetting> lruCache = sCache;
        synchronized (lruCache) {
            lruCache.remove(java.lang.Integer.valueOf(i));
        }
    }

    public static void setGlobalBugFix(java.lang.String str, boolean z) {
        try {
            if (sGlobalBugFixSetting == null) {
                sGlobalBugFixSetting = new org.json.JSONObject();
            }
            sGlobalBugFixSetting.put(str, z ? 1 : 0);
        } catch (org.json.JSONException unused) {
        }
    }

    public boolean has(java.lang.String str) {
        return (this.mTaskSetting == null || isTaskKeyDisabled(str)) ? getGlobalSettings().has(str) : this.mTaskSetting.has(str);
    }

    public java.lang.Object opt(java.lang.String str) {
        org.json.JSONObject jSONObject = this.mTaskSetting;
        return (jSONObject == null || !jSONObject.has(str) || isTaskKeyDisabled(str)) ? getGlobalSettings().opt(str) : this.mTaskSetting.opt(str);
    }

    public boolean optBoolean(java.lang.String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject = this.mTaskSetting;
        return (jSONObject == null || !jSONObject.has(str) || isTaskKeyDisabled(str)) ? getGlobalSettings().optBoolean(str, z) : this.mTaskSetting.optBoolean(str, z);
    }

    public boolean optBugFix(java.lang.String str) {
        return optBugFix(str, false);
    }

    public boolean optBugFix(java.lang.String str, boolean z) {
        if (this.mBugFixSetting != null && !isTaskKeyDisabled(str)) {
            if (this.mBugFixSetting.has(str)) {
                return this.mBugFixSetting.optInt(str, z ? 1 : 0) == 1;
            }
            java.lang.Boolean bool = this.mBugFixDefault;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        org.json.JSONObject jSONObject = sGlobalBugFixSetting;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return sGlobalBugFixSetting.optInt(str, z ? 1 : 0) == 1;
            }
            java.lang.Boolean bool2 = sGlobalBugFixDefault;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public double optDouble(java.lang.String str) {
        return optDouble(str, Double.NaN);
    }

    public double optDouble(java.lang.String str, double d) {
        org.json.JSONObject jSONObject = this.mTaskSetting;
        return (jSONObject == null || !jSONObject.has(str) || isTaskKeyDisabled(str)) ? getGlobalSettings().optDouble(str, d) : this.mTaskSetting.optDouble(str, d);
    }

    public int optInt(java.lang.String str) {
        return optInt(str, 0);
    }

    public int optInt(java.lang.String str, int i) {
        org.json.JSONObject jSONObject = this.mTaskSetting;
        return (jSONObject == null || !jSONObject.has(str) || isTaskKeyDisabled(str)) ? getGlobalSettings().optInt(str, i) : this.mTaskSetting.optInt(str, i);
    }

    public org.json.JSONArray optJSONArray(java.lang.String str) {
        org.json.JSONObject jSONObject = this.mTaskSetting;
        return (jSONObject == null || !jSONObject.has(str) || isTaskKeyDisabled(str)) ? getGlobalSettings().optJSONArray(str) : this.mTaskSetting.optJSONArray(str);
    }

    public org.json.JSONObject optJSONObject(java.lang.String str) {
        org.json.JSONObject jSONObject = this.mTaskSetting;
        return (jSONObject == null || !jSONObject.has(str) || isTaskKeyDisabled(str)) ? getGlobalSettings().optJSONObject(str) : this.mTaskSetting.optJSONObject(str);
    }

    public long optLong(java.lang.String str) {
        return optLong(str, 0L);
    }

    public long optLong(java.lang.String str, long j) {
        org.json.JSONObject jSONObject = this.mTaskSetting;
        return (jSONObject == null || !jSONObject.has(str) || isTaskKeyDisabled(str)) ? getGlobalSettings().optLong(str, j) : this.mTaskSetting.optLong(str, j);
    }

    public java.lang.String optString(java.lang.String str) {
        return optString(str, "");
    }

    public java.lang.String optString(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject = this.mTaskSetting;
        return (jSONObject == null || !jSONObject.has(str) || isTaskKeyDisabled(str)) ? getGlobalSettings().optString(str, str2) : this.mTaskSetting.optString(str, str2);
    }
}
