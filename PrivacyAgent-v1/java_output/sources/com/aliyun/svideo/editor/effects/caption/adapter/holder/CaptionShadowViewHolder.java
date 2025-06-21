package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionShadowViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter colorAdapter;
    private int currentCaptionControlId;
    private final android.widget.SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
    private android.widget.SeekBar xSeekBar;
    private android.widget.SeekBar ySeekBar;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00681 implements java.lang.Runnable {
            final /* synthetic */ int val$currentIndex;
            final /* synthetic */ android.graphics.PointF val$finalShadowOffset;

            public RunnableC00681(android.graphics.PointF pointF, int i) {
                this.val$finalShadowOffset = pointF;
                this.val$currentIndex = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.xSeekBar.setOnSeekBarChangeListener(null);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.ySeekBar.setOnSeekBarChangeListener(null);
                if (this.val$finalShadowOffset != null) {
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.xSeekBar.setProgress((int) this.val$finalShadowOffset.x);
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.ySeekBar.setProgress((int) this.val$finalShadowOffset.y);
                } else {
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.xSeekBar.setProgress(0);
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.ySeekBar.setProgress(0);
                }
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.xSeekBar.setOnSeekBarChangeListener(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.onSeekBarChangeListener);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.ySeekBar.setOnSeekBarChangeListener(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.onSeekBarChangeListener);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.colorAdapter.setSelectPosition(this.val$currentIndex);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int captionControllerId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.getCaptionChooserStateChangeListener());
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.currentCaptionControlId != captionControllerId) {
                int currentIndex = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.getCurrentIndex();
                com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.getCaptionChooserStateChangeListener());
                android.graphics.PointF shadowOffset = captionController != null ? captionController.getShadowOffset() : null;
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.currentCaptionControlId = captionControllerId;
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.AnonymousClass1.RunnableC00681(shadowOffset, currentIndex));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder$2, reason: invalid class name */
    public class AnonymousClass2 implements android.widget.SeekBar.OnSeekBarChangeListener {
        public AnonymousClass2() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.getCaptionChooserStateChangeListener() != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.getCaptionChooserStateChangeListener().onCaptionTextShandowOffsetChanged(new android.graphics.PointF(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.xSeekBar.getProgress(), com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.this.ySeekBar.getProgress()));
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

    public CaptionShadowViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
        this.onSeekBarChangeListener = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.AnonymousClass2();
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
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) itemView.findViewById(com.aliyun.svideo.editor.R.id.color_list);
        this.xSeekBar = (android.widget.SeekBar) itemView.findViewById(com.aliyun.svideo.editor.R.id.x_seekbar);
        this.ySeekBar = (android.widget.SeekBar) itemView.findViewById(com.aliyun.svideo.editor.R.id.y_seekbar);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter captionColorAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter();
        this.colorAdapter = captionColorAdapter;
        captionColorAdapter.setModel(2);
        recyclerView.setAdapter(this.colorAdapter);
        this.colorAdapter.setColorList(initColors());
        this.colorAdapter.setOnCaptionColorItemClickListener(getCaptionChooserStateChangeListener());
        this.xSeekBar.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        this.ySeekBar.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        if (this.colorAdapter != null) {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionShadowViewHolder.AnonymousClass1());
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        return android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_style_shadow_container, (android.view.ViewGroup) null, false);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        lazyInit();
    }
}
