package com.efs.sdk.base;

/* loaded from: classes22.dex */
public class EfsReporter {
    private static com.efs.sdk.base.core.controller.ControllerCenter sControllerCenter;
    private static com.efs.sdk.base.custommapping.IUMPerfCallback sUMPerfCallback;
    private final java.lang.String TAG;

    public static class Builder {
        private static java.util.Map<java.lang.String, com.efs.sdk.base.EfsReporter> sInstanceMap = new java.util.concurrent.ConcurrentHashMap();
        private static boolean sUseAppContext = true;
        private final java.lang.String TAG;
        private com.efs.sdk.base.core.config.GlobalEnvStruct mGlobalEnvStruct;

        public interface IPublicParams {
            java.util.Map<java.lang.String, java.lang.String> getRecordHeaders();
        }

        public Builder(@androidx.annotation.NonNull android.app.Application application, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
            this(application.getApplicationContext(), str, str2);
        }

        public Builder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
            this.TAG = "efs.reporter.builder";
            android.content.Context checkContext = checkContext(context);
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.RuntimeException("EfsReporter init, appid is empty");
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                throw new java.lang.RuntimeException("EfsReporter init, secret is empty");
            }
            com.efs.sdk.base.core.config.GlobalEnvStruct globalEnvStruct = new com.efs.sdk.base.core.config.GlobalEnvStruct();
            this.mGlobalEnvStruct = globalEnvStruct;
            globalEnvStruct.mAppContext = checkContext;
            globalEnvStruct.setAppid(str);
            this.mGlobalEnvStruct.setSecret(str2);
        }

        private static android.content.Context checkContext(android.content.Context context) {
            if (context == null) {
                com.efs.sdk.base.core.util.Log.e("context can not be null!");
                throw null;
            }
            if (!sUseAppContext || (context instanceof android.app.Application) || ((context = context.getApplicationContext()) != null && (context instanceof android.app.Application))) {
                return context;
            }
            com.efs.sdk.base.core.util.Log.e("Can not get Application context from given context!");
            throw new java.lang.IllegalArgumentException("Can not get Application context from given context!");
        }

        private void checkParam(java.lang.String str) {
            com.efs.sdk.base.core.config.GlobalEnvStruct globalEnvStruct = sInstanceMap.get(str).getGlobalEnvStruct();
            if (!globalEnvStruct.mAppContext.equals(getGlobalEnvStruct().mAppContext)) {
                throw new java.lang.RuntimeException("efs-core: duplicate init, but application context is different");
            }
            if (!android.text.TextUtils.isEmpty(globalEnvStruct.getSecret()) && !globalEnvStruct.getSecret().equals(getGlobalEnvStruct().getSecret())) {
                throw new java.lang.RuntimeException("efs-core: duplicate init, but secret is different");
            }
            if (globalEnvStruct.isIntl() != getGlobalEnvStruct().isIntl()) {
                throw new java.lang.RuntimeException("efs-core: duplicate init, but intl setting is different");
            }
            if (!android.text.TextUtils.isEmpty(getGlobalEnvStruct().getUid()) && !getGlobalEnvStruct().getUid().equals(globalEnvStruct.getUid())) {
                com.efs.sdk.base.core.util.Log.w("efs.reporter.builder", "efs-core: duplicate init, but  uid is different");
            }
            if (getGlobalEnvStruct().getPublicParamMap() == null || getGlobalEnvStruct().getPublicParamMap().size() <= 0) {
                return;
            }
            globalEnvStruct.addPublicParams(getGlobalEnvStruct().getPublicParamMap());
        }

        public com.efs.sdk.base.EfsReporter.Builder addEfsReporterObserver(com.efs.sdk.base.observer.IEfsReporterObserver iEfsReporterObserver) {
            this.mGlobalEnvStruct.addConfigObserver(iEfsReporterObserver);
            return this;
        }

        public com.efs.sdk.base.EfsReporter build() {
            java.lang.String appid = getGlobalEnvStruct().getAppid();
            if (!sInstanceMap.containsKey(appid)) {
                synchronized (com.efs.sdk.base.EfsReporter.class) {
                    if (!sInstanceMap.containsKey(appid)) {
                        com.efs.sdk.base.EfsReporter efsReporter = new com.efs.sdk.base.EfsReporter(this, null);
                        sInstanceMap.put(appid, efsReporter);
                        return efsReporter;
                    }
                }
            }
            com.efs.sdk.base.core.util.Log.w("efs.reporter.builder", "efs-core: duplicate init");
            checkParam(appid);
            return sInstanceMap.get(appid);
        }

        public com.efs.sdk.base.EfsReporter.Builder configRefreshAction(@androidx.annotation.NonNull com.efs.sdk.base.IConfigRefreshAction iConfigRefreshAction) {
            com.efs.sdk.base.core.config.remote.b.a().b = iConfigRefreshAction;
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder configRefreshDelayMills(long j) {
            this.mGlobalEnvStruct.configRefreshDelayMills = j;
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder debug(boolean z) {
            this.mGlobalEnvStruct.setDebug(z);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder efsDirRootName(java.lang.String str) {
            com.efs.sdk.base.core.util.a.a(str);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder enablePaBackup(boolean z) {
            this.mGlobalEnvStruct.setEnablePaBackup(z);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder enableSendLog(boolean z) {
            this.mGlobalEnvStruct.setEnableSendLog(z);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder enableWaStat(boolean z) {
            this.mGlobalEnvStruct.setEnableWaStat(z);
            return this;
        }

        public com.efs.sdk.base.core.config.GlobalEnvStruct getGlobalEnvStruct() {
            return this.mGlobalEnvStruct;
        }

        public com.efs.sdk.base.EfsReporter.Builder intl(boolean z) {
            this.mGlobalEnvStruct.setIsIntl(z);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder logDid(java.lang.String str) {
            this.mGlobalEnvStruct.setLogDid(str);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder logEncryptAction(com.efs.sdk.base.processor.action.ILogEncryptAction iLogEncryptAction) {
            this.mGlobalEnvStruct.setLogEncryptAction(iLogEncryptAction);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder logUid(java.lang.String str) {
            this.mGlobalEnvStruct.setLogUid(str);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder maxConcurrentUploadCnt(int i) {
            com.efs.sdk.base.core.b.e.a().a = i;
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder maxConcurrentUploadCntCodeLog(int i) {
            com.efs.sdk.base.core.b.e.a().b = i;
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder printLogDetail(boolean z) {
            this.mGlobalEnvStruct.setPrintLogDetail(z);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder publicParams(@androidx.annotation.NonNull com.efs.sdk.base.EfsReporter.Builder.IPublicParams iPublicParams) {
            if (iPublicParams.getRecordHeaders() != null && iPublicParams.getRecordHeaders().size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(iPublicParams.getRecordHeaders());
            }
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder publicParams(@androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.String> map) {
            if (map.size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(map);
            }
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder setOpenCodeLog(boolean z) {
            this.mGlobalEnvStruct.setOpenCodeLog(z);
            return this;
        }

        public com.efs.sdk.base.EfsReporter.Builder uid(java.lang.String str) {
            this.mGlobalEnvStruct.setUid(str);
            return this;
        }
    }

    private EfsReporter(com.efs.sdk.base.EfsReporter.Builder builder) {
        this.TAG = "efs.reporter";
        sControllerCenter = new com.efs.sdk.base.core.controller.ControllerCenter(builder);
    }

    public /* synthetic */ EfsReporter(com.efs.sdk.base.EfsReporter.Builder builder, com.efs.sdk.base.EfsReporter.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.NonNull
    public com.efs.sdk.base.core.config.GlobalEnvStruct getGlobalEnvStruct() {
        return com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct();
    }

    public static void registerPerfCallback(com.efs.sdk.base.custommapping.IUMPerfCallback iUMPerfCallback) {
        sUMPerfCallback = iUMPerfCallback;
    }

    public void addPublicParams(@androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.String> map) {
        if (map.size() > 0) {
            getGlobalEnvStruct().addPublicParams(map);
        }
    }

    public void flushRecordLogImmediately(java.lang.String str) {
        com.efs.sdk.base.core.cache.CacheManager.getInstance().flushImmediately((byte) 1, str);
    }

    public java.util.Map<java.lang.String, java.lang.String> getAllConfig() {
        return com.efs.sdk.base.core.config.remote.b.a().c();
    }

    public java.util.Map<java.lang.String, java.lang.Object> getAllSdkConfig() {
        return new java.util.HashMap(com.efs.sdk.base.core.config.remote.b.a().d.mSDKConfigMap);
    }

    public void getAllSdkConfig(java.lang.String[] strArr, com.efs.sdk.base.observer.IConfigCallback iConfigCallback) {
        com.efs.sdk.base.core.config.remote.b a = com.efs.sdk.base.core.config.remote.b.a();
        a.e.put(iConfigCallback, strArr);
        if (a.d.mSDKConfigMap.isEmpty()) {
            return;
        }
        a.d();
    }

    public void getAllSdkConfigFromServer(java.lang.String[] strArr, com.efs.sdk.base.observer.IConfigCallback iConfigCallback) {
        com.efs.sdk.base.core.config.remote.b.a().f.put(iConfigCallback, strArr);
    }

    public java.util.Map<java.lang.String, java.lang.Object> getStrategyMap() {
        return new java.util.HashMap(com.efs.sdk.base.core.config.remote.b.a().d.mStrategyMap);
    }

    public void refreshConfig(java.lang.String str) {
        com.efs.sdk.base.core.config.remote.b.a().a(str);
    }

    public void registerCallback(int i, android.webkit.ValueCallback<android.util.Pair<android.os.Message, android.os.Message>> valueCallback) {
        getGlobalEnvStruct().registerCallback(i, valueCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:2:0x0000, B:4:0x0004, B:13:0x0034, B:15:0x0038, B:16:0x003d, B:17:0x0048, B:19:0x004c, B:20:0x0051, B:21:0x0018, B:24:0x0022), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void send(com.efs.sdk.base.protocol.ILogProtocol iLogProtocol) {
        char c;
        try {
            if (iLogProtocol instanceof com.efs.sdk.base.protocol.record.EfsJSONLog) {
                java.lang.String logType = iLogProtocol.getLogType();
                int hashCode = logType.hashCode();
                if (hashCode != -2128464309) {
                    if (hashCode == 846000494 && logType.equals("powerperf")) {
                        c = 0;
                        if (c != 0) {
                            com.efs.sdk.base.custommapping.IUMPerfCallback iUMPerfCallback = sUMPerfCallback;
                            if (iUMPerfCallback != null) {
                                iUMPerfCallback.onCallback(com.efs.sdk.base.custommapping.IUMPerfCallback.PerfType.PERF_TYPE_POWER);
                            }
                            ((com.efs.sdk.base.protocol.record.EfsJSONLog) iLogProtocol).put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_CUSTOM_MAPPING, com.efs.sdk.base.custommapping.InnerCustomMappingManager.getCustomMappingJsonStr());
                        } else if (c == 1) {
                            com.efs.sdk.base.custommapping.IUMPerfCallback iUMPerfCallback2 = sUMPerfCallback;
                            if (iUMPerfCallback2 != null) {
                                iUMPerfCallback2.onCallback(com.efs.sdk.base.custommapping.IUMPerfCallback.PerfType.PERF_TYPE_START);
                            }
                            ((com.efs.sdk.base.protocol.record.EfsJSONLog) iLogProtocol).put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_CUSTOM_MAPPING, com.efs.sdk.base.custommapping.InnerCustomMappingManager.getCustomMappingJsonStr());
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else {
                    if (logType.equals(com.efs.sdk.base.Constants.LOG_TYPE_STARTPERF)) {
                        c = 1;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        sControllerCenter.send(iLogProtocol);
    }

    public com.efs.sdk.base.http.HttpResponse sendSyncImediatelly(java.lang.String str, int i, java.lang.String str2, java.io.File file) {
        return sendSyncImediatelly(str, i, str2, true, file);
    }

    public com.efs.sdk.base.http.HttpResponse sendSyncImediatelly(java.lang.String str, int i, java.lang.String str2, boolean z, java.io.File file) {
        return sControllerCenter.sendSyncImmediately(str, i, str2, z, file);
    }

    public void setEnableRefreshConfigFromRemote(boolean z) {
        com.efs.sdk.base.core.config.remote.b.a().c = z;
    }

    public void setFileFilterCodeLog(com.efs.sdk.base.core.cache.IFileFilter iFileFilter) {
        com.efs.sdk.base.core.b.e.a().d = iFileFilter;
    }
}
