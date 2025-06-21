package com.sensorsdata.analytics.android.sdk.useridentity;

/* loaded from: classes19.dex */
public class Identities {
    public static final java.lang.String ANDROID_ID = "$identity_android_id";
    public static final java.lang.String ANDROID_UUID = "$identity_android_uuid";
    public static final java.lang.String ANONYMOUS_ID = "$identity_anonymous_id";
    public static final java.lang.String COOKIE_ID = "$identity_cookie_id";
    public static final java.lang.String IDENTITIES_KEY = "identities";
    private static final java.lang.String TAG = "SA.Identities";
    private java.lang.String mAndroidId;
    private com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId mAnonymousId;
    private org.json.JSONObject mIdentities;
    private final com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey mLoginIDAndKey = new com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey();
    private org.json.JSONObject mLoginIdentities;
    private org.json.JSONObject mUnbindIdentities;

    /* renamed from: com.sensorsdata.analytics.android.sdk.useridentity.Identities$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID;
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State;

        static {
            int[] iArr = new int[com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.values().length];
            $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State = iArr;
            try {
                iArr[com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.LOGIN_KEY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State[com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.REMOVE_KEYID.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State[com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.DEFAULT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.values().length];
            $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID = iArr2;
            try {
                iArr2[com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.ANONYMOUS_ID.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID[com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.ANDROID_ID.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID[com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.ANDROID_UUID.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    public static class Local {
        public static java.lang.String getIdentitiesFromLocal() {
            try {
                com.sensorsdata.analytics.android.sdk.data.persistent.UserIdentityPersistent userIdsPst = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getUserIdsPst();
                if (userIdsPst != null) {
                    return com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.decodeIdentities(userIdsPst.get());
                }
                return null;
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return null;
            }
        }

        public static java.lang.String getLoginIdFromLocal() {
            try {
                com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoginId loginIdPst = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getLoginIdPst();
                return loginIdPst == null ? "" : loginIdPst.get();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return "";
            }
        }

        public static java.lang.String getLoginIdKeyFromLocal() {
            try {
                com.sensorsdata.analytics.android.sdk.data.persistent.LoginIdKeyPersistent loginIdKeyPst = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getLoginIdKeyPst();
                return loginIdKeyPst == null ? "" : loginIdKeyPst.get();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return "";
            }
        }
    }

    public enum SpecialID {
        ANONYMOUS_ID,
        ANDROID_ID,
        ANDROID_UUID
    }

    public enum State {
        LOGIN_KEY,
        REMOVE_KEYID,
        DEFAULT
    }

    private void clearIdentities(java.util.List<java.lang.String> list, org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                if (!list.contains(keys.next())) {
                    keys.remove();
                }
            }
        }
    }

    private org.json.JSONObject createIdentities(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        if (jSONObject == null || jSONObject.length() == 0) {
            jSONObject = new org.json.JSONObject();
            if (str != null) {
                jSONObject.put(ANONYMOUS_ID, str);
            }
            if (com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.isValidAndroidId(this.mAndroidId)) {
                jSONObject.put(ANDROID_ID, this.mAndroidId);
            } else {
                jSONObject.put(ANDROID_UUID, str);
            }
        } else if (jSONObject.has(ANONYMOUS_ID)) {
            jSONObject.put(ANONYMOUS_ID, str);
        }
        return jSONObject;
    }

    private org.json.JSONObject getCacheIdentities() throws org.json.JSONException {
        java.lang.String identities = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getIdentities();
        if (android.text.TextUtils.isEmpty(identities)) {
            return null;
        }
        return new org.json.JSONObject(identities);
    }

    private org.json.JSONObject getDefaultIdentities() {
        try {
            return getCacheIdentities();
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    private org.json.JSONObject getInitIdentities() throws org.json.JSONException {
        java.lang.String identitiesFromLocal = com.sensorsdata.analytics.android.sdk.useridentity.Identities.Local.getIdentitiesFromLocal();
        if (android.text.TextUtils.isEmpty(identitiesFromLocal)) {
            return null;
        }
        return new org.json.JSONObject(identitiesFromLocal);
    }

    private void initLoginIDAndKeyIdentities(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (android.text.TextUtils.isEmpty(str2)) {
            if (jSONObject.has(str)) {
                clearIdentities(java.util.Arrays.asList(ANDROID_ID, ANDROID_UUID, ANONYMOUS_ID), jSONObject);
                this.mLoginIDAndKey.setLoginIDKey("");
                return;
            }
            return;
        }
        if (!jSONObject.has(str)) {
            jSONObject.put(com.sensorsdata.analytics.android.sdk.useridentity.Identities.Local.getLoginIdKeyFromLocal(), com.sensorsdata.analytics.android.sdk.useridentity.Identities.Local.getLoginIdFromLocal());
            clearIdentities(java.util.Arrays.asList(ANDROID_ID, ANDROID_UUID, this.mLoginIDAndKey.getLoginIDKey()), jSONObject);
        } else {
            if (jSONObject.optString(this.mLoginIDAndKey.getLoginIDKey()).equals(str2)) {
                return;
            }
            jSONObject.put(com.sensorsdata.analytics.android.sdk.useridentity.Identities.Local.getLoginIdKeyFromLocal(), com.sensorsdata.analytics.android.sdk.useridentity.Identities.Local.getLoginIdFromLocal());
            clearIdentities(java.util.Arrays.asList(ANDROID_ID, ANDROID_UUID, this.mLoginIDAndKey.getLoginIDKey()), jSONObject);
        }
    }

    private boolean isInValid(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return !this.mLoginIDAndKey.setLoginKeyAndID(str, str2, str3);
    }

    private boolean isInvalidBusinessID(java.lang.String str, java.lang.String str2, boolean z) {
        boolean z2;
        if (z) {
            if (!isRemoveKeyValid(str) || !com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyKey(str)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "unbind key is invalid, key = " + str);
                z2 = true;
            }
            z2 = false;
        } else {
            if (!isKeyValid(str) || !com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyKey(str)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "bind key is invalid, key = " + str);
                z2 = true;
            }
            z2 = false;
        }
        try {
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertDistinctId(str2);
            return z2;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e);
            return true;
        }
    }

    private boolean isKeyValid(java.lang.String str) {
        return (ANONYMOUS_ID.equals(str) || ANDROID_UUID.equals(str) || ANDROID_ID.equals(str) || this.mLoginIDAndKey.getLoginIDKey().equals(str) || com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.LOGIN_ID_KEY_DEFAULT.equals(str)) ? false : true;
    }

    private boolean isRemoveKeyValid(java.lang.String str) {
        return (ANONYMOUS_ID.equals(str) || com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.LOGIN_ID_KEY_DEFAULT.equals(str)) ? false : true;
    }

    private boolean isValidIdentities(org.json.JSONObject jSONObject) {
        return jSONObject != null && (jSONObject.has(ANDROID_ID) || jSONObject.has(ANDROID_UUID));
    }

    private org.json.JSONObject resetIdentities(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        if (!jSONObject.has(ANDROID_UUID) && !jSONObject.has(ANDROID_ID)) {
            if (com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.isValidAndroidId(this.mAndroidId)) {
                jSONObject.put(ANDROID_ID, this.mAndroidId);
            } else {
                jSONObject.put(ANDROID_UUID, this.mAnonymousId.get());
            }
        }
        return jSONObject;
    }

    private void saveIdentities() {
        if (!isValidIdentities(this.mIdentities)) {
            try {
                this.mIdentities = resetIdentities(this.mIdentities);
            } catch (org.json.JSONException unused) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "reset identities failed!");
            }
        }
        com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitIdentities(this.mIdentities.toString());
    }

    public org.json.JSONObject getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State state) {
        int i = com.sensorsdata.analytics.android.sdk.useridentity.Identities.AnonymousClass1.$SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State[state.ordinal()];
        if (i == 1) {
            return this.mLoginIdentities;
        }
        if (i == 2) {
            org.json.JSONObject jSONObject = this.mUnbindIdentities;
            if (jSONObject != null) {
                return jSONObject;
            }
        } else if (i == 3) {
            org.json.JSONObject jSONObject2 = this.mIdentities;
            return (jSONObject2 == null || jSONObject2.length() == 0) ? getDefaultIdentities() : this.mIdentities;
        }
        return null;
    }

    public java.lang.String getJointLoginID() {
        return this.mLoginIDAndKey.getJointLoginID();
    }

    public java.lang.String getLoginIDKey() {
        return this.mLoginIDAndKey.getLoginIDKey();
    }

    public java.lang.String getLoginId() {
        return this.mLoginIDAndKey.getLoginId();
    }

    public void init(java.lang.String str, java.lang.String str2) throws org.json.JSONException {
        java.lang.String loginIdKeyFromLocal = com.sensorsdata.analytics.android.sdk.useridentity.Identities.Local.getLoginIdKeyFromLocal();
        java.lang.String loginIdFromLocal = com.sensorsdata.analytics.android.sdk.useridentity.Identities.Local.getLoginIdFromLocal();
        this.mLoginIDAndKey.init(loginIdKeyFromLocal);
        this.mAndroidId = str;
        this.mAnonymousId = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getAnonymousIdPst();
        org.json.JSONObject createIdentities = createIdentities(getInitIdentities(), str2);
        initLoginIDAndKeyIdentities(loginIdKeyFromLocal, loginIdFromLocal, createIdentities);
        this.mIdentities = createIdentities;
        saveIdentities();
    }

    public void mergeIdentities(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            if (!this.mIdentities.has(next)) {
                this.mIdentities.put(next, jSONObject.optString(next));
            }
        }
        saveIdentities();
    }

    public boolean remove(java.lang.String str, java.lang.String str2) throws org.json.JSONException {
        if (isInvalidBusinessID(str, str2, true)) {
            return false;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        this.mUnbindIdentities = jSONObject;
        jSONObject.put(str, str2);
        if (!(ANDROID_ID.equals(str) || ANDROID_UUID.equals(str)) && this.mIdentities.has(str) && this.mIdentities.optString(str).equals(str2)) {
            this.mIdentities.remove(str);
        }
        if ((str + "+" + str2).equals(getJointLoginID())) {
            this.mIdentities.remove(str);
            this.mLoginIDAndKey.removeLoginKeyAndID();
        }
        saveIdentities();
        return true;
    }

    public void removeLoginKeyAndID() {
        this.mLoginIdentities = new org.json.JSONObject();
        clearIdentities(java.util.Arrays.asList(ANDROID_ID, ANDROID_UUID), this.mIdentities);
        com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State state = com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.LOGOUT;
        if (!state.isObserverCalled) {
            this.mLoginIDAndKey.removeLoginKeyAndID();
        }
        saveIdentities();
        state.isObserverCalled = false;
    }

    public boolean update(java.lang.String str, java.lang.String str2) throws org.json.JSONException {
        if (isInvalidBusinessID(str, str2, false)) {
            return false;
        }
        this.mIdentities.put(str, str2);
        saveIdentities();
        return true;
    }

    public void updateIDKeyAndValue(java.lang.String str) throws org.json.JSONException {
        if (this.mIdentities.has(ANDROID_ID)) {
            this.mIdentities.put(ANDROID_ID, str);
        } else if (this.mIdentities.has(ANDROID_UUID)) {
            this.mIdentities.put(ANDROID_UUID, str);
        }
        saveIdentities();
    }

    public void updateIdentities() {
        try {
            this.mIdentities = getCacheIdentities();
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public boolean updateLoginKeyAndID(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        if (isInValid(str, str2, str3)) {
            return false;
        }
        this.mIdentities.put(str, str2);
        this.mLoginIdentities = new org.json.JSONObject(this.mIdentities.toString());
        clearIdentities(java.util.Arrays.asList(ANDROID_ID, ANDROID_UUID, str), this.mIdentities);
        saveIdentities();
        return true;
    }

    public void updateSpecialIDKeyAndValue(com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID specialID, java.lang.String str) throws org.json.JSONException {
        int i = com.sensorsdata.analytics.android.sdk.useridentity.Identities.AnonymousClass1.$SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID[specialID.ordinal()];
        if (i == 1) {
            this.mIdentities.put(ANONYMOUS_ID, str);
        } else if (i == 2) {
            this.mIdentities.put(ANDROID_ID, str);
        } else if (i == 3) {
            this.mIdentities.put(ANDROID_UUID, str);
        }
        saveIdentities();
    }
}
