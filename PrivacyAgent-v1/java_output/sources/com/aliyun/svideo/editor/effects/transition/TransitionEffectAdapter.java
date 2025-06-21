package com.aliyun.svideo.editor.effects.transition;

/* loaded from: classes12.dex */
public class TransitionEffectAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private android.content.Context mContext;
    private int mGroupId;
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mOnItemClickListener;
    private int mSelectPosition = 0;
    private java.util.List<java.lang.String> mTransitionEffectList = new java.util.ArrayList();
    private boolean isDefault = true;

    public class TransitionViewEffectHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView mEffectIcon;
        android.widget.TextView mEffectName;

        /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter$TransitionViewEffectHolder$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter val$this$0;

            public AnonymousClass1(com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter transitionEffectAdapter) {
                this.val$this$0 = transitionEffectAdapter;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                if (com.aliyun.svideo.common.utils.FastClickUtil.isFastClick()) {
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                if (com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.this.mOnItemClickListener != null) {
                    com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                    int adapterPosition = com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.TransitionViewEffectHolder.this.getAdapterPosition();
                    effectInfo.transitionType = adapterPosition;
                    if (!com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.this.isDefault) {
                        java.lang.String str = (java.lang.String) com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.this.mTransitionEffectList.get(adapterPosition);
                        com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase = new com.aliyun.svideosdk.common.struct.effect.TransitionBase(str);
                        effectInfo.setPath(str);
                        com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(str);
                        if (source.getPath() != null) {
                            java.lang.String path = source.getPath();
                            java.lang.String str2 = java.io.File.separator;
                            if (path.contains(str2)) {
                                source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION, java.lang.String.valueOf(com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.this.mGroupId), source.getPath().substring(source.getPath().lastIndexOf(str2) + 1)));
                            }
                        }
                        effectInfo.setSource(source);
                        transitionBase.setCustomSource(source);
                        if (adapterPosition == 0) {
                            effectInfo.transitionType = 0;
                        } else {
                            effectInfo.transitionType = 9;
                        }
                        effectInfo.transitionBase = transitionBase;
                    }
                    if (com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.this.mOnItemClickListener.onItemClick(effectInfo, adapterPosition)) {
                        com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.TransitionViewEffectHolder transitionViewEffectHolder = com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.TransitionViewEffectHolder.this;
                        com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.this.mSelectPosition = transitionViewEffectHolder.getAdapterPosition();
                        com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.this.notifyDataSetChanged();
                    }
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public TransitionViewEffectHolder(android.view.View view) {
            super(view);
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
            this.mEffectIcon = imageView;
            imageView.setOnClickListener(new com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.TransitionViewEffectHolder.AnonymousClass1(com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.this));
            this.mEffectName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_effect_name);
        }
    }

    public TransitionEffectAdapter(android.content.Context context) {
        this.mContext = context;
    }

    private java.lang.String getTransitionName(java.lang.String str) {
        java.lang.String str2;
        com.aliyun.svideo.base.Form.I18nBean currentEffectI18n = com.aliyun.svideo.editor.util.EditorCommon.getCurrentEffectI18n(str, "name");
        if (currentEffectI18n != null) {
            return com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(this.mContext) ? currentEffectI18n.getZh_cn() : currentEffectI18n.getEn();
        }
        if (com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(this.mContext)) {
            str2 = str + "/config.json";
        } else {
            java.lang.String str3 = str + "/configEn.json";
            if (new java.io.File(str3).exists()) {
                str2 = str3;
            } else {
                str2 = str + "/config.json";
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.io.FileReader fileReader = new java.io.FileReader(new java.io.File(str2));
            while (true) {
                int read = fileReader.read();
                if (read == -1) {
                    break;
                }
                sb.append((char) read);
            }
            fileReader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        try {
            return new org.json.JSONObject(sb.toString()).optString("name");
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.isDefault ? com.aliyun.svideo.editor.effects.transition.TransitionChooserView.EFFECT_LIST.length : this.mTransitionEffectList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.TransitionViewEffectHolder transitionViewEffectHolder = (com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.TransitionViewEffectHolder) viewHolder;
        if (this.isDefault) {
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
                    transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_shutter_effect_selector);
                    transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_shutter);
                    break;
                case 6:
                    transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_fade_effect_selector);
                    transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_fade);
                    break;
                case 7:
                    transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_fivepointstar_effect_selector);
                    transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_transition_star);
                    break;
                case 8:
                    transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_circle_effect_selector);
                    transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_effect_circle);
                    break;
            }
        } else {
            java.lang.String str = this.mTransitionEffectList.get(i);
            if (str == null) {
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_none_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_none);
            } else {
                java.lang.String transitionName = getTransitionName(str);
                transitionViewEffectHolder.mEffectIcon.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_custom_effect_selector);
                transitionViewEffectHolder.mEffectName.setText(transitionName);
            }
        }
        if (i == this.mSelectPosition) {
            transitionViewEffectHolder.mEffectIcon.setSelected(true);
        } else {
            transitionViewEffectHolder.mEffectIcon.setSelected(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter.TransitionViewEffectHolder(((com.aliyun.svideo.editor.editor.EditorActivity) this.mContext).getLayoutInflater().inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_transition_effect, (android.view.ViewGroup) null));
    }

    public void setCustomSelectPosition(java.lang.String str) {
        if (this.isDefault) {
            this.mSelectPosition = -1;
        } else {
            this.mSelectPosition = this.mTransitionEffectList.indexOf(str);
        }
        notifyDataSetChanged();
    }

    public void setData(int i, java.util.List<java.lang.String> list) {
        this.mTransitionEffectList.clear();
        if (list == null) {
            this.isDefault = true;
            this.mGroupId = -1;
        } else {
            this.isDefault = false;
            this.mGroupId = i;
            this.mTransitionEffectList.addAll(list);
        }
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setSelectPosition(int i) {
        if (this.isDefault) {
            this.mSelectPosition = i;
        } else {
            this.mSelectPosition = -1;
        }
        notifyDataSetChanged();
    }
}
