package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class ai {
    public static <T extends com.xiaomi.push.hw<T, ?>> com.xiaomi.push.hh a(android.content.Context context, T t, com.xiaomi.push.gk gkVar) {
        return a(context, t, gkVar, !gkVar.equals(com.xiaomi.push.gk.Registration), context.getPackageName(), com.xiaomi.mipush.sdk.b.m126a(context).m127a());
    }

    public static <T extends com.xiaomi.push.hw<T, ?>> com.xiaomi.push.hh a(android.content.Context context, T t, com.xiaomi.push.gk gkVar, boolean z, java.lang.String str, java.lang.String str2) {
        return a(context, t, gkVar, z, str, str2, true);
    }

    public static <T extends com.xiaomi.push.hw<T, ?>> com.xiaomi.push.hh a(android.content.Context context, T t, com.xiaomi.push.gk gkVar, boolean z, java.lang.String str, java.lang.String str2, boolean z2) {
        java.lang.String str3;
        byte[] a = com.xiaomi.push.hv.a(t);
        if (a != null) {
            com.xiaomi.push.hh hhVar = new com.xiaomi.push.hh();
            if (z) {
                java.lang.String d = com.xiaomi.mipush.sdk.b.m126a(context).d();
                if (android.text.TextUtils.isEmpty(d)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a = com.xiaomi.push.hb.b(com.xiaomi.push.al.b(d), a);
                    } catch (java.lang.Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
                    }
                }
            }
            com.xiaomi.push.gz gzVar = new com.xiaomi.push.gz();
            gzVar.a = 5L;
            gzVar.b = "fakeid";
            hhVar.g = gzVar;
            hhVar.d = java.nio.ByteBuffer.wrap(a);
            hhVar.a = gkVar;
            hhVar.b(z2);
            hhVar.f = str;
            hhVar.a(z);
            hhVar.e = str2;
            return hhVar;
        }
        str3 = "invoke convertThriftObjectToBytes method, return null.";
        com.xiaomi.channel.commonutils.logger.b.a(str3);
        return null;
    }

    public static com.xiaomi.push.hw a(android.content.Context context, com.xiaomi.push.hh hhVar) {
        byte[] a;
        if (hhVar.b) {
            byte[] a2 = com.xiaomi.mipush.sdk.i.a(context, hhVar, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM);
            if (a2 == null) {
                a2 = com.xiaomi.push.al.b(com.xiaomi.mipush.sdk.b.m126a(context).d());
            }
            try {
                a = com.xiaomi.push.hb.a(a2, hhVar.a());
            } catch (java.lang.Exception e) {
                throw new com.xiaomi.mipush.sdk.u("the aes decrypt failed.", e);
            }
        } else {
            a = hhVar.a();
        }
        com.xiaomi.push.hw a3 = a(hhVar.a, hhVar.c);
        if (a3 != null) {
            com.xiaomi.push.hv.a(a3, a);
        }
        return a3;
    }

    private static com.xiaomi.push.hw a(com.xiaomi.push.gk gkVar, boolean z) {
        switch (com.xiaomi.mipush.sdk.aj.a[gkVar.ordinal()]) {
            case 1:
                return new com.xiaomi.push.hm();
            case 2:
                return new com.xiaomi.push.hs();
            case 3:
                return new com.xiaomi.push.hq();
            case 4:
                return new com.xiaomi.push.hu();
            case 5:
                return new com.xiaomi.push.ho();
            case 6:
                return new com.xiaomi.push.ha();
            case 7:
                return new com.xiaomi.push.hg();
            case 8:
                return new com.xiaomi.push.hn();
            case 9:
                if (z) {
                    return new com.xiaomi.push.hk();
                }
                com.xiaomi.push.hc hcVar = new com.xiaomi.push.hc();
                hcVar.b();
                return hcVar;
            case 10:
                return new com.xiaomi.push.hg();
            default:
                return null;
        }
    }

    public static <T extends com.xiaomi.push.hw<T, ?>> com.xiaomi.push.hh b(android.content.Context context, T t, com.xiaomi.push.gk gkVar, boolean z, java.lang.String str, java.lang.String str2) {
        return a(context, t, gkVar, z, str, str2, false);
    }
}
