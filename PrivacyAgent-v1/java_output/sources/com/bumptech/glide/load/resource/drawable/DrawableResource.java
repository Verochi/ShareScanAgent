package com.bumptech.glide.load.resource.drawable;

/* loaded from: classes.dex */
public abstract class DrawableResource<T extends android.graphics.drawable.Drawable> implements com.bumptech.glide.load.engine.Resource<T>, com.bumptech.glide.load.engine.Initializable {
    protected final T drawable;

    public DrawableResource(T t) {
        this.drawable = (T) com.bumptech.glide.util.Preconditions.checkNotNull(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public final T get() {
        android.graphics.drawable.Drawable.ConstantState constantState = this.drawable.getConstantState();
        return constantState == null ? this.drawable : (T) constantState.newDrawable();
    }

    public void initialize() {
        T t = this.drawable;
        if (t instanceof android.graphics.drawable.BitmapDrawable) {
            ((android.graphics.drawable.BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof com.bumptech.glide.load.resource.gif.GifDrawable) {
            ((com.bumptech.glide.load.resource.gif.GifDrawable) t).getFirstFrame().prepareToDraw();
        }
    }
}
