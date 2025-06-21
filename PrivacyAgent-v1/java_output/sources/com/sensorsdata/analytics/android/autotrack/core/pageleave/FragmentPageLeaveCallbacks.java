package com.sensorsdata.analytics.android.autotrack.core.pageleave;

/* loaded from: classes19.dex */
public class FragmentPageLeaveCallbacks implements com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks, com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener {
    private static final java.lang.String START_TIME = "sa_start_time";
    private java.util.List<java.lang.Class<?>> mIgnoreList;
    private final boolean mIsEmpty;
    private final java.util.HashMap<java.lang.Integer, org.json.JSONObject> mResumedFragments = new java.util.HashMap<>();

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$hashCode;
        final /* synthetic */ org.json.JSONObject val$pageInfo;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass1(java.lang.String str, org.json.JSONObject jSONObject, int i) {
            this.val$url = str;
            this.val$pageInfo = jSONObject;
            this.val$hashCode = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks.START_TIME, android.os.SystemClock.elapsedRealtime());
                jSONObject.put("$url", this.val$url);
                if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN) || !com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isTrackFragmentAppViewScreenEnabled()) {
                    com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.setCurrentScreenUrl(this.val$url);
                }
                java.lang.String referrer = com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getReferrer();
                if (!android.text.TextUtils.isEmpty(referrer)) {
                    jSONObject.put("$referrer", referrer);
                }
                jSONObject.put("$referrer_title", com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getReferrerTitle());
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(this.val$pageInfo, jSONObject);
                com.sensorsdata.analytics.android.sdk.SALog.i("SA.FragmentPageLeave", "trackFragmentStart = " + jSONObject);
                com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks.this.mResumedFragments.put(java.lang.Integer.valueOf(this.val$hashCode), jSONObject);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$properties;

        public AnonymousClass2(org.json.JSONObject jSONObject) {
            this.val$properties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$AppPageLeave").setProperties(this.val$properties).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
        }
    }

    public FragmentPageLeaveCallbacks(java.util.List<java.lang.Class<?>> list) {
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

    private void trackAppPageLeave(java.lang.Object obj) {
        try {
            int hashCode = obj.hashCode();
            if (this.mResumedFragments.containsKey(java.lang.Integer.valueOf(hashCode))) {
                org.json.JSONObject jSONObject = this.mResumedFragments.get(java.lang.Integer.valueOf(hashCode));
                this.mResumedFragments.remove(java.lang.Integer.valueOf(hashCode));
                trackPageLeaveEvent(jSONObject);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void trackFragmentStart(java.lang.Object obj) {
        try {
            java.lang.String screenUrl = com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getScreenUrl(obj);
            int hashCode = obj.hashCode();
            com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().postDelayed(new com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks.AnonymousClass1(screenUrl, com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getFragmentPageInfo(null, obj), hashCode), 300L);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void trackPageLeaveEvent(org.json.JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(START_TIME);
            jSONObject.remove(START_TIME);
            java.lang.Float duration = com.sensorsdata.analytics.android.sdk.util.TimeUtils.duration(optLong, android.os.SystemClock.elapsedRealtime());
            if (duration.floatValue() < 0.05d) {
                return;
            }
            jSONObject.put("event_duration", duration);
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks.AnonymousClass2(jSONObject));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onCreate(java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onHiddenChanged(java.lang.Object obj, boolean z) {
        if (ignorePage(obj)) {
            return;
        }
        if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        } else {
            trackAppPageLeave(obj);
        }
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onPause(java.lang.Object obj) {
        try {
            if (this.mResumedFragments.containsKey(java.lang.Integer.valueOf(obj.hashCode()))) {
                trackAppPageLeave(obj);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onResume(java.lang.Object obj) {
        if (ignorePage(obj) || !com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragmentVisible(obj)) {
            return;
        }
        trackFragmentStart(obj);
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onStart(java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onStop(java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onViewCreated(java.lang.Object obj, android.view.View view, android.os.Bundle bundle) {
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void setUserVisibleHint(java.lang.Object obj, boolean z) {
        if (ignorePage(obj)) {
            return;
        }
        if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        } else {
            trackAppPageLeave(obj);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        try {
            java.util.Iterator<java.lang.Integer> it = this.mResumedFragments.keySet().iterator();
            while (it.hasNext()) {
                org.json.JSONObject jSONObject = this.mResumedFragments.get(java.lang.Integer.valueOf(it.next().intValue()));
                if (jSONObject != null) {
                    trackPageLeaveEvent(jSONObject);
                    it.remove();
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
