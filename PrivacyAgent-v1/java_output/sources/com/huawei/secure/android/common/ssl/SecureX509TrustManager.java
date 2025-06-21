package com.huawei.secure.android.common.ssl;

/* loaded from: classes22.dex */
public class SecureX509TrustManager implements javax.net.ssl.X509TrustManager {
    public static final java.lang.String c = "SecureX509TrustManager";
    public static final java.lang.String d = "hmsrootcas.bks";
    protected java.util.List<javax.net.ssl.X509TrustManager> a;
    public java.security.cert.X509Certificate[] b;

    public SecureX509TrustManager(android.content.Context context) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.KeyStoreException, java.lang.IllegalArgumentException {
        this(context, false);
    }

    public SecureX509TrustManager(android.content.Context context, boolean z) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.KeyStoreException, java.lang.IllegalArgumentException {
        this.a = new java.util.ArrayList();
        if (context == null) {
            throw new java.lang.IllegalArgumentException(com.anythink.expressad.foundation.g.b.b.a);
        }
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (z) {
            a();
        }
        b(context);
        if (this.a.isEmpty()) {
            throw new java.security.cert.CertificateException("X509TrustManager is empty");
        }
    }

    public SecureX509TrustManager(java.io.InputStream inputStream, java.lang.String str) throws java.lang.IllegalArgumentException {
        this.a = new java.util.ArrayList();
        d(inputStream, str);
    }

    public SecureX509TrustManager(java.io.InputStream inputStream, java.lang.String str, boolean z) throws java.lang.IllegalArgumentException {
        this.a = new java.util.ArrayList();
        if (z) {
            a();
        }
        d(inputStream, str);
    }

    public SecureX509TrustManager(java.lang.String str) throws java.lang.IllegalArgumentException, java.io.FileNotFoundException {
        this(str, false);
    }

    public SecureX509TrustManager(java.lang.String str, boolean z) throws java.lang.IllegalArgumentException, java.io.FileNotFoundException {
        java.io.FileInputStream fileInputStream;
        this.a = new java.util.ArrayList();
        try {
            fileInputStream = new java.io.FileInputStream(str);
            try {
                d(fileInputStream, "");
                com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) fileInputStream);
                if (z) {
                    a();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public final void a() {
        com.huawei.secure.android.common.ssl.util.g.c(c, "loadSystemCA");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidCAStore");
            keyStore.load(null, null);
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore);
            javax.net.ssl.TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (javax.net.ssl.TrustManager trustManager : trustManagers) {
                if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                    this.a.add((javax.net.ssl.X509TrustManager) trustManager);
                }
            }
        } catch (java.io.IOException | java.security.KeyStoreException | java.security.NoSuchAlgorithmException | java.security.cert.CertificateException e) {
            com.huawei.secure.android.common.ssl.util.g.b(c, "loadSystemCA: exception : " + e.getMessage());
        }
        com.huawei.secure.android.common.ssl.util.g.a(c, "loadSystemCA: cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public final void b(android.content.Context context) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.io.IOException {
        boolean z;
        java.lang.String str = c;
        com.huawei.secure.android.common.ssl.util.g.c(str, "loadBksCA");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.io.InputStream filesBksIS = com.huawei.secure.android.common.ssl.util.BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                com.huawei.secure.android.common.ssl.util.g.c(str, "get bks not from assets");
                c(filesBksIS);
            } catch (java.io.IOException | java.security.KeyStoreException | java.security.NoSuchAlgorithmException | java.security.cert.CertificateException e) {
                com.huawei.secure.android.common.ssl.util.g.b(c, "loadBksCA: exception : " + e.getMessage());
                z = false;
            }
        }
        z = true;
        if (!z || filesBksIS == null) {
            com.huawei.secure.android.common.ssl.util.g.c(c, " get bks from assets ");
            c(context.getAssets().open("hmsrootcas.bks"));
        }
        com.huawei.secure.android.common.ssl.util.g.a(c, "loadBksCA: cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public final void c(java.io.InputStream inputStream) throws java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.security.cert.CertificateException, java.io.IOException {
        try {
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance("X509");
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance(com.huawei.secure.android.common.ssl.util.j.e);
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            for (javax.net.ssl.TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                    this.a.add((javax.net.ssl.X509TrustManager) trustManager);
                }
            }
        } finally {
            com.huawei.secure.android.common.ssl.util.f.a(inputStream);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        com.huawei.secure.android.common.ssl.util.g.c(c, "checkClientTrusted: ");
        java.util.Iterator<javax.net.ssl.X509TrustManager> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (java.security.cert.CertificateException e) {
                com.huawei.secure.android.common.ssl.util.g.b(c, "checkServerTrusted CertificateException" + e.getMessage());
            }
        }
        throw new java.security.cert.CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        setChain(x509CertificateArr);
        com.huawei.secure.android.common.ssl.util.g.c(c, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length + " ,auth type is : " + str);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            java.lang.String str2 = c;
            com.huawei.secure.android.common.ssl.util.g.a(str2, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            com.huawei.secure.android.common.ssl.util.g.a(str2, "IssuerDN :" + x509Certificate.getIssuerDN());
            com.huawei.secure.android.common.ssl.util.g.a(str2, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                java.lang.String str3 = c;
                com.huawei.secure.android.common.ssl.util.g.c(str3, "check server i : " + i);
                javax.net.ssl.X509TrustManager x509TrustManager = this.a.get(i);
                java.security.cert.X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    com.huawei.secure.android.common.ssl.util.g.c(str3, "client root ca size is : " + acceptedIssuers.length);
                    for (java.security.cert.X509Certificate x509Certificate2 : acceptedIssuers) {
                        com.huawei.secure.android.common.ssl.util.g.a(c, "client root ca getIssuerDN :" + x509Certificate2.getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                com.huawei.secure.android.common.ssl.util.g.c(c, "checkServerTrusted succeed ,root ca issuer is : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (java.security.cert.CertificateException e) {
                java.lang.String str4 = c;
                com.huawei.secure.android.common.ssl.util.g.b(str4, "checkServerTrusted error :" + e.getMessage() + " , time : " + i);
                if (i == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        com.huawei.secure.android.common.ssl.util.g.b(str4, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e;
                }
            }
        }
        com.huawei.secure.android.common.ssl.util.g.a(c, "checkServerTrusted: cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public final void d(java.io.InputStream inputStream, java.lang.String str) {
        if (inputStream == null || str == null) {
            throw new java.lang.IllegalArgumentException("inputstream or trustPwd is null");
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            try {
                javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance("X509");
                java.security.KeyStore keyStore = java.security.KeyStore.getInstance(com.huawei.secure.android.common.ssl.util.j.e);
                keyStore.load(inputStream, str.toCharArray());
                trustManagerFactory.init(keyStore);
                javax.net.ssl.TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                for (javax.net.ssl.TrustManager trustManager : trustManagers) {
                    if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                        this.a.add((javax.net.ssl.X509TrustManager) trustManager);
                    }
                }
                com.huawei.secure.android.common.ssl.util.f.a(inputStream);
            } finally {
                com.huawei.secure.android.common.ssl.util.f.a(inputStream);
            }
        } catch (java.io.IOException | java.security.KeyStoreException | java.security.NoSuchAlgorithmException | java.security.cert.CertificateException e) {
            com.huawei.secure.android.common.ssl.util.g.b(c, "loadInputStream: exception : " + e.getMessage());
        }
        com.huawei.secure.android.common.ssl.util.g.a(c, "loadInputStream: cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<javax.net.ssl.X509TrustManager> it = this.a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(java.util.Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (java.security.cert.X509Certificate[]) arrayList.toArray(new java.security.cert.X509Certificate[arrayList.size()]);
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.ssl.util.g.b(c, "getAcceptedIssuers exception : " + e.getMessage());
            return new java.security.cert.X509Certificate[0];
        }
    }

    public java.security.cert.X509Certificate[] getChain() {
        return this.b;
    }

    public java.util.List<javax.net.ssl.X509TrustManager> getX509TrustManagers() {
        return this.a;
    }

    public void setChain(java.security.cert.X509Certificate[] x509CertificateArr) {
        this.b = x509CertificateArr;
    }

    public void setX509TrustManagers(java.util.List<javax.net.ssl.X509TrustManager> list) {
        this.a = list;
    }
}
