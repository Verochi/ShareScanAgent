package com.efs.sdk.base.core.controller.a;

/* loaded from: classes22.dex */
public final class a extends android.content.BroadcastReceiver implements java.lang.Runnable {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.efs.sdk.base.core.config.GlobalInfoManager.getInstance().refreshNetStatus();
    }
}
