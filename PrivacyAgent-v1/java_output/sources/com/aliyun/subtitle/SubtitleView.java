package com.aliyun.subtitle;

/* loaded from: classes.dex */
public class SubtitleView extends android.widget.RelativeLayout {
    public static final java.lang.String EXTRA_COLOR__STRING = "extra_color";
    public static final java.lang.String EXTRA_GRAVITY__ENUM = "extra_gravity";
    public static final java.lang.String EXTRA_LOCATION__INT = "extra_location";
    public static final java.lang.String EXTRA_SIZE_PX__INT = "extra_size_px";
    private static final java.lang.String TAG = "SubtitleView";
    private java.lang.String mDefaultColor;
    private int mDefaultLocation;
    private float mDefaultPercent;
    private int mDefaultSize;
    private java.util.Map<java.lang.String, android.widget.TextView> mSubtitleView;
    private com.aliyun.subtitle.TextViewPool mTextViewPool;

    public static class DefaultValueBuilder {
        int mLocation = 24;
        int mTextSize = -1;
        float mTextSizePercent = 0.08f;
        java.lang.String mTextColor = "#FFFFFFFF";

        public com.aliyun.subtitle.SubtitleView.DefaultValueBuilder setColor(java.lang.String str) {
            this.mTextColor = str;
            return this;
        }

        public com.aliyun.subtitle.SubtitleView.DefaultValueBuilder setLocation(int i) {
            this.mLocation = i;
            return this;
        }

        public com.aliyun.subtitle.SubtitleView.DefaultValueBuilder setSize(int i) {
            this.mTextSize = i;
            return this;
        }

        public com.aliyun.subtitle.SubtitleView.DefaultValueBuilder setSizePercent(float f) {
            this.mTextSizePercent = f;
            return this;
        }
    }

    public static class Subtitle {
        public java.lang.String content;
        public java.util.Map<java.lang.String, java.lang.Object> extraInfo;
        public java.lang.String id;
    }

    public SubtitleView(android.content.Context context) {
        super(context);
        this.mSubtitleView = new java.util.HashMap();
        init();
    }

    public SubtitleView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSubtitleView = new java.util.HashMap();
        init();
    }

    public SubtitleView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSubtitleView = new java.util.HashMap();
        init();
    }

    private android.widget.RelativeLayout.LayoutParams getFinalParam(com.aliyun.subtitle.SubtitleView.Subtitle subtitle) {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        com.aliyun.subtitle.LocationStyle.setLocation(layoutParams, subtitle.extraInfo, this.mDefaultLocation);
        return layoutParams;
    }

    private android.text.SpannableStringBuilder getFinalText(com.aliyun.subtitle.SubtitleView.Subtitle subtitle) {
        java.lang.String str;
        if (subtitle == null || (str = subtitle.content) == null) {
            return new android.text.SpannableStringBuilder("");
        }
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(android.text.Html.fromHtml(str.replace("\n", "<br>")));
        java.util.Map<java.lang.String, java.lang.Object> map = subtitle.extraInfo;
        com.aliyun.subtitle.TextSytle.setTextColor(spannableStringBuilder, map, this.mDefaultColor);
        com.aliyun.subtitle.TextSytle.setTextSize(spannableStringBuilder, map, this.mDefaultSize);
        return spannableStringBuilder;
    }

    private android.widget.TextView getFinalTextView(com.aliyun.subtitle.SubtitleView.Subtitle subtitle) {
        android.widget.TextView obtain = this.mTextViewPool.obtain();
        java.util.Map<java.lang.String, java.lang.Object> map = subtitle.extraInfo;
        if (map == null) {
            obtain.setGravity(17);
        } else {
            map.containsKey(EXTRA_GRAVITY__ENUM);
        }
        return obtain;
    }

    private void init() {
        this.mTextViewPool = new com.aliyun.subtitle.TextViewPool(getContext());
        setDefaultValue(new com.aliyun.subtitle.SubtitleView.DefaultValueBuilder());
    }

    public void dismiss(java.lang.String str) {
        this.mTextViewPool.recycle(this.mSubtitleView.remove(str));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i4 - i2;
        if (this.mDefaultSize > 0) {
            return;
        }
        float f = this.mDefaultPercent;
        if (f > 0.0f) {
            this.mDefaultSize = (int) (f * i5);
        }
        if (this.mDefaultSize <= 0) {
            this.mDefaultSize = 20;
        }
    }

    public void setDefaultValue(com.aliyun.subtitle.SubtitleView.DefaultValueBuilder defaultValueBuilder) {
        this.mDefaultLocation = defaultValueBuilder.mLocation;
        this.mDefaultPercent = defaultValueBuilder.mTextSizePercent;
        this.mDefaultSize = defaultValueBuilder.mTextSize;
        this.mDefaultColor = defaultValueBuilder.mTextColor;
    }

    public void show(com.aliyun.subtitle.SubtitleView.Subtitle subtitle) {
        android.text.SpannableStringBuilder finalText = getFinalText(subtitle);
        android.widget.RelativeLayout.LayoutParams finalParam = getFinalParam(subtitle);
        android.widget.TextView finalTextView = getFinalTextView(subtitle);
        finalTextView.setLayoutParams(finalParam);
        finalTextView.setText(finalText);
        android.view.ViewParent parent = finalTextView.getParent();
        if (parent != null) {
            ((android.view.ViewGroup) parent).removeView(finalTextView);
        }
        addView(finalTextView);
        this.mSubtitleView.put(subtitle.id, finalTextView);
    }
}
