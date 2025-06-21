package com.huawei.hms.common.webserverpic;

/* loaded from: classes22.dex */
public class WebServerPic {
    public static final android.os.Parcelable.Creator<com.huawei.hms.common.webserverpic.WebServerPic> CREATOR = new com.huawei.hms.common.webserverpic.WebServerPicCreator();
    private final int height;
    private final android.net.Uri url;
    private final int width;

    public WebServerPic(android.net.Uri uri) throws java.lang.IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebServerPic(android.net.Uri uri, int i, int i2) throws java.lang.IllegalArgumentException {
        this.url = uri;
        this.width = i;
        this.height = i2;
        if (uri == null) {
            throw new java.lang.IllegalArgumentException("url is not able to be null");
        }
        if (i < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("width and height should be positive or 0");
        }
    }

    public final int getHeight() {
        return this.height;
    }

    public final android.net.Uri getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public final java.lang.String toString() {
        return java.lang.String.format(java.util.Locale.ENGLISH, "Image %dx%d %s", java.lang.Integer.valueOf(this.width), java.lang.Integer.valueOf(this.height), this.url.toString());
    }

    public final void writeToParcel(android.os.Parcel parcel, int i) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(parcel);
        int beginObjectHeader = com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeParcelable(parcel, 1, getUrl(), i, false);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 2, getWidth());
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 3, getHeight());
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
