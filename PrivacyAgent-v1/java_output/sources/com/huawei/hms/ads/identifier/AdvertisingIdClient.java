package com.huawei.hms.ads.identifier;

@androidx.annotation.Keep
/* loaded from: classes22.dex */
public class AdvertisingIdClient {
    private static final java.lang.String SETTINGS_AD_ID = "pps_oaid";
    private static final java.lang.String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    /* renamed from: com.huawei.hms.ads.identifier.AdvertisingIdClient$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.huawei.hms.ads.identifier.AdvertisingIdClient.requestAdvertisingIdInfo(this.a);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @androidx.annotation.Keep
    public static final class Info {
        private final java.lang.String advertisingId;
        private final boolean limitAdTrackingEnabled;

        @androidx.annotation.Keep
        public Info(java.lang.String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @androidx.annotation.Keep
        public final java.lang.String getId() {
            return this.advertisingId;
        }

        @androidx.annotation.Keep
        public final boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    @androidx.annotation.Keep
    public static com.huawei.hms.ads.identifier.AdvertisingIdClient.Info getAdvertisingIdInfo(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            try {
                java.lang.String string = android.provider.Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
                java.lang.String string2 = android.provider.Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
                if (!android.text.TextUtils.isEmpty(string) && !android.text.TextUtils.isEmpty(string2)) {
                    updateAdvertisingIdInfo(context);
                    return new com.huawei.hms.ads.identifier.AdvertisingIdClient.Info(string, java.lang.Boolean.valueOf(string2).booleanValue());
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return requestAdvertisingIdInfo(context);
    }

    @androidx.annotation.Keep
    public static boolean isAdvertisingIdAvailable(android.content.Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid");
            return !r4.queryIntentServices(r2, 0).isEmpty();
        } catch (android.content.pm.PackageManager.NameNotFoundException | java.lang.Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.huawei.hms.ads.identifier.AdvertisingIdClient.Info requestAdvertisingIdInfo(android.content.Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            com.huawei.hms.ads.identifier.a aVar = new com.huawei.hms.ads.identifier.a();
            android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (!context.bindService(intent, aVar, 1)) {
                    throw new java.io.IOException("bind failed");
                }
                try {
                    if (aVar.b) {
                        throw new java.lang.IllegalStateException();
                    }
                    aVar.b = true;
                    com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService asInterface = com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService.Stub.asInterface(aVar.c.take());
                    return new com.huawei.hms.ads.identifier.AdvertisingIdClient.Info(asInterface.getOaid(), asInterface.isOaidTrackLimited());
                } catch (android.os.RemoteException unused) {
                    throw new java.io.IOException("bind hms service RemoteException");
                } catch (java.lang.InterruptedException unused2) {
                    throw new java.io.IOException("bind hms service InterruptedException");
                }
            } finally {
                try {
                    context.unbindService(aVar);
                } catch (java.lang.Throwable th) {
                    new java.lang.StringBuilder("unbind ").append(th.getClass().getSimpleName());
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused3) {
            throw new java.io.IOException("Service not found");
        }
    }

    private static void updateAdvertisingIdInfo(android.content.Context context) {
        com.huawei.hms.ads.identifier.b.a.execute(new com.huawei.hms.ads.identifier.AdvertisingIdClient.AnonymousClass1(context));
    }

    @androidx.annotation.Keep
    public static boolean verifyAdId(android.content.Context context, java.lang.String str, boolean z) {
        com.huawei.hms.ads.identifier.AdvertisingIdClient.Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
        if (requestAdvertisingIdInfo != null && android.text.TextUtils.equals(str, requestAdvertisingIdInfo.getId())) {
            if (z == requestAdvertisingIdInfo.isLimitAdTrackingEnabled()) {
                return true;
            }
        }
        return false;
    }
}
