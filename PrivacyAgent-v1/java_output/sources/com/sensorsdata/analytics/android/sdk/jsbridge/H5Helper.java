package com.sensorsdata.analytics.android.sdk.jsbridge;

/* loaded from: classes19.dex */
public class H5Helper {
    private static java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.analytics.android.sdk.listener.SAJSListener> mSAJSListeners;

    /* renamed from: com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$eventInfo;

        public AnonymousClass1(java.lang.String str) {
            this.val$eventInfo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setExtras(this.val$eventInfo));
        }
    }

    public static void addJavascriptInterface(android.view.View view, java.lang.Object obj, java.lang.String str) {
        try {
            java.lang.Class<?> cls = view.getClass();
            try {
                java.lang.Object invoke = cls.getMethod("getSettings", new java.lang.Class[0]).invoke(view, new java.lang.Object[0]);
                if (invoke != null) {
                    invoke.getClass().getMethod("setJavaScriptEnabled", java.lang.Boolean.TYPE).invoke(invoke, java.lang.Boolean.TRUE);
                }
            } catch (java.lang.Exception unused) {
            }
            cls.getMethod("addJavascriptInterface", java.lang.Object.class, java.lang.String.class).invoke(view, obj, str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void addSAJSListener(com.sensorsdata.analytics.android.sdk.listener.SAJSListener sAJSListener) {
        try {
            if (mSAJSListeners == null) {
                mSAJSListeners = new java.util.concurrent.CopyOnWriteArrayList<>();
            }
            if (mSAJSListeners.contains(sAJSListener)) {
                return;
            }
            mSAJSListeners.add(sAJSListener);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void handleJsMessage(java.lang.ref.WeakReference<android.view.View> weakReference, java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.analytics.android.sdk.listener.SAJSListener> copyOnWriteArrayList = mSAJSListeners;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAJSListener> it = mSAJSListeners.iterator();
        while (it.hasNext()) {
            com.sensorsdata.analytics.android.sdk.listener.SAJSListener next = it.next();
            if (next != null) {
                try {
                    next.onReceiveJSMessage(weakReference, str);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void removeSAJSListener(com.sensorsdata.analytics.android.sdk.listener.SAJSListener sAJSListener) {
        try {
            java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.analytics.android.sdk.listener.SAJSListener> copyOnWriteArrayList = mSAJSListeners;
            if (copyOnWriteArrayList == null || !copyOnWriteArrayList.contains(sAJSListener)) {
                return;
            }
            mSAJSListeners.remove(sAJSListener);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private static void trackEvent(java.lang.String str) {
        if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance() instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.AppWebViewInterface", "trackEvent SensorsDataAPIEmptyImplementation");
        } else {
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper.AnonymousClass1(str));
        }
    }

    public static void trackEventFromH5(java.lang.String str, boolean z) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.AppWebViewInterface", "trackEventFromH5 h5 enableVerify = " + z);
            if (z) {
                java.lang.String optString = jSONObject.optString("server_url");
                com.sensorsdata.analytics.android.sdk.SALog.i("SA.AppWebViewInterface", "trackEventFromH5 h5 serverUrl = " + optString);
                if (android.text.TextUtils.isEmpty(optString) || !new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(optString).check(new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getServerUrl()))) {
                    return;
                }
            }
            trackEvent(str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static boolean verifyEventFromH5(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.AppWebViewInterface", "verifyEventFromH5 h5 eventInfo = " + str);
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            java.lang.String optString = new org.json.JSONObject(str).optString("server_url");
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.AppWebViewInterface", "verifyEventFromH5 h5 serverUrl = " + optString);
            if (android.text.TextUtils.isEmpty(optString) || !new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(optString).check(new com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl(com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getServerUrl()))) {
                return false;
            }
            trackEvent(str);
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return false;
    }
}
