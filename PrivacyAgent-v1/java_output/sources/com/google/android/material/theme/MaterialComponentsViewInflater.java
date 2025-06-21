package com.google.android.material.theme;

/* loaded from: classes22.dex */
public class MaterialComponentsViewInflater extends androidx.appcompat.app.AppCompatViewInflater {
    @Override // androidx.appcompat.app.AppCompatViewInflater
    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatAutoCompleteTextView createAutoCompleteTextView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        return new com.google.android.material.textfield.MaterialAutoCompleteTextView(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatButton createButton(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        return new com.google.android.material.button.MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatCheckBox createCheckBox(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new com.google.android.material.checkbox.MaterialCheckBox(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatRadioButton createRadioButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new com.google.android.material.radiobutton.MaterialRadioButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    @androidx.annotation.NonNull
    public androidx.appcompat.widget.AppCompatTextView createTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new com.google.android.material.textview.MaterialTextView(context, attributeSet);
    }
}
