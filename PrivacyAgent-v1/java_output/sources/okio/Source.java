package okio;

/* loaded from: classes24.dex */
public interface Source extends java.io.Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws java.io.IOException;

    long read(okio.Buffer buffer, long j) throws java.io.IOException;

    okio.Timeout timeout();
}
