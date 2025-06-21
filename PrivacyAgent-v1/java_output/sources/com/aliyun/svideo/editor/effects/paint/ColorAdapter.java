package com.aliyun.svideo.editor.effects.paint;

/* loaded from: classes12.dex */
public class ColorAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private java.util.List<java.lang.Integer> mColorList;
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect mPaintSelect;
    private com.aliyun.svideo.editor.effects.paint.ColorAdapter.ColorViewHolder mSelectHolder;
    private int mSelectedPos = 1;

    /* renamed from: com.aliyun.svideo.editor.effects.paint.ColorAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mPaintSelect != null) {
                com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mPaintSelect.onUndo();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.paint.ColorAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ int val$position;
        final /* synthetic */ com.aliyun.svideo.editor.effects.paint.ColorAdapter.ColorViewHolder val$viewHolder;

        public AnonymousClass2(int i, com.aliyun.svideo.editor.effects.paint.ColorAdapter.ColorViewHolder colorViewHolder) {
            this.val$position = i;
            this.val$viewHolder = colorViewHolder;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mPaintSelect != null) {
                com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mPaintSelect.onColorSelect(((java.lang.Integer) com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mColorList.get(this.val$position)).intValue());
                this.val$viewHolder.colorImage.setSelected(true);
                if (com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mSelectHolder != null) {
                    com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mSelectHolder.colorImage.setSelected(false);
                }
                com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mSelectedPos = this.val$position;
                com.aliyun.svideo.editor.effects.paint.ColorAdapter.this.mSelectHolder = this.val$viewHolder;
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class ColorViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.ImageView colorImage;

        public ColorViewHolder(android.view.View view) {
            super(view);
            this.colorImage = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.paint_color_image);
        }
    }

    public ColorAdapter(android.content.Context context) {
        this.mColorList = new java.util.ArrayList();
        this.mContext = context;
        this.mColorList = initColors();
    }

    private java.util.List<java.lang.Integer> initColors() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.res.TypedArray obtainTypedArray = this.mContext.getResources().obtainTypedArray(com.aliyun.svideo.editor.R.array.paint_colors);
        int length = obtainTypedArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(java.lang.Integer.valueOf(obtainTypedArray.getColor(i, -1)));
        }
        arrayList.add(0, 0);
        obtainTypedArray.recycle();
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mColorList.size();
    }

    public int getSelectedPos() {
        return this.mSelectedPos;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.paint.ColorAdapter.ColorViewHolder colorViewHolder = (com.aliyun.svideo.editor.effects.paint.ColorAdapter.ColorViewHolder) viewHolder;
        if (i == 0) {
            colorViewHolder.colorImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_effect_revoke);
            colorViewHolder.colorImage.setOnClickListener(new com.aliyun.svideo.editor.effects.paint.ColorAdapter.AnonymousClass1());
        } else {
            colorViewHolder.colorImage.setColorFilter(this.mColorList.get(i).intValue());
            colorViewHolder.colorImage.setOnClickListener(new com.aliyun.svideo.editor.effects.paint.ColorAdapter.AnonymousClass2(i, colorViewHolder));
        }
        if (this.mSelectedPos != i) {
            colorViewHolder.colorImage.setSelected(false);
        } else {
            colorViewHolder.colorImage.setSelected(true);
            this.mSelectHolder = colorViewHolder;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.paint.ColorAdapter.ColorViewHolder(android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_color, viewGroup, false));
    }

    public void setPaintSelect(com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect paintSelect) {
        this.mPaintSelect = paintSelect;
    }

    public void setSelectedPos(int i) {
        int indexOf = this.mColorList.indexOf(java.lang.Integer.valueOf(i));
        if (indexOf < 0) {
            return;
        }
        this.mSelectedPos = indexOf;
    }
}
