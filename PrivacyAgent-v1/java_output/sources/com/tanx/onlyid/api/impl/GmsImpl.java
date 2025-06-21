package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class GmsImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;

    /* renamed from: com.tanx.onlyid.api.impl.GmsImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.impl.OAIDService.RemoteCaller {
        public AnonymousClass1() {
        }

        @Override // com.tanx.onlyid.api.impl.OAIDService.RemoteCaller
        public java.lang.String callRemoteInterface(android.os.IBinder iBinder) throws com.tanx.onlyid.api.OAIDException, android.os.RemoteException {
            com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService asInterface = com.tanx.onlyid.core.google.android.gms.ads.identifier.internal.IAdvertisingIdService.Stub.asInterface(iBinder);
            if (asInterface.isLimitAdTrackingEnabled(true)) {
                com.tanx.onlyid.api.OAIDLog.print("User has disabled advertising identifier");
            }
            return asInterface.getId();
        }
    }

    public GmsImpl(android.content.Context context) {
        this.a = context;
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        com.tanx.onlyid.api.impl.OAIDService.a(this.a, intent, iGetter, new com.tanx.onlyid.api.impl.GmsImpl.AnonymousClass1());
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.content.Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
