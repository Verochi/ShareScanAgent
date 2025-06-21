package com.google.android.material.timepicker;

/* loaded from: classes22.dex */
class TimePickerClockPresenter implements com.google.android.material.timepicker.ClockHandView.OnRotateListener, com.google.android.material.timepicker.TimePickerView.OnSelectionChange, com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener, com.google.android.material.timepicker.ClockHandView.OnActionUpListener, com.google.android.material.timepicker.TimePickerPresenter {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private boolean broadcasting = false;
    private float hourRotation;
    private float minuteRotation;
    private com.google.android.material.timepicker.TimeModel time;
    private com.google.android.material.timepicker.TimePickerView timePickerView;
    private static final java.lang.String[] HOUR_CLOCK_VALUES = {com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, "1", "2", "3", "4", "5", "6", "7", "8", "9", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
    private static final java.lang.String[] HOUR_CLOCK_24_VALUES = {org.apache.tools.tar.TarConstants.VERSION_POSIX, "2", "4", "6", "8", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP, "18", "20", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE};
    private static final java.lang.String[] MINUTE_CLOCK_VALUES = {org.apache.tools.tar.TarConstants.VERSION_POSIX, "5", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE, "20", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "30", "35", "40", "45", "50", "55"};

    public TimePickerClockPresenter(com.google.android.material.timepicker.TimePickerView timePickerView, com.google.android.material.timepicker.TimeModel timeModel) {
        this.timePickerView = timePickerView;
        this.time = timeModel;
        initialize();
    }

    private int getDegreesPerHour() {
        return this.time.format == 1 ? 15 : 30;
    }

    private java.lang.String[] getHourClockValues() {
        return this.time.format == 1 ? HOUR_CLOCK_24_VALUES : HOUR_CLOCK_VALUES;
    }

    private void performHapticFeedback(int i, int i2) {
        com.google.android.material.timepicker.TimeModel timeModel = this.time;
        if (timeModel.minute == i2 && timeModel.hour == i) {
            return;
        }
        this.timePickerView.performHapticFeedback(4);
    }

    private void updateTime() {
        com.google.android.material.timepicker.TimePickerView timePickerView = this.timePickerView;
        com.google.android.material.timepicker.TimeModel timeModel = this.time;
        timePickerView.updateTime(timeModel.period, timeModel.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT);
        updateValues(HOUR_CLOCK_24_VALUES, com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT);
        updateValues(MINUTE_CLOCK_VALUES, com.google.android.material.timepicker.TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void updateValues(java.lang.String[] strArr, java.lang.String str) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = com.google.android.material.timepicker.TimeModel.formatText(this.timePickerView.getResources(), strArr[i], str);
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        if (this.time.format == 0) {
            this.timePickerView.showToggle();
        }
        this.timePickerView.addOnRotateListener(this);
        this.timePickerView.setOnSelectionChangeListener(this);
        this.timePickerView.setOnPeriodChangeListener(this);
        this.timePickerView.setOnActionUpListener(this);
        updateValues();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        this.hourRotation = this.time.getHourForDisplay() * getDegreesPerHour();
        com.google.android.material.timepicker.TimeModel timeModel = this.time;
        this.minuteRotation = timeModel.minute * 6;
        setSelection(timeModel.selection, false);
        updateTime();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float f, boolean z) {
        this.broadcasting = true;
        com.google.android.material.timepicker.TimeModel timeModel = this.time;
        int i = timeModel.minute;
        int i2 = timeModel.hour;
        if (timeModel.selection == 10) {
            this.timePickerView.setHandRotation(this.hourRotation, false);
            if (!((android.view.accessibility.AccessibilityManager) androidx.core.content.ContextCompat.getSystemService(this.timePickerView.getContext(), android.view.accessibility.AccessibilityManager.class)).isTouchExplorationEnabled()) {
                setSelection(12, true);
            }
        } else {
            int round = java.lang.Math.round(f);
            if (!z) {
                this.time.setMinute(((round + 15) / 30) * 5);
                this.minuteRotation = this.time.minute * 6;
            }
            this.timePickerView.setHandRotation(this.minuteRotation, z);
        }
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(i2, i);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void onPeriodChange(int i) {
        this.time.setPeriod(i);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f, boolean z) {
        if (this.broadcasting) {
            return;
        }
        com.google.android.material.timepicker.TimeModel timeModel = this.time;
        int i = timeModel.hour;
        int i2 = timeModel.minute;
        int round = java.lang.Math.round(f);
        com.google.android.material.timepicker.TimeModel timeModel2 = this.time;
        if (timeModel2.selection == 12) {
            timeModel2.setMinute((round + 3) / 6);
            this.minuteRotation = (float) java.lang.Math.floor(this.time.minute * 6);
        } else {
            this.time.setHour((round + (getDegreesPerHour() / 2)) / getDegreesPerHour());
            this.hourRotation = this.time.getHourForDisplay() * getDegreesPerHour();
        }
        if (z) {
            return;
        }
        updateTime();
        performHapticFeedback(i, i2);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int i) {
        setSelection(i, true);
    }

    public void setSelection(int i, boolean z) {
        boolean z2 = i == 12;
        this.timePickerView.setAnimateOnTouchUp(z2);
        this.time.selection = i;
        this.timePickerView.setValues(z2 ? MINUTE_CLOCK_VALUES : getHourClockValues(), z2 ? com.google.android.material.R.string.material_minute_suffix : com.google.android.material.R.string.material_hour_suffix);
        this.timePickerView.setHandRotation(z2 ? this.minuteRotation : this.hourRotation, z);
        this.timePickerView.setActiveSelection(i);
        this.timePickerView.setMinuteHourDelegate(new com.google.android.material.timepicker.ClickActionDelegate(this.timePickerView.getContext(), com.google.android.material.R.string.material_hour_selection));
        this.timePickerView.setHourClickDelegate(new com.google.android.material.timepicker.ClickActionDelegate(this.timePickerView.getContext(), com.google.android.material.R.string.material_minute_selection));
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }
}
