package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0002R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/FDetailLiveVerticalLayout;", "Landroid/widget/LinearLayout;", "Lmoji/com/mjweatherservicebase/detail/DetailLiveViewPresenter$SakuraDetailLiveView;", "", "onFinishInflate", "", "flowerType", "loadSpotPicture", "showEmpty", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "", "", "result", "loadPicture", "a", "Lmoji/com/mjweatherservicebase/detail/DetailLiveViewPresenter;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjweatherservicebase/detail/DetailLiveViewPresenter;", "mDetailLiveViewPresenter", "Landroidx/recyclerview/widget/RecyclerView;", "t", "Landroidx/recyclerview/widget/RecyclerView;", "mSakuraDetailRecyclerView", "Lmoji/com/mjweatherservicebase/detail/RflowersDetailScenePicAdapter;", com.umeng.analytics.pro.bo.aN, "Lmoji/com/mjweatherservicebase/detail/RflowersDetailScenePicAdapter;", "mSakuraDetailScenePicAdapter", "v", "I", "mFlowerType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class FDetailLiveVerticalLayout extends android.widget.LinearLayout implements moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter mDetailLiveViewPresenter;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public androidx.recyclerview.widget.RecyclerView mSakuraDetailRecyclerView;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter mSakuraDetailScenePicAdapter;

    /* renamed from: v, reason: from kotlin metadata */
    public int mFlowerType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public FDetailLiveVerticalLayout(@org.jetbrains.annotations.NotNull android.content.Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public FDetailLiveVerticalLayout(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public FDetailLiveVerticalLayout(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        android.view.LayoutInflater.from(context).inflate(moji.com.mjweatherservicebase.R.layout.flowers_detail_live_vertical_view, (android.view.ViewGroup) this, true);
    }

    public /* synthetic */ FDetailLiveVerticalLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a() {
        this.mSakuraDetailRecyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(moji.com.mjweatherservicebase.R.id.detail_vertical_recycler_view);
    }

    @Override // moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView
    @org.jetbrains.annotations.NotNull
    public androidx.fragment.app.FragmentActivity getActivity() {
        android.content.Context context = getContext();
        if (context != null) {
            return (androidx.fragment.app.FragmentActivity) context;
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView
    public void loadPicture(@org.jetbrains.annotations.NotNull java.util.List<java.lang.String> result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter rflowersDetailScenePicAdapter = this.mSakuraDetailScenePicAdapter;
        kotlin.jvm.internal.Intrinsics.checkNotNull(rflowersDetailScenePicAdapter);
        rflowersDetailScenePicAdapter.fillDate$MJWeatherServiceBase_release(result, this.mFlowerType);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mSakuraDetailRecyclerView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(0);
    }

    public final void loadSpotPicture(int flowerType) {
        this.mFlowerType = flowerType;
        moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter detailLiveViewPresenter = this.mDetailLiveViewPresenter;
        kotlin.jvm.internal.Intrinsics.checkNotNull(detailLiveViewPresenter);
        detailLiveViewPresenter.load();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
        this.mDetailLiveViewPresenter = new moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter(this);
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mSakuraDetailRecyclerView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.mSakuraDetailRecyclerView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setNestedScrollingEnabled(false);
        this.mSakuraDetailScenePicAdapter = new moji.com.mjweatherservicebase.detail.RflowersDetailScenePicAdapter(new java.util.ArrayList());
        androidx.recyclerview.widget.RecyclerView recyclerView3 = this.mSakuraDetailRecyclerView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setAdapter(this.mSakuraDetailScenePicAdapter);
    }

    @Override // moji.com.mjweatherservicebase.detail.DetailLiveViewPresenter.SakuraDetailLiveView
    public void showEmpty() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mSakuraDetailRecyclerView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(8);
    }
}
