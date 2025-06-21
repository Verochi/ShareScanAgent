package com.alimm.tanx.ui.image.glide.manager;

/* loaded from: classes.dex */
class ActivityFragmentLifecycle implements com.alimm.tanx.ui.image.glide.manager.Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final java.util.Set<com.alimm.tanx.ui.image.glide.manager.LifecycleListener> lifecycleListeners = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());

    @Override // com.alimm.tanx.ui.image.glide.manager.Lifecycle
    public void addListener(com.alimm.tanx.ui.image.glide.manager.LifecycleListener lifecycleListener) {
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
        java.util.Iterator it = com.alimm.tanx.ui.image.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.alimm.tanx.ui.image.glide.manager.LifecycleListener) it.next()).onDestroy();
        }
    }

    public void onStart() {
        this.isStarted = true;
        java.util.Iterator it = com.alimm.tanx.ui.image.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.alimm.tanx.ui.image.glide.manager.LifecycleListener) it.next()).onStart();
        }
    }

    public void onStop() {
        this.isStarted = false;
        java.util.Iterator it = com.alimm.tanx.ui.image.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.alimm.tanx.ui.image.glide.manager.LifecycleListener) it.next()).onStop();
        }
    }
}
