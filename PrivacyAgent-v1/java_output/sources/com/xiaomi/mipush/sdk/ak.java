package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class ak {
    public static com.xiaomi.mipush.sdk.AbstractPushManager a(android.content.Context context, com.xiaomi.mipush.sdk.e eVar) {
        return b(context, eVar);
    }

    private static com.xiaomi.mipush.sdk.AbstractPushManager b(android.content.Context context, com.xiaomi.mipush.sdk.e eVar) {
        com.xiaomi.mipush.sdk.l.a m152a = com.xiaomi.mipush.sdk.l.m152a(eVar);
        if (m152a == null || android.text.TextUtils.isEmpty(m152a.a) || android.text.TextUtils.isEmpty(m152a.b)) {
            return null;
        }
        return (com.xiaomi.mipush.sdk.AbstractPushManager) com.xiaomi.push.aj.a(m152a.a, m152a.b, context);
    }
}
