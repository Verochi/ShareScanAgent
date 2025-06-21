package com.anythink.expressad.video.bt.module;

/* loaded from: classes12.dex */
public abstract class BTBaseView extends android.widget.FrameLayout {
    public static final java.lang.String TAG = "BTBaseView";
    protected static int n = 0;
    protected static int o = 1;
    private static final int p = -999;
    protected android.content.Context a;
    protected com.anythink.expressad.foundation.d.c b;
    protected java.lang.String c;
    protected java.lang.String d;
    protected com.anythink.expressad.videocommon.e.d e;
    protected android.view.LayoutInflater f;
    protected int g;
    protected boolean h;
    protected float i;
    protected float j;
    protected android.graphics.Rect k;
    protected int l;
    protected int m;

    public BTBaseView(android.content.Context context) {
        this(context, null);
    }

    public BTBaseView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = "";
        this.g = 1;
        this.h = false;
        this.a = context;
        this.f = android.view.LayoutInflater.from(context);
        init(context);
    }

    public static void a(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", n);
            jSONObject.put("id", str2);
            jSONObject.put("data", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(webView, str, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(webView, e.getMessage());
            e.getMessage();
        }
    }

    private java.lang.String b() {
        return a(0).toString();
    }

    public final org.json.JSONObject a(int i) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject = new org.json.JSONObject();
        } catch (org.json.JSONException e) {
            e = e;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.cc, com.anythink.expressad.foundation.h.t.a(com.anythink.expressad.foundation.b.a.b().d(), this.i));
            jSONObject.put(com.anythink.expressad.foundation.g.a.cd, com.anythink.expressad.foundation.h.t.a(com.anythink.expressad.foundation.b.a.b().d(), this.j));
            jSONObject.put(com.anythink.expressad.foundation.g.a.cf, i);
            try {
                this.g = getContext().getResources().getConfiguration().orientation;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            jSONObject.put(com.anythink.expressad.foundation.g.a.cg, this.g);
            jSONObject.put(com.anythink.expressad.foundation.g.a.ch, com.anythink.expressad.foundation.h.t.c(getContext()));
            return jSONObject;
        } catch (org.json.JSONException e3) {
            e = e3;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    public void a() {
    }

    public void defaultShow() {
    }

    public int findColor(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(this.a.getApplicationContext(), str, "color");
    }

    public int findDrawable(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(this.a.getApplicationContext(), str, com.anythink.expressad.foundation.h.i.c);
    }

    public int findID(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(this.a.getApplicationContext(), str, "id");
    }

    public int findLayout(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(this.a.getApplicationContext(), str, "layout");
    }

    public com.anythink.expressad.foundation.d.c getCampaign() {
        return this.b;
    }

    public java.lang.String getInstanceId() {
        return this.d;
    }

    public android.widget.FrameLayout.LayoutParams getParentFrameLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof android.widget.FrameLayout.LayoutParams) {
            return (android.widget.FrameLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public android.widget.LinearLayout.LayoutParams getParentLinearLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            return (android.widget.LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public android.widget.RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
            return (android.widget.RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public android.graphics.Rect getRect() {
        return this.k;
    }

    public java.lang.String getUnitId() {
        return this.c;
    }

    public int getViewHeight() {
        return this.m;
    }

    public int getViewWidth() {
        return this.l;
    }

    public abstract void init(android.content.Context context);

    public boolean isLandscape() {
        return this.a.getResources().getConfiguration().orientation == 2;
    }

    public boolean isNotNULL(android.view.View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            if (viewArr[i] == null) {
                return false;
            }
            i++;
            z = true;
        }
        return z;
    }

    @Override // android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        this.g = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public abstract void onDestory();

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        this.i = motionEvent.getRawX();
        this.j = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(android.content.res.Configuration configuration) {
        this.g = configuration.orientation;
    }

    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        this.b = cVar;
    }

    public void setInstanceId(java.lang.String str) {
        this.d = str;
    }

    public void setLayout(int i, int i2) {
        this.l = i;
        this.m = i2;
    }

    public void setLayoutCenter(int i, int i2) {
        android.widget.FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        android.widget.RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        android.widget.LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i != -999) {
                parentRelativeLayoutParams.width = i;
            }
            if (i2 != -999) {
                parentRelativeLayoutParams.height = i2;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i != -999) {
                parentLinearLayoutParams.width = i;
            }
            if (i2 != -999) {
                parentLinearLayoutParams.height = i2;
            }
            setLayoutParams(parentLinearLayoutParams);
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.gravity = 17;
            if (i != -999) {
                parentFrameLayoutParams.width = i;
            }
            if (i2 != -999) {
                parentFrameLayoutParams.height = i2;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setLayoutParam(int i, int i2, int i3, int i4) {
        android.widget.FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        android.widget.RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        android.widget.LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i2;
            parentRelativeLayoutParams.leftMargin = i;
            if (i3 != -999) {
                parentRelativeLayoutParams.width = i3;
            }
            if (i4 != -999) {
                parentRelativeLayoutParams.height = i4;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i2;
            parentLinearLayoutParams.leftMargin = i;
            if (i3 != -999) {
                parentLinearLayoutParams.width = i3;
            }
            if (i4 != -999) {
                parentLinearLayoutParams.height = i4;
            }
            setLayoutParams(parentLinearLayoutParams);
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.topMargin = i2;
            parentFrameLayoutParams.leftMargin = i;
            if (i3 != -999) {
                parentFrameLayoutParams.width = i3;
            }
            if (i4 != -999) {
                parentFrameLayoutParams.height = i4;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setMatchParent() {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setRect(android.graphics.Rect rect) {
        this.k = rect;
    }

    public void setRewardUnitSetting(com.anythink.expressad.videocommon.e.d dVar) {
        this.e = dVar;
    }

    public void setUnitId(java.lang.String str) {
        this.c = str;
    }

    public void setWrapContent() {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        } else {
            layoutParams.height = -2;
            layoutParams.width = -2;
        }
    }
}
