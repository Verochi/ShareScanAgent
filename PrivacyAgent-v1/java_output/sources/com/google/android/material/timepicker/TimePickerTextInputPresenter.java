package com.google.android.material.timepicker;

/* loaded from: classes22.dex */
class TimePickerTextInputPresenter implements com.google.android.material.timepicker.TimePickerView.OnSelectionChange, com.google.android.material.timepicker.TimePickerPresenter {
    private final com.google.android.material.timepicker.TimePickerTextInputKeyController controller;
    private final android.widget.EditText hourEditText;
    private final com.google.android.material.timepicker.ChipTextInputComboView hourTextInput;
    private final android.widget.EditText minuteEditText;
    private final com.google.android.material.timepicker.ChipTextInputComboView minuteTextInput;
    private final com.google.android.material.timepicker.TimeModel time;
    private final android.widget.LinearLayout timePickerView;
    private com.google.android.material.button.MaterialButtonToggleGroup toggle;
    private final android.text.TextWatcher minuteTextWatcher = new com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass1();
    private final android.text.TextWatcher hourTextWatcher = new com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass2();

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.material.internal.TextWatcherAdapter {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            try {
                if (android.text.TextUtils.isEmpty(editable)) {
                    com.google.android.material.timepicker.TimePickerTextInputPresenter.this.time.setMinute(0);
                } else {
                    com.google.android.material.timepicker.TimePickerTextInputPresenter.this.time.setMinute(java.lang.Integer.parseInt(editable.toString()));
                }
            } catch (java.lang.NumberFormatException unused) {
            }
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.android.material.internal.TextWatcherAdapter {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            try {
                if (android.text.TextUtils.isEmpty(editable)) {
                    com.google.android.material.timepicker.TimePickerTextInputPresenter.this.time.setHour(0);
                } else {
                    com.google.android.material.timepicker.TimePickerTextInputPresenter.this.time.setHour(java.lang.Integer.parseInt(editable.toString()));
                }
            } catch (java.lang.NumberFormatException unused) {
            }
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.material.timepicker.TimePickerTextInputPresenter.this.onSelectionChanged(((java.lang.Integer) view.getTag(com.google.android.material.R.id.selection_type)).intValue());
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$4, reason: invalid class name */
    public class AnonymousClass4 implements com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener {
        public AnonymousClass4() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
        public void onButtonChecked(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
            com.google.android.material.timepicker.TimePickerTextInputPresenter.this.time.setPeriod(i == com.google.android.material.R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public TimePickerTextInputPresenter(android.widget.LinearLayout linearLayout, com.google.android.material.timepicker.TimeModel timeModel) {
        this.timePickerView = linearLayout;
        this.time = timeModel;
        android.content.res.Resources resources = linearLayout.getResources();
        com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView = (com.google.android.material.timepicker.ChipTextInputComboView) linearLayout.findViewById(com.google.android.material.R.id.material_minute_text_input);
        this.minuteTextInput = chipTextInputComboView;
        com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView2 = (com.google.android.material.timepicker.ChipTextInputComboView) linearLayout.findViewById(com.google.android.material.R.id.material_hour_text_input);
        this.hourTextInput = chipTextInputComboView2;
        int i = com.google.android.material.R.id.material_label;
        android.widget.TextView textView = (android.widget.TextView) chipTextInputComboView.findViewById(i);
        android.widget.TextView textView2 = (android.widget.TextView) chipTextInputComboView2.findViewById(i);
        textView.setText(resources.getString(com.google.android.material.R.string.material_timepicker_minute));
        textView2.setText(resources.getString(com.google.android.material.R.string.material_timepicker_hour));
        int i2 = com.google.android.material.R.id.selection_type;
        chipTextInputComboView.setTag(i2, 12);
        chipTextInputComboView2.setTag(i2, 10);
        if (timeModel.format == 0) {
            setupPeriodToggle();
        }
        com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass3 anonymousClass3 = new com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass3();
        chipTextInputComboView2.setOnClickListener(anonymousClass3);
        chipTextInputComboView.setOnClickListener(anonymousClass3);
        chipTextInputComboView2.addInputFilter(timeModel.getHourInputValidator());
        chipTextInputComboView.addInputFilter(timeModel.getMinuteInputValidator());
        this.hourEditText = chipTextInputComboView2.getTextInput().getEditText();
        this.minuteEditText = chipTextInputComboView.getTextInput().getEditText();
        this.controller = new com.google.android.material.timepicker.TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.setChipDelegate(new com.google.android.material.timepicker.ClickActionDelegate(linearLayout.getContext(), com.google.android.material.R.string.material_hour_selection));
        chipTextInputComboView.setChipDelegate(new com.google.android.material.timepicker.ClickActionDelegate(linearLayout.getContext(), com.google.android.material.R.string.material_minute_selection));
        initialize();
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private static void setCursorDrawableColor(android.widget.EditText editText, @androidx.annotation.ColorInt int i) {
        try {
            android.content.Context context = editText.getContext();
            java.lang.reflect.Field declaredField = android.widget.TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(editText);
            java.lang.reflect.Field declaredField2 = android.widget.TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            java.lang.Object obj = declaredField2.get(editText);
            java.lang.reflect.Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            android.graphics.drawable.Drawable drawable = androidx.appcompat.content.res.AppCompatResources.getDrawable(context, i2);
            drawable.setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new android.graphics.drawable.Drawable[]{drawable, drawable});
        } catch (java.lang.Throwable unused) {
        }
    }

    private void setTime(com.google.android.material.timepicker.TimeModel timeModel) {
        removeTextWatchers();
        java.util.Locale locale = this.timePickerView.getResources().getConfiguration().locale;
        java.lang.String format = java.lang.String.format(locale, com.google.android.material.timepicker.TimeModel.ZERO_LEADING_NUMBER_FORMAT, java.lang.Integer.valueOf(timeModel.minute));
        java.lang.String format2 = java.lang.String.format(locale, com.google.android.material.timepicker.TimeModel.ZERO_LEADING_NUMBER_FORMAT, java.lang.Integer.valueOf(timeModel.getHourForDisplay()));
        this.minuteTextInput.setText(format);
        this.hourTextInput.setText(format2);
        addTextWatchers();
        updateSelection();
    }

    private void setupPeriodToggle() {
        com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup = (com.google.android.material.button.MaterialButtonToggleGroup) this.timePickerView.findViewById(com.google.android.material.R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass4());
        this.toggle.setVisibility(0);
        updateSelection();
    }

    private void updateSelection() {
        com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup = this.toggle;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.check(this.time.period == 0 ? com.google.android.material.R.id.material_clock_period_am_button : com.google.android.material.R.id.material_clock_period_pm_button);
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        android.view.View focusedChild = this.timePickerView.getFocusedChild();
        if (focusedChild == null) {
            this.timePickerView.setVisibility(8);
            return;
        }
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) androidx.core.content.ContextCompat.getSystemService(this.timePickerView.getContext(), android.view.inputmethod.InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        setTime(this.time);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int i) {
        this.time.selection = i;
        this.minuteTextInput.setChecked(i == 12);
        this.hourTextInput.setChecked(i == 10);
        updateSelection();
    }

    public void resetChecked() {
        this.minuteTextInput.setChecked(this.time.selection == 12);
        this.hourTextInput.setChecked(this.time.selection == 10);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }
}
