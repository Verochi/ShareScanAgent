package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hv {
    public static short a(android.content.Context context, com.xiaomi.push.hh hhVar) {
        return a(context, hhVar.f);
    }

    public static short a(android.content.Context context, java.lang.String str) {
        return (short) (com.xiaomi.push.ga.a(context, str, false).d + 0 + (com.xiaomi.push.l.b(context) ? 4 : 0) + (com.xiaomi.push.l.a(context) ? 8 : 0) + (com.xiaomi.push.service.aa.a(context) ? 16 : 0));
    }

    public static <T extends com.xiaomi.push.hw<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new com.xiaomi.push.ia("the message byte is empty.");
        }
        new com.xiaomi.push.hz(new com.xiaomi.push.in.a(bArr.length)).a(t, bArr);
    }

    public static <T extends com.xiaomi.push.hw<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            com.xiaomi.push.ic icVar = new com.xiaomi.push.ic(new com.xiaomi.push.id.a());
            icVar.a.reset();
            t.b(icVar.b);
            return icVar.a.toByteArray();
        } catch (com.xiaomi.push.ia e) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
