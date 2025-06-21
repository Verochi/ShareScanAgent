package okhttp3;

/* loaded from: classes23.dex */
public interface Interceptor {

    public interface Chain {
        okhttp3.Call call();

        int connectTimeoutMillis();

        @javax.annotation.Nullable
        okhttp3.Connection connection();

        okhttp3.Response proceed(okhttp3.Request request) throws java.io.IOException;

        int readTimeoutMillis();

        okhttp3.Request request();

        okhttp3.Interceptor.Chain withConnectTimeout(int i, java.util.concurrent.TimeUnit timeUnit);

        okhttp3.Interceptor.Chain withReadTimeout(int i, java.util.concurrent.TimeUnit timeUnit);

        okhttp3.Interceptor.Chain withWriteTimeout(int i, java.util.concurrent.TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException;
}
