package com.bumptech.glide;

/* loaded from: classes.dex */
public class ListPreloader<T> implements android.widget.AbsListView.OnScrollListener {
    private int lastEnd;
    private int lastStart;
    private final int maxPreload;
    private final com.bumptech.glide.ListPreloader.PreloadSizeProvider<T> preloadDimensionProvider;
    private final com.bumptech.glide.ListPreloader.PreloadModelProvider<T> preloadModelProvider;
    private final com.bumptech.glide.ListPreloader.PreloadTargetQueue preloadTargetQueue;
    private final com.bumptech.glide.RequestManager requestManager;
    private int totalItemCount;
    private int lastFirstVisible = -1;
    private boolean isIncreasing = true;

    public interface PreloadModelProvider<U> {
        @androidx.annotation.NonNull
        java.util.List<U> getPreloadItems(int i);

        @androidx.annotation.Nullable
        com.bumptech.glide.RequestBuilder<?> getPreloadRequestBuilder(@androidx.annotation.NonNull U u);
    }

    public interface PreloadSizeProvider<T> {
        @androidx.annotation.Nullable
        int[] getPreloadSize(@androidx.annotation.NonNull T t, int i, int i2);
    }

    public static final class PreloadTarget implements com.bumptech.glide.request.target.Target<java.lang.Object> {
        int photoHeight;
        int photoWidth;

        @androidx.annotation.Nullable
        private com.bumptech.glide.request.Request request;

        @Override // com.bumptech.glide.request.target.Target
        @androidx.annotation.Nullable
        public com.bumptech.glide.request.Request getRequest() {
            return this.request;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super java.lang.Object> transition) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(@androidx.annotation.Nullable com.bumptech.glide.request.Request request) {
            this.request = request;
        }
    }

    public static final class PreloadTargetQueue {
        final java.util.Queue<com.bumptech.glide.ListPreloader.PreloadTarget> queue;

        public PreloadTargetQueue(int i) {
            this.queue = com.bumptech.glide.util.Util.createQueue(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.queue.offer(new com.bumptech.glide.ListPreloader.PreloadTarget());
            }
        }

        public com.bumptech.glide.ListPreloader.PreloadTarget next(int i, int i2) {
            com.bumptech.glide.ListPreloader.PreloadTarget poll = this.queue.poll();
            this.queue.offer(poll);
            poll.photoWidth = i;
            poll.photoHeight = i2;
            return poll;
        }
    }

    public ListPreloader(@androidx.annotation.NonNull com.bumptech.glide.RequestManager requestManager, @androidx.annotation.NonNull com.bumptech.glide.ListPreloader.PreloadModelProvider<T> preloadModelProvider, @androidx.annotation.NonNull com.bumptech.glide.ListPreloader.PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.requestManager = requestManager;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i;
        this.preloadTargetQueue = new com.bumptech.glide.ListPreloader.PreloadTargetQueue(i + 1);
    }

    private void cancelAll() {
        for (int i = 0; i < this.preloadTargetQueue.queue.size(); i++) {
            this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
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

    private void preloadItem(@androidx.annotation.Nullable T t, int i, int i2) {
        int[] preloadSize;
        com.bumptech.glide.RequestBuilder<?> preloadRequestBuilder;
        if (t == null || (preloadSize = this.preloadDimensionProvider.getPreloadSize(t, i, i2)) == null || (preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t)) == null) {
            return;
        }
        preloadRequestBuilder.into((com.bumptech.glide.RequestBuilder<?>) this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
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
