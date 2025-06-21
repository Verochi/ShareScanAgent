package com.sijla.g.a.b;

/* loaded from: classes19.dex */
public interface f extends android.os.IInterface {

    public static class a implements com.sijla.g.a.b.f {
        private android.os.IBinder a;

        public a(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        public final java.lang.String a() {
            java.lang.String str;
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (java.lang.Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return str;
        }

        @Override // android.os.IInterface
        public final android.os.IBinder asBinder() {
            return this.a;
        }
    }
}
