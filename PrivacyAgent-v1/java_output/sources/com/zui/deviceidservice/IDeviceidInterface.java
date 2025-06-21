package com.zui.deviceidservice;

/* loaded from: classes19.dex */
public interface IDeviceidInterface extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.zui.deviceidservice.IDeviceidInterface {

        public static class Proxy implements com.zui.deviceidservice.IDeviceidInterface {
            private android.os.IBinder a;

            public Proxy(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public boolean a() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public java.lang.String getAAID(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    obtain.writeString(str);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public java.lang.String getOAID() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public java.lang.String getUDID() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public java.lang.String getVAID(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
        }

        public static com.zui.deviceidservice.IDeviceidInterface a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.zui.deviceidservice.IDeviceidInterface)) ? new com.zui.deviceidservice.IDeviceidInterface.Stub.Proxy(iBinder) : (com.zui.deviceidservice.IDeviceidInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                java.lang.String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                java.lang.String udid = getUDID();
                parcel2.writeNoException();
                parcel2.writeString(udid);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                boolean a = a();
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                java.lang.String vaid = getVAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(vaid);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
            java.lang.String aaid = getAAID(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }
    }

    boolean a();

    java.lang.String getAAID(java.lang.String str);

    java.lang.String getOAID();

    java.lang.String getUDID();

    java.lang.String getVAID(java.lang.String str);
}
