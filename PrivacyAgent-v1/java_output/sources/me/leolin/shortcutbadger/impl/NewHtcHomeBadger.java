package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class NewHtcHomeBadger implements me.leolin.shortcutbadger.Badger {
    public static final java.lang.String COUNT = "count";
    public static final java.lang.String EXTRA_COMPONENT = "com.htc.launcher.extra.COMPONENT";
    public static final java.lang.String EXTRA_COUNT = "com.htc.launcher.extra.COUNT";
    public static final java.lang.String INTENT_SET_NOTIFICATION = "com.htc.launcher.action.SET_NOTIFICATION";
    public static final java.lang.String INTENT_UPDATE_SHORTCUT = "com.htc.launcher.action.UPDATE_SHORTCUT";
    public static final java.lang.String PACKAGENAME = "packagename";

    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.content.Intent intent = new android.content.Intent(INTENT_SET_NOTIFICATION);
        intent.putExtra(EXTRA_COMPONENT, componentName.flattenToShortString());
        intent.putExtra(EXTRA_COUNT, i);
        android.content.Intent intent2 = new android.content.Intent(INTENT_UPDATE_SHORTCUT);
        intent2.putExtra(PACKAGENAME, componentName.getPackageName());
        intent2.putExtra(COUNT, i);
        if (me.leolin.shortcutbadger.util.BroadcastHelper.canResolveBroadcast(context, intent) || me.leolin.shortcutbadger.util.BroadcastHelper.canResolveBroadcast(context, intent2)) {
            context.sendBroadcast(intent);
            context.sendBroadcast(intent2);
        } else {
            throw new me.leolin.shortcutbadger.ShortcutBadgeException("unable to resolve intent: " + intent2.toString());
        }
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("com.htc.launcher");
    }
}
