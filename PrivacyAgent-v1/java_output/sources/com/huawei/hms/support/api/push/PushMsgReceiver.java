package com.huawei.hms.support.api.push;

/* loaded from: classes22.dex */
public class PushMsgReceiver extends android.content.BroadcastReceiver {
    public static void a(android.content.Context context, android.content.Intent intent) {
        if (intent.hasExtra("selfshow_info")) {
            if (!com.huawei.hms.push.u.a(context)) {
                com.huawei.hms.support.log.HMSLog.i("PushMsgReceiver", context.getPackageName() + " disable display notification.");
            }
            com.huawei.hms.push.i.a(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("PushMsgReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            intent.getStringExtra("TestIntent");
            java.lang.String action = intent.getAction();
            if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
                com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action) || ("com.huawei.intent.action.PUSH".equals(action) && com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT < 10)) {
                a(context, intent);
            } else {
                com.huawei.hms.support.log.HMSLog.i("PushMsgReceiver", "message can't be recognised.");
            }
        } catch (java.lang.Exception unused) {
            com.huawei.hms.support.log.HMSLog.e("PushMsgReceiver", "intent has some error");
        }
    }
}
