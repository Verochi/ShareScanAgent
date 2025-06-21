package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class ApexHomeBadger implements me.leolin.shortcutbadger.Badger {
    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.content.Intent intent = new android.content.Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", componentName.getPackageName());
        intent.putExtra(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, i);
        intent.putExtra("class", componentName.getClassName());
        if (me.leolin.shortcutbadger.util.BroadcastHelper.canResolveBroadcast(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new me.leolin.shortcutbadger.ShortcutBadgeException("unable to resolve intent: " + intent.toString());
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("com.anddoes.launcher");
    }
}
