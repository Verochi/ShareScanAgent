package com.huawei.hms.framework.common.hianalytics;

/* loaded from: classes22.dex */
public class InitReport {
    private static final int EVENT_LIMIT = 10;
    private static final java.lang.String TAG = "HaReport";
    private static java.util.List<java.lang.Runnable> eventsToReport = new java.util.concurrent.CopyOnWriteArrayList();
    private static boolean hasConnectNet;

    /* renamed from: com.huawei.hms.framework.common.hianalytics.InitReport$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.framework.common.hianalytics.InitReport.submitAllEvents();
        }
    }

    public static void enableConnectNet() {
        hasConnectNet = true;
        try {
            com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance().getReportExecutor().submit(new com.huawei.hms.framework.common.hianalytics.InitReport.AnonymousClass1());
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            com.huawei.hms.framework.common.Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        } catch (java.lang.Throwable unused2) {
            com.huawei.hms.framework.common.Logger.e(TAG, "the thread submit has fatal error!");
        }
    }

    public static void reportWhenInit(java.lang.Runnable runnable) {
        if (!hasConnectNet) {
            if (eventsToReport.size() > 10) {
                com.huawei.hms.framework.common.Logger.e("TAG", "the event to be report when init exceed the limit!");
                return;
            } else {
                eventsToReport.add(runnable);
                return;
            }
        }
        try {
            com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance().getReportExecutor().execute(runnable);
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            com.huawei.hms.framework.common.Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        } catch (java.lang.Throwable unused2) {
            com.huawei.hms.framework.common.Logger.e(TAG, "the thread submit has fatal error!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void submitAllEvents() {
        try {
            java.util.Iterator<java.lang.Runnable> it = eventsToReport.iterator();
            while (it.hasNext()) {
                com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance().getReportExecutor().submit(it.next());
            }
            eventsToReport.clear();
        } catch (java.lang.NullPointerException unused) {
            com.huawei.hms.framework.common.Logger.e(TAG, "event is null occured");
        } catch (java.util.concurrent.RejectedExecutionException unused2) {
            com.huawei.hms.framework.common.Logger.e(TAG, "submit failed of rejected execution exception");
        } catch (java.lang.Exception unused3) {
            com.huawei.hms.framework.common.Logger.e(TAG, "submit failed because of some exception");
        }
    }
}
