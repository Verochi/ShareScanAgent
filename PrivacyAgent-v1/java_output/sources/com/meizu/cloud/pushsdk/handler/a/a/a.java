package com.meizu.cloud.pushsdk.handler.a.a;

/* loaded from: classes23.dex */
public class a {
    private android.content.Context a;
    private com.meizu.cloud.pushsdk.b.a.a b;
    private int c;
    private android.app.Notification d;

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.meizu.cloud.pushinternal.DebugLogger.d("AdNotification", "ad priority valid time out");
            com.meizu.cloud.pushsdk.handler.a.a.a.this.a();
        }
    }

    public a(android.content.Context context) {
        this.a = context;
    }

    private void a(int i, android.app.Notification notification) {
        this.c = i;
        this.d = notification;
    }

    private void b() {
        this.c = 0;
        this.d = null;
        com.meizu.cloud.pushsdk.b.a.a aVar = this.b;
        try {
            if (aVar != null) {
                try {
                    aVar.b();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            this.b = null;
        }
    }

    private void b(int i) {
        if (i <= 0) {
            return;
        }
        com.meizu.cloud.pushsdk.b.a.a aVar = this.b;
        if (aVar != null) {
            try {
                try {
                    aVar.b();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.b = null;
            }
        }
        com.meizu.cloud.pushsdk.b.a.a aVar2 = new com.meizu.cloud.pushsdk.b.a.a(this.a, new com.meizu.cloud.pushsdk.handler.a.a.a.AnonymousClass1(), i * 60 * 1000);
        this.b = aVar2;
        aVar2.a();
    }

    public void a() {
        if (this.c <= 0 || this.d == null) {
            return;
        }
        try {
            ((android.app.NotificationManager) this.a.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION)).notify(this.c, this.d);
            com.meizu.cloud.pushinternal.DebugLogger.d("AdNotification", "again show old ad notification, notifyId:" + this.c);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.meizu.cloud.pushinternal.DebugLogger.e("AdNotification", "again show old ad notification error:" + e.getMessage());
        }
        b();
    }

    public void a(int i) {
        int i2;
        if (i <= 0 || (i2 = this.c) <= 0 || i != i2) {
            return;
        }
        b();
        com.meizu.cloud.pushinternal.DebugLogger.d("AdNotification", "clean ad notification, notifyId:" + i);
    }

    public void a(int i, android.app.Notification notification, int i2) {
        if (i <= 0 || notification == null) {
            return;
        }
        a(i, notification);
        b(i2);
        com.meizu.cloud.pushinternal.DebugLogger.d("AdNotification", "save ad notification, notifyId:" + i);
    }

    public void a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.AdvanceSetting advanceSetting = messageV3.getAdvanceSetting();
        if (advanceSetting != null) {
            advanceSetting.getNotifyType().setSound(false);
            advanceSetting.getNotifyType().setLights(false);
            advanceSetting.getNotifyType().setVibrate(false);
        }
        com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx advanceSettingEx = messageV3.getAdvanceSettingEx();
        if (advanceSettingEx != null) {
            advanceSettingEx.setSoundTitle(null);
            if (android.os.Build.VERSION.SDK_INT < 29 || advanceSetting == null || !advanceSetting.isHeadUpNotification()) {
                advanceSettingEx.setPriorityDisplay(0);
            } else {
                advanceSettingEx.setPriorityDisplay(1);
            }
        }
    }
}
