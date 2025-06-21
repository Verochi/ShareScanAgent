package com.google.android.material.timepicker;

/* loaded from: classes22.dex */
class TimePickerView extends androidx.constraintlayout.widget.ConstraintLayout implements com.google.android.material.timepicker.TimePickerControls {
    private final com.google.android.material.timepicker.ClockFaceView clockFace;
    private final com.google.android.material.timepicker.ClockHandView clockHandView;
    private final com.google.android.material.chip.Chip hourView;
    private final com.google.android.material.chip.Chip minuteView;
    private com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener onDoubleTapListener;
    private com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener onPeriodChangeListener;
    private com.google.android.material.timepicker.TimePickerView.OnSelectionChange onSelectionChangeListener;
    private final android.view.View.OnClickListener selectionListener;
    private final com.google.android.material.button.MaterialButtonToggleGroup toggle;

    /* renamed from: com.google.android.material.timepicker.TimePickerView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (com.google.android.material.timepicker.TimePickerView.this.onSelectionChangeListener != null) {
                com.google.android.material.timepicker.TimePickerView.this.onSelectionChangeListener.onSelectionChanged(((java.lang.Integer) view.getTag(com.google.android.material.R.id.selection_type)).intValue());
            }
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
        public void onButtonChecked(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
            int i2 = i == com.google.android.material.R.id.material_clock_period_pm_button ? 1 : 0;
            if (com.google.android.material.timepicker.TimePickerView.this.onPeriodChangeListener == null || !z) {
                return;
            }
            com.google.android.material.timepicker.TimePickerView.this.onPeriodChangeListener.onPeriodChange(i2);
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$3, reason: invalid class name */
    public class AnonymousClass3 extends android.view.GestureDetector.SimpleOnGestureListener {
        public AnonymousClass3() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            if (com.google.android.material.timepicker.TimePickerView.this.onDoubleTapListener != null) {
                com.google.android.material.timepicker.TimePickerView.this.onDoubleTapListener.onDoubleTap();
            }
            return onDoubleTap;
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnTouchListener {
        final /* synthetic */ android.view.GestureDetector val$gestureDetector;

        public AnonymousClass4(android.view.GestureDetector gestureDetector) {
            this.val$gestureDetector = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            if (((android.widget.Checkable) view).isChecked()) {
                return this.val$gestureDetector.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public interface OnDoubleTapListener {
        void onDoubleTap();
    }

    public interface OnPeriodChangeListener {
        void onPeriodChange(int i);
    }

    public interface OnSelectionChange {
        void onSelectionChanged(int i);
    }

    public TimePickerView(android.content.Context context) {
        this(context, null);
    }

    public TimePickerView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectionListener = new com.google.android.material.timepicker.TimePickerView.AnonymousClass1();
        android.view.LayoutInflater.from(context).inflate(com.google.android.material.R.layout.material_timepicker, this);
        this.clockFace = (com.google.android.material.timepicker.ClockFaceView) findViewById(com.google.android.material.R.id.material_clock_face);
        com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup = (com.google.android.material.button.MaterialButtonToggleGroup) findViewById(com.google.android.material.R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new com.google.android.material.timepicker.TimePickerView.AnonymousClass2());
        this.minuteView = (com.google.android.material.chip.Chip) findViewById(com.google.android.material.R.id.material_minute_tv);
        this.hourView = (com.google.android.material.chip.Chip) findViewById(com.google.android.material.R.id.material_hour_tv);
        this.clockHandView = (com.google.android.material.timepicker.ClockHandView) findViewById(com.google.android.material.R.id.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }

    private void setUpDisplay() {
        com.google.android.material.chip.Chip chip = this.minuteView;
        int i = com.google.android.material.R.id.selection_type;
        chip.setTag(i, 12);
        this.hourView.setTag(i, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        com.google.android.material.timepicker.TimePickerView.AnonymousClass4 anonymousClass4 = new com.google.android.material.timepicker.TimePickerView.AnonymousClass4(new android.view.GestureDetector(getContext(), new com.google.android.material.timepicker.TimePickerView.AnonymousClass3()));
        this.minuteView.setOnTouchListener(anonymousClass4);
        this.hourView.setOnTouchListener(anonymousClass4);
    }

    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() == 0) {
            androidx.constraintlayout.widget.ConstraintSet constraintSet = new androidx.constraintlayout.widget.ConstraintSet();
            constraintSet.clone(this);
            constraintSet.clear(com.google.android.material.R.id.material_clock_display, androidx.core.view.ViewCompat.getLayoutDirection(this) == 0 ? 2 : 1);
            constraintSet.applyTo(this);
        }
    }

    public void addOnRotateListener(com.google.android.material.timepicker.ClockHandView.OnRotateListener onRotateListener) {
        this.clockHandView.addOnRotateListener(onRotateListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            updateToggleConstraints();
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setActiveSelection(int i) {
        this.minuteView.setChecked(i == 12);
        this.hourView.setChecked(i == 10);
    }

    public void setAnimateOnTouchUp(boolean z) {
        this.clockHandView.setAnimateOnTouchUp(z);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setHandRotation(float f) {
        this.clockHandView.setHandRotation(f);
    }

    public void setHandRotation(float f, boolean z) {
        this.clockHandView.setHandRotation(f, z);
    }

    public void setHourClickDelegate(androidx.core.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this.minuteView, accessibilityDelegateCompat);
    }

    public void setMinuteHourDelegate(androidx.core.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this.hourView, accessibilityDelegateCompat);
    }

    public void setOnActionUpListener(com.google.android.material.timepicker.ClockHandView.OnActionUpListener onActionUpListener) {
        this.clockHandView.setOnActionUpListener(onActionUpListener);
    }

    public void setOnDoubleTapListener(@androidx.annotation.Nullable com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener onDoubleTapListener) {
        this.onDoubleTapListener = onDoubleTapListener;
    }

    public void setOnPeriodChangeListener(com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener onPeriodChangeListener) {
        this.onPeriodChangeListener = onPeriodChangeListener;
    }

    public void setOnSelectionChangeListener(com.google.android.material.timepicker.TimePickerView.OnSelectionChange onSelectionChange) {
        this.onSelectionChangeListener = onSelectionChange;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setValues(java.lang.String[] strArr, @androidx.annotation.StringRes int i) {
        this.clockFace.setValues(strArr, i);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    @android.annotation.SuppressLint({"DefaultLocale"})
    public void updateTime(int i, int i2, int i3) {
        this.toggle.check(i == 1 ? com.google.android.material.R.id.material_clock_period_pm_button : com.google.android.material.R.id.material_clock_period_am_button);
        java.util.Locale locale = getResources().getConfiguration().locale;
        java.lang.String format = java.lang.String.format(locale, com.google.android.material.timepicker.TimeModel.ZERO_LEADING_NUMBER_FORMAT, java.lang.Integer.valueOf(i3));
        java.lang.String format2 = java.lang.String.format(locale, com.google.android.material.timepicker.TimeModel.ZERO_LEADING_NUMBER_FORMAT, java.lang.Integer.valueOf(i2));
        this.minuteView.setText(format);
        this.hourView.setText(format2);
    }
}
