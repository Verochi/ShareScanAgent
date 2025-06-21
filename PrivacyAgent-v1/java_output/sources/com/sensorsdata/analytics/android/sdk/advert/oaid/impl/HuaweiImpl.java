package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
public class HuaweiImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.HuaweiImpl";
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService mService = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService();

    public static final class HuaWeiInterface implements android.os.IInterface {
        private final android.os.IBinder iBinder;

        private HuaWeiInterface(android.os.IBinder iBinder) {
            this.iBinder = iBinder;
        }

        public /* synthetic */ HuaWeiInterface(android.os.IBinder iBinder, com.sensorsdata.analytics.android.sdk.advert.oaid.impl.HuaweiImpl.AnonymousClass1 anonymousClass1) {
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
                obtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
                this.iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str;
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.HuaweiImpl.TAG, th);
                return str;
            }
        }
    }

    public HuaweiImpl(android.content.Context context) {
        this.mContext = context;
    }

    private java.lang.String realLoadOaid(java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(str);
            return this.mContext.bindService(intent, this.mService, 1) ? new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.HuaweiImpl.HuaWeiInterface(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.BINDER_QUEUE.take(), null).getOAID() : "";
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            return "";
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            try {
                java.lang.String string = android.provider.Settings.Global.getString(this.mContext.getContentResolver(), "pps_oaid");
                if (!android.text.TextUtils.isEmpty(string)) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Get oaid from global settings");
                    return string;
                }
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            }
        }
        java.lang.String[] strArr = {"com.huawei.hwid", "com.huawei.hwid.tv", com.huawei.hms.common.PackageConstants.SERVICES_PACKAGE_ALL_SCENE};
        java.lang.String str = null;
        for (int i = 0; i < 3; i++) {
            java.lang.String str2 = strArr[i];
            if (android.text.TextUtils.isEmpty(str)) {
                str = realLoadOaid(str2);
            }
        }
        return str;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public boolean isSupported() {
        return true;
    }
}
