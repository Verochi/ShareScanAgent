package androidx.appcompat.widget;

/* loaded from: classes.dex */
class TintResources extends androidx.appcompat.widget.ResourcesWrapper {
    private final java.lang.ref.WeakReference<android.content.Context> mContextRef;

    public TintResources(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.Resources resources) {
        super(resources);
        this.mContextRef = new java.lang.ref.WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.Drawable drawable = super.getDrawable(i);
        android.content.Context context = this.mContextRef.get();
        if (drawable != null && context != null) {
            androidx.appcompat.widget.ResourceManagerInternal.get().tintDrawableUsingColorFilter(context, i, drawable);
        }
        return drawable;
    }
}
