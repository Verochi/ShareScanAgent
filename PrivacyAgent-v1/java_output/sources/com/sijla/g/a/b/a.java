package com.sijla.g.a.b;

/* loaded from: classes19.dex */
public interface a extends android.os.IInterface {

    /* renamed from: com.sijla.g.a.b.a$a, reason: collision with other inner class name */
    public static final class C0449a implements com.sijla.g.a.b.a {
        private android.os.IBinder a;

        public C0449a(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        public final java.lang.String a() {
            java.lang.String str;
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (java.lang.Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }

        @Override // android.os.IInterface
        public final android.os.IBinder asBinder() {
            return this.a;
        }
    }
}
