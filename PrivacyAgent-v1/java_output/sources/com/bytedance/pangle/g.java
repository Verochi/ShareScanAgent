package com.bytedance.pangle;

/* loaded from: classes12.dex */
public interface g extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.bytedance.pangle.g {

        /* renamed from: com.bytedance.pangle.g$a$a, reason: collision with other inner class name */
        public static class C0268a implements com.bytedance.pangle.g {
            public static com.bytedance.pangle.g a;
            private android.os.IBinder b;

            public C0268a(android.os.IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.g
            public final int a() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.b.transact(2, obtain, obtain2, 0) && com.bytedance.pangle.g.a.b() != null) {
                        return com.bytedance.pangle.g.a.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.g
            public final void a(android.content.ComponentName componentName, android.os.IBinder iBinder) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.b.transact(1, obtain, obtain2, 0) || com.bytedance.pangle.g.a.b() == null) {
                        obtain2.readException();
                    } else {
                        com.bytedance.pangle.g.a.b().a(componentName, iBinder);
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
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static com.bytedance.pangle.g a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.bytedance.pangle.g)) ? new com.bytedance.pangle.g.a.C0268a(iBinder) : (com.bytedance.pangle.g) queryLocalInterface;
        }

        public static com.bytedance.pangle.g b() {
            return com.bytedance.pangle.g.a.C0268a.a;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                a(parcel.readInt() != 0 ? (android.content.ComponentName) android.content.ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
            int a = a();
            parcel2.writeNoException();
            parcel2.writeInt(a);
            return true;
        }
    }

    int a();

    void a(android.content.ComponentName componentName, android.os.IBinder iBinder);
}
