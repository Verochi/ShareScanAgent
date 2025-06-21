package com.otaliastudios.cameraview.size;

/* loaded from: classes19.dex */
public class Size implements java.lang.Comparable<com.otaliastudios.cameraview.size.Size> {
    public final int n;
    public final int t;

    public Size(int i, int i2) {
        this.n = i;
        this.t = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        return (this.n * this.t) - (size.n * size.t);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.otaliastudios.cameraview.size.Size)) {
            return false;
        }
        com.otaliastudios.cameraview.size.Size size = (com.otaliastudios.cameraview.size.Size) obj;
        return this.n == size.n && this.t == size.t;
    }

    public com.otaliastudios.cameraview.size.Size flip() {
        return new com.otaliastudios.cameraview.size.Size(this.t, this.n);
    }

    public int getHeight() {
        return this.t;
    }

    public int getWidth() {
        return this.n;
    }

    public int hashCode() {
        int i = this.t;
        int i2 = this.n;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return this.n + "x" + this.t;
    }
}
