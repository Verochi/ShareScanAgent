package com.anythink.china.common.a;

/* loaded from: classes12.dex */
public abstract class a {
    public static final java.lang.String e = ".temp";
    public static final java.lang.String f = ".log";
    public static final java.lang.String g = ".apk";
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    private static final java.lang.String u = "a";
    protected java.lang.String a;
    protected java.lang.String b;
    protected boolean c;
    protected boolean d;
    public int m = 0;
    protected long n;
    protected long o;
    protected long p;
    protected long q;
    protected long r;

    /* renamed from: s, reason: collision with root package name */
    protected long f156s;
    protected long t;
    private com.anythink.china.common.a.a.InterfaceC0157a v;
    private com.anythink.china.common.a.e w;
    private java.lang.String x;

    /* renamed from: com.anythink.china.common.a.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.core.common.o.b.d {
        public AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v8 */
        private void b(java.lang.String str) {
            java.lang.Exception e;
            java.net.HttpURLConnection httpURLConnection;
            java.lang.Error e2;
            java.lang.StackOverflowError e3;
            java.lang.OutOfMemoryError e4;
            com.anythink.china.common.a.a.this.o = java.lang.System.currentTimeMillis();
            com.anythink.china.common.a.a.this.p = android.os.SystemClock.elapsedRealtime();
            ?? r2 = 0;
            java.net.HttpURLConnection httpURLConnection2 = null;
            java.net.HttpURLConnection httpURLConnection3 = null;
            try {
                try {
                    try {
                        java.lang.String unused = com.anythink.china.common.a.a.u;
                        httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                        try {
                            httpURLConnection.setInstanceFollowRedirects(false);
                            if (com.anythink.china.common.a.a.this.w.o) {
                                java.lang.String i = com.anythink.core.common.o.e.i();
                                if (!android.text.TextUtils.isEmpty(i)) {
                                    httpURLConnection.addRequestProperty("User-Agent", i);
                                }
                            }
                            com.anythink.china.common.a.a aVar = com.anythink.china.common.a.a.this;
                            if (aVar.n > 0) {
                                java.lang.String unused2 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a aVar2 = com.anythink.china.common.a.a.this;
                                long j = aVar2.n;
                                long j2 = aVar2.f156s;
                                httpURLConnection.setRequestProperty("Range", "bytes=" + com.anythink.china.common.a.a.this.n + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            } else {
                                aVar.f156s = httpURLConnection.getContentLength();
                            }
                            com.anythink.china.common.a.a aVar3 = com.anythink.china.common.a.a.this;
                            if (aVar3.f156s <= 0) {
                                java.lang.String unused3 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", "downloadSize <= 0"));
                                httpURLConnection.disconnect();
                                return;
                            }
                            if (aVar3.c) {
                                if (aVar3.w != null) {
                                    com.anythink.china.common.a.a.this.w.j();
                                }
                                com.anythink.china.common.a.a aVar4 = com.anythink.china.common.a.a.this;
                                aVar4.m = 3;
                                aVar4.d();
                                httpURLConnection.disconnect();
                                return;
                            }
                            httpURLConnection.setConnectTimeout(60000);
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode != 200 && responseCode != 206) {
                                java.lang.String unused4 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10001", httpURLConnection.getResponseMessage()));
                                httpURLConnection.disconnect();
                                return;
                            }
                            com.anythink.china.common.a.a aVar5 = com.anythink.china.common.a.a.this;
                            if (aVar5.c) {
                                if (aVar5.w != null) {
                                    com.anythink.china.common.a.a.this.w.j();
                                }
                                com.anythink.china.common.a.a aVar6 = com.anythink.china.common.a.a.this;
                                aVar6.m = 3;
                                aVar6.d();
                                httpURLConnection.disconnect();
                                return;
                            }
                            java.io.InputStream inputStream = httpURLConnection.getInputStream();
                            if (com.anythink.china.common.a.a.this.w != null) {
                                com.anythink.china.common.a.a.this.w.i();
                            }
                            com.anythink.china.common.a.e eVar = com.anythink.china.common.a.a.this.w;
                            com.anythink.china.common.a.a aVar7 = com.anythink.china.common.a.a.this;
                            eVar.h = aVar7.f156s;
                            if (aVar7.v != null) {
                                com.anythink.china.common.a.a.InterfaceC0157a interfaceC0157a = com.anythink.china.common.a.a.this.v;
                                com.anythink.china.common.a.e eVar2 = com.anythink.china.common.a.a.this.w;
                                com.anythink.china.common.a.a aVar8 = com.anythink.china.common.a.a.this;
                                interfaceC0157a.a(eVar2, aVar8.n, aVar8.f156s);
                            }
                            com.anythink.china.common.a.a aVar9 = com.anythink.china.common.a.a.this;
                            int a = aVar9.a(aVar9.b, inputStream);
                            com.anythink.china.common.a.a.this.m = a;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            com.anythink.china.common.a.a.this.q = java.lang.System.currentTimeMillis();
                            com.anythink.china.common.a.a.this.r = android.os.SystemClock.elapsedRealtime();
                            com.anythink.china.common.a.e eVar3 = com.anythink.china.common.a.a.this.w;
                            com.anythink.china.common.a.a aVar10 = com.anythink.china.common.a.a.this;
                            eVar3.i = aVar10.r - aVar10.p;
                            if (a == 1) {
                                java.lang.String unused5 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a aVar11 = com.anythink.china.common.a.a.this;
                                java.lang.String str2 = aVar11.a;
                                aVar11.e();
                            } else if (a == 2 || a == 3) {
                                aVar10.d();
                            } else {
                                java.lang.String unused6 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a aVar12 = com.anythink.china.common.a.a.this;
                                java.lang.String str3 = aVar12.a;
                                aVar12.b(com.anythink.china.common.a.c.a("10000", "Save fail!(" + com.anythink.china.common.a.a.this.x + ")"));
                            }
                            httpURLConnection.disconnect();
                        } catch (java.lang.OutOfMemoryError e5) {
                            e4 = e5;
                            java.lang.System.gc();
                            java.lang.String unused7 = com.anythink.china.common.a.a.u;
                            e4.getMessage();
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", e4.getMessage() != null ? e4.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.lang.StackOverflowError e6) {
                            e3 = e6;
                            java.lang.System.gc();
                            java.lang.String unused8 = com.anythink.china.common.a.a.u;
                            e3.getMessage();
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", e3.getMessage() != null ? e3.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.lang.Error e7) {
                            e2 = e7;
                            java.lang.System.gc();
                            java.lang.String unused9 = com.anythink.china.common.a.a.u;
                            e2.getMessage();
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", e2.getMessage() != null ? e2.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.net.SocketTimeoutException e8) {
                            e = e8;
                            httpURLConnection2 = httpURLConnection;
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("20001", e.getMessage()));
                            java.lang.String unused10 = com.anythink.china.common.a.a.u;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (org.apache.http.conn.ConnectTimeoutException e9) {
                            e = e9;
                            httpURLConnection3 = httpURLConnection;
                            com.anythink.china.common.a.a.this.a(e);
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                        } catch (java.lang.Exception e10) {
                            e = e10;
                            java.lang.String unused11 = com.anythink.china.common.a.a.u;
                            e.getMessage();
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r2 = str;
                        if (r2 != 0) {
                            r2.disconnect();
                        }
                        throw th;
                    }
                } catch (java.lang.OutOfMemoryError e11) {
                    e4 = e11;
                    httpURLConnection = null;
                } catch (java.lang.StackOverflowError e12) {
                    e3 = e12;
                    httpURLConnection = null;
                } catch (java.lang.Error e13) {
                    e2 = e13;
                    httpURLConnection = null;
                } catch (java.net.SocketTimeoutException e14) {
                    e = e14;
                } catch (org.apache.http.conn.ConnectTimeoutException e15) {
                    e = e15;
                } catch (java.lang.Exception e16) {
                    e = e16;
                    httpURLConnection = null;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0296 A[Catch: Exception -> 0x029a, StackOverflowError -> 0x02b5, OutOfMemoryError -> 0x02b7, TryCatch #13 {Exception -> 0x029a, OutOfMemoryError -> 0x02b7, StackOverflowError -> 0x02b5, blocks: (B:3:0x000b, B:20:0x0099, B:29:0x00b8, B:37:0x00e3, B:45:0x0103, B:62:0x01b1, B:115:0x01ec, B:93:0x0214, B:83:0x023c, B:73:0x0264, B:106:0x0273, B:100:0x028f, B:122:0x0296, B:123:0x0299), top: B:2:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:147:0x02c7  */
        /* JADX WARN: Type inference failed for: r3v18, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v5 */
        @Override // com.anythink.core.common.o.b.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            java.lang.Throwable th;
            java.net.HttpURLConnection httpURLConnection;
            java.lang.Exception e;
            org.apache.http.conn.ConnectTimeoutException e2;
            java.net.SocketTimeoutException e3;
            java.lang.Error e4;
            java.lang.StackOverflowError e5;
            java.lang.OutOfMemoryError e6;
            java.lang.String unused = com.anythink.china.common.a.a.u;
            com.anythink.china.common.a.a aVar = com.anythink.china.common.a.a.this;
            java.lang.String str = aVar.a;
            try {
                com.anythink.china.common.a.a.a(aVar);
                com.anythink.china.common.a.a aVar2 = com.anythink.china.common.a.a.this;
                ?? r3 = aVar2.a;
                aVar2.o = java.lang.System.currentTimeMillis();
                com.anythink.china.common.a.a.this.p = android.os.SystemClock.elapsedRealtime();
                try {
                    try {
                        java.lang.String unused2 = com.anythink.china.common.a.a.u;
                        httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(r3).openConnection();
                        try {
                            httpURLConnection.setInstanceFollowRedirects(false);
                            if (com.anythink.china.common.a.a.this.w.o) {
                                java.lang.String i = com.anythink.core.common.o.e.i();
                                if (!android.text.TextUtils.isEmpty(i)) {
                                    httpURLConnection.addRequestProperty("User-Agent", i);
                                }
                            }
                            com.anythink.china.common.a.a aVar3 = com.anythink.china.common.a.a.this;
                            if (aVar3.n > 0) {
                                java.lang.String unused3 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a aVar4 = com.anythink.china.common.a.a.this;
                                long j = aVar4.n;
                                long j2 = aVar4.f156s;
                                httpURLConnection.setRequestProperty("Range", "bytes=" + com.anythink.china.common.a.a.this.n + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            } else {
                                aVar3.f156s = httpURLConnection.getContentLength();
                            }
                            com.anythink.china.common.a.a aVar5 = com.anythink.china.common.a.a.this;
                            if (aVar5.f156s <= 0) {
                                java.lang.String unused4 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", "downloadSize <= 0"));
                                httpURLConnection.disconnect();
                                return;
                            }
                            if (aVar5.c) {
                                if (aVar5.w != null) {
                                    com.anythink.china.common.a.a.this.w.j();
                                }
                                com.anythink.china.common.a.a aVar6 = com.anythink.china.common.a.a.this;
                                aVar6.m = 3;
                                aVar6.d();
                                httpURLConnection.disconnect();
                                return;
                            }
                            httpURLConnection.setConnectTimeout(60000);
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode != 200 && responseCode != 206) {
                                java.lang.String unused5 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10001", httpURLConnection.getResponseMessage()));
                                httpURLConnection.disconnect();
                                return;
                            }
                            com.anythink.china.common.a.a aVar7 = com.anythink.china.common.a.a.this;
                            if (aVar7.c) {
                                if (aVar7.w != null) {
                                    com.anythink.china.common.a.a.this.w.j();
                                }
                                com.anythink.china.common.a.a aVar8 = com.anythink.china.common.a.a.this;
                                aVar8.m = 3;
                                aVar8.d();
                                httpURLConnection.disconnect();
                                return;
                            }
                            java.io.InputStream inputStream = httpURLConnection.getInputStream();
                            if (com.anythink.china.common.a.a.this.w != null) {
                                com.anythink.china.common.a.a.this.w.i();
                            }
                            com.anythink.china.common.a.e eVar = com.anythink.china.common.a.a.this.w;
                            com.anythink.china.common.a.a aVar9 = com.anythink.china.common.a.a.this;
                            eVar.h = aVar9.f156s;
                            if (aVar9.v != null) {
                                com.anythink.china.common.a.a.InterfaceC0157a interfaceC0157a = com.anythink.china.common.a.a.this.v;
                                com.anythink.china.common.a.e eVar2 = com.anythink.china.common.a.a.this.w;
                                com.anythink.china.common.a.a aVar10 = com.anythink.china.common.a.a.this;
                                interfaceC0157a.a(eVar2, aVar10.n, aVar10.f156s);
                            }
                            com.anythink.china.common.a.a aVar11 = com.anythink.china.common.a.a.this;
                            int a = aVar11.a(aVar11.b, inputStream);
                            com.anythink.china.common.a.a.this.m = a;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            com.anythink.china.common.a.a.this.q = java.lang.System.currentTimeMillis();
                            com.anythink.china.common.a.a.this.r = android.os.SystemClock.elapsedRealtime();
                            com.anythink.china.common.a.e eVar3 = com.anythink.china.common.a.a.this.w;
                            com.anythink.china.common.a.a aVar12 = com.anythink.china.common.a.a.this;
                            eVar3.i = aVar12.r - aVar12.p;
                            if (a == 1) {
                                java.lang.String unused6 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a aVar13 = com.anythink.china.common.a.a.this;
                                java.lang.String str2 = aVar13.a;
                                aVar13.e();
                            } else if (a == 2 || a == 3) {
                                aVar12.d();
                            } else {
                                java.lang.String unused7 = com.anythink.china.common.a.a.u;
                                com.anythink.china.common.a.a aVar14 = com.anythink.china.common.a.a.this;
                                java.lang.String str3 = aVar14.a;
                                aVar14.b(com.anythink.china.common.a.c.a("10000", "Save fail!(" + com.anythink.china.common.a.a.this.x + ")"));
                            }
                            httpURLConnection.disconnect();
                        } catch (java.lang.OutOfMemoryError e7) {
                            e6 = e7;
                            java.lang.System.gc();
                            java.lang.String unused8 = com.anythink.china.common.a.a.u;
                            e6.getMessage();
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", e6.getMessage() != null ? e6.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.lang.StackOverflowError e8) {
                            e5 = e8;
                            java.lang.System.gc();
                            java.lang.String unused9 = com.anythink.china.common.a.a.u;
                            e5.getMessage();
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", e5.getMessage() != null ? e5.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.lang.Error e9) {
                            e4 = e9;
                            java.lang.System.gc();
                            java.lang.String unused10 = com.anythink.china.common.a.a.u;
                            e4.getMessage();
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", e4.getMessage() != null ? e4.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.net.SocketTimeoutException e10) {
                            e3 = e10;
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("20001", e3.getMessage()));
                            java.lang.String unused11 = com.anythink.china.common.a.a.u;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (org.apache.http.conn.ConnectTimeoutException e11) {
                            e2 = e11;
                            com.anythink.china.common.a.a.this.a(e2);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (java.lang.Exception e12) {
                            e = e12;
                            java.lang.String unused12 = com.anythink.china.common.a.a.u;
                            e.getMessage();
                            com.anythink.china.common.a.a.this.a(com.anythink.china.common.a.c.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (r3 != 0) {
                            r3.disconnect();
                        }
                        throw th;
                    }
                } catch (java.lang.OutOfMemoryError e13) {
                    httpURLConnection = null;
                    e6 = e13;
                } catch (java.lang.StackOverflowError e14) {
                    httpURLConnection = null;
                    e5 = e14;
                } catch (java.lang.Error e15) {
                    httpURLConnection = null;
                    e4 = e15;
                } catch (java.net.SocketTimeoutException e16) {
                    httpURLConnection = null;
                    e3 = e16;
                } catch (org.apache.http.conn.ConnectTimeoutException e17) {
                    httpURLConnection = null;
                    e2 = e17;
                } catch (java.lang.Exception e18) {
                    httpURLConnection = null;
                    e = e18;
                } catch (java.lang.Throwable th3) {
                    r3 = 0;
                    th = th3;
                    if (r3 != 0) {
                    }
                    throw th;
                }
            } catch (java.lang.Exception e19) {
                java.lang.String unused13 = com.anythink.china.common.a.a.u;
                e19.getMessage();
                com.anythink.china.common.a.a.this.b(com.anythink.china.common.a.c.a("10000", e19.getMessage() != null ? e19.getMessage() : "Http connect error!"));
            } catch (java.lang.OutOfMemoryError e20) {
                e = e20;
                java.lang.System.gc();
                java.lang.String unused14 = com.anythink.china.common.a.a.u;
                e.getMessage();
                com.anythink.china.common.a.a.this.b(com.anythink.china.common.a.c.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
            } catch (java.lang.StackOverflowError e21) {
                e = e21;
                java.lang.System.gc();
                java.lang.String unused142 = com.anythink.china.common.a.a.u;
                e.getMessage();
                com.anythink.china.common.a.a.this.b(com.anythink.china.common.a.c.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
            }
        }
    }

    /* renamed from: com.anythink.china.common.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0157a {
        void a(com.anythink.china.common.a.e eVar, long j);

        void a(com.anythink.china.common.a.e eVar, long j, long j2);

        void a(com.anythink.china.common.a.e eVar, long j, long j2, int i);

        void a(com.anythink.china.common.a.e eVar, java.lang.String str);

        void b(com.anythink.china.common.a.e eVar, long j, long j2);
    }

    public a(com.anythink.china.common.a.e eVar) {
        this.w = eVar;
        this.a = eVar.b;
        this.b = eVar.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(java.lang.String str, java.io.InputStream inputStream) {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.String a = com.anythink.china.common.c.b.a(str);
        if (android.text.TextUtils.isEmpty(a)) {
            return 4;
        }
        java.io.File file = new java.io.File(a + e);
        java.io.File file2 = new java.io.File(a + f);
        java.io.RandomAccessFile randomAccessFile2 = null;
        try {
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
                boolean createNewFile2 = file2.createNewFile();
                if (!createNewFile || !createNewFile2) {
                    return 4;
                }
            }
            java.io.RandomAccessFile randomAccessFile3 = new java.io.RandomAccessFile(file, "rws");
            try {
                randomAccessFile = new java.io.RandomAccessFile(file2, "rws");
                try {
                    long j2 = 0;
                    if (this.n > 0) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
                        sb.append(this.w.c);
                        sb.append(")  seek to -> ");
                        sb.append(this.n);
                        randomAccessFile3.seek(this.n);
                    } else {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("(");
                        sb2.append(this.w.c);
                        sb2.append(")  set temp file size -> ");
                        sb2.append(this.f156s);
                        randomAccessFile3.setLength(this.f156s);
                    }
                    byte[] bArr = new byte[1048576];
                    this.t = this.n;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (-1 == read) {
                            file.renameTo(new java.io.File(a + g));
                            if (file2.exists()) {
                                file2.delete();
                            }
                            com.anythink.china.common.a.e eVar = this.w;
                            if (eVar != null) {
                                eVar.l();
                            }
                            try {
                                randomAccessFile3.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                randomAccessFile.close();
                                return 1;
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                                return 1;
                            }
                        }
                        if (this.d) {
                            com.anythink.china.common.a.e eVar2 = this.w;
                            if (eVar2 != null) {
                                eVar2.k();
                            }
                            try {
                                randomAccessFile3.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                            try {
                                randomAccessFile.close();
                                return 2;
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                                return 2;
                            }
                        }
                        if (this.c) {
                            com.anythink.china.common.a.e eVar3 = this.w;
                            if (eVar3 != null) {
                                eVar3.j();
                            }
                            try {
                                randomAccessFile3.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                            }
                            try {
                                randomAccessFile.close();
                                return 3;
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                                return 3;
                            }
                        }
                        randomAccessFile3.write(bArr, 0, read);
                        long j3 = this.t + read;
                        this.t = j3;
                        com.anythink.china.common.a.e eVar4 = this.w;
                        if (eVar4 != null) {
                            eVar4.g = j3;
                        }
                        randomAccessFile.setLength(j2);
                        randomAccessFile.write(java.lang.String.valueOf(this.t).getBytes());
                        com.anythink.china.common.a.a.InterfaceC0157a interfaceC0157a = this.v;
                        if (interfaceC0157a != null) {
                            interfaceC0157a.b(this.w, this.t, this.f156s);
                            j2 = 0;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile3;
                    try {
                        th.printStackTrace();
                        this.x = th.getMessage();
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (java.io.IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (java.io.IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        return 4;
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.FileInputStream, java.io.InputStream] */
    public static /* synthetic */ void a(com.anythink.china.common.a.a aVar) {
        java.io.BufferedReader bufferedReader;
        ?? file = new java.io.File(com.anythink.china.common.c.b.a(aVar.b) + f);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.anythink.china.common.c.b.a(aVar.b));
        ?? r3 = e;
        sb.append(e);
        java.io.File file2 = new java.io.File(sb.toString());
        if (!file.exists() || !file2.exists()) {
            try {
                file.delete();
                file2.delete();
                return;
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                r3 = new java.io.FileInputStream((java.io.File) file);
                try {
                    file = new java.io.InputStreamReader(r3);
                    try {
                        bufferedReader = new java.io.BufferedReader(file);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                    }
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (!android.text.TextUtils.isEmpty(readLine)) {
                            long longValue = java.lang.Long.valueOf(readLine).longValue();
                            aVar.n = longValue;
                            if (longValue > file2.length()) {
                                aVar.n = 0L;
                            } else {
                                aVar.f156s = file2.length();
                            }
                        }
                        try {
                            bufferedReader.close();
                            file.close();
                            r3.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        bufferedReader2 = bufferedReader;
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                                return;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (r3 != 0) {
                            r3.close();
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (r3 != 0) {
                            r3.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e7) {
                    e = e7;
                    file = 0;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    file = 0;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Exception e8) {
            e = e8;
            file = 0;
            r3 = 0;
        } catch (java.lang.Throwable th4) {
            th = th4;
            file = 0;
            r3 = 0;
        }
    }

    private void g() {
        com.anythink.china.common.a.a.a.a().a((com.anythink.core.common.o.b.d) new com.anythink.china.common.a.a.AnonymousClass1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.FileInputStream, java.io.InputStream] */
    private void h() {
        java.io.BufferedReader bufferedReader;
        ?? file = new java.io.File(com.anythink.china.common.c.b.a(this.b) + f);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.anythink.china.common.c.b.a(this.b));
        ?? r3 = e;
        sb.append(e);
        java.io.File file2 = new java.io.File(sb.toString());
        if (!file.exists() || !file2.exists()) {
            try {
                file.delete();
                file2.delete();
                return;
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                r3 = new java.io.FileInputStream((java.io.File) file);
                try {
                    file = new java.io.InputStreamReader(r3);
                    try {
                        bufferedReader = new java.io.BufferedReader(file);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                    }
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (!android.text.TextUtils.isEmpty(readLine)) {
                            long longValue = java.lang.Long.valueOf(readLine).longValue();
                            this.n = longValue;
                            if (longValue > file2.length()) {
                                this.n = 0L;
                            } else {
                                this.f156s = file2.length();
                            }
                        }
                        try {
                            bufferedReader.close();
                            file.close();
                            r3.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        bufferedReader2 = bufferedReader;
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                                return;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (r3 != 0) {
                            r3.close();
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (r3 != 0) {
                            r3.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e7) {
                    e = e7;
                    file = 0;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    file = 0;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Exception e8) {
            e = e8;
            file = 0;
            r3 = 0;
        } catch (java.lang.Throwable th4) {
            th = th4;
            file = 0;
            r3 = 0;
        }
    }

    private static int i() {
        return 60000;
    }

    private static int j() {
        return 20000;
    }

    public final void a() {
        this.c = true;
    }

    public final void a(com.anythink.china.common.a.a.InterfaceC0157a interfaceC0157a) {
        this.v = interfaceC0157a;
        this.c = false;
        com.anythink.china.common.a.a.a.a().a((com.anythink.core.common.o.b.d) new com.anythink.china.common.a.a.AnonymousClass1());
    }

    public final void a(com.anythink.china.common.a.b bVar) {
        b(bVar);
    }

    public final void a(org.apache.http.conn.ConnectTimeoutException connectTimeoutException) {
        b(com.anythink.china.common.a.c.a("10000", connectTimeoutException.getMessage()));
    }

    public final void b() {
        this.d = true;
    }

    public final void b(com.anythink.china.common.a.b bVar) {
        bVar.a();
        this.w.n();
        com.anythink.china.common.a.a.InterfaceC0157a interfaceC0157a = this.v;
        if (interfaceC0157a != null) {
            interfaceC0157a.a(this.w, bVar.b());
        }
    }

    public boolean c() {
        return true;
    }

    public final void d() {
        com.anythink.china.common.a.a.InterfaceC0157a interfaceC0157a = this.v;
        if (interfaceC0157a != null) {
            interfaceC0157a.a(this.w, this.t, this.f156s, this.m);
        }
    }

    public final void e() {
        com.anythink.china.common.a.a.InterfaceC0157a interfaceC0157a = this.v;
        if (interfaceC0157a != null) {
            com.anythink.china.common.a.e eVar = this.w;
            interfaceC0157a.a(eVar, eVar.i);
        }
    }
}
