package okhttp3.internal.tls;

/* loaded from: classes24.dex */
public final class OkHostnameVerifier implements javax.net.ssl.HostnameVerifier {
    public static final okhttp3.internal.tls.OkHostnameVerifier INSTANCE = new okhttp3.internal.tls.OkHostnameVerifier();

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

    public static java.util.List<java.lang.String> allSubjectAltNames(java.security.cert.X509Certificate x509Certificate) {
        java.util.List<java.lang.String> a = a(x509Certificate, 7);
        java.util.List<java.lang.String> a2 = a(x509Certificate, 2);
        java.util.ArrayList arrayList = new java.util.ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    public final boolean b(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.US);
        java.util.Iterator<java.lang.String> it = a(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (verifyHostname(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        java.util.List<java.lang.String> a = a(x509Certificate, 7);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean verify(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        return okhttp3.internal.Util.verifyAsIpAddress(str) ? c(str, x509Certificate) : b(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        try {
            return verify(str, (java.security.cert.X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (javax.net.ssl.SSLException unused) {
            return false;
        }
    }

    public boolean verifyHostname(java.lang.String str, java.lang.String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            java.lang.String lowerCase = str2.toLowerCase(java.util.Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            java.lang.String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
