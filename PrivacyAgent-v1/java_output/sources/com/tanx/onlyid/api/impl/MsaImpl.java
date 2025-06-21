package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class MsaImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;

    /* renamed from: com.tanx.onlyid.api.impl.MsaImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.impl.OAIDService.RemoteCaller {
        public AnonymousClass1() {
        }

        @Override // com.tanx.onlyid.api.impl.OAIDService.RemoteCaller
        public java.lang.String callRemoteInterface(android.os.IBinder iBinder) throws com.tanx.onlyid.api.OAIDException, android.os.RemoteException {
            com.tanx.onlyid.core.bun.lib.MsaIdInterface asInterface = com.tanx.onlyid.core.bun.lib.MsaIdInterface.Stub.asInterface(iBinder);
            if (asInterface == null) {
                throw new com.tanx.onlyid.api.OAIDException("MsaIdInterface is null");
            }
            if (asInterface.isSupported()) {
                return asInterface.getOAID();
            }
            throw new com.tanx.onlyid.api.OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public MsaImpl(android.content.Context context) {
        this.a = context;
    }

    public final void a() {
        try {
            android.content.Intent intent = new android.content.Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            if (android.os.Build.VERSION.SDK_INT < 26) {
                this.a.startService(intent);
            } else {
                this.a.startForegroundService(intent);
            }
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
        }
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        a();
        android.content.Intent intent = new android.content.Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
        com.tanx.onlyid.api.impl.OAIDService.a(this.a, intent, iGetter, new com.tanx.onlyid.api.impl.MsaImpl.AnonymousClass1());
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.content.Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
