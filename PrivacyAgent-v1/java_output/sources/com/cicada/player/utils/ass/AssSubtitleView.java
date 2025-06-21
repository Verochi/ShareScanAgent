package com.cicada.player.utils.ass;

/* loaded from: classes22.dex */
public class AssSubtitleView extends android.widget.RelativeLayout {
    private com.cicada.player.utils.ass.AssResolver mAssResolver;
    private java.util.List<com.cicada.player.utils.ass.AssTextView> mAssSubtitleView;
    private int videoHeight;
    private int videoWidth;

    public AssSubtitleView(android.content.Context context) {
        super(context);
        this.mAssSubtitleView = new java.util.ArrayList();
        this.videoWidth = 0;
        this.videoHeight = 0;
        init(context);
    }

    public AssSubtitleView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAssSubtitleView = new java.util.ArrayList();
        this.videoWidth = 0;
        this.videoHeight = 0;
        init(context);
    }

    public AssSubtitleView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAssSubtitleView = new java.util.ArrayList();
        this.videoWidth = 0;
        this.videoHeight = 0;
        init(context);
    }

    private void init(android.content.Context context) {
        this.mAssResolver = new com.cicada.player.utils.ass.AssResolver(context);
    }

    public void destroy() {
        com.cicada.player.utils.ass.AssResolver assResolver = this.mAssResolver;
        if (assResolver != null) {
            assResolver.destroy();
        }
    }

    public synchronized void dismiss(long j) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.cicada.player.utils.ass.AssTextView assTextView : this.mAssSubtitleView) {
            if (assTextView.getSubtitleId().longValue() == j) {
                removeView(assTextView);
                this.mAssResolver.dismiss(assTextView);
                arrayList.add(assTextView);
            }
        }
        this.mAssSubtitleView.removeAll(arrayList);
    }

    public void setAssHeader(java.lang.String str) {
        this.mAssResolver.setAssHeaders(str);
    }

    public void setFontTypeFace(java.util.Map<java.lang.String, android.graphics.Typeface> map) {
        this.mAssResolver.setFontTypeMap(map);
    }

    public synchronized void setVideoRenderSize(int i, int i2) {
        if (this.videoWidth != i || this.videoHeight != i2) {
            this.videoWidth = i;
            this.videoHeight = i2;
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.videoWidth;
                layoutParams.height = this.videoHeight;
                setLayoutParams(layoutParams);
            }
            this.mAssResolver.setVideoDisplaySize(this.videoWidth, this.videoHeight);
            java.util.ArrayList<com.cicada.player.utils.ass.AssTextView> arrayList = new java.util.ArrayList();
            arrayList.addAll(this.mAssSubtitleView);
            for (com.cicada.player.utils.ass.AssTextView assTextView : arrayList) {
                long longValue = assTextView.getSubtitleId().longValue();
                java.lang.String content = assTextView.getContent();
                dismiss(longValue);
                show(longValue, content);
            }
        }
    }

    public synchronized void show(long j, java.lang.String str) {
        com.cicada.player.utils.ass.AssTextView assDialog = this.mAssResolver.setAssDialog(str);
        if (assDialog != null) {
            assDialog.setSubtitleId(java.lang.Long.valueOf(j));
            addView(assDialog);
            this.mAssSubtitleView.add(assDialog);
        }
        invalidate();
    }
}
