package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public interface X509Extensions extends javax.net.ssl.X509TrustManager {
    java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException;

    boolean isUserAddedCertificate(java.security.cert.X509Certificate x509Certificate);
}
