package com.aliyun.svideo.editor.effects.lut;

/* loaded from: classes12.dex */
public class LutFilterChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
    private java.lang.String lutFilePath;
    private androidx.recyclerview.widget.RecyclerView mListView;
    private com.aliyun.svideo.editor.effects.lut.LutAdapter mLutAdapter;
    private android.widget.SeekBar mSeekBar;
    private android.widget.TextView mTvEffectTitle;

    /* renamed from: com.aliyun.svideo.editor.effects.lut.LutFilterChooserView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.SeekBar.OnSeekBarChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (com.aliyun.svideo.editor.effects.lut.LutFilterChooserView.this.lutFilePath == null || com.aliyun.svideo.editor.contant.EditorConstants.EFFECT_FILTER_LOCAL_LUT_CLEAR.equals(com.aliyun.svideo.editor.effects.lut.LutFilterChooserView.this.lutFilePath) || com.aliyun.svideo.editor.contant.EditorConstants.EFFECT_FILTER_LOCAL_LUT_ADD.equals(com.aliyun.svideo.editor.effects.lut.LutFilterChooserView.this.lutFilePath)) {
                return;
            }
            com.aliyun.svideosdk.common.struct.effect.LUTEffectBean lUTEffectBean = new com.aliyun.svideosdk.common.struct.effect.LUTEffectBean();
            lUTEffectBean.setSource(new com.aliyun.svideosdk.common.struct.project.Source(com.aliyun.svideo.editor.effects.lut.LutFilterChooserView.this.lutFilePath));
            lUTEffectBean.setIntensity((i * 1.0f) / 100.0f);
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(lUTEffectBean);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
        }
    }

    public LutFilterChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public LutFilterChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LutFilterChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_mv, this);
        int i = com.aliyun.svideo.editor.R.id.seek_bar;
        findViewById(i).setVisibility(0);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.effect_list_filter);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        if (this.mLutAdapter == null) {
            com.aliyun.svideo.editor.effects.lut.LutAdapter lutAdapter = new com.aliyun.svideo.editor.effects.lut.LutAdapter(getContext());
            this.mLutAdapter = lutAdapter;
            lutAdapter.setOnItemClickListener(this);
            this.mLutAdapter.setDataList(com.aliyun.svideo.editor.util.EditorCommon.getLutFilterList(getContext()));
        }
        this.mListView.setAdapter(this.mLutAdapter);
        this.mListView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.effect_title_tv);
        this.mTvEffectTitle = textView;
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_svideo_filter_lut);
        android.graphics.drawable.Drawable drawable = getContext().getResources().getDrawable(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_tab_filter);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mTvEffectTitle.setCompoundDrawables(drawable, null, null, null);
        android.widget.SeekBar seekBar = (android.widget.SeekBar) findViewById(i);
        this.mSeekBar = seekBar;
        seekBar.setOnSeekBarChangeListener(new com.aliyun.svideo.editor.effects.lut.LutFilterChooserView.AnonymousClass1());
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return false;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isShowSelectedView() {
        return false;
    }

    @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
    public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
        if (effectInfo == null || effectInfo.getSource() == null) {
            return true;
        }
        this.lutFilePath = effectInfo.getSource().getPath();
        com.aliyun.svideosdk.common.struct.effect.LUTEffectBean lUTEffectBean = new com.aliyun.svideosdk.common.struct.effect.LUTEffectBean();
        lUTEffectBean.setSource(effectInfo.getSource());
        lUTEffectBean.setIntensity(1.0f);
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(lUTEffectBean);
        return true;
    }

    public void setSelectedPos(int i) {
        com.aliyun.svideo.editor.effects.lut.LutAdapter lutAdapter = this.mLutAdapter;
        if (lutAdapter != null) {
            lutAdapter.setSelectedPos(i);
        }
    }
}
