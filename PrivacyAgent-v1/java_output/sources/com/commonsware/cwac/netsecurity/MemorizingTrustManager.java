package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class MemorizingTrustManager implements com.commonsware.cwac.netsecurity.X509Extensions {
    private final com.commonsware.cwac.netsecurity.DomainMatchRule domainMatchRule;
    private final boolean noTOFU;
    private final boolean onlySingleItemChains;
    private final char[] storePassword;
    private final java.lang.String storeType;
    private final android.util.LruCache<java.lang.String, com.commonsware.cwac.netsecurity.MemorizingTrustManager.MemorizingStore> stores;
    private final java.io.File workingDir;

    public static class Builder {
        private com.commonsware.cwac.netsecurity.DomainMatchRule domainMatchRule;
        private char[] storePassword;
        private java.lang.String storeType;
        private java.io.File workingDir = null;
        private boolean noTOFU = false;
        private int cacheSize = 128;
        private boolean onlySingleItemChains = false;

        public com.commonsware.cwac.netsecurity.MemorizingTrustManager build() {
            java.io.File file = this.workingDir;
            if (file == null) {
                throw new java.lang.IllegalStateException("You have not configured this builder!");
            }
            file.mkdirs();
            return new com.commonsware.cwac.netsecurity.MemorizingTrustManager(this.workingDir, this.storePassword, this.storeType, this.noTOFU, this.cacheSize, this.domainMatchRule, this.onlySingleItemChains, null);
        }

        public com.commonsware.cwac.netsecurity.MemorizingTrustManager.Builder cacheSize(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("Please provide a sensible cache size");
            }
            this.cacheSize = i;
            return this;
        }

        public com.commonsware.cwac.netsecurity.MemorizingTrustManager.Builder forDomains(com.commonsware.cwac.netsecurity.DomainMatchRule domainMatchRule) {
            this.domainMatchRule = domainMatchRule;
            return this;
        }

        public com.commonsware.cwac.netsecurity.MemorizingTrustManager.Builder noTOFU() {
            this.noTOFU = true;
            return this;
        }

        public com.commonsware.cwac.netsecurity.MemorizingTrustManager.Builder onlySingleItemChains() {
            this.onlySingleItemChains = true;
            return this;
        }

        public com.commonsware.cwac.netsecurity.MemorizingTrustManager.Builder saveTo(java.io.File file, char[] cArr) {
            return saveTo(file, cArr, java.security.KeyStore.getDefaultType());
        }

        public com.commonsware.cwac.netsecurity.MemorizingTrustManager.Builder saveTo(java.io.File file, char[] cArr, java.lang.String str) {
            this.workingDir = file;
            this.storePassword = cArr;
            this.storeType = str;
            return this;
        }
    }

    public static class MemorizingStore {
        private final java.lang.String host;
        private java.security.KeyStore keyStore;
        private final boolean noTOFU;
        private final java.io.File store;
        private final char[] storePassword;
        private javax.net.ssl.X509TrustManager storeTrustManager;
        private final java.lang.String storeType;
        private java.security.KeyStore transientKeyStore;
        private javax.net.ssl.X509TrustManager transientTrustManager;

        public MemorizingStore(java.lang.String str, java.io.File file, char[] cArr, java.lang.String str2, boolean z) throws java.lang.Exception {
            this.host = str;
            this.store = new java.io.File(file, str);
            this.storePassword = cArr;
            this.storeType = str2;
            this.noTOFU = z;
            init();
        }

        private javax.net.ssl.X509TrustManager findX509TrustManager(javax.net.ssl.TrustManagerFactory trustManagerFactory) {
            for (javax.net.ssl.TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                    return (javax.net.ssl.X509TrustManager) trustManager;
                }
            }
            return null;
        }

        private void init() throws java.lang.Exception {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance(this.storeType);
            this.transientKeyStore = keyStore;
            keyStore.load(null, null);
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(this.transientKeyStore);
            this.transientTrustManager = findX509TrustManager(trustManagerFactory);
            this.keyStore = java.security.KeyStore.getInstance(this.storeType);
            if (this.store.exists()) {
                this.keyStore.load(new java.io.FileInputStream(this.store), this.storePassword);
            } else {
                this.keyStore.load(null, this.storePassword);
            }
            javax.net.ssl.TrustManagerFactory trustManagerFactory2 = javax.net.ssl.TrustManagerFactory.getInstance("X509");
            trustManagerFactory2.init(this.keyStore);
            this.storeTrustManager = findX509TrustManager(trustManagerFactory2);
        }

        public synchronized void checkServerTrusted(@androidx.annotation.NonNull java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
            try {
                try {
                    this.storeTrustManager.checkServerTrusted(x509CertificateArr, str);
                } catch (java.security.cert.CertificateException unused) {
                    this.transientTrustManager.checkServerTrusted(x509CertificateArr, str);
                }
            } catch (java.security.cert.CertificateException e) {
                try {
                    if (this.keyStore.size() == 0 && this.transientKeyStore.size() == 0) {
                        if (this.noTOFU) {
                            throw new com.commonsware.cwac.netsecurity.CertificateNotMemorizedException(x509CertificateArr, this.host);
                        }
                        try {
                            memorize(x509CertificateArr);
                            return;
                        } catch (java.lang.Exception e2) {
                            throw new java.security.cert.CertificateException("Problem while memorizing", e2);
                        }
                    }
                } catch (java.security.KeyStoreException unused2) {
                }
                throw new com.commonsware.cwac.netsecurity.MemorizationMismatchException(x509CertificateArr, this.host, e);
            }
        }

        public synchronized void clear(boolean z) throws java.lang.Exception {
            if (z) {
                this.store.delete();
            }
            init();
        }

        public synchronized void memorize(@androidx.annotation.NonNull java.security.cert.X509Certificate[] x509CertificateArr) throws java.lang.Exception {
            for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
                this.keyStore.setCertificateEntry(x509Certificate.getSubjectDN().getName(), x509Certificate);
            }
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(this.keyStore);
            this.storeTrustManager = findX509TrustManager(trustManagerFactory);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(this.store);
            this.keyStore.store(fileOutputStream, this.storePassword);
            fileOutputStream.flush();
            fileOutputStream.close();
        }

        public synchronized void memorizeForNow(@androidx.annotation.NonNull java.security.cert.X509Certificate[] x509CertificateArr) throws java.lang.Exception {
            for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
                this.transientKeyStore.setCertificateEntry(x509Certificate.getSubjectDN().getName(), x509Certificate);
            }
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(this.transientKeyStore);
            this.transientTrustManager = findX509TrustManager(trustManagerFactory);
        }
    }

    private MemorizingTrustManager(java.io.File file, char[] cArr, java.lang.String str, boolean z, int i, com.commonsware.cwac.netsecurity.DomainMatchRule domainMatchRule, boolean z2) {
        this.workingDir = file;
        this.storePassword = cArr;
        this.storeType = str;
        this.noTOFU = z;
        this.stores = new android.util.LruCache<>(i);
        this.domainMatchRule = domainMatchRule;
        this.onlySingleItemChains = z2;
    }

    public /* synthetic */ MemorizingTrustManager(java.io.File file, char[] cArr, java.lang.String str, boolean z, int i, com.commonsware.cwac.netsecurity.DomainMatchRule domainMatchRule, boolean z2, com.commonsware.cwac.netsecurity.MemorizingTrustManager.AnonymousClass1 anonymousClass1) {
        this(file, cArr, str, z, i, domainMatchRule, z2);
    }

    private com.commonsware.cwac.netsecurity.MemorizingTrustManager.MemorizingStore getStoreForHost(java.lang.String str) throws java.lang.Exception {
        com.commonsware.cwac.netsecurity.MemorizingTrustManager.MemorizingStore memorizingStore;
        synchronized (this) {
            memorizingStore = this.stores.get(str);
            if (memorizingStore == null) {
                memorizingStore = new com.commonsware.cwac.netsecurity.MemorizingTrustManager.MemorizingStore(str, this.workingDir, this.storePassword, this.storeType, this.noTOFU);
                this.stores.put(str, memorizingStore);
            }
        }
        return memorizingStore;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(@androidx.annotation.NonNull java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        throw new java.lang.UnsupportedOperationException("Client checks not supported");
    }

    @Override // com.commonsware.cwac.netsecurity.X509Extensions
    public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(@androidx.annotation.NonNull java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
        com.commonsware.cwac.netsecurity.DomainMatchRule domainMatchRule;
        if ((!this.onlySingleItemChains || x509CertificateArr.length == 1) && ((domainMatchRule = this.domainMatchRule) == null || domainMatchRule.matches(str2))) {
            try {
                getStoreForHost(str2).checkServerTrusted(x509CertificateArr, str);
            } catch (java.lang.Exception e) {
                if ((e instanceof com.commonsware.cwac.netsecurity.CertificateNotMemorizedException) || (e instanceof com.commonsware.cwac.netsecurity.MemorizationMismatchException)) {
                    throw ((java.security.cert.CertificateException) e);
                }
                throw new java.security.cert.CertificateException("Exception setting up memoization", e);
            }
        }
        return java.util.Arrays.asList(x509CertificateArr);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(@androidx.annotation.NonNull java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        throw new java.lang.IllegalStateException("Must use three-parameter checkServerTrusted()");
    }

    public void clear(java.lang.String str, boolean z) throws java.lang.Exception {
        getStoreForHost(str).clear(z);
    }

    public synchronized void clearAll(boolean z) throws java.lang.Exception {
        java.util.Iterator<java.lang.String> it = this.stores.snapshot().keySet().iterator();
        while (it.hasNext()) {
            clear(it.next(), z);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[0];
    }

    @Override // com.commonsware.cwac.netsecurity.X509Extensions
    public boolean isUserAddedCertificate(java.security.cert.X509Certificate x509Certificate) {
        return false;
    }

    public void memorize(@androidx.annotation.NonNull com.commonsware.cwac.netsecurity.MemorizationException memorizationException) throws java.lang.Exception {
        getStoreForHost(memorizationException.host).memorize(memorizationException.chain);
    }

    public synchronized void memorizeForNow(@androidx.annotation.NonNull com.commonsware.cwac.netsecurity.MemorizationException memorizationException) throws java.lang.Exception {
        getStoreForHost(memorizationException.host).memorizeForNow(memorizationException.chain);
    }
}
