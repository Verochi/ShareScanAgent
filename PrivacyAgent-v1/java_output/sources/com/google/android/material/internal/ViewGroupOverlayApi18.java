package com.google.android.material.internal;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes22.dex */
class ViewGroupOverlayApi18 implements com.google.android.material.internal.ViewGroupOverlayImpl {
    private final android.view.ViewGroupOverlay viewGroupOverlay;

    public ViewGroupOverlayApi18(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        this.viewGroupOverlay = viewGroup.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        this.viewGroupOverlay.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void add(@androidx.annotation.NonNull android.view.View view) {
        this.viewGroupOverlay.add(view);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        this.viewGroupOverlay.remove(drawable);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void remove(@androidx.annotation.NonNull android.view.View view) {
        this.viewGroupOverlay.remove(view);
    }
}
