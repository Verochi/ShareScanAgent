package com.huawei.secure.android.common.ssl;

/* loaded from: classes22.dex */
public abstract class SSLUtil {
    public static final java.lang.String[] a = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};
    public static final java.lang.String[] b = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};
    public static final java.lang.String[] c = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static java.lang.String[] getEnabledCipherSuites(javax.net.ssl.SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static java.lang.String[] getEnabledProtocols(javax.net.ssl.SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void printTLSAndCipher(javax.net.ssl.SSLSocket sSLSocket) {
        for (java.lang.String str : sSLSocket.getEnabledProtocols()) {
            com.huawei.secure.android.common.ssl.util.g.c("SSLUtil", "new enable protocols is : " + str);
        }
        for (java.lang.String str2 : sSLSocket.getEnabledCipherSuites()) {
            com.huawei.secure.android.common.ssl.util.g.c("SSLUtil", "new cipher suites is : " + str2);
        }
    }

    public static boolean setBlackListCipherSuites(javax.net.ssl.SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setBlackListCipherSuites(sSLSocket, c);
    }

    public static boolean setBlackListCipherSuites(javax.net.ssl.SSLSocket sSLSocket, java.lang.String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        java.lang.String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = enabledCipherSuites.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            java.lang.String str = enabledCipherSuites[i];
            java.lang.String upperCase = str.toUpperCase(java.util.Locale.ENGLISH);
            int length2 = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = false;
                    break;
                }
                if (upperCase.contains(strArr[i2].toUpperCase(java.util.Locale.ENGLISH))) {
                    break;
                }
                i2++;
            }
            if (!z) {
                arrayList.add(str);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
        return true;
    }

    public static void setEnableSafeCipherSuites(javax.net.ssl.SSLSocket sSLSocket) {
        if (sSLSocket == null || setWhiteListCipherSuites(sSLSocket)) {
            return;
        }
        setBlackListCipherSuites(sSLSocket);
    }

    public static void setEnabledProtocols(javax.net.ssl.SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 29) {
            sSLSocket.setEnabledProtocols(new java.lang.String[]{"TLSv1.3", "TLSv1.2"});
        }
        if (i < 29) {
            sSLSocket.setEnabledProtocols(new java.lang.String[]{"TLSv1.2"});
        }
    }

    public static boolean setEnabledProtocols(javax.net.ssl.SSLSocket sSLSocket, java.lang.String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (java.lang.Exception e) {
                com.huawei.secure.android.common.ssl.util.g.b("SSLUtil", "setEnabledProtocols: exception : " + e.getMessage());
            }
        }
        return false;
    }

    public static javax.net.ssl.SSLContext setSSLContext() throws java.security.NoSuchAlgorithmException {
        return android.os.Build.VERSION.SDK_INT >= 29 ? javax.net.ssl.SSLContext.getInstance("TLSv1.3") : javax.net.ssl.SSLContext.getInstance("TLSv1.2");
    }

    public static void setSSLSocketOptions(javax.net.ssl.SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        setEnabledProtocols(sSLSocket);
        setEnableSafeCipherSuites(sSLSocket);
    }

    public static boolean setWhiteListCipherSuites(javax.net.ssl.SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setWhiteListCipherSuites(sSLSocket, b);
    }

    public static boolean setWhiteListCipherSuites(javax.net.ssl.SSLSocket sSLSocket, java.lang.String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        java.lang.String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List asList = java.util.Arrays.asList(strArr);
        for (java.lang.String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(java.util.Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
        return true;
    }
}
