package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class CompositeTrustManager implements com.commonsware.cwac.netsecurity.X509Extensions {
    private static final java.lang.ThreadLocal<java.lang.String> host = new java.lang.ThreadLocal<>();
    private boolean matchAll;
    private java.util.ArrayList<com.commonsware.cwac.netsecurity.X509Extensions> managers = new java.util.ArrayList<>();
    private java.util.ArrayList<com.commonsware.cwac.netsecurity.CertChainListener> certChainListeners = new java.util.ArrayList<>();

    public CompositeTrustManager(javax.net.ssl.X509TrustManager[] x509TrustManagerArr, boolean z) {
        if (x509TrustManagerArr != null) {
            addAll(x509TrustManagerArr);
        }
        setMatchAll(z);
    }

    public static com.commonsware.cwac.netsecurity.CompositeTrustManager matchAll(javax.net.ssl.X509TrustManager... x509TrustManagerArr) {
        return new com.commonsware.cwac.netsecurity.CompositeTrustManager(x509TrustManagerArr, true);
    }

    public static com.commonsware.cwac.netsecurity.CompositeTrustManager matchAny(javax.net.ssl.X509TrustManager... x509TrustManagerArr) {
        return new com.commonsware.cwac.netsecurity.CompositeTrustManager(x509TrustManagerArr, false);
    }

    private void passChainToListeners(java.security.cert.X509Certificate[] x509CertificateArr) {
        passChainToListeners(x509CertificateArr, host.get());
    }

    private void passChainToListeners(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) {
        java.util.Iterator<com.commonsware.cwac.netsecurity.CertChainListener> it = this.certChainListeners.iterator();
        while (it.hasNext()) {
            it.next().onChain(x509CertificateArr, str);
        }
    }

    public void add(javax.net.ssl.X509TrustManager x509TrustManager) {
        if (x509TrustManager instanceof com.commonsware.cwac.netsecurity.X509Extensions) {
            this.managers.add((com.commonsware.cwac.netsecurity.X509Extensions) x509TrustManager);
        } else {
            this.managers.add(new com.commonsware.cwac.netsecurity.X509ExtensionsWrapper(x509TrustManager));
        }
    }

    public void addAll(javax.net.ssl.X509TrustManager[] x509TrustManagerArr) {
        for (javax.net.ssl.X509TrustManager x509TrustManager : x509TrustManagerArr) {
            add(x509TrustManager);
        }
    }

    public void addCertChainListener(com.commonsware.cwac.netsecurity.CertChainListener certChainListener) {
        this.certChainListeners.add(certChainListener);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        passChainToListeners(x509CertificateArr);
        java.util.Iterator<com.commonsware.cwac.netsecurity.X509Extensions> it = this.managers.iterator();
        java.security.cert.CertificateException e = null;
        while (it.hasNext()) {
            try {
                it.next().checkClientTrusted(x509CertificateArr, str);
            } catch (java.security.cert.CertificateException e2) {
                e = e2;
                if (this.matchAll) {
                    throw e;
                }
            }
            if (!this.matchAll) {
                return;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    @Override // com.commonsware.cwac.netsecurity.X509Extensions
    public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
        passChainToListeners(x509CertificateArr, str2);
        java.util.Iterator<com.commonsware.cwac.netsecurity.X509Extensions> it = this.managers.iterator();
        java.security.cert.CertificateException e = null;
        java.util.List<java.security.cert.X509Certificate> list = null;
        boolean z = false;
        while (it.hasNext()) {
            try {
                list = it.next().checkServerTrusted(x509CertificateArr, str, str2);
                z = true;
            } catch (java.security.cert.CertificateException e2) {
                e = e2;
                if (this.matchAll) {
                    throw e;
                }
            }
        }
        if (this.matchAll || z || e == null) {
            return list;
        }
        throw e;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        java.lang.ThreadLocal<java.lang.String> threadLocal = host;
        if (threadLocal != null) {
            checkServerTrusted(x509CertificateArr, str, threadLocal.get());
            return;
        }
        passChainToListeners(x509CertificateArr);
        java.util.Iterator<com.commonsware.cwac.netsecurity.X509Extensions> it = this.managers.iterator();
        java.security.cert.CertificateException e = null;
        boolean z = false;
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                z = true;
            } catch (java.security.cert.CertificateException e2) {
                e = e2;
                if (this.matchAll) {
                    throw e;
                }
            }
        }
        if (!this.matchAll && !z && e != null) {
            throw e;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<com.commonsware.cwac.netsecurity.X509Extensions> it = this.managers.iterator();
        while (it.hasNext()) {
            for (java.security.cert.X509Certificate x509Certificate : it.next().getAcceptedIssuers()) {
                hashSet.add(x509Certificate);
            }
        }
        return (java.security.cert.X509Certificate[]) hashSet.toArray(new java.security.cert.X509Certificate[hashSet.size()]);
    }

    public boolean hasCertChainListeners() {
        return this.certChainListeners.size() > 0;
    }

    public boolean isMatchAll() {
        return this.matchAll;
    }

    @Override // com.commonsware.cwac.netsecurity.X509Extensions
    public boolean isUserAddedCertificate(java.security.cert.X509Certificate x509Certificate) {
        java.util.Iterator<com.commonsware.cwac.netsecurity.X509Extensions> it = this.managers.iterator();
        while (it.hasNext()) {
            boolean isUserAddedCertificate = it.next().isUserAddedCertificate(x509Certificate);
            if (!this.matchAll && isUserAddedCertificate) {
                return true;
            }
        }
        return false;
    }

    public void removeCertChainListener(com.commonsware.cwac.netsecurity.CertChainListener certChainListener) {
        this.certChainListeners.remove(certChainListener);
    }

    public void setHost(java.lang.String str) {
        host.set(str);
    }

    public void setMatchAll(boolean z) {
        if (this.managers.size() > 1) {
            throw new java.lang.IllegalStateException("Cannot change mode once 2+ managers added");
        }
        this.matchAll = z;
    }

    public int size() {
        return this.managers.size();
    }
}
