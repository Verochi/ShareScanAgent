package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class TransitionBuilder {
    private static final java.lang.String TAG = "TransitionBuilder";

    public static androidx.constraintlayout.motion.widget.MotionScene.Transition buildTransition(androidx.constraintlayout.motion.widget.MotionScene motionScene, int i, int i2, androidx.constraintlayout.widget.ConstraintSet constraintSet, int i3, androidx.constraintlayout.widget.ConstraintSet constraintSet2) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = new androidx.constraintlayout.motion.widget.MotionScene.Transition(i, motionScene, i2, i3);
        updateConstraintSetInMotionScene(motionScene, transition, constraintSet, constraintSet2);
        return transition;
    }

    private static void updateConstraintSetInMotionScene(androidx.constraintlayout.motion.widget.MotionScene motionScene, androidx.constraintlayout.motion.widget.MotionScene.Transition transition, androidx.constraintlayout.widget.ConstraintSet constraintSet, androidx.constraintlayout.widget.ConstraintSet constraintSet2) {
        int startConstraintSetId = transition.getStartConstraintSetId();
        int endConstraintSetId = transition.getEndConstraintSetId();
        motionScene.setConstraintSet(startConstraintSetId, constraintSet);
        motionScene.setConstraintSet(endConstraintSetId, constraintSet2);
    }

    public static void validate(androidx.constraintlayout.motion.widget.MotionLayout motionLayout) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            throw new java.lang.RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
        }
        if (!motionScene.validateLayout(motionLayout)) {
            throw new java.lang.RuntimeException("MotionLayout doesn't have the right motion scene.");
        }
        if (motionScene.mCurrentTransition == null || motionScene.getDefinedTransitions().isEmpty()) {
            throw new java.lang.RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
        }
    }
}
