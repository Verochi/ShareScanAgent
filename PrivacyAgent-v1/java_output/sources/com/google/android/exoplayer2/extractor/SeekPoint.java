package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class SeekPoint {
    public static final com.google.android.exoplayer2.extractor.SeekPoint START = new com.google.android.exoplayer2.extractor.SeekPoint(0, 0);
    public final long position;
    public final long timeUs;

    public SeekPoint(long j, long j2) {
        this.timeUs = j;
        this.position = j2;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.extractor.SeekPoint.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = (com.google.android.exoplayer2.extractor.SeekPoint) obj;
        return this.timeUs == seekPoint.timeUs && this.position == seekPoint.position;
    }

    public int hashCode() {
        return (((int) this.timeUs) * 31) + ((int) this.position);
    }

    public java.lang.String toString() {
        long j = this.timeUs;
        long j2 = this.position;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(60);
        sb.append("[timeUs=");
        sb.append(j);
        sb.append(", position=");
        sb.append(j2);
        sb.append("]");
        return sb.toString();
    }
}
