package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class RollCaptionSubtitleAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder> {
    private java.util.List<com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean> datas;
    private com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.OnSelectItemChangedListener mListener;
    private int mInEditCount = 0;
    private int mSelectItemCount = 0;
    private java.util.ArrayList<java.lang.Integer> mSelectedIndex = new java.util.ArrayList<>();

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder val$holder;

        public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder rollCaptionSubtitleViewHolder) {
            this.val$holder = rollCaptionSubtitleViewHolder;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean = (com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean) com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.datas.get(this.val$holder.getAdapterPosition());
            boolean z = !alivcRollCaptionSubtitleBean.isChecked();
            if (!alivcRollCaptionSubtitleBean.isInEdit()) {
                this.val$holder.mRollCaptionSubtitleCheckBox.setChecked(z);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.widget.CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder val$holder;

        public AnonymousClass2(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder rollCaptionSubtitleViewHolder) {
            this.val$holder = rollCaptionSubtitleViewHolder;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
            com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean = (com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean) com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.datas.get(this.val$holder.getAdapterPosition());
            com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.changeViewState(alivcRollCaptionSubtitleBean, this.val$holder, z);
            alivcRollCaptionSubtitleBean.setInEdit(false);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder val$holder;

        public AnonymousClass3(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder rollCaptionSubtitleViewHolder) {
            this.val$holder = rollCaptionSubtitleViewHolder;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean = (com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean) com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.datas.get(this.val$holder.getAdapterPosition());
            if (alivcRollCaptionSubtitleBean.isInEdit()) {
                alivcRollCaptionSubtitleBean.setContent(this.val$holder.mRollCaptionSubtitleEditText.getText().toString());
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.changeEditTextFocus(this.val$holder, false);
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.mInEditCount--;
            } else {
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.changeEditTextFocus(this.val$holder, true);
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.mInEditCount++;
            }
            this.val$holder.mRollCaptionEditTextView.setText(alivcRollCaptionSubtitleBean.isInEdit() ? com.aliyun.svideo.editor.R.string.alivc_editor_dialog_roll_caption_edit : com.aliyun.svideo.editor.R.string.alivc_editor_dialog_roll_caption_finish);
            alivcRollCaptionSubtitleBean.setInEdit(!alivcRollCaptionSubtitleBean.isInEdit());
            if (com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.mListener != null) {
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.mListener.onSelectItemChanged(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.mSelectItemCount, com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.this.mInEditCount, this.val$holder.getAdapterPosition(), alivcRollCaptionSubtitleBean.isChecked());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface OnSelectItemChangedListener {
        void onSelectItemChanged(int i, int i2, int i3, boolean z);
    }

    public static class RollCaptionSubtitleViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView mRollCaptionEditTextView;
        private final android.widget.LinearLayout mRollCaptionItem;
        private final android.widget.CheckBox mRollCaptionSubtitleCheckBox;
        private final android.widget.EditText mRollCaptionSubtitleEditText;

        public RollCaptionSubtitleViewHolder(android.view.View view) {
            super(view);
            this.mRollCaptionItem = (android.widget.LinearLayout) view.findViewById(com.aliyun.svideo.editor.R.id.roll_caption_item);
            this.mRollCaptionSubtitleCheckBox = (android.widget.CheckBox) view.findViewById(com.aliyun.svideo.editor.R.id.roll_caption_subtitle_checkbox);
            this.mRollCaptionSubtitleEditText = (android.widget.EditText) view.findViewById(com.aliyun.svideo.editor.R.id.roll_caption_subtitle_et);
            this.mRollCaptionEditTextView = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.roll_caption_edit_tv);
        }
    }

    public RollCaptionSubtitleAdapter(java.util.List<com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean> list) {
        this.datas = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeEditTextFocus(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder rollCaptionSubtitleViewHolder, boolean z) {
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleCheckBox.setClickable(!z);
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleCheckBox.setEnabled(!z);
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.setFocusable(z);
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.setEnabled(z);
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.setFocusableInTouchMode(z);
        if (z) {
            rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.requestFocus();
            rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.setSelection(rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.getText().length());
            ((android.view.inputmethod.InputMethodManager) rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.getContext().getSystemService("input_method")).showSoftInput(rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeViewState(com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean, com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder rollCaptionSubtitleViewHolder, boolean z) {
        if (alivcRollCaptionSubtitleBean.isInEdit()) {
            return;
        }
        alivcRollCaptionSubtitleBean.setChecked(z);
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleCheckBox.setChecked(z);
        rollCaptionSubtitleViewHolder.mRollCaptionEditTextView.setVisibility(z ? 0 : 8);
        if (z) {
            this.mSelectItemCount++;
            this.mSelectedIndex.add(java.lang.Integer.valueOf(rollCaptionSubtitleViewHolder.getAdapterPosition()));
            rollCaptionSubtitleViewHolder.mRollCaptionEditTextView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_roll_caption_edit);
        } else {
            changeEditTextFocus(rollCaptionSubtitleViewHolder, false);
            this.mSelectItemCount--;
            this.mSelectedIndex.remove(java.lang.Integer.valueOf(rollCaptionSubtitleViewHolder.getAdapterPosition()));
        }
        com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.OnSelectItemChangedListener onSelectItemChangedListener = this.mListener;
        if (onSelectItemChangedListener != null) {
            onSelectItemChangedListener.onSelectItemChanged(this.mSelectItemCount, this.mInEditCount, rollCaptionSubtitleViewHolder.getAdapterPosition(), z);
        }
    }

    public void confirmColor() {
        this.mSelectItemCount = 0;
        java.util.Iterator<java.lang.Integer> it = this.mSelectedIndex.iterator();
        while (it.hasNext()) {
            java.lang.Integer next = it.next();
            com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean = this.datas.get(next.intValue());
            if (alivcRollCaptionSubtitleBean.isChecked()) {
                alivcRollCaptionSubtitleBean.setChecked(false);
            }
            notifyItemChanged(next.intValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean> list = this.datas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder rollCaptionSubtitleViewHolder, int i) {
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.setText(this.datas.get(i).getContent());
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleEditText.setTextColor(this.datas.get(i).getColor());
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleCheckBox.setChecked(this.datas.get(i).isChecked());
        rollCaptionSubtitleViewHolder.mRollCaptionItem.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.AnonymousClass1(rollCaptionSubtitleViewHolder));
        rollCaptionSubtitleViewHolder.mRollCaptionSubtitleCheckBox.setOnCheckedChangeListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.AnonymousClass2(rollCaptionSubtitleViewHolder));
        rollCaptionSubtitleViewHolder.mRollCaptionEditTextView.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.AnonymousClass3(rollCaptionSubtitleViewHolder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.RollCaptionSubtitleViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_roll_caption_item_subtitle_effect, viewGroup, false));
    }

    public void setAllColor(int i) {
        java.util.Iterator<com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean> it = this.datas.iterator();
        while (it.hasNext()) {
            it.next().setColor(i);
        }
        notifyDataSetChanged();
    }

    public void setColor(int i) {
        java.util.Iterator<java.lang.Integer> it = this.mSelectedIndex.iterator();
        while (it.hasNext()) {
            java.lang.Integer next = it.next();
            com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean = this.datas.get(next.intValue());
            if (alivcRollCaptionSubtitleBean.isChecked()) {
                alivcRollCaptionSubtitleBean.setColor(i);
            }
            notifyItemChanged(next.intValue());
        }
    }

    public void setOnSelectItemChangedListener(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.OnSelectItemChangedListener onSelectItemChangedListener) {
        this.mListener = onSelectItemChangedListener;
    }
}
