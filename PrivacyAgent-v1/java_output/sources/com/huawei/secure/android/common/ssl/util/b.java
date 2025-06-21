package com.huawei.secure.android.common.ssl.util;

/* loaded from: classes22.dex */
public class b {
    public static final java.lang.String a = "b";

    public static java.security.cert.X509Certificate a(android.net.http.SslCertificate sslCertificate) {
        byte[] byteArray = android.net.http.SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new java.io.ByteArrayInputStream(byteArray));
            } catch (java.security.cert.CertificateException e) {
                com.huawei.secure.android.common.ssl.util.g.a(a, "exception", e);
            }
        }
        return null;
    }

    public static java.security.cert.X509Certificate a(java.lang.String str) {
        try {
            return (java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X509").generateCertificate(new java.io.ByteArrayInputStream(str.getBytes()));
        } catch (java.security.cert.CertificateException e) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "generateX509FromStr: CertificateException" + e.getMessage());
            return null;
        }
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate, java.lang.String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        com.huawei.secure.android.common.ssl.util.g.b(a, "verify: subject name is error");
        return false;
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (b(new java.security.cert.X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            com.huawei.secure.android.common.ssl.util.g.b(a, "verify: date not right");
            return false;
        } catch (java.security.InvalidKeyException e) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "verify: publickey InvalidKeyException " + e.getMessage());
            return false;
        } catch (java.security.NoSuchAlgorithmException e2) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "verify: publickey NoSuchAlgorithmException " + e2.getMessage());
            return false;
        } catch (java.security.NoSuchProviderException e3) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "verify: publickey NoSuchProviderException " + e3.getMessage());
            return false;
        } catch (java.security.SignatureException e4) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "verify: publickey SignatureException " + e4.getMessage());
            return false;
        } catch (java.security.cert.CertificateException e5) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "verify: publickey CertificateException " + e5.getMessage());
            return false;
        } catch (java.lang.Exception e6) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "verify: Exception " + e6.getMessage());
            return false;
        }
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate[] x509CertificateArr) throws java.security.NoSuchProviderException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.SignatureException {
        java.security.Principal principal = null;
        int i = 0;
        while (i < x509CertificateArr.length) {
            java.security.cert.X509Certificate x509Certificate2 = x509CertificateArr[i];
            java.security.Principal issuerDN = x509Certificate2.getIssuerDN();
            java.security.Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (!issuerDN.equals(principal)) {
                    com.huawei.secure.android.common.ssl.util.g.b(a, "verify: principalIssuer not match");
                    return false;
                }
                x509CertificateArr[i].verify(x509CertificateArr[i - 1].getPublicKey());
            }
            i++;
            principal = subjectDN;
        }
        return a(x509Certificate, x509CertificateArr[0]) && b(x509CertificateArr) && a(x509Certificate) && a(x509CertificateArr);
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate[] x509CertificateArr, java.security.cert.X509CRL x509crl, java.lang.String str) throws java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.NoSuchProviderException, java.security.InvalidKeyException, java.security.SignatureException {
        return !a(x509Certificate, x509CertificateArr) && !a(x509CertificateArr, x509crl) && a(x509CertificateArr[x509CertificateArr.length - 1], str) && b(x509CertificateArr);
    }

    public static boolean a(java.security.cert.X509Certificate[] x509CertificateArr) {
        for (int i = 0; i < x509CertificateArr.length - 1; i++) {
            if (!a(x509CertificateArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(java.security.cert.X509Certificate[] x509CertificateArr, java.security.cert.X509CRL x509crl) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Certificate.getSerialNumber());
        }
        if (x509crl == null) {
            return true;
        }
        try {
            java.util.Set<? extends java.security.cert.X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
            if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                return true;
            }
            java.util.Iterator<? extends java.security.cert.X509CRLEntry> it = revokedCertificates.iterator();
            while (it.hasNext()) {
                if (arrayList.contains(it.next().getSerialNumber())) {
                    com.huawei.secure.android.common.ssl.util.g.b(a, "verify: certificate revoked");
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "verify: revoked verify exception : " + e.getMessage());
            return false;
        }
    }

    public static boolean b(java.security.cert.X509Certificate[] x509CertificateArr) {
        java.util.Date date = new java.util.Date();
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (java.security.cert.CertificateExpiredException e) {
                e = e;
                com.huawei.secure.android.common.ssl.util.g.b(a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (java.security.cert.CertificateNotYetValidException e2) {
                e = e2;
                com.huawei.secure.android.common.ssl.util.g.b(a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (java.lang.Exception e3) {
                com.huawei.secure.android.common.ssl.util.g.b(a, "verifyCertificateDate : exception : " + e3.getMessage());
                return false;
            }
        }
        return true;
    }
}
