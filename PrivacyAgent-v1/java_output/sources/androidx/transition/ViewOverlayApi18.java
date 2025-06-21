package androidx.transition;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes.dex */
class ViewOverlayApi18 implements androidx.transition.ViewOverlayImpl {
    private final android.view.ViewOverlay mViewOverlay;

    public ViewOverlayApi18(@androidx.annotation.NonNull android.view.View view) {
        this.mViewOverlay = view.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        this.mViewOverlay.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        this.mViewOverlay.remove(drawable);
    }
}
