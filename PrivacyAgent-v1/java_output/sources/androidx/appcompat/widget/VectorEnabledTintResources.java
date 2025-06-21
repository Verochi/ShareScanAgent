package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class VectorEnabledTintResources extends android.content.res.Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private static boolean sCompatVectorFromResourcesEnabled;
    private final java.lang.ref.WeakReference<android.content.Context> mContextRef;

    public VectorEnabledTintResources(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mContextRef = new java.lang.ref.WeakReference<>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return sCompatVectorFromResourcesEnabled;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        sCompatVectorFromResourcesEnabled = z;
    }

    public static boolean shouldBeUsed() {
        isCompatVectorFromResourcesEnabled();
        return false;
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i) throws android.content.res.Resources.NotFoundException {
        android.content.Context context = this.mContextRef.get();
        return context != null ? androidx.appcompat.widget.ResourceManagerInternal.get().onDrawableLoadedFromResources(context, this, i) : super.getDrawable(i);
    }

    public final android.graphics.drawable.Drawable superGetDrawable(int i) {
        return super.getDrawable(i);
    }
}
