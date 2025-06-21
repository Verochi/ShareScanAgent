package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:backgroundTint", method = "setBackgroundTintList", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:fadeScrollbars", method = "setScrollbarFadingEnabled", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:getOutline", method = "setOutlineProvider", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:nextFocusForward", method = "setNextFocusForwardId", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:nextFocusLeft", method = "setNextFocusLeftId", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:nextFocusRight", method = "setNextFocusRightId", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:nextFocusUp", method = "setNextFocusUpId", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:nextFocusDown", method = "setNextFocusDownId", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:requiresFadingEdge", method = "setVerticalFadingEdgeEnabled", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:scrollbarDefaultDelayBeforeFade", method = "setScrollBarDefaultDelayBeforeFade", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:scrollbarFadeDuration", method = "setScrollBarFadeDuration", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:scrollbarSize", method = "setScrollBarSize", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:scrollbarStyle", method = "setScrollBarStyle", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:transformPivotX", method = "setPivotX", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:transformPivotY", method = "setPivotY", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onDrag", method = "setOnDragListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onClick", method = "setOnClickListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onApplyWindowInsets", method = "setOnApplyWindowInsetsListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onCreateContextMenu", method = "setOnCreateContextMenuListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onFocusChange", method = "setOnFocusChangeListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onGenericMotion", method = "setOnGenericMotionListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onHover", method = "setOnHoverListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onKey", method = "setOnKeyListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onLongClick", method = "setOnLongClickListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onSystemUiVisibilityChange", method = "setOnSystemUiVisibilityChangeListener", type = android.view.View.class), @androidx.databinding.BindingMethod(attribute = "android:onTouch", method = "setOnTouchListener", type = android.view.View.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ViewBindingAdapter {
    public static final int FADING_EDGE_HORIZONTAL = 1;
    public static final int FADING_EDGE_NONE = 0;
    public static final int FADING_EDGE_VERTICAL = 2;

    /* renamed from: androidx.databinding.adapters.ViewBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnAttachStateChangeListener {
        final /* synthetic */ androidx.databinding.adapters.ViewBindingAdapter.OnViewAttachedToWindow val$attach;
        final /* synthetic */ androidx.databinding.adapters.ViewBindingAdapter.OnViewDetachedFromWindow val$detach;

        public AnonymousClass1(androidx.databinding.adapters.ViewBindingAdapter.OnViewAttachedToWindow onViewAttachedToWindow, androidx.databinding.adapters.ViewBindingAdapter.OnViewDetachedFromWindow onViewDetachedFromWindow) {
            this.val$attach = onViewAttachedToWindow;
            this.val$detach = onViewDetachedFromWindow;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
            androidx.databinding.adapters.ViewBindingAdapter.OnViewAttachedToWindow onViewAttachedToWindow = this.val$attach;
            if (onViewAttachedToWindow != null) {
                onViewAttachedToWindow.onViewAttachedToWindow(view);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            androidx.databinding.adapters.ViewBindingAdapter.OnViewDetachedFromWindow onViewDetachedFromWindow = this.val$detach;
            if (onViewDetachedFromWindow != null) {
                onViewDetachedFromWindow.onViewDetachedFromWindow(view);
            }
        }
    }

    @android.annotation.TargetApi(12)
    public interface OnViewAttachedToWindow {
        void onViewAttachedToWindow(android.view.View view);
    }

    @android.annotation.TargetApi(12)
    public interface OnViewDetachedFromWindow {
        void onViewDetachedFromWindow(android.view.View view);
    }

    private static int pixelsToDimensionPixelSize(float f) {
        int i = (int) (0.5f + f);
        if (i != 0) {
            return i;
        }
        if (f == 0.0f) {
            return 0;
        }
        return f > 0.0f ? 1 : -1;
    }

    @androidx.databinding.BindingAdapter({"android:background"})
    public static void setBackground(android.view.View view, android.graphics.drawable.Drawable drawable) {
        view.setBackground(drawable);
    }

    @androidx.databinding.BindingAdapter({"android:onClickListener", "android:clickable"})
    public static void setClickListener(android.view.View view, android.view.View.OnClickListener onClickListener, boolean z) {
        view.setOnClickListener(onClickListener);
        view.setClickable(z);
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onViewDetachedFromWindow", "android:onViewAttachedToWindow"})
    public static void setOnAttachStateChangeListener(android.view.View view, androidx.databinding.adapters.ViewBindingAdapter.OnViewDetachedFromWindow onViewDetachedFromWindow, androidx.databinding.adapters.ViewBindingAdapter.OnViewAttachedToWindow onViewAttachedToWindow) {
        androidx.databinding.adapters.ViewBindingAdapter.AnonymousClass1 anonymousClass1 = (onViewDetachedFromWindow == null && onViewAttachedToWindow == null) ? null : new androidx.databinding.adapters.ViewBindingAdapter.AnonymousClass1(onViewAttachedToWindow, onViewDetachedFromWindow);
        android.view.View.OnAttachStateChangeListener onAttachStateChangeListener = (android.view.View.OnAttachStateChangeListener) androidx.databinding.adapters.ListenerUtil.trackListener(view, anonymousClass1, androidx.databinding.library.baseAdapters.R.id.onAttachStateChangeListener);
        if (onAttachStateChangeListener != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        if (anonymousClass1 != null) {
            view.addOnAttachStateChangeListener(anonymousClass1);
        }
    }

    @androidx.databinding.BindingAdapter({"android:onClick", "android:clickable"})
    public static void setOnClick(android.view.View view, android.view.View.OnClickListener onClickListener, boolean z) {
        view.setOnClickListener(onClickListener);
        view.setClickable(z);
    }

    @androidx.databinding.BindingAdapter({"android:onLayoutChange"})
    public static void setOnLayoutChangeListener(android.view.View view, android.view.View.OnLayoutChangeListener onLayoutChangeListener, android.view.View.OnLayoutChangeListener onLayoutChangeListener2) {
        if (onLayoutChangeListener != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        if (onLayoutChangeListener2 != null) {
            view.addOnLayoutChangeListener(onLayoutChangeListener2);
        }
    }

    @androidx.databinding.BindingAdapter({"android:onLongClick", "android:longClickable"})
    public static void setOnLongClick(android.view.View view, android.view.View.OnLongClickListener onLongClickListener, boolean z) {
        view.setOnLongClickListener(onLongClickListener);
        view.setLongClickable(z);
    }

    @androidx.databinding.BindingAdapter({"android:onLongClickListener", "android:longClickable"})
    public static void setOnLongClickListener(android.view.View view, android.view.View.OnLongClickListener onLongClickListener, boolean z) {
        view.setOnLongClickListener(onLongClickListener);
        view.setLongClickable(z);
    }

    @androidx.databinding.BindingAdapter({"android:padding"})
    public static void setPadding(android.view.View view, float f) {
        int pixelsToDimensionPixelSize = pixelsToDimensionPixelSize(f);
        view.setPadding(pixelsToDimensionPixelSize, pixelsToDimensionPixelSize, pixelsToDimensionPixelSize, pixelsToDimensionPixelSize);
    }

    @androidx.databinding.BindingAdapter({"android:paddingBottom"})
    public static void setPaddingBottom(android.view.View view, float f) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), pixelsToDimensionPixelSize(f));
    }

    @androidx.databinding.BindingAdapter({"android:paddingEnd"})
    public static void setPaddingEnd(android.view.View view, float f) {
        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), pixelsToDimensionPixelSize(f), view.getPaddingBottom());
    }

    @androidx.databinding.BindingAdapter({"android:paddingLeft"})
    public static void setPaddingLeft(android.view.View view, float f) {
        view.setPadding(pixelsToDimensionPixelSize(f), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    @androidx.databinding.BindingAdapter({"android:paddingRight"})
    public static void setPaddingRight(android.view.View view, float f) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), pixelsToDimensionPixelSize(f), view.getPaddingBottom());
    }

    @androidx.databinding.BindingAdapter({"android:paddingStart"})
    public static void setPaddingStart(android.view.View view, float f) {
        view.setPaddingRelative(pixelsToDimensionPixelSize(f), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
    }

    @androidx.databinding.BindingAdapter({"android:paddingTop"})
    public static void setPaddingTop(android.view.View view, float f) {
        view.setPadding(view.getPaddingLeft(), pixelsToDimensionPixelSize(f), view.getPaddingRight(), view.getPaddingBottom());
    }

    @androidx.databinding.BindingAdapter({"android:requiresFadingEdge"})
    public static void setRequiresFadingEdge(android.view.View view, int i) {
        boolean z = (i & 2) != 0;
        boolean z2 = (i & 1) != 0;
        view.setVerticalFadingEdgeEnabled(z);
        view.setHorizontalFadingEdgeEnabled(z2);
    }
}
