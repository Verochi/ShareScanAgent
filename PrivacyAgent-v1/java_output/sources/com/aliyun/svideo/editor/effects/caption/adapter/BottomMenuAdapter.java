package com.aliyun.svideo.editor.effects.caption.adapter;

/* loaded from: classes12.dex */
public class BottomMenuAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private java.util.List<com.aliyun.svideo.editor.bean.AlivcEditMenuBean> data;
    private com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.OnItemClickListener mItemClick;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.this.mItemClick != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.this.mItemClick.onItemClick(com.aliyun.svideo.editor.bean.AlivcEditMenus.AddText);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class MenuViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView menuTv;

        public MenuViewHolder(android.view.View view) {
            super(view);
            this.menuTv = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_roll_caption_subtitle);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(com.aliyun.svideo.editor.bean.AlivcEditMenus alivcEditMenus);
    }

    public void clearData() {
        this.data.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<com.aliyun.svideo.editor.bean.AlivcEditMenuBean> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.MenuViewHolder menuViewHolder = (com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.MenuViewHolder) viewHolder;
        menuViewHolder.menuTv.setText(this.data.get(i).menuName);
        android.graphics.drawable.Drawable drawable = menuViewHolder.menuTv.getContext().getResources().getDrawable(this.data.get(i).resourceId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        menuViewHolder.menuTv.setCompoundDrawables(null, drawable, null, null);
        menuViewHolder.itemView.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.AnonymousClass1());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.MenuViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_menu, viewGroup, false));
    }

    public void setData(java.util.List<com.aliyun.svideo.editor.bean.AlivcEditMenuBean> list) {
        if (list == null) {
            return;
        }
        this.data = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }
}
