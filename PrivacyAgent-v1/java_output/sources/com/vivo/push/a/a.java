package com.vivo.push.a;

/* loaded from: classes19.dex */
public final class a {
    private static void a(android.content.Context context, android.content.Intent intent) {
        if (context == null) {
            com.vivo.push.util.p.d("CommandBridge", "enter startService context is null");
            throw new java.lang.Exception(com.anythink.expressad.foundation.g.b.b.a);
        }
        try {
            context.startService(intent);
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("CommandBridge", "start service error", e);
            intent.setComponent(null);
            context.sendBroadcast(intent);
        }
    }

    public static void a(android.content.Context context, com.vivo.push.o oVar, java.lang.String str) {
        try {
            boolean d = com.vivo.push.util.t.d(context, str);
            java.lang.String str2 = d ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (android.text.TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.c(context, "消息接受者包名为空！");
                throw new java.lang.Exception("消息接受者包名为空！");
            }
            if (d || a(context, str2, str)) {
                if (android.text.TextUtils.isEmpty(oVar.a())) {
                    oVar.a(context.getPackageName());
                }
                android.content.Intent intent = new android.content.Intent();
                intent.setFlags(1048576);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    intent.setAction(str2);
                }
                intent.setPackage(str);
                intent.setClassName(str, d ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                intent.putExtra("security_avoid_pull", com.vivo.push.util.a.a(context).a("com.vivo.pushservice"));
                oVar.b(intent);
                intent.putExtra("command_type", "reflect_receiver");
                intent.putExtra("security_avoid_pull_rsa", com.vivo.push.c.d.a(context).a().a("com.vivo.pushservice"));
                intent.putExtra("security_avoid_rsa_public_key", com.vivo.push.util.u.a(com.vivo.push.c.d.a(context).a().a()));
                a(context, intent);
            }
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, com.vivo.push.o oVar) {
        boolean c = oVar.c();
        com.vivo.push.b a = com.vivo.push.b.a(context, c ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean a2 = a.a();
        if (android.text.TextUtils.isEmpty(oVar.a())) {
            oVar.a(context.getPackageName());
        }
        if (a2 && !"com.vivo.pushservice".equals(context.getPackageName())) {
            com.vivo.push.a aVar = new com.vivo.push.a(oVar.a(), str, new android.os.Bundle());
            oVar.a(aVar);
            if (a.a(aVar.b())) {
                return;
            }
            com.vivo.push.util.p.b("CommandBridge", "send command error by aidl");
            com.vivo.push.util.p.c(context, "send command error by aidl");
        }
        android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, c ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        oVar.a(intent);
        try {
            a(context, intent);
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("CommandBridge", "CommandBridge startService exception: ", e);
        }
    }

    private static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent(str);
        intent.setPackage(str2);
        try {
            java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return true;
            }
            com.vivo.push.util.p.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (java.lang.Exception unused) {
            com.vivo.push.util.p.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
