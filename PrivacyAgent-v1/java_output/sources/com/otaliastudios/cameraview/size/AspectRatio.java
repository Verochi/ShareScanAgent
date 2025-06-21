package com.otaliastudios.cameraview.size;

/* loaded from: classes19.dex */
public class AspectRatio implements java.lang.Comparable<com.otaliastudios.cameraview.size.AspectRatio> {

    @androidx.annotation.VisibleForTesting
    public static final java.util.HashMap<java.lang.String, com.otaliastudios.cameraview.size.AspectRatio> u = new java.util.HashMap<>(16);
    public final int n;
    public final int t;

    public AspectRatio(int i, int i2) {
        this.n = i;
        this.t = i2;
    }

    public static int a(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.AspectRatio of(int i, int i2) {
        int a = a(i, i2);
        if (a > 0) {
            i /= a;
        }
        if (a > 0) {
            i2 /= a;
        }
        java.lang.String str = i + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i2;
        java.util.HashMap<java.lang.String, com.otaliastudios.cameraview.size.AspectRatio> hashMap = u;
        com.otaliastudios.cameraview.size.AspectRatio aspectRatio = hashMap.get(str);
        if (aspectRatio != null) {
            return aspectRatio;
        }
        com.otaliastudios.cameraview.size.AspectRatio aspectRatio2 = new com.otaliastudios.cameraview.size.AspectRatio(i, i2);
        hashMap.put(str, aspectRatio2);
        return aspectRatio2;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.AspectRatio of(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        return of(size.getWidth(), size.getHeight());
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.AspectRatio parse(@androidx.annotation.NonNull java.lang.String str) {
        java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        if (split.length == 2) {
            return of(java.lang.Integer.parseInt(split[0]), java.lang.Integer.parseInt(split[1]));
        }
        throw new java.lang.NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    @Override // java.lang.Comparable
    public int compareTo(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio) {
        return java.lang.Float.compare(toFloat(), aspectRatio.toFloat());
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof com.otaliastudios.cameraview.size.AspectRatio) && toFloat() == ((com.otaliastudios.cameraview.size.AspectRatio) obj).toFloat();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.size.AspectRatio flip() {
        return of(this.t, this.n);
    }

    public int getX() {
        return this.n;
    }

    public int getY() {
        return this.t;
    }

    public int hashCode() {
        return java.lang.Float.floatToIntBits(toFloat());
    }

    public boolean matches(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        return equals(of(size));
    }

    public boolean matches(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, float f) {
        return java.lang.Math.abs(toFloat() - of(size).toFloat()) <= f;
    }

    public float toFloat() {
        return this.n / this.t;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return this.n + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.t;
    }
}
