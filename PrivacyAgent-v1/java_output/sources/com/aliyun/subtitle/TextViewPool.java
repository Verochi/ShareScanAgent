package com.aliyun.subtitle;

/* loaded from: classes.dex */
public class TextViewPool {
    private android.content.Context mContext;
    private java.util.List<android.widget.TextView> idelTextViewList = new java.util.ArrayList();
    private java.util.List<android.widget.TextView> busyTextViewList = new java.util.ArrayList();

    public TextViewPool(android.content.Context context) {
        this.mContext = context;
    }

    public android.widget.TextView obtain() {
        android.widget.TextView textView = this.idelTextViewList.isEmpty() ? new android.widget.TextView(this.mContext) : this.idelTextViewList.get(0);
        this.busyTextViewList.add(textView);
        return textView;
    }

    public void recycle(android.widget.TextView textView) {
        if (textView == null) {
            return;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) textView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(textView);
        }
        this.busyTextViewList.remove(textView);
        this.idelTextViewList.add(textView);
    }
}
