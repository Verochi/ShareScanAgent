package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public interface a extends android.os.IInterface {

    /* renamed from: com.umeng.analytics.pro.a$a, reason: collision with other inner class name */
    public static class C0511a implements com.umeng.analytics.pro.a {
        @Override // com.umeng.analytics.pro.a
        public java.lang.String a(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public boolean a() throws android.os.RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public java.lang.String b() throws android.os.RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public java.lang.String b(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public java.lang.String c(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public java.lang.String d(java.lang.String str) throws android.os.RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public java.lang.String e(java.lang.String str) throws android.os.RemoteException {
            return null;
        }
    }

    public static abstract class b extends android.os.Binder implements com.umeng.analytics.pro.a {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        static final int g = 7;
        private static final java.lang.String h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        /* renamed from: com.umeng.analytics.pro.a$b$a, reason: collision with other inner class name */
        public static class C0512a implements com.umeng.analytics.pro.a {
            public static com.umeng.analytics.pro.a a;
            private android.os.IBinder b;

            public C0512a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public java.lang.String a(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.a.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && com.umeng.analytics.pro.a.b.c() != null) {
                        return com.umeng.analytics.pro.a.b.c().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public boolean a() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.a.b.h);
                    if (!this.b.transact(6, obtain, obtain2, 0) && com.umeng.analytics.pro.a.b.c() != null) {
                        return com.umeng.analytics.pro.a.b.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.b;
            }

            @Override // com.umeng.analytics.pro.a
            public java.lang.String b() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.a.b.h);
                    if (!this.b.transact(7, obtain, obtain2, 0) && com.umeng.analytics.pro.a.b.c() != null) {
                        return com.umeng.analytics.pro.a.b.c().b();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public java.lang.String b(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.a.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && com.umeng.analytics.pro.a.b.c() != null) {
                        return com.umeng.analytics.pro.a.b.c().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String c() {
                return com.umeng.analytics.pro.a.b.h;
            }

            @Override // com.umeng.analytics.pro.a
            public java.lang.String c(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.a.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(3, obtain, obtain2, 0) && com.umeng.analytics.pro.a.b.c() != null) {
                        return com.umeng.analytics.pro.a.b.c().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public java.lang.String d(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.a.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(4, obtain, obtain2, 0) && com.umeng.analytics.pro.a.b.c() != null) {
                        return com.umeng.analytics.pro.a.b.c().d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public java.lang.String e(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.a.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(5, obtain, obtain2, 0) && com.umeng.analytics.pro.a.b.c() != null) {
                        return com.umeng.analytics.pro.a.b.c().e(str);
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
            attachInterface(this, h);
        }

        public static com.umeng.analytics.pro.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.umeng.analytics.pro.a)) ? new com.umeng.analytics.pro.a.b.C0512a(iBinder) : (com.umeng.analytics.pro.a) queryLocalInterface;
        }

        public static boolean a(com.umeng.analytics.pro.a aVar) {
            if (com.umeng.analytics.pro.a.b.C0512a.a != null || aVar == null) {
                return false;
            }
            com.umeng.analytics.pro.a.b.C0512a.a = aVar;
            return true;
        }

        public static com.umeng.analytics.pro.a c() {
            return com.umeng.analytics.pro.a.b.C0512a.a;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(h);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(h);
                    java.lang.String a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface(h);
                    java.lang.String b2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 3:
                    parcel.enforceInterface(h);
                    java.lang.String c2 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(c2);
                    return true;
                case 4:
                    parcel.enforceInterface(h);
                    java.lang.String d2 = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(d2);
                    return true;
                case 5:
                    parcel.enforceInterface(h);
                    java.lang.String e2 = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(e2);
                    return true;
                case 6:
                    parcel.enforceInterface(h);
                    boolean a3 = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(h);
                    java.lang.String b3 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    java.lang.String a(java.lang.String str) throws android.os.RemoteException;

    boolean a() throws android.os.RemoteException;

    java.lang.String b() throws android.os.RemoteException;

    java.lang.String b(java.lang.String str) throws android.os.RemoteException;

    java.lang.String c(java.lang.String str) throws android.os.RemoteException;

    java.lang.String d(java.lang.String str) throws android.os.RemoteException;

    java.lang.String e(java.lang.String str) throws android.os.RemoteException;
}
