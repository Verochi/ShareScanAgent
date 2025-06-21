package okio;

/* loaded from: classes24.dex */
public interface BufferedSink extends okio.Sink, java.nio.channels.WritableByteChannel {
    okio.Buffer buffer();

    okio.BufferedSink emit() throws java.io.IOException;

    okio.BufferedSink emitCompleteSegments() throws java.io.IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws java.io.IOException;

    java.io.OutputStream outputStream();

    okio.BufferedSink write(okio.ByteString byteString) throws java.io.IOException;

    okio.BufferedSink write(okio.Source source, long j) throws java.io.IOException;

    okio.BufferedSink write(byte[] bArr) throws java.io.IOException;

    okio.BufferedSink write(byte[] bArr, int i, int i2) throws java.io.IOException;

    long writeAll(okio.Source source) throws java.io.IOException;

    okio.BufferedSink writeByte(int i) throws java.io.IOException;

    okio.BufferedSink writeDecimalLong(long j) throws java.io.IOException;

    okio.BufferedSink writeHexadecimalUnsignedLong(long j) throws java.io.IOException;

    okio.BufferedSink writeInt(int i) throws java.io.IOException;

    okio.BufferedSink writeIntLe(int i) throws java.io.IOException;

    okio.BufferedSink writeLong(long j) throws java.io.IOException;

    okio.BufferedSink writeLongLe(long j) throws java.io.IOException;

    okio.BufferedSink writeShort(int i) throws java.io.IOException;

    okio.BufferedSink writeShortLe(int i) throws java.io.IOException;

    okio.BufferedSink writeString(java.lang.String str, int i, int i2, java.nio.charset.Charset charset) throws java.io.IOException;

    okio.BufferedSink writeString(java.lang.String str, java.nio.charset.Charset charset) throws java.io.IOException;

    okio.BufferedSink writeUtf8(java.lang.String str) throws java.io.IOException;

    okio.BufferedSink writeUtf8(java.lang.String str, int i, int i2) throws java.io.IOException;

    okio.BufferedSink writeUtf8CodePoint(int i) throws java.io.IOException;
}
