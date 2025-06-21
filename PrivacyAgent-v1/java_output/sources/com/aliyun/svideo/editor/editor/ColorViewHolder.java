package com.aliyun.svideo.editor.editor;

/* loaded from: classes12.dex */
public class ColorViewHolder extends com.aliyun.svideo.editor.editor.ColorViewPagerAdapter.ViewHolder {
    private android.util.SparseArray<android.graphics.drawable.ColorDrawable> mColorDrawCache;
    private android.content.Context mContext;
    private android.util.SparseArray<android.graphics.drawable.GradientDrawable> mGradientDrawCache;
    private android.widget.GridView mGridView;
    private int mInitColor;
    private boolean mIsStroke;
    private com.aliyun.svideo.editor.editor.ColorViewHolder.OnItemClickListener mItemClickListener;

    public class ColorAdapter extends android.widget.BaseAdapter {
        public java.util.List<com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem> list;

        /* renamed from: com.aliyun.svideo.editor.editor.ColorViewHolder$ColorAdapter$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            final /* synthetic */ int val$position;

            public AnonymousClass1(int i) {
                this.val$position = i;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem data = ((com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItemViewMediator) view.getTag()).getData();
                if (com.aliyun.svideo.editor.editor.ColorViewHolder.this.mItemClickListener != null) {
                    com.aliyun.svideo.editor.editor.ColorViewHolder.this.mItemClickListener.onItemClick(data);
                }
                com.aliyun.svideo.editor.editor.ColorViewHolder.this.mGridView.setItemChecked(this.val$position, true);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        private ColorAdapter() {
            this.list = new java.util.ArrayList();
        }

        public /* synthetic */ ColorAdapter(com.aliyun.svideo.editor.editor.ColorViewHolder colorViewHolder, defpackage.cq cqVar) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.list.size();
        }

        @Override // android.widget.Adapter
        public com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem getItem(int i) {
            return this.list.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            android.view.View view2;
            com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItemViewMediator colorItemViewMediator;
            if (view == null) {
                colorItemViewMediator = com.aliyun.svideo.editor.editor.ColorViewHolder.this.new ColorItemViewMediator(viewGroup);
                view2 = colorItemViewMediator.getView();
            } else {
                view2 = view;
                colorItemViewMediator = (com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItemViewMediator) view.getTag();
            }
            colorItemViewMediator.setData(getItem(i), i == 0);
            if (com.aliyun.svideo.editor.editor.ColorViewHolder.this.mGridView.getCheckedItemPosition() == i) {
                colorItemViewMediator.setSelected(true);
            } else {
                colorItemViewMediator.setSelected(false);
            }
            colorItemViewMediator.setListener(new com.aliyun.svideo.editor.editor.ColorViewHolder.ColorAdapter.AnonymousClass1(i));
            return view2;
        }

        public void setData(java.util.List<com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    public class ColorItem {
        public int color;
        public boolean isStroke;
        public int strokeColor;

        public ColorItem() {
        }
    }

    public class ColorItemViewMediator {
        private com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem mData;
        private android.widget.ImageView mIvColor;
        private android.view.View root;
        private android.view.View select;

        public ColorItemViewMediator(android.view.ViewGroup viewGroup) {
            android.view.View inflate = android.view.View.inflate(viewGroup.getContext(), com.aliyun.svideo.editor.R.layout.alivc_editor_item_textcolor, null);
            this.root = inflate;
            this.mIvColor = (android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_color);
            this.select = this.root.findViewById(com.aliyun.svideo.editor.R.id.selected);
            this.root.setTag(this);
        }

        public com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem getData() {
            return this.mData;
        }

        public android.view.View getView() {
            return this.root;
        }

        public void setData(com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem colorItem, boolean z) {
            this.mData = colorItem;
            if (z) {
                this.mIvColor.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_font_color_none);
                return;
            }
            if (!colorItem.isStroke) {
                android.graphics.drawable.ColorDrawable colorDrawable = (android.graphics.drawable.ColorDrawable) com.aliyun.svideo.editor.editor.ColorViewHolder.this.mColorDrawCache.get(colorItem.color);
                if (colorDrawable == null) {
                    colorDrawable = new android.graphics.drawable.ColorDrawable(colorItem.color);
                    colorDrawable.setBounds(0, 0, this.mIvColor.getMeasuredWidth(), this.mIvColor.getMeasuredHeight());
                    com.aliyun.svideo.editor.editor.ColorViewHolder.this.mColorDrawCache.put(colorItem.color, colorDrawable);
                }
                this.mIvColor.setImageDrawable(colorDrawable);
                return;
            }
            android.graphics.drawable.GradientDrawable gradientDrawable = (android.graphics.drawable.GradientDrawable) com.aliyun.svideo.editor.editor.ColorViewHolder.this.mGradientDrawCache.get(colorItem.strokeColor);
            if (gradientDrawable == null) {
                gradientDrawable = new android.graphics.drawable.GradientDrawable();
                gradientDrawable.setStroke(8, colorItem.strokeColor);
                gradientDrawable.setShape(0);
                com.aliyun.svideo.editor.editor.ColorViewHolder.this.mGradientDrawCache.put(colorItem.strokeColor, gradientDrawable);
            }
            this.mIvColor.setImageDrawable(gradientDrawable);
        }

        public void setListener(android.view.View.OnClickListener onClickListener) {
            this.root.setOnClickListener(onClickListener);
        }

        public void setSelected(boolean z) {
            this.select.setVisibility(z ? 0 : 8);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem colorItem);
    }

    public ColorViewHolder(android.content.Context context, java.lang.String str, boolean z, int i) {
        super(context, str);
        this.mGradientDrawCache = new android.util.SparseArray<>();
        this.mColorDrawCache = new android.util.SparseArray<>();
        this.mContext = context;
        this.mIsStroke = z;
        this.mInitColor = i;
    }

    private java.util.List<com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem> initColors(boolean z, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.res.TypedArray obtainTypedArray = this.mContext.getResources().obtainTypedArray(com.aliyun.svideo.editor.R.array.qupai_text_edit_colors);
        for (int i2 = 0; i2 < 35; i2++) {
            int color = obtainTypedArray.getColor(i2, -1);
            com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem colorItem = new com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem();
            colorItem.color = color;
            colorItem.isStroke = z;
            arrayList.add(colorItem);
            if (z) {
                colorItem.strokeColor = color;
            }
        }
        obtainTypedArray.recycle();
        com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem colorItem2 = new com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem();
        colorItem2.color = -1;
        colorItem2.isStroke = z;
        if (z) {
            colorItem2.strokeColor = -1;
        }
        arrayList.add(0, colorItem2);
        return arrayList;
    }

    @Override // com.aliyun.svideo.editor.editor.ColorViewPagerAdapter.ViewHolder
    public void onBindViewHolder() {
        com.aliyun.svideo.editor.editor.ColorViewHolder.ColorAdapter colorAdapter = new com.aliyun.svideo.editor.editor.ColorViewHolder.ColorAdapter(this, null);
        colorAdapter.setData(initColors(this.mIsStroke, this.mInitColor));
        this.mGridView.setAdapter((android.widget.ListAdapter) colorAdapter);
    }

    @Override // com.aliyun.svideo.editor.editor.ColorViewPagerAdapter.ViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_text_color_container, (android.view.ViewGroup) null, false);
        this.mGridView = (android.widget.GridView) inflate.findViewById(com.aliyun.svideo.editor.R.id.grid_view);
        return inflate;
    }

    public void setItemClickListener(com.aliyun.svideo.editor.editor.ColorViewHolder.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }
}
