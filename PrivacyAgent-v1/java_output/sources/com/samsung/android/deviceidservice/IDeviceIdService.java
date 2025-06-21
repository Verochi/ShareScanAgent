package com.samsung.android.deviceidservice;

/* loaded from: classes19.dex */
public interface IDeviceIdService extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.samsung.android.deviceidservice.IDeviceIdService {

        public static class Proxy implements com.samsung.android.deviceidservice.IDeviceIdService {
            private android.os.IBinder a;

            public Proxy(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public java.lang.String getAAID(java.lang.String str) {
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

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public java.lang.String getOAID() {
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

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public java.lang.String getVAID(java.lang.String str) {
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
        }

        public Stub() {
            attachInterface(this, com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
        }

        public static com.samsung.android.deviceidservice.IDeviceIdService a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.samsung.android.deviceidservice.IDeviceIdService)) ? new com.samsung.android.deviceidservice.IDeviceIdService.Stub.Proxy(iBinder) : (com.samsung.android.deviceidservice.IDeviceIdService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            java.lang.String oaid;
            if (i == 1) {
                parcel.enforceInterface(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                oaid = getOAID();
            } else if (i == 2) {
                parcel.enforceInterface(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                oaid = getVAID(parcel.readString());
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                    return true;
                }
                parcel.enforceInterface(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                oaid = getAAID(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(oaid);
            return true;
        }
    }

    java.lang.String getAAID(java.lang.String str);

    java.lang.String getOAID();

    java.lang.String getVAID(java.lang.String str);
}
