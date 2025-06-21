package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public final class PreloadTarget<Z> extends com.alimm.tanx.ui.image.glide.request.target.SimpleTarget<Z> {
    private PreloadTarget(int i, int i2) {
        super(i, i2);
    }

    public static <Z> com.alimm.tanx.ui.image.glide.request.target.PreloadTarget<Z> obtain(int i, int i2) {
        return new com.alimm.tanx.ui.image.glide.request.target.PreloadTarget<>(i, i2);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onResourceReady(Z z, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super Z> glideAnimation) {
        com.alimm.tanx.ui.image.glide.Glide.clear(this);
    }
}
