package com.google.android.material.textfield;

/* loaded from: classes22.dex */
class NoEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    public NoEndIconDelegate(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconDrawable((android.graphics.drawable.Drawable) null);
        this.textInputLayout.setEndIconContentDescription((java.lang.CharSequence) null);
    }
}
