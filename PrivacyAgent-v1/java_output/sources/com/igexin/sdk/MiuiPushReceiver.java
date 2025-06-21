package com.igexin.sdk;

/* loaded from: classes23.dex */
public class MiuiPushReceiver extends com.xiaomi.mipush.sdk.PushMessageReceiver {
    public static final java.lang.String TAG = "Assist_XM";

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        "onCommandResult receive command:".concat(java.lang.String.valueOf(miPushCommandMessage));
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        "onNotificationArrived receive message:".concat(java.lang.String.valueOf(miPushMessage));
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        try {
            "onNotificationMessageClicked receive message:".concat(java.lang.String.valueOf(miPushMessage));
            if (context != null && miPushMessage != null) {
                com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, "payload", miPushMessage.getContent());
                messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX);
                com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
            }
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        try {
            "onReceivePassThroughMessage receive meaasge:".concat(java.lang.String.valueOf(miPushMessage));
            if (context != null && miPushMessage != null) {
                com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, "payload", miPushMessage.getContent());
                messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX);
                com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
            }
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
        try {
            "onReceiveRegisterResult receiver message:".concat(java.lang.String.valueOf(miPushCommandMessage));
            if (context == null || miPushCommandMessage == null) {
                return;
            }
            java.lang.String command = miPushCommandMessage.getCommand();
            java.util.List<java.lang.String> commandArguments = miPushCommandMessage.getCommandArguments();
            java.lang.String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
            if (com.xiaomi.mipush.sdk.MiPushClient.COMMAND_REGISTER.equals(command) && miPushCommandMessage.getResultCode() == 0) {
                com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(context, "token", com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX.concat(java.lang.String.valueOf(str))));
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
