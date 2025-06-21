package me.leolin.shortcutbadger.util;

/* loaded from: classes16.dex */
public class BroadcastHelper {
    public static boolean canResolveBroadcast(android.content.Context context, android.content.Intent intent) {
        java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        return queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0;
    }
}
