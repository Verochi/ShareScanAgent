package com.anythink.basead.ui.specialnote;

/* loaded from: classes12.dex */
public class ScreenSpecialNoteView extends com.anythink.basead.ui.specialnote.BaseSpecialNoteView {
    public ScreenSpecialNoteView(android.content.Context context) {
        super(context);
    }

    public ScreenSpecialNoteView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    public final void b() {
        setOrientation(0);
        setPadding(com.anythink.core.common.o.i.a(getContext(), 10.0f), 0, com.anythink.core.common.o.i.a(getContext(), 12.0f), 0);
        setGravity(16);
        setBackgroundResource(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_bg_shake_border_thumb", com.anythink.expressad.foundation.h.i.c));
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_special_note", "layout"), (android.view.ViewGroup) this, true);
        this.l = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_special_countdown_text", "id"));
        this.m = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_special_cancel_text", "id"));
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    public final void c() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(getMeasuredWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
        super.c();
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    public final boolean d() {
        return false;
    }
}
