package com.bumptech.glide.request.target;

@java.lang.Deprecated
/* loaded from: classes.dex */
public abstract class ViewTarget<T extends android.view.View, Z> extends com.bumptech.glide.request.target.BaseTarget<Z> {
    private static final java.lang.String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce;
    private static int tagId = com.bumptech.glide.R.id.glide_custom_view_target_tag;

    @androidx.annotation.Nullable
    private android.view.View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final com.bumptech.glide.request.target.ViewTarget.SizeDeterminer sizeDeterminer;
    protected final T view;

    /* renamed from: com.bumptech.glide.request.target.ViewTarget$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnAttachStateChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
            com.bumptech.glide.request.target.ViewTarget.this.resumeMyRequest();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            com.bumptech.glide.request.target.ViewTarget.this.pauseMyRequest();
        }
    }

    @androidx.annotation.VisibleForTesting
    public static final class SizeDeterminer {
        private static final int PENDING_SIZE = 0;

        @androidx.annotation.Nullable
        @androidx.annotation.VisibleForTesting
        static java.lang.Integer maxDisplayLength;
        private final java.util.List<com.bumptech.glide.request.target.SizeReadyCallback> cbs = new java.util.ArrayList();

        @androidx.annotation.Nullable
        private com.bumptech.glide.request.target.ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener layoutListener;
        private final android.view.View view;
        boolean waitForLayout;

        public static final class SizeDeterminerLayoutListener implements android.view.ViewTreeObserver.OnPreDrawListener {
            private final java.lang.ref.WeakReference<com.bumptech.glide.request.target.ViewTarget.SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(@androidx.annotation.NonNull com.bumptech.glide.request.target.ViewTarget.SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new java.lang.ref.WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (android.util.Log.isLoggable(com.bumptech.glide.request.target.ViewTarget.TAG, 2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                }
                com.bumptech.glide.request.target.ViewTarget.SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.checkCurrentDimens();
                return true;
            }
        }

        public SizeDeterminer(@androidx.annotation.NonNull android.view.View view) {
            this.view = view;
        }

        private static int getMaxDisplayLength(@androidx.annotation.NonNull android.content.Context context) {
            if (maxDisplayLength == null) {
                android.view.Display defaultDisplay = ((android.view.WindowManager) com.bumptech.glide.util.Preconditions.checkNotNull((android.view.WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                android.graphics.Point point = new android.graphics.Point();
                defaultDisplay.getSize(point);
                maxDisplayLength = java.lang.Integer.valueOf(java.lang.Math.max(point.x, point.y));
            }
            return maxDisplayLength.intValue();
        }

        private int getTargetDimen(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.waitForLayout && this.view.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.view.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            return getMaxDisplayLength(this.view.getContext());
        }

        private int getTargetHeight() {
            int paddingTop = this.view.getPaddingTop() + this.view.getPaddingBottom();
            android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            return getTargetDimen(this.view.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int getTargetWidth() {
            int paddingLeft = this.view.getPaddingLeft() + this.view.getPaddingRight();
            android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            return getTargetDimen(this.view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean isDimensionValid(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean isViewStateAndSizeValid(int i, int i2) {
            return isDimensionValid(i) && isDimensionValid(i2);
        }

        private void notifyCbs(int i, int i2) {
            java.util.Iterator it = new java.util.ArrayList(this.cbs).iterator();
            while (it.hasNext()) {
                ((com.bumptech.glide.request.target.SizeReadyCallback) it.next()).onSizeReady(i, i2);
            }
        }

        public void checkCurrentDimens() {
            if (this.cbs.isEmpty()) {
                return;
            }
            int targetWidth = getTargetWidth();
            int targetHeight = getTargetHeight();
            if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
                notifyCbs(targetWidth, targetHeight);
                clearCallbacksAndListener();
            }
        }

        public void clearCallbacksAndListener() {
            android.view.ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
            }
            this.layoutListener = null;
            this.cbs.clear();
        }

        public void getSize(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
            int targetWidth = getTargetWidth();
            int targetHeight = getTargetHeight();
            if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
                sizeReadyCallback.onSizeReady(targetWidth, targetHeight);
                return;
            }
            if (!this.cbs.contains(sizeReadyCallback)) {
                this.cbs.add(sizeReadyCallback);
            }
            if (this.layoutListener == null) {
                android.view.ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                com.bumptech.glide.request.target.ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new com.bumptech.glide.request.target.ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener(this);
                this.layoutListener = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        public void removeCallback(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
            this.cbs.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(@androidx.annotation.NonNull T t) {
        this.view = (T) com.bumptech.glide.util.Preconditions.checkNotNull(t);
        this.sizeDeterminer = new com.bumptech.glide.request.target.ViewTarget.SizeDeterminer(t);
    }

    @java.lang.Deprecated
    public ViewTarget(@androidx.annotation.NonNull T t, boolean z) {
        this(t);
        if (z) {
            waitForLayout();
        }
    }

    @androidx.annotation.Nullable
    private java.lang.Object getTag() {
        return this.view.getTag(tagId);
    }

    private void maybeAddAttachStateListener() {
        android.view.View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null || this.isAttachStateListenerAdded) {
            return;
        }
        this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = true;
    }

    private void maybeRemoveAttachStateListener() {
        android.view.View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null || !this.isAttachStateListenerAdded) {
            return;
        }
        this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = false;
    }

    private void setTag(@androidx.annotation.Nullable java.lang.Object obj) {
        isTagUsedAtLeastOnce = true;
        this.view.setTag(tagId, obj);
    }

    @java.lang.Deprecated
    public static void setTagId(int i) {
        if (isTagUsedAtLeastOnce) {
            throw new java.lang.IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        tagId = i;
    }

    @androidx.annotation.NonNull
    public final com.bumptech.glide.request.target.ViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new com.bumptech.glide.request.target.ViewTarget.AnonymousClass1();
        maybeAddAttachStateListener();
        return this;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @androidx.annotation.Nullable
    public com.bumptech.glide.request.Request getRequest() {
        java.lang.Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof com.bumptech.glide.request.Request) {
            return (com.bumptech.glide.request.Request) tag;
        }
        throw new java.lang.IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.request.target.Target
    @androidx.annotation.CallSuper
    public void getSize(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    @androidx.annotation.NonNull
    public T getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @androidx.annotation.CallSuper
    public void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        super.onLoadCleared(drawable);
        this.sizeDeterminer.clearCallbacksAndListener();
        if (this.isClearedByUs) {
            return;
        }
        maybeRemoveAttachStateListener();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @androidx.annotation.CallSuper
    public void onLoadStarted(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        super.onLoadStarted(drawable);
        maybeAddAttachStateListener();
    }

    public void pauseMyRequest() {
        com.bumptech.glide.request.Request request = getRequest();
        if (request != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    @androidx.annotation.CallSuper
    public void removeCallback(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.removeCallback(sizeReadyCallback);
    }

    public void resumeMyRequest() {
        com.bumptech.glide.request.Request request = getRequest();
        if (request == null || !request.isCleared()) {
            return;
        }
        request.begin();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(@androidx.annotation.Nullable com.bumptech.glide.request.Request request) {
        setTag(request);
    }

    public java.lang.String toString() {
        return "Target for: " + this.view;
    }

    @androidx.annotation.NonNull
    public final com.bumptech.glide.request.target.ViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }
}
