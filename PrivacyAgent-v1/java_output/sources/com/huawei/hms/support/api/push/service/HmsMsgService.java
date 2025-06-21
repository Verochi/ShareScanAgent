package com.huawei.hms.support.api.push.service;

/* loaded from: classes22.dex */
public class HmsMsgService extends android.app.Service {

    public static class a extends android.os.Handler {
        public android.content.Context a;

        public a(android.content.Context context) {
            this.a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            android.os.Bundle data = message.getData();
            if (java.util.Objects.equals(this.a.getApplicationContext().getPackageManager().getNameForUid(message.sendingUid), com.huawei.hms.utils.HMSPackageManager.getInstance(this.a).getHMSPackageName()) && data != null) {
                if (com.huawei.hms.utils.HMSPackageManager.getInstance(this.a).getHMSPackageStates() != com.huawei.hms.utils.PackageManagerHelper.PackageStates.ENABLED) {
                    com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "service not start by hms");
                } else {
                    com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "chose push type");
                    if (java.util.Objects.equals(com.huawei.hms.push.c.b(data, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
                        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
                            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(this.a.getApplicationContext());
                        }
                        com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "invokeSelfShow");
                        com.huawei.hms.support.api.push.service.HmsMsgService.c(this.a, data);
                    } else if (java.util.Objects.equals(com.huawei.hms.push.c.b(data, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
                        com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "sendBroadcastToHms");
                        com.huawei.hms.support.api.push.service.HmsMsgService.d(this.a, data);
                    }
                }
            }
            super.handleMessage(message);
        }
    }

    public static void c(android.content.Context context, android.os.Bundle bundle) {
        if (!com.huawei.hms.push.u.a(context)) {
            com.huawei.hms.support.log.HMSLog.i("HmsMsgService", context.getPackageName() + " disable display notification.");
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", com.huawei.hms.push.c.a(bundle, "selfshow_info"));
        intent.putExtra("selfshow_token", com.huawei.hms.push.c.a(bundle, "selfshow_token"));
        intent.setPackage(com.huawei.hms.push.c.c(bundle, "push_package"));
        com.huawei.hms.push.i.a(context, intent);
        com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "invokeSelfShow done");
    }

    public static void d(android.content.Context context, android.os.Bundle bundle) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("msg_data", com.huawei.hms.push.c.a(bundle, "msg_data"));
            intent.putExtra(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, com.huawei.hms.push.c.a(bundle, com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN));
            intent.putExtra("msgIdStr", com.huawei.hms.push.c.c(bundle, "msgIdStr"));
            intent.setFlags(32);
            intent.setPackage(com.huawei.hms.push.c.c(bundle, "push_package"));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".permission.PROCESS_PUSH_MSG");
            context.sendBroadcast(intent, sb.toString());
            com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "send broadcast passby done");
        } catch (java.lang.SecurityException unused) {
            com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "send broadcast SecurityException");
        } catch (java.lang.Exception unused2) {
            com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "send broadcast Exception");
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "onBind");
        return new android.os.Messenger(new com.huawei.hms.support.api.push.service.HmsMsgService.a(this)).getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.huawei.hms.support.log.HMSLog.i("HmsMsgService", "Enter onStartCommand.");
        return 2;
    }
}
