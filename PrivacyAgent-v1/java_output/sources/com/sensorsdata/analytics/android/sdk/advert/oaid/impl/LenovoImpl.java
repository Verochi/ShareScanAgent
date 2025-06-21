package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
class LenovoImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.LenovoImpl";
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService mService = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService();

    public static final class LenovoInterface implements android.os.IInterface {
        private final android.os.IBinder iBinder;

        private LenovoInterface(android.os.IBinder iBinder) {
            this.iBinder = iBinder;
        }

        public /* synthetic */ LenovoInterface(android.os.IBinder iBinder, com.sensorsdata.analytics.android.sdk.advert.oaid.impl.LenovoImpl.AnonymousClass1 anonymousClass1) {
            this(iBinder);
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.iBinder;
        }

        public java.lang.String getOAID() {
            java.lang.String str = null;
            try {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                this.iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.LenovoImpl.TAG, th);
                return str;
            }
        }
    }

    public LenovoImpl(android.content.Context context) {
        this.mContext = context;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        java.lang.String str = null;
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.mContext.bindService(intent, this.mService, 1)) {
                return null;
            }
            str = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.LenovoImpl.LenovoInterface(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.BINDER_QUEUE.take(), null).getOAID();
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
