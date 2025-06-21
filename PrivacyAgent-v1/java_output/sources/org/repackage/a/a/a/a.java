package org.repackage.a.a.a;

/* loaded from: classes26.dex */
public interface a extends android.os.IInterface {

    /* renamed from: org.repackage.a.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0543a extends android.os.Binder implements org.repackage.a.a.a.a {

        /* renamed from: org.repackage.a.a.a.a$a$a, reason: collision with other inner class name */
        public static class C0544a implements org.repackage.a.a.a.a {
            public android.os.IBinder a;

            public C0544a(android.os.IBinder iBinder) {
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

        public static org.repackage.a.a.a.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof org.repackage.a.a.a.a)) ? new org.repackage.a.a.a.a.AbstractBinderC0543a.C0544a(iBinder) : (org.repackage.a.a.a.a) queryLocalInterface;
        }
    }
}
