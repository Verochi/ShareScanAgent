package com.google.android.material.textfield;

/* loaded from: classes22.dex */
class PasswordToggleEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    private final com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    private final com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener onEndIconChangedListener;
    private final android.text.TextWatcher textWatcher;

    /* renamed from: com.google.android.material.textfield.PasswordToggleEndIconDelegate$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.material.internal.TextWatcherAdapter {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.endIconView.setChecked(!r1.hasPasswordTransformation());
        }
    }

    /* renamed from: com.google.android.material.textfield.PasswordToggleEndIconDelegate$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
            android.widget.EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.endIconView.setChecked(!r4.hasPasswordTransformation());
            editText.removeTextChangedListener(com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.textWatcher);
            editText.addTextChangedListener(com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.textWatcher);
        }
    }

    /* renamed from: com.google.android.material.textfield.PasswordToggleEndIconDelegate$3, reason: invalid class name */
    public class AnonymousClass3 implements com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener {

        /* renamed from: com.google.android.material.textfield.PasswordToggleEndIconDelegate$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.widget.EditText val$editText;

            public AnonymousClass1(android.widget.EditText editText) {
                this.val$editText = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$editText.removeTextChangedListener(com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.textWatcher);
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout, int i) {
            android.widget.EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
            editText.post(new com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass3.AnonymousClass1(editText));
        }
    }

    /* renamed from: com.google.android.material.textfield.PasswordToggleEndIconDelegate$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            android.widget.EditText editText = com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.textInputLayout.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.hasPasswordTransformation()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            com.google.android.material.textfield.PasswordToggleEndIconDelegate.this.textInputLayout.refreshEndIconDrawableState();
        }
    }

    public PasswordToggleEndIconDelegate(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.textWatcher = new com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass1();
        this.onEditTextAttachedListener = new com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass2();
        this.onEndIconChangedListener = new com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPasswordTransformation() {
        android.widget.EditText editText = this.textInputLayout.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod);
    }

    private static boolean isInputTypePassword(android.widget.EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(this.context, com.google.android.material.R.drawable.design_password_eye));
        com.google.android.material.textfield.TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(com.google.android.material.R.string.password_toggle_content_description));
        this.textInputLayout.setEndIconOnClickListener(new com.google.android.material.textfield.PasswordToggleEndIconDelegate.AnonymousClass4());
        this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
        android.widget.EditText editText = this.textInputLayout.getEditText();
        if (isInputTypePassword(editText)) {
            editText.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
        }
    }
}
