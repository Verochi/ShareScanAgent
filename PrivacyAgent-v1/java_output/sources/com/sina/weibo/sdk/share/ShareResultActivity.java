package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public class ShareResultActivity extends android.app.Activity {
    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        android.content.Intent intent;
        super.onCreate(bundle);
        try {
            intent = getIntent();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getIntExtra("start_flag", -1) == 0) {
            finish();
            return;
        }
        java.lang.String action = intent.getAction();
        if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY".equals(action)) {
            intent.setClassName(this, "com.sina.weibo.sdk.share.ShareTransActivity");
        } else if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY".equals(action)) {
            intent.setClassName(this, "com.sina.weibo.sdk.share.ShareStoryActivity");
        }
        startActivity(intent);
        finish();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
