package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class TitleTextView extends android.widget.TextView {
    public TitleTextView(android.content.Context context) {
        super(context);
        tanxc_do();
    }

    public TitleTextView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        tanxc_do();
    }

    private void tanxc_do() {
        setPadding(24, 24, 24, 24);
        setMaxLines(2);
        setEllipsize(android.text.TextUtils.TruncateAt.valueOf("END"));
    }
}
