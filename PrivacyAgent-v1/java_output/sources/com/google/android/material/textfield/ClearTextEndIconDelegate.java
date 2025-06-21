package com.google.android.material.textfield;

/* loaded from: classes22.dex */
class ClearTextEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    private static final int ANIMATION_FADE_DURATION = 100;
    private static final int ANIMATION_SCALE_DURATION = 150;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private final android.text.TextWatcher clearTextEndIconTextWatcher;
    private final com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener;
    private final com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private android.animation.AnimatorSet iconInAnim;
    private android.animation.ValueAnimator iconOutAnim;
    private final android.view.View.OnFocusChangeListener onFocusChangeListener;

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$1, reason: invalid class name */
    public class AnonymousClass1 implements android.text.TextWatcher {
        public AnonymousClass1() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@androidx.annotation.NonNull android.text.Editable editable) {
            if (com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.getSuffixText() != null) {
                return;
            }
            com.google.android.material.textfield.ClearTextEndIconDelegate clearTextEndIconDelegate = com.google.android.material.textfield.ClearTextEndIconDelegate.this;
            clearTextEndIconDelegate.animateIcon(clearTextEndIconDelegate.textInputLayout.hasFocus() && com.google.android.material.textfield.ClearTextEndIconDelegate.hasText(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnFocusChangeListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(android.view.View view, boolean z) {
            com.google.android.material.textfield.ClearTextEndIconDelegate.this.animateIcon((android.text.TextUtils.isEmpty(((android.widget.EditText) view).getText()) ^ true) && z);
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$3, reason: invalid class name */
    public class AnonymousClass3 implements com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass3() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
            android.widget.EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && com.google.android.material.textfield.ClearTextEndIconDelegate.hasText(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(com.google.android.material.textfield.ClearTextEndIconDelegate.this.onFocusChangeListener);
            editText.removeTextChangedListener(com.google.android.material.textfield.ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            editText.addTextChangedListener(com.google.android.material.textfield.ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$4, reason: invalid class name */
    public class AnonymousClass4 implements com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener {

        /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.widget.EditText val$editText;

            public AnonymousClass1(android.widget.EditText editText) {
                this.val$editText = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$editText.removeTextChangedListener(com.google.android.material.textfield.ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout, int i) {
            android.widget.EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 2) {
                return;
            }
            editText.post(new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass4.AnonymousClass1(editText));
            if (editText.getOnFocusChangeListener() == com.google.android.material.textfield.ClearTextEndIconDelegate.this.onFocusChangeListener) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            android.text.Editable text = com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.refreshEndIconDrawableState();
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$6, reason: invalid class name */
    public class AnonymousClass6 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass6() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$7, reason: invalid class name */
    public class AnonymousClass7 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.material.textfield.ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$8, reason: invalid class name */
    public class AnonymousClass8 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass8() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            com.google.android.material.textfield.ClearTextEndIconDelegate.this.endIconView.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$9, reason: invalid class name */
    public class AnonymousClass9 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass9() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.google.android.material.textfield.ClearTextEndIconDelegate.this.endIconView.setScaleX(floatValue);
            com.google.android.material.textfield.ClearTextEndIconDelegate.this.endIconView.setScaleY(floatValue);
        }
    }

    public ClearTextEndIconDelegate(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.clearTextEndIconTextWatcher = new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass1();
        this.onFocusChangeListener = new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass2();
        this.clearTextOnEditTextAttachedListener = new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass3();
        this.endIconChangedListener = new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateIcon(boolean z) {
        boolean z2 = this.textInputLayout.isEndIconVisible() == z;
        if (z && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z2) {
                this.iconInAnim.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (z2) {
            this.iconOutAnim.end();
        }
    }

    private android.animation.ValueAnimator getAlphaAnimator(float... fArr) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass8());
        return ofFloat;
    }

    private android.animation.ValueAnimator getScaleAnimator() {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(ANIMATION_SCALE_FROM_VALUE, 1.0f);
        ofFloat.setInterpolator(com.google.android.material.animation.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass9());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasText(@androidx.annotation.NonNull android.text.Editable editable) {
        return editable.length() > 0;
    }

    private void initAnimators() {
        android.animation.ValueAnimator scaleAnimator = getScaleAnimator();
        android.animation.ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(scaleAnimator, alphaAnimator);
        this.iconInAnim.addListener(new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass6());
        android.animation.ValueAnimator alphaAnimator2 = getAlphaAnimator(1.0f, 0.0f);
        this.iconOutAnim = alphaAnimator2;
        alphaAnimator2.addListener(new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass7());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(this.context, com.google.android.material.R.drawable.mtrl_ic_cancel));
        com.google.android.material.textfield.TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(com.google.android.material.R.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass5());
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onSuffixVisibilityChanged(boolean z) {
        if (this.textInputLayout.getSuffixText() == null) {
            return;
        }
        animateIcon(z);
    }
}
