package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public interface d extends android.os.IInterface {

    public static class a implements com.umeng.analytics.pro.d {
        @Override // com.umeng.analytics.pro.d
        public java.lang.String a() throws android.os.RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.d
        public java.lang.String a(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.d
        public java.lang.String b(java.lang.String str) throws android.os.RemoteException {
            return null;
        }
    }

    public static abstract class b extends android.os.Binder implements com.umeng.analytics.pro.d {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        private static final java.lang.String d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public static class a implements com.umeng.analytics.pro.d {
            public static com.umeng.analytics.pro.d a;
            private android.os.IBinder b;

            public a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.umeng.analytics.pro.d
            public java.lang.String a() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.b.transact(1, obtain, obtain2, 0) && com.umeng.analytics.pro.d.b.b() != null) {
                        return com.umeng.analytics.pro.d.b.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.d
            public java.lang.String a(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && com.umeng.analytics.pro.d.b.b() != null) {
                        return com.umeng.analytics.pro.d.b.b().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.b;
            }

            public java.lang.String b() {
                return "com.samsung.android.deviceidservice.IDeviceIdService";
            }

            @Override // com.umeng.analytics.pro.d
            public java.lang.String b(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.b.transact(3, obtain, obtain2, 0) && com.umeng.analytics.pro.d.b.b() != null) {
                        return com.umeng.analytics.pro.d.b.b().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static com.umeng.analytics.pro.d a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.umeng.analytics.pro.d)) ? new com.umeng.analytics.pro.d.b.a(iBinder) : (com.umeng.analytics.pro.d) queryLocalInterface;
        }

        public static boolean a(com.umeng.analytics.pro.d dVar) {
            if (com.umeng.analytics.pro.d.b.a.a != null || dVar == null) {
                return false;
            }
            com.umeng.analytics.pro.d.b.a.a = dVar;
            return true;
        }

        public static com.umeng.analytics.pro.d b() {
            return com.umeng.analytics.pro.d.b.a.a;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                java.lang.String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                java.lang.String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            }
            parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            java.lang.String b2 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b2);
            return true;
        }
    }

    java.lang.String a() throws android.os.RemoteException;

    java.lang.String a(java.lang.String str) throws android.os.RemoteException;

    java.lang.String b(java.lang.String str) throws android.os.RemoteException;
}
