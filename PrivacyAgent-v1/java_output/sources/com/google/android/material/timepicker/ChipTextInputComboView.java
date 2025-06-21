package com.google.android.material.timepicker;

/* loaded from: classes22.dex */
class ChipTextInputComboView extends android.widget.FrameLayout implements android.widget.Checkable {
    private final com.google.android.material.chip.Chip chip;
    private final android.widget.EditText editText;
    private android.widget.TextView label;
    private final com.google.android.material.textfield.TextInputLayout textInputLayout;
    private android.text.TextWatcher watcher;

    public class TextFormatter extends com.google.android.material.internal.TextWatcherAdapter {
        private static final java.lang.String DEFAULT_TEXT = "00";

        private TextFormatter() {
        }

        public /* synthetic */ TextFormatter(com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView, com.google.android.material.timepicker.ChipTextInputComboView.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            if (android.text.TextUtils.isEmpty(editable)) {
                com.google.android.material.timepicker.ChipTextInputComboView.this.chip.setText(com.google.android.material.timepicker.ChipTextInputComboView.this.formatText("00"));
            } else {
                com.google.android.material.timepicker.ChipTextInputComboView.this.chip.setText(com.google.android.material.timepicker.ChipTextInputComboView.this.formatText(editable));
            }
        }
    }

    public ChipTextInputComboView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ChipTextInputComboView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.view.LayoutInflater from = android.view.LayoutInflater.from(context);
        com.google.android.material.chip.Chip chip = (com.google.android.material.chip.Chip) from.inflate(com.google.android.material.R.layout.material_time_chip, (android.view.ViewGroup) this, false);
        this.chip = chip;
        com.google.android.material.textfield.TextInputLayout textInputLayout = (com.google.android.material.textfield.TextInputLayout) from.inflate(com.google.android.material.R.layout.material_time_input, (android.view.ViewGroup) this, false);
        this.textInputLayout = textInputLayout;
        android.widget.EditText editText = textInputLayout.getEditText();
        this.editText = editText;
        editText.setVisibility(4);
        com.google.android.material.timepicker.ChipTextInputComboView.TextFormatter textFormatter = new com.google.android.material.timepicker.ChipTextInputComboView.TextFormatter(this, null);
        this.watcher = textFormatter;
        editText.addTextChangedListener(textFormatter);
        updateHintLocales();
        addView(chip);
        addView(textInputLayout);
        this.label = (android.widget.TextView) findViewById(com.google.android.material.R.id.material_label);
        editText.setSaveEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String formatText(java.lang.CharSequence charSequence) {
        return com.google.android.material.timepicker.TimeModel.formatText(getResources(), charSequence);
    }

    private void updateHintLocales() {
        android.os.LocaleList locales;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.editText.setImeHintLocales(locales);
        }
    }

    public void addInputFilter(android.text.InputFilter inputFilter) {
        android.text.InputFilter[] filters = this.editText.getFilters();
        android.text.InputFilter[] inputFilterArr = (android.text.InputFilter[]) java.util.Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.editText.setFilters(inputFilterArr);
    }

    public com.google.android.material.textfield.TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateHintLocales();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.chip.setChecked(z);
        this.editText.setVisibility(z ? 0 : 4);
        this.chip.setVisibility(z ? 8 : 0);
        if (isChecked()) {
            this.editText.requestFocus();
            if (android.text.TextUtils.isEmpty(this.editText.getText())) {
                return;
            }
            android.widget.EditText editText = this.editText;
            editText.setSelection(editText.getText().length());
        }
    }

    public void setChipDelegate(androidx.core.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this.chip, accessibilityDelegateCompat);
    }

    public void setCursorVisible(boolean z) {
        this.editText.setCursorVisible(z);
    }

    public void setHelperText(java.lang.CharSequence charSequence) {
        this.label.setText(charSequence);
    }

    @Override // android.view.View
    public void setOnClickListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
        this.chip.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i, java.lang.Object obj) {
        this.chip.setTag(i, obj);
    }

    public void setText(java.lang.CharSequence charSequence) {
        this.chip.setText(formatText(charSequence));
        if (android.text.TextUtils.isEmpty(this.editText.getText())) {
            return;
        }
        this.editText.removeTextChangedListener(this.watcher);
        this.editText.setText((java.lang.CharSequence) null);
        this.editText.addTextChangedListener(this.watcher);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.chip.toggle();
    }
}
