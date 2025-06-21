package com.huawei.secure.android.common.ssl.util;

/* loaded from: classes22.dex */
public final class CertificateUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    public static java.security.cert.X509Certificate getHwCbgRootCA(android.content.Context context) {
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2 = null;
        java.security.cert.X509Certificate x509Certificate = null;
        try {
            try {
                java.security.KeyStore keyStore = java.security.KeyStore.getInstance(com.huawei.secure.android.common.ssl.util.j.e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
                try {
                    inputStream.reset();
                    keyStore.load(inputStream, "".toCharArray());
                    x509Certificate = (java.security.cert.X509Certificate) keyStore.getCertificate(com.huawei.secure.android.common.ssl.util.j.f);
                    context = inputStream;
                } catch (java.io.IOException e) {
                    e = e;
                    com.huawei.secure.android.common.ssl.util.g.b("CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
                    return x509Certificate;
                } catch (java.security.KeyStoreException e2) {
                    e = e2;
                    com.huawei.secure.android.common.ssl.util.g.b("CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
                    return x509Certificate;
                } catch (java.security.NoSuchAlgorithmException e3) {
                    e = e3;
                    com.huawei.secure.android.common.ssl.util.g.b("CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
                    return x509Certificate;
                } catch (java.security.cert.CertificateException e4) {
                    e = e4;
                    com.huawei.secure.android.common.ssl.util.g.b("CertificateUtil", "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
                    return x509Certificate;
                }
            } catch (java.lang.Throwable th) {
                inputStream2 = context;
                th = th;
                com.huawei.secure.android.common.ssl.util.f.a(inputStream2);
                throw th;
            }
        } catch (java.io.IOException e5) {
            e = e5;
            inputStream = null;
            com.huawei.secure.android.common.ssl.util.g.b("CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
            return x509Certificate;
        } catch (java.security.KeyStoreException e6) {
            e = e6;
            inputStream = null;
            com.huawei.secure.android.common.ssl.util.g.b("CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
            return x509Certificate;
        } catch (java.security.NoSuchAlgorithmException e7) {
            e = e7;
            inputStream = null;
            com.huawei.secure.android.common.ssl.util.g.b("CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
            return x509Certificate;
        } catch (java.security.cert.CertificateException e8) {
            e = e8;
            inputStream = null;
            com.huawei.secure.android.common.ssl.util.g.b("CertificateUtil", "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
            return x509Certificate;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.huawei.secure.android.common.ssl.util.f.a(inputStream2);
            throw th;
        }
        com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) context);
        return x509Certificate;
    }
}
