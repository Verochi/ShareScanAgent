package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
class OppoImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.OppoImpl";
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService mService = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService();
    private java.lang.String mSign;

    public static class OppoInterface implements android.os.IInterface {
        private final android.os.IBinder mIBinder;

        public OppoInterface(android.os.IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.mIBinder;
        }

        public java.lang.String getSerID(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            java.lang.String str4 = null;
            try {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                this.mIBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str4 = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return str4;
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OppoImpl.TAG, th);
                return str4;
            }
        }
    }

    public OppoImpl(android.content.Context context) {
        this.mContext = context;
    }

    private java.lang.String getSerId(java.lang.String str, java.lang.String str2) throws java.lang.InterruptedException {
        return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OppoImpl.OppoInterface(com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.BINDER_QUEUE.take()).getSerID(str, str2, "OUID");
    }

    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    private java.lang.String realGetOUID() {
        java.lang.String packageName = this.mContext.getPackageName();
        try {
            java.lang.String str = this.mSign;
            if (str != null) {
                return getSerId(packageName, str);
            }
            byte[] digest = java.security.MessageDigest.getInstance("SHA1").digest(this.mContext.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : digest) {
                sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            java.lang.String sb2 = sb.toString();
            this.mSign = sb2;
            return getSerId(packageName, sb2);
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        java.lang.String str = null;
        try {
            android.content.Intent intent = new android.content.Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
            intent.setComponent(new android.content.ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            if (!this.mContext.bindService(intent, this.mService, 1)) {
                return null;
            }
            str = realGetOUID();
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
