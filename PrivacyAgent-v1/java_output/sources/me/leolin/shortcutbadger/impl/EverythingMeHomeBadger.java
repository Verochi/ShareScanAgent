package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class EverythingMeHomeBadger implements me.leolin.shortcutbadger.Badger {
    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        contentValues.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, java.lang.Integer.valueOf(i));
        context.getContentResolver().insert(android.net.Uri.parse("content://me.everything.badger/apps"), contentValues);
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("me.everything.launcher");
    }
}
