package com.anythink.expressad.foundation.g.f.f;

/* loaded from: classes12.dex */
public class a implements com.anythink.expressad.foundation.g.f.g {
    private static final java.lang.String a = "a";
    private static final int b = 3000;
    private com.anythink.expressad.foundation.g.f.e.a c;
    private com.anythink.expressad.foundation.g.f.c d;

    public a(com.anythink.expressad.foundation.g.f.e.a aVar, com.anythink.expressad.foundation.g.f.c cVar) {
        this.c = aVar;
        this.d = cVar;
    }

    private static void a(long j, com.anythink.expressad.foundation.g.f.i<?> iVar, byte[] bArr, int i) {
        if (com.anythink.expressad.a.a) {
            java.lang.Object obj = com.igexin.push.core.b.m;
            if (j > 3000) {
                try {
                    java.lang.Object[] objArr = new java.lang.Object[6];
                    objArr[0] = iVar.d();
                    objArr[1] = java.lang.Integer.valueOf(iVar.a());
                    objArr[2] = java.lang.Long.valueOf(j);
                    if (bArr != null) {
                        obj = java.lang.Integer.valueOf(bArr.length);
                    }
                    objArr[3] = obj;
                    objArr[4] = java.lang.Integer.valueOf(i);
                    objArr[5] = java.lang.Integer.valueOf(iVar.l().c());
                    java.lang.String.format("Slow HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", objArr);
                    return;
                } catch (java.lang.Exception unused) {
                    return;
                }
            }
            try {
                java.lang.Object[] objArr2 = new java.lang.Object[6];
                objArr2[0] = iVar.d();
                objArr2[1] = java.lang.Integer.valueOf(iVar.a());
                objArr2[2] = java.lang.Long.valueOf(j);
                if (bArr != null) {
                    obj = java.lang.Integer.valueOf(bArr.length);
                }
                objArr2[3] = obj;
                objArr2[4] = java.lang.Integer.valueOf(i);
                objArr2[5] = java.lang.Integer.valueOf(iVar.l().c());
                java.lang.String.format("Normal HTTP response for request=<%s> [method=%s] [lifetime=%d], [size=%s], [statusCode=%d], [retryCount=%s]", objArr2);
            } catch (java.lang.Exception unused2) {
            }
        }
    }

    private void a(com.anythink.expressad.foundation.g.f.i<?> iVar, com.anythink.expressad.foundation.g.f.a.a aVar) {
        if (!iVar.l().d()) {
            throw aVar;
        }
        this.d.e(iVar);
    }

    private static void a(java.lang.String str, long j, com.anythink.expressad.foundation.g.f.i<?> iVar) {
        if (com.anythink.expressad.a.a) {
            try {
                java.lang.Object[] objArr = new java.lang.Object[4];
                objArr[0] = iVar.d();
                objArr[1] = java.lang.Long.valueOf(j);
                if (str == null) {
                    str = com.igexin.push.core.b.m;
                }
                objArr[2] = str;
                objArr[3] = java.lang.Integer.valueOf(iVar.l().c());
                java.lang.String.format("HTTP exception for request=<%s> [lifetime=%d], [size=%s], [retryCount=%s]", objArr);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0273 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7  */
    @Override // com.anythink.expressad.foundation.g.f.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.anythink.expressad.foundation.g.f.f.c a(com.anythink.expressad.foundation.g.f.i<?> iVar) {
        java.lang.String str;
        com.anythink.expressad.foundation.g.f.f.b bVar;
        byte[] bArr;
        int a2;
        java.lang.String str2;
        com.anythink.expressad.foundation.g.f.f.b bVar2;
        byte[] bArr2;
        int a3;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        com.anythink.expressad.foundation.g.f.l l = iVar != null ? iVar.l() : null;
        java.lang.String str3 = "SocketTimeoutException ex= ";
        if ((l != null ? l.a() : 0) > 0) {
            while (!iVar.f()) {
                try {
                    try {
                        try {
                            iVar.i();
                            bVar = this.c.a(iVar);
                        } catch (java.io.IOException e) {
                            e = e;
                            str = str3;
                            bVar = null;
                        }
                        try {
                            a2 = bVar.a();
                            bArr = iVar.a(bVar, this.d);
                            try {
                                str = str3;
                            } catch (java.io.IOException e2) {
                                e = e2;
                                str = str3;
                            }
                        } catch (java.io.IOException e3) {
                            e = e3;
                            str = str3;
                            bArr = null;
                            a("IOException ex= " + e.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                            if (bVar != null) {
                                throw new com.anythink.expressad.foundation.g.f.a.a(14, null);
                            }
                            int a4 = bVar.a();
                            if (bArr != null) {
                                com.anythink.expressad.foundation.g.f.f.c cVar = new com.anythink.expressad.foundation.g.f.f.c(a4, bArr, bVar.b());
                                if (a4 >= 400 && a4 <= 499) {
                                    throw new com.anythink.expressad.foundation.g.f.a.a(6, cVar);
                                }
                                if (a4 < 500 || a4 > 599) {
                                    throw new com.anythink.expressad.foundation.g.f.a.a(2, cVar);
                                }
                                throw new com.anythink.expressad.foundation.g.f.a.a(7, cVar);
                            }
                            com.anythink.expressad.foundation.g.f.a.a aVar = new com.anythink.expressad.foundation.g.f.a.a(15, null);
                            if (!iVar.l().d()) {
                                throw aVar;
                            }
                            this.d.e(iVar);
                            str3 = str;
                        }
                    } catch (java.net.SocketTimeoutException e4) {
                        e = e4;
                        str = str3;
                    }
                    try {
                        a(android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar, bArr, a2);
                        if (a2 < 200 || a2 > 399) {
                            throw new java.io.IOException();
                        }
                        return new com.anythink.expressad.foundation.g.f.f.c(a2, bArr, bVar.b());
                    } catch (java.net.SocketTimeoutException e5) {
                        e = e5;
                        a(str + e.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                        throw new com.anythink.expressad.foundation.g.f.a.a(10, null);
                    } catch (java.io.IOException e6) {
                        e = e6;
                        a("IOException ex= " + e.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                        if (bVar != null) {
                        }
                    }
                } catch (java.net.ConnectException e7) {
                    a("ConnectException ex= " + e7.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(12, null);
                } catch (java.net.MalformedURLException e8) {
                    a("MalformedURLException ex= " + e8.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(4, null);
                } catch (java.net.UnknownHostException e9) {
                    a("UnknownHostException ex= " + e9.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(9, null);
                } catch (javax.net.ssl.SSLProtocolException e10) {
                    a("SSLProtocolException ex= " + e10.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(11, null);
                } catch (org.apache.http.conn.ConnectTimeoutException e11) {
                    a("ConnectTimeoutException ex= " + e11.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                    throw new com.anythink.expressad.foundation.g.f.a.a(3, null);
                }
            }
            iVar.c();
            this.d.b(iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(-2, null);
        }
        if (iVar.f()) {
            iVar.c();
            this.d.b(iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(-2, null);
        }
        try {
            try {
                try {
                    iVar.i();
                    bVar2 = this.c.a(iVar);
                } catch (java.io.IOException e12) {
                    e = e12;
                    bVar2 = null;
                }
                try {
                    a3 = bVar2.a();
                    bArr2 = iVar.a(bVar2, this.d);
                } catch (java.io.IOException e13) {
                    e = e13;
                    bArr2 = null;
                    a("IOException ex= " + e.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                    if (bVar2 != null) {
                        throw new com.anythink.expressad.foundation.g.f.a.a(14, null);
                    }
                    int a5 = bVar2.a();
                    if (bArr2 == null) {
                        throw new com.anythink.expressad.foundation.g.f.a.a(15, null);
                    }
                    com.anythink.expressad.foundation.g.f.f.c cVar2 = new com.anythink.expressad.foundation.g.f.f.c(a5, bArr2, bVar2.b());
                    if (a5 >= 400 && a5 <= 499) {
                        throw new com.anythink.expressad.foundation.g.f.a.a(6, cVar2);
                    }
                    if (a5 < 500 || a5 > 599) {
                        throw new com.anythink.expressad.foundation.g.f.a.a(2, cVar2);
                    }
                    throw new com.anythink.expressad.foundation.g.f.a.a(7, cVar2);
                }
                try {
                    str2 = "ConnectTimeoutException ex= ";
                    try {
                        a(android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar, bArr2, a3);
                        if (a3 < 200 || a3 > 399) {
                            throw new java.io.IOException();
                        }
                        return new com.anythink.expressad.foundation.g.f.f.c(a3, bArr2, bVar2.b());
                    } catch (org.apache.http.conn.ConnectTimeoutException e14) {
                        e = e14;
                        a(str2 + e.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                        throw new com.anythink.expressad.foundation.g.f.a.a(3, null);
                    }
                } catch (java.io.IOException e15) {
                    e = e15;
                    a("IOException ex= " + e.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
                    if (bVar2 != null) {
                    }
                }
            } catch (org.apache.http.conn.ConnectTimeoutException e16) {
                e = e16;
                str2 = "ConnectTimeoutException ex= ";
            }
        } catch (java.net.ConnectException e17) {
            a("ConnectException ex= " + e17.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(12, null);
        } catch (java.net.MalformedURLException e18) {
            a("MalformedURLException ex= " + e18.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(4, null);
        } catch (java.net.SocketTimeoutException e19) {
            a("SocketTimeoutException ex= " + e19.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(10, null);
        } catch (java.net.UnknownHostException e20) {
            a("UnknownHostException ex= " + e20.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(9, null);
        } catch (javax.net.ssl.SSLProtocolException e21) {
            a("SSLProtocolException ex= " + e21.getMessage(), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, iVar);
            throw new com.anythink.expressad.foundation.g.f.a.a(11, null);
        }
    }
}
