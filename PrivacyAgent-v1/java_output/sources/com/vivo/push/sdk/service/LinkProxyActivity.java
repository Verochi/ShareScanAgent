package com.vivo.push.sdk.service;

/* loaded from: classes19.dex */
public class LinkProxyActivity extends android.app.Activity {
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba A[Catch: Exception -> 0x00cc, TryCatch #1 {Exception -> 0x00cc, blocks: (B:12:0x005f, B:15:0x0067, B:18:0x006c, B:21:0x007b, B:22:0x007f, B:24:0x0085, B:26:0x0091, B:28:0x0097, B:30:0x009f, B:33:0x00a6, B:35:0x00ae, B:37:0x00b2, B:41:0x00ba, B:42:0x00be), top: B:10:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be A[Catch: Exception -> 0x00cc, TRY_LEAVE, TryCatch #1 {Exception -> 0x00cc, blocks: (B:12:0x005f, B:15:0x0067, B:18:0x006c, B:21:0x007b, B:22:0x007f, B:24:0x0085, B:26:0x0091, B:28:0x0097, B:30:0x009f, B:33:0x00a6, B:35:0x00ae, B:37:0x00b2, B:41:0x00ba, B:42:0x00be), top: B:10:0x005d }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(android.os.Bundle bundle) {
        android.content.pm.PackageManager packageManager;
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices;
        android.content.pm.ResolveInfo resolveInfo;
        android.content.pm.ServiceInfo serviceInfo;
        java.lang.String str;
        super.onCreate(bundle);
        android.content.Intent intent = getIntent();
        if (intent == null) {
            com.vivo.push.util.p.d("LinkProxyActivity", "enter RequestPermissionsActivity onCreate, intent is null, finish");
            finish();
            return;
        }
        boolean z = true;
        try {
            android.view.Window window = getWindow();
            window.setGravity(com.google.android.material.badge.BadgeDrawable.TOP_START);
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
        } catch (java.lang.Throwable th) {
            com.vivo.push.util.p.b("LinkProxyActivity", "enter onCreate error ", th);
        }
        java.lang.String packageName = getPackageName();
        com.vivo.push.util.p.d("LinkProxyActivity", hashCode() + " enter onCreate " + packageName);
        try {
            if ("com.vivo.abe".equals(packageName)) {
                if (intent.getExtras() == null) {
                    str = "adapterToService getExtras() is null";
                } else {
                    android.content.Intent intent2 = (android.content.Intent) intent.getExtras().get("previous_intent");
                    if (intent2 == null) {
                        str = "adapterToService proxyIntent is null";
                    } else {
                        com.vivo.push.util.z.a(this, intent2);
                    }
                }
                com.vivo.push.util.p.d("LinkProxyActivity", str);
            } else if (intent.getExtras() != null) {
                android.content.Intent intent3 = (android.content.Intent) intent.getExtras().get("previous_intent");
                if (intent3 != null && (packageManager = getPackageManager()) != null && (queryIntentServices = packageManager.queryIntentServices(intent3, 576)) != null && !queryIntentServices.isEmpty() && (resolveInfo = queryIntentServices.get(0)) != null && (serviceInfo = resolveInfo.serviceInfo) != null && serviceInfo.exported) {
                    if (z) {
                        com.vivo.push.util.p.b("LinkProxyActivity", "service's exported is ".concat(java.lang.String.valueOf(z)));
                    } else {
                        startService(intent3);
                    }
                }
                z = false;
                if (z) {
                }
            }
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("LinkProxyActivity", e.toString(), e);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.vivo.push.util.p.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
