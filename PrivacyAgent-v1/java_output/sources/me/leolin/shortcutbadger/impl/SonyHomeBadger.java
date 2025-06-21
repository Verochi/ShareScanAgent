package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class SonyHomeBadger implements me.leolin.shortcutbadger.Badger {
    public final android.net.Uri a = android.net.Uri.parse("content://com.sonymobile.home.resourceprovider/badge");
    public android.content.AsyncQueryHandler b;

    /* renamed from: me.leolin.shortcutbadger.impl.SonyHomeBadger$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.AsyncQueryHandler {
        public AnonymousClass1(android.content.ContentResolver contentResolver) {
            super(contentResolver);
        }
    }

    public static void b(android.content.Context context, android.content.ComponentName componentName, int i) {
        android.content.Intent intent = new android.content.Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", java.lang.String.valueOf(i));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i > 0);
        context.sendBroadcast(intent);
    }

    public static boolean f(android.content.Context context) {
        return context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null;
    }

    public final android.content.ContentValues a(int i, android.content.ComponentName componentName) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("badge_count", java.lang.Integer.valueOf(i));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    public final void c(android.content.Context context, android.content.ComponentName componentName, int i) {
        if (i < 0) {
            return;
        }
        android.content.ContentValues a = a(i, componentName);
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            e(context, a);
            return;
        }
        if (this.b == null) {
            this.b = new me.leolin.shortcutbadger.impl.SonyHomeBadger.AnonymousClass1(context.getApplicationContext().getContentResolver());
        }
        d(a);
    }

    public final void d(android.content.ContentValues contentValues) {
        this.b.startInsert(0, null, this.a, contentValues);
    }

    public final void e(android.content.Context context, android.content.ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.a, contentValues);
    }

    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        if (f(context)) {
            c(context, componentName, i);
        } else {
            b(context, componentName, i);
        }
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("com.sonyericsson.home", "com.sonymobile.home");
    }
}
