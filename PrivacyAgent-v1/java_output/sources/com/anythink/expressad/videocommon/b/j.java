package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public final class j {
    public static final int a = 259200000;
    private static final java.lang.String b = "HTMLResourceManager";
    private java.lang.String c;

    /* renamed from: com.anythink.expressad.videocommon.b.j$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.foundation.g.g.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void a() {
            com.anythink.expressad.foundation.h.m.c(com.anythink.expressad.videocommon.b.j.this.c);
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    public static class a {
        public static com.anythink.expressad.videocommon.b.j a = new com.anythink.expressad.videocommon.b.j((byte) 0);

        private a() {
        }
    }

    private j() {
        this.c = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
    }

    public /* synthetic */ j(byte b2) {
        this();
    }

    public static com.anythink.expressad.videocommon.b.j a() {
        return com.anythink.expressad.videocommon.b.j.a.a;
    }

    private void c() {
        this.c = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
    }

    public final java.lang.String a(java.lang.String str) {
        try {
            java.lang.String str2 = this.c + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(str)) + ".html";
            if (new java.io.File(str2).exists()) {
                return "file:////".concat(java.lang.String.valueOf(str2));
            }
            return null;
        } catch (java.lang.Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final boolean a(java.lang.String str, byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            if (bArr.length <= 0) {
                return false;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.c);
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            sb.append(com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(str)));
            sb.append(".html");
            return com.anythink.expressad.foundation.h.m.a(bArr, new java.io.File(sb.toString()));
        } catch (java.lang.Exception e) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public final java.lang.String b(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(this.c + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(str)) + ".html");
            if (file.length() > 0) {
                return com.anythink.expressad.foundation.h.m.a(file);
            }
            return null;
        } catch (java.lang.Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final void b() {
        try {
            if (android.text.TextUtils.isEmpty(this.c)) {
                return;
            }
            com.anythink.expressad.videocommon.b.h.a.a.a(new com.anythink.expressad.videocommon.b.j.AnonymousClass1());
        } catch (java.lang.Exception e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        }
    }
}
