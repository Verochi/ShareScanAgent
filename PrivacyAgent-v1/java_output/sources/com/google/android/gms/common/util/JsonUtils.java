package com.google.android.gms.common.util;

@com.google.android.gms.common.util.VisibleForTesting
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class JsonUtils {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("\\\\.");
    public static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean areJsonValuesEquivalent(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if ((obj instanceof org.json.JSONObject) && (obj2 instanceof org.json.JSONObject)) {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            org.json.JSONObject jSONObject2 = (org.json.JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                if (!jSONObject2.has(next)) {
                    return false;
                }
                if (!areJsonValuesEquivalent(jSONObject.get((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(next)), jSONObject2.get(next))) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof org.json.JSONArray) || !(obj2 instanceof org.json.JSONArray)) {
            return obj.equals(obj2);
        }
        org.json.JSONArray jSONArray = (org.json.JSONArray) obj;
        org.json.JSONArray jSONArray2 = (org.json.JSONArray) obj2;
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (!areJsonValuesEquivalent(jSONArray.get(i), jSONArray2.get(i))) {
                    return false;
                }
            } catch (org.json.JSONException unused) {
                return false;
            }
        }
        return true;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String escapeString(@androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.util.regex.Matcher matcher = b.matcher(str);
        java.lang.StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new java.lang.StringBuffer();
            }
            char charAt = matcher.group().charAt(0);
            if (charAt == '\f') {
                matcher.appendReplacement(stringBuffer, "\\\\f");
            } else if (charAt == '\r') {
                matcher.appendReplacement(stringBuffer, "\\\\r");
            } else if (charAt == '\"') {
                matcher.appendReplacement(stringBuffer, "\\\\\\\"");
            } else if (charAt == '/') {
                matcher.appendReplacement(stringBuffer, "\\\\/");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case '\b':
                        matcher.appendReplacement(stringBuffer, "\\\\b");
                        break;
                    case '\t':
                        matcher.appendReplacement(stringBuffer, "\\\\t");
                        break;
                    case '\n':
                        matcher.appendReplacement(stringBuffer, "\\\\n");
                        break;
                }
            } else {
                matcher.appendReplacement(stringBuffer, "\\\\\\\\");
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String unescapeString(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String zza = com.google.android.gms.common.util.zzc.zza(str);
        java.util.regex.Matcher matcher = a.matcher(zza);
        java.lang.StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new java.lang.StringBuffer();
            }
            char charAt = matcher.group().charAt(1);
            if (charAt == '\"') {
                matcher.appendReplacement(stringBuffer, "\"");
            } else if (charAt == '/') {
                matcher.appendReplacement(stringBuffer, net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            } else if (charAt == '\\') {
                matcher.appendReplacement(stringBuffer, "\\\\");
            } else if (charAt == 'b') {
                matcher.appendReplacement(stringBuffer, "\b");
            } else if (charAt == 'f') {
                matcher.appendReplacement(stringBuffer, "\f");
            } else if (charAt == 'n') {
                matcher.appendReplacement(stringBuffer, "\n");
            } else if (charAt == 'r') {
                matcher.appendReplacement(stringBuffer, "\r");
            } else {
                if (charAt != 't') {
                    throw new java.lang.IllegalStateException("Found an escaped character that should never be.");
                }
                matcher.appendReplacement(stringBuffer, "\t");
            }
        }
        if (stringBuffer == null) {
            return zza;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
