package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class l {
    private static com.xiaomi.push.ek a(com.xiaomi.push.service.c cVar, byte[] bArr) {
        com.xiaomi.push.hh hhVar = new com.xiaomi.push.hh();
        try {
            com.xiaomi.push.hv.a(hhVar, bArr);
            return a(com.xiaomi.push.service.cp.a(cVar), hhVar);
        } catch (com.xiaomi.push.ia e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    private static com.xiaomi.push.ek a(com.xiaomi.push.service.co coVar, com.xiaomi.push.hh hhVar) {
        java.lang.String str;
        java.util.Map<java.lang.String, java.lang.String> map;
        try {
            com.xiaomi.push.ek ekVar = new com.xiaomi.push.ek();
            ekVar.a(5);
            ekVar.b(coVar.a);
            com.xiaomi.push.gx gxVar = hhVar.h;
            if (gxVar != null && (map = gxVar.k) != null) {
                str = map.get("ext_traffic_source_pkg");
                if (!android.text.TextUtils.isEmpty(str)) {
                    ekVar.c = str;
                    ekVar.a("SECMSG", "message");
                    java.lang.String str2 = coVar.a;
                    hhVar.g.b = str2.substring(0, str2.indexOf("@"));
                    hhVar.g.d = str2.substring(str2.indexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1);
                    ekVar.a(com.xiaomi.push.hv.a(hhVar), coVar.c);
                    ekVar.b = (short) 1;
                    com.xiaomi.channel.commonutils.logger.b.a("try send mi push message. packagename:" + hhVar.f + " action:" + hhVar.a);
                    return ekVar;
                }
            }
            str = hhVar.f;
            ekVar.c = str;
            ekVar.a("SECMSG", "message");
            java.lang.String str22 = coVar.a;
            hhVar.g.b = str22.substring(0, str22.indexOf("@"));
            hhVar.g.d = str22.substring(str22.indexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1);
            ekVar.a(com.xiaomi.push.hv.a(hhVar), coVar.c);
            ekVar.b = (short) 1;
            com.xiaomi.channel.commonutils.logger.b.a("try send mi push message. packagename:" + hhVar.f + " action:" + hhVar.a);
            return ekVar;
        } catch (java.lang.NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public static com.xiaomi.push.hh a(java.lang.String str, java.lang.String str2) {
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        hkVar.d = str2;
        hkVar.e = "package uninstalled";
        hkVar.c = com.xiaomi.push.fn.c();
        hkVar.a(false);
        return a(str, str2, hkVar, com.xiaomi.push.gk.Notification);
    }

    public static <T extends com.xiaomi.push.hw<T, ?>> com.xiaomi.push.hh a(java.lang.String str, java.lang.String str2, T t, com.xiaomi.push.gk gkVar) {
        return a(str, str2, t, gkVar, true);
    }

    public static <T extends com.xiaomi.push.hw<T, ?>> com.xiaomi.push.hh a(java.lang.String str, java.lang.String str2, T t, com.xiaomi.push.gk gkVar, boolean z) {
        byte[] a = com.xiaomi.push.hv.a(t);
        com.xiaomi.push.hh hhVar = new com.xiaomi.push.hh();
        com.xiaomi.push.gz gzVar = new com.xiaomi.push.gz();
        gzVar.a = 5L;
        gzVar.b = "fakeid";
        hhVar.g = gzVar;
        hhVar.d = java.nio.ByteBuffer.wrap(a);
        hhVar.a = gkVar;
        hhVar.b(z);
        hhVar.f = str;
        hhVar.a(false);
        hhVar.e = str2;
        return hhVar;
    }

    public static java.lang.String a(java.lang.String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    public static void a(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.cc.a(hhVar.f, cVar.getApplicationContext(), hhVar, -1);
        com.xiaomi.push.ev evVar = cVar.c;
        if (evVar == null) {
            throw new com.xiaomi.push.fh("try send msg while connection is null.");
        }
        if (!evVar.b()) {
            throw new com.xiaomi.push.fh("Don't support XMPP connection.");
        }
        com.xiaomi.push.ek a = a(com.xiaomi.push.service.cp.a(cVar), hhVar);
        if (a != null) {
            evVar.b(a);
        }
    }

    public static void a(com.xiaomi.push.service.c cVar, com.xiaomi.push.service.aj.b bVar) {
        bVar.a((android.os.Messenger) null);
        bVar.a(new com.xiaomi.push.service.o(cVar));
    }

    public static void a(com.xiaomi.push.service.c cVar, java.lang.String str, byte[] bArr) {
        android.content.Context applicationContext = cVar.getApplicationContext();
        if (applicationContext != null && bArr != null && bArr.length > 0) {
            com.xiaomi.push.hh hhVar = new com.xiaomi.push.hh();
            try {
                com.xiaomi.push.hv.a(hhVar, bArr);
                com.xiaomi.push.cc.a(str, applicationContext, hhVar, bArr.length);
            } catch (com.xiaomi.push.ia unused) {
                com.xiaomi.channel.commonutils.logger.b.a("fail to convert bytes to container");
            }
        }
        com.xiaomi.push.ev evVar = cVar.c;
        if (evVar == null) {
            throw new com.xiaomi.push.fh("try send msg while connection is null.");
        }
        if (!evVar.b()) {
            throw new com.xiaomi.push.fh("Don't support XMPP connection.");
        }
        com.xiaomi.push.ek a = a(cVar, bArr);
        if (a != null) {
            evVar.b(a);
        } else {
            com.xiaomi.push.service.cs.a(cVar, str, bArr, com.xiaomi.mipush.sdk.ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }
}
