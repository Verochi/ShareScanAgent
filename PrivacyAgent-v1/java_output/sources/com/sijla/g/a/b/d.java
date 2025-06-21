package com.sijla.g.a.b;

/* loaded from: classes19.dex */
public interface d extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.sijla.g.a.b.e {

        /* renamed from: com.sijla.g.a.b.d$a$a, reason: collision with other inner class name */
        public static class C0451a implements com.sijla.g.a.b.e {
            private android.os.IBinder a;

            public C0451a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            public final java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        obtain.recycle();
                        obtain2.recycle();
                        return null;
                    }
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.a;
            }
        }

        public static com.sijla.g.a.b.d a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.sijla.g.a.b.d)) ? new com.sijla.g.a.b.e.a.C0452a(iBinder) : (com.sijla.g.a.b.d) queryLocalInterface;
        }
    }
}
