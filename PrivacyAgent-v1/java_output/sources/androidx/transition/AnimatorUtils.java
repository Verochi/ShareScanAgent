package androidx.transition;

/* loaded from: classes.dex */
class AnimatorUtils {

    public interface AnimatorPauseListenerCompat {
        void onAnimationPause(android.animation.Animator animator);

        void onAnimationResume(android.animation.Animator animator);
    }

    private AnimatorUtils() {
    }

    public static void addPauseListener(@androidx.annotation.NonNull android.animation.Animator animator, @androidx.annotation.NonNull android.animation.AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public static void pause(@androidx.annotation.NonNull android.animation.Animator animator) {
        animator.pause();
    }

    public static void resume(@androidx.annotation.NonNull android.animation.Animator animator) {
        animator.resume();
    }
}
