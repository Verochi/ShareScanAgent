package com.aliyun.svideo.editor.effects.sound;

/* loaded from: classes12.dex */
public class SoundEffectChooseView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements android.view.View.OnClickListener {
    private com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter adapter;
    private android.widget.ImageView mCancel;
    private android.widget.ImageView mComplete;
    int mLastIndex;
    int mLastSaveIndex;
    com.aliyun.svideo.editor.effects.control.EffectInfo mLastSelectSoundInfo;

    /* renamed from: com.aliyun.svideo.editor.effects.sound.SoundEffectChooseView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
            com.aliyun.svideo.editor.effects.sound.SoundEffectChooseView soundEffectChooseView = com.aliyun.svideo.editor.effects.sound.SoundEffectChooseView.this;
            soundEffectChooseView.mLastSelectSoundInfo = effectInfo;
            soundEffectChooseView.mLastIndex = i;
            soundEffectChooseView.mOnEffectChangeListener.onEffectChange(effectInfo);
            return false;
        }
    }

    public SoundEffectChooseView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public SoundEffectChooseView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SoundEffectChooseView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_sound, this);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.effect_sound_list_filter);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        recyclerView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpacesEffectItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        if (this.adapter == null) {
            com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter effectSoundAdapter = new com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter(getContext());
            this.adapter = effectSoundAdapter;
            effectSoundAdapter.setOnItemClickListener(new com.aliyun.svideo.editor.effects.sound.SoundEffectChooseView.AnonymousClass1());
            this.adapter.setDataList(com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.getEffectSound());
        }
        recyclerView.setAdapter(this.adapter);
        this.mCancel = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.alivc_btn_close);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.alivc_btn_done);
        this.mComplete = imageView;
        imageView.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
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
                if (editorService != null && editorService.getLastSoundInfo() != null) {
                    this.mOnEffectChangeListener.onEffectChange(this.mEditorService.getLastSoundInfo());
                    this.adapter.setSelectedPos(this.mLastSaveIndex);
                    this.adapter.notifyDataSetChanged();
                }
                this.mOnEffectActionLister.onCancel();
            }
        } else if (view == this.mComplete && this.mOnEffectActionLister != null) {
            com.aliyun.svideo.editor.effects.control.EditorService editorService2 = this.mEditorService;
            if (editorService2 != null && (effectInfo = this.mLastSelectSoundInfo) != null) {
                editorService2.setLastSoundInfo(effectInfo);
                this.mLastSaveIndex = this.mLastIndex;
            }
            this.mOnEffectActionLister.onComplete();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setSelectedPos(int i) {
        com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter effectSoundAdapter = this.adapter;
        if (effectSoundAdapter != null) {
            effectSoundAdapter.setSelectedPos(i);
        }
    }
}
