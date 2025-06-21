package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public abstract class SegmentBase {

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.dash.manifest.RangedUri a;
    public final long b;
    public final long c;

    public static abstract class MultiSegmentBase extends com.google.android.exoplayer2.source.dash.manifest.SegmentBase {
        public final long d;
        public final long e;

        @androidx.annotation.Nullable
        public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> f;

        public MultiSegmentBase(@androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j, long j2, long j3, long j4, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list) {
            super(rangedUri, j, j2);
            this.d = j3;
            this.e = j4;
            this.f = list;
        }

        public long getFirstSegmentNum() {
            return this.d;
        }

        public abstract int getSegmentCount(long j);

        public final long getSegmentDurationUs(long j, long j2) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list = this.f;
            if (list != null) {
                return (list.get((int) (j - this.d)).b * 1000000) / this.b;
            }
            int segmentCount = getSegmentCount(j2);
            return (segmentCount == -1 || j != (getFirstSegmentNum() + ((long) segmentCount)) - 1) ? (this.e * 1000000) / this.b : j2 - getSegmentTimeUs(j);
        }

        public long getSegmentNum(long j, long j2) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.f == null) {
                long j3 = this.d + (j / ((this.e * 1000000) / this.b));
                return j3 < firstSegmentNum ? firstSegmentNum : segmentCount == -1 ? j3 : java.lang.Math.min(j3, (firstSegmentNum + segmentCount) - 1);
            }
            long j4 = (segmentCount + firstSegmentNum) - 1;
            long j5 = firstSegmentNum;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                long segmentTimeUs = getSegmentTimeUs(j6);
                if (segmentTimeUs < j) {
                    j5 = j6 + 1;
                } else {
                    if (segmentTimeUs <= j) {
                        return j6;
                    }
                    j4 = j6 - 1;
                }
            }
            return j5 == firstSegmentNum ? j5 : j4;
        }

        public final long getSegmentTimeUs(long j) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list = this.f;
            return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(list != null ? list.get((int) (j - this.d)).a - this.c : (j - this.d) * this.e, 1000000L, this.b);
        }

        public abstract com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(com.google.android.exoplayer2.source.dash.manifest.Representation representation, long j);

        public boolean isExplicit() {
            return this.f != null;
        }
    }

    public static final class SegmentList extends com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase {

        @androidx.annotation.Nullable
        public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.RangedUri> g;

        public SegmentList(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j, long j2, long j3, long j4, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.RangedUri> list2) {
            super(rangedUri, j, j2, j3, j4, list);
            this.g = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j) {
            return this.g.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(com.google.android.exoplayer2.source.dash.manifest.Representation representation, long j) {
            return this.g.get((int) (j - this.d));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean isExplicit() {
            return true;
        }
    }

    public static final class SegmentTemplate extends com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase {

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.dash.manifest.UrlTemplate g;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.dash.manifest.UrlTemplate h;
        public final long i;

        public SegmentTemplate(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j, long j2, long j3, long j4, long j5, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate2) {
            super(rangedUri, j, j2, j3, j5, list);
            this.g = urlTemplate;
            this.h = urlTemplate2;
            this.i = j4;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getInitialization(com.google.android.exoplayer2.source.dash.manifest.Representation representation) {
            com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate = this.g;
            if (urlTemplate == null) {
                return super.getInitialization(representation);
            }
            com.google.android.exoplayer2.Format format = representation.format;
            return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(urlTemplate.buildUri(format.id, 0L, format.bitrate, 0L), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public int getSegmentCount(long j) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list = this.f;
            if (list != null) {
                return list.size();
            }
            long j2 = this.i;
            if (j2 != -1) {
                return (int) ((j2 - this.d) + 1);
            }
            if (j != -9223372036854775807L) {
                return (int) com.google.android.exoplayer2.util.Util.ceilDivide(j, (this.e * 1000000) / this.b);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(com.google.android.exoplayer2.source.dash.manifest.Representation representation, long j) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list = this.f;
            long j2 = list != null ? list.get((int) (j - this.d)).a : (j - this.d) * this.e;
            com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate = this.h;
            com.google.android.exoplayer2.Format format = representation.format;
            return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(urlTemplate.buildUri(format.id, j, format.bitrate, j2), 0L, -1L);
        }
    }

    public static final class SegmentTimelineElement {
        public final long a;
        public final long b;

        public SegmentTimelineElement(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement segmentTimelineElement = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement) obj;
            return this.a == segmentTimelineElement.a && this.b == segmentTimelineElement.b;
        }

        public int hashCode() {
            return (((int) this.a) * 31) + ((int) this.b);
        }
    }

    public static class SingleSegmentBase extends com.google.android.exoplayer2.source.dash.manifest.SegmentBase {
        public final long d;
        public final long e;

        public SingleSegmentBase() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public SingleSegmentBase(@androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            this.d = j3;
            this.e = j4;
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getIndex() {
            long j = this.e;
            if (j <= 0) {
                return null;
            }
            return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(null, this.d, j);
        }
    }

    public SegmentBase(@androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j, long j2) {
        this.a = rangedUri;
        this.b = j;
        this.c = j2;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.dash.manifest.RangedUri getInitialization(com.google.android.exoplayer2.source.dash.manifest.Representation representation) {
        return this.a;
    }

    public long getPresentationTimeOffsetUs() {
        return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(this.c, 1000000L, this.b);
    }
}
