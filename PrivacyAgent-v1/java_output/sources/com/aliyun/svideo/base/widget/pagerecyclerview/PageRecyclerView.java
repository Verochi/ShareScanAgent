package com.aliyun.svideo.base.widget.pagerecyclerview;

/* loaded from: classes.dex */
public class PageRecyclerView extends androidx.recyclerview.widget.RecyclerView {
    private static final int ITEM_TYPE_EMPTY = 1;
    private static final int ITEM_TYPE_NORMAL = 2;
    private int currentPage;
    private android.content.Context mContext;
    private com.aliyun.svideo.base.widget.pagerecyclerview.PageIndicatorView mIndicatorView;
    private boolean mIsAutoScrollPage;
    private com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.PageAdapter myAdapter;
    private int pageMargin;
    private int realPosition;
    private int scrollState;
    private float scrollX;
    private int shortestDistance;
    private float slideDistance;
    private int spanColumn;
    private int spanRow;
    private int totalPage;

    public interface CallBack<T extends androidx.recyclerview.widget.RecyclerView.ViewHolder> {
        void onBindViewHolder(T t, int i);

        androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i);

        void onItemClickListener(android.view.View view, int i);

        void onItemLongClickListener(android.view.View view, int i);
    }

    public class EmptyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public EmptyViewHolder(android.view.View view) {
            super(view);
        }
    }

    public class PageAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
        private java.util.List<?> dataList;
        private int itemCount;
        private int itemWidth;
        private com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.CallBack mCallBack;

        /* renamed from: com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView$PageAdapter$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.PageAdapter.this.mCallBack.onItemClickListener(view, ((java.lang.Integer) view.getTag()).intValue());
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* renamed from: com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView$PageAdapter$2, reason: invalid class name */
        public class AnonymousClass2 implements android.view.View.OnLongClickListener {
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(android.view.View view) {
                com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.PageAdapter.this.mCallBack.onItemLongClickListener(view, ((java.lang.Integer) view.getTag()).intValue());
                return true;
            }
        }

        public PageAdapter(java.util.List<?> list, com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.CallBack callBack) {
            this.dataList = list;
            this.mCallBack = callBack;
            this.itemCount = list.size();
        }

        private int countRealPosition(int i) {
            int i2 = i % (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn);
            com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.realPosition = (i - i2) + ((i2 % com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow) * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn) + (i2 / com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow);
            return com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.realPosition;
        }

        private int reflectLayoutPosition(int i) {
            int i2 = i % (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn);
            return (i - i2) + ((i2 % com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn) * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow) + (i2 / com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn);
        }

        private void setListener(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setOnClickListener(new com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.PageAdapter.AnonymousClass1());
            viewHolder.itemView.setOnLongClickListener(new com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.PageAdapter.AnonymousClass2());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.dataList.size();
            this.itemCount = size;
            return size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            countRealPosition(i);
            return com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.realPosition >= this.dataList.size() ? 1 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            if (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn == 1) {
                viewHolder.itemView.getLayoutParams().width = this.itemWidth + (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.pageMargin * 2);
                viewHolder.itemView.setPadding(com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.pageMargin, 0, com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.pageMargin, 0);
            } else {
                int i2 = i % (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn);
                if (i2 < com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow) {
                    viewHolder.itemView.getLayoutParams().width = this.itemWidth + com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.pageMargin;
                    viewHolder.itemView.setPadding(com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.pageMargin, 0, 0, 0);
                } else if (i2 >= (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn) - com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow) {
                    viewHolder.itemView.getLayoutParams().width = this.itemWidth + com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.pageMargin;
                    viewHolder.itemView.setPadding(0, 0, com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.pageMargin, 0);
                } else {
                    viewHolder.itemView.getLayoutParams().width = this.itemWidth;
                    viewHolder.itemView.setPadding(0, 0, 0, 0);
                }
            }
            viewHolder.itemView.setTag(java.lang.Integer.valueOf(com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.realPosition));
            setListener(viewHolder);
            if (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.realPosition >= this.dataList.size()) {
                viewHolder.itemView.setVisibility(4);
            } else {
                viewHolder.itemView.setVisibility(0);
                this.mCallBack.onBindViewHolder(viewHolder, com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.realPosition);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            android.graphics.Point point = new android.graphics.Point();
            ((android.view.WindowManager) viewGroup.getContext().getSystemService("window")).getDefaultDisplay().getSize(point);
            if (this.itemWidth <= 0) {
                this.itemWidth = (point.x - (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.pageMargin * 2)) / com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn;
            }
            androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder = this.mCallBack.onCreateViewHolder(viewGroup, i);
            onCreateViewHolder.itemView.measure(0, 0);
            onCreateViewHolder.itemView.getLayoutParams().width = this.itemWidth;
            onCreateViewHolder.itemView.getLayoutParams().height = onCreateViewHolder.itemView.getMeasuredHeight();
            return onCreateViewHolder;
        }

        public void realNotifyDataSetChanged() {
            com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.update();
            notifyDataSetChanged();
        }

        public void realNotifyItemChanged(int i) {
            com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.update();
            notifyItemChanged(reflectLayoutPosition(i));
        }

        public void realNotifyItemChanged(int i, java.lang.Object obj) {
            notifyItemChanged(reflectLayoutPosition(i), obj);
            com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.update();
        }

        public void remove(int i) {
            if (i < this.dataList.size()) {
                this.dataList.remove(i);
                this.itemCount--;
                notifyItemRemoved(i);
                notifyItemRangeChanged((com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.currentPage - 1) * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn, com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.currentPage * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanRow * com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.spanColumn);
                com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.this.update();
            }
        }
    }

    public PageRecyclerView(android.content.Context context) {
        this(context, null);
    }

    public PageRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.myAdapter = null;
        this.slideDistance = 0.0f;
        this.scrollX = 0.0f;
        this.spanRow = 1;
        this.spanColumn = 3;
        this.totalPage = 0;
        this.currentPage = 1;
        this.pageMargin = 0;
        this.mIndicatorView = null;
        this.realPosition = 0;
        this.scrollState = 0;
        this.mIsAutoScrollPage = true;
        defaultInit(context);
    }

    private void defaultInit(android.content.Context context) {
        this.mContext = context;
        setLayoutManager(new com.aliyun.svideo.base.widget.pagerecyclerview.AutoGridLayoutManager(context, this.spanRow, 0, false));
        setOverScrollMode(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        int ceil = (int) java.lang.Math.ceil(this.myAdapter.dataList.size() / (this.spanRow * this.spanColumn));
        if (ceil != this.totalPage) {
            this.mIndicatorView.initIndicator(ceil);
            int i = this.totalPage;
            if (ceil < i && this.currentPage == i) {
                this.currentPage = ceil;
                smoothScrollBy(-getWidth(), 0);
            }
            this.mIndicatorView.setSelectedPage(this.currentPage - 1);
            this.totalPage = ceil;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.shortestDistance = getMeasuredWidth() / 6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            float f = this.slideDistance;
            if (f != 0.0f) {
                this.scrollState = 0;
                if (f < 0.0f) {
                    this.currentPage = (int) java.lang.Math.ceil(this.scrollX / getWidth());
                    if ((r0 * getWidth()) - this.scrollX < this.shortestDistance) {
                        this.currentPage++;
                    }
                } else {
                    int ceil = ((int) java.lang.Math.ceil(this.scrollX / getWidth())) + 1;
                    this.currentPage = ceil;
                    int i2 = this.totalPage;
                    if (ceil > i2) {
                        this.currentPage = i2;
                    } else if (this.scrollX - ((ceil - 2) * getWidth()) < this.shortestDistance) {
                        this.currentPage--;
                    }
                }
                if (this.mIsAutoScrollPage) {
                    smoothScrollBy((int) (((this.currentPage - 1) * getWidth()) - this.scrollX), 0);
                    this.mIndicatorView.setSelectedPage(this.currentPage - 1);
                }
                this.slideDistance = 0.0f;
            }
        } else if (i == 1) {
            this.scrollState = 1;
        } else if (i == 2) {
            this.scrollState = 2;
        }
        super.onScrollStateChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        float f = i;
        this.scrollX += f;
        if (this.scrollState == 1) {
            this.slideDistance += f;
        }
        super.onScrolled(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(androidx.recyclerview.widget.RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.myAdapter = (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.PageAdapter) adapter;
        update();
    }

    public void setAutoScrollPage(boolean z) {
        this.mIsAutoScrollPage = z;
    }

    public void setIndicator(com.aliyun.svideo.base.widget.pagerecyclerview.PageIndicatorView pageIndicatorView) {
        this.mIndicatorView = pageIndicatorView;
    }

    public void setPageMargin(int i) {
        this.pageMargin = i;
    }

    public void setPageSize(int i, int i2) {
        if (i <= 0) {
            i = this.spanRow;
        }
        this.spanRow = i;
        if (i2 <= 0) {
            i2 = this.spanColumn;
        }
        this.spanColumn = i2;
        setLayoutManager(new com.aliyun.svideo.base.widget.pagerecyclerview.AutoGridLayoutManager(this.mContext, i, 0, false));
    }
}
