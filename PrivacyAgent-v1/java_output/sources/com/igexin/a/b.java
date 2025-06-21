package com.igexin.a;

/* loaded from: classes22.dex */
public final class b {
    private static final java.lang.String a = "com.igexin.push.extension.distribution.gws.action.guard.WakeCallback";
    private static final int c = 1;
    private android.os.IBinder b;

    public b(android.os.IBinder iBinder) {
        this.b = iBinder;
    }

    private android.os.IBinder a() {
        return this.b;
    }

    public final void a(android.os.Bundle bundle) throws android.os.RemoteException {
        if (this.b == null) {
            return;
        }
        android.os.Parcel obtain = android.os.Parcel.obtain();
        android.os.Parcel obtain2 = android.os.Parcel.obtain();
        try {
            obtain.writeInterfaceToken(a);
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
            this.b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
