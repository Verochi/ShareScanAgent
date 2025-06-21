package com.google.android.material.internal;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes22.dex */
class ViewOverlayApi18 implements com.google.android.material.internal.ViewOverlayImpl {
    private final android.view.ViewOverlay viewOverlay;

    public ViewOverlayApi18(@androidx.annotation.NonNull android.view.View view) {
        this.viewOverlay = view.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        this.viewOverlay.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        this.viewOverlay.remove(drawable);
    }
}
