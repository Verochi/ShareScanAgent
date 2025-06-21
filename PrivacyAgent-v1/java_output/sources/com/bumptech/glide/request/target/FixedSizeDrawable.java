package com.bumptech.glide.request.target;

/* loaded from: classes.dex */
public class FixedSizeDrawable extends android.graphics.drawable.Drawable {
    private final android.graphics.RectF bounds;
    private final android.graphics.Matrix matrix;
    private boolean mutated;
    private com.bumptech.glide.request.target.FixedSizeDrawable.State state;
    private android.graphics.drawable.Drawable wrapped;
    private final android.graphics.RectF wrappedRect;

    public static final class State extends android.graphics.drawable.Drawable.ConstantState {
        final int height;
        final int width;
        private final android.graphics.drawable.Drawable.ConstantState wrapped;

        public State(android.graphics.drawable.Drawable.ConstantState constantState, int i, int i2) {
            this.wrapped = constantState;
            this.width = i;
            this.height = i2;
        }

        public State(com.bumptech.glide.request.target.FixedSizeDrawable.State state) {
            this(state.wrapped, state.width, state.height);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable() {
            return new com.bumptech.glide.request.target.FixedSizeDrawable(this, this.wrapped.newDrawable());
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return new com.bumptech.glide.request.target.FixedSizeDrawable(this, this.wrapped.newDrawable(resources));
        }
    }

    public FixedSizeDrawable(android.graphics.drawable.Drawable drawable, int i, int i2) {
        this(new com.bumptech.glide.request.target.FixedSizeDrawable.State(drawable.getConstantState(), i, i2), drawable);
    }

    public FixedSizeDrawable(com.bumptech.glide.request.target.FixedSizeDrawable.State state, android.graphics.drawable.Drawable drawable) {
        this.state = (com.bumptech.glide.request.target.FixedSizeDrawable.State) com.bumptech.glide.util.Preconditions.checkNotNull(state);
        this.wrapped = (android.graphics.drawable.Drawable) com.bumptech.glide.util.Preconditions.checkNotNull(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.matrix = new android.graphics.Matrix();
        this.wrappedRect = new android.graphics.RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.bounds = new android.graphics.RectF();
    }

    private void updateMatrix() {
        this.matrix.setRectToRect(this.wrappedRect, this.bounds, android.graphics.Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        canvas.save();
        canvas.concat(this.matrix);
        this.wrapped.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.RequiresApi(19)
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.Callback getCallback() {
        return this.wrapped.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.NonNull
    public android.graphics.drawable.Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.width;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@androidx.annotation.NonNull android.graphics.Rect rect) {
        return this.wrapped.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.NonNull
    public android.graphics.drawable.Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.wrapped = this.wrapped.mutate();
            this.state = new com.bumptech.glide.request.target.FixedSizeDrawable.State(this.state);
            this.mutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@androidx.annotation.NonNull java.lang.Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.wrapped.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.wrapped.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.bounds.set(i, i2, i3, i4);
        updateMatrix();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@androidx.annotation.NonNull android.graphics.Rect rect) {
        super.setBounds(rect);
        this.bounds.set(rect);
        updateMatrix();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.wrapped.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) {
        this.wrapped.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @java.lang.Deprecated
    public void setDither(boolean z) {
        this.wrapped.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.wrapped.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.wrapped.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.wrapped.unscheduleSelf(runnable);
    }
}
