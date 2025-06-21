package com.sensorsdata.analytics.android.sdk.useridentity;

/* loaded from: classes19.dex */
public class LoginIDAndKey {
    public static final java.lang.String LOGIN_ID_KEY_DEFAULT = "$identity_login_id";
    private static final java.lang.String TAG = "SA.LoginIDAndKey";

    public static boolean isInValidLogin(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        if (isInValidLoginIDKey(str) || isInValidLoginID(str2, str5)) {
            return true;
        }
        if (!str.equals(str3) || !str2.equals(str4)) {
            return false;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "login key and value already exist!");
        return true;
    }

    private static boolean isInValidLoginID(java.lang.String str, java.lang.String str2) {
        try {
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertDistinctId(str);
            if (!str.equals(str2)) {
                return false;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "login value cannot be an anonymous id!");
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e);
            return true;
        }
    }

    private static boolean isInValidLoginIDKey(java.lang.String str) {
        if (!com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyKey(str)) {
            return true;
        }
        if (!com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANONYMOUS_ID.equals(str) && !com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANDROID_UUID.equals(str) && !com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANDROID_ID.equals(str)) {
            return false;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "login key cannot be an anonymous id or android_uuid or android_id!");
        return true;
    }

    public static java.lang.String jointLoginID(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || str.equals(LOGIN_ID_KEY_DEFAULT)) {
            return str2;
        }
        return str + "+" + str2;
    }

    private void restoreDefaultLoginIDKey() {
        setLoginIDKey(LOGIN_ID_KEY_DEFAULT);
    }

    public java.lang.String getJointLoginID() {
        return jointLoginID(getLoginIDKey(), getLoginId());
    }

    public java.lang.String getLoginIDKey() {
        return com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getLoginIdKey();
    }

    public java.lang.String getLoginId() {
        return com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getLoginId();
    }

    public void init(java.lang.String str) {
        if (isInValidLoginIDKey(str)) {
            restoreDefaultLoginIDKey();
        }
    }

    public void removeLoginKeyAndID() {
        setLoginIDKey("");
        setLoginId("");
    }

    public void setLoginIDKey(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitLoginIdKey(str);
    }

    public void setLoginId(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitLoginId(str);
    }

    public boolean setLoginKeyAndID(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (isInValidLogin(str, str2, getLoginIDKey(), getLoginId(), str3)) {
            return false;
        }
        setLoginIDKey(str);
        setLoginId(str2);
        java.lang.String loginId = getLoginId();
        java.lang.String loginIDKey = getLoginIDKey();
        if (str2.equals(loginId) && str.equals(loginIDKey)) {
            return true;
        }
        setLoginId(str2);
        setLoginIDKey(str);
        return true;
    }
}
