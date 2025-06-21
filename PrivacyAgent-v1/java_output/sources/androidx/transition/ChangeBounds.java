package androidx.transition;

/* loaded from: classes.dex */
public class ChangeBounds extends androidx.transition.Transition {
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;
    private static final java.lang.String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final java.lang.String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final java.lang.String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final java.lang.String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final java.lang.String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final java.lang.String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private static final android.util.Property<android.graphics.drawable.Drawable, android.graphics.PointF> DRAWABLE_ORIGIN_PROPERTY = new androidx.transition.ChangeBounds.AnonymousClass1(android.graphics.PointF.class, "boundsOrigin");
    private static final android.util.Property<androidx.transition.ChangeBounds.ViewBounds, android.graphics.PointF> TOP_LEFT_PROPERTY = new androidx.transition.ChangeBounds.AnonymousClass2(android.graphics.PointF.class, "topLeft");
    private static final android.util.Property<androidx.transition.ChangeBounds.ViewBounds, android.graphics.PointF> BOTTOM_RIGHT_PROPERTY = new androidx.transition.ChangeBounds.AnonymousClass3(android.graphics.PointF.class, "bottomRight");
    private static final android.util.Property<android.view.View, android.graphics.PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new androidx.transition.ChangeBounds.AnonymousClass4(android.graphics.PointF.class, "bottomRight");
    private static final android.util.Property<android.view.View, android.graphics.PointF> TOP_LEFT_ONLY_PROPERTY = new androidx.transition.ChangeBounds.AnonymousClass5(android.graphics.PointF.class, "topLeft");
    private static final android.util.Property<android.view.View, android.graphics.PointF> POSITION_PROPERTY = new androidx.transition.ChangeBounds.AnonymousClass6(android.graphics.PointF.class, com.alibaba.sdk.android.oss.common.RequestParameters.POSITION);
    private static androidx.transition.RectEvaluator sRectEvaluator = new androidx.transition.RectEvaluator();

    /* renamed from: androidx.transition.ChangeBounds$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.util.Property<android.graphics.drawable.Drawable, android.graphics.PointF> {
        private android.graphics.Rect mBounds;

        public AnonymousClass1(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
            this.mBounds = new android.graphics.Rect();
        }

        @Override // android.util.Property
        public android.graphics.PointF get(android.graphics.drawable.Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            android.graphics.Rect rect = this.mBounds;
            return new android.graphics.PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(android.graphics.drawable.Drawable drawable, android.graphics.PointF pointF) {
            drawable.copyBounds(this.mBounds);
            this.mBounds.offsetTo(java.lang.Math.round(pointF.x), java.lang.Math.round(pointF.y));
            drawable.setBounds(this.mBounds);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$10, reason: invalid class name */
    public class AnonymousClass10 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ android.graphics.drawable.BitmapDrawable val$drawable;
        final /* synthetic */ android.view.ViewGroup val$sceneRoot;
        final /* synthetic */ float val$transitionAlpha;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass10(android.view.ViewGroup viewGroup, android.graphics.drawable.BitmapDrawable bitmapDrawable, android.view.View view, float f) {
            this.val$sceneRoot = viewGroup;
            this.val$drawable = bitmapDrawable;
            this.val$view = view;
            this.val$transitionAlpha = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            androidx.transition.ViewUtils.getOverlay(this.val$sceneRoot).remove(this.val$drawable);
            androidx.transition.ViewUtils.setTransitionAlpha(this.val$view, this.val$transitionAlpha);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.util.Property<androidx.transition.ChangeBounds.ViewBounds, android.graphics.PointF> {
        public AnonymousClass2(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public android.graphics.PointF get(androidx.transition.ChangeBounds.ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(androidx.transition.ChangeBounds.ViewBounds viewBounds, android.graphics.PointF pointF) {
            viewBounds.setTopLeft(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$3, reason: invalid class name */
    public static class AnonymousClass3 extends android.util.Property<androidx.transition.ChangeBounds.ViewBounds, android.graphics.PointF> {
        public AnonymousClass3(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public android.graphics.PointF get(androidx.transition.ChangeBounds.ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(androidx.transition.ChangeBounds.ViewBounds viewBounds, android.graphics.PointF pointF) {
            viewBounds.setBottomRight(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$4, reason: invalid class name */
    public static class AnonymousClass4 extends android.util.Property<android.view.View, android.graphics.PointF> {
        public AnonymousClass4(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public android.graphics.PointF get(android.view.View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(android.view.View view, android.graphics.PointF pointF) {
            androidx.transition.ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), java.lang.Math.round(pointF.x), java.lang.Math.round(pointF.y));
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$5, reason: invalid class name */
    public static class AnonymousClass5 extends android.util.Property<android.view.View, android.graphics.PointF> {
        public AnonymousClass5(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public android.graphics.PointF get(android.view.View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(android.view.View view, android.graphics.PointF pointF) {
            androidx.transition.ViewUtils.setLeftTopRightBottom(view, java.lang.Math.round(pointF.x), java.lang.Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$6, reason: invalid class name */
    public static class AnonymousClass6 extends android.util.Property<android.view.View, android.graphics.PointF> {
        public AnonymousClass6(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public android.graphics.PointF get(android.view.View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(android.view.View view, android.graphics.PointF pointF) {
            int round = java.lang.Math.round(pointF.x);
            int round2 = java.lang.Math.round(pointF.y);
            androidx.transition.ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$7, reason: invalid class name */
    public class AnonymousClass7 extends android.animation.AnimatorListenerAdapter {
        private androidx.transition.ChangeBounds.ViewBounds mViewBounds;
        final /* synthetic */ androidx.transition.ChangeBounds.ViewBounds val$viewBounds;

        public AnonymousClass7(androidx.transition.ChangeBounds.ViewBounds viewBounds) {
            this.val$viewBounds = viewBounds;
            this.mViewBounds = viewBounds;
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$8, reason: invalid class name */
    public class AnonymousClass8 extends android.animation.AnimatorListenerAdapter {
        private boolean mIsCanceled;
        final /* synthetic */ int val$endBottom;
        final /* synthetic */ int val$endLeft;
        final /* synthetic */ int val$endRight;
        final /* synthetic */ int val$endTop;
        final /* synthetic */ android.graphics.Rect val$finalClip;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass8(android.view.View view, android.graphics.Rect rect, int i, int i2, int i3, int i4) {
            this.val$view = view;
            this.val$finalClip = rect;
            this.val$endLeft = i;
            this.val$endTop = i2;
            this.val$endRight = i3;
            this.val$endBottom = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.mIsCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (this.mIsCanceled) {
                return;
            }
            androidx.core.view.ViewCompat.setClipBounds(this.val$view, this.val$finalClip);
            androidx.transition.ViewUtils.setLeftTopRightBottom(this.val$view, this.val$endLeft, this.val$endTop, this.val$endRight, this.val$endBottom);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$9, reason: invalid class name */
    public class AnonymousClass9 extends androidx.transition.TransitionListenerAdapter {
        boolean mCanceled = false;
        final /* synthetic */ android.view.ViewGroup val$parent;

        public AnonymousClass9(android.view.ViewGroup viewGroup) {
            this.val$parent = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            androidx.transition.ViewGroupUtils.suppressLayout(this.val$parent, false);
            this.mCanceled = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            if (!this.mCanceled) {
                androidx.transition.ViewGroupUtils.suppressLayout(this.val$parent, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            androidx.transition.ViewGroupUtils.suppressLayout(this.val$parent, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            androidx.transition.ViewGroupUtils.suppressLayout(this.val$parent, true);
        }
    }

    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private android.view.View mView;

        public ViewBounds(android.view.View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            androidx.transition.ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        public void setBottomRight(android.graphics.PointF pointF) {
            this.mRight = java.lang.Math.round(pointF.x);
            this.mBottom = java.lang.Math.round(pointF.y);
            int i = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i;
            if (this.mTopLeftCalls == i) {
                setLeftTopRightBottom();
            }
        }

        public void setTopLeft(android.graphics.PointF pointF) {
            this.mLeft = java.lang.Math.round(pointF.x);
            this.mTop = java.lang.Math.round(pointF.y);
            int i = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i;
            if (i == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public ChangeBounds(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.transition.Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = androidx.core.content.res.TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (android.content.res.XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }

    private void captureValues(androidx.transition.TransitionValues transitionValues) {
        android.view.View view = transitionValues.view;
        if (!androidx.core.view.ViewCompat.isLaidOut(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.values.put(PROPNAME_BOUNDS, new android.graphics.Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        if (this.mReparent) {
            transitionValues.view.getLocationInWindow(this.mTempLocation);
            transitionValues.values.put(PROPNAME_WINDOW_X, java.lang.Integer.valueOf(this.mTempLocation[0]));
            transitionValues.values.put(PROPNAME_WINDOW_Y, java.lang.Integer.valueOf(this.mTempLocation[1]));
        }
        if (this.mResizeClip) {
            transitionValues.values.put(PROPNAME_CLIP, androidx.core.view.ViewCompat.getClipBounds(view));
        }
    }

    private boolean parentMatches(android.view.View view, android.view.View view2) {
        if (!this.mReparent) {
            return true;
        }
        androidx.transition.TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.view) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@androidx.annotation.NonNull androidx.transition.TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues2) {
        int i;
        android.view.View view;
        int i2;
        android.graphics.Rect rect;
        android.animation.ObjectAnimator objectAnimator;
        android.animation.Animator mergeAnimators;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        java.util.Map<java.lang.String, java.lang.Object> map = transitionValues.values;
        java.util.Map<java.lang.String, java.lang.Object> map2 = transitionValues2.values;
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) map.get(PROPNAME_PARENT);
        android.view.ViewGroup viewGroup3 = (android.view.ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        android.view.View view2 = transitionValues2.view;
        if (!parentMatches(viewGroup2, viewGroup3)) {
            int intValue = ((java.lang.Integer) transitionValues.values.get(PROPNAME_WINDOW_X)).intValue();
            int intValue2 = ((java.lang.Integer) transitionValues.values.get(PROPNAME_WINDOW_Y)).intValue();
            int intValue3 = ((java.lang.Integer) transitionValues2.values.get(PROPNAME_WINDOW_X)).intValue();
            int intValue4 = ((java.lang.Integer) transitionValues2.values.get(PROPNAME_WINDOW_Y)).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.mTempLocation);
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            view2.draw(new android.graphics.Canvas(createBitmap));
            android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(createBitmap);
            float transitionAlpha = androidx.transition.ViewUtils.getTransitionAlpha(view2);
            androidx.transition.ViewUtils.setTransitionAlpha(view2, 0.0f);
            androidx.transition.ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
            androidx.transition.PathMotion pathMotion = getPathMotion();
            int[] iArr = this.mTempLocation;
            int i3 = iArr[0];
            int i4 = iArr[1];
            android.animation.ObjectAnimator ofPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, androidx.transition.PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath(intValue - i3, intValue2 - i4, intValue3 - i3, intValue4 - i4)));
            ofPropertyValuesHolder.addListener(new androidx.transition.ChangeBounds.AnonymousClass10(viewGroup, bitmapDrawable, view2, transitionAlpha));
            return ofPropertyValuesHolder;
        }
        android.graphics.Rect rect2 = (android.graphics.Rect) transitionValues.values.get(PROPNAME_BOUNDS);
        android.graphics.Rect rect3 = (android.graphics.Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
        int i5 = rect2.left;
        int i6 = rect3.left;
        int i7 = rect2.top;
        int i8 = rect3.top;
        int i9 = rect2.right;
        int i10 = rect3.right;
        int i11 = rect2.bottom;
        int i12 = rect3.bottom;
        int i13 = i9 - i5;
        int i14 = i11 - i7;
        int i15 = i10 - i6;
        int i16 = i12 - i8;
        android.graphics.Rect rect4 = (android.graphics.Rect) transitionValues.values.get(PROPNAME_CLIP);
        android.graphics.Rect rect5 = (android.graphics.Rect) transitionValues2.values.get(PROPNAME_CLIP);
        if ((i13 == 0 || i14 == 0) && (i15 == 0 || i16 == 0)) {
            i = 0;
        } else {
            i = (i5 == i6 && i7 == i8) ? 0 : 1;
            if (i9 != i10 || i11 != i12) {
                i++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i++;
        }
        if (i <= 0) {
            return null;
        }
        if (this.mResizeClip) {
            view = view2;
            androidx.transition.ViewUtils.setLeftTopRightBottom(view, i5, i7, java.lang.Math.max(i13, i15) + i5, java.lang.Math.max(i14, i16) + i7);
            android.animation.ObjectAnimator ofPointF = (i5 == i6 && i7 == i8) ? null : androidx.transition.ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath(i5, i7, i6, i8));
            if (rect4 == null) {
                i2 = 0;
                rect = new android.graphics.Rect(0, 0, i13, i14);
            } else {
                i2 = 0;
                rect = rect4;
            }
            android.graphics.Rect rect6 = rect5 == null ? new android.graphics.Rect(i2, i2, i15, i16) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                androidx.core.view.ViewCompat.setClipBounds(view, rect);
                androidx.transition.RectEvaluator rectEvaluator = sRectEvaluator;
                java.lang.Object[] objArr = new java.lang.Object[2];
                objArr[i2] = rect;
                objArr[1] = rect6;
                android.animation.ObjectAnimator ofObject = android.animation.ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                ofObject.addListener(new androidx.transition.ChangeBounds.AnonymousClass8(view, rect5, i6, i8, i10, i12));
                objectAnimator = ofObject;
            }
            mergeAnimators = androidx.transition.TransitionUtils.mergeAnimators(ofPointF, objectAnimator);
        } else {
            view = view2;
            androidx.transition.ViewUtils.setLeftTopRightBottom(view, i5, i7, i9, i11);
            if (i != 2) {
                mergeAnimators = (i5 == i6 && i7 == i8) ? androidx.transition.ObjectAnimatorUtils.ofPointF(view, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(i9, i11, i10, i12)) : androidx.transition.ObjectAnimatorUtils.ofPointF(view, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(i5, i7, i6, i8));
            } else if (i13 == i15 && i14 == i16) {
                mergeAnimators = androidx.transition.ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath(i5, i7, i6, i8));
            } else {
                androidx.transition.ChangeBounds.ViewBounds viewBounds = new androidx.transition.ChangeBounds.ViewBounds(view);
                android.animation.ObjectAnimator ofPointF2 = androidx.transition.ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath(i5, i7, i6, i8));
                android.animation.ObjectAnimator ofPointF3 = androidx.transition.ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(i9, i11, i10, i12));
                android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
                animatorSet.playTogether(ofPointF2, ofPointF3);
                animatorSet.addListener(new androidx.transition.ChangeBounds.AnonymousClass7(viewBounds));
                mergeAnimators = animatorSet;
            }
        }
        if (view.getParent() instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup4 = (android.view.ViewGroup) view.getParent();
            androidx.transition.ViewGroupUtils.suppressLayout(viewGroup4, true);
            addListener(new androidx.transition.ChangeBounds.AnonymousClass9(viewGroup4));
        }
        return mergeAnimators;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    public java.lang.String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z) {
        this.mResizeClip = z;
    }
}
