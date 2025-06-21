package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class MotionLayout extends androidx.constraintlayout.widget.ConstraintLayout implements androidx.core.view.NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final java.lang.String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime;
    private int mBeginState;
    private android.graphics.RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private androidx.constraintlayout.motion.widget.MotionLayout.DecelerateInterpolator mDecelerateLogic;
    private androidx.constraintlayout.motion.widget.DesignTool mDesignTool;
    androidx.constraintlayout.motion.widget.MotionLayout.DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    android.view.animation.Interpolator mInterpolator;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private androidx.constraintlayout.motion.widget.KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    androidx.constraintlayout.motion.widget.MotionLayout.Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> mOnHideHelpers;
    private java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> mOnShowHelpers;
    float mPostInterpolationPosition;
    private android.view.View mRegionView;
    androidx.constraintlayout.motion.widget.MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private androidx.constraintlayout.motion.widget.MotionLayout.StateCache mStateCache;
    private androidx.constraintlayout.motion.utils.StopLogic mStopLogic;
    private boolean mTemporalInterpolator;
    java.util.ArrayList<java.lang.Integer> mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener mTransitionListener;
    private java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> mTransitionListeners;
    float mTransitionPosition;
    androidx.constraintlayout.motion.widget.MotionLayout.TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.view.View val$target;

        public AnonymousClass1(android.view.View view) {
            this.val$target = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$target.setNestedScrollingEnabled(true);
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;

        static {
            int[] iArr = new int[androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.values().length];
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = iArr;
            try {
                iArr[androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public class DecelerateInterpolator extends androidx.constraintlayout.motion.widget.MotionInterpolator {
        float maxA;
        float initalV = 0.0f;
        float currentP = 0.0f;

        public DecelerateInterpolator() {
        }

        public void config(float f, float f2, float f3) {
            this.initalV = f;
            this.currentP = f2;
            this.maxA = f3;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2;
            float f3;
            float f4 = this.initalV;
            if (f4 > 0.0f) {
                float f5 = this.maxA;
                if (f4 / f5 < f) {
                    f = f4 / f5;
                }
                androidx.constraintlayout.motion.widget.MotionLayout.this.mLastVelocity = f4 - (f5 * f);
                f2 = (f4 * f) - (((f5 * f) * f) / 2.0f);
                f3 = this.currentP;
            } else {
                float f6 = this.maxA;
                if ((-f4) / f6 < f) {
                    f = (-f4) / f6;
                }
                androidx.constraintlayout.motion.widget.MotionLayout.this.mLastVelocity = (f6 * f) + f4;
                f2 = (f4 * f) + (((f6 * f) * f) / 2.0f);
                f3 = this.currentP;
            }
            return f2 + f3;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return androidx.constraintlayout.motion.widget.MotionLayout.this.mLastVelocity;
        }
    }

    public class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        android.graphics.DashPathEffect mDashPathEffect;
        android.graphics.Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        android.graphics.Paint mPaint;
        android.graphics.Paint mPaintGraph;
        android.graphics.Paint mPaintKeyframes;
        android.graphics.Path mPath;
        int[] mPathMode;
        float[] mPoints;
        private float[] mRectangle;
        int mShadowTranslate;
        android.graphics.Paint mTextPaint;
        final int RED_COLOR = -21965;
        final int KEYFRAME_COLOR = -2067046;
        final int GRAPH_COLOR = -13391360;
        final int SHADOW_COLOR = 1996488704;
        final int DIAMOND_SIZE = 10;
        android.graphics.Rect mBounds = new android.graphics.Rect();
        boolean mPresentationMode = false;

        public DevModeDraw() {
            this.mShadowTranslate = 1;
            android.graphics.Paint paint = new android.graphics.Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            android.graphics.Paint paint2 = new android.graphics.Paint();
            this.mPaintKeyframes = paint2;
            paint2.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(android.graphics.Paint.Style.STROKE);
            android.graphics.Paint paint3 = new android.graphics.Paint();
            this.mPaintGraph = paint3;
            paint3.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(android.graphics.Paint.Style.STROKE);
            android.graphics.Paint paint4 = new android.graphics.Paint();
            this.mTextPaint = paint4;
            paint4.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(androidx.constraintlayout.motion.widget.MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            android.graphics.Paint paint5 = new android.graphics.Paint();
            this.mFillPaint = paint5;
            paint5.setAntiAlias(true);
            android.graphics.DashPathEffect dashPathEffect = new android.graphics.DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(android.graphics.Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(android.graphics.Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.mKeyFrameCount; i++) {
                int i2 = this.mPathMode[i];
                if (i2 == 1) {
                    z = true;
                }
                if (i2 == 2) {
                    z2 = true;
                }
            }
            if (z) {
                drawPathRelative(canvas);
            }
            if (z2) {
                drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(android.graphics.Canvas canvas) {
            float[] fArr = this.mPoints;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(java.lang.Math.min(f, f3), java.lang.Math.max(f2, f4), java.lang.Math.max(f, f3), java.lang.Math.max(f2, f4), this.mPaintGraph);
            canvas.drawLine(java.lang.Math.min(f, f3), java.lang.Math.min(f2, f4), java.lang.Math.min(f, f3), java.lang.Math.max(f2, f4), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(android.graphics.Canvas canvas, float f, float f2) {
            float[] fArr = this.mPoints;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = java.lang.Math.min(f3, f5);
            float max = java.lang.Math.max(f4, f6);
            float min2 = f - java.lang.Math.min(f3, f5);
            float max2 = java.lang.Math.max(f4, f6) - f2;
            java.lang.String str = "" + (((int) (((min2 * 100.0f) / java.lang.Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((min2 / 2.0f) - (this.mBounds.width() / 2)) + min, f2 - 20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, java.lang.Math.min(f3, f5), f2, this.mPaintGraph);
            java.lang.String str2 = "" + (((int) (((max2 * 100.0f) / java.lang.Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, f + 5.0f, max - ((max2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f, f2, f, java.lang.Math.max(f4, f6), this.mPaintGraph);
        }

        private void drawPathRelative(android.graphics.Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(android.graphics.Canvas canvas, float f, float f2) {
            float[] fArr = this.mPoints;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float hypot = (float) java.lang.Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (hypot * hypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            android.graphics.Path path = new android.graphics.Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float hypot2 = (float) java.lang.Math.hypot(f10 - f, f11 - f2);
            java.lang.String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, f10, f11, this.mPaintGraph);
        }

        private void drawPathScreenTicks(android.graphics.Canvas canvas, float f, float f2, int i, int i2) {
            java.lang.String str = "" + (((int) ((((f - (i / 2)) * 100.0f) / (androidx.constraintlayout.motion.widget.MotionLayout.this.getWidth() - i)) + 0.5d)) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((f / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, f2 - 20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, java.lang.Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
            java.lang.String str2 = "" + (((int) ((((f2 - (i2 / 2)) * 100.0f) / (androidx.constraintlayout.motion.widget.MotionLayout.this.getHeight() - i2)) + 0.5d)) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f, f2, f, java.lang.Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(android.graphics.Canvas canvas, androidx.constraintlayout.motion.widget.MotionController motionController) {
            this.mPath.reset();
            for (int i = 0; i <= 50; i++) {
                motionController.buildRect(i / 50, this.mRectangle, 0);
                android.graphics.Path path = this.mPath;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                android.graphics.Path path2 = this.mPath;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                android.graphics.Path path3 = this.mPath;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                android.graphics.Path path4 = this.mPath;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(androidx.core.internal.view.SupportMenu.CATEGORY_MASK);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(android.graphics.Canvas canvas, int i, int i2, androidx.constraintlayout.motion.widget.MotionController motionController) {
            int i3;
            int i4;
            float f;
            float f2;
            int i5;
            android.view.View view = motionController.mView;
            if (view != null) {
                i3 = view.getWidth();
                i4 = motionController.mView.getHeight();
            } else {
                i3 = 0;
                i4 = 0;
            }
            for (int i6 = 1; i6 < i2 - 1; i6++) {
                if (i != 4 || this.mPathMode[i6 - 1] != 0) {
                    float[] fArr = this.mKeyFramePoints;
                    int i7 = i6 * 2;
                    float f3 = fArr[i7];
                    float f4 = fArr[i7 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f3, f4 + 10.0f);
                    this.mPath.lineTo(f3 + 10.0f, f4);
                    this.mPath.lineTo(f3, f4 - 10.0f);
                    this.mPath.lineTo(f3 - 10.0f, f4);
                    this.mPath.close();
                    int i8 = i6 - 1;
                    motionController.getKeyFrame(i8);
                    if (i == 4) {
                        int i9 = this.mPathMode[i8];
                        if (i9 == 1) {
                            drawPathRelativeTicks(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (i9 == 2) {
                            drawPathCartesianTicks(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (i9 == 3) {
                            i5 = 3;
                            f = f4;
                            f2 = f3;
                            drawPathScreenTicks(canvas, f3 - 0.0f, f4 - 0.0f, i3, i4);
                            canvas.drawPath(this.mPath, this.mFillPaint);
                        }
                        f = f4;
                        f2 = f3;
                        i5 = 3;
                        canvas.drawPath(this.mPath, this.mFillPaint);
                    } else {
                        f = f4;
                        f2 = f3;
                        i5 = 3;
                    }
                    if (i == 2) {
                        drawPathRelativeTicks(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == i5) {
                        drawPathCartesianTicks(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 6) {
                        drawPathScreenTicks(canvas, f2 - 0.0f, f - 0.0f, i3, i4);
                    }
                    canvas.drawPath(this.mPath, this.mFillPaint);
                }
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(android.graphics.Canvas canvas, float f, float f2, float f3, float f4) {
            canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
            canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
        }

        public void draw(android.graphics.Canvas canvas, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> hashMap, int i, int i2) {
            if (hashMap == null || hashMap.size() == 0) {
                return;
            }
            canvas.save();
            if (!androidx.constraintlayout.motion.widget.MotionLayout.this.isInEditMode() && (i2 & 1) == 2) {
                java.lang.String str = androidx.constraintlayout.motion.widget.MotionLayout.this.getContext().getResources().getResourceName(androidx.constraintlayout.motion.widget.MotionLayout.this.mEndState) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + androidx.constraintlayout.motion.widget.MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, androidx.constraintlayout.motion.widget.MotionLayout.this.getHeight() - 30, this.mTextPaint);
                canvas.drawText(str, 11.0f, androidx.constraintlayout.motion.widget.MotionLayout.this.getHeight() - 29, this.mPaint);
            }
            for (androidx.constraintlayout.motion.widget.MotionController motionController : hashMap.values()) {
                int drawPath = motionController.getDrawPath();
                if (i2 > 0 && drawPath == 0) {
                    drawPath = 1;
                }
                if (drawPath != 0) {
                    this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                    if (drawPath >= 1) {
                        int i3 = i / 16;
                        float[] fArr = this.mPoints;
                        if (fArr == null || fArr.length != i3 * 2) {
                            this.mPoints = new float[i3 * 2];
                            this.mPath = new android.graphics.Path();
                        }
                        int i4 = this.mShadowTranslate;
                        canvas.translate(i4, i4);
                        this.mPaint.setColor(1996488704);
                        this.mFillPaint.setColor(1996488704);
                        this.mPaintKeyframes.setColor(1996488704);
                        this.mPaintGraph.setColor(1996488704);
                        motionController.buildPath(this.mPoints, i3);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        this.mPaint.setColor(-21965);
                        this.mPaintKeyframes.setColor(-2067046);
                        this.mFillPaint.setColor(-2067046);
                        this.mPaintGraph.setColor(-13391360);
                        int i5 = this.mShadowTranslate;
                        canvas.translate(-i5, -i5);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        if (drawPath == 5) {
                            drawRectangle(canvas, motionController);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void drawAll(android.graphics.Canvas canvas, int i, int i2, androidx.constraintlayout.motion.widget.MotionController motionController) {
            if (i == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i == 2) {
                drawPathRelative(canvas);
            }
            if (i == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i, i2, motionController);
        }

        public void getTextBounds(java.lang.String str, android.graphics.Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    public class Model {
        int mEndId;
        int mStartId;
        androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer mLayoutStart = new androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer();
        androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer mLayoutEnd = new androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer();
        androidx.constraintlayout.widget.ConstraintSet mStart = null;
        androidx.constraintlayout.widget.ConstraintSet mEnd = null;

        public Model() {
        }

        private void debugLayout(java.lang.String str, androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer) {
            java.lang.String str2 = str + " " + androidx.constraintlayout.motion.widget.Debug.getName((android.view.View) constraintWidgetContainer.getCompanionWidget());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str2);
            sb.append("  ========= ");
            sb.append(constraintWidgetContainer);
            int size = constraintWidgetContainer.getChildren().size();
            for (int i = 0; i < size; i++) {
                java.lang.String str3 = str2 + "[" + i + "] ";
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("");
                sb2.append(constraintWidget.mTop.mTarget != null ? androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE : "_");
                java.lang.String sb3 = sb2.toString();
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append(sb3);
                sb4.append(constraintWidget.mBottom.mTarget != null ? "B" : "_");
                java.lang.String sb5 = sb4.toString();
                java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                sb6.append(sb5);
                sb6.append(constraintWidget.mLeft.mTarget != null ? "L" : "_");
                java.lang.String sb7 = sb6.toString();
                java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                sb8.append(sb7);
                sb8.append(constraintWidget.mRight.mTarget != null ? "R" : "_");
                java.lang.String sb9 = sb8.toString();
                android.view.View view = (android.view.View) constraintWidget.getCompanionWidget();
                java.lang.String name = androidx.constraintlayout.motion.widget.Debug.getName(view);
                if (view instanceof android.widget.TextView) {
                    name = name + "(" + ((java.lang.Object) ((android.widget.TextView) view).getText()) + ")";
                }
                java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
                sb10.append(str3);
                sb10.append("  ");
                sb10.append(name);
                sb10.append(" ");
                sb10.append(constraintWidget);
                sb10.append(" ");
                sb10.append(sb9);
            }
            java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
            sb11.append(str2);
            sb11.append(" done. ");
        }

        private void debugLayoutParam(java.lang.String str, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(" ");
            sb.append(layoutParams.startToStart != -1 ? "SS" : "__");
            java.lang.String sb2 = sb.toString();
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(sb2);
            sb3.append(layoutParams.startToEnd != -1 ? "|SE" : "|__");
            java.lang.String sb4 = sb3.toString();
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append(sb4);
            sb5.append(layoutParams.endToStart != -1 ? "|ES" : "|__");
            java.lang.String sb6 = sb5.toString();
            java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
            sb7.append(sb6);
            sb7.append(layoutParams.endToEnd != -1 ? "|EE" : "|__");
            java.lang.String sb8 = sb7.toString();
            java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
            sb9.append(sb8);
            sb9.append(layoutParams.leftToLeft != -1 ? "|LL" : "|__");
            java.lang.String sb10 = sb9.toString();
            java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
            sb11.append(sb10);
            sb11.append(layoutParams.leftToRight != -1 ? "|LR" : "|__");
            java.lang.String sb12 = sb11.toString();
            java.lang.StringBuilder sb13 = new java.lang.StringBuilder();
            sb13.append(sb12);
            sb13.append(layoutParams.rightToLeft != -1 ? "|RL" : "|__");
            java.lang.String sb14 = sb13.toString();
            java.lang.StringBuilder sb15 = new java.lang.StringBuilder();
            sb15.append(sb14);
            sb15.append(layoutParams.rightToRight != -1 ? "|RR" : "|__");
            java.lang.String sb16 = sb15.toString();
            java.lang.StringBuilder sb17 = new java.lang.StringBuilder();
            sb17.append(sb16);
            sb17.append(layoutParams.topToTop != -1 ? "|TT" : "|__");
            java.lang.String sb18 = sb17.toString();
            java.lang.StringBuilder sb19 = new java.lang.StringBuilder();
            sb19.append(sb18);
            sb19.append(layoutParams.topToBottom != -1 ? "|TB" : "|__");
            java.lang.String sb20 = sb19.toString();
            java.lang.StringBuilder sb21 = new java.lang.StringBuilder();
            sb21.append(sb20);
            sb21.append(layoutParams.bottomToTop != -1 ? "|BT" : "|__");
            java.lang.String sb22 = sb21.toString();
            java.lang.StringBuilder sb23 = new java.lang.StringBuilder();
            sb23.append(sb22);
            sb23.append(layoutParams.bottomToBottom != -1 ? "|BB" : "|__");
            java.lang.String sb24 = sb23.toString();
            java.lang.StringBuilder sb25 = new java.lang.StringBuilder();
            sb25.append(str);
            sb25.append(sb24);
        }

        private void debugWidget(java.lang.String str, androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget) {
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String str4;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(" ");
            java.lang.String str5 = "__";
            if (constraintWidget.mTop.mTarget != null) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
                sb2.append(constraintWidget.mTop.mTarget.mType == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP ? androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE : "B");
                str2 = sb2.toString();
            } else {
                str2 = "__";
            }
            sb.append(str2);
            java.lang.String sb3 = sb.toString();
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(sb3);
            if (constraintWidget.mBottom.mTarget != null) {
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                sb5.append("B");
                sb5.append(constraintWidget.mBottom.mTarget.mType == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP ? androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE : "B");
                str3 = sb5.toString();
            } else {
                str3 = "__";
            }
            sb4.append(str3);
            java.lang.String sb6 = sb4.toString();
            java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
            sb7.append(sb6);
            if (constraintWidget.mLeft.mTarget != null) {
                java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                sb8.append("L");
                sb8.append(constraintWidget.mLeft.mTarget.mType == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT ? "L" : "R");
                str4 = sb8.toString();
            } else {
                str4 = "__";
            }
            sb7.append(str4);
            java.lang.String sb9 = sb7.toString();
            java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
            sb10.append(sb9);
            if (constraintWidget.mRight.mTarget != null) {
                java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
                sb11.append("R");
                sb11.append(constraintWidget.mRight.mTarget.mType == androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT ? "L" : "R");
                str5 = sb11.toString();
            }
            sb10.append(str5);
            java.lang.String sb12 = sb10.toString();
            java.lang.StringBuilder sb13 = new java.lang.StringBuilder();
            sb13.append(str);
            sb13.append(sb12);
            sb13.append(" ---  ");
            sb13.append(constraintWidget);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void setupConstraintWidget(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.widget.ConstraintSet constraintSet) {
            android.util.SparseArray<androidx.constraintlayout.solver.widgets.ConstraintWidget> sparseArray = new android.util.SparseArray<>();
            androidx.constraintlayout.widget.Constraints.LayoutParams layoutParams = new androidx.constraintlayout.widget.Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(androidx.constraintlayout.motion.widget.MotionLayout.this.getId(), constraintWidgetContainer);
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
                sparseArray.put(((android.view.View) next.getCompanionWidget()).getId(), next);
            }
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next2 = it2.next();
                android.view.View view = (android.view.View) next2.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                next2.setWidth(constraintSet.getWidth(view.getId()));
                next2.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof androidx.constraintlayout.widget.ConstraintHelper) {
                    constraintSet.applyToHelper((androidx.constraintlayout.widget.ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof androidx.constraintlayout.widget.Barrier) {
                        ((androidx.constraintlayout.widget.Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(androidx.constraintlayout.motion.widget.MotionLayout.this.getLayoutDirection());
                androidx.constraintlayout.motion.widget.MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    next2.setVisibility(view.getVisibility());
                } else {
                    next2.setVisibility(constraintSet.getVisibility(view.getId()));
                }
            }
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
            while (it3.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next3 = it3.next();
                if (next3 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) {
                    androidx.constraintlayout.widget.ConstraintHelper constraintHelper = (androidx.constraintlayout.widget.ConstraintHelper) next3.getCompanionWidget();
                    androidx.constraintlayout.solver.widgets.Helper helper = (androidx.constraintlayout.solver.widgets.Helper) next3;
                    constraintHelper.updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((androidx.constraintlayout.solver.widgets.VirtualLayout) helper).captureWidgets();
                }
            }
        }

        public void build() {
            int childCount = androidx.constraintlayout.motion.widget.MotionLayout.this.getChildCount();
            androidx.constraintlayout.motion.widget.MotionLayout.this.mFrameArrayList.clear();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = androidx.constraintlayout.motion.widget.MotionLayout.this.getChildAt(i);
                androidx.constraintlayout.motion.widget.MotionLayout.this.mFrameArrayList.put(childAt, new androidx.constraintlayout.motion.widget.MotionController(childAt));
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt2 = androidx.constraintlayout.motion.widget.MotionLayout.this.getChildAt(i2);
                androidx.constraintlayout.motion.widget.MotionController motionController = androidx.constraintlayout.motion.widget.MotionLayout.this.mFrameArrayList.get(childAt2);
                if (motionController != null) {
                    if (this.mStart != null) {
                        androidx.constraintlayout.solver.widgets.ConstraintWidget widget = getWidget(this.mLayoutStart, childAt2);
                        if (widget != null) {
                            motionController.setStartState(widget, this.mStart);
                        } else if (androidx.constraintlayout.motion.widget.MotionLayout.this.mDebugPath != 0) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(androidx.constraintlayout.motion.widget.Debug.getLocation());
                            sb.append("no widget for  ");
                            sb.append(androidx.constraintlayout.motion.widget.Debug.getName(childAt2));
                            sb.append(" (");
                            sb.append(childAt2.getClass().getName());
                            sb.append(")");
                        }
                    }
                    if (this.mEnd != null) {
                        androidx.constraintlayout.solver.widgets.ConstraintWidget widget2 = getWidget(this.mLayoutEnd, childAt2);
                        if (widget2 != null) {
                            motionController.setEndState(widget2, this.mEnd);
                        } else if (androidx.constraintlayout.motion.widget.MotionLayout.this.mDebugPath != 0) {
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append(androidx.constraintlayout.motion.widget.Debug.getLocation());
                            sb2.append("no widget for  ");
                            sb2.append(androidx.constraintlayout.motion.widget.Debug.getName(childAt2));
                            sb2.append(" (");
                            sb2.append(childAt2.getClass().getName());
                            sb2.append(")");
                        }
                    }
                }
            }
        }

        public void copy(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer2) {
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> children = constraintWidgetContainer.getChildren();
            java.util.HashMap<androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget> hashMap = new java.util.HashMap<>();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it = children.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next = it.next();
                androidx.constraintlayout.solver.widgets.ConstraintWidget barrier = next instanceof androidx.constraintlayout.solver.widgets.Barrier ? new androidx.constraintlayout.solver.widgets.Barrier() : next instanceof androidx.constraintlayout.solver.widgets.Guideline ? new androidx.constraintlayout.solver.widgets.Guideline() : next instanceof androidx.constraintlayout.solver.widgets.Flow ? new androidx.constraintlayout.solver.widgets.Flow() : next instanceof androidx.constraintlayout.solver.widgets.Helper ? new androidx.constraintlayout.solver.widgets.HelperWidget() : new androidx.constraintlayout.solver.widgets.ConstraintWidget();
                constraintWidgetContainer2.add(barrier);
                hashMap.put(next, barrier);
            }
            java.util.Iterator<androidx.constraintlayout.solver.widgets.ConstraintWidget> it2 = children.iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget next2 = it2.next();
                hashMap.get(next2).copy(next2, hashMap);
            }
        }

        public androidx.constraintlayout.solver.widgets.ConstraintWidget getWidget(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, android.view.View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i = 0; i < size; i++) {
                androidx.constraintlayout.solver.widgets.ConstraintWidget constraintWidget = children.get(i);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void initFrom(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer, androidx.constraintlayout.widget.ConstraintSet constraintSet, androidx.constraintlayout.widget.ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer();
            this.mLayoutEnd = new androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(((androidx.constraintlayout.widget.ConstraintLayout) androidx.constraintlayout.motion.widget.MotionLayout.this).mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(((androidx.constraintlayout.widget.ConstraintLayout) androidx.constraintlayout.motion.widget.MotionLayout.this).mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(((androidx.constraintlayout.widget.ConstraintLayout) androidx.constraintlayout.motion.widget.MotionLayout.this).mLayoutWidget, this.mLayoutStart);
            copy(((androidx.constraintlayout.widget.ConstraintLayout) androidx.constraintlayout.motion.widget.MotionLayout.this).mLayoutWidget, this.mLayoutEnd);
            if (androidx.constraintlayout.motion.widget.MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.setRtl(androidx.constraintlayout.motion.widget.MotionLayout.this.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(androidx.constraintlayout.motion.widget.MotionLayout.this.isRtl());
            this.mLayoutEnd.updateHierarchy();
            android.view.ViewGroup.LayoutParams layoutParams = androidx.constraintlayout.motion.widget.MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                    androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.mLayoutEnd.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public boolean isNotConfiguredWith(int i, int i2) {
            return (i == this.mStartId && i2 == this.mEndId) ? false : true;
        }

        public void measure(int i, int i2) {
            int mode = android.view.View.MeasureSpec.getMode(i);
            int mode2 = android.view.View.MeasureSpec.getMode(i2);
            androidx.constraintlayout.motion.widget.MotionLayout motionLayout = androidx.constraintlayout.motion.widget.MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            androidx.constraintlayout.motion.widget.MotionLayout motionLayout2 = androidx.constraintlayout.motion.widget.MotionLayout.this;
            if (motionLayout2.mCurrentState == motionLayout2.getStartState()) {
                androidx.constraintlayout.motion.widget.MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                if (this.mStart != null) {
                    androidx.constraintlayout.motion.widget.MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                }
            } else {
                if (this.mStart != null) {
                    androidx.constraintlayout.motion.widget.MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                }
                androidx.constraintlayout.motion.widget.MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
            }
            if (((androidx.constraintlayout.motion.widget.MotionLayout.this.getParent() instanceof androidx.constraintlayout.motion.widget.MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                androidx.constraintlayout.motion.widget.MotionLayout motionLayout3 = androidx.constraintlayout.motion.widget.MotionLayout.this;
                motionLayout3.mWidthMeasureMode = mode;
                motionLayout3.mHeightMeasureMode = mode2;
                if (motionLayout3.mCurrentState == motionLayout3.getStartState()) {
                    androidx.constraintlayout.motion.widget.MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                    if (this.mStart != null) {
                        androidx.constraintlayout.motion.widget.MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                    }
                } else {
                    if (this.mStart != null) {
                        androidx.constraintlayout.motion.widget.MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                    }
                    androidx.constraintlayout.motion.widget.MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                }
                androidx.constraintlayout.motion.widget.MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                androidx.constraintlayout.motion.widget.MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                androidx.constraintlayout.motion.widget.MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                androidx.constraintlayout.motion.widget.MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                androidx.constraintlayout.motion.widget.MotionLayout motionLayout4 = androidx.constraintlayout.motion.widget.MotionLayout.this;
                motionLayout4.mMeasureDuringTransition = (motionLayout4.mStartWrapWidth == motionLayout4.mEndWrapWidth && motionLayout4.mStartWrapHeight == motionLayout4.mEndWrapHeight) ? false : true;
            }
            androidx.constraintlayout.motion.widget.MotionLayout motionLayout5 = androidx.constraintlayout.motion.widget.MotionLayout.this;
            int i3 = motionLayout5.mStartWrapWidth;
            int i4 = motionLayout5.mStartWrapHeight;
            int i5 = motionLayout5.mWidthMeasureMode;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                i3 = (int) (i3 + (motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapWidth - i3)));
            }
            int i6 = motionLayout5.mHeightMeasureMode;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                i4 = (int) (i4 + (motionLayout5.mPostInterpolationPosition * (motionLayout5.mEndWrapHeight - i4)));
            }
            androidx.constraintlayout.motion.widget.MotionLayout.this.resolveMeasuredDimension(i, i2, i3, i4, this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall(), this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall());
        }

        public void reEvaluateState() {
            measure(androidx.constraintlayout.motion.widget.MotionLayout.this.mLastWidthMeasureSpec, androidx.constraintlayout.motion.widget.MotionLayout.this.mLastHeightMeasureSpec);
            androidx.constraintlayout.motion.widget.MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i, int i2) {
            this.mStartId = i;
            this.mEndId = i2;
        }
    }

    public interface MotionTracker {
        void addMovement(android.view.MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i);

        void computeCurrentVelocity(int i, float f);

        float getXVelocity();

        float getXVelocity(int i);

        float getYVelocity();

        float getYVelocity(int i);

        void recycle();
    }

    public static class MyTracker implements androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker {

        /* renamed from: me, reason: collision with root package name */
        private static androidx.constraintlayout.motion.widget.MotionLayout.MyTracker f64me = new androidx.constraintlayout.motion.widget.MotionLayout.MyTracker();
        android.view.VelocityTracker tracker;

        private MyTracker() {
        }

        public static androidx.constraintlayout.motion.widget.MotionLayout.MyTracker obtain() {
            f64me.tracker = android.view.VelocityTracker.obtain();
            return f64me;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(android.view.MotionEvent motionEvent) {
            android.view.VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            android.view.VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i) {
            android.view.VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i, float f) {
            android.view.VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i, f);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            android.view.VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i) {
            android.view.VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            android.view.VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i) {
            if (this.tracker != null) {
                return getYVelocity(i);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            android.view.VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.tracker = null;
            }
        }
    }

    public class StateCache {
        float mProgress = Float.NaN;
        float mVelocity = Float.NaN;
        int startState = -1;
        int endState = -1;
        final java.lang.String KeyProgress = "motion.progress";
        final java.lang.String KeyVelocity = "motion.velocity";
        final java.lang.String KeyStartState = "motion.StartState";
        final java.lang.String KeyEndState = "motion.EndState";

        public StateCache() {
        }

        public void apply() {
            int i = this.startState;
            if (i != -1 || this.endState != -1) {
                if (i == -1) {
                    androidx.constraintlayout.motion.widget.MotionLayout.this.transitionToState(this.endState);
                } else {
                    int i2 = this.endState;
                    if (i2 == -1) {
                        androidx.constraintlayout.motion.widget.MotionLayout.this.setState(i, -1, -1);
                    } else {
                        androidx.constraintlayout.motion.widget.MotionLayout.this.setTransition(i, i2);
                    }
                }
                androidx.constraintlayout.motion.widget.MotionLayout.this.setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP);
            }
            if (java.lang.Float.isNaN(this.mVelocity)) {
                if (java.lang.Float.isNaN(this.mProgress)) {
                    return;
                }
                androidx.constraintlayout.motion.widget.MotionLayout.this.setProgress(this.mProgress);
            } else {
                androidx.constraintlayout.motion.widget.MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.startState = -1;
                this.endState = -1;
            }
        }

        public android.os.Bundle getTransitionState() {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.startState);
            bundle.putInt("motion.EndState", this.endState);
            return bundle;
        }

        public void recordState() {
            this.endState = androidx.constraintlayout.motion.widget.MotionLayout.this.mEndState;
            this.startState = androidx.constraintlayout.motion.widget.MotionLayout.this.mBeginState;
            this.mVelocity = androidx.constraintlayout.motion.widget.MotionLayout.this.getVelocity();
            this.mProgress = androidx.constraintlayout.motion.widget.MotionLayout.this.getProgress();
        }

        public void setEndState(int i) {
            this.endState = i;
        }

        public void setProgress(float f) {
            this.mProgress = f;
        }

        public void setStartState(int i) {
            this.startState = i;
        }

        public void setTransitionState(android.os.Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.startState = bundle.getInt("motion.StartState");
            this.endState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f) {
            this.mVelocity = f;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i, int i2, float f);

        void onTransitionCompleted(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i);

        void onTransitionStarted(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i, boolean z, float f);
    }

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new java.util.HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new androidx.constraintlayout.motion.utils.StopLogic();
        this.mDecelerateLogic = new androidx.constraintlayout.motion.widget.MotionLayout.DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.motion.widget.KeyCache();
        this.mInLayout = false;
        this.mTransitionState = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED;
        this.mModel = new androidx.constraintlayout.motion.widget.MotionLayout.Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new android.graphics.RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new java.util.ArrayList<>();
        init(null);
    }

    public MotionLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new java.util.HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new androidx.constraintlayout.motion.utils.StopLogic();
        this.mDecelerateLogic = new androidx.constraintlayout.motion.widget.MotionLayout.DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.motion.widget.KeyCache();
        this.mInLayout = false;
        this.mTransitionState = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED;
        this.mModel = new androidx.constraintlayout.motion.widget.MotionLayout.Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new android.graphics.RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new java.util.ArrayList<>();
        init(attributeSet);
    }

    public MotionLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastVelocity = 0.0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new java.util.HashMap<>();
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new androidx.constraintlayout.motion.utils.StopLogic();
        this.mDecelerateLogic = new androidx.constraintlayout.motion.widget.MotionLayout.DecelerateInterpolator();
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1L;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new androidx.constraintlayout.motion.widget.KeyCache();
        this.mInLayout = false;
        this.mTransitionState = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED;
        this.mModel = new androidx.constraintlayout.motion.widget.MotionLayout.Model();
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new android.graphics.RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new java.util.ArrayList<>();
        init(attributeSet);
    }

    private void checkStructure() {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        int startId = motionScene.getStartId();
        androidx.constraintlayout.motion.widget.MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        android.util.SparseIntArray sparseIntArray2 = new android.util.SparseIntArray();
        java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = this.mScene.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition next = it.next();
            androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mScene.mCurrentTransition;
            checkStructure(next);
            int startConstraintSetId = next.getStartConstraintSetId();
            int endConstraintSetId = next.getEndConstraintSetId();
            java.lang.String name = androidx.constraintlayout.motion.widget.Debug.getName(getContext(), startConstraintSetId);
            java.lang.String name2 = androidx.constraintlayout.motion.widget.Debug.getName(getContext(), endConstraintSetId);
            if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("CHECK: two transitions with the same start and end ");
                sb.append(name);
                sb.append("->");
                sb.append(name2);
            }
            if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("CHECK: you can't have reverse transitions");
                sb2.append(name);
                sb2.append("->");
                sb2.append(name2);
            }
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            if (this.mScene.getConstraintSet(startConstraintSetId) == null) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(" no such constraintSetStart ");
                sb3.append(name);
            }
            if (this.mScene.getConstraintSet(endConstraintSetId) == null) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append(" no such constraintSetEnd ");
                sb4.append(name);
            }
        }
    }

    private void checkStructure(int i, androidx.constraintlayout.widget.ConstraintSet constraintSet) {
        java.lang.String name = androidx.constraintlayout.motion.widget.Debug.getName(getContext(), i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = getChildAt(i2);
            int id = childAt.getId();
            if (id == -1) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("CHECK: ");
                sb.append(name);
                sb.append(" ALL VIEWS SHOULD HAVE ID's ");
                sb.append(childAt.getClass().getName());
                sb.append(" does not!");
            }
            if (constraintSet.getConstraint(id) == null) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("CHECK: ");
                sb2.append(name);
                sb2.append(" NO CONSTRAINTS for ");
                sb2.append(androidx.constraintlayout.motion.widget.Debug.getName(childAt));
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i3 = 0; i3 < knownIds.length; i3++) {
            int i4 = knownIds[i3];
            java.lang.String name2 = androidx.constraintlayout.motion.widget.Debug.getName(getContext(), i4);
            if (findViewById(knownIds[i3]) == null) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("CHECK: ");
                sb3.append(name);
                sb3.append(" NO View matches id ");
                sb3.append(name2);
            }
            if (constraintSet.getHeight(i4) == -1) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("CHECK: ");
                sb4.append(name);
                sb4.append("(");
                sb4.append(name2);
                sb4.append(") no LAYOUT_HEIGHT");
            }
            if (constraintSet.getWidth(i4) == -1) {
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                sb5.append("CHECK: ");
                sb5.append(name);
                sb5.append("(");
                sb5.append(name2);
                sb5.append(") no LAYOUT_HEIGHT");
            }
        }
    }

    private void checkStructure(androidx.constraintlayout.motion.widget.MotionScene.Transition transition) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("CHECK: transition = ");
        sb.append(transition.debugString(getContext()));
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("CHECK: transition.setDuration = ");
        sb2.append(transition.getDuration());
        transition.getStartConstraintSetId();
        transition.getEndConstraintSetId();
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = getChildAt(i);
            androidx.constraintlayout.motion.widget.MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    private void debugPos() {
        for (int i = 0; i < getChildCount(); i++) {
            android.view.View childAt = getChildAt(i);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(" ");
            sb.append(androidx.constraintlayout.motion.widget.Debug.getLocation());
            sb.append(" ");
            sb.append(androidx.constraintlayout.motion.widget.Debug.getName(this));
            sb.append(" ");
            sb.append(androidx.constraintlayout.motion.widget.Debug.getName(getContext(), this.mCurrentState));
            sb.append(" ");
            sb.append(androidx.constraintlayout.motion.widget.Debug.getName(childAt));
            sb.append(childAt.getLeft());
            sb.append(" ");
            sb.append(childAt.getTop());
        }
    }

    private void evaluateLayout() {
        boolean z;
        float signum = java.lang.Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        android.view.animation.Interpolator interpolator = this.mInterpolator;
        float f = this.mTransitionLastPosition + (!(interpolator instanceof androidx.constraintlayout.motion.utils.StopLogic) ? (((nanoTime - this.mTransitionLastTime) * signum) * 1.0E-9f) / this.mTransitionDuration : 0.0f);
        if (this.mTransitionInstantly) {
            f = this.mTransitionGoalPosition;
        }
        if ((signum <= 0.0f || f < this.mTransitionGoalPosition) && (signum > 0.0f || f > this.mTransitionGoalPosition)) {
            z = false;
        } else {
            f = this.mTransitionGoalPosition;
            z = true;
        }
        if (interpolator != null && !z) {
            f = this.mTemporalInterpolator ? interpolator.getInterpolation((nanoTime - this.mAnimationStartTime) * 1.0E-9f) : interpolator.getInterpolation(f);
        }
        if ((signum > 0.0f && f >= this.mTransitionGoalPosition) || (signum <= 0.0f && f <= this.mTransitionGoalPosition)) {
            f = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = getChildAt(i);
            androidx.constraintlayout.motion.widget.MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList;
        if ((this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) || this.mListenerPosition == this.mTransitionPosition) {
            return;
        }
        if (this.mListenerState != -1) {
            androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
            }
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList2 = this.mTransitionListeners;
            if (arrayList2 != null) {
                java.util.Iterator<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> it = arrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
            }
            this.mIsAnimating = true;
        }
        this.mListenerState = -1;
        float f = this.mTransitionPosition;
        this.mListenerPosition = f;
        androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener transitionListener2 = this.mTransitionListener;
        if (transitionListener2 != null) {
            transitionListener2.onTransitionChange(this, this.mBeginState, this.mEndState, f);
        }
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList3 = this.mTransitionListeners;
        if (arrayList3 != null) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
            }
        }
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i, int i2) {
        androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, i, i2);
        }
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(motionLayout, i, i2);
            }
        }
    }

    private boolean handlesTouchEvent(float f, float f2, android.view.View view, android.view.MotionEvent motionEvent) {
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (handlesTouchEvent(view.getLeft() + f, view.getTop() + f2, viewGroup.getChildAt(i), motionEvent)) {
                    return true;
                }
            }
        }
        this.mBoundsCheck.set(view.getLeft() + f, view.getTop() + f2, f + view.getRight(), f2 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private void init(android.util.AttributeSet attributeSet) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == androidx.constraintlayout.widget.R.styleable.MotionLayout_layoutDescription) {
                    this.mScene = new androidx.constraintlayout.motion.widget.MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLayout_applyMotionScene) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        this.mDebugPath = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (!z) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState != -1 || (motionScene = this.mScene) == null) {
            return;
        }
        this.mCurrentState = motionScene.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
    }

    private void processTransitionCompleted() {
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList;
        if (this.mTransitionListener == null && ((arrayList = this.mTransitionListeners) == null || arrayList.isEmpty())) {
            return;
        }
        this.mIsAnimating = false;
        java.util.Iterator<java.lang.Integer> it = this.mTransitionCompleted.iterator();
        while (it.hasNext()) {
            java.lang.Integer next = it.next();
            androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, next.intValue());
            }
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList2 = this.mTransitionListeners;
            if (arrayList2 != null) {
                java.util.Iterator<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionCompleted(this, next.intValue());
                }
            }
        }
        this.mTransitionCompleted.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMotionViews() {
        int childCount = getChildCount();
        this.mModel.build();
        boolean z = true;
        this.mInTransition = true;
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.mScene.gatPathMotionArc();
        int i = 0;
        if (gatPathMotionArc != -1) {
            for (int i2 = 0; i2 < childCount; i2++) {
                androidx.constraintlayout.motion.widget.MotionController motionController = this.mFrameArrayList.get(getChildAt(i2));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            androidx.constraintlayout.motion.widget.MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i3));
            if (motionController2 != null) {
                this.mScene.getKeyFrames(motionController2);
                motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            boolean z2 = ((double) staggered) < 0.0d;
            float abs = java.lang.Math.abs(staggered);
            float f = -3.4028235E38f;
            float f2 = Float.MAX_VALUE;
            int i4 = 0;
            float f3 = Float.MAX_VALUE;
            float f4 = -3.4028235E38f;
            while (true) {
                if (i4 >= childCount) {
                    z = false;
                    break;
                }
                androidx.constraintlayout.motion.widget.MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i4));
                if (!java.lang.Float.isNaN(motionController3.mMotionStagger)) {
                    break;
                }
                float finalX = motionController3.getFinalX();
                float finalY = motionController3.getFinalY();
                float f5 = z2 ? finalY - finalX : finalY + finalX;
                f3 = java.lang.Math.min(f3, f5);
                f4 = java.lang.Math.max(f4, f5);
                i4++;
            }
            if (!z) {
                while (i < childCount) {
                    androidx.constraintlayout.motion.widget.MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i));
                    float finalX2 = motionController4.getFinalX();
                    float finalY2 = motionController4.getFinalY();
                    float f6 = z2 ? finalY2 - finalX2 : finalY2 + finalX2;
                    motionController4.mStaggerScale = 1.0f / (1.0f - abs);
                    motionController4.mStaggerOffset = abs - (((f6 - f3) * abs) / (f4 - f3));
                    i++;
                }
                return;
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                androidx.constraintlayout.motion.widget.MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i5));
                if (!java.lang.Float.isNaN(motionController5.mMotionStagger)) {
                    f2 = java.lang.Math.min(f2, motionController5.mMotionStagger);
                    f = java.lang.Math.max(f, motionController5.mMotionStagger);
                }
            }
            while (i < childCount) {
                androidx.constraintlayout.motion.widget.MotionController motionController6 = this.mFrameArrayList.get(getChildAt(i));
                if (!java.lang.Float.isNaN(motionController6.mMotionStagger)) {
                    motionController6.mStaggerScale = 1.0f / (1.0f - abs);
                    if (z2) {
                        motionController6.mStaggerOffset = abs - (((f - motionController6.mMotionStagger) / (f - f2)) * abs);
                    } else {
                        motionController6.mStaggerOffset = abs - (((motionController6.mMotionStagger - f2) * abs) / (f - f2));
                    }
                }
                i++;
            }
        }
    }

    private static boolean willJump(float f, float f2, float f3) {
        if (f > 0.0f) {
            float f4 = f / f3;
            return f2 + ((f * f4) - (((f3 * f4) * f4) / 2.0f)) > 1.0f;
        }
        float f5 = (-f) / f3;
        return f2 + ((f * f5) + (((f3 * f5) * f5) / 2.0f)) < 0.0f;
    }

    public void addTransitionListener(androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new java.util.ArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    public void animateTo(float f) {
        if (this.mScene == null) {
            return;
        }
        float f2 = this.mTransitionLastPosition;
        float f3 = this.mTransitionPosition;
        if (f2 != f3 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f3;
        }
        float f4 = this.mTransitionLastPosition;
        if (f4 == f) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f;
        this.mTransitionDuration = r0.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f4;
        this.mTransitionLastPosition = f4;
        invalidate();
    }

    public void disableAutoTransition(boolean z) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(z);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        evaluate(false);
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
            this.mFrames++;
            long nanoTime = getNanoTime();
            long j = this.mLastDrawTime;
            if (j != -1) {
                if (nanoTime - j > 200000000) {
                    this.mLastFps = ((int) ((this.mFrames / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = nanoTime;
                }
            } else {
                this.mLastDrawTime = nanoTime;
            }
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setTextSize(42.0f);
            java.lang.String str = this.mLastFps + " fps " + androidx.constraintlayout.motion.widget.Debug.getState(this, this.mBeginState) + " -> ";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(androidx.constraintlayout.motion.widget.Debug.getState(this, this.mEndState));
            sb.append(" (progress: ");
            sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb.append(" ) state=");
            int i = this.mCurrentState;
            sb.append(i == -1 ? "undefined" : androidx.constraintlayout.motion.widget.Debug.getState(this, i));
            java.lang.String sb2 = sb.toString();
            paint.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            canvas.drawText(sb2, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb2, 10.0f, getHeight() - 30, paint);
        }
        if (this.mDebugPath > 1) {
            if (this.mDevModeDraw == null) {
                this.mDevModeDraw = new androidx.constraintlayout.motion.widget.MotionLayout.DevModeDraw();
            }
            this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        }
    }

    public void enableTransition(int i, boolean z) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = getTransition(i);
        if (z) {
            transition.setEnable(true);
            return;
        }
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (transition == motionScene.mCurrentTransition) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                androidx.constraintlayout.motion.widget.MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.mScene.mCurrentTransition = next;
                    break;
                }
            }
        }
        transition.setEnable(false);
    }

    public void evaluate(boolean z) {
        float f;
        boolean z2;
        int i;
        float interpolation;
        boolean z3;
        if (this.mTransitionLastTime == -1) {
            this.mTransitionLastTime = getNanoTime();
        }
        float f2 = this.mTransitionLastPosition;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.mCurrentState = -1;
        }
        boolean z4 = false;
        if (this.mKeepAnimating || (this.mInTransition && (z || this.mTransitionGoalPosition != f2))) {
            float signum = java.lang.Math.signum(this.mTransitionGoalPosition - f2);
            long nanoTime = getNanoTime();
            android.view.animation.Interpolator interpolator = this.mInterpolator;
            if (interpolator instanceof androidx.constraintlayout.motion.widget.MotionInterpolator) {
                f = 0.0f;
            } else {
                f = (((nanoTime - this.mTransitionLastTime) * signum) * 1.0E-9f) / this.mTransitionDuration;
                this.mLastVelocity = f;
            }
            float f3 = this.mTransitionLastPosition + f;
            if (this.mTransitionInstantly) {
                f3 = this.mTransitionGoalPosition;
            }
            if ((signum <= 0.0f || f3 < this.mTransitionGoalPosition) && (signum > 0.0f || f3 > this.mTransitionGoalPosition)) {
                z2 = false;
            } else {
                f3 = this.mTransitionGoalPosition;
                this.mInTransition = false;
                z2 = true;
            }
            this.mTransitionLastPosition = f3;
            this.mTransitionPosition = f3;
            this.mTransitionLastTime = nanoTime;
            if (interpolator != null && !z2) {
                if (this.mTemporalInterpolator) {
                    interpolation = interpolator.getInterpolation((nanoTime - this.mAnimationStartTime) * 1.0E-9f);
                    this.mTransitionLastPosition = interpolation;
                    this.mTransitionLastTime = nanoTime;
                    android.view.animation.Interpolator interpolator2 = this.mInterpolator;
                    if (interpolator2 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator) {
                        float velocity = ((androidx.constraintlayout.motion.widget.MotionInterpolator) interpolator2).getVelocity();
                        this.mLastVelocity = velocity;
                        if (java.lang.Math.abs(velocity) * this.mTransitionDuration <= EPSILON) {
                            this.mInTransition = false;
                        }
                        if (velocity > 0.0f && interpolation >= 1.0f) {
                            this.mTransitionLastPosition = 1.0f;
                            this.mInTransition = false;
                            interpolation = 1.0f;
                        }
                        if (velocity < 0.0f && interpolation <= 0.0f) {
                            this.mTransitionLastPosition = 0.0f;
                            this.mInTransition = false;
                            f3 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f3);
                    android.view.animation.Interpolator interpolator3 = this.mInterpolator;
                    if (interpolator3 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator) {
                        this.mLastVelocity = ((androidx.constraintlayout.motion.widget.MotionInterpolator) interpolator3).getVelocity();
                    } else {
                        this.mLastVelocity = ((interpolator3.getInterpolation(f3 + f) - interpolation) * signum) / f;
                    }
                }
                f3 = interpolation;
            }
            if (java.lang.Math.abs(this.mLastVelocity) > EPSILON) {
                setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
            }
            if ((signum > 0.0f && f3 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f3 <= this.mTransitionGoalPosition)) {
                f3 = this.mTransitionGoalPosition;
                this.mInTransition = false;
            }
            if (f3 >= 1.0f || f3 <= 0.0f) {
                this.mInTransition = false;
                setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED);
            }
            int childCount = getChildCount();
            this.mKeepAnimating = false;
            long nanoTime2 = getNanoTime();
            this.mPostInterpolationPosition = f3;
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = getChildAt(i2);
                androidx.constraintlayout.motion.widget.MotionController motionController = this.mFrameArrayList.get(childAt);
                if (motionController != null) {
                    this.mKeepAnimating = motionController.interpolate(childAt, f3, nanoTime2, this.mKeyCache) | this.mKeepAnimating;
                }
            }
            boolean z5 = (signum > 0.0f && f3 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f3 <= this.mTransitionGoalPosition);
            if (!this.mKeepAnimating && !this.mInTransition && z5) {
                setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED);
            }
            if (this.mMeasureDuringTransition) {
                requestLayout();
            }
            this.mKeepAnimating = (!z5) | this.mKeepAnimating;
            if (f3 <= 0.0f && (i = this.mBeginState) != -1 && this.mCurrentState != i) {
                this.mCurrentState = i;
                this.mScene.getConstraintSet(i).applyCustomAttributes(this);
                setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED);
                z4 = true;
            }
            if (f3 >= 1.0d) {
                int i3 = this.mCurrentState;
                int i4 = this.mEndState;
                if (i3 != i4) {
                    this.mCurrentState = i4;
                    this.mScene.getConstraintSet(i4).applyCustomAttributes(this);
                    setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED);
                    z4 = true;
                }
            }
            if (this.mKeepAnimating || this.mInTransition) {
                invalidate();
            } else if ((signum > 0.0f && f3 == 1.0f) || (signum < 0.0f && f3 == 0.0f)) {
                setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED);
            }
            if ((!this.mKeepAnimating && this.mInTransition && signum > 0.0f && f3 == 1.0f) || (signum < 0.0f && f3 == 0.0f)) {
                onNewStateAttachHandlers();
            }
        }
        float f4 = this.mTransitionLastPosition;
        if (f4 < 1.0f) {
            if (f4 <= 0.0f) {
                int i5 = this.mCurrentState;
                int i6 = this.mBeginState;
                z3 = i5 == i6 ? z4 : true;
                this.mCurrentState = i6;
            }
            this.mNeedsFireTransitionCompleted |= z4;
            if (z4 && !this.mInLayout) {
                requestLayout();
            }
            this.mTransitionPosition = this.mTransitionLastPosition;
        }
        int i7 = this.mCurrentState;
        int i8 = this.mEndState;
        z3 = i7 == i8 ? z4 : true;
        this.mCurrentState = i8;
        z4 = z3;
        this.mNeedsFireTransitionCompleted |= z4;
        if (z4) {
            requestLayout();
        }
        this.mTransitionPosition = this.mTransitionLastPosition;
    }

    public void fireTransitionCompleted() {
        int i;
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList;
        if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (this.mTransitionCompleted.isEmpty()) {
                i = -1;
            } else {
                i = this.mTransitionCompleted.get(r0.size() - 1).intValue();
            }
            int i2 = this.mCurrentState;
            if (i != i2 && i2 != -1) {
                this.mTransitionCompleted.add(java.lang.Integer.valueOf(i2));
            }
        }
        processTransitionCompleted();
    }

    public void fireTrigger(int i, boolean z, float f) {
        androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i, z, f);
        }
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i, z, f);
            }
        }
    }

    public void getAnchorDpDt(int i, float f, float f2, float f3, float[] fArr) {
        java.lang.String resourceName;
        java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> hashMap = this.mFrameArrayList;
        android.view.View viewById = getViewById(i);
        androidx.constraintlayout.motion.widget.MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f, f2, f3, fArr);
            float y = viewById.getY();
            this.lastPos = f;
            this.lastY = y;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("WARNING could not find view id ");
        sb.append(resourceName);
    }

    public androidx.constraintlayout.widget.ConstraintSet getConstraintSet(int i) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i);
    }

    public int[] getConstraintSetIds() {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public java.lang.String getConstraintSetNames(int i) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean z) {
        this.mDebugPath = z ? 2 : 1;
        invalidate();
    }

    public java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene.Transition> getDefinedTransitions() {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public androidx.constraintlayout.motion.widget.DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new androidx.constraintlayout.motion.widget.DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public long getNanoTime() {
        return java.lang.System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public androidx.constraintlayout.motion.widget.MotionScene.Transition getTransition(int i) {
        return this.mScene.getTransitionById(i);
    }

    public android.os.Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new androidx.constraintlayout.motion.widget.MotionLayout.StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        if (this.mScene != null) {
            this.mTransitionDuration = r0.getDuration() / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(android.view.View view, float f, float f2, float[] fArr, int i) {
        float f3;
        float f4 = this.mLastVelocity;
        float f5 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = java.lang.Math.signum(this.mTransitionGoalPosition - f5);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            f3 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f4 = (signum * ((interpolation - f3) / EPSILON)) / this.mTransitionDuration;
        } else {
            f3 = f5;
        }
        android.view.animation.Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof androidx.constraintlayout.motion.widget.MotionInterpolator) {
            f4 = ((androidx.constraintlayout.motion.widget.MotionInterpolator) interpolator).getVelocity();
        }
        androidx.constraintlayout.motion.widget.MotionController motionController = this.mFrameArrayList.get(view);
        if ((i & 1) == 0) {
            motionController.getPostLayoutDvDp(f3, view.getWidth(), view.getHeight(), f, f2, fArr);
        } else {
            motionController.getDpDt(f3, f, f2, fArr);
        }
        if (i < 2) {
            fArr[0] = fArr[0] * f4;
            fArr[1] = fArr[1] * f4;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        if (i == 0) {
            this.mScene = null;
            return;
        }
        try {
            this.mScene = new androidx.constraintlayout.motion.widget.MotionScene(getContext(), this, i);
            if (isAttachedToWindow()) {
                this.mScene.readFallback(this);
                this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                rebuildScene();
                this.mScene.setRtl(isRtl());
            }
        } catch (java.lang.Exception e) {
            throw new java.lang.IllegalArgumentException("unable to parse MotionScene file", e);
        }
    }

    public int lookUpConstraintId(java.lang.String str) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    public androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker obtainVelocityTracker() {
        return androidx.constraintlayout.motion.widget.MotionLayout.MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition;
        int i;
        super.onAttachedToWindow();
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene != null && (i = this.mCurrentState) != -1) {
            androidx.constraintlayout.widget.ConstraintSet constraintSet = motionScene.getConstraintSet(i);
            this.mScene.readFallback(this);
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        androidx.constraintlayout.motion.widget.MotionLayout.StateCache stateCache = this.mStateCache;
        if (stateCache != null) {
            stateCache.apply();
            return;
        }
        androidx.constraintlayout.motion.widget.MotionScene motionScene2 = this.mScene;
        if (motionScene2 == null || (transition = motionScene2.mCurrentTransition) == null || transition.getAutoTransition() != 4) {
            return;
        }
        transitionToEnd();
        setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP);
        setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition;
        androidx.constraintlayout.motion.widget.TouchResponse touchResponse;
        int touchRegionId;
        android.graphics.RectF touchRegion;
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new android.graphics.RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
            android.view.View view = this.mRegionView;
            if (view == null || view.getId() != touchRegionId) {
                this.mRegionView = findViewById(touchRegionId);
            }
            if (this.mRegionView != null) {
                this.mBoundsCheck.set(r0.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.mLastLayoutWidth != i5 || this.mLastLayoutHeight != i6) {
                rebuildScene();
                evaluate(true);
            }
            this.mLastLayoutWidth = i5;
            this.mLastLayoutHeight = i6;
            this.mOldWidth = i5;
            this.mOldHeight = i6;
        } finally {
            this.mInLayout = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mScene == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z = false;
        boolean z2 = (this.mLastWidthMeasureSpec == i && this.mLastHeightMeasureSpec == i2) ? false : true;
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z2 = true;
        }
        if (this.mDirtyHierarchy) {
            z2 = true;
        }
        this.mLastWidthMeasureSpec = i;
        this.mLastHeightMeasureSpec = i2;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z2 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i, i2);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(startId, endId);
        } else {
            z = true;
        }
        if (this.mMeasureDuringTransition || z) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
            int height = this.mLayoutWidget.getHeight() + paddingTop;
            int i3 = this.mWidthMeasureMode;
            if (i3 == Integer.MIN_VALUE || i3 == 0) {
                width = (int) (this.mStartWrapWidth + (this.mPostInterpolationPosition * (this.mEndWrapWidth - r7)));
                requestLayout();
            }
            int i4 = this.mHeightMeasureMode;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                height = (int) (this.mStartWrapHeight + (this.mPostInterpolationPosition * (this.mEndWrapHeight - r7)));
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int i3) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition;
        androidx.constraintlayout.motion.widget.TouchResponse touchResponse;
        int touchRegionId;
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || !transition.isEnabled()) {
            return;
        }
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition2 = this.mScene.mCurrentTransition;
        if (transition2 == null || !transition2.isEnabled() || (touchResponse = transition2.getTouchResponse()) == null || (touchRegionId = touchResponse.getTouchRegionId()) == -1 || view.getId() == touchRegionId) {
            androidx.constraintlayout.motion.widget.MotionScene motionScene2 = this.mScene;
            if (motionScene2 != null && motionScene2.getMoveWhenScrollAtTop()) {
                float f = this.mTransitionPosition;
                if ((f == 1.0f || f == 0.0f) && view.canScrollVertically(-1)) {
                    return;
                }
            }
            if (transition2.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) != 0) {
                float progressDirection = this.mScene.getProgressDirection(i, i2);
                float f2 = this.mTransitionLastPosition;
                if ((f2 <= 0.0f && progressDirection < 0.0f) || (f2 >= 1.0f && progressDirection > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new androidx.constraintlayout.motion.widget.MotionLayout.AnonymousClass1(view));
                    return;
                }
            }
            float f3 = this.mTransitionPosition;
            long nanoTime = getNanoTime();
            float f4 = i;
            this.mScrollTargetDX = f4;
            float f5 = i2;
            this.mScrollTargetDY = f5;
            this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
            this.mScrollTargetTime = nanoTime;
            this.mScene.processScrollMove(f4, f5);
            if (f3 != this.mTransitionPosition) {
                iArr[0] = i;
                iArr[1] = i2;
            }
            evaluate(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.mUndergoingMotion = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.mUndergoingMotion || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.mUndergoingMotion = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i, int i2) {
    }

    public void onNewStateAttachHandlers() {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        if (motionScene.autoTransition(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i = this.mCurrentState;
        if (i != -1) {
            this.mScene.addOnClickListeners(this, i);
        }
        if (this.mScene.supportTouch()) {
            this.mScene.setupTouch();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i, int i2) {
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition;
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        return (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(android.view.View view, int i) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        float f = this.mScrollTargetDX;
        float f2 = this.mScrollTargetDT;
        motionScene.processScrollUp(f / f2, this.mScrollTargetDY / f2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.supportTouch()) {
            return super.onTouchEvent(motionEvent);
        }
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition = this.mScene.mCurrentTransition;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(android.view.View view) {
        super.onViewAdded(view);
        if (view instanceof androidx.constraintlayout.motion.widget.MotionHelper) {
            androidx.constraintlayout.motion.widget.MotionHelper motionHelper = (androidx.constraintlayout.motion.widget.MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new java.util.ArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new java.util.ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new java.util.ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(android.view.View view) {
        super.onViewRemoved(view);
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    @java.lang.Deprecated
    public void rebuildMotion() {
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener transitionListener) {
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        androidx.constraintlayout.motion.widget.MotionScene motionScene;
        androidx.constraintlayout.motion.widget.MotionScene.Transition transition;
        if (this.mMeasureDuringTransition || this.mCurrentState != -1 || (motionScene = this.mScene) == null || (transition = motionScene.mCurrentTransition) == null || transition.getLayoutDuringTransition() != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i) {
        this.mDebugPath = i;
        invalidate();
    }

    public void setInteractionEnabled(boolean z) {
        this.mInteractionEnabled = z;
    }

    public void setInterpolatedProgress(float f) {
        if (this.mScene != null) {
            setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
            android.view.animation.Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public void setOnHide(float f) {
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mOnHideHelpers.get(i).setProgress(f);
            }
        }
    }

    public void setOnShow(float f) {
        java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mOnShowHelpers.get(i).setProgress(f);
            }
        }
    }

    public void setProgress(float f) {
        if (f >= 0.0f) {
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        }
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new androidx.constraintlayout.motion.widget.MotionLayout.StateCache();
            }
            this.mStateCache.setProgress(f);
            return;
        }
        if (f <= 0.0f) {
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED);
            }
        } else if (f >= 1.0f) {
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f;
        this.mTransitionPosition = f;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    public void setProgress(float f, float f2) {
        if (isAttachedToWindow()) {
            setProgress(f);
            setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING);
            this.mLastVelocity = f2;
            animateTo(1.0f);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new androidx.constraintlayout.motion.widget.MotionLayout.StateCache();
        }
        this.mStateCache.setProgress(f);
        this.mStateCache.setVelocity(f2);
    }

    public void setScene(androidx.constraintlayout.motion.widget.MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP);
        this.mCurrentState = i;
        this.mBeginState = -1;
        this.mEndState = -1;
        androidx.constraintlayout.widget.ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, i2, i3);
            return;
        }
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i).applyTo(this);
        }
    }

    public void setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState transitionState) {
        androidx.constraintlayout.motion.widget.MotionLayout.TransitionState transitionState2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.mCurrentState == -1) {
            return;
        }
        androidx.constraintlayout.motion.widget.MotionLayout.TransitionState transitionState3 = this.mTransitionState;
        this.mTransitionState = transitionState;
        androidx.constraintlayout.motion.widget.MotionLayout.TransitionState transitionState4 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            fireTransitionChange();
        }
        int i = androidx.constraintlayout.motion.widget.MotionLayout.AnonymousClass2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[transitionState3.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3 && transitionState == transitionState2) {
                fireTransitionCompleted();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            fireTransitionChange();
        }
        if (transitionState == transitionState2) {
            fireTransitionCompleted();
        }
    }

    public void setTransition(int i) {
        if (this.mScene != null) {
            androidx.constraintlayout.motion.widget.MotionScene.Transition transition = getTransition(i);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new androidx.constraintlayout.motion.widget.MotionLayout.StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            int i2 = this.mCurrentState;
            float f = i2 == this.mBeginState ? 0.0f : i2 == this.mEndState ? 1.0f : Float.NaN;
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            this.mTransitionLastPosition = java.lang.Float.isNaN(f) ? 0.0f : f;
            if (!java.lang.Float.isNaN(f)) {
                setProgress(f);
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(androidx.constraintlayout.motion.widget.Debug.getLocation());
            sb.append(" transitionToStart ");
            transitionToStart();
        }
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new androidx.constraintlayout.motion.widget.MotionLayout.StateCache();
            }
            this.mStateCache.setStartState(i);
            this.mStateCache.setEndState(i2);
            return;
        }
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i;
            this.mEndState = i2;
            motionScene.setTransition(i, i2);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i), this.mScene.getConstraintSet(i2));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransition(androidx.constraintlayout.motion.widget.MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1L : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId == this.mBeginState && endId == this.mEndState) {
            return;
        }
        this.mBeginState = startId;
        this.mEndState = endId;
        this.mScene.setTransition(startId, endId);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
    }

    public void setTransitionDuration(int i) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.setDuration(i);
    }

    public void setTransitionListener(androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(android.os.Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new androidx.constraintlayout.motion.widget.MotionLayout.StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    @Override // android.view.View
    public java.lang.String toString() {
        android.content.Context context = getContext();
        return androidx.constraintlayout.motion.widget.Debug.getName(context, this.mBeginState) + "->" + androidx.constraintlayout.motion.widget.Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int i, float f, float f2) {
        if (this.mScene == null || this.mTransitionLastPosition == f) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        float duration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionDuration = duration;
        this.mTransitionGoalPosition = f;
        this.mInTransition = true;
        if (i == 0 || i == 1 || i == 2) {
            if (i == 1) {
                f = 0.0f;
            } else if (i == 2) {
                f = 1.0f;
            }
            this.mStopLogic.config(this.mTransitionLastPosition, f, f2, duration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
            int i2 = this.mCurrentState;
            this.mTransitionGoalPosition = f;
            this.mCurrentState = i2;
            this.mInterpolator = this.mStopLogic;
        } else if (i == 4) {
            this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
            this.mInterpolator = this.mDecelerateLogic;
        } else if (i == 5) {
            if (willJump(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
                this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                this.mInterpolator = this.mDecelerateLogic;
            } else {
                this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                this.mLastVelocity = 0.0f;
                int i3 = this.mCurrentState;
                this.mTransitionGoalPosition = f;
                this.mCurrentState = i3;
                this.mInterpolator = this.mStopLogic;
            }
        }
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        animateTo(1.0f);
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i) {
        if (isAttachedToWindow()) {
            transitionToState(i, -1, -1);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new androidx.constraintlayout.motion.widget.MotionLayout.StateCache();
        }
        this.mStateCache.setEndState(i);
    }

    public void transitionToState(int i, int i2, int i3) {
        androidx.constraintlayout.widget.StateSet stateSet;
        int convertToConstraintSet;
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene != null && (stateSet = motionScene.mStateSet) != null && (convertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i, i2, i3)) != -1) {
            i = convertToConstraintSet;
        }
        int i4 = this.mCurrentState;
        if (i4 == i) {
            return;
        }
        if (this.mBeginState == i) {
            animateTo(0.0f);
            return;
        }
        if (this.mEndState == i) {
            animateTo(1.0f);
            return;
        }
        this.mEndState = i;
        if (i4 != -1) {
            setTransition(i4, i);
            animateTo(1.0f);
            this.mTransitionLastPosition = 0.0f;
            transitionToEnd();
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = getNanoTime();
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        this.mScene.getStartId();
        int childCount = getChildCount();
        this.mFrameArrayList.clear();
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = getChildAt(i5);
            this.mFrameArrayList.put(childAt, new androidx.constraintlayout.motion.widget.MotionController(childAt));
        }
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(i));
        rebuildScene();
        this.mModel.build();
        computeCurrentPositions();
        int width = getWidth();
        int height = getHeight();
        for (int i6 = 0; i6 < childCount; i6++) {
            androidx.constraintlayout.motion.widget.MotionController motionController = this.mFrameArrayList.get(getChildAt(i6));
            this.mScene.getKeyFrames(motionController);
            motionController.setup(width, height, this.mTransitionDuration, getNanoTime());
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            float f = Float.MAX_VALUE;
            float f2 = -3.4028235E38f;
            for (int i7 = 0; i7 < childCount; i7++) {
                androidx.constraintlayout.motion.widget.MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i7));
                float finalY = motionController2.getFinalY() + motionController2.getFinalX();
                f = java.lang.Math.min(f, finalY);
                f2 = java.lang.Math.max(f2, finalY);
            }
            for (int i8 = 0; i8 < childCount; i8++) {
                androidx.constraintlayout.motion.widget.MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i8));
                float finalX = motionController3.getFinalX();
                float finalY2 = motionController3.getFinalY();
                motionController3.mStaggerScale = 1.0f / (1.0f - staggered);
                motionController3.mStaggerOffset = staggered - ((((finalX + finalY2) - f) * staggered) / (f2 - f));
            }
        }
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        invalidate();
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void updateState(int i, androidx.constraintlayout.widget.ConstraintSet constraintSet) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i) {
            constraintSet.applyTo(this);
        }
    }
}
