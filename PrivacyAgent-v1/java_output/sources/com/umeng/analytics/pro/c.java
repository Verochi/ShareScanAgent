package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public interface c extends android.os.IInterface {

    public static class a implements com.umeng.analytics.pro.c {
        @Override // com.umeng.analytics.pro.c
        public void a(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.umeng.analytics.pro.c
        public void a(com.umeng.analytics.pro.b bVar) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.c
        public void b(com.umeng.analytics.pro.b bVar) throws android.os.RemoteException {
        }
    }

    public static abstract class b extends android.os.Binder implements com.umeng.analytics.pro.c {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        private static final java.lang.String d = "com.hihonor.cloudservice.oaid.IOAIDService";

        public static class a implements com.umeng.analytics.pro.c {
            public static com.umeng.analytics.pro.c a;
            private android.os.IBinder b;

            public a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            public java.lang.String a() {
                return com.umeng.analytics.pro.c.b.d;
            }

            @Override // com.umeng.analytics.pro.c
            public void a(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.c.b.d);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    obtain.writeDouble(d);
                    obtain.writeString(str);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                    if (this.b.transact(1, obtain, obtain2, 0) || com.umeng.analytics.pro.c.b.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        com.umeng.analytics.pro.c.b.a().a(i, j, z, f, d, str);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.umeng.analytics.pro.c
            public void a(com.umeng.analytics.pro.b bVar) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.c.b.d);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.b.transact(2, obtain, obtain2, 0) || com.umeng.analytics.pro.c.b.a() == null) {
                        obtain2.readException();
                    } else {
                        com.umeng.analytics.pro.c.b.a().a(bVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.b;
            }

            @Override // com.umeng.analytics.pro.c
            public void b(com.umeng.analytics.pro.b bVar) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.c.b.d);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.b.transact(3, obtain, obtain2, 0) || com.umeng.analytics.pro.c.b.a() == null) {
                        obtain2.readException();
                    } else {
                        com.umeng.analytics.pro.c.b.a().b(bVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, d);
        }

        public static com.umeng.analytics.pro.c a() {
            return com.umeng.analytics.pro.c.b.a.a;
        }

        public static com.umeng.analytics.pro.c a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.umeng.analytics.pro.c)) ? new com.umeng.analytics.pro.c.b.a(iBinder) : (com.umeng.analytics.pro.c) queryLocalInterface;
        }

        public static boolean a(com.umeng.analytics.pro.c cVar) {
            if (com.umeng.analytics.pro.c.b.a.a != null || cVar == null) {
                return false;
            }
            com.umeng.analytics.pro.c.b.a.a = cVar;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface(d);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(d);
                a(com.umeng.analytics.pro.b.AbstractBinderC0513b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(d);
                return true;
            }
            parcel.enforceInterface(d);
            b(com.umeng.analytics.pro.b.AbstractBinderC0513b.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException;

    void a(com.umeng.analytics.pro.b bVar) throws android.os.RemoteException;

    void b(com.umeng.analytics.pro.b bVar) throws android.os.RemoteException;
}
