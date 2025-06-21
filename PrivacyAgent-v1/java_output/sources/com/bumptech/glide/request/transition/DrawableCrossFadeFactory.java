package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public class DrawableCrossFadeFactory implements com.bumptech.glide.request.transition.TransitionFactory<android.graphics.drawable.Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;
    private com.bumptech.glide.request.transition.DrawableCrossFadeTransition resourceTransition;

    public static class Builder {
        private static final int DEFAULT_DURATION_MS = 300;
        private final int durationMillis;
        private boolean isCrossFadeEnabled;

        public Builder() {
            this(300);
        }

        public Builder(int i) {
            this.durationMillis = i;
        }

        public com.bumptech.glide.request.transition.DrawableCrossFadeFactory build() {
            return new com.bumptech.glide.request.transition.DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
        }

        public com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder setCrossFadeEnabled(boolean z) {
            this.isCrossFadeEnabled = z;
            return this;
        }
    }

    public DrawableCrossFadeFactory(int i, boolean z) {
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    private com.bumptech.glide.request.transition.Transition<android.graphics.drawable.Drawable> getResourceTransition() {
        if (this.resourceTransition == null) {
            this.resourceTransition = new com.bumptech.glide.request.transition.DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
        }
        return this.resourceTransition;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public com.bumptech.glide.request.transition.Transition<android.graphics.drawable.Drawable> build(com.bumptech.glide.load.DataSource dataSource, boolean z) {
        return dataSource == com.bumptech.glide.load.DataSource.MEMORY_CACHE ? com.bumptech.glide.request.transition.NoTransition.get() : getResourceTransition();
    }
}
