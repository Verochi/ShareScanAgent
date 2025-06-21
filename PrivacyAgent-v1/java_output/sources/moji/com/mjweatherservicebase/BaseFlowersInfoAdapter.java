package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u0001:\b`abcdefgB\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b^\u0010_J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nJ\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u001e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R#\u0010(\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R&\u00100\u001a\u0012\u0012\u0004\u0012\u00020\n0,j\b\u0012\u0004\u0012\u00020\n`-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0017\u0010=\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010K\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00106\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u00106R\u0016\u0010O\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u00106R\u0016\u0010Q\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u00106R\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020S0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u00106R\u0016\u0010Z\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u00106R\u0016\u0010[\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010NR\u0016\u0010]\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010N¨\u0006h"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lmoji/com/mjweatherservicebase/card/ShareCallback;", "callback", "", "getMapBits", "Landroidx/recyclerview/widget/LinearLayoutManager;", "manager", "recordRank", "", "type", "getHolderByType", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "holder", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "onBindViewHolder", "Lmoji/com/mjweatherservicebase/BaseFlowersPageInfo;", "t", "flower_type", "update", "getItemViewType", "getItemCount", "cityId", "", "lat", com.anythink.core.common.h.c.C, "setCityId", "Lmoji/com/mjweatherservicebase/BaseHomePageActivity;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjweatherservicebase/BaseHomePageActivity;", "context", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getMInflater", "()Landroid/view/LayoutInflater;", "mInflater", com.umeng.analytics.pro.bo.aN, "Lmoji/com/mjweatherservicebase/BaseFlowersPageInfo;", "mData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "v", "Ljava/util/ArrayList;", "typeList", "Lmoji/com/mjweatherservicebase/card/HomePageMapView;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lmoji/com/mjweatherservicebase/card/HomePageMapView;", "homePageMapView", "x", "I", "flowersType", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "y", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getOnScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollListener", "", com.umeng.analytics.pro.bo.aJ, "Z", "mNeedStatRank", "", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/Map;", "holderMap", "B", "getMMapPos", "()I", "setMMapPos", "(I)V", "mMapPos", "C", "mRankPos", "D", "mRegionPos", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "mFeedBackPos", "", "Lcom/moji/http/rapeflowers/RapeFlowersInfoResp$AreasBean;", "F", "Ljava/util/List;", "mList", "G", "mPos", "H", "mCityId", "mLat", "J", "mLon", "<init>", "(Lmoji/com/mjweatherservicebase/BaseHomePageActivity;)V", "Companion", "HomePageBannerHolder", "HomePageBestDateHolder", "HomePageFeedbackHolder", "HomePageHotSpotHolder", "HomePageMapHolder", "HomePageNearSpotHolder", "HomePageRegionHolder", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class BaseFlowersInfoAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    public static final int TYPE_AREA_LABEL = 5;
    public static final int TYPE_BANNER = 4;
    public static final int TYPE_BEST_DATE = 7;
    public static final int TYPE_FEEDBACK = 6;
    public static final int TYPE_HOT = 3;
    public static final int TYPE_MAP = 1;
    public static final int TYPE_NEARBY = 2;

    /* renamed from: A, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.Integer, androidx.recyclerview.widget.RecyclerView.ViewHolder> holderMap;

    /* renamed from: B, reason: from kotlin metadata */
    public int mMapPos;

    /* renamed from: C, reason: from kotlin metadata */
    public int mRankPos;

    /* renamed from: D, reason: from kotlin metadata */
    public int mRegionPos;

    /* renamed from: E, reason: from kotlin metadata */
    public int mFeedBackPos;

    /* renamed from: F, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean> mList;

    /* renamed from: G, reason: from kotlin metadata */
    public int mPos;

    /* renamed from: H, reason: from kotlin metadata */
    public int mCityId;

    /* renamed from: I, reason: from kotlin metadata */
    public double mLat;

    /* renamed from: J, reason: from kotlin metadata */
    public double mLon;

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjweatherservicebase.BaseHomePageActivity context;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mInflater;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public moji.com.mjweatherservicebase.BaseFlowersPageInfo mData;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.util.ArrayList<java.lang.Integer> typeList;

    /* renamed from: w, reason: from kotlin metadata */
    public moji.com.mjweatherservicebase.card.HomePageMapView homePageMapView;

    /* renamed from: x, reason: from kotlin metadata */
    public int flowersType;

    /* renamed from: y, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView.OnScrollListener onScrollListener;

    /* renamed from: z, reason: from kotlin metadata */
    public boolean mNeedStatRank;

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter$HomePageBannerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", com.anythink.expressad.a.B, "Landroid/view/View;", "(Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter;Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class HomePageBannerHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final /* synthetic */ moji.com.mjweatherservicebase.BaseFlowersInfoAdapter n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageBannerHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseFlowersInfoAdapter baseFlowersInfoAdapter, android.view.View view) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            this.n = baseFlowersInfoAdapter;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter$HomePageBestDateHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", com.anythink.expressad.a.B, "Landroid/view/View;", "(Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter;Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class HomePageBestDateHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final /* synthetic */ moji.com.mjweatherservicebase.BaseFlowersInfoAdapter n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageBestDateHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseFlowersInfoAdapter baseFlowersInfoAdapter, android.view.View view) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            this.n = baseFlowersInfoAdapter;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter$HomePageFeedbackHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", com.anythink.expressad.a.B, "Landroid/view/View;", "(Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter;Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class HomePageFeedbackHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final /* synthetic */ moji.com.mjweatherservicebase.BaseFlowersInfoAdapter n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageFeedbackHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseFlowersInfoAdapter baseFlowersInfoAdapter, android.view.View view) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            this.n = baseFlowersInfoAdapter;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter$HomePageHotSpotHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", com.anythink.expressad.a.B, "Landroid/view/View;", "(Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter;Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class HomePageHotSpotHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final /* synthetic */ moji.com.mjweatherservicebase.BaseFlowersInfoAdapter n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageHotSpotHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseFlowersInfoAdapter baseFlowersInfoAdapter, android.view.View view) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            this.n = baseFlowersInfoAdapter;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter$HomePageMapHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", com.anythink.expressad.a.B, "Landroid/view/View;", "(Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter;Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class HomePageMapHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final /* synthetic */ moji.com.mjweatherservicebase.BaseFlowersInfoAdapter n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageMapHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseFlowersInfoAdapter baseFlowersInfoAdapter, android.view.View view) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            this.n = baseFlowersInfoAdapter;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter$HomePageNearSpotHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", com.anythink.expressad.a.B, "Landroid/view/View;", "(Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter;Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class HomePageNearSpotHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final /* synthetic */ moji.com.mjweatherservicebase.BaseFlowersInfoAdapter n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageNearSpotHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseFlowersInfoAdapter baseFlowersInfoAdapter, android.view.View view) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            this.n = baseFlowersInfoAdapter;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter$HomePageRegionHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lmoji/com/mjweatherservicebase/card/HomePageRegionView;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjweatherservicebase/card/HomePageRegionView;", "getControl", "()Lmoji/com/mjweatherservicebase/card/HomePageRegionView;", "control", "Landroid/view/View;", com.anythink.expressad.a.B, "<init>", "(Lmoji/com/mjweatherservicebase/BaseFlowersInfoAdapter;Landroid/view/View;Lmoji/com/mjweatherservicebase/card/HomePageRegionView;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
    public final class HomePageRegionHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjweatherservicebase.card.HomePageRegionView control;
        public final /* synthetic */ moji.com.mjweatherservicebase.BaseFlowersInfoAdapter t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageRegionHolder(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseFlowersInfoAdapter baseFlowersInfoAdapter, @org.jetbrains.annotations.NotNull android.view.View view, moji.com.mjweatherservicebase.card.HomePageRegionView control) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(control, "control");
            this.t = baseFlowersInfoAdapter;
            this.control = control;
        }

        @org.jetbrains.annotations.NotNull
        public final moji.com.mjweatherservicebase.card.HomePageRegionView getControl() {
            return this.control;
        }
    }

    public BaseFlowersInfoAdapter(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseHomePageActivity context) {
        kotlin.Lazy lazy;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter$mInflater$2(this));
        this.mInflater = lazy;
        this.typeList = new java.util.ArrayList<>();
        this.flowersType = 12;
        this.onScrollListener = new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter$onScrollListener$1(this);
        this.mNeedStatRank = true;
        this.holderMap = new java.util.LinkedHashMap();
        this.mMapPos = 10;
        this.mRankPos = -2;
        this.mRegionPos = -2;
        this.mFeedBackPos = -2;
        this.mList = new java.util.ArrayList();
        this.mCityId = -1;
        this.mLat = -11111.0d;
        this.mLon = -11111.0d;
    }

    @org.jetbrains.annotations.Nullable
    public final androidx.recyclerview.widget.RecyclerView.ViewHolder getHolderByType(int type) {
        return this.holderMap.get(java.lang.Integer.valueOf(type));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mList.get(position).type;
    }

    public final android.view.LayoutInflater getMInflater() {
        return (android.view.LayoutInflater) this.mInflater.getValue();
    }

    public final int getMMapPos() {
        return this.mMapPos;
    }

    public final void getMapBits(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.card.ShareCallback callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        java.util.List<com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean> list = this.mList;
        boolean z = false;
        if (!(list instanceof java.util.Collection) || !list.isEmpty()) {
            java.util.Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean) it.next()).type == 1) {
                    z = true;
                    break;
                }
            }
        }
        moji.com.mjweatherservicebase.card.HomePageMapView homePageMapView = null;
        if (!z) {
            callback.onBack(null);
            return;
        }
        moji.com.mjweatherservicebase.card.HomePageMapView homePageMapView2 = this.homePageMapView;
        if (homePageMapView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("homePageMapView");
        } else {
            homePageMapView = homePageMapView2;
        }
        homePageMapView.getShareBitmap(callback);
    }

    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView.OnScrollListener getOnScrollListener() {
        return this.onScrollListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageRegionHolder) {
            ((moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageRegionHolder) holder).getControl().fillData(this.mList.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @org.jetbrains.annotations.NotNull
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        java.lang.String str;
        com.moji.http.rapeflowers.RapeFlowersInfoResp info;
        com.moji.http.rapeflowers.RapeFlowersInfoResp info2;
        androidx.recyclerview.widget.RecyclerView.ViewHolder homePageBannerHolder;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1:
                com.moji.base.MJActivity mJActivity = this.context;
                double d = this.mLat;
                double d2 = this.mLon;
                moji.com.mjweatherservicebase.BaseFlowersPageInfo baseFlowersPageInfo = this.mData;
                java.lang.String str2 = (baseFlowersPageInfo == null || (info = baseFlowersPageInfo.getInfo()) == null) ? null : info.map_pic;
                moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE.getFlowersMainPresenter();
                if (flowersMainPresenter == null || (str = flowersMainPresenter.getFlowerType()) == null) {
                    str = "0";
                }
                this.homePageMapView = new moji.com.mjweatherservicebase.card.HomePageMapView(mJActivity, d, d2, str2, str);
                moji.com.mjweatherservicebase.card.HomePageMapView homePageMapView = this.homePageMapView;
                if (homePageMapView == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("homePageMapView");
                    homePageMapView = null;
                }
                android.view.View createView = homePageMapView.createView();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createView, "homePageMapView.createView()");
                moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageMapHolder homePageMapHolder = new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageMapHolder(this, createView);
                moji.com.mjweatherservicebase.card.HomePageMapView homePageMapView2 = this.homePageMapView;
                if (homePageMapView2 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("homePageMapView");
                    homePageMapView2 = null;
                }
                moji.com.mjweatherservicebase.BaseFlowersPageInfo baseFlowersPageInfo2 = this.mData;
                homePageMapView2.fillData(baseFlowersPageInfo2 != null ? baseFlowersPageInfo2.getMap() : null);
                return homePageMapHolder;
            case 2:
                android.content.Context context = parent.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                moji.com.mjweatherservicebase.card.HomePageNearSpotView homePageNearSpotView = new moji.com.mjweatherservicebase.card.HomePageNearSpotView(context, this.mCityId, this.mLat, this.mLon);
                android.view.View createView2 = homePageNearSpotView.createView();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createView2, "nearestSpotView.createView()");
                moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageNearSpotHolder homePageNearSpotHolder = new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageNearSpotHolder(this, createView2);
                moji.com.mjweatherservicebase.BaseFlowersPageInfo baseFlowersPageInfo3 = this.mData;
                kotlin.jvm.internal.Intrinsics.checkNotNull(baseFlowersPageInfo3);
                homePageNearSpotView.fillData(baseFlowersPageInfo3.getInfo());
                this.holderMap.put(2, homePageNearSpotHolder);
                return homePageNearSpotHolder;
            case 3:
                android.content.Context context2 = parent.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                moji.com.mjweatherservicebase.card.HomePageHotSpotView homePageHotSpotView = new moji.com.mjweatherservicebase.card.HomePageHotSpotView(context2);
                android.view.View createView3 = homePageHotSpotView.createView();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createView3, "view.createView()");
                moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageHotSpotHolder homePageHotSpotHolder = new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageHotSpotHolder(this, createView3);
                moji.com.mjweatherservicebase.BaseFlowersPageInfo baseFlowersPageInfo4 = this.mData;
                if (baseFlowersPageInfo4 != null && (info2 = baseFlowersPageInfo4.getInfo()) != null) {
                    r1 = info2.ranks;
                }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
                homePageHotSpotView.fillData(r1);
                this.holderMap.put(3, homePageHotSpotHolder);
                return homePageHotSpotHolder;
            case 4:
                android.content.Context context3 = parent.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
                moji.com.mjweatherservicebase.BaseFlowersPageInfo baseFlowersPageInfo5 = this.mData;
                android.view.View createView4 = new moji.com.mjweatherservicebase.card.HomePageBannerView(context3, baseFlowersPageInfo5 != null ? baseFlowersPageInfo5.getBanner() : null).createView();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createView4, "HomePageBannerView(paren…ata?.banner).createView()");
                homePageBannerHolder = new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageBannerHolder(this, createView4);
                break;
            case 5:
                android.view.View inflate = getMInflater().inflate(moji.com.mjweatherservicebase.R.layout.layout_rflowers_area_label, parent, false);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "mInflater.inflate(R.layo…rea_label, parent, false)");
                homePageBannerHolder = new com.moji.base.EmptyHolder(inflate);
                break;
            case 6:
                moji.com.mjweatherservicebase.card.HomePageFeedbackView homePageFeedbackView = new moji.com.mjweatherservicebase.card.HomePageFeedbackView(this.context, this.mCityId);
                java.lang.String stringById = com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_feedback);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(stringById, "getStringById(R.string.rapeflowers_feedback)");
                homePageFeedbackView.setBtnText(stringById);
                android.view.View createView5 = homePageFeedbackView.createView();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createView5, "homePageFeedbackView.createView()");
                homePageBannerHolder = new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageFeedbackHolder(this, createView5);
                break;
            case 7:
                android.content.Context context4 = parent.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
                moji.com.mjweatherservicebase.card.HomePageBestDateView homePageBestDateView = new moji.com.mjweatherservicebase.card.HomePageBestDateView(context4);
                android.view.View createView6 = homePageBestDateView.createView();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createView6, "dateView.createView()");
                moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageBestDateHolder homePageBestDateHolder = new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageBestDateHolder(this, createView6);
                moji.com.mjweatherservicebase.BaseFlowersPageInfo baseFlowersPageInfo6 = this.mData;
                kotlin.jvm.internal.Intrinsics.checkNotNull(baseFlowersPageInfo6);
                homePageBestDateView.fillData(baseFlowersPageInfo6.getInfo());
                this.holderMap.put(7, homePageBestDateHolder);
                return homePageBestDateHolder;
            default:
                android.content.Context context5 = parent.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context5, "parent.context");
                moji.com.mjweatherservicebase.card.HomePageRegionView homePageRegionView = new moji.com.mjweatherservicebase.card.HomePageRegionView(context5, this.mLat, this.mLon);
                android.view.View createView7 = homePageRegionView.createView();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(createView7, "homePageRegionView.createView()");
                return new moji.com.mjweatherservicebase.BaseFlowersInfoAdapter.HomePageRegionHolder(this, createView7, homePageRegionView);
        }
        return homePageBannerHolder;
    }

    public final void recordRank(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.LinearLayoutManager manager) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(manager, "manager");
        int findLastVisibleItemPosition = manager.findLastVisibleItemPosition();
        int i = this.mRankPos;
        if ((1 <= i && i <= findLastVisibleItemPosition) && this.mNeedStatRank) {
            this.mNeedStatRank = false;
            moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE.getFlowersMainPresenter();
            if (flowersMainPresenter != null) {
                flowersMainPresenter.bannerShow();
            }
        }
    }

    public final void setCityId(int cityId, double lat, double lon) {
        this.mCityId = cityId;
        this.mLat = lat;
        this.mLon = lon;
    }

    public final void setMMapPos(int i) {
        this.mMapPos = i;
    }

    public final void update(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.BaseFlowersPageInfo t, int flower_type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "t");
        this.mList.clear();
        this.flowersType = flower_type;
        this.mData = t;
        java.util.ArrayList<java.lang.Integer> typeList = this.context.getFeatureCustom().getTypeList();
        kotlin.jvm.internal.Intrinsics.checkNotNull(typeList);
        this.typeList = typeList;
        if (typeList.contains(1) && t.getMap() != null) {
            moji.com.mjweatherservicebase.card.RFlowersMapInfo map = t.getMap();
            kotlin.jvm.internal.Intrinsics.checkNotNull(map);
            if (map.getMap() != null) {
                moji.com.mjweatherservicebase.card.RFlowersMapInfo map2 = t.getMap();
                kotlin.jvm.internal.Intrinsics.checkNotNull(map2);
                if (map2.getSuccess()) {
                    moji.com.mjweatherservicebase.card.RFlowersMapInfo map3 = t.getMap();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(map3);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(map3.getMap());
                    if (!r6.isEmpty()) {
                        com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean areasBean = new com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean();
                        areasBean.type = 1;
                        this.mList.add(areasBean);
                        this.mPos++;
                    }
                }
            }
        }
        if (this.typeList.contains(7) && t.getInfo() != null) {
            com.moji.http.rapeflowers.RapeFlowersInfoResp info = t.getInfo();
            kotlin.jvm.internal.Intrinsics.checkNotNull(info);
            if (info.list != null) {
                com.moji.http.rapeflowers.RapeFlowersInfoResp info2 = t.getInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(info2);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(info2.list, "t.info!!.list");
                if (!r6.isEmpty()) {
                    com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean areasBean2 = new com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean();
                    areasBean2.type = 7;
                    this.mList.add(areasBean2);
                    this.mPos++;
                }
            }
        }
        if (this.typeList.contains(2) && t.getInfo() != null) {
            com.moji.http.rapeflowers.RapeFlowersInfoResp info3 = t.getInfo();
            kotlin.jvm.internal.Intrinsics.checkNotNull(info3);
            if (info3.list != null) {
                com.moji.http.rapeflowers.RapeFlowersInfoResp info4 = t.getInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(info4);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(info4.list, "t.info!!.list");
                if (!r6.isEmpty()) {
                    com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean areasBean3 = new com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean();
                    areasBean3.type = 2;
                    this.mList.add(areasBean3);
                    this.mPos++;
                }
            }
        }
        if (this.typeList.contains(4) && t.getBanner() != null) {
            int i = this.mPos;
            this.mRankPos = i;
            this.mPos = i + 1;
            com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean areasBean4 = new com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean();
            areasBean4.type = 4;
            this.mList.add(areasBean4);
        }
        if (this.typeList.contains(3) && t.getInfo() != null) {
            com.moji.http.rapeflowers.RapeFlowersInfoResp info5 = t.getInfo();
            kotlin.jvm.internal.Intrinsics.checkNotNull(info5);
            if (info5.ranks != null) {
                com.moji.http.rapeflowers.RapeFlowersInfoResp info6 = t.getInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(info6);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(info6.ranks, "t.info!!.ranks");
                if (!r6.isEmpty()) {
                    com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean areasBean5 = new com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean();
                    areasBean5.type = 3;
                    this.mList.add(areasBean5);
                    this.mPos++;
                }
            }
        }
        if (this.typeList.contains(5) && t.getInfo() != null) {
            com.moji.http.rapeflowers.RapeFlowersInfoResp info7 = t.getInfo();
            kotlin.jvm.internal.Intrinsics.checkNotNull(info7);
            if (info7.areas != null) {
                com.moji.http.rapeflowers.RapeFlowersInfoResp info8 = t.getInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(info8);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(info8.areas, "t.info!!.areas");
                if (!r6.isEmpty()) {
                    this.mRegionPos = this.mPos;
                    com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean areasBean6 = new com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean();
                    areasBean6.type = 5;
                    this.mList.add(areasBean6);
                    int i2 = this.mPos;
                    com.moji.http.rapeflowers.RapeFlowersInfoResp info9 = t.getInfo();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(info9);
                    this.mPos = i2 + info9.areas.size();
                    java.util.List<com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean> list = this.mList;
                    com.moji.http.rapeflowers.RapeFlowersInfoResp info10 = t.getInfo();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(info10);
                    java.util.List list2 = info10.areas;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(list2);
                    list.addAll(list2);
                }
            }
        }
        if (this.typeList.contains(6)) {
            this.mFeedBackPos = this.mPos;
            com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean areasBean7 = new com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean();
            areasBean7.type = 6;
            this.mList.add(areasBean7);
        }
        notifyDataSetChanged();
    }
}
