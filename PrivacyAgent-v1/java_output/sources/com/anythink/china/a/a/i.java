package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public interface i extends android.os.IInterface {

    public static class a implements com.anythink.china.a.a.i {
        @Override // com.anythink.china.a.a.i
        public final java.lang.String a(java.lang.String str) {
            return null;
        }

        @Override // com.anythink.china.a.a.i
        public final boolean a() {
            return false;
        }

        @Override // android.os.IInterface
        public final android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.anythink.china.a.a.i
        public final java.lang.String b() {
            return null;
        }

        @Override // com.anythink.china.a.a.i
        public final java.lang.String b(java.lang.String str) {
            return null;
        }

        @Override // com.anythink.china.a.a.i
        public final java.lang.String c(java.lang.String str) {
            return null;
        }

        @Override // com.anythink.china.a.a.i
        public final java.lang.String d(java.lang.String str) {
            return null;
        }

        @Override // com.anythink.china.a.a.i
        public final java.lang.String e(java.lang.String str) {
            return null;
        }
    }

    public static abstract class b extends android.os.Binder implements com.anythink.china.a.a.i {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        static final int g = 7;
        private static final java.lang.String h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        public static class a implements com.anythink.china.a.a.i {
            public static com.anythink.china.a.a.i a;
            private android.os.IBinder b;

            public a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            private static java.lang.String c() {
                return com.anythink.china.a.a.i.b.h;
            }

            @Override // com.anythink.china.a.a.i
            public final java.lang.String a(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.i.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && com.anythink.china.a.a.i.b.c() != null) {
                        return com.anythink.china.a.a.i.b.c().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.anythink.china.a.a.i
            public final boolean a() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.i.b.h);
                    if (!this.b.transact(6, obtain, obtain2, 0) && com.anythink.china.a.a.i.b.c() != null) {
                        return com.anythink.china.a.a.i.b.c().a();
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

            @Override // com.anythink.china.a.a.i
            public final java.lang.String b() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.i.b.h);
                    if (!this.b.transact(7, obtain, obtain2, 0) && com.anythink.china.a.a.i.b.c() != null) {
                        return com.anythink.china.a.a.i.b.c().b();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.anythink.china.a.a.i
            public final java.lang.String b(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.i.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && com.anythink.china.a.a.i.b.c() != null) {
                        return com.anythink.china.a.a.i.b.c().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.anythink.china.a.a.i
            public final java.lang.String c(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.i.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(3, obtain, obtain2, 0) && com.anythink.china.a.a.i.b.c() != null) {
                        return com.anythink.china.a.a.i.b.c().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.anythink.china.a.a.i
            public final java.lang.String d(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.i.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(4, obtain, obtain2, 0) && com.anythink.china.a.a.i.b.c() != null) {
                        return com.anythink.china.a.a.i.b.c().d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.anythink.china.a.a.i
            public final java.lang.String e(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.anythink.china.a.a.i.b.h);
                    obtain.writeString(str);
                    if (!this.b.transact(5, obtain, obtain2, 0) && com.anythink.china.a.a.i.b.c() != null) {
                        return com.anythink.china.a.a.i.b.c().e(str);
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

        public static com.anythink.china.a.a.i a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.anythink.china.a.a.i)) ? new com.anythink.china.a.a.i.b.a(iBinder) : (com.anythink.china.a.a.i) queryLocalInterface;
        }

        private static boolean a(com.anythink.china.a.a.i iVar) {
            if (com.anythink.china.a.a.i.b.a.a != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iVar == null) {
                return false;
            }
            com.anythink.china.a.a.i.b.a.a = iVar;
            return true;
        }

        public static com.anythink.china.a.a.i c() {
            return com.anythink.china.a.a.i.b.a.a;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
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

    java.lang.String a(java.lang.String str);

    boolean a();

    java.lang.String b();

    java.lang.String b(java.lang.String str);

    java.lang.String c(java.lang.String str);

    java.lang.String d(java.lang.String str);

    java.lang.String e(java.lang.String str);
}
