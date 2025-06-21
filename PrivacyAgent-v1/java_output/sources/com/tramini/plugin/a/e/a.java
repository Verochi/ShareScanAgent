package com.tramini.plugin.a.e;

/* loaded from: classes19.dex */
public abstract class a {
    public static final java.lang.String a = "platform";
    public static final java.lang.String b = "os_vn";
    public static final java.lang.String c = "os_vc";
    public static final java.lang.String d = "package_name";
    public static final java.lang.String e = "app_vn";
    public static final java.lang.String f = "app_vc";
    public static final java.lang.String g = "sdk_ver";
    public static final java.lang.String h = "android_id";
    public static final java.lang.String i = "is_proxy";
    public static final java.lang.String j = "ds_pl";
    public static final java.lang.String k = "area_type";
    public static final java.lang.String l = "cached";
    public static final int m = 1;
    public static final int n = 2;
    private static final java.lang.String p = "a";
    protected com.tramini.plugin.a.e.b o;

    /* renamed from: com.tramini.plugin.a.e.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.tramini.plugin.a.h.b.b {
        final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        private void a(java.lang.String str) {
            java.lang.Throwable th;
            java.net.HttpURLConnection httpURLConnection;
            java.net.HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    httpURLConnection = null;
                }
            } catch (java.lang.OutOfMemoryError unused) {
            } catch (java.lang.Error unused2) {
            } catch (java.net.ConnectException unused3) {
            } catch (java.net.SocketTimeoutException unused4) {
            } catch (org.apache.http.conn.ConnectTimeoutException unused5) {
            } catch (java.lang.Exception unused6) {
            } catch (java.lang.StackOverflowError unused7) {
            } catch (java.net.UnknownHostException unused8) {
            }
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                java.util.Map<java.lang.String, java.lang.String> c = com.tramini.plugin.a.e.a.this.c();
                if (c.size() > 0) {
                    for (java.lang.String str2 : c.keySet()) {
                        httpURLConnection.addRequestProperty(str2, c.get(str2));
                    }
                }
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.connect();
                byte[] d = com.tramini.plugin.a.e.a.this.d();
                if (d != null) {
                    java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(d);
                    outputStream.flush();
                    outputStream.close();
                }
                if (httpURLConnection.getResponseCode() != 200) {
                    com.tramini.plugin.a.e.a.this.i();
                    httpURLConnection.disconnect();
                    return;
                }
                java.io.InputStream a = com.tramini.plugin.a.e.a.a(httpURLConnection);
                java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(a);
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(inputStreamReader);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while (true) {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else {
                        sb.append(readLine);
                    }
                }
                bufferedReader.close();
                inputStreamReader.close();
                if (a != null) {
                    a.close();
                }
                if (com.tramini.plugin.a.e.a.this.g()) {
                    java.lang.String sb2 = sb.toString();
                    com.tramini.plugin.a.e.a aVar = com.tramini.plugin.a.e.a.this;
                    httpURLConnection.getHeaderFields();
                    com.tramini.plugin.a.e.a.this.a(aVar.a(sb2));
                } else {
                    com.tramini.plugin.a.e.a aVar2 = com.tramini.plugin.a.e.a.this;
                    httpURLConnection.getHeaderFields();
                    com.tramini.plugin.a.e.a.this.a(aVar2.a(""));
                }
                httpURLConnection.disconnect();
            } catch (java.lang.OutOfMemoryError unused9) {
                httpURLConnection2 = httpURLConnection;
                java.lang.System.gc();
                com.tramini.plugin.a.e.a.this.i();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.lang.StackOverflowError unused10) {
                httpURLConnection2 = httpURLConnection;
                java.lang.System.gc();
                com.tramini.plugin.a.e.a.this.i();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.lang.Error unused11) {
                httpURLConnection2 = httpURLConnection;
                java.lang.System.gc();
                com.tramini.plugin.a.e.a.this.i();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.net.ConnectException unused12) {
                httpURLConnection2 = httpURLConnection;
                com.tramini.plugin.a.e.a.this.i();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.net.SocketTimeoutException unused13) {
                httpURLConnection2 = httpURLConnection;
                com.tramini.plugin.a.e.a.this.i();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.net.UnknownHostException unused14) {
                httpURLConnection2 = httpURLConnection;
                com.tramini.plugin.a.e.a.this.i();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (org.apache.http.conn.ConnectTimeoutException unused15) {
                httpURLConnection2 = httpURLConnection;
                com.tramini.plugin.a.e.a.this.h();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.lang.Exception unused16) {
                httpURLConnection2 = httpURLConnection;
                com.tramini.plugin.a.e.a.this.i();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }

        @Override // com.tramini.plugin.a.h.b.b
        public final void a() {
            java.lang.Throwable th;
            java.net.HttpURLConnection httpURLConnection;
            try {
                try {
                    com.tramini.plugin.a.e.b bVar = com.tramini.plugin.a.e.a.this.o;
                    if (bVar != null) {
                        bVar.a();
                    }
                    java.net.HttpURLConnection httpURLConnection2 = null;
                    try {
                        try {
                            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(com.tramini.plugin.a.e.a.this.b()).openConnection();
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            httpURLConnection = null;
                        }
                        try {
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setUseCaches(false);
                            java.util.Map<java.lang.String, java.lang.String> c = com.tramini.plugin.a.e.a.this.c();
                            if (c.size() > 0) {
                                for (java.lang.String str : c.keySet()) {
                                    httpURLConnection.addRequestProperty(str, c.get(str));
                                }
                            }
                            httpURLConnection.setConnectTimeout(20000);
                            httpURLConnection.setReadTimeout(60000);
                            httpURLConnection.connect();
                            byte[] d = com.tramini.plugin.a.e.a.this.d();
                            if (d != null) {
                                java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(d);
                                outputStream.flush();
                                outputStream.close();
                            }
                            if (httpURLConnection.getResponseCode() != 200) {
                                com.tramini.plugin.a.e.a.this.i();
                                httpURLConnection.disconnect();
                                return;
                            }
                            java.io.InputStream a = com.tramini.plugin.a.e.a.a(httpURLConnection);
                            java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(a);
                            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(inputStreamReader);
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            while (true) {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else {
                                    sb.append(readLine);
                                }
                            }
                            bufferedReader.close();
                            inputStreamReader.close();
                            if (a != null) {
                                a.close();
                            }
                            if (com.tramini.plugin.a.e.a.this.g()) {
                                java.lang.String sb2 = sb.toString();
                                com.tramini.plugin.a.e.a aVar = com.tramini.plugin.a.e.a.this;
                                httpURLConnection.getHeaderFields();
                                com.tramini.plugin.a.e.a.this.a(aVar.a(sb2));
                            } else {
                                com.tramini.plugin.a.e.a aVar2 = com.tramini.plugin.a.e.a.this;
                                httpURLConnection.getHeaderFields();
                                com.tramini.plugin.a.e.a.this.a(aVar2.a(""));
                            }
                            httpURLConnection.disconnect();
                        } catch (java.lang.OutOfMemoryError unused) {
                            httpURLConnection2 = httpURLConnection;
                            java.lang.System.gc();
                            com.tramini.plugin.a.e.a.this.i();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (java.lang.StackOverflowError unused2) {
                            httpURLConnection2 = httpURLConnection;
                            java.lang.System.gc();
                            com.tramini.plugin.a.e.a.this.i();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (java.lang.Error unused3) {
                            httpURLConnection2 = httpURLConnection;
                            java.lang.System.gc();
                            com.tramini.plugin.a.e.a.this.i();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (java.net.ConnectException unused4) {
                            httpURLConnection2 = httpURLConnection;
                            com.tramini.plugin.a.e.a.this.i();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (java.net.SocketTimeoutException unused5) {
                            httpURLConnection2 = httpURLConnection;
                            com.tramini.plugin.a.e.a.this.i();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (java.net.UnknownHostException unused6) {
                            httpURLConnection2 = httpURLConnection;
                            com.tramini.plugin.a.e.a.this.i();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (org.apache.http.conn.ConnectTimeoutException unused7) {
                            httpURLConnection2 = httpURLConnection;
                            com.tramini.plugin.a.e.a.this.h();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (java.lang.Exception unused8) {
                            httpURLConnection2 = httpURLConnection;
                            com.tramini.plugin.a.e.a.this.i();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (java.lang.OutOfMemoryError unused9) {
                    } catch (java.lang.StackOverflowError unused10) {
                    } catch (java.lang.Error unused11) {
                    } catch (java.net.ConnectException unused12) {
                    } catch (java.net.SocketTimeoutException unused13) {
                    } catch (java.net.UnknownHostException unused14) {
                    } catch (org.apache.http.conn.ConnectTimeoutException unused15) {
                    } catch (java.lang.Exception unused16) {
                    }
                } catch (java.lang.OutOfMemoryError | java.lang.StackOverflowError unused17) {
                    java.lang.System.gc();
                    com.tramini.plugin.a.e.b bVar2 = com.tramini.plugin.a.e.a.this.o;
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                }
            } catch (java.lang.Exception unused18) {
                com.tramini.plugin.a.e.b bVar3 = com.tramini.plugin.a.e.a.this.o;
                if (bVar3 != null) {
                    bVar3.b();
                }
            }
        }
    }

    public static java.io.InputStream a(java.net.HttpURLConnection httpURLConnection) {
        java.io.InputStream inputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (java.lang.Exception unused) {
        }
        if (!"gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return inputStream;
        }
        try {
            byte[] bArr = new byte[2];
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream);
            bufferedInputStream.mark(2);
            int read = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            return (read == -1 || (((bArr[1] & 255) << 8) | (bArr[0] & 255)) != 35615) ? bufferedInputStream : new java.util.zip.GZIPInputStream(bufferedInputStream);
        } catch (java.lang.Exception unused2) {
            return inputStream;
        }
    }

    private void a(int i2) {
        com.tramini.plugin.a.h.b.a.a().a((com.tramini.plugin.a.h.b.b) new com.tramini.plugin.a.e.a.AnonymousClass1(i2));
    }

    public static byte[] b(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public abstract int a();

    public abstract java.lang.Object a(java.lang.String str);

    public final void a(int i2, com.tramini.plugin.a.e.b bVar) {
        this.o = bVar;
        com.tramini.plugin.a.h.b.a.a().a((com.tramini.plugin.a.h.b.b) new com.tramini.plugin.a.e.a.AnonymousClass1(i2));
    }

    public final void a(java.lang.Object obj) {
        com.tramini.plugin.a.e.b bVar = this.o;
        if (bVar != null) {
            bVar.a(obj);
        }
    }

    public abstract java.lang.String b();

    public abstract java.util.Map<java.lang.String, java.lang.String> c();

    public abstract byte[] d();

    public org.json.JSONObject e() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        android.content.Context b2 = com.tramini.plugin.a.b.c.a().b();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", com.tramini.plugin.a.h.e.b());
            jSONObject.put("os_vc", com.tramini.plugin.a.h.e.a());
            jSONObject.put("package_name", com.tramini.plugin.a.h.e.c(b2));
            jSONObject.put("app_vn", com.tramini.plugin.a.h.e.b(b2));
            jSONObject.put("app_vc", com.tramini.plugin.a.h.e.a(b2));
            jSONObject.put("sdk_ver", com.tramini.plugin.a.b.a.a);
            jSONObject.put("area_type", com.tramini.plugin.a.b.a.b.a);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    public java.lang.String f() {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String b2 = com.tramini.plugin.a.h.c.b(e().toString());
        hashMap.put("d_version", "1.0");
        hashMap.put(com.anythink.expressad.foundation.g.a.N, b2);
        hashMap.put("d_sign", com.tramini.plugin.a.h.f.a("d_version=1.0&d1=".concat(java.lang.String.valueOf(b2))));
        hashMap.put("pl_c", "5");
        java.util.Set<java.lang.String> keySet = hashMap.keySet();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            for (java.lang.String str : keySet) {
                jSONObject.put(str, java.lang.String.valueOf(hashMap.get(str)));
            }
            return jSONObject.toString();
        } catch (java.lang.Exception unused) {
            return null;
        } catch (java.lang.OutOfMemoryError unused2) {
            java.lang.System.gc();
            return null;
        }
    }

    public abstract boolean g();

    public final void h() {
        com.tramini.plugin.a.e.b bVar = this.o;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void i() {
        com.tramini.plugin.a.e.b bVar = this.o;
        if (bVar != null) {
            bVar.b();
        }
    }
}
