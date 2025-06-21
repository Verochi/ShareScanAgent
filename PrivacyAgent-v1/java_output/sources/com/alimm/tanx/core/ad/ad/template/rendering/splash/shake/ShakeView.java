package com.alimm.tanx.core.ad.ad.template.rendering.splash.shake;

/* loaded from: classes.dex */
public class ShakeView extends android.view.View implements android.hardware.SensorEventListener, com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.IShakeView, com.alimm.tanx.core.utils.NotConfused {
    private static final long ROTATE_ANIM_INTERVAL_TIME = 333;
    private static final long ROTATE_ANIM_TIME = 1000;
    private static final java.lang.String TAG = "ShakeView";
    public final int GESTURE_INTERACTION_END_CLICK;
    public final int GESTURE_INTERACTION_END_FAIL;
    public final int GESTURE_INTERACTION_END_SUCCESS;
    public final int GESTURE_INTERACTION_START;
    public final int MAX_SHAKE_THRESHOLD;
    public final int MIN_SHAKE_THRESHOLD;
    int count;
    private volatile boolean isShake;

    @androidx.annotation.Nullable
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback mCallBack;

    @androidx.annotation.NonNull
    @androidx.annotation.Nullable
    private android.graphics.Rect mCircleImgRect;
    private int mCircleLength;
    private android.content.Context mContext;
    private int mImagePadding;
    private float[] mLastMatchedSensorValues;
    private long mLastSenorCheckTime;
    private float[] mLastSensorValues;
    private long mLastShakeTime;
    private long mLastTimeShake;
    private float mNowShakeDegree;
    private int mNowVisibility;

    @androidx.annotation.NonNull
    private android.graphics.Paint mPaint;
    private int[] mPhoneImgSize;

    @androidx.annotation.NonNull
    private android.graphics.Rect mRealShakeImgRect;
    private android.animation.ValueAnimator.AnimatorUpdateListener mRotateAnimListener;

    @androidx.annotation.Nullable
    private android.animation.ValueAnimator mRotateAnimation;
    android.hardware.Sensor mSenAccelerometer;

    @androidx.annotation.Nullable
    private android.hardware.SensorManager mSenSensorManager;

    @androidx.annotation.Nullable
    private android.graphics.Bitmap mShakeBitMap;
    private int mShakeCnt;

    @androidx.annotation.NonNull
    private android.graphics.Rect mShakeImgRect;
    private int mShakeViewHeight;
    private java.lang.String mShowText1;
    private java.lang.String mShowText2;
    private int mShowTextColor1;
    private int mShowTextColor2;
    private float mShowTextHeight1;
    private float mShowTextHeight2;
    private android.graphics.Rect mShowTextRect1;
    private android.graphics.Rect mShowTextRect2;
    private float mShowTextSize1;
    private float mShowTextSize2;
    private int mTextPadding;

    @androidx.annotation.NonNull
    private android.graphics.Paint mTextPaint;
    private java.util.List<com.alimm.tanx.core.ut.bean.UtSensor> sensorList;
    private com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean shakeBean;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
        public void appVisibleCallBack(boolean z, boolean z2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("当前前后台状态：->");
            sb.append(z ? "后台" : "前台");
            sb.append(",是否由后台切换到前台：");
            sb.append(z2);
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.TAG, sb.toString());
            if (z) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.this.pauseShake();
            }
            if (!z2 || com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.this.mContext == null) {
                return;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView shakeView = com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.this;
            shakeView.startShake(shakeView.mContext);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.this.mNowShakeDegree = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.this.postInvalidate();
        }
    }

    public ShakeView(@androidx.annotation.NonNull android.content.Context context, com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean shakeBean) {
        super(context);
        this.isShake = false;
        this.mLastTimeShake = 0L;
        this.mSenAccelerometer = null;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        this.count = 0;
        init(context, shakeBean);
    }

    public ShakeView(@androidx.annotation.NonNull android.content.Context context, java.lang.String str, com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean shakeBean) {
        super(context);
        this.isShake = false;
        this.mLastTimeShake = 0L;
        this.mSenAccelerometer = null;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        this.count = 0;
        this.mShowText1 = str;
        init(context, shakeBean);
    }

    private void drawText(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.graphics.Rect rect, float f, int i, boolean z) {
        if (z) {
            paint.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        } else {
            paint.setTypeface(android.graphics.Typeface.DEFAULT);
        }
        paint.setTextSize(f);
        paint.setColor(i);
        android.graphics.Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = fontMetrics.bottom;
        canvas.drawText(str, rect.centerX(), rect.centerY() + (((f2 - fontMetrics.top) / 2.0f) - f2), paint);
    }

    private double getShakeIntensity(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr2 == null || fArr.length < 2 || fArr2.length < 2) {
            return 0.0d;
        }
        return java.lang.Math.sqrt(java.lang.Math.pow(fArr[0] - fArr2[0], 2.0d) + java.lang.Math.pow(fArr[1] - fArr2[1], 2.0d));
    }

    private void init(android.content.Context context, com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean shakeBean) {
        this.mContext = context;
        if (shakeBean != null) {
            this.shakeBean = shakeBean;
        } else {
            this.shakeBean = new com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean().build(null);
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "摇一摇参数：" + shakeBean.toString());
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
        this.mSenSensorManager = sensorManager;
        android.hardware.Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        this.mSenAccelerometer = defaultSensor;
        this.mSenSensorManager.registerListener(this, defaultSensor, 2);
        this.mShakeBitMap = android.graphics.BitmapFactory.decodeResource(context.getResources(), com.alimm.tanx.core.R.drawable.tanx_shake_phone);
        this.mCircleLength = com.alimm.tanx.core.utils.DimenUtil.dp2px(context, 112.0f);
        this.mShakeViewHeight = com.alimm.tanx.core.utils.DimenUtil.dp2px(context, 220.0f);
        this.mPhoneImgSize = new int[]{com.alimm.tanx.core.utils.DimenUtil.dp2px(context, 79.0f), com.alimm.tanx.core.utils.DimenUtil.dp2px(context, 71.0f)};
        this.mShowTextSize1 = com.alimm.tanx.core.utils.DimenUtil.dp2px(context, 20.0f);
        this.mShowTextHeight1 = com.alimm.tanx.core.utils.DimenUtil.dp2px(context, 2.0f);
        this.mPaint = new android.graphics.Paint();
        this.mShakeImgRect = new android.graphics.Rect();
        this.mRealShakeImgRect = new android.graphics.Rect();
        this.mCircleImgRect = new android.graphics.Rect();
        this.mShowTextRect1 = new android.graphics.Rect();
        this.mShowTextRect2 = new android.graphics.Rect();
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mTextPaint = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        this.mTextPaint.setAntiAlias(true);
        if (android.text.TextUtils.isEmpty(this.mShowText1)) {
            this.mShowText1 = "摇一摇";
        }
        this.mShowText2 = "互动跳转详情页面或第三方应用";
        this.mShowTextColor1 = android.graphics.Color.parseColor("#ffffff");
        this.mShowTextColor2 = android.graphics.Color.parseColor("#ffffff");
        startAnimation();
        com.alimm.tanx.core.ut.core.LifeCycleManager.getInstance().register(TAG, new com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.AnonymousClass1());
    }

    private boolean isShakeDirectionOpposite(float[] fArr, float[] fArr2) {
        return fArr != null && fArr2 != null && fArr.length >= 2 && fArr2.length >= 2 && (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) < 0.0f;
    }

    private void onLinerAccSenorChanged(android.hardware.SensorEvent sensorEvent) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.mLastSenorCheckTime < this.shakeBean.getShakeSensorCheckInterval()) {
            return;
        }
        onLinerAccSenorChangedInner(sensorEvent, elapsedRealtime);
        float[] fArr = sensorEvent.values;
        if (fArr != null) {
            this.mLastSensorValues = java.util.Arrays.copyOf(fArr, fArr.length);
        }
        this.mLastSenorCheckTime = elapsedRealtime;
    }

    private void onLinerAccSenorChangedInner(android.hardware.SensorEvent sensorEvent, long j) {
        if (getShakeIntensity(sensorEvent.values, this.mLastSensorValues) < this.shakeBean.getShakeSplash()) {
            return;
        }
        if (j - this.mLastShakeTime > this.shakeBean.getShakeSensorShakeInterval()) {
            this.mShakeCnt = 1;
            this.mLastShakeTime = j;
        } else if (!isShakeDirectionOpposite(sensorEvent.values, this.mLastMatchedSensorValues)) {
            return;
        } else {
            this.mShakeCnt++;
        }
        float[] fArr = sensorEvent.values;
        if (fArr != null) {
            this.mLastMatchedSensorValues = java.util.Arrays.copyOf(fArr, fArr.length);
        }
        if (this.mShakeCnt >= this.shakeBean.getShakeCount()) {
            this.mShakeCnt = 0;
            this.mLastShakeTime = j;
            onShake();
        }
    }

    private void onShake() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback interactiveCallback;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (getVisibility() != 0 || (interactiveCallback = this.mCallBack) == null || currentTimeMillis - this.mLastTimeShake <= 1000) {
            return;
        }
        this.mLastTimeShake = currentTimeMillis;
        interactiveCallback.onShake();
        this.isShake = true;
    }

    private void startAnimation() {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.0f, 15.0f, -5.0f, 15.0f, -5.0f, 10.0f, -5.0f);
        this.mRotateAnimation = ofFloat;
        ofFloat.setDuration(1000L);
        this.mRotateAnimation.setStartDelay(ROTATE_ANIM_INTERVAL_TIME);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
        com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.AnonymousClass2 anonymousClass2 = new com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.AnonymousClass2();
        this.mRotateAnimListener = anonymousClass2;
        this.mRotateAnimation.addUpdateListener(anonymousClass2);
    }

    private void startShakeAnim() {
        android.animation.ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void addSensorList(float f, float f2, float f3) {
        try {
            if (this.sensorList == null) {
                this.sensorList = java.util.Collections.synchronizedList(new java.util.ArrayList());
            }
            if (this.sensorList.size() < 10) {
                this.sensorList.add(new com.alimm.tanx.core.ut.bean.UtSensor(f, f2, f3));
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.IShakeView
    public void load(@androidx.annotation.NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback interactiveCallback, boolean z) {
        this.mCallBack = interactiveCallback;
        if (z) {
            this.mShakeViewHeight = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), 190.0f);
        } else {
            this.mShakeViewHeight = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), 160.0f);
        }
        setMeasuredDimension(getMeasuredWidth(), this.mShakeViewHeight);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startShakeAnim();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback interactiveCallback = this.mCallBack;
        if (interactiveCallback != null) {
            java.util.List<com.alimm.tanx.core.ut.bean.UtSensor> list = this.sensorList;
            if (list != null) {
                interactiveCallback.destroy(com.alibaba.fastjson.JSON.toJSONString(list));
            } else {
                interactiveCallback.destroy("");
            }
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "onDetachedFromWindow");
        recycle();
        com.alimm.tanx.core.ut.core.LifeCycleManager.getInstance().unRegister(TAG);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "onDetachedFromWindow");
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        try {
            android.graphics.Bitmap bitmap = this.mShakeBitMap;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.save();
                canvas.translate(this.mShakeImgRect.centerX(), this.mShakeImgRect.centerY());
                canvas.rotate(this.mNowShakeDegree);
                canvas.drawBitmap(this.mShakeBitMap, (android.graphics.Rect) null, this.mRealShakeImgRect, this.mPaint);
                canvas.restore();
            }
            this.mTextPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
            this.mTextPaint.setShadowLayer(3.0f, 2.0f, 2.0f, 1711276032);
            drawText(canvas, this.mTextPaint, this.mShowText1, this.mShowTextRect1, this.mShowTextSize1, this.mShowTextColor1, true);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int dp2px = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), 10.0f);
        android.graphics.Rect rect = this.mCircleImgRect;
        if (rect != null) {
            int i3 = measuredWidth / 2;
            int i4 = this.mCircleLength;
            rect.set(i3 - (i4 / 2), dp2px, i3 + (i4 / 2), i4 + dp2px);
        }
        int i5 = this.mCircleLength / 2;
        int[] iArr = this.mPhoneImgSize;
        int i6 = iArr[1];
        int i7 = dp2px + (i5 - (i6 / 2));
        android.graphics.Rect rect2 = this.mShakeImgRect;
        if (rect2 != null) {
            int i8 = measuredWidth / 2;
            int i9 = iArr[0];
            rect2.set(i8 - (i9 / 2), i7, i8 + (i9 / 2), i6 + i7);
        }
        android.graphics.Rect rect3 = this.mRealShakeImgRect;
        if (rect3 != null) {
            int[] iArr2 = this.mPhoneImgSize;
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            rect3.set((-i10) / 2, (-i11) / 2, i10 / 2, i11 / 2);
        }
        int dp2px2 = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), 10.0f) + this.mCircleLength + this.mImagePadding;
        this.mShowTextRect1.set(getPaddingLeft(), dp2px2, measuredWidth - getPaddingRight(), ((int) this.mShowTextHeight1) + dp2px2);
        setMeasuredDimension(i, this.mShakeViewHeight);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        android.hardware.Sensor sensor = sensorEvent.sensor;
        if (this.mNowVisibility == 0 && sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            addSensorList(fArr[0], fArr[1], fArr[2]);
            if (((float) java.lang.Math.sqrt((r2 * r2) + (r1 * r1) + (r0 * r0))) >= this.shakeBean.getShakeSplash()) {
                onShake();
            }
        }
        android.hardware.Sensor sensor2 = this.mSenAccelerometer;
        if (sensor2 == null || sensor2.getType() != 10) {
            return;
        }
        onLinerAccSenorChanged(sensorEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.mNowVisibility = i;
    }

    public void pauseShake() {
        android.hardware.SensorManager sensorManager = this.mSenSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        android.animation.ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public void recycle() {
        android.hardware.SensorManager sensorManager = this.mSenSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.mSenSensorManager = null;
        }
        android.animation.ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mRotateAnimListener;
            if (animatorUpdateListener != null) {
                this.mRotateAnimation.removeUpdateListener(animatorUpdateListener);
            }
            this.mRotateAnimation = null;
        }
        android.graphics.Bitmap bitmap = this.mShakeBitMap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mShakeBitMap = null;
        }
    }

    public void setImagePadding(int i) {
        if (getContext() != null) {
            this.mImagePadding = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), i);
        }
    }

    public void setMessageTextSize(float f) {
        if (getContext() == null || f <= 0.0f) {
            return;
        }
        this.mShowTextSize2 = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), f);
    }

    public void setTextPadding(int i) {
        if (getContext() != null) {
            this.mTextPadding = com.alimm.tanx.core.utils.DimenUtil.dp2px(getContext(), i);
        }
    }

    public void setTitleTextSize(float f) {
        this.mShowTextSize1 = f;
    }

    public void startShake(android.content.Context context) {
        try {
            if (this.mSenSensorManager == null) {
                this.mSenSensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
            }
            android.hardware.Sensor defaultSensor = this.mSenSensorManager.getDefaultSensor(10);
            this.mSenAccelerometer = defaultSensor;
            this.mSenSensorManager.registerListener(this, defaultSensor, 2);
            android.animation.ValueAnimator valueAnimator = this.mRotateAnimation;
            if (valueAnimator != null) {
                valueAnimator.resume();
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }
}
