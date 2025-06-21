package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class l {
    private static java.util.HashMap<com.xiaomi.mipush.sdk.e, com.xiaomi.mipush.sdk.l.a> a = new java.util.HashMap<>();

    public static class a {
        public java.lang.String a;
        public java.lang.String b;

        public a(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    static {
        a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI, new com.xiaomi.mipush.sdk.l.a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM, new com.xiaomi.mipush.sdk.l.a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS, new com.xiaomi.mipush.sdk.l.a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS, new com.xiaomi.mipush.sdk.l.a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static com.xiaomi.mipush.sdk.au a(com.xiaomi.mipush.sdk.e eVar) {
        int i = com.xiaomi.mipush.sdk.m.a[eVar.ordinal()];
        if (i == 1) {
            return com.xiaomi.mipush.sdk.au.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return com.xiaomi.mipush.sdk.au.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return com.xiaomi.mipush.sdk.au.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return com.xiaomi.mipush.sdk.au.UPLOAD_FTOS_TOKEN;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static com.xiaomi.mipush.sdk.l.a m152a(com.xiaomi.mipush.sdk.e eVar) {
        return a.get(eVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static com.xiaomi.push.gp m153a(com.xiaomi.mipush.sdk.e eVar) {
        return com.xiaomi.push.gp.AggregatePushSwitch;
    }

    private static void a(com.xiaomi.mipush.sdk.e eVar, com.xiaomi.mipush.sdk.l.a aVar) {
        if (aVar != null) {
            a.put(eVar, aVar);
        }
    }
}
