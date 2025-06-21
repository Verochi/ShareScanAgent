package com.meizu.cloud.pushsdk.handler.a.f;

/* loaded from: classes23.dex */
public class a {
    private android.content.Context a;
    private java.util.List<android.content.Intent> b;
    private android.content.BroadcastReceiver c;

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.f.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;

        public AnonymousClass1(android.content.Intent intent) {
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.Thread.sleep(1000L);
                com.meizu.cloud.pushinternal.DebugLogger.d("BrightNotification", "start bright notification service " + this.a);
                com.meizu.cloud.pushsdk.handler.a.f.a.this.a.startService(this.a);
            } catch (java.lang.Exception e) {
                com.meizu.cloud.pushinternal.DebugLogger.e("BrightNotification", "send bright notification error " + e.getMessage());
            }
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.f.a$2, reason: invalid class name */
    public class AnonymousClass2 extends android.content.BroadcastReceiver {
        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT.equalsIgnoreCase(intent.getAction())) {
                com.meizu.cloud.pushsdk.handler.a.f.a.this.a();
            }
        }
    }

    public a(android.content.Context context) {
        this.a = context.getApplicationContext();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        java.util.List<android.content.Intent> list = this.b;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = this.b.size();
        java.util.Iterator<android.content.Intent> it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            android.content.Intent next = it.next();
            if (i != size - 1) {
                b(next);
            }
            a(next);
            it.remove();
            i++;
        }
    }

    private void a(android.content.Intent intent) {
        com.meizu.cloud.pushsdk.b.c.c.a().execute(new com.meizu.cloud.pushsdk.handler.a.f.a.AnonymousClass1(intent));
    }

    private void b() {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT);
        if (this.c == null) {
            this.c = new com.meizu.cloud.pushsdk.handler.a.f.a.AnonymousClass2();
        }
        this.a.registerReceiver(this.c, intentFilter);
    }

    private void b(android.content.Intent intent) {
        com.meizu.cloud.pushsdk.handler.MessageV3 messageV3 = (com.meizu.cloud.pushsdk.handler.MessageV3) intent.getParcelableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_BRIGHT_NOTIFICATION_MESSAGE);
        if (messageV3 == null) {
            return;
        }
        com.meizu.cloud.pushsdk.notification.model.AdvanceSetting advanceSetting = messageV3.getAdvanceSetting();
        com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx advanceSettingEx = messageV3.getAdvanceSettingEx();
        if (advanceSetting == null || advanceSettingEx == null) {
            return;
        }
        advanceSettingEx.setSoundTitle(null);
        advanceSetting.getNotifyType().setSound(false);
        advanceSetting.getNotifyType().setLights(false);
        advanceSetting.getNotifyType().setVibrate(false);
    }

    public void a(android.content.Intent intent, java.lang.String str) {
        if (intent == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.util.List<android.content.Intent> list = this.b;
        if (list != null) {
            java.util.Iterator<android.content.Intent> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                android.content.Intent next = it.next();
                com.meizu.cloud.pushsdk.handler.MessageV3 messageV3 = (com.meizu.cloud.pushsdk.handler.MessageV3) next.getParcelableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_BRIGHT_NOTIFICATION_MESSAGE);
                if (messageV3 != null && messageV3.getUploadDataPackageName() != null && str.equalsIgnoreCase(messageV3.getUploadDataPackageName())) {
                    this.b.remove(next);
                    break;
                }
            }
        } else {
            this.b = new java.util.ArrayList();
        }
        this.b.add(intent);
        com.meizu.cloud.pushinternal.DebugLogger.d("BrightNotification", "add bright notification intent, intent list: " + this.b);
    }
}
