package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public final class jad_jw {
    public static boolean jad_an(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            int length = str.length();
            if (length % 4 != 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= length) {
                    return true;
                }
                if (i == length - 3 && charArray[i] == '=') {
                    return false;
                }
                char c = charArray[i];
                if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && ((c < '0' || c > '9') && c != '_' && c != '-' && c != '='))) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
                i++;
            }
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
