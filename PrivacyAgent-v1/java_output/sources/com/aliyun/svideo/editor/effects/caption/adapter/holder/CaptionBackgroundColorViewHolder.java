package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionBackgroundColorViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter colorAdapter;
    private int currentCaptionControlId;
    private androidx.recyclerview.widget.RecyclerView mListView;
    private android.widget.SeekBar mRadiusSeekBar;
    private android.widget.SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.SeekBar.OnSeekBarChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.getCaptionChooserStateChangeListener() != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.getCaptionChooserStateChangeListener().onCaptionTextBackgroundCornerRadiusChanged(i);
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

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.getCaptionChooserStateChangeListener() != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.getCaptionChooserStateChangeListener().onCaptionTextBackgroundColorChanged(new com.aliyun.svideosdk.common.AliyunColor(0));
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int val$captionControllerId;

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ int val$currentIndex;
            final /* synthetic */ int val$finalCornerRadius;

            public AnonymousClass1(int i, int i2) {
                this.val$currentIndex = i;
                this.val$finalCornerRadius = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.colorAdapter.setSelectPosition(this.val$currentIndex);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.mRadiusSeekBar.setOnSeekBarChangeListener(null);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.mRadiusSeekBar.setProgress(this.val$finalCornerRadius);
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.mRadiusSeekBar.setOnSeekBarChangeListener(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.mSeekBarChangeListener);
            }
        }

        public AnonymousClass3(int i) {
            this.val$captionControllerId = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.currentCaptionControlId != this.val$captionControllerId) {
                int currentIndex = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.getCurrentIndex();
                com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.getCaptionChooserStateChangeListener());
                int backgroundCornerRadius = captionController != null ? (int) captionController.getBackgroundCornerRadius() : 0;
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.this.currentCaptionControlId = this.val$captionControllerId;
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.AnonymousClass3.AnonymousClass1(currentIndex, backgroundCornerRadius));
            }
        }
    }

    public CaptionBackgroundColorViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentIndex() {
        com.aliyun.svideosdk.common.AliyunColor backgroundColor;
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(getCaptionChooserStateChangeListener());
        if (this.colorAdapter != null && captionController != null && (backgroundColor = captionController.getBackgroundColor()) != null) {
            int argb = backgroundColor.toArgb();
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

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        if (this.colorAdapter != null) {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.AnonymousClass3(com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener())));
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter captionColorAdapter = this.colorAdapter;
        if (captionColorAdapter != null) {
            captionColorAdapter.setOnCaptionColorItemClickListener(getCaptionChooserStateChangeListener());
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_text_background_color_container, (android.view.ViewGroup) null, false);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.color_list);
        android.view.View findViewById = inflate.findViewById(com.aliyun.svideo.editor.R.id.img_clean);
        findViewById.setVisibility(0);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter captionColorAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter();
        this.colorAdapter = captionColorAdapter;
        captionColorAdapter.setModel(3);
        this.mRadiusSeekBar = (android.widget.SeekBar) inflate.findViewById(com.aliyun.svideo.editor.R.id.radius_seekBar);
        this.mListView.setAdapter(this.colorAdapter);
        this.colorAdapter.setColorList(initColors());
        this.mSeekBarChangeListener = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.AnonymousClass1();
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
        findViewById.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionBackgroundColorViewHolder.AnonymousClass2());
        this.mRadiusSeekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        return inflate;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        notifyDataSetChanged();
    }
}
