package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionStrokeColorViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter colorAdapter;
    private int currentCaptionControlId;
    private androidx.recyclerview.widget.RecyclerView mListView;
    private final android.widget.SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    private android.widget.SeekBar seekBar;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00691 implements java.lang.Runnable {
            final /* synthetic */ int val$currentIndex;
            final /* synthetic */ int val$finalOutlineWidth;

            public RunnableC00691(int i, int i2) {
                this.val$finalOutlineWidth = i;
                this.val$currentIndex = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.seekBar.setOnSeekBarChangeListener(null);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.seekBar.setProgress(this.val$finalOutlineWidth);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.colorAdapter.setSelectPosition(this.val$currentIndex);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.seekBar.setOnSeekBarChangeListener(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.mSeekBarChangeListener);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int captionControllerId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.getCaptionChooserStateChangeListener());
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.currentCaptionControlId != captionControllerId) {
                int currentIndex = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.getCurrentIndex();
                com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.getCaptionChooserStateChangeListener());
                int outlineWidth = captionController != null ? (int) captionController.getOutlineWidth() : 0;
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.currentCaptionControlId = captionControllerId;
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.AnonymousClass1.RunnableC00691(outlineWidth, currentIndex));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder$2, reason: invalid class name */
    public class AnonymousClass2 implements android.widget.SeekBar.OnSeekBarChangeListener {
        public AnonymousClass2() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.getCaptionChooserStateChangeListener() != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.this.getCaptionChooserStateChangeListener().onCaptionTextStrokeWidthChanged(i);
            }
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

    public CaptionStrokeColorViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
        this.mSeekBarChangeListener = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.AnonymousClass2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentIndex() {
        com.aliyun.svideosdk.common.AliyunColor shadowColor;
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(getCaptionChooserStateChangeListener());
        if (this.colorAdapter != null && captionController != null && (shadowColor = captionController.getShadowColor()) != null) {
            int argb = shadowColor.toArgb();
            java.util.List<java.lang.Integer> data = this.colorAdapter.getData();
            if (data != null) {
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).intValue() == argb) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private java.util.List<java.lang.Integer> initColors() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.res.TypedArray obtainTypedArray = getContext().getResources().obtainTypedArray(com.aliyun.svideo.editor.R.array.qupai_text_edit_colors);
        for (int i = 0; i < 35; i++) {
            arrayList.add(java.lang.Integer.valueOf(obtainTypedArray.getColor(i, -1)));
        }
        obtainTypedArray.recycle();
        return arrayList;
    }

    private void lazyInit() {
        android.view.View itemView = getItemView();
        if (itemView == null || this.colorAdapter != null) {
            notifyDataSetChanged();
            return;
        }
        this.mListView = (androidx.recyclerview.widget.RecyclerView) itemView.findViewById(com.aliyun.svideo.editor.R.id.color_list);
        this.seekBar = (android.widget.SeekBar) itemView.findViewById(com.aliyun.svideo.editor.R.id.seekBar);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter captionColorAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter();
        this.colorAdapter = captionColorAdapter;
        captionColorAdapter.setModel(1);
        this.mListView.setAdapter(this.colorAdapter);
        this.colorAdapter.setOnCaptionColorItemClickListener(getCaptionChooserStateChangeListener());
        this.seekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        this.colorAdapter.setColorList(initColors());
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        if (this.colorAdapter != null) {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionStrokeColorViewHolder.AnonymousClass1());
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        return android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_text_stroke_color_container, (android.view.ViewGroup) null, false);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        lazyInit();
    }
}
