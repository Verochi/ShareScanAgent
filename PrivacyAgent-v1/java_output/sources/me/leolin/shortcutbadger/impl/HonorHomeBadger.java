package me.leolin.shortcutbadger.impl;

/* loaded from: classes16.dex */
public class HonorHomeBadger implements me.leolin.shortcutbadger.Badger {
    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", componentName.getClassName());
        bundle.putInt("badgenumber", i);
        context.getContentResolver().call(android.net.Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (java.lang.String) null, bundle);
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("com.hihonor.android.launcher");
    }
}
