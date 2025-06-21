package com.anythink.expressad.video.dynview.j;

/* loaded from: classes12.dex */
public final class b {
    private java.lang.String a = "anythink_top_play_bg";
    private java.lang.String b = "anythink_top_finger_bg";
    private java.lang.String c = "anythink_bottom_play_bg";
    private java.lang.String d = "anythink_bottom_finger_bg";
    private java.lang.String e = "anythink_tv_count";
    private java.lang.String f = "anythink_sound_switch";
    private java.lang.String g = "anythink_top_control";
    private java.lang.String h = "anythink_tv_title";
    private java.lang.String i = "anythink_tv_desc";
    private java.lang.String j = "anythink_tv_install";
    private java.lang.String k = "anythink_sv_starlevel";
    private java.lang.String l = "anythink_sv_heat_count_level";
    private java.lang.String m = "anythink_tv_cta";
    private java.lang.String n = "anythink_native_ec_controller";
    private java.lang.String o = "anythink_reward_shape_choice_rl";
    private java.lang.String p = "#FFFFFF";
    private java.lang.String q = "#FF000000";
    private java.lang.String r = "#40000000";

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f268s = "#CAEF79";
    private java.lang.String t = "#2196F3";
    private java.lang.String u = "#402196F3";
    private java.lang.String v = "#8FC31F";
    private java.lang.String w = "#03A9F4";
    private boolean x = false;

    private static int a(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), str, "id");
    }

    private static void a() {
    }

    private void a(android.content.Context context, android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        com.anythink.expressad.video.widget.SoundImageView soundImageView = (com.anythink.expressad.video.widget.SoundImageView) view.findViewById(a(this.f));
        int b = com.anythink.expressad.foundation.h.t.b(context, 60.0f);
        int b2 = com.anythink.expressad.foundation.h.t.b(context, 10.0f);
        if (soundImageView != null) {
            cVar.e();
            ((android.widget.FrameLayout.LayoutParams) soundImageView.getLayoutParams()).setMargins(b2, 0, 0, b);
        }
    }

    private static int b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private void b(android.view.View view) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view.findViewById(a(this.g));
        if (relativeLayout != null) {
            if (com.anythink.expressad.video.dynview.a.b.a == 0 && com.anythink.expressad.video.dynview.a.b.b == 0 && com.anythink.expressad.video.dynview.a.b.c == 0 && com.anythink.expressad.video.dynview.a.b.d == 0) {
                return;
            }
            relativeLayout.setVisibility(4);
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 100.0f);
            alphaAnimation.setDuration(200L);
            relativeLayout.startAnimation(alphaAnimation);
            relativeLayout.setVisibility(0);
        }
    }

    private void d(android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view.findViewById(a(this.n));
        if (relativeLayout != null) {
            if (cVar.e() == 1) {
                android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(layoutParams.leftMargin + com.anythink.expressad.video.dynview.a.b.a, layoutParams.topMargin + com.anythink.expressad.video.dynview.a.b.c, layoutParams.rightMargin + com.anythink.expressad.video.dynview.a.b.b, layoutParams.bottomMargin + com.anythink.expressad.video.dynview.a.b.d);
                relativeLayout.setLayoutParams(layoutParams);
                return;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.setMargins(layoutParams2.leftMargin + com.anythink.expressad.video.dynview.a.b.a, layoutParams2.topMargin + com.anythink.expressad.video.dynview.a.b.c, layoutParams2.rightMargin + com.anythink.expressad.video.dynview.a.b.b, layoutParams2.bottomMargin + com.anythink.expressad.video.dynview.a.b.d);
            relativeLayout.setLayoutParams(layoutParams2);
        }
    }

    public final void a(android.view.View view) {
        android.animation.ObjectAnimator objectAnimator;
        android.animation.ObjectAnimator objectAnimator2;
        android.animation.ObjectAnimator objectAnimator3;
        if (view == null || !(view instanceof com.anythink.expressad.video.dynview.widget.ATFramLayout)) {
            return;
        }
        com.anythink.expressad.video.dynview.widget.ATFramLayout aTFramLayout = (com.anythink.expressad.video.dynview.widget.ATFramLayout) view;
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        if (view.getContext() != null) {
            this.x = false;
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(a(this.a));
            android.widget.ImageView imageView2 = (android.widget.ImageView) view.findViewById(a(this.b));
            android.widget.ImageView imageView3 = (android.widget.ImageView) view.findViewById(a(this.c));
            android.widget.ImageView imageView4 = (android.widget.ImageView) view.findViewById(a(this.d));
            android.animation.ObjectAnimator objectAnimator4 = null;
            if (imageView != null) {
                new com.anythink.expressad.video.dynview.h.b();
                objectAnimator = com.anythink.expressad.video.dynview.h.b.a(imageView);
            } else {
                objectAnimator = null;
            }
            if (imageView2 != null) {
                new com.anythink.expressad.video.dynview.h.b();
                objectAnimator2 = com.anythink.expressad.video.dynview.h.b.b(imageView2);
            } else {
                objectAnimator2 = null;
            }
            if (imageView3 != null) {
                new com.anythink.expressad.video.dynview.h.b();
                objectAnimator3 = com.anythink.expressad.video.dynview.h.b.a(imageView3);
            } else {
                objectAnimator3 = null;
            }
            if (imageView4 != null) {
                new com.anythink.expressad.video.dynview.h.b();
                objectAnimator4 = com.anythink.expressad.video.dynview.h.b.b(imageView4);
            }
            if (objectAnimator == null || objectAnimator3 == null || objectAnimator2 == null || objectAnimator4 == null) {
                return;
            }
            animatorSet.playTogether(objectAnimator, objectAnimator3, objectAnimator2, objectAnimator4);
            aTFramLayout.setAnimatorSet(animatorSet);
        }
    }

    public final void a(android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        java.lang.String str;
        java.lang.String str2;
        float f;
        android.content.Context context = view != null ? view.getContext() : null;
        if (context == null || cVar == null) {
            return;
        }
        this.x = false;
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(a(this.e));
        android.widget.TextView textView2 = (android.widget.TextView) view.findViewById(a("anythink_reward_click_tv"));
        if (textView != null) {
            textView.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(context, "anythink_reward_shape_progress", com.anythink.expressad.foundation.h.i.c));
            textView.setTextColor(android.graphics.Color.parseColor(this.p));
            textView.setTextSize(11.0f);
        }
        if (textView2 != null) {
            textView2.setTextSize(20.0f);
            if (textView2 instanceof com.anythink.expressad.video.dynview.widget.ATTextView) {
                new com.anythink.expressad.video.dynview.h.b();
                ((com.anythink.expressad.video.dynview.widget.ATTextView) textView2).setObjectAnimator(com.anythink.expressad.video.dynview.h.b.c(textView2));
            }
        }
        java.lang.String str3 = this.q;
        java.lang.String str4 = this.f268s;
        int i = cVar.i();
        float f2 = 1.0f;
        if (i == 302) {
            str = this.t;
            str2 = this.w;
            str3 = this.p;
            str4 = this.u;
            f = 10.0f;
        } else if (i != 802) {
            str = this.v;
            str2 = this.f268s;
            f = 5.0f;
        } else {
            str = this.p;
            str3 = this.q;
            str4 = this.r;
            str2 = str;
            f2 = 0.5f;
            f = 25.0f;
        }
        if (textView2 != null) {
            textView2.setTextColor(android.graphics.Color.parseColor(str3));
            com.anythink.expressad.video.dynview.i.b.a.a(textView2, f2, f, str4, new java.lang.String[]{str, str2}, android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT);
        }
        if (cVar.f() != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) cVar.f().getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            cVar.f().setLayoutParams(layoutParams);
        }
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view.findViewById(a(this.g));
        if (relativeLayout != null) {
            if (com.anythink.expressad.video.dynview.a.b.a == 0 && com.anythink.expressad.video.dynview.a.b.b == 0 && com.anythink.expressad.video.dynview.a.b.c == 0 && com.anythink.expressad.video.dynview.a.b.d == 0) {
                return;
            }
            relativeLayout.setVisibility(4);
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 100.0f);
            alphaAnimation.setDuration(200L);
            relativeLayout.startAnimation(alphaAnimation);
            relativeLayout.setVisibility(0);
        }
    }

    public final void b(android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        android.content.Context context;
        int b;
        if (view == null || cVar == null || (context = view.getContext()) == null) {
            return;
        }
        if (cVar.e() == 1) {
            view.setBackgroundDrawable(context.getResources().getDrawable(com.anythink.expressad.foundation.h.i.a(context, this.o, com.anythink.expressad.foundation.h.i.c)));
            android.widget.TextView textView = (android.widget.TextView) view.findViewById(a(this.h));
            if (textView != null) {
                textView.setTextColor(android.graphics.Color.parseColor(this.q));
            }
            android.widget.TextView textView2 = (android.widget.TextView) view.findViewById(a(this.i));
            if (textView2 != null) {
                textView2.setTextColor(android.graphics.Color.parseColor(this.q));
            }
            b = com.anythink.expressad.foundation.h.t.b(context, 2.0f);
        } else {
            b = com.anythink.expressad.foundation.h.t.b(context, 10.0f);
            view.getBackground().setAlpha(100);
        }
        int b2 = com.anythink.expressad.foundation.h.t.b(context, 8.0f);
        android.view.View findViewById = view.findViewById(a(this.j));
        if (findViewById != null) {
            if (cVar.f() != null && (cVar.f() instanceof com.anythink.expressad.video.module.AnythinkClickCTAView)) {
                new com.anythink.expressad.video.dynview.h.b();
                ((com.anythink.expressad.video.module.AnythinkClickCTAView) cVar.f()).setObjectAnimator(com.anythink.expressad.video.dynview.h.b.c(findViewById));
            }
            if (findViewById instanceof android.widget.TextView) {
                android.widget.TextView textView3 = (android.widget.TextView) findViewById;
                textView3.setTextColor(android.graphics.Color.parseColor(this.p));
                textView3.setTextSize(15.0f);
                java.lang.String str = this.f268s;
                com.anythink.expressad.video.dynview.i.b.a.a(textView3, 1.0f, 5.0f, str, new java.lang.String[]{this.v, str}, android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT);
            }
        }
        if (view.getLayoutParams() == null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(b, b, b, b2);
            layoutParams.height = com.anythink.expressad.foundation.h.t.b(context, 60.0f);
            view.setLayoutParams(layoutParams);
        }
    }

    public final void c(android.view.View view, com.anythink.expressad.video.dynview.c cVar) {
        if (view == null || cVar == null) {
            return;
        }
        if (view.getContext() != null) {
            this.x = false;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view.findViewById(a(this.k));
            android.view.View findViewById = view.findViewById(a(this.m));
            if (linearLayout != null && (linearLayout instanceof com.anythink.expressad.video.dynview.widget.ATLevelLayoutView)) {
                if (cVar.e() == 1) {
                    linearLayout.setOrientation(1);
                } else {
                    linearLayout.setOrientation(0);
                }
            }
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view.findViewById(a(this.n));
            if (relativeLayout != null) {
                if (cVar.e() == 1) {
                    android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                    layoutParams.setMargins(layoutParams.leftMargin + com.anythink.expressad.video.dynview.a.b.a, layoutParams.topMargin + com.anythink.expressad.video.dynview.a.b.c, layoutParams.rightMargin + com.anythink.expressad.video.dynview.a.b.b, layoutParams.bottomMargin + com.anythink.expressad.video.dynview.a.b.d);
                    relativeLayout.setLayoutParams(layoutParams);
                } else {
                    android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    layoutParams2.setMargins(layoutParams2.leftMargin + com.anythink.expressad.video.dynview.a.b.a, layoutParams2.topMargin + com.anythink.expressad.video.dynview.a.b.c, layoutParams2.rightMargin + com.anythink.expressad.video.dynview.a.b.b, layoutParams2.bottomMargin + com.anythink.expressad.video.dynview.a.b.d);
                    relativeLayout.setLayoutParams(layoutParams2);
                }
            }
            if (findViewById != null) {
                if (findViewById instanceof android.widget.TextView) {
                    android.widget.TextView textView = (android.widget.TextView) findViewById;
                    textView.setTextColor(android.graphics.Color.parseColor(this.p));
                    textView.setTextSize(25.0f);
                    java.lang.String str = this.f268s;
                    com.anythink.expressad.video.dynview.i.b.a.a(findViewById, 1.0f, 5.0f, str, new java.lang.String[]{this.v, str}, android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT);
                }
                android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
                new com.anythink.expressad.video.dynview.h.b();
                animatorSet.playTogether(com.anythink.expressad.video.dynview.h.b.c(findViewById));
                if (view instanceof com.anythink.expressad.video.dynview.widget.ATFramLayout) {
                    ((com.anythink.expressad.video.dynview.widget.ATFramLayout) view).setAnimatorSet(animatorSet);
                }
                if (view instanceof com.anythink.expressad.video.dynview.widget.ATRelativeLayout) {
                    ((com.anythink.expressad.video.dynview.widget.ATRelativeLayout) view).setAnimatorSet(animatorSet);
                }
            }
        }
        new com.anythink.expressad.video.dynview.h.b();
        com.anythink.expressad.video.dynview.h.b.e(view);
    }
}
