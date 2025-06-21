package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0018"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/RFlowerViewDivider;", "Landroid/widget/LinearLayout;", "", "onFinishInflate", "Landroid/widget/TextView;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroid/widget/TextView;", "mLeftTextView", "t", "mRightTextView", "", com.umeng.analytics.pro.bo.aN, "Ljava/lang/CharSequence;", "mLeftText", "v", "mRightText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class RFlowerViewDivider extends android.widget.LinearLayout {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public android.widget.TextView mLeftTextView;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public android.widget.TextView mRightTextView;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.CharSequence mLeftText;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.CharSequence mRightText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public RFlowerViewDivider(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public RFlowerViewDivider(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        android.view.LayoutInflater.from(getContext()).inflate(moji.com.mjweatherservicebase.R.layout.rflower_main_divider_item, this);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, moji.com.mjweatherservicebase.R.styleable.RFlowersViewDivider, i, moji.com.mjweatherservicebase.R.style.RFlowersViewDivider_Default);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…owersViewDivider_Default)");
        java.lang.CharSequence text = obtainStyledAttributes.getText(obtainStyledAttributes.getIndex(moji.com.mjweatherservicebase.R.styleable.RFlowersViewDivider_left_text));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(text, "typedArray.getText(typed…rsViewDivider_left_text))");
        this.mLeftText = text;
        java.lang.CharSequence text2 = obtainStyledAttributes.getText(obtainStyledAttributes.getIndex(moji.com.mjweatherservicebase.R.styleable.RFlowersViewDivider_right_text));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(text2, "typedArray.getText(typed…sViewDivider_right_text))");
        this.mRightText = text2;
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ RFlowerViewDivider(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        android.widget.TextView textView = (android.widget.TextView) findViewById(moji.com.mjweatherservicebase.R.id.sakura_title_text);
        this.mLeftTextView = textView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(textView);
        textView.getPaint().setFakeBoldText(true);
        this.mRightTextView = (android.widget.TextView) findViewById(moji.com.mjweatherservicebase.R.id.sakura_more_text);
        android.widget.TextView textView2 = this.mLeftTextView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(textView2);
        textView2.setText(this.mLeftText);
        android.widget.TextView textView3 = this.mRightTextView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(textView3);
        textView3.setText(this.mRightText);
    }
}
