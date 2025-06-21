package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class DefaultBadger implements me.leolin.shortcutbadger.Badger {
    public boolean a(android.content.Context context) {
        return me.leolin.shortcutbadger.util.BroadcastHelper.canResolveBroadcast(context, new android.content.Intent("android.intent.action.BADGE_COUNT_UPDATE"));
    }

    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.content.Intent intent = new android.content.Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        if (me.leolin.shortcutbadger.util.BroadcastHelper.canResolveBroadcast(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new me.leolin.shortcutbadger.ShortcutBadgeException("unable to resolve intent: " + intent.toString());
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return new java.util.ArrayList(0);
    }
}
