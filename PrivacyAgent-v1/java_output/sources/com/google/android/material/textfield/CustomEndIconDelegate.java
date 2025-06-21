package com.google.android.material.textfield;

/* loaded from: classes22.dex */
class CustomEndIconDelegate extends com.google.android.material.textfield.EndIconDelegate {
    public CustomEndIconDelegate(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconOnLongClickListener(null);
    }
}
