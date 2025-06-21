package com.ss.android.socialbase.appdownloader.kz;

/* loaded from: classes19.dex */
public class vw {
    private static final java.util.HashMap<java.lang.String, com.ss.android.socialbase.appdownloader.bt.vw> vw = new java.util.HashMap<>();

    public static boolean t(org.json.JSONObject jSONObject) {
        return jSONObject == null || com.ss.android.socialbase.appdownloader.kz.kz.vw() || jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_SECURITY_MODE) != 1;
    }

    public static com.ss.android.socialbase.appdownloader.bt.vw vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                com.ss.android.socialbase.appdownloader.bt.vw wg = wg(str);
                if (wg != null) {
                    return wg;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    public static boolean vw(org.json.JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < length; i++) {
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                java.lang.String optString = optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_PACKAGE_NAMES);
                org.json.JSONArray optJSONArray = optJSONObject.optJSONArray(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_ALLOW);
                org.json.JSONArray optJSONArray2 = optJSONObject.optJSONArray(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_BLOCK);
                java.lang.String optString2 = optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ALLOW_VERSION_RANGE);
                if (android.text.TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (java.lang.String str : optString.split(",")) {
                    if ("market".equals(str)) {
                        str = com.ss.android.socialbase.appdownloader.kz.yl.es();
                    }
                    com.ss.android.socialbase.appdownloader.bt.vw wg = wg(str);
                    if (wg != null && !(z = vw(optJSONArray, optJSONArray2, optString2, wg))) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    public static boolean vw(org.json.JSONArray jSONArray, java.lang.String str) {
        if (jSONArray != null && !android.text.TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && vw(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean vw(org.json.JSONArray jSONArray, org.json.JSONArray jSONArray2, java.lang.String str, @androidx.annotation.NonNull com.ss.android.socialbase.appdownloader.bt.vw vwVar) {
        java.lang.String bt = vwVar.bt();
        int kz = vwVar.kz();
        java.lang.String str2 = kz + "_" + bt;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                java.lang.String[] split = str.split("[-,]");
                for (int i = 0; i < split.length; i += 2) {
                    int parseInt = java.lang.Integer.parseInt(split[i]);
                    int parseInt2 = java.lang.Integer.parseInt(split[i + 1]);
                    if (kz >= parseInt && kz <= parseInt2) {
                        return true;
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } else if (jSONArray == null || jSONArray.length() <= 0) {
            if (jSONArray2 != null && jSONArray2.length() > 0 && !wg(jSONArray2, str2)) {
                return true;
            }
        } else if (wg(jSONArray, str2)) {
            return true;
        }
        return false;
    }

    public static boolean vw(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return wg(jSONObject) && vw(jSONObject.optJSONArray(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_REQUIREMENTS)) && t(jSONObject);
    }

    public static boolean vw(org.json.JSONObject jSONObject, android.content.Context context, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            java.lang.String optString = jSONObject.optString("s");
            try {
                java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(jSONObject.optString("az"), optString);
                java.lang.String vw3 = com.ss.android.socialbase.appdownloader.kz.t.vw(jSONObject.optString("ba"), optString);
                java.lang.reflect.Field declaredField = android.content.ContextWrapper.class.getDeclaredField(vw2);
                declaredField.setAccessible(true);
                java.lang.Object obj = declaredField.get(context);
                java.lang.reflect.Field declaredField2 = obj.getClass().getDeclaredField(vw3);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    private static com.ss.android.socialbase.appdownloader.bt.vw wg(java.lang.String str) {
        java.util.HashMap<java.lang.String, com.ss.android.socialbase.appdownloader.bt.vw> hashMap = vw;
        if (hashMap.containsKey(str)) {
            com.ss.android.socialbase.appdownloader.bt.vw vwVar = hashMap.get(str);
            if (vwVar != null) {
                return vwVar;
            }
            return null;
        }
        com.ss.android.socialbase.appdownloader.bt.vw wg = com.ss.android.socialbase.appdownloader.bt.wg(str);
        hashMap.put(str, wg);
        if (wg != null) {
            return wg;
        }
        return null;
    }

    private static boolean wg(org.json.JSONArray jSONArray, java.lang.String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wg(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = android.os.Build.VERSION.SDK_INT;
        java.lang.String optString = jSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_ALLOW_OS_API_RANGE);
        int optInt = jSONObject.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_MIN_OS_API, -1);
        if (android.text.TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i >= optInt;
        }
        try {
            java.lang.String[] split = optString.split("[-,]");
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                int parseInt = java.lang.Integer.parseInt(split[i2]);
                int parseInt2 = java.lang.Integer.parseInt(split[i2 + 1]);
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
