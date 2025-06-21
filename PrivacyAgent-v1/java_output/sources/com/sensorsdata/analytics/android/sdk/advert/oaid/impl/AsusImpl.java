package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
class AsusImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.AsusImpl";
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService mService = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService();

    public static class AsusInterface implements android.os.IInterface {
        private final android.os.IBinder mIBinder;

        public AsusInterface(android.os.IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.mIBinder;
        }

        public java.lang.String getOAID() {
            java.lang.String str = null;
            try {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.mIBinder.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.AsusImpl.TAG, th);
                return str;
            }
        }
    }

    public AsusImpl(android.content.Context context) {
        this.mContext = context;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        java.lang.String str = null;
        try {
            android.content.Intent intent = new android.content.Intent("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new android.content.ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (!this.mContext.bindService(intent, this.mService, 1)) {
                return null;
            }
            str = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.AsusImpl.AsusInterface(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.BINDER_QUEUE.take()).getOAID();
            this.mContext.unbindService(this.mService);
            return str;
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            return str;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public boolean isSupported() {
        return true;
    }
}
