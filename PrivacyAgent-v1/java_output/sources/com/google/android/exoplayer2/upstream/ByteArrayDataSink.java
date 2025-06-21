package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class ByteArrayDataSink implements com.google.android.exoplayer2.upstream.DataSink {
    public java.io.ByteArrayOutputStream a;

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws java.io.IOException {
        ((java.io.ByteArrayOutputStream) com.google.android.exoplayer2.util.Util.castNonNull(this.a)).close();
    }

    @androidx.annotation.Nullable
    public byte[] getData() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = this.a;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        long j = dataSpec.length;
        if (j == -1) {
            this.a = new java.io.ByteArrayOutputStream();
        } else {
            com.google.android.exoplayer2.util.Assertions.checkArgument(j <= 2147483647L);
            this.a = new java.io.ByteArrayOutputStream((int) dataSpec.length);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) {
        ((java.io.ByteArrayOutputStream) com.google.android.exoplayer2.util.Util.castNonNull(this.a)).write(bArr, i, i2);
    }
}
