package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
public class CoolpadImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.CoolpadImpl";
    private final android.content.Context context;
    private final com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService service = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService();

    public static class CoolpadInterface implements android.os.IInterface {
        private final android.os.IBinder mIBinder;

        public CoolpadInterface(android.os.IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.mIBinder;
        }

        public java.lang.String getOAID(java.lang.String str) {
            java.lang.String str2 = null;
            try {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                obtain.writeString(str);
                this.mIBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                str2 = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str2;
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.CoolpadImpl.TAG, th);
                return str2;
            }
        }
    }

    public CoolpadImpl(android.content.Context context) {
        this.context = context;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        java.lang.String str = null;
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setComponent(new android.content.ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            if (!this.context.bindService(intent, this.service, 1)) {
                return null;
            }
            str = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.CoolpadImpl.CoolpadInterface(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.BINDER_QUEUE.take()).getOAID(this.context.getPackageName());
            this.context.unbindService(this.service);
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
