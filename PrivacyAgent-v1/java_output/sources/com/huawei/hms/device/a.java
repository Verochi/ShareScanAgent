package com.huawei.hms.device;

/* loaded from: classes22.dex */
public class a {
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        int indexOf = str.toUpperCase(java.util.Locale.getDefault()).indexOf(str2 + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        return indexOf2 != -1 ? str.substring(indexOf + str2.length() + 1, indexOf2) : str.substring(indexOf + str2.length() + 1);
    }

    public static java.security.cert.X509Certificate a(android.content.Context context) {
        return a(context, com.huawei.secure.android.common.ssl.util.j.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    public static java.security.cert.X509Certificate a(android.content.Context context, java.lang.String str) {
        java.io.InputStream inputStream;
        java.security.KeyStore keyStore;
        ?? r1 = 0;
        if (context != null) {
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    try {
                        keyStore = java.security.KeyStore.getInstance(com.huawei.secure.android.common.ssl.util.j.e);
                        inputStream = context.getAssets().open("hmsrootcas.bks");
                    } catch (java.io.IOException e) {
                        e = e;
                        inputStream = null;
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (java.security.KeyStoreException e2) {
                        e = e2;
                        inputStream = null;
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (java.security.NoSuchAlgorithmException e3) {
                        e = e3;
                        inputStream = null;
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (java.security.cert.CertificateException e4) {
                        e = e4;
                        inputStream = null;
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) r1);
                        throw th;
                    }
                    try {
                        keyStore.load(inputStream, "".toCharArray());
                    } catch (java.io.IOException e5) {
                        e = e5;
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (java.security.KeyStoreException e6) {
                        e = e6;
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (java.security.NoSuchAlgorithmException e7) {
                        e = e7;
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (java.security.cert.CertificateException e8) {
                        e = e8;
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    }
                    if (!keyStore.containsAlias(str)) {
                        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "Not include alias " + str);
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    }
                    java.security.cert.Certificate certificate = keyStore.getCertificate(str);
                    if (!(certificate instanceof java.security.cert.X509Certificate)) {
                        com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                        return null;
                    }
                    java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) certificate;
                    x509Certificate.checkValidity();
                    com.huawei.hms.utils.IOUtils.closeQuietly(inputStream);
                    return x509Certificate;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                r1 = context;
            }
        }
        com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "args are error");
        return null;
    }

    public static java.security.cert.X509Certificate a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(com.huawei.hms.support.log.common.Base64.decode(str));
        } catch (java.lang.IllegalArgumentException e) {
            com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "getCert failed : " + e.getMessage());
            return null;
        }
    }

    public static java.security.cert.X509Certificate a(byte[] bArr) {
        try {
            return (java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new java.io.ByteArrayInputStream(bArr));
        } catch (java.security.cert.CertificateException e) {
            com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "Failed to get cert: " + e.getMessage());
            return null;
        }
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (5 < keyUsage.length) {
            return keyUsage[5];
        }
        return false;
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate, java.lang.String str) {
        return b(x509Certificate, "CN", str);
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate, java.lang.String str, java.lang.String str2) {
        try {
            return a(x509Certificate, str.getBytes("UTF-8"), com.huawei.hms.support.log.common.Base64.decode(str2));
        } catch (java.io.UnsupportedEncodingException | java.lang.IllegalArgumentException e) {
            com.huawei.hms.support.log.HMSLog.e("X509CertUtil", " plainText exception: " + e.getMessage());
            return false;
        }
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate, java.util.List<java.security.cert.X509Certificate> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (x509Certificate == null) {
            com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "rootCert is null,verify failed ");
            return false;
        }
        java.security.PublicKey publicKey = x509Certificate.getPublicKey();
        for (java.security.cert.X509Certificate x509Certificate2 : list) {
            if (x509Certificate2 != null) {
                try {
                    x509Certificate2.checkValidity();
                    x509Certificate2.verify(publicKey);
                    publicKey = x509Certificate2.getPublicKey();
                } catch (java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | java.security.NoSuchProviderException | java.security.SignatureException | java.security.cert.CertificateException e) {
                    com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "verify failed " + e.getMessage());
                }
            }
            return false;
        }
        return a(list);
    }

    public static boolean a(java.security.cert.X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        try {
            java.security.Signature signature = java.security.Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate.getPublicKey());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | java.security.SignatureException e) {
            com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "failed checkSignature : " + e.getMessage());
            return false;
        }
    }

    public static boolean a(java.util.List<java.security.cert.X509Certificate> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (!a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static java.util.List<java.security.cert.X509Certificate> b(java.lang.String str) {
        return b(c(str));
    }

    public static java.util.List<java.security.cert.X509Certificate> b(java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public static boolean b(java.security.cert.X509Certificate x509Certificate, java.lang.String str) {
        return b(x509Certificate, "OU", str);
    }

    public static boolean b(java.security.cert.X509Certificate x509Certificate, java.lang.String str, java.lang.String str2) {
        if (x509Certificate == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(a(x509Certificate.getSubjectDN().getName(), str));
    }

    public static java.util.List<java.lang.String> c(java.lang.String str) {
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            if (jSONArray.length() <= 1) {
                return java.util.Collections.emptyList();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e("X509CertUtil", "Failed to getCertChain: " + e.getMessage());
            return java.util.Collections.emptyList();
        }
    }
}
