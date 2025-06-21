package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
class HlsChunkSource {
    public final com.google.android.exoplayer2.source.hls.HlsExtractorFactory a;
    public final com.google.android.exoplayer2.upstream.DataSource b;
    public final com.google.android.exoplayer2.upstream.DataSource c;
    public final com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider d;
    public final android.net.Uri[] e;
    public final com.google.android.exoplayer2.Format[] f;
    public final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker g;
    public final com.google.android.exoplayer2.source.TrackGroup h;

    @androidx.annotation.Nullable
    public final java.util.List<com.google.android.exoplayer2.Format> i;
    public boolean k;

    @androidx.annotation.Nullable
    public java.io.IOException m;

    @androidx.annotation.Nullable
    public android.net.Uri n;
    public boolean o;
    public com.google.android.exoplayer2.trackselection.TrackSelection p;
    public boolean r;
    public final com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache j = new com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache(4);
    public byte[] l = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    public long q = -9223372036854775807L;

    public static final class EncryptionKeyChunk extends com.google.android.exoplayer2.source.chunk.DataChunk {
        public byte[] c;

        public EncryptionKeyChunk(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, int i, @androidx.annotation.Nullable java.lang.Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
        }

        @androidx.annotation.Nullable
        public byte[] b() {
            return this.c;
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        public void consume(byte[] bArr, int i) {
            this.c = java.util.Arrays.copyOf(bArr, i);
        }
    }

    public static final class HlsChunkHolder {

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.chunk.Chunk chunk;
        public boolean endOfStream;

        @androidx.annotation.Nullable
        public android.net.Uri playlistUrl;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlistUrl = null;
        }
    }

    public static final class HlsMediaPlaylistSegmentIterator extends com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator {
        public final com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist d;
        public final long e;

        public HlsMediaPlaylistSegmentIterator(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
            super(i, hlsMediaPlaylist.segments.size() - 1);
            this.d = hlsMediaPlaylist;
            this.e = j;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = this.d.segments.get((int) getCurrentIndex());
            return this.e + segment.relativeStartTimeUs + segment.durationUs;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.e + this.d.segments.get((int) getCurrentIndex()).relativeStartTimeUs;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public com.google.android.exoplayer2.upstream.DataSpec getDataSpec() {
            checkInBounds();
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = this.d.segments.get((int) getCurrentIndex());
            return new com.google.android.exoplayer2.upstream.DataSpec(com.google.android.exoplayer2.util.UriUtil.resolveToUri(this.d.baseUri, segment.url), segment.byteRangeOffset, segment.byteRangeLength);
        }
    }

    public static final class InitializationTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {
        public int d;

        public InitializationTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.d = indexOf(trackGroup.getFormat(iArr[0]));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.d;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        @androidx.annotation.Nullable
        public java.lang.Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (isBlacklisted(this.d, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!isBlacklisted(i, elapsedRealtime)) {
                        this.d = i;
                        return;
                    }
                }
                throw new java.lang.IllegalStateException();
            }
        }
    }

    public HlsChunkSource(com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker hlsPlaylistTracker, android.net.Uri[] uriArr, com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider timestampAdjusterProvider, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list) {
        this.a = hlsExtractorFactory;
        this.g = hlsPlaylistTracker;
        this.e = uriArr;
        this.f = formatArr;
        this.d = timestampAdjusterProvider;
        this.i = list;
        com.google.android.exoplayer2.upstream.DataSource createDataSource = hlsDataSourceFactory.createDataSource(1);
        this.b = createDataSource;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        this.c = hlsDataSourceFactory.createDataSource(3);
        this.h = new com.google.android.exoplayer2.source.TrackGroup(formatArr);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((formatArr[i].roleFlags & 16384) == 0) {
                arrayList.add(java.lang.Integer.valueOf(i));
            }
        }
        this.p = new com.google.android.exoplayer2.source.hls.HlsChunkSource.InitializationTrackSelection(this.h, com.google.common.primitives.Ints.toArray(arrayList));
    }

    @androidx.annotation.Nullable
    public static android.net.Uri c(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, @androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment) {
        java.lang.String str;
        if (segment == null || (str = segment.fullSegmentEncryptionKeyUri) == null) {
            return null;
        }
        return com.google.android.exoplayer2.util.UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, str);
    }

    public com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] a(@androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk, long j) {
        int indexOf = hlsMediaChunk == null ? -1 : this.h.indexOf(hlsMediaChunk.trackFormat);
        int length = this.p.length();
        com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr = new com.google.android.exoplayer2.source.chunk.MediaChunkIterator[length];
        for (int i = 0; i < length; i++) {
            int indexInTrackGroup = this.p.getIndexInTrackGroup(i);
            android.net.Uri uri = this.e[indexInTrackGroup];
            if (this.g.isSnapshotValid(uri)) {
                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist playlistSnapshot = this.g.getPlaylistSnapshot(uri, false);
                com.google.android.exoplayer2.util.Assertions.checkNotNull(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.g.getInitialStartTimeUs();
                long b = b(hlsMediaChunk, indexInTrackGroup != indexOf, playlistSnapshot, initialStartTimeUs, j);
                long j2 = playlistSnapshot.mediaSequence;
                if (b < j2) {
                    mediaChunkIteratorArr[i] = com.google.android.exoplayer2.source.chunk.MediaChunkIterator.EMPTY;
                } else {
                    mediaChunkIteratorArr[i] = new com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsMediaPlaylistSegmentIterator(playlistSnapshot, initialStartTimeUs, (int) (b - j2));
                }
            } else {
                mediaChunkIteratorArr[i] = com.google.android.exoplayer2.source.chunk.MediaChunkIterator.EMPTY;
            }
        }
        return mediaChunkIteratorArr;
    }

    public final long b(@androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk, boolean z, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, long j, long j2) {
        long binarySearchFloor;
        long j3;
        if (hlsMediaChunk != null && !z) {
            return hlsMediaChunk.isLoadCompleted() ? hlsMediaChunk.getNextChunkIndex() : hlsMediaChunk.chunkIndex;
        }
        long j4 = hlsMediaPlaylist.durationUs + j;
        if (hlsMediaChunk != null && !this.o) {
            j2 = hlsMediaChunk.startTimeUs;
        }
        if (hlsMediaPlaylist.hasEndTag || j2 < j4) {
            binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor((java.util.List<? extends java.lang.Comparable<? super java.lang.Long>>) hlsMediaPlaylist.segments, java.lang.Long.valueOf(j2 - j), true, !this.g.isLive() || hlsMediaChunk == null);
            j3 = hlsMediaPlaylist.mediaSequence;
        } else {
            binarySearchFloor = hlsMediaPlaylist.mediaSequence;
            j3 = hlsMediaPlaylist.segments.size();
        }
        return binarySearchFloor + j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(long j, long j2, java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> list, boolean z, com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder hlsChunkHolder) {
        long j3;
        long j4;
        android.net.Uri uri;
        int i;
        android.net.Uri uri2;
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist;
        int i2;
        com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk = list.isEmpty() ? null : list.get(list.size() - 1);
        int indexOf = hlsMediaChunk == null ? -1 : this.h.indexOf(hlsMediaChunk.trackFormat);
        long j5 = j2 - j;
        long n = n(j);
        if (hlsMediaChunk != null && !this.o) {
            long durationUs = hlsMediaChunk.getDurationUs();
            j5 = java.lang.Math.max(0L, j5 - durationUs);
            if (n != -9223372036854775807L) {
                j3 = j5;
                j4 = java.lang.Math.max(0L, n - durationUs);
                this.p.updateSelectedTrack(j, j3, j4, list, a(hlsMediaChunk, j2));
                int selectedIndexInTrackGroup = this.p.getSelectedIndexInTrackGroup();
                boolean z2 = indexOf == selectedIndexInTrackGroup;
                uri = this.e[selectedIndexInTrackGroup];
                if (this.g.isSnapshotValid(uri)) {
                    hlsChunkHolder.playlistUrl = uri;
                    this.r &= uri.equals(this.n);
                    this.n = uri;
                    return;
                }
                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist playlistSnapshot = this.g.getPlaylistSnapshot(uri, true);
                com.google.android.exoplayer2.util.Assertions.checkNotNull(playlistSnapshot);
                this.o = playlistSnapshot.hasIndependentSegments;
                r(playlistSnapshot);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.g.getInitialStartTimeUs();
                com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
                int i3 = indexOf;
                long b = b(hlsMediaChunk, z2, playlistSnapshot, initialStartTimeUs, j2);
                if (b >= playlistSnapshot.mediaSequence || hlsMediaChunk2 == null || !z2) {
                    i = selectedIndexInTrackGroup;
                    uri2 = uri;
                    hlsMediaPlaylist = playlistSnapshot;
                } else {
                    android.net.Uri uri3 = this.e[i3];
                    com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist playlistSnapshot2 = this.g.getPlaylistSnapshot(uri3, true);
                    com.google.android.exoplayer2.util.Assertions.checkNotNull(playlistSnapshot2);
                    initialStartTimeUs = playlistSnapshot2.startTimeUs - this.g.getInitialStartTimeUs();
                    uri2 = uri3;
                    hlsMediaPlaylist = playlistSnapshot2;
                    b = hlsMediaChunk2.getNextChunkIndex();
                    i = i3;
                }
                long j6 = hlsMediaPlaylist.mediaSequence;
                if (b < j6) {
                    this.m = new com.google.android.exoplayer2.source.BehindLiveWindowException();
                    return;
                }
                int i4 = (int) (b - j6);
                int size = hlsMediaPlaylist.segments.size();
                if (i4 < size) {
                    i2 = i4;
                } else if (!hlsMediaPlaylist.hasEndTag) {
                    hlsChunkHolder.playlistUrl = uri2;
                    this.r &= uri2.equals(this.n);
                    this.n = uri2;
                    return;
                } else {
                    if (z || size == 0) {
                        hlsChunkHolder.endOfStream = true;
                        return;
                    }
                    i2 = size - 1;
                }
                this.r = false;
                this.n = null;
                com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i2);
                android.net.Uri c = c(hlsMediaPlaylist, segment.initializationSegment);
                com.google.android.exoplayer2.source.chunk.Chunk h = h(c, i);
                hlsChunkHolder.chunk = h;
                if (h != null) {
                    return;
                }
                android.net.Uri c2 = c(hlsMediaPlaylist, segment);
                com.google.android.exoplayer2.source.chunk.Chunk h2 = h(c2, i);
                hlsChunkHolder.chunk = h2;
                if (h2 != null) {
                    return;
                }
                hlsChunkHolder.chunk = com.google.android.exoplayer2.source.hls.HlsMediaChunk.b(this.a, this.b, this.f[i], initialStartTimeUs, hlsMediaPlaylist, i2, uri2, this.i, this.p.getSelectionReason(), this.p.getSelectionData(), this.k, this.d, hlsMediaChunk2, this.j.a(c2), this.j.a(c));
                return;
            }
        }
        j3 = j5;
        j4 = n;
        this.p.updateSelectedTrack(j, j3, j4, list, a(hlsMediaChunk, j2));
        int selectedIndexInTrackGroup2 = this.p.getSelectedIndexInTrackGroup();
        if (indexOf == selectedIndexInTrackGroup2) {
        }
        uri = this.e[selectedIndexInTrackGroup2];
        if (this.g.isSnapshotValid(uri)) {
        }
    }

    public int e(long j, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        return (this.m != null || this.p.length() < 2) ? list.size() : this.p.evaluateQueueSize(j, list);
    }

    public com.google.android.exoplayer2.source.TrackGroup f() {
        return this.h;
    }

    public com.google.android.exoplayer2.trackselection.TrackSelection g() {
        return this.p;
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.chunk.Chunk h(@androidx.annotation.Nullable android.net.Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] c = this.j.c(uri);
        if (c != null) {
            this.j.b(uri, c);
            return null;
        }
        return new com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk(this.c, new com.google.android.exoplayer2.upstream.DataSpec.Builder().setUri(uri).setFlags(1).build(), this.f[i], this.p.getSelectionReason(), this.p.getSelectionData(), this.l);
    }

    public boolean i(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j) {
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = this.p;
        return trackSelection.blacklist(trackSelection.indexOf(this.h.indexOf(chunk.trackFormat)), j);
    }

    public void j() throws java.io.IOException {
        java.io.IOException iOException = this.m;
        if (iOException != null) {
            throw iOException;
        }
        android.net.Uri uri = this.n;
        if (uri == null || !this.r) {
            return;
        }
        this.g.maybeThrowPlaylistRefreshError(uri);
    }

    public void k(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        if (chunk instanceof com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk) {
            com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk encryptionKeyChunk = (com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk) chunk;
            this.l = encryptionKeyChunk.getDataHolder();
            this.j.b(encryptionKeyChunk.dataSpec.uri, (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(encryptionKeyChunk.b()));
        }
    }

    public boolean l(android.net.Uri uri, long j) {
        int indexOf;
        int i = 0;
        while (true) {
            android.net.Uri[] uriArr = this.e;
            if (i >= uriArr.length) {
                i = -1;
                break;
            }
            if (uriArr[i].equals(uri)) {
                break;
            }
            i++;
        }
        if (i == -1 || (indexOf = this.p.indexOf(i)) == -1) {
            return true;
        }
        this.r = uri.equals(this.n) | this.r;
        return j == -9223372036854775807L || this.p.blacklist(indexOf, j);
    }

    public void m() {
        this.m = null;
    }

    public final long n(long j) {
        long j2 = this.q;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    public void o(boolean z) {
        this.k = z;
    }

    public void p(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection) {
        this.p = trackSelection;
    }

    public boolean q(long j, com.google.android.exoplayer2.source.chunk.Chunk chunk, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        if (this.m != null) {
            return false;
        }
        return this.p.shouldCancelChunkLoad(j, chunk, list);
    }

    public final void r(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        this.q = hlsMediaPlaylist.hasEndTag ? -9223372036854775807L : hlsMediaPlaylist.getEndTimeUs() - this.g.getInitialStartTimeUs();
    }
}
