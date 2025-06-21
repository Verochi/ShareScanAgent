package com.bytedance.pangle;

/* loaded from: classes12.dex */
public interface c extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.bytedance.pangle.c {

        /* renamed from: com.bytedance.pangle.c$a$a, reason: collision with other inner class name */
        public static class C0265a implements com.bytedance.pangle.c {
            public static com.bytedance.pangle.c a;
            private android.os.IBinder b;

            public C0265a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.c
            public final void a(int i) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i);
                    if (this.b.transact(5, obtain, obtain2, 0) || com.bytedance.pangle.c.a.a() == null) {
                        obtain2.readException();
                    } else {
                        com.bytedance.pangle.c.a.a().a(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final void a(int i, com.bytedance.pangle.d dVar) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (this.b.transact(4, obtain, obtain2, 0) || com.bytedance.pangle.c.a.a() == null) {
                        obtain2.readException();
                    } else {
                        com.bytedance.pangle.c.a.a().a(i, dVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && com.bytedance.pangle.c.a.a() != null) {
                        return com.bytedance.pangle.c.a.a().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(java.lang.String str, java.lang.String str2) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.b.transact(3, obtain, obtain2, 0) && com.bytedance.pangle.c.a.a() != null) {
                        return com.bytedance.pangle.c.a.a().a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.b;
            }

            @Override // com.bytedance.pangle.c
            public final int b(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && com.bytedance.pangle.c.a.a() != null) {
                        return com.bytedance.pangle.c.a.a().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static com.bytedance.pangle.c a() {
            return com.bytedance.pangle.c.a.C0265a.a;
        }

        public static com.bytedance.pangle.c a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.bytedance.pangle.c)) ? new com.bytedance.pangle.c.a.C0265a(iBinder) : (com.bytedance.pangle.c) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            com.bytedance.pangle.d c0266a;
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int b = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a2 = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            if (i != 4) {
                if (i != 5) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                }
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            int readInt = parcel.readInt();
            android.os.IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                c0266a = null;
            } else {
                android.os.IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
                c0266a = (queryLocalInterface == null || !(queryLocalInterface instanceof com.bytedance.pangle.d)) ? new com.bytedance.pangle.d.a.C0266a(readStrongBinder) : (com.bytedance.pangle.d) queryLocalInterface;
            }
            a(readInt, c0266a);
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i);

    void a(int i, com.bytedance.pangle.d dVar);

    boolean a(java.lang.String str);

    boolean a(java.lang.String str, java.lang.String str2);

    int b(java.lang.String str);
}
