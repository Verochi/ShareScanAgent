package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class a implements android.os.IInterface {
    private android.os.IBinder a;

    public a(android.os.IBinder iBinder) {
        this.a = iBinder;
    }

    public final java.lang.String a() {
        java.lang.String str;
        android.os.Parcel obtain = android.os.Parcel.obtain();
        android.os.Parcel obtain2 = android.os.Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (java.lang.Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            th.printStackTrace();
            str = null;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }

    @Override // android.os.IInterface
    public final android.os.IBinder asBinder() {
        return this.a;
    }
}
