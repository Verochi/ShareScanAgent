package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public class StatUtil {
    private static final java.lang.String COUNT = "count";
    private static final int MCS_SUPPORT_VERSION = 1017;
    private static final java.lang.String STAT_LIST = "list";
    private static final java.lang.String TYPE = "type";

    private static boolean isSupportStatisticByMcs(android.content.Context context) {
        java.lang.String mcsPackageName = com.heytap.mcssdk.PushService.getInstance().getMcsPackageName(context);
        return com.heytap.mcssdk.utils.Utils.isExistPackage(context, mcsPackageName) && com.heytap.mcssdk.utils.Utils.getVersionCode(context, mcsPackageName) >= 1017;
    }

    public static void statisticMessage(android.content.Context context, com.heytap.msp.push.mode.MessageStat messageStat) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        linkedList.add(messageStat);
        statisticMessage(context, linkedList);
    }

    public static boolean statisticMessage(android.content.Context context, java.util.List<com.heytap.msp.push.mode.MessageStat> list) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        linkedList.addAll(list);
        com.heytap.mcssdk.utils.d.b("isSupportStatisticByMcs:" + isSupportStatisticByMcs(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !isSupportStatisticByMcs(context)) {
            return false;
        }
        return statisticMessageByMcs(context, linkedList);
    }

    private static boolean statisticMessageByMcs(android.content.Context context, java.util.List<com.heytap.msp.push.mode.MessageStat> list) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction(com.heytap.mcssdk.PushService.getInstance().getReceiveSdkAction(context));
            intent.setPackage(com.heytap.mcssdk.PushService.getInstance().getMcsPackageName(context));
            intent.putExtra(com.heytap.mcssdk.constant.b.e, context.getPackageName());
            intent.putExtra("type", com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_STATISTIC);
            intent.putExtra("count", list.size());
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
            java.util.Iterator<com.heytap.msp.push.mode.MessageStat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toJsonObject());
            }
            intent.putStringArrayListExtra("list", arrayList);
            context.startService(intent);
            return true;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.e("statisticMessage--Exception" + e.getMessage());
            return false;
        }
    }
}
