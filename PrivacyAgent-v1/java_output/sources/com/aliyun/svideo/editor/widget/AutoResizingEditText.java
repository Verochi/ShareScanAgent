package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class AutoResizingEditText extends com.aliyun.svideo.editor.widget.AutoResizingTextView {
    public AutoResizingEditText(android.content.Context context) {
        this(context, null);
    }

    public AutoResizingEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizingEditText(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(1, getPaint());
    }

    public void extendSelection(int i) {
        android.text.Selection.extendSelection(getText(), i);
    }

    @Override // android.widget.TextView, android.view.View
    public java.lang.CharSequence getAccessibilityClassName() {
        return android.widget.EditText.class.getName();
    }

    @Override // android.widget.TextView
    public boolean getDefaultEditable() {
        return true;
    }

    @Override // android.widget.TextView
    public android.text.method.MovementMethod getDefaultMovementMethod() {
        return android.text.method.ArrowKeyMovementMethod.getInstance();
    }

    @Override // android.widget.TextView
    public android.text.Editable getText() {
        return (android.text.Editable) super.getText();
    }

    public void selectAll() {
        android.text.Selection.selectAll(getText());
    }

    @Override // android.widget.TextView
    public void setEllipsize(android.text.TextUtils.TruncateAt truncateAt) {
        if (truncateAt == android.text.TextUtils.TruncateAt.MARQUEE) {
            throw new java.lang.IllegalArgumentException("EditText cannot use the ellipsize mode TextUtils.TruncateAt.MARQUEE");
        }
        super.setEllipsize(truncateAt);
    }

    public void setSelection(int i) {
        android.text.Selection.setSelection(getText(), i);
    }

    public void setSelection(int i, int i2) {
        android.text.Selection.setSelection(getText(), i, i2);
    }

    @Override // com.aliyun.svideo.editor.widget.AutoResizingTextView, android.widget.TextView
    public void setText(java.lang.CharSequence charSequence, android.widget.TextView.BufferType bufferType) {
        super.setText(charSequence, android.widget.TextView.BufferType.EDITABLE);
    }
}
