package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cm implements android.app.Application.ActivityLifecycleCallbacks {
    private java.lang.String a;
    private java.lang.String b;
    private android.content.Context c;

    public cm(android.content.Context context, java.lang.String str) {
        this.c = context;
        this.a = str;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(android.app.Activity activity) {
        java.lang.String localClassName = activity.getLocalClassName();
        if (android.text.TextUtils.isEmpty(this.a) || android.text.TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.b = "";
        if (!android.text.TextUtils.isEmpty("") && !android.text.TextUtils.equals(this.b, localClassName)) {
            this.a = "";
            return;
        }
        java.lang.String str = this.c.getPackageName() + "|" + localClassName + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.a + "," + java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000);
        com.xiaomi.push.gs gsVar = new com.xiaomi.push.gs();
        gsVar.c = str;
        gsVar.a(java.lang.System.currentTimeMillis());
        gsVar.b = com.xiaomi.push.gm.ActivityActiveTimeStamp;
        com.xiaomi.push.ct.a(this.c, gsVar);
        this.a = "";
        this.b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(android.app.Activity activity) {
        if (android.text.TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.a = java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(android.app.Activity activity) {
    }
}
