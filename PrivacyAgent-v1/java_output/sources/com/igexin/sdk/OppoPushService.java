package com.igexin.sdk;

/* loaded from: classes23.dex */
public class OppoPushService extends com.heytap.msp.push.service.CompatibleDataMessageCallbackService {
    public static final java.lang.String TAG = "Assist_OP_PS";

    @Override // com.heytap.msp.push.service.CompatibleDataMessageCallbackService, com.heytap.msp.push.callback.IDataMessageCallBackService
    public void processMessage(android.content.Context context, com.heytap.msp.push.mode.DataMessage dataMessage) {
        try {
            "processMessage receive app meaasge:".concat(java.lang.String.valueOf(dataMessage));
            if (context != null && dataMessage != null) {
                com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(context, "payload", dataMessage.getContent());
                messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX);
                com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
            }
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
