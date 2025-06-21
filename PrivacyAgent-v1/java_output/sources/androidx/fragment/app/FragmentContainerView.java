package androidx.fragment.app;

/* loaded from: classes.dex */
public final class FragmentContainerView extends android.widget.FrameLayout {
    private android.view.View.OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private java.util.ArrayList<android.view.View> mDisappearingFragmentChildren;
    private boolean mDrawDisappearingViewsFirst;
    private java.util.ArrayList<android.view.View> mTransitioningFragmentViews;

    public FragmentContainerView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.mDrawDisappearingViewsFirst = true;
    }

    public FragmentContainerView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        java.lang.String str;
        this.mDrawDisappearingViewsFirst = true;
        if (attributeSet != null) {
            java.lang.String classAttribute = attributeSet.getClassAttribute();
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.fragment.R.styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(androidx.fragment.R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new java.lang.UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    public FragmentContainerView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager) {
        super(context, attributeSet);
        java.lang.String str;
        this.mDrawDisappearingViewsFirst = true;
        java.lang.String classAttribute = attributeSet.getClassAttribute();
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.fragment.R.styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(androidx.fragment.R.styleable.FragmentContainerView_android_name) : classAttribute;
        java.lang.String string = obtainStyledAttributes.getString(androidx.fragment.R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        androidx.fragment.app.Fragment findFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute != null && findFragmentById == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new java.lang.IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            androidx.fragment.app.Fragment instantiate = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), classAttribute);
            instantiate.onInflate(context, attributeSet, (android.os.Bundle) null);
            fragmentManager.beginTransaction().setReorderingAllowed(true).add(this, instantiate, string).commitNowAllowingStateLoss();
        }
        fragmentManager.onContainerAvailable(this);
    }

    private void addDisappearingFragmentView(@androidx.annotation.NonNull android.view.View view) {
        java.util.ArrayList<android.view.View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.mDisappearingFragmentChildren == null) {
            this.mDisappearingFragmentChildren = new java.util.ArrayList<>();
        }
        this.mDisappearingFragmentChildren.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(@androidx.annotation.NonNull android.view.View view, int i, @androidx.annotation.Nullable android.view.ViewGroup.LayoutParams layoutParams) {
        if (androidx.fragment.app.FragmentManager.getViewFragment(view) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new java.lang.IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(@androidx.annotation.NonNull android.view.View view, int i, @androidx.annotation.Nullable android.view.ViewGroup.LayoutParams layoutParams, boolean z) {
        if (androidx.fragment.app.FragmentManager.getViewFragment(view) != null) {
            return super.addViewInLayout(view, i, layoutParams, z);
        }
        throw new java.lang.IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(20)
    public android.view.WindowInsets dispatchApplyWindowInsets(@androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
        androidx.core.view.WindowInsetsCompat windowInsetsCompat = androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        android.view.View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.mApplyWindowInsetsListener;
        androidx.core.view.WindowInsetsCompat windowInsetsCompat2 = onApplyWindowInsetsListener != null ? androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : androidx.core.view.ViewCompat.onApplyWindowInsets(this, windowInsetsCompat);
        if (!windowInsetsCompat2.isConsumed()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                androidx.core.view.ViewCompat.dispatchApplyWindowInsets(getChildAt(i), windowInsetsCompat2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (this.mDrawDisappearingViewsFirst && this.mDisappearingFragmentChildren != null) {
            for (int i = 0; i < this.mDisappearingFragmentChildren.size(); i++) {
                super.drawChild(canvas, this.mDisappearingFragmentChildren.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.view.View view, long j) {
        java.util.ArrayList<android.view.View> arrayList;
        if (!this.mDrawDisappearingViewsFirst || (arrayList = this.mDisappearingFragmentChildren) == null || arrayList.size() <= 0 || !this.mDisappearingFragmentChildren.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@androidx.annotation.NonNull android.view.View view) {
        java.util.ArrayList<android.view.View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList != null) {
            arrayList.remove(view);
            java.util.ArrayList<android.view.View> arrayList2 = this.mDisappearingFragmentChildren;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.mDrawDisappearingViewsFirst = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(20)
    public android.view.WindowInsets onApplyWindowInsets(@androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            addDisappearingFragmentView(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(@androidx.annotation.NonNull android.view.View view, boolean z) {
        if (z) {
            addDisappearingFragmentView(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@androidx.annotation.NonNull android.view.View view) {
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        addDisappearingFragmentView(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(@androidx.annotation.NonNull android.view.View view) {
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            addDisappearingFragmentView(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            addDisappearingFragmentView(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.mDrawDisappearingViewsFirst = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@androidx.annotation.Nullable android.animation.LayoutTransition layoutTransition) {
        throw new java.lang.UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@androidx.annotation.NonNull android.view.View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.mApplyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@androidx.annotation.NonNull android.view.View view) {
        if (view.getParent() == this) {
            if (this.mTransitioningFragmentViews == null) {
                this.mTransitioningFragmentViews = new java.util.ArrayList<>();
            }
            this.mTransitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }
}
