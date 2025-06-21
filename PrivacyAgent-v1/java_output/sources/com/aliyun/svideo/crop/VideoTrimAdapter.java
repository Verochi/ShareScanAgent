package com.aliyun.svideo.crop;

/* loaded from: classes.dex */
public class VideoTrimAdapter extends android.widget.BaseAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private java.util.ArrayList<java.lang.ref.SoftReference<android.graphics.Bitmap>> mBitmaps;
    private android.content.Context mContext;
    private int screenWidth;

    public class ViewHolder {
        private android.widget.ImageView thumbImage;
        private com.aliyun.svideo.base.widget.SquareFrameLayout thumblayout;

        public ViewHolder() {
        }
    }

    public VideoTrimAdapter(android.content.Context context, java.util.ArrayList<java.lang.ref.SoftReference<android.graphics.Bitmap>> arrayList) {
        this.mContext = context;
        this.mBitmaps = arrayList;
        this.screenWidth = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    private int getItemCount() {
        java.util.ArrayList<java.lang.ref.SoftReference<android.graphics.Bitmap>> arrayList = this.mBitmaps;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void add(java.lang.ref.SoftReference<android.graphics.Bitmap> softReference) {
        if (this.mBitmaps == null) {
            this.mBitmaps = new java.util.ArrayList<>();
        }
        this.mBitmaps.add(softReference);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return getItemCount();
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i) {
        return java.lang.Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        android.view.View view2;
        com.aliyun.svideo.crop.VideoTrimAdapter.ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new com.aliyun.svideo.crop.VideoTrimAdapter.ViewHolder();
            view2 = android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.crop.R.layout.alivc_crop_item_trim_video_thumbnail, viewGroup, false);
            viewHolder.thumblayout = (com.aliyun.svideo.base.widget.SquareFrameLayout) view2.findViewById(com.aliyun.svideo.crop.R.id.aliyun_video_tailor_frame);
            viewHolder.thumbImage = (android.widget.ImageView) view2.findViewById(com.aliyun.svideo.crop.R.id.aliyun_video_tailor_img_item);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (com.aliyun.svideo.crop.VideoTrimAdapter.ViewHolder) view.getTag();
        }
        android.view.ViewGroup.LayoutParams layoutParams = viewHolder.thumblayout.getLayoutParams();
        layoutParams.width = (this.screenWidth - com.aliyun.svideo.common.utils.DensityUtils.dip2px(this.mContext, 40.0f)) / 10;
        viewHolder.thumblayout.setLayoutParams(layoutParams);
        android.graphics.Bitmap bitmap = this.mBitmaps.get(i).get();
        if (bitmap != null) {
            viewHolder.thumbImage.setImageBitmap(bitmap);
        }
        return view2;
    }
}
