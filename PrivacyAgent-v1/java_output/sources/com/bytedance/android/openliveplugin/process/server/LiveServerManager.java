package com.bytedance.android.openliveplugin.process.server;

/* loaded from: classes.dex */
public class LiveServerManager extends com.bytedance.android.dy.sdk.pangle.ZeusPlatformServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("LiveServerManager onCreate");
        android.content.Context applicationContext = getContext().getApplicationContext();
        if (applicationContext instanceof android.app.Application) {
            com.bytedance.android.openliveplugin.stub.logger.TTLogger.d("LiveServerManager initZeus");
            com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.initZeus((android.app.Application) applicationContext, true, "com.byted.live.lite");
        }
        return super.onCreate();
    }
}
