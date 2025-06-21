package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class HuaweiImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;
    public java.lang.String b;

    /* renamed from: com.tanx.onlyid.api.impl.HuaweiImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.impl.OAIDService.RemoteCaller {
        public AnonymousClass1() {
        }

        @Override // com.tanx.onlyid.api.impl.OAIDService.RemoteCaller
        public java.lang.String callRemoteInterface(android.os.IBinder iBinder) throws com.tanx.onlyid.api.OAIDException, android.os.RemoteException {
            com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService asInterface = com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (asInterface.isOaidTrackLimited()) {
                throw new com.tanx.onlyid.api.OAIDException("User has disabled advertising identifier");
            }
            return asInterface.getOaid();
        }
    }

    public HuaweiImpl(android.content.Context context) {
        this.a = context;
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        android.content.Context context = this.a;
        if (context == null || iGetter == null) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            try {
                java.lang.String string = android.provider.Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!android.text.TextUtils.isEmpty(string)) {
                    com.tanx.onlyid.api.OAIDLog.print("Get oaid from global settings: " + string);
                    iGetter.oaidSucc(string);
                    return;
                }
            } catch (java.lang.Exception e) {
                com.tanx.onlyid.api.OAIDLog.print(e);
            }
        }
        if (android.text.TextUtils.isEmpty(this.b) && !supported()) {
            iGetter.oaidError(new com.tanx.onlyid.api.OAIDException("Huawei Advertising ID not available"));
            return;
        }
        android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        com.tanx.onlyid.api.impl.OAIDService.a(this.a, intent, iGetter, new com.tanx.onlyid.api.impl.HuaweiImpl.AnonymousClass1());
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.content.Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
            } else {
                this.b = com.huawei.hms.common.PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
                if (packageManager.getPackageInfo(com.huawei.hms.common.PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
