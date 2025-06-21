package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionAnimationPanelViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private com.aliyun.svideo.editor.effects.caption.adapter.CaptionAnimationAdapter mCaptionAnimationAdapter;
    private final com.aliyun.svideo.editor.effects.caption.adapter.CaptionAnimationAdapter.OnItemClickListener mClickListener;
    private int mCurrentCaptionControlId;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$currentIndex;

        public AnonymousClass1(int i) {
            this.val$currentIndex = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.mCaptionAnimationAdapter.setSelectPosition(this.val$currentIndex);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ int val$currentIndex;

            public AnonymousClass1(int i) {
                this.val$currentIndex = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.mCaptionAnimationAdapter.setSelectPosition(this.val$currentIndex);
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int captionControllerId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.getCaptionChooserStateChangeListener());
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.mCurrentCaptionControlId != captionControllerId) {
                int currentIndex = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.getCurrentIndex();
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.mCurrentCaptionControlId = captionControllerId;
                com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.AnonymousClass2.AnonymousClass1(currentIndex));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.effects.caption.adapter.CaptionAnimationAdapter.OnItemClickListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.editor.effects.caption.adapter.CaptionAnimationAdapter.OnItemClickListener
        public void onItemClick(int i) {
            com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener captionChooserStateChangeListener = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.getCaptionChooserStateChangeListener();
            if (captionChooserStateChangeListener != null && captionChooserStateChangeListener.isInvert()) {
                com.aliyun.svideo.editor.util.FixedToastUtils.show(com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.getContext(), com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_tip_not_support));
            } else if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.getCaptionChooserStateChangeListener() != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.this.getCaptionChooserStateChangeListener().onCaptionFrameAnimation(i);
            }
        }
    }

    public CaptionAnimationPanelViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
        this.mClickListener = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.AnonymousClass3();
    }

    private int coverActionBase(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        if (actionBase == null) {
            return 0;
        }
        return java.lang.Integer.parseInt(actionBase.getResId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentIndex() {
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterController;
        java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> frameAnimations;
        com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener captionChooserStateChangeListener = getCaptionChooserStateChangeListener();
        if (captionChooserStateChangeListener == null || (aliyunPasterController = captionChooserStateChangeListener.getAliyunPasterController()) == null || (frameAnimations = aliyunPasterController.getFrameAnimations()) == null || frameAnimations.size() <= 0) {
            return 0;
        }
        return coverActionBase(frameAnimations.get(frameAnimations.size() - 1));
    }

    private void lazyInit() {
        android.view.View itemView = getItemView();
        if (itemView == null || this.mCaptionAnimationAdapter != null) {
            notifyDataSetChanged();
            return;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) itemView.findViewById(com.aliyun.svideo.editor.R.id.font_animation_view);
        this.mCaptionAnimationAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.CaptionAnimationAdapter(itemView.getContext());
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(getContext(), 4));
        recyclerView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        recyclerView.setAdapter(this.mCaptionAnimationAdapter);
        this.mCaptionAnimationAdapter.setOnItemClickListener(this.mClickListener);
        this.mCurrentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
        com.aliyun.svideo.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.AnonymousClass1(getCurrentIndex()));
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        if (this.mCaptionAnimationAdapter != null) {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAnimationPanelViewHolder.AnonymousClass2());
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
