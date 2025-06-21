package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class MiPushClient4VR {
    public static void uploadData(android.content.Context context, java.lang.String str) {
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.e = com.xiaomi.push.gu.VRUpload.ah;
        hkVar.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
        hkVar.i = context.getPackageName();
        hkVar.a("data", str);
        hkVar.c = com.xiaomi.push.service.ag.a();
        com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, (com.xiaomi.push.gx) null);
    }
}
