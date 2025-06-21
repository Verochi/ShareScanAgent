package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ch {
    public static android.content.ComponentName a(android.content.Context context, android.content.Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            android.content.pm.ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                return null;
            }
            android.content.pm.ActivityInfo activityInfo = resolveActivity.activityInfo;
            return new android.content.ComponentName(activityInfo.packageName, activityInfo.name);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean a(android.content.Context context, android.content.ComponentName componentName) {
        try {
            new android.content.Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            if (serviceInfoArr == null) {
                return false;
            }
            for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.a("checkService ".concat(java.lang.String.valueOf(e)));
            return false;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.Intent intent = new android.content.Intent(str2);
            intent.setPackage(str);
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryIntentServices != null) {
                return !queryIntentServices.isEmpty();
            }
            return false;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("checkService action: " + str2 + ", " + e);
            return false;
        }
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        boolean z = false;
        try {
            java.util.List<android.content.pm.ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders((java.lang.String) null, 0, 8);
            if (queryContentProviders != null && !queryContentProviders.isEmpty()) {
                for (android.content.pm.ProviderInfo providerInfo : queryContentProviders) {
                    if (providerInfo.enabled && providerInfo.exported && providerInfo.authority.equals(str)) {
                        z = true;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("checkProvider ".concat(java.lang.String.valueOf(e)));
        }
        return z;
    }

    public static boolean b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.Intent intent = new android.content.Intent(str2);
            intent.setPackage(str);
            return packageManager.resolveActivity(intent, 65536) != null;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("checkActivity action: " + str2 + ", " + e);
            return false;
        }
    }
}
