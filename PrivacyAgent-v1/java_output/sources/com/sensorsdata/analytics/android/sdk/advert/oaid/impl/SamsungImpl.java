package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
class SamsungImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.SamsungImpl";
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService mService = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService();

    public static class SamsungInterface implements android.os.IInterface {
        private final android.os.IBinder mIBinder;

        public SamsungInterface(android.os.IBinder iBinder) {
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
                obtain.writeInterfaceToken(com.alipay.sdk.m.k0.a.AbstractBinderC0035a.a);
                this.mIBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return str;
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.SamsungImpl.TAG, th);
                return str;
            }
        }
    }

    public SamsungImpl(android.content.Context context) {
        this.mContext = context;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        java.lang.String str = null;
        try {
            if (!this.mContext.bindService(intent, this.mService, 1)) {
                return null;
            }
            str = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.SamsungImpl.SamsungInterface(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.BINDER_QUEUE.take()).getOAID();
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
