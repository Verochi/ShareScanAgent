package com.alipay.sdk.m.k0;

/* loaded from: classes.dex */
public interface a extends android.os.IInterface {

    /* renamed from: com.alipay.sdk.m.k0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0035a extends android.os.Binder implements com.alipay.sdk.m.k0.a {
        public static final java.lang.String a = "com.samsung.android.deviceidservice.IDeviceIdService";
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;

        /* renamed from: com.alipay.sdk.m.k0.a$a$a, reason: collision with other inner class name */
        public static class C0036a implements com.alipay.sdk.m.k0.a {
            public android.os.IBinder a;

            public C0036a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alipay.sdk.m.k0.a
            public java.lang.String a() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.k0.a
            public java.lang.String a(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }

            @Override // com.alipay.sdk.m.k0.a
            public java.lang.String b(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String d() {
                return com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a;
            }
        }

        public AbstractBinderC0035a() {
            attachInterface(this, a);
        }

        public static com.alipay.sdk.m.k0.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.alipay.sdk.m.k0.a)) ? new com.alipay.sdk.m.k0.a.AbstractBinderC0035a.C0036a(iBinder) : (com.alipay.sdk.m.k0.a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                java.lang.String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a);
                java.lang.String b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a);
                return true;
            }
            parcel.enforceInterface(a);
            java.lang.String a3 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a3);
            return true;
        }
    }

    java.lang.String a() throws android.os.RemoteException;

    java.lang.String a(java.lang.String str) throws android.os.RemoteException;

    java.lang.String b(java.lang.String str) throws android.os.RemoteException;
}
