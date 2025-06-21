package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
public class CoolpadImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;

    /* renamed from: com.tanx.onlyid.api.impl.CoolpadImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.impl.OAIDService.RemoteCaller {
        public AnonymousClass1() {
        }

        @Override // com.tanx.onlyid.api.impl.OAIDService.RemoteCaller
        public java.lang.String callRemoteInterface(android.os.IBinder iBinder) throws com.tanx.onlyid.api.OAIDException, android.os.RemoteException {
            com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager asInterface = com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID(com.tanx.onlyid.api.impl.CoolpadImpl.this.a.getPackageName());
            }
            throw new com.tanx.onlyid.api.OAIDException("IDeviceIdManager is null");
        }
    }

    public CoolpadImpl(android.content.Context context) {
        if (context instanceof android.app.Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        com.tanx.onlyid.api.impl.OAIDService.a(this.a, intent, iGetter, new com.tanx.onlyid.api.impl.CoolpadImpl.AnonymousClass1());
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.content.Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
