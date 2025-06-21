package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public final class TrackSelectionArray {
    public final com.google.android.exoplayer2.trackselection.TrackSelection[] a;
    public int b;
    public final int length;

    public TrackSelectionArray(com.google.android.exoplayer2.trackselection.TrackSelection... trackSelectionArr) {
        this.a = trackSelectionArr;
        this.length = trackSelectionArr.length;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.trackselection.TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return java.util.Arrays.equals(this.a, ((com.google.android.exoplayer2.trackselection.TrackSelectionArray) obj).a);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.trackselection.TrackSelection get(int i) {
        return this.a[i];
    }

    public com.google.android.exoplayer2.trackselection.TrackSelection[] getAll() {
        return (com.google.android.exoplayer2.trackselection.TrackSelection[]) this.a.clone();
    }

    public int hashCode() {
        if (this.b == 0) {
            this.b = 527 + java.util.Arrays.hashCode(this.a);
        }
        return this.b;
    }
}
