package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
final class CanvasSubtitleOutput extends android.view.View implements com.google.android.exoplayer2.ui.SubtitleView.Output {
    public final java.util.List<com.google.android.exoplayer2.ui.SubtitlePainter> n;
    public java.util.List<com.google.android.exoplayer2.text.Cue> t;
    public int u;
    public float v;
    public com.google.android.exoplayer2.text.CaptionStyleCompat w;
    public float x;

    public CanvasSubtitleOutput(android.content.Context context) {
        this(context, null);
    }

    public CanvasSubtitleOutput(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new java.util.ArrayList();
        this.t = java.util.Collections.emptyList();
        this.u = 0;
        this.v = 0.0533f;
        this.w = com.google.android.exoplayer2.text.CaptionStyleCompat.DEFAULT;
        this.x = 0.08f;
    }

    public static com.google.android.exoplayer2.text.Cue a(com.google.android.exoplayer2.text.Cue cue) {
        com.google.android.exoplayer2.text.Cue.Builder textAlignment = cue.buildUpon().setPosition(-3.4028235E38f).setPositionAnchor(Integer.MIN_VALUE).setTextAlignment(null);
        if (cue.lineType == 0) {
            textAlignment.setLine(1.0f - cue.line, 0);
        } else {
            textAlignment.setLine((-cue.line) - 1.0f, 1);
        }
        int i = cue.lineAnchor;
        if (i == 0) {
            textAlignment.setLineAnchor(2);
        } else if (i == 2) {
            textAlignment.setLineAnchor(0);
        }
        return textAlignment.build();
    }

    @Override // android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        java.util.List<com.google.android.exoplayer2.text.Cue> list = this.t;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i = paddingBottom - paddingTop;
        float a = com.google.android.exoplayer2.ui.SubtitleViewUtils.a(this.u, this.v, height, i);
        if (a <= 0.0f) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            com.google.android.exoplayer2.text.Cue cue = list.get(i2);
            if (cue.verticalType != Integer.MIN_VALUE) {
                cue = a(cue);
            }
            com.google.android.exoplayer2.text.Cue cue2 = cue;
            int i3 = paddingBottom;
            this.n.get(i2).b(cue2, this.w, a, com.google.android.exoplayer2.ui.SubtitleViewUtils.a(cue2.textSizeType, cue2.textSize, height, i), this.x, canvas, paddingLeft, paddingTop, width, i3);
            i2++;
            size = size;
            i = i;
            paddingBottom = i3;
            width = width;
        }
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void update(java.util.List<com.google.android.exoplayer2.text.Cue> list, com.google.android.exoplayer2.text.CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.t = list;
        this.w = captionStyleCompat;
        this.v = f;
        this.u = i;
        this.x = f2;
        while (this.n.size() < list.size()) {
            this.n.add(new com.google.android.exoplayer2.ui.SubtitlePainter(getContext()));
        }
        invalidate();
    }
}
