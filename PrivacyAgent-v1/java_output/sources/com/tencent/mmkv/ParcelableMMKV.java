package com.tencent.mmkv;

/* loaded from: classes19.dex */
public final class ParcelableMMKV implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.tencent.mmkv.ParcelableMMKV> CREATOR = new com.tencent.mmkv.ParcelableMMKV.AnonymousClass1();
    private int ashmemFD;
    private int ashmemMetaFD;
    private java.lang.String cryptKey;
    private final java.lang.String mmapID;

    /* renamed from: com.tencent.mmkv.ParcelableMMKV$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.tencent.mmkv.ParcelableMMKV> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.tencent.mmkv.ParcelableMMKV createFromParcel(android.os.Parcel parcel) {
            java.lang.String readString = parcel.readString();
            android.os.ParcelFileDescriptor parcelFileDescriptor = (android.os.ParcelFileDescriptor) android.os.ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            android.os.ParcelFileDescriptor parcelFileDescriptor2 = (android.os.ParcelFileDescriptor) android.os.ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            java.lang.String readString2 = parcel.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new com.tencent.mmkv.ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.tencent.mmkv.ParcelableMMKV[] newArray(int i) {
            return new com.tencent.mmkv.ParcelableMMKV[i];
        }
    }

    public ParcelableMMKV(com.tencent.mmkv.MMKV mmkv) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = mmkv.mmapID();
        this.ashmemFD = mmkv.ashmemFD();
        this.ashmemMetaFD = mmkv.ashmemMetaFD();
        this.cryptKey = mmkv.cryptKey();
    }

    private ParcelableMMKV(java.lang.String str, int i, int i2, java.lang.String str2) {
        this.mmapID = str;
        this.ashmemFD = i;
        this.ashmemMetaFD = i2;
        this.cryptKey = str2;
    }

    public /* synthetic */ ParcelableMMKV(java.lang.String str, int i, int i2, java.lang.String str2, com.tencent.mmkv.ParcelableMMKV.AnonymousClass1 anonymousClass1) {
        this(str, i, i2, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public com.tencent.mmkv.MMKV toMMKV() {
        int i;
        int i2 = this.ashmemFD;
        if (i2 < 0 || (i = this.ashmemMetaFD) < 0) {
            return null;
        }
        return com.tencent.mmkv.MMKV.mmkvWithAshmemFD(this.mmapID, i2, i, this.cryptKey);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        try {
            parcel.writeString(this.mmapID);
            android.os.ParcelFileDescriptor fromFd = android.os.ParcelFileDescriptor.fromFd(this.ashmemFD);
            android.os.ParcelFileDescriptor fromFd2 = android.os.ParcelFileDescriptor.fromFd(this.ashmemMetaFD);
            int i2 = i | 1;
            fromFd.writeToParcel(parcel, i2);
            fromFd2.writeToParcel(parcel, i2);
            java.lang.String str = this.cryptKey;
            if (str != null) {
                parcel.writeString(str);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
