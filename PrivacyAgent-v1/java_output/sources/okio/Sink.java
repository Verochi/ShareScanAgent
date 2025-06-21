package okio;

/* loaded from: classes24.dex */
public interface Sink extends java.io.Closeable, java.io.Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws java.io.IOException;

    void flush() throws java.io.IOException;

    okio.Timeout timeout();

    void write(okio.Buffer buffer, long j) throws java.io.IOException;
}
