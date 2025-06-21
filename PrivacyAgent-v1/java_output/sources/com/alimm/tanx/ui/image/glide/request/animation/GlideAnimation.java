package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public interface GlideAnimation<R> {

    public interface ViewAdapter {
        android.graphics.drawable.Drawable getCurrentDrawable();

        android.view.View getView();

        void setDrawable(android.graphics.drawable.Drawable drawable);
    }

    boolean animate(R r, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter viewAdapter);
}
