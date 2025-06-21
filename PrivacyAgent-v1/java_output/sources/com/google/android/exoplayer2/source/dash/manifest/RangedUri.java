package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public final class RangedUri {
    public final java.lang.String a;
    public int b;
    public final long length;
    public final long start;

    public RangedUri(@androidx.annotation.Nullable java.lang.String str, long j, long j2) {
        this.a = str == null ? "" : str;
        this.start = j;
        this.length = j2;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.dash.manifest.RangedUri attemptMerge(@androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, java.lang.String str) {
        java.lang.String resolveUriString = resolveUriString(str);
        if (rangedUri != null && resolveUriString.equals(rangedUri.resolveUriString(str))) {
            long j = this.length;
            if (j != -1) {
                long j2 = this.start;
                if (j2 + j == rangedUri.start) {
                    long j3 = rangedUri.length;
                    return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(resolveUriString, j2, j3 != -1 ? j + j3 : -1L);
                }
            }
            long j4 = rangedUri.length;
            if (j4 != -1) {
                long j5 = rangedUri.start;
                if (j5 + j4 == this.start) {
                    return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(resolveUriString, j5, j != -1 ? j4 + j : -1L);
                }
            }
        }
        return null;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.source.dash.manifest.RangedUri.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri = (com.google.android.exoplayer2.source.dash.manifest.RangedUri) obj;
        return this.start == rangedUri.start && this.length == rangedUri.length && this.a.equals(rangedUri.a);
    }

    public int hashCode() {
        if (this.b == 0) {
            this.b = ((((527 + ((int) this.start)) * 31) + ((int) this.length)) * 31) + this.a.hashCode();
        }
        return this.b;
    }

    public android.net.Uri resolveUri(java.lang.String str) {
        return com.google.android.exoplayer2.util.UriUtil.resolveToUri(str, this.a);
    }

    public java.lang.String resolveUriString(java.lang.String str) {
        return com.google.android.exoplayer2.util.UriUtil.resolve(str, this.a);
    }

    public java.lang.String toString() {
        java.lang.String str = this.a;
        long j = this.start;
        long j2 = this.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 81);
        sb.append("RangedUri(referenceUri=");
        sb.append(str);
        sb.append(", start=");
        sb.append(j);
        sb.append(", length=");
        sb.append(j2);
        sb.append(")");
        return sb.toString();
    }
}
