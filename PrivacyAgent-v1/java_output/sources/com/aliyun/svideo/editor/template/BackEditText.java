package com.aliyun.svideo.editor.template;

/* loaded from: classes12.dex */
public class BackEditText extends androidx.appcompat.widget.AppCompatEditText {
    private com.aliyun.svideo.editor.template.BackEditText.OnKeyBoardHideListener onKeyBoardHideListener;

    public interface OnKeyBoardHideListener {
        void onKeyHide();
    }

    public BackEditText(android.content.Context context) {
        super(context);
    }

    public BackEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BackEditText(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, android.view.KeyEvent keyEvent) {
        com.aliyun.svideo.editor.template.BackEditText.OnKeyBoardHideListener onKeyBoardHideListener;
        if (i == 4 && keyEvent.getAction() == 1 && (onKeyBoardHideListener = this.onKeyBoardHideListener) != null) {
            onKeyBoardHideListener.onKeyHide();
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setOnKeyBoardHideListener(com.aliyun.svideo.editor.template.BackEditText.OnKeyBoardHideListener onKeyBoardHideListener) {
        this.onKeyBoardHideListener = onKeyBoardHideListener;
    }
}
