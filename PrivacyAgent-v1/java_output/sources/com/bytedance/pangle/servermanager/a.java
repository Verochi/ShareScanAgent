package com.bytedance.pangle.servermanager;

/* loaded from: classes.dex */
public final class a implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.bytedance.pangle.servermanager.a> CREATOR = new com.bytedance.pangle.servermanager.a.AnonymousClass1();
    final android.os.IBinder a;

    /* renamed from: com.bytedance.pangle.servermanager.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.bytedance.pangle.servermanager.a> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.bytedance.pangle.servermanager.a createFromParcel(android.os.Parcel parcel) {
            return new com.bytedance.pangle.servermanager.a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.bytedance.pangle.servermanager.a[] newArray(int i) {
            return new com.bytedance.pangle.servermanager.a[i];
        }
    }

    public a(android.os.IBinder iBinder) {
        this.a = iBinder;
    }

    public a(android.os.Parcel parcel) {
        this.a = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeStrongBinder(this.a);
    }
}
