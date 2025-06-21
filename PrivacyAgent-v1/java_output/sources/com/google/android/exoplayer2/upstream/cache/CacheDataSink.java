package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public final class CacheDataSink implements com.google.android.exoplayer2.upstream.DataSink {
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    public static final long DEFAULT_FRAGMENT_SIZE = 5242880;
    public final com.google.android.exoplayer2.upstream.cache.Cache a;
    public final long b;
    public final int c;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSpec d;
    public long e;

    @androidx.annotation.Nullable
    public java.io.File f;

    @androidx.annotation.Nullable
    public java.io.OutputStream g;
    public long h;
    public long i;
    public com.google.android.exoplayer2.util.ReusableBufferedOutputStream j;

    public static final class CacheDataSinkException extends com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        public CacheDataSinkException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public static final class Factory implements com.google.android.exoplayer2.upstream.DataSink.Factory {
        public com.google.android.exoplayer2.upstream.cache.Cache a;
        public long b = com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_FRAGMENT_SIZE;
        public int c = 20480;

        @Override // com.google.android.exoplayer2.upstream.DataSink.Factory
        public com.google.android.exoplayer2.upstream.DataSink createDataSink() {
            return new com.google.android.exoplayer2.upstream.cache.CacheDataSink((com.google.android.exoplayer2.upstream.cache.Cache) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.a), this.b, this.c);
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSink.Factory setBufferSize(int i) {
            this.c = i;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSink.Factory setCache(com.google.android.exoplayer2.upstream.cache.Cache cache) {
            this.a = cache;
            return this;
        }

        public com.google.android.exoplayer2.upstream.cache.CacheDataSink.Factory setFragmentSize(long j) {
            this.b = j;
            return this;
        }
    }

    public CacheDataSink(com.google.android.exoplayer2.upstream.cache.Cache cache, long j) {
        this(cache, j, 20480);
    }

    public CacheDataSink(com.google.android.exoplayer2.upstream.cache.Cache cache, long j, int i) {
        com.google.android.exoplayer2.util.Assertions.checkState(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < 2097152) {
            com.google.android.exoplayer2.util.Log.w("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.a = (com.google.android.exoplayer2.upstream.cache.Cache) com.google.android.exoplayer2.util.Assertions.checkNotNull(cache);
        this.b = j == -1 ? Long.MAX_VALUE : j;
        this.c = i;
    }

    public final void a() throws java.io.IOException {
        java.io.OutputStream outputStream = this.g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            com.google.android.exoplayer2.util.Util.closeQuietly(this.g);
            this.g = null;
            java.io.File file = (java.io.File) com.google.android.exoplayer2.util.Util.castNonNull(this.f);
            this.f = null;
            this.a.commitFile(file, this.h);
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Util.closeQuietly(this.g);
            this.g = null;
            java.io.File file2 = (java.io.File) com.google.android.exoplayer2.util.Util.castNonNull(this.f);
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    public final void b(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        long j = dataSpec.length;
        this.f = this.a.startFile((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(dataSpec.key), dataSpec.position + this.i, j != -1 ? java.lang.Math.min(j - this.i, this.e) : -1L);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(this.f);
        if (this.c > 0) {
            com.google.android.exoplayer2.util.ReusableBufferedOutputStream reusableBufferedOutputStream = this.j;
            if (reusableBufferedOutputStream == null) {
                this.j = new com.google.android.exoplayer2.util.ReusableBufferedOutputStream(fileOutputStream, this.c);
            } else {
                reusableBufferedOutputStream.reset(fileOutputStream);
            }
            this.g = this.j;
        } else {
            this.g = fileOutputStream;
        }
        this.h = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException {
        if (this.d == null) {
            return;
        }
        try {
            a();
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSpec.key);
        if (dataSpec.length == -1 && dataSpec.isFlagSet(2)) {
            this.d = null;
            return;
        }
        this.d = dataSpec;
        this.e = dataSpec.isFlagSet(4) ? this.b : Long.MAX_VALUE;
        this.i = 0L;
        try {
            b(dataSpec);
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) throws com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = this.d;
        if (dataSpec == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.h == this.e) {
                    a();
                    b(dataSpec);
                }
                int min = (int) java.lang.Math.min(i2 - i3, this.e - this.h);
                ((java.io.OutputStream) com.google.android.exoplayer2.util.Util.castNonNull(this.g)).write(bArr, i + i3, min);
                i3 += min;
                long j = min;
                this.h += j;
                this.i += j;
            } catch (java.io.IOException e) {
                throw new com.google.android.exoplayer2.upstream.cache.CacheDataSink.CacheDataSinkException(e);
            }
        }
    }
}
