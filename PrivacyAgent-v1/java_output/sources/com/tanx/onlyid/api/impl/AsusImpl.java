package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class AsusImpl implements com.tanx.onlyid.api.IOAID {
    public final android.content.Context a;

    /* renamed from: com.tanx.onlyid.api.impl.AsusImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.impl.OAIDService.RemoteCaller {
        public AnonymousClass1() {
        }

        @Override // com.tanx.onlyid.api.impl.OAIDService.RemoteCaller
        public java.lang.String callRemoteInterface(android.os.IBinder iBinder) throws com.tanx.onlyid.api.OAIDException, android.os.RemoteException {
            com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface asInterface = com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface.Stub.asInterface(iBinder);
            if (asInterface == null) {
                throw new com.tanx.onlyid.api.OAIDException("IDidAidlInterface is null");
            }
            if (asInterface.isSupport()) {
                return asInterface.getOAID();
            }
            throw new com.tanx.onlyid.api.OAIDException("IDidAidlInterface#isSupport return false");
        }
    }

    public AsusImpl(android.content.Context context) {
        this.a = context;
    }

    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (this.a == null || iGetter == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new android.content.ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        com.tanx.onlyid.api.impl.OAIDService.a(this.a, intent, iGetter, new com.tanx.onlyid.api.impl.AsusImpl.AnonymousClass1());
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        android.content.Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return false;
        }
    }
}
