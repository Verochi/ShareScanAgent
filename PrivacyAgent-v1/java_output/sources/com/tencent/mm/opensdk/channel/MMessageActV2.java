package com.tencent.mm.opensdk.channel;

/* loaded from: classes19.dex */
public class MMessageActV2 {
    public static final java.lang.String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final java.lang.String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final java.lang.String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final java.lang.String TAG = "MicroMsg.SDK.MMessageAct";

    /* renamed from: com.tencent.mm.opensdk.channel.MMessageActV2$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.app.PendingIntent.OnFinished {
        @Override // android.app.PendingIntent.OnFinished
        public void onSendFinished(android.app.PendingIntent pendingIntent, android.content.Intent intent, int i, java.lang.String str, android.os.Bundle bundle) {
            com.tencent.mm.opensdk.utils.Log.i(com.tencent.mm.opensdk.channel.MMessageActV2.TAG, "sendUsingPendingIntent onSendFinished resultCode: " + i + ", resultData: " + str);
        }
    }

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public android.os.Bundle bundle;
        public java.lang.String content;
        public int flags = -1;
        public java.lang.String targetClassName;
        public java.lang.String targetPkgName;
        public java.lang.String token;

        public java.lang.String toString() {
            return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
        }
    }

    public static boolean send(android.content.Context context, com.tencent.mm.opensdk.channel.MMessageActV2.Args args) {
        java.lang.String str;
        if (context == null || args == null) {
            str = "send fail, invalid argument";
        } else if (com.tencent.mm.opensdk.utils.b.b(args.targetPkgName)) {
            str = "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName;
        } else {
            if (com.tencent.mm.opensdk.utils.b.b(args.targetClassName)) {
                args.targetClassName = args.targetPkgName + DEFAULT_ENTRY_CLASS_NAME;
            }
            com.tencent.mm.opensdk.utils.Log.d(TAG, "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName);
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName(args.targetPkgName, args.targetClassName);
            android.os.Bundle bundle = args.bundle;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            java.lang.String packageName = context.getPackageName();
            intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.SDK_VERSION, com.tencent.mm.opensdk.constants.Build.SDK_INT);
            intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CONTENT, args.content);
            intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CHECK_SUM, com.tencent.mm.opensdk.channel.a.a.a(args.content, com.tencent.mm.opensdk.constants.Build.SDK_INT, packageName));
            intent.putExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.TOKEN, args.token);
            int i = args.flags;
            if (i == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(i);
            }
            try {
                if (android.os.Build.VERSION.SDK_INT >= 29) {
                    sendUsingPendingIntent(context, intent);
                } else {
                    context.startActivity(intent);
                }
                com.tencent.mm.opensdk.utils.Log.d(TAG, "send mm message, intent=" + intent);
                return true;
            } catch (java.lang.Exception e) {
                str = "send fail, ex = " + e.getMessage();
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str);
        return false;
    }

    private static void sendUsingPendingIntent(android.content.Context context, android.content.Intent intent) {
        try {
            com.tencent.mm.opensdk.utils.Log.i(TAG, "sendUsingPendingIntent");
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetActivity(context, 3, intent, 134217728);
            android.app.PendingIntent activity = android.app.PendingIntent.getActivity(context, 3, intent, 134217728);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetActivity(activity, context, 3, intent, 134217728);
            activity.send(context, 4, null, new com.tencent.mm.opensdk.channel.MMessageActV2.AnonymousClass1(), null);
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "sendUsingPendingIntent fail, ex = " + e.getMessage());
            context.startActivity(intent);
        }
    }
}
