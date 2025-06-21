package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class PushMessageHelper {
    public static final java.lang.String ERROR_MESSAGE = "error_message";
    public static final java.lang.String ERROR_TYPE = "error_type";
    public static final java.lang.String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final java.lang.String KEY_COMMAND = "key_command";
    public static final java.lang.String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final java.lang.String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static com.xiaomi.mipush.sdk.MiPushCommandMessage generateCommandMessage(java.lang.String str, java.util.List<java.lang.String> list, long j, java.lang.String str2, java.lang.String str3, java.util.List<java.lang.String> list2) {
        com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage = new com.xiaomi.mipush.sdk.MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }

    public static com.xiaomi.mipush.sdk.MiPushMessage generateMessage(com.xiaomi.push.ho hoVar, com.xiaomi.push.gx gxVar, boolean z) {
        com.xiaomi.mipush.sdk.MiPushMessage miPushMessage = new com.xiaomi.mipush.sdk.MiPushMessage();
        miPushMessage.setMessageId(hoVar.c);
        if (!android.text.TextUtils.isEmpty(hoVar.g)) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(hoVar.g);
        } else if (!android.text.TextUtils.isEmpty(hoVar.f)) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(hoVar.f);
        } else if (android.text.TextUtils.isEmpty(hoVar.l)) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(hoVar.l);
        }
        miPushMessage.setCategory(hoVar.k);
        com.xiaomi.push.gw gwVar = hoVar.h;
        if (gwVar != null) {
            miPushMessage.setContent(gwVar.d);
        }
        if (gxVar != null) {
            if (android.text.TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(gxVar.a);
            }
            if (android.text.TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(gxVar.c);
            }
            miPushMessage.setDescription(gxVar.e);
            miPushMessage.setTitle(gxVar.d);
            miPushMessage.setNotifyType(gxVar.f);
            miPushMessage.setNotifyId(gxVar.i);
            miPushMessage.setPassThrough(gxVar.h);
            miPushMessage.setExtra(gxVar.j);
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static com.xiaomi.push.gx generateMessage(com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        com.xiaomi.push.gx gxVar = new com.xiaomi.push.gx();
        gxVar.a = miPushMessage.getMessageId();
        gxVar.c = miPushMessage.getTopic();
        gxVar.e = miPushMessage.getDescription();
        gxVar.d = miPushMessage.getTitle();
        gxVar.c(miPushMessage.getNotifyId());
        gxVar.a(miPushMessage.getNotifyType());
        gxVar.b(miPushMessage.getPassThrough());
        gxVar.j = miPushMessage.getExtra();
        return gxVar;
    }

    public static int getPushMode(android.content.Context context) {
        if (pushMode == 0) {
            setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(android.content.Context context, android.content.Intent intent) {
        try {
            java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                return !queryBroadcastReceivers.isEmpty();
            }
            return false;
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        android.content.Intent intent = new android.content.Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new com.xiaomi.mipush.sdk.PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new com.xiaomi.mipush.sdk.PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }
}
