package com.alimm.tanx.ui.image.glide.manager;

/* loaded from: classes.dex */
class ApplicationLifecycle implements com.alimm.tanx.ui.image.glide.manager.Lifecycle {
    @Override // com.alimm.tanx.ui.image.glide.manager.Lifecycle
    public void addListener(com.alimm.tanx.ui.image.glide.manager.LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
