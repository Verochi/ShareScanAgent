package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public abstract class AnythinkBaseView extends android.widget.RelativeLayout {
    public static final java.lang.String TAG = "AnythinkBaseView";
    private static final int n = -999;
    protected android.content.Context a;
    protected com.anythink.expressad.foundation.d.c b;
    protected android.view.LayoutInflater c;
    protected int d;
    protected com.anythink.expressad.video.module.a.a e;
    protected boolean f;
    protected float g;
    protected float h;
    protected boolean i;
    protected int j;
    protected boolean k;
    protected int l;
    protected int m;

    public AnythinkBaseView(android.content.Context context) {
        this(context, null);
    }

    public AnythinkBaseView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1;
        this.e = new com.anythink.expressad.video.module.a.a.f();
        this.f = false;
        this.l = 1;
        this.m = 0;
        this.a = context;
        this.c = android.view.LayoutInflater.from(context);
        init(context);
    }

    public AnythinkBaseView(android.content.Context context, android.util.AttributeSet attributeSet, boolean z, int i, boolean z2, int i2, int i3) {
        super(context, attributeSet);
        this.d = 1;
        this.e = new com.anythink.expressad.video.module.a.a.f();
        this.f = false;
        this.l = 1;
        this.m = 0;
        this.a = context;
        this.c = android.view.LayoutInflater.from(context);
        this.i = z;
        this.j = i;
        this.k = z2;
        this.l = i2;
        this.m = i3;
        init(context);
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
            jSONObject.put(com.anythink.expressad.foundation.g.a.cc, com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), this.g));
            jSONObject.put(com.anythink.expressad.foundation.g.a.cd, com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), this.h));
            jSONObject.put(com.anythink.expressad.foundation.g.a.cf, i);
            try {
                this.d = getContext().getResources().getConfiguration().orientation;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            jSONObject.put(com.anythink.expressad.foundation.g.a.cg, this.d);
            jSONObject.put(com.anythink.expressad.foundation.g.a.ch, com.anythink.expressad.foundation.h.t.c(getContext()));
            return jSONObject;
        } catch (org.json.JSONException e3) {
            e = e3;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    public void c() {
    }

    public final java.lang.String d() {
        return a(0).toString();
    }

    public void defaultShow() {
    }

    public int filterFindViewId(boolean z, java.lang.String str) {
        return z ? findDyID(str) : findID(str);
    }

    public int findColor(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(this.a.getApplicationContext(), str, "color");
    }

    public int findDrawable(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(this.a.getApplicationContext(), str, com.anythink.expressad.foundation.h.i.c);
    }

    public int findDyID(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
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
        this.d = configuration.orientation;
        super.onConfigurationChanged(configuration);
        new java.lang.StringBuilder("onConfigurationChanged:").append(configuration.orientation);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(android.content.res.Configuration configuration) {
        this.d = configuration.orientation;
        new java.lang.StringBuilder("onSelfConfigurationChanged:").append(configuration.orientation);
    }

    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        this.b = cVar;
    }

    public void setLayoutCenter(int i, int i2) {
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
        }
    }

    public void setLayoutParam(int i, int i2, int i3, int i4) {
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

    public void setNotifyListener(com.anythink.expressad.video.module.a.a aVar) {
        this.e = aVar;
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
