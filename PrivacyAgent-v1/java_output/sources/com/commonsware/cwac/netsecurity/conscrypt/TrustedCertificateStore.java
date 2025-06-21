package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public class TrustedCertificateStore {
    private static final java.security.cert.CertificateFactory CERT_FACTORY;
    private static final java.lang.String PREFIX_SYSTEM = "system:";
    private static final java.lang.String PREFIX_USER = "user:";
    private static java.io.File defaultCaCertsAddedDir;
    private static java.io.File defaultCaCertsDeletedDir;
    private static java.io.File defaultCaCertsSystemDir;
    private final java.io.File addedDir;
    private final java.io.File deletedDir;
    private final java.io.File systemDir;

    /* renamed from: com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore$1, reason: invalid class name */
    public class AnonymousClass1 implements com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore.CertSelector {
        final /* synthetic */ java.security.cert.X509Certificate val$c;

        public AnonymousClass1(java.security.cert.X509Certificate x509Certificate) {
            this.val$c = x509Certificate;
        }

        @Override // com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore.CertSelector
        public boolean match(java.security.cert.X509Certificate x509Certificate) {
            return x509Certificate.getPublicKey().equals(this.val$c.getPublicKey());
        }
    }

    /* renamed from: com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore$2, reason: invalid class name */
    public class AnonymousClass2 implements com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore.CertSelector {
        final /* synthetic */ java.security.cert.X509Certificate val$c;

        public AnonymousClass2(java.security.cert.X509Certificate x509Certificate) {
            this.val$c = x509Certificate;
        }

        @Override // com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore.CertSelector
        public boolean match(java.security.cert.X509Certificate x509Certificate) {
            try {
                this.val$c.verify(x509Certificate.getPublicKey());
                return true;
            } catch (java.lang.Exception unused) {
                return false;
            }
        }
    }

    public interface CertSelector {
        boolean match(java.security.cert.X509Certificate x509Certificate);
    }

    static {
        java.lang.String str = java.lang.System.getenv("ANDROID_ROOT");
        java.lang.String str2 = java.lang.System.getenv("ANDROID_DATA");
        defaultCaCertsSystemDir = new java.io.File(str + "/etc/security/cacerts");
        setDefaultUserDirectory(new java.io.File(str2 + "/misc/keychain"));
        try {
            CERT_FACTORY = java.security.cert.CertificateFactory.getInstance("X509");
        } catch (java.security.cert.CertificateException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public TrustedCertificateStore() {
        this(defaultCaCertsSystemDir, defaultCaCertsAddedDir, defaultCaCertsDeletedDir);
    }

    public TrustedCertificateStore(java.io.File file, java.io.File file2, java.io.File file3) {
        this.systemDir = file;
        this.addedDir = file2;
        this.deletedDir = file3;
    }

    private java.io.File file(java.io.File file, java.lang.String str, int i) {
        return new java.io.File(file, str + '.' + i);
    }

    private java.io.File fileForAlias(java.lang.String str) {
        java.io.File file;
        if (str == null) {
            throw new java.lang.NullPointerException("alias == null");
        }
        if (!isSystem(str)) {
            if (isUser(str)) {
                file = new java.io.File(this.addedDir, str.substring(5));
            }
            return null;
        }
        file = new java.io.File(this.systemDir, str.substring(7));
        if (!file.exists() || isTombstone(file)) {
            return null;
        }
        return file;
    }

    public static final boolean isSystem(java.lang.String str) {
        return str.startsWith(PREFIX_SYSTEM);
    }

    private boolean isTombstone(java.io.File file) {
        return file.length() == 0;
    }

    public static final boolean isUser(java.lang.String str) {
        return str.startsWith(PREFIX_USER);
    }

    private java.security.cert.X509Certificate readCertificate(java.io.File file) {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
        } catch (java.io.IOException unused) {
            bufferedInputStream = null;
        } catch (java.security.cert.CertificateException unused2) {
            bufferedInputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) CERT_FACTORY.generateCertificate(bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception unused3) {
            }
            return x509Certificate;
        } catch (java.io.IOException unused4) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (java.lang.RuntimeException e2) {
                    throw e2;
                } catch (java.lang.Exception unused5) {
                }
            }
            return null;
        } catch (java.security.cert.CertificateException unused6) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (java.lang.RuntimeException e3) {
                    throw e3;
                } catch (java.lang.Exception unused7) {
                }
            }
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (java.lang.RuntimeException e4) {
                    throw e4;
                } catch (java.lang.Exception unused8) {
                }
            }
            throw th;
        }
    }

    private void removeUnnecessaryTombstones(java.lang.String str) throws java.io.IOException {
        if (!isUser(str)) {
            throw new java.lang.AssertionError(str);
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            throw new java.lang.AssertionError(str);
        }
        java.lang.String substring = str.substring(5, lastIndexOf);
        int parseInt = java.lang.Integer.parseInt(str.substring(lastIndexOf + 1));
        if (file(this.addedDir, substring, parseInt + 1).exists()) {
            return;
        }
        while (parseInt >= 0) {
            java.io.File file = file(this.addedDir, substring, parseInt);
            if (!isTombstone(file)) {
                return;
            }
            if (!file.delete()) {
                throw new java.io.IOException("Could not remove " + file);
            }
            parseInt--;
        }
    }

    public static void setDefaultUserDirectory(java.io.File file) {
        defaultCaCertsAddedDir = new java.io.File(file, "cacerts-added");
        defaultCaCertsDeletedDir = new java.io.File(file, "cacerts-removed");
    }

    private void writeCertificate(java.io.File file, java.security.cert.X509Certificate x509Certificate) throws java.io.IOException, java.security.cert.CertificateException {
        java.io.File parentFile = file.getParentFile();
        parentFile.mkdirs();
        parentFile.setReadable(true, false);
        parentFile.setExecutable(true, false);
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
            try {
                fileOutputStream2.write(x509Certificate.getEncoded());
                try {
                    fileOutputStream2.close();
                } catch (java.lang.RuntimeException e) {
                    throw e;
                } catch (java.lang.Exception unused) {
                }
                file.setReadable(true, false);
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.lang.RuntimeException e2) {
                        throw e2;
                    } catch (java.lang.Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public java.util.Set<java.security.cert.X509Certificate> findAllIssuers(java.security.cert.X509Certificate x509Certificate) {
        new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore.AnonymousClass2(x509Certificate);
        x509Certificate.getIssuerX500Principal();
        return java.util.Collections.emptySet();
    }

    public java.security.cert.X509Certificate getTrustAnchor(java.security.cert.X509Certificate x509Certificate) {
        new com.commonsware.cwac.netsecurity.conscrypt.TrustedCertificateStore.AnonymousClass1(x509Certificate);
        return null;
    }
}
