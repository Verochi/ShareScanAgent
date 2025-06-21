package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public class ViewTransition<R> implements com.bumptech.glide.request.transition.Transition<R> {
    private final com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public interface ViewTransitionAnimationFactory {
        android.view.animation.Animation build(android.content.Context context);
    }

    public ViewTransition(com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, com.bumptech.glide.request.transition.Transition.ViewAdapter viewAdapter) {
        android.view.View view = viewAdapter.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.viewTransitionAnimationFactory.build(view.getContext()));
        return false;
    }
}
