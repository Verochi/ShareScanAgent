package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class CloseHeaderView extends android.widget.RelativeLayout {
    private android.view.ViewGroup a;
    private com.anythink.basead.ui.CloseImageView b;
    private android.widget.TextView c;
    private java.lang.String d;
    private java.lang.String e;
    private long f;
    private long g;

    public CloseHeaderView(android.content.Context context) {
        super(context);
        this.d = "";
        this.e = "";
        a();
    }

    public CloseHeaderView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = "";
        this.e = "";
        a();
    }

    public CloseHeaderView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = "";
        this.e = "";
        a();
    }

    private void a() {
        setBackgroundColor(android.graphics.Color.parseColor("#66000000"));
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_close_header_view", "layout"), this);
        this.a = (android.view.ViewGroup) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_feedback_ll_nobg_id", "id"));
        this.b = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_btn_close_ch_id", "id"));
        this.c = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_tv_countdown_text", "id"));
        this.d = getContext().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_count_down_to_rewarded", com.anythink.expressad.foundation.h.i.g));
        this.e = getContext().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_count_down_finish_rewarded", com.anythink.expressad.foundation.h.i.g));
    }

    public com.anythink.basead.ui.CloseImageView getCloseImageView() {
        return this.b;
    }

    public android.view.ViewGroup getFeedbackButton() {
        return this.a;
    }

    public void refresh(long j) {
        this.g = j;
        if (j >= this.f) {
            this.c.setText(this.e);
            this.c.setTextColor(-1);
        } else {
            this.c.setText(android.text.Html.fromHtml(java.lang.String.format(this.d, java.lang.Integer.valueOf((int) java.lang.Math.ceil((r0 - j) / 1000.0d)))));
        }
    }

    public void setDuration(long j) {
        this.f = j;
    }
}
