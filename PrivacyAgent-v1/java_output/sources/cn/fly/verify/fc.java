package cn.fly.verify;

/* loaded from: classes.dex */
public class fc {
    public static int a = 0;
    public static int b = 0;
    private static boolean d = true;
    protected boolean c = d;

    /* renamed from: cn.fly.verify.fc$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fe {
        final /* synthetic */ byte[] a;
        final /* synthetic */ java.io.OutputStream b;

        public AnonymousClass1(byte[] bArr, java.io.OutputStream outputStream) {
            this.a = bArr;
            this.b = outputStream;
        }

        @Override // cn.fly.verify.fe
        public void a(java.io.InputStream inputStream) throws java.lang.Throwable {
            int read = inputStream.read(this.a);
            while (read != -1) {
                this.b.write(this.a, 0, read);
                read = inputStream.read(this.a);
            }
        }
    }

    /* renamed from: cn.fly.verify.fc$2, reason: invalid class name */
    public class AnonymousClass2 implements cn.fly.verify.ez {
        final /* synthetic */ java.util.HashMap a;

        public AnonymousClass2(java.util.HashMap hashMap) {
            this.a = hashMap;
        }

        @Override // cn.fly.verify.ez
        public void a(cn.fly.verify.ex exVar) throws java.lang.Throwable {
            java.io.InputStreamReader inputStreamReader;
            java.io.InputStreamReader inputStreamReader2;
            int a = exVar.a();
            java.io.BufferedReader bufferedReader = null;
            if (a == 200 || a == 201) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                try {
                    inputStreamReader = new java.io.InputStreamReader(exVar.b(), java.nio.charset.Charset.forName("utf-8"));
                    try {
                        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                java.lang.String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    cn.fly.verify.dw.a(bufferedReader2, inputStreamReader);
                                    this.a.put(cn.fly.verify.ba.a("003!flKh%hj"), sb.toString());
                                    return;
                                } else {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(readLine);
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                cn.fly.verify.dw.a(bufferedReader, inputStreamReader);
                                throw th;
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                }
            } else {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                try {
                    inputStreamReader2 = new java.io.InputStreamReader(exVar.c(), java.nio.charset.Charset.forName("utf-8"));
                    try {
                        java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(inputStreamReader2);
                        while (true) {
                            try {
                                java.lang.String readLine2 = bufferedReader3.readLine();
                                if (readLine2 == null) {
                                    cn.fly.verify.dw.a(bufferedReader3, inputStreamReader2);
                                    java.util.HashMap hashMap = new java.util.HashMap();
                                    hashMap.put(cn.fly.verify.ba.a("005h^flflgffl"), sb2.toString());
                                    hashMap.put(cn.fly.verify.ba.a("006^hj!kfk'fihj"), java.lang.Integer.valueOf(a));
                                    new cn.fly.verify.fm();
                                    throw new java.lang.Throwable(cn.fly.verify.fm.a(hashMap));
                                }
                                if (sb2.length() > 0) {
                                    sb2.append('\n');
                                }
                                sb2.append(readLine2);
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                bufferedReader = bufferedReader3;
                                cn.fly.verify.dw.a(bufferedReader, inputStreamReader2);
                                throw th;
                            }
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    inputStreamReader2 = null;
                }
            }
        }
    }

    public static class a {
        public int a;
        public int b;
    }

    public static class b implements java.lang.reflect.InvocationHandler {
        private java.lang.Object a;
        private java.lang.String b;

        private b(java.lang.String str) {
            try {
                this.b = str;
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName(cn.fly.verify.ba.a("033Nji9f ff8f9gehf)ghkPhfhjhj@iFhfgmflfihj.kVje+fgf!ggCh:flhn(fek4gfflfm")).getDeclaredMethod(cn.fly.verify.ba.a("011?ggOhk^gk)g5hj3kfgeh"), java.lang.String.class);
                declaredMethod.setAccessible(true);
                java.lang.Object invoke = declaredMethod.invoke(null, cn.fly.verify.ba.a("004Qihjkhijl"));
                java.lang.reflect.Method method = invoke.getClass().getMethod(cn.fly.verify.ba.a("004Bfk?gLfk0k"), java.lang.Class.forName(cn.fly.verify.ba.a("022_ji^fEffYf9hfhjZheHfiflfk[k1fmhfkeDhLfmglNkNgfflJh")));
                method.setAccessible(true);
                method.invoke(invoke, null);
                java.lang.reflect.Method method2 = invoke.getClass().getMethod(cn.fly.verify.ba.a("016*ggIhk]gmflfihjVk;jeIfgfSgg^h<flhj"), new java.lang.Class[0]);
                method2.setAccessible(true);
                java.lang.Object[] objArr = (java.lang.Object[]) method2.invoke(invoke, new java.lang.Object[0]);
                if (objArr == null || objArr.length == 0) {
                    throw new java.security.NoSuchAlgorithmException("no trust manager found.");
                }
                this.a = objArr[0];
            } catch (java.lang.Exception e) {
                cn.fly.verify.ed.a().a("failed to initialize the standard trust manager: " + e.getMessage(), new java.lang.Object[0]);
                this.a = null;
            }
        }

        public /* synthetic */ b(java.lang.String str, cn.fly.verify.fc.AnonymousClass1 anonymousClass1) {
            this(str);
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            java.lang.String name = method.getName();
            if (name.equals(cn.fly.verify.ba.a("018ejhe%fnimKi8fkOhgkAgmflfihjAkh'fe"))) {
                return null;
            }
            try {
                if (!name.equals(cn.fly.verify.ba.a("018ejheQfnglZh flff=hUflgmflfihj7khWfe"))) {
                    if (name.equals(cn.fly.verify.ba.a("018Xgg!hk_gnGeehlkhHfegkhjhjfiLh?flhj"))) {
                        return java.lang.reflect.Array.newInstance(java.lang.Class.forName(cn.fly.verify.ba.a("0343jiZfBff+f hfhjEheLfiflfk[k[fmhf>ehSfl=k hfihjkhijlim8hLfl5kOfkghfk?efkh")), 0);
                    }
                    if (name.equals(cn.fly.verify.ba.a("008jfAhjKj5imgffe.h"))) {
                        return java.lang.Integer.valueOf(hashCode());
                    }
                    if (name.equals("toString")) {
                        return toString();
                    }
                    return null;
                }
                java.lang.Object[] objArr2 = (java.lang.Object[]) objArr[0];
                java.lang.String str = (java.lang.String) objArr[1];
                if (objArr2 == null) {
                    throw new java.lang.IllegalArgumentException("there were no certificates.");
                }
                if (objArr2.length == 1) {
                    java.lang.reflect.Method declaredMethod = objArr2[0].getClass().getDeclaredMethod(cn.fly.verify.ba.a("013ejhe]fnil2fi_fkfefkYkSfm"), new java.lang.Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(objArr2[0], new java.lang.Object[0]);
                    return null;
                }
                if (this.a == null) {
                    throw new java.security.cert.CertificateException("there were one more certificates but no trust manager found.");
                }
                java.lang.Object newInstance = java.lang.Class.forName("android.net.http.X509TrustManagerExtensions").getConstructor(java.lang.Class.forName(cn.fly.verify.ba.a("030Lji>fEffRfDgehf_ghk*hfhjhj i<hfihjkhijlgmflfihj7k]je1fgf<gg3h6fl"))).newInstance(this.a);
                java.lang.reflect.Method declaredMethod2 = newInstance.getClass().getDeclaredMethod(cn.fly.verify.ba.a("018ejheBfngl(hVflff7hXflgmflfihj5kh>fe"), java.lang.reflect.Array.newInstance(java.lang.Class.forName(cn.fly.verify.ba.a("034^ji>f4ff'fHhfhj?he=fiflfk^k*fmhf%ehPflPk%hfihjkhijlimRhGflBk.fkghfkVefkh")), 0).getClass(), java.lang.String.class, java.lang.String.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(newInstance, objArr2, str, this.b);
                return null;
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().c(th);
                return null;
            }
        }
    }

    public static java.lang.Object a(java.lang.String str) throws java.lang.Throwable {
        java.lang.Class<?> cls = java.lang.Class.forName(cn.fly.verify.ba.a("0300ji8f-ff>fYgehfEghk=hfhjhj0i4hfihjkhijlgmflfihjCk@je]fgfRgg_hCfl"));
        return java.lang.reflect.Proxy.newProxyInstance(java.lang.ClassLoader.getSystemClassLoader(), new java.lang.Class[]{cls}, new cn.fly.verify.fc.b(str, null));
    }

    private java.lang.String a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) throws java.lang.Throwable {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : hashMap.entrySet()) {
            java.lang.String c = cn.fly.verify.fi.c(entry.getKey(), "utf-8");
            java.lang.String c2 = entry.getValue() == null ? "" : cn.fly.verify.fi.c(java.lang.String.valueOf(entry.getValue()), "utf-8");
            if (sb.length() > 0) {
                sb.append(kotlin.text.Typography.amp);
            }
            sb.append(c);
            sb.append(com.alipay.sdk.m.n.a.h);
            sb.append(c2);
        }
        return sb.toString();
    }

    private java.net.HttpURLConnection a(java.lang.String str, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        java.lang.Object obj;
        boolean z;
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        java.lang.String a2 = cn.fly.verify.ba.a("012,fh.hkjLgffegmgffnFhg1hj");
        try {
            obj = cn.fly.verify.fp.a(httpURLConnection, a2);
        } catch (java.lang.Throwable unused) {
            obj = null;
        }
        if (obj == null) {
            a2 = "PERMITTED_USER_METHODS";
            try {
                obj = cn.fly.verify.fp.c("HttpURLConnection", "PERMITTED_USER_METHODS");
            } catch (java.lang.Throwable unused2) {
            }
            z = true;
        } else {
            z = false;
        }
        if (obj != null) {
            java.lang.String[] strArr = (java.lang.String[]) obj;
            java.lang.String[] strArr2 = new java.lang.String[strArr.length + 1];
            java.lang.System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = cn.fly.verify.ba.a("0053ingngmimhl");
            if (z) {
                cn.fly.verify.fp.a("HttpURLConnection", a2, (java.lang.Object) strArr2);
            } else {
                cn.fly.verify.fp.b(httpURLConnection, a2, strArr2);
            }
        }
        java.lang.System.setProperty("http.keepAlive", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            org.apache.http.conn.ssl.X509HostnameVerifier x509HostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) httpURLConnection;
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance(cn.fly.verify.ba.a("003Dgmhegl"));
            javax.net.ssl.TrustManager[] trustManagerArr = new javax.net.ssl.TrustManager[0];
            try {
                trustManagerArr = new javax.net.ssl.TrustManager[]{(javax.net.ssl.TrustManager) a(httpsURLConnection.getURL().getHost())};
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().c(th);
            }
            sSLContext.init(null, trustManagerArr, new java.security.SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
        }
        int i = aVar == null ? a : aVar.b;
        if (i > 0) {
            httpURLConnection.setConnectTimeout(i);
        }
        int i2 = aVar == null ? b : aVar.a;
        if (i2 > 0) {
            httpURLConnection.setReadTimeout(i2);
        }
        return httpURLConnection;
    }

    @java.lang.Deprecated
    private void a(java.lang.String str, java.util.ArrayList<cn.fly.verify.fa<java.lang.String>> arrayList, java.util.ArrayList<cn.fly.verify.fa<java.lang.String>> arrayList2, cn.fly.verify.fc.a aVar, cn.fly.verify.ez ezVar) throws java.lang.Throwable {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        java.util.Iterator<cn.fly.verify.fa<java.lang.String>> it = arrayList.iterator();
        while (it.hasNext()) {
            cn.fly.verify.fa<java.lang.String> next = it.next();
            hashMap.put(next.a, next.b);
        }
        a(str, hashMap, arrayList2, aVar, ezVar);
    }

    private void a(java.net.URLConnection uRLConnection, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : hashMap.entrySet()) {
            uRLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static boolean a(java.net.HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getResponseCode() != 301 && httpURLConnection.getResponseCode() != 302 && httpURLConnection.getResponseCode() != 304 && httpURLConnection.getResponseCode() != 307) {
                if (httpURLConnection.getResponseCode() != 308) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return false;
        }
    }

    @java.lang.Deprecated
    public java.lang.String a(java.lang.String str, java.util.ArrayList<cn.fly.verify.fa<java.lang.String>> arrayList, java.util.ArrayList<cn.fly.verify.fa<java.lang.String>> arrayList2, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        java.util.HashMap hashMap = new java.util.HashMap();
        a(str, arrayList, arrayList2, aVar, new cn.fly.verify.fc.AnonymousClass2(hashMap));
        if (hashMap.containsKey(cn.fly.verify.ba.a("0037fl)h$hj"))) {
            return (java.lang.String) hashMap.get(cn.fly.verify.ba.a("003]flUhXhj"));
        }
        return null;
    }

    public java.lang.String a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.String> hashMap2) throws java.lang.Throwable {
        cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
        aVar.a = 30000;
        aVar.b = 10000;
        return a(str, hashMap, hashMap2, aVar);
    }

    public java.lang.String a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.String> hashMap2, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        java.io.InputStreamReader inputStreamReader;
        java.io.InputStreamReader inputStreamReader2;
        cn.fly.verify.ed.a().a(java.lang.String.format("hgt: %s", str) + "\n" + java.lang.String.format("hd: %s", hashMap2), new java.lang.Object[0]);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (hashMap != null) {
            java.lang.String a2 = a(hashMap);
            if (a2.length() > 0) {
                str = str + "?" + a2;
            }
        }
        java.net.HttpURLConnection a3 = a(str, aVar);
        a(a3, hashMap2);
        a3.setInstanceFollowRedirects(this.c);
        a3.connect();
        int responseCode = a3.getResponseCode();
        java.io.BufferedReader bufferedReader = null;
        if (responseCode == 200) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            try {
                inputStreamReader2 = new java.io.InputStreamReader(a3.getInputStream(), java.nio.charset.Charset.forName("utf-8"));
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(inputStreamReader2);
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                cn.fly.verify.dw.a(bufferedReader2, inputStreamReader2);
                                a3.disconnect();
                                java.lang.String sb2 = sb.toString();
                                cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
                                return sb2;
                            }
                            if (sb.length() > 0) {
                                sb.append('\n');
                            }
                            sb.append(readLine);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            cn.fly.verify.dw.a(bufferedReader, inputStreamReader2);
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                inputStreamReader2 = null;
            }
        } else {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            try {
                inputStreamReader = new java.io.InputStreamReader(a3.getErrorStream(), java.nio.charset.Charset.forName("utf-8"));
                try {
                    java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            java.lang.String readLine2 = bufferedReader3.readLine();
                            if (readLine2 == null) {
                                cn.fly.verify.dw.a(bufferedReader3, inputStreamReader);
                                a3.disconnect();
                                java.util.HashMap hashMap3 = new java.util.HashMap();
                                hashMap3.put(cn.fly.verify.ba.a("005h flflgffl"), sb3.toString());
                                hashMap3.put(cn.fly.verify.ba.a("006KhjXkfk(fihj"), java.lang.Integer.valueOf(responseCode));
                                throw new java.lang.Throwable(cn.fly.verify.fm.a(hashMap3));
                            }
                            if (sb3.length() > 0) {
                                sb3.append('\n');
                            }
                            sb3.append(readLine2);
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            bufferedReader = bufferedReader3;
                            cn.fly.verify.dw.a(bufferedReader, inputStreamReader);
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                inputStreamReader = null;
            }
        }
    }

    public void a(java.lang.String str, cn.fly.verify.fe feVar, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        a(str, new java.util.HashMap<>(), feVar, aVar);
    }

    public void a(java.lang.String str, java.io.OutputStream outputStream, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        a(str, new cn.fly.verify.fc.AnonymousClass1(new byte[1024], outputStream), aVar);
        outputStream.flush();
    }

    public void a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> hashMap, cn.fly.verify.ew ewVar, int i, cn.fly.verify.ez ezVar, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        java.io.OutputStream outputStream;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        cn.fly.verify.ed.a().a("hptr: " + str, new java.lang.Object[0]);
        java.net.HttpURLConnection a2 = a(str, aVar);
        a2.setDoOutput(true);
        if (i >= 0) {
            a2.setChunkedStreamingMode(0);
        }
        a(a2, hashMap);
        a2.setInstanceFollowRedirects(this.c);
        a2.connect();
        java.io.InputStream inputStream = null;
        try {
            outputStream = a2.getOutputStream();
            try {
                inputStream = ewVar.c();
                byte[] bArr = new byte[65536];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, read);
                    }
                }
                outputStream.flush();
                cn.fly.verify.dw.a(inputStream, outputStream);
                if (ezVar != null) {
                    try {
                        ezVar.a(new cn.fly.verify.ey(a2));
                    } finally {
                    }
                }
                a2.disconnect();
                cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                th = th;
                cn.fly.verify.dw.a(inputStream, outputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }

    public void a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> hashMap, cn.fly.verify.fe feVar, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        java.io.InputStreamReader inputStreamReader;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        cn.fly.verify.ed.a().a("rawGet: " + str, new java.lang.Object[0]);
        java.net.HttpURLConnection a2 = a(str, aVar);
        a(a2, hashMap);
        a2.setInstanceFollowRedirects(this.c);
        a2.connect();
        int responseCode = a2.getResponseCode();
        if (responseCode == 200) {
            if (feVar != null) {
                java.io.InputStream inputStream = a2.getInputStream();
                try {
                    feVar.a(inputStream);
                    cn.fly.verify.dw.a(inputStream);
                } catch (java.lang.Throwable th) {
                    try {
                        throw th;
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.dw.a(inputStream);
                        a2.disconnect();
                        throw th2;
                    }
                }
            }
            a2.disconnect();
            cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
            return;
        }
        if (a(a2)) {
            a(a2.getHeaderField(cn.fly.verify.ba.a("008:hegf.efkMfkgfJg")), new java.util.HashMap<>(), feVar, aVar);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new java.io.InputStreamReader(a2.getErrorStream(), java.nio.charset.Charset.forName("utf-8"));
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            cn.fly.verify.dw.a(bufferedReader2, inputStreamReader);
                            a2.disconnect();
                            java.util.HashMap hashMap2 = new java.util.HashMap();
                            hashMap2.put(cn.fly.verify.ba.a("005h6flflgffl"), sb.toString());
                            hashMap2.put(cn.fly.verify.ba.a("0068hj-kfkXfihj"), java.lang.Integer.valueOf(responseCode));
                            throw new java.lang.Throwable(cn.fly.verify.fm.a(hashMap2));
                        }
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(readLine);
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        cn.fly.verify.dw.a(bufferedReader, inputStreamReader);
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            inputStreamReader = null;
        }
    }

    @java.lang.Deprecated
    public void a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.ArrayList<cn.fly.verify.fa<java.lang.String>> arrayList, cn.fly.verify.fc.a aVar, cn.fly.verify.ez ezVar) throws java.lang.Throwable {
        java.io.OutputStream outputStream;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        cn.fly.verify.ed.a().c("jsonPost: " + str);
        java.net.HttpURLConnection a2 = a(str, aVar);
        a2.setDoOutput(true);
        a2.setChunkedStreamingMode(0);
        a2.setRequestProperty(com.alipay.sdk.m.p.e.f, com.baidu.mobads.sdk.internal.am.d);
        if (arrayList != null) {
            java.util.Iterator<cn.fly.verify.fa<java.lang.String>> it = arrayList.iterator();
            while (it.hasNext()) {
                cn.fly.verify.fa<java.lang.String> next = it.next();
                a2.setRequestProperty(next.a, next.b);
            }
        }
        cn.fly.verify.ff ffVar = new cn.fly.verify.ff();
        if (hashMap != null) {
            new cn.fly.verify.fm();
            ffVar.a(cn.fly.verify.fm.a((java.util.HashMap) hashMap));
        }
        a2.setInstanceFollowRedirects(this.c);
        a2.connect();
        java.io.InputStream inputStream = null;
        try {
            outputStream = a2.getOutputStream();
        } catch (java.lang.Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            inputStream = ffVar.c();
            byte[] bArr = new byte[65536];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                } else {
                    outputStream.write(bArr, 0, read);
                }
            }
            outputStream.flush();
            cn.fly.verify.dw.a(inputStream, outputStream);
            if (ezVar != null) {
                try {
                    ezVar.a(new cn.fly.verify.ey(a2));
                } finally {
                }
            }
            a2.disconnect();
            cn.fly.verify.ed.a().c("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis));
        } catch (java.lang.Throwable th2) {
            th = th2;
            cn.fly.verify.dw.a(inputStream, outputStream);
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    public void a(java.lang.String str, byte[] bArr, java.util.HashMap<java.lang.String, java.lang.String> hashMap, int i, cn.fly.verify.ez ezVar, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.OutputStream outputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.DataOutputStream dataOutputStream;
        byte[] bytes;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        cn.fly.verify.ed.a().a("hpt: " + str, new java.lang.Object[0]);
        java.net.HttpURLConnection a2 = a(str, aVar);
        a2.setDoOutput(true);
        if (i >= 0) {
            a2.setChunkedStreamingMode(0);
        }
        a(a2, hashMap);
        a2.setRequestProperty(cn.fly.verify.ba.a("010>imgfGgghekCfkgfEg"), com.anythink.expressad.foundation.g.f.g.b.c);
        a2.setRequestProperty("Content-Type", com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        a2.setInstanceFollowRedirects(this.c);
        a2.connect();
        try {
            outputStream = a2.getOutputStream();
            try {
                java.lang.String a3 = cn.fly.verify.dv.a();
                if (a3 == null) {
                    a3 = "";
                }
                bytes = a3.getBytes("utf-8");
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayInputStream = null;
                byteArrayOutputStream = null;
                dataOutputStream = null;
                a2.disconnect();
                cn.fly.verify.dw.a(byteArrayInputStream, outputStream, dataOutputStream, byteArrayOutputStream);
                cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
            outputStream = null;
        }
        try {
            dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(bytes.length);
                dataOutputStream.write(bytes);
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    byte[] bArr2 = new byte[65536];
                    for (int read = byteArrayInputStream.read(bArr2); read > 0; read = byteArrayInputStream.read(bArr2)) {
                        outputStream.write(bArr2, 0, read);
                    }
                    outputStream.flush();
                    if (ezVar != null) {
                        try {
                            ezVar.a(new cn.fly.verify.ey(a2));
                        } finally {
                        }
                    }
                    a2.disconnect();
                    a2.disconnect();
                    cn.fly.verify.dw.a(byteArrayInputStream, outputStream, dataOutputStream, byteArrayOutputStream);
                    cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    a2.disconnect();
                    cn.fly.verify.dw.a(byteArrayInputStream, outputStream, dataOutputStream, byteArrayOutputStream);
                    cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
                    throw th;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                byteArrayInputStream = null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            dataOutputStream = null;
            a2.disconnect();
            cn.fly.verify.dw.a(byteArrayInputStream, outputStream, dataOutputStream, byteArrayOutputStream);
            cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
            throw th;
        }
    }

    public java.lang.String b(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.String> hashMap2, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.OutputStream outputStream;
        java.lang.Throwable th;
        java.io.InputStreamReader inputStreamReader;
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        java.io.InputStreamReader inputStreamReader2;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        cn.fly.verify.ed.a().a("hpt: " + str + "\nhd: " + hashMap2, new java.lang.Object[0]);
        java.net.HttpURLConnection a2 = a(str, aVar);
        a2.setDoOutput(true);
        a(a2, hashMap2);
        a2.setRequestProperty(cn.fly.verify.ba.a("010Nimgf2gghek8fkgf)g"), com.anythink.expressad.foundation.g.f.g.b.c);
        a2.setRequestProperty("Content-Type", cn.fly.verify.ba.a("033flli+fkQefk4fkgfCgnXgejmhhhhhhjmghgfflfhjmfiflAihgeTgffe^hJfe"));
        cn.fly.verify.ff ffVar = new cn.fly.verify.ff();
        if (hashMap != null) {
            ffVar.a(a(hashMap));
        }
        a2.setFixedLengthStreamingMode((int) ffVar.b());
        a2.setInstanceFollowRedirects(this.c);
        a2.connect();
        try {
            outputStream = a2.getOutputStream();
            try {
                java.io.InputStream c = ffVar.c();
                try {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int read = c.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                    }
                    outputStream.flush();
                    int responseCode = a2.getResponseCode();
                    if (responseCode == 200 || responseCode < 300) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        try {
                            java.io.InputStreamReader inputStreamReader3 = new java.io.InputStreamReader(a2.getInputStream(), java.nio.charset.Charset.forName("utf-8"));
                            try {
                                java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(inputStreamReader3);
                                while (true) {
                                    try {
                                        java.lang.String readLine = bufferedReader3.readLine();
                                        if (readLine == null) {
                                            cn.fly.verify.dw.a(bufferedReader3, inputStreamReader3);
                                            java.lang.String sb2 = sb.toString();
                                            a2.disconnect();
                                            cn.fly.verify.dw.a(c, outputStream);
                                            cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
                                            return sb2;
                                        }
                                        if (sb.length() > 0) {
                                            sb.append('\n');
                                        }
                                        sb.append(readLine);
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        inputStreamReader = inputStreamReader3;
                                        bufferedReader = bufferedReader3;
                                        cn.fly.verify.dw.a(bufferedReader, inputStreamReader);
                                        throw th;
                                    }
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                inputStreamReader = inputStreamReader3;
                                bufferedReader = null;
                                cn.fly.verify.dw.a(bufferedReader, inputStreamReader);
                                throw th;
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            inputStreamReader = null;
                        }
                    } else {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        try {
                            inputStreamReader2 = new java.io.InputStreamReader(a2.getErrorStream(), java.nio.charset.Charset.forName("utf-8"));
                            try {
                                bufferedReader2 = new java.io.BufferedReader(inputStreamReader2);
                                while (true) {
                                    try {
                                        java.lang.String readLine2 = bufferedReader2.readLine();
                                        if (readLine2 == null) {
                                            cn.fly.verify.dw.a(bufferedReader2, inputStreamReader2);
                                            java.util.HashMap hashMap3 = new java.util.HashMap();
                                            hashMap3.put(cn.fly.verify.ba.a("005h_flflgffl"), sb3.toString());
                                            hashMap3.put(cn.fly.verify.ba.a("006_hjJkfk%fihj"), java.lang.Integer.valueOf(responseCode));
                                            throw new java.lang.Throwable(cn.fly.verify.fm.a(hashMap3));
                                        }
                                        if (sb3.length() > 0) {
                                            sb3.append('\n');
                                        }
                                        sb3.append(readLine2);
                                    } catch (java.lang.Throwable th5) {
                                        th = th5;
                                        cn.fly.verify.dw.a(bufferedReader2, inputStreamReader2);
                                        throw th;
                                    }
                                }
                            } catch (java.lang.Throwable th6) {
                                th = th6;
                                bufferedReader2 = null;
                            }
                        } catch (java.lang.Throwable th7) {
                            th = th7;
                            bufferedReader2 = null;
                            inputStreamReader2 = null;
                        }
                    }
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    inputStream = c;
                    a2.disconnect();
                    cn.fly.verify.dw.a(inputStream, outputStream);
                    cn.fly.verify.ed.a().a("use time: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
                    throw th;
                }
            } catch (java.lang.Throwable th9) {
                th = th9;
                inputStream = null;
            }
        } catch (java.lang.Throwable th10) {
            th = th10;
            inputStream = null;
            outputStream = null;
        }
    }
}
