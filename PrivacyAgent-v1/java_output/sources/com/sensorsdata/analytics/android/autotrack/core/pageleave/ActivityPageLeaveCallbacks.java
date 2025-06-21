package com.sensorsdata.analytics.android.autotrack.core.pageleave;

/* loaded from: classes19.dex */
public class ActivityPageLeaveCallbacks implements com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks, com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener {
    private static final java.lang.String START_TIME = "sa_start_time";
    private java.util.List<java.lang.Class<?>> mIgnoreList;
    private final boolean mIsEmpty;
    private final java.util.HashMap<java.lang.Integer, org.json.JSONObject> mResumedActivities = new java.util.HashMap<>();
    private final java.lang.String DIALOG_ACTIVITY = "com.sensorsdata.sf.ui.view.DialogActivity";

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.pageleave.ActivityPageLeaveCallbacks$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$properties;

        public AnonymousClass1(org.json.JSONObject jSONObject) {
            this.val$properties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppPageLeave").setProperties(this.val$properties).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
        }
    }

    public ActivityPageLeaveCallbacks(java.util.List<java.lang.Class<?>> list) {
        if (list == null || list.isEmpty()) {
            this.mIsEmpty = true;
        } else {
            this.mIgnoreList = list;
            this.mIsEmpty = false;
        }
    }

    private boolean ignorePage(java.lang.Object obj) {
        if (this.mIsEmpty) {
            return false;
        }
        return this.mIgnoreList.contains(obj.getClass());
    }

    private void trackActivityStart(android.app.Activity activity) {
        try {
            if ("com.sensorsdata.sf.ui.view.DialogActivity".equals(activity.getClass().getCanonicalName())) {
                return;
            }
            org.json.JSONObject activityPageInfo = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(activity);
            java.lang.String screenUrl = com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getScreenUrl(activity);
            activityPageInfo.put("$url", screenUrl);
            if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
                com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.setCurrentScreenUrl(screenUrl);
            }
            java.lang.String referrer = com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getReferrer();
            if (!activityPageInfo.has("$referrer") && !android.text.TextUtils.isEmpty(referrer)) {
                activityPageInfo.put("$referrer", referrer);
            }
            activityPageInfo.put(START_TIME, android.os.SystemClock.elapsedRealtime());
            this.mResumedActivities.put(java.lang.Integer.valueOf(activity.hashCode()), activityPageInfo);
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void trackAppPageLeave(org.json.JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(START_TIME);
            jSONObject.remove(START_TIME);
            java.lang.Float duration = com.sensorsdata.analytics.android.sdk.util.TimeUtils.duration(optLong, android.os.SystemClock.elapsedRealtime());
            if (duration.floatValue() < 0.05d) {
                return;
            }
            jSONObject.put("event_duration", duration);
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.pageleave.ActivityPageLeaveCallbacks.AnonymousClass1(jSONObject));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        try {
            int hashCode = activity.hashCode();
            if (this.mResumedActivities.containsKey(java.lang.Integer.valueOf(hashCode))) {
                org.json.JSONObject jSONObject = this.mResumedActivities.get(java.lang.Integer.valueOf(hashCode));
                java.lang.String optString = jSONObject == null ? "" : jSONObject.optString("$referrer");
                long optLong = jSONObject == null ? 0L : jSONObject.optLong(START_TIME);
                org.json.JSONObject activityPageInfo = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(activity);
                activityPageInfo.put(START_TIME, optLong);
                activityPageInfo.put("$url", com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getScreenUrl(activity));
                if (!android.text.TextUtils.isEmpty(optString)) {
                    activityPageInfo.put("$referrer", optString);
                }
                trackAppPageLeave(activityPageInfo);
                this.mResumedActivities.remove(java.lang.Integer.valueOf(hashCode));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        if (ignorePage(activity)) {
            return;
        }
        trackActivityStart(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks
    public void onNewIntent(android.content.Intent intent) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        try {
            java.util.Iterator<java.lang.Integer> it = this.mResumedActivities.keySet().iterator();
            while (it.hasNext()) {
                org.json.JSONObject jSONObject = this.mResumedActivities.get(java.lang.Integer.valueOf(it.next().intValue()));
                if (jSONObject != null) {
                    trackAppPageLeave(jSONObject);
                    it.remove();
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
