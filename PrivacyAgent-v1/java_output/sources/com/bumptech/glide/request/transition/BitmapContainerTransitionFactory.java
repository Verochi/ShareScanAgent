package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public abstract class BitmapContainerTransitionFactory<R> implements com.bumptech.glide.request.transition.TransitionFactory<R> {
    private final com.bumptech.glide.request.transition.TransitionFactory<android.graphics.drawable.Drawable> realFactory;

    public final class BitmapGlideAnimation implements com.bumptech.glide.request.transition.Transition<R> {
        private final com.bumptech.glide.request.transition.Transition<android.graphics.drawable.Drawable> transition;

        public BitmapGlideAnimation(com.bumptech.glide.request.transition.Transition<android.graphics.drawable.Drawable> transition) {
            this.transition = transition;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean transition(R r, com.bumptech.glide.request.transition.Transition.ViewAdapter viewAdapter) {
            return this.transition.transition(new android.graphics.drawable.BitmapDrawable(viewAdapter.getView().getResources(), com.bumptech.glide.request.transition.BitmapContainerTransitionFactory.this.getBitmap(r)), viewAdapter);
        }
    }

    public BitmapContainerTransitionFactory(com.bumptech.glide.request.transition.TransitionFactory<android.graphics.drawable.Drawable> transitionFactory) {
        this.realFactory = transitionFactory;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public com.bumptech.glide.request.transition.Transition<R> build(com.bumptech.glide.load.DataSource dataSource, boolean z) {
        return new com.bumptech.glide.request.transition.BitmapContainerTransitionFactory.BitmapGlideAnimation(this.realFactory.build(dataSource, z));
    }

    public abstract android.graphics.Bitmap getBitmap(R r);
}
