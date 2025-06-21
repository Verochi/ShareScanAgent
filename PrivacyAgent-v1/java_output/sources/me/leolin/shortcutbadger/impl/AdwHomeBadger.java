package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class AdwHomeBadger implements me.leolin.shortcutbadger.Badger {
    public static final java.lang.String CLASSNAME = "CNAME";
    public static final java.lang.String COUNT = "COUNT";
    public static final java.lang.String INTENT_UPDATE_COUNTER = "org.adw.launcher.counter.SEND";
    public static final java.lang.String PACKAGENAME = "PNAME";

    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.content.Intent intent = new android.content.Intent(INTENT_UPDATE_COUNTER);
        intent.putExtra(PACKAGENAME, componentName.getPackageName());
        intent.putExtra(CLASSNAME, componentName.getClassName());
        intent.putExtra(COUNT, i);
        if (me.leolin.shortcutbadger.util.BroadcastHelper.canResolveBroadcast(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new me.leolin.shortcutbadger.ShortcutBadgeException("unable to resolve intent: " + intent.toString());
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("org.adw.launcher", "org.adwfreak.launcher");
    }
}
