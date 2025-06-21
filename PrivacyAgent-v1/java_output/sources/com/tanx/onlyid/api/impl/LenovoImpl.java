package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class LenovoImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;

    /* renamed from: com.tanx.onlyid.api.impl.LenovoImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.impl.OAIDService.RemoteCaller {
        public AnonymousClass1() {
        }

        @Override // com.tanx.onlyid.api.impl.OAIDService.RemoteCaller
        public java.lang.String callRemoteInterface(android.os.IBinder iBinder) throws com.tanx.onlyid.api.OAIDException, android.os.RemoteException {
            com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface asInterface = com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface.Stub.asInterface(iBinder);
            if (asInterface == null) {
                throw new com.tanx.onlyid.api.OAIDException("IDeviceidInterface is null");
            }
            if (asInterface.isSupport()) {
                return asInterface.getOAID();
            }
            throw new com.tanx.onlyid.api.OAIDException("IDeviceidInterface#isSupport return false");
        }
    }

    public LenovoImpl(android.content.Context context) {
        this.a = context;
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        com.tanx.onlyid.api.impl.OAIDService.a(this.a, intent, iGetter, new com.tanx.onlyid.api.impl.LenovoImpl.AnonymousClass1());
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.content.Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
