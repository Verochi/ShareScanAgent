package com.google.android.material.transformation;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class FabTransformationBehavior extends com.google.android.material.transformation.ExpandableTransformationBehavior {
    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray;
    private final android.graphics.Rect tmpRect;
    private final android.graphics.RectF tmpRectF1;
    private final android.graphics.RectF tmpRectF2;

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ android.view.View val$child;
        final /* synthetic */ android.view.View val$dependency;
        final /* synthetic */ boolean val$expanded;

        public AnonymousClass1(boolean z, android.view.View view, android.view.View view2) {
            this.val$expanded = z;
            this.val$child = view;
            this.val$dependency = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (this.val$expanded) {
                return;
            }
            this.val$child.setVisibility(4);
            this.val$dependency.setAlpha(1.0f);
            this.val$dependency.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (this.val$expanded) {
                this.val$child.setVisibility(0);
                this.val$dependency.setAlpha(0.0f);
                this.val$dependency.setVisibility(4);
            }
        }
    }

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$2, reason: invalid class name */
    public class AnonymousClass2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ android.view.View val$child;

        public AnonymousClass2(android.view.View view) {
            this.val$child = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            this.val$child.invalidate();
        }
    }

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$3, reason: invalid class name */
    public class AnonymousClass3 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.CircularRevealWidget val$circularRevealChild;
        final /* synthetic */ android.graphics.drawable.Drawable val$icon;

        public AnonymousClass3(com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget, android.graphics.drawable.Drawable drawable) {
            this.val$circularRevealChild = circularRevealWidget;
            this.val$icon = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$circularRevealChild.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            this.val$circularRevealChild.setCircularRevealOverlayDrawable(this.val$icon);
        }
    }

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$4, reason: invalid class name */
    public class AnonymousClass4 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.CircularRevealWidget val$circularRevealChild;

        public AnonymousClass4(com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget) {
            this.val$circularRevealChild = circularRevealWidget;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo revealInfo = this.val$circularRevealChild.getRevealInfo();
            revealInfo.radius = Float.MAX_VALUE;
            this.val$circularRevealChild.setRevealInfo(revealInfo);
        }
    }

    public static class FabTransformationSpec {
        public com.google.android.material.animation.Positioning positioning;

        @androidx.annotation.Nullable
        public com.google.android.material.animation.MotionSpec timings;
    }

    public FabTransformationBehavior() {
        this.tmpRect = new android.graphics.Rect();
        this.tmpRectF1 = new android.graphics.RectF();
        this.tmpRectF2 = new android.graphics.RectF();
        this.tmpArray = new int[2];
    }

    public FabTransformationBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tmpRect = new android.graphics.Rect();
        this.tmpRectF1 = new android.graphics.RectF();
        this.tmpRectF2 = new android.graphics.RectF();
        this.tmpArray = new int[2];
    }

    @androidx.annotation.Nullable
    private android.view.ViewGroup calculateChildContentContainer(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findViewById = view.findViewById(com.google.android.material.R.id.mtrl_child_content_container);
        return findViewById != null ? toViewGroupOrNull(findViewById) : ((view instanceof com.google.android.material.transformation.TransformationChildLayout) || (view instanceof com.google.android.material.transformation.TransformationChildCard)) ? toViewGroupOrNull(((android.view.ViewGroup) view).getChildAt(0)) : toViewGroupOrNull(view);
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, @androidx.annotation.NonNull com.google.android.material.animation.MotionTiming motionTiming, @androidx.annotation.NonNull com.google.android.material.animation.MotionTiming motionTiming2, float f, float f2, float f3, float f4, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, f, f3);
        float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, f2, f4);
        android.graphics.Rect rect = this.tmpRect;
        view.getWindowVisibleDisplayFrame(rect);
        android.graphics.RectF rectF2 = this.tmpRectF1;
        rectF2.set(rect);
        android.graphics.RectF rectF3 = this.tmpRectF2;
        calculateWindowBounds(view, rectF3);
        rectF3.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void calculateDependencyWindowBounds(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    @androidx.annotation.NonNull
    private android.util.Pair<com.google.android.material.animation.MotionTiming, com.google.android.material.animation.MotionTiming> calculateMotionTiming(float f, float f2, boolean z, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec) {
        com.google.android.material.animation.MotionTiming timing;
        com.google.android.material.animation.MotionTiming timing2;
        if (f == 0.0f || f2 == 0.0f) {
            timing = fabTransformationSpec.timings.getTiming("translationXLinear");
            timing2 = fabTransformationSpec.timings.getTiming("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            timing = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
            timing2 = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
        } else {
            timing = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
            timing2 = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
        }
        return new android.util.Pair<>(timing, timing2);
    }

    private float calculateRevealCenterX(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull com.google.android.material.animation.Positioning positioning) {
        android.graphics.RectF rectF = this.tmpRectF1;
        android.graphics.RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        rectF2.offset(-calculateTranslationX(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float calculateRevealCenterY(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull com.google.android.material.animation.Positioning positioning) {
        android.graphics.RectF rectF = this.tmpRectF1;
        android.graphics.RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        rectF2.offset(0.0f, -calculateTranslationY(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float calculateTranslationX(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull com.google.android.material.animation.Positioning positioning) {
        float centerX;
        float centerX2;
        float f;
        android.graphics.RectF rectF = this.tmpRectF1;
        android.graphics.RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i = positioning.gravity & 7;
        if (i == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else {
            if (i != 5) {
                f = 0.0f;
                return f + positioning.xAdjustment;
            }
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f = centerX - centerX2;
        return f + positioning.xAdjustment;
    }

    private float calculateTranslationY(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull com.google.android.material.animation.Positioning positioning) {
        float centerY;
        float centerY2;
        float f;
        android.graphics.RectF rectF = this.tmpRectF1;
        android.graphics.RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i = positioning.gravity & 112;
        if (i == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else {
            if (i != 80) {
                f = 0.0f;
                return f + positioning.yAdjustment;
            }
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f = centerY - centerY2;
        return f + positioning.yAdjustment;
    }

    private float calculateValueOfAnimationAtEndOfExpansion(@androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, @androidx.annotation.NonNull com.google.android.material.animation.MotionTiming motionTiming, float f, float f2) {
        long delay = motionTiming.getDelay();
        long duration = motionTiming.getDuration();
        com.google.android.material.animation.MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        return com.google.android.material.animation.AnimationUtils.lerp(f, f2, motionTiming.getInterpolator().getInterpolation((((timing.getDelay() + timing.getDuration()) + 17) - delay) / duration));
    }

    private void calculateWindowBounds(@androidx.annotation.NonNull android.view.View view, android.graphics.RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.tmpArray);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void createChildrenFadeAnimation(android.view.View view, android.view.View view2, boolean z, boolean z2, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list, java.util.List<android.animation.Animator.AnimatorListener> list2) {
        android.view.ViewGroup calculateChildContentContainer;
        android.animation.ObjectAnimator ofFloat;
        if (view2 instanceof android.view.ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.CircularRevealWidget) && com.google.android.material.circularreveal.CircularRevealHelper.STRATEGY == 0) || (calculateChildContentContainer = calculateChildContentContainer(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    com.google.android.material.animation.ChildrenAlphaProperty.CHILDREN_ALPHA.set(calculateChildContentContainer, java.lang.Float.valueOf(0.0f));
                }
                ofFloat = android.animation.ObjectAnimator.ofFloat(calculateChildContentContainer, com.google.android.material.animation.ChildrenAlphaProperty.CHILDREN_ALPHA, 1.0f);
            } else {
                ofFloat = android.animation.ObjectAnimator.ofFloat(calculateChildContentContainer, com.google.android.material.animation.ChildrenAlphaProperty.CHILDREN_ALPHA, 0.0f);
            }
            fabTransformationSpec.timings.getTiming("contentFade").apply(ofFloat);
            list.add(ofFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createColorAnimation(@androidx.annotation.NonNull android.view.View view, android.view.View view2, boolean z, boolean z2, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list, java.util.List<android.animation.Animator.AnimatorListener> list2) {
        android.animation.ObjectAnimator ofInt;
        if (view2 instanceof com.google.android.material.circularreveal.CircularRevealWidget) {
            com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget = (com.google.android.material.circularreveal.CircularRevealWidget) view2;
            int backgroundTint = getBackgroundTint(view);
            int i = 16777215 & backgroundTint;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(backgroundTint);
                }
                ofInt = android.animation.ObjectAnimator.ofInt(circularRevealWidget, com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, i);
            } else {
                ofInt = android.animation.ObjectAnimator.ofInt(circularRevealWidget, com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, backgroundTint);
            }
            ofInt.setEvaluator(com.google.android.material.animation.ArgbEvaluatorCompat.getInstance());
            fabTransformationSpec.timings.getTiming("color").apply(ofInt);
            list.add(ofInt);
        }
    }

    private void createDependencyTranslationAnimation(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, boolean z, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list) {
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        android.util.Pair<com.google.android.material.animation.MotionTiming, com.google.android.material.animation.MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, fabTransformationSpec);
        com.google.android.material.animation.MotionTiming motionTiming = (com.google.android.material.animation.MotionTiming) calculateMotionTiming.first;
        com.google.android.material.animation.MotionTiming motionTiming2 = (com.google.android.material.animation.MotionTiming) calculateMotionTiming.second;
        android.util.Property property = android.view.View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            calculateTranslationX = this.dependencyOriginalTranslationX;
        }
        fArr[0] = calculateTranslationX;
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(view, (android.util.Property<android.view.View, java.lang.Float>) property, fArr);
        android.util.Property property2 = android.view.View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            calculateTranslationY = this.dependencyOriginalTranslationY;
        }
        fArr2[0] = calculateTranslationY;
        android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(view, (android.util.Property<android.view.View, java.lang.Float>) property2, fArr2);
        motionTiming.apply(ofFloat);
        motionTiming2.apply(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @android.annotation.TargetApi(21)
    private void createElevationAnimation(android.view.View view, @androidx.annotation.NonNull android.view.View view2, boolean z, boolean z2, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list, java.util.List<android.animation.Animator.AnimatorListener> list2) {
        android.animation.ObjectAnimator ofFloat;
        float elevation = androidx.core.view.ViewCompat.getElevation(view2) - androidx.core.view.ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = android.animation.ObjectAnimator.ofFloat(view2, (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = android.animation.ObjectAnimator.ofFloat(view2, (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Z, -elevation);
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createExpansionAnimation(@androidx.annotation.NonNull android.view.View view, android.view.View view2, boolean z, boolean z2, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, float f, float f2, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list, @androidx.annotation.NonNull java.util.List<android.animation.Animator.AnimatorListener> list2) {
        android.animation.Animator animator;
        if (view2 instanceof com.google.android.material.circularreveal.CircularRevealWidget) {
            com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget = (com.google.android.material.circularreveal.CircularRevealWidget) view2;
            float calculateRevealCenterX = calculateRevealCenterX(view, view2, fabTransformationSpec.positioning);
            float calculateRevealCenterY = calculateRevealCenterY(view, view2, fabTransformationSpec.positioning);
            ((com.google.android.material.floatingactionbutton.FloatingActionButton) view).getContentRect(this.tmpRect);
            float width = this.tmpRect.width() / 2.0f;
            com.google.android.material.animation.MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
            if (z) {
                if (!z2) {
                    circularRevealWidget.setRevealInfo(new com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo(calculateRevealCenterX, calculateRevealCenterY, width));
                }
                if (z2) {
                    width = circularRevealWidget.getRevealInfo().radius;
                }
                animator = com.google.android.material.circularreveal.CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, com.google.android.material.math.MathUtils.distanceToFurthestCorner(calculateRevealCenterX, calculateRevealCenterY, 0.0f, 0.0f, f, f2));
                animator.addListener(new com.google.android.material.transformation.FabTransformationBehavior.AnonymousClass4(circularRevealWidget));
                createPreFillRadialExpansion(view2, timing.getDelay(), (int) calculateRevealCenterX, (int) calculateRevealCenterY, width, list);
            } else {
                float f3 = circularRevealWidget.getRevealInfo().radius;
                android.animation.Animator createCircularReveal = com.google.android.material.circularreveal.CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, width);
                int i = (int) calculateRevealCenterX;
                int i2 = (int) calculateRevealCenterY;
                createPreFillRadialExpansion(view2, timing.getDelay(), i, i2, f3, list);
                createPostFillRadialExpansion(view2, timing.getDelay(), timing.getDuration(), fabTransformationSpec.timings.getTotalDuration(), i, i2, width, list);
                animator = createCircularReveal;
            }
            timing.apply(animator);
            list.add(animator);
            list2.add(com.google.android.material.circularreveal.CircularRevealCompat.createCircularRevealListener(circularRevealWidget));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createIconFadeAnimation(android.view.View view, android.view.View view2, boolean z, boolean z2, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list, @androidx.annotation.NonNull java.util.List<android.animation.Animator.AnimatorListener> list2) {
        android.animation.ObjectAnimator ofInt;
        if ((view2 instanceof com.google.android.material.circularreveal.CircularRevealWidget) && (view instanceof android.widget.ImageView)) {
            com.google.android.material.circularreveal.CircularRevealWidget circularRevealWidget = (com.google.android.material.circularreveal.CircularRevealWidget) view2;
            android.graphics.drawable.Drawable drawable = ((android.widget.ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = android.animation.ObjectAnimator.ofInt(drawable, com.google.android.material.animation.DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 0);
            } else {
                ofInt = android.animation.ObjectAnimator.ofInt(drawable, com.google.android.material.animation.DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 255);
            }
            ofInt.addUpdateListener(new com.google.android.material.transformation.FabTransformationBehavior.AnonymousClass2(view2));
            fabTransformationSpec.timings.getTiming("iconFade").apply(ofInt);
            list.add(ofInt);
            list2.add(new com.google.android.material.transformation.FabTransformationBehavior.AnonymousClass3(circularRevealWidget, drawable));
        }
    }

    private void createPostFillRadialExpansion(android.view.View view, long j, long j2, long j3, int i, int i2, float f, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list) {
        long j4 = j + j2;
        if (j4 < j3) {
            android.animation.Animator createCircularReveal = android.view.ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            createCircularReveal.setStartDelay(j4);
            createCircularReveal.setDuration(j3 - j4);
            list.add(createCircularReveal);
        }
    }

    private void createPreFillRadialExpansion(android.view.View view, long j, int i, int i2, float f, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list) {
        if (j > 0) {
            android.animation.Animator createCircularReveal = android.view.ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    private void createTranslationAnimation(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, boolean z, boolean z2, @androidx.annotation.NonNull com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec fabTransformationSpec, @androidx.annotation.NonNull java.util.List<android.animation.Animator> list, java.util.List<android.animation.Animator.AnimatorListener> list2, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        android.animation.ObjectAnimator ofFloat;
        android.animation.ObjectAnimator ofFloat2;
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        android.util.Pair<com.google.android.material.animation.MotionTiming, com.google.android.material.animation.MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, fabTransformationSpec);
        com.google.android.material.animation.MotionTiming motionTiming = (com.google.android.material.animation.MotionTiming) calculateMotionTiming.first;
        com.google.android.material.animation.MotionTiming motionTiming2 = (com.google.android.material.animation.MotionTiming) calculateMotionTiming.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-calculateTranslationX);
                view2.setTranslationY(-calculateTranslationY);
            }
            ofFloat = android.animation.ObjectAnimator.ofFloat(view2, (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_X, 0.0f);
            ofFloat2 = android.animation.ObjectAnimator.ofFloat(view2, (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Y, 0.0f);
            calculateChildVisibleBoundsAtEndOfExpansion(view2, fabTransformationSpec, motionTiming, motionTiming2, -calculateTranslationX, -calculateTranslationY, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = android.animation.ObjectAnimator.ofFloat(view2, (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_X, -calculateTranslationX);
            ofFloat2 = android.animation.ObjectAnimator.ofFloat(view2, (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Y, -calculateTranslationY);
        }
        motionTiming.apply(ofFloat);
        motionTiming2.apply(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int getBackgroundTint(@androidx.annotation.NonNull android.view.View view) {
        android.content.res.ColorStateList backgroundTintList = androidx.core.view.ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    @androidx.annotation.Nullable
    private android.view.ViewGroup toViewGroupOrNull(android.view.View view) {
        if (view instanceof android.view.ViewGroup) {
            return (android.view.ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @androidx.annotation.CallSuper
    public boolean layoutDependsOn(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2) {
        if (view.getVisibility() == 8) {
            throw new java.lang.IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((com.google.android.material.floatingactionbutton.FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @androidx.annotation.CallSuper
    public void onAttachedToLayoutParams(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @androidx.annotation.NonNull
    public android.animation.AnimatorSet onCreateExpandedStateChangeAnimation(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, boolean z, boolean z2) {
        com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec = onCreateMotionSpec(view2.getContext(), z);
        if (z) {
            this.dependencyOriginalTranslationX = view.getTranslationX();
            this.dependencyOriginalTranslationY = view.getTranslationY();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        createElevationAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
        android.graphics.RectF rectF = this.tmpRectF1;
        createTranslationAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        createDependencyTranslationAnimation(view, view2, z, onCreateMotionSpec, arrayList);
        createIconFadeAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
        createExpansionAnimation(view, view2, z, z2, onCreateMotionSpec, width, height, arrayList, arrayList2);
        createColorAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
        createChildrenFadeAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        com.google.android.material.animation.AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.addListener(new com.google.android.material.transformation.FabTransformationBehavior.AnonymousClass1(z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    public abstract com.google.android.material.transformation.FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(android.content.Context context, boolean z);
}
