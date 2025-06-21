package com.xiaomi.mipush.sdk;

@android.annotation.TargetApi(14)
/* loaded from: classes19.dex */
public class a implements android.app.Application.ActivityLifecycleCallbacks {
    private java.util.Set<java.lang.String> a = new java.util.HashSet();

    private static void a(android.app.Application application) {
        application.registerActivityLifecycleCallbacks(new com.xiaomi.mipush.sdk.a());
    }

    public static void a(android.content.Context context) {
        a((android.app.Application) context.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        android.content.Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        java.lang.String stringExtra = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if (android.text.TextUtils.isEmpty(stringExtra) || intExtra <= 0 || this.a.contains(stringExtra)) {
            return;
        }
        this.a.add(stringExtra);
        if (intExtra == 3000) {
            com.xiaomi.push.dp.a(activity.getApplicationContext()).a(activity.getPackageName(), com.xiaomi.push.Cdo.a(intExtra), stringExtra, 3008, null);
        } else if (intExtra == 1000) {
            com.xiaomi.push.dp.a(activity.getApplicationContext()).a(activity.getPackageName(), com.xiaomi.push.Cdo.a(intExtra), stringExtra, 1008, null);
        }
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
}
