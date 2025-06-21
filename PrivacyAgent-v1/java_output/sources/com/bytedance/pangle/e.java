package com.bytedance.pangle;

/* loaded from: classes12.dex */
public interface e extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.bytedance.pangle.e {

        /* renamed from: com.bytedance.pangle.e$a$a, reason: collision with other inner class name */
        public static class C0267a implements com.bytedance.pangle.e {
            public static com.bytedance.pangle.e a;
            private android.os.IBinder b;

            public C0267a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.e
            public final android.content.ComponentName a(android.content.Intent intent, java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && com.bytedance.pangle.e.a.a() != null) {
                        return com.bytedance.pangle.e.a.a().a(intent, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (android.content.ComponentName) android.content.ComponentName.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.e
            public final void a(com.bytedance.pangle.g gVar) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    if (this.b.transact(4, obtain, obtain2, 0) || com.bytedance.pangle.e.a.a() == null) {
                        obtain2.readException();
                    } else {
                        com.bytedance.pangle.e.a.a().a(gVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.e
            public final boolean a(android.content.Intent intent, com.bytedance.pangle.g gVar, int i, java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.b.transact(3, obtain, obtain2, 0) && com.bytedance.pangle.e.a.a() != null) {
                        return com.bytedance.pangle.e.a.a().a(intent, gVar, i, str);
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

            @Override // com.bytedance.pangle.e
            public final boolean b(android.content.Intent intent, java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && com.bytedance.pangle.e.a.a() != null) {
                        return com.bytedance.pangle.e.a.a().b(intent, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static com.bytedance.pangle.e a() {
            return com.bytedance.pangle.e.a.C0267a.a;
        }

        public static com.bytedance.pangle.e a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.bytedance.pangle.e)) ? new com.bytedance.pangle.e.a.C0267a(iBinder) : (com.bytedance.pangle.e) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                android.content.ComponentName a = a(parcel.readInt() != 0 ? (android.content.Intent) android.content.Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean b = b(parcel.readInt() != 0 ? (android.content.Intent) android.content.Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean a2 = a(parcel.readInt() != 0 ? (android.content.Intent) android.content.Intent.CREATOR.createFromParcel(parcel) : null, com.bytedance.pangle.g.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            if (i != 4) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.IServiceManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
            a(com.bytedance.pangle.g.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    android.content.ComponentName a(android.content.Intent intent, java.lang.String str);

    void a(com.bytedance.pangle.g gVar);

    boolean a(android.content.Intent intent, com.bytedance.pangle.g gVar, int i, java.lang.String str);

    boolean b(android.content.Intent intent, java.lang.String str);
}
