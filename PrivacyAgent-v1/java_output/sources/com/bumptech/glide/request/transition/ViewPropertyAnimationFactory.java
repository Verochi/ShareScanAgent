package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public class ViewPropertyAnimationFactory<R> implements com.bumptech.glide.request.transition.TransitionFactory<R> {
    private com.bumptech.glide.request.transition.ViewPropertyTransition<R> animation;
    private final com.bumptech.glide.request.transition.ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(com.bumptech.glide.request.transition.ViewPropertyTransition.Animator animator) {
        this.animator = animator;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public com.bumptech.glide.request.transition.Transition<R> build(com.bumptech.glide.load.DataSource dataSource, boolean z) {
        if (dataSource == com.bumptech.glide.load.DataSource.MEMORY_CACHE || !z) {
            return com.bumptech.glide.request.transition.NoTransition.get();
        }
        if (this.animation == null) {
            this.animation = new com.bumptech.glide.request.transition.ViewPropertyTransition<>(this.animator);
        }
        return this.animation;
    }
}
