package com.commonsware.cwac.netsecurity.conscrypt;

/* loaded from: classes22.dex */
public final class CertificatePriorityComparator implements java.util.Comparator<java.security.cert.X509Certificate> {
    private static final java.util.Map<java.lang.String, java.lang.Integer> ALGORITHM_OID_PRIORITY_MAP;
    private static final java.lang.Integer PRIORITY_MD5 = 6;
    private static final java.lang.Integer PRIORITY_SHA1 = 5;
    private static final java.lang.Integer PRIORITY_SHA224 = 4;
    private static final java.lang.Integer PRIORITY_SHA256 = 3;
    private static final java.lang.Integer PRIORITY_SHA384 = 2;
    private static final java.lang.Integer PRIORITY_SHA512 = 1;
    private static final java.lang.Integer PRIORITY_UNKNOWN = -1;

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        ALGORITHM_OID_PRIORITY_MAP = hashMap;
        hashMap.put("1.2.840.113549.1.1.13", 1);
        hashMap.put("1.2.840.113549.1.1.12", 2);
        hashMap.put("1.2.840.113549.1.1.11", 3);
        hashMap.put("1.2.840.113549.1.1.14", 4);
        hashMap.put("1.2.840.113549.1.1.5", 5);
        hashMap.put("1.2.840.113549.1.1.4", 6);
        hashMap.put("1.2.840.10045.4.3.4", 1);
        hashMap.put("1.2.840.10045.4.3.3", 2);
        hashMap.put("1.2.840.10045.4.3.2", 3);
        hashMap.put("1.2.840.10045.4.3.1", 4);
        hashMap.put("1.2.840.10045.4.1", 5);
    }

    private int compareKeyAlgorithm(java.security.PublicKey publicKey, java.security.PublicKey publicKey2) {
        java.lang.String algorithm = publicKey.getAlgorithm();
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String upperCase = algorithm.toUpperCase(locale);
        if (upperCase.equals(publicKey2.getAlgorithm().toUpperCase(locale))) {
            return 0;
        }
        return "EC".equals(upperCase) ? 1 : -1;
    }

    private int compareKeySize(java.security.PublicKey publicKey, java.security.PublicKey publicKey2) {
        java.lang.String algorithm = publicKey.getAlgorithm();
        java.util.Locale locale = java.util.Locale.US;
        if (algorithm.toUpperCase(locale).equals(publicKey2.getAlgorithm().toUpperCase(locale))) {
            return getKeySize(publicKey) - getKeySize(publicKey2);
        }
        throw new java.lang.IllegalArgumentException("Keys are not of the same type");
    }

    private int compareSignatureAlgorithm(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate x509Certificate2) {
        java.util.Map<java.lang.String, java.lang.Integer> map = ALGORITHM_OID_PRIORITY_MAP;
        java.lang.Integer num = map.get(x509Certificate.getSigAlgOID());
        java.lang.Integer num2 = map.get(x509Certificate2.getSigAlgOID());
        if (num == null) {
            num = PRIORITY_UNKNOWN;
        }
        if (num2 == null) {
            num2 = PRIORITY_UNKNOWN;
        }
        return num2.intValue() - num.intValue();
    }

    private int compareStrength(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate x509Certificate2) {
        java.security.PublicKey publicKey = x509Certificate.getPublicKey();
        java.security.PublicKey publicKey2 = x509Certificate2.getPublicKey();
        int compareKeyAlgorithm = compareKeyAlgorithm(publicKey, publicKey2);
        if (compareKeyAlgorithm != 0) {
            return compareKeyAlgorithm;
        }
        int compareKeySize = compareKeySize(publicKey, publicKey2);
        return compareKeySize != 0 ? compareKeySize : compareSignatureAlgorithm(x509Certificate, x509Certificate2);
    }

    private int getKeySize(java.security.PublicKey publicKey) {
        if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            return ((java.security.interfaces.ECPublicKey) publicKey).getParams().getCurve().getField().getFieldSize();
        }
        if (publicKey instanceof java.security.interfaces.RSAPublicKey) {
            return ((java.security.interfaces.RSAPublicKey) publicKey).getModulus().bitLength();
        }
        throw new java.lang.IllegalArgumentException("Unsupported public key type: " + publicKey.getClass().getName());
    }

    @Override // java.util.Comparator
    public int compare(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate x509Certificate2) {
        boolean equals = x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
        boolean equals2 = x509Certificate2.getSubjectDN().equals(x509Certificate2.getIssuerDN());
        if (equals != equals2) {
            return equals2 ? 1 : -1;
        }
        int compareStrength = compareStrength(x509Certificate2, x509Certificate);
        if (compareStrength != 0) {
            return compareStrength;
        }
        int compareTo = x509Certificate2.getNotAfter().compareTo(x509Certificate.getNotAfter());
        if (compareTo != 0) {
            return compareTo;
        }
        return x509Certificate2.getNotBefore().compareTo(x509Certificate.getNotBefore());
    }
}
