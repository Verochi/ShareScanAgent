package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public final class m {
    public static final java.lang.String a = "foldername";
    public static final java.lang.String b = "md5filename";
    public static final java.lang.String c = "nc";
    public static final int d = 259200000;
    private static java.lang.String e = "ResourceManager";
    private java.lang.String f;

    /* renamed from: com.anythink.expressad.videocommon.b.m$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.foundation.g.g.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void a() {
            com.anythink.expressad.foundation.h.m.c(com.anythink.expressad.videocommon.b.m.this.f);
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    public static class a {
        public static com.anythink.expressad.videocommon.b.m a = new com.anythink.expressad.videocommon.b.m((byte) 0);

        private a() {
        }
    }

    private m() {
        this.f = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_RES);
    }

    public /* synthetic */ m(byte b2) {
        this();
    }

    public static com.anythink.expressad.videocommon.b.m a() {
        return com.anythink.expressad.videocommon.b.m.a.a;
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2, java.io.File file) {
        java.lang.String a2 = com.anythink.expressad.foundation.h.m.a(str2, this.f + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(str)));
        return android.text.TextUtils.isEmpty(a2) ? com.anythink.expressad.foundation.h.m.b(file) : a2;
    }

    private void c() {
        this.f = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_RES);
    }

    public final java.lang.String a(java.lang.String str) {
        java.lang.String str2;
        try {
            java.lang.String str3 = this.f + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(str));
            java.util.List<java.lang.String> queryParameters = android.net.Uri.parse(str).getQueryParameters(a);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            java.lang.String str4 = queryParameters.get(0);
            if (android.text.TextUtils.isEmpty(str4)) {
                return null;
            }
            java.lang.String str5 = str3 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str4 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str4 + ".html";
            if (!com.anythink.expressad.foundation.h.m.a(str5)) {
                return null;
            }
            try {
                str2 = str.substring(str.indexOf("?") + 1);
            } catch (java.lang.Exception unused) {
                str2 = "";
            }
            return org.apache.tools.ant.taskdefs.XSLTLiaison.FILE_PROTOCOL_PREFIX + str5 + (android.text.TextUtils.isEmpty(str2) ? "" : "?".concat(java.lang.String.valueOf(str2)));
        } catch (java.lang.Exception e2) {
            if (!com.anythink.expressad.a.a) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public final synchronized java.lang.String a(java.lang.String str, byte[] bArr) {
        java.lang.String message;
        java.lang.String str2 = "unknow exception ";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    java.lang.String str3 = this.f + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(str)) + ".zip";
                    java.io.File file = new java.io.File(str3);
                    if (com.anythink.expressad.foundation.h.m.a(bArr, file)) {
                        android.net.Uri parse = android.net.Uri.parse(str);
                        java.util.List<java.lang.String> queryParameters = parse.getQueryParameters(c);
                        if (queryParameters != null && queryParameters.size() != 0) {
                            str2 = a(str, str3, file);
                        }
                        java.util.List<java.lang.String> queryParameters2 = parse.getQueryParameters(b);
                        if (queryParameters2 != null && queryParameters2.size() > 0) {
                            java.lang.String str4 = queryParameters2.get(0);
                            if (!android.text.TextUtils.isEmpty(str4) && str4.equals(com.anythink.expressad.foundation.h.l.a(file))) {
                                str2 = a(str, str3, file);
                            }
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        com.anythink.expressad.foundation.h.m.b(file);
                    }
                }
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
                message = e2.getMessage();
            }
        }
        message = str2;
        return message;
    }

    public final void b() {
        try {
            if (android.text.TextUtils.isEmpty(this.f)) {
                return;
            }
            com.anythink.expressad.videocommon.b.h.a.a.a(new com.anythink.expressad.videocommon.b.m.AnonymousClass1());
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }
}
