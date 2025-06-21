package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public interface MainThreadSupport {

    public static class AndroidHandlerMainThreadSupport implements org.greenrobot.eventbus.MainThreadSupport {
        public final android.os.Looper a;

        public AndroidHandlerMainThreadSupport(android.os.Looper looper) {
            this.a = looper;
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public org.greenrobot.eventbus.Poster createPoster(org.greenrobot.eventbus.EventBus eventBus) {
            return new org.greenrobot.eventbus.HandlerPoster(eventBus, this.a, 10);
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public boolean isMainThread() {
            return this.a == android.os.Looper.myLooper();
        }
    }

    org.greenrobot.eventbus.Poster createPoster(org.greenrobot.eventbus.EventBus eventBus);

    boolean isMainThread();
}
