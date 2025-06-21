package me.leolin.shortcutbadger;

/* loaded from: classes16.dex */
public interface Badger {
    void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException;

    java.util.List<java.lang.String> getSupportLaunchers();
}
