package com.vivo.push.sdk;

/* loaded from: classes19.dex */
public abstract class BasePushMessageReceiver extends android.content.BroadcastReceiver implements com.vivo.push.sdk.PushMessageCallback {
    public static final java.lang.String TAG = "PushMessageReceiver";

    @Override // com.vivo.push.sdk.PushMessageCallback
    public boolean isAllowNet(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            str = "isAllowNet sContext is null";
        } else {
            java.lang.String packageName = context.getPackageName();
            if (!android.text.TextUtils.isEmpty(packageName)) {
                android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.PUSH_SERVICE");
                intent.setPackage(packageName);
                java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    return com.vivo.push.util.t.a(context, packageName);
                }
                com.vivo.push.util.p.a(TAG, "this is client sdk");
                return true;
            }
            str = "isAllowNet pkgName is null";
        }
        com.vivo.push.util.p.a(TAG, str);
        return false;
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onBind(android.content.Context context, int i, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelAlias(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onListTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onLog(android.content.Context context, java.lang.String str, int i, boolean z) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onPublish(android.content.Context context, int i, java.lang.String str) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        android.content.Context applicationContext = com.vivo.push.util.ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.e.a().a(applicationContext);
        com.vivo.push.util.p.d(TAG, "PushMessageReceiver " + applicationContext.getPackageName() + " ; requestId = " + intent.getStringExtra(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId));
        try {
            com.vivo.push.e.a().a(intent, this);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetAlias(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(android.content.Context context, com.vivo.push.model.UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onUnBind(android.content.Context context, int i, java.lang.String str) {
    }
}
