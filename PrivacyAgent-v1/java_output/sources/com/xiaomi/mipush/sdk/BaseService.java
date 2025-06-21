package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public abstract class BaseService extends android.app.Service {
    private com.xiaomi.mipush.sdk.BaseService.a a;

    public static class a extends android.os.Handler {
        private java.lang.ref.WeakReference<com.xiaomi.mipush.sdk.BaseService> a;

        public a(java.lang.ref.WeakReference<com.xiaomi.mipush.sdk.BaseService> weakReference) {
            this.a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.ref.WeakReference<com.xiaomi.mipush.sdk.BaseService> weakReference;
            com.xiaomi.mipush.sdk.BaseService baseService;
            if (message.what != 1001 || (weakReference = this.a) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler " + baseService.toString() + " kill self");
            if (!baseService.mo104a()) {
                baseService.stopSelf();
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000L);
            }
        }
    }

    /* renamed from: a */
    public abstract boolean mo104a();

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(android.content.Intent intent, int i) {
        super.onStart(intent, i);
        if (this.a == null) {
            this.a = new com.xiaomi.mipush.sdk.BaseService.a(new java.lang.ref.WeakReference(this));
        }
        this.a.a();
    }
}
