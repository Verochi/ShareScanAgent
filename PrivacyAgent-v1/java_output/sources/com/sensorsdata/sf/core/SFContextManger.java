package com.sensorsdata.sf.core;

/* loaded from: classes19.dex */
public class SFContextManger {
    public static final long LOCAL_PLAN_OUT_TIME = 2592000000L;
    static final java.lang.Object LOCK_OBJECT = new java.lang.Object();
    private static final java.lang.String TAG = "SFContextManger";
    static final java.lang.String THREAD_TASK_TRIGGER_QUEUE = "sensors_focus_trigger_queue";
    private static com.sensorsdata.sf.core.SFContextManger mInstance;
    private com.sensorsdata.sf.core.AppStateManager mAppStateManager;
    private android.content.Context mContext;
    private com.sensorsdata.sf.core.data.IDataOperate mDbOperate;
    private volatile java.lang.String mDistinctId;
    private volatile com.sensorsdata.sf.core.entity.GlobalData mGlobalData;
    private com.sensorsdata.sf.core.GlobalDataLoadThread mGlobalDataLoadThread;
    private com.sensorsdata.sf.ui.listener.PopupListener mInternalWindowListener;
    private boolean mIsEncrypt = false;
    private final java.util.concurrent.atomic.AtomicBoolean mIsGlobalDateThreadStart = new java.util.concurrent.atomic.AtomicBoolean(false);
    private com.sensorsdata.sf.core.SFConfigOptions mSFConfigOptions;
    private com.sensorsdata.sf.core.thread.SFPlanTriggerRunnable mSFPlanTriggerRunnable;

    /* renamed from: com.sensorsdata.sf.core.SFContextManger$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.sf.core.GlobalDataLoadThread.CallBack {
        public AnonymousClass1() {
        }

        @Override // com.sensorsdata.sf.core.GlobalDataLoadThread.CallBack
        public void loadSuccess(org.json.JSONObject jSONObject, com.sensorsdata.sf.core.entity.GlobalData globalData) {
            com.sensorsdata.sf.core.SFContextManger.this.mGlobalData = globalData;
            com.sensorsdata.sf.core.SFContextManger.this.mAppStateManager.addAppStateChangedListener(com.sensorsdata.sf.core.SFContextManger.this.mGlobalData);
            try {
                if (!com.sensorsdata.sf.core.SFContextManger.this.getSFConfigOptions().isPreloadImage()) {
                    com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "disable preloadImage");
                    return;
                }
                java.util.List<com.sensorsdata.sf.core.entity.PopupPlan> list = globalData.popupPlans;
                if (list == null) {
                    com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "popupPlans is null");
                    return;
                }
                java.util.HashSet hashSet = new java.util.HashSet();
                for (com.sensorsdata.sf.core.entity.PopupPlan popupPlan : list) {
                    try {
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    }
                    if (popupPlan.isAudience && popupPlan.isActive()) {
                        if (android.text.TextUtils.isEmpty(popupPlan.strategyId)) {
                            if (popupPlan.isControlGroup) {
                                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "isControlGroup is true,PopupPlan id:" + popupPlan.planId);
                            }
                        } else if (!popupPlan.isTrigger) {
                            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "isTrigger is false,PopupPlan id:" + popupPlan.planId);
                        }
                        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(?<=(\"image\":\")|(\"backgroundImage\":\")).*?(?=(\"))").matcher(popupPlan.popupWindowContent.optString("content"));
                        while (matcher.find()) {
                            hashSet.add(matcher.group(0));
                        }
                    }
                    com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "Plan is not active or not audience,PopupPlan id:" + popupPlan.planId);
                }
                java.util.Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    com.sensorsdata.sf.ui.utils.ImageLoader.getInstance().preLoadBitmap((java.lang.String) it.next());
                }
            } catch (java.lang.Exception e2) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e2);
            }
        }
    }

    /* renamed from: com.sensorsdata.sf.core.SFContextManger$2, reason: invalid class name */
    public class AnonymousClass2 implements com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener {

        /* renamed from: com.sensorsdata.sf.core.SFContextManger$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ org.json.JSONObject val$args;

            /* renamed from: com.sensorsdata.sf.core.SFContextManger$2$1$1, reason: invalid class name and collision with other inner class name */
            public class C04471 implements java.util.Comparator<com.sensorsdata.sf.core.entity.PopupPlan> {
                public C04471() {
                }

                @Override // java.util.Comparator
                public int compare(com.sensorsdata.sf.core.entity.PopupPlan popupPlan, com.sensorsdata.sf.core.entity.PopupPlan popupPlan2) {
                    int i = popupPlan2.absolutePriority - popupPlan.absolutePriority;
                    if (i == 0) {
                        long j = popupPlan2.planId - popupPlan.planId;
                        if (j != 0) {
                            return j > 0 ? 1 : -1;
                        }
                    }
                    return i;
                }
            }

            public AnonymousClass1(org.json.JSONObject jSONObject) {
                this.val$args = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                org.json.JSONObject jSONObject = this.val$args;
                if (jSONObject == null) {
                    return;
                }
                try {
                    org.json.JSONObject optJSONObject = jSONObject.optJSONObject("eventJSON");
                    if (com.sensorsdata.sf.core.SFContextManger.this.mGlobalData != null && optJSONObject != null) {
                        if (android.text.TextUtils.equals(optJSONObject.getString("type"), "track")) {
                            synchronized (com.sensorsdata.sf.core.SFContextManger.LOCK_OBJECT) {
                                java.lang.String string = optJSONObject.getString("event");
                                if (!com.sensorsdata.sf.core.SFContextManger.this.mGlobalData.eventPopupPlans.containsKey(string)) {
                                    com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "Plan json not contains " + string);
                                    return;
                                }
                                java.util.List<com.sensorsdata.sf.core.entity.PopupPlan> list = com.sensorsdata.sf.core.SFContextManger.this.mGlobalData.eventPopupPlans.get(string);
                                if (list == null) {
                                    return;
                                }
                                java.util.Collections.sort(list, new com.sensorsdata.sf.core.SFContextManger.AnonymousClass2.AnonymousClass1.C04471());
                                com.sensorsdata.sf.core.PlanManager.TriggerPopupPlans(com.sensorsdata.sf.core.SFContextManger.this.mGlobalData, com.sensorsdata.sf.core.SFContextManger.this.mContext, list, optJSONObject, com.sensorsdata.sf.core.SFContextManger.this.mAppStateManager);
                                return;
                            }
                        }
                        return;
                    }
                    com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "GlobalData is null");
                } catch (java.lang.Exception e) {
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener
        public void call(java.lang.String str, org.json.JSONObject jSONObject) {
            if (com.sensorsdata.sf.core.SFContextManger.this.mGlobalDataLoadThread == null) {
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "mGlobalDataLoadThread is null");
                return;
            }
            if ("enableDataCollect".equals(str)) {
                com.sensorsdata.sf.core.SFContextManger.this.mGlobalDataLoadThread.enableDataCollect();
            } else {
                if ("login".equals(str)) {
                    com.sensorsdata.sf.core.SFContextManger.this.mGlobalDataLoadThread.onDistinctIdChange(jSONObject != null ? jSONObject.optString("distinctId") : null);
                } else if (com.baidu.mobads.sdk.internal.ax.b.equals(str)) {
                    com.sensorsdata.sf.core.SFContextManger.this.mGlobalDataLoadThread.onDistinctIdChange(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getDistinctId());
                } else if ("identify".equals(str) || "resetAnonymousId".equals(str)) {
                    if (android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getLoginId())) {
                        com.sensorsdata.sf.core.SFContextManger.this.mGlobalDataLoadThread.onDistinctIdChange(jSONObject != null ? jSONObject.optString("distinctId") : null);
                    }
                } else if ("trackEvent".equals(str)) {
                    try {
                        com.sensorsdata.sf.ui.track.SFTrackHelper.sDisplayEventTime = new java.util.Date();
                        com.sensorsdata.sf.core.thread.SFPlanTaskManager.getInstance().addTriggerTask(new com.sensorsdata.sf.core.SFContextManger.AnonymousClass2.AnonymousClass1(jSONObject));
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    }
                }
            }
            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.SFContextManger.TAG, "SAFunction is called,function name:" + str);
        }
    }

    private SFContextManger() {
    }

    public static com.sensorsdata.sf.core.SFContextManger getInstance() {
        synchronized (com.sensorsdata.sf.core.SFContextManger.class) {
            if (mInstance == null) {
                mInstance = new com.sensorsdata.sf.core.SFContextManger();
            }
        }
        return mInstance;
    }

    public void delayExecution(android.app.Activity activity) {
        com.sensorsdata.sf.core.AppStateManager appStateManager = this.mAppStateManager;
        if (appStateManager != null) {
            appStateManager.onActivityCreated(activity, null);
            this.mAppStateManager.onActivityStarted(activity);
        }
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "SF SDK delay init success");
    }

    public void enablePopup() {
        if (getSFConfigOptions().isEnablePopup()) {
            return;
        }
        getSFConfigOptions().enablePopup(true);
        this.mGlobalDataLoadThread.sendStartTriggerThreadMsg();
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "postStartTriggerTask");
    }

    public com.sensorsdata.sf.core.AppStateManager getAppStateManager() {
        return this.mAppStateManager;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    public com.sensorsdata.sf.core.data.IDataOperate getDataOperate() {
        return this.mDbOperate;
    }

    public java.lang.String getDistinctId() {
        return this.mDistinctId;
    }

    public com.sensorsdata.sf.ui.listener.PopupListener getInternalWindowListener() {
        return this.mInternalWindowListener;
    }

    public com.sensorsdata.sf.core.entity.PopupPlan getPopupPlan(long j) {
        if (this.mGlobalData == null) {
            return null;
        }
        return this.mGlobalData.getPopupPlan(j);
    }

    public com.sensorsdata.sf.core.SFConfigOptions getSFConfigOptions() {
        return this.mSFConfigOptions;
    }

    public com.sensorsdata.sf.core.thread.SFPlanTriggerRunnable getSFPlanTriggerRunnable() {
        return this.mSFPlanTriggerRunnable;
    }

    public com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener getSensorsFocusCampaignListener() {
        try {
            return this.mSFConfigOptions.getCampaignListener();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public com.sensorsdata.sf.ui.listener.PopupListener getWindowListener() {
        try {
            return this.mSFConfigOptions.getPopupListener();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public void initDbAdapter() {
        com.sensorsdata.sf.core.data.SFDbAdapterOperate sFDbAdapterOperate = com.sensorsdata.sf.core.data.SFDbAdapterOperate.getInstance();
        com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance();
        com.sensorsdata.analytics.android.sdk.SAConfigOptions configOptions = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions();
        if (configOptions == null || configOptions.getStorePlugins() == null || configOptions.getStorePlugins().size() <= 0) {
            sFDbAdapterOperate.init(this.mContext);
            this.mDbOperate = sFDbAdapterOperate;
            return;
        }
        this.mIsEncrypt = true;
        sFDbAdapterOperate.init(this.mContext);
        com.sensorsdata.sf.core.data.EncryptDataOperate encryptDataOperate = new com.sensorsdata.sf.core.data.EncryptDataOperate();
        encryptDataOperate.next(sFDbAdapterOperate);
        this.mDbOperate = encryptDataOperate;
    }

    public boolean isEncrypt() {
        return this.mIsEncrypt;
    }

    public java.util.concurrent.atomic.AtomicBoolean isGlobalDateThreadStart() {
        return this.mIsGlobalDateThreadStart;
    }

    public void loadConfig() {
        com.sensorsdata.sf.core.GlobalDataLoadThread globalDataLoadThread = new com.sensorsdata.sf.core.GlobalDataLoadThread("sensors_focus_popup_plans", this.mContext);
        this.mGlobalDataLoadThread = globalDataLoadThread;
        globalDataLoadThread.addCallBack(new com.sensorsdata.sf.core.SFContextManger.AnonymousClass1());
        setEventDistinct(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getDistinctId());
        this.mIsGlobalDateThreadStart.set(true);
        this.mGlobalDataLoadThread.start();
        this.mGlobalDataLoadThread.migrationDate();
        com.sensorsdata.sf.core.AppStateManager appStateManager = this.mAppStateManager;
        if (appStateManager != null) {
            appStateManager.addAppStateChangedListener(this.mGlobalDataLoadThread);
        }
    }

    public void registerActivityLifecycleCallbacks() {
        android.content.Context context = this.mContext;
        if (context instanceof android.app.Application) {
            com.sensorsdata.sf.core.AppStateManager appStateManager = new com.sensorsdata.sf.core.AppStateManager(context);
            this.mAppStateManager = appStateManager;
            ((android.app.Application) context).registerActivityLifecycleCallbacks(appStateManager);
        }
    }

    public void setContext(android.content.Context context) {
        this.mContext = context;
    }

    public void setEventDistinct(java.lang.String str) {
        this.mDistinctId = str;
    }

    public void setInternalWindowListener(com.sensorsdata.sf.ui.listener.PopupListener popupListener) {
        this.mInternalWindowListener = popupListener;
    }

    public void setSAListener() {
        com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().addFunctionListener(new com.sensorsdata.sf.core.SFContextManger.AnonymousClass2());
    }

    public void setSFConfigOptions(com.sensorsdata.sf.core.SFConfigOptions sFConfigOptions) {
        this.mSFConfigOptions = sFConfigOptions;
    }

    public void setSFPlanTriggerRunnable(com.sensorsdata.sf.core.thread.SFPlanTriggerRunnable sFPlanTriggerRunnable) {
        this.mSFPlanTriggerRunnable = sFPlanTriggerRunnable;
    }

    public void startTriggerThread() {
        if (!this.mSFConfigOptions.isEnablePopup()) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "disable popup");
            return;
        }
        if (this.mGlobalData == null) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "mGlobalData is null");
        } else if (getSFPlanTriggerRunnable() == null || getSFPlanTriggerRunnable().isStopped()) {
            setSFPlanTriggerRunnable(new com.sensorsdata.sf.core.thread.SFPlanTriggerRunnable());
            new java.lang.Thread(getSFPlanTriggerRunnable(), THREAD_TASK_TRIGGER_QUEUE).start();
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Start SFPlanTriggerTask");
        }
    }
}
