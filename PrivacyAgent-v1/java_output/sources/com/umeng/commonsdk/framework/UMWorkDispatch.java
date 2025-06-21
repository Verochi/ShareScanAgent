package com.umeng.commonsdk.framework;

/* loaded from: classes19.dex */
public class UMWorkDispatch {
    public static final java.lang.String GENERAL_CONTENT = "content";
    public static final java.lang.String GENERAL_HEADER = "header";
    public static final java.lang.String KEY_EXCEPTION = "exception";
    private static final int MSG_AUTO_PROCESS = 769;
    private static final int MSG_CHECKER_TIMER = 771;
    private static final int MSG_DELAY_PROCESS = 770;
    private static final int MSG_QUIT = 784;
    private static final int MSG_SEND_EVENT = 768;
    private static android.os.HandlerThread mNetTask;
    private static com.umeng.commonsdk.framework.a mSender;
    private static java.lang.Object mSenderInitLock = new java.lang.Object();
    private static android.os.Handler mTaskHandler;

    /* renamed from: com.umeng.commonsdk.framework.UMWorkDispatch$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 768) {
                com.umeng.commonsdk.framework.UMWorkDispatch.handleEvent(message);
                return;
            }
            if (i == com.umeng.commonsdk.framework.UMWorkDispatch.MSG_QUIT) {
                com.umeng.commonsdk.framework.UMWorkDispatch.handleQuit();
            } else if (i == 770) {
                com.umeng.commonsdk.framework.UMWorkDispatch.delayProcess();
            } else {
                if (i != 771) {
                    return;
                }
                com.umeng.commonsdk.framework.UMWorkDispatch.handleEvent(message);
            }
        }
    }

    private UMWorkDispatch() {
    }

    public static void Quit() {
        android.os.Handler handler = mTaskHandler;
        if (handler != null) {
            android.os.Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = MSG_QUIT;
            mTaskHandler.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void delayProcess() {
        org.json.JSONObject jSONObject;
        org.json.JSONObject buildEnvelopeWithExtHeader;
        com.umeng.commonsdk.statistics.common.ULog.d("--->>> delayProcess Enter...");
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> delayProcess Enter...");
        android.content.Context appContext = com.umeng.commonsdk.framework.UMModuleRegister.getAppContext();
        if (appContext == null || !com.umeng.commonsdk.framework.UMFrUtils.isOnline(appContext)) {
            return;
        }
        long maxDataSpace = com.umeng.commonsdk.framework.UMEnvelopeBuild.maxDataSpace(appContext);
        com.umeng.commonsdk.framework.UMLogDataProtocol callbackFromModuleName = com.umeng.commonsdk.framework.UMModuleRegister.getCallbackFromModuleName("analytics");
        if (callbackFromModuleName != null) {
            try {
                jSONObject = callbackFromModuleName.setupReportData(maxDataSpace);
                if (jSONObject == null) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> analyticsCB.setupReportData() return null");
                    return;
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(appContext, th);
                return;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        org.json.JSONObject jSONObject2 = (org.json.JSONObject) jSONObject.opt("header");
        org.json.JSONObject jSONObject3 = (org.json.JSONObject) jSONObject.opt("content");
        if (jSONObject2 == null || jSONObject3 == null || (buildEnvelopeWithExtHeader = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(appContext, jSONObject2, jSONObject3)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> autoProcess: Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (java.lang.Throwable unused) {
        }
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> autoProcess: removeCacheData ... ");
        callbackFromModuleName.removeCacheData(buildEnvelopeWithExtHeader);
    }

    public static synchronized boolean eventHasExist() {
        synchronized (com.umeng.commonsdk.framework.UMWorkDispatch.class) {
            android.os.Handler handler = mTaskHandler;
            if (handler == null) {
                return false;
            }
            return handler.hasMessages(771);
        }
    }

    public static synchronized boolean eventHasExist(int i) {
        synchronized (com.umeng.commonsdk.framework.UMWorkDispatch.class) {
            android.os.Handler handler = mTaskHandler;
            if (handler == null) {
                return false;
            }
            return handler.hasMessages(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleEvent(android.os.Message message) {
        int i = message.arg1;
        java.lang.Object obj = message.obj;
        com.umeng.commonsdk.framework.UMLogDataProtocol callbackFromModuleName = com.umeng.commonsdk.framework.UMModuleRegister.getCallbackFromModuleName(com.umeng.commonsdk.framework.UMModuleRegister.eventType2ModuleName(i));
        if (callbackFromModuleName != null) {
            com.umeng.commonsdk.statistics.common.ULog.d("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x" + java.lang.Integer.toHexString(i) + "]");
            callbackFromModuleName.workEvent(obj, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleQuit() {
        if (mSender == null || mNetTask == null) {
            return;
        }
        com.umeng.commonsdk.framework.a.c();
        com.umeng.commonsdk.statistics.common.ULog.d("--->>> handleQuit: Quit dispatch thread.");
        mNetTask.quit();
        teardown();
    }

    private static synchronized void init() {
        synchronized (com.umeng.commonsdk.framework.UMWorkDispatch.class) {
            com.umeng.commonsdk.statistics.common.ULog.d("--->>> Dispatch: init Enter...");
            try {
                if (mNetTask == null) {
                    android.os.HandlerThread handlerThread = new android.os.HandlerThread("work_thread");
                    mNetTask = handlerThread;
                    handlerThread.start();
                    if (mTaskHandler == null) {
                        mTaskHandler = new com.umeng.commonsdk.framework.UMWorkDispatch.AnonymousClass1(mNetTask.getLooper());
                    }
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext(), th);
            }
            com.umeng.commonsdk.statistics.common.ULog.d("--->>> Dispatch: init Exit...");
        }
    }

    public static void registerConnStateObserver(com.umeng.commonsdk.framework.UMSenderStateNotify uMSenderStateNotify) {
        if (mSender != null) {
            com.umeng.commonsdk.framework.a.a(uMSenderStateNotify);
        }
    }

    public static synchronized void removeEvent() {
        synchronized (com.umeng.commonsdk.framework.UMWorkDispatch.class) {
            android.os.Handler handler = mTaskHandler;
            if (handler == null) {
                return;
            }
            handler.removeMessages(771);
        }
    }

    public static synchronized void removeEvent(int i) {
        synchronized (com.umeng.commonsdk.framework.UMWorkDispatch.class) {
            android.os.Handler handler = mTaskHandler;
            if (handler == null) {
                return;
            }
            handler.removeMessages(i);
        }
    }

    public static void sendDelayProcessMsg(long j) {
        android.os.Handler handler = mTaskHandler;
        if (handler != null) {
            if (handler.hasMessages(770)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
                return;
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS not exist. send it.");
            android.os.Message obtainMessage = mTaskHandler.obtainMessage();
            obtainMessage.what = 770;
            mTaskHandler.sendMessageDelayed(obtainMessage, j);
        }
    }

    public static void sendEvent(android.content.Context context, int i, com.umeng.commonsdk.framework.UMLogDataProtocol uMLogDataProtocol, java.lang.Object obj) {
        sendEventInternal(context, 768, i, uMLogDataProtocol, obj, 0L);
    }

    public static void sendEvent(android.content.Context context, int i, com.umeng.commonsdk.framework.UMLogDataProtocol uMLogDataProtocol, java.lang.Object obj, long j) {
        sendEventInternal(context, 768, i, uMLogDataProtocol, obj, j);
    }

    public static void sendEventEx(android.content.Context context, int i, com.umeng.commonsdk.framework.UMLogDataProtocol uMLogDataProtocol, java.lang.Object obj, long j) {
        sendEventInternal(context, 771, i, uMLogDataProtocol, obj, j);
    }

    public static void sendEventInternal(android.content.Context context, int i, int i2, com.umeng.commonsdk.framework.UMLogDataProtocol uMLogDataProtocol, java.lang.Object obj, long j) {
        if (context == null || uMLogDataProtocol == null) {
            com.umeng.commonsdk.statistics.common.ULog.d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
            return;
        }
        com.umeng.commonsdk.framework.UMModuleRegister.registerAppContext(context.getApplicationContext());
        if (com.umeng.commonsdk.framework.UMModuleRegister.registerCallback(i2, uMLogDataProtocol)) {
            if (mNetTask == null || mTaskHandler == null) {
                init();
            }
            try {
                if (mTaskHandler != null) {
                    if (com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
                        synchronized (mSenderInitLock) {
                            if (mSender == null) {
                                com.umeng.commonsdk.framework.UMFrUtils.syncLegacyEnvelopeIfNeeded(context);
                                mSender = new com.umeng.commonsdk.framework.a(context, mTaskHandler);
                            }
                        }
                    }
                    android.os.Message obtainMessage = mTaskHandler.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.arg1 = i2;
                    obtainMessage.obj = obj;
                    mTaskHandler.sendMessageDelayed(obtainMessage, j);
                }
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(com.umeng.commonsdk.framework.UMModuleRegister.getAppContext(), th);
            }
        }
    }

    private static void teardown() {
        if (mNetTask != null) {
            mNetTask = null;
        }
        if (mTaskHandler != null) {
            mTaskHandler = null;
        }
        if (mSender != null) {
            mSender = null;
        }
    }
}
