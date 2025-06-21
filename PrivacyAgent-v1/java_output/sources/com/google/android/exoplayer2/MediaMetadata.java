package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class MediaMetadata {

    @androidx.annotation.Nullable
    public final java.lang.String title;

    public static final class Builder {

        @androidx.annotation.Nullable
        public java.lang.String a;

        public com.google.android.exoplayer2.MediaMetadata build() {
            return new com.google.android.exoplayer2.MediaMetadata(this.a, null);
        }

        public com.google.android.exoplayer2.MediaMetadata.Builder setTitle(@androidx.annotation.Nullable java.lang.String str) {
            this.a = str;
            return this;
        }
    }

    public MediaMetadata(@androidx.annotation.Nullable java.lang.String str) {
        this.title = str;
    }

    public /* synthetic */ MediaMetadata(java.lang.String str, com.google.android.exoplayer2.MediaMetadata.AnonymousClass1 anonymousClass1) {
        this(str);
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.MediaMetadata.class != obj.getClass()) {
            return false;
        }
        return com.google.android.exoplayer2.util.Util.areEqual(this.title, ((com.google.android.exoplayer2.MediaMetadata) obj).title);
    }

    public int hashCode() {
        java.lang.String str = this.title;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}
