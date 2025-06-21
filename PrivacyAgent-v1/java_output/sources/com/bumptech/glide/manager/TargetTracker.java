package com.bumptech.glide.manager;

/* loaded from: classes.dex */
public final class TargetTracker implements com.bumptech.glide.manager.LifecycleListener {
    private final java.util.Set<com.bumptech.glide.request.target.Target<?>> targets = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());

    public void clear() {
        this.targets.clear();
    }

    @androidx.annotation.NonNull
    public java.util.List<com.bumptech.glide.request.target.Target<?>> getAll() {
        return com.bumptech.glide.util.Util.getSnapshot(this.targets);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.targets).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.Target) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.targets).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.Target) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.targets).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.Target) it.next()).onStop();
        }
    }

    public void track(@androidx.annotation.NonNull com.bumptech.glide.request.target.Target<?> target) {
        this.targets.add(target);
    }

    public void untrack(@androidx.annotation.NonNull com.bumptech.glide.request.target.Target<?> target) {
        this.targets.remove(target);
    }
}
