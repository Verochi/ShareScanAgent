package com.alimm.tanx.ui.image.glide.load.resource.drawable;

/* loaded from: classes.dex */
public abstract class DrawableResource<T extends android.graphics.drawable.Drawable> implements com.alimm.tanx.ui.image.glide.load.engine.Resource<T> {
    protected final T drawable;

    public DrawableResource(T t) {
        if (t == null) {
            throw new java.lang.NullPointerException("Drawable must not be null!");
        }
        this.drawable = t;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final T get() {
        return (T) this.drawable.getConstantState().newDrawable();
    }
}
