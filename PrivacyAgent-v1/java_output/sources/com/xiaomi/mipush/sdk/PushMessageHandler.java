package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class PushMessageHandler extends com.xiaomi.mipush.sdk.BaseService {
    private static java.util.List<com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult> a = new java.util.ArrayList();
    private static java.util.List<com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback> b = new java.util.ArrayList();

    /* renamed from: a, reason: collision with other field name */
    private static java.util.concurrent.ThreadPoolExecutor f18a = new java.util.concurrent.ThreadPoolExecutor(1, 1, 15, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());

    public interface a extends java.io.Serializable {
    }

    public static void a() {
        synchronized (b) {
            b.clear();
        }
    }

    public static void a(long j, java.lang.String str, java.lang.String str2) {
        synchronized (b) {
            java.util.Iterator<com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback> it = b.iterator();
            while (it.hasNext()) {
                it.next().onInitializeResult(j, str, str2);
            }
        }
    }

    public static void a(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName(context, (java.lang.Class<?>) com.xiaomi.mipush.sdk.PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e.getMessage());
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.c("addjob PushMessageHandler ".concat(java.lang.String.valueOf(intent)));
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    private static void a(android.content.Context context, android.content.Intent intent, android.content.pm.ResolveInfo resolveInfo, boolean z) {
        try {
            com.xiaomi.mipush.sdk.MessageHandleService.a aVar = new com.xiaomi.mipush.sdk.MessageHandleService.a(intent, (com.xiaomi.mipush.sdk.PushMessageReceiver) com.xiaomi.push.jc.a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                com.xiaomi.mipush.sdk.MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                com.xiaomi.mipush.sdk.MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            com.xiaomi.mipush.sdk.MessageHandleService.a(context, new android.content.Intent(context.getApplicationContext(), (java.lang.Class<?>) com.xiaomi.mipush.sdk.MessageHandleService.class));
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static void a(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        synchronized (a) {
            for (com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult iCallbackResult : a) {
                if (iCallbackResult instanceof com.xiaomi.mipush.sdk.MiPushClient.UPSRegisterCallBack) {
                    com.xiaomi.mipush.sdk.MiPushClient.TokenResult tokenResult = new com.xiaomi.mipush.sdk.MiPushClient.TokenResult();
                    if (miPushCommandMessage != null && miPushCommandMessage.getCommandArguments() != null && miPushCommandMessage.getCommandArguments().size() > 0) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    iCallbackResult.onResult(tokenResult);
                }
            }
        }
    }

    public static void a(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        synchronized (b) {
            for (com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(android.content.Context context, com.xiaomi.mipush.sdk.PushMessageHandler.a aVar) {
        if (aVar instanceof com.xiaomi.mipush.sdk.MiPushMessage) {
            a(context, (com.xiaomi.mipush.sdk.MiPushMessage) aVar);
            return;
        }
        if (aVar instanceof com.xiaomi.mipush.sdk.MiPushCommandMessage) {
            com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage = (com.xiaomi.mipush.sdk.MiPushCommandMessage) aVar;
            java.lang.String command = miPushCommandMessage.getCommand();
            java.lang.String str = null;
            if (com.xiaomi.push.dx.COMMAND_REGISTER.k.equals(command)) {
                java.util.List<java.lang.String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (com.xiaomi.push.dx.COMMAND_SET_ALIAS.k.equals(command) || com.xiaomi.push.dx.COMMAND_UNSET_ALIAS.k.equals(command) || com.xiaomi.push.dx.COMMAND_SET_ACCEPT_TIME.k.equals(command)) {
                a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
                return;
            }
            if (com.xiaomi.push.dx.COMMAND_SUBSCRIBE_TOPIC.k.equals(command)) {
                java.util.List<java.lang.String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (com.xiaomi.push.dx.COMMAND_UNSUBSCRIBE_TOPIC.k.equals(command)) {
                java.util.List<java.lang.String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    public static void a(android.content.Context context, java.lang.String str, long j, java.lang.String str2, java.lang.String str3) {
        synchronized (b) {
            for (com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, long j, java.lang.String str3, java.util.List<java.lang.String> list) {
        synchronized (b) {
            for (com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    public static void a(com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (a) {
            if (!a.contains(iCallbackResult)) {
                a.add(iCallbackResult);
            }
        }
    }

    public static void a(com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (b) {
            if (!b.contains(miPushClientCallback)) {
                b.add(miPushClientCallback);
            }
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        return (android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isEmpty(str2)) || android.text.TextUtils.equals(str, str2);
    }

    public static void b() {
        synchronized (a) {
            a.clear();
        }
    }

    private static void b(android.content.Context context) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, com.xiaomi.mipush.sdk.d.a(context));
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("callback sync error".concat(java.lang.String.valueOf(e)));
        }
    }

    public static void b(android.content.Context context, android.content.Intent intent) {
        boolean z = false;
        try {
            z = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("intent unparcel error:".concat(java.lang.String.valueOf(th)));
        }
        try {
            android.content.pm.ResolveInfo resolveInfo = null;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                com.xiaomi.mipush.sdk.o.a(context, intent, null);
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                com.xiaomi.push.go goVar = new com.xiaomi.push.go();
                com.xiaomi.push.hv.a(goVar, intent.getByteArrayExtra("mipush_payload"));
                com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler.onHandleIntent " + goVar.i);
                com.xiaomi.mipush.sdk.MiTinyDataClient.upload(context, goVar);
            } else if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(context)) {
                if (m103b()) {
                    com.xiaomi.channel.commonutils.logger.b.d("receive a message before application calling initialize");
                    if (z) {
                        b(context);
                        return;
                    }
                    return;
                }
                com.xiaomi.mipush.sdk.PushMessageHandler.a a2 = com.xiaomi.mipush.sdk.am.a(context).a(intent);
                if (a2 != null) {
                    a(context, a2);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                android.content.Intent intent2 = new android.content.Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    if (queryBroadcastReceivers != null) {
                        java.util.Iterator<android.content.pm.ResolveInfo> it = queryBroadcastReceivers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            android.content.pm.ResolveInfo next = it.next();
                            android.content.pm.ActivityInfo activityInfo = next.activityInfo;
                            if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName()) && com.xiaomi.mipush.sdk.PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.jc.a(context, next.activityInfo.name))) {
                                resolveInfo = next;
                                break;
                            }
                        }
                    }
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo, z);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("cannot find the receiver to handler this message, check your manifest");
                        com.xiaomi.push.dp.a(context).a(context.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    }
                } catch (java.lang.Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.dp.a(context).a(context.getPackageName(), intent, "9");
                }
            }
        } catch (java.lang.Throwable th2) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(th2);
                com.xiaomi.push.dp.a(context).a(context.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                if (z) {
                    b(context);
                }
            } finally {
                if (z) {
                    b(context);
                }
            }
        }
    }

    public static void b(android.content.Context context, java.lang.String str, long j, java.lang.String str2, java.lang.String str3) {
        synchronized (b) {
            for (com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback miPushClientCallback : b) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m103b() {
        return b.isEmpty();
    }

    private static void c(android.content.Context context, android.content.Intent intent) {
        if (intent == null || f18a.isShutdown()) {
            return;
        }
        f18a.execute(new com.xiaomi.mipush.sdk.al(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo104a() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = f18a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f18a.getQueue().size() <= 0) ? false : true;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(android.content.Intent intent, int i) {
        super.onStart(intent, i);
        c(getApplicationContext(), intent);
    }
}
