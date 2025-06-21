package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class n2 implements javax.net.ssl.HostnameVerifier {
    public static final com.zx.a.I8b7.n2 a = new com.zx.a.I8b7.n2();
    public static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static java.util.List<java.lang.String> a(java.security.cert.X509Certificate x509Certificate, int i) {
        java.lang.Integer num;
        java.lang.String str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.util.Collection<java.util.List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return java.util.Collections.emptyList();
            }
            for (java.util.List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (java.lang.Integer) list.get(0)) != null && num.intValue() == i && (str = (java.lang.String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (java.security.cert.CertificateParsingException unused) {
            return java.util.Collections.emptyList();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[LOOP:1: B:14:0x003b->B:44:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        boolean z;
        int length;
        if (b.matcher(str).matches()) {
            java.util.List<java.lang.String> a2 = a(x509Certificate, 7);
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                if (str.equalsIgnoreCase(a2.get(i))) {
                    return true;
                }
            }
            return false;
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.US);
        for (java.lang.String str2 : a(x509Certificate, 2)) {
            if (lowerCase != null && lowerCase.length() != 0 && !lowerCase.startsWith(".") && !lowerCase.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
                java.lang.String str3 = lowerCase.endsWith(".") ? lowerCase : lowerCase + '.';
                if (!str2.endsWith(".")) {
                    str2 = str2 + '.';
                }
                java.lang.String lowerCase2 = str2.toLowerCase(java.util.Locale.US);
                if (!lowerCase2.contains("*")) {
                    z = str3.equals(lowerCase2);
                } else if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(42, 1) == -1 && str3.length() >= lowerCase2.length() && !"*.".equals(lowerCase2)) {
                    java.lang.String substring = lowerCase2.substring(1);
                    if (str3.endsWith(substring) && ((length = str3.length() - substring.length()) <= 0 || str3.lastIndexOf(46, length - 1) == -1)) {
                        z = true;
                    }
                }
                if (!z) {
                    return true;
                }
            }
            z = false;
            if (!z) {
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        try {
            return a(str, (java.security.cert.X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (javax.net.ssl.SSLException unused) {
            return false;
        }
    }
}
