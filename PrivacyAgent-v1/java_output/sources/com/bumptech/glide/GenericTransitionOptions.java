package com.bumptech.glide;

/* loaded from: classes.dex */
public final class GenericTransitionOptions<TranscodeType> extends com.bumptech.glide.TransitionOptions<com.bumptech.glide.GenericTransitionOptions<TranscodeType>, TranscodeType> {
    @androidx.annotation.NonNull
    public static <TranscodeType> com.bumptech.glide.GenericTransitionOptions<TranscodeType> with(int i) {
        return new com.bumptech.glide.GenericTransitionOptions().transition(i);
    }

    @androidx.annotation.NonNull
    public static <TranscodeType> com.bumptech.glide.GenericTransitionOptions<TranscodeType> with(@androidx.annotation.NonNull com.bumptech.glide.request.transition.TransitionFactory<? super TranscodeType> transitionFactory) {
        return new com.bumptech.glide.GenericTransitionOptions().transition(transitionFactory);
    }

    @androidx.annotation.NonNull
    public static <TranscodeType> com.bumptech.glide.GenericTransitionOptions<TranscodeType> with(@androidx.annotation.NonNull com.bumptech.glide.request.transition.ViewPropertyTransition.Animator animator) {
        return new com.bumptech.glide.GenericTransitionOptions().transition(animator);
    }

    @androidx.annotation.NonNull
    public static <TranscodeType> com.bumptech.glide.GenericTransitionOptions<TranscodeType> withNoTransition() {
        return new com.bumptech.glide.GenericTransitionOptions().dontTransition();
    }
}
