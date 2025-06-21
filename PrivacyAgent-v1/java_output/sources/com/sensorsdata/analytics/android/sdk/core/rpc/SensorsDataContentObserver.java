package com.sensorsdata.analytics.android.sdk.core.rpc;

/* loaded from: classes19.dex */
public class SensorsDataContentObserver extends android.database.ContentObserver {

    public enum State {
        LOGOUT(false, false),
        LOGIN(false, false),
        ENABLE_SDK(false, false),
        DISABLE_SDK(false, false);

        public boolean isDid;
        public boolean isObserverCalled;

        State(boolean z, boolean z2) {
            this.isDid = z;
            this.isObserverCalled = z2;
        }
    }

    public SensorsDataContentObserver() {
        super(new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:2:0x0000, B:4:0x000e, B:7:0x001f, B:9:0x002f, B:11:0x0045, B:16:0x0053, B:20:0x005e, B:22:0x0064, B:24:0x0067, B:26:0x0072, B:28:0x0078, B:30:0x007b, B:34:0x0083, B:36:0x0091, B:38:0x0097, B:40:0x009a, B:42:0x00a0, B:44:0x00ae, B:46:0x00b4, B:48:0x00b7, B:50:0x00bd, B:52:0x00cb, B:55:0x00d4, B:57:0x00da), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:2:0x0000, B:4:0x000e, B:7:0x001f, B:9:0x002f, B:11:0x0045, B:16:0x0053, B:20:0x005e, B:22:0x0064, B:24:0x0067, B:26:0x0072, B:28:0x0078, B:30:0x007b, B:34:0x0083, B:36:0x0091, B:38:0x0097, B:40:0x009a, B:42:0x00a0, B:44:0x00ae, B:46:0x00b4, B:48:0x00b7, B:50:0x00bd, B:52:0x00cb, B:55:0x00d4, B:57:0x00da), top: B:1:0x0000 }] */
    @Override // android.database.ContentObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onChange(boolean z, android.net.Uri uri) {
        com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager;
        boolean z2;
        try {
            if (com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getSessionTimeUri().equals(uri)) {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().setSessionIntervalTime(com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getSessionIntervalTime());
                return;
            }
            if (!com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getLoginIdUri().equals(uri)) {
                if (com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getDisableSDKUri().equals(uri)) {
                    com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State state = com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.DISABLE_SDK;
                    if (state.isDid) {
                        state.isDid = false;
                        return;
                    } else {
                        state.isObserverCalled = true;
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI.disableSDK();
                        return;
                    }
                }
                if (com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getEnableSDKUri().equals(uri)) {
                    com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State state2 = com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.ENABLE_SDK;
                    if (state2.isDid) {
                        state2.isDid = false;
                        return;
                    } else {
                        state2.isObserverCalled = true;
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI.enableSDK();
                        return;
                    }
                }
                if (com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getUserIdentities().equals(uri)) {
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance();
                    if ((sharedInstance instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation) || (sAContextManager = sharedInstance.getSAContextManager()) == null) {
                        return;
                    }
                    sAContextManager.getUserIdentityAPI().getIdentitiesInstance().updateIdentities();
                    return;
                }
                return;
            }
            java.lang.String loginIdKey = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getLoginIdKey();
            java.lang.String loginId = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getLoginId();
            if (!android.text.TextUtils.isEmpty(loginId) && !loginIdKey.equals(com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.LOGIN_ID_KEY_DEFAULT)) {
                z2 = false;
                if (!z2 && android.text.TextUtils.isEmpty(loginId)) {
                    com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State state3 = com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.LOGIN;
                    if (state3.isDid) {
                        state3.isDid = false;
                        return;
                    } else {
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().loginWithKey(loginIdKey, loginId);
                        return;
                    }
                }
                com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State state4 = com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.LOGOUT;
                if (state4.isDid) {
                    state4.isDid = false;
                    return;
                } else {
                    state4.isObserverCalled = true;
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().logout();
                    return;
                }
            }
            z2 = true;
            if (!z2 && android.text.TextUtils.isEmpty(loginId)) {
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
