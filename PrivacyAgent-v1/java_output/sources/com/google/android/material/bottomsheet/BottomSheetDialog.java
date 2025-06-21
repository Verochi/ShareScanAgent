package com.google.android.material.bottomsheet;

/* loaded from: classes22.dex */
public class BottomSheetDialog extends androidx.appcompat.app.AppCompatDialog {
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> behavior;
    private android.widget.FrameLayout bottomSheet;

    @androidx.annotation.NonNull
    private com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private android.widget.FrameLayout container;
    private androidx.coordinatorlayout.widget.CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.core.view.OnApplyWindowInsetsListener {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            if (com.google.android.material.bottomsheet.BottomSheetDialog.this.edgeToEdgeCallback != null) {
                com.google.android.material.bottomsheet.BottomSheetDialog.this.behavior.removeBottomSheetCallback(com.google.android.material.bottomsheet.BottomSheetDialog.this.edgeToEdgeCallback);
            }
            if (windowInsetsCompat != null) {
                com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = com.google.android.material.bottomsheet.BottomSheetDialog.this;
                bottomSheetDialog.edgeToEdgeCallback = new com.google.android.material.bottomsheet.BottomSheetDialog.EdgeToEdgeCallback(bottomSheetDialog.bottomSheet, windowInsetsCompat, null);
                com.google.android.material.bottomsheet.BottomSheetDialog.this.behavior.addBottomSheetCallback(com.google.android.material.bottomsheet.BottomSheetDialog.this.edgeToEdgeCallback);
            }
            return windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = com.google.android.material.bottomsheet.BottomSheetDialog.this;
            if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing() && com.google.android.material.bottomsheet.BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                com.google.android.material.bottomsheet.BottomSheetDialog.this.cancel();
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.core.view.AccessibilityDelegateCompat {
        public AnonymousClass3() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!com.google.android.material.bottomsheet.BottomSheetDialog.this.cancelable) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
            if (i == 1048576) {
                com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = com.google.android.material.bottomsheet.BottomSheetDialog.this;
                if (bottomSheetDialog.cancelable) {
                    bottomSheetDialog.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnTouchListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$5, reason: invalid class name */
    public class AnonymousClass5 extends com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback {
        public AnonymousClass5() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@androidx.annotation.NonNull android.view.View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@androidx.annotation.NonNull android.view.View view, int i) {
            if (i == 5) {
                com.google.android.material.bottomsheet.BottomSheetDialog.this.cancel();
            }
        }
    }

    public static class EdgeToEdgeCallback extends com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback {
        private final androidx.core.view.WindowInsetsCompat insetsCompat;
        private final boolean lightBottomSheet;
        private final boolean lightStatusBar;

        private EdgeToEdgeCallback(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            this.insetsCompat = windowInsetsCompat;
            boolean z = android.os.Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            this.lightStatusBar = z;
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = com.google.android.material.bottomsheet.BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            android.content.res.ColorStateList fillColor = materialShapeDrawable != null ? materialShapeDrawable.getFillColor() : androidx.core.view.ViewCompat.getBackgroundTintList(view);
            if (fillColor != null) {
                this.lightBottomSheet = com.google.android.material.color.MaterialColors.isColorLight(fillColor.getDefaultColor());
            } else if (view.getBackground() instanceof android.graphics.drawable.ColorDrawable) {
                this.lightBottomSheet = com.google.android.material.color.MaterialColors.isColorLight(((android.graphics.drawable.ColorDrawable) view.getBackground()).getColor());
            } else {
                this.lightBottomSheet = z;
            }
        }

        public /* synthetic */ EdgeToEdgeCallback(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat, com.google.android.material.bottomsheet.BottomSheetDialog.AnonymousClass1 anonymousClass1) {
            this(view, windowInsetsCompat);
        }

        private void setPaddingForPosition(android.view.View view) {
            if (view.getTop() < this.insetsCompat.getSystemWindowInsetTop()) {
                com.google.android.material.bottomsheet.BottomSheetDialog.setLightStatusBar(view, this.lightBottomSheet);
                view.setPadding(view.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                com.google.android.material.bottomsheet.BottomSheetDialog.setLightStatusBar(view, this.lightStatusBar);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@androidx.annotation.NonNull android.view.View view, float f) {
            setPaddingForPosition(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@androidx.annotation.NonNull android.view.View view, int i) {
            setPaddingForPosition(view);
        }
    }

    public BottomSheetDialog(@androidx.annotation.NonNull android.content.Context context) {
        this(context, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{com.google.android.material.R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.StyleRes int i) {
        super(context, getThemeResId(context, i));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new com.google.android.material.bottomsheet.BottomSheetDialog.AnonymousClass5();
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{com.google.android.material.R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(@androidx.annotation.NonNull android.content.Context context, boolean z, android.content.DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new com.google.android.material.bottomsheet.BottomSheetDialog.AnonymousClass5();
        supportRequestWindowFeature(1);
        this.cancelable = z;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{com.google.android.material.R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private android.widget.FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) android.view.View.inflate(getContext(), com.google.android.material.R.layout.design_bottom_sheet_dialog, null);
            this.container = frameLayout;
            this.coordinator = (androidx.coordinatorlayout.widget.CoordinatorLayout) frameLayout.findViewById(com.google.android.material.R.id.coordinator);
            android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) this.container.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            this.bottomSheet = frameLayout2;
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> from = com.google.android.material.bottomsheet.BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    private static int getThemeResId(@androidx.annotation.NonNull android.content.Context context, int i) {
        if (i != 0) {
            return i;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        return context.getTheme().resolveAttribute(com.google.android.material.R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : com.google.android.material.R.style.Theme_Design_Light_BottomSheetDialog;
    }

    public static void setLightStatusBar(@androidx.annotation.NonNull android.view.View view, boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    private android.view.View wrapInBottomSheet(int i, @androidx.annotation.Nullable android.view.View view, @androidx.annotation.Nullable android.view.ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = (androidx.coordinatorlayout.widget.CoordinatorLayout) this.container.findViewById(com.google.android.material.R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (android.view.ViewGroup) coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new com.google.android.material.bottomsheet.BottomSheetDialog.AnonymousClass1());
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(com.google.android.material.R.id.touch_outside).setOnClickListener(new com.google.android.material.bottomsheet.BottomSheetDialog.AnonymousClass2());
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this.bottomSheet, new com.google.android.material.bottomsheet.BottomSheetDialog.AnonymousClass3());
        this.bottomSheet.setOnTouchListener(new com.google.android.material.bottomsheet.BottomSheetDialog.AnonymousClass4());
        return this.container;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> behavior = getBehavior();
        if (!this.dismissWithAnimation || behavior.getState() == 5) {
            super.cancel();
        } else {
            behavior.setState(5);
        }
    }

    @androidx.annotation.NonNull
    public com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.view.Window window = getWindow();
        if (window != null) {
            boolean z = this.edgeToEdgeEnabled && android.graphics.Color.alpha(window.getNavigationBarColor()) < 255;
            android.widget.FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            if (z) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.view.Window window = getWindow();
        if (window != null) {
            int i = android.os.Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 5) {
            return;
        }
        this.behavior.setState(4);
    }

    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.cancelable != z) {
            this.cancelable = z;
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@androidx.annotation.LayoutRes int i) {
        super.setContentView(wrapInBottomSheet(i, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(android.view.View view) {
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public void setDismissWithAnimation(boolean z) {
        this.dismissWithAnimation = z;
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }
}
