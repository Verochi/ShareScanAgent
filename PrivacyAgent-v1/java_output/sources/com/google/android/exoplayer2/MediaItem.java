package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class MediaItem {
    public final com.google.android.exoplayer2.MediaItem.ClippingProperties clippingProperties;
    public final java.lang.String mediaId;
    public final com.google.android.exoplayer2.MediaMetadata mediaMetadata;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties;

    public static final class Builder {

        @androidx.annotation.Nullable
        public java.lang.String a;

        @androidx.annotation.Nullable
        public android.net.Uri b;

        @androidx.annotation.Nullable
        public java.lang.String c;
        public long d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;

        @androidx.annotation.Nullable
        public android.net.Uri i;
        public java.util.Map<java.lang.String, java.lang.String> j;

        @androidx.annotation.Nullable
        public java.util.UUID k;
        public boolean l;
        public boolean m;
        public boolean n;
        public java.util.List<java.lang.Integer> o;

        @androidx.annotation.Nullable
        public byte[] p;
        public java.util.List<com.google.android.exoplayer2.offline.StreamKey> q;

        @androidx.annotation.Nullable
        public java.lang.String r;

        /* renamed from: s, reason: collision with root package name */
        public java.util.List<com.google.android.exoplayer2.MediaItem.Subtitle> f338s;

        @androidx.annotation.Nullable
        public android.net.Uri t;

        @androidx.annotation.Nullable
        public java.lang.Object u;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.MediaMetadata v;

        public Builder() {
            this.e = Long.MIN_VALUE;
            this.o = java.util.Collections.emptyList();
            this.j = java.util.Collections.emptyMap();
            this.q = java.util.Collections.emptyList();
            this.f338s = java.util.Collections.emptyList();
        }

        public Builder(com.google.android.exoplayer2.MediaItem mediaItem) {
            this();
            com.google.android.exoplayer2.MediaItem.ClippingProperties clippingProperties = mediaItem.clippingProperties;
            this.e = clippingProperties.endPositionMs;
            this.f = clippingProperties.relativeToLiveWindow;
            this.g = clippingProperties.relativeToDefaultPosition;
            this.d = clippingProperties.startPositionMs;
            this.h = clippingProperties.startsAtKeyFrame;
            this.a = mediaItem.mediaId;
            this.v = mediaItem.mediaMetadata;
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            if (playbackProperties != null) {
                this.t = playbackProperties.adTagUri;
                this.r = playbackProperties.customCacheKey;
                this.c = playbackProperties.mimeType;
                this.b = playbackProperties.uri;
                this.q = playbackProperties.streamKeys;
                this.f338s = playbackProperties.subtitles;
                this.u = playbackProperties.tag;
                com.google.android.exoplayer2.MediaItem.DrmConfiguration drmConfiguration = playbackProperties.drmConfiguration;
                if (drmConfiguration != null) {
                    this.i = drmConfiguration.licenseUri;
                    this.j = drmConfiguration.requestHeaders;
                    this.l = drmConfiguration.multiSession;
                    this.n = drmConfiguration.forceDefaultLicenseUri;
                    this.m = drmConfiguration.playClearContentWithoutKey;
                    this.o = drmConfiguration.sessionForClearTypes;
                    this.k = drmConfiguration.uuid;
                    this.p = drmConfiguration.getKeySetId();
                }
            }
        }

        public /* synthetic */ Builder(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.MediaItem.AnonymousClass1 anonymousClass1) {
            this(mediaItem);
        }

        public com.google.android.exoplayer2.MediaItem build() {
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties;
            com.google.android.exoplayer2.util.Assertions.checkState(this.i == null || this.k != null);
            android.net.Uri uri = this.b;
            if (uri != null) {
                java.lang.String str = this.c;
                java.util.UUID uuid = this.k;
                com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties2 = new com.google.android.exoplayer2.MediaItem.PlaybackProperties(uri, str, uuid != null ? new com.google.android.exoplayer2.MediaItem.DrmConfiguration(uuid, this.i, this.j, this.l, this.n, this.m, this.o, this.p, null) : null, this.q, this.r, this.f338s, this.t, this.u, null);
                java.lang.String str2 = this.a;
                if (str2 == null) {
                    str2 = this.b.toString();
                }
                this.a = str2;
                playbackProperties = playbackProperties2;
            } else {
                playbackProperties = null;
            }
            java.lang.String str3 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.a);
            com.google.android.exoplayer2.MediaItem.ClippingProperties clippingProperties = new com.google.android.exoplayer2.MediaItem.ClippingProperties(this.d, this.e, this.f, this.g, this.h, null);
            com.google.android.exoplayer2.MediaMetadata mediaMetadata = this.v;
            if (mediaMetadata == null) {
                mediaMetadata = new com.google.android.exoplayer2.MediaMetadata.Builder().build();
            }
            return new com.google.android.exoplayer2.MediaItem(str3, clippingProperties, playbackProperties, mediaMetadata, null);
        }

        public com.google.android.exoplayer2.MediaItem.Builder setAdTagUri(@androidx.annotation.Nullable android.net.Uri uri) {
            this.t = uri;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setAdTagUri(@androidx.annotation.Nullable java.lang.String str) {
            this.t = str != null ? android.net.Uri.parse(str) : null;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setClipEndPositionMs(long j) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(j == Long.MIN_VALUE || j >= 0);
            this.e = j;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setClipRelativeToDefaultPosition(boolean z) {
            this.g = z;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setClipRelativeToLiveWindow(boolean z) {
            this.f = z;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setClipStartPositionMs(long j) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(j >= 0);
            this.d = j;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setClipStartsAtKeyFrame(boolean z) {
            this.h = z;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setCustomCacheKey(@androidx.annotation.Nullable java.lang.String str) {
            this.r = str;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmForceDefaultLicenseUri(boolean z) {
            this.n = z;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmKeySetId(@androidx.annotation.Nullable byte[] bArr) {
            this.p = bArr != null ? java.util.Arrays.copyOf(bArr, bArr.length) : null;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmLicenseRequestHeaders(@androidx.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map) {
            this.j = (map == null || map.isEmpty()) ? java.util.Collections.emptyMap() : java.util.Collections.unmodifiableMap(new java.util.HashMap(map));
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmLicenseUri(@androidx.annotation.Nullable android.net.Uri uri) {
            this.i = uri;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmLicenseUri(@androidx.annotation.Nullable java.lang.String str) {
            this.i = str == null ? null : android.net.Uri.parse(str);
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmMultiSession(boolean z) {
            this.l = z;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmPlayClearContentWithoutKey(boolean z) {
            this.m = z;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmSessionForClearPeriods(boolean z) {
            setDrmSessionForClearTypes(z ? java.util.Arrays.asList(2, 1) : java.util.Collections.emptyList());
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmSessionForClearTypes(@androidx.annotation.Nullable java.util.List<java.lang.Integer> list) {
            this.o = (list == null || list.isEmpty()) ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setDrmUuid(@androidx.annotation.Nullable java.util.UUID uuid) {
            this.k = uuid;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setMediaId(@androidx.annotation.Nullable java.lang.String str) {
            this.a = str;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setMediaMetadata(com.google.android.exoplayer2.MediaMetadata mediaMetadata) {
            this.v = mediaMetadata;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setMimeType(@androidx.annotation.Nullable java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setStreamKeys(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
            this.q = (list == null || list.isEmpty()) ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setSubtitles(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.MediaItem.Subtitle> list) {
            this.f338s = (list == null || list.isEmpty()) ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.u = obj;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setUri(@androidx.annotation.Nullable android.net.Uri uri) {
            this.b = uri;
            return this;
        }

        public com.google.android.exoplayer2.MediaItem.Builder setUri(@androidx.annotation.Nullable java.lang.String str) {
            return setUri(str == null ? null : android.net.Uri.parse(str));
        }
    }

    public static final class ClippingProperties {
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;

        public ClippingProperties(long j, long j2, boolean z, boolean z2, boolean z3) {
            this.startPositionMs = j;
            this.endPositionMs = j2;
            this.relativeToLiveWindow = z;
            this.relativeToDefaultPosition = z2;
            this.startsAtKeyFrame = z3;
        }

        public /* synthetic */ ClippingProperties(long j, long j2, boolean z, boolean z2, boolean z3, com.google.android.exoplayer2.MediaItem.AnonymousClass1 anonymousClass1) {
            this(j, j2, z, z2, z3);
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof com.google.android.exoplayer2.MediaItem.ClippingProperties)) {
                return false;
            }
            com.google.android.exoplayer2.MediaItem.ClippingProperties clippingProperties = (com.google.android.exoplayer2.MediaItem.ClippingProperties) obj;
            return this.startPositionMs == clippingProperties.startPositionMs && this.endPositionMs == clippingProperties.endPositionMs && this.relativeToLiveWindow == clippingProperties.relativeToLiveWindow && this.relativeToDefaultPosition == clippingProperties.relativeToDefaultPosition && this.startsAtKeyFrame == clippingProperties.startsAtKeyFrame;
        }

        public int hashCode() {
            return (((((((java.lang.Long.valueOf(this.startPositionMs).hashCode() * 31) + java.lang.Long.valueOf(this.endPositionMs).hashCode()) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }
    }

    public static final class DrmConfiguration {

        @androidx.annotation.Nullable
        public final byte[] a;
        public final boolean forceDefaultLicenseUri;

        @androidx.annotation.Nullable
        public final android.net.Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        public final java.util.Map<java.lang.String, java.lang.String> requestHeaders;
        public final java.util.List<java.lang.Integer> sessionForClearTypes;
        public final java.util.UUID uuid;

        public DrmConfiguration(java.util.UUID uuid, @androidx.annotation.Nullable android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map, boolean z, boolean z2, boolean z3, java.util.List<java.lang.Integer> list, @androidx.annotation.Nullable byte[] bArr) {
            this.uuid = uuid;
            this.licenseUri = uri;
            this.requestHeaders = map;
            this.multiSession = z;
            this.forceDefaultLicenseUri = z2;
            this.playClearContentWithoutKey = z3;
            this.sessionForClearTypes = list;
            this.a = bArr != null ? java.util.Arrays.copyOf(bArr, bArr.length) : null;
        }

        public /* synthetic */ DrmConfiguration(java.util.UUID uuid, android.net.Uri uri, java.util.Map map, boolean z, boolean z2, boolean z3, java.util.List list, byte[] bArr, com.google.android.exoplayer2.MediaItem.AnonymousClass1 anonymousClass1) {
            this(uuid, uri, map, z, z2, z3, list, bArr);
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof com.google.android.exoplayer2.MediaItem.DrmConfiguration)) {
                return false;
            }
            com.google.android.exoplayer2.MediaItem.DrmConfiguration drmConfiguration = (com.google.android.exoplayer2.MediaItem.DrmConfiguration) obj;
            return this.uuid.equals(drmConfiguration.uuid) && com.google.android.exoplayer2.util.Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) && com.google.android.exoplayer2.util.Util.areEqual(this.requestHeaders, drmConfiguration.requestHeaders) && this.multiSession == drmConfiguration.multiSession && this.forceDefaultLicenseUri == drmConfiguration.forceDefaultLicenseUri && this.playClearContentWithoutKey == drmConfiguration.playClearContentWithoutKey && this.sessionForClearTypes.equals(drmConfiguration.sessionForClearTypes) && java.util.Arrays.equals(this.a, drmConfiguration.a);
        }

        @androidx.annotation.Nullable
        public byte[] getKeySetId() {
            byte[] bArr = this.a;
            if (bArr != null) {
                return java.util.Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public int hashCode() {
            int hashCode = this.uuid.hashCode() * 31;
            android.net.Uri uri = this.licenseUri;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.requestHeaders.hashCode()) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.forceDefaultLicenseUri ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31) + this.sessionForClearTypes.hashCode()) * 31) + java.util.Arrays.hashCode(this.a);
        }
    }

    public static final class PlaybackProperties {

        @androidx.annotation.Nullable
        public final android.net.Uri adTagUri;

        @androidx.annotation.Nullable
        public final java.lang.String customCacheKey;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.MediaItem.DrmConfiguration drmConfiguration;

        @androidx.annotation.Nullable
        public final java.lang.String mimeType;
        public final java.util.List<com.google.android.exoplayer2.offline.StreamKey> streamKeys;
        public final java.util.List<com.google.android.exoplayer2.MediaItem.Subtitle> subtitles;

        @androidx.annotation.Nullable
        public final java.lang.Object tag;
        public final android.net.Uri uri;

        public PlaybackProperties(android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.MediaItem.DrmConfiguration drmConfiguration, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, @androidx.annotation.Nullable java.lang.String str2, java.util.List<com.google.android.exoplayer2.MediaItem.Subtitle> list2, @androidx.annotation.Nullable android.net.Uri uri2, @androidx.annotation.Nullable java.lang.Object obj) {
            this.uri = uri;
            this.mimeType = str;
            this.drmConfiguration = drmConfiguration;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitles = list2;
            this.adTagUri = uri2;
            this.tag = obj;
        }

        public /* synthetic */ PlaybackProperties(android.net.Uri uri, java.lang.String str, com.google.android.exoplayer2.MediaItem.DrmConfiguration drmConfiguration, java.util.List list, java.lang.String str2, java.util.List list2, android.net.Uri uri2, java.lang.Object obj, com.google.android.exoplayer2.MediaItem.AnonymousClass1 anonymousClass1) {
            this(uri, str, drmConfiguration, list, str2, list2, uri2, obj);
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof com.google.android.exoplayer2.MediaItem.PlaybackProperties)) {
                return false;
            }
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = (com.google.android.exoplayer2.MediaItem.PlaybackProperties) obj;
            return this.uri.equals(playbackProperties.uri) && com.google.android.exoplayer2.util.Util.areEqual(this.mimeType, playbackProperties.mimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.drmConfiguration, playbackProperties.drmConfiguration) && this.streamKeys.equals(playbackProperties.streamKeys) && com.google.android.exoplayer2.util.Util.areEqual(this.customCacheKey, playbackProperties.customCacheKey) && this.subtitles.equals(playbackProperties.subtitles) && com.google.android.exoplayer2.util.Util.areEqual(this.adTagUri, playbackProperties.adTagUri) && com.google.android.exoplayer2.util.Util.areEqual(this.tag, playbackProperties.tag);
        }

        public int hashCode() {
            int hashCode = this.uri.hashCode() * 31;
            java.lang.String str = this.mimeType;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            com.google.android.exoplayer2.MediaItem.DrmConfiguration drmConfiguration = this.drmConfiguration;
            int hashCode3 = (((hashCode2 + (drmConfiguration == null ? 0 : drmConfiguration.hashCode())) * 31) + this.streamKeys.hashCode()) * 31;
            java.lang.String str2 = this.customCacheKey;
            int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.subtitles.hashCode()) * 31;
            android.net.Uri uri = this.adTagUri;
            int hashCode5 = (hashCode4 + (uri == null ? 0 : uri.hashCode())) * 31;
            java.lang.Object obj = this.tag;
            return hashCode5 + (obj != null ? obj.hashCode() : 0);
        }
    }

    public static final class Subtitle {

        @androidx.annotation.Nullable
        public final java.lang.String label;

        @androidx.annotation.Nullable
        public final java.lang.String language;
        public final java.lang.String mimeType;
        public final int roleFlags;
        public final int selectionFlags;
        public final android.net.Uri uri;

        public Subtitle(android.net.Uri uri, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
            this(uri, str, str2, 0);
        }

        public Subtitle(android.net.Uri uri, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i) {
            this(uri, str, str2, i, 0, null);
        }

        public Subtitle(android.net.Uri uri, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i, int i2, @androidx.annotation.Nullable java.lang.String str3) {
            this.uri = uri;
            this.mimeType = str;
            this.language = str2;
            this.selectionFlags = i;
            this.roleFlags = i2;
            this.label = str3;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof com.google.android.exoplayer2.MediaItem.Subtitle)) {
                return false;
            }
            com.google.android.exoplayer2.MediaItem.Subtitle subtitle = (com.google.android.exoplayer2.MediaItem.Subtitle) obj;
            return this.uri.equals(subtitle.uri) && this.mimeType.equals(subtitle.mimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.language, subtitle.language) && this.selectionFlags == subtitle.selectionFlags && this.roleFlags == subtitle.roleFlags && com.google.android.exoplayer2.util.Util.areEqual(this.label, subtitle.label);
        }

        public int hashCode() {
            int hashCode = ((this.uri.hashCode() * 31) + this.mimeType.hashCode()) * 31;
            java.lang.String str = this.language;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31;
            java.lang.String str2 = this.label;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }
    }

    public MediaItem(java.lang.String str, com.google.android.exoplayer2.MediaItem.ClippingProperties clippingProperties, @androidx.annotation.Nullable com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties, com.google.android.exoplayer2.MediaMetadata mediaMetadata) {
        this.mediaId = str;
        this.playbackProperties = playbackProperties;
        this.mediaMetadata = mediaMetadata;
        this.clippingProperties = clippingProperties;
    }

    public /* synthetic */ MediaItem(java.lang.String str, com.google.android.exoplayer2.MediaItem.ClippingProperties clippingProperties, com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties, com.google.android.exoplayer2.MediaMetadata mediaMetadata, com.google.android.exoplayer2.MediaItem.AnonymousClass1 anonymousClass1) {
        this(str, clippingProperties, playbackProperties, mediaMetadata);
    }

    public static com.google.android.exoplayer2.MediaItem fromUri(android.net.Uri uri) {
        return new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).build();
    }

    public static com.google.android.exoplayer2.MediaItem fromUri(java.lang.String str) {
        return new com.google.android.exoplayer2.MediaItem.Builder().setUri(str).build();
    }

    public com.google.android.exoplayer2.MediaItem.Builder buildUpon() {
        return new com.google.android.exoplayer2.MediaItem.Builder(this, null);
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.exoplayer2.MediaItem)) {
            return false;
        }
        com.google.android.exoplayer2.MediaItem mediaItem = (com.google.android.exoplayer2.MediaItem) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.mediaId, mediaItem.mediaId) && this.clippingProperties.equals(mediaItem.clippingProperties) && com.google.android.exoplayer2.util.Util.areEqual(this.playbackProperties, mediaItem.playbackProperties) && com.google.android.exoplayer2.util.Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata);
    }

    public int hashCode() {
        int hashCode = this.mediaId.hashCode() * 31;
        com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = this.playbackProperties;
        return ((((hashCode + (playbackProperties != null ? playbackProperties.hashCode() : 0)) * 31) + this.clippingProperties.hashCode()) * 31) + this.mediaMetadata.hashCode();
    }
}
