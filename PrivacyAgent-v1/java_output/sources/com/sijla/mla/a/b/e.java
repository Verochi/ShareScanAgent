package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class e extends com.sijla.mla.a.b.s {
    private static final java.util.ArrayList<java.lang.String> b;
    private com.sijla.mla.a.b a;

    public static class a extends com.sijla.mla.a.b.t {
        public a(java.lang.String str) {
            this.e = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: Exception -> 0x00a8, TryCatch #0 {Exception -> 0x00a8, blocks: (B:2:0x0000, B:10:0x002c, B:13:0x002f, B:15:0x0049, B:17:0x0051, B:21:0x006e, B:25:0x007d, B:26:0x0085, B:27:0x0092, B:29:0x0089, B:30:0x006c, B:31:0x0013, B:34:0x001d), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x006c A[Catch: Exception -> 0x00a8, TryCatch #0 {Exception -> 0x00a8, blocks: (B:2:0x0000, B:10:0x002c, B:13:0x002f, B:15:0x0049, B:17:0x0051, B:21:0x006e, B:25:0x007d, B:26:0x0085, B:27:0x0092, B:29:0x0089, B:30:0x006c, B:31:0x0013, B:34:0x001d), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[ADDED_TO_REGION] */
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            char c;
            com.sijla.mla.a.o q;
            com.sijla.mla.a.n a;
            java.net.HttpURLConnection a2;
            int responseCode;
            java.io.InputStream errorStream;
            byte[] a3;
            try {
                java.lang.String str = this.e;
                int hashCode = str.hashCode();
                if (hashCode == 102230) {
                    if (str.equals(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                        c = 0;
                        if (c == 0) {
                        }
                        java.lang.String str2 = this.e;
                        java.lang.String v = yVar.v(1);
                        q = yVar.q(2);
                        byte[] bArr = null;
                        a = yVar.a(3, (com.sijla.mla.a.n) null);
                        com.sijla.h.c.a.a();
                        a2 = com.sijla.h.c.a.a(v);
                        if (q != null) {
                        }
                        if (a == null) {
                        }
                        com.sijla.h.c.a.a(a2, str2, bArr);
                        responseCode = a2.getResponseCode();
                        if (responseCode >= 200) {
                        }
                        errorStream = a2.getErrorStream();
                        a3 = com.sijla.c.a.a(errorStream);
                        errorStream.close();
                        a2.disconnect();
                        return com.sijla.mla.a.r.a(new com.sijla.mla.a.r[]{com.sijla.mla.a.k.c_(responseCode), com.sijla.mla.a.n.a(a3)});
                    }
                    c = 65535;
                    if (c == 0) {
                    }
                    java.lang.String str22 = this.e;
                    java.lang.String v2 = yVar.v(1);
                    q = yVar.q(2);
                    byte[] bArr2 = null;
                    a = yVar.a(3, (com.sijla.mla.a.n) null);
                    com.sijla.h.c.a.a();
                    a2 = com.sijla.h.c.a.a(v2);
                    if (q != null) {
                    }
                    if (a == null) {
                    }
                    com.sijla.h.c.a.a(a2, str22, bArr2);
                    responseCode = a2.getResponseCode();
                    if (responseCode >= 200) {
                    }
                    errorStream = a2.getErrorStream();
                    a3 = com.sijla.c.a.a(errorStream);
                    errorStream.close();
                    a2.disconnect();
                    return com.sijla.mla.a.r.a(new com.sijla.mla.a.r[]{com.sijla.mla.a.k.c_(responseCode), com.sijla.mla.a.n.a(a3)});
                }
                if (hashCode == 3446944 && str.equals("post")) {
                    c = 1;
                    if (c == 0 && c != 1) {
                        return com.sijla.mla.a.r.n;
                    }
                    java.lang.String str222 = this.e;
                    java.lang.String v22 = yVar.v(1);
                    q = yVar.q(2);
                    byte[] bArr22 = null;
                    a = yVar.a(3, (com.sijla.mla.a.n) null);
                    com.sijla.h.c.a.a();
                    a2 = com.sijla.h.c.a.a(v22);
                    if (q != null) {
                        for (com.sijla.mla.a.r rVar : q.g_()) {
                            a2.setRequestProperty(rVar.g(), q.a(rVar).C().g());
                        }
                    }
                    if (a == null) {
                        bArr22 = a.b;
                    }
                    com.sijla.h.c.a.a(a2, str222, bArr22);
                    responseCode = a2.getResponseCode();
                    if (responseCode >= 200 || responseCode >= 400) {
                        errorStream = a2.getErrorStream();
                        a3 = com.sijla.c.a.a(errorStream);
                    } else {
                        errorStream = a2.getInputStream();
                        a3 = com.sijla.c.a.a(errorStream);
                    }
                    errorStream.close();
                    a2.disconnect();
                    return com.sijla.mla.a.r.a(new com.sijla.mla.a.r[]{com.sijla.mla.a.k.c_(responseCode), com.sijla.mla.a.n.a(a3)});
                }
                c = 65535;
                if (c == 0) {
                }
                java.lang.String str2222 = this.e;
                java.lang.String v222 = yVar.v(1);
                q = yVar.q(2);
                byte[] bArr222 = null;
                a = yVar.a(3, (com.sijla.mla.a.n) null);
                com.sijla.h.c.a.a();
                a2 = com.sijla.h.c.a.a(v222);
                if (q != null) {
                }
                if (a == null) {
                }
                com.sijla.h.c.a.a(a2, str2222, bArr222);
                responseCode = a2.getResponseCode();
                if (responseCode >= 200) {
                }
                errorStream = a2.getErrorStream();
                a3 = com.sijla.c.a.a(errorStream);
                errorStream.close();
                a2.disconnect();
                return com.sijla.mla.a.r.a(new com.sijla.mla.a.r[]{com.sijla.mla.a.k.c_(responseCode), com.sijla.mla.a.n.a(a3)});
            } catch (java.lang.Exception e) {
                return com.sijla.mla.a.r.a(com.sijla.mla.a.r.k, (com.sijla.mla.a.y) com.sijla.mla.a.n.c(e.getMessage()));
            }
        }
    }

    static {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        b = arrayList;
        arrayList.add(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET);
        arrayList.add("post");
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        this.a = rVar2.a();
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        int i = 0;
        while (true) {
            java.util.ArrayList<java.lang.String> arrayList = b;
            if (i >= arrayList.size()) {
                rVar2.a(com.alipay.sdk.m.l.a.q, oVar);
                rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a(com.alipay.sdk.m.l.a.q, oVar);
                return oVar;
            }
            java.lang.String str = arrayList.get(i);
            oVar.a(str, new com.sijla.mla.a.b.e.a(str));
            i++;
        }
    }
}
