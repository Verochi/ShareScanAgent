package androidx.transition;

@android.annotation.SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
class Styleable {

    @androidx.annotation.StyleableRes
    static final int[] TRANSITION_TARGET = {android.R.attr.targetClass, android.R.attr.targetId, android.R.attr.excludeId, android.R.attr.excludeClass, android.R.attr.targetName, android.R.attr.excludeName};

    @androidx.annotation.StyleableRes
    static final int[] TRANSITION_MANAGER = {android.R.attr.fromScene, android.R.attr.toScene, android.R.attr.transition};

    @androidx.annotation.StyleableRes
    static final int[] TRANSITION = {android.R.attr.interpolator, android.R.attr.duration, android.R.attr.startDelay, android.R.attr.matchOrder};

    @androidx.annotation.StyleableRes
    static final int[] CHANGE_BOUNDS = {android.R.attr.resizeClip};

    @androidx.annotation.StyleableRes
    static final int[] VISIBILITY_TRANSITION = {android.R.attr.transitionVisibilityMode};

    @androidx.annotation.StyleableRes
    static final int[] FADE = {android.R.attr.fadingMode};

    @androidx.annotation.StyleableRes
    static final int[] CHANGE_TRANSFORM = {android.R.attr.reparent, android.R.attr.reparentWithOverlay};

    @androidx.annotation.StyleableRes
    static final int[] SLIDE = {android.R.attr.slideEdge};

    @androidx.annotation.StyleableRes
    static final int[] TRANSITION_SET = {android.R.attr.transitionOrdering};

    @androidx.annotation.StyleableRes
    static final int[] ARC_MOTION = {android.R.attr.minimumHorizontalAngle, android.R.attr.minimumVerticalAngle, android.R.attr.maximumAngle};

    @androidx.annotation.StyleableRes
    static final int[] PATTERN_PATH_MOTION = {android.R.attr.patternPathData};

    public interface ArcMotion {

        @androidx.annotation.StyleableRes
        public static final int MAXIMUM_ANGLE = 2;

        @androidx.annotation.StyleableRes
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;

        @androidx.annotation.StyleableRes
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    public interface ChangeBounds {

        @androidx.annotation.StyleableRes
        public static final int RESIZE_CLIP = 0;
    }

    public interface ChangeTransform {

        @androidx.annotation.StyleableRes
        public static final int REPARENT = 0;

        @androidx.annotation.StyleableRes
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    public interface Fade {

        @androidx.annotation.StyleableRes
        public static final int FADING_MODE = 0;
    }

    public interface PatternPathMotion {

        @androidx.annotation.StyleableRes
        public static final int PATTERN_PATH_DATA = 0;
    }

    public interface Slide {

        @androidx.annotation.StyleableRes
        public static final int SLIDE_EDGE = 0;
    }

    public interface Transition {

        @androidx.annotation.StyleableRes
        public static final int DURATION = 1;

        @androidx.annotation.StyleableRes
        public static final int INTERPOLATOR = 0;

        @androidx.annotation.StyleableRes
        public static final int MATCH_ORDER = 3;

        @androidx.annotation.StyleableRes
        public static final int START_DELAY = 2;
    }

    public interface TransitionManager {

        @androidx.annotation.StyleableRes
        public static final int FROM_SCENE = 0;

        @androidx.annotation.StyleableRes
        public static final int TO_SCENE = 1;

        @androidx.annotation.StyleableRes
        public static final int TRANSITION = 2;
    }

    public interface TransitionSet {

        @androidx.annotation.StyleableRes
        public static final int TRANSITION_ORDERING = 0;
    }

    public interface TransitionTarget {

        @androidx.annotation.StyleableRes
        public static final int EXCLUDE_CLASS = 3;

        @androidx.annotation.StyleableRes
        public static final int EXCLUDE_ID = 2;

        @androidx.annotation.StyleableRes
        public static final int EXCLUDE_NAME = 5;

        @androidx.annotation.StyleableRes
        public static final int TARGET_CLASS = 0;

        @androidx.annotation.StyleableRes
        public static final int TARGET_ID = 1;

        @androidx.annotation.StyleableRes
        public static final int TARGET_NAME = 4;
    }

    public interface VisibilityTransition {

        @androidx.annotation.StyleableRes
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    private Styleable() {
    }
}
