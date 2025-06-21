package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class MuteImageView extends android.widget.ImageView {
    private boolean a;

    public MuteImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
    }

    public void setMute(boolean z) {
        if (z) {
            setSelected(true);
        } else {
            setSelected(false);
        }
    }
}
