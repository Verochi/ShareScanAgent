package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public class QuestionDialogG2CV2View extends com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View {
    private android.widget.TextView c;
    private android.widget.TextView d;
    private java.lang.String e;
    private java.lang.String f;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View.this.b;
            if (aVar != null) {
                aVar.a(11, 17);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View.this.b;
            if (aVar != null) {
                aVar.a(11, 17);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public QuestionDialogG2CV2View(android.content.Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void a(int i, int i2) {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_v2_question_dialog", "layout"), this);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_question_answer1", "id"));
        this.c = textView;
        textView.setOnClickListener(new com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View.AnonymousClass1());
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_question_answer2", "id"));
        this.d = textView2;
        textView2.setOnClickListener(new com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View.AnonymousClass2());
        if (!android.text.TextUtils.isEmpty(this.e)) {
            this.c.setText(this.e);
        }
        if (!android.text.TextUtils.isEmpty(this.f)) {
            this.d.setText(this.f);
        }
        setOnClickListener(new com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View.AnonymousClass3());
    }

    public void setQuestionAnswer(java.lang.String str, java.lang.String str2) {
        this.e = str;
        this.f = str2;
    }
}
