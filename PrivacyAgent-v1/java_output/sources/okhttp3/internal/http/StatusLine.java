package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class StatusLine {
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final java.lang.String message;
    public final okhttp3.Protocol protocol;

    public StatusLine(okhttp3.Protocol protocol, int i, java.lang.String str) {
        this.protocol = protocol;
        this.code = i;
        this.message = str;
    }

    public static okhttp3.internal.http.StatusLine get(okhttp3.Response response) {
        return new okhttp3.internal.http.StatusLine(response.protocol(), response.code(), response.message());
    }

    public static okhttp3.internal.http.StatusLine parse(java.lang.String str) throws java.io.IOException {
        okhttp3.Protocol protocol;
        int i;
        java.lang.String str2;
        if (str.startsWith("HTTP/1.")) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new java.net.ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                protocol = okhttp3.Protocol.HTTP_1_0;
            } else {
                if (charAt != 1) {
                    throw new java.net.ProtocolException("Unexpected status line: " + str);
                }
                protocol = okhttp3.Protocol.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new java.net.ProtocolException("Unexpected status line: " + str);
            }
            protocol = okhttp3.Protocol.HTTP_1_0;
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new java.net.ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = java.lang.Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                str2 = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new java.net.ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i + 4);
            }
            return new okhttp3.internal.http.StatusLine(protocol, parseInt, str2);
        } catch (java.lang.NumberFormatException unused) {
            throw new java.net.ProtocolException("Unexpected status line: " + str);
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.protocol == okhttp3.Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.code);
        if (this.message != null) {
            sb.append(' ');
            sb.append(this.message);
        }
        return sb.toString();
    }
}
