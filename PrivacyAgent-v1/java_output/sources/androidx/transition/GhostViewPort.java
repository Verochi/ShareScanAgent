package androidx.transition;

@android.annotation.SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class GhostViewPort extends android.view.ViewGroup implements androidx.transition.GhostView {

    @androidx.annotation.Nullable
    private android.graphics.Matrix mMatrix;
    private final android.view.ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    int mReferences;
    android.view.ViewGroup mStartParent;
    android.view.View mStartView;
    final android.view.View mView;

    /* renamed from: androidx.transition.GhostViewPort$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnPreDrawListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            android.view.View view;
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(androidx.transition.GhostViewPort.this);
            androidx.transition.GhostViewPort ghostViewPort = androidx.transition.GhostViewPort.this;
            android.view.ViewGroup viewGroup = ghostViewPort.mStartParent;
            if (viewGroup == null || (view = ghostViewPort.mStartView) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(androidx.transition.GhostViewPort.this.mStartParent);
            androidx.transition.GhostViewPort ghostViewPort2 = androidx.transition.GhostViewPort.this;
            ghostViewPort2.mStartParent = null;
            ghostViewPort2.mStartView = null;
            return true;
        }
    }

    public GhostViewPort(android.view.View view) {
        super(view.getContext());
        this.mOnPreDrawListener = new androidx.transition.GhostViewPort.AnonymousClass1();
        this.mView = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    public static androidx.transition.GhostViewPort addGhost(android.view.View view, android.view.ViewGroup viewGroup, android.graphics.Matrix matrix) {
        int i;
        androidx.transition.GhostViewHolder ghostViewHolder;
        if (!(view.getParent() instanceof android.view.ViewGroup)) {
            throw new java.lang.IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        androidx.transition.GhostViewHolder holder = androidx.transition.GhostViewHolder.getHolder(viewGroup);
        androidx.transition.GhostViewPort ghostView = getGhostView(view);
        if (ghostView == null || (ghostViewHolder = (androidx.transition.GhostViewHolder) ghostView.getParent()) == holder) {
            i = 0;
        } else {
            i = ghostView.mReferences;
            ghostViewHolder.removeView(ghostView);
            ghostView = null;
        }
        if (ghostView == null) {
            if (matrix == null) {
                matrix = new android.graphics.Matrix();
                calculateMatrix(view, viewGroup, matrix);
            }
            ghostView = new androidx.transition.GhostViewPort(view);
            ghostView.setMatrix(matrix);
            if (holder == null) {
                holder = new androidx.transition.GhostViewHolder(viewGroup);
            } else {
                holder.popToOverlayTop();
            }
            copySize(viewGroup, holder);
            copySize(viewGroup, ghostView);
            holder.addGhostView(ghostView);
            ghostView.mReferences = i;
        } else if (matrix != null) {
            ghostView.setMatrix(matrix);
        }
        ghostView.mReferences++;
        return ghostView;
    }

    public static void calculateMatrix(android.view.View view, android.view.ViewGroup viewGroup, android.graphics.Matrix matrix) {
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) view.getParent();
        matrix.reset();
        androidx.transition.ViewUtils.transformMatrixToGlobal(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        androidx.transition.ViewUtils.transformMatrixToLocal(viewGroup, matrix);
    }

    public static void copySize(android.view.View view, android.view.View view2) {
        androidx.transition.ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    public static androidx.transition.GhostViewPort getGhostView(android.view.View view) {
        return (androidx.transition.GhostViewPort) view.getTag(androidx.transition.R.id.ghost_view);
    }

    public static void removeGhost(android.view.View view) {
        androidx.transition.GhostViewPort ghostView = getGhostView(view);
        if (ghostView != null) {
            int i = ghostView.mReferences - 1;
            ghostView.mReferences = i;
            if (i <= 0) {
                ((androidx.transition.GhostViewHolder) ghostView.getParent()).removeView(ghostView);
            }
        }
    }

    public static void setGhostView(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.transition.GhostViewPort ghostViewPort) {
        view.setTag(androidx.transition.R.id.ghost_view, ghostViewPort);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        androidx.transition.ViewUtils.setTransitionVisibility(this.mView, 4);
        if (this.mView.getParent() != null) {
            ((android.view.View) this.mView.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        androidx.transition.ViewUtils.setTransitionVisibility(this.mView, 0);
        setGhostView(this.mView, null);
        if (this.mView.getParent() != null) {
            ((android.view.View) this.mView.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        androidx.transition.CanvasUtils.enableZ(canvas, true);
        canvas.setMatrix(this.mMatrix);
        androidx.transition.ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        androidx.transition.ViewUtils.setTransitionVisibility(this.mView, 4);
        drawChild(canvas, this.mView, getDrawingTime());
        androidx.transition.CanvasUtils.enableZ(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(android.view.ViewGroup viewGroup, android.view.View view) {
        this.mStartParent = viewGroup;
        this.mStartView = view;
    }

    public void setMatrix(@androidx.annotation.NonNull android.graphics.Matrix matrix) {
        this.mMatrix = matrix;
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getGhostView(this.mView) == this) {
            androidx.transition.ViewUtils.setTransitionVisibility(this.mView, i == 0 ? 4 : 0);
        }
    }
}
