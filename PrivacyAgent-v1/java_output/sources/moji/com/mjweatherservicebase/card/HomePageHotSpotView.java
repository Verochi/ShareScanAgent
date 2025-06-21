package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u0004B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0014J\u0016\u0010\u000e\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0015R#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0019\u001a\n \u000f*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001e\u001a\n \u000f*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR#\u0010 \u001a\n \u000f*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u001f\u0010\u001dR#\u0010\"\u001a\n \u000f*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\u0010\u0010\u001dR#\u0010'\u001a\n \u000f*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lmoji/com/mjweatherservicebase/card/HomePageHotSpotView;", "Lcom/moji/viewcontrol/MJViewControl;", "", "Lcom/moji/http/rapeflowers/RapeFlowersSpotResp$ListBean;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", "onClick", "", "getResLayoutId", com.anythink.expressad.a.B, "onCreatedView", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "onBindViewData", "kotlin.jvm.PlatformType", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/Lazy;", "l", "()Landroid/view/View;", "mTopInfoView", "Landroid/widget/ImageView;", "t", "k", "()Landroid/widget/ImageView;", "mTopImageView", "Landroid/widget/TextView;", com.umeng.analytics.pro.bo.aN, com.anythink.expressad.d.a.b.dH, "()Landroid/widget/TextView;", "mTopName", "j", "mTopArea", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "mTopState", "Landroid/widget/LinearLayout;", "x", "i", "()Landroid/widget/LinearLayout;", "mItemContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class HomePageHotSpotView extends com.moji.viewcontrol.MJViewControl<java.util.List<com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean>> implements android.view.View.OnClickListener {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mTopInfoView;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mTopImageView;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mTopName;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mTopArea;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mTopState;

    /* renamed from: x, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mItemContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageHotSpotView(@org.jetbrains.annotations.NotNull android.content.Context context) {
        super(context);
        kotlin.Lazy lazy;
        kotlin.Lazy lazy2;
        kotlin.Lazy lazy3;
        kotlin.Lazy lazy4;
        kotlin.Lazy lazy5;
        kotlin.Lazy lazy6;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageHotSpotView$mTopInfoView$2(this));
        this.mTopInfoView = lazy;
        lazy2 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageHotSpotView$mTopImageView$2(this));
        this.mTopImageView = lazy2;
        lazy3 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageHotSpotView$mTopName$2(this));
        this.mTopName = lazy3;
        lazy4 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageHotSpotView$mTopArea$2(this));
        this.mTopArea = lazy4;
        lazy5 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageHotSpotView$mTopState$2(this));
        this.mTopState = lazy5;
        lazy6 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageHotSpotView$mItemContainer$2(this));
        this.mItemContainer = lazy6;
    }

    public int getResLayoutId() {
        return moji.com.mjweatherservicebase.R.layout.rflower_hot_attractions;
    }

    public final android.widget.LinearLayout i() {
        return (android.widget.LinearLayout) this.mItemContainer.getValue();
    }

    public final android.widget.TextView j() {
        return (android.widget.TextView) this.mTopArea.getValue();
    }

    public final android.widget.ImageView k() {
        return (android.widget.ImageView) this.mTopImageView.getValue();
    }

    public final android.view.View l() {
        return (android.view.View) this.mTopInfoView.getValue();
    }

    public final android.widget.TextView m() {
        return (android.widget.TextView) this.mTopName.getValue();
    }

    public final android.widget.TextView n() {
        return (android.widget.TextView) this.mTopState.getValue();
    }

    @android.annotation.SuppressLint({"SetTextI18n"})
    public void onBindViewData(@org.jetbrains.annotations.NotNull java.util.List<com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
        m().setText(list.get(0).spot_name);
        j().setText(list.get(0).province_name);
        n().setText("状态: " + list.get(0).spot_state);
        if (!android.text.TextUtils.isEmpty(list.get(0).spot_pic)) {
            com.moji.glide.util.ImageUtils.loadImage(k(), list.get(0).spot_pic, moji.com.mjweatherservicebase.R.drawable.flowers_item_placeholder);
        }
        k().setTag(java.lang.Integer.valueOf(list.get(0).spot_id));
        l().setTag(java.lang.Integer.valueOf(list.get(0).spot_id));
        if (list.size() <= 2) {
            i().setVisibility(0);
            return;
        }
        i().setVisibility(0);
        int size = list.size();
        int i = 0;
        while (i < 3 && i < size - 1) {
            android.view.View childAt = i().getChildAt(i);
            childAt.setVisibility(0);
            android.widget.ImageView imageView = (android.widget.ImageView) childAt.findViewById(moji.com.mjweatherservicebase.R.id.item_image);
            android.widget.TextView textView = (android.widget.TextView) childAt.findViewById(moji.com.mjweatherservicebase.R.id.item_text);
            i++;
            com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean listBean = list.get(i);
            if (!android.text.TextUtils.isEmpty(listBean.spot_pic)) {
                com.moji.glide.util.ImageUtils.loadImage(imageView, listBean.spot_pic, moji.com.mjweatherservicebase.R.drawable.flowers_item_placeholder);
            }
            imageView.setOnClickListener(this);
            imageView.setTag(java.lang.Integer.valueOf(listBean.spot_id));
            textView.setText(listBean.spot_name);
        }
        while (i < 3) {
            i().getChildAt(i).setVisibility(4);
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0035, code lost:
    
        if (r0.intValue() != r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002c  */
    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(@org.jetbrains.annotations.Nullable android.view.View v) {
        boolean z;
        moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter;
        java.lang.Object tag;
        java.lang.Integer valueOf = v != null ? java.lang.Integer.valueOf(v.getId()) : null;
        int i = moji.com.mjweatherservicebase.R.id.mTopImageView;
        boolean z2 = false;
        if (valueOf == null || valueOf.intValue() != i) {
            int i2 = moji.com.mjweatherservicebase.R.id.mTopInfoView;
            if (valueOf == null || valueOf.intValue() != i2) {
                z = false;
                if (!z) {
                    int i3 = moji.com.mjweatherservicebase.R.id.item_image;
                    if (valueOf != null) {
                    }
                    if (z2 && v.getTag() != null && (flowersMainPresenter = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE.getFlowersMainPresenter()) != null) {
                        tag = v.getTag();
                        if (tag != null) {
                            java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Int");
                            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
                            throw nullPointerException;
                        }
                        flowersMainPresenter.hotPhotoClick(((java.lang.Integer) tag).intValue());
                    }
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
                }
                z2 = true;
                if (z2) {
                    tag = v.getTag();
                    if (tag != null) {
                    }
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
            }
        }
        z = true;
        if (!z) {
        }
        z2 = true;
        if (z2) {
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
    }

    public void onCreatedView(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        l().setOnClickListener(this);
        k().setOnClickListener(this);
    }
}
