package com.huawei.secure.android.common.ssl.util;

/* loaded from: classes22.dex */
public class j {
    public static final java.lang.String c = "hmsrootcas.bks";
    public static final java.lang.String d = "";
    public static final java.lang.String e = "bks";
    public static final java.lang.String f = "052root";
    public android.content.Context a;

    public j(android.content.Context context) {
        this.a = context;
    }

    public java.security.cert.X509Certificate a() {
        return a("hmsincas.bks", "huawei cbg application integration ca");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public java.security.cert.X509Certificate a(java.lang.String str, java.lang.String str2) {
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2 = null;
        java.security.cert.X509Certificate x509Certificate = null;
        try {
            try {
                java.security.KeyStore keyStore = java.security.KeyStore.getInstance(e);
                inputStream = this.a.getAssets().open(str);
                try {
                    inputStream.reset();
                    keyStore.load(inputStream, "".toCharArray());
                    x509Certificate = (java.security.cert.X509Certificate) keyStore.getCertificate(str2);
                    str = inputStream;
                } catch (java.io.IOException e2) {
                    e = e2;
                    com.huawei.secure.android.common.ssl.util.g.b("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    str = inputStream;
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
                    return x509Certificate;
                } catch (java.security.KeyStoreException e3) {
                    e = e3;
                    com.huawei.secure.android.common.ssl.util.g.b("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    str = inputStream;
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
                    return x509Certificate;
                } catch (java.security.NoSuchAlgorithmException e4) {
                    e = e4;
                    com.huawei.secure.android.common.ssl.util.g.b("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    str = inputStream;
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
                    return x509Certificate;
                } catch (java.security.cert.CertificateException e5) {
                    e = e5;
                    com.huawei.secure.android.common.ssl.util.g.b("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    str = inputStream;
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
                    return x509Certificate;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream2 = str;
                com.huawei.secure.android.common.ssl.util.f.a(inputStream2);
                throw th;
            }
        } catch (java.io.IOException e6) {
            e = e6;
            inputStream = null;
            com.huawei.secure.android.common.ssl.util.g.b("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            str = inputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
            return x509Certificate;
        } catch (java.security.KeyStoreException e7) {
            e = e7;
            inputStream = null;
            com.huawei.secure.android.common.ssl.util.g.b("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            str = inputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
            return x509Certificate;
        } catch (java.security.NoSuchAlgorithmException e8) {
            e = e8;
            inputStream = null;
            com.huawei.secure.android.common.ssl.util.g.b("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            str = inputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
            return x509Certificate;
        } catch (java.security.cert.CertificateException e9) {
            e = e9;
            inputStream = null;
            com.huawei.secure.android.common.ssl.util.g.b("X509CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            str = inputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
            return x509Certificate;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.huawei.secure.android.common.ssl.util.f.a(inputStream2);
            throw th;
        }
        com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) str);
        return x509Certificate;
    }

    public java.security.cert.X509Certificate b() {
        return a("hmsrootcas.bks", f);
    }
}
