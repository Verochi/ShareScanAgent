package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class b implements android.os.Parcelable.Creator<com.huawei.hms.push.RemoteMessage> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.huawei.hms.push.RemoteMessage createFromParcel(android.os.Parcel parcel) {
        return new com.huawei.hms.push.RemoteMessage(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public com.huawei.hms.push.RemoteMessage[] newArray(int i) {
        return new com.huawei.hms.push.RemoteMessage[i];
    }
}
