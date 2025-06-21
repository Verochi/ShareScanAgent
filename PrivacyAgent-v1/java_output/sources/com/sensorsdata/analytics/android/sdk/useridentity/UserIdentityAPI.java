package com.sensorsdata.analytics.android.sdk.useridentity;

/* loaded from: classes19.dex */
public final class UserIdentityAPI implements com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI {
    private static final java.lang.String TAG = "SA.UserIdentityAPI";
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId mAnonymousId;
    private com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityStrategy mH5UserIdentityStrategy;
    private final com.sensorsdata.analytics.android.sdk.useridentity.Identities mIdentitiesInstance;
    private java.lang.String mLoginIdValue;
    private final com.sensorsdata.analytics.android.sdk.core.SAContextManager mSAContextManager;

    public UserIdentityAPI(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mLoginIdValue = null;
        this.mSAContextManager = sAContextManager;
        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId anonymousIdPst = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getAnonymousIdPst();
        this.mAnonymousId = anonymousIdPst;
        com.sensorsdata.analytics.android.sdk.useridentity.Identities identities = new com.sensorsdata.analytics.android.sdk.useridentity.Identities();
        this.mIdentitiesInstance = identities;
        try {
            identities.init(com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(sAContextManager.getContext()), anonymousIdPst.get());
            this.mLoginIdValue = identities.getJointLoginID();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void bind(java.lang.String str, java.lang.String str2) {
        bindBack(str, str2);
    }

    public boolean bindBack(java.lang.String str, java.lang.String str2) {
        try {
            return this.mIdentitiesInstance.update(str, str2);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getAnonymousId() {
        java.lang.String str;
        try {
            synchronized (this.mAnonymousId) {
                str = this.mAnonymousId.get();
            }
            return str;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getDistinctId() {
        try {
            java.lang.String loginId = getLoginId();
            return !android.text.TextUtils.isEmpty(loginId) ? loginId : getAnonymousId();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public org.json.JSONObject getIdentities() {
        return this.mIdentitiesInstance.getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.DEFAULT);
    }

    public org.json.JSONObject getIdentities(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType) {
        return com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP == eventType ? this.mIdentitiesInstance.getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.LOGIN_KEY) : com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_UNBIND == eventType ? this.mIdentitiesInstance.getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.REMOVE_KEYID) : this.mIdentitiesInstance.getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.DEFAULT);
    }

    public com.sensorsdata.analytics.android.sdk.useridentity.Identities getIdentitiesInstance() {
        return this.mIdentitiesInstance;
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getLoginId() {
        java.lang.String str = "";
        try {
            if (!com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.isTaskExecuteThread()) {
                return this.mLoginIdValue;
            }
            java.lang.String jointLoginID = this.mIdentitiesInstance.getJointLoginID();
            if (!android.text.TextUtils.isEmpty(jointLoginID)) {
                return jointLoginID;
            }
            java.lang.String loginIDKey = this.mIdentitiesInstance.getLoginIDKey();
            if (android.text.TextUtils.isEmpty(jointLoginID)) {
                loginIDKey = com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.LOGIN_ID_KEY_DEFAULT;
            }
            org.json.JSONObject identities = this.mIdentitiesInstance.getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.LOGIN_KEY);
            if (identities != null) {
                str = identities.optString(loginIDKey);
            }
            return str;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void identify(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "identify is called");
            synchronized (this.mAnonymousId) {
                if (!str.equals(this.mAnonymousId.get())) {
                    this.mAnonymousId.commit(str);
                    this.mIdentitiesInstance.updateSpecialIDKeyAndValue(com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.ANONYMOUS_ID, str);
                    if (this.mSAContextManager.getEventListenerList() != null) {
                        java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> it = this.mSAContextManager.getEventListenerList().iterator();
                        while (it.hasNext()) {
                            try {
                                it.next().identify();
                            } catch (java.lang.Exception e) {
                                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                            }
                        }
                    }
                    com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().callIdentify(str);
                }
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void login(java.lang.String str) {
        loginWithKeyBack(com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void login(java.lang.String str, org.json.JSONObject jSONObject) {
        loginWithKeyBack(com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void loginWithKey(java.lang.String str, java.lang.String str2) {
        loginWithKeyBack(str, str2);
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void loginWithKey(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        loginWithKeyBack(str, str2);
    }

    public boolean loginWithKeyBack(java.lang.String str, java.lang.String str2) {
        try {
            boolean updateLoginKeyAndID = this.mIdentitiesInstance.updateLoginKeyAndID(str, str2, getAnonymousId());
            if (!updateLoginKeyAndID) {
                return updateLoginKeyAndID;
            }
            if (this.mSAContextManager.getEventListenerList() != null) {
                java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> it = this.mSAContextManager.getEventListenerList().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().login();
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                }
            }
            com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().callLogin(this.mIdentitiesInstance.getJointLoginID());
            return updateLoginKeyAndID;
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            return false;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void logout() {
        try {
            com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.LOGOUT.isDid = true;
            com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.LOGIN.isDid = false;
            org.json.JSONObject identities = this.mIdentitiesInstance.getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.DEFAULT);
            boolean z = !android.text.TextUtils.isEmpty(this.mIdentitiesInstance.getLoginId());
            if (!z) {
                if (identities == null) {
                    return;
                }
                if (identities.length() == 1 && (identities.has(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANDROID_ID) || identities.has(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANDROID_UUID))) {
                    return;
                }
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "logout is called");
            this.mIdentitiesInstance.removeLoginKeyAndID();
            if (z) {
                if (this.mSAContextManager.getEventListenerList() != null) {
                    java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> it = this.mSAContextManager.getEventListenerList().iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().logout();
                        } catch (java.lang.Exception e) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        }
                    }
                }
                com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().callLogout();
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Clean loginId");
    }

    public boolean mergeH5Identities(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, org.json.JSONObject jSONObject) {
        if (this.mH5UserIdentityStrategy == null) {
            this.mH5UserIdentityStrategy = new com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityStrategy(this);
        }
        return this.mH5UserIdentityStrategy.processH5UserIdentity(eventType, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void resetAnonymousId() {
        try {
            synchronized (this.mAnonymousId) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "resetAnonymousId is called");
                java.lang.String identifier = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(this.mSAContextManager.getContext());
                if (identifier.equals(this.mAnonymousId.get())) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "DistinctId not change");
                    return;
                }
                if (!com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.isValidAndroidId(identifier)) {
                    identifier = java.util.UUID.randomUUID().toString();
                }
                this.mAnonymousId.commit(identifier);
                if (this.mIdentitiesInstance.getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.DEFAULT).has(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANONYMOUS_ID)) {
                    this.mIdentitiesInstance.updateSpecialIDKeyAndValue(com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.ANONYMOUS_ID, this.mAnonymousId.get());
                }
                if (this.mSAContextManager.getEventListenerList() != null) {
                    java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> it = this.mSAContextManager.getEventListenerList().iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().resetAnonymousId();
                        } catch (java.lang.Exception e) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        }
                    }
                }
                com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().callResetAnonymousId(identifier);
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void resetAnonymousIdentity(java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(this.mLoginIdValue)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "resetAnonymousIdentity 需退出登录后调用");
                return;
            }
            if (android.text.TextUtils.isEmpty(str)) {
                str = java.util.UUID.randomUUID().toString();
            }
            this.mAnonymousId.commit(str);
            this.mIdentitiesInstance.updateIDKeyAndValue(str);
            if (this.mSAContextManager.getEventListenerList() != null) {
                java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> it = this.mSAContextManager.getEventListenerList().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().resetAnonymousId();
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                }
            }
            com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().callResetAnonymousId(str);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public void trackH5Notify(org.json.JSONObject jSONObject) {
        try {
            if (this.mSAContextManager.getEventListenerList() != null) {
                java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> it = this.mSAContextManager.getEventListenerList().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().trackEvent(jSONObject);
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
        com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().callTrack(jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void unbind(java.lang.String str, java.lang.String str2) {
        unbindBack(str, str2);
    }

    public boolean unbindBack(java.lang.String str, java.lang.String str2) {
        try {
            return this.mIdentitiesInstance.remove(str, str2);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public void updateLoginId(java.lang.String str, java.lang.String str2) {
        this.mLoginIdValue = com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.jointLoginID(str, str2);
    }
}
