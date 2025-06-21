package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public interface q extends android.os.IInterface {

    public static class a implements com.anythink.china.a.a.q {
        private android.os.IBinder a;

        public a(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // com.anythink.china.a.a.q
        public final java.lang.String a() {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.anythink.china.a.a.q
        public final java.lang.String b() {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    java.lang.String a();

    java.lang.String b();
}
