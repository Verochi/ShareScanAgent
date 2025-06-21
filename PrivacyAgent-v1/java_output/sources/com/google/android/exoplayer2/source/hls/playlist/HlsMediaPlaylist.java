package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes22.dex */
public final class HlsMediaPlaylist extends com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist {
    public static final int PLAYLIST_TYPE_EVENT = 2;
    public static final int PLAYLIST_TYPE_UNKNOWN = 0;
    public static final int PLAYLIST_TYPE_VOD = 1;
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasProgramDateTime;
    public final long mediaSequence;
    public final int playlistType;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.drm.DrmInitData protectionSchemes;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> segments;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final int version;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public static final class Segment implements java.lang.Comparable<java.lang.Long> {
        public final long byteRangeLength;
        public final long byteRangeOffset;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.drm.DrmInitData drmInitData;
        public final long durationUs;

        @androidx.annotation.Nullable
        public final java.lang.String encryptionIV;

        @androidx.annotation.Nullable
        public final java.lang.String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment initializationSegment;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final java.lang.String title;
        public final java.lang.String url;

        public Segment(java.lang.String str, long j, long j2, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j, j2, false);
        }

        public Segment(java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment, java.lang.String str2, long j, int i, long j2, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, long j3, long j4, boolean z) {
            this.url = str;
            this.initializationSegment = segment;
            this.title = str2;
            this.durationUs = j;
            this.relativeDiscontinuitySequence = i;
            this.relativeStartTimeUs = j2;
            this.drmInitData = drmInitData;
            this.fullSegmentEncryptionKeyUri = str3;
            this.encryptionIV = str4;
            this.byteRangeOffset = j3;
            this.byteRangeLength = j4;
            this.hasGapTag = z;
        }

        @Override // java.lang.Comparable
        public int compareTo(java.lang.Long l) {
            if (this.relativeStartTimeUs > l.longValue()) {
                return 1;
            }
            return this.relativeStartTimeUs < l.longValue() ? -1 : 0;
        }
    }

    public HlsMediaPlaylist(int i, java.lang.String str, java.util.List<java.lang.String> list, long j, long j2, boolean z, int i2, long j3, int i3, long j4, boolean z2, boolean z3, boolean z4, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> list2) {
        super(str, list, z2);
        this.playlistType = i;
        this.startTimeUs = j2;
        this.hasDiscontinuitySequence = z;
        this.discontinuitySequence = i2;
        this.mediaSequence = j3;
        this.version = i3;
        this.targetDurationUs = j4;
        this.hasEndTag = z3;
        this.hasProgramDateTime = z4;
        this.protectionSchemes = drmInitData;
        this.segments = java.util.Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            this.durationUs = 0L;
        } else {
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = list2.get(list2.size() - 1);
            this.durationUs = segment.relativeStartTimeUs + segment.durationUs;
        }
        this.startOffsetUs = j == -9223372036854775807L ? -9223372036854775807L : j >= 0 ? j : this.durationUs + j;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist copy(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        return this;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* renamed from: copy, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist copy2(java.util.List list) {
        return copy((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }

    public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist copyWith(long j, int i) {
        return new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, j, true, i, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, this.hasEndTag, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }

    public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist copyWithEndTag() {
        return this.hasEndTag ? this : new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, true, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }

    public long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public boolean isNewerThan(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j = this.mediaSequence;
        long j2 = hlsMediaPlaylist.mediaSequence;
        if (j > j2) {
            return true;
        }
        if (j < j2) {
            return false;
        }
        int size = this.segments.size();
        int size2 = hlsMediaPlaylist.segments.size();
        if (size <= size2) {
            return size == size2 && this.hasEndTag && !hlsMediaPlaylist.hasEndTag;
        }
        return true;
    }
}
