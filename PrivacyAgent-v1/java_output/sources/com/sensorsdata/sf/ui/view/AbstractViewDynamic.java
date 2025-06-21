package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
abstract class AbstractViewDynamic implements com.sensorsdata.sf.ui.view.IViewDynamic {
    int cornerRadius;
    int height;
    boolean isPORTRAIT = true;
    org.json.JSONObject mActionJson;
    android.content.Context mContext;
    protected org.json.JSONObject mLayoutJson;
    org.json.JSONObject mPropertyJson;
    java.lang.String mText;
    java.lang.String mType;
    protected org.json.JSONObject mUIJson;
    android.view.View mView;
    int width;

    public AbstractViewDynamic(android.content.Context context, org.json.JSONObject jSONObject) {
        this.mContext = context;
        this.mUIJson = jSONObject;
        if (jSONObject != null) {
            try {
                this.mLayoutJson = jSONObject.optJSONObject("layout");
                this.mPropertyJson = jSONObject.optJSONObject("properties");
                this.mActionJson = jSONObject.optJSONObject("action");
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        }
    }

    private void handleActions(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                org.json.JSONArray optJSONArray = jSONObject.optJSONArray(com.sensorsdata.sf.ui.view.UIProperty.action_android);
                if (optJSONArray != null) {
                    this.mActionJson = optJSONArray.getJSONObject(0);
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        }
    }

    public int align(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 1;
            case "left":
                return androidx.core.view.GravityCompat.START;
            case "right":
                return androidx.core.view.GravityCompat.END;
            default:
                return 17;
        }
    }

    public int color(org.json.JSONObject jSONObject) {
        try {
            return android.graphics.Color.argb((int) java.lang.Math.round(jSONObject.optDouble("a") * 255.0d), (int) jSONObject.optDouble("r"), (int) jSONObject.optDouble("g"), (int) jSONObject.optDouble("b"));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return 0;
        }
    }

    @Override // com.sensorsdata.sf.ui.view.IViewDynamic
    public android.view.View createView(android.app.Activity activity) {
        try {
            setViewConfig();
            return this.mView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public org.json.JSONObject getActionJson() {
        return this.mActionJson;
    }

    public java.lang.String getText() {
        return this.mText;
    }

    public java.lang.String getType() {
        return this.mType;
    }

    public android.view.View getView() {
        return this.mView;
    }

    public void layoutView(org.json.JSONObject jSONObject) {
        try {
            this.width = realSize(this.mContext, jSONObject.optString("width"));
            this.height = realSize(this.mContext, jSONObject.optString("height"));
            int align = align(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.align));
            if (this.width == 0) {
                this.width = -2;
            }
            if (this.height == 0) {
                this.height = -2;
            }
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(this.width, this.height);
            layoutParams.gravity = align;
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.margin);
            if (optJSONObject != null) {
                if (this.isPORTRAIT) {
                    layoutParams.setMargins(realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.left)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.top)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.right)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)));
                } else {
                    layoutParams.setMargins(realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.left)) / 2, realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.top)) / 2, realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.right)) / 2, realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)) / 2);
                }
            }
            this.mView.setLayoutParams(layoutParams);
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.padding);
            if (optJSONObject2 != null) {
                this.mView.setPadding(realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.left)), realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.top)), realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.right)), realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public int realFontSize(java.lang.String str) {
        try {
            return java.lang.Integer.parseInt(str.replace("px", ""));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return 15;
        }
    }

    public int realSize(android.content.Context context, java.lang.String str) {
        try {
            return com.sensorsdata.sf.ui.utils.SizeUtil.realSize(context, str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return 0;
        }
    }

    public void setBackground(android.content.Context context, org.json.JSONObject jSONObject) {
        try {
            this.cornerRadius = realSize(context, jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.cornerRadius));
            int realSize = realSize(context, jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.borderWidth));
            if (this.cornerRadius == 0 && realSize == 0) {
                if (jSONObject.has(com.sensorsdata.sf.ui.view.UIProperty.backgroundColor)) {
                    this.mView.setBackgroundColor(color(jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.backgroundColor)));
                    return;
                }
                return;
            }
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(this.cornerRadius);
            if (jSONObject.has(com.sensorsdata.sf.ui.view.UIProperty.backgroundColor)) {
                gradientDrawable.setColor(color(jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.backgroundColor)));
            }
            if (jSONObject.has(com.sensorsdata.sf.ui.view.UIProperty.borderColor)) {
                gradientDrawable.setStroke(realSize, color(jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.borderColor)));
            }
            this.mView.setBackground(gradientDrawable);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void setViewConfig() {
        android.view.View view = getView();
        if (view != null) {
            android.view.WindowManager windowManager = (android.view.WindowManager) this.mContext.getSystemService("window");
            if (windowManager != null) {
                int rotation = windowManager.getDefaultDisplay().getRotation();
                this.isPORTRAIT = rotation == 0 || rotation == 2;
            }
            layoutView(this.mLayoutJson);
            setViewProperty(this.mPropertyJson);
            handleActions(this.mActionJson);
            view.setTag(this);
        }
    }

    public abstract void setViewProperty(org.json.JSONObject jSONObject);

    public int visible(boolean z) {
        return z ? 8 : 0;
    }
}
