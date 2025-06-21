package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002*+B'\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0010\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006,"}, d2 = {"Lmoji/com/mjweatherservicebase/card/HomePageNearSpotAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmoji/com/mjweatherservicebase/card/HomePageNearSpotAdapter$RFlowersHoriNearHolder;", "holder", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "", "onBindViewHolder", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "getItemCount", "", "Lcom/moji/http/rapeflowers/RapeFlowersSpotResp$ListBean;", "data", "updateData", "", "d", "", "fmt", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "mCityId", "", "t", "D", "mLat", com.umeng.analytics.pro.bo.aN, "mLon", "v", "Ljava/util/List;", "mData", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;IDD)V", "Companion", "RFlowersHoriNearHolder", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class HomePageNearSpotAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter.RFlowersHoriNearHolder> {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String x = "HomePageNearSpotAdapter";

    /* renamed from: n, reason: from kotlin metadata */
    public final int mCityId;

    /* renamed from: t, reason: from kotlin metadata */
    public final double mLat;

    /* renamed from: u, reason: from kotlin metadata */
    public final double mLon;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean> mData;

    /* renamed from: w, reason: from kotlin metadata */
    public final android.view.LayoutInflater inflater;

    @kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u0011\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019¨\u0006\u001e"}, d2 = {"Lmoji/com/mjweatherservicebase/card/HomePageNearSpotAdapter$RFlowersHoriNearHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/moji/http/rapeflowers/RapeFlowersSpotResp$ListBean;", "spot", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "itemCount", "", "bindData", "Landroid/view/View;", "v", "onClick", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "getMCityId", "()I", "mCityId", "", "t", "D", "mLat", com.umeng.analytics.pro.bo.aN, "mLon", "Lmoji/com/mjweatherservicebase/databinding/RflowersItemHoriAreaBinding;", "Lmoji/com/mjweatherservicebase/databinding/RflowersItemHoriAreaBinding;", "binding", com.anythink.expressad.a.B, "<init>", "(Lmoji/com/mjweatherservicebase/card/HomePageNearSpotAdapter;Landroid/view/View;IDD)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
    public final class RFlowersHoriNearHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {

        /* renamed from: n, reason: from kotlin metadata */
        public final int mCityId;

        /* renamed from: t, reason: from kotlin metadata */
        public final double mLat;

        /* renamed from: u, reason: from kotlin metadata */
        public final double mLon;

        /* renamed from: v, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjweatherservicebase.databinding.RflowersItemHoriAreaBinding binding;
        public final /* synthetic */ moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RFlowersHoriNearHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter homePageNearSpotAdapter, android.view.View view, int i, double d, double d2) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            this.w = homePageNearSpotAdapter;
            this.mCityId = i;
            this.mLat = d;
            this.mLon = d2;
            moji.com.mjweatherservicebase.databinding.RflowersItemHoriAreaBinding bind = moji.com.mjweatherservicebase.databinding.RflowersItemHoriAreaBinding.bind(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
            this.binding = bind;
            view.setOnClickListener(this);
        }

        public final void bindData(@org.jetbrains.annotations.NotNull com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean spot, int position, int itemCount) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(spot, "spot");
            if (!android.text.TextUtils.isEmpty(spot.spot_pic)) {
                if (android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread()) {
                    com.moji.glide.util.ImageUtils.loadImage(this.binding.mImageView, spot.spot_pic, moji.com.mjweatherservicebase.R.drawable.flowers_item_placeholder);
                } else {
                    try {
                        android.graphics.Bitmap bitmap = com.bumptech.glide.Glide.with(com.moji.tool.AppDelegate.getAppContext()).asBitmap().load(spot.spot_pic).submit().get();
                        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                            this.binding.mImageView.setImageBitmap(bitmap);
                        }
                    } catch (java.lang.Exception e) {
                        com.moji.tool.log.MJLogger.e(moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter.x, e);
                    }
                }
            }
            android.widget.TextView textView = this.binding.mAreaView;
            java.lang.String str = spot.spot_name;
            if (str == null) {
                str = "--";
            }
            textView.setText(str);
            this.binding.mDistanceView.setText(com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_dist, new java.lang.Object[]{this.w.fmt(spot.distance)}));
            this.binding.getRoot().setTag(moji.com.mjweatherservicebase.R.id.mAreaView, java.lang.Integer.valueOf(spot.spot_id));
            if (position == itemCount - 1 && position >= 6) {
                moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE.getFlowersMainPresenter();
                kotlin.jvm.internal.Intrinsics.checkNotNull(flowersMainPresenter);
                if (flowersMainPresenter.needShowMoreView()) {
                    this.binding.getRoot().setTag(moji.com.mjweatherservicebase.R.id.mMoreView, 1);
                    this.binding.mMoreView.setVisibility(0);
                    return;
                }
            }
            this.binding.getRoot().setTag(moji.com.mjweatherservicebase.R.id.mMoreView, 0);
            this.binding.mMoreView.setVisibility(8);
        }

        public final int getMCityId() {
            return this.mCityId;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(@org.jetbrains.annotations.NotNull android.view.View v) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(v, "v");
            if (!com.moji.tool.Utils.canClick()) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
                return;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(v.getTag(moji.com.mjweatherservicebase.R.id.mMoreView), (java.lang.Object) 1)) {
                moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE.getFlowersMainPresenter();
                if (flowersMainPresenter != null) {
                    flowersMainPresenter.nearbyMoreClick(this.mCityId, true, this.mLat, this.mLon);
                }
            } else {
                java.lang.Object tag = v.getTag(moji.com.mjweatherservicebase.R.id.mAreaView);
                if (tag == null) {
                    java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
                    throw nullPointerException;
                }
                int intValue = ((java.lang.Integer) tag).intValue();
                moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter2 = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE.getFlowersMainPresenter();
                if (flowersMainPresenter2 != null) {
                    flowersMainPresenter2.nearPhotoClick(intValue);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
        }
    }

    public HomePageNearSpotAdapter(@org.jetbrains.annotations.NotNull android.content.Context context, int i, double d, double d2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.mCityId = i;
        this.mLat = d;
        this.mLon = d2;
        this.mData = new java.util.ArrayList();
        this.inflater = android.view.LayoutInflater.from(context);
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String fmt(float d) {
        java.lang.String format;
        int i = (int) d;
        if (d == ((float) i)) {
            kotlin.jvm.internal.StringCompanionObject stringCompanionObject = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
            format = java.lang.String.format(com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT, java.util.Arrays.copyOf(new java.lang.Object[]{java.lang.Integer.valueOf(i)}, 1));
        } else {
            kotlin.jvm.internal.StringCompanionObject stringCompanionObject2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
            format = java.lang.String.format("%s", java.util.Arrays.copyOf(new java.lang.Object[]{java.lang.Float.valueOf(d)}, 1));
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mData.isEmpty()) {
            return 0;
        }
        return java.lang.Math.min(this.mData.size(), 7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter.RFlowersHoriNearHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindData(this.mData.get(position), position, getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @org.jetbrains.annotations.NotNull
    public moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter.RFlowersHoriNearHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        android.view.View view = this.inflater.inflate(moji.com.mjweatherservicebase.R.layout.rflowers_item_hori_area, parent, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(view, "view");
        return new moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter.RFlowersHoriNearHolder(this, view, this.mCityId, this.mLat, this.mLon);
    }

    public final void updateData(@org.jetbrains.annotations.Nullable java.util.List<com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean> data) {
        java.util.List<com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean> list = this.mData;
        kotlin.jvm.internal.Intrinsics.checkNotNull(data);
        list.addAll(data);
        notifyDataSetChanged();
    }
}
