package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class e implements com.zx.a.I8b7.n0 {
    @Override // com.zx.a.I8b7.n0
    public com.zx.a.I8b7.t1 a(com.zx.a.I8b7.n0.a aVar) throws java.io.IOException {
        boolean z;
        com.zx.a.I8b7.u1 u1Var;
        com.zx.a.I8b7.j1 j1Var = (com.zx.a.I8b7.j1) aVar;
        com.zx.a.I8b7.q1 q1Var = j1Var.c;
        com.zx.a.I8b7.q1.a aVar2 = new com.zx.a.I8b7.q1.a(q1Var);
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) q1Var.a.openConnection();
        com.zx.a.I8b7.s1 s1Var = q1Var.d;
        if (s1Var != null) {
            com.zx.a.I8b7.r1 r1Var = (com.zx.a.I8b7.r1) s1Var;
            com.zx.a.I8b7.x0 x0Var = r1Var.a;
            if (x0Var != null) {
                aVar2.c.put("Content-Type", x0Var.a);
            }
            long j = r1Var.b;
            if (j != -1) {
                aVar2.c.put("Content-Length", java.lang.Long.toString(j));
                aVar2.c.remove("Transfer-Encoding");
            } else {
                aVar2.c.put("Transfer-Encoding", com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED);
                aVar2.c.remove("Content-Length");
            }
        }
        if (q1Var.c.get("Host") == null) {
            aVar2.c.put("Host", q1Var.a.getHost());
        }
        if (q1Var.c.get(com.google.common.net.HttpHeaders.CONNECTION) == null) {
            aVar2.c.put(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
        }
        if (q1Var.c.get(com.google.common.net.HttpHeaders.ACCEPT_ENCODING) == null && q1Var.c.get("Range") == null) {
            aVar2.c.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        } else {
            z = false;
        }
        com.zx.a.I8b7.t1 a = j1Var.a(new com.zx.a.I8b7.q1(aVar2), httpURLConnection);
        com.zx.a.I8b7.t1.a aVar3 = new com.zx.a.I8b7.t1.a(a);
        aVar3.a = q1Var;
        if (z && "gzip".equalsIgnoreCase(a.a("Content-Encoding")) && (u1Var = a.e) != null) {
            aVar3.e = com.zx.a.I8b7.u1.a(((com.zx.a.I8b7.u1.a) u1Var).a, -1L, new java.util.zip.GZIPInputStream(((com.zx.a.I8b7.u1.a) a.e).c));
            aVar3.d.remove("Content-Encoding");
            aVar3.d.remove("Content-Length");
        }
        return aVar3.a();
    }
}
