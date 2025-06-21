package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class RollCaptionColorAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.RollCaptionColorViewHolder> {
    private java.util.List<java.lang.Integer> mColorList = initColors();
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.OnRollCaptionColorItemClickListener mListener;

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.RollCaptionColorViewHolder val$holder;

        public AnonymousClass1(com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.RollCaptionColorViewHolder rollCaptionColorViewHolder) {
            this.val$holder = rollCaptionColorViewHolder;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.this.mListener != null) {
                com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.this.mListener.onItemClick(((java.lang.Integer) com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.this.mColorList.get(this.val$holder.getAdapterPosition())).intValue());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface OnRollCaptionColorItemClickListener {
        void onItemClick(int i);
    }

    public static class RollCaptionColorViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.ImageView mColorImage;

        public RollCaptionColorViewHolder(android.view.View view) {
            super(view);
            this.mColorImage = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.paint_color_image);
        }
    }

    public RollCaptionColorAdapter(android.content.Context context) {
        this.mContext = context;
    }

    private java.util.List<java.lang.Integer> initColors() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.res.TypedArray obtainTypedArray = this.mContext.getResources().obtainTypedArray(com.aliyun.svideo.editor.R.array.paint_colors);
        int length = obtainTypedArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(java.lang.Integer.valueOf(obtainTypedArray.getColor(i, -1)));
        }
        obtainTypedArray.recycle();
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<java.lang.Integer> list = this.mColorList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.RollCaptionColorViewHolder rollCaptionColorViewHolder, int i) {
        rollCaptionColorViewHolder.mColorImage.setColorFilter(this.mColorList.get(i).intValue());
        rollCaptionColorViewHolder.mColorImage.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.AnonymousClass1(rollCaptionColorViewHolder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.RollCaptionColorViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.RollCaptionColorViewHolder(android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_color, viewGroup, false));
    }

    public void setOnRollCaptionColorItemClickListener(com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.OnRollCaptionColorItemClickListener onRollCaptionColorItemClickListener) {
        this.mListener = onRollCaptionColorItemClickListener;
    }
}
