package com.huawei.hms.common.size;

/* loaded from: classes22.dex */
public class Size {
    private final int height;
    private final int width;

    public Size(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public static com.huawei.hms.common.size.Size parseSize(java.lang.String str) {
        try {
            int indexOf = str.indexOf("x");
            if (indexOf < 0) {
                indexOf = str.indexOf("*");
            }
            return new com.huawei.hms.common.size.Size(java.lang.Integer.parseInt(str.substring(0, indexOf)), java.lang.Integer.parseInt(str.substring(indexOf + 1)));
        } catch (java.lang.Exception unused) {
            throw new java.lang.IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.huawei.hms.common.size.Size)) {
            return false;
        }
        com.huawei.hms.common.size.Size size = (com.huawei.hms.common.size.Size) obj;
        return this.width == size.width && this.height == size.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return com.huawei.hms.common.internal.Objects.hashCode(java.lang.Integer.valueOf(getWidth()), java.lang.Integer.valueOf(getHeight()));
    }

    public final java.lang.String toString() {
        return "Width is " + this.width + " Height is " + this.height;
    }
}
