package okhttp3.internal;

/* loaded from: classes23.dex */
public abstract class Internal {
    public static okhttp3.internal.Internal instance;

    public static void initializeInstanceForTests() {
        new okhttp3.OkHttpClient();
    }

    public abstract void addLenient(okhttp3.Headers.Builder builder, java.lang.String str);

    public abstract void addLenient(okhttp3.Headers.Builder builder, java.lang.String str, java.lang.String str2);

    public abstract void apply(okhttp3.ConnectionSpec connectionSpec, javax.net.ssl.SSLSocket sSLSocket, boolean z);

    public abstract int code(okhttp3.Response.Builder builder);

    public abstract boolean equalsNonHost(okhttp3.Address address, okhttp3.Address address2);

    @javax.annotation.Nullable
    public abstract okhttp3.internal.connection.Exchange exchange(okhttp3.Response response);

    public abstract void initExchange(okhttp3.Response.Builder builder, okhttp3.internal.connection.Exchange exchange);

    public abstract okhttp3.Call newWebSocketCall(okhttp3.OkHttpClient okHttpClient, okhttp3.Request request);

    public abstract okhttp3.internal.connection.RealConnectionPool realConnectionPool(okhttp3.ConnectionPool connectionPool);
}
