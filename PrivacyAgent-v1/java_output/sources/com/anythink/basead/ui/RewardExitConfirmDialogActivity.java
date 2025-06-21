package com.anythink.basead.ui;

/* loaded from: classes29.dex */
public class RewardExitConfirmDialogActivity extends android.app.Activity {
    public static final int a = 1;
    public static final int b = 2;
    private static java.lang.Runnable c = null;
    private static java.lang.String d = null;
    private static int e = 1;
    private android.app.Dialog f;

    /* renamed from: com.anythink.basead.ui.RewardExitConfirmDialogActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.RewardExitConfirmDialogActivity.this.finish();
            if (com.anythink.basead.ui.RewardExitConfirmDialogActivity.c != null) {
                com.anythink.basead.ui.RewardExitConfirmDialogActivity.c.run();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.RewardExitConfirmDialogActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.RewardExitConfirmDialogActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.Runnable runnable, int i) {
        d = str;
        c = runnable;
        e = i;
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.anythink.basead.ui.RewardExitConfirmDialogActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void b() {
        try {
            android.view.View inflate = android.view.LayoutInflater.from(this).inflate(com.anythink.core.common.o.i.a(this, "myoffer_confirm_dialog", "layout"), (android.view.ViewGroup) null, false);
            android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_msg", "id"));
            android.widget.TextView textView2 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_give_up", "id"));
            android.widget.TextView textView3 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_continue", "id"));
            textView2.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_reward_exit_confirm_give_up", com.anythink.expressad.foundation.h.i.g)));
            if (e != 2) {
                textView.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_reward_exit_confirm_msg", com.anythink.expressad.foundation.h.i.g), d));
                textView3.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_reward_exit_confirm_continue", com.anythink.expressad.foundation.h.i.g)));
            } else {
                textView.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_anim_reward_exit_confirm_msg", com.anythink.expressad.foundation.h.i.g), d));
                textView3.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_anim_reward_exit_confirm_continue", com.anythink.expressad.foundation.h.i.g)));
            }
            textView2.setOnClickListener(new com.anythink.basead.ui.RewardExitConfirmDialogActivity.AnonymousClass1());
            textView3.setOnClickListener(new com.anythink.basead.ui.RewardExitConfirmDialogActivity.AnonymousClass2());
            android.app.Dialog dialog = new android.app.Dialog(this, com.anythink.core.common.o.i.a(this, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.e));
            this.f = dialog;
            dialog.setContentView(inflate);
            this.f.setCancelable(false);
            this.f.show();
        } catch (java.lang.Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            android.view.View inflate = android.view.LayoutInflater.from(this).inflate(com.anythink.core.common.o.i.a(this, "myoffer_confirm_dialog", "layout"), (android.view.ViewGroup) null, false);
            android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_msg", "id"));
            android.widget.TextView textView2 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_give_up", "id"));
            android.widget.TextView textView3 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_continue", "id"));
            textView2.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_reward_exit_confirm_give_up", com.anythink.expressad.foundation.h.i.g)));
            if (e != 2) {
                textView.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_reward_exit_confirm_msg", com.anythink.expressad.foundation.h.i.g), d));
                textView3.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_reward_exit_confirm_continue", com.anythink.expressad.foundation.h.i.g)));
            } else {
                textView.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_anim_reward_exit_confirm_msg", com.anythink.expressad.foundation.h.i.g), d));
                textView3.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "myoffer_anim_reward_exit_confirm_continue", com.anythink.expressad.foundation.h.i.g)));
            }
            textView2.setOnClickListener(new com.anythink.basead.ui.RewardExitConfirmDialogActivity.AnonymousClass1());
            textView3.setOnClickListener(new com.anythink.basead.ui.RewardExitConfirmDialogActivity.AnonymousClass2());
            android.app.Dialog dialog = new android.app.Dialog(this, com.anythink.core.common.o.i.a(this, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.e));
            this.f = dialog;
            dialog.setContentView(inflate);
            this.f.setCancelable(false);
            this.f.show();
        } catch (java.lang.Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        android.app.Dialog dialog = this.f;
        if (dialog != null) {
            dialog.dismiss();
            this.f = null;
        }
        c = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
