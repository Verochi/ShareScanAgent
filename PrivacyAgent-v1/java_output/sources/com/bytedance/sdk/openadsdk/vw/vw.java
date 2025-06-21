package com.bytedance.sdk.openadsdk.vw;

/* loaded from: classes22.dex */
class vw implements android.app.Application.ActivityLifecycleCallbacks {
    private static volatile boolean vw;
    private com.bytedance.sdk.openadsdk.vw.vw.InterfaceC0280vw t;
    private int wg = 0;

    /* renamed from: com.bytedance.sdk.openadsdk.vw.vw$vw, reason: collision with other inner class name */
    public interface InterfaceC0280vw {
        void vw();

        void wg();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        this.wg++;
        vw = false;
        com.bytedance.sdk.openadsdk.vw.vw.InterfaceC0280vw interfaceC0280vw = this.t;
        if (interfaceC0280vw != null) {
            interfaceC0280vw.wg();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        int i = this.wg - 1;
        this.wg = i;
        if (i == 0) {
            vw = true;
            com.bytedance.sdk.openadsdk.vw.vw.InterfaceC0280vw interfaceC0280vw = this.t;
            if (interfaceC0280vw != null) {
                interfaceC0280vw.vw();
            }
        }
    }

    public java.lang.Boolean vw() {
        return java.lang.Boolean.valueOf(vw);
    }

    public void vw(com.bytedance.sdk.openadsdk.vw.vw.InterfaceC0280vw interfaceC0280vw) {
        this.t = interfaceC0280vw;
    }
}
