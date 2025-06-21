package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public class SquaringDrawable extends com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable {
    private boolean mutated;
    private com.alimm.tanx.ui.image.glide.request.target.SquaringDrawable.State state;
    private com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable wrapped;

    public static class State extends android.graphics.drawable.Drawable.ConstantState {
        private final int side;
        private final android.graphics.drawable.Drawable.ConstantState wrapped;

        public State(android.graphics.drawable.Drawable.ConstantState constantState, int i) {
            this.wrapped = constantState;
            this.side = i;
        }

        public State(com.alimm.tanx.ui.image.glide.request.target.SquaringDrawable.State state) {
            this(state.wrapped, state.side);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return new com.alimm.tanx.ui.image.glide.request.target.SquaringDrawable(this, null, resources);
        }
    }

    public SquaringDrawable(com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable glideDrawable, int i) {
        this(new com.alimm.tanx.ui.image.glide.request.target.SquaringDrawable.State(glideDrawable.getConstantState(), i), glideDrawable, null);
    }

    public SquaringDrawable(com.alimm.tanx.ui.image.glide.request.target.SquaringDrawable.State state, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable glideDrawable, android.content.res.Resources resources) {
        this.state = state;
        if (glideDrawable != null) {
            this.wrapped = glideDrawable;
        } else if (resources != null) {
            this.wrapped = (com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable) state.wrapped.newDrawable(resources);
        } else {
            this.wrapped = (com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable) state.wrapped.newDrawable();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.wrapped.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    @android.annotation.TargetApi(19)
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @android.annotation.TargetApi(11)
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
    public android.graphics.drawable.Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.side;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.side;
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
    public boolean getPadding(android.graphics.Rect rect) {
        return this.wrapped.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return this.wrapped.isAnimated();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.wrapped.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.wrapped = (com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable) this.wrapped.mutate();
            this.state = new com.alimm.tanx.ui.image.glide.request.target.SquaringDrawable.State(this.state);
            this.mutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(java.lang.Runnable runnable, long j) {
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
        this.wrapped.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(android.graphics.Rect rect) {
        super.setBounds(rect);
        this.wrapped.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.wrapped.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, android.graphics.PorterDuff.Mode mode) {
        this.wrapped.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.wrapped.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.wrapped.setFilterBitmap(z);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i) {
        this.wrapped.setLoopCount(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.wrapped.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.wrapped.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.wrapped.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(java.lang.Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.wrapped.unscheduleSelf(runnable);
    }
}
