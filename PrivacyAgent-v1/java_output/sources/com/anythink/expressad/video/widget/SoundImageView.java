package com.anythink.expressad.video.widget;

/* loaded from: classes12.dex */
public class SoundImageView extends android.widget.ImageView {
    private boolean a;

    public SoundImageView(android.content.Context context) {
        super(context);
        this.a = true;
    }

    public SoundImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }

    public SoundImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
    }

    public boolean getStatus() {
        return this.a;
    }

    public void setSoundStatus(boolean z) {
        this.a = z;
        if (z) {
            setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_reward_sound_open", com.anythink.expressad.foundation.h.i.c));
        } else {
            setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_reward_sound_close", com.anythink.expressad.foundation.h.i.c));
        }
    }
}
