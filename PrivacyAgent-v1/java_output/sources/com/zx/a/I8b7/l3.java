package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class l3 extends android.app.Dialog {
    public android.view.View.OnClickListener a;
    public android.view.View.OnClickListener b;
    public android.view.View.OnClickListener c;

    public l3(android.content.Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        android.content.Context context = getContext();
        getWindow().setGravity(80);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        linearLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, com.zx.a.I8b7.s.a(context, 30.0f), 0, 0);
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(android.graphics.Color.parseColor("#FFFFFFFF"));
        gradientDrawable.setCornerRadius(com.zx.a.I8b7.s.a(context, 8.0f));
        linearLayout.setBackground(gradientDrawable);
        android.widget.LinearLayout linearLayout2 = new android.widget.LinearLayout(context);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(com.zx.a.I8b7.s.a(context, 16.0f), 0, com.zx.a.I8b7.s.a(context, 16.0f), 0);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        textView.setGravity(1);
        textView.setTextColor(android.graphics.Color.parseColor("#FF111111"));
        textView.setTextSize(2, 18.0f);
        textView.setText("是否允许\"" + com.zx.a.I8b7.w3.a(context) + "\"获取此设备的反欺诈匿名可变ID?");
        android.widget.TextView textView2 = new android.widget.TextView(context);
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        textView2.setLayoutParams(layoutParams2);
        int a = com.zx.a.I8b7.s.a(context, 12.0f);
        textView2.setPadding(a, a, a, a);
        textView2.setTextColor(android.graphics.Color.parseColor("#FF111111"));
        textView2.setTextSize(2, 18.0f);
        textView2.setText("了解更多");
        linearLayout2.addView(textView);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        android.widget.TextView textView3 = new android.widget.TextView(context);
        android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        textView3.setLayoutParams(layoutParams3);
        layoutParams3.gravity = 1;
        textView3.setTextColor(android.graphics.Color.parseColor("#FF111111"));
        textView3.setTextSize(2, 18.0f);
        int a2 = com.zx.a.I8b7.s.a(context, 10.0f);
        textView3.setPadding(a2, a2, a2, a2);
        textView3.setText("允许");
        android.widget.TextView textView4 = new android.widget.TextView(context);
        android.widget.LinearLayout.LayoutParams layoutParams4 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        textView4.setLayoutParams(layoutParams4);
        layoutParams4.gravity = 1;
        int a3 = com.zx.a.I8b7.s.a(context, 12.0f);
        layoutParams4.setMargins(0, a3, 0, a3);
        textView4.setTextColor(android.graphics.Color.parseColor("#FF111111"));
        textView4.setTextSize(2, 18.0f);
        int a4 = com.zx.a.I8b7.s.a(context, 10.0f);
        textView4.setPadding(a4, a4, a4, a4);
        textView4.setText("拒绝");
        linearLayout.addView(textView3);
        linearLayout.addView(textView4);
        setContentView(linearLayout);
        textView4.setOnClickListener(this.a);
        textView3.setOnClickListener(this.b);
        textView2.setOnClickListener(this.c);
        setCancelable(false);
    }
}
