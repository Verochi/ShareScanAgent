package com.igexin.sdk;

/* loaded from: classes23.dex */
public class FlymePushReceiver extends com.meizu.cloud.pushsdk.MzPushMessageReceiver {
    public static final java.lang.String CONTENT = "content";
    public static final java.lang.String MSG_KEY_PAYLOAD = "gt_payload";
    public static final java.lang.String MZ_STATUS_BAR_SMALL_ICON = "mz_push_notification_small_icon";
    public static final java.lang.String TAG = "Assist_MZ";
    private android.content.Context context;
    private int statusBarIconId;

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(android.content.Context context, android.content.Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        try {
            new java.lang.StringBuilder("onMessage intent msg :").append(intent.toUri(0));
            java.lang.String stringExtra = intent.getStringExtra("content");
            if (android.text.TextUtils.isEmpty(stringExtra)) {
                return;
            }
            com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, "payload", stringExtra);
            messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX);
            com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(android.content.Context context, java.lang.String str) {
        try {
            "onMessage receive msg:".concat(java.lang.String.valueOf(str));
            if (context == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, "payload", str);
            messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX);
            com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationArrived(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
        "onNotificationArrived receive msg:".concat(java.lang.String.valueOf(mzPushMessage));
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationClicked(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("onNotificationClicked receive msg:");
            sb.append(mzPushMessage.getTitle());
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(mzPushMessage.getContent());
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(mzPushMessage.getSelfDefineContentString());
            java.lang.String selfDefineContentString = mzPushMessage.getSelfDefineContentString();
            if (context != null && !android.text.TextUtils.isEmpty(selfDefineContentString)) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(selfDefineContentString);
                    if (jSONObject.has(MSG_KEY_PAYLOAD)) {
                        selfDefineContentString = jSONObject.getString(MSG_KEY_PAYLOAD);
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (!android.text.TextUtils.isEmpty(selfDefineContentString)) {
                    com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, "payload", selfDefineContentString);
                    messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX);
                    com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
                }
            }
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onPushStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
        "onPushStatus:".concat(java.lang.String.valueOf(pushSwitchStatus));
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver, android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        this.context = context.getApplicationContext();
        super.onReceive(context, intent);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegister(android.content.Context context, java.lang.String str) {
        try {
            "onRegister :".concat(java.lang.String.valueOf(str));
            if (context == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(context, "token", com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX.concat(java.lang.String.valueOf(str))));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegisterStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
        try {
            "onRegisterStatus :".concat(java.lang.String.valueOf(registerStatus));
            java.lang.String pushId = registerStatus.getPushId();
            if (context == null || android.text.TextUtils.isEmpty(pushId)) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(context, "token", com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX.concat(java.lang.String.valueOf(pushId))));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubAliasStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubTagsStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegister(android.content.Context context, boolean z) {
        "onUnRegister:".concat(java.lang.String.valueOf(z));
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegisterStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
        "onUnRegisterStatus:".concat(java.lang.String.valueOf(unRegisterStatus));
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUpdateNotificationBuilder(com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        try {
            int i = this.statusBarIconId;
            if (i != 0) {
                pushNotificationBuilder.setStatusBarIcon(i);
                return;
            }
            android.content.Context context = this.context;
            if (context != null) {
                int identifier = context.getResources().getIdentifier("mz_push_notification_small_icon", com.anythink.expressad.foundation.h.i.c, this.context.getPackageName());
                this.statusBarIconId = identifier;
                if (identifier != 0) {
                    pushNotificationBuilder.setStatusBarIcon(identifier);
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
