package com.huawei.secure.android.common.ssl.hostname;

/* loaded from: classes22.dex */
public class b {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    public static final java.lang.String[] b;

    static {
        java.lang.String[] strArr = {com.anythink.expressad.d.a.b.da, "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", com.alipay.sdk.m.k.b.k, "or", "org"};
        b = strArr;
        java.util.Arrays.sort(strArr);
    }

    public static final void a(java.lang.String str, java.security.cert.X509Certificate x509Certificate, boolean z) throws javax.net.ssl.SSLException {
        java.lang.String[] a2 = a(x509Certificate);
        java.lang.String[] b2 = b(x509Certificate);
        com.huawei.secure.android.common.ssl.util.g.a("", "cn is : " + java.util.Arrays.toString(a2));
        com.huawei.secure.android.common.ssl.util.g.a("", "san is : " + java.util.Arrays.toString(b2));
        a(str, a2, b2, z);
    }

    public static final void a(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2, boolean z) throws javax.net.ssl.SSLException {
        java.lang.String str2;
        java.util.LinkedList linkedList = new java.util.LinkedList();
        if (strArr != null && strArr.length > 0 && (str2 = strArr[0]) != null) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (java.lang.String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (linkedList.isEmpty()) {
            throw new javax.net.ssl.SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String lowerCase = str.trim().toLowerCase(java.util.Locale.ENGLISH);
        java.util.Iterator it = linkedList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            java.lang.String lowerCase2 = ((java.lang.String) it.next()).toLowerCase(java.util.Locale.ENGLISH);
            stringBuffer.append(" <");
            stringBuffer.append(lowerCase2);
            stringBuffer.append(kotlin.text.Typography.greater);
            if (it.hasNext()) {
                stringBuffer.append(" OR");
            }
            if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && a(lowerCase2) && !c(str)) {
                boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                z2 = (endsWith && z) ? b(lowerCase) == b(lowerCase2) : endsWith;
            } else {
                z2 = lowerCase.equals(lowerCase2);
            }
            if (z2) {
                break;
            }
        }
        if (z2) {
            return;
        }
        throw new javax.net.ssl.SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((java.lang.Object) stringBuffer));
    }

    public static boolean a(java.lang.String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i = length - 3;
        if (str.charAt(i) == '.') {
            return java.util.Arrays.binarySearch(b, str.substring(2, i)) < 0;
        }
        return true;
    }

    public static java.lang.String[] a(java.security.cert.X509Certificate x509Certificate) {
        java.util.List<java.lang.String> b2 = new com.huawei.secure.android.common.ssl.hostname.a(x509Certificate.getSubjectX500Principal()).b(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION);
        if (b2.isEmpty()) {
            return null;
        }
        java.lang.String[] strArr = new java.lang.String[b2.size()];
        b2.toArray(strArr);
        return strArr;
    }

    public static int b(java.lang.String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    public static java.lang.String[] b(java.security.cert.X509Certificate x509Certificate) {
        java.util.Collection<java.util.List<?>> collection;
        java.util.LinkedList linkedList = new java.util.LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (java.security.cert.CertificateParsingException e) {
            com.huawei.secure.android.common.ssl.util.g.a("", "Error parsing certificate.", e);
            collection = null;
        }
        if (collection != null) {
            for (java.util.List<?> list : collection) {
                if (((java.lang.Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((java.lang.String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        java.lang.String[] strArr = new java.lang.String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    public static boolean c(java.lang.String str) {
        return a.matcher(str).matches();
    }
}
