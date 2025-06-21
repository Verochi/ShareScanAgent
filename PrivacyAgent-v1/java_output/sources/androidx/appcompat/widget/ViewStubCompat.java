package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ViewStubCompat extends android.view.View {
    private androidx.appcompat.widget.ViewStubCompat.OnInflateListener mInflateListener;
    private int mInflatedId;
    private java.lang.ref.WeakReference<android.view.View> mInflatedViewRef;
    private android.view.LayoutInflater mInflater;
    private int mLayoutResource;

    public interface OnInflateListener {
        void onInflate(androidx.appcompat.widget.ViewStubCompat viewStubCompat, android.view.View view);
    }

    public ViewStubCompat(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLayoutResource = 0;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ViewStubCompat, i, 0);
        this.mInflatedId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.mLayoutResource = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
    }

    @Override // android.view.View
    @android.annotation.SuppressLint({"MissingSuperCall"})
    public void draw(android.graphics.Canvas canvas) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public android.view.LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public android.view.View inflate() {
        android.view.ViewParent parent = getParent();
        if (!(parent instanceof android.view.ViewGroup)) {
            throw new java.lang.IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.mLayoutResource == 0) {
            throw new java.lang.IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
        android.view.LayoutInflater layoutInflater = this.mInflater;
        if (layoutInflater == null) {
            layoutInflater = android.view.LayoutInflater.from(getContext());
        }
        android.view.View inflate = layoutInflater.inflate(this.mLayoutResource, viewGroup, false);
        int i = this.mInflatedId;
        if (i != -1) {
            inflate.setId(i);
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        this.mInflatedViewRef = new java.lang.ref.WeakReference<>(inflate);
        androidx.appcompat.widget.ViewStubCompat.OnInflateListener onInflateListener = this.mInflateListener;
        if (onInflateListener != null) {
            onInflateListener.onInflate(this, inflate);
        }
        return inflate;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.mInflatedId = i;
    }

    public void setLayoutInflater(android.view.LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.mLayoutResource = i;
    }

    public void setOnInflateListener(androidx.appcompat.widget.ViewStubCompat.OnInflateListener onInflateListener) {
        this.mInflateListener = onInflateListener;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.mInflatedViewRef;
        if (weakReference != null) {
            android.view.View view = weakReference.get();
            if (view == null) {
                throw new java.lang.IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            inflate();
        }
    }
}
