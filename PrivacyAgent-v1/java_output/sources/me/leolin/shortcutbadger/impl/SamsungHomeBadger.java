package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class SamsungHomeBadger implements me.leolin.shortcutbadger.Badger {
    public static final java.lang.String[] b = {"_id", "class"};
    public me.leolin.shortcutbadger.impl.DefaultBadger a = new me.leolin.shortcutbadger.impl.DefaultBadger();

    public final android.content.ContentValues a(android.content.ComponentName componentName, int i, boolean z) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        if (z) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", java.lang.Integer.valueOf(i));
        return contentValues;
    }

    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        me.leolin.shortcutbadger.impl.DefaultBadger defaultBadger = this.a;
        if (defaultBadger != null && defaultBadger.a(context)) {
            this.a.executeBadge(context, componentName, i);
            return;
        }
        android.net.Uri parse = android.net.Uri.parse("content://com.sec.badge/apps?notify=true");
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.database.Cursor cursor = null;
        try {
            cursor = contentResolver.query(parse, b, "package=?", new java.lang.String[]{componentName.getPackageName()}, null);
            if (cursor != null) {
                java.lang.String className = componentName.getClassName();
                boolean z = false;
                while (cursor.moveToNext()) {
                    contentResolver.update(parse, a(componentName, i, false), "_id=?", new java.lang.String[]{java.lang.String.valueOf(cursor.getInt(0))});
                    if (className.equals(cursor.getString(cursor.getColumnIndex("class")))) {
                        z = true;
                    }
                }
                if (!z) {
                    contentResolver.insert(parse, a(componentName, i, true));
                }
            }
        } finally {
            me.leolin.shortcutbadger.util.CloseHelper.close(cursor);
        }
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("com.sec.android.app.launcher", "com.sec.android.app.twlauncher");
    }
}
