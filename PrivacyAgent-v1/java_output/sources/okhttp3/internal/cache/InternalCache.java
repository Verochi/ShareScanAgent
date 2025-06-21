package okhttp3.internal.cache;

/* loaded from: classes23.dex */
public interface InternalCache {
    @javax.annotation.Nullable
    okhttp3.Response get(okhttp3.Request request) throws java.io.IOException;

    @javax.annotation.Nullable
    okhttp3.internal.cache.CacheRequest put(okhttp3.Response response) throws java.io.IOException;

    void remove(okhttp3.Request request) throws java.io.IOException;

    void trackConditionalCacheHit();

    void trackResponse(okhttp3.internal.cache.CacheStrategy cacheStrategy);

    void update(okhttp3.Response response, okhttp3.Response response2);
}
