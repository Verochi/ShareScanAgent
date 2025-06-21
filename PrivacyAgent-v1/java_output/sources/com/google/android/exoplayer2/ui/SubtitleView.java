package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final class SubtitleView extends android.widget.FrameLayout implements com.google.android.exoplayer2.text.TextOutput {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int VIEW_TYPE_CANVAS = 1;
    public static final int VIEW_TYPE_WEB = 2;
    public com.google.android.exoplayer2.ui.SubtitleView.Output A;
    public android.view.View B;
    public java.util.List<com.google.android.exoplayer2.text.Cue> n;
    public com.google.android.exoplayer2.text.CaptionStyleCompat t;
    public int u;
    public float v;
    public float w;
    public boolean x;
    public boolean y;
    public int z;

    public interface Output {
        void update(java.util.List<com.google.android.exoplayer2.text.Cue> list, com.google.android.exoplayer2.text.CaptionStyleCompat captionStyleCompat, float f, int i, float f2);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ViewType {
    }

    public SubtitleView(android.content.Context context) {
        this(context, null);
    }

    public SubtitleView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = java.util.Collections.emptyList();
        this.t = com.google.android.exoplayer2.text.CaptionStyleCompat.DEFAULT;
        this.u = 0;
        this.v = 0.0533f;
        this.w = 0.08f;
        this.x = true;
        this.y = true;
        com.google.android.exoplayer2.ui.CanvasSubtitleOutput canvasSubtitleOutput = new com.google.android.exoplayer2.ui.CanvasSubtitleOutput(context, attributeSet);
        this.A = canvasSubtitleOutput;
        this.B = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.z = 1;
    }

    private java.util.List<com.google.android.exoplayer2.text.Cue> getCuesWithStylingPreferencesApplied() {
        if (this.x && this.y) {
            return this.n;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.n.size());
        for (int i = 0; i < this.n.size(); i++) {
            arrayList.add(a(this.n.get(i)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        android.view.accessibility.CaptioningManager captioningManager;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 19 || isInEditMode() || (captioningManager = (android.view.accessibility.CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private com.google.android.exoplayer2.text.CaptionStyleCompat getUserCaptionStyle() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 19 || isInEditMode()) {
            return com.google.android.exoplayer2.text.CaptionStyleCompat.DEFAULT;
        }
        android.view.accessibility.CaptioningManager captioningManager = (android.view.accessibility.CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? com.google.android.exoplayer2.text.CaptionStyleCompat.DEFAULT : com.google.android.exoplayer2.text.CaptionStyleCompat.createFromCaptionStyle(captioningManager.getUserStyle());
    }

    private <T extends android.view.View & com.google.android.exoplayer2.ui.SubtitleView.Output> void setView(T t) {
        removeView(this.B);
        android.view.View view = this.B;
        if (view instanceof com.google.android.exoplayer2.ui.WebViewSubtitleOutput) {
            ((com.google.android.exoplayer2.ui.WebViewSubtitleOutput) view).f();
        }
        this.B = t;
        this.A = t;
        addView(t);
    }

    public final com.google.android.exoplayer2.text.Cue a(com.google.android.exoplayer2.text.Cue cue) {
        java.lang.CharSequence charSequence = cue.text;
        if (!this.x) {
            com.google.android.exoplayer2.text.Cue.Builder clearWindowColor = cue.buildUpon().setTextSize(-3.4028235E38f, Integer.MIN_VALUE).clearWindowColor();
            if (charSequence != null) {
                clearWindowColor.setText(charSequence.toString());
            }
            return clearWindowColor.build();
        }
        if (this.y || charSequence == null) {
            return cue;
        }
        com.google.android.exoplayer2.text.Cue.Builder textSize = cue.buildUpon().setTextSize(-3.4028235E38f, Integer.MIN_VALUE);
        if (charSequence instanceof android.text.Spanned) {
            android.text.SpannableString valueOf = android.text.SpannableString.valueOf(charSequence);
            for (android.text.style.AbsoluteSizeSpan absoluteSizeSpan : (android.text.style.AbsoluteSizeSpan[]) valueOf.getSpans(0, valueOf.length(), android.text.style.AbsoluteSizeSpan.class)) {
                valueOf.removeSpan(absoluteSizeSpan);
            }
            for (android.text.style.RelativeSizeSpan relativeSizeSpan : (android.text.style.RelativeSizeSpan[]) valueOf.getSpans(0, valueOf.length(), android.text.style.RelativeSizeSpan.class)) {
                valueOf.removeSpan(relativeSizeSpan);
            }
            textSize.setText(valueOf);
        }
        return textSize.build();
    }

    public final void b(int i, float f) {
        this.u = i;
        this.v = f;
        c();
    }

    public final void c() {
        this.A.update(getCuesWithStylingPreferencesApplied(), this.t, this.v, this.u, this.w);
    }

    @Override // com.google.android.exoplayer2.text.TextOutput
    public void onCues(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        setCues(list);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.y = z;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.x = z;
        c();
    }

    public void setBottomPaddingFraction(float f) {
        this.w = f;
        c();
    }

    public void setCues(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        if (list == null) {
            list = java.util.Collections.emptyList();
        }
        this.n = list;
        c();
    }

    public void setFixedTextSize(@androidx.annotation.Dimension int i, float f) {
        android.content.Context context = getContext();
        b(2, android.util.TypedValue.applyDimension(i, f, (context == null ? android.content.res.Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public void setFractionalTextSize(float f, boolean z) {
        b(z ? 1 : 0, f);
    }

    public void setStyle(com.google.android.exoplayer2.text.CaptionStyleCompat captionStyleCompat) {
        this.t = captionStyleCompat;
        c();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i) {
        if (this.z == i) {
            return;
        }
        if (i == 1) {
            setView(new com.google.android.exoplayer2.ui.CanvasSubtitleOutput(getContext()));
        } else {
            if (i != 2) {
                throw new java.lang.IllegalArgumentException();
            }
            setView(new com.google.android.exoplayer2.ui.WebViewSubtitleOutput(getContext()));
        }
        this.z = i;
    }
}
