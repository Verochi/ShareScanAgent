package com.alimm.tanx.core.web.cache.utils;

/* loaded from: classes.dex */
public class MimeTypeMapUtils {
    public static java.lang.String getFileExtensionFromUrl(java.lang.String str) {
        int lastIndexOf;
        java.lang.String lowerCase = str.toLowerCase();
        if (android.text.TextUtils.isEmpty(lowerCase)) {
            return "";
        }
        int lastIndexOf2 = lowerCase.lastIndexOf(35);
        if (lastIndexOf2 > 0) {
            lowerCase = lowerCase.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = lowerCase.lastIndexOf(63);
        if (lastIndexOf3 > 0) {
            lowerCase = lowerCase.substring(0, lastIndexOf3);
        }
        int lastIndexOf4 = lowerCase.lastIndexOf(47);
        if (lastIndexOf4 >= 0) {
            lowerCase = lowerCase.substring(lastIndexOf4 + 1);
        }
        return (lowerCase.isEmpty() || (lastIndexOf = lowerCase.lastIndexOf(46)) < 0) ? "" : lowerCase.substring(lastIndexOf + 1);
    }

    public static java.lang.String getMimeTypeFromExtension(java.lang.String str) {
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public static java.lang.String getMimeTypeFromUrl(java.lang.String str) {
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(getFileExtensionFromUrl(str));
    }
}
