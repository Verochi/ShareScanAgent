package com.vivo.push.d;

/* loaded from: classes19.dex */
final class f extends com.vivo.push.l {
    public f(com.vivo.push.o oVar) {
        super(oVar);
    }

    public static boolean a(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            com.vivo.push.util.p.a("OnChangePushStatusTask", "enableService error: can not find push service.");
            return false;
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        android.content.ComponentName componentName = new android.content.ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 1) {
            com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has enabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
        com.vivo.push.util.p.d("OnChangePushStatusTask", "enableService push service.");
        return true;
    }

    public static boolean b(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            com.vivo.push.util.p.a("OnChangePushStatusTask", "disableService error: can not find push service.");
            return false;
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        android.content.ComponentName componentName = new android.content.ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 2) {
            com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has disabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
        com.vivo.push.util.p.d("OnChangePushStatusTask", "disableService push service.");
        return true;
    }

    private static java.util.List<android.content.pm.ResolveInfo> c(android.content.Context context) {
        java.util.List<android.content.pm.ResolveInfo> list;
        android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (java.lang.Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            return list;
        }
        android.content.Intent intent2 = new android.content.Intent("com.vivo.pushclient.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        try {
            return context.getPackageManager().queryBroadcastReceivers(intent2, 576);
        } catch (java.lang.Exception unused2) {
            return list;
        }
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        java.lang.String str;
        if (this.a.getPackageName().equals(com.vivo.push.util.t.b(this.a))) {
            return;
        }
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) oVar;
        int d = jVar.d();
        int e = jVar.e();
        com.vivo.push.util.p.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + d + " ; receiverStatus is " + e);
        if (d == 2) {
            b(this.a);
        } else if (d == 1) {
            a(this.a);
        } else if (d == 0) {
            android.content.Context context = this.a;
            android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            } else {
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                android.content.ComponentName componentName = new android.content.ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 0) {
                    packageManager.setComponentEnabledSetting(componentName, 0, 1);
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has defaulted");
                }
            }
        }
        if (e == 2) {
            android.content.Context context2 = this.a;
            java.util.List<android.content.pm.ResolveInfo> c = c(context2);
            if (c == null || c.size() <= 0) {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            } else {
                java.lang.String str2 = c.get(0).activityInfo.name;
                if (android.text.TextUtils.isEmpty(str2)) {
                    str = "disableReceiver error: className is null. ";
                } else {
                    android.content.pm.PackageManager packageManager2 = context2.getPackageManager();
                    android.content.ComponentName componentName2 = new android.content.ComponentName(context2, str2);
                    if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                        packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                        str = "push service disableReceiver ";
                    } else {
                        str = "push service has disableReceiver ";
                    }
                }
                com.vivo.push.util.p.d("OnChangePushStatusTask", str);
            }
            com.vivo.push.sdk.a.a().b();
            return;
        }
        if (e == 1) {
            android.content.Context context3 = this.a;
            java.util.List<android.content.pm.ResolveInfo> c2 = c(context3);
            if (c2 == null || c2.size() <= 0) {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
                return;
            }
            java.lang.String str3 = c2.get(0).activityInfo.name;
            if (android.text.TextUtils.isEmpty(str3)) {
                com.vivo.push.util.p.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                return;
            }
            android.content.pm.PackageManager packageManager3 = context3.getPackageManager();
            android.content.ComponentName componentName3 = new android.content.ComponentName(context3, str3);
            if (packageManager3.getComponentEnabledSetting(componentName3) == 1) {
                com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has enableReceiver ");
                return;
            } else {
                packageManager3.setComponentEnabledSetting(componentName3, 1, 1);
                com.vivo.push.util.p.d("OnChangePushStatusTask", "push service enableReceiver ");
                return;
            }
        }
        if (e == 0) {
            android.content.Context context4 = this.a;
            java.util.List<android.content.pm.ResolveInfo> c3 = c(context4);
            if (c3 == null || c3.size() <= 0) {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
                return;
            }
            java.lang.String str4 = c3.get(0).activityInfo.name;
            if (android.text.TextUtils.isEmpty(str4)) {
                com.vivo.push.util.p.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                return;
            }
            android.content.pm.PackageManager packageManager4 = context4.getPackageManager();
            android.content.ComponentName componentName4 = new android.content.ComponentName(context4, str4);
            if (packageManager4.getComponentEnabledSetting(componentName4) == 0) {
                com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has defaulted");
            } else {
                packageManager4.setComponentEnabledSetting(componentName4, 0, 1);
                com.vivo.push.util.p.d("OnChangePushStatusTask", "push service defaultReceiver ");
            }
        }
    }
}
