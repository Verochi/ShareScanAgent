package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionCoolTextPanelViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private java.util.List<java.lang.String> coolTextFileList;
    private int currentCaptionControlId;
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter mCaptionCoolTextAdapter;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$captionControllerId;

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00661 implements java.lang.Runnable {
            final /* synthetic */ int val$currentIndex;

            public RunnableC00661(int i) {
                this.val$currentIndex = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.mCaptionCoolTextAdapter.setSelectPosition(this.val$currentIndex);
            }
        }

        public AnonymousClass1(int i) {
            this.val$captionControllerId = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.currentCaptionControlId != this.val$captionControllerId) {
                int currentIndex = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.getCurrentIndex();
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.currentCaptionControlId = this.val$captionControllerId;
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.AnonymousClass1.RunnableC00661(currentIndex));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.mCaptionCoolTextAdapter != null) {
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.mCaptionCoolTextAdapter.setData(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.coolTextFileList);
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.coolTextFileList = com.aliyun.svideo.editor.util.EditorCommon.getCoolTextFileList();
            com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.this.coolTextFileList.add(0, null);
            com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.AnonymousClass2.AnonymousClass1());
        }
    }

    public CaptionCoolTextPanelViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentIndex() {
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterController;
        com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener captionChooserStateChangeListener = getCaptionChooserStateChangeListener();
        if (captionChooserStateChangeListener == null || (aliyunPasterController = captionChooserStateChangeListener.getAliyunPasterController()) == null) {
            return 0;
        }
        java.lang.String fontEffectTemplate = aliyunPasterController.getFontEffectTemplate();
        if (android.text.TextUtils.isEmpty(fontEffectTemplate)) {
            return 0;
        }
        for (int i = 0; i < this.coolTextFileList.size(); i++) {
            if (fontEffectTemplate.equals(this.coolTextFileList.get(i))) {
                return i;
            }
        }
        return 0;
    }

    private void lazyInit() {
        android.view.View itemView = getItemView();
        if (itemView == null || this.mCaptionCoolTextAdapter != null) {
            notifyDataSetChanged();
            return;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) itemView.findViewById(com.aliyun.svideo.editor.R.id.font_animation_view);
        this.mCaptionCoolTextAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionCoolTextAdapter();
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(getContext(), 4));
        recyclerView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        recyclerView.setAdapter(this.mCaptionCoolTextAdapter);
        this.mCaptionCoolTextAdapter.setOnItemClickListener(getCaptionChooserStateChangeListener());
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
        loadFiles();
    }

    public void loadFiles() {
        com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.AnonymousClass2());
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        if (this.mCaptionCoolTextAdapter != null) {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionCoolTextPanelViewHolder.AnonymousClass1(com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener())));
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        return android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_animation_container, (android.view.ViewGroup) null, false);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        lazyInit();
    }
}
