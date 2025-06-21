package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public final class ChainStrengthAnalyzer {
    private static final int MIN_DSA_P_LEN_BITS = 1024;
    private static final int MIN_DSA_Q_LEN_BITS = 160;
    private static final int MIN_EC_FIELD_SIZE_BITS = 160;
    private static final int MIN_RSA_MODULUS_LEN_BITS = 1024;
    private static final java.lang.String[] SIGNATURE_ALGORITHM_OID_BLACKLIST = {"1.2.840.113549.1.1.2", "1.2.840.113549.1.1.3", "1.2.840.113549.1.1.4"};

    public static final void check(java.util.List<java.security.cert.X509Certificate> list) throws java.security.cert.CertificateException {
        for (java.security.cert.X509Certificate x509Certificate : list) {
            try {
                checkCert(x509Certificate);
            } catch (java.security.cert.CertificateException e) {
                throw new java.security.cert.CertificateException("Unacceptable certificate: " + x509Certificate.getSubjectX500Principal(), e);
            }
        }
    }

    public static final void check(java.security.cert.X509Certificate[] x509CertificateArr) throws java.security.cert.CertificateException {
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            try {
                checkCert(x509Certificate);
            } catch (java.security.cert.CertificateException e) {
                throw new java.security.cert.CertificateException("Unacceptable certificate: " + x509Certificate.getSubjectX500Principal(), e);
            }
        }
    }

    public static final void checkCert(java.security.cert.X509Certificate x509Certificate) throws java.security.cert.CertificateException {
        checkKeyLength(x509Certificate);
        checkSignatureAlgorithm(x509Certificate);
    }

    private static final void checkKeyLength(java.security.cert.X509Certificate x509Certificate) throws java.security.cert.CertificateException {
        java.security.PublicKey publicKey = x509Certificate.getPublicKey();
        if (publicKey instanceof java.security.interfaces.RSAPublicKey) {
            if (((java.security.interfaces.RSAPublicKey) publicKey).getModulus().bitLength() < 1024) {
                throw new java.security.cert.CertificateException("RSA modulus is < 1024 bits");
            }
            return;
        }
        if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            if (((java.security.interfaces.ECPublicKey) publicKey).getParams().getCurve().getField().getFieldSize() < 160) {
                throw new java.security.cert.CertificateException("EC key field size is < 160 bits");
            }
            return;
        }
        if (!(publicKey instanceof java.security.interfaces.DSAPublicKey)) {
            throw new java.security.cert.CertificateException("Rejecting unknown key class " + publicKey.getClass().getName());
        }
        java.security.interfaces.DSAPublicKey dSAPublicKey = (java.security.interfaces.DSAPublicKey) publicKey;
        int bitLength = dSAPublicKey.getParams().getP().bitLength();
        int bitLength2 = dSAPublicKey.getParams().getQ().bitLength();
        if (bitLength < 1024 || bitLength2 < 160) {
            throw new java.security.cert.CertificateException("DSA key length is < (1024, 160) bits");
        }
    }

    private static final void checkSignatureAlgorithm(java.security.cert.X509Certificate x509Certificate) throws java.security.cert.CertificateException {
        java.lang.String sigAlgOID = x509Certificate.getSigAlgOID();
        for (java.lang.String str : SIGNATURE_ALGORITHM_OID_BLACKLIST) {
            if (sigAlgOID.equals(str)) {
                throw new java.security.cert.CertificateException("Signature uses an insecure hash function: " + sigAlgOID);
            }
        }
    }
}
