package com.heytap.openid;

/* loaded from: classes22.dex */
public interface o_a extends android.os.IInterface {

    /* renamed from: com.heytap.openid.o_a$o_a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0358o_a extends android.os.Binder implements com.heytap.openid.o_a {

        /* renamed from: com.heytap.openid.o_a$o_a$o_a, reason: collision with other inner class name */
        public static class C0359o_a implements com.heytap.openid.o_a {
            public android.os.IBinder a;

            public C0359o_a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }
        }

        public static com.heytap.openid.o_a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.heytap.openid.o_a)) ? new com.heytap.openid.o_a.AbstractBinderC0358o_a.C0359o_a(iBinder) : (com.heytap.openid.o_a) queryLocalInterface;
        }
    }
}
