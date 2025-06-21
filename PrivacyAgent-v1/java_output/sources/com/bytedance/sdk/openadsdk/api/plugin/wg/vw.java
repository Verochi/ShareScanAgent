package com.bytedance.sdk.openadsdk.api.plugin.wg;

/* loaded from: classes22.dex */
public final class vw implements javax.net.ssl.HostnameVerifier {
    public static final com.bytedance.sdk.openadsdk.api.plugin.wg.vw vw = new com.bytedance.sdk.openadsdk.api.plugin.wg.vw();
    private static final java.util.regex.Pattern wg = java.util.regex.Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private vw() {
    }

    private boolean t(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        java.lang.String vw2;
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.US);
        java.util.List<java.lang.String> vw3 = vw(x509Certificate, 2);
        int size = vw3.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (vw(lowerCase, vw3.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (vw2 = new com.bytedance.sdk.openadsdk.api.plugin.wg.wg(x509Certificate.getSubjectX500Principal()).vw(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION)) == null) {
            return false;
        }
        return vw(lowerCase, vw2);
    }

    private static java.util.List<java.lang.String> vw(java.security.cert.X509Certificate x509Certificate, int i) {
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

    private static boolean vw(java.lang.String str) {
        return wg.matcher(str).matches();
    }

    private boolean vw(java.lang.String str, java.lang.String str2) {
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

    private boolean vw(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        return vw(str) ? wg(str, x509Certificate) : t(str, x509Certificate);
    }

    private boolean wg(java.lang.String str, java.security.cert.X509Certificate x509Certificate) {
        java.util.List<java.lang.String> vw2 = vw(x509Certificate, 7);
        int size = vw2.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(vw2.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        try {
            return vw(str, (java.security.cert.X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (javax.net.ssl.SSLException unused) {
            return false;
        }
    }
}
