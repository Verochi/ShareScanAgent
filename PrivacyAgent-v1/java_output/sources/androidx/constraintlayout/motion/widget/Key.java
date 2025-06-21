package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public abstract class Key {
    static final java.lang.String ALPHA = "alpha";
    static final java.lang.String CUSTOM = "CUSTOM";
    static final java.lang.String ELEVATION = "elevation";
    static final java.lang.String PIVOT_X = "transformPivotX";
    static final java.lang.String PIVOT_Y = "transformPivotY";
    static final java.lang.String PROGRESS = "progress";
    static final java.lang.String ROTATION = "rotation";
    static final java.lang.String ROTATION_X = "rotationX";
    static final java.lang.String ROTATION_Y = "rotationY";
    static final java.lang.String SCALE_X = "scaleX";
    static final java.lang.String SCALE_Y = "scaleY";
    static final java.lang.String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    static final java.lang.String TRANSLATION_X = "translationX";
    static final java.lang.String TRANSLATION_Y = "translationY";
    static final java.lang.String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    static final java.lang.String WAVE_OFFSET = "waveOffset";
    static final java.lang.String WAVE_PERIOD = "wavePeriod";
    static final java.lang.String WAVE_VARIES_BY = "waveVariesBy";
    java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    java.lang.String mTargetString;
    protected int mType;

    public Key() {
        int i = UNSET;
        this.mFramePosition = i;
        this.mTargetId = i;
        this.mTargetString = null;
    }

    public abstract void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap);

    public abstract void getAttributeNames(java.util.HashSet<java.lang.String> hashSet);

    public abstract void load(android.content.Context context, android.util.AttributeSet attributeSet);

    public boolean matches(java.lang.String str) {
        java.lang.String str2 = this.mTargetString;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void setInterpolation(java.util.HashMap<java.lang.String, java.lang.Integer> hashMap) {
    }

    public abstract void setValue(java.lang.String str, java.lang.Object obj);

    public boolean toBoolean(java.lang.Object obj) {
        return obj instanceof java.lang.Boolean ? ((java.lang.Boolean) obj).booleanValue() : java.lang.Boolean.parseBoolean(obj.toString());
    }

    public float toFloat(java.lang.Object obj) {
        return obj instanceof java.lang.Float ? ((java.lang.Float) obj).floatValue() : java.lang.Float.parseFloat(obj.toString());
    }

    public int toInt(java.lang.Object obj) {
        return obj instanceof java.lang.Integer ? ((java.lang.Integer) obj).intValue() : java.lang.Integer.parseInt(obj.toString());
    }
}
