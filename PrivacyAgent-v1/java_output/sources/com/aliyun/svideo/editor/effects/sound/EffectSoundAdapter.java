package com.aliyun.svideo.editor.effects.sound;

/* loaded from: classes12.dex */
class EffectSoundAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.SoundHolder> {
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mClickListener;
    private android.content.Context mContext;
    private int mSelectedPos;
    private java.util.List<com.aliyun.svideo.editor.effects.sound.SoundEffectInfo> mSoundList = new java.util.ArrayList();

    public class SoundHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        com.aliyun.svideo.base.widget.CircularImageView mSoundImage;
        android.widget.TextView mSoundName;
        android.widget.ImageView mSoundSelectState;

        /* renamed from: com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter$SoundHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter effectSoundAdapter) {
                this.val$this$0 = effectSoundAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                int adapterPosition;
                if (com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.this.mClickListener != null && com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.this.mSelectedPos != (adapterPosition = com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.SoundHolder.this.getAdapterPosition())) {
                    com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.this.mSelectedPos = adapterPosition;
                    com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.this.mClickListener.onItemClick((com.aliyun.svideo.editor.effects.control.EffectInfo) com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.this.mSoundList.get(adapterPosition), com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.this.mSelectedPos);
                    com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_SOUND_CK, com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.SoundHolder.this.mSoundName.getText().toString());
                    com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.this.notifyDataSetChanged();
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public SoundHolder(android.view.View view) {
            super(view);
            this.mSoundImage = (com.aliyun.svideo.base.widget.CircularImageView) view.findViewById(com.aliyun.svideo.editor.R.id.effect_sound_image_view);
            this.mSoundName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.effect_sound_name);
            this.mSoundSelectState = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_effect_select_state);
            view.setOnClickListener(new com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.SoundHolder.AnonymousClass1(com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.this));
        }
    }

    public EffectSoundAdapter(android.content.Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<com.aliyun.svideo.editor.effects.sound.SoundEffectInfo> list = this.mSoundList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.SoundHolder soundHolder, int i) {
        soundHolder.mSoundImage.setImageResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_none);
        soundHolder.mSoundName.setText(this.mSoundList.get(i).soundNameId);
        soundHolder.mSoundImage.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this.mContext, this.mSoundList.get(i).imgIcon));
        if (this.mSelectedPos > this.mSoundList.size()) {
            this.mSelectedPos = 0;
        }
        if (this.mSelectedPos == i) {
            soundHolder.mSoundImage.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_select);
        } else {
            soundHolder.mSoundImage.setBackgroundResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_augmentation_default);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.SoundHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.sound.EffectSoundAdapter.SoundHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_effcet_sound, viewGroup, false));
    }

    public void setDataList(java.util.List<com.aliyun.svideo.editor.effects.sound.SoundEffectInfo> list) {
        this.mSoundList.clear();
        this.mSoundList.addAll(list);
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener) {
        this.mClickListener = onItemClickListener;
    }

    public void setSelectedPos(int i) {
        this.mSelectedPos = i;
    }
}
