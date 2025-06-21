package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
public class ZTEImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String ID_PACKAGE = "com.mdid.msa";
    private static final java.lang.String TAG = "SA.ZTEImpl";
    private static final java.lang.String ZTE_MANAGER = "android.app.ZteDeviceIdentifyManager";
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService mService = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService();

    public static class ZTEInterface implements android.os.IInterface {
        private final android.os.IBinder mIBinder;

        public ZTEInterface(android.os.IBinder iBinder) {
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
                obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                this.mIBinder.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.ZTEImpl.TAG, th);
                return str;
            }
        }
    }

    public ZTEImpl(android.content.Context context) {
        this.mContext = context;
    }

    private java.lang.String getOAID29(android.content.Context context) {
        android.content.Intent intent;
        java.lang.String str = null;
        try {
            java.lang.String packageName = context.getPackageName();
            startMsaklServer(packageName, context);
            intent = new android.content.Intent();
            intent.setClassName(ID_PACKAGE, "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", packageName);
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
        }
        if (!context.bindService(intent, this.mService, 1)) {
            return null;
        }
        str = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.ZTEImpl.ZTEInterface(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.BINDER_QUEUE.take()).getOAID();
        try {
            context.unbindService(this.mService);
        } catch (java.lang.Throwable th2) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th2);
        }
        return str;
    }

    @android.annotation.SuppressLint({"PrivateApi"})
    private static java.lang.String getOAID30(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(ZTE_MANAGER);
            java.lang.reflect.Constructor<?> declaredConstructor = cls.getDeclaredConstructor(android.content.Context.class);
            if (declaredConstructor == null) {
                return null;
            }
            return (java.lang.String) cls.getDeclaredMethod("getOAID", android.content.Context.class).invoke(declaredConstructor.newInstance(context), context);
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            return null;
        }
    }

    private static void startMsaklServer(java.lang.String str, android.content.Context context) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(ID_PACKAGE, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
        }
    }

    public java.lang.String bindZTEServiceGetOAID(android.content.Context context) {
        return android.os.Build.VERSION.SDK_INT <= 29 ? getOAID29(context) : getOAID30(context);
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        return bindZTEServiceGetOAID(this.mContext);
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public boolean isSupported() {
        return true;
    }
}
