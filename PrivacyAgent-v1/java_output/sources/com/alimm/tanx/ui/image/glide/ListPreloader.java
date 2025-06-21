package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class ListPreloader<T> implements android.widget.AbsListView.OnScrollListener {
    private boolean isIncreasing;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider<T> preloadDimensionProvider;
    private final com.alimm.tanx.ui.image.glide.ListPreloader.PreloadModelProvider<T> preloadModelProvider;
    private final com.alimm.tanx.ui.image.glide.ListPreloader.PreloadTargetQueue preloadTargetQueue;
    private int totalItemCount;

    /* renamed from: com.alimm.tanx.ui.image.glide.ListPreloader$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.ui.image.glide.ListPreloader.PreloadModelProvider<T> {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadModelProvider
        public java.util.List<T> getPreloadItems(int i) {
            return com.alimm.tanx.ui.image.glide.ListPreloader.this.getItems(i, i + 1);
        }

        @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadModelProvider
        public com.alimm.tanx.ui.image.glide.GenericRequestBuilder getPreloadRequestBuilder(T t) {
            return com.alimm.tanx.ui.image.glide.ListPreloader.this.getRequestBuilder(t);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.glide.ListPreloader$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider<T> {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider
        public int[] getPreloadSize(T t, int i, int i2) {
            return com.alimm.tanx.ui.image.glide.ListPreloader.this.getDimensions(t);
        }
    }

    public interface PreloadModelProvider<U> {
        java.util.List<U> getPreloadItems(int i);

        com.alimm.tanx.ui.image.glide.GenericRequestBuilder getPreloadRequestBuilder(U u);
    }

    public interface PreloadSizeProvider<T> {
        int[] getPreloadSize(T t, int i, int i2);
    }

    public static class PreloadTarget extends com.alimm.tanx.ui.image.glide.request.target.BaseTarget<java.lang.Object> {
        private int photoHeight;
        private int photoWidth;

        private PreloadTarget() {
        }

        public /* synthetic */ PreloadTarget(com.alimm.tanx.ui.image.glide.ListPreloader.AnonymousClass1 anonymousClass1) {
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public void getSize(com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public void onResourceReady(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super java.lang.Object> glideAnimation) {
        }
    }

    public static final class PreloadTargetQueue {
        private final java.util.Queue<com.alimm.tanx.ui.image.glide.ListPreloader.PreloadTarget> queue;

        public PreloadTargetQueue(int i) {
            this.queue = com.alimm.tanx.ui.image.glide.util.Util.createQueue(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.queue.offer(new com.alimm.tanx.ui.image.glide.ListPreloader.PreloadTarget(null));
            }
        }

        public com.alimm.tanx.ui.image.glide.ListPreloader.PreloadTarget next(int i, int i2) {
            com.alimm.tanx.ui.image.glide.ListPreloader.PreloadTarget poll = this.queue.poll();
            this.queue.offer(poll);
            poll.photoWidth = i;
            poll.photoHeight = i2;
            return poll;
        }
    }

    @java.lang.Deprecated
    public ListPreloader(int i) {
        this.isIncreasing = true;
        this.preloadModelProvider = new com.alimm.tanx.ui.image.glide.ListPreloader.AnonymousClass1();
        this.preloadDimensionProvider = new com.alimm.tanx.ui.image.glide.ListPreloader.AnonymousClass2();
        this.maxPreload = i;
        this.preloadTargetQueue = new com.alimm.tanx.ui.image.glide.ListPreloader.PreloadTargetQueue(i + 1);
    }

    public ListPreloader(com.alimm.tanx.ui.image.glide.ListPreloader.PreloadModelProvider<T> preloadModelProvider, com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.isIncreasing = true;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i;
        this.preloadTargetQueue = new com.alimm.tanx.ui.image.glide.ListPreloader.PreloadTargetQueue(i + 1);
    }

    private void cancelAll() {
        for (int i = 0; i < this.maxPreload; i++) {
            com.alimm.tanx.ui.image.glide.Glide.clear(this.preloadTargetQueue.next(0, 0));
        }
    }

    private void preload(int i, int i2) {
        int min;
        int i3;
        if (i < i2) {
            i3 = java.lang.Math.max(this.lastEnd, i);
            min = i2;
        } else {
            min = java.lang.Math.min(this.lastStart, i);
            i3 = i2;
        }
        int min2 = java.lang.Math.min(this.totalItemCount, min);
        int min3 = java.lang.Math.min(this.totalItemCount, java.lang.Math.max(0, i3));
        if (i < i2) {
            for (int i4 = min3; i4 < min2; i4++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i4), i4, true);
            }
        } else {
            for (int i5 = min2 - 1; i5 >= min3; i5--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i5), i5, false);
            }
        }
        this.lastStart = min3;
        this.lastEnd = min2;
    }

    private void preload(int i, boolean z) {
        if (this.isIncreasing != z) {
            this.isIncreasing = z;
            cancelAll();
        }
        preload(i, (z ? this.maxPreload : -this.maxPreload) + i);
    }

    private void preloadAdapterPosition(java.util.List<T> list, int i, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                preloadItem(list.get(i2), i, i2);
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            preloadItem(list.get(i3), i, i3);
        }
    }

    private void preloadItem(T t, int i, int i2) {
        int[] preloadSize = this.preloadDimensionProvider.getPreloadSize(t, i, i2);
        if (preloadSize != null) {
            this.preloadModelProvider.getPreloadRequestBuilder(t).into((com.alimm.tanx.ui.image.glide.GenericRequestBuilder) this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
        }
    }

    @java.lang.Deprecated
    public int[] getDimensions(T t) {
        throw new java.lang.IllegalStateException("You must either provide a PreloadDimensionProvider or override getDimensions()");
    }

    @java.lang.Deprecated
    public java.util.List<T> getItems(int i, int i2) {
        throw new java.lang.IllegalStateException("You must either provide a PreloadModelProvider or override getItems()");
    }

    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder getRequestBuilder(T t) {
        throw new java.lang.IllegalStateException("You must either provide a PreloadModelProvider, or override getRequestBuilder()");
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3) {
        this.totalItemCount = i3;
        int i4 = this.lastFirstVisible;
        if (i > i4) {
            preload(i2 + i, true);
        } else if (i < i4) {
            preload(i, false);
        }
        this.lastFirstVisible = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(android.widget.AbsListView absListView, int i) {
    }
}
