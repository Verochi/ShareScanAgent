package com.sijla.g.a.b;

/* loaded from: classes19.dex */
public interface g extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.sijla.g.a.b.g {

        /* renamed from: com.sijla.g.a.b.g$a$a, reason: collision with other inner class name */
        public static class C0453a implements com.sijla.g.a.b.g {
            private android.os.IBinder a;

            public C0453a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.sijla.g.a.b.g
            public final java.lang.String a() {
                java.lang.String str;
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (java.lang.Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                    str = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return str;
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return this.a;
            }
        }
    }

    java.lang.String a();
}
