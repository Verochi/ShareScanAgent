package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class Size implements java.lang.Comparable<com.aliyun.common.utils.Size> {
    private final int mHeight;
    private final int mWidth;

    public Size(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.aliyun.common.utils.Size size) {
        return (this.mWidth * this.mHeight) - (size.mWidth * size.mHeight);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.aliyun.common.utils.Size)) {
            return false;
        }
        com.aliyun.common.utils.Size size = (com.aliyun.common.utils.Size) obj;
        return this.mWidth == size.mWidth && this.mHeight == size.mHeight;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public java.lang.String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
