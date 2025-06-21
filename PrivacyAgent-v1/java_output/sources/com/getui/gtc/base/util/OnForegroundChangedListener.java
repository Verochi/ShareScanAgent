package com.getui.gtc.base.util;

/* loaded from: classes22.dex */
public abstract class OnForegroundChangedListener implements android.app.Application.ActivityLifecycleCallbacks {
    private int resumedCounter = 0;
    private boolean isForeground = false;

    private void checkForegroundChanged() {
        try {
            if (this.isForeground && this.resumedCounter == 0) {
                this.isForeground = false;
                onForegroundChanged(false);
            }
            if (this.isForeground || this.resumedCounter <= 0) {
                return;
            }
            this.isForeground = true;
            onForegroundChanged(true);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
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
        int i = this.resumedCounter;
        if (i > 0) {
            this.resumedCounter = i - 1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        this.resumedCounter++;
        checkForegroundChanged();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        checkForegroundChanged();
    }

    public abstract void onForegroundChanged(boolean z);
}
