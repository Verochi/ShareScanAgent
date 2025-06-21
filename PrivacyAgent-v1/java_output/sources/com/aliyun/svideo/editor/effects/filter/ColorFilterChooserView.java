package com.aliyun.svideo.editor.effects.filter;

/* loaded from: classes12.dex */
public class ColorFilterChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements com.aliyun.svideo.editor.effects.control.OnItemClickListener, android.view.View.OnClickListener {
    private android.widget.ImageView mCancel;
    private android.widget.ImageView mComplete;
    private com.aliyun.svideo.editor.effects.filter.FilterAdapter mFilterAdapter;
    private android.widget.ImageView mIvEffectIcon;
    int mLastIndex;
    int mLastSaveIndex;
    com.aliyun.svideo.editor.effects.control.EffectInfo mLastSelectEffectInfo;
    private androidx.recyclerview.widget.RecyclerView mListView;
    private android.widget.TextView mTvEffectTitle;

    public ColorFilterChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ColorFilterChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorFilterChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.moji_editor_view_chooser_mv, this);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.effect_list_filter);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        if (this.mFilterAdapter == null) {
            com.aliyun.svideo.editor.effects.filter.FilterAdapter filterAdapter = new com.aliyun.svideo.editor.effects.filter.FilterAdapter(getContext());
            this.mFilterAdapter = filterAdapter;
            filterAdapter.setOnItemClickListener(this);
            this.mFilterAdapter.setDataList(com.aliyun.svideo.editor.util.EditorCommon.getColorFilterList(getContext()));
        }
        this.mListView.setAdapter(this.mFilterAdapter);
        this.mListView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpacesEffectItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.moji_list_item_space)));
        this.mTvEffectTitle = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        this.mIvEffectIcon = imageView;
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_tab_filter);
        this.mTvEffectTitle.setText(com.aliyun.svideo.editor.R.string.alivc_editor_effect_filter);
        this.mCancel = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.cancel);
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.complete);
        this.mComplete = imageView2;
        imageView2.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isShowSelectedView() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo;
        if (com.aliyun.svideo.base.utils.FastClickUtil.isFastClick()) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (view == this.mCancel) {
            if (this.mOnEffectActionLister != null) {
                com.aliyun.svideo.editor.effects.control.EditorService editorService = this.mEditorService;
                if (editorService != null && editorService.getLastFilterInfo() != null) {
                    com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.SelectColorFilter.Builder().effectInfo(this.mEditorService.getLastFilterInfo()).index(this.mLastSaveIndex).build());
                    this.mFilterAdapter.setSelectedPos(this.mLastSaveIndex);
                    this.mFilterAdapter.notifyDataSetChanged();
                }
                this.mOnEffectActionLister.onCancel();
            }
        } else if (view == this.mComplete && this.mOnEffectActionLister != null) {
            com.aliyun.svideo.editor.effects.control.EditorService editorService2 = this.mEditorService;
            if (editorService2 != null && (effectInfo = this.mLastSelectEffectInfo) != null) {
                editorService2.setLastFilterInfo(effectInfo);
                this.mLastSaveIndex = this.mLastIndex;
            }
            this.mOnEffectActionLister.onComplete();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
    public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.SelectColorFilter.Builder().effectInfo(effectInfo).index(i).build());
        this.mLastSelectEffectInfo = effectInfo;
        this.mLastIndex = i;
        return true;
    }

    public void setSelectedPos(int i) {
        com.aliyun.svideo.editor.effects.filter.FilterAdapter filterAdapter = this.mFilterAdapter;
        if (filterAdapter != null) {
            filterAdapter.setSelectedPos(i);
        }
    }
}
