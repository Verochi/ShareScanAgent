package com.bumptech.glide.manager;

/* loaded from: classes.dex */
class ApplicationLifecycle implements com.bumptech.glide.manager.Lifecycle {
    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@androidx.annotation.NonNull com.bumptech.glide.manager.LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@androidx.annotation.NonNull com.bumptech.glide.manager.LifecycleListener lifecycleListener) {
    }
}
