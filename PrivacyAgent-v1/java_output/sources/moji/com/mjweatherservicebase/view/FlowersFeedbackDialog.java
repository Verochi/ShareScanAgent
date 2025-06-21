package moji.com.mjweatherservicebase.view;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0002R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Lmoji/com/mjweatherservicebase/view/FlowersFeedbackDialog;", "Lcom/moji/dialog/specific/MJSpecificDialog;", "", "getLayoutRes", "Landroid/view/View;", com.anythink.expressad.a.B, "", "initView", "", "getViewClick", "Lcom/moji/dialog/specific/MJSpecificDialog$OnViewClickListener;", "getOnClickListener", "b", "Lcom/moji/dialog/specific/CheckBoxView;", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/moji/dialog/specific/CheckBoxView;", "mCheckBoxView", "", "B", "Z", "mStatDismiss", "C", "I", "mSpotId", "D", "mCityId", "<init>", "()V", "Companion", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class FlowersFeedbackDialog extends com.moji.dialog.specific.MJSpecificDialog {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SPOT_ID = "spot_id";

    /* renamed from: A, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.moji.dialog.specific.CheckBoxView mCheckBoxView;

    /* renamed from: B, reason: from kotlin metadata */
    public boolean mStatDismiss = true;

    /* renamed from: C, reason: from kotlin metadata */
    public int mSpotId = -1;

    /* renamed from: D, reason: from kotlin metadata */
    public int mCityId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        android.os.Bundle arguments = getArguments();
        this.mSpotId = arguments != null ? arguments.getInt("spot_id", -1) : -1;
    }

    public int getLayoutRes() {
        return moji.com.mjweatherservicebase.R.layout.layout_mult_choice_dialog;
    }

    @org.jetbrains.annotations.Nullable
    public com.moji.dialog.specific.MJSpecificDialog.OnViewClickListener getOnClickListener() {
        return new moji.com.mjweatherservicebase.view.FlowersFeedbackDialog$getOnClickListener$1(this);
    }

    @org.jetbrains.annotations.NotNull
    public java.util.Set<java.lang.Integer> getViewClick() {
        java.util.Set<java.lang.Integer> mutableSetOf;
        mutableSetOf = kotlin.collections.SetsKt__SetsKt.mutableSetOf(java.lang.Integer.valueOf(moji.com.mjweatherservicebase.R.id.mUnderView), java.lang.Integer.valueOf(moji.com.mjweatherservicebase.R.id.mSendView));
        return mutableSetOf;
    }

    public void initView(@org.jetbrains.annotations.NotNull android.view.View view) {
        java.util.List mutableListOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        b();
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String[] strSnow = com.moji.tool.DeviceTool.getStringArray(moji.com.mjweatherservicebase.R.array.rapeflowers_state);
        java.lang.String stringById = com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_sqi);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(stringById, "getStringById(R.string.rapeflowers_sqi)");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSnow, "strSnow");
        hashMap.put(stringById, strSnow);
        int i = moji.com.mjweatherservicebase.R.id.mChoiceView;
        this.mCheckBoxView = view.findViewById(i);
        this.mCheckBoxView = view.findViewById(i);
        int i2 = moji.com.mjweatherservicebase.R.id.mSendView;
        android.view.View findViewById = view.findViewById(i2);
        com.moji.dialog.specific.CheckBoxView checkBoxView = this.mCheckBoxView;
        if (checkBoxView != null) {
            checkBoxView.setOnItemClickListener(new moji.com.mjweatherservicebase.view.FlowersFeedbackDialog$initView$1(this, findViewById));
        }
        mutableListOf = kotlin.collections.CollectionsKt__CollectionsKt.mutableListOf(hashMap);
        com.moji.dialog.specific.CheckBoxView checkBoxView2 = this.mCheckBoxView;
        if (checkBoxView2 != null) {
            checkBoxView2.setData(mutableListOf);
        }
        ((android.widget.TextView) view.findViewById(moji.com.mjweatherservicebase.R.id.mTipView)).setText(com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_consult));
        ((android.widget.TextView) view.findViewById(i2)).setText(com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_submmit));
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(moji.com.mjweatherservicebase.R.id.mUnderView);
        textView.setText(com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_unknown));
        textView.getPaint().setFlags(9);
        com.moji.imageview.FourCornerImageView findViewById2 = view.findViewById(moji.com.mjweatherservicebase.R.id.mImageView);
        findViewById2.setImageResource(moji.com.mjweatherservicebase.R.drawable.rflowers_feedback_top);
        findViewById2.setBackgroundResource(moji.com.mjweatherservicebase.R.drawable.mj_dialog_top_pic_mask);
    }
}
