package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionColorViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter colorAdapter;
    private int currentCaptionControlId;
    private androidx.recyclerview.widget.RecyclerView mListView;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$captionControllerId;

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00651 implements java.lang.Runnable {
            final /* synthetic */ int val$currentIndex;

            public RunnableC00651(int i) {
                this.val$currentIndex = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder.this.colorAdapter.setSelectPosition(this.val$currentIndex);
            }
        }

        public AnonymousClass1(int i) {
            this.val$captionControllerId = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder.this.currentCaptionControlId != this.val$captionControllerId) {
                int currentIndex = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder.this.getCurrentIndex();
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder.this.currentCaptionControlId = this.val$captionControllerId;
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder.AnonymousClass1.RunnableC00651(currentIndex));
            }
        }
    }

    public CaptionColorViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentIndex() {
        com.aliyun.svideosdk.common.AliyunColor color;
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(getCaptionChooserStateChangeListener());
        if (this.colorAdapter != null && captionController != null && (color = captionController.getColor()) != null) {
            int argb = color.toArgb();
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
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionColorViewHolder.AnonymousClass1(com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener())));
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
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_text_color_container, (android.view.ViewGroup) null, false);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.color_list);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter captionColorAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter();
        this.colorAdapter = captionColorAdapter;
        this.mListView.setAdapter(captionColorAdapter);
        this.colorAdapter.setColorList(initColors());
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
        return inflate;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        notifyDataSetChanged();
    }
}
