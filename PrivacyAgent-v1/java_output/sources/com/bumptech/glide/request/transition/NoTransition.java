package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public class NoTransition<R> implements com.bumptech.glide.request.transition.Transition<R> {
    static final com.bumptech.glide.request.transition.NoTransition<?> NO_ANIMATION = new com.bumptech.glide.request.transition.NoTransition<>();
    private static final com.bumptech.glide.request.transition.TransitionFactory<?> NO_ANIMATION_FACTORY = new com.bumptech.glide.request.transition.NoTransition.NoAnimationFactory();

    public static class NoAnimationFactory<R> implements com.bumptech.glide.request.transition.TransitionFactory<R> {
        @Override // com.bumptech.glide.request.transition.TransitionFactory
        public com.bumptech.glide.request.transition.Transition<R> build(com.bumptech.glide.load.DataSource dataSource, boolean z) {
            return com.bumptech.glide.request.transition.NoTransition.NO_ANIMATION;
        }
    }

    public static <R> com.bumptech.glide.request.transition.Transition<R> get() {
        return NO_ANIMATION;
    }

    public static <R> com.bumptech.glide.request.transition.TransitionFactory<R> getFactory() {
        return (com.bumptech.glide.request.transition.TransitionFactory<R>) NO_ANIMATION_FACTORY;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(java.lang.Object obj, com.bumptech.glide.request.transition.Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
