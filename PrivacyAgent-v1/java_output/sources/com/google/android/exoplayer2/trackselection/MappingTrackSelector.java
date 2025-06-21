package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public abstract class MappingTrackSelector extends com.google.android.exoplayer2.trackselection.TrackSelector {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo c;

    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        public final int a;
        public final java.lang.String[] b;
        public final int[] c;
        public final com.google.android.exoplayer2.source.TrackGroupArray[] d;
        public final int[] e;
        public final int[][][] f;
        public final com.google.android.exoplayer2.source.TrackGroupArray g;

        @java.lang.Deprecated
        public final int length;

        public MappedTrackInfo(java.lang.String[] strArr, int[] iArr, com.google.android.exoplayer2.source.TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
            this.b = strArr;
            this.c = iArr;
            this.d = trackGroupArrayArr;
            this.f = iArr3;
            this.e = iArr2;
            this.g = trackGroupArray;
            int length = iArr.length;
            this.a = length;
            this.length = length;
        }

        public int getAdaptiveSupport(int i, int i2, boolean z) {
            int i3 = this.d[i].get(i2).length;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int trackSupport = getTrackSupport(i, i2, i5);
                if (trackSupport == 4 || (z && trackSupport == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return getAdaptiveSupport(i, i2, java.util.Arrays.copyOf(iArr, i4));
        }

        public int getAdaptiveSupport(int i, int i2, int[] iArr) {
            int i3 = 0;
            java.lang.String str = null;
            boolean z = false;
            int i4 = 0;
            int i5 = 16;
            while (i3 < iArr.length) {
                java.lang.String str2 = this.d[i].get(i2).getFormat(iArr[i3]).sampleMimeType;
                int i6 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !com.google.android.exoplayer2.util.Util.areEqual(str, str2);
                }
                i5 = java.lang.Math.min(i5, defpackage.ub2.c(this.f[i][i2][i3]));
                i3++;
                i4 = i6;
            }
            return z ? java.lang.Math.min(i5, this.e[i]) : i5;
        }

        public int getRendererCount() {
            return this.a;
        }

        public java.lang.String getRendererName(int i) {
            return this.b[i];
        }

        public int getRendererSupport(int i) {
            int i2 = 0;
            for (int[] iArr : this.f[i]) {
                for (int i3 : iArr) {
                    int d = defpackage.ub2.d(i3);
                    int i4 = 1;
                    if (d != 0 && d != 1 && d != 2) {
                        if (d != 3) {
                            if (d == 4) {
                                return 3;
                            }
                            throw new java.lang.IllegalStateException();
                        }
                        i4 = 2;
                    }
                    i2 = java.lang.Math.max(i2, i4);
                }
            }
            return i2;
        }

        public int getRendererType(int i) {
            return this.c[i];
        }

        @java.lang.Deprecated
        public int getTrackFormatSupport(int i, int i2, int i3) {
            return getTrackSupport(i, i2, i3);
        }

        public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups(int i) {
            return this.d[i];
        }

        public int getTrackSupport(int i, int i2, int i3) {
            return defpackage.ub2.d(this.f[i][i2][i3]);
        }

        @java.lang.Deprecated
        public int getTrackTypeRendererSupport(int i) {
            return getTypeSupport(i);
        }

        public int getTypeSupport(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.a; i3++) {
                if (this.c[i3] == i) {
                    i2 = java.lang.Math.max(i2, getRendererSupport(i3));
                }
            }
            return i2;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.TrackGroupArray getUnassociatedTrackGroups() {
            return getUnmappedTrackGroups();
        }

        public com.google.android.exoplayer2.source.TrackGroupArray getUnmappedTrackGroups() {
            return this.g;
        }
    }

    public static int a(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < rendererCapabilitiesArr.length; i2++) {
            com.google.android.exoplayer2.RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                i3 = java.lang.Math.max(i3, defpackage.ub2.d(rendererCapabilities.supportsFormat(trackGroup.getFormat(i4))));
            }
            boolean z3 = iArr[i2] == 0;
            if (i3 > i || (i3 == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = i3;
            }
        }
        return length;
    }

    public static int[] b(com.google.android.exoplayer2.RendererCapabilities rendererCapabilities, com.google.android.exoplayer2.source.TrackGroup trackGroup) throws com.google.android.exoplayer2.ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i = 0; i < trackGroup.length; i++) {
            iArr[i] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i));
        }
        return iArr;
    }

    public static int[] c(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr) throws com.google.android.exoplayer2.ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = rendererCapabilitiesArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(@androidx.annotation.Nullable java.lang.Object obj) {
        this.c = (com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo) obj;
    }

    public abstract android.util.Pair<com.google.android.exoplayer2.RendererConfiguration[], com.google.android.exoplayer2.trackselection.TrackSelection[]> selectTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws com.google.android.exoplayer2.ExoPlaybackException;

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final com.google.android.exoplayer2.trackselection.TrackSelectorResult selectTracks(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.Timeline timeline) throws com.google.android.exoplayer2.ExoPlaybackException {
        int[] iArr = new int[rendererCapabilitiesArr.length + 1];
        int length = rendererCapabilitiesArr.length + 1;
        com.google.android.exoplayer2.source.TrackGroup[][] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[length][];
        int[][][] iArr2 = new int[rendererCapabilitiesArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = trackGroupArray.length;
            trackGroupArr[i] = new com.google.android.exoplayer2.source.TrackGroup[i2];
            iArr2[i] = new int[i2][];
        }
        int[] c = c(rendererCapabilitiesArr);
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroupArray.get(i3);
            int a = a(rendererCapabilitiesArr, trackGroup, iArr, com.google.android.exoplayer2.util.MimeTypes.getTrackType(trackGroup.getFormat(0).sampleMimeType) == 4);
            int[] b = a == rendererCapabilitiesArr.length ? new int[trackGroup.length] : b(rendererCapabilitiesArr[a], trackGroup);
            int i4 = iArr[a];
            trackGroupArr[a][i4] = trackGroup;
            iArr2[a][i4] = b;
            iArr[a] = i4 + 1;
        }
        com.google.android.exoplayer2.source.TrackGroupArray[] trackGroupArrayArr = new com.google.android.exoplayer2.source.TrackGroupArray[rendererCapabilitiesArr.length];
        java.lang.String[] strArr = new java.lang.String[rendererCapabilitiesArr.length];
        int[] iArr3 = new int[rendererCapabilitiesArr.length];
        for (int i5 = 0; i5 < rendererCapabilitiesArr.length; i5++) {
            int i6 = iArr[i5];
            trackGroupArrayArr[i5] = new com.google.android.exoplayer2.source.TrackGroupArray((com.google.android.exoplayer2.source.TrackGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(trackGroupArr[i5], i6));
            iArr2[i5] = (int[][]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(iArr2[i5], i6);
            strArr[i5] = rendererCapabilitiesArr[i5].getName();
            iArr3[i5] = rendererCapabilitiesArr[i5].getTrackType();
        }
        com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo = new com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo(strArr, iArr3, trackGroupArrayArr, c, iArr2, new com.google.android.exoplayer2.source.TrackGroupArray((com.google.android.exoplayer2.source.TrackGroup[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr.length], iArr[rendererCapabilitiesArr.length])));
        android.util.Pair<com.google.android.exoplayer2.RendererConfiguration[], com.google.android.exoplayer2.trackselection.TrackSelection[]> selectTracks = selectTracks(mappedTrackInfo, iArr2, c);
        return new com.google.android.exoplayer2.trackselection.TrackSelectorResult((com.google.android.exoplayer2.RendererConfiguration[]) selectTracks.first, (com.google.android.exoplayer2.trackselection.TrackSelection[]) selectTracks.second, mappedTrackInfo);
    }
}
