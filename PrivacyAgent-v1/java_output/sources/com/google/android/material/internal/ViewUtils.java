package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class ViewUtils {

    /* renamed from: com.google.android.material.internal.ViewUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(android.view.View view) {
            this.val$view = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((android.view.inputmethod.InputMethodManager) this.val$view.getContext().getSystemService("input_method")).showSoftInput(this.val$view, 1);
        }
    }

    /* renamed from: com.google.android.material.internal.ViewUtils$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener {
        final /* synthetic */ com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener val$listener;
        final /* synthetic */ boolean val$paddingBottomSystemWindowInsets;
        final /* synthetic */ boolean val$paddingLeftSystemWindowInsets;
        final /* synthetic */ boolean val$paddingRightSystemWindowInsets;

        public AnonymousClass2(boolean z, boolean z2, boolean z3, com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            this.val$paddingBottomSystemWindowInsets = z;
            this.val$paddingLeftSystemWindowInsets = z2;
            this.val$paddingRightSystemWindowInsets = z3;
            this.val$listener = onApplyWindowInsetsListener;
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
            if (this.val$paddingBottomSystemWindowInsets) {
                relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean isLayoutRtl = com.google.android.material.internal.ViewUtils.isLayoutRtl(view);
            if (this.val$paddingLeftSystemWindowInsets) {
                if (isLayoutRtl) {
                    relativePadding.end += windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    relativePadding.start += windowInsetsCompat.getSystemWindowInsetLeft();
                }
            }
            if (this.val$paddingRightSystemWindowInsets) {
                if (isLayoutRtl) {
                    relativePadding.start += windowInsetsCompat.getSystemWindowInsetRight();
                } else {
                    relativePadding.end += windowInsetsCompat.getSystemWindowInsetRight();
                }
            }
            relativePadding.applyToView(view);
            com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.val$listener;
            return onApplyWindowInsetsListener != null ? onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat, relativePadding) : windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.internal.ViewUtils$3, reason: invalid class name */
    public static class AnonymousClass3 implements androidx.core.view.OnApplyWindowInsetsListener {
        final /* synthetic */ com.google.android.material.internal.ViewUtils.RelativePadding val$initialPadding;
        final /* synthetic */ com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener val$listener;

        public AnonymousClass3(com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener, com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
            this.val$listener = onApplyWindowInsetsListener;
            this.val$initialPadding = relativePadding;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat, new com.google.android.material.internal.ViewUtils.RelativePadding(this.val$initialPadding));
        }
    }

    /* renamed from: com.google.android.material.internal.ViewUtils$4, reason: invalid class name */
    public static class AnonymousClass4 implements android.view.View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@androidx.annotation.NonNull android.view.View view) {
            view.removeOnAttachStateChangeListener(this);
            androidx.core.view.ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
        }
    }

    public interface OnApplyWindowInsetsListener {
        androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat, com.google.android.material.internal.ViewUtils.RelativePadding relativePadding);
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i, int i2, int i3, int i4) {
            this.start = i;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public RelativePadding(@androidx.annotation.NonNull com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }

        public void applyToView(android.view.View view) {
            androidx.core.view.ViewCompat.setPaddingRelative(view, this.start, this.top, this.end, this.bottom);
        }
    }

    private ViewUtils() {
    }

    public static void addOnGlobalLayoutListener(@androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void doOnApplyWindowInsets(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        doOnApplyWindowInsets(view, attributeSet, i, i2, null);
    }

    public static void doOnApplyWindowInsets(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2, @androidx.annotation.Nullable com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        android.content.res.TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.Insets, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        doOnApplyWindowInsets(view, new com.google.android.material.internal.ViewUtils.AnonymousClass2(z, z2, z3, onApplyWindowInsetsListener));
    }

    public static void doOnApplyWindowInsets(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(view, new com.google.android.material.internal.ViewUtils.AnonymousClass3(onApplyWindowInsetsListener, new com.google.android.material.internal.ViewUtils.RelativePadding(androidx.core.view.ViewCompat.getPaddingStart(view), view.getPaddingTop(), androidx.core.view.ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        requestApplyInsetsWhenAttached(view);
    }

    public static float dpToPx(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Dimension(unit = 0) int i) {
        return android.util.TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    @androidx.annotation.Nullable
    public static android.view.ViewGroup getContentView(@androidx.annotation.Nullable android.view.View view) {
        if (view == null) {
            return null;
        }
        android.view.View rootView = view.getRootView();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof android.view.ViewGroup)) {
            return null;
        }
        return (android.view.ViewGroup) rootView;
    }

    @androidx.annotation.Nullable
    public static com.google.android.material.internal.ViewOverlayImpl getContentViewOverlay(@androidx.annotation.NonNull android.view.View view) {
        return getOverlay(getContentView(view));
    }

    @androidx.annotation.Nullable
    public static com.google.android.material.internal.ViewOverlayImpl getOverlay(@androidx.annotation.Nullable android.view.View view) {
        if (view == null) {
            return null;
        }
        return new com.google.android.material.internal.ViewOverlayApi18(view);
    }

    public static float getParentAbsoluteElevation(@androidx.annotation.NonNull android.view.View view) {
        float f = 0.0f;
        for (android.view.ViewParent parent = view.getParent(); parent instanceof android.view.View; parent = parent.getParent()) {
            f += androidx.core.view.ViewCompat.getElevation((android.view.View) parent);
        }
        return f;
    }

    public static boolean isLayoutRtl(android.view.View view) {
        return androidx.core.view.ViewCompat.getLayoutDirection(view) == 1;
    }

    public static android.graphics.PorterDuff.Mode parseTintMode(int i, android.graphics.PorterDuff.Mode mode) {
        if (i == 3) {
            return android.graphics.PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return android.graphics.PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return android.graphics.PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case 15:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case 16:
                return android.graphics.PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void removeOnGlobalLayoutListener(@androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            removeOnGlobalLayoutListener(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void removeOnGlobalLayoutListener(@androidx.annotation.NonNull android.view.ViewTreeObserver viewTreeObserver, @androidx.annotation.NonNull android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void requestApplyInsetsWhenAttached(@androidx.annotation.NonNull android.view.View view) {
        if (androidx.core.view.ViewCompat.isAttachedToWindow(view)) {
            androidx.core.view.ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new com.google.android.material.internal.ViewUtils.AnonymousClass4());
        }
    }

    public static void requestFocusAndShowKeyboard(@androidx.annotation.NonNull android.view.View view) {
        view.requestFocus();
        view.post(new com.google.android.material.internal.ViewUtils.AnonymousClass1(view));
    }
}
