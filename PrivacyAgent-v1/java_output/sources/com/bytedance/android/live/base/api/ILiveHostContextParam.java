package com.bytedance.android.live.base.api;

/* loaded from: classes.dex */
public interface ILiveHostContextParam {

    public static class Builder {
        private int aid;
        private int appIcon;
        private java.lang.String appName;
        private java.lang.String channel;
        private android.app.Application context;
        private java.lang.String generalAppId;
        private com.bytedance.android.live.base.api.ILiveHostActionParam hostActionParam;
        private boolean isBoe;
        private boolean isDebug;
        private com.bytedance.android.live.base.api.MethodChannelService methodChannelService;
        private java.lang.String partner;
        private java.lang.String partnerSecret;
        private boolean runInLiveProcess;
        private java.lang.String ttSDKAppId;
        private java.lang.String ttSDKCertAssetsPath;
        private java.lang.String version;
        private int versionCode;
        private java.lang.String cjAppId = "";
        private java.lang.String cjMerchantId = "";
        private java.lang.String nativeLibraryDir = "";
        private java.util.Map<java.lang.String, java.lang.String> feParamsExtra = null;
        private java.lang.String ecHostAppId = null;
        private java.lang.String clientKey = "";
        private org.json.JSONObject paramsExtraSettings = null;
        private java.util.HashMap<java.lang.String, java.lang.String> hostInitExtra = null;
        private com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth injectionAuth = null;
        private com.bytedance.android.live.base.api.param.IUserIdGetter userIdGetter = new com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.AnonymousClass1();
        private com.bytedance.android.live.base.api.IHostPermission hostPermission = new com.bytedance.android.live.base.api.DefaultHostPermission();

        /* renamed from: com.bytedance.android.live.base.api.ILiveHostContextParam$Builder$1, reason: invalid class name */
        class AnonymousClass1 implements com.bytedance.android.live.base.api.param.IUserIdGetter {
            public AnonymousClass1() {
            }

            @Override // com.bytedance.android.live.base.api.param.IUserIdGetter
            public java.lang.String getUserId() {
                return "";
            }
        }

        /* renamed from: com.bytedance.android.live.base.api.ILiveHostContextParam$Builder$2, reason: invalid class name */
        class AnonymousClass2 implements com.bytedance.android.live.base.api.ILiveHostContextParam {
            final /* synthetic */ com.bytedance.android.live.base.api.ILiveHostContextParam.Builder val$selfBuilder;

            public AnonymousClass2(com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder) {
                this.val$selfBuilder = builder;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public int getAid() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.aid;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public int getAppIcon() {
                android.content.pm.ApplicationInfo applicationInfo;
                if (com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.appIcon == 0) {
                    com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder = com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this;
                    android.content.pm.PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                    if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                        return applicationInfo.icon;
                    }
                }
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.appIcon;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getAppName() {
                android.content.pm.ApplicationInfo applicationInfo;
                if (com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.appName == null) {
                    com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder = com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this;
                    android.content.pm.PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                    if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                        return applicationInfo.name;
                    }
                }
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.appName;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getCJAppId() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.cjAppId;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getCJMerchantId() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.cjMerchantId;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getChannel() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.channel;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getClientKey() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.clientKey;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public android.app.Application getContext() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.context;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public boolean getDebug() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.isDebug;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getECHostAppId() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.ecHostAppId;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.util.Map<java.lang.String, java.lang.String> getFEParamsExtra() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.feParamsExtra;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getGeneralAppId() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.generalAppId;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public com.bytedance.android.live.base.api.ILiveHostActionParam getHostAction() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.hostActionParam;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.util.Map<java.lang.String, java.lang.String> getHostInitExtra() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.hostInitExtra;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public com.bytedance.android.live.base.api.IHostPermission getHostPermission() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.hostPermission;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getNativeLibraryDir() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.nativeLibraryDir;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public org.json.JSONObject getParamsExtraSettings() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.paramsExtraSettings;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getPartner() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.partner;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getPartnerSecret() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.partnerSecret;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public boolean getRunInLiveProcess() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.runInLiveProcess;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getTtSDKAppId() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.ttSDKAppId;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getTtSDKCertAssetsPath() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.ttSDKCertAssetsPath;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public java.lang.String getVersion() {
                java.lang.String str;
                if (com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.version != null) {
                    return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.version;
                }
                com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder = com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this;
                android.content.pm.PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                return (packageInfo == null || (str = packageInfo.versionName) == null) ? "1.0.0-default" : str;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public int getVersionCode() {
                if (com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.versionCode != 0) {
                    return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.versionCode;
                }
                com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder = com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this;
                android.content.pm.PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
                return 1;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth injectAccount() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.injectionAuth;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public boolean isBoe() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.isBoe;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public com.bytedance.android.live.base.api.MethodChannelService provideMethodChannel() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.methodChannelService;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public com.bytedance.android.live.base.api.param.IUserIdGetter provideUserIdGetter() {
                return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.userIdGetter;
            }

            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
            public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder toBuilder() {
                try {
                    return com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.this.copy(this.val$selfBuilder);
                } catch (java.lang.Exception unused) {
                    return this.val$selfBuilder;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder copy(com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder) {
            com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder2 = new com.bytedance.android.live.base.api.ILiveHostContextParam.Builder();
            for (java.lang.reflect.Field field : com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.class.getDeclaredFields()) {
                boolean isAccessible = field.isAccessible();
                if (!isAccessible) {
                    field.setAccessible(true);
                }
                field.set(builder2, field.get(builder));
                field.setAccessible(isAccessible);
            }
            return builder2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public android.content.pm.PackageInfo getPackageInfo(android.app.Application application) {
            try {
                return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder addHostInitExtra(java.util.Map<java.lang.String, java.lang.String> map) {
            if (map != null) {
                if (this.hostInitExtra == null) {
                    this.hostInitExtra = new java.util.HashMap<>();
                }
                this.hostInitExtra.putAll(map);
            }
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam build() {
            return new com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.AnonymousClass2(this);
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder provideMethodChannel(com.bytedance.android.live.base.api.MethodChannelService methodChannelService) {
            this.methodChannelService = methodChannelService;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setAid(int i) {
            this.aid = i;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setAppIcon(int i) {
            this.appIcon = i;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setAppName(java.lang.String str) {
            this.appName = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setChannel(java.lang.String str) {
            this.channel = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setCjAppId(java.lang.String str) {
            this.cjAppId = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setCjMerchantId(java.lang.String str) {
            this.cjMerchantId = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setClientKey(java.lang.String str) {
            this.clientKey = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setContext(android.app.Application application) {
            this.context = application;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setECHostAppId(java.lang.String str) {
            this.ecHostAppId = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setFeParamsExtra(java.util.Map<java.lang.String, java.lang.String> map) {
            this.feParamsExtra = map;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setGeneralAppId(java.lang.String str) {
            this.generalAppId = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setHostActionParam(com.bytedance.android.live.base.api.ILiveHostActionParam iLiveHostActionParam) {
            this.hostActionParam = iLiveHostActionParam;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setHostPermission(com.bytedance.android.live.base.api.IHostPermission iHostPermission) {
            if (iHostPermission != null) {
                this.hostPermission = iHostPermission;
            }
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setInjectionAuth(com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth iHostTokenInjectionAuth) {
            this.injectionAuth = iHostTokenInjectionAuth;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setIsBoe(boolean z) {
            this.isBoe = z;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setIsDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setNativeLibraryDir(java.lang.String str) {
            this.nativeLibraryDir = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setParamsExtraSettings(org.json.JSONObject jSONObject) {
            this.paramsExtraSettings = jSONObject;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setPartner(java.lang.String str) {
            this.partner = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setPartnerSecret(java.lang.String str) {
            this.partnerSecret = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setRunInLiveProcess(boolean z) {
            this.runInLiveProcess = z;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setTtSDKAppId(java.lang.String str) {
            this.ttSDKAppId = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setTtSDKCertAssetsPath(java.lang.String str) {
            this.ttSDKCertAssetsPath = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setUserIdGetter(com.bytedance.android.live.base.api.param.IUserIdGetter iUserIdGetter) {
            this.userIdGetter = iUserIdGetter;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setVersion(java.lang.String str) {
            this.version = str;
            return this;
        }

        public com.bytedance.android.live.base.api.ILiveHostContextParam.Builder setVersionCode(int i) {
            this.versionCode = i;
            return this;
        }
    }

    int getAid();

    int getAppIcon();

    java.lang.String getAppName();

    java.lang.String getCJAppId();

    java.lang.String getCJMerchantId();

    java.lang.String getChannel();

    java.lang.String getClientKey();

    android.app.Application getContext();

    boolean getDebug();

    java.lang.String getECHostAppId();

    java.util.Map<java.lang.String, java.lang.String> getFEParamsExtra();

    java.lang.String getGeneralAppId();

    com.bytedance.android.live.base.api.ILiveHostActionParam getHostAction();

    java.util.Map<java.lang.String, java.lang.String> getHostInitExtra();

    com.bytedance.android.live.base.api.IHostPermission getHostPermission();

    java.lang.String getNativeLibraryDir();

    org.json.JSONObject getParamsExtraSettings();

    java.lang.String getPartner();

    java.lang.String getPartnerSecret();

    boolean getRunInLiveProcess();

    java.lang.String getTtSDKAppId();

    java.lang.String getTtSDKCertAssetsPath();

    java.lang.String getVersion();

    int getVersionCode();

    com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth injectAccount();

    boolean isBoe();

    com.bytedance.android.live.base.api.MethodChannelService provideMethodChannel();

    com.bytedance.android.live.base.api.param.IUserIdGetter provideUserIdGetter();

    com.bytedance.android.live.base.api.ILiveHostContextParam.Builder toBuilder();
}
