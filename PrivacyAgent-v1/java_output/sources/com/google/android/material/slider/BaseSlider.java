package com.google.android.material.slider;

/* loaded from: classes22.dex */
abstract class BaseSlider<S extends com.google.android.material.slider.BaseSlider<S, L, T>, L extends com.google.android.material.slider.BaseOnChangeListener<S>, T extends com.google.android.material.slider.BaseOnSliderTouchListener<S>> extends android.view.View {
    static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Slider;
    private static final java.lang.String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final java.lang.String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final java.lang.String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final java.lang.String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final java.lang.String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final long LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final long LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final java.lang.String TAG = "BaseSlider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final java.lang.String WARNING_FLOATING_POINT_ERRROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    private com.google.android.material.slider.BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;

    @androidx.annotation.NonNull
    private final com.google.android.material.slider.BaseSlider.AccessibilityHelper accessibilityHelper;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private int activeThumbIdx;

    @androidx.annotation.NonNull
    private final android.graphics.Paint activeTicksPaint;

    @androidx.annotation.NonNull
    private final android.graphics.Paint activeTrackPaint;

    @androidx.annotation.NonNull
    private final java.util.List<L> changeListeners;
    private int defaultThumbRadius;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private com.google.android.material.slider.LabelFormatter formatter;

    @androidx.annotation.NonNull
    private android.content.res.ColorStateList haloColor;

    @androidx.annotation.NonNull
    private final android.graphics.Paint haloPaint;
    private int haloRadius;

    @androidx.annotation.NonNull
    private final android.graphics.Paint inactiveTicksPaint;

    @androidx.annotation.NonNull
    private final android.graphics.Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;

    @androidx.annotation.NonNull
    private final com.google.android.material.slider.BaseSlider.TooltipDrawableFactory labelMaker;
    private int labelPadding;

    @androidx.annotation.NonNull
    private final java.util.List<com.google.android.material.tooltip.TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private android.animation.ValueAnimator labelsInAnimator;
    private android.animation.ValueAnimator labelsOutAnimator;
    private android.view.MotionEvent lastEvent;
    private int minTrackSidePadding;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;

    @androidx.annotation.NonNull
    private final com.google.android.material.shape.MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;

    @androidx.annotation.NonNull
    private final android.graphics.Paint thumbPaint;
    private int thumbRadius;

    @androidx.annotation.NonNull
    private android.content.res.ColorStateList tickColorActive;

    @androidx.annotation.NonNull
    private android.content.res.ColorStateList tickColorInactive;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;

    @androidx.annotation.NonNull
    private final java.util.List<T> touchListeners;
    private float touchPosition;

    @androidx.annotation.NonNull
    private android.content.res.ColorStateList trackColorActive;

    @androidx.annotation.NonNull
    private android.content.res.ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private java.util.ArrayList<java.lang.Float> values;
    private int widgetHeight;

    /* renamed from: com.google.android.material.slider.BaseSlider$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.material.slider.BaseSlider.TooltipDrawableFactory {
        final /* synthetic */ android.util.AttributeSet val$attrs;
        final /* synthetic */ int val$defStyleAttr;

        public AnonymousClass1(android.util.AttributeSet attributeSet, int i) {
            this.val$attrs = attributeSet;
            this.val$defStyleAttr = i;
        }

        @Override // com.google.android.material.slider.BaseSlider.TooltipDrawableFactory
        public com.google.android.material.tooltip.TooltipDrawable createTooltipDrawable() {
            android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(com.google.android.material.slider.BaseSlider.this.getContext(), this.val$attrs, com.google.android.material.R.styleable.Slider, this.val$defStyleAttr, com.google.android.material.slider.BaseSlider.DEF_STYLE_RES, new int[0]);
            com.google.android.material.tooltip.TooltipDrawable parseLabelDrawable = com.google.android.material.slider.BaseSlider.parseLabelDrawable(com.google.android.material.slider.BaseSlider.this.getContext(), obtainStyledAttributes);
            obtainStyledAttributes.recycle();
            return parseLabelDrawable;
        }
    }

    /* renamed from: com.google.android.material.slider.BaseSlider$2, reason: invalid class name */
    public class AnonymousClass2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            java.util.Iterator it = com.google.android.material.slider.BaseSlider.this.labels.iterator();
            while (it.hasNext()) {
                ((com.google.android.material.tooltip.TooltipDrawable) it.next()).setRevealFraction(floatValue);
            }
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(com.google.android.material.slider.BaseSlider.this);
        }
    }

    /* renamed from: com.google.android.material.slider.BaseSlider$3, reason: invalid class name */
    public class AnonymousClass3 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            java.util.Iterator it = com.google.android.material.slider.BaseSlider.this.labels.iterator();
            while (it.hasNext()) {
                com.google.android.material.internal.ViewUtils.getContentViewOverlay(com.google.android.material.slider.BaseSlider.this).remove((com.google.android.material.tooltip.TooltipDrawable) it.next());
            }
        }
    }

    public class AccessibilityEventSender implements java.lang.Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        public /* synthetic */ AccessibilityEventSender(com.google.android.material.slider.BaseSlider baseSlider, com.google.android.material.slider.BaseSlider.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.slider.BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }

        public void setVirtualViewId(int i) {
            this.virtualViewId = i;
        }
    }

    public static class AccessibilityHelper extends androidx.customview.widget.ExploreByTouchHelper {
        private final com.google.android.material.slider.BaseSlider<?, ?, ?> slider;
        android.graphics.Rect virtualViewBounds;

        public AccessibilityHelper(com.google.android.material.slider.BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.virtualViewBounds = new android.graphics.Rect();
            this.slider = baseSlider;
        }

        @androidx.annotation.NonNull
        private java.lang.String startOrEndDescription(int i) {
            return i == this.slider.getValues().size() + (-1) ? this.slider.getContext().getString(com.google.android.material.R.string.material_slider_range_end) : i == 0 ? this.slider.getContext().getString(com.google.android.material.R.string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) f, (int) f2)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(java.util.List<java.lang.Integer> list) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                list.add(java.lang.Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, android.os.Bundle bundle) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            if (i2 != 4096 && i2 != 8192) {
                if (i2 == 16908349 && bundle != null && bundle.containsKey(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.slider.snapThumbToValue(i, bundle.getFloat(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.slider.updateHaloHotspot();
                        this.slider.postInvalidate();
                        invalidateVirtualView(i);
                        return true;
                    }
                }
                return false;
            }
            float calculateStepIncrement = this.slider.calculateStepIncrement(20);
            if (i2 == 8192) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            if (this.slider.isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            if (!this.slider.snapThumbToValue(i, androidx.core.math.MathUtils.clamp(this.slider.getValues().get(i).floatValue() + calculateStepIncrement, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                return false;
            }
            this.slider.updateHaloHotspot();
            this.slider.postInvalidate();
            invalidateVirtualView(i);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            java.util.List<java.lang.Float> values = this.slider.getValues();
            float floatValue = values.get(i).floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(android.widget.SeekBar.class.getName());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (this.slider.getContentDescription() != null) {
                sb.append(this.slider.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(startOrEndDescription(i));
                sb.append(this.slider.formatValue(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.slider.updateBoundsForVirturalViewId(i, this.virtualViewBounds);
            accessibilityNodeInfoCompat.setBoundsInParent(this.virtualViewBounds);
        }
    }

    public static class SliderState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.slider.BaseSlider.SliderState> CREATOR = new com.google.android.material.slider.BaseSlider.SliderState.AnonymousClass1();
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        java.util.ArrayList<java.lang.Float> values;

        /* renamed from: com.google.android.material.slider.BaseSlider$SliderState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.material.slider.BaseSlider.SliderState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.slider.BaseSlider.SliderState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.slider.BaseSlider.SliderState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.slider.BaseSlider.SliderState[] newArray(int i) {
                return new com.google.android.material.slider.BaseSlider.SliderState[i];
            }
        }

        private SliderState(@androidx.annotation.NonNull android.os.Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            java.util.ArrayList<java.lang.Float> arrayList = new java.util.ArrayList<>();
            this.values = arrayList;
            parcel.readList(arrayList, java.lang.Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }

        public /* synthetic */ SliderState(android.os.Parcel parcel, com.google.android.material.slider.BaseSlider.AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        public SliderState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    public interface TooltipDrawableFactory {
        com.google.android.material.tooltip.TooltipDrawable createTooltipDrawable();
    }

    public BaseSlider(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public BaseSlider(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.sliderStyle);
    }

    public BaseSlider(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.labels = new java.util.ArrayList();
        this.changeListeners = new java.util.ArrayList();
        this.touchListeners = new java.util.ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new java.util.ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        this.thumbDrawable = materialShapeDrawable;
        this.separationUnit = 0;
        android.content.Context context2 = getContext();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.inactiveTrackPaint = paint;
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        paint2.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        android.graphics.Paint paint3 = new android.graphics.Paint(1);
        this.thumbPaint = paint3;
        paint3.setStyle(android.graphics.Paint.Style.FILL);
        paint3.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        android.graphics.Paint paint4 = new android.graphics.Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint5 = new android.graphics.Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(android.graphics.Paint.Style.STROKE);
        paint5.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        android.graphics.Paint paint6 = new android.graphics.Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(android.graphics.Paint.Style.STROKE);
        paint6.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        loadResources(context2.getResources());
        this.labelMaker = new com.google.android.material.slider.BaseSlider.AnonymousClass1(attributeSet, i);
        processAttributes(context2, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = android.view.ViewConfiguration.get(context2).getScaledTouchSlop();
        com.google.android.material.slider.BaseSlider.AccessibilityHelper accessibilityHelper = new com.google.android.material.slider.BaseSlider.AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper;
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this, accessibilityHelper);
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private void attachLabelToContentView(com.google.android.material.tooltip.TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(com.google.android.material.internal.ViewUtils.getContentView(this));
    }

    private java.lang.Float calculateIncrementForKey(int i) {
        float calculateStepIncrement = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
        if (i == 21) {
            if (!isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            return java.lang.Float.valueOf(calculateStepIncrement);
        }
        if (i == 22) {
            if (isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            return java.lang.Float.valueOf(calculateStepIncrement);
        }
        if (i == 69) {
            return java.lang.Float.valueOf(-calculateStepIncrement);
        }
        if (i == 70 || i == 81) {
            return java.lang.Float.valueOf(calculateStepIncrement);
        }
        return null;
    }

    private float calculateStepIncrement() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return 1.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateStepIncrement(int i) {
        float calculateStepIncrement = calculateStepIncrement();
        return (this.valueTo - this.valueFrom) / calculateStepIncrement <= i ? calculateStepIncrement : java.lang.Math.round(r1 / r4) * calculateStepIncrement;
    }

    private int calculateTop() {
        return this.trackTop + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0);
    }

    private android.animation.ValueAnimator createLabelAnimator(boolean z) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(getAnimatorCurrentValueOrDefault(z ? this.labelsOutAnimator : this.labelsInAnimator, z ? 0.0f : 1.0f), z ? 1.0f : 0.0f);
        ofFloat.setDuration(z ? LABEL_ANIMATION_ENTER_DURATION : LABEL_ANIMATION_EXIT_DURATION);
        ofFloat.setInterpolator(z ? com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR : com.google.android.material.animation.AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        ofFloat.addUpdateListener(new com.google.android.material.slider.BaseSlider.AnonymousClass2());
        return ofFloat;
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            java.util.List<com.google.android.material.tooltip.TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
            for (com.google.android.material.tooltip.TooltipDrawable tooltipDrawable : subList) {
                if (androidx.core.view.ViewCompat.isAttachedToWindow(this)) {
                    detachLabelFromContentView(tooltipDrawable);
                }
            }
            subList.clear();
        }
        while (this.labels.size() < this.values.size()) {
            com.google.android.material.tooltip.TooltipDrawable createTooltipDrawable = this.labelMaker.createTooltipDrawable();
            this.labels.add(createTooltipDrawable);
            if (androidx.core.view.ViewCompat.isAttachedToWindow(this)) {
                attachLabelToContentView(createTooltipDrawable);
            }
        }
        int i = this.labels.size() == 1 ? 0 : 1;
        java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setStrokeWidth(i);
        }
    }

    private void detachLabelFromContentView(com.google.android.material.tooltip.TooltipDrawable tooltipDrawable) {
        com.google.android.material.internal.ViewOverlayImpl contentViewOverlay = com.google.android.material.internal.ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(tooltipDrawable);
            tooltipDrawable.detachView(com.google.android.material.internal.ViewUtils.getContentView(this));
        }
    }

    private float dimenToValue(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f2 = (f - this.trackSidePadding) / this.trackWidth;
        float f3 = this.valueFrom;
        return (f2 * (f3 - this.valueTo)) + f3;
    }

    private void dispatchOnChangedFromUser(int i) {
        java.util.Iterator<L> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            it.next().onValueChange(this, this.values.get(i).floatValue(), true);
        }
        android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        scheduleAccessibilityEventSender(i);
    }

    private void dispatchOnChangedProgramatically() {
        for (L l : this.changeListeners) {
            java.util.Iterator<java.lang.Float> it = this.values.iterator();
            while (it.hasNext()) {
                l.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void drawActiveTrack(@androidx.annotation.NonNull android.graphics.Canvas canvas, int i, int i2) {
        float[] activeRange = getActiveRange();
        int i3 = this.trackSidePadding;
        float f = i;
        float f2 = i2;
        canvas.drawLine(i3 + (activeRange[0] * f), f2, i3 + (activeRange[1] * f), f2, this.activeTrackPaint);
    }

    private void drawInactiveTrack(@androidx.annotation.NonNull android.graphics.Canvas canvas, int i, int i2) {
        float[] activeRange = getActiveRange();
        float f = i;
        float f2 = this.trackSidePadding + (activeRange[1] * f);
        if (f2 < r1 + i) {
            float f3 = i2;
            canvas.drawLine(f2, f3, r1 + i, f3, this.inactiveTrackPaint);
        }
        int i3 = this.trackSidePadding;
        float f4 = i3 + (activeRange[0] * f);
        if (f4 > i3) {
            float f5 = i2;
            canvas.drawLine(i3, f5, f4, f5, this.inactiveTrackPaint);
        }
    }

    private void drawThumbs(@androidx.annotation.NonNull android.graphics.Canvas canvas, int i, int i2) {
        if (!isEnabled()) {
            java.util.Iterator<java.lang.Float> it = this.values.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.trackSidePadding + (normalizeValue(it.next().floatValue()) * i), i2, this.thumbRadius, this.thumbPaint);
            }
        }
        java.util.Iterator<java.lang.Float> it2 = this.values.iterator();
        while (it2.hasNext()) {
            java.lang.Float next = it2.next();
            canvas.save();
            int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(next.floatValue()) * i));
            int i3 = this.thumbRadius;
            canvas.translate(normalizeValue - i3, i2 - i3);
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void ensureLabelsAdded() {
        if (this.labelBehavior == 2) {
            return;
        }
        if (!this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = true;
            android.animation.ValueAnimator createLabelAnimator = createLabelAnimator(true);
            this.labelsInAnimator = createLabelAnimator;
            this.labelsOutAnimator = null;
            createLabelAnimator.start();
        }
        java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
        for (int i = 0; i < this.values.size() && it.hasNext(); i++) {
            if (i != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(i).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new java.lang.IllegalStateException(java.lang.String.format("Not enough labels(%d) to display all the values(%d)", java.lang.Integer.valueOf(this.labels.size()), java.lang.Integer.valueOf(this.values.size())));
        }
        setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            android.animation.ValueAnimator createLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = createLabelAnimator;
            this.labelsInAnimator = null;
            createLabelAnimator.addListener(new com.google.android.material.slider.BaseSlider.AnonymousClass3());
            this.labelsOutAnimator.start();
        }
    }

    private void focusThumbOnFocusGained(int i) {
        if (i == 1) {
            moveFocus(Integer.MAX_VALUE);
            return;
        }
        if (i == 2) {
            moveFocus(Integer.MIN_VALUE);
        } else if (i == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else {
            if (i != 66) {
                return;
            }
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String formatValue(float f) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f);
        }
        return java.lang.String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", java.lang.Float.valueOf(f));
    }

    private float[] getActiveRange() {
        float floatValue = ((java.lang.Float) java.util.Collections.max(getValues())).floatValue();
        float floatValue2 = ((java.lang.Float) java.util.Collections.min(getValues())).floatValue();
        if (this.values.size() == 1) {
            floatValue2 = this.valueFrom;
        }
        float normalizeValue = normalizeValue(floatValue2);
        float normalizeValue2 = normalizeValue(floatValue);
        return isRtl() ? new float[]{normalizeValue2, normalizeValue} : new float[]{normalizeValue, normalizeValue2};
    }

    private static float getAnimatorCurrentValueOrDefault(android.animation.ValueAnimator valueAnimator, float f) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f;
        }
        float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private float getClampedValue(int i, float f) {
        float minSeparation = this.stepSize == 0.0f ? getMinSeparation() : 0.0f;
        if (this.separationUnit == 0) {
            minSeparation = dimenToValue(minSeparation);
        }
        if (isRtl()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        int i3 = i - 1;
        return androidx.core.math.MathUtils.clamp(f, i3 < 0 ? this.valueFrom : this.values.get(i3).floatValue() + minSeparation, i2 >= this.values.size() ? this.valueTo : this.values.get(i2).floatValue() - minSeparation);
    }

    @androidx.annotation.ColorInt
    private int getColorForState(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float getValueOfTouchPosition() {
        double snapPosition = snapPosition(this.touchPosition);
        if (isRtl()) {
            snapPosition = 1.0d - snapPosition;
        }
        float f = this.valueTo;
        return (float) ((snapPosition * (f - r3)) + this.valueFrom);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f = this.touchPosition;
        if (isRtl()) {
            f = 1.0f - f;
        }
        float f2 = this.valueTo;
        float f3 = this.valueFrom;
        return (f * (f2 - f3)) + f3;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInVerticalScrollingContainer() {
        android.view.ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof android.view.ViewGroup)) {
                return false;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private void loadResources(@androidx.annotation.NonNull android.content.res.Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_slider_thumb_radius);
        this.trackTop = resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_slider_label_padding);
    }

    private void maybeCalculateTicksCoordinates() {
        if (this.stepSize <= 0.0f) {
            return;
        }
        validateConfigurationIfDirty();
        int min = java.lang.Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != min * 2) {
            this.ticksCoordinates = new float[min * 2];
        }
        float f = this.trackWidth / (min - 1);
        for (int i = 0; i < min * 2; i += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i] = this.trackSidePadding + ((i / 2) * f);
            fArr2[i + 1] = calculateTop();
        }
    }

    private void maybeDrawHalo(@androidx.annotation.NonNull android.graphics.Canvas canvas, int i, int i2) {
        if (shouldDrawCompatHalo()) {
            int normalizeValue = (int) (this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * i));
            if (android.os.Build.VERSION.SDK_INT < 28) {
                int i3 = this.haloRadius;
                canvas.clipRect(normalizeValue - i3, i2 - i3, normalizeValue + i3, i3 + i2, android.graphics.Region.Op.UNION);
            }
            canvas.drawCircle(normalizeValue, i2, this.haloRadius, this.haloPaint);
        }
    }

    private void maybeDrawTicks(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (!this.tickVisible || this.stepSize <= 0.0f) {
            return;
        }
        float[] activeRange = getActiveRange();
        int pivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
        int pivotIndex2 = pivotIndex(this.ticksCoordinates, activeRange[1]);
        int i = pivotIndex * 2;
        canvas.drawPoints(this.ticksCoordinates, 0, i, this.inactiveTicksPaint);
        int i2 = pivotIndex2 * 2;
        canvas.drawPoints(this.ticksCoordinates, i, i2 - i, this.activeTicksPaint);
        float[] fArr = this.ticksCoordinates;
        canvas.drawPoints(fArr, i2, fArr.length - i2, this.inactiveTicksPaint);
    }

    private void maybeIncreaseTrackSidePadding() {
        this.trackSidePadding = this.minTrackSidePadding + java.lang.Math.max(this.thumbRadius - this.defaultThumbRadius, 0);
        if (androidx.core.view.ViewCompat.isLaidOut(this)) {
            updateTrackWidth(getWidth());
        }
    }

    private boolean moveFocus(int i) {
        int i2 = this.focusedThumbIdx;
        int clamp = (int) androidx.core.math.MathUtils.clamp(i2 + i, 0L, this.values.size() - 1);
        this.focusedThumbIdx = clamp;
        if (clamp == i2) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = clamp;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int i) {
        if (isRtl()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        return moveFocus(i);
    }

    private float normalizeValue(float f) {
        float f2 = this.valueFrom;
        float f3 = (f - f2) / (this.valueTo - f2);
        return isRtl() ? 1.0f - f3 : f3;
    }

    private java.lang.Boolean onKeyDownNoActiveThumb(int i, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        if (i == 61) {
            return keyEvent.hasNoModifiers() ? java.lang.Boolean.valueOf(moveFocus(1)) : keyEvent.isShiftPressed() ? java.lang.Boolean.valueOf(moveFocus(-1)) : java.lang.Boolean.FALSE;
        }
        if (i != 66) {
            if (i != 81) {
                if (i == 69) {
                    moveFocus(-1);
                    return java.lang.Boolean.TRUE;
                }
                if (i != 70) {
                    switch (i) {
                        case 21:
                            moveFocusInAbsoluteDirection(-1);
                            break;
                        case 22:
                            moveFocusInAbsoluteDirection(1);
                            break;
                    }
                    return java.lang.Boolean.TRUE;
                }
            }
            moveFocus(1);
            return java.lang.Boolean.TRUE;
        }
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return java.lang.Boolean.TRUE;
    }

    private void onStartTrackingTouch() {
        java.util.Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        java.util.Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStopTrackingTouch(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.NonNull
    public static com.google.android.material.tooltip.TooltipDrawable parseLabelDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        return com.google.android.material.tooltip.TooltipDrawable.createFromAttributes(context, null, 0, typedArray.getResourceId(com.google.android.material.R.styleable.Slider_labelStyle, com.google.android.material.R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int pivotIndex(float[] fArr, float f) {
        return java.lang.Math.round(f * ((fArr.length / 2) - 1));
    }

    private void processAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.Slider, i, DEF_STYLE_RES, new int[0]);
        this.valueFrom = obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.Slider_android_valueTo, 1.0f);
        setValues(java.lang.Float.valueOf(this.valueFrom));
        this.stepSize = obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.Slider_android_stepSize, 0.0f);
        int i2 = com.google.android.material.R.styleable.Slider_trackColor;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        int i3 = hasValue ? i2 : com.google.android.material.R.styleable.Slider_trackColorInactive;
        if (!hasValue) {
            i2 = com.google.android.material.R.styleable.Slider_trackColorActive;
        }
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, i3);
        if (colorStateList == null) {
            colorStateList = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, com.google.android.material.R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        android.content.res.ColorStateList colorStateList2 = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, i2);
        if (colorStateList2 == null) {
            colorStateList2 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, com.google.android.material.R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.thumbDrawable.setFillColor(com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.Slider_thumbColor));
        int i4 = com.google.android.material.R.styleable.Slider_thumbStrokeColor;
        if (obtainStyledAttributes.hasValue(i4)) {
            setThumbStrokeColor(com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, i4));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Slider_thumbStrokeWidth, 0.0f));
        android.content.res.ColorStateList colorStateList3 = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, com.google.android.material.R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        this.tickVisible = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Slider_tickVisible, true);
        int i5 = com.google.android.material.R.styleable.Slider_tickColor;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i5);
        int i6 = hasValue2 ? i5 : com.google.android.material.R.styleable.Slider_tickColorInactive;
        if (!hasValue2) {
            i5 = com.google.android.material.R.styleable.Slider_tickColorActive;
        }
        android.content.res.ColorStateList colorStateList4 = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, i6);
        if (colorStateList4 == null) {
            colorStateList4 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, com.google.android.material.R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        android.content.res.ColorStateList colorStateList5 = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, i5);
        if (colorStateList5 == null) {
            colorStateList5 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, com.google.android.material.R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.Slider_labelBehavior, 0);
        if (!obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    private void scheduleAccessibilityEventSender(int i) {
        com.google.android.material.slider.BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.accessibilityEventSender = new com.google.android.material.slider.BaseSlider.AccessibilityEventSender(this, null);
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.accessibilityEventSender.setVirtualViewId(i);
        postDelayed(this.accessibilityEventSender, 200L);
    }

    private void setValueForLabel(com.google.android.material.tooltip.TooltipDrawable tooltipDrawable, float f) {
        tooltipDrawable.setText(formatValue(f));
        int normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int calculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(normalizeValue, calculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + normalizeValue, calculateTop);
        android.graphics.Rect rect = new android.graphics.Rect(tooltipDrawable.getBounds());
        com.google.android.material.internal.DescendantOffsetUtils.offsetDescendantRect(com.google.android.material.internal.ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        com.google.android.material.internal.ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    private void setValuesInternal(@androidx.annotation.NonNull java.util.ArrayList<java.lang.Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new java.lang.IllegalArgumentException("At least one value must be set");
        }
        java.util.Collections.sort(arrayList);
        if (this.values.size() == arrayList.size() && this.values.equals(arrayList)) {
            return;
        }
        this.values = arrayList;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgramatically();
        postInvalidate();
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || !(getBackground() instanceof android.graphics.drawable.RippleDrawable);
    }

    private boolean snapActiveThumbToValue(float f) {
        return snapThumbToValue(this.activeThumbIdx, f);
    }

    private double snapPosition(float f) {
        float f2 = this.stepSize;
        if (f2 <= 0.0f) {
            return f;
        }
        return java.lang.Math.round(f * r0) / ((int) ((this.valueTo - this.valueFrom) / f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapThumbToValue(int i, float f) {
        if (java.lang.Math.abs(f - this.values.get(i).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.values.set(i, java.lang.Float.valueOf(getClampedValue(i, f)));
        this.focusedThumbIdx = i;
        dispatchOnChangedFromUser(i);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (shouldDrawCompatHalo() || getMeasuredWidth() <= 0) {
            return;
        }
        android.graphics.drawable.Drawable background = getBackground();
        if (background instanceof android.graphics.drawable.RippleDrawable) {
            int normalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
            int calculateTop = calculateTop();
            int i = this.haloRadius;
            androidx.core.graphics.drawable.DrawableCompat.setHotspotBounds(background, normalizeValue - i, calculateTop - i, normalizeValue + i, calculateTop + i);
        }
    }

    private void updateTrackWidth(int i) {
        this.trackWidth = java.lang.Math.max(i - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValueFrom();
            validateValueTo();
            validateStepSize();
            validateValues();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new java.lang.IllegalStateException(java.lang.String.format(EXCEPTION_ILLEGAL_STEP_SIZE, java.lang.Float.toString(this.stepSize), java.lang.Float.toString(this.valueFrom), java.lang.Float.toString(this.valueTo)));
        }
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) {
            throw new java.lang.IllegalStateException(java.lang.String.format(EXCEPTION_ILLEGAL_VALUE_FROM, java.lang.Float.toString(this.valueFrom), java.lang.Float.toString(this.valueTo)));
        }
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) {
            throw new java.lang.IllegalStateException(java.lang.String.format(EXCEPTION_ILLEGAL_VALUE_TO, java.lang.Float.toString(this.valueTo), java.lang.Float.toString(this.valueFrom)));
        }
    }

    private void validateValues() {
        java.util.Iterator<java.lang.Float> it = this.values.iterator();
        while (it.hasNext()) {
            java.lang.Float next = it.next();
            if (next.floatValue() < this.valueFrom || next.floatValue() > this.valueTo) {
                throw new java.lang.IllegalStateException(java.lang.String.format(EXCEPTION_ILLEGAL_VALUE, java.lang.Float.toString(next.floatValue()), java.lang.Float.toString(this.valueFrom), java.lang.Float.toString(this.valueTo)));
            }
            if (this.stepSize > 0.0f && !valueLandsOnTick(next.floatValue())) {
                throw new java.lang.IllegalStateException(java.lang.String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, java.lang.Float.toString(next.floatValue()), java.lang.Float.toString(this.valueFrom), java.lang.Float.toString(this.stepSize), java.lang.Float.toString(this.stepSize)));
            }
        }
    }

    private boolean valueLandsOnTick(float f) {
        double doubleValue = new java.math.BigDecimal(java.lang.Float.toString(f)).subtract(new java.math.BigDecimal(java.lang.Float.toString(this.valueFrom))).divide(new java.math.BigDecimal(java.lang.Float.toString(this.stepSize)), java.math.MathContext.DECIMAL64).doubleValue();
        return java.lang.Math.abs(((double) java.lang.Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    private float valueToX(float f) {
        return (normalizeValue(f) * this.trackWidth) + this.trackSidePadding;
    }

    private void warnAboutFloatingPointError() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return;
        }
        if (((int) f) != f) {
            java.lang.String.format(WARNING_FLOATING_POINT_ERRROR, "stepSize", java.lang.Float.valueOf(f));
        }
        float f2 = this.valueFrom;
        if (((int) f2) != f2) {
            java.lang.String.format(WARNING_FLOATING_POINT_ERRROR, "valueFrom", java.lang.Float.valueOf(f2));
        }
        float f3 = this.valueTo;
        if (((int) f3) != f3) {
            java.lang.String.format(WARNING_FLOATING_POINT_ERRROR, "valueTo", java.lang.Float.valueOf(f3));
        }
    }

    public void addOnChangeListener(@androidx.annotation.Nullable L l) {
        this.changeListeners.add(l);
    }

    public void addOnSliderTouchListener(@androidx.annotation.NonNull T t) {
        this.touchListeners.add(t);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (com.google.android.material.tooltip.TooltipDrawable tooltipDrawable : this.labels) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.thumbDrawable.isStateful()) {
            this.thumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    @androidx.annotation.VisibleForTesting
    public void forceDrawCompatHalo(boolean z) {
        this.forceDrawCompatHalo = z;
    }

    @Override // android.view.View
    @androidx.annotation.NonNull
    public java.lang.CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    @androidx.annotation.VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @androidx.annotation.Dimension
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    @androidx.annotation.Dimension
    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public android.content.res.ColorStateList getThumbStrokeColor() {
        return this.thumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.thumbDrawable.getStrokeWidth();
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getThumbTintList() {
        return this.thumbDrawable.getFillColor();
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new java.lang.IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @androidx.annotation.Dimension
    public int getTrackHeight() {
        return this.trackHeight;
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    @androidx.annotation.Dimension
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new java.lang.IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @androidx.annotation.Dimension
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @androidx.annotation.NonNull
    public java.util.List<java.lang.Float> getValues() {
        return new java.util.ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public final boolean isRtl() {
        return androidx.core.view.ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            attachLabelToContentView(it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        com.google.android.material.slider.BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.labelsAreAnimatedIn = false;
        java.util.Iterator<com.google.android.material.tooltip.TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            detachLabelFromContentView(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            maybeCalculateTicksCoordinates();
        }
        super.onDraw(canvas);
        int calculateTop = calculateTop();
        drawInactiveTrack(canvas, this.trackWidth, calculateTop);
        if (((java.lang.Float) java.util.Collections.max(getValues())).floatValue() > this.valueFrom) {
            drawActiveTrack(canvas, this.trackWidth, calculateTop);
        }
        maybeDrawTicks(canvas);
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawHalo(canvas, this.trackWidth, calculateTop);
            if (this.activeThumbIdx != -1) {
                ensureLabelsAdded();
            }
        }
        drawThumbs(canvas, this.trackWidth, calculateTop);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, @androidx.annotation.Nullable android.graphics.Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            focusThumbOnFocusGained(i);
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        } else {
            this.activeThumbIdx = -1;
            ensureLabelsRemoved();
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            java.lang.Boolean onKeyDownNoActiveThumb = onKeyDownNoActiveThumb(i, keyEvent);
            return onKeyDownNoActiveThumb != null ? onKeyDownNoActiveThumb.booleanValue() : super.onKeyDown(i, keyEvent);
        }
        this.isLongPress |= keyEvent.isLongPress();
        java.lang.Float calculateIncrementForKey = calculateIncrementForKey(i);
        if (calculateIncrementForKey != null) {
            if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + calculateIncrementForKey.floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return moveFocus(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return moveFocus(-1);
                }
                return false;
            }
            if (i != 66) {
                return super.onKeyDown(i, keyEvent);
            }
        }
        this.activeThumbIdx = -1;
        ensureLabelsRemoved();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(this.widgetHeight + (this.labelBehavior == 1 ? this.labels.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        com.google.android.material.slider.BaseSlider.SliderState sliderState = (com.google.android.material.slider.BaseSlider.SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
        dispatchOnChangedProgramatically();
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.slider.BaseSlider.SliderState sliderState = new com.google.android.material.slider.BaseSlider.SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new java.util.ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateTrackWidth(i);
        updateHaloHotspot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float f = (x - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = f;
        float max = java.lang.Math.max(0.0f, f);
        this.touchPosition = max;
        this.touchPosition = java.lang.Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x;
            if (!isInVerticalScrollingContainer()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                    onStartTrackingTouch();
                }
            }
        } else if (actionMasked == 1) {
            this.thumbIsPressed = false;
            android.view.MotionEvent motionEvent2 = this.lastEvent;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && java.lang.Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= this.scaledTouchSlop && java.lang.Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= this.scaledTouchSlop && pickActiveThumb()) {
                onStartTrackingTouch();
            }
            if (this.activeThumbIdx != -1) {
                snapTouchPosition();
                this.activeThumbIdx = -1;
                onStopTrackingTouch();
            }
            ensureLabelsRemoved();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (isInVerticalScrollingContainer() && java.lang.Math.abs(x - this.touchDownX) < this.scaledTouchSlop) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                onStartTrackingTouch();
            }
            if (pickActiveThumb()) {
                this.thumbIsPressed = true;
                snapTouchPosition();
                updateHaloHotspot();
                invalidate();
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = android.view.MotionEvent.obtain(motionEvent);
        return true;
    }

    public boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float valueToX = valueToX(valueOfTouchPositionAbsolute);
        this.activeThumbIdx = 0;
        float abs = java.lang.Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i = 1; i < this.values.size(); i++) {
            float abs2 = java.lang.Math.abs(this.values.get(i).floatValue() - valueOfTouchPositionAbsolute);
            float valueToX2 = valueToX(this.values.get(i).floatValue());
            if (java.lang.Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z = !isRtl() ? valueToX2 - valueToX >= 0.0f : valueToX2 - valueToX <= 0.0f;
            if (java.lang.Float.compare(abs2, abs) < 0) {
                this.activeThumbIdx = i;
            } else {
                if (java.lang.Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (java.lang.Math.abs(valueToX2 - valueToX) < this.scaledTouchSlop) {
                        this.activeThumbIdx = -1;
                        return false;
                    }
                    if (z) {
                        this.activeThumbIdx = i;
                    }
                }
            }
            abs = abs2;
        }
        return this.activeThumbIdx != -1;
    }

    public void removeOnChangeListener(@androidx.annotation.NonNull L l) {
        this.changeListeners.remove(l);
    }

    public void removeOnSliderTouchListener(@androidx.annotation.NonNull T t) {
        this.touchListeners.remove(t);
    }

    public void setActiveThumbIndex(int i) {
        this.activeThumbIdx = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.values.size()) {
            throw new java.lang.IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i);
        postInvalidate();
    }

    public void setHaloRadius(@androidx.annotation.IntRange(from = 0) @androidx.annotation.Dimension int i) {
        if (i == this.haloRadius) {
            return;
        }
        this.haloRadius = i;
        android.graphics.drawable.Drawable background = getBackground();
        if (shouldDrawCompatHalo() || !(background instanceof android.graphics.drawable.RippleDrawable)) {
            postInvalidate();
        } else {
            com.google.android.material.drawable.DrawableUtils.setRippleDrawableRadius((android.graphics.drawable.RippleDrawable) background, this.haloRadius);
        }
    }

    public void setHaloRadiusResource(@androidx.annotation.DimenRes int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setHaloTintList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.haloColor)) {
            return;
        }
        this.haloColor = colorStateList;
        android.graphics.drawable.Drawable background = getBackground();
        if (!shouldDrawCompatHalo() && (background instanceof android.graphics.drawable.RippleDrawable)) {
            ((android.graphics.drawable.RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.haloPaint.setColor(getColorForState(colorStateList));
        this.haloPaint.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i) {
        if (this.labelBehavior != i) {
            this.labelBehavior = i;
            requestLayout();
        }
    }

    public void setLabelFormatter(@androidx.annotation.Nullable com.google.android.material.slider.LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public void setSeparationUnit(int i) {
        this.separationUnit = i;
    }

    public void setStepSize(float f) {
        if (f < 0.0f) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(EXCEPTION_ILLEGAL_STEP_SIZE, java.lang.Float.toString(f), java.lang.Float.toString(this.valueFrom), java.lang.Float.toString(this.valueTo)));
        }
        if (this.stepSize != f) {
            this.stepSize = f;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f) {
        this.thumbDrawable.setElevation(f);
    }

    public void setThumbElevationResource(@androidx.annotation.DimenRes int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbRadius(@androidx.annotation.IntRange(from = 0) @androidx.annotation.Dimension int i) {
        if (i == this.thumbRadius) {
            return;
        }
        this.thumbRadius = i;
        maybeIncreaseTrackSidePadding();
        this.thumbDrawable.setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
        int i2 = this.thumbRadius;
        materialShapeDrawable.setBounds(0, 0, i2 * 2, i2 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@androidx.annotation.DimenRes int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbStrokeColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.thumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@androidx.annotation.ColorRes int i) {
        if (i != 0) {
            setThumbStrokeColor(androidx.appcompat.content.res.AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setThumbStrokeWidth(float f) {
        this.thumbDrawable.setStrokeWidth(f);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@androidx.annotation.DimenRes int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.thumbDrawable.getFillColor())) {
            return;
        }
        this.thumbDrawable.setFillColor(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickTintList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.tickVisible != z) {
            this.tickVisible = z;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@androidx.annotation.IntRange(from = 0) @androidx.annotation.Dimension int i) {
        if (this.trackHeight != i) {
            this.trackHeight = i;
            invalidateTrack();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f) {
        this.valueFrom = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.valueTo = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValues(@androidx.annotation.NonNull java.util.List<java.lang.Float> list) {
        setValuesInternal(new java.util.ArrayList<>(list));
    }

    public void setValues(@androidx.annotation.NonNull java.lang.Float... fArr) {
        java.util.ArrayList<java.lang.Float> arrayList = new java.util.ArrayList<>();
        java.util.Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public void updateBoundsForVirturalViewId(int i, android.graphics.Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i).floatValue()) * this.trackWidth));
        int calculateTop = calculateTop();
        int i2 = this.thumbRadius;
        rect.set(normalizeValue - i2, calculateTop - i2, normalizeValue + i2, calculateTop + i2);
    }
}
