package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class NativeCPUAdData implements com.baidu.mobads.sdk.api.IBasicCPUData, java.util.Observer {
    private static final java.lang.String CLASS_NAME = com.baidu.mobads.sdk.internal.z.l;
    private final java.lang.ClassLoader classLoader;
    private com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB mCpuNativeStatusCBListener;
    private final android.content.Context mCtx;
    public java.lang.Object mInstance;
    private final java.util.HashMap<java.lang.String, java.lang.Object> mSettings;
    public com.baidu.mobads.sdk.internal.at remoteUtils;

    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$1, reason: invalid class name */
    class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ android.view.View val$clickView;

        /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$1$1, reason: invalid class name and collision with other inner class name */
        class RunnableC02501 implements java.lang.Runnable {
            public RunnableC02501() {
            }

            @Override // java.lang.Runnable
            public void run() {
                android.view.View view = com.baidu.mobads.sdk.api.NativeCPUAdData.AnonymousClass1.this.val$clickView;
                if (view != null) {
                    view.setClickable(true);
                }
            }
        }

        public AnonymousClass1(android.view.View view) {
            this.val$clickView = view;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.baidu.mobads.sdk.api.NativeCPUAdData.this.handleCanClickView(view);
            this.val$clickView.setClickable(false);
            this.val$clickView.postDelayed(new com.baidu.mobads.sdk.api.NativeCPUAdData.AnonymousClass1.RunnableC02501(), 1000L);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$2, reason: invalid class name */
    class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ java.util.List val$clickViews;
        final /* synthetic */ android.view.View val$creativeView;

        /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$2$1, reason: invalid class name */
        class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.mobads.sdk.api.NativeCPUAdData.AnonymousClass2 anonymousClass2 = com.baidu.mobads.sdk.api.NativeCPUAdData.AnonymousClass2.this;
                if (anonymousClass2.val$clickViews != null) {
                    anonymousClass2.val$creativeView.setClickable(true);
                }
            }
        }

        public AnonymousClass2(android.view.View view, java.util.List list) {
            this.val$creativeView = view;
            this.val$clickViews = list;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.baidu.mobads.sdk.api.NativeCPUAdData.this.handleCreativeView(view);
            this.val$creativeView.setClickable(false);
            this.val$creativeView.postDelayed(new com.baidu.mobads.sdk.api.NativeCPUAdData.AnonymousClass2.AnonymousClass1(), 1000L);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.NativeCPUAdData$3, reason: invalid class name */
    class AnonymousClass3 implements java.lang.reflect.InvocationHandler {
        final /* synthetic */ com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB val$cpuNativeStatusCBListener;

        public AnonymousClass3(com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
            this.val$cpuNativeStatusCBListener = cpuNativeStatusCB;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            com.baidu.mobads.sdk.internal.ay.h("NativeCPUAdData").c("invoke: " + method.getName());
            if (this.val$cpuNativeStatusCBListener == null) {
                return null;
            }
            java.lang.String name = method.getName();
            if ("onAdDownloadWindowShow".equals(name)) {
                this.val$cpuNativeStatusCBListener.onAdDownloadWindowShow();
            } else if ("onPermissionShow".equals(name)) {
                this.val$cpuNativeStatusCBListener.onPermissionShow();
            } else if ("onPermissionClose".equals(name)) {
                this.val$cpuNativeStatusCBListener.onPermissionClose();
            } else if ("onPrivacyClick".equals(name)) {
                this.val$cpuNativeStatusCBListener.onPrivacyClick();
            } else if ("onPrivacyLpClose".equals(name)) {
                this.val$cpuNativeStatusCBListener.onPrivacyLpClose();
            } else if ("onNotifyPerformance".equals(name)) {
                if (objArr != null && objArr.length >= 1) {
                    java.lang.Object obj2 = objArr[0];
                    if (obj2 instanceof java.lang.String) {
                        this.val$cpuNativeStatusCBListener.onNotifyPerformance((java.lang.String) obj2);
                    }
                }
            } else if ("startRouter".equals(name)) {
                com.baidu.mobads.sdk.internal.an.a((android.content.Context) objArr[0], (java.lang.String) objArr[1]);
            }
            return null;
        }
    }

    public NativeCPUAdData(android.content.Context context, java.lang.Object obj, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = com.baidu.mobads.sdk.internal.at.a(context, CLASS_NAME);
        this.classLoader = com.baidu.mobads.sdk.internal.bs.a(context);
    }

    private java.lang.String getAdid() {
        return this.remoteUtils.c(this.mInstance, "getAdid", new java.lang.Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCanClickView(android.view.View view) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof com.baidu.mobads.sdk.api.CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof android.widget.TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.a(this.mInstance, "handleCanClickView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void cancelAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        com.baidu.mobads.sdk.internal.as.a(this.mCtx.getApplicationContext()).b(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void clickHotItem(android.view.View view) {
        this.remoteUtils.a(this.mInstance, "clickHotItem", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getActionType() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getActionType", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdHeight() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getAdHeight", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getAdLogoUrl() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getAdLogoUrl", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdWidth() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getAdWidth", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getAppPackageName() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getPackageName", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getAppPermissionUrl() {
        return this.remoteUtils.c(this.mInstance, "getAppPermissionUrl", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getAppPrivacyUrl() {
        return this.remoteUtils.c(this.mInstance, "getAppPrivacyUrl", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getAppPublisher() {
        return this.remoteUtils.c(this.mInstance, "getAppPublisher", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getAppVersion() {
        return this.remoteUtils.c(this.mInstance, "getAppVersion", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAttribute() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getAttribute", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getAuthor() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getAuthor", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getBaiduLogoUrl() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getBaiduLogoUrl", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getBrandName() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getBrandName", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getChannelId() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getCatId", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getChannelName() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getCatName", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getCommentCounts() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getCommentCounts", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.util.List<java.lang.Integer> getContentAttributesList() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getContentAttributesList", new java.lang.Object[0]);
        if (b instanceof java.util.List) {
            return (java.util.List) b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getContentClickUrl() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getContentClickUrl", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getCtime() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getCtime", new java.lang.Object[0]);
        if (b instanceof java.lang.Long) {
            return ((java.lang.Long) b).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getDesc() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getContent", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public org.json.JSONArray getDislikeReasons() {
        return (org.json.JSONArray) this.remoteUtils.b(this.mInstance, "getDislikeReasons", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDownloadStatus() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getDownloadStatus", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDuration() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getDuration", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public org.json.JSONObject getExtra() {
        return (org.json.JSONObject) this.remoteUtils.b(this.mInstance, "getExtra", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getHotId() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getHotId", new java.lang.Object[0]);
        if (b instanceof java.lang.Long) {
            return ((java.lang.Long) b).longValue();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getHotWord() {
        return this.remoteUtils.c(this.mInstance, "getHotWord", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getIconUrl() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getAvatar", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getImage() {
        return this.remoteUtils.c(this.mInstance, "getImage", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.util.List<java.lang.String> getImageUrls() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getImageList", new java.lang.Object[0]);
        if (b instanceof java.util.List) {
            return (java.util.List) b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getLabel() {
        return this.remoteUtils.c(this.mInstance, "getLabel", new java.lang.Object[0]);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPlayCounts() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getPlayCounts", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPresentationType() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getPresentationType", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getReadCounts() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getReadCounts", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public double getScore() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getScore", new java.lang.Object[0]);
        if (b instanceof java.lang.Double) {
            return ((java.lang.Double) b).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.util.List<java.lang.String> getSmallImageUrls() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getSmallImageList", new java.lang.Object[0]);
        if (b instanceof java.util.List) {
            return (java.util.List) b;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getStyleTypeCpu() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getStyleTypeCpu", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbHeight() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getThumbHeight", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getThumbUrl() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getThumbUrl", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbWidth() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getThumbWidth", new java.lang.Object[0]);
        if (b instanceof java.lang.Integer) {
            return ((java.lang.Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getTitle() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getTitle", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getType() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getType", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getUpdateTime() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getUpdateTime", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public java.lang.String getVUrl() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "getVUrl", new java.lang.Object[0]);
        return b instanceof java.lang.String ? (java.lang.String) b : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleClick(android.view.View view, java.lang.Object... objArr) {
        long j;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (objArr != null && objArr.length > 0) {
            java.lang.Object obj = objArr[0];
            if (obj instanceof java.lang.Long) {
                j = ((java.lang.Long) obj).longValue();
                if (!(view instanceof com.baidu.mobads.sdk.api.CpuVideoView)) {
                    this.remoteUtils.a(this.mInstance, "handClickVideo", 1, java.lang.Long.valueOf(j));
                } else if (view instanceof android.widget.TextView) {
                    this.remoteUtils.a(this.mInstance, "handClickVideo", 2, java.lang.Long.valueOf(j));
                }
                this.remoteUtils.a(this.mInstance, "handleClick", view);
            }
        }
        j = 0;
        if (!(view instanceof com.baidu.mobads.sdk.api.CpuVideoView)) {
        }
        this.remoteUtils.a(this.mInstance, "handleClick", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleCreativeView(android.view.View view) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        if (view instanceof com.baidu.mobads.sdk.api.CpuVideoView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
        } else if (view instanceof android.widget.TextView) {
            this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
        }
        this.remoteUtils.a(this.mInstance, "handleCreativeView", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleDislikeClick(android.view.View view, int i) {
        this.remoteUtils.a(this.mInstance, "handleDislikeClick", view, java.lang.Integer.valueOf(i));
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isAutoplay() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "isAutoplay", new java.lang.Object[0]);
        if (b instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) b).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isCanGoLp() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "isCanGoLp", new java.lang.Object[0]);
        if (b instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) b).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isNeedDownloadApp() {
        return ((java.lang.Boolean) this.remoteUtils.b(this.mInstance, "isDownloadApp", new java.lang.Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isTop() {
        java.lang.Object b = this.remoteUtils.b(this.mInstance, "isTop", new java.lang.Object[0]);
        if (b instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) b).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void markDislike(java.lang.String[] strArr) {
        this.remoteUtils.a(this.mInstance, "markDislike", strArr);
    }

    public void monitorVisibleTime(android.view.View view) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "monitorVisibleTime", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void onImpression(android.view.View view) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.mSettings;
        if (hashMap != null) {
            this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
        }
        this.remoteUtils.a(this.mInstance, "onImpression", view);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void pauseAppDownload() {
        if (this.mCtx == null || !isNeedDownloadApp()) {
            return;
        }
        com.baidu.mobads.sdk.internal.as.a(this.mCtx.getApplicationContext()).a(getAppPackageName());
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void registerViewForInteraction(android.view.View view, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        setStatusListener(cpuNativeStatusCB);
        onImpression(view);
        monitorVisibleTime(view);
        if (list != null && list.size() > 0) {
            for (android.view.View view2 : list) {
                if (view2 != null) {
                    view2.setOnClickListener(new com.baidu.mobads.sdk.api.NativeCPUAdData.AnonymousClass1(view2));
                }
            }
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (android.view.View view3 : list2) {
            if (view3 != null) {
                view3.setOnClickListener(new com.baidu.mobads.sdk.api.NativeCPUAdData.AnonymousClass2(view3, list));
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void setStatusListener(com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        this.mCpuNativeStatusCBListener = cpuNativeStatusCB;
        try {
            this.remoteUtils.a(this.mInstance, "setStatusListener", java.lang.reflect.Proxy.newProxyInstance(this.classLoader, new java.lang.Class[]{com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.n, this.classLoader)}, new com.baidu.mobads.sdk.api.NativeCPUAdData.AnonymousClass3(cpuNativeStatusCB)));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(java.util.Observable observable, java.lang.Object obj) {
        if ((observable instanceof com.baidu.mobads.sdk.internal.ae) && this.mCpuNativeStatusCBListener != null && isNeedDownloadApp() && (obj instanceof com.baidu.mobads.sdk.api.IOAdEvent)) {
            com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent = (com.baidu.mobads.sdk.api.IOAdEvent) obj;
            java.lang.String message = iOAdEvent.getMessage();
            java.util.Map<java.lang.String, java.lang.Object> data = iOAdEvent.getData();
            if (data != null) {
                java.lang.Object obj2 = data.get("adid");
                if ((obj2 instanceof java.lang.String) && ((java.lang.String) obj2).equals(getAdid())) {
                    this.mCpuNativeStatusCBListener.onAdStatusChanged(message, getDownloadStatus());
                }
            }
        }
    }
}
