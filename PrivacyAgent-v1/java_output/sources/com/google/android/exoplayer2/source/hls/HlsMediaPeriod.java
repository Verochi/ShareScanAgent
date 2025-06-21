package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class HlsMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener {
    public final com.google.android.exoplayer2.upstream.Allocator A;
    public final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory D;
    public final boolean E;
    public final int F;
    public final boolean G;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaPeriod.Callback H;
    public int I;
    public com.google.android.exoplayer2.source.TrackGroupArray J;
    public com.google.android.exoplayer2.source.SequenceableLoader N;
    public final com.google.android.exoplayer2.source.hls.HlsExtractorFactory n;
    public final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker t;
    public final com.google.android.exoplayer2.source.hls.HlsDataSourceFactory u;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.TransferListener v;
    public final com.google.android.exoplayer2.drm.DrmSessionManager w;
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher x;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy y;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher z;
    public final java.util.IdentityHashMap<com.google.android.exoplayer2.source.SampleStream, java.lang.Integer> B = new java.util.IdentityHashMap<>();
    public final com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider C = new com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider();
    public com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] K = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[0];
    public com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] L = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[0];
    public int[][] M = new int[0][];

    public HlsMediaPeriod(com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker hlsPlaylistTracker, com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher2, com.google.android.exoplayer2.upstream.Allocator allocator, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z, int i, boolean z2) {
        this.n = hlsExtractorFactory;
        this.t = hlsPlaylistTracker;
        this.u = hlsDataSourceFactory;
        this.v = transferListener;
        this.w = drmSessionManager;
        this.x = eventDispatcher;
        this.y = loadErrorHandlingPolicy;
        this.z = eventDispatcher2;
        this.A = allocator;
        this.D = compositeSequenceableLoaderFactory;
        this.E = z;
        this.F = i;
        this.G = z2;
        this.N = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new com.google.android.exoplayer2.source.SequenceableLoader[0]);
    }

    public static com.google.android.exoplayer2.Format e(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format2, boolean z) {
        java.lang.String codecsOfType;
        com.google.android.exoplayer2.metadata.Metadata metadata;
        int i;
        java.lang.String str;
        java.lang.String str2;
        int i2;
        int i3;
        if (format2 != null) {
            codecsOfType = format2.codecs;
            metadata = format2.metadata;
            i2 = format2.channelCount;
            i = format2.selectionFlags;
            i3 = format2.roleFlags;
            str = format2.language;
            str2 = format2.label;
        } else {
            codecsOfType = com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, 1);
            metadata = format.metadata;
            if (z) {
                i2 = format.channelCount;
                i = format.selectionFlags;
                i3 = format.roleFlags;
                str = format.language;
                str2 = format.label;
            } else {
                i = 0;
                str = null;
                str2 = null;
                i2 = -1;
                i3 = 0;
            }
        }
        return new com.google.android.exoplayer2.Format.Builder().setId(format.id).setLabel(str2).setContainerMimeType(format.containerMimeType).setSampleMimeType(com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(codecsOfType)).setCodecs(codecsOfType).setMetadata(metadata).setAverageBitrate(z ? format.averageBitrate : -1).setPeakBitrate(z ? format.peakBitrate : -1).setChannelCount(i2).setSelectionFlags(i).setRoleFlags(i3).setLanguage(str).build();
    }

    public static java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> f(java.util.List<com.google.android.exoplayer2.drm.DrmInitData> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.HashMap hashMap = new java.util.HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            com.google.android.exoplayer2.drm.DrmInitData drmInitData = list.get(i);
            java.lang.String str = drmInitData.schemeType;
            i++;
            int i2 = i;
            while (i2 < arrayList.size()) {
                com.google.android.exoplayer2.drm.DrmInitData drmInitData2 = (com.google.android.exoplayer2.drm.DrmInitData) arrayList.get(i2);
                if (android.text.TextUtils.equals(drmInitData2.schemeType, str)) {
                    drmInitData = drmInitData.merge(drmInitData2);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    public static com.google.android.exoplayer2.Format g(com.google.android.exoplayer2.Format format) {
        java.lang.String codecsOfType = com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, 2);
        return new com.google.android.exoplayer2.Format.Builder().setId(format.id).setLabel(format.label).setContainerMimeType(format.containerMimeType).setSampleMimeType(com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(codecsOfType)).setCodecs(codecsOfType).setMetadata(format.metadata).setAverageBitrate(format.averageBitrate).setPeakBitrate(format.peakBitrate).setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).build();
    }

    public final void a(long j, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list, java.util.List<com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper> list2, java.util.List<int[]> list3, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> map) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.ArrayList arrayList2 = new java.util.ArrayList(list.size());
        java.util.ArrayList arrayList3 = new java.util.ArrayList(list.size());
        java.util.HashSet hashSet = new java.util.HashSet();
        for (int i = 0; i < list.size(); i++) {
            java.lang.String str = list.get(i).name;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (com.google.android.exoplayer2.util.Util.areEqual(str, list.get(i2).name)) {
                        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition rendition = list.get(i2);
                        arrayList3.add(java.lang.Integer.valueOf(i2));
                        arrayList.add(rendition.url);
                        arrayList2.add(rendition.format);
                        z &= rendition.format.codecs != null;
                    }
                }
                com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper d = d(1, (android.net.Uri[]) arrayList.toArray((android.net.Uri[]) com.google.android.exoplayer2.util.Util.castNonNullTypeArray(new android.net.Uri[0])), (com.google.android.exoplayer2.Format[]) arrayList2.toArray(new com.google.android.exoplayer2.Format[0]), null, java.util.Collections.emptyList(), map, j);
                list3.add(com.google.common.primitives.Ints.toArray(arrayList3));
                list2.add(d);
                if (this.E && z) {
                    d.H(new com.google.android.exoplayer2.source.TrackGroup[]{new com.google.android.exoplayer2.source.TrackGroup((com.google.android.exoplayer2.Format[]) arrayList2.toArray(new com.google.android.exoplayer2.Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist, long j, java.util.List<com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper> list, java.util.List<int[]> list2, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> map) {
        boolean z;
        boolean z2;
        int i;
        int size = hlsMasterPlaylist.variants.size();
        int[] iArr = new int[size];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < hlsMasterPlaylist.variants.size(); i4++) {
            com.google.android.exoplayer2.Format format = hlsMasterPlaylist.variants.get(i4).format;
            if (format.height > 0 || com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, 2) != null) {
                iArr[i4] = 2;
                i2++;
            } else if (com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, 1) != null) {
                iArr[i4] = 1;
                i3++;
            } else {
                iArr[i4] = -1;
            }
        }
        if (i2 > 0) {
            size = i2;
            z = true;
        } else {
            if (i3 < size) {
                size -= i3;
                z = false;
                z2 = true;
                android.net.Uri[] uriArr = new android.net.Uri[size];
                com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[size];
                int[] iArr2 = new int[size];
                int i5 = 0;
                for (i = 0; i < hlsMasterPlaylist.variants.size(); i++) {
                    if ((!z || iArr[i] == 2) && (!z2 || iArr[i] != 1)) {
                        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant variant = hlsMasterPlaylist.variants.get(i);
                        uriArr[i5] = variant.url;
                        formatArr[i5] = variant.format;
                        iArr2[i5] = i;
                        i5++;
                    }
                }
                java.lang.String str = formatArr[0].codecs;
                com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper d = d(0, uriArr, formatArr, hlsMasterPlaylist.muxedAudioFormat, hlsMasterPlaylist.muxedCaptionFormats, map, j);
                list.add(d);
                list2.add(iArr2);
                if (this.E || str == null) {
                }
                boolean z3 = com.google.android.exoplayer2.util.Util.getCodecsOfType(str, 2) != null;
                boolean z4 = com.google.android.exoplayer2.util.Util.getCodecsOfType(str, 1) != null;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (z3) {
                    com.google.android.exoplayer2.Format[] formatArr2 = new com.google.android.exoplayer2.Format[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        formatArr2[i6] = g(formatArr[i6]);
                    }
                    arrayList.add(new com.google.android.exoplayer2.source.TrackGroup(formatArr2));
                    if (z4 && (hlsMasterPlaylist.muxedAudioFormat != null || hlsMasterPlaylist.audios.isEmpty())) {
                        arrayList.add(new com.google.android.exoplayer2.source.TrackGroup(e(formatArr[0], hlsMasterPlaylist.muxedAudioFormat, false)));
                    }
                    java.util.List<com.google.android.exoplayer2.Format> list3 = hlsMasterPlaylist.muxedCaptionFormats;
                    if (list3 != null) {
                        for (int i7 = 0; i7 < list3.size(); i7++) {
                            arrayList.add(new com.google.android.exoplayer2.source.TrackGroup(list3.get(i7)));
                        }
                    }
                } else {
                    if (!z4) {
                        throw new java.lang.IllegalArgumentException(str.length() != 0 ? "Unexpected codecs attribute: ".concat(str) : new java.lang.String("Unexpected codecs attribute: "));
                    }
                    com.google.android.exoplayer2.Format[] formatArr3 = new com.google.android.exoplayer2.Format[size];
                    for (int i8 = 0; i8 < size; i8++) {
                        formatArr3[i8] = e(formatArr[i8], hlsMasterPlaylist.muxedAudioFormat, true);
                    }
                    arrayList.add(new com.google.android.exoplayer2.source.TrackGroup(formatArr3));
                }
                com.google.android.exoplayer2.source.TrackGroup trackGroup = new com.google.android.exoplayer2.source.TrackGroup(new com.google.android.exoplayer2.Format.Builder().setId("ID3").setSampleMimeType("application/id3").build());
                arrayList.add(trackGroup);
                d.H((com.google.android.exoplayer2.source.TrackGroup[]) arrayList.toArray(new com.google.android.exoplayer2.source.TrackGroup[0]), 0, arrayList.indexOf(trackGroup));
                return;
            }
            z = false;
        }
        z2 = false;
        android.net.Uri[] uriArr2 = new android.net.Uri[size];
        com.google.android.exoplayer2.Format[] formatArr4 = new com.google.android.exoplayer2.Format[size];
        int[] iArr22 = new int[size];
        int i52 = 0;
        while (i < hlsMasterPlaylist.variants.size()) {
        }
        java.lang.String str2 = formatArr4[0].codecs;
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper d2 = d(0, uriArr2, formatArr4, hlsMasterPlaylist.muxedAudioFormat, hlsMasterPlaylist.muxedCaptionFormats, map, j);
        list.add(d2);
        list2.add(iArr22);
        if (this.E) {
        }
    }

    public final void c(long j) {
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.t.getMasterPlaylist());
        java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> f = this.G ? f(hlsMasterPlaylist.sessionKeyDrmInitData) : java.util.Collections.emptyMap();
        boolean z = !hlsMasterPlaylist.variants.isEmpty();
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list = hlsMasterPlaylist.audios;
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list2 = hlsMasterPlaylist.subtitles;
        this.I = 0;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        if (z) {
            b(hlsMasterPlaylist, j, arrayList, arrayList2, f);
        }
        a(j, list, arrayList, arrayList2, f);
        int i = 0;
        while (i < list2.size()) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition rendition = list2.get(i);
            int i2 = i;
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper d = d(3, new android.net.Uri[]{rendition.url}, new com.google.android.exoplayer2.Format[]{rendition.format}, null, java.util.Collections.emptyList(), f, j);
            arrayList2.add(new int[]{i2});
            arrayList.add(d);
            d.H(new com.google.android.exoplayer2.source.TrackGroup[]{new com.google.android.exoplayer2.source.TrackGroup(rendition.format)}, 0, new int[0]);
            i = i2 + 1;
        }
        this.K = (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[]) arrayList.toArray(new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[0]);
        this.M = (int[][]) arrayList2.toArray(new int[0][]);
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.K;
        this.I = hlsSampleStreamWrapperArr.length;
        hlsSampleStreamWrapperArr[0].Q(true);
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.K) {
            hlsSampleStreamWrapper.g();
        }
        this.L = this.K;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.J != null) {
            return this.N.continueLoading(j);
        }
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.K) {
            hlsSampleStreamWrapper.g();
        }
        return false;
    }

    public final com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper d(int i, android.net.Uri[] uriArr, com.google.android.exoplayer2.Format[] formatArr, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> map, long j) {
        return new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper(i, this, new com.google.android.exoplayer2.source.hls.HlsChunkSource(this.n, this.t, uriArr, formatArr, this.u, this.v, this.C, list), map, this.A, j, format, this.w, this.x, this.y, this.z, this.F);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.L) {
            hlsSampleStreamWrapper.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.N.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.N.getNextLoadPositionUs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public java.util.List<com.google.android.exoplayer2.offline.StreamKey> getStreamKeys(java.util.List<com.google.android.exoplayer2.trackselection.TrackSelection> list) {
        int[] iArr;
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray;
        int i;
        com.google.android.exoplayer2.source.hls.HlsMediaPeriod hlsMediaPeriod = this;
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) com.google.android.exoplayer2.util.Assertions.checkNotNull(hlsMediaPeriod.t.getMasterPlaylist());
        boolean z = !hlsMasterPlaylist.variants.isEmpty();
        int length = hlsMediaPeriod.K.length - hlsMasterPlaylist.subtitles.size();
        int i2 = 0;
        if (z) {
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.K[0];
            iArr = hlsMediaPeriod.M[0];
            trackGroupArray = hlsSampleStreamWrapper.getTrackGroups();
            i = hlsSampleStreamWrapper.r();
        } else {
            iArr = new int[0];
            trackGroupArray = com.google.android.exoplayer2.source.TrackGroupArray.EMPTY;
            i = 0;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : list) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackSelection.getTrackGroup();
            int indexOf = trackGroupArray.indexOf(trackGroup);
            if (indexOf == -1) {
                ?? r15 = z;
                while (true) {
                    com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = hlsMediaPeriod.K;
                    if (r15 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    }
                    if (hlsSampleStreamWrapperArr[r15].getTrackGroups().indexOf(trackGroup) != -1) {
                        int i3 = r15 < length ? 1 : 2;
                        int[] iArr2 = hlsMediaPeriod.M[r15];
                        for (int i4 = 0; i4 < trackSelection.length(); i4++) {
                            arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(i3, iArr2[trackSelection.getIndexInTrackGroup(i4)]));
                        }
                    } else {
                        hlsMediaPeriod = this;
                        r15++;
                    }
                }
            } else if (indexOf == i) {
                for (int i5 = 0; i5 < trackSelection.length(); i5++) {
                    arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(i2, iArr[trackSelection.getIndexInTrackGroup(i5)]));
                }
                z3 = true;
            } else {
                z2 = true;
            }
            hlsMediaPeriod = this;
            i2 = 0;
        }
        if (z2 && !z3) {
            int i6 = iArr[0];
            int i7 = hlsMasterPlaylist.variants.get(i6).format.bitrate;
            for (int i8 = 1; i8 < iArr.length; i8++) {
                int i9 = hlsMasterPlaylist.variants.get(iArr[i8]).format.bitrate;
                if (i9 < i7) {
                    i6 = iArr[i8];
                    i7 = i9;
                }
            }
            arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(0, i6));
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return (com.google.android.exoplayer2.source.TrackGroupArray) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.J);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.N.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.K) {
            hlsSampleStreamWrapper.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.H.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistChanged() {
        this.H.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public boolean onPlaylistError(android.net.Uri uri, long j) {
        boolean z = true;
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.K) {
            z &= hlsSampleStreamWrapper.F(uri, j);
        }
        this.H.onContinueLoadingRequested(this);
        return z;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPlaylistRefreshRequired(android.net.Uri uri) {
        this.t.refreshPlaylist(uri);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPrepared() {
        int i = this.I - 1;
        this.I = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.K) {
            i2 += hlsSampleStreamWrapper.getTrackGroups().length;
        }
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[i2];
        int i3 = 0;
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper2 : this.K) {
            int i4 = hlsSampleStreamWrapper2.getTrackGroups().length;
            int i5 = 0;
            while (i5 < i4) {
                trackGroupArr[i3] = hlsSampleStreamWrapper2.getTrackGroups().get(i5);
                i5++;
                i3++;
            }
        }
        this.J = new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
        this.H.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
        this.H = callback;
        this.t.addListener(this);
        c(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.N.reevaluateBuffer(j);
    }

    public void release() {
        this.t.removeListener(this);
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper : this.K) {
            hlsSampleStreamWrapper.J();
        }
        this.H = null;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.L;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean M = hlsSampleStreamWrapperArr[0].M(j, false);
            int i = 1;
            while (true) {
                com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.L;
                if (i >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i].M(j, M);
                i++;
            }
            if (M) {
                this.C.reset();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[trackSelectionArr.length];
        int[] iArr2 = new int[trackSelectionArr.length];
        for (int i = 0; i < trackSelectionArr.length; i++) {
            com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr2[i];
            iArr[i] = sampleStream == null ? -1 : this.B.get(sampleStream).intValue();
            iArr2[i] = -1;
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArr[i];
            if (trackSelection != null) {
                com.google.android.exoplayer2.source.TrackGroup trackGroup = trackSelection.getTrackGroup();
                int i2 = 0;
                while (true) {
                    com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.K;
                    if (i2 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    }
                    if (hlsSampleStreamWrapperArr[i2].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.B.clear();
        int length = trackSelectionArr.length;
        com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr3 = new com.google.android.exoplayer2.source.SampleStream[length];
        com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr4 = new com.google.android.exoplayer2.source.SampleStream[trackSelectionArr.length];
        com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr2 = new com.google.android.exoplayer2.trackselection.TrackSelection[trackSelectionArr.length];
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[this.K.length];
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (i4 < this.K.length) {
            for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
                com.google.android.exoplayer2.trackselection.TrackSelection trackSelection2 = null;
                sampleStreamArr4[i5] = iArr[i5] == i4 ? sampleStreamArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    trackSelection2 = trackSelectionArr[i5];
                }
                trackSelectionArr2[i5] = trackSelection2;
            }
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper = this.K[i4];
            int i6 = i3;
            int i7 = length;
            int i8 = i4;
            com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean N = hlsSampleStreamWrapper.N(trackSelectionArr2, zArr, sampleStreamArr4, zArr2, j, z);
            int i9 = 0;
            boolean z2 = false;
            while (true) {
                if (i9 >= trackSelectionArr.length) {
                    break;
                }
                com.google.android.exoplayer2.source.SampleStream sampleStream2 = sampleStreamArr4[i9];
                if (iArr2[i9] == i8) {
                    com.google.android.exoplayer2.util.Assertions.checkNotNull(sampleStream2);
                    sampleStreamArr3[i9] = sampleStream2;
                    this.B.put(sampleStream2, java.lang.Integer.valueOf(i8));
                    z2 = true;
                } else if (iArr[i9] == i8) {
                    com.google.android.exoplayer2.util.Assertions.checkState(sampleStream2 == null);
                }
                i9++;
            }
            if (z2) {
                hlsSampleStreamWrapperArr3[i6] = hlsSampleStreamWrapper;
                i3 = i6 + 1;
                if (i6 == 0) {
                    hlsSampleStreamWrapper.Q(true);
                    if (!N) {
                        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = this.L;
                        if (hlsSampleStreamWrapperArr4.length != 0) {
                            if (hlsSampleStreamWrapper == hlsSampleStreamWrapperArr4[0]) {
                            }
                            this.C.reset();
                            z = true;
                        }
                    }
                    this.C.reset();
                    z = true;
                } else {
                    hlsSampleStreamWrapper.Q(false);
                }
            } else {
                i3 = i6;
            }
            i4 = i8 + 1;
            sampleStreamArr2 = sampleStreamArr;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr3;
            length = i7;
            trackSelectionArr2 = trackSelectionArr3;
        }
        java.lang.System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(hlsSampleStreamWrapperArr2, i3);
        this.L = hlsSampleStreamWrapperArr5;
        this.N = this.D.createCompositeSequenceableLoader(hlsSampleStreamWrapperArr5);
        return j;
    }
}
