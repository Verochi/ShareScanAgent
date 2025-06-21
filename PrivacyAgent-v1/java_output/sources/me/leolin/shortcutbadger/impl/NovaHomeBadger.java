package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class NovaHomeBadger implements me.leolin.shortcutbadger.Badger {
    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("tag", componentName.getPackageName() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + componentName.getClassName());
        contentValues.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, java.lang.Integer.valueOf(i));
        context.getContentResolver().insert(android.net.Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("com.teslacoilsw.launcher");
    }
}
