package com.bytedance.pangle;

/* loaded from: classes12.dex */
public interface d extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.bytedance.pangle.d {

        /* renamed from: com.bytedance.pangle.d$a$a, reason: collision with other inner class name */
        public static class C0266a implements com.bytedance.pangle.d {
            public static com.bytedance.pangle.d a;
            private android.os.IBinder b;

            public C0266a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.d
            public final void a(java.lang.String str, int i, java.lang.String str2) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPluginInstallListener");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (this.b.transact(1, obtain, obtain2, 0) || com.bytedance.pangle.d.a.a() == null) {
                        obtain2.readException();
                    } else {
                        com.bytedance.pangle.d.a.a().a(str, i, str2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.b;
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.pangle.IPluginInstallListener");
        }

        public static com.bytedance.pangle.d a() {
            return com.bytedance.pangle.d.a.C0266a.a;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.IPluginInstallListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPluginInstallListener");
            a(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void a(java.lang.String str, int i, java.lang.String str2);
}
