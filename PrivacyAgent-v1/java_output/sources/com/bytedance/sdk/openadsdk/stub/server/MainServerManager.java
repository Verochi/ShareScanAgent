package com.bytedance.sdk.openadsdk.stub.server;

/* loaded from: classes22.dex */
public class MainServerManager extends com.bytedance.pangle.servermanager.AbsServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        android.content.Context applicationContext = getContext().getApplicationContext();
        com.bytedance.sdk.openadsdk.TTAppContextHolder.setContext(applicationContext);
        if (applicationContext instanceof android.app.Application) {
            ((android.app.Application) applicationContext).registerActivityLifecycleCallbacks(com.bytedance.sdk.openadsdk.vw.t.vw().wg());
        }
        return super.onCreate();
    }
}
