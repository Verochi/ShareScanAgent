package com.cicada.player.utils.ass;

/* loaded from: classes22.dex */
public class AssTextView extends android.widget.TextView {
    private java.lang.String mContent;
    private java.lang.Long mId;

    public AssTextView(android.content.Context context) {
        super(context);
        this.mContent = null;
        this.mId = null;
    }

    public AssTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContent = null;
        this.mId = null;
    }

    public AssTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContent = null;
        this.mId = null;
    }

    public java.lang.String getContent() {
        return this.mContent;
    }

    public java.lang.Long getSubtitleId() {
        return this.mId;
    }

    public void setContent(java.lang.String str) {
        this.mContent = str;
    }

    public void setSubtitleId(java.lang.Long l) {
        this.mId = l;
    }
}
