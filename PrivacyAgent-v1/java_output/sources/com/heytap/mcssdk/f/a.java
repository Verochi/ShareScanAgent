package com.heytap.mcssdk.f;

/* loaded from: classes22.dex */
public class a {
    public static boolean a(android.content.Context context, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.heytap.msp.push.mode.MessageStat(context.getPackageName(), str));
        return com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, arrayList);
    }

    public static boolean a(android.content.Context context, java.lang.String str, com.heytap.msp.push.mode.DataMessage dataMessage) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String packageName = context.getPackageName();
        arrayList.add(dataMessage == null ? new com.heytap.msp.push.mode.MessageStat(packageName, str) : new com.heytap.msp.push.mode.MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
        return com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, arrayList);
    }

    public static boolean a(android.content.Context context, java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String packageName = context.getPackageName();
        if (list != null && list.size() != 0) {
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.heytap.msp.push.mode.MessageStat(packageName, it.next()));
            }
        }
        return com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, arrayList);
    }
}
