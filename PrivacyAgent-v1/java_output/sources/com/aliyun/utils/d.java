package com.aliyun.utils;

/* loaded from: classes12.dex */
public class d {
    private static final java.lang.String a = "d";
    private static java.util.concurrent.ExecutorService b = java.util.concurrent.Executors.newCachedThreadPool();
    private java.lang.String d;
    private java.net.URLConnection c = null;
    private java.lang.String e = null;
    private int f = 10000;
    private java.lang.String g = null;
    private java.lang.String h = null;
    private java.lang.String[] i = null;

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            java.net.HttpURLConnection httpURLConnection;
            try {
                if (com.aliyun.utils.d.this.c instanceof javax.net.ssl.HttpsURLConnection) {
                    com.cicada.player.utils.Logger.i(com.aliyun.utils.d.a, "HttpClientHelper stop().... HttpsURLConnection.disconnect ");
                    httpURLConnection = (javax.net.ssl.HttpsURLConnection) com.aliyun.utils.d.this.c;
                } else {
                    if (!(com.aliyun.utils.d.this.c instanceof java.net.HttpURLConnection)) {
                        return;
                    }
                    com.cicada.player.utils.Logger.i(com.aliyun.utils.d.a, "HttpClientHelper stop().... HttpURLConnection.disconnect ");
                    httpURLConnection = (java.net.HttpURLConnection) com.aliyun.utils.d.this.c;
                }
                httpURLConnection.disconnect();
            } catch (java.lang.Exception e) {
                com.cicada.player.utils.Logger.e(com.aliyun.utils.d.a, e.getMessage());
            }
        }
    }

    public d(java.lang.String str) {
        this.d = str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|2|3|(7:20|21|6|(1:8)(1:19)|9|10|(1:12)(3:14|15|16))|5|6|(0)(0)|9|10|(0)(0)|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[Catch: Exception -> 0x0049, TRY_LEAVE, TryCatch #1 {Exception -> 0x0049, blocks: (B:10:0x0032, B:14:0x0037), top: B:9:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #0 {Exception -> 0x004a, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:19:0x002e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: Exception -> 0x004a, TryCatch #0 {Exception -> 0x004a, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:19:0x002e), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.net.URLConnection a(java.lang.String str) {
        java.net.Proxy proxy;
        java.net.URLConnection openConnection;
        try {
            if (this.g != null) {
                try {
                    java.net.URL url = new java.net.URL(this.g);
                    proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(url.getHost(), url.getPort()));
                } catch (java.lang.Exception unused) {
                }
                java.net.URL url2 = new java.net.URL(str);
                openConnection = proxy == null ? url2.openConnection(proxy) : url2.openConnection();
                if (openConnection instanceof java.net.HttpURLConnection) {
                    return null;
                }
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(this.f);
                httpURLConnection.setReadTimeout(this.f);
                return openConnection;
            }
            proxy = null;
            java.net.URL url22 = new java.net.URL(str);
            if (proxy == null) {
            }
            if (openConnection instanceof java.net.HttpURLConnection) {
            }
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|2|3|(7:20|21|6|(1:8)(1:19)|9|10|(1:12)(3:14|15|16))|5|6|(0)(0)|9|10|(0)(0)|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[Catch: Exception -> 0x0049, TRY_LEAVE, TryCatch #1 {Exception -> 0x0049, blocks: (B:10:0x0032, B:14:0x0037), top: B:9:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #0 {Exception -> 0x004a, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:19:0x002e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: Exception -> 0x004a, TryCatch #0 {Exception -> 0x004a, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:19:0x002e), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.net.URLConnection b(java.lang.String str) {
        java.net.Proxy proxy;
        java.net.URLConnection openConnection;
        try {
            if (this.g != null) {
                try {
                    java.net.URL url = new java.net.URL(this.g);
                    proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(url.getHost(), url.getPort()));
                } catch (java.lang.Exception unused) {
                }
                java.net.URL url2 = new java.net.URL(str);
                openConnection = proxy == null ? url2.openConnection(proxy) : url2.openConnection();
                if (openConnection instanceof javax.net.ssl.HttpsURLConnection) {
                    return null;
                }
                javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) openConnection;
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(this.f);
                httpsURLConnection.setReadTimeout(this.f);
                return openConnection;
            }
            proxy = null;
            java.net.URL url22 = new java.net.URL(str);
            if (proxy == null) {
            }
            if (openConnection instanceof javax.net.ssl.HttpsURLConnection) {
            }
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }

    private java.io.InputStream c() {
        java.net.HttpURLConnection httpURLConnection;
        java.net.URLConnection uRLConnection = this.c;
        if (uRLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            httpURLConnection = (javax.net.ssl.HttpsURLConnection) uRLConnection;
        } else {
            if (!(uRLConnection instanceof java.net.HttpURLConnection)) {
                return null;
            }
            httpURLConnection = (java.net.HttpURLConnection) uRLConnection;
        }
        return httpURLConnection.getErrorStream();
    }

    private int d() throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnection;
        java.net.URLConnection uRLConnection = this.c;
        if (uRLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            httpURLConnection = (javax.net.ssl.HttpsURLConnection) uRLConnection;
        } else {
            if (!(uRLConnection instanceof java.net.HttpURLConnection)) {
                return 0;
            }
            httpURLConnection = (java.net.HttpURLConnection) uRLConnection;
        }
        return httpURLConnection.getResponseCode();
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(java.lang.String[] strArr) {
        this.i = strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0165 A[Catch: IOException -> 0x0161, TryCatch #13 {IOException -> 0x0161, blocks: (B:83:0x015d, B:67:0x0165, B:69:0x016a), top: B:82:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016a A[Catch: IOException -> 0x0161, TRY_LEAVE, TryCatch #13 {IOException -> 0x0161, blocks: (B:83:0x015d, B:67:0x0165, B:69:0x016a), top: B:82:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0193 A[Catch: IOException -> 0x018f, TryCatch #8 {IOException -> 0x018f, blocks: (B:108:0x018b, B:90:0x0193, B:92:0x0198), top: B:107:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0198 A[Catch: IOException -> 0x018f, TRY_LEAVE, TryCatch #8 {IOException -> 0x018f, blocks: (B:108:0x018b, B:90:0x0193, B:92:0x0198), top: B:107:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String b() {
        java.net.URLConnection a2;
        java.net.URLConnection uRLConnection;
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        java.lang.Exception e;
        java.io.BufferedReader bufferedReader;
        java.io.InputStreamReader inputStreamReader;
        java.net.URLConnection uRLConnection2;
        java.net.HttpURLConnection httpURLConnection;
        java.io.BufferedReader bufferedReader2;
        java.io.InputStreamReader inputStreamReader2;
        java.lang.Throwable th2;
        java.net.URLConnection uRLConnection3;
        java.net.HttpURLConnection httpURLConnection2;
        java.net.HttpURLConnection httpURLConnection3;
        java.net.HttpURLConnection httpURLConnection4;
        java.io.InputStreamReader inputStreamReader3 = null;
        if (this.d.startsWith("https://")) {
            a2 = b(this.d);
        } else if (this.d.startsWith("http://")) {
            a2 = a(this.d);
        } else {
            this.c = null;
            uRLConnection = this.c;
            if (uRLConnection != null) {
                return null;
            }
            java.lang.String str = this.e;
            if (str != null) {
                uRLConnection.setRequestProperty(com.google.common.net.HttpHeaders.REFERER, str);
            }
            java.lang.String str2 = this.h;
            if (str2 != null) {
                this.c.addRequestProperty("User-Agent", str2);
            }
            java.lang.String[] strArr = this.i;
            if (strArr != null) {
                for (java.lang.String str3 : strArr) {
                    if (str3 != null) {
                        java.lang.String[] split = str3.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        if (split.length == 2) {
                            this.c.addRequestProperty(split[0], split[1]);
                        }
                    }
                }
            }
            try {
                int d = d();
                if (d == 200) {
                    inputStream = this.c.getInputStream();
                    try {
                        inputStreamReader = new java.io.InputStreamReader(inputStream);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        try {
                            com.cicada.player.utils.Logger.d("HttpClientUtil", e.getMessage());
                            if (inputStream != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            uRLConnection3 = this.c;
                            if (uRLConnection3 != null) {
                            }
                            return null;
                        } catch (java.lang.Throwable th3) {
                            th2 = th3;
                            bufferedReader2 = bufferedReader;
                            inputStreamReader2 = inputStreamReader;
                            th = th2;
                            inputStreamReader3 = inputStreamReader2;
                            bufferedReader = bufferedReader2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.io.IOException unused) {
                                    uRLConnection2 = this.c;
                                    if (uRLConnection2 == null) {
                                    }
                                }
                            }
                            if (inputStreamReader3 != null) {
                                inputStreamReader3.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            uRLConnection2 = this.c;
                            if (uRLConnection2 == null) {
                                throw th;
                            }
                            if (uRLConnection2 instanceof java.net.HttpURLConnection) {
                                httpURLConnection = (java.net.HttpURLConnection) uRLConnection2;
                            } else {
                                if (!(uRLConnection2 instanceof javax.net.ssl.HttpsURLConnection)) {
                                    throw th;
                                }
                                httpURLConnection = (javax.net.ssl.HttpsURLConnection) uRLConnection2;
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        if (inputStream != null) {
                        }
                        if (inputStreamReader3 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        uRLConnection2 = this.c;
                        if (uRLConnection2 == null) {
                        }
                    }
                    try {
                        bufferedReader = new java.io.BufferedReader(inputStreamReader);
                        try {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            while (true) {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            java.lang.String sb2 = sb.toString();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.io.IOException unused2) {
                                }
                            }
                            inputStreamReader.close();
                            bufferedReader.close();
                            java.net.URLConnection uRLConnection4 = this.c;
                            if (uRLConnection4 != null) {
                                if (uRLConnection4 instanceof java.net.HttpURLConnection) {
                                    httpURLConnection4 = (java.net.HttpURLConnection) uRLConnection4;
                                } else if (uRLConnection4 instanceof javax.net.ssl.HttpsURLConnection) {
                                    httpURLConnection4 = (javax.net.ssl.HttpsURLConnection) uRLConnection4;
                                }
                                httpURLConnection4.disconnect();
                            }
                            return sb2;
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            com.cicada.player.utils.Logger.d("HttpClientUtil", e.getMessage());
                            if (inputStream != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            uRLConnection3 = this.c;
                            if (uRLConnection3 != null) {
                            }
                            return null;
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            inputStreamReader3 = inputStreamReader;
                            if (inputStream != null) {
                            }
                            if (inputStreamReader3 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            uRLConnection2 = this.c;
                            if (uRLConnection2 == null) {
                            }
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        bufferedReader = null;
                        com.cicada.player.utils.Logger.d("HttpClientUtil", e.getMessage());
                        if (inputStream != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        uRLConnection3 = this.c;
                        if (uRLConnection3 != null) {
                        }
                        return null;
                    } catch (java.lang.Throwable th6) {
                        bufferedReader = null;
                        inputStreamReader3 = inputStreamReader;
                        th = th6;
                    }
                } else {
                    java.io.InputStream c = c();
                    try {
                        inputStreamReader2 = new java.io.InputStreamReader(c);
                        try {
                            bufferedReader2 = new java.io.BufferedReader(inputStreamReader2);
                            try {
                                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                while (true) {
                                    java.lang.String readLine2 = bufferedReader2.readLine();
                                    if (readLine2 == null) {
                                        break;
                                    }
                                    sb3.append(readLine2);
                                }
                                org.json.JSONObject jSONObject = new org.json.JSONObject();
                                jSONObject.put("StatusCode", d);
                                jSONObject.put("ResponseStr", sb3.toString());
                                java.lang.String jSONObject2 = jSONObject.toString();
                                if (c != null) {
                                    try {
                                        c.close();
                                    } catch (java.io.IOException unused3) {
                                    }
                                }
                                inputStreamReader2.close();
                                bufferedReader2.close();
                                java.net.URLConnection uRLConnection5 = this.c;
                                if (uRLConnection5 != null) {
                                    if (uRLConnection5 instanceof java.net.HttpURLConnection) {
                                        httpURLConnection3 = (java.net.HttpURLConnection) uRLConnection5;
                                    } else if (uRLConnection5 instanceof javax.net.ssl.HttpsURLConnection) {
                                        httpURLConnection3 = (javax.net.ssl.HttpsURLConnection) uRLConnection5;
                                    }
                                    httpURLConnection3.disconnect();
                                }
                                return jSONObject2;
                            } catch (java.lang.Exception e5) {
                                e = e5;
                                inputStream = c;
                                inputStreamReader = inputStreamReader2;
                                bufferedReader = bufferedReader2;
                                com.cicada.player.utils.Logger.d("HttpClientUtil", e.getMessage());
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (java.io.IOException unused4) {
                                        uRLConnection3 = this.c;
                                        if (uRLConnection3 != null) {
                                            if (uRLConnection3 instanceof java.net.HttpURLConnection) {
                                                httpURLConnection2 = (java.net.HttpURLConnection) uRLConnection3;
                                            } else if (uRLConnection3 instanceof javax.net.ssl.HttpsURLConnection) {
                                                httpURLConnection2 = (javax.net.ssl.HttpsURLConnection) uRLConnection3;
                                            }
                                            httpURLConnection2.disconnect();
                                        }
                                        return null;
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                uRLConnection3 = this.c;
                                if (uRLConnection3 != null) {
                                }
                                return null;
                            } catch (java.lang.Throwable th7) {
                                th2 = th7;
                                inputStream = c;
                                th = th2;
                                inputStreamReader3 = inputStreamReader2;
                                bufferedReader = bufferedReader2;
                                if (inputStream != null) {
                                }
                                if (inputStreamReader3 != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                uRLConnection2 = this.c;
                                if (uRLConnection2 == null) {
                                }
                            }
                        } catch (java.lang.Exception e6) {
                            e = e6;
                            inputStream = c;
                            inputStreamReader = inputStreamReader2;
                            bufferedReader = null;
                            com.cicada.player.utils.Logger.d("HttpClientUtil", e.getMessage());
                            if (inputStream != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            uRLConnection3 = this.c;
                            if (uRLConnection3 != null) {
                            }
                            return null;
                        } catch (java.lang.Throwable th8) {
                            th = th8;
                            inputStream = c;
                            bufferedReader = null;
                            inputStreamReader3 = inputStreamReader2;
                            if (inputStream != null) {
                            }
                            if (inputStreamReader3 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            uRLConnection2 = this.c;
                            if (uRLConnection2 == null) {
                            }
                        }
                    } catch (java.lang.Exception e7) {
                        e = e7;
                        inputStream = c;
                        inputStreamReader = null;
                        bufferedReader = null;
                        com.cicada.player.utils.Logger.d("HttpClientUtil", e.getMessage());
                        if (inputStream != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        uRLConnection3 = this.c;
                        if (uRLConnection3 != null) {
                        }
                        return null;
                    } catch (java.lang.Throwable th9) {
                        th = th9;
                        inputStream = c;
                        bufferedReader = null;
                        if (inputStream != null) {
                        }
                        if (inputStreamReader3 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        uRLConnection2 = this.c;
                        if (uRLConnection2 == null) {
                        }
                    }
                }
            } catch (java.lang.Exception e8) {
                e = e8;
                inputStream = null;
            } catch (java.lang.Throwable th10) {
                th = th10;
                inputStream = null;
            }
        }
        this.c = a2;
        uRLConnection = this.c;
        if (uRLConnection != null) {
        }
    }

    public void c(java.lang.String str) {
        this.g = str;
    }

    public void d(java.lang.String str) {
        this.e = str;
    }

    public void e() {
        com.cicada.player.utils.Logger.d(a, "HttpClientHelper stop().... urlConnection = " + this.c);
        if (this.c != null) {
            b.execute(new com.aliyun.utils.d.a());
        }
    }

    public void e(java.lang.String str) {
        this.h = str;
    }
}
