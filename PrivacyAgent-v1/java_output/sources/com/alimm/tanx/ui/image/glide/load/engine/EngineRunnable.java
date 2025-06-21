package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
class EngineRunnable implements java.lang.Runnable, com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized {
    private static final java.lang.String TAG = "EngineRunnable";
    private final com.alimm.tanx.ui.image.glide.load.engine.DecodeJob<?, ?, ?> decodeJob;
    private volatile boolean isCancelled;
    private final com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.EngineRunnableManager manager;
    private final com.alimm.tanx.ui.image.glide.Priority priority;
    private com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.Stage stage = com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.Stage.CACHE;

    public interface EngineRunnableManager extends com.alimm.tanx.ui.image.glide.request.ResourceCallback {
        void submitForSource(com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable engineRunnable);
    }

    public enum Stage {
        CACHE,
        SOURCE
    }

    public EngineRunnable(com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.EngineRunnableManager engineRunnableManager, com.alimm.tanx.ui.image.glide.load.engine.DecodeJob<?, ?, ?> decodeJob, com.alimm.tanx.ui.image.glide.Priority priority) {
        this.manager = engineRunnableManager;
        this.decodeJob = decodeJob;
        this.priority = priority;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<?> decode() throws java.lang.Exception {
        return isDecodingFromCache() ? decodeFromCache() : decodeFromSource();
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<?> decodeFromCache() throws java.lang.Exception {
        com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource;
        try {
            resource = this.decodeJob.decodeResultFromCache();
        } catch (java.lang.Exception e) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Exception decoding result from cache: ");
                sb.append(e);
            }
            resource = null;
        }
        return resource == null ? this.decodeJob.decodeSourceFromCache() : resource;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.Resource<?> decodeFromSource() throws java.lang.Exception {
        return this.decodeJob.decodeFromSource();
    }

    private boolean isDecodingFromCache() {
        return this.stage == com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.Stage.CACHE;
    }

    private void onLoadComplete(com.alimm.tanx.ui.image.glide.load.engine.Resource resource) {
        this.manager.onResourceReady(resource);
    }

    private void onLoadFailed(java.lang.Exception exc) {
        if (!isDecodingFromCache()) {
            this.manager.onException(exc);
        } else {
            this.stage = com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.Stage.SOURCE;
            this.manager.submitForSource(this);
        }
    }

    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized
    public int getPriority() {
        return this.priority.ordinal();
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.Exception e;
        if (this.isCancelled) {
            return;
        }
        com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource = null;
        try {
            e = null;
            resource = decode();
        } catch (java.lang.Exception e2) {
            e = e2;
        } catch (java.lang.OutOfMemoryError e3) {
            e = new com.alimm.tanx.ui.image.glide.load.engine.ErrorWrappingGlideException(e3);
        }
        if (this.isCancelled) {
            if (resource != null) {
                resource.recycle();
            }
        } else if (resource == null) {
            onLoadFailed(e);
        } else {
            this.manager.onResourceReady(resource);
        }
    }
}
