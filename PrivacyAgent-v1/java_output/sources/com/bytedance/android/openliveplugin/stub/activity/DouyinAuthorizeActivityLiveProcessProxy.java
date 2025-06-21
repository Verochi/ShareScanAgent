package com.bytedance.android.openliveplugin.stub.activity;

/* loaded from: classes.dex */
public class DouyinAuthorizeActivityLiveProcessProxy extends android.app.Activity {
    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            com.bytedance.android.live.base.api.JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.auth.impl.auth.LiveAuthCallStub", "onAuthActivityBack", com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), getIntent(), this);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            android.widget.Toast.makeText(this, "抖音授权失败-界面启动失败", 1).show();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
