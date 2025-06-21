package com.heytap.msp.push.statis;

/* loaded from: classes22.dex */
public class StatisticUtils {
    public static boolean statisticEvent(android.content.Context context, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.heytap.msp.push.mode.MessageStat(context.getPackageName(), str));
        return com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, arrayList);
    }

    public static boolean statisticEvent(android.content.Context context, java.lang.String str, com.heytap.msp.push.mode.DataMessage dataMessage) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String packageName = context.getPackageName();
        arrayList.add(dataMessage == null ? new com.heytap.msp.push.mode.MessageStat(packageName, str) : new com.heytap.msp.push.mode.MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
        return com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, arrayList);
    }

    public static boolean statisticEvent(android.content.Context context, java.util.List<java.lang.String> list) {
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

    public static boolean statisticEvent(android.content.Context context, java.util.Map<java.lang.String, java.util.List<com.heytap.msp.push.mode.DataMessage>> map) {
        if (map == null) {
            return false;
        }
        java.lang.String packageName = context.getPackageName();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : map.keySet()) {
            java.util.List<com.heytap.msp.push.mode.DataMessage> list = map.get(str);
            if (list != null) {
                for (com.heytap.msp.push.mode.DataMessage dataMessage : list) {
                    arrayList.add(new com.heytap.msp.push.mode.MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
                }
            } else {
                arrayList.add(new com.heytap.msp.push.mode.MessageStat(packageName, str));
            }
        }
        return com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, arrayList);
    }
}
