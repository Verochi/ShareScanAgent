package me.leolin.shortcutbadger.impl;

@java.lang.Deprecated
/* loaded from: classes16.dex */
public class XiaomiHomeBadger implements me.leolin.shortcutbadger.Badger {
    public static final java.lang.String EXTRA_UPDATE_APP_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
    public static final java.lang.String EXTRA_UPDATE_APP_MSG_TEXT = "android.intent.extra.update_application_message_text";
    public static final java.lang.String INTENT_ACTION = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
    public android.content.pm.ResolveInfo a;

    @android.annotation.TargetApi(16)
    public final void a(android.content.Context context, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        if (this.a == null) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.a = context.getPackageManager().resolveActivity(intent, 65536);
        }
        if (this.a != null) {
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
            android.app.Notification build = new android.app.Notification.Builder(context).setContentTitle("").setContentText("").setSmallIcon(this.a.getIconResource()).build();
            try {
                java.lang.Object obj = build.getClass().getDeclaredField("extraNotification").get(build);
                obj.getClass().getDeclaredMethod("setMessageCount", java.lang.Integer.TYPE).invoke(obj, java.lang.Integer.valueOf(i));
                notificationManager.notify(0, build);
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager, 0, build);
            } catch (java.lang.Exception e) {
                throw new me.leolin.shortcutbadger.ShortcutBadgeException("not able to set badge", e);
            }
        }
    }

    @Override // me.leolin.shortcutbadger.Badger
    public void executeBadge(android.content.Context context, android.content.ComponentName componentName, int i) throws me.leolin.shortcutbadger.ShortcutBadgeException {
        java.lang.Object valueOf;
        try {
            java.lang.Object newInstance = java.lang.Class.forName("android.app.MiuiNotification").newInstance();
            java.lang.reflect.Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            if (i == 0) {
                valueOf = "";
            } else {
                try {
                    valueOf = java.lang.Integer.valueOf(i);
                } catch (java.lang.Exception unused) {
                    declaredField.set(newInstance, java.lang.Integer.valueOf(i));
                }
            }
            declaredField.set(newInstance, java.lang.String.valueOf(valueOf));
        } catch (java.lang.Exception unused2) {
            android.content.Intent intent = new android.content.Intent(INTENT_ACTION);
            intent.putExtra(EXTRA_UPDATE_APP_COMPONENT_NAME, componentName.getPackageName() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + componentName.getClassName());
            intent.putExtra(EXTRA_UPDATE_APP_MSG_TEXT, java.lang.String.valueOf(i != 0 ? java.lang.Integer.valueOf(i) : ""));
            if (me.leolin.shortcutbadger.util.BroadcastHelper.canResolveBroadcast(context, intent)) {
                context.sendBroadcast(intent);
            }
        }
        if (android.os.Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            a(context, i);
        }
    }

    @Override // me.leolin.shortcutbadger.Badger
    public java.util.List<java.lang.String> getSupportLaunchers() {
        return java.util.Arrays.asList("com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher");
    }
}
