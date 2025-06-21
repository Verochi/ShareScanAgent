package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class MessageHandleService extends com.xiaomi.mipush.sdk.BaseService {
    private static java.util.concurrent.ConcurrentLinkedQueue<com.xiaomi.mipush.sdk.MessageHandleService.a> a = new java.util.concurrent.ConcurrentLinkedQueue<>();

    /* renamed from: a, reason: collision with other field name */
    private static java.util.concurrent.ExecutorService f6a = new java.util.concurrent.ThreadPoolExecutor(1, 1, 15, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());

    public static class a {
        private android.content.Intent a;

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.mipush.sdk.PushMessageReceiver f7a;

        public a(android.content.Intent intent, com.xiaomi.mipush.sdk.PushMessageReceiver pushMessageReceiver) {
            this.f7a = pushMessageReceiver;
            this.a = intent;
        }

        public android.content.Intent a() {
            return this.a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.mipush.sdk.PushMessageReceiver m98a() {
            return this.f7a;
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void a(android.content.Context context, com.xiaomi.mipush.sdk.MessageHandleService.a aVar) {
        java.lang.String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            com.xiaomi.mipush.sdk.PushMessageReceiver m98a = aVar.m98a();
            android.content.Intent a2 = aVar.a();
            int intExtra = a2.getIntExtra("message_type", 1);
            if (intExtra != 1) {
                if (intExtra != 3) {
                    if (intExtra == 5 && com.xiaomi.mipush.sdk.PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a2.getStringExtra(com.xiaomi.mipush.sdk.PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = a2.getStringArrayExtra("error_message")) != null) {
                        com.xiaomi.channel.commonutils.logger.b.f("begin execute onRequirePermissions, lack of necessary permissions");
                        m98a.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                }
                com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage = (com.xiaomi.mipush.sdk.MiPushCommandMessage) a2.getSerializableExtra(com.xiaomi.mipush.sdk.PushMessageHelper.KEY_COMMAND);
                com.xiaomi.channel.commonutils.logger.b.f("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                m98a.onCommandResult(context, miPushCommandMessage);
                if (android.text.TextUtils.equals(miPushCommandMessage.getCommand(), com.xiaomi.push.dx.COMMAND_REGISTER.k)) {
                    m98a.onReceiveRegisterResult(context, miPushCommandMessage);
                    com.xiaomi.mipush.sdk.PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() == 0) {
                        com.xiaomi.mipush.sdk.i.b(context);
                        return;
                    }
                    return;
                }
                return;
            }
            com.xiaomi.mipush.sdk.PushMessageHandler.a a3 = com.xiaomi.mipush.sdk.am.a(context).a(a2);
            int intExtra2 = a2.getIntExtra("eventMessageType", -1);
            if (a3 != null) {
                if (!(a3 instanceof com.xiaomi.mipush.sdk.MiPushMessage)) {
                    if (a3 instanceof com.xiaomi.mipush.sdk.MiPushCommandMessage) {
                        com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage2 = (com.xiaomi.mipush.sdk.MiPushCommandMessage) a3;
                        com.xiaomi.channel.commonutils.logger.b.f("begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                        m98a.onCommandResult(context, miPushCommandMessage2);
                        if (android.text.TextUtils.equals(miPushCommandMessage2.getCommand(), com.xiaomi.push.dx.COMMAND_REGISTER.k)) {
                            m98a.onReceiveRegisterResult(context, miPushCommandMessage2);
                            com.xiaomi.mipush.sdk.PushMessageHandler.a(context, miPushCommandMessage2);
                            if (miPushCommandMessage2.getResultCode() == 0) {
                                com.xiaomi.mipush.sdk.i.b(context);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.xiaomi.mipush.sdk.MiPushMessage miPushMessage = (com.xiaomi.mipush.sdk.MiPushMessage) a3;
                if (!miPushMessage.isArrivedMessage()) {
                    m98a.onReceiveMessage(context, miPushMessage);
                }
                if (miPushMessage.getPassThrough() == 1) {
                    com.xiaomi.push.dp.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004);
                    com.xiaomi.channel.commonutils.logger.b.f("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                    m98a.onReceivePassThroughMessage(context, miPushMessage);
                    return;
                }
                if (!miPushMessage.isNotified()) {
                    com.xiaomi.channel.commonutils.logger.b.f("begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                    m98a.onNotificationMessageArrived(context, miPushMessage);
                    return;
                }
                if (intExtra2 == 1000) {
                    com.xiaomi.push.dp.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007);
                } else {
                    com.xiaomi.push.dp.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007);
                }
                com.xiaomi.channel.commonutils.logger.b.f("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                m98a.onNotificationMessageClicked(context, miPushMessage);
            }
        } catch (java.lang.RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void addJob(android.content.Context context, com.xiaomi.mipush.sdk.MessageHandleService.a aVar) {
        if (aVar != null) {
            a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(android.content.Context context) {
        if (f6a.isShutdown()) {
            return;
        }
        f6a.execute(new com.xiaomi.mipush.sdk.z(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(android.content.Context context) {
        try {
            a(context, a.poll());
        } catch (java.lang.RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void startService(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName(context, (java.lang.Class<?>) com.xiaomi.mipush.sdk.MessageHandleService.class));
        com.xiaomi.push.m.a(context).a(new com.xiaomi.mipush.sdk.y(context, intent), 0);
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    public boolean mo104a() {
        java.util.concurrent.ConcurrentLinkedQueue<com.xiaomi.mipush.sdk.MessageHandleService.a> concurrentLinkedQueue = a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(android.content.Intent intent, int i) {
        super.onStart(intent, i);
    }
}
