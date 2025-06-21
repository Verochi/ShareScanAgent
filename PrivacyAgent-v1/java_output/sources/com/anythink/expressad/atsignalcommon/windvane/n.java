package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public final class n {
    private static final java.lang.String[] a = {"wv_hybrid:", "mraid:", "ssp:", "mvb_hybrid:"};
    private static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static final java.util.regex.Pattern c = java.util.regex.Pattern.compile("mraid://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static final java.util.regex.Pattern d = java.util.regex.Pattern.compile("ssp://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static final java.util.regex.Pattern e = java.util.regex.Pattern.compile("mv://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static java.util.Map<java.lang.String, java.lang.String> f = new java.util.HashMap();

    static {
        for (com.anythink.expressad.atsignalcommon.windvane.h hVar : com.anythink.expressad.atsignalcommon.windvane.h.values()) {
            f.put(hVar.a(), hVar.b());
        }
    }

    public static boolean a(java.lang.String str) {
        for (java.lang.String str2 : a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static java.util.regex.Pattern b(java.lang.String str) {
        if ("wv_hybrid:".equals(str)) {
            return e;
        }
        if ("mraid:".equals(str)) {
            return c;
        }
        if ("ssp:".equals(str)) {
            return d;
        }
        if ("mvb_hybrid:".equals(str)) {
            return e;
        }
        return null;
    }

    public static java.lang.String c(java.lang.String str) {
        char[] cArr = {'\'', '\\'};
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            boolean z = true;
            if (charAt > 255) {
                stringBuffer.append("\\u");
                java.lang.String upperCase = java.lang.Integer.toHexString(charAt >>> '\b').toUpperCase();
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                java.lang.String upperCase2 = java.lang.Integer.toHexString(charAt & 255).toUpperCase();
                if (upperCase2.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase2);
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        z = false;
                        break;
                    }
                    if (cArr[i2] == charAt) {
                        stringBuffer.append("\\".concat(java.lang.String.valueOf(charAt)));
                        break;
                    }
                    i2++;
                }
                if (!z) {
                    stringBuffer.append(charAt);
                }
            }
        }
        return new java.lang.String(stringBuffer);
    }

    public static boolean d(java.lang.String str) {
        return e(str).startsWith("image");
    }

    public static java.lang.String e(java.lang.String str) {
        java.lang.String str2 = f.get(f(str));
        return str2 == null ? "" : str2;
    }

    private static java.lang.String f(java.lang.String str) {
        java.lang.String path;
        int lastIndexOf;
        return (android.text.TextUtils.isEmpty(str) || (path = android.net.Uri.parse(str).getPath()) == null || (lastIndexOf = path.lastIndexOf(".")) == -1) ? "" : path.substring(lastIndexOf + 1);
    }
}
