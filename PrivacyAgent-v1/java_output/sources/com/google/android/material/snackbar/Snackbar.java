package com.google.android.material.snackbar;

/* loaded from: classes22.dex */
public class Snackbar extends com.google.android.material.snackbar.BaseTransientBottomBar<com.google.android.material.snackbar.Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS;

    @androidx.annotation.Nullable
    private final android.view.accessibility.AccessibilityManager accessibilityManager;

    @androidx.annotation.Nullable
    private com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<com.google.android.material.snackbar.Snackbar> callback;
    private boolean hasAction;

    /* renamed from: com.google.android.material.snackbar.Snackbar$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ android.view.View.OnClickListener val$listener;

        public AnonymousClass1(android.view.View.OnClickListener onClickListener) {
            this.val$listener = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            this.val$listener.onClick(view);
            com.google.android.material.snackbar.Snackbar.this.dispatchDismiss(1);
        }
    }

    public static class Callback extends com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<com.google.android.material.snackbar.Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onDismissed(com.google.android.material.snackbar.Snackbar snackbar, int i) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onShown(com.google.android.material.snackbar.Snackbar snackbar) {
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(android.content.Context context) {
            super(context);
        }

        public SnackbarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                android.view.View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        int i = com.google.android.material.R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{i};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{i, com.google.android.material.R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @androidx.annotation.Nullable
    private static android.view.ViewGroup findSuitableParent(android.view.View view) {
        android.view.ViewGroup viewGroup = null;
        while (!(view instanceof androidx.coordinatorlayout.widget.CoordinatorLayout)) {
            if (view instanceof android.widget.FrameLayout) {
                if (view.getId() == 16908290) {
                    return (android.view.ViewGroup) view;
                }
                viewGroup = (android.view.ViewGroup) view;
            }
            if (view != null) {
                java.lang.Object parent = view.getParent();
                view = parent instanceof android.view.View ? (android.view.View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (android.view.ViewGroup) view;
    }

    @java.lang.Deprecated
    public static boolean hasSnackbarButtonStyleAttr(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    private static boolean hasSnackbarContentStyleAttrs(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.snackbar.Snackbar make(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.CharSequence charSequence, int i) {
        return makeInternal(context, view, charSequence, i);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.snackbar.Snackbar make(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.StringRes int i, int i2) {
        return make(view, view.getResources().getText(i), i2);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.snackbar.Snackbar make(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.CharSequence charSequence, int i) {
        return makeInternal(null, view, charSequence, i);
    }

    @androidx.annotation.NonNull
    private static com.google.android.material.snackbar.Snackbar makeInternal(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.CharSequence charSequence, int i) {
        android.view.ViewGroup findSuitableParent = findSuitableParent(view);
        if (findSuitableParent == null) {
            throw new java.lang.IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = findSuitableParent.getContext();
        }
        com.google.android.material.snackbar.SnackbarContentLayout snackbarContentLayout = (com.google.android.material.snackbar.SnackbarContentLayout) android.view.LayoutInflater.from(context).inflate(hasSnackbarContentStyleAttrs(context) ? com.google.android.material.R.layout.mtrl_layout_snackbar_include : com.google.android.material.R.layout.design_layout_snackbar_include, findSuitableParent, false);
        com.google.android.material.snackbar.Snackbar snackbar = new com.google.android.material.snackbar.Snackbar(context, findSuitableParent, snackbarContentLayout, snackbarContentLayout);
        snackbar.setText(charSequence);
        snackbar.setDuration(i);
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int recommendedTimeoutMillis;
        int duration = super.getDuration();
        if (duration == -2) {
            return -2;
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            recommendedTimeoutMillis = this.accessibilityManager.getRecommendedTimeoutMillis(duration, (this.hasAction ? 4 : 0) | 1 | 2);
            return recommendedTimeoutMillis;
        }
        if (this.hasAction && this.accessibilityManager.isTouchExplorationEnabled()) {
            return -2;
        }
        return duration;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setAction(@androidx.annotation.StringRes int i, android.view.View.OnClickListener onClickListener) {
        return setAction(getContext().getText(i), onClickListener);
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setAction(@androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
        android.widget.Button actionView = ((com.google.android.material.snackbar.SnackbarContentLayout) this.view.getChildAt(0)).getActionView();
        if (android.text.TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.hasAction = false;
        } else {
            this.hasAction = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new com.google.android.material.snackbar.Snackbar.AnonymousClass1(onClickListener));
        }
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setActionTextColor(@androidx.annotation.ColorInt int i) {
        ((com.google.android.material.snackbar.SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(i);
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setActionTextColor(android.content.res.ColorStateList colorStateList) {
        ((com.google.android.material.snackbar.SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(colorStateList);
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setBackgroundTint(@androidx.annotation.ColorInt int i) {
        return setBackgroundTintList(android.content.res.ColorStateList.valueOf(i));
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setBackgroundTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.view.setBackgroundTintList(colorStateList);
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setBackgroundTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        this.view.setBackgroundTintMode(mode);
        return this;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public com.google.android.material.snackbar.Snackbar setCallback(@androidx.annotation.Nullable com.google.android.material.snackbar.Snackbar.Callback callback) {
        com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<com.google.android.material.snackbar.Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            removeCallback(baseCallback);
        }
        if (callback != null) {
            addCallback(callback);
        }
        this.callback = callback;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setMaxInlineActionWidth(@androidx.annotation.Dimension int i) {
        ((com.google.android.material.snackbar.SnackbarContentLayout) this.view.getChildAt(0)).setMaxInlineActionWidth(i);
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setText(@androidx.annotation.StringRes int i) {
        return setText(getContext().getText(i));
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setText(@androidx.annotation.NonNull java.lang.CharSequence charSequence) {
        ((com.google.android.material.snackbar.SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setTextColor(@androidx.annotation.ColorInt int i) {
        ((com.google.android.material.snackbar.SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(i);
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.snackbar.Snackbar setTextColor(android.content.res.ColorStateList colorStateList) {
        ((com.google.android.material.snackbar.SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(colorStateList);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }
}
