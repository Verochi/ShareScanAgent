package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public interface e extends android.os.IInterface {

    public static class a implements com.anythink.china.a.a.e {
        @Override // com.anythink.china.a.a.e
        public final java.lang.String a(java.lang.String str) {
            return null;
        }

        @Override // com.anythink.china.a.a.e
        public final boolean a() {
            return false;
        }

        @Override // android.os.IInterface
        public final android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.anythink.china.a.a.e
        public final java.lang.String b() {
            return null;
        }

        @Override // com.anythink.china.a.a.e
        public final java.lang.String b(java.lang.String str) {
            return null;
        }

        @Override // com.anythink.china.a.a.e
        public final java.lang.String c() {
            return null;
        }
    }

    public static abstract class b extends android.os.Binder implements com.anythink.china.a.a.e {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        private static final java.lang.String f = "com.android.creator.FreemeIdsSupplier";

        public static class a implements com.anythink.china.a.a.e {
            public static com.anythink.china.a.a.e a;
            private android.os.IBinder b;

            public a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            private static java.lang.String d() {
                return com.anythink.china.a.a.e.b.f;
            }

            @Override // com.anythink.china.a.a.e
            public final java.lang.String a(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.e.b.f);
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && com.anythink.china.a.a.e.b.d() != null) {
                        return com.anythink.china.a.a.e.b.d().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.anythink.china.a.a.e
            public final boolean a() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.e.b.f);
                    if (!this.b.transact(1, obtain, obtain2, 0) && com.anythink.china.a.a.e.b.d() != null) {
                        return com.anythink.china.a.a.e.b.d().a();
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

            @Override // com.anythink.china.a.a.e
            public final java.lang.String b() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.e.b.f);
                    if (!this.b.transact(3, obtain, obtain2, 0) && com.anythink.china.a.a.e.b.d() != null) {
                        return com.anythink.china.a.a.e.b.d().b();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.anythink.china.a.a.e
            public final java.lang.String b(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.e.b.f);
                    obtain.writeString(str);
                    if (!this.b.transact(5, obtain, obtain2, 0) && com.anythink.china.a.a.e.b.d() != null) {
                        return com.anythink.china.a.a.e.b.d().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.anythink.china.a.a.e
            public final java.lang.String c() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.e.b.f);
                    if (!this.b.transact(4, obtain, obtain2, 0) && com.anythink.china.a.a.e.b.d() != null) {
                        return com.anythink.china.a.a.e.b.d().c();
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
            attachInterface(this, f);
        }

        public static com.anythink.china.a.a.e a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(f);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.anythink.china.a.a.e)) ? new com.anythink.china.a.a.e.b.a(iBinder) : (com.anythink.china.a.a.e) queryLocalInterface;
        }

        private static boolean a(com.anythink.china.a.a.e eVar) {
            if (com.anythink.china.a.a.e.b.a.a != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (eVar == null) {
                return false;
            }
            com.anythink.china.a.a.e.b.a.a = eVar;
            return true;
        }

        public static com.anythink.china.a.a.e d() {
            return com.anythink.china.a.a.e.b.a.a;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(f);
                boolean a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(f);
                java.lang.String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(f);
                java.lang.String b2 = b();
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(f);
                java.lang.String c2 = c();
                parcel2.writeNoException();
                parcel2.writeString(c2);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f);
                return true;
            }
            parcel.enforceInterface(f);
            java.lang.String b3 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b3);
            return true;
        }
    }

    java.lang.String a(java.lang.String str);

    boolean a();

    java.lang.String b();

    java.lang.String b(java.lang.String str);

    java.lang.String c();
}
