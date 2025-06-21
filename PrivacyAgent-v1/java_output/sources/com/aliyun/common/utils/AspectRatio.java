package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class AspectRatio implements java.lang.Comparable<com.aliyun.common.utils.AspectRatio>, android.os.Parcelable {
    private final int mX;
    private final int mY;
    private static final android.util.SparseArray<android.util.SparseArray<com.aliyun.common.utils.AspectRatio>> SCACHE = new android.util.SparseArray<>(16);
    public static final android.os.Parcelable.Creator<com.aliyun.common.utils.AspectRatio> CREATOR = new com.aliyun.common.utils.AspectRatio.AnonymousClass1();

    /* renamed from: com.aliyun.common.utils.AspectRatio$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.aliyun.common.utils.AspectRatio> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.aliyun.common.utils.AspectRatio createFromParcel(android.os.Parcel parcel) {
            return com.aliyun.common.utils.AspectRatio.of(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.aliyun.common.utils.AspectRatio[] newArray(int i) {
            return new com.aliyun.common.utils.AspectRatio[i];
        }
    }

    public AspectRatio(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    private static int gcd(int i, int i2) {
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

    public static com.aliyun.common.utils.AspectRatio of(int i, int i2) {
        int gcd = gcd(i, i2);
        int i3 = i / gcd;
        int i4 = i2 / gcd;
        android.util.SparseArray<android.util.SparseArray<com.aliyun.common.utils.AspectRatio>> sparseArray = SCACHE;
        android.util.SparseArray<com.aliyun.common.utils.AspectRatio> sparseArray2 = sparseArray.get(i3);
        if (sparseArray2 == null) {
            com.aliyun.common.utils.AspectRatio aspectRatio = new com.aliyun.common.utils.AspectRatio(i3, i4);
            android.util.SparseArray<com.aliyun.common.utils.AspectRatio> sparseArray3 = new android.util.SparseArray<>();
            sparseArray3.put(i4, aspectRatio);
            sparseArray.put(i3, sparseArray3);
            return aspectRatio;
        }
        com.aliyun.common.utils.AspectRatio aspectRatio2 = sparseArray2.get(i4);
        if (aspectRatio2 != null) {
            return aspectRatio2;
        }
        com.aliyun.common.utils.AspectRatio aspectRatio3 = new com.aliyun.common.utils.AspectRatio(i3, i4);
        sparseArray2.put(i4, aspectRatio3);
        return aspectRatio3;
    }

    public static com.aliyun.common.utils.AspectRatio parse(java.lang.String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            throw new java.lang.IllegalArgumentException("Malformed aspect ratio: " + str);
        }
        try {
            return of(java.lang.Integer.parseInt(str.substring(0, indexOf)), java.lang.Integer.parseInt(str.substring(indexOf + 1)));
        } catch (java.lang.NumberFormatException e) {
            throw new java.lang.IllegalArgumentException("Malformed aspect ratio: " + str, e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(com.aliyun.common.utils.AspectRatio aspectRatio) {
        if (equals(aspectRatio)) {
            return 0;
        }
        return toFloat() - aspectRatio.toFloat() > 0.0f ? 1 : -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.aliyun.common.utils.AspectRatio)) {
            return false;
        }
        com.aliyun.common.utils.AspectRatio aspectRatio = (com.aliyun.common.utils.AspectRatio) obj;
        return this.mX == aspectRatio.mX && this.mY == aspectRatio.mY;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public int hashCode() {
        int i = this.mY;
        int i2 = this.mX;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public com.aliyun.common.utils.AspectRatio inverse() {
        return of(this.mY, this.mX);
    }

    public boolean matches(com.aliyun.common.utils.Size size) {
        int gcd = gcd(size.getWidth(), size.getHeight());
        return this.mX == size.getWidth() / gcd && this.mY == size.getHeight() / gcd;
    }

    public float toFloat() {
        return this.mX / this.mY;
    }

    public java.lang.String toString() {
        return this.mX + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.mY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mX);
        parcel.writeInt(this.mY);
    }
}
