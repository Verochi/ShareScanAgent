package com.efs.sdk.base.custommapping;

/* loaded from: classes22.dex */
public class InnerCustomMappingManager {
    private static final int MAX_SIZE = 10;
    private static final int MAX_VALUE_LENGTH = 100;
    private static final java.lang.String TAG = "CustomMappingManager";
    private static final org.json.JSONObject sCustomMappingObj = new org.json.JSONObject();
    private static final java.util.List<java.lang.String> STRING_PARAMS_LIST = new java.util.ArrayList(java.util.Arrays.asList(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_1, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_2, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_3, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_4, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_5, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_6, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_7, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_8, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_9, com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_10));

    public static java.lang.String getCustomMappingJsonStr() {
        java.lang.String jSONObject;
        synchronized (com.efs.sdk.base.custommapping.InnerCustomMappingManager.class) {
            try {
                jSONObject = sCustomMappingObj.toString();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return jSONObject;
    }

    public static java.lang.String getStringParam(java.lang.String str) {
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str) || !STRING_PARAMS_LIST.contains(str)) {
            return null;
        }
        synchronized (com.efs.sdk.base.custommapping.InnerCustomMappingManager.class) {
            try {
                str2 = (java.lang.String) sCustomMappingObj.opt(str);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return str2;
    }

    public static boolean putStringParam(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || !STRING_PARAMS_LIST.contains(str) || str2.length() > 100) {
            return false;
        }
        synchronized (com.efs.sdk.base.custommapping.InnerCustomMappingManager.class) {
            try {
                sCustomMappingObj.put(str, str2);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
