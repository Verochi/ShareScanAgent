package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public class DataMessageUtil {
    private static final java.lang.String TYPE = "type";

    public void appArrive(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction(com.heytap.mcssdk.PushService.getInstance().getReceiveSdkAction(context));
            intent.setPackage(com.heytap.mcssdk.PushService.getInstance().getMcsPackageName(context));
            intent.putExtra(com.heytap.mcssdk.constant.b.e, context.getPackageName());
            intent.putExtra(com.heytap.mcssdk.constant.b.c, str);
            intent.putExtra("type", com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK);
            context.startService(intent);
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.e("statisticMessage--Exception" + e.getMessage());
        }
    }
}
