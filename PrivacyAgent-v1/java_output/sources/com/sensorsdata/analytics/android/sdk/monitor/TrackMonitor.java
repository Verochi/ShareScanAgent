package com.sensorsdata.analytics.android.sdk.monitor;

/* loaded from: classes19.dex */
public class TrackMonitor {
    private org.json.JSONObject cacheData;
    private java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener> mFunctionListener;

    /* renamed from: com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.this.cacheData = null;
        }
    }

    public static class SingletonHolder {
        private static final com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor INSTANCE = new com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor(null);

        private SingletonHolder() {
        }
    }

    private TrackMonitor() {
    }

    public /* synthetic */ TrackMonitor(com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.AnonymousClass1 anonymousClass1) {
        this();
    }

    private void call(java.lang.String str, org.json.JSONObject jSONObject) {
        java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener> list;
        if (android.text.TextUtils.isEmpty(str) || (list = this.mFunctionListener) == null) {
            return;
        }
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().call(str, jSONObject);
        }
    }

    public static com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor getInstance() {
        return com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.SingletonHolder.INSTANCE;
    }

    public void addFunctionListener(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
        try {
            if (this.mFunctionListener == null) {
                this.mFunctionListener = new java.util.ArrayList();
            }
            if (sAFunctionListener != null && !this.mFunctionListener.contains(sAFunctionListener)) {
                this.mFunctionListener.add(sAFunctionListener);
            }
            org.json.JSONObject jSONObject = this.cacheData;
            if (jSONObject != null) {
                call("trackEvent", jSONObject);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void callEnableDataCollect() {
        call("enableDataCollect", null);
    }

    public void callIdentify(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("distinctId", str);
            call("identify", jSONObject);
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void callLogin(java.lang.String str) {
        if (this.mFunctionListener == null) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("distinctId", str);
            call("login", jSONObject);
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void callLogout() {
        call(com.baidu.mobads.sdk.internal.ax.b, null);
    }

    public void callResetAnonymousId(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("distinctId", str);
            call("resetAnonymousId", jSONObject);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void callSetServerUrl() {
        call("setServerUrl", null);
    }

    public void callTrack(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.put("eventJSON", jSONObject);
            if (!"$AppStart".equals(jSONObject.optString("event")) || this.mFunctionListener != null) {
                call("trackEvent", jSONObject2);
            } else {
                this.cacheData = jSONObject2;
                new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.AnonymousClass1(), 2000L);
            }
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void removeFunctionListener(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
        java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener> list = this.mFunctionListener;
        if (list == null || sAFunctionListener == null) {
            return;
        }
        list.remove(sAFunctionListener);
    }
}
