package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u0017\b\u0000\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J'\u0010\u0013\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/RflowersDetailScenePicAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmoji/com/mjweatherservicebase/detail/RflowersDetailScenePicAdapter$ImgViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "holder", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "", "onBindViewHolder", "getItemCount", "", "", "attractionPicList", "flowerType", "fillDate$MJWeatherServiceBase_release", "(Ljava/util/List;I)V", "fillDate", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/List;", "mPicList", "t", "I", "mFlowerType", "<init>", "(Ljava/util/List;)V", "ImgViewHolder", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class RflowersDetailScenePicAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter.ImgViewHolder> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> mPicList;

    /* renamed from: t, reason: from kotlin metadata */
    public int mFlowerType;

    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/RflowersDetailScenePicAdapter$ImgViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroid/widget/ImageView;", "getMImageView", "()Landroid/widget/ImageView;", "mImageView", "Landroid/view/View;", "itemView", "<init>", "(Lmoji/com/mjweatherservicebase/detail/RflowersDetailScenePicAdapter;Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
    public final class ImgViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView mImageView;
        public final /* synthetic */ moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImgViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter rflowersDetailScenePicAdapter, android.view.View itemView) {
            super(itemView);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.t = rflowersDetailScenePicAdapter;
            android.view.View findViewById = itemView.findViewById(moji.com.mjweatherservicebase.R.id.scene_image);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.scene_image)");
            this.mImageView = (android.widget.ImageView) findViewById;
        }

        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getMImageView() {
            return this.mImageView;
        }
    }

    public RflowersDetailScenePicAdapter(@org.jetbrains.annotations.NotNull java.util.List<java.lang.String> mPicList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mPicList, "mPicList");
        this.mPicList = mPicList;
        this.mFlowerType = 12;
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void b(moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter this$0, int i, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.moji.router.MJRouter.getInstance().build("image/preview").withString("URL", this$0.mPicList.get(i)).start();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void fillDate$MJWeatherServiceBase_release(@org.jetbrains.annotations.Nullable java.util.List<java.lang.String> attractionPicList, int flowerType) {
        this.mFlowerType = flowerType;
        this.mPicList.clear();
        if (attractionPicList != null) {
            this.mPicList.addAll(attractionPicList);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mPicList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter.ImgViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        com.bumptech.glide.Glide.with(holder.getMImageView()).load(this.mPicList.get(position)).placeholder(moji.com.mjweatherservicebase.R.drawable.zaker_ad_default_image).into(holder.getMImageView());
        holder.getMImageView().setOnClickListener(new defpackage.gc2(this, position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @org.jetbrains.annotations.NotNull
    public moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter.ImgViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        int i = this.mFlowerType;
        android.view.View inflate = i == 12 ? android.view.LayoutInflater.from(parent.getContext()).inflate(moji.com.mjweatherservicebase.R.layout.flowers_item_pic, parent, false) : i == 45 ? android.view.LayoutInflater.from(parent.getContext()).inflate(moji.com.mjweatherservicebase.R.layout.flowers_vertical_item_pic, parent, false) : null;
        kotlin.jvm.internal.Intrinsics.checkNotNull(inflate);
        return new moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter.ImgViewHolder(this, inflate);
    }
}
