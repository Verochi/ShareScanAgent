package com.vivo.push.d;

/* loaded from: classes19.dex */
final class v implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ java.util.Map b;
    final /* synthetic */ com.vivo.push.d.u c;

    public v(com.vivo.push.d.u uVar, android.content.Context context, java.util.Map map) {
        this.c = uVar;
        this.a = context;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.ComponentName componentName;
        java.lang.String packageName = this.a.getPackageName();
        try {
            java.util.List<android.app.ActivityManager.RunningTaskInfo> runningTasks = ((android.app.ActivityManager) this.a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                java.util.Iterator<android.app.ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        android.content.Intent intent = new android.content.Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        com.vivo.push.d.u.b(intent, this.b);
                        this.a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e);
        }
        android.content.Intent launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName());
        if (launchIntentForPackage == null) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(268435456);
        com.vivo.push.d.u.b(launchIntentForPackage, this.b);
        this.a.startActivity(launchIntentForPackage);
    }
}
