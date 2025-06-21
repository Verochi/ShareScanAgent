package moji.com.mjwallet.list;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lmoji/com/mjwallet/list/PageAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "Landroidx/fragment/app/Fragment;", "getItem", "getCount", "", "getPageTitle", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/List;", "fragmentList", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class PageAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<androidx.fragment.app.Fragment> fragmentList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageAdapter(@org.jetbrains.annotations.NotNull androidx.fragment.app.FragmentManager fm2) {
        super(fm2);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fm2, "fm");
        this.fragmentList = new java.util.ArrayList();
        for (int i = 0; i < 3; i++) {
            this.fragmentList.add(moji.com.mjwallet.list.BillListFragment.INSTANCE.newInstance(i));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @org.jetbrains.annotations.NotNull
    public androidx.fragment.app.Fragment getItem(int position) {
        return this.fragmentList.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @org.jetbrains.annotations.Nullable
    public java.lang.CharSequence getPageTitle(int position) {
        return position != 0 ? position != 1 ? position != 2 ? "..." : com.moji.tool.AppDelegate.getAppContext().getString(moji.com.mjwallet.R.string.cash_extract_recore) : com.moji.tool.AppDelegate.getAppContext().getString(moji.com.mjwallet.R.string.recharge_record) : com.moji.tool.AppDelegate.getAppContext().getString(moji.com.mjwallet.R.string.all_record);
    }
}
