package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public abstract class ViewTarget<T extends android.view.View, Z> extends com.alimm.tanx.ui.image.glide.request.target.BaseTarget<Z> {
    private static final java.lang.String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce;
    private static java.lang.Integer tagId;
    private final com.alimm.tanx.ui.image.glide.request.target.ViewTarget.SizeDeterminer sizeDeterminer;
    protected final T view;

    public static class SizeDeterminer {
        private static final int PENDING_SIZE = 0;
        private final java.util.List<com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback> cbs = new java.util.ArrayList();
        private android.graphics.Point displayDimens;
        private com.alimm.tanx.ui.image.glide.request.target.ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener layoutListener;
        private final android.view.View view;

        public static class SizeDeterminerLayoutListener implements android.view.ViewTreeObserver.OnPreDrawListener {
            private final java.lang.ref.WeakReference<com.alimm.tanx.ui.image.glide.request.target.ViewTarget.SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(com.alimm.tanx.ui.image.glide.request.target.ViewTarget.SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new java.lang.ref.WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (android.util.Log.isLoggable(com.alimm.tanx.ui.image.glide.request.target.ViewTarget.TAG, 2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("OnGlobalLayoutListener called listener=");
                    sb.append(this);
                }
                com.alimm.tanx.ui.image.glide.request.target.ViewTarget.SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.checkCurrentDimens();
                return true;
            }
        }

        public SizeDeterminer(android.view.View view) {
            this.view = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkCurrentDimens() {
            if (this.cbs.isEmpty()) {
                return;
            }
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                notifyCbs(viewWidthOrParam, viewHeightOrParam);
                android.view.ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
                }
                this.layoutListener = null;
            }
        }

        @android.annotation.TargetApi(13)
        private android.graphics.Point getDisplayDimens() {
            android.graphics.Point point = this.displayDimens;
            if (point != null) {
                return point;
            }
            android.view.Display defaultDisplay = ((android.view.WindowManager) this.view.getContext().getSystemService("window")).getDefaultDisplay();
            android.graphics.Point point2 = new android.graphics.Point();
            this.displayDimens = point2;
            defaultDisplay.getSize(point2);
            return this.displayDimens;
        }

        private int getSizeForParam(int i, boolean z) {
            if (i != -2) {
                return i;
            }
            android.graphics.Point displayDimens = getDisplayDimens();
            return z ? displayDimens.y : displayDimens.x;
        }

        private int getViewHeightOrParam() {
            android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getHeight())) {
                return this.view.getHeight();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.height, true);
            }
            return 0;
        }

        private int getViewWidthOrParam() {
            android.view.ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (isSizeValid(this.view.getWidth())) {
                return this.view.getWidth();
            }
            if (layoutParams != null) {
                return getSizeForParam(layoutParams.width, false);
            }
            return 0;
        }

        private boolean isSizeValid(int i) {
            return i > 0 || i == -2;
        }

        private void notifyCbs(int i, int i2) {
            java.util.Iterator<com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback> it = this.cbs.iterator();
            while (it.hasNext()) {
                it.next().onSizeReady(i, i2);
            }
            this.cbs.clear();
        }

        public void getSize(com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback sizeReadyCallback) {
            int viewWidthOrParam = getViewWidthOrParam();
            int viewHeightOrParam = getViewHeightOrParam();
            if (isSizeValid(viewWidthOrParam) && isSizeValid(viewHeightOrParam)) {
                sizeReadyCallback.onSizeReady(viewWidthOrParam, viewHeightOrParam);
                return;
            }
            if (!this.cbs.contains(sizeReadyCallback)) {
                this.cbs.add(sizeReadyCallback);
            }
            if (this.layoutListener == null) {
                android.view.ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                com.alimm.tanx.ui.image.glide.request.target.ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new com.alimm.tanx.ui.image.glide.request.target.ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener(this);
                this.layoutListener = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }
    }

    public ViewTarget(T t) {
        if (t == null) {
            throw new java.lang.NullPointerException("View must not be null!");
        }
        this.view = t;
        this.sizeDeterminer = new com.alimm.tanx.ui.image.glide.request.target.ViewTarget.SizeDeterminer(t);
    }

    private java.lang.Object getTag() {
        java.lang.Integer num = tagId;
        return num == null ? this.view.getTag() : this.view.getTag(num.intValue());
    }

    private void setTag(java.lang.Object obj) {
        java.lang.Integer num = tagId;
        if (num != null) {
            this.view.setTag(num.intValue(), obj);
        } else {
            isTagUsedAtLeastOnce = true;
            this.view.setTag(obj);
        }
    }

    public static void setTagId(int i) {
        if (tagId != null || isTagUsedAtLeastOnce) {
            throw new java.lang.IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        tagId = java.lang.Integer.valueOf(i);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public com.alimm.tanx.ui.image.glide.request.Request getRequest() {
        java.lang.Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof com.alimm.tanx.ui.image.glide.request.Request) {
            return (com.alimm.tanx.ui.image.glide.request.Request) tag;
        }
        throw new java.lang.IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void getSize(com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    public T getView() {
        return this.view;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(com.alimm.tanx.ui.image.glide.request.Request request) {
        setTag(request);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Target for: ");
        tanxu_do2.append(this.view);
        return tanxu_do2.toString();
    }
}
