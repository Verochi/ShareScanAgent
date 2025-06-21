package androidx.core.net;

/* loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @androidx.annotation.NonNull
    public static java.lang.String toSafeString(@androidx.annotation.NonNull android.net.Uri uri) {
        java.lang.String scheme = uri.getScheme();
        java.lang.String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase(com.sensorsdata.sf.ui.view.UIProperty.action_type_tel) || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase(com.sensorsdata.sf.ui.view.UIProperty.action_type_sms) || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
                sb.append(scheme);
                sb.append(':');
                if (schemeSpecificPart != null) {
                    for (int i = 0; i < schemeSpecificPart.length(); i++) {
                        char charAt = schemeSpecificPart.charAt(i);
                        if (charAt == '-' || charAt == '@' || charAt == '.') {
                            sb.append(charAt);
                        } else {
                            sb.append('x');
                        }
                    }
                }
                return sb.toString();
            }
            if (scheme.equalsIgnoreCase(com.alipay.sdk.m.l.a.q) || scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("//");
                sb2.append(uri.getHost() != null ? uri.getHost() : "");
                sb2.append(uri.getPort() != -1 ? com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + uri.getPort() : "");
                sb2.append("/...");
                schemeSpecificPart = sb2.toString();
            }
        }
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder(64);
        if (scheme != null) {
            sb3.append(scheme);
            sb3.append(':');
        }
        if (schemeSpecificPart != null) {
            sb3.append(schemeSpecificPart);
        }
        return sb3.toString();
    }
}
