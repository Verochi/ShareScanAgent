package com.google.android.material.internal;

/* loaded from: classes22.dex */
class ViewGroupOverlayApi14 extends com.google.android.material.internal.ViewOverlayApi14 implements com.google.android.material.internal.ViewGroupOverlayImpl {
    public ViewGroupOverlayApi14(android.content.Context context, android.view.ViewGroup viewGroup, android.view.View view) {
        super(context, viewGroup, view);
    }

    public static com.google.android.material.internal.ViewGroupOverlayApi14 createFrom(android.view.ViewGroup viewGroup) {
        return (com.google.android.material.internal.ViewGroupOverlayApi14) com.google.android.material.internal.ViewOverlayApi14.createFrom(viewGroup);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void add(@androidx.annotation.NonNull android.view.View view) {
        this.overlayViewGroup.add(view);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void remove(@androidx.annotation.NonNull android.view.View view) {
        this.overlayViewGroup.remove(view);
    }
}
