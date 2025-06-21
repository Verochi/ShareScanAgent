package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public abstract class DataChunk extends com.google.android.exoplayer2.source.chunk.Chunk {
    public byte[] a;
    public volatile boolean b;

    public DataChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i, com.google.android.exoplayer2.Format format, int i2, @androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable byte[] bArr) {
        super(dataSource, dataSpec, i, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        com.google.android.exoplayer2.source.chunk.DataChunk dataChunk;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
            dataChunk = this;
        } else {
            dataChunk = this;
            bArr2 = bArr;
        }
        dataChunk.a = bArr2;
    }

    public final void a(int i) {
        byte[] bArr = this.a;
        if (bArr.length < i + 16384) {
            this.a = java.util.Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.b = true;
    }

    public abstract void consume(byte[] bArr, int i) throws java.io.IOException;

    public byte[] getDataHolder() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws java.io.IOException {
        try {
            this.dataSource.open(this.dataSpec);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.b) {
                a(i2);
                i = this.dataSource.read(this.a, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.b) {
                consume(this.a, i2);
            }
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
        }
    }
}
