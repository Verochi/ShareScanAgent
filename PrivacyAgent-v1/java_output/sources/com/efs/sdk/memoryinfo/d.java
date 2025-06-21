package com.efs.sdk.memoryinfo;

import com.efs.sdk.memoryinfo.b.AnonymousClass1;

/* loaded from: classes22.dex */
final class d implements com.efs.sdk.memoryinfo.UMMemoryMonitorApi {
    private boolean A;
    private boolean u;
    private boolean v = true;
    private com.efs.sdk.memoryinfo.b w;
    private java.lang.ref.WeakReference<android.app.Activity> x;
    private boolean y;
    private int z;

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final java.lang.String getCurrentActivity() {
        android.app.Activity activity;
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.x;
        return (weakReference == null || (activity = weakReference.get()) == null) ? "" : activity.getClass().getName();
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isEnable() {
        com.efs.sdk.memoryinfo.b bVar;
        return this.v && (bVar = this.w) != null && bVar.b;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isForeground() {
        return this.y;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityResumed(android.app.Activity activity) {
        if (this.v) {
            this.x = new java.lang.ref.WeakReference<>(activity);
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStarted(android.app.Activity activity) {
        if (this.v && activity != null) {
            if (this.A) {
                this.A = false;
                return;
            }
            int i = this.z + 1;
            this.z = i;
            if (i == 1) {
                this.y = true;
            }
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStopped(android.app.Activity activity) {
        if (this.v && activity != null) {
            if (activity.isChangingConfigurations()) {
                this.A = true;
                return;
            }
            int i = this.z - 1;
            this.z = i;
            if (i == 0) {
                this.y = false;
            }
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void setEnable(boolean z) {
        this.v = z;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void start(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        if ((this.v || com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) && !this.u) {
            this.u = true;
            com.efs.sdk.memoryinfo.b bVar = new com.efs.sdk.memoryinfo.b(context, efsReporter);
            this.w = bVar;
            bVar.a.getAllSdkConfig(new java.lang.String[]{"apm_memperf_sampling_rate", "apm_memperf_collect_interval", "apm_memperf_collect_max_period_sec"}, bVar.new AnonymousClass1());
        }
    }
}
