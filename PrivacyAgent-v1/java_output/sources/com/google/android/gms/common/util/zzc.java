package com.google.android.gms.common.util;

@com.google.android.gms.common.util.VisibleForTesting
/* loaded from: classes22.dex */
public final class zzc {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static java.lang.String zza(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.util.regex.Matcher matcher = a.matcher(str);
        java.lang.StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new java.lang.StringBuffer();
            }
            matcher.appendReplacement(stringBuffer, new java.lang.String(java.lang.Character.toChars(java.lang.Integer.parseInt(matcher.group().substring(2), 16))));
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
