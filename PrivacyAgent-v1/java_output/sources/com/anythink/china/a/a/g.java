package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public interface g extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.anythink.china.a.a.g {
        static final int a = 1;
        static final int b = 2;
        private static final java.lang.String c = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

        /* renamed from: com.anythink.china.a.a.g$a$a, reason: collision with other inner class name */
        public static class C0152a implements com.anythink.china.a.a.g {
            private android.os.IBinder a;

            public C0152a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            private static java.lang.String c() {
                return "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            }

            @Override // com.anythink.china.a.a.g
            public final java.lang.String a() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.a;
            }

            @Override // com.anythink.china.a.a.g
            public final boolean b() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        public static com.anythink.china.a.a.g a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.anythink.china.a.a.g)) ? new com.anythink.china.a.a.g.a.C0152a(iBinder) : (com.anythink.china.a.a.g) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                java.lang.String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean b2 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b2 ? 1 : 0);
            return true;
        }
    }

    java.lang.String a();

    boolean b();
}
