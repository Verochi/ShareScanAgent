package com.sensorsdata.analytics.android.sdk.exceptions;

/* loaded from: classes19.dex */
public class SensorsDataExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {
    private static final int SLEEP_TIMEOUT_MS = 400;
    private static com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler sInstance;
    private java.lang.Thread.UncaughtExceptionHandler mDefaultExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
    private static final java.util.ArrayList<com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener> sExceptionListeners = new java.util.ArrayList<>();
    private static boolean isTrackCrash = false;

    /* renamed from: com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$messageProp;

        public AnonymousClass1(org.json.JSONObject jSONObject) {
            this.val$messageProp = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("AppCrashed").setProperties(this.val$messageProp).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK));
        }
    }

    public interface SAExceptionListener {
        void uncaughtException(java.lang.Thread thread, java.lang.Throwable th);
    }

    private SensorsDataExceptionHandler() {
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void addExceptionListener(com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener sAExceptionListener) {
        if (sAExceptionListener != null) {
            java.util.ArrayList<com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener> arrayList = sExceptionListeners;
            if (arrayList.contains(sAExceptionListener)) {
                return;
            }
            arrayList.add(sAExceptionListener);
        }
    }

    public static void enableAppCrash() {
        isTrackCrash = true;
    }

    public static synchronized void init() {
        synchronized (com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.class) {
            if (sInstance == null) {
                sInstance = new com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler();
            }
        }
    }

    private void killProcessAndExit() {
        try {
            android.os.Process.killProcess(android.os.Process.myPid());
            java.lang.System.exit(10);
        } catch (java.lang.Exception unused) {
        }
    }

    public static void removeExceptionListener(com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener sAExceptionListener) {
        if (sAExceptionListener != null) {
            java.util.ArrayList<com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener> arrayList = sExceptionListeners;
            if (arrayList.contains(sAExceptionListener)) {
                arrayList.remove(sAExceptionListener);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        try {
            if (isTrackCrash) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        java.io.StringWriter stringWriter = new java.io.StringWriter();
                        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
                        th.printStackTrace(printWriter);
                        for (java.lang.Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                            cause.printStackTrace(printWriter);
                        }
                        printWriter.close();
                        jSONObject.put("app_crashed_reason", stringWriter.toString());
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                    com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance().trackQueueEvent(new com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.AnonymousClass1(jSONObject));
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().flush();
                    try {
                        java.lang.Thread.sleep(400L);
                    } catch (java.lang.InterruptedException e2) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                    }
                } catch (java.lang.Exception e3) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
                }
            }
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener> it = sExceptionListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (java.lang.Exception e4) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                }
            }
            java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                killProcessAndExit();
            }
        } catch (java.lang.Exception unused) {
        }
    }
}
