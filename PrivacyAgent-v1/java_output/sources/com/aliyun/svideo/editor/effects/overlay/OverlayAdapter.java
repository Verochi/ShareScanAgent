package com.aliyun.svideo.editor.effects.overlay;

/* loaded from: classes12.dex */
public class OverlayAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private android.content.Context mContext;

    public static class OverlayViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public OverlayViewHolder(android.view.View view) {
            super(view);
        }
    }

    public OverlayAdapter(android.content.Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.overlay.OverlayAdapter.OverlayViewHolder(android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_paster, viewGroup, false));
    }
}
