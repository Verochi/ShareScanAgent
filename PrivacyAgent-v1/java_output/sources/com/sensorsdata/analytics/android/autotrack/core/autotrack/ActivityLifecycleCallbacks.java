package com.sensorsdata.analytics.android.autotrack.core.autotrack;

/* loaded from: classes19.dex */
public class ActivityLifecycleCallbacks implements com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks, com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener {
    private static final java.lang.String EVENT_DURATION = "event_duration";
    private static final java.lang.String EVENT_TIME = "event_time";
    private static final java.lang.String TAG = "SA.ActivityLifecycleCallbacks";
    private static final int TIME_INTERVAL = 2000;
    private final com.sensorsdata.analytics.android.sdk.core.SAContextManager mContextManager;
    private android.os.Handler mHandler;
    private final com.sensorsdata.analytics.android.sdk.SensorsDataAPI mSensorsDataInstance;
    private int mStartActivityCount;
    private long mStartTime;
    private int mStartTimerCount;
    private boolean resumeFromBackground = false;
    private org.json.JSONObject activityProperty = new org.json.JSONObject();
    private final org.json.JSONObject endDataProperty = new org.json.JSONObject();
    private org.json.JSONObject mDeepLinkProperty = new org.json.JSONObject();
    private final java.lang.String APP_START_TIME = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME;
    private final java.lang.String APP_END_DATA = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.APP_END_DATA;
    private final java.lang.String APP_RESET_STATE = "app_reset_state";
    private final java.lang.String TIME = "time";
    private final java.lang.String ELAPSE_TIME = "elapse_time";
    private long messageReceiveTime = 0;
    private final int MESSAGE_CODE_APP_END = 0;
    private final int MESSAGE_CODE_START = 100;
    private final int MESSAGE_CODE_START_DELAY = 101;
    private final int MESSAGE_CODE_STOP = 200;
    private final int MESSAGE_CODE_TIMER = 300;
    private final java.util.Set<java.lang.Integer> hashSet = new java.util.HashSet();
    private final com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter mDbAdapter = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance();

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks$1, reason: invalid class name */
    public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription<org.json.JSONObject> {
        public AnonymousClass1() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription
        public void notify(org.json.JSONObject jSONObject) {
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_REMOVE_DEEPLINK_INFO, com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.endDataProperty);
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.endDataProperty);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.Handler {
        public AnonymousClass2(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i != 0) {
                if (i == 200) {
                    com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.handleStoppedMessage(message);
                    return;
                }
                if (i != 300) {
                    if (i == 100 || i == 101) {
                        com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.handleStartedMessage(message);
                        return;
                    }
                    return;
                }
                if (com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.mSensorsDataInstance.isAutoTrackEnabled() && com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.isAutoTrackAppEnd()) {
                    com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.generateAppEndData(java.lang.System.currentTimeMillis(), android.os.SystemClock.elapsedRealtime());
                }
                if (com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.mStartTimerCount <= 0 || com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.mContextManager.getInternalConfigs().saConfigOptions.isDisableAppEndTimer()) {
                    return;
                }
                com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.mHandler.sendEmptyMessageDelayed(300, 2000L);
                return;
            }
            if (com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.messageReceiveTime != 0 && android.os.SystemClock.elapsedRealtime() - com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.messageReceiveTime < com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.mSensorsDataInstance.getSessionIntervalTime()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.TAG, "$AppEnd in time");
                return;
            }
            com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.messageReceiveTime = android.os.SystemClock.elapsedRealtime();
            android.os.Bundle data = message.getData();
            java.lang.String string = data.getString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.APP_END_DATA);
            boolean z = data.getBoolean("app_reset_state");
            com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.resumeFromBackground = true;
            if (!z) {
                com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.trackAppEnd(string);
                return;
            }
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_COMMIT_REQUEST_DEFERRED_DEEPLINK, java.lang.Boolean.FALSE);
            if (com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getActivityCount() <= 0) {
                com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.trackAppEnd(string);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$properties;

        public AnonymousClass3(org.json.JSONObject jSONObject) {
            this.val$properties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.mContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppStart").setProperties(com.sensorsdata.analytics.android.sdk.util.SADataHelper.appendLibMethodAutoTrack(this.val$properties)).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$property;

        public AnonymousClass4(org.json.JSONObject jSONObject) {
            this.val$property = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.this.mContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppEnd").setProperties(com.sensorsdata.analytics.android.sdk.util.SADataHelper.appendLibMethodAutoTrack(this.val$property)).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
        }
    }

    public ActivityLifecycleCallbacks(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mSensorsDataInstance = sAContextManager.getSensorsDataAPI();
        this.mContextManager = sAContextManager;
        initHandler();
        registerAdvertObserver();
    }

    private void buildScreenProperties(android.app.Activity activity) {
        org.json.JSONObject buildTitleNoAutoTrackerProperties = com.sensorsdata.analytics.android.autotrack.utils.AopUtil.buildTitleNoAutoTrackerProperties(activity);
        this.activityProperty = buildTitleNoAutoTrackerProperties;
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(buildTitleNoAutoTrackerProperties, this.endDataProperty);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateAppEndData(long j, long j2) {
        try {
            if (this.mStartTime == 0) {
                this.mStartTime = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getAppStartTime();
            }
            this.endDataProperty.put(EVENT_DURATION, com.sensorsdata.analytics.android.sdk.util.TimeUtils.duration(this.mStartTime, j2));
            this.endDataProperty.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME, this.mStartTime);
            long j3 = j + 2000;
            this.endDataProperty.put(EVENT_TIME, j3);
            if (com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
                com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager.getInstance().refreshSessionByTimer(j3);
                org.json.JSONObject jSONObject = this.endDataProperty;
                com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager.getInstance().getClass();
                jSONObject.put("$event_session_id", com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager.getInstance().getSessionID());
            }
            this.endDataProperty.put("$app_version", com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppVersionName(this.mContextManager.getContext()));
            this.endDataProperty.put("$lib_version", com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSDKVersion());
            if (!this.endDataProperty.has("$is_first_day")) {
                this.endDataProperty.put("$is_first_day", this.mContextManager.isFirstDay(java.lang.System.currentTimeMillis()));
            }
            this.mDbAdapter.commitAppExitData(this.endDataProperty.toString());
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartedMessage(android.os.Message message) {
        try {
            int activityCount = this.mDbAdapter.getActivityCount();
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter dbAdapter = this.mDbAdapter;
            int i = activityCount + 1;
            this.mStartActivityCount = i;
            dbAdapter.commitActivityCount(i);
            if (this.mStartActivityCount == 1) {
                boolean z = false;
                if (com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isSaveDeepLinkInfo()) {
                    com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject((org.json.JSONObject) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_GET_LATEST_UTM_PROPERTIES, new java.lang.Object[0]), this.endDataProperty);
                }
                this.mHandler.removeMessages(0);
                if (isSessionTimeOut()) {
                    this.mHandler.sendMessage(obtainAppEndMessage(false));
                    boolean booleanValue = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstStartPst().get().booleanValue();
                    android.os.Bundle data = message.getData();
                    try {
                        if (this.mSensorsDataInstance.isAutoTrackEnabled() && !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_START)) {
                            z = true;
                        }
                        if (z || message.what == 101) {
                            if (booleanValue) {
                                com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstStartPst().commit(java.lang.Boolean.FALSE);
                            }
                            org.json.JSONObject jSONObject = new org.json.JSONObject();
                            jSONObject.put("$resume_from_background", this.resumeFromBackground);
                            jSONObject.put("$is_first_time", booleanValue);
                            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(this.activityProperty, jSONObject);
                            org.json.JSONObject jSONObject2 = this.mDeepLinkProperty;
                            if (jSONObject2 != null) {
                                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject2, jSONObject);
                                this.mDeepLinkProperty = null;
                            }
                            long j = data.getLong("time");
                            if (j <= 0) {
                                j = java.lang.System.currentTimeMillis();
                            }
                            jSONObject.put(EVENT_TIME, j);
                            if (message.what == 101) {
                                com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_START_DATA, jSONObject.toString());
                            } else {
                                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.AnonymousClass3(jSONObject));
                                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().flush();
                            }
                        }
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e);
                    }
                    updateStartTime(data.getLong("elapse_time"));
                    this.resumeFromBackground = true;
                }
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            updateStartTime(android.os.SystemClock.elapsedRealtime());
        }
        try {
            int i2 = this.mStartTimerCount;
            this.mStartTimerCount = i2 + 1;
            if (i2 != 0 || this.mContextManager.getInternalConfigs().saConfigOptions.isDisableAppEndTimer()) {
                return;
            }
            this.mHandler.sendEmptyMessage(300);
        } catch (java.lang.Exception e3) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStoppedMessage(android.os.Message message) {
        try {
            int i = this.mStartTimerCount - 1;
            this.mStartTimerCount = i;
            int i2 = 0;
            if (i <= 0) {
                this.mHandler.removeMessages(300);
                this.mStartTimerCount = 0;
            }
            int activityCount = this.mDbAdapter.getActivityCount();
            this.mStartActivityCount = activityCount;
            if (activityCount > 0) {
                i2 = activityCount - 1;
                this.mStartActivityCount = i2;
            }
            this.mStartActivityCount = i2;
            this.mDbAdapter.commitActivityCount(i2);
            if (this.mStartActivityCount <= 0) {
                this.mSensorsDataInstance.flush();
                android.os.Bundle data = message.getData();
                generateAppEndData(data.getLong("time"), data.getLong("elapse_time"));
                this.mHandler.sendMessageDelayed(obtainAppEndMessage(true), this.mSensorsDataInstance.getSessionIntervalTime());
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void initHandler() {
        try {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("SENSORS_DATA_THREAD");
            handlerThread.start();
            this.mHandler = new com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.AnonymousClass2(handlerThread.getLooper());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAutoTrackAppEnd() {
        return !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_END);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isSessionTimeOut() {
        long j;
        java.lang.Exception e;
        java.lang.String appExitData;
        long max = java.lang.Math.max(java.lang.System.currentTimeMillis(), 946656000000L);
        long j2 = 0;
        try {
            appExitData = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getAppExitData();
        } catch (java.lang.Exception e2) {
            j = 0;
            e = e2;
        }
        if (!android.text.TextUtils.isEmpty(appExitData)) {
            org.json.JSONObject jSONObject = new org.json.JSONObject(appExitData);
            j = jSONObject.optLong(EVENT_TIME) - 2000;
            try {
                if (this.mStartTime == 0) {
                    updateStartTime(jSONObject.optLong(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME));
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                j2 = j;
                if (java.lang.Math.abs(max - j2) <= ((long) this.mSensorsDataInstance.getSessionIntervalTime())) {
                }
            }
            j2 = j;
        }
        return java.lang.Math.abs(max - j2) <= ((long) this.mSensorsDataInstance.getSessionIntervalTime());
    }

    private android.os.Message obtainAppEndMessage(boolean z) {
        android.os.Message obtain = android.os.Message.obtain(this.mHandler);
        obtain.what = 0;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.APP_END_DATA, com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getAppExitData());
        bundle.putBoolean("app_reset_state", z);
        obtain.setData(bundle);
        return obtain;
    }

    private void registerAdvertObserver() {
        if (com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().hasModuleByName(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME)) {
            com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus.getInstance().register(com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBusConstants.Tag.DEEPLINK_LAUNCH, new com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.AnonymousClass1());
        }
    }

    private void sendActivityHandleMessage(int i) {
        android.os.Message obtainMessage = this.mHandler.obtainMessage();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("time", java.lang.System.currentTimeMillis());
        bundle.putLong("elapse_time", android.os.SystemClock.elapsedRealtime());
        obtainMessage.what = i;
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackAppEnd(java.lang.String str) {
        try {
            if (this.mSensorsDataInstance.isAutoTrackEnabled() && isAutoTrackAppEnd() && !android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (jSONObject.has("track_timer")) {
                    jSONObject.put(EVENT_TIME, jSONObject.optLong("track_timer") + 2000);
                    jSONObject.remove("event_timer");
                    jSONObject.remove("track_timer");
                }
                jSONObject.remove(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME);
                if (com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getAppStartTime() == 0) {
                    jSONObject.remove(EVENT_DURATION);
                }
                com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.AnonymousClass4(jSONObject));
                this.mDbAdapter.commitAppExitData("");
                this.mSensorsDataInstance.flush();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void updateStartTime(long j) {
        try {
            try {
                this.mStartTime = j;
                this.mDbAdapter.commitAppStartTime(j > 0 ? j : android.os.SystemClock.elapsedRealtime());
            } catch (java.lang.Exception unused) {
                com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter dbAdapter = this.mDbAdapter;
                if (j <= 0) {
                    j = android.os.SystemClock.elapsedRealtime();
                }
                dbAdapter.commitAppStartTime(j);
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    public void addActivity(android.app.Activity activity) {
        if (activity != null) {
            this.hashSet.add(java.lang.Integer.valueOf(activity.hashCode()));
        }
    }

    public boolean hasActivity(android.app.Activity activity) {
        if (activity != null) {
            return this.hashSet.contains(java.lang.Integer.valueOf(activity.hashCode()));
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        org.json.JSONObject trackProperties;
        try {
            if (com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.isSchemeActivity(activity)) {
                return;
            }
            buildScreenProperties(activity);
            if (!this.mSensorsDataInstance.isAutoTrackEnabled() || this.mSensorsDataInstance.isActivityAutoTrackAppViewScreenIgnored(activity.getClass()) || this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(this.activityProperty, jSONObject);
            if ((activity instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) && (trackProperties = ((com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) activity).getTrackProperties()) != null) {
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(trackProperties, jSONObject);
            }
            this.mSensorsDataInstance.trackViewScreen(com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getScreenUrl(activity), com.sensorsdata.analytics.android.sdk.util.SADataHelper.appendLibMethodAutoTrack(jSONObject));
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        if (com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.isSchemeActivity(activity) || hasActivity(activity)) {
            return;
        }
        if (this.mStartActivityCount == 0) {
            buildScreenProperties(activity);
        }
        sendActivityHandleMessage(100);
        addActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        if (com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.isSchemeActivity(activity) || !hasActivity(activity)) {
            return;
        }
        sendActivityHandleMessage(200);
        removeActivity(activity);
    }

    public void onDelayInitStarted(android.app.Activity activity) {
        if (com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.isSchemeActivity(activity) || hasActivity(activity)) {
            return;
        }
        if (this.mStartActivityCount == 0) {
            buildScreenProperties(activity);
        }
        sendActivityHandleMessage(101);
        addActivity(activity);
    }

    @Override // com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks
    public void onNewIntent(android.content.Intent intent) {
    }

    public void removeActivity(android.app.Activity activity) {
        if (activity != null) {
            this.hashSet.remove(java.lang.Integer.valueOf(activity.hashCode()));
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        if (android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getAppExitData())) {
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitAppStartTime(android.os.SystemClock.elapsedRealtime());
        }
        if (com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isMultiProcessFlush()) {
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitSubProcessFlushState(false);
        }
        com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitActivityCount(0);
    }
}
