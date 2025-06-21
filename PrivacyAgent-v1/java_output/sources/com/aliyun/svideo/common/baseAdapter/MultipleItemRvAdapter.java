package com.aliyun.svideo.common.baseAdapter;

/* loaded from: classes.dex */
public abstract class MultipleItemRvAdapter<T, V extends com.aliyun.svideo.common.baseAdapter.BaseViewHolder> extends com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter<T, V> {
    private android.util.SparseArray<com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider> mItemProviders;
    protected com.aliyun.svideo.common.baseAdapter.utils.ProviderDelegate mProviderDelegate;

    /* renamed from: com.aliyun.svideo.common.baseAdapter.MultipleItemRvAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideo.common.baseAdapter.delegate.MultiTypeDelegate<T> {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.common.baseAdapter.delegate.MultiTypeDelegate
        public int getItemType(T t) {
            return com.aliyun.svideo.common.baseAdapter.MultipleItemRvAdapter.this.getViewType(t);
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.MultipleItemRvAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.common.baseAdapter.BaseViewHolder val$helper;
        final /* synthetic */ java.lang.Object val$item;
        final /* synthetic */ int val$position;
        final /* synthetic */ com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider val$provider;

        public AnonymousClass2(com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider baseItemProvider, com.aliyun.svideo.common.baseAdapter.BaseViewHolder baseViewHolder, java.lang.Object obj, int i) {
            this.val$provider = baseItemProvider;
            this.val$helper = baseViewHolder;
            this.val$item = obj;
            this.val$position = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            this.val$provider.onClick(this.val$helper, this.val$item, this.val$position);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.MultipleItemRvAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnLongClickListener {
        final /* synthetic */ com.aliyun.svideo.common.baseAdapter.BaseViewHolder val$helper;
        final /* synthetic */ java.lang.Object val$item;
        final /* synthetic */ int val$position;
        final /* synthetic */ com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider val$provider;

        public AnonymousClass3(com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider baseItemProvider, com.aliyun.svideo.common.baseAdapter.BaseViewHolder baseViewHolder, java.lang.Object obj, int i) {
            this.val$provider = baseItemProvider;
            this.val$helper = baseViewHolder;
            this.val$item = obj;
            this.val$position = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(android.view.View view) {
            return this.val$provider.onLongClick(this.val$helper, this.val$item, this.val$position);
        }
    }

    public MultipleItemRvAdapter(@androidx.annotation.Nullable java.util.List<T> list) {
        super(list);
    }

    private void bindClick(V v, T t, int i, com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider baseItemProvider) {
        com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemClickListener onItemClickListener = getOnItemClickListener();
        com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        if (onItemClickListener == null || onItemLongClickListener == null) {
            android.view.View view = v.itemView;
            if (onItemClickListener == null) {
                view.setOnClickListener(new com.aliyun.svideo.common.baseAdapter.MultipleItemRvAdapter.AnonymousClass2(baseItemProvider, v, t, i));
            }
            if (onItemLongClickListener == null) {
                view.setOnLongClickListener(new com.aliyun.svideo.common.baseAdapter.MultipleItemRvAdapter.AnonymousClass3(baseItemProvider, v, t, i));
            }
        }
    }

    @Override // com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
    public void convert(V v, T t) {
        com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider baseItemProvider = this.mItemProviders.get(v.getItemViewType());
        baseItemProvider.mContext = v.itemView.getContext();
        int layoutPosition = v.getLayoutPosition() - getHeaderLayoutCount();
        baseItemProvider.convert(v, t, layoutPosition);
        bindClick(v, t, layoutPosition, baseItemProvider);
    }

    public void finishInitialize() {
        this.mProviderDelegate = new com.aliyun.svideo.common.baseAdapter.utils.ProviderDelegate();
        setMultiTypeDelegate(new com.aliyun.svideo.common.baseAdapter.MultipleItemRvAdapter.AnonymousClass1());
        registerItemProvider();
        this.mItemProviders = this.mProviderDelegate.getItemProviders();
        for (int i = 0; i < this.mItemProviders.size(); i++) {
            int keyAt = this.mItemProviders.keyAt(i);
            com.aliyun.svideo.common.baseAdapter.provider.BaseItemProvider baseItemProvider = this.mItemProviders.get(keyAt);
            baseItemProvider.mData = this.mData;
            getMultiTypeDelegate().registerItemType(keyAt, baseItemProvider.layout());
        }
    }

    public abstract int getViewType(T t);

    public abstract void registerItemProvider();
}
