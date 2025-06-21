package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public interface SeekMap {

    public static final class SeekPoints {
        public final com.google.android.exoplayer2.extractor.SeekPoint first;
        public final com.google.android.exoplayer2.extractor.SeekPoint second;

        public SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint seekPoint, com.google.android.exoplayer2.extractor.SeekPoint seekPoint2) {
            this.first = (com.google.android.exoplayer2.extractor.SeekPoint) com.google.android.exoplayer2.util.Assertions.checkNotNull(seekPoint);
            this.second = (com.google.android.exoplayer2.extractor.SeekPoint) com.google.android.exoplayer2.util.Assertions.checkNotNull(seekPoint2);
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.extractor.SeekMap.SeekPoints.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.extractor.SeekMap.SeekPoints seekPoints = (com.google.android.exoplayer2.extractor.SeekMap.SeekPoints) obj;
            return this.first.equals(seekPoints.first) && this.second.equals(seekPoints.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public java.lang.String toString() {
            java.lang.String sb;
            java.lang.String valueOf = java.lang.String.valueOf(this.first);
            if (this.first.equals(this.second)) {
                sb = "";
            } else {
                java.lang.String valueOf2 = java.lang.String.valueOf(this.second);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(valueOf2.length() + 2);
                sb2.append(", ");
                sb2.append(valueOf2);
                sb = sb2.toString();
            }
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(valueOf.length() + 2 + java.lang.String.valueOf(sb).length());
            sb3.append("[");
            sb3.append(valueOf);
            sb3.append(sb);
            sb3.append("]");
            return sb3.toString();
        }
    }

    public static class Unseekable implements com.google.android.exoplayer2.extractor.SeekMap {
        public final long a;
        public final com.google.android.exoplayer2.extractor.SeekMap.SeekPoints b;

        public Unseekable(long j) {
            this(j, 0L);
        }

        public Unseekable(long j, long j2) {
            this.a = j;
            this.b = new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(j2 == 0 ? com.google.android.exoplayer2.extractor.SeekPoint.START : new com.google.android.exoplayer2.extractor.SeekPoint(0L, j2));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j);

    boolean isSeekable();
}
