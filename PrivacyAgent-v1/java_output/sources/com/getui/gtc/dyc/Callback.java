package com.getui.gtc.dyc;

/* loaded from: classes22.dex */
public interface Callback extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.getui.gtc.dyc.Callback {

        /* renamed from: com.getui.gtc.dyc.Callback$a$a, reason: collision with other inner class name */
        public static class C0302a implements com.getui.gtc.dyc.Callback {
            public static com.getui.gtc.dyc.Callback a;
            private android.os.IBinder c;

            public C0302a(android.os.IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // com.getui.gtc.dyc.Callback
            public void a(java.util.Map map, java.util.Map map2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.getui.gtc.dyc.Callback");
                    obtain.writeMap(map);
                    obtain.writeMap(map2);
                    if (this.c.transact(1, obtain, obtain2, 0) || com.getui.gtc.dyc.Callback.a.a() == null) {
                        obtain2.readException();
                    } else {
                        com.getui.gtc.dyc.Callback.a.a().a(map, map2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.c;
            }

            @Override // com.getui.gtc.dyc.Callback
            public void b(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.getui.gtc.dyc.Callback");
                    obtain.writeString(str);
                    if (this.c.transact(2, obtain, obtain2, 0) || com.getui.gtc.dyc.Callback.a.a() == null) {
                        obtain2.readException();
                    } else {
                        com.getui.gtc.dyc.Callback.a.a().b(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.getui.gtc.dyc.Callback");
        }

        public static com.getui.gtc.dyc.Callback a() {
            return com.getui.gtc.dyc.Callback.a.C0302a.a;
        }

        public static com.getui.gtc.dyc.Callback a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.getui.gtc.dyc.Callback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.getui.gtc.dyc.Callback)) ? new com.getui.gtc.dyc.Callback.a.C0302a(iBinder) : (com.getui.gtc.dyc.Callback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.getui.gtc.dyc.Callback");
                java.lang.ClassLoader classLoader = getClass().getClassLoader();
                a(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.getui.gtc.dyc.Callback");
                    return true;
                }
                parcel.enforceInterface("com.getui.gtc.dyc.Callback");
                b(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(java.util.Map map, java.util.Map map2) throws android.os.RemoteException;

    void b(java.lang.String str) throws android.os.RemoteException;
}
