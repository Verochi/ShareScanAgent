package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
class bd implements com.umeng.analytics.pro.az {
    private static java.lang.String a = "";

    public static final class a implements android.content.ServiceConnection {
        boolean a;
        private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b;

        private a() {
            this.a = false;
            this.b = new java.util.concurrent.LinkedBlockingQueue<>();
        }

        public /* synthetic */ a(com.umeng.analytics.pro.bd.AnonymousClass1 anonymousClass1) {
            this();
        }

        public android.os.IBinder a() throws java.lang.InterruptedException {
            if (this.a) {
                throw new java.lang.IllegalStateException();
            }
            this.a = true;
            return this.b.poll(5L, java.util.concurrent.TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (java.lang.InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public static final class b extends com.umeng.analytics.pro.b.AbstractBinderC0513b {
        private b() {
        }

        public /* synthetic */ b(com.umeng.analytics.pro.bd.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i, android.os.Bundle bundle) throws android.os.RemoteException {
            if (i != 0 || bundle == null) {
                return;
            }
            java.lang.String unused = com.umeng.analytics.pro.bd.a = bundle.getString("oa_id_flag");
        }
    }

    public interface c {
        public static final int a = 0;
        public static final java.lang.String b = "oa_id_flag";
    }

    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        com.umeng.analytics.pro.bd.a aVar = new com.umeng.analytics.pro.bd.a(null);
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        if (context.bindService(intent, aVar, 1)) {
            try {
                com.umeng.analytics.pro.c.b.a(aVar.a()).a(new com.umeng.analytics.pro.bd.b(null));
                return a;
            } catch (java.lang.Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
