package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public class AdaptiveTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public final com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.BandwidthProvider d;
    public final long e;
    public final long f;
    public final long g;
    public final float h;
    public final com.google.android.exoplayer2.util.Clock i;
    public float j;
    public int k;
    public int l;
    public long m;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.chunk.MediaChunk n;

    public interface BandwidthProvider {
        long a();
    }

    public static final class DefaultBandwidthProvider implements com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.BandwidthProvider {
        public final com.google.android.exoplayer2.upstream.BandwidthMeter a;
        public final float b;
        public final long c;

        @androidx.annotation.Nullable
        public long[][] d;

        public DefaultBandwidthProvider(com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, float f, long j) {
            this.a = bandwidthMeter;
            this.b = f;
            this.c = j;
        }

        @Override // com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.BandwidthProvider
        public long a() {
            long[][] jArr;
            long max = java.lang.Math.max(0L, ((long) (this.a.getBitrateEstimate() * this.b)) - this.c);
            if (this.d == null) {
                return max;
            }
            int i = 1;
            while (true) {
                jArr = this.d;
                if (i >= jArr.length - 1 || jArr[i][0] >= max) {
                    break;
                }
                i++;
            }
            long[] jArr2 = jArr[i - 1];
            long[] jArr3 = jArr[i];
            long j = jArr2[0];
            float f = (max - j) / (jArr3[0] - j);
            return jArr2[1] + ((long) (f * (jArr3[1] - r4)));
        }

        public void b(long[][] jArr) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(jArr.length >= 2);
            this.d = jArr;
        }
    }

    public static class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        public final int a;
        public final int b;
        public final int c;
        public final float d;
        public final float e;
        public final com.google.android.exoplayer2.util.Clock f;

        public Factory() {
            this(10000, 25000, 25000, 0.7f, 0.75f, com.google.android.exoplayer2.util.Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f) {
            this(i, i2, i3, f, 0.75f, com.google.android.exoplayer2.util.Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f, float f2, com.google.android.exoplayer2.util.Clock clock) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = f;
            this.e = f2;
            this.f = clock;
        }

        public com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection createAdaptiveTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, int[] iArr, int i) {
            return new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection(trackGroup, iArr, new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DefaultBandwidthProvider(bandwidthMeter, this.d, i), this.a, this.b, this.c, this.e, this.f, null);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public final com.google.android.exoplayer2.trackselection.TrackSelection[] createTrackSelections(com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] definitionArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
            com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr = new com.google.android.exoplayer2.trackselection.TrackSelection[definitionArr.length];
            int i = 0;
            for (int i2 = 0; i2 < definitionArr.length; i2++) {
                com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition = definitionArr[i2];
                if (definition != null) {
                    int[] iArr = definition.tracks;
                    if (iArr.length == 1) {
                        trackSelectionArr[i2] = new com.google.android.exoplayer2.trackselection.FixedTrackSelection(definition.group, iArr[0], definition.reason, definition.data);
                        int i3 = definition.group.getFormat(definition.tracks[0]).bitrate;
                        if (i3 != -1) {
                            i += i3;
                        }
                    }
                }
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i4 = 0; i4 < definitionArr.length; i4++) {
                com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition2 = definitionArr[i4];
                if (definition2 != null) {
                    int[] iArr2 = definition2.tracks;
                    if (iArr2.length > 1) {
                        com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection createAdaptiveTrackSelection = createAdaptiveTrackSelection(definition2.group, bandwidthMeter, iArr2, i);
                        arrayList.add(createAdaptiveTrackSelection);
                        trackSelectionArr[i4] = createAdaptiveTrackSelection;
                    }
                }
            }
            if (arrayList.size() > 1) {
                long[][] jArr = new long[arrayList.size()][];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection adaptiveTrackSelection = (com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection) arrayList.get(i5);
                    jArr[i5] = new long[adaptiveTrackSelection.length()];
                    for (int i6 = 0; i6 < adaptiveTrackSelection.length(); i6++) {
                        jArr[i5][i6] = adaptiveTrackSelection.getFormat((adaptiveTrackSelection.length() - i6) - 1).bitrate;
                    }
                }
                long[][][] f = com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.f(jArr);
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    ((com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection) arrayList.get(i7)).experimentalSetBandwidthAllocationCheckpoints(f[i7]);
                }
            }
            return trackSelectionArr;
        }
    }

    public AdaptiveTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.BandwidthProvider bandwidthProvider, long j, long j2, long j3, float f, com.google.android.exoplayer2.util.Clock clock) {
        super(trackGroup, iArr);
        this.d = bandwidthProvider;
        this.e = j * 1000;
        this.f = j2 * 1000;
        this.g = j3 * 1000;
        this.h = f;
        this.i = clock;
        this.j = 1.0f;
        this.l = 0;
        this.m = -9223372036854775807L;
    }

    public /* synthetic */ AdaptiveTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.BandwidthProvider bandwidthProvider, long j, long j2, long j3, float f, com.google.android.exoplayer2.util.Clock clock, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.AnonymousClass1 anonymousClass1) {
        this(trackGroup, iArr, bandwidthProvider, j, j2, j3, f, clock);
    }

    public AdaptiveTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, bandwidthMeter, 0L, 10000L, 25000L, 25000L, 0.7f, 0.75f, com.google.android.exoplayer2.util.Clock.DEFAULT);
    }

    public AdaptiveTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, long j, long j2, long j3, long j4, float f, float f2, com.google.android.exoplayer2.util.Clock clock) {
        this(trackGroup, iArr, new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DefaultBandwidthProvider(bandwidthMeter, f, j), j2, j3, j4, f2, clock);
    }

    public static int d(double[][] dArr) {
        int i = 0;
        for (double[] dArr2 : dArr) {
            i += dArr2.length;
        }
        return i;
    }

    public static long[][][] f(long[][] jArr) {
        int i;
        double[][] g = g(jArr);
        double[][] h = h(g);
        int d = d(h) + 3;
        long[][][] jArr2 = (long[][][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Long.TYPE, g.length, d, 2);
        int[] iArr = new int[g.length];
        j(jArr2, 1, jArr, iArr);
        int i2 = 2;
        while (true) {
            i = d - 1;
            if (i2 >= i) {
                break;
            }
            double d2 = Double.MAX_VALUE;
            int i3 = 0;
            for (int i4 = 0; i4 < g.length; i4++) {
                int i5 = iArr[i4];
                if (i5 + 1 != g[i4].length) {
                    double d3 = h[i4][i5];
                    if (d3 < d2) {
                        i3 = i4;
                        d2 = d3;
                    }
                }
            }
            iArr[i3] = iArr[i3] + 1;
            j(jArr2, i2, jArr, iArr);
            i2++;
        }
        for (long[][] jArr3 : jArr2) {
            long[] jArr4 = jArr3[i];
            long[] jArr5 = jArr3[d - 2];
            jArr4[0] = jArr5[0] * 2;
            jArr4[1] = jArr5[1] * 2;
        }
        return jArr2;
    }

    public static double[][] g(long[][] jArr) {
        double[][] dArr = new double[jArr.length][];
        for (int i = 0; i < jArr.length; i++) {
            dArr[i] = new double[jArr[i].length];
            int i2 = 0;
            while (true) {
                long[] jArr2 = jArr[i];
                if (i2 < jArr2.length) {
                    double[] dArr2 = dArr[i];
                    long j = jArr2[i2];
                    dArr2[i2] = j == -1 ? 0.0d : java.lang.Math.log(j);
                    i2++;
                }
            }
        }
        return dArr;
    }

    public static double[][] h(double[][] dArr) {
        double[][] dArr2 = new double[dArr.length][];
        for (int i = 0; i < dArr.length; i++) {
            double[] dArr3 = new double[dArr[i].length - 1];
            dArr2[i] = dArr3;
            if (dArr3.length != 0) {
                double[] dArr4 = dArr[i];
                double d = dArr4[dArr4.length - 1] - dArr4[0];
                int i2 = 0;
                while (true) {
                    double[] dArr5 = dArr[i];
                    if (i2 < dArr5.length - 1) {
                        int i3 = i2 + 1;
                        dArr2[i][i2] = d == 0.0d ? 1.0d : (((dArr5[i2] + dArr5[i3]) * 0.5d) - dArr5[0]) / d;
                        i2 = i3;
                    }
                }
            }
        }
        return dArr2;
    }

    public static void j(long[][][] jArr, int i, long[][] jArr2, int[] iArr) {
        long j = 0;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            long[] jArr3 = jArr[i2][i];
            long j2 = jArr2[i2][iArr[i2]];
            jArr3[1] = j2;
            j += j2;
        }
        for (long[][] jArr4 : jArr) {
            jArr4[i][0] = j;
        }
    }

    public boolean canSelectFormat(com.google.android.exoplayer2.Format format, int i, float f, long j) {
        return ((long) java.lang.Math.round(((float) i) * f)) <= j;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    @androidx.annotation.CallSuper
    public void disable() {
        this.n = null;
    }

    public final int e(long j) {
        long a = this.d.a();
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !isBlacklisted(i2, j)) {
                com.google.android.exoplayer2.Format format = getFormat(i2);
                if (canSelectFormat(format, format.bitrate, this.j, a)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    @androidx.annotation.CallSuper
    public void enable() {
        this.m = -9223372036854775807L;
        this.n = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        int i;
        int i2;
        long elapsedRealtime = this.i.elapsedRealtime();
        if (!shouldEvaluateQueueSize(elapsedRealtime, list)) {
            return list.size();
        }
        this.m = elapsedRealtime;
        this.n = list.isEmpty() ? null : (com.google.android.exoplayer2.source.chunk.MediaChunk) com.google.common.collect.Iterables.getLast(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = com.google.android.exoplayer2.util.Util.getPlayoutDurationForMediaDuration(list.get(size - 1).startTimeUs - j, this.j);
        long minDurationToRetainAfterDiscardUs = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs) {
            return size;
        }
        com.google.android.exoplayer2.Format format = getFormat(e(elapsedRealtime));
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.exoplayer2.source.chunk.MediaChunk mediaChunk = list.get(i3);
            com.google.android.exoplayer2.Format format2 = mediaChunk.trackFormat;
            if (com.google.android.exoplayer2.util.Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j, this.j) >= minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i = format2.height) != -1 && i < 720 && (i2 = format2.width) != -1 && i2 < 1280 && i < format.height) {
                return i3;
            }
        }
        return size;
    }

    public void experimentalSetBandwidthAllocationCheckpoints(long[][] jArr) {
        ((com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DefaultBandwidthProvider) this.d).b(jArr);
    }

    public long getMinDurationToRetainAfterDiscardUs() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.k;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    @androidx.annotation.Nullable
    public java.lang.Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.l;
    }

    public final long i(long j) {
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.e ? 1 : (j == this.e ? 0 : -1)) <= 0 ? (long) (j * this.h) : this.e;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float f) {
        this.j = f;
    }

    public boolean shouldEvaluateQueueSize(long j, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        long j2 = this.m;
        return j2 == -9223372036854775807L || j - j2 >= 1000 || !(list.isEmpty() || ((com.google.android.exoplayer2.source.chunk.MediaChunk) com.google.common.collect.Iterables.getLast(list)).equals(this.n));
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = this.i.elapsedRealtime();
        int i = this.l;
        if (i == 0) {
            this.l = 1;
            this.k = e(elapsedRealtime);
            return;
        }
        int i2 = this.k;
        int indexOf = list.isEmpty() ? -1 : indexOf(((com.google.android.exoplayer2.source.chunk.MediaChunk) com.google.common.collect.Iterables.getLast(list)).trackFormat);
        if (indexOf != -1) {
            i = ((com.google.android.exoplayer2.source.chunk.MediaChunk) com.google.common.collect.Iterables.getLast(list)).trackSelectionReason;
            i2 = indexOf;
        }
        int e = e(elapsedRealtime);
        if (!isBlacklisted(i2, elapsedRealtime)) {
            com.google.android.exoplayer2.Format format = getFormat(i2);
            com.google.android.exoplayer2.Format format2 = getFormat(e);
            if ((format2.bitrate > format.bitrate && j2 < i(j3)) || (format2.bitrate < format.bitrate && j2 >= this.f)) {
                e = i2;
            }
        }
        if (e != i2) {
            i = 3;
        }
        this.l = i;
        this.k = e;
    }
}
