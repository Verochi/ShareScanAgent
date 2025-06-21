package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public interface m extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.anythink.china.a.a.m {

        /* renamed from: com.anythink.china.a.a.m$a$a, reason: collision with other inner class name */
        public static class C0153a implements com.anythink.china.a.a.m {
            public android.os.IBinder a;

            public C0153a(android.os.IBinder iBinder) {
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

        public static com.anythink.china.a.a.m a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof com.anythink.china.a.a.m)) ? new com.anythink.china.a.a.m.a.C0153a(iBinder) : (com.anythink.china.a.a.m) queryLocalInterface;
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }
    }
}
