package com.amap.api.maps.model.animation;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    protected java.lang.String animationType;
    public com.autonavi.amap.mapcore.animation.GLAnimation glAnimation;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.animation.Animation.AnimationListener mListener;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int fillMode = 0;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private long duration = 500;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private android.view.animation.Interpolator interpolator = null;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean mFillBefore = true;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean mFillAfter = false;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean mFillEnabled = false;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int mRepeatCount = 0;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int mRepeatMode = 1;
    private com.amap.api.maps.model.animation.Animation.AnimationUpdateFlags updateFlags = new com.amap.api.maps.model.animation.Animation.AnimationUpdateFlags();

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public interface AnimationListener {
        @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
        void onAnimationEnd();

        @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
        void onAnimationStart();
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static class AnimationUpdateFlags extends com.amap.api.maps.model.BaseOptions.BaseUpdateFlags {
        protected boolean mListenerUpdate = false;
        protected boolean durationUpdate = false;
        protected boolean interpolatorUpdate = false;
        protected boolean fillModeUpdate = false;
        protected boolean mFillEnabledUpdate = false;
        protected boolean mFillAfterUpdate = false;
        protected boolean mFillBeforeUpdate = false;
        protected boolean mRepeatCountUpdate = false;
        protected boolean mRepeatModeUpdate = false;

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.mListenerUpdate = false;
            this.durationUpdate = false;
            this.interpolatorUpdate = false;
            this.fillModeUpdate = false;
            this.mFillEnabledUpdate = false;
            this.mFillAfterUpdate = false;
            this.mFillBeforeUpdate = false;
            this.mRepeatCountUpdate = false;
            this.mRepeatModeUpdate = false;
        }
    }

    public class a implements com.amap.api.maps.model.animation.Animation.AnimationListener {
        private final com.amap.api.mapcore.util.ij b;
        private final com.amap.api.mapcore.util.ij c;

        /* renamed from: com.amap.api.maps.model.animation.Animation$a$1, reason: invalid class name */
        public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
            final /* synthetic */ com.amap.api.maps.model.animation.Animation a;
            final /* synthetic */ com.amap.api.maps.model.animation.Animation.AnimationListener b;

            public AnonymousClass1(com.amap.api.maps.model.animation.Animation animation, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
                this.a = animation;
                this.b = animationListener;
            }

            @Override // com.amap.api.mapcore.util.ij
            public final void runTask() {
                try {
                    com.amap.api.maps.model.animation.Animation.AnimationListener animationListener = this.b;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        /* renamed from: com.amap.api.maps.model.animation.Animation$a$2, reason: invalid class name */
        public class AnonymousClass2 extends com.amap.api.mapcore.util.ij {
            final /* synthetic */ com.amap.api.maps.model.animation.Animation a;
            final /* synthetic */ com.amap.api.maps.model.animation.Animation.AnimationListener b;

            public AnonymousClass2(com.amap.api.maps.model.animation.Animation animation, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
                this.a = animation;
                this.b = animationListener;
            }

            @Override // com.amap.api.mapcore.util.ij
            public final void runTask() {
                try {
                    com.amap.api.maps.model.animation.Animation.AnimationListener animationListener = this.b;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd();
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        private a(com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
            this.b = new com.amap.api.maps.model.animation.Animation.a.AnonymousClass1(com.amap.api.maps.model.animation.Animation.this, animationListener);
            this.c = new com.amap.api.maps.model.animation.Animation.a.AnonymousClass2(com.amap.api.maps.model.animation.Animation.this, animationListener);
        }

        public /* synthetic */ a(com.amap.api.maps.model.animation.Animation animation, com.amap.api.maps.model.animation.Animation.AnimationListener animationListener, byte b) {
            this(animationListener);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationEnd() {
            com.amap.api.mapcore.util.dj.a().a(this.c);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationStart() {
            com.amap.api.mapcore.util.dj.a().a(this.b);
        }
    }

    public Animation() {
        this.animationType = "typeAnimtionBase";
        this.glAnimation = null;
        this.glAnimation = new com.autonavi.amap.mapcore.animation.GLAnimation();
        this.animationType = getAnimationType();
    }

    private void a(boolean z) {
        this.mFillEnabled = z;
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillEnabled(z);
        }
        this.updateFlags.mFillEnabledUpdate = true;
    }

    private void b(boolean z) {
        this.mFillAfter = z;
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillAfter(z);
        }
        this.updateFlags.mFillAfterUpdate = true;
    }

    private void c(boolean z) {
        this.mFillBefore = z;
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillBefore(z);
        }
        this.updateFlags.mFillBeforeUpdate = true;
    }

    public abstract java.lang.String getAnimationType();

    public int getFillMode() {
        return this.fillMode;
    }

    public int getRepeatCount() {
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatCount();
        }
        return 0;
    }

    public int getRepeatMode() {
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatMode();
        }
        return 1;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public com.amap.api.maps.model.animation.Animation.AnimationUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public void setAnimationListener(com.amap.api.maps.model.animation.Animation.AnimationListener animationListener) {
        this.mListener = new com.amap.api.maps.model.animation.Animation.a(this, animationListener, (byte) 0);
        this.glAnimation.setAnimationListener(animationListener);
        this.updateFlags.mListenerUpdate = true;
    }

    public void setDuration(long j) {
        this.duration = j;
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setDuration(j);
        }
        this.updateFlags.durationUpdate = true;
    }

    public void setFillMode(int i) {
        this.fillMode = i;
        if (i == 0) {
            b(true);
            c(false);
            a(false);
        } else {
            b(false);
            a(true);
            c(true);
        }
        this.updateFlags.fillModeUpdate = true;
    }

    public void setInterpolator(android.view.animation.Interpolator interpolator) {
        this.interpolator = interpolator;
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setInterpolator(interpolator);
        }
        this.updateFlags.interpolatorUpdate = true;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatCount(i);
        }
        this.updateFlags.mRepeatCountUpdate = true;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        com.autonavi.amap.mapcore.animation.GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatMode(i);
        }
        this.updateFlags.mRepeatModeUpdate = true;
    }
}
