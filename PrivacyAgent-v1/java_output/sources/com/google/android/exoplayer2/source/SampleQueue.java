package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public class SampleQueue implements com.google.android.exoplayer2.extractor.TrackOutput {
    public boolean A;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format B;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format C;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format D;
    public int E;
    public boolean F;
    public boolean G;
    public long H;
    public boolean I;
    public final com.google.android.exoplayer2.source.SampleDataQueue a;
    public final android.os.Looper c;
    public final com.google.android.exoplayer2.drm.DrmSessionManager d;
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher e;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener f;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format g;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession h;
    public int q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f357s;
    public int t;
    public boolean x;
    public final com.google.android.exoplayer2.source.SampleQueue.SampleExtrasHolder b = new com.google.android.exoplayer2.source.SampleQueue.SampleExtrasHolder();
    public int i = 1000;
    public int[] j = new int[1000];
    public long[] k = new long[1000];
    public long[] n = new long[1000];
    public int[] m = new int[1000];
    public int[] l = new int[1000];
    public com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[] o = new com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[1000];
    public com.google.android.exoplayer2.Format[] p = new com.google.android.exoplayer2.Format[1000];
    public long u = Long.MIN_VALUE;
    public long v = Long.MIN_VALUE;
    public long w = Long.MIN_VALUE;
    public boolean z = true;
    public boolean y = true;

    public static final class SampleExtrasHolder {
        public int a;
        public long b;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.extractor.TrackOutput.CryptoData c;
    }

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(com.google.android.exoplayer2.Format format);
    }

    public SampleQueue(com.google.android.exoplayer2.upstream.Allocator allocator, android.os.Looper looper, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.c = looper;
        this.d = drmSessionManager;
        this.e = eventDispatcher;
        this.a = new com.google.android.exoplayer2.source.SampleDataQueue(allocator);
    }

    public final synchronized boolean a(long j) {
        if (this.q == 0) {
            return j > this.v;
        }
        if (getLargestReadTimestampUs() >= j) {
            return false;
        }
        g(this.r + c(j));
        return true;
    }

    public final synchronized void b(long j, int i, long j2, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
        int i3 = this.q;
        if (i3 > 0) {
            int j3 = j(i3 - 1);
            com.google.android.exoplayer2.util.Assertions.checkArgument(this.k[j3] + ((long) this.l[j3]) <= j2);
        }
        this.x = (536870912 & i) != 0;
        this.w = java.lang.Math.max(this.w, j);
        int j4 = j(this.q);
        this.n[j4] = j;
        long[] jArr = this.k;
        jArr[j4] = j2;
        this.l[j4] = i2;
        this.m[j4] = i;
        this.o[j4] = cryptoData;
        com.google.android.exoplayer2.Format[] formatArr = this.p;
        com.google.android.exoplayer2.Format format = this.C;
        formatArr[j4] = format;
        this.j[j4] = this.E;
        this.D = format;
        int i4 = this.q + 1;
        this.q = i4;
        int i5 = this.i;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[] cryptoDataArr = new com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[i6];
            com.google.android.exoplayer2.Format[] formatArr2 = new com.google.android.exoplayer2.Format[i6];
            int i7 = this.f357s;
            int i8 = i5 - i7;
            java.lang.System.arraycopy(jArr, i7, jArr2, 0, i8);
            java.lang.System.arraycopy(this.n, this.f357s, jArr3, 0, i8);
            java.lang.System.arraycopy(this.m, this.f357s, iArr2, 0, i8);
            java.lang.System.arraycopy(this.l, this.f357s, iArr3, 0, i8);
            java.lang.System.arraycopy(this.o, this.f357s, cryptoDataArr, 0, i8);
            java.lang.System.arraycopy(this.p, this.f357s, formatArr2, 0, i8);
            java.lang.System.arraycopy(this.j, this.f357s, iArr, 0, i8);
            int i9 = this.f357s;
            java.lang.System.arraycopy(this.k, 0, jArr2, i8, i9);
            java.lang.System.arraycopy(this.n, 0, jArr3, i8, i9);
            java.lang.System.arraycopy(this.m, 0, iArr2, i8, i9);
            java.lang.System.arraycopy(this.l, 0, iArr3, i8, i9);
            java.lang.System.arraycopy(this.o, 0, cryptoDataArr, i8, i9);
            java.lang.System.arraycopy(this.p, 0, formatArr2, i8, i9);
            java.lang.System.arraycopy(this.j, 0, iArr, i8, i9);
            this.k = jArr2;
            this.n = jArr3;
            this.m = iArr2;
            this.l = iArr3;
            this.o = cryptoDataArr;
            this.p = formatArr2;
            this.j = iArr;
            this.f357s = 0;
            this.i = i6;
        }
    }

    public final int c(long j) {
        int i = this.q;
        int j2 = j(i - 1);
        while (i > this.t && this.n[j2] >= j) {
            i--;
            j2--;
            if (j2 == -1) {
                j2 = this.i - 1;
            }
        }
        return i;
    }

    public final synchronized long d(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.q;
        if (i2 != 0) {
            long[] jArr = this.n;
            int i3 = this.f357s;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.t) != i2) {
                    i2 = i + 1;
                }
                int h = h(i3, i2, j, z);
                if (h == -1) {
                    return -1L;
                }
                return f(h);
            }
        }
        return -1L;
    }

    public synchronized long discardSampleMetadataToRead() {
        int i = this.t;
        if (i == 0) {
            return -1L;
        }
        return f(i);
    }

    public final void discardTo(long j, boolean z, boolean z2) {
        this.a.c(d(j, z, z2));
    }

    public final void discardToEnd() {
        this.a.c(e());
    }

    public final void discardToRead() {
        this.a.c(discardSampleMetadataToRead());
    }

    public final void discardUpstreamFrom(long j) {
        if (this.q == 0) {
            return;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(j > getLargestReadTimestampUs());
        discardUpstreamSamples(this.r + c(j));
    }

    public final void discardUpstreamSamples(int i) {
        this.a.d(g(i));
    }

    public final synchronized long e() {
        int i = this.q;
        if (i == 0) {
            return -1L;
        }
        return f(i);
    }

    public final long f(int i) {
        this.v = java.lang.Math.max(this.v, i(i));
        int i2 = this.q - i;
        this.q = i2;
        this.r += i;
        int i3 = this.f357s + i;
        this.f357s = i3;
        int i4 = this.i;
        if (i3 >= i4) {
            this.f357s = i3 - i4;
        }
        int i5 = this.t - i;
        this.t = i5;
        if (i5 < 0) {
            this.t = 0;
        }
        if (i2 != 0) {
            return this.k[this.f357s];
        }
        int i6 = this.f357s;
        if (i6 != 0) {
            i4 = i6;
        }
        return this.k[i4 - 1] + this.l[r2];
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void format(com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(format);
        this.A = false;
        this.B = format;
        boolean q = q(adjustedUpstreamFormat);
        com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener upstreamFormatChangedListener = this.f;
        if (upstreamFormatChangedListener == null || !q) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
    }

    public final long g(int i) {
        int writeIndex = getWriteIndex() - i;
        boolean z = false;
        com.google.android.exoplayer2.util.Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.q - this.t);
        int i2 = this.q - writeIndex;
        this.q = i2;
        this.w = java.lang.Math.max(this.v, i(i2));
        if (writeIndex == 0 && this.x) {
            z = true;
        }
        this.x = z;
        int i3 = this.q;
        if (i3 == 0) {
            return 0L;
        }
        return this.k[j(i3 - 1)] + this.l[r8];
    }

    @androidx.annotation.CallSuper
    public com.google.android.exoplayer2.Format getAdjustedUpstreamFormat(com.google.android.exoplayer2.Format format) {
        return (this.H == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.H).build();
    }

    public final int getFirstIndex() {
        return this.r;
    }

    public final synchronized long getFirstTimestampUs() {
        return this.q == 0 ? Long.MIN_VALUE : this.n[this.f357s];
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.w;
    }

    public final synchronized long getLargestReadTimestampUs() {
        return java.lang.Math.max(this.v, i(this.t));
    }

    public final int getReadIndex() {
        return this.r + this.t;
    }

    public final synchronized int getSkipCount(long j, boolean z) {
        int j2 = j(this.t);
        if (k() && j >= this.n[j2]) {
            if (j > this.w && z) {
                return this.q - this.t;
            }
            int h = h(j2, this.q - this.t, j, true);
            if (h == -1) {
                return 0;
            }
            return h;
        }
        return 0;
    }

    @androidx.annotation.Nullable
    public final synchronized com.google.android.exoplayer2.Format getUpstreamFormat() {
        return this.z ? null : this.C;
    }

    public final int getWriteIndex() {
        return this.r + this.q;
    }

    public final int h(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2 && this.n[i] <= j; i4++) {
            if (!z || (this.m[i] & 1) != 0) {
                i3 = i4;
            }
            i++;
            if (i == this.i) {
                i = 0;
            }
        }
        return i3;
    }

    public final long i(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int j2 = j(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = java.lang.Math.max(j, this.n[j2]);
            if ((this.m[j2] & 1) != 0) {
                break;
            }
            j2--;
            if (j2 == -1) {
                j2 = this.i - 1;
            }
        }
        return j;
    }

    public final void invalidateUpstreamFormatAdjustment() {
        this.A = true;
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.x;
    }

    @androidx.annotation.CallSuper
    public synchronized boolean isReady(boolean z) {
        com.google.android.exoplayer2.Format format;
        boolean z2 = true;
        if (k()) {
            int j = j(this.t);
            if (this.p[j] != this.g) {
                return true;
            }
            return l(j);
        }
        if (!z && !this.x && ((format = this.C) == null || format == this.g)) {
            z2 = false;
        }
        return z2;
    }

    public final int j(int i) {
        int i2 = this.f357s + i;
        int i3 = this.i;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final boolean k() {
        return this.t != this.q;
    }

    public final boolean l(int i) {
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.h;
        return drmSession == null || drmSession.getState() == 4 || ((this.m[i] & 1073741824) == 0 && this.h.playClearSamplesWithoutKeys());
    }

    public final void m(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.FormatHolder formatHolder) {
        com.google.android.exoplayer2.Format format2 = this.g;
        boolean z = format2 == null;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = z ? null : format2.drmInitData;
        this.g = format;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData2 = format.drmInitData;
        formatHolder.format = format.copyWithExoMediaCryptoType(this.d.getExoMediaCryptoType(format));
        formatHolder.drmSession = this.h;
        if (z || !com.google.android.exoplayer2.util.Util.areEqual(drmInitData, drmInitData2)) {
            com.google.android.exoplayer2.drm.DrmSession drmSession = this.h;
            com.google.android.exoplayer2.drm.DrmSession acquireSession = this.d.acquireSession(this.c, this.e, format);
            this.h = acquireSession;
            formatHolder.drmSession = acquireSession;
            if (drmSession != null) {
                drmSession.release(this.e);
            }
        }
    }

    @androidx.annotation.CallSuper
    public void maybeThrowError() throws java.io.IOException {
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((com.google.android.exoplayer2.drm.DrmSession.DrmSessionException) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.h.getError()));
        }
    }

    public final synchronized int n(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, com.google.android.exoplayer2.source.SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        decoderInputBuffer.waitingForKeys = false;
        if (!k()) {
            if (!z2 && !this.x) {
                com.google.android.exoplayer2.Format format = this.C;
                if (format == null || (!z && format == this.g)) {
                    return -3;
                }
                m((com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(format), formatHolder);
                return -5;
            }
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        int j = j(this.t);
        if (!z && this.p[j] == this.g) {
            if (!l(j)) {
                decoderInputBuffer.waitingForKeys = true;
                return -3;
            }
            decoderInputBuffer.setFlags(this.m[j]);
            long j2 = this.n[j];
            decoderInputBuffer.timeUs = j2;
            if (j2 < this.u) {
                decoderInputBuffer.addFlag(Integer.MIN_VALUE);
            }
            if (decoderInputBuffer.isFlagsOnly()) {
                return -4;
            }
            sampleExtrasHolder.a = this.l[j];
            sampleExtrasHolder.b = this.k[j];
            sampleExtrasHolder.c = this.o[j];
            this.t++;
            return -4;
        }
        m(this.p[j], formatHolder);
        return -5;
    }

    public final void o() {
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.h;
        if (drmSession != null) {
            drmSession.release(this.e);
            this.h = null;
            this.g = null;
        }
    }

    public final synchronized void p() {
        this.t = 0;
        this.a.m();
    }

    public final synchronized int peekSourceId() {
        return k() ? this.j[j(this.t)] : this.E;
    }

    @androidx.annotation.CallSuper
    public void preRelease() {
        discardToEnd();
        o();
    }

    public final synchronized boolean q(com.google.android.exoplayer2.Format format) {
        this.z = false;
        if (com.google.android.exoplayer2.util.Util.areEqual(format, this.C)) {
            return false;
        }
        if (com.google.android.exoplayer2.util.Util.areEqual(format, this.D)) {
            this.C = this.D;
        } else {
            this.C = format;
        }
        com.google.android.exoplayer2.Format format2 = this.C;
        this.F = com.google.android.exoplayer2.util.MimeTypes.allSamplesAreSyncSamples(format2.sampleMimeType, format2.codecs);
        this.G = false;
        return true;
    }

    @androidx.annotation.CallSuper
    public int read(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2) {
        int n = n(formatHolder, decoderInputBuffer, z, z2, this.b);
        if (n == -4 && !decoderInputBuffer.isEndOfStream() && !decoderInputBuffer.isFlagsOnly()) {
            this.a.k(decoderInputBuffer, this.b);
        }
        return n;
    }

    @androidx.annotation.CallSuper
    public void release() {
        reset(true);
        o();
    }

    public final void reset() {
        reset(false);
    }

    @androidx.annotation.CallSuper
    public void reset(boolean z) {
        this.a.l();
        this.q = 0;
        this.r = 0;
        this.f357s = 0;
        this.t = 0;
        this.y = true;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = Long.MIN_VALUE;
        this.x = false;
        this.D = null;
        if (z) {
            this.B = null;
            this.C = null;
            this.z = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z) {
        return defpackage.p33.a(this, dataReader, i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z, int i2) throws java.io.IOException {
        return this.a.n(dataReader, i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        defpackage.p33.b(this, parsableByteArray, i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
        this.a.o(parsableByteArray, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sampleMetadata(long j, int i, int i2, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
        int i4;
        if (this.A) {
            format((com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.B));
        }
        int i5 = i & 1;
        boolean z = i5 != 0;
        if (this.y) {
            if (!z) {
                return;
            } else {
                this.y = false;
            }
        }
        long j2 = this.H + j;
        if (this.F) {
            if (j2 < this.u) {
                return;
            }
            if (i5 == 0) {
                if (!this.G) {
                    java.lang.String valueOf = java.lang.String.valueOf(this.C);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 50);
                    sb.append("Overriding unexpected non-sync sample for format: ");
                    sb.append(valueOf);
                    this.G = true;
                }
                i4 = i | 1;
                if (this.I) {
                    if (!z || !a(j2)) {
                        return;
                    } else {
                        this.I = false;
                    }
                }
                b(j2, i4, (this.a.e() - i2) - i3, i2, cryptoData);
            }
        }
        i4 = i;
        if (this.I) {
        }
        b(j2, i4, (this.a.e() - i2) - i3, i2, cryptoData);
    }

    public final synchronized boolean seekTo(int i) {
        p();
        int i2 = this.r;
        if (i >= i2 && i <= this.q + i2) {
            this.u = Long.MIN_VALUE;
            this.t = i - i2;
            return true;
        }
        return false;
    }

    public final synchronized boolean seekTo(long j, boolean z) {
        p();
        int j2 = j(this.t);
        if (k() && j >= this.n[j2] && (j <= this.w || z)) {
            int h = h(j2, this.q - this.t, j, true);
            if (h == -1) {
                return false;
            }
            this.u = j;
            this.t += h;
            return true;
        }
        return false;
    }

    public final void setSampleOffsetUs(long j) {
        if (this.H != j) {
            this.H = j;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setStartTimeUs(long j) {
        this.u = j;
    }

    public final void setUpstreamFormatChangeListener(@androidx.annotation.Nullable com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f = upstreamFormatChangedListener;
    }

    public final synchronized void skip(int i) {
        boolean z;
        if (i >= 0) {
            try {
                if (this.t + i <= this.q) {
                    z = true;
                    com.google.android.exoplayer2.util.Assertions.checkArgument(z);
                    this.t += i;
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        z = false;
        com.google.android.exoplayer2.util.Assertions.checkArgument(z);
        this.t += i;
    }

    public final void sourceId(int i) {
        this.E = i;
    }

    public final void splice() {
        this.I = true;
    }
}
