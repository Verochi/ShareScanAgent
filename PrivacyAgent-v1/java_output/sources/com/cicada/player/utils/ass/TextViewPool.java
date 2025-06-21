package com.cicada.player.utils.ass;

/* loaded from: classes22.dex */
public class TextViewPool {
    private android.content.Context mContext;
    private java.util.List<com.cicada.player.utils.ass.AssTextView> idelTextViewList = new java.util.ArrayList();
    private java.util.List<com.cicada.player.utils.ass.AssTextView> busyTextViewList = new java.util.ArrayList();

    public TextViewPool(android.content.Context context) {
        this.mContext = context;
    }

    public com.cicada.player.utils.ass.AssTextView obtain() {
        com.cicada.player.utils.ass.AssTextView assTextView;
        if (this.idelTextViewList.isEmpty()) {
            assTextView = new com.cicada.player.utils.ass.AssTextView(this.mContext);
        } else {
            assTextView = this.idelTextViewList.get(0);
            this.idelTextViewList.remove(assTextView);
        }
        this.busyTextViewList.add(assTextView);
        return assTextView;
    }

    public void recycle(com.cicada.player.utils.ass.AssTextView assTextView) {
        if (assTextView == null) {
            return;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) assTextView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(assTextView);
        }
        this.busyTextViewList.remove(assTextView);
        this.idelTextViewList.add(assTextView);
    }
}
