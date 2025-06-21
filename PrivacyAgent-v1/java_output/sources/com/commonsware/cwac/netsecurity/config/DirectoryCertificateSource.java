package com.commonsware.cwac.netsecurity.config;

/* loaded from: classes22.dex */
abstract class DirectoryCertificateSource implements com.commonsware.cwac.netsecurity.config.CertificateSource {
    private final java.security.cert.CertificateFactory mCertFactory;
    private java.util.Set<java.security.cert.X509Certificate> mCertificates;
    private final java.io.File mDir;
    private final java.lang.Object mLock = new java.lang.Object();

    /* renamed from: com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource$1, reason: invalid class name */
    public class AnonymousClass1 implements com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.CertSelector {
        final /* synthetic */ java.security.cert.X509Certificate val$cert;

        public AnonymousClass1(java.security.cert.X509Certificate x509Certificate) {
            this.val$cert = x509Certificate;
        }

        @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.CertSelector
        public boolean match(java.security.cert.X509Certificate x509Certificate) {
            return x509Certificate.getPublicKey().equals(this.val$cert.getPublicKey());
        }
    }

    /* renamed from: com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource$2, reason: invalid class name */
    public class AnonymousClass2 implements com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.CertSelector {
        final /* synthetic */ java.security.cert.X509Certificate val$cert;

        public AnonymousClass2(java.security.cert.X509Certificate x509Certificate) {
            this.val$cert = x509Certificate;
        }

        @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.CertSelector
        public boolean match(java.security.cert.X509Certificate x509Certificate) {
            try {
                this.val$cert.verify(x509Certificate.getPublicKey());
                return true;
            } catch (java.lang.Exception unused) {
                return false;
            }
        }
    }

    /* renamed from: com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource$3, reason: invalid class name */
    public class AnonymousClass3 implements com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.CertSelector {
        final /* synthetic */ java.security.cert.X509Certificate val$cert;

        public AnonymousClass3(java.security.cert.X509Certificate x509Certificate) {
            this.val$cert = x509Certificate;
        }

        @Override // com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.CertSelector
        public boolean match(java.security.cert.X509Certificate x509Certificate) {
            try {
                this.val$cert.verify(x509Certificate.getPublicKey());
                return true;
            } catch (java.lang.Exception unused) {
                return false;
            }
        }
    }

    public interface CertSelector {
        boolean match(java.security.cert.X509Certificate x509Certificate);
    }

    public DirectoryCertificateSource(java.io.File file) {
        this.mDir = file;
        try {
            this.mCertFactory = java.security.cert.CertificateFactory.getInstance("X.509");
        } catch (java.security.cert.CertificateException e) {
            throw new java.lang.RuntimeException("Failed to obtain X.509 CertificateFactory", e);
        }
    }

    private static int X509_NAME_hash(javax.security.auth.x500.X500Principal x500Principal, java.lang.String str) {
        try {
            byte[] digest = java.security.MessageDigest.getInstance(str).digest(x500Principal.getEncoded());
            return ((digest[3] & 255) << 24) | ((digest[0] & 255) << 0) | ((digest[1] & 255) << 8) | ((digest[2] & 255) << 16);
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public static int X509_NAME_hash_old(javax.security.auth.x500.X500Principal x500Principal) {
        return X509_NAME_hash(x500Principal, "MD5");
    }

    private java.security.cert.X509Certificate findCert(javax.security.auth.x500.X500Principal x500Principal, com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.CertSelector certSelector) {
        java.lang.String hash = getHash(x500Principal);
        for (int i = 0; i >= 0; i++) {
            java.lang.String str = hash + "." + i;
            if (!new java.io.File(this.mDir, str).exists()) {
                return null;
            }
            if (!isCertMarkedAsRemoved(str)) {
                java.security.cert.X509Certificate readCertificate = readCertificate(str);
                if (x500Principal.equals(readCertificate.getSubjectX500Principal()) && certSelector.match(readCertificate)) {
                    return readCertificate;
                }
            }
        }
        return null;
    }

    private java.util.Set<java.security.cert.X509Certificate> findCerts(javax.security.auth.x500.X500Principal x500Principal, com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.CertSelector certSelector) {
        java.lang.String hash = getHash(x500Principal);
        java.util.HashSet hashSet = null;
        for (int i = 0; i >= 0; i++) {
            java.lang.String str = hash + "." + i;
            if (!new java.io.File(this.mDir, str).exists()) {
                break;
            }
            if (!isCertMarkedAsRemoved(str)) {
                java.security.cert.X509Certificate readCertificate = readCertificate(str);
                if (x500Principal.equals(readCertificate.getSubjectX500Principal()) && certSelector.match(readCertificate)) {
                    if (hashSet == null) {
                        hashSet = new java.util.HashSet();
                    }
                    hashSet.add(readCertificate);
                }
            }
        }
        return hashSet != null ? hashSet : java.util.Collections.emptySet();
    }

    private java.lang.String getHash(javax.security.auth.x500.X500Principal x500Principal) {
        return com.commonsware.cwac.netsecurity.conscrypt.Hex.intToHexString(X509_NAME_hash_old(x500Principal), 8);
    }

    private java.security.cert.X509Certificate readCertificate(java.lang.String str) {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(new java.io.File(this.mDir, str)));
            try {
                java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) this.mCertFactory.generateCertificate(bufferedInputStream);
                try {
                    bufferedInputStream.close();
                } catch (java.lang.RuntimeException e) {
                    throw e;
                } catch (java.lang.Exception unused) {
                }
                return x509Certificate;
            } catch (java.io.IOException | java.security.cert.CertificateException unused2) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.RuntimeException e2) {
                        throw e2;
                    } catch (java.lang.Exception unused3) {
                    }
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (java.lang.RuntimeException e3) {
                        throw e3;
                    } catch (java.lang.Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (java.io.IOException | java.security.cert.CertificateException unused5) {
            bufferedInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public java.util.Set<java.security.cert.X509Certificate> findAllByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        return findCerts(x509Certificate.getIssuerX500Principal(), new com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.AnonymousClass3(x509Certificate));
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        return findCert(x509Certificate.getIssuerX500Principal(), new com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.AnonymousClass2(x509Certificate));
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public java.security.cert.X509Certificate findBySubjectAndPublicKey(java.security.cert.X509Certificate x509Certificate) {
        return findCert(x509Certificate.getSubjectX500Principal(), new com.commonsware.cwac.netsecurity.config.DirectoryCertificateSource.AnonymousClass1(x509Certificate));
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public java.util.Set<java.security.cert.X509Certificate> getCertificates() {
        java.security.cert.X509Certificate readCertificate;
        synchronized (this.mLock) {
            java.util.Set<java.security.cert.X509Certificate> set = this.mCertificates;
            if (set != null) {
                return set;
            }
            java.util.HashSet hashSet = new java.util.HashSet();
            if (this.mDir.isDirectory()) {
                for (java.lang.String str : this.mDir.list()) {
                    if (!isCertMarkedAsRemoved(str) && (readCertificate = readCertificate(str)) != null) {
                        hashSet.add(readCertificate);
                    }
                }
            }
            this.mCertificates = hashSet;
            return hashSet;
        }
    }

    @Override // com.commonsware.cwac.netsecurity.config.CertificateSource
    public void handleTrustStorageUpdate() {
        synchronized (this.mLock) {
            this.mCertificates = null;
        }
    }

    public abstract boolean isCertMarkedAsRemoved(java.lang.String str);
}
