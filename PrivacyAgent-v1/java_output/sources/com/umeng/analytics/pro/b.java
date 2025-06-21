package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public interface b extends android.os.IInterface {

    public static class a implements com.umeng.analytics.pro.b {
        @Override // com.umeng.analytics.pro.b
        public void a(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i, android.os.Bundle bundle) throws android.os.RemoteException {
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: com.umeng.analytics.pro.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0513b extends android.os.Binder implements com.umeng.analytics.pro.b {
        static final int a = 1;
        static final int b = 2;
        private static final java.lang.String c = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        /* renamed from: com.umeng.analytics.pro.b$b$a */
        public static class a implements com.umeng.analytics.pro.b {
            public static com.umeng.analytics.pro.b a;
            private android.os.IBinder b;

            public a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            public java.lang.String a() {
                return com.umeng.analytics.pro.b.AbstractBinderC0513b.c;
            }

            @Override // com.umeng.analytics.pro.b
            public void a(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.b.AbstractBinderC0513b.c);
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
                    if (this.b.transact(1, obtain, obtain2, 0) || com.umeng.analytics.pro.b.AbstractBinderC0513b.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        com.umeng.analytics.pro.b.AbstractBinderC0513b.a().a(i, j, z, f, d, str);
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

            @Override // com.umeng.analytics.pro.b
            public void a(int i, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.umeng.analytics.pro.b.AbstractBinderC0513b.c);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.b.transact(2, obtain, obtain2, 0) || com.umeng.analytics.pro.b.AbstractBinderC0513b.a() == null) {
                        obtain2.readException();
                    } else {
                        com.umeng.analytics.pro.b.AbstractBinderC0513b.a().a(i, bundle);
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
        }

        public AbstractBinderC0513b() {
            attachInterface(this, c);
        }

        public static com.umeng.analytics.pro.b a() {
            return com.umeng.analytics.pro.b.AbstractBinderC0513b.a.a;
        }

        public static com.umeng.analytics.pro.b a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(c);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.umeng.analytics.pro.b)) ? new com.umeng.analytics.pro.b.AbstractBinderC0513b.a(iBinder) : (com.umeng.analytics.pro.b) queryLocalInterface;
        }

        public static boolean a(com.umeng.analytics.pro.b bVar) {
            if (com.umeng.analytics.pro.b.AbstractBinderC0513b.a.a != null || bVar == null) {
                return false;
            }
            com.umeng.analytics.pro.b.AbstractBinderC0513b.a.a = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface(c);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(c);
                return true;
            }
            parcel.enforceInterface(c);
            a(parcel.readInt(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException;

    void a(int i, android.os.Bundle bundle) throws android.os.RemoteException;
}
