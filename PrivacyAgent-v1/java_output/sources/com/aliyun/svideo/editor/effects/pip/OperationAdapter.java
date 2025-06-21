package com.aliyun.svideo.editor.effects.pip;

/* loaded from: classes12.dex */
public class OperationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.pip.OperationAdapter.OnItemClickListener mItemClick;
    private com.aliyun.svideo.editor.effects.pip.OperationAdapter.OperationViewHolder mSelectedHolder;
    private int mSelectedPos = 0;

    public interface OnItemClickListener {
        boolean onItemClick(com.aliyun.svideo.editor.effects.pip.Operation operation, int i);
    }

    public static class OperationViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.TextView mName;

        public OperationViewHolder(android.view.View view) {
            super(view);
            this.mName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_name);
        }
    }

    public OperationAdapter(android.content.Context context) {
        this.mContext = context;
    }

    private com.aliyun.svideo.editor.effects.pip.Operation getOperation(int i) {
        return com.aliyun.svideo.editor.effects.pip.Operation.values()[i];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return com.aliyun.svideo.editor.effects.pip.Operation.values().length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.pip.OperationAdapter.OperationViewHolder operationViewHolder = (com.aliyun.svideo.editor.effects.pip.OperationAdapter.OperationViewHolder) viewHolder;
        java.lang.String str = com.aliyun.svideo.editor.effects.pip.Operation.values()[i].name;
        if (this.mSelectedPos > com.aliyun.svideo.editor.effects.pip.Operation.values().length) {
            this.mSelectedPos = 0;
        }
        if (i == 0) {
            this.mSelectedHolder = operationViewHolder;
        }
        operationViewHolder.mName.setSelected(this.mSelectedPos == i || com.aliyun.svideo.editor.effects.pip.Operation.values()[i].allwaysSelected);
        operationViewHolder.mName.setText(str);
        operationViewHolder.itemView.setTag(viewHolder);
        operationViewHolder.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (this.mItemClick != null) {
            com.aliyun.svideo.editor.effects.pip.OperationAdapter.OperationViewHolder operationViewHolder = (com.aliyun.svideo.editor.effects.pip.OperationAdapter.OperationViewHolder) view.getTag();
            int adapterPosition = operationViewHolder.getAdapterPosition();
            com.aliyun.svideo.editor.effects.pip.OperationAdapter.OperationViewHolder operationViewHolder2 = this.mSelectedHolder;
            if (operationViewHolder2 != null) {
                operationViewHolder2.mName.setSelected(false);
            }
            com.aliyun.svideo.editor.effects.pip.Operation operation = com.aliyun.svideo.editor.effects.pip.Operation.values()[adapterPosition];
            if (this.mSelectedPos != adapterPosition || operation.allwaysSelected) {
                if (this.mSelectedHolder != null) {
                    this.mSelectedHolder.mName.setSelected(com.aliyun.svideo.editor.effects.pip.Operation.values()[this.mSelectedPos].allwaysSelected);
                }
                operationViewHolder.mName.setSelected(true);
                this.mSelectedPos = adapterPosition;
                this.mSelectedHolder = operationViewHolder;
                this.mItemClick.onItemClick(getOperation(adapterPosition), adapterPosition);
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.pip.OperationAdapter.OperationViewHolder(android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_pip, viewGroup, false));
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.pip.OperationAdapter.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }
}
