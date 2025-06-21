package com.google.android.exoplayer2.source.smoothstreaming.manifest;

/* loaded from: classes22.dex */
public class SsManifest implements com.google.android.exoplayer2.offline.FilterableManifest<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> {
    public static final int UNSET_LOOKAHEAD = -1;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement;
    public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElements;

    public static class ProtectionElement {
        public final byte[] data;
        public final com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxes;
        public final java.util.UUID uuid;

        public ProtectionElement(java.util.UUID uuid, byte[] bArr, com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.uuid = uuid;
            this.data = bArr;
            this.trackEncryptionBoxes = trackEncryptionBoxArr;
        }
    }

    public static class StreamElement {
        public final java.lang.String a;
        public final java.lang.String b;
        public final java.util.List<java.lang.Long> c;
        public final int chunkCount;
        public final long[] d;
        public final int displayHeight;
        public final int displayWidth;
        public final long e;
        public final com.google.android.exoplayer2.Format[] formats;

        @androidx.annotation.Nullable
        public final java.lang.String language;
        public final int maxHeight;
        public final int maxWidth;
        public final java.lang.String name;
        public final java.lang.String subType;
        public final long timescale;
        public final int type;

        public StreamElement(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, long j, java.lang.String str4, int i2, int i3, int i4, int i5, @androidx.annotation.Nullable java.lang.String str5, com.google.android.exoplayer2.Format[] formatArr, java.util.List<java.lang.Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, formatArr, list, com.google.android.exoplayer2.util.Util.scaleLargeTimestamps(list, 1000000L, j), com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, 1000000L, j));
        }

        public StreamElement(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, long j, java.lang.String str4, int i2, int i3, int i4, int i5, @androidx.annotation.Nullable java.lang.String str5, com.google.android.exoplayer2.Format[] formatArr, java.util.List<java.lang.Long> list, long[] jArr, long j2) {
            this.a = str;
            this.b = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.displayWidth = i4;
            this.displayHeight = i5;
            this.language = str5;
            this.formats = formatArr;
            this.c = list;
            this.d = jArr;
            this.e = j2;
            this.chunkCount = list.size();
        }

        public android.net.Uri buildRequestUri(int i, int i2) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.formats != null);
            com.google.android.exoplayer2.util.Assertions.checkState(this.c != null);
            com.google.android.exoplayer2.util.Assertions.checkState(i2 < this.c.size());
            java.lang.String num = java.lang.Integer.toString(this.formats[i].bitrate);
            java.lang.String l = this.c.get(i2).toString();
            return com.google.android.exoplayer2.util.UriUtil.resolveToUri(this.a, this.b.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
        }

        public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement copy(com.google.android.exoplayer2.Format[] formatArr) {
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement(this.a, this.b, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.c, this.d, this.e);
        }

        public long getChunkDurationUs(int i) {
            if (i == this.chunkCount - 1) {
                return this.e;
            }
            long[] jArr = this.d;
            return jArr[i + 1] - jArr[i];
        }

        public int getChunkIndex(long j) {
            return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.d, j, true, true);
        }

        public long getStartTimeUs(int i) {
            return this.d[i];
        }
    }

    public SsManifest(int i, int i2, long j, long j2, int i3, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr) {
        this.majorVersion = i;
        this.minorVersion = i2;
        this.durationUs = j;
        this.dvrWindowLengthUs = j2;
        this.lookAheadCount = i3;
        this.isLive = z;
        this.protectionElement = protectionElement;
        this.streamElements = streamElementArr;
    }

    public SsManifest(int i, int i2, long j, long j2, long j3, int i3, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, 1000000L, j), j3 != 0 ? com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j3, 1000000L, j) : -9223372036854775807L, i3, z, protectionElement, streamElementArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest copy(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.Collections.sort(arrayList);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = null;
        int i = 0;
        while (i < arrayList.size()) {
            com.google.android.exoplayer2.offline.StreamKey streamKey = (com.google.android.exoplayer2.offline.StreamKey) arrayList.get(i);
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement2 = this.streamElements[streamKey.groupIndex];
            if (streamElement2 != streamElement && streamElement != null) {
                arrayList2.add(streamElement.copy((com.google.android.exoplayer2.Format[]) arrayList3.toArray(new com.google.android.exoplayer2.Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(streamElement2.formats[streamKey.trackIndex]);
            i++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList2.add(streamElement.copy((com.google.android.exoplayer2.Format[]) arrayList3.toArray(new com.google.android.exoplayer2.Format[0])));
        }
        return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest(this.majorVersion, this.minorVersion, this.durationUs, this.dvrWindowLengthUs, this.lookAheadCount, this.isLive, this.protectionElement, (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[]) arrayList2.toArray(new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[0]));
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest copy(java.util.List list) {
        return copy((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }
}
