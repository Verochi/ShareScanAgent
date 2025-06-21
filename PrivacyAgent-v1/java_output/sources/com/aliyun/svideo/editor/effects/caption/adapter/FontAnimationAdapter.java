package com.aliyun.svideo.editor.effects.caption.adapter;

/* loaded from: classes12.dex */
public class FontAnimationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.OnItemClickListener mOnItemClickListerner;
    private int mSelectPosition = 0;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public class TransitionViewEffectHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView mEffectIcon;
        android.widget.TextView mEffectName;

        /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter$TransitionViewEffectHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter fontAnimationAdapter) {
                this.val$this$0 = fontAnimationAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.this.mOnItemClickListerner != null) {
                    if (com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.this.notifySelectedView(com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.TransitionViewEffectHolder.this.getAdapterPosition())) {
                        com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.this.mOnItemClickListerner.onItemClick(com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.TransitionViewEffectHolder.this.getAdapterPosition());
                    }
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public TransitionViewEffectHolder(android.view.View view) {
            super(view);
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
            this.mEffectIcon = imageView;
            imageView.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.TransitionViewEffectHolder.AnonymousClass1(com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.this));
            this.mEffectName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_effect_name);
        }
    }

    public FontAnimationAdapter(android.content.Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifySelectedView(int i) {
        int i2 = this.mSelectPosition;
        if (i == i2) {
            return false;
        }
        this.mSelectPosition = i;
        notifyItemChanged(i2);
        notifyItemChanged(this.mSelectPosition);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return com.aliyun.svideo.editor.contant.CaptionConfig.POSITION_FONT_ANIM_ARRAY.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.TransitionViewEffectHolder transitionViewEffectHolder = (com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.TransitionViewEffectHolder) viewHolder;
        switch (i) {
            case 0:
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_none_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_none);
                break;
            case 1:
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_translate_up_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_translate_up);
                break;
            case 2:
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_translate_down_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_translate_down);
                break;
            case 3:
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_translate_left_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_translate_left);
                break;
            case 4:
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_translate_right_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_translate_right);
                break;
            case 5:
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_fade_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_fade);
                break;
            case 6:
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_linearwipe_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_translate_linearwipe);
                break;
            case 7:
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_fade_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_translate_effect_scale);
                break;
        }
        if (i == this.mSelectPosition) {
            transitionViewEffectHolder.mEffectIcon.setSelected(true);
        } else {
            transitionViewEffectHolder.mEffectIcon.setSelected(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.TransitionViewEffectHolder(((com.aliyun.svideo.editor.editor.EditorActivity) this.mContext).getLayoutInflater().inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_transition_effect, (android.view.ViewGroup) null));
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.caption.adapter.FontAnimationAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListerner = onItemClickListener;
    }

    public void setSelectPosition(int i) {
        notifySelectedView(i);
    }
}
