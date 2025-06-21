package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ByteSink {

    public final class AsCharSink extends com.google.common.io.CharSink {
        public final java.nio.charset.Charset a;

        public AsCharSink(java.nio.charset.Charset charset) {
            this.a = (java.nio.charset.Charset) com.google.common.base.Preconditions.checkNotNull(charset);
        }

        public /* synthetic */ AsCharSink(com.google.common.io.ByteSink byteSink, java.nio.charset.Charset charset, com.google.common.io.ByteSink.AnonymousClass1 anonymousClass1) {
            this(charset);
        }

        @Override // com.google.common.io.CharSink
        public java.io.Writer openStream() throws java.io.IOException {
            return new java.io.OutputStreamWriter(com.google.common.io.ByteSink.this.openStream(), this.a);
        }

        public java.lang.String toString() {
            return com.google.common.io.ByteSink.this.toString() + ".asCharSink(" + this.a + ")";
        }
    }

    public com.google.common.io.CharSink asCharSink(java.nio.charset.Charset charset) {
        return new com.google.common.io.ByteSink.AsCharSink(this, charset, null);
    }

    public java.io.OutputStream openBufferedStream() throws java.io.IOException {
        java.io.OutputStream openStream = openStream();
        return openStream instanceof java.io.BufferedOutputStream ? (java.io.BufferedOutputStream) openStream : new java.io.BufferedOutputStream(openStream);
    }

    public abstract java.io.OutputStream openStream() throws java.io.IOException;

    public void write(byte[] bArr) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        try {
            java.io.OutputStream outputStream = (java.io.OutputStream) com.google.common.io.Closer.create().register(openStream());
            outputStream.write(bArr);
            outputStream.flush();
        } finally {
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public long writeFrom(java.io.InputStream inputStream) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(inputStream);
        try {
            java.io.OutputStream outputStream = (java.io.OutputStream) com.google.common.io.Closer.create().register(openStream());
            long copy = com.google.common.io.ByteStreams.copy(inputStream, outputStream);
            outputStream.flush();
            return copy;
        } finally {
        }
    }
}
