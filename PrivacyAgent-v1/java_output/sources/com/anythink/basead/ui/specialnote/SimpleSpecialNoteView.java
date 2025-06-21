package com.anythink.basead.ui.specialnote;

/* loaded from: classes12.dex */
public class SimpleSpecialNoteView extends com.anythink.basead.ui.specialnote.BaseSpecialNoteView {
    public SimpleSpecialNoteView(android.content.Context context) {
        super(context);
    }

    public SimpleSpecialNoteView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    public final void a() {
        this.n = getContext().getString(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_special_note_delay_click_simple", com.anythink.expressad.foundation.h.i.g));
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    public final void b() {
        setOrientation(0);
        int a = com.anythink.core.common.o.i.a(getContext(), 5.0f);
        setPadding(a, 0, a, 0);
        setGravity(16);
        setBackgroundColor(android.graphics.Color.parseColor("#80000000"));
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_special_note_simple", "layout"), (android.view.ViewGroup) this, true);
        this.l = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_special_countdown_text", "id"));
        this.m = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_special_cancel_text", "id"));
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    public final void c() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, getMeasuredHeight(), 0.0f);
        translateAnimation.setDuration(500L);
        startAnimation(translateAnimation);
        super.c();
    }

    @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView
    public final boolean d() {
        return true;
    }
}
