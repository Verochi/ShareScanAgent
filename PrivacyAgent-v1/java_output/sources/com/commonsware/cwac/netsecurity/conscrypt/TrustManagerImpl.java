package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public final class TrustManagerImpl extends com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager {
    private static final com.commonsware.cwac.netsecurity.conscrypt.TrustManagerImpl.TrustAnchorComparator TRUST_ANCHOR_COMPARATOR = new com.commonsware.cwac.netsecurity.conscrypt.TrustManagerImpl.TrustAnchorComparator(null);
    private final java.security.cert.X509Certificate[] acceptedIssuers;
    private final java.lang.Exception err;
    private final java.security.cert.CertificateFactory factory;
    private final com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex intermediateIndex;
    private com.commonsware.cwac.netsecurity.conscrypt.CertPinManager pinManager;
    private final java.security.KeyStore rootKeyStore;
    private final com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex trustedCertificateIndex;
    private final com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore;
    private final java.security.cert.CertPathValidator validator;

    public static class ExtendedKeyUsagePKIXCertPathChecker extends java.security.cert.PKIXCertPathChecker {
        private static final java.lang.String EKU_anyExtendedKeyUsage = "2.5.29.37.0";
        private static final java.lang.String EKU_clientAuth = "1.3.6.1.5.5.7.3.2";
        private static final java.lang.String EKU_msSGC = "1.3.6.1.4.1.311.10.3.3";
        private static final java.lang.String EKU_nsSGC = "2.16.840.1.113730.4.1";
        private static final java.lang.String EKU_serverAuth = "1.3.6.1.5.5.7.3.1";
        private final boolean clientAuth;
        private final java.security.cert.X509Certificate leaf;
        private static final java.lang.String EKU_OID = "2.5.29.37";
        private static final java.util.Set<java.lang.String> SUPPORTED_EXTENSIONS = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList(EKU_OID)));

        private ExtendedKeyUsagePKIXCertPathChecker(boolean z, java.security.cert.X509Certificate x509Certificate) {
            this.clientAuth = z;
            this.leaf = x509Certificate;
        }

        public /* synthetic */ ExtendedKeyUsagePKIXCertPathChecker(boolean z, java.security.cert.X509Certificate x509Certificate, com.commonsware.cwac.netsecurity.conscrypt.TrustManagerImpl.AnonymousClass1 anonymousClass1) {
            this(z, x509Certificate);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
        
            r5.remove(com.commonsware.cwac.netsecurity.conscrypt.TrustManagerImpl.ExtendedKeyUsagePKIXCertPathChecker.EKU_OID);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
        
            return;
         */
        @Override // java.security.cert.PKIXCertPathChecker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void check(java.security.cert.Certificate certificate, java.util.Collection<java.lang.String> collection) throws java.security.cert.CertPathValidatorException {
            boolean z;
            java.security.cert.X509Certificate x509Certificate = this.leaf;
            if (certificate != x509Certificate) {
                return;
            }
            try {
                java.util.List<java.lang.String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
                if (extendedKeyUsage == null) {
                    return;
                }
                java.util.Iterator<java.lang.String> it = extendedKeyUsage.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    java.lang.String next = it.next();
                    z = true;
                    if (!next.equals(EKU_anyExtendedKeyUsage)) {
                        if (!this.clientAuth) {
                            if (next.equals(EKU_serverAuth) || next.equals(EKU_nsSGC) || next.equals(EKU_msSGC)) {
                                break;
                            }
                        } else if (next.equals(EKU_clientAuth)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                throw new java.security.cert.CertPathValidatorException("End-entity certificate does not have a valid extendedKeyUsage.");
            } catch (java.security.cert.CertificateParsingException e) {
                throw new java.security.cert.CertPathValidatorException(e);
            }
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public java.util.Set<java.lang.String> getSupportedExtensions() {
            return SUPPORTED_EXTENSIONS;
        }

        @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
        public void init(boolean z) throws java.security.cert.CertPathValidatorException {
        }

        @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
        public boolean isForwardCheckingSupported() {
            return true;
        }
    }

    public static class TrustAnchorComparator implements java.util.Comparator<java.security.cert.TrustAnchor> {
        private static final com.commonsware.cwac.netsecurity.conscrypt.CertificatePriorityComparator CERT_COMPARATOR = new com.commonsware.cwac.netsecurity.conscrypt.CertificatePriorityComparator();

        private TrustAnchorComparator() {
        }

        public /* synthetic */ TrustAnchorComparator(com.commonsware.cwac.netsecurity.conscrypt.TrustManagerImpl.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(java.security.cert.TrustAnchor trustAnchor, java.security.cert.TrustAnchor trustAnchor2) {
            return CERT_COMPARATOR.compare(trustAnchor.getTrustedCert(), trustAnchor2.getTrustedCert());
        }
    }

    public TrustManagerImpl(java.security.KeyStore keyStore) {
        this(keyStore, null);
    }

    public TrustManagerImpl(java.security.KeyStore keyStore, com.commonsware.cwac.netsecurity.conscrypt.CertPinManager certPinManager) {
        this(keyStore, certPinManager, null);
    }

    public TrustManagerImpl(java.security.KeyStore keyStore, com.commonsware.cwac.netsecurity.conscrypt.CertPinManager certPinManager, com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore) {
        this(keyStore, certPinManager, trustedCertificateStore, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TrustManagerImpl(java.security.KeyStore keyStore, com.commonsware.cwac.netsecurity.conscrypt.CertPinManager certPinManager, com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore, java.lang.Object obj) {
        com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore2;
        com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore3;
        java.security.cert.CertPathValidator certPathValidator;
        java.lang.Exception exc;
        java.security.cert.CertificateFactory certificateFactory;
        com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore4;
        java.security.cert.CertPathValidator certPathValidator2;
        java.security.cert.CertificateFactory certificateFactory2;
        java.security.cert.X509Certificate[] x509CertificateArr;
        com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore5;
        com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex trustedCertificateIndex;
        java.lang.Object obj2;
        com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex trustedCertificateIndex2 = null;
        try {
            certPathValidator2 = java.security.cert.CertPathValidator.getInstance("PKIX");
            try {
                certificateFactory2 = java.security.cert.CertificateFactory.getInstance("X509");
                try {
                    if ("AndroidCAStore".equals(keyStore.getType())) {
                        if (trustedCertificateStore == null) {
                            try {
                                trustedCertificateStore = new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore();
                            } catch (java.lang.Exception e) {
                                e = e;
                                trustedCertificateStore5 = null;
                                exc = e;
                                certificateFactory = certificateFactory2;
                                certPathValidator = certPathValidator2;
                                trustedCertificateStore3 = trustedCertificateStore5;
                                trustedCertificateStore2 = trustedCertificateStore5;
                                java.security.cert.CertificateFactory certificateFactory3 = certificateFactory;
                                trustedCertificateStore4 = trustedCertificateStore3;
                                certPathValidator2 = certPathValidator;
                                certificateFactory2 = certificateFactory3;
                                x509CertificateArr = trustedCertificateStore2;
                                if (certPinManager == null) {
                                }
                                this.rootKeyStore = keyStore;
                                this.trustedCertificateStore = trustedCertificateStore4;
                                this.validator = certPathValidator2;
                                this.factory = certificateFactory2;
                                this.trustedCertificateIndex = trustedCertificateIndex2;
                                this.intermediateIndex = new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex();
                                this.acceptedIssuers = x509CertificateArr;
                                this.err = exc;
                            }
                        }
                        try {
                            trustedCertificateIndex = new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex();
                            trustedCertificateStore4 = trustedCertificateStore;
                            obj2 = null;
                        } catch (java.lang.Exception e2) {
                            exc = e2;
                            certificateFactory = certificateFactory2;
                            certPathValidator = certPathValidator2;
                            trustedCertificateStore3 = trustedCertificateStore;
                            trustedCertificateStore2 = null;
                            java.security.cert.CertificateFactory certificateFactory32 = certificateFactory;
                            trustedCertificateStore4 = trustedCertificateStore3;
                            certPathValidator2 = certPathValidator;
                            certificateFactory2 = certificateFactory32;
                            x509CertificateArr = trustedCertificateStore2;
                            if (certPinManager == null) {
                            }
                            this.rootKeyStore = keyStore;
                            this.trustedCertificateStore = trustedCertificateStore4;
                            this.validator = certPathValidator2;
                            this.factory = certificateFactory2;
                            this.trustedCertificateIndex = trustedCertificateIndex2;
                            this.intermediateIndex = new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex();
                            this.acceptedIssuers = x509CertificateArr;
                            this.err = exc;
                        }
                    } else {
                        try {
                            java.security.cert.X509Certificate[] acceptedIssuers = acceptedIssuers(keyStore);
                            try {
                                trustedCertificateIndex = new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex(trustAnchors(acceptedIssuers));
                                trustedCertificateStore4 = trustedCertificateStore;
                                obj2 = acceptedIssuers;
                                keyStore = null;
                            } catch (java.lang.Exception e3) {
                                exc = e3;
                                certificateFactory = certificateFactory2;
                                certPathValidator = certPathValidator2;
                                trustedCertificateStore3 = trustedCertificateStore;
                                trustedCertificateStore2 = acceptedIssuers;
                                keyStore = null;
                                java.security.cert.CertificateFactory certificateFactory322 = certificateFactory;
                                trustedCertificateStore4 = trustedCertificateStore3;
                                certPathValidator2 = certPathValidator;
                                certificateFactory2 = certificateFactory322;
                                x509CertificateArr = trustedCertificateStore2;
                                if (certPinManager == null) {
                                }
                                this.rootKeyStore = keyStore;
                                this.trustedCertificateStore = trustedCertificateStore4;
                                this.validator = certPathValidator2;
                                this.factory = certificateFactory2;
                                this.trustedCertificateIndex = trustedCertificateIndex2;
                                this.intermediateIndex = new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex();
                                this.acceptedIssuers = x509CertificateArr;
                                this.err = exc;
                            }
                        } catch (java.lang.Exception e4) {
                            keyStore = null;
                            exc = e4;
                            certificateFactory = certificateFactory2;
                            certPathValidator = certPathValidator2;
                            trustedCertificateStore3 = trustedCertificateStore;
                            trustedCertificateStore2 = null;
                        }
                    }
                    com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex trustedCertificateIndex3 = trustedCertificateIndex;
                    exc = null;
                    trustedCertificateIndex2 = trustedCertificateIndex3;
                    x509CertificateArr = obj2;
                } catch (java.lang.Exception e5) {
                    e = e5;
                    keyStore = null;
                    trustedCertificateStore5 = null;
                }
            } catch (java.lang.Exception e6) {
                keyStore = null;
                trustedCertificateStore2 = null;
                certPathValidator = certPathValidator2;
                exc = e6;
                trustedCertificateStore3 = null;
                certificateFactory = null;
            }
        } catch (java.lang.Exception e7) {
            keyStore = null;
            trustedCertificateStore2 = null;
            trustedCertificateStore3 = null;
            certPathValidator = null;
            exc = e7;
            certificateFactory = null;
        }
        if (certPinManager == null) {
            this.pinManager = certPinManager;
        } else {
            try {
                this.pinManager = new com.commonsware.cwac.netsecurity.conscrypt.CertPinManager(trustedCertificateStore4);
            } catch (com.commonsware.cwac.netsecurity.conscrypt.PinManagerException e8) {
                throw new java.lang.SecurityException("Could not initialize CertPinManager", e8);
            }
        }
        this.rootKeyStore = keyStore;
        this.trustedCertificateStore = trustedCertificateStore4;
        this.validator = certPathValidator2;
        this.factory = certificateFactory2;
        this.trustedCertificateIndex = trustedCertificateIndex2;
        this.intermediateIndex = new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateIndex();
        this.acceptedIssuers = x509CertificateArr;
        this.err = exc;
    }

    private static java.security.cert.X509Certificate[] acceptedIssuers(java.security.KeyStore keyStore) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Enumeration<java.lang.String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) keyStore.getCertificate(aliases.nextElement());
                if (x509Certificate != null) {
                    arrayList.add(x509Certificate);
                }
            }
            return (java.security.cert.X509Certificate[]) arrayList.toArray(new java.security.cert.X509Certificate[arrayList.size()]);
        } catch (java.security.KeyStoreException unused) {
            return new java.security.cert.X509Certificate[0];
        }
    }

    private java.util.List<java.security.cert.X509Certificate> checkTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2, boolean z) throws java.security.cert.CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0 || str == null || str.length() == 0) {
            throw new java.lang.IllegalArgumentException("null or zero-length parameter");
        }
        if (this.err != null) {
            throw new java.security.cert.CertificateException(this.err);
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.ArrayList<java.security.cert.X509Certificate> arrayList = new java.util.ArrayList<>();
        java.util.ArrayList<java.security.cert.TrustAnchor> arrayList2 = new java.util.ArrayList<>();
        java.security.cert.X509Certificate x509Certificate = x509CertificateArr[0];
        java.security.cert.TrustAnchor findTrustAnchorBySubjectAndPublicKey = findTrustAnchorBySubjectAndPublicKey(x509Certificate);
        if (findTrustAnchorBySubjectAndPublicKey != null) {
            arrayList2.add(findTrustAnchorBySubjectAndPublicKey);
            hashSet.add(findTrustAnchorBySubjectAndPublicKey.getTrustedCert());
        } else {
            arrayList.add(x509Certificate);
        }
        hashSet.add(x509Certificate);
        return checkTrustedRecursive(x509CertificateArr, str2, z, arrayList, arrayList2, hashSet);
    }

    private java.util.List<java.security.cert.X509Certificate> checkTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLSession sSLSession, javax.net.ssl.SSLParameters sSLParameters, boolean z) throws java.security.cert.CertificateException {
        java.lang.String peerHost = sSLSession != null ? sSLSession.getPeerHost() : null;
        if (sSLSession != null && sSLParameters != null) {
            try {
                java.lang.reflect.Method method = sSLParameters.getClass().getMethod("getEndpointIdentificationAlgorithm", new java.lang.Class[0]);
                if (method != null) {
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return checkTrusted(x509CertificateArr, str, peerHost, z);
    }

    private java.util.List<java.security.cert.X509Certificate> checkTrustedRecursive(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, boolean z, java.util.ArrayList<java.security.cert.X509Certificate> arrayList, java.util.ArrayList<java.security.cert.TrustAnchor> arrayList2, java.util.Set<java.security.cert.X509Certificate> set) throws java.security.cert.CertificateException {
        java.security.cert.X509Certificate trustedCert = arrayList2.isEmpty() ? arrayList.get(arrayList.size() - 1) : arrayList2.get(arrayList2.size() - 1).getTrustedCert();
        if (trustedCert.getIssuerDN().equals(trustedCert.getSubjectDN())) {
            return verifyChain(arrayList, arrayList2, str, z);
        }
        boolean z2 = false;
        java.security.cert.CertificateException e = null;
        for (java.security.cert.TrustAnchor trustAnchor : sortPotentialAnchors(findAllTrustAnchorsByIssuerAndSignature(trustedCert))) {
            java.security.cert.X509Certificate trustedCert2 = trustAnchor.getTrustedCert();
            if (!set.contains(trustedCert2)) {
                set.add(trustedCert2);
                arrayList2.add(trustAnchor);
                try {
                    return checkTrustedRecursive(x509CertificateArr, str, z, arrayList, arrayList2, set);
                } catch (java.security.cert.CertificateException e2) {
                    e = e2;
                    arrayList2.remove(arrayList2.size() - 1);
                    set.remove(trustedCert2);
                    z2 = true;
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            if (z2) {
                throw e;
            }
            return verifyChain(arrayList, arrayList2, str, z);
        }
        for (int i = 1; i < x509CertificateArr.length; i++) {
            java.security.cert.X509Certificate x509Certificate = x509CertificateArr[i];
            if (!set.contains(x509Certificate) && trustedCert.getIssuerDN().equals(x509Certificate.getSubjectDN())) {
                try {
                    x509Certificate.checkValidity();
                    com.commonsware.cwac.netsecurity.conscrypt.ChainStrengthAnalyzer.checkCert(x509Certificate);
                    set.add(x509Certificate);
                    arrayList.add(x509Certificate);
                    try {
                        return checkTrustedRecursive(x509CertificateArr, str, z, arrayList, arrayList2, set);
                    } catch (java.security.cert.CertificateException e3) {
                        e = e3;
                        set.remove(x509Certificate);
                        arrayList.remove(arrayList.size() - 1);
                    }
                } catch (java.security.cert.CertificateException e4) {
                    e = new java.security.cert.CertificateException("Unacceptable certificate: " + x509Certificate.getSubjectX500Principal(), e4);
                }
            }
        }
        java.util.Iterator<java.security.cert.TrustAnchor> it = sortPotentialAnchors(this.intermediateIndex.findAllByIssuerAndSignature(trustedCert)).iterator();
        while (it.hasNext()) {
            java.security.cert.X509Certificate trustedCert3 = it.next().getTrustedCert();
            if (!set.contains(trustedCert3)) {
                set.add(trustedCert3);
                arrayList.add(trustedCert3);
                try {
                    return checkTrustedRecursive(x509CertificateArr, str, z, arrayList, arrayList2, set);
                } catch (java.security.cert.CertificateException e5) {
                    e = e5;
                    arrayList.remove(arrayList.size() - 1);
                    set.remove(trustedCert3);
                }
            }
        }
        if (e != null) {
            throw e;
        }
        throw new java.security.cert.CertificateException(new java.security.cert.CertPathValidatorException("Trust anchor for certification path not found.", null, this.factory.generateCertPath(arrayList), -1));
    }

    private java.util.Set<java.security.cert.TrustAnchor> findAllTrustAnchorsByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore;
        java.util.Set<java.security.cert.TrustAnchor> findAllByIssuerAndSignature = this.trustedCertificateIndex.findAllByIssuerAndSignature(x509Certificate);
        if (findAllByIssuerAndSignature.isEmpty() && (trustedCertificateStore = this.trustedCertificateStore) != null) {
            java.util.Set<java.security.cert.X509Certificate> findAllIssuers = trustedCertificateStore.findAllIssuers(x509Certificate);
            if (findAllIssuers.isEmpty()) {
                return findAllByIssuerAndSignature;
            }
            findAllByIssuerAndSignature = new java.util.HashSet<>(findAllIssuers.size());
            java.util.Iterator<java.security.cert.X509Certificate> it = findAllIssuers.iterator();
            while (it.hasNext()) {
                findAllByIssuerAndSignature.add(this.trustedCertificateIndex.index(it.next()));
            }
        }
        return findAllByIssuerAndSignature;
    }

    private java.security.cert.TrustAnchor findTrustAnchorBySubjectAndPublicKey(java.security.cert.X509Certificate x509Certificate) {
        java.security.cert.X509Certificate trustAnchor;
        java.security.cert.TrustAnchor findBySubjectAndPublicKey = this.trustedCertificateIndex.findBySubjectAndPublicKey(x509Certificate);
        if (findBySubjectAndPublicKey != null) {
            return findBySubjectAndPublicKey;
        }
        com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore trustedCertificateStore = this.trustedCertificateStore;
        if (trustedCertificateStore == null || (trustAnchor = trustedCertificateStore.getTrustAnchor(x509Certificate)) == null) {
            return null;
        }
        return new java.security.cert.TrustAnchor(trustAnchor, null);
    }

    private static javax.net.ssl.SSLSession getHandshakeSessionOrThrow(javax.net.ssl.SSLSocket sSLSocket) throws java.security.cert.CertificateException {
        javax.net.ssl.SSLSession sSLSession = null;
        try {
            java.lang.reflect.Method method = sSLSocket.getClass().getMethod("getHandshakeSession", new java.lang.Class[0]);
            if (method != null) {
                sSLSession = (javax.net.ssl.SSLSession) method.invoke(sSLSocket, new java.lang.Object[0]);
            }
        } catch (java.lang.Exception unused) {
        }
        if (sSLSession != null) {
            return sSLSession;
        }
        throw new java.security.cert.CertificateException("Not in handshake; no session available");
    }

    private static java.util.Collection<java.security.cert.TrustAnchor> sortPotentialAnchors(java.util.Set<java.security.cert.TrustAnchor> set) {
        if (set.size() <= 1) {
            return set;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(set);
        java.util.Collections.sort(arrayList, TRUST_ANCHOR_COMPARATOR);
        return arrayList;
    }

    private static java.util.Set<java.security.cert.TrustAnchor> trustAnchors(java.security.cert.X509Certificate[] x509CertificateArr) {
        java.util.HashSet hashSet = new java.util.HashSet(x509CertificateArr.length);
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            hashSet.add(new java.security.cert.TrustAnchor(x509Certificate, null));
        }
        return hashSet;
    }

    private java.util.List<java.security.cert.X509Certificate> verifyChain(java.util.List<java.security.cert.X509Certificate> list, java.util.List<java.security.cert.TrustAnchor> list2, java.lang.String str, boolean z) throws java.security.cert.CertificateException {
        java.security.cert.CertPath generateCertPath = this.factory.generateCertPath(list);
        if (list2.isEmpty()) {
            throw new java.security.cert.CertificateException(new java.security.cert.CertPathValidatorException("Trust anchor for certification path not found.", null, generateCertPath, -1));
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(list);
        java.util.Iterator<java.security.cert.TrustAnchor> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTrustedCert());
        }
        if (str != null) {
            try {
                if (!this.pinManager.isChainValid(str, arrayList)) {
                    throw new java.security.cert.CertificateException("Pinning failure", new java.security.cert.CertPathValidatorException("Certificate path is not properly pinned.", null, generateCertPath, -1));
                }
            } catch (com.commonsware.cwac.netsecurity.conscrypt.PinManagerException e) {
                throw new java.security.cert.CertificateException("Failed to check pinning", e);
            }
        }
        if (list.isEmpty()) {
            return arrayList;
        }
        com.commonsware.cwac.netsecurity.conscrypt.ChainStrengthAnalyzer.check(list);
        try {
            java.util.HashSet hashSet = new java.util.HashSet();
            hashSet.add(list2.get(0));
            java.security.cert.PKIXParameters pKIXParameters = new java.security.cert.PKIXParameters(hashSet);
            pKIXParameters.setRevocationEnabled(false);
            pKIXParameters.addCertPathChecker(new com.commonsware.cwac.netsecurity.conscrypt.TrustManagerImpl.ExtendedKeyUsagePKIXCertPathChecker(z, list.get(0), null));
            this.validator.validate(generateCertPath, pKIXParameters);
            for (int i = 1; i < list.size(); i++) {
                this.intermediateIndex.index(list.get(i));
            }
            return arrayList;
        } catch (java.security.InvalidAlgorithmParameterException e2) {
            throw new java.security.cert.CertificateException("Chain validation failed", e2);
        } catch (java.security.cert.CertPathValidatorException e3) {
            throw new java.security.cert.CertificateException("Chain validation failed", e3);
        }
    }

    public java.util.List<java.security.cert.X509Certificate> checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
        return checkTrusted(x509CertificateArr, str, str2, true);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        checkTrusted(x509CertificateArr, str, null, null, true);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException {
        javax.net.ssl.SSLSession sSLSession;
        javax.net.ssl.SSLParameters sSLParameters;
        if (socket instanceof javax.net.ssl.SSLSocket) {
            javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) socket;
            javax.net.ssl.SSLSession handshakeSessionOrThrow = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
            sSLSession = handshakeSessionOrThrow;
        } else {
            sSLSession = null;
            sSLParameters = null;
        }
        checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, true);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException {
        javax.net.ssl.SSLSession sSLSession = null;
        try {
            java.lang.reflect.Method method = sSLEngine.getClass().getMethod("getHandshakeSession", new java.lang.Class[0]);
            if (method != null) {
                sSLSession = (javax.net.ssl.SSLSession) method.invoke(sSLEngine, new java.lang.Object[0]);
            }
        } catch (java.lang.Exception unused) {
        }
        javax.net.ssl.SSLSession sSLSession2 = sSLSession;
        if (sSLSession2 == null) {
            throw new java.security.cert.CertificateException("Not in handshake; no session available");
        }
        checkTrusted(x509CertificateArr, str, sSLSession2, sSLEngine.getSSLParameters(), true);
    }

    public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
        return checkTrusted(x509CertificateArr, str, str2, false);
    }

    public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLSession sSLSession) throws java.security.cert.CertificateException {
        return checkTrusted(x509CertificateArr, str, sSLSession, null, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        checkTrusted(x509CertificateArr, str, null, null, false);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, socket);
    }

    @Override // com.commonsware.cwac.netsecurity.luni.X509ExtendedTrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, sSLEngine);
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        java.security.cert.X509Certificate[] x509CertificateArr = this.acceptedIssuers;
        return x509CertificateArr != null ? (java.security.cert.X509Certificate[]) x509CertificateArr.clone() : acceptedIssuers(this.rootKeyStore);
    }

    public java.util.List<java.security.cert.X509Certificate> getTrustedChainForServer(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.net.Socket socket) throws java.security.cert.CertificateException {
        javax.net.ssl.SSLSession sSLSession;
        javax.net.ssl.SSLParameters sSLParameters;
        if (socket instanceof javax.net.ssl.SSLSocket) {
            javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) socket;
            javax.net.ssl.SSLSession handshakeSessionOrThrow = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
            sSLSession = handshakeSessionOrThrow;
        } else {
            sSLSession = null;
            sSLParameters = null;
        }
        return checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, false);
    }

    public java.util.List<java.security.cert.X509Certificate> getTrustedChainForServer(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, javax.net.ssl.SSLEngine sSLEngine) throws java.security.cert.CertificateException {
        javax.net.ssl.SSLSession sSLSession = null;
        try {
            java.lang.reflect.Method method = sSLEngine.getClass().getMethod("getHandshakeSession", new java.lang.Class[0]);
            if (method != null) {
                sSLSession = (javax.net.ssl.SSLSession) method.invoke(sSLEngine, new java.lang.Object[0]);
            }
        } catch (java.lang.Exception unused) {
        }
        javax.net.ssl.SSLSession sSLSession2 = sSLSession;
        if (sSLSession2 != null) {
            return checkTrusted(x509CertificateArr, str, sSLSession2, sSLEngine.getSSLParameters(), false);
        }
        throw new java.security.cert.CertificateException("Not in handshake; no session available");
    }

    public void handleTrustStorageUpdate() {
        java.security.cert.X509Certificate[] x509CertificateArr = this.acceptedIssuers;
        if (x509CertificateArr == null) {
            this.trustedCertificateIndex.reset();
        } else {
            this.trustedCertificateIndex.reset(trustAnchors(x509CertificateArr));
        }
    }
}
