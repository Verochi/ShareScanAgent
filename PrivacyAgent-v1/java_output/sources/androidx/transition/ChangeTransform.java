package androidx.transition;

/* loaded from: classes.dex */
public class ChangeTransform extends androidx.transition.Transition {
    private static final java.lang.String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final java.lang.String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final java.lang.String PROPNAME_PARENT = "android:changeTransform:parent";
    private boolean mReparent;
    private android.graphics.Matrix mTempMatrix;
    boolean mUseOverlay;
    private static final java.lang.String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final java.lang.String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final java.lang.String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final java.lang.String[] sTransitionProperties = {PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
    private static final android.util.Property<androidx.transition.ChangeTransform.PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY = new androidx.transition.ChangeTransform.AnonymousClass1(float[].class, "nonTranslations");
    private static final android.util.Property<androidx.transition.ChangeTransform.PathAnimatorMatrix, android.graphics.PointF> TRANSLATIONS_PROPERTY = new androidx.transition.ChangeTransform.AnonymousClass2(android.graphics.PointF.class, "translations");
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;

    /* renamed from: androidx.transition.ChangeTransform$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.util.Property<androidx.transition.ChangeTransform.PathAnimatorMatrix, float[]> {
        public AnonymousClass1(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public float[] get(androidx.transition.ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public void set(androidx.transition.ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.setValues(fArr);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.util.Property<androidx.transition.ChangeTransform.PathAnimatorMatrix, android.graphics.PointF> {
        public AnonymousClass2(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public android.graphics.PointF get(androidx.transition.ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public void set(androidx.transition.ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix, android.graphics.PointF pointF) {
            pathAnimatorMatrix.setTranslation(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$3, reason: invalid class name */
    public class AnonymousClass3 extends android.animation.AnimatorListenerAdapter {
        private boolean mIsCanceled;
        private android.graphics.Matrix mTempMatrix = new android.graphics.Matrix();
        final /* synthetic */ android.graphics.Matrix val$finalEndMatrix;
        final /* synthetic */ boolean val$handleParentChange;
        final /* synthetic */ androidx.transition.ChangeTransform.PathAnimatorMatrix val$pathAnimatorMatrix;
        final /* synthetic */ androidx.transition.ChangeTransform.Transforms val$transforms;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass3(boolean z, android.graphics.Matrix matrix, android.view.View view, androidx.transition.ChangeTransform.Transforms transforms, androidx.transition.ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix) {
            this.val$handleParentChange = z;
            this.val$finalEndMatrix = matrix;
            this.val$view = view;
            this.val$transforms = transforms;
            this.val$pathAnimatorMatrix = pathAnimatorMatrix;
        }

        private void setCurrentMatrix(android.graphics.Matrix matrix) {
            this.mTempMatrix.set(matrix);
            this.val$view.setTag(androidx.transition.R.id.transition_transform, this.mTempMatrix);
            this.val$transforms.restore(this.val$view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.mIsCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (!this.mIsCanceled) {
                if (this.val$handleParentChange && androidx.transition.ChangeTransform.this.mUseOverlay) {
                    setCurrentMatrix(this.val$finalEndMatrix);
                } else {
                    this.val$view.setTag(androidx.transition.R.id.transition_transform, null);
                    this.val$view.setTag(androidx.transition.R.id.parent_matrix, null);
                }
            }
            androidx.transition.ViewUtils.setAnimationMatrix(this.val$view, null);
            this.val$transforms.restore(this.val$view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(android.animation.Animator animator) {
            setCurrentMatrix(this.val$pathAnimatorMatrix.getMatrix());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(android.animation.Animator animator) {
            androidx.transition.ChangeTransform.setIdentityTransforms(this.val$view);
        }
    }

    public static class GhostListener extends androidx.transition.TransitionListenerAdapter {
        private androidx.transition.GhostView mGhostView;
        private android.view.View mView;

        public GhostListener(android.view.View view, androidx.transition.GhostView ghostView) {
            this.mView = view;
            this.mGhostView = ghostView;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            transition.removeListener(this);
            androidx.transition.GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(androidx.transition.R.id.transition_transform, null);
            this.mView.setTag(androidx.transition.R.id.parent_matrix, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            this.mGhostView.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            this.mGhostView.setVisibility(0);
        }
    }

    public static class PathAnimatorMatrix {
        private final android.graphics.Matrix mMatrix = new android.graphics.Matrix();
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final android.view.View mView;

        public PathAnimatorMatrix(android.view.View view, float[] fArr) {
            this.mView = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.mValues = fArr2;
            this.mTranslationX = fArr2[2];
            this.mTranslationY = fArr2[5];
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            float[] fArr = this.mValues;
            fArr[2] = this.mTranslationX;
            fArr[5] = this.mTranslationY;
            this.mMatrix.setValues(fArr);
            androidx.transition.ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        public android.graphics.Matrix getMatrix() {
            return this.mMatrix;
        }

        public void setTranslation(android.graphics.PointF pointF) {
            this.mTranslationX = pointF.x;
            this.mTranslationY = pointF.y;
            setAnimationMatrix();
        }

        public void setValues(float[] fArr) {
            java.lang.System.arraycopy(fArr, 0, this.mValues, 0, fArr.length);
            setAnimationMatrix();
        }
    }

    public static class Transforms {
        final float mRotationX;
        final float mRotationY;
        final float mRotationZ;
        final float mScaleX;
        final float mScaleY;
        final float mTranslationX;
        final float mTranslationY;
        final float mTranslationZ;

        public Transforms(android.view.View view) {
            this.mTranslationX = view.getTranslationX();
            this.mTranslationY = view.getTranslationY();
            this.mTranslationZ = androidx.core.view.ViewCompat.getTranslationZ(view);
            this.mScaleX = view.getScaleX();
            this.mScaleY = view.getScaleY();
            this.mRotationX = view.getRotationX();
            this.mRotationY = view.getRotationY();
            this.mRotationZ = view.getRotation();
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof androidx.transition.ChangeTransform.Transforms)) {
                return false;
            }
            androidx.transition.ChangeTransform.Transforms transforms = (androidx.transition.ChangeTransform.Transforms) obj;
            return transforms.mTranslationX == this.mTranslationX && transforms.mTranslationY == this.mTranslationY && transforms.mTranslationZ == this.mTranslationZ && transforms.mScaleX == this.mScaleX && transforms.mScaleY == this.mScaleY && transforms.mRotationX == this.mRotationX && transforms.mRotationY == this.mRotationY && transforms.mRotationZ == this.mRotationZ;
        }

        public int hashCode() {
            float f = this.mTranslationX;
            int floatToIntBits = (f != 0.0f ? java.lang.Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.mTranslationY;
            int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? java.lang.Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.mTranslationZ;
            int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? java.lang.Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.mScaleX;
            int floatToIntBits4 = (floatToIntBits3 + (f4 != 0.0f ? java.lang.Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.mScaleY;
            int floatToIntBits5 = (floatToIntBits4 + (f5 != 0.0f ? java.lang.Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.mRotationX;
            int floatToIntBits6 = (floatToIntBits5 + (f6 != 0.0f ? java.lang.Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.mRotationY;
            int floatToIntBits7 = (floatToIntBits6 + (f7 != 0.0f ? java.lang.Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.mRotationZ;
            return floatToIntBits7 + (f8 != 0.0f ? java.lang.Float.floatToIntBits(f8) : 0);
        }

        public void restore(android.view.View view) {
            androidx.transition.ChangeTransform.setTransforms(view, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }

    public ChangeTransform() {
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new android.graphics.Matrix();
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public ChangeTransform(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new android.graphics.Matrix();
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.transition.Styleable.CHANGE_TRANSFORM);
        org.xmlpull.v1.XmlPullParser xmlPullParser = (org.xmlpull.v1.XmlPullParser) attributeSet;
        this.mUseOverlay = androidx.core.content.res.TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.mReparent = androidx.core.content.res.TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    private void captureValues(androidx.transition.TransitionValues transitionValues) {
        android.view.View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.values.put(PROPNAME_PARENT, view.getParent());
        transitionValues.values.put(PROPNAME_TRANSFORMS, new androidx.transition.ChangeTransform.Transforms(view));
        android.graphics.Matrix matrix = view.getMatrix();
        transitionValues.values.put(PROPNAME_MATRIX, (matrix == null || matrix.isIdentity()) ? null : new android.graphics.Matrix(matrix));
        if (this.mReparent) {
            android.graphics.Matrix matrix2 = new android.graphics.Matrix();
            androidx.transition.ViewUtils.transformMatrixToGlobal((android.view.ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix2);
            transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view.getTag(androidx.transition.R.id.transition_transform));
            transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view.getTag(androidx.transition.R.id.parent_matrix));
        }
    }

    private void createGhostView(android.view.ViewGroup viewGroup, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        android.view.View view = transitionValues2.view;
        android.graphics.Matrix matrix = new android.graphics.Matrix((android.graphics.Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX));
        androidx.transition.ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        androidx.transition.GhostView addGhost = androidx.transition.GhostViewUtils.addGhost(view, viewGroup, matrix);
        if (addGhost == null) {
            return;
        }
        addGhost.reserveEndViewTransition((android.view.ViewGroup) transitionValues.values.get(PROPNAME_PARENT), transitionValues.view);
        androidx.transition.Transition transition = this;
        while (true) {
            androidx.transition.Transition transition2 = transition.mParent;
            if (transition2 == null) {
                break;
            } else {
                transition = transition2;
            }
        }
        transition.addListener(new androidx.transition.ChangeTransform.GhostListener(view, addGhost));
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            android.view.View view2 = transitionValues.view;
            if (view2 != transitionValues2.view) {
                androidx.transition.ViewUtils.setTransitionAlpha(view2, 0.0f);
            }
            androidx.transition.ViewUtils.setTransitionAlpha(view, 1.0f);
        }
    }

    private android.animation.ObjectAnimator createTransformAnimator(androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2, boolean z) {
        android.graphics.Matrix matrix = (android.graphics.Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        android.graphics.Matrix matrix2 = (android.graphics.Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
        if (matrix == null) {
            matrix = androidx.transition.MatrixUtils.IDENTITY_MATRIX;
        }
        if (matrix2 == null) {
            matrix2 = androidx.transition.MatrixUtils.IDENTITY_MATRIX;
        }
        android.graphics.Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        androidx.transition.ChangeTransform.Transforms transforms = (androidx.transition.ChangeTransform.Transforms) transitionValues2.values.get(PROPNAME_TRANSFORMS);
        android.view.View view = transitionValues2.view;
        setIdentityTransforms(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        androidx.transition.ChangeTransform.PathAnimatorMatrix pathAnimatorMatrix = new androidx.transition.ChangeTransform.PathAnimatorMatrix(view, fArr);
        android.animation.ObjectAnimator ofPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, android.animation.PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new androidx.transition.FloatArrayEvaluator(new float[9]), fArr, fArr2), androidx.transition.PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        androidx.transition.ChangeTransform.AnonymousClass3 anonymousClass3 = new androidx.transition.ChangeTransform.AnonymousClass3(z, matrix3, view, transforms, pathAnimatorMatrix);
        ofPropertyValuesHolder.addListener(anonymousClass3);
        androidx.transition.AnimatorUtils.addPauseListener(ofPropertyValuesHolder, anonymousClass3);
        return ofPropertyValuesHolder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
    
        if (r4 == r5) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r5 == r4.view) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean parentsMatch(android.view.ViewGroup viewGroup, android.view.ViewGroup viewGroup2) {
        boolean z = true;
        if (isValidTarget(viewGroup) && isValidTarget(viewGroup2)) {
            androidx.transition.TransitionValues matchedTransitionValues = getMatchedTransitionValues(viewGroup, true);
            if (matchedTransitionValues == null) {
                return false;
            }
        }
    }

    public static void setIdentityTransforms(android.view.View view) {
        setTransforms(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setMatricesForParent(androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        android.graphics.Matrix matrix = (android.graphics.Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
        transitionValues2.view.setTag(androidx.transition.R.id.parent_matrix, matrix);
        android.graphics.Matrix matrix2 = this.mTempMatrix;
        matrix2.reset();
        matrix.invert(matrix2);
        android.graphics.Matrix matrix3 = (android.graphics.Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        if (matrix3 == null) {
            matrix3 = new android.graphics.Matrix();
            transitionValues.values.put(PROPNAME_MATRIX, matrix3);
        }
        matrix3.postConcat((android.graphics.Matrix) transitionValues.values.get(PROPNAME_PARENT_MATRIX));
        matrix3.postConcat(matrix2);
    }

    public static void setTransforms(android.view.View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        androidx.core.view.ViewCompat.setTranslationZ(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            return;
        }
        ((android.view.ViewGroup) transitionValues.view.getParent()).startViewTransition(transitionValues.view);
    }

    @Override // androidx.transition.Transition
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.values.containsKey(PROPNAME_PARENT) || !transitionValues2.values.containsKey(PROPNAME_PARENT)) {
            return null;
        }
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        boolean z = this.mReparent && !parentsMatch(viewGroup2, (android.view.ViewGroup) transitionValues2.values.get(PROPNAME_PARENT));
        android.graphics.Matrix matrix = (android.graphics.Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_MATRIX);
        if (matrix != null) {
            transitionValues.values.put(PROPNAME_MATRIX, matrix);
        }
        android.graphics.Matrix matrix2 = (android.graphics.Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
        if (matrix2 != null) {
            transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix2);
        }
        if (z) {
            setMatricesForParent(transitionValues, transitionValues2);
        }
        android.animation.ObjectAnimator createTransformAnimator = createTransformAnimator(transitionValues, transitionValues2, z);
        if (z && createTransformAnimator != null && this.mUseOverlay) {
            createGhostView(viewGroup, transitionValues, transitionValues2);
        } else if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            viewGroup2.endViewTransition(transitionValues.view);
        }
        return createTransformAnimator;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    @Override // androidx.transition.Transition
    public java.lang.String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean z) {
        this.mReparent = z;
    }

    public void setReparentWithOverlay(boolean z) {
        this.mUseOverlay = z;
    }
}
