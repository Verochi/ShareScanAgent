package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class ZukHomeBadger implements me.leolin.shortcutbadger.Badger {
    public final android.net.Uri a = android.net.Uri.parse("content://com.android.badge/badge");

    @Override // me.leolin.shortcutbadger.Badger
    @android.annotation.TargetApi(11)
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("app_badge_count", i);
        context.getContentResolver().call(this.a, "setAppBadgeCount", (java.lang.String) null, bundle);
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Collections.singletonList("com.zui.launcher");
    }
}
