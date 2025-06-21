package com.umeng.analytics.vshelper;

/* loaded from: classes19.dex */
public class PageNameMonitor implements com.umeng.analytics.vshelper.a {
    private static java.lang.String currentActivity;
    private static java.lang.String currentCustomPage;
    private static java.lang.Object lock = new java.lang.Object();

    public static class a {
        private static final com.umeng.analytics.vshelper.PageNameMonitor a = new com.umeng.analytics.vshelper.PageNameMonitor(null);

        private a() {
        }
    }

    private PageNameMonitor() {
    }

    public /* synthetic */ PageNameMonitor(com.umeng.analytics.vshelper.PageNameMonitor.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.vshelper.PageNameMonitor getInstance() {
        return com.umeng.analytics.vshelper.PageNameMonitor.a.a;
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityPause(java.lang.String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityResume(java.lang.String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageBegin(java.lang.String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageEnd(java.lang.String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public java.lang.String getCurrenPageName() {
        synchronized (lock) {
            java.lang.String str = currentCustomPage;
            if (str != null) {
                return str;
            }
            java.lang.String str2 = currentActivity;
            if (str2 != null) {
                return str2;
            }
            return null;
        }
    }

    public java.lang.String getCurrentActivityName() {
        java.lang.String str;
        synchronized (lock) {
            str = currentActivity;
        }
        return str;
    }
}
