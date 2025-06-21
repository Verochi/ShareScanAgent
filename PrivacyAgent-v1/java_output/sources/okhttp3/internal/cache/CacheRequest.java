package okhttp3.internal.cache;

/* loaded from: classes23.dex */
public interface CacheRequest {
    void abort();

    okio.Sink body() throws java.io.IOException;
}
