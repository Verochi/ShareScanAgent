package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = -1;
    public final com.google.android.exoplayer2.source.dash.manifest.RangedUri a;
    public final java.lang.String baseUrl;
    public final com.google.android.exoplayer2.Format format;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> inbandEventStreams;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    public static class MultiSegmentRepresentation extends com.google.android.exoplayer2.source.dash.manifest.Representation implements com.google.android.exoplayer2.source.dash.DashSegmentIndex {
        public final com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase b;

        public MultiSegmentRepresentation(long j, com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase multiSegmentBase, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
            super(j, format, str, multiSegmentBase, list, null);
            this.b = multiSegmentBase;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @androidx.annotation.Nullable
        public java.lang.String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getDurationUs(long j, long j2) {
            return this.b.getSegmentDurationUs(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getFirstSegmentNum() {
            return this.b.getFirstSegmentNum();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public com.google.android.exoplayer2.source.dash.DashSegmentIndex getIndex() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getIndexUri() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public int getSegmentCount(long j) {
            return this.b.getSegmentCount(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getSegmentNum(long j, long j2) {
            return this.b.getSegmentNum(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j) {
            return this.b.getSegmentUrl(this, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getTimeUs(long j) {
            return this.b.getSegmentTimeUs(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public boolean isExplicit() {
            return this.b.isExplicit();
        }
    }

    public static class SingleSegmentRepresentation extends com.google.android.exoplayer2.source.dash.manifest.Representation {

        @androidx.annotation.Nullable
        public final java.lang.String b;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.dash.manifest.RangedUri c;
        public final long contentLength;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.dash.manifest.SingleSegmentIndex d;
        public final android.net.Uri uri;

        public SingleSegmentRepresentation(long j, com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase singleSegmentBase, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, @androidx.annotation.Nullable java.lang.String str2, long j2) {
            super(j, format, str, singleSegmentBase, list, null);
            this.uri = android.net.Uri.parse(str);
            com.google.android.exoplayer2.source.dash.manifest.RangedUri index = singleSegmentBase.getIndex();
            this.c = index;
            this.b = str2;
            this.contentLength = j2;
            this.d = index != null ? null : new com.google.android.exoplayer2.source.dash.manifest.SingleSegmentIndex(new com.google.android.exoplayer2.source.dash.manifest.RangedUri(null, 0L, j2));
        }

        public static com.google.android.exoplayer2.source.dash.manifest.Representation.SingleSegmentRepresentation newInstance(long j, com.google.android.exoplayer2.Format format, java.lang.String str, long j2, long j3, long j4, long j5, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, @androidx.annotation.Nullable java.lang.String str2, long j6) {
            return new com.google.android.exoplayer2.source.dash.manifest.Representation.SingleSegmentRepresentation(j, format, str, new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase(new com.google.android.exoplayer2.source.dash.manifest.RangedUri(null, j2, (j3 - j2) + 1), 1L, 0L, j4, (j5 - j4) + 1), list, str2, j6);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @androidx.annotation.Nullable
        public java.lang.String getCacheKey() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.dash.DashSegmentIndex getIndex() {
            return this.d;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getIndexUri() {
            return this.c;
        }
    }

    public Representation(long j, com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        this.revisionId = j;
        this.format = format;
        this.baseUrl = str;
        this.inbandEventStreams = list == null ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(list);
        this.a = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public /* synthetic */ Representation(long j, com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, java.util.List list, com.google.android.exoplayer2.source.dash.manifest.Representation.AnonymousClass1 anonymousClass1) {
        this(j, format, str, segmentBase, list);
    }

    public static com.google.android.exoplayer2.source.dash.manifest.Representation newInstance(long j, com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase) {
        return newInstance(j, format, str, segmentBase, null);
    }

    public static com.google.android.exoplayer2.source.dash.manifest.Representation newInstance(long j, com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        return newInstance(j, format, str, segmentBase, list, null);
    }

    public static com.google.android.exoplayer2.source.dash.manifest.Representation newInstance(long j, com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, @androidx.annotation.Nullable java.lang.String str2) {
        if (segmentBase instanceof com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) {
            return new com.google.android.exoplayer2.source.dash.manifest.Representation.SingleSegmentRepresentation(j, format, str, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) segmentBase, list, str2, -1L);
        }
        if (segmentBase instanceof com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase) {
            return new com.google.android.exoplayer2.source.dash.manifest.Representation.MultiSegmentRepresentation(j, format, str, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase) segmentBase, list);
        }
        throw new java.lang.IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    @androidx.annotation.Nullable
    public abstract java.lang.String getCacheKey();

    @androidx.annotation.Nullable
    public abstract com.google.android.exoplayer2.source.dash.DashSegmentIndex getIndex();

    @androidx.annotation.Nullable
    public abstract com.google.android.exoplayer2.source.dash.manifest.RangedUri getIndexUri();

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.dash.manifest.RangedUri getInitializationUri() {
        return this.a;
    }
}
