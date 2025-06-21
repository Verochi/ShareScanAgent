package com.sijla.h.c.b;

/* loaded from: classes19.dex */
public final class b implements javax.net.ssl.HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        try {
            java.lang.String peerHost = sSLSession.getPeerHost();
            for (java.security.cert.X509Certificate x509Certificate : (java.security.cert.X509Certificate[]) sSLSession.getPeerCertificates()) {
                for (java.lang.String str2 : x509Certificate.getSubjectX500Principal().getName().split(",")) {
                    if (str2.startsWith("CN") && peerHost.equals(str) && str2.contains("qchannel")) {
                        return true;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
