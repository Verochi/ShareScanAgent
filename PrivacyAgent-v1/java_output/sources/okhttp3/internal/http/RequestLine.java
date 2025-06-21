package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class RequestLine {
    public static boolean a(okhttp3.Request request, java.net.Proxy.Type type) {
        return !request.isHttps() && type == java.net.Proxy.Type.HTTP;
    }

    public static java.lang.String get(okhttp3.Request request, java.net.Proxy.Type type) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        if (a(request, type)) {
            sb.append(request.url());
        } else {
            sb.append(requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static java.lang.String requestPath(okhttp3.HttpUrl httpUrl) {
        java.lang.String encodedPath = httpUrl.encodedPath();
        java.lang.String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery == null) {
            return encodedPath;
        }
        return encodedPath + '?' + encodedQuery;
    }
}
