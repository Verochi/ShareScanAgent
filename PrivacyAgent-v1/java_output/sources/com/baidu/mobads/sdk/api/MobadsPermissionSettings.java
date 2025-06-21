package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class MobadsPermissionSettings {
    private static final java.lang.String PERMISSION_APP_LIST = "permission_app_list";
    private static final java.lang.String PERMISSION_APP_UPDATE = "permission_app_update";
    private static final java.lang.String PERMISSION_DEVICE_INFO = "permission_device_info";
    private static final java.lang.String PERMISSION_LIMIT_STATE = "permission_limitpersonalads";
    private static final java.lang.String PERMISSION_LOCATION = "permission_location";
    private static final java.lang.String PERMISSION_OAID = "permission_oaid";
    private static final java.lang.String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    private static final java.lang.String PERMISSION_RUNNING_APP = "permission_running_app";
    private static final java.lang.String PERMISSION_STORAGE = "permission_storage";
    private static boolean mAccessAppListGranted = false;
    private static boolean mAccessLocationGranted = false;
    private static boolean mAppUpdateGranted = true;
    private static boolean mCheckSPLimit = false;
    private static boolean mDeviceInfoGranted = true;
    private static boolean mExternalStorageGranted = false;
    private static boolean mLimitPrivacyAds = false;
    private static boolean mOAIDGranted = true;
    private static boolean mReadPhoneStateGranted = false;
    private static boolean mRunningAppGranted = true;

    public static org.json.JSONObject getLimitInfo() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(PERMISSION_LIMIT_STATE, mLimitPrivacyAds);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean getLimitPersonalAdsStatus() {
        updateSPLimitTag();
        return mLimitPrivacyAds;
    }

    public static org.json.JSONObject getPermissionInfo() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(PERMISSION_LOCATION, "" + mAccessLocationGranted);
            jSONObject.put(PERMISSION_STORAGE, "" + mExternalStorageGranted);
            jSONObject.put(PERMISSION_APP_LIST, "" + mAccessAppListGranted);
            jSONObject.put(PERMISSION_PHONE_STATE, "" + mReadPhoneStateGranted);
            jSONObject.put(PERMISSION_OAID, "" + mOAIDGranted);
            jSONObject.put(PERMISSION_APP_UPDATE, "" + mAppUpdateGranted);
            jSONObject.put(PERMISSION_RUNNING_APP, "" + mRunningAppGranted);
            jSONObject.put(PERMISSION_DEVICE_INFO, "" + mDeviceInfoGranted);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean handleIntegrationInfo(android.os.Bundle bundle) {
        try {
            switchDebugLog(bundle);
            com.baidu.mobads.sdk.api.IXAdContainerFactory c = com.baidu.mobads.sdk.internal.aa.a().c();
            if (c != null) {
                c.getRemoteParam("integrationInfo", bundle);
                return true;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private static void postLimitInfoRemote() {
        com.baidu.mobads.sdk.api.IXAdContainerFactory c = com.baidu.mobads.sdk.internal.aa.a().c();
        if (c != null) {
            c.onTaskDistribute(com.baidu.mobads.sdk.internal.bc.b, getLimitInfo());
        }
    }

    private static void postPermissionInfoRemote() {
        com.baidu.mobads.sdk.api.IXAdContainerFactory c = com.baidu.mobads.sdk.internal.aa.a().c();
        if (c != null) {
            c.onTaskDistribute(com.baidu.mobads.sdk.internal.bc.a, getPermissionInfo());
        }
    }

    public static void setLimitPersonalAds(boolean z) {
        mLimitPrivacyAds = z;
        postLimitInfoRemote();
    }

    public static void setPermissionAppList(boolean z) {
        mAccessAppListGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionAppUpdate(boolean z) {
        mAppUpdateGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionDeviceInfo(boolean z) {
        mDeviceInfoGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionLocation(boolean z) {
        mAccessLocationGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionOAID(boolean z) {
        mOAIDGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionReadDeviceID(boolean z) {
        mReadPhoneStateGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionRunningApp(boolean z) {
        mRunningAppGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionStorage(boolean z) {
        mExternalStorageGranted = z;
        postPermissionInfoRemote();
    }

    private static void switchDebugLog(android.os.Bundle bundle) {
        if (bundle != null && bundle.containsKey("debug_mode")) {
            if (bundle.getBoolean("debug_mode")) {
                com.baidu.mobads.sdk.internal.ay.a(true);
                return;
            } else {
                com.baidu.mobads.sdk.internal.ay.a();
                return;
            }
        }
        if (bundle == null || !bundle.containsKey(com.baidu.mobads.sdk.internal.ax.b)) {
            return;
        }
        if (bundle.getBoolean(com.baidu.mobads.sdk.internal.ax.b)) {
            com.baidu.mobads.sdk.internal.ay.a((com.baidu.mobads.sdk.internal.ay.a) new com.baidu.mobads.sdk.internal.ax());
        } else {
            com.baidu.mobads.sdk.internal.ay.i(com.baidu.mobads.sdk.internal.ax.b);
        }
    }

    private static void updateSPLimitTag() {
        com.baidu.mobads.sdk.internal.aa a;
        com.baidu.mobads.sdk.api.IXAdContainerFactory c;
        try {
            if (mCheckSPLimit || (a = com.baidu.mobads.sdk.internal.aa.a()) == null || (c = a.c()) == null) {
                return;
            }
            java.lang.Object remoteParam = c.getRemoteParam("limitPersonalAds", new java.lang.Object[0]);
            if (remoteParam instanceof java.lang.Boolean) {
                mLimitPrivacyAds = ((java.lang.Boolean) remoteParam).booleanValue();
                mCheckSPLimit = true;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
