package com.autonavi.amap.mapcore.animation;

/* loaded from: classes12.dex */
public class GLAnimationSet extends com.autonavi.amap.mapcore.animation.GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private boolean mDirty;
    private boolean mHasAlpha;
    private long mLastEnd;
    private int mFlags = 0;
    private java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> mAnimations = new java.util.ArrayList<>();
    private com.autonavi.amap.mapcore.animation.GLTransformation mTempTransformation = new com.autonavi.amap.mapcore.animation.GLTransformation();

    public GLAnimationSet(boolean z) {
        setFlag(16, z);
        init();
    }

    private void init() {
        this.mStartTime = 0L;
    }

    private void setFlag(int i, boolean z) {
        if (z) {
            this.mFlags = i | this.mFlags;
        } else {
            this.mFlags = (~i) & this.mFlags;
        }
    }

    public void addAnimation(com.amap.api.maps.model.animation.Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        if (((this.mFlags & 64) == 0) && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if (((this.mFlags & 128) == 0) && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            long startOffset = animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration();
            this.mDuration = startOffset;
            this.mLastEnd = this.mStartOffset + startOffset;
        } else {
            long max = java.lang.Math.max(this.mLastEnd, animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration());
            this.mLastEnd = max;
            this.mDuration = max - this.mStartOffset;
        }
        this.mDirty = true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    /* renamed from: clone */
    public com.autonavi.amap.mapcore.animation.GLAnimationSet mo45clone() throws java.lang.CloneNotSupportedException {
        com.autonavi.amap.mapcore.animation.GLAnimationSet gLAnimationSet = (com.autonavi.amap.mapcore.animation.GLAnimationSet) super.mo45clone();
        gLAnimationSet.mTempTransformation = new com.autonavi.amap.mapcore.animation.GLTransformation();
        gLAnimationSet.mAnimations = new java.util.ArrayList<>();
        int size = this.mAnimations.size();
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        for (int i = 0; i < size; i++) {
            gLAnimationSet.mAnimations.add(arrayList.get(i).mo45clone());
        }
        return gLAnimationSet;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long computeDurationHint() {
        int size = this.mAnimations.size();
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        long j = 0;
        for (int i = size - 1; i >= 0; i--) {
            long computeDurationHint = arrayList.get(i).computeDurationHint();
            if (computeDurationHint > j) {
                j = computeDurationHint;
            }
        }
        return j;
    }

    public java.util.List<com.autonavi.amap.mapcore.animation.GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getDuration() {
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        if ((this.mFlags & 32) == 32) {
            return this.mDuration;
        }
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = java.lang.Math.max(j, arrayList.get(i).getDuration());
        }
        return j;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getStartTime() {
        int size = this.mAnimations.size();
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            j = java.lang.Math.min(j, arrayList.get(i).getStartTime());
        }
        return j;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean getTransformation(long j, com.autonavi.amap.mapcore.animation.GLTransformation gLTransformation) {
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        com.autonavi.amap.mapcore.animation.GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        for (int i = size - 1; i >= 0; i--) {
            com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = arrayList.get(i);
            gLTransformation2.clear();
            z2 = gLAnimation.getTransformation(j, gLTransformation, getScaleFactor()) || z2;
            z = z || gLAnimation.hasStarted();
            z3 = gLAnimation.hasEnded() && z3;
        }
        if (z) {
            try {
                if (!this.mStarted) {
                    com.amap.api.maps.model.animation.Animation.AnimationListener animationListener = this.mListener;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                    this.mStarted = true;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        if (z3 != this.mEnded) {
            com.amap.api.maps.model.animation.Animation.AnimationListener animationListener2 = this.mListener;
            if (animationListener2 != null) {
                animationListener2.onAnimationEnd();
            }
            this.mEnded = z3;
        }
        return z2;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean hasAlpha() {
        if (this.mDirty) {
            int i = 0;
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                }
                i++;
            }
        }
        return this.mHasAlpha;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void initialize() {
        boolean z;
        boolean z2;
        super.initialize();
        int i = this.mFlags;
        boolean z3 = (i & 32) == 32;
        boolean z4 = (i & 1) == 1;
        boolean z5 = (i & 2) == 2;
        boolean z6 = (i & 4) == 4;
        boolean z7 = (i & 16) == 16;
        boolean z8 = (i & 8) == 8;
        if (z7) {
            ensureInterpolator();
        }
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        long j = this.mDuration;
        boolean z9 = this.mFillAfter;
        boolean z10 = this.mFillBefore;
        int i2 = this.mRepeatMode;
        android.view.animation.Interpolator interpolator = this.mInterpolator;
        boolean z11 = z8;
        long j2 = this.mStartOffset;
        int i3 = 0;
        while (i3 < size) {
            java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList2 = arrayList;
            com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = arrayList.get(i3);
            if (z3) {
                gLAnimation.setDuration(j);
            }
            if (z4) {
                gLAnimation.setFillAfter(z9);
            }
            if (z5) {
                gLAnimation.setFillBefore(z10);
            }
            if (z6) {
                gLAnimation.setRepeatMode(i2);
            }
            if (z7) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (z11) {
                z = z4;
                z2 = z5;
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j2);
            } else {
                z = z4;
                z2 = z5;
            }
            gLAnimation.initialize();
            i3++;
            z4 = z;
            arrayList = arrayList2;
            z5 = z2;
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void reset() {
        super.reset();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void restrictDuration(long j) {
        super.restrictDuration(j);
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).restrictDuration(j);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void scaleCurrentDuration(float f) {
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).scaleCurrentDuration(f);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setDuration(long j) {
        this.mFlags |= 32;
        super.setDuration(j);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillAfter(boolean z) {
        this.mFlags |= 1;
        super.setFillAfter(z);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillBefore(boolean z) {
        this.mFlags |= 2;
        super.setFillBefore(z);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setRepeatMode(int i) {
        this.mFlags |= 4;
        super.setRepeatMode(i);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartOffset(long j) {
        this.mFlags |= 8;
        super.setStartOffset(j);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartTime(long j) {
        super.setStartTime(j);
        int size = this.mAnimations.size();
        java.util.ArrayList<com.autonavi.amap.mapcore.animation.GLAnimation> arrayList = this.mAnimations;
        for (int i = 0; i < size; i++) {
            arrayList.get(i).setStartTime(j);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }
}
