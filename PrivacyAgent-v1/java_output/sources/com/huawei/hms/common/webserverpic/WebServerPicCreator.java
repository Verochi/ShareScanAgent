package com.huawei.hms.common.webserverpic;

/* loaded from: classes22.dex */
public final class WebServerPicCreator implements android.os.Parcelable.Creator<com.huawei.hms.common.webserverpic.WebServerPic> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.huawei.hms.common.webserverpic.WebServerPic createFromParcel(android.os.Parcel parcel) {
        return new com.huawei.hms.common.webserverpic.WebServerPic((android.net.Uri) parcel.readParcelable(android.net.Uri.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.huawei.hms.common.webserverpic.WebServerPic[] newArray(int i) {
        return new com.huawei.hms.common.webserverpic.WebServerPic[i];
    }
}
