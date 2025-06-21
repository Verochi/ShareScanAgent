package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes22.dex */
public final class HlsMasterPlaylist extends com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist {
    public static final com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist EMPTY = new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist("", java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList(), null, java.util.Collections.emptyList(), false, java.util.Collections.emptyMap(), java.util.Collections.emptyList());
    public static final int GROUP_INDEX_AUDIO = 1;
    public static final int GROUP_INDEX_SUBTITLE = 2;
    public static final int GROUP_INDEX_VARIANT = 0;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> audios;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> closedCaptions;
    public final java.util.List<android.net.Uri> mediaPlaylistUrls;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.Format muxedAudioFormat;

    @androidx.annotation.Nullable
    public final java.util.List<com.google.android.exoplayer2.Format> muxedCaptionFormats;
    public final java.util.List<com.google.android.exoplayer2.drm.DrmInitData> sessionKeyDrmInitData;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> subtitles;
    public final java.util.Map<java.lang.String, java.lang.String> variableDefinitions;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant> variants;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> videos;

    public static final class Rendition {
        public final com.google.android.exoplayer2.Format format;
        public final java.lang.String groupId;
        public final java.lang.String name;

        @androidx.annotation.Nullable
        public final android.net.Uri url;

        public Rendition(@androidx.annotation.Nullable android.net.Uri uri, com.google.android.exoplayer2.Format format, java.lang.String str, java.lang.String str2) {
            this.url = uri;
            this.format = format;
            this.groupId = str;
            this.name = str2;
        }
    }

    public static final class Variant {

        @androidx.annotation.Nullable
        public final java.lang.String audioGroupId;

        @androidx.annotation.Nullable
        public final java.lang.String captionGroupId;
        public final com.google.android.exoplayer2.Format format;

        @androidx.annotation.Nullable
        public final java.lang.String subtitleGroupId;
        public final android.net.Uri url;

        @androidx.annotation.Nullable
        public final java.lang.String videoGroupId;

        public Variant(android.net.Uri uri, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4) {
            this.url = uri;
            this.format = format;
            this.videoGroupId = str;
            this.audioGroupId = str2;
            this.subtitleGroupId = str3;
            this.captionGroupId = str4;
        }

        public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant createMediaPlaylistVariantUrl(android.net.Uri uri) {
            return new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant(uri, new com.google.android.exoplayer2.Format.Builder().setId("0").setContainerMimeType("application/x-mpegURL").build(), null, null, null, null);
        }

        public com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant copyWithFormat(com.google.android.exoplayer2.Format format) {
            return new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant(this.url, format, this.videoGroupId, this.audioGroupId, this.subtitleGroupId, this.captionGroupId);
        }
    }

    public HlsMasterPlaylist(java.lang.String str, java.util.List<java.lang.String> list, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant> list2, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list3, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list4, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list5, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list6, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list7, boolean z, java.util.Map<java.lang.String, java.lang.String> map, java.util.List<com.google.android.exoplayer2.drm.DrmInitData> list8) {
        super(str, list, z);
        this.mediaPlaylistUrls = java.util.Collections.unmodifiableList(c(list2, list3, list4, list5, list6));
        this.variants = java.util.Collections.unmodifiableList(list2);
        this.videos = java.util.Collections.unmodifiableList(list3);
        this.audios = java.util.Collections.unmodifiableList(list4);
        this.subtitles = java.util.Collections.unmodifiableList(list5);
        this.closedCaptions = java.util.Collections.unmodifiableList(list6);
        this.muxedAudioFormat = format;
        this.muxedCaptionFormats = list7 != null ? java.util.Collections.unmodifiableList(list7) : null;
        this.variableDefinitions = java.util.Collections.unmodifiableMap(map);
        this.sessionKeyDrmInitData = java.util.Collections.unmodifiableList(list8);
    }

    public static void a(java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list, java.util.List<android.net.Uri> list2) {
        for (int i = 0; i < list.size(); i++) {
            android.net.Uri uri = list.get(i).url;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    public static <T> java.util.List<T> b(java.util.List<T> list, int i, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list2) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            T t = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 < list2.size()) {
                    com.google.android.exoplayer2.offline.StreamKey streamKey = list2.get(i3);
                    if (streamKey.groupIndex == i && streamKey.trackIndex == i2) {
                        arrayList.add(t);
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }

    public static java.util.List<android.net.Uri> c(java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant> list, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list2, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list3, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list4, java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition> list5) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < list.size(); i++) {
            android.net.Uri uri = list.get(i).url;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        a(list2, arrayList);
        a(list3, arrayList);
        a(list4, arrayList);
        a(list5, arrayList);
        return arrayList;
    }

    public static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist createSingleVariantMasterPlaylist(java.lang.String str) {
        return new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist("", java.util.Collections.emptyList(), java.util.Collections.singletonList(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant.createMediaPlaylistVariantUrl(android.net.Uri.parse(str))), java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList(), java.util.Collections.emptyList(), null, null, false, java.util.Collections.emptyMap(), java.util.Collections.emptyList());
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist copy(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        return new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist(this.baseUri, this.tags, b(this.variants, 0, list), java.util.Collections.emptyList(), b(this.audios, 1, list), b(this.subtitles, 2, list), java.util.Collections.emptyList(), this.muxedAudioFormat, this.muxedCaptionFormats, this.hasIndependentSegments, this.variableDefinitions, this.sessionKeyDrmInitData);
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* renamed from: copy, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist copy2(java.util.List list) {
        return copy((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }
}
