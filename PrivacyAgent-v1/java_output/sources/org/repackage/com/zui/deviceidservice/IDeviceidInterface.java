package org.repackage.com.zui.deviceidservice;

/* loaded from: classes26.dex */
public interface IDeviceidInterface extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements org.repackage.com.zui.deviceidservice.IDeviceidInterface {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        private static final java.lang.String g = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        public static class Proxy implements org.repackage.com.zui.deviceidservice.IDeviceidInterface {
            private android.os.IBinder a;

            public Proxy(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public java.lang.String a() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.g);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public java.lang.String a(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.g);
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
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

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public java.lang.String b() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.g);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public java.lang.String b(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.g);
                    obtain.writeString(str);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.g);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.g);
                    obtain.writeString(str);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String d() {
                return org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.g;
            }
        }

        public Stub() {
            attachInterface(this, g);
        }

        public static org.repackage.com.zui.deviceidservice.IDeviceidInterface a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(g);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof org.repackage.com.zui.deviceidservice.IDeviceidInterface)) ? new org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.Proxy(iBinder) : (org.repackage.com.zui.deviceidservice.IDeviceidInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(g);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(g);
                    java.lang.String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface(g);
                    java.lang.String b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 3:
                    parcel.enforceInterface(g);
                    boolean c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c2 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(g);
                    java.lang.String a3 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a3);
                    return true;
                case 5:
                    parcel.enforceInterface(g);
                    java.lang.String b3 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                case 6:
                    parcel.enforceInterface(g);
                    boolean c3 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c3 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    java.lang.String a() throws android.os.RemoteException;

    java.lang.String a(java.lang.String str) throws android.os.RemoteException;

    java.lang.String b() throws android.os.RemoteException;

    java.lang.String b(java.lang.String str) throws android.os.RemoteException;

    boolean c() throws android.os.RemoteException;

    boolean c(java.lang.String str) throws android.os.RemoteException;
}
