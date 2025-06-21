package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
public final class NetworkSecurityConfig {
    public static final boolean DEFAULT_CLEARTEXT_TRAFFIC_PERMITTED = true;
    public static final boolean DEFAULT_HSTS_ENFORCED = false;
    private java.util.Set<com.commonsware.cwac.netsecurity.config.TrustAnchor> mAnchors;
    private final java.lang.Object mAnchorsLock;
    private final java.util.List<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> mCertificatesEntryRefs;
    private final boolean mCleartextTrafficPermitted;
    private final boolean mHstsEnforced;
    private final com.commonsware.cwac.netsecurity.config.PinSet mPins;
    private com.commonsware.cwac.netsecurity.config.NetworkSecurityTrustManager mTrustManager;
    private final java.lang.Object mTrustManagerLock;

    /* renamed from: com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(com.commonsware.cwac.netsecurity.config.CertificatesEntryRef certificatesEntryRef, com.commonsware.cwac.netsecurity.config.CertificatesEntryRef certificatesEntryRef2) {
            return certificatesEntryRef.overridesPins() ? certificatesEntryRef2.overridesPins() ? 0 : -1 : certificatesEntryRef2.overridesPins() ? 1 : 0;
        }
    }

    public static final class Builder {
        private java.util.List<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> mCertificatesEntryRefs;
        private com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder mParentBuilder;
        private com.commonsware.cwac.netsecurity.config.PinSet mPinSet;
        private boolean mCleartextTrafficPermitted = true;
        private boolean mHstsEnforced = false;
        private boolean mCleartextTrafficPermittedSet = false;
        private boolean mHstsEnforcedSet = false;

        private java.util.List<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> getEffectiveCertificatesEntryRefs() {
            java.util.List<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> list = this.mCertificatesEntryRefs;
            if (list != null) {
                return list;
            }
            com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder = this.mParentBuilder;
            return builder != null ? builder.getEffectiveCertificatesEntryRefs() : java.util.Collections.emptyList();
        }

        private boolean getEffectiveCleartextTrafficPermitted() {
            if (this.mCleartextTrafficPermittedSet) {
                return this.mCleartextTrafficPermitted;
            }
            com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder = this.mParentBuilder;
            if (builder != null) {
                return builder.getEffectiveCleartextTrafficPermitted();
            }
            return true;
        }

        private boolean getEffectiveHstsEnforced() {
            if (this.mHstsEnforcedSet) {
                return this.mHstsEnforced;
            }
            com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder = this.mParentBuilder;
            if (builder != null) {
                return builder.getEffectiveHstsEnforced();
            }
            return false;
        }

        private com.commonsware.cwac.netsecurity.config.PinSet getEffectivePinSet() {
            com.commonsware.cwac.netsecurity.config.PinSet pinSet = this.mPinSet;
            if (pinSet != null) {
                return pinSet;
            }
            com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder = this.mParentBuilder;
            return builder != null ? builder.getEffectivePinSet() : com.commonsware.cwac.netsecurity.config.PinSet.EMPTY_PINSET;
        }

        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder addCertificatesEntryRef(com.commonsware.cwac.netsecurity.config.CertificatesEntryRef certificatesEntryRef) {
            if (this.mCertificatesEntryRefs == null) {
                this.mCertificatesEntryRefs = new java.util.ArrayList();
            }
            this.mCertificatesEntryRefs.add(certificatesEntryRef);
            return this;
        }

        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder addCertificatesEntryRefs(java.util.Collection<? extends com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> collection) {
            if (this.mCertificatesEntryRefs == null) {
                this.mCertificatesEntryRefs = new java.util.ArrayList();
            }
            this.mCertificatesEntryRefs.addAll(collection);
            return this;
        }

        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig build() {
            return new com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig(getEffectiveCleartextTrafficPermitted(), getEffectiveHstsEnforced(), getEffectivePinSet(), getEffectiveCertificatesEntryRefs(), null);
        }

        public java.util.List<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> getCertificatesEntryRefs() {
            return this.mCertificatesEntryRefs;
        }

        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder getParent() {
            return this.mParentBuilder;
        }

        public boolean hasCertificatesEntryRefs() {
            return this.mCertificatesEntryRefs != null;
        }

        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder setCleartextTrafficPermitted(boolean z) {
            this.mCleartextTrafficPermitted = z;
            this.mCleartextTrafficPermittedSet = true;
            return this;
        }

        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder setHstsEnforced(boolean z) {
            this.mHstsEnforced = z;
            this.mHstsEnforcedSet = true;
            return this;
        }

        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder setParent(com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder) {
            for (com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder builder2 = builder; builder2 != null; builder2 = builder2.getParent()) {
                if (builder2 == this) {
                    throw new java.lang.IllegalArgumentException("Loops are not allowed in Builder parents");
                }
            }
            this.mParentBuilder = builder;
            return this;
        }

        public com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder setPinSet(com.commonsware.cwac.netsecurity.config.PinSet pinSet) {
            this.mPinSet = pinSet;
            return this;
        }
    }

    private NetworkSecurityConfig(boolean z, boolean z2, com.commonsware.cwac.netsecurity.config.PinSet pinSet, java.util.List<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> list) {
        this.mAnchorsLock = new java.lang.Object();
        this.mTrustManagerLock = new java.lang.Object();
        this.mCleartextTrafficPermitted = z;
        this.mHstsEnforced = z2;
        this.mPins = pinSet;
        this.mCertificatesEntryRefs = list;
        java.util.Collections.sort(list, new com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.AnonymousClass1());
    }

    public /* synthetic */ NetworkSecurityConfig(boolean z, boolean z2, com.commonsware.cwac.netsecurity.config.PinSet pinSet, java.util.List list, com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.AnonymousClass1 anonymousClass1) {
        this(z, z2, pinSet, list);
    }

    public static final com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder getDefaultBuilder(int i) {
        return new com.commonsware.cwac.netsecurity.config.NetworkSecurityConfig.Builder().setCleartextTrafficPermitted(true).setHstsEnforced(false).addCertificatesEntryRef(new com.commonsware.cwac.netsecurity.config.CertificatesEntryRef(com.commonsware.cwac.netsecurity.config.SystemCertificateSource.getInstance(), false));
    }

    public java.util.Set<java.security.cert.X509Certificate> findAllCertificatesByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> it = this.mCertificatesEntryRefs.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().findAllCertificatesByIssuerAndSignature(x509Certificate));
        }
        return hashSet;
    }

    public com.commonsware.cwac.netsecurity.config.TrustAnchor findTrustAnchorByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        java.util.Iterator<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> it = this.mCertificatesEntryRefs.iterator();
        while (it.hasNext()) {
            com.commonsware.cwac.netsecurity.config.TrustAnchor findByIssuerAndSignature = it.next().findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature != null) {
                return findByIssuerAndSignature;
            }
        }
        return null;
    }

    public com.commonsware.cwac.netsecurity.config.TrustAnchor findTrustAnchorBySubjectAndPublicKey(java.security.cert.X509Certificate x509Certificate) {
        java.util.Iterator<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> it = this.mCertificatesEntryRefs.iterator();
        while (it.hasNext()) {
            com.commonsware.cwac.netsecurity.config.TrustAnchor findBySubjectAndPublicKey = it.next().findBySubjectAndPublicKey(x509Certificate);
            if (findBySubjectAndPublicKey != null) {
                return findBySubjectAndPublicKey;
            }
        }
        return null;
    }

    public com.commonsware.cwac.netsecurity.config.PinSet getPins() {
        return this.mPins;
    }

    public java.util.Set<com.commonsware.cwac.netsecurity.config.TrustAnchor> getTrustAnchors() {
        synchronized (this.mAnchorsLock) {
            java.util.Set<com.commonsware.cwac.netsecurity.config.TrustAnchor> set = this.mAnchors;
            if (set != null) {
                return set;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            java.util.Iterator<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> it = this.mCertificatesEntryRefs.iterator();
            while (it.hasNext()) {
                for (com.commonsware.cwac.netsecurity.config.TrustAnchor trustAnchor : it.next().getTrustAnchors()) {
                    java.security.cert.X509Certificate x509Certificate = trustAnchor.certificate;
                    if (!hashMap.containsKey(x509Certificate)) {
                        hashMap.put(x509Certificate, trustAnchor);
                    }
                }
            }
            java.util.HashSet hashSet = new java.util.HashSet(hashMap.size());
            hashSet.addAll(hashMap.values());
            this.mAnchors = hashSet;
            return hashSet;
        }
    }

    public com.commonsware.cwac.netsecurity.config.NetworkSecurityTrustManager getTrustManager() {
        com.commonsware.cwac.netsecurity.config.NetworkSecurityTrustManager networkSecurityTrustManager;
        synchronized (this.mTrustManagerLock) {
            if (this.mTrustManager == null) {
                this.mTrustManager = new com.commonsware.cwac.netsecurity.config.NetworkSecurityTrustManager(this);
            }
            networkSecurityTrustManager = this.mTrustManager;
        }
        return networkSecurityTrustManager;
    }

    public void handleTrustStorageUpdate() {
        synchronized (this.mAnchorsLock) {
            this.mAnchors = null;
            java.util.Iterator<com.commonsware.cwac.netsecurity.config.CertificatesEntryRef> it = this.mCertificatesEntryRefs.iterator();
            while (it.hasNext()) {
                it.next().handleTrustStorageUpdate();
            }
        }
        getTrustManager().handleTrustStorageUpdate();
    }

    public boolean isCleartextTrafficPermitted() {
        return this.mCleartextTrafficPermitted;
    }

    public boolean isHstsEnforced() {
        return this.mHstsEnforced;
    }
}
