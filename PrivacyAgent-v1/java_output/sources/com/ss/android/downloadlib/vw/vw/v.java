package com.ss.android.downloadlib.vw.vw;

/* loaded from: classes19.dex */
public interface v extends android.os.IInterface {

    public static abstract class vw extends android.os.Binder implements com.ss.android.downloadlib.vw.vw.v {
        private static java.lang.String vw = "";

        /* renamed from: com.ss.android.downloadlib.vw.vw.v$vw$vw, reason: collision with other inner class name */
        public static class C0477vw implements com.ss.android.downloadlib.vw.vw.v {
            private android.os.IBinder vw;

            public C0477vw(android.os.IBinder iBinder) {
                if (android.text.TextUtils.isEmpty(com.ss.android.downloadlib.vw.vw.v.vw.vw)) {
                    org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
                    java.lang.String unused = com.ss.android.downloadlib.vw.vw.v.vw.vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("t"), x.optString("s"));
                }
                this.vw = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.vw;
            }

            @Override // com.ss.android.downloadlib.vw.vw.v
            public void vw(com.ss.android.downloadlib.vw.vw.wg wgVar) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.downloadlib.vw.vw.v.vw.vw);
                    if (wgVar != null) {
                        obtain.writeInt(1);
                        wgVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.vw.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static com.ss.android.downloadlib.vw.vw.v vw(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(vw);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.downloadlib.vw.vw.v)) ? new com.ss.android.downloadlib.vw.vw.v.vw.C0477vw(iBinder) : (com.ss.android.downloadlib.vw.vw.v) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface(vw);
                vw(parcel.readInt() != 0 ? com.ss.android.downloadlib.vw.vw.wg.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(vw);
            return true;
        }
    }

    void vw(com.ss.android.downloadlib.vw.vw.wg wgVar) throws android.os.RemoteException;
}
