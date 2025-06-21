package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class VivoHomeBadger implements me.leolin.shortcutbadger.Badger {
    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.content.Intent intent = new android.content.Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra(com.vivo.push.PushClientConstants.TAG_CLASS_NAME, componentName.getClassName());
        intent.putExtra("notificationNum", i);
        context.sendBroadcast(intent);
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("com.vivo.launcher");
    }
}
