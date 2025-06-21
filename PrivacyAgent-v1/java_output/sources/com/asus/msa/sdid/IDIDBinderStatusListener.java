package com.asus.msa.sdid;

/* loaded from: classes12.dex */
public interface IDIDBinderStatusListener extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.asus.msa.sdid.IDIDBinderStatusListener {

        public static class Proxy implements com.asus.msa.sdid.IDIDBinderStatusListener {
            public android.os.IBinder a;

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.sdid.IDIDBinderStatusListener");
                    obtain.writeStrongBinder(iDidAidlInterface != null ? iDidAidlInterface.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public void b() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.sdid.IDIDBinderStatusListener");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.sdid.IDIDBinderStatusListener");
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.asus.msa.sdid.IDIDBinderStatusListener");
                a(com.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.a(parcel.readStrongBinder()));
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.asus.msa.sdid.IDIDBinderStatusListener");
                    return true;
                }
                parcel.enforceInterface("com.asus.msa.sdid.IDIDBinderStatusListener");
                b();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

    void b();
}
