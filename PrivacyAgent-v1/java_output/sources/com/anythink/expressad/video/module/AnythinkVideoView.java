package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkVideoView extends com.anythink.expressad.video.module.AnythinkBaseView implements com.anythink.expressad.video.signal.f, com.anythink.expressad.video.signal.j {
    private static int A = 0;
    private static int B = 0;
    private static int C = 0;
    private static final java.lang.String D = "2";
    public static final java.lang.String TAG = "AnythinkVideoView";
    private static boolean aw = false;
    private static final java.lang.String t = "anythink_reward_videoview_item";
    private static final int u = 1;
    private static final float v = 1280.0f;
    private static final float w = 720.0f;
    private static final float x = 0.1f;
    private static int y;
    private static int z;
    private com.anythink.expressad.playercommon.PlayerView E;
    private com.anythink.expressad.video.widget.SoundImageView F;
    private android.widget.TextView G;
    private android.view.View H;
    private android.widget.RelativeLayout I;
    private android.widget.ImageView J;
    private android.widget.ProgressBar K;
    private com.anythink.expressad.widget.FeedBackButton L;
    private boolean M;
    private com.anythink.expressad.video.dynview.widget.ATSegmentsProgressBar N;
    private com.anythink.expressad.video.dynview.f.a O;
    private int P;
    private android.widget.FrameLayout Q;
    private com.anythink.expressad.video.module.AnythinkClickCTAView R;
    private com.anythink.expressad.video.signal.factory.b S;
    private int T;
    private android.widget.RelativeLayout U;
    private com.anythink.expressad.video.module.a.a V;
    private boolean W;
    private int aA;
    private int aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private boolean aH;
    private boolean aI;
    private boolean aJ;
    private android.view.animation.AlphaAnimation aK;
    private com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView aL;
    private com.anythink.expressad.video.module.AnythinkVideoView.b aM;
    private boolean aN;
    private java.lang.Runnable aO;
    private boolean aa;
    private java.lang.String ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    private com.anythink.expressad.widget.a.a ag;
    private com.anythink.expressad.widget.a.b ah;
    private java.lang.String ai;
    private double aj;
    private double ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private boolean at;
    private int au;
    private boolean av;
    private int ax;
    private java.lang.String ay;
    private int az;
    public java.util.List<com.anythink.expressad.foundation.d.c> mCampOrderViewData;
    public int mCampaignSize;
    public int mCurrPlayNum;
    public int mCurrentPlayProgressTime;
    public int mMuteSwitch;
    com.anythink.expressad.reward.player.c n;

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.video.dynview.f.h {
        final /* synthetic */ android.view.ViewGroup a;
        final /* synthetic */ com.anythink.expressad.video.dynview.c b;

        /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$1$1, reason: invalid class name and collision with other inner class name */
        public class C02301 extends com.anythink.expressad.widget.a {
            public C02301() {
            }

            @Override // com.anythink.expressad.widget.a
            public final void a(android.view.View view) {
                org.json.JSONObject jSONObject;
                org.json.JSONException e;
                if (com.anythink.expressad.video.module.AnythinkVideoView.this.V != null) {
                    try {
                        jSONObject = new org.json.JSONObject();
                    } catch (org.json.JSONException e2) {
                        jSONObject = null;
                        e = e2;
                    }
                    try {
                        jSONObject.put(com.anythink.expressad.foundation.g.a.ce, com.anythink.expressad.video.module.AnythinkVideoView.this.a(0));
                    } catch (org.json.JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        com.anythink.expressad.video.module.AnythinkVideoView.this.V.a(105, jSONObject);
                        com.anythink.core.common.b.o.a().f();
                    }
                    com.anythink.expressad.video.module.AnythinkVideoView.this.V.a(105, jSONObject);
                    com.anythink.core.common.b.o.a().f();
                }
            }
        }

        public AnonymousClass1(android.view.ViewGroup viewGroup, com.anythink.expressad.video.dynview.c cVar) {
            this.a = viewGroup;
            this.b = cVar;
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            if (this.a != null && aVar.a() != null) {
                aVar.a().setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
                this.a.addView(aVar.a());
            }
            if (aVar.b() != null) {
                java.util.Iterator<android.view.View> it = aVar.b().iterator();
                while (it.hasNext()) {
                    it.next().setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass1.C02301());
                }
            }
            com.anythink.expressad.video.module.AnythinkVideoView.this.aJ = aVar.c();
            com.anythink.expressad.video.module.AnythinkVideoView.this.b();
            boolean unused = com.anythink.expressad.video.module.AnythinkVideoView.aw = false;
            com.anythink.expressad.video.module.AnythinkVideoView.this.T = this.b.j();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            bVar.b();
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$10, reason: invalid class name */
    public class AnonymousClass10 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass10() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            int b = com.anythink.expressad.foundation.h.t.b(com.anythink.expressad.video.module.AnythinkVideoView.this.a, 12.0f);
            android.widget.ImageView imageView = new android.widget.ImageView(com.anythink.expressad.video.module.AnythinkVideoView.this.a);
            imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            imageView.setImageBitmap(bitmap);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams((int) (b * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight())), b);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.expressad.video.module.AnythinkVideoView.this.a, 5.0f);
            layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.expressad.video.module.AnythinkVideoView.this.a, 12.0f);
            com.anythink.expressad.video.module.AnythinkVideoView.this.addView(imageView, layoutParams);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        public AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkVideoView.p(com.anythink.expressad.video.module.AnythinkVideoView.this);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        public AnonymousClass12(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.video.module.AnythinkVideoView.this.I == null) {
                return;
            }
            com.anythink.expressad.video.module.AnythinkVideoView.this.I.setVisibility(0);
            com.anythink.expressad.foundation.d.c cVar = com.anythink.expressad.video.module.AnythinkVideoView.this.b;
            if (cVar != null && !cVar.j() && com.anythink.expressad.video.module.AnythinkVideoView.this.b.f() != 2) {
                com.anythink.expressad.video.module.AnythinkVideoView.this.I.setPadding(this.a, this.b, this.c, this.d);
                com.anythink.expressad.video.module.AnythinkVideoView.this.I.startAnimation(com.anythink.expressad.video.module.AnythinkVideoView.this.aK);
            }
            com.anythink.expressad.video.module.AnythinkVideoView.this.I.setVisibility(0);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled() || com.anythink.expressad.video.module.AnythinkVideoView.this.J == null) {
                        return;
                    }
                    com.anythink.expressad.video.module.AnythinkVideoView.this.J.setVisibility(0);
                    android.widget.ImageView imageView = com.anythink.expressad.video.module.AnythinkVideoView.this.J;
                    com.anythink.expressad.video.dynview.i.b.a();
                    imageView.setImageBitmap(com.anythink.expressad.video.dynview.i.b.a(bitmap, 20));
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.video.module.AnythinkVideoView.this.Q != null) {
                com.anythink.expressad.video.module.AnythinkVideoView.this.Q.setVisibility(8);
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.a.a aVar = com.anythink.expressad.video.module.AnythinkVideoView.this.e;
            if (aVar != null) {
                aVar.a(1, "");
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.a.a aVar = com.anythink.expressad.video.module.AnythinkVideoView.this.e;
            if (aVar != null) {
                aVar.a(1, "");
            }
            com.anythink.expressad.video.module.AnythinkVideoView.this.setCTALayoutVisibleOrGone();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.a.a aVar = com.anythink.expressad.video.module.AnythinkVideoView.this.e;
            if (aVar != null) {
                aVar.a(1, "");
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            java.lang.Integer num = 2;
            if (com.anythink.expressad.video.module.AnythinkVideoView.this.E != null && com.anythink.expressad.video.module.AnythinkVideoView.this.E.isSilent()) {
                num = 1;
            }
            if (num.intValue() == 1) {
                com.anythink.expressad.video.module.AnythinkVideoView.this.mMuteSwitch = 2;
            } else {
                com.anythink.expressad.video.module.AnythinkVideoView.this.mMuteSwitch = 1;
            }
            com.anythink.expressad.video.module.a.a aVar = com.anythink.expressad.video.module.AnythinkVideoView.this.e;
            if (aVar != null) {
                aVar.a(5, num);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.video.module.AnythinkVideoView.this.av) {
                com.anythink.expressad.video.module.AnythinkVideoView.e(com.anythink.expressad.video.module.AnythinkVideoView.this);
                if (com.anythink.expressad.video.module.AnythinkVideoView.this.aF) {
                    com.anythink.expressad.video.module.AnythinkVideoView.this.e();
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                } else {
                    com.anythink.expressad.video.module.a.a aVar = com.anythink.expressad.video.module.AnythinkVideoView.this.e;
                    if (aVar != null) {
                        aVar.a(123, "");
                        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                }
            } else {
                com.anythink.expressad.video.module.AnythinkVideoView.this.e();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoView$9, reason: invalid class name */
    public class AnonymousClass9 implements com.anythink.expressad.widget.a.b {
        public AnonymousClass9() {
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void a() {
            com.anythink.expressad.video.module.AnythinkVideoView.h(com.anythink.expressad.video.module.AnythinkVideoView.this);
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = com.anythink.expressad.video.module.AnythinkVideoView.this;
            anythinkVideoView.setShowingAlertViewCover(anythinkVideoView.W);
            if (com.anythink.expressad.video.module.AnythinkVideoView.this.av && (com.anythink.expressad.video.module.AnythinkVideoView.this.az == com.anythink.expressad.foundation.g.a.cs || com.anythink.expressad.video.module.AnythinkVideoView.this.az == com.anythink.expressad.foundation.g.a.cr)) {
                com.anythink.expressad.video.module.AnythinkVideoView.k(com.anythink.expressad.video.module.AnythinkVideoView.this);
                com.anythink.expressad.video.module.a.a aVar = com.anythink.expressad.video.module.AnythinkVideoView.this.e;
                if (aVar != null) {
                    aVar.a(124, "");
                }
                com.anythink.expressad.video.module.AnythinkVideoView.l(com.anythink.expressad.video.module.AnythinkVideoView.this);
                com.anythink.expressad.video.module.AnythinkVideoView.this.gonePlayingCloseView();
            }
            com.anythink.expressad.video.module.AnythinkVideoView.this.i();
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void b() {
            com.anythink.expressad.video.module.AnythinkVideoView.h(com.anythink.expressad.video.module.AnythinkVideoView.this);
            com.anythink.expressad.video.module.AnythinkVideoView.n(com.anythink.expressad.video.module.AnythinkVideoView.this);
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = com.anythink.expressad.video.module.AnythinkVideoView.this;
            anythinkVideoView.setShowingAlertViewCover(anythinkVideoView.W);
            if (com.anythink.expressad.video.module.AnythinkVideoView.this.av && com.anythink.expressad.video.module.AnythinkVideoView.this.az == com.anythink.expressad.foundation.g.a.cr) {
                com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView2 = com.anythink.expressad.video.module.AnythinkVideoView.this;
                com.anythink.expressad.video.module.a.a aVar = anythinkVideoView2.e;
                if (aVar != null) {
                    aVar.a(2, anythinkVideoView2.b(anythinkVideoView2.aG));
                    return;
                }
                return;
            }
            if (com.anythink.expressad.video.module.AnythinkVideoView.this.av && com.anythink.expressad.video.module.AnythinkVideoView.this.az == com.anythink.expressad.foundation.g.a.cs) {
                com.anythink.expressad.video.module.AnythinkVideoView.this.i();
                return;
            }
            com.anythink.expressad.video.module.a.a aVar2 = com.anythink.expressad.video.module.AnythinkVideoView.this.e;
            if (aVar2 != null) {
                aVar2.a(2, "");
            }
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void c() {
            a();
        }
    }

    public static class a {
        public int a;
        public int b;
        public boolean c;

        public final java.lang.String toString() {
            return "ProgressData{curPlayPosition=" + this.a + ", allDuration=" + this.b + '}';
        }
    }

    public static final class b extends com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener {
        private com.anythink.expressad.video.module.AnythinkVideoView a;
        private int b;
        private int c;
        private boolean d;
        private boolean i;
        private java.lang.String j;
        private com.anythink.expressad.foundation.d.c k;
        private int l;
        private int m;
        private com.anythink.expressad.video.module.AnythinkVideoView.a e = new com.anythink.expressad.video.module.AnythinkVideoView.a();
        private boolean f = false;
        private boolean g = false;
        private boolean h = false;
        private boolean n = false;

        public b(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
            this.a = anythinkVideoView;
        }

        private void a(int i) {
            if (i <= 0) {
                this.a.G.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_shape_progress", com.anythink.expressad.foundation.h.i.c));
                return;
            }
            this.a.G.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_time_count_num_bg", com.anythink.expressad.foundation.h.i.c));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 30.0f));
            int b = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 5.0f);
            layoutParams.addRule(1, com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_native_endcard_feed_btn", "id"));
            layoutParams.setMargins(b, 0, 0, 0);
            this.a.G.setPadding(b, 0, b, 0);
            this.a.G.setLayoutParams(layoutParams);
        }

        private void a(int i, int i2, int i3) {
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView == null) {
                return;
            }
            java.lang.String str = (java.lang.String) anythinkVideoView.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_complete", com.anythink.expressad.foundation.h.i.g));
            java.lang.String str2 = (java.lang.String) this.a.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_left", com.anythink.expressad.foundation.h.i.g));
            if (i >= 0) {
                int i4 = i - i3;
                if (i4 > 0) {
                    str = i4 + str2;
                }
            } else {
                int i5 = i2 - i3;
                if (i5 <= 0) {
                    if (i <= 0) {
                        str = "0";
                    }
                } else if (i <= 0) {
                    str = java.lang.String.valueOf(i5);
                } else {
                    str = i5 + str2;
                }
            }
            this.e.a = i3;
            this.a.G.setText(str);
            if (this.a.K == null || this.a.K.getVisibility() != 0) {
                return;
            }
            this.a.K.setProgress(i3);
        }

        private void b(int i) {
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView == null || anythinkVideoView.G == null) {
                return;
            }
            java.lang.String str = "anythink_reward_video_time_count_num_bg";
            if (this.k.k() == 5) {
                com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView2 = this.a;
                if (anythinkVideoView2.mCurrPlayNum > 1 && i <= 0) {
                    anythinkVideoView2.G.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_time_count_num_bg", com.anythink.expressad.foundation.h.i.c));
                    d();
                    return;
                }
            }
            if (i > 0) {
                d();
            } else {
                str = "anythink_reward_shape_progress";
            }
            this.a.G.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), str, com.anythink.expressad.foundation.h.i.c));
        }

        private void b(int i, int i2, int i3) {
            java.lang.String str;
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView == null) {
                return;
            }
            if (i > i2) {
                i = i2;
            }
            int i4 = i <= 0 ? i2 - i3 : i - i3;
            if (i4 <= 0) {
                str = i <= 0 ? "0" : (java.lang.String) anythinkVideoView.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_complete", com.anythink.expressad.foundation.h.i.g));
            } else if (i <= 0) {
                str = java.lang.String.valueOf(i4);
            } else {
                str = i4 + ((java.lang.String) this.a.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_left", com.anythink.expressad.foundation.h.i.g)));
            }
            this.a.G.setText(str);
            if (this.a.K == null || this.a.K.getVisibility() != 0) {
                return;
            }
            this.a.K.setProgress(i3);
        }

        private com.anythink.expressad.foundation.d.c c() {
            return this.k;
        }

        private void d() {
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView == null) {
                return;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) anythinkVideoView.G.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 25.0f);
                this.a.G.setLayoutParams(layoutParams);
            }
            int b = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 5.0f);
            this.a.G.setPadding(b, 0, b, 0);
        }

        public final int a() {
            return this.b;
        }

        public final void a(int i, int i2) {
            this.l = i;
            this.m = i2;
        }

        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            this.k = cVar;
        }

        public final void a(java.lang.String str) {
            this.j = str;
        }

        public final void a(boolean z) {
            this.i = z;
        }

        public final void b() {
            this.a = null;
            boolean unused = com.anythink.expressad.video.module.AnythinkVideoView.aw = false;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                this.a.e.a(14, "");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(java.lang.String str) {
            try {
                super.onBufferingStart(str);
                this.a.e.a(13, "");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() {
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView;
            super.onPlayCompleted();
            com.anythink.expressad.video.module.AnythinkVideoView.w(this.a);
            com.anythink.expressad.foundation.d.c cVar = this.k;
            if (cVar != null) {
                if (cVar.i() > 0) {
                    this.a.G.setText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_complete", com.anythink.expressad.foundation.h.i.g));
                } else {
                    this.a.G.setText("0");
                }
                this.k.n(100);
                if (this.k.f() == 2) {
                    this.a.H.setVisibility(4);
                    if (this.a.L != null) {
                        this.a.L.setClickable(false);
                    }
                    if (this.a.F != null) {
                        this.a.F.setClickable(false);
                    }
                }
            } else {
                this.a.G.setText("0");
            }
            this.a.E.setClickable(false);
            java.lang.String b = this.a.b(true);
            com.anythink.expressad.foundation.d.c cVar2 = this.k;
            if (cVar2 != null && cVar2.k() == 5 && (anythinkVideoView = this.a) != null && anythinkVideoView.O != null) {
                com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView2 = this.a;
                if (anythinkVideoView2.mCampaignSize > anythinkVideoView2.mCurrPlayNum) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, java.lang.Integer.valueOf(this.a.mCurrPlayNum));
                    int i = this.a.mMuteSwitch;
                    if (i != 0) {
                        hashMap.put("mute", java.lang.Integer.valueOf(i));
                    }
                    this.a.O.a(hashMap);
                    return;
                }
            }
            this.a.e.a(121, "");
            this.a.e.a(11, b);
            int i2 = this.c;
            this.b = i2;
            this.a.mCurrentPlayProgressTime = i2;
            boolean unused = com.anythink.expressad.video.module.AnythinkVideoView.aw = true;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayError(java.lang.String str) {
            super.onPlayError(str);
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.a;
            if (anythinkVideoView != null) {
                anythinkVideoView.e.a(12, str);
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayProgress(int i, int i2) {
            java.lang.String str;
            com.anythink.expressad.foundation.d.c cVar;
            int i3;
            java.lang.String str2;
            super.onPlayProgress(i, i2);
            if (this.a.f) {
                com.anythink.expressad.foundation.d.c cVar2 = this.k;
                if (cVar2 != null) {
                    i3 = cVar2.i();
                    com.anythink.expressad.foundation.f.b.a().a(this.k.K() + "_1", i);
                } else {
                    i3 = 0;
                }
                java.lang.String str3 = "0";
                if (this.k.j() && this.k.k() == 5) {
                    try {
                        int i4 = this.a.P;
                        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.a;
                        if (anythinkVideoView != null) {
                            java.lang.String str4 = (java.lang.String) anythinkVideoView.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_complete", com.anythink.expressad.foundation.h.i.g));
                            java.lang.String str5 = (java.lang.String) this.a.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_left", com.anythink.expressad.foundation.h.i.g));
                            if (i3 >= 0) {
                                int i5 = i3 - i;
                                if (i5 > 0) {
                                    str4 = i5 + str5;
                                }
                            } else {
                                int i6 = i4 - i;
                                if (i6 <= 0) {
                                    if (i3 <= 0) {
                                        this.e.a = i;
                                        this.a.G.setText(str3);
                                        if (this.a.K != null && this.a.K.getVisibility() == 0) {
                                            this.a.K.setProgress(i);
                                        }
                                    }
                                } else if (i3 <= 0) {
                                    str4 = java.lang.String.valueOf(i6);
                                } else {
                                    str4 = i6 + str5;
                                }
                            }
                            str3 = str4;
                            this.e.a = i;
                            this.a.G.setText(str3);
                            if (this.a.K != null) {
                                this.a.K.setProgress(i);
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e.getMessage();
                    }
                } else {
                    com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView2 = this.a;
                    if (anythinkVideoView2 != null) {
                        if (i3 > i2) {
                            i3 = i2;
                        }
                        int i7 = i3 <= 0 ? i2 - i : i3 - i;
                        if (i7 > 0) {
                            if (i3 <= 0) {
                                str2 = java.lang.String.valueOf(i7);
                            } else {
                                str2 = i7 + ((java.lang.String) this.a.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_left", com.anythink.expressad.foundation.h.i.g)));
                            }
                            str3 = str2;
                        } else if (i3 > 0) {
                            str3 = (java.lang.String) anythinkVideoView2.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_complete", com.anythink.expressad.foundation.h.i.g));
                        }
                        this.a.G.setText(str3);
                        if (this.a.K != null && this.a.K.getVisibility() == 0) {
                            this.a.K.setProgress(i);
                        }
                    }
                    this.e.a = i;
                }
            }
            this.c = i2;
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView3 = this.a;
            anythinkVideoView3.mCurrentPlayProgressTime = i;
            com.anythink.expressad.video.module.AnythinkVideoView.a aVar = this.e;
            aVar.a = i;
            aVar.b = i2;
            aVar.c = anythinkVideoView3.aH;
            this.b = i;
            this.a.e.a(15, this.e);
            if (this.a.av && !this.a.aC && this.a.az == com.anythink.expressad.foundation.g.a.cs) {
                this.a.e();
            }
            try {
                com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView4 = this.a;
                if (anythinkVideoView4 != null && anythinkVideoView4.N != null) {
                    int i8 = (i * 100) / i2;
                    this.a.N.setProgress(i8, this.a.mCurrPlayNum - 1);
                    this.k.n(i8);
                }
                com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView5 = this.a;
                if (anythinkVideoView5 != null && anythinkVideoView5.T != -1 && i == this.a.T && (cVar = this.a.b) != null && cVar.j()) {
                    this.a.setCTALayoutVisibleOrGone();
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            int i9 = this.l;
            if (i9 == 100 || this.n || i9 == 0) {
                return;
            }
            if (this.m > i9) {
                this.m = i9 / 2;
            }
            int i10 = this.m;
            if (i10 < 0 || i < (i2 * i10) / 100) {
                return;
            }
            if (this.k.w() == 94 || this.k.w() == 287) {
                str = this.k.Z() + this.k.aZ() + this.k.S();
            } else {
                str = this.k.aZ() + this.k.S() + this.k.B();
            }
            com.anythink.expressad.videocommon.b.c a = com.anythink.expressad.videocommon.b.e.a().a(this.j, str);
            if (a != null) {
                a.i();
                this.n = true;
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(java.lang.String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayStarted(int i) {
            super.onPlayStarted(i);
            if (!this.d) {
                com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.a;
                if (anythinkVideoView != null) {
                    com.anythink.expressad.video.module.AnythinkVideoView.q(anythinkVideoView);
                }
                this.a.e.a(10, this.e);
                this.d = true;
            }
            com.anythink.expressad.foundation.d.c cVar = this.k;
            if (cVar != null) {
                int i2 = cVar.i();
                java.lang.String str = "anythink_reward_shape_progress";
                if (this.k.j()) {
                    com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView2 = this.a;
                    if (anythinkVideoView2 != null && anythinkVideoView2.G != null) {
                        if (this.k.k() == 5) {
                            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView3 = this.a;
                            if (anythinkVideoView3.mCurrPlayNum > 1 && i2 <= 0) {
                                anythinkVideoView3.G.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_time_count_num_bg", com.anythink.expressad.foundation.h.i.c));
                                d();
                            }
                        }
                        if (i2 > 0) {
                            d();
                            str = "anythink_reward_video_time_count_num_bg";
                        }
                        this.a.G.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), str, com.anythink.expressad.foundation.h.i.c));
                    }
                } else if (i2 > 0) {
                    this.a.G.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_time_count_num_bg", com.anythink.expressad.foundation.h.i.c));
                    android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 30.0f));
                    int b = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 5.0f);
                    layoutParams.addRule(1, com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_native_endcard_feed_btn", "id"));
                    layoutParams.setMargins(b, 0, 0, 0);
                    this.a.G.setPadding(b, 0, b, 0);
                    this.a.G.setLayoutParams(layoutParams);
                } else {
                    this.a.G.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_shape_progress", com.anythink.expressad.foundation.h.i.c));
                }
            }
            if (this.a.K != null) {
                this.a.K.setMax(i);
            }
            com.anythink.expressad.foundation.d.c cVar2 = this.k;
            if (cVar2 != null && cVar2.f() == 2) {
                this.a.I.setVisibility(0);
            }
            if (this.a.G.getVisibility() == 0) {
                this.a.n();
            }
            boolean unused = com.anythink.expressad.video.module.AnythinkVideoView.aw = false;
            if (this.a.T == 0) {
                this.a.setCTALayoutVisibleOrGone();
            }
            this.a.showMoreOfferInPlayTemplate();
            this.a.showBaitClickView();
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onVideoDownloadResume() {
            java.lang.String str;
            if (this.k.w() == 94 || this.k.w() == 287) {
                str = this.k.Z() + this.k.aZ() + this.k.S();
            } else {
                str = this.k.aZ() + this.k.S() + this.k.B();
            }
            com.anythink.expressad.videocommon.b.c a = com.anythink.expressad.videocommon.b.e.a().a(this.j, str);
            if (a != null) {
                a.i();
                this.n = true;
            }
        }
    }

    public AnythinkVideoView(android.content.Context context) {
        super(context);
        this.mMuteSwitch = 0;
        this.P = 0;
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.W = false;
        this.aa = false;
        this.ai = "";
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.ar = false;
        this.as = false;
        this.at = false;
        this.av = false;
        this.ax = 2;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aF = true;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aJ = false;
        this.aM = new com.anythink.expressad.video.module.AnythinkVideoView.b(this);
        this.aN = false;
        this.aO = new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass3();
    }

    public AnythinkVideoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMuteSwitch = 0;
        this.P = 0;
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.W = false;
        this.aa = false;
        this.ai = "";
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.ar = false;
        this.as = false;
        this.at = false;
        this.av = false;
        this.ax = 2;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aF = true;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aJ = false;
        this.aM = new com.anythink.expressad.video.module.AnythinkVideoView.b(this);
        this.aN = false;
        this.aO = new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass3();
    }

    private int a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null && cVar.ao() != -1) {
            return cVar.ao();
        }
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ai, false).v();
    }

    private static java.lang.String a(int i, int i2) {
        if (i2 != 0) {
            double d = i / i2;
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.anythink.expressad.foundation.h.t.a(java.lang.Double.valueOf(d)));
                return sb.toString();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return java.lang.String.valueOf(i2);
    }

    private void a() {
        int findLayout = findLayout(t);
        if (findLayout > 0) {
            this.c.inflate(findLayout, this);
            b();
        }
        aw = false;
    }

    private void a(android.view.ViewGroup viewGroup, com.anythink.expressad.foundation.d.c cVar) {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c a2 = com.anythink.expressad.video.dynview.j.c.a(viewGroup, cVar);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(a2, new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass1(viewGroup, a2));
    }

    private void a(java.lang.String str) {
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(str, new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String b(boolean z2) {
        if (!this.av) {
            return "";
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (!this.aC) {
                jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cv);
            }
            if (this.aE) {
                jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cx);
            }
            if (this.aD) {
                jSONObject.put("Alert_window_status", com.anythink.expressad.foundation.g.a.cw);
            }
            jSONObject.put("complete_info", z2 ? 1 : 2);
            return jSONObject.toString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f = f();
        c();
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 100.0f);
        this.aK = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    private void b(int i) {
        if (i > 0) {
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setCornerRadius(com.anythink.expressad.foundation.h.t.b(getContext(), i));
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(1, 0);
            setBackground(gradientDrawable);
            this.E.setBackground(gradientDrawable);
            setClipToOutline(true);
            this.E.setClipToOutline(true);
        }
    }

    private boolean b(int i, int i2) {
        return i > 0 && i2 > 0 && com.anythink.expressad.foundation.h.t.f(this.a) >= i && com.anythink.expressad.foundation.h.t.e(this.a) >= i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i;
        com.anythink.expressad.video.module.a.a aVar;
        try {
            if (!this.av || ((i = this.az) != com.anythink.expressad.foundation.g.a.cr && i != com.anythink.expressad.foundation.g.a.cs)) {
                com.anythink.expressad.foundation.d.c cVar = this.b;
                if (cVar == null || cVar.f() == 2) {
                    com.anythink.expressad.video.module.a.a aVar2 = this.e;
                    if (aVar2 != null) {
                        aVar2.a(2, "");
                        return;
                    }
                    return;
                }
                int i2 = this.b.i();
                int curPosition = this.E.getCurPosition() / 1000;
                boolean z2 = false;
                if (this.b.k() == 5) {
                }
                if (!z2 || this.ae != 1 || this.at) {
                    com.anythink.expressad.video.module.a.a aVar3 = this.e;
                    if (aVar3 != null) {
                        aVar3.a(2, "");
                        return;
                    }
                    return;
                }
                h();
                com.anythink.expressad.video.module.a.a aVar4 = this.e;
                if (aVar4 != null) {
                    aVar4.a(8, "");
                    return;
                }
                return;
            }
            if (this.aC) {
                if (i != com.anythink.expressad.foundation.g.a.cs || (aVar = this.e) == null) {
                    return;
                }
                aVar.a(2, b(this.aG));
                return;
            }
            if (i == com.anythink.expressad.foundation.g.a.cs && this.aI) {
                com.anythink.expressad.video.module.a.a aVar5 = this.e;
                if (aVar5 != null) {
                    aVar5.a(2, b(this.aG));
                    return;
                }
                return;
            }
            if (this.aF) {
                int curPosition2 = this.E.getCurPosition() / 1000;
                int bi = (int) ((curPosition2 / (this.E.getDuration() == 0 ? this.b.bi() : this.E.getDuration())) * 100.0f);
                if (this.az == com.anythink.expressad.foundation.g.a.cr) {
                    h();
                    int i3 = this.aA;
                    if (i3 == com.anythink.expressad.foundation.g.a.ct && bi >= this.aB) {
                        com.anythink.expressad.video.module.a.a aVar6 = this.e;
                        if (aVar6 != null) {
                            aVar6.a(2, b(this.aG));
                            return;
                        }
                        return;
                    }
                    if (i3 == com.anythink.expressad.foundation.g.a.cu && curPosition2 >= this.aB) {
                        com.anythink.expressad.video.module.a.a aVar7 = this.e;
                        if (aVar7 != null) {
                            aVar7.a(2, b(this.aG));
                            return;
                        }
                        return;
                    }
                    com.anythink.expressad.video.module.a.a aVar8 = this.e;
                    if (aVar8 != null) {
                        aVar8.a(8, "");
                    }
                }
                if (this.az == com.anythink.expressad.foundation.g.a.cs) {
                    int i4 = this.aA;
                    if (i4 == com.anythink.expressad.foundation.g.a.ct && bi >= this.aB) {
                        h();
                        com.anythink.expressad.video.module.a.a aVar9 = this.e;
                        if (aVar9 != null) {
                            aVar9.a(8, "");
                            return;
                        }
                        return;
                    }
                    if (i4 != com.anythink.expressad.foundation.g.a.cu || curPosition2 < this.aB) {
                        return;
                    }
                    h();
                    com.anythink.expressad.video.module.a.a aVar10 = this.e;
                    if (aVar10 != null) {
                        aVar10.a(8, "");
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public static /* synthetic */ boolean e(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aI = true;
        return true;
    }

    private boolean f() {
        try {
            this.E = (com.anythink.expressad.playercommon.PlayerView) findViewById(filterFindViewId(this.aJ, "anythink_vfpv"));
            this.F = (com.anythink.expressad.video.widget.SoundImageView) findViewById(filterFindViewId(this.aJ, "anythink_sound_switch"));
            this.G = (android.widget.TextView) findViewById(filterFindViewId(this.aJ, "anythink_tv_count"));
            android.view.View findViewById = findViewById(filterFindViewId(this.aJ, "anythink_rl_playing_close"));
            this.H = findViewById;
            findViewById.setVisibility(4);
            this.I = (android.widget.RelativeLayout) findViewById(filterFindViewId(this.aJ, "anythink_top_control"));
            this.J = (android.widget.ImageView) findViewById(filterFindViewId(this.aJ, "anythink_videoview_bg"));
            this.K = (android.widget.ProgressBar) findViewById(filterFindViewId(this.aJ, "anythink_video_progress_bar"));
            this.L = (com.anythink.expressad.widget.FeedBackButton) findViewById(filterFindViewId(this.aJ, "anythink_native_endcard_feed_btn"));
            this.N = (com.anythink.expressad.video.dynview.widget.ATSegmentsProgressBar) findViewById(filterFindViewId(this.aJ, "anythink_reward_segment_progressbar"));
            this.Q = (android.widget.FrameLayout) findViewById(filterFindViewId(this.aJ, "anythink_reward_cta_layout"));
            this.aL = (com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView) findViewById(filterFindViewId(this.aJ, "anythink_animation_click_view"));
            this.U = (android.widget.RelativeLayout) findViewById(filterFindViewId(this.aJ, "anythink_reward_moreoffer_layout"));
            try {
                java.lang.String aE = this.b.aE();
                if (android.text.TextUtils.isEmpty(aE)) {
                    aE = com.anythink.expressad.a.ab;
                }
                if (!android.text.TextUtils.isEmpty(aE)) {
                    com.anythink.expressad.foundation.g.d.b.a(this.a).a(aE, new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass10());
                }
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.getLocalizedMessage();
                }
            }
            return isNotNULL(this.E, this.F, this.G, this.H);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private void g() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !com.anythink.expressad.foundation.h.w.b(cVar.U())) {
            return;
        }
        java.lang.String[] split = this.b.U().split("x");
        if (split.length == 2) {
            if (com.anythink.expressad.foundation.h.t.b(split[0]) > 0.0d) {
                this.aj = com.anythink.expressad.foundation.h.t.b(split[0]);
            }
            if (com.anythink.expressad.foundation.h.t.b(split[1]) > 0.0d) {
                this.ak = com.anythink.expressad.foundation.h.t.b(split[1]);
            }
        }
        if (this.aj <= 0.0d) {
            this.aj = 1280.0d;
        }
        if (this.ak <= 0.0d) {
            this.ak = 720.0d;
        }
    }

    private void h() {
        boolean z2;
        com.anythink.expressad.foundation.d.c cVar;
        try {
            com.anythink.expressad.playercommon.PlayerView playerView = this.E;
            if (playerView != null) {
                if (!this.aa && !this.W) {
                    z2 = false;
                    playerView.setIsCovered(z2);
                    this.E.onPause();
                    cVar = this.b;
                    if (cVar != null || cVar.L() == null || this.b.aw()) {
                        return;
                    }
                    this.b.ax();
                    android.content.Context f = com.anythink.core.common.b.o.a().f();
                    com.anythink.expressad.foundation.d.c cVar2 = this.b;
                    com.anythink.expressad.a.a.a(f, cVar2, this.ai, cVar2.L().m(), false);
                    return;
                }
                z2 = true;
                playerView.setIsCovered(z2);
                this.E.onPause();
                cVar = this.b;
                if (cVar != null) {
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ boolean h(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.W = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.anythink.expressad.video.module.AnythinkVideoView.b bVar;
        try {
            if (this.am) {
                if (this.aa || this.W) {
                    return;
                }
                this.E.setIsCovered(false);
                this.E.onResume();
                return;
            }
            boolean playVideo = this.E.playVideo();
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar != null && cVar.J() != 2 && !playVideo && (bVar = this.aM) != null) {
                bVar.onPlayError("play video failed");
            }
            this.am = true;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private void j() {
        if (!this.f || this.H.getVisibility() == 0) {
            return;
        }
        if (!this.i || this.M) {
            this.H.setVisibility(0);
        }
        this.ap = true;
    }

    private void k() {
        if (this.aN || this.as || this.aq) {
            return;
        }
        this.aN = true;
        int i = this.ac;
        if (i >= 0) {
            if (i == 0) {
                this.as = true;
            } else {
                new android.os.Handler().postDelayed(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass11(), this.ac * 1000);
            }
        }
    }

    public static /* synthetic */ boolean k(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aD = true;
        return true;
    }

    private void l() {
        float f;
        float f2 = com.anythink.expressad.foundation.h.t.f(this.a);
        float e = com.anythink.expressad.foundation.h.t.e(this.a);
        com.anythink.expressad.foundation.d.c.C0208c M = this.b.M();
        if (M != null && ((M.c() == 1 && f2 > e) || (M.c() == 2 && e > f2))) {
            float f3 = f2 + e;
            e = f3 - e;
            f2 = f3 - e;
        }
        int b2 = com.anythink.expressad.foundation.h.t.b(getContext(), 58.0f);
        int b3 = com.anythink.expressad.foundation.h.t.b(getContext(), 104.0f);
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null && cVar.f() == 2) {
            int c = this.b.M().c();
            if (c == 1) {
                f2 -= b2 * 2;
                e -= b3 * 2;
            }
            if (c == 2) {
                f2 -= b3 * 2;
                e -= b2 * 2;
            }
            if (c == 0) {
                if (this.d == 1) {
                    f2 -= b2 * 2;
                    f = b3 * 2;
                } else {
                    f2 -= b3 * 2;
                    f = b2 * 2;
                }
                e -= f;
            }
        }
        double d = this.aj;
        if (d > 0.0d) {
            double d2 = this.ak;
            if (d2 > 0.0d && f2 > 0.0f && e > 0.0f) {
                double d3 = d / d2;
                double a2 = com.anythink.expressad.foundation.h.t.a(java.lang.Double.valueOf(d3));
                double a3 = com.anythink.expressad.foundation.h.t.a(java.lang.Double.valueOf(f2 / e));
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.E.getLayoutParams();
                if (a2 > a3) {
                    double d4 = (f2 * this.ak) / this.aj;
                    layoutParams.width = -1;
                    layoutParams.height = (int) d4;
                    layoutParams.gravity = 17;
                } else if (a2 < a3) {
                    layoutParams.width = (int) (e * d3);
                    layoutParams.height = -1;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                try {
                    com.anythink.expressad.foundation.d.c cVar2 = this.b;
                    if (cVar2 != null && cVar2.j()) {
                        int b4 = this.b.M().b();
                        int c2 = this.b.M().c();
                        if (b4 == 102 || b4 == 202) {
                            if (c2 == 1) {
                                layoutParams.width = -1;
                                layoutParams.gravity = 17;
                                layoutParams.height = (int) (this.ak / (this.aj / f2));
                            } else {
                                layoutParams.height = -1;
                                layoutParams.gravity = 17;
                                layoutParams.width = (int) (e * d3);
                            }
                        }
                        if (b4 == 202 && !android.text.TextUtils.isEmpty(this.b.be())) {
                            a(this.b.be());
                        }
                        if (b4 == 302 || b4 == 802) {
                            double d5 = this.aj;
                            double d6 = this.ak;
                            if (d5 / d6 > 1.0d) {
                                layoutParams.width = -1;
                                layoutParams.height = (int) ((d6 * f2) / d5);
                            } else {
                                int b5 = com.anythink.expressad.foundation.h.t.b(getContext(), 220.0f);
                                layoutParams.width = (int) ((this.aj * b5) / this.ak);
                                layoutParams.height = b5;
                            }
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
                this.E.setLayoutParams(layoutParams);
                setMatchParent();
                return;
            }
        }
        m();
    }

    public static /* synthetic */ boolean l(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aH = true;
        return true;
    }

    private void m() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (isLandscape() || !this.f) {
                return;
            }
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.E.getLayoutParams();
            int f = com.anythink.expressad.foundation.h.t.f(this.a);
            layoutParams.width = -1;
            layoutParams.height = (f * 9) / 16;
            layoutParams.gravity = 17;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            com.anythink.expressad.widget.FeedBackButton feedBackButton = this.L;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        this.b.l(this.ai);
        com.anythink.expressad.foundation.f.b.a().a(this.ai + "_1", this.b);
        com.anythink.expressad.foundation.f.b.a().a(this.ai + "_1", this.L);
    }

    public static /* synthetic */ boolean n(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aE = true;
        return true;
    }

    private int o() {
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ai, false).x();
    }

    private void p() {
        if (this.Q == null) {
            return;
        }
        if (this.R == null) {
            com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView = new com.anythink.expressad.video.module.AnythinkClickCTAView(getContext());
            this.R = anythinkClickCTAView;
            anythinkClickCTAView.setCampaign(this.b);
            this.R.setUnitId(this.ai);
            com.anythink.expressad.video.module.a.a aVar = this.V;
            if (aVar != null) {
                this.R.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(aVar));
            }
            this.R.preLoadData(this.S);
        }
        this.Q.addView(this.R);
    }

    public static /* synthetic */ boolean p(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.as = true;
        return true;
    }

    public static /* synthetic */ boolean q(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.M = true;
        return true;
    }

    public static /* synthetic */ boolean w(com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView) {
        anythinkVideoView.aG = true;
        return true;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void alertWebViewShowed() {
        this.W = true;
        setShowingAlertViewCover(true);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        super.c();
        if (this.f) {
            if (!this.i) {
                this.E.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass6());
            } else if (com.anythink.expressad.video.dynview.i.c.a(this.b) == -1 || com.anythink.expressad.video.dynview.i.c.a(this.b) == 100) {
                this.E.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass5());
            }
            com.anythink.expressad.video.widget.SoundImageView soundImageView = this.F;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass7());
            }
            this.H.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass8());
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void closeVideoOperate(int i, int i2) {
        if (i == 1) {
            this.aI = true;
            if (getVisibility() == 0) {
                e();
            }
        }
        if (i2 == 1) {
            gonePlayingCloseView();
            return;
        }
        if (i2 == 2) {
            if ((this.aH && getVisibility() == 0) || !this.f || this.H.getVisibility() == 0) {
                return;
            }
            if (!this.i || this.M) {
                this.H.setVisibility(0);
            }
            this.ap = true;
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
        this.al = true;
        showVideoLocation(0, 0, com.anythink.expressad.foundation.h.t.f(this.a), com.anythink.expressad.foundation.h.t.e(this.a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.ac == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void dismissAllAlert() {
        com.anythink.expressad.widget.a.a aVar = this.ag;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.anythink.expressad.video.module.a.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.a(125, "");
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewHeight() {
        return C;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewLeft() {
        return A;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewRadius() {
        return y;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewTop() {
        return z;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewWidth() {
        return B;
    }

    public int getCloseAlert() {
        return this.ae;
    }

    @Override // com.anythink.expressad.video.signal.j
    public java.lang.String getCurrentProgress() {
        try {
            int a2 = this.aM.a();
            com.anythink.expressad.foundation.d.c cVar = this.b;
            int bi = cVar != null ? cVar.bi() : 0;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, a(a2, bi));
            jSONObject.put("time", a2);
            jSONObject.put("duration", java.lang.String.valueOf(bi));
            return jSONObject.toString();
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return "{}";
        }
    }

    public int getMute() {
        return this.ax;
    }

    public java.lang.String getUnitId() {
        return this.ai;
    }

    public int getVideoSkipTime() {
        return this.ac;
    }

    public void gonePlayingCloseView() {
        if (this.f && this.H.getVisibility() != 8) {
            this.H.setVisibility(8);
            this.ap = false;
        }
        if (this.aN || this.as || this.aq) {
            return;
        }
        this.aN = true;
        int i = this.ac;
        if (i >= 0) {
            if (i == 0) {
                this.as = true;
            } else {
                new android.os.Handler().postDelayed(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass11(), this.ac * 1000);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void hideAlertView(int i) {
        if (this.W) {
            this.W = false;
            this.aC = true;
            setShowingAlertViewCover(false);
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ai, false);
            if (i == 0) {
                i();
                if (this.av) {
                    int i2 = this.az;
                    if (i2 == com.anythink.expressad.foundation.g.a.cs || i2 == com.anythink.expressad.foundation.g.a.cr) {
                        this.aD = true;
                        com.anythink.expressad.video.module.a.a aVar = this.e;
                        if (aVar != null) {
                            aVar.a(124, "");
                        }
                        this.aH = true;
                        gonePlayingCloseView();
                        return;
                    }
                    return;
                }
                return;
            }
            this.aE = true;
            boolean z2 = this.av;
            if (z2 && this.az == com.anythink.expressad.foundation.g.a.cs) {
                i();
                return;
            }
            if (z2 && this.az == com.anythink.expressad.foundation.g.a.cr) {
                com.anythink.expressad.video.module.a.a aVar2 = this.e;
                if (aVar2 != null) {
                    aVar2.a(2, b(this.aG));
                    return;
                }
                return;
            }
            com.anythink.expressad.video.module.a.a aVar3 = this.e;
            if (aVar3 != null) {
                aVar3.a(2, "");
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
    }

    @Override // com.anythink.expressad.video.signal.j
    public boolean isH5Canvas() {
        return getLayoutParams().height < com.anythink.expressad.foundation.h.t.e(this.a.getApplicationContext());
    }

    public boolean isInstallDialogShowing() {
        return this.aa;
    }

    public boolean isMiniCardShowing() {
        return this.ao;
    }

    public boolean isShowingAlertView() {
        return this.W;
    }

    public boolean isShowingTransparent() {
        return this.at;
    }

    public boolean isfront() {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i = indexOfChild + 1;
        boolean z2 = false;
        while (i <= childCount - 1) {
            if (viewGroup.getChildAt(i).getVisibility() == 0 && this.ao) {
                return false;
            }
            i++;
            z2 = true;
        }
        return z2;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.aq = true;
            this.as = false;
        } else if (i == 1) {
            this.ar = true;
        }
    }

    public void notifyVideoClose() {
        this.e.a(2, "");
    }

    public void onBackPress() {
        if (this.ao || this.W || this.aD) {
            return;
        }
        if (this.ap) {
            e();
            return;
        }
        boolean z2 = this.aq;
        if (z2 && this.ar) {
            e();
        } else {
            if (z2 || !this.as) {
                return;
            }
            e();
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if ((cVar == null || !cVar.j()) && this.f && this.al) {
            l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.aO != null) {
                getHandler().removeCallbacks(this.aO);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        com.anythink.expressad.foundation.d.c cVar;
        this.S = bVar;
        if (!this.f) {
            com.anythink.expressad.video.module.a.a aVar = this.e;
            if (aVar != null) {
                aVar.a(12, "ATVideoView initSuccess false");
            }
        } else if (!android.text.TextUtils.isEmpty(this.ab) && (cVar = this.b) != null) {
            if (cVar != null && com.anythink.expressad.foundation.h.w.b(cVar.U())) {
                java.lang.String[] split = this.b.U().split("x");
                if (split.length == 2) {
                    if (com.anythink.expressad.foundation.h.t.b(split[0]) > 0.0d) {
                        this.aj = com.anythink.expressad.foundation.h.t.b(split[0]);
                    }
                    if (com.anythink.expressad.foundation.h.t.b(split[1]) > 0.0d) {
                        this.ak = com.anythink.expressad.foundation.h.t.b(split[1]);
                    }
                }
                if (this.aj <= 0.0d) {
                    this.aj = 1280.0d;
                }
                if (this.ak <= 0.0d) {
                    this.ak = 720.0d;
                }
            }
            com.anythink.expressad.reward.player.c cVar2 = this.n;
            if (cVar2 != null) {
                cVar2.c();
            }
            this.E.setTempEventListener(this.n);
            this.E.initBufferIngParam(this.ad);
            this.E.initVFPData(this.ab, this.b.S(), this.b.ao(), this.aM);
            soundOperate(this.ax, -1, null);
        }
        aw = false;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void progressBarOperate(int i) {
        android.widget.ProgressBar progressBar;
        if (this.f) {
            if (i == 1) {
                android.widget.ProgressBar progressBar2 = this.K;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                    return;
                }
                return;
            }
            if (i != 2 || (progressBar = this.K) == null) {
                return;
            }
            progressBar.setVisibility(0);
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void progressOperate(int i, int i2) {
        com.anythink.expressad.playercommon.PlayerView playerView;
        if (this.f) {
            com.anythink.expressad.foundation.d.c cVar = this.b;
            int bi = cVar != null ? cVar.bi() : 0;
            if (i > 0 && i <= bi && (playerView = this.E) != null) {
                playerView.seekTo(i * 1000);
            }
            if (i2 == 1) {
                this.G.setVisibility(8);
            } else if (i2 == 2) {
                this.G.setVisibility(0);
            }
            if (this.G.getVisibility() == 0) {
                n();
            }
        }
    }

    public void releasePlayer() {
        try {
            com.anythink.expressad.playercommon.PlayerView playerView = this.E;
            if (playerView != null && !this.an) {
                playerView.release();
            }
            com.anythink.expressad.video.module.AnythinkVideoView.b bVar = this.aM;
            if (bVar != null) {
                bVar.b();
            }
            if (this.V != null) {
                this.V = null;
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setBufferTimeout(int i) {
        this.ad = i;
    }

    public void setCTALayoutVisibleOrGone() {
        android.widget.FrameLayout frameLayout;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null && cVar.j() && (frameLayout = this.Q) != null && this.T >= -1) {
            com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView = this.R;
            if (anythinkClickCTAView == null && frameLayout != null) {
                if (anythinkClickCTAView == null) {
                    com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView2 = new com.anythink.expressad.video.module.AnythinkClickCTAView(getContext());
                    this.R = anythinkClickCTAView2;
                    anythinkClickCTAView2.setCampaign(this.b);
                    this.R.setUnitId(this.ai);
                    com.anythink.expressad.video.module.a.a aVar = this.V;
                    if (aVar != null) {
                        this.R.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(aVar));
                    }
                    this.R.preLoadData(this.S);
                }
                this.Q.addView(this.R);
            }
            int i = this.T;
            if (i >= 0) {
                this.Q.setVisibility(0);
                return;
            }
            if (i == -1) {
                if (this.Q.getVisibility() != 0) {
                    this.Q.setVisibility(0);
                    postDelayed(this.aO, 3000L);
                } else {
                    this.Q.setVisibility(8);
                    getHandler().removeCallbacks(this.aO);
                }
            }
        }
    }

    public void setCamPlayOrderCallback(com.anythink.expressad.video.dynview.f.a aVar, java.util.List<com.anythink.expressad.foundation.d.c> list, int i, int i2) {
        com.anythink.expressad.video.dynview.widget.ATSegmentsProgressBar aTSegmentsProgressBar;
        this.O = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i;
        this.P = i2;
        this.mCampOrderViewData = list;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || cVar.k() != 5 || (aTSegmentsProgressBar = this.N) == null || this.mCampOrderViewData == null) {
            return;
        }
        if (this.mCampaignSize <= 1) {
            aTSegmentsProgressBar.setVisibility(8);
            return;
        }
        aTSegmentsProgressBar.setVisibility(0);
        this.N.init(this.mCampaignSize, 2);
        for (int i3 = 0; i3 < this.mCampOrderViewData.size(); i3++) {
            int aF = this.mCampOrderViewData.get(i3).aF();
            if (aF > 0) {
                this.N.setProgress(aF, i3);
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        super.setCampaign(cVar);
        com.anythink.expressad.video.module.AnythinkVideoView.b bVar = this.aM;
        if (bVar != null) {
            bVar.a(cVar);
            this.aM.a(cVar != null ? cVar.ao() != -1 ? cVar.ao() : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ai, false).v() : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ai, false).v(), com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ai, false).x());
        }
    }

    public void setCloseAlert(int i) {
        this.ae = i;
    }

    public void setContainerViewOnNotifyListener(com.anythink.expressad.video.module.a.a aVar) {
        this.V = aVar;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setCover(boolean z2) {
        if (this.f) {
            this.E.setIsCovered(z2);
        }
    }

    public void setDialogRole(int i) {
        this.aF = i == 1;
    }

    public void setIVRewardEnable(int i, int i2, int i3) {
        this.az = i;
        this.aA = i2;
        this.aB = i3;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setInstallDialogState(boolean z2) {
        this.aa = z2;
        this.E.setIsCovered(z2);
    }

    public void setIsIV(boolean z2) {
        this.av = z2;
        com.anythink.expressad.video.module.AnythinkVideoView.b bVar = this.aM;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setMiniEndCardState(boolean z2) {
        this.ao = z2;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        android.widget.RelativeLayout relativeLayout;
        try {
            java.lang.String.format("%1s-%2s-%3s-%4s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) getLayoutParams();
            if (!(java.lang.Math.max(java.lang.Math.max(layoutParams.leftMargin, layoutParams.rightMargin), java.lang.Math.max(layoutParams.topMargin, layoutParams.bottomMargin)) > java.lang.Math.max(java.lang.Math.max(i, i2), java.lang.Math.max(i3, i4))) && (relativeLayout = this.I) != null) {
                relativeLayout.postDelayed(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass12(i, i3, i2, i4), 200L);
            }
            if (this.G.getVisibility() == 0) {
                n();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setPlayURL(java.lang.String str) {
        this.ab = str;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setScaleFitXY(int i) {
        this.au = i;
    }

    public void setShowingAlertViewCover(boolean z2) {
        this.E.setIsCovered(z2);
    }

    public void setShowingTransparent(boolean z2) {
        this.at = z2;
    }

    public void setSoundState(int i) {
        this.ax = i;
    }

    public void setTempEventListener(com.anythink.expressad.reward.player.c cVar) {
        this.n = cVar;
    }

    public void setUnitId(java.lang.String str) {
        this.ai = str;
        com.anythink.expressad.video.module.AnythinkVideoView.b bVar = this.aM;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void setVideoLayout(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            this.b = cVar;
            this.i = cVar.j();
        }
        if (this.i) {
            new com.anythink.expressad.video.dynview.j.c();
            com.anythink.expressad.video.dynview.c a2 = com.anythink.expressad.video.dynview.j.c.a(this, cVar);
            com.anythink.expressad.video.dynview.b.a();
            com.anythink.expressad.video.dynview.b.a(a2, new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass1(this, a2));
            return;
        }
        int findLayout = findLayout(t);
        if (findLayout > 0) {
            this.c.inflate(findLayout, this);
            b();
        }
        aw = false;
    }

    public void setVideoSkipTime(int i) {
        this.ac = i;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setVisible(int i) {
        setVisibility(i);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showAlertView() {
        if (this.ao) {
            return;
        }
        if (this.ah == null) {
            this.ah = new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass9();
        }
        if (this.ag == null) {
            this.ag = new com.anythink.expressad.widget.a.a(getContext(), this.ah);
        }
        if (this.av) {
            this.ag.a(this.az, this.ai);
        } else {
            this.ag.b();
        }
        com.anythink.expressad.playercommon.PlayerView playerView = this.E;
        if (playerView == null || playerView.isComplete()) {
            return;
        }
        this.ag.show();
        this.aC = true;
        this.W = true;
        setShowingAlertViewCover(true);
        com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.ai, false);
        this.ay = com.anythink.expressad.videocommon.e.d.J();
    }

    public void showBaitClickView() {
        int parseInt;
        com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView anythinkBaitClickView;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.j() || this.b.M() == null) {
            return;
        }
        java.lang.String e = this.b.M().e();
        if (android.text.TextUtils.isEmpty(e)) {
            return;
        }
        try {
            java.lang.String a2 = com.anythink.expressad.foundation.h.x.a(e, "bait_click");
            if (android.text.TextUtils.isEmpty(a2) || (parseInt = java.lang.Integer.parseInt(a2)) == 0 || (anythinkBaitClickView = this.aL) == null) {
                return;
            }
            anythinkBaitClickView.setVisibility(0);
            this.aL.init(parseInt);
            this.aL.startAnimation();
            this.aL.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoView.AnonymousClass4());
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showIVRewardAlertView(java.lang.String str) {
        this.e.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || this.U == null || !cVar.j() || this.b.M() == null) {
            return;
        }
        android.text.TextUtils.isEmpty(this.b.M().e());
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        float f;
        if (this.f) {
            this.I.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.I.getVisibility() != 0) {
                this.I.setVisibility(0);
            }
            if (this.G.getVisibility() == 0) {
                n();
            }
            if (!(i3 > 0 && i4 > 0 && com.anythink.expressad.foundation.h.t.f(this.a) >= i3 && com.anythink.expressad.foundation.h.t.e(this.a) >= i4) || this.al) {
                l();
                return;
            }
            z = i6;
            A = i7;
            B = i8 + 4;
            C = i9 + 4;
            float f2 = i3 / i4;
            try {
                f = (float) (this.aj / this.ak);
            } catch (java.lang.Throwable th) {
                th.getMessage();
                f = 0.0f;
            }
            if (i5 > 0) {
                y = i5;
                if (i5 > 0) {
                    android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
                    gradientDrawable.setCornerRadius(com.anythink.expressad.foundation.h.t.b(getContext(), i5));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    setBackground(gradientDrawable);
                    this.E.setBackground(gradientDrawable);
                    setClipToOutline(true);
                    this.E.setClipToOutline(true);
                }
            }
            if (java.lang.Math.abs(f2 - f) > 0.1f && this.au != 1) {
                l();
                videoOperate(1);
                return;
            }
            l();
            if (!this.at) {
                setLayoutParam(i2, i, i3, i4);
                return;
            }
            setLayoutCenter(i3, i4);
            if (aw) {
                this.e.a(114, "");
            } else {
                this.e.a(116, "");
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.j
    public void soundOperate(int i, int i2) {
        soundOperate(i, i2, "2");
    }

    @Override // com.anythink.expressad.video.signal.j
    public void soundOperate(int i, int i2, java.lang.String str) {
        com.anythink.expressad.video.module.a.a aVar;
        com.anythink.expressad.video.widget.SoundImageView soundImageView;
        if (this.f) {
            this.ax = i;
            if (i == 1) {
                com.anythink.expressad.video.widget.SoundImageView soundImageView2 = this.F;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.E.closeSound();
            } else if (i == 2) {
                com.anythink.expressad.video.widget.SoundImageView soundImageView3 = this.F;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.E.openSound();
            }
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar != null && cVar.j()) {
                com.anythink.expressad.video.widget.SoundImageView soundImageView4 = this.F;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i2 == 1) {
                com.anythink.expressad.video.widget.SoundImageView soundImageView5 = this.F;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i2 == 2 && (soundImageView = this.F) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str == null || !str.equals("2") || (aVar = this.e) == null) {
            return;
        }
        aVar.a(7, java.lang.Integer.valueOf(i));
    }

    @Override // com.anythink.expressad.video.signal.j
    public void videoOperate(int i) {
        if (this.f) {
            if (i == 1) {
                if (getVisibility() != 0 || !isfront() || this.W || this.ao || this.aa || com.anythink.expressad.foundation.f.b.c) {
                    return;
                }
                i();
                return;
            }
            if (i == 2) {
                if (getVisibility() == 0) {
                    h();
                    return;
                }
                return;
            }
            if (i == 3) {
                if (this.an) {
                    return;
                }
                this.E.release();
                this.an = true;
                return;
            }
            if (i == 5) {
                this.aa = true;
                if (this.an) {
                    return;
                }
                h();
                return;
            }
            if (i == 4) {
                this.aa = false;
                if (this.an || isMiniCardShowing()) {
                    return;
                }
                i();
            }
        }
    }
}
