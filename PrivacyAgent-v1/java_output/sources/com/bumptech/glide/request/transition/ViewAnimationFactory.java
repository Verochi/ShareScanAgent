package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public class ViewAnimationFactory<R> implements com.bumptech.glide.request.transition.TransitionFactory<R> {
    private com.bumptech.glide.request.transition.Transition<R> transition;
    private final com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public static class ConcreteViewTransitionAnimationFactory implements com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory {
        private final android.view.animation.Animation animation;

        public ConcreteViewTransitionAnimationFactory(android.view.animation.Animation animation) {
            this.animation = animation;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public android.view.animation.Animation build(android.content.Context context) {
            return this.animation;
        }
    }

    public static class ResourceViewTransitionAnimationFactory implements com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory {
        private final int animationId;

        public ResourceViewTransitionAnimationFactory(int i) {
            this.animationId = i;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public android.view.animation.Animation build(android.content.Context context) {
            return android.view.animation.AnimationUtils.loadAnimation(context, this.animationId);
        }
    }

    public ViewAnimationFactory(int i) {
        this(new com.bumptech.glide.request.transition.ViewAnimationFactory.ResourceViewTransitionAnimationFactory(i));
    }

    public ViewAnimationFactory(android.view.animation.Animation animation) {
        this(new com.bumptech.glide.request.transition.ViewAnimationFactory.ConcreteViewTransitionAnimationFactory(animation));
    }

    public ViewAnimationFactory(com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public com.bumptech.glide.request.transition.Transition<R> build(com.bumptech.glide.load.DataSource dataSource, boolean z) {
        if (dataSource == com.bumptech.glide.load.DataSource.MEMORY_CACHE || !z) {
            return com.bumptech.glide.request.transition.NoTransition.get();
        }
        if (this.transition == null) {
            this.transition = new com.bumptech.glide.request.transition.ViewTransition(this.viewTransitionAnimationFactory);
        }
        return this.transition;
    }
}
