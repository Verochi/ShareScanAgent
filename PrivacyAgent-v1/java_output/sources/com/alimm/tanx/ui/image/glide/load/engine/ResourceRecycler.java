package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
class ResourceRecycler {
    private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper(), new com.alimm.tanx.ui.image.glide.load.engine.ResourceRecycler.ResourceRecyclerCallback(null));
    private boolean isRecycling;

    public static class ResourceRecyclerCallback implements android.os.Handler.Callback {
        public static final int RECYCLE_RESOURCE = 1;

        private ResourceRecyclerCallback() {
        }

        public /* synthetic */ ResourceRecyclerCallback(com.alimm.tanx.ui.image.glide.load.engine.ResourceRecycler.AnonymousClass1 anonymousClass1) {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return false;
            }
            ((com.alimm.tanx.ui.image.glide.load.engine.Resource) message.obj).recycle();
            return true;
        }
    }

    public void recycle(com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        if (this.isRecycling) {
            this.handler.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.isRecycling = true;
        resource.recycle();
        this.isRecycling = false;
    }
}
