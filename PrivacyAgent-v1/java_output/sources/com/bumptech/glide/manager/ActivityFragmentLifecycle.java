package com.bumptech.glide.manager;

/* loaded from: classes.dex */
class ActivityFragmentLifecycle implements com.bumptech.glide.manager.Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final java.util.Set<com.bumptech.glide.manager.LifecycleListener> lifecycleListeners = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@androidx.annotation.NonNull com.bumptech.glide.manager.LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.isDestroyed) {
            lifecycleListener.onDestroy();
        } else if (this.isStarted) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    public void onDestroy() {
        this.isDestroyed = true;
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.manager.LifecycleListener) it.next()).onDestroy();
        }
    }

    public void onStart() {
        this.isStarted = true;
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.manager.LifecycleListener) it.next()).onStart();
        }
    }

    public void onStop() {
        this.isStarted = false;
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.manager.LifecycleListener) it.next()).onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@androidx.annotation.NonNull com.bumptech.glide.manager.LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }
}
