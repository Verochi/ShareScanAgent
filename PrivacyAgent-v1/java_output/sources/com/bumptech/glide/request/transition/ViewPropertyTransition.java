package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public class ViewPropertyTransition<R> implements com.bumptech.glide.request.transition.Transition<R> {
    private final com.bumptech.glide.request.transition.ViewPropertyTransition.Animator animator;

    public interface Animator {
        void animate(android.view.View view);
    }

    public ViewPropertyTransition(com.bumptech.glide.request.transition.ViewPropertyTransition.Animator animator) {
        this.animator = animator;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, com.bumptech.glide.request.transition.Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() == null) {
            return false;
        }
        this.animator.animate(viewAdapter.getView());
        return false;
    }
}
