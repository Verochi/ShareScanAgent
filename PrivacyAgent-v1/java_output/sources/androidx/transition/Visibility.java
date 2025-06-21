package androidx.transition;

/* loaded from: classes.dex */
public abstract class Visibility extends androidx.transition.Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final java.lang.String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    private int mMode;
    static final java.lang.String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final java.lang.String PROPNAME_PARENT = "android:visibility:parent";
    private static final java.lang.String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};

    /* renamed from: androidx.transition.Visibility$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.transition.TransitionListenerAdapter {
        final /* synthetic */ android.view.View val$finalOverlayView;
        final /* synthetic */ android.view.ViewGroup val$overlayHost;
        final /* synthetic */ android.view.View val$startView;

        public AnonymousClass1(android.view.ViewGroup viewGroup, android.view.View view, android.view.View view2) {
            this.val$overlayHost = viewGroup;
            this.val$finalOverlayView = view;
            this.val$startView = view2;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            this.val$startView.setTag(androidx.transition.R.id.save_overlay_view, null);
            androidx.transition.ViewGroupUtils.getOverlay(this.val$overlayHost).remove(this.val$finalOverlayView);
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            androidx.transition.ViewGroupUtils.getOverlay(this.val$overlayHost).remove(this.val$finalOverlayView);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            if (this.val$finalOverlayView.getParent() == null) {
                androidx.transition.ViewGroupUtils.getOverlay(this.val$overlayHost).add(this.val$finalOverlayView);
            } else {
                androidx.transition.Visibility.this.cancel();
            }
        }
    }

    public static class DisappearListener extends android.animation.AnimatorListenerAdapter implements androidx.transition.Transition.TransitionListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat {
        boolean mCanceled = false;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final android.view.ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final android.view.View mView;

        public DisappearListener(android.view.View view, int i, boolean z) {
            this.mView = view;
            this.mFinalVisibility = i;
            this.mParent = (android.view.ViewGroup) view.getParent();
            this.mSuppressLayout = z;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (!this.mCanceled) {
                androidx.transition.ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
                android.view.ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            suppressLayout(false);
        }

        private void suppressLayout(boolean z) {
            android.view.ViewGroup viewGroup;
            if (!this.mSuppressLayout || this.mLayoutSuppressed == z || (viewGroup = this.mParent) == null) {
                return;
            }
            this.mLayoutSuppressed = z;
            androidx.transition.ViewGroupUtils.suppressLayout(viewGroup, z);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            hideViewWhenNotCanceled();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(android.animation.Animator animator) {
            if (this.mCanceled) {
                return;
            }
            androidx.transition.ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(android.animation.Animator animator) {
            if (this.mCanceled) {
                return;
            }
            androidx.transition.ViewUtils.setTransitionVisibility(this.mView, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            hideViewWhenNotCanceled();
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            suppressLayout(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@androidx.annotation.NonNull androidx.transition.Transition transition) {
            suppressLayout(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@androidx.annotation.NonNull androidx.transition.Transition transition) {
        }
    }

    @android.annotation.SuppressLint({"UniqueConstants"})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Mode {
    }

    public static class VisibilityInfo {
        android.view.ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        android.view.ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;
    }

    public Visibility() {
        this.mMode = 3;
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public Visibility(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 3;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.transition.Styleable.VISIBILITY_TRANSITION);
        int namedInt = androidx.core.content.res.TypedArrayUtils.getNamedInt(obtainStyledAttributes, (android.content.res.XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }

    private void captureValues(androidx.transition.TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, java.lang.Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    private androidx.transition.Visibility.VisibilityInfo getVisibilityChangeInfo(androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        androidx.transition.Visibility.VisibilityInfo visibilityInfo = new androidx.transition.Visibility.VisibilityInfo();
        visibilityInfo.mVisibilityChange = false;
        visibilityInfo.mFadeIn = false;
        if (transitionValues == null || !transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mStartVisibility = -1;
            visibilityInfo.mStartParent = null;
        } else {
            visibilityInfo.mStartVisibility = ((java.lang.Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.mStartParent = (android.view.ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mEndVisibility = -1;
            visibilityInfo.mEndParent = null;
        } else {
            visibilityInfo.mEndVisibility = ((java.lang.Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.mEndParent = (android.view.ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i = visibilityInfo.mStartVisibility;
            int i2 = visibilityInfo.mEndVisibility;
            if (i == i2 && visibilityInfo.mStartParent == visibilityInfo.mEndParent) {
                return visibilityInfo;
            }
            if (i != i2) {
                if (i == 0) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                } else if (i2 == 0) {
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                }
            } else if (visibilityInfo.mEndParent == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            } else if (visibilityInfo.mStartParent == null) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            }
        } else if (transitionValues == null && visibilityInfo.mEndVisibility == 0) {
            visibilityInfo.mFadeIn = true;
            visibilityInfo.mVisibilityChange = true;
        } else if (transitionValues2 == null && visibilityInfo.mStartVisibility == 0) {
            visibilityInfo.mFadeIn = false;
            visibilityInfo.mVisibilityChange = true;
        }
        return visibilityInfo;
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
        androidx.transition.Visibility.VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange) {
            return null;
        }
        if (visibilityChangeInfo.mStartParent == null && visibilityChangeInfo.mEndParent == null) {
            return null;
        }
        return visibilityChangeInfo.mFadeIn ? onAppear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility) : onDisappear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    public java.lang.String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        androidx.transition.Visibility.VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.mVisibilityChange) {
            return visibilityChangeInfo.mStartVisibility == 0 || visibilityChangeInfo.mEndVisibility == 0;
        }
        return false;
    }

    public boolean isVisible(androidx.transition.TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        return ((java.lang.Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((android.view.View) transitionValues.values.get(PROPNAME_PARENT)) != null;
    }

    public android.animation.Animator onAppear(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        return null;
    }

    public android.animation.Animator onAppear(android.view.ViewGroup viewGroup, androidx.transition.TransitionValues transitionValues, int i, androidx.transition.TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            android.view.View view = (android.view.View) transitionValues2.view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).mVisibilityChange) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    public android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, android.view.View view, androidx.transition.TransitionValues transitionValues, androidx.transition.TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0089, code lost:
    
        if (r17.mCanRemoveViews != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, androidx.transition.TransitionValues transitionValues, int i, androidx.transition.TransitionValues transitionValues2, int i2) {
        android.view.View view;
        boolean z;
        boolean z2;
        android.view.View view2;
        if ((this.mMode & 2) != 2 || transitionValues == null) {
            return null;
        }
        android.view.View view3 = transitionValues.view;
        android.view.View view4 = transitionValues2 != null ? transitionValues2.view : null;
        int i3 = androidx.transition.R.id.save_overlay_view;
        android.view.View view5 = (android.view.View) view3.getTag(i3);
        if (view5 != null) {
            view2 = null;
            z2 = true;
        } else if (view4 == null || view4.getParent() == null) {
            if (view4 != null) {
                view = null;
                z = false;
                if (z) {
                    if (view3.getParent() != null) {
                        if (view3.getParent() instanceof android.view.View) {
                            android.view.View view6 = (android.view.View) view3.getParent();
                            if (getVisibilityChangeInfo(getTransitionValues(view6, true), getMatchedTransitionValues(view6, true)).mVisibilityChange) {
                                int id = view6.getId();
                                if (view6.getParent() == null) {
                                    if (id != -1) {
                                        if (viewGroup.findViewById(id) != null) {
                                        }
                                    }
                                }
                            } else {
                                view4 = androidx.transition.TransitionUtils.copyViewImage(viewGroup, view3, view6);
                            }
                        }
                    }
                    view2 = view;
                    z2 = false;
                    view5 = view3;
                }
                z2 = false;
                android.view.View view7 = view;
                view5 = view4;
                view2 = view7;
            }
            view4 = null;
            view = null;
            z = true;
            if (z) {
            }
            z2 = false;
            android.view.View view72 = view;
            view5 = view4;
            view2 = view72;
        } else {
            if (i2 == 4 || view3 == view4) {
                view = view4;
                z = false;
                view4 = null;
                if (z) {
                }
                z2 = false;
                android.view.View view722 = view;
                view5 = view4;
                view2 = view722;
            }
            view4 = null;
            view = null;
            z = true;
            if (z) {
            }
            z2 = false;
            android.view.View view7222 = view;
            view5 = view4;
            view2 = view7222;
        }
        if (view5 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            androidx.transition.ViewUtils.setTransitionVisibility(view2, 0);
            android.animation.Animator onDisappear = onDisappear(viewGroup, view2, transitionValues, transitionValues2);
            if (onDisappear != null) {
                androidx.transition.Visibility.DisappearListener disappearListener = new androidx.transition.Visibility.DisappearListener(view2, i2, true);
                onDisappear.addListener(disappearListener);
                androidx.transition.AnimatorUtils.addPauseListener(onDisappear, disappearListener);
                addListener(disappearListener);
            } else {
                androidx.transition.ViewUtils.setTransitionVisibility(view2, visibility);
            }
            return onDisappear;
        }
        if (!z2) {
            int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_LOCATION);
            int i4 = iArr[0];
            int i5 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view5.offsetLeftAndRight((i4 - iArr2[0]) - view5.getLeft());
            view5.offsetTopAndBottom((i5 - iArr2[1]) - view5.getTop());
            androidx.transition.ViewGroupUtils.getOverlay(viewGroup).add(view5);
        }
        android.animation.Animator onDisappear2 = onDisappear(viewGroup, view5, transitionValues, transitionValues2);
        if (!z2) {
            if (onDisappear2 == null) {
                androidx.transition.ViewGroupUtils.getOverlay(viewGroup).remove(view5);
            } else {
                view3.setTag(i3, view5);
                addListener(new androidx.transition.Visibility.AnonymousClass1(viewGroup, view5, view3));
            }
        }
        return onDisappear2;
    }

    public void setMode(int i) {
        if ((i & (-4)) != 0) {
            throw new java.lang.IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i;
    }
}
