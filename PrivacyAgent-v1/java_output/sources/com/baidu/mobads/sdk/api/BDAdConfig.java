package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class BDAdConfig {
    private android.content.Context mAppContext;
    private java.lang.String mAppName;
    private java.lang.String mAppsid;
    private com.baidu.mobads.sdk.api.BDAdConfig.BDAdInitListener mBDAdInitListener;
    private java.lang.String mChannelId;
    private boolean mCloseShake;
    private org.json.JSONObject mConfigObj;
    private boolean mDebug;
    private org.json.JSONObject mDialogParams;
    private org.json.JSONObject mExtraParams;
    private boolean mHttps;
    private boolean mLpMultiProcess;
    private boolean mMtjSwitch;
    private boolean mSplashLog;
    private boolean mUseActivityDialog;
    private int mVideoCacheCapacityMb;
    private java.lang.String mWXAPPid;

    /* renamed from: com.baidu.mobads.sdk.api.BDAdConfig$1, reason: invalid class name */
    class AnonymousClass1 implements com.baidu.mobads.sdk.internal.aa.a {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.aa.a
        public void onFailure() {
            if (com.baidu.mobads.sdk.api.BDAdConfig.this.mBDAdInitListener != null) {
                com.baidu.mobads.sdk.api.BDAdConfig.this.mBDAdInitListener.fail();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.aa.a
        public void onSuccess() {
            com.baidu.mobads.sdk.api.IXAdContainerFactory c = com.baidu.mobads.sdk.internal.aa.a().c();
            if (c != null) {
                c.initConfig(com.baidu.mobads.sdk.api.BDAdConfig.this.mConfigObj);
                c.onTaskDistribute(com.baidu.mobads.sdk.internal.bc.a, com.baidu.mobads.sdk.api.MobadsPermissionSettings.getPermissionInfo());
            }
            if (com.baidu.mobads.sdk.api.BDAdConfig.this.mBDAdInitListener != null) {
                com.baidu.mobads.sdk.api.BDAdConfig.this.mBDAdInitListener.success();
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.BDAdConfig$2, reason: invalid class name */
    class AnonymousClass2 implements com.baidu.mobads.sdk.internal.aa.a {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.internal.aa.a
        public void onFailure() {
            if (com.baidu.mobads.sdk.api.BDAdConfig.this.mBDAdInitListener != null) {
                com.baidu.mobads.sdk.api.BDAdConfig.this.mBDAdInitListener.fail();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.aa.a
        public void onSuccess() {
            com.baidu.mobads.sdk.internal.aa.a().c();
            if (com.baidu.mobads.sdk.api.BDAdConfig.this.mBDAdInitListener != null) {
                com.baidu.mobads.sdk.api.BDAdConfig.this.mBDAdInitListener.success();
            }
        }
    }

    public interface BDAdInitListener {
        void fail();

        void success();
    }

    public static class Builder {
        private java.lang.String mAppName;
        private java.lang.String mAppsid;
        private com.baidu.mobads.sdk.api.BDAdConfig.BDAdInitListener mBDAdInitListener;
        private java.lang.String mChannelId;
        private org.json.JSONObject mDialogParams;
        private org.json.JSONObject mExtraParams;
        private boolean mLpSupportMultiProcess;
        private int mVideoCacheCapacityMb;
        private java.lang.String mWXAPPid;
        private boolean mHttps = true;
        private boolean mUseActivityDialog = true;
        private boolean mMtjSwitch = true;
        private boolean mCloseShake = false;
        private boolean mDebug = false;
        private boolean mSplashLog = false;

        public com.baidu.mobads.sdk.api.BDAdConfig build(android.content.Context context) {
            return new com.baidu.mobads.sdk.api.BDAdConfig(context, this, null);
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder putExtraParam(java.lang.String str, java.lang.String str2) {
            if (this.mExtraParams == null) {
                this.mExtraParams = new org.json.JSONObject();
            }
            try {
                this.mExtraParams.put(str, str2);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setAppName(java.lang.String str) {
            this.mAppName = str;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setAppsid(java.lang.String str) {
            this.mAppsid = str;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setBDAdInitListener(com.baidu.mobads.sdk.api.BDAdConfig.BDAdInitListener bDAdInitListener) {
            this.mBDAdInitListener = bDAdInitListener;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setChannelId(java.lang.String str) {
            this.mChannelId = str;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setCloseShake(boolean z) {
            this.mCloseShake = z;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setDebug(boolean z) {
            this.mDebug = z;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setDialogParams(com.baidu.mobads.sdk.api.BDDialogParams bDDialogParams) {
            this.mDialogParams = bDDialogParams.toJson();
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setHttps(boolean z) {
            this.mHttps = z;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setLpMultiProcess(boolean z) {
            this.mLpSupportMultiProcess = z;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setMtjSwitch(boolean z) {
            this.mMtjSwitch = z;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setSplashLog(boolean z) {
            this.mSplashLog = z;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setVideoCacheCapacityMb(int i) {
            this.mVideoCacheCapacityMb = i;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDAdConfig.Builder setWXAppid(java.lang.String str) {
            this.mWXAPPid = str;
            return this;
        }

        @java.lang.Deprecated
        public com.baidu.mobads.sdk.api.BDAdConfig.Builder useActivityDialog(java.lang.Boolean bool) {
            this.mUseActivityDialog = bool.booleanValue();
            return this;
        }
    }

    private BDAdConfig(android.content.Context context, com.baidu.mobads.sdk.api.BDAdConfig.Builder builder) {
        this.mUseActivityDialog = true;
        this.mDebug = false;
        this.mSplashLog = false;
        this.mHttps = builder.mHttps;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
        this.mUseActivityDialog = builder.mUseActivityDialog;
        this.mDialogParams = builder.mDialogParams;
        this.mMtjSwitch = builder.mMtjSwitch;
        this.mCloseShake = builder.mCloseShake;
        this.mDebug = builder.mDebug;
        this.mWXAPPid = builder.mWXAPPid;
        this.mBDAdInitListener = builder.mBDAdInitListener;
        this.mSplashLog = builder.mSplashLog;
        this.mExtraParams = builder.mExtraParams;
    }

    public /* synthetic */ BDAdConfig(android.content.Context context, com.baidu.mobads.sdk.api.BDAdConfig.Builder builder, com.baidu.mobads.sdk.api.BDAdConfig.AnonymousClass1 anonymousClass1) {
        this(context, builder);
    }

    public static void clearMemoryCache() {
        try {
            com.baidu.mobads.sdk.internal.aa.a().c().onTaskDistribute(com.baidu.mobads.sdk.internal.bc.c, null);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void initConfig() {
        try {
            if (this.mConfigObj == null) {
                this.mConfigObj = new org.json.JSONObject();
            }
            this.mConfigObj.put("https", "" + this.mHttps);
            this.mConfigObj.put("appName", this.mAppName);
            this.mConfigObj.put("videoCacheSize", "" + this.mVideoCacheCapacityMb);
            this.mConfigObj.put("appsid", this.mAppsid);
            this.mConfigObj.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, this.mChannelId);
            this.mConfigObj.put("lpMultiProcess", "" + this.mLpMultiProcess);
            this.mConfigObj.put("useActivityDialog", "" + this.mUseActivityDialog);
            this.mConfigObj.put("dialog_params", this.mDialogParams);
            this.mConfigObj.put("mtj_switch", this.mMtjSwitch);
            this.mConfigObj.put("sp_shake", this.mCloseShake);
            this.mConfigObj.put("sdk_debug", this.mDebug);
            this.mConfigObj.put("splashLog", this.mSplashLog);
            this.mConfigObj.put("extras", this.mExtraParams);
            if (!android.text.TextUtils.isEmpty(this.mWXAPPid)) {
                this.mConfigObj.put("wxAppid", this.mWXAPPid);
            }
            com.baidu.mobads.sdk.internal.cq.a().a(this.mLpMultiProcess);
            com.baidu.mobads.sdk.internal.cq.a().b(this.mHttps);
            com.baidu.mobads.sdk.internal.ay.a(this.mDebug);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void init() {
        initConfig();
        org.json.JSONObject jSONObject = this.mConfigObj;
        if (jSONObject != null) {
            try {
                jSONObject.put("gmss", com.baidu.mobads.sdk.internal.e.a());
                this.mConfigObj.put("toss", com.baidu.mobads.sdk.internal.e.b());
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        com.baidu.mobads.sdk.internal.aa.a().a(this.mAppContext, new com.baidu.mobads.sdk.api.BDAdConfig.AnonymousClass1());
    }

    public void preInit() {
        try {
            initConfig();
            com.baidu.mobads.sdk.internal.aa.a().a(this.mAppContext, new com.baidu.mobads.sdk.api.BDAdConfig.AnonymousClass2());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
