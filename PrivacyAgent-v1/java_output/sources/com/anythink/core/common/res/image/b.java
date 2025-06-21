package com.anythink.core.common.res.image;

/* loaded from: classes12.dex */
public abstract class b {
    private final java.lang.String a = getClass().getSimpleName();
    protected java.lang.String c;
    protected boolean d;
    protected long e;
    protected long f;
    protected long g;
    protected long h;
    protected long i;

    /* renamed from: com.anythink.core.common.res.image.b$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.core.common.o.b.d {
        public AnonymousClass1() {
        }

        private void b(java.lang.String str) {
            java.net.HttpURLConnection httpURLConnection;
            com.anythink.core.common.res.image.b.this.e = java.lang.System.currentTimeMillis();
            com.anythink.core.common.res.image.b.this.f = android.os.SystemClock.elapsedRealtime();
            java.net.HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    java.lang.String unused = com.anythink.core.common.res.image.b.this.a;
                    httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.OutOfMemoryError e) {
                e = e;
            } catch (java.lang.StackOverflowError e2) {
                e = e2;
            } catch (java.lang.Error e3) {
                e = e3;
            } catch (java.net.SocketTimeoutException e4) {
                e = e4;
            } catch (org.apache.http.conn.ConnectTimeoutException e5) {
                e = e5;
            } catch (java.lang.Exception e6) {
                e = e6;
            }
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                java.util.Map<java.lang.String, java.lang.String> a = com.anythink.core.common.res.image.b.this.a();
                if (a != null && a.size() > 0) {
                    for (java.lang.String str2 : a.keySet()) {
                        httpURLConnection.addRequestProperty(str2, a.get(str2));
                        java.lang.String unused2 = com.anythink.core.common.res.image.b.this.a;
                        a.get(str2);
                    }
                }
                com.anythink.core.common.res.image.b bVar = com.anythink.core.common.res.image.b.this;
                if (bVar.d) {
                    bVar.a(com.anythink.core.common.res.image.c.b, "Task had been canceled.");
                    httpURLConnection.disconnect();
                    return;
                }
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    com.anythink.core.common.res.image.b bVar2 = com.anythink.core.common.res.image.b.this;
                    if (bVar2.d) {
                        bVar2.a(com.anythink.core.common.res.image.c.b, "Task had been canceled.");
                        httpURLConnection.disconnect();
                        return;
                    }
                    bVar2.i = httpURLConnection.getContentLength();
                    java.io.InputStream inputStream = httpURLConnection.getInputStream();
                    boolean a2 = com.anythink.core.common.res.image.b.this.a(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    com.anythink.core.common.res.image.b.this.g = java.lang.System.currentTimeMillis();
                    com.anythink.core.common.res.image.b.this.h = android.os.SystemClock.elapsedRealtime();
                    if (a2) {
                        java.lang.String unused3 = com.anythink.core.common.res.image.b.this.a;
                        com.anythink.core.common.res.image.b bVar3 = com.anythink.core.common.res.image.b.this;
                        java.lang.String str3 = bVar3.c;
                        bVar3.c();
                    } else {
                        java.lang.String unused4 = com.anythink.core.common.res.image.b.this.a;
                        com.anythink.core.common.res.image.b bVar4 = com.anythink.core.common.res.image.b.this;
                        java.lang.String str4 = bVar4.c;
                        bVar4.a(com.anythink.core.common.res.image.c.a, "Save fail!");
                    }
                    httpURLConnection.disconnect();
                    return;
                }
                java.lang.String unused5 = com.anythink.core.common.res.image.b.this.a;
                if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                    com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, "Resource download fail, status code: " + responseCode + ", " + httpURLConnection.getResponseMessage() + ", url: " + str);
                    httpURLConnection.disconnect();
                    return;
                }
                com.anythink.core.common.res.image.b bVar5 = com.anythink.core.common.res.image.b.this;
                if (bVar5.d) {
                    bVar5.a(com.anythink.core.common.res.image.c.b, "Task had been canceled.");
                } else {
                    java.lang.String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField != null) {
                        if (!headerField.toLowerCase().startsWith(com.alipay.sdk.m.l.a.q)) {
                            com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, "Final url is wrong:".concat(headerField));
                            httpURLConnection.disconnect();
                            return;
                        }
                        b(headerField);
                    }
                }
                httpURLConnection.disconnect();
            } catch (java.lang.Error e7) {
                e = e7;
                httpURLConnection2 = httpURLConnection;
                java.lang.System.gc();
                java.lang.String unused6 = com.anythink.core.common.res.image.b.this.a;
                e.getMessage();
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.net.SocketTimeoutException e8) {
                e = e8;
                httpURLConnection2 = httpURLConnection;
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
                java.lang.String unused7 = com.anythink.core.common.res.image.b.this.a;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.lang.Exception e9) {
                e = e9;
                httpURLConnection2 = httpURLConnection;
                java.lang.String unused8 = com.anythink.core.common.res.image.b.this.a;
                e.getMessage();
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.lang.OutOfMemoryError e10) {
                e = e10;
                httpURLConnection2 = httpURLConnection;
                java.lang.System.gc();
                java.lang.String unused9 = com.anythink.core.common.res.image.b.this.a;
                e.getMessage();
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.lang.StackOverflowError e11) {
                e = e11;
                httpURLConnection2 = httpURLConnection;
                java.lang.System.gc();
                java.lang.String unused10 = com.anythink.core.common.res.image.b.this.a;
                e.getMessage();
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (org.apache.http.conn.ConnectTimeoutException e12) {
                e = e12;
                httpURLConnection2 = httpURLConnection;
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }

        @Override // com.anythink.core.common.o.b.d
        public final void a() {
            try {
                b(com.anythink.core.common.res.image.b.this.c);
            } catch (java.lang.Exception e) {
                java.lang.String unused = com.anythink.core.common.res.image.b.this.a;
                e.getMessage();
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
            } catch (java.lang.OutOfMemoryError e2) {
                e = e2;
                java.lang.System.gc();
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
            } catch (java.lang.StackOverflowError e3) {
                e = e3;
                java.lang.System.gc();
                com.anythink.core.common.res.image.b.this.a(com.anythink.core.common.res.image.c.a, e.getMessage());
            }
        }
    }

    public b(java.lang.String str) {
        this.c = str;
    }

    private void e() {
        this.d = true;
    }

    private void f() {
        a(new com.anythink.core.common.res.image.b.AnonymousClass1());
    }

    private static int g() {
        return 60000;
    }

    private static int h() {
        return 20000;
    }

    public abstract java.util.Map<java.lang.String, java.lang.String> a();

    public abstract void a(com.anythink.core.common.o.b.d dVar);

    public abstract void a(java.lang.String str, java.lang.String str2);

    public abstract boolean a(java.io.InputStream inputStream);

    public abstract void b();

    public abstract void c();

    public final void d() {
        this.d = false;
        a(new com.anythink.core.common.res.image.b.AnonymousClass1());
    }
}
