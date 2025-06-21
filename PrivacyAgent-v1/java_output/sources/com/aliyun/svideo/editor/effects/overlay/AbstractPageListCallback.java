package com.aliyun.svideo.editor.effects.overlay;

/* loaded from: classes12.dex */
public abstract class AbstractPageListCallback implements com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.CallBack<com.aliyun.svideo.editor.effects.overlay.PageViewHolder> {
    private static final int NO_SELECTED = -1;
    private android.content.Context mContext;
    private int mGroupId;
    private java.util.ArrayList<com.aliyun.svideo.base.Form.PasterForm> mListData = new java.util.ArrayList<>();
    private int mCurrSelectedPos = -1;
    private java.lang.StringBuilder mIconBuilder = new java.lang.StringBuilder();

    /* renamed from: com.aliyun.svideo.editor.effects.overlay.AbstractPageListCallback$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.overlay.PageViewHolder val$holder;

        public AnonymousClass1(com.aliyun.svideo.editor.effects.overlay.PageViewHolder pageViewHolder) {
            this.val$holder = pageViewHolder;
        }

        @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget
        public void onResourceReady(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.val$holder.mImageView.setImageDrawable(drawable);
        }
    }

    public AbstractPageListCallback(android.content.Context context) {
        this.mContext = context;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public com.aliyun.svideo.base.Form.PasterForm getSelectedItem() {
        int i = this.mCurrSelectedPos;
        if (i != -1 && i >= 0 && i < this.mListData.size()) {
            return this.mListData.get(this.mCurrSelectedPos);
        }
        return null;
    }

    public abstract void notifySelected(int i, int i2);

    @Override // com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.CallBack
    public void onBindViewHolder(com.aliyun.svideo.editor.effects.overlay.PageViewHolder pageViewHolder, int i) {
        java.util.ArrayList<com.aliyun.svideo.base.Form.PasterForm> arrayList = this.mListData;
        if (arrayList == null || i >= arrayList.size() || i < 0) {
            return;
        }
        com.aliyun.svideo.base.Form.PasterForm pasterForm = this.mListData.get(i);
        if (this.mIconBuilder.length() > 0) {
            java.lang.StringBuilder sb = this.mIconBuilder;
            sb.delete(0, sb.length());
        }
        java.lang.StringBuilder sb2 = this.mIconBuilder;
        sb2.append(pasterForm.getPath());
        sb2.append("/icon.png");
        new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, this.mIconBuilder.toString()).into(pageViewHolder.mImageView, new com.aliyun.svideo.editor.effects.overlay.AbstractPageListCallback.AnonymousClass1(pageViewHolder));
    }

    @Override // com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.CallBack
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        android.view.View inflate = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_paster, viewGroup, false);
        com.aliyun.svideo.editor.effects.overlay.PageViewHolder pageViewHolder = new com.aliyun.svideo.editor.effects.overlay.PageViewHolder(inflate);
        pageViewHolder.mImageView = (com.aliyun.svideo.base.widget.CircularImageView) inflate.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
        return pageViewHolder;
    }

    @Override // com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.CallBack
    public void onItemClickListener(android.view.View view, int i) {
        int i2 = this.mCurrSelectedPos;
        if (i2 == -1) {
            this.mCurrSelectedPos = i;
            i2 = -1;
        } else {
            this.mCurrSelectedPos = i;
        }
        notifySelected(this.mCurrSelectedPos, i2);
    }

    @Override // com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView.CallBack
    public void onItemLongClickListener(android.view.View view, int i) {
    }

    public void resetSelected() {
        this.mCurrSelectedPos = -1;
    }

    public void setData(com.aliyun.svideo.base.Form.ResourceForm resourceForm) {
        if (resourceForm == null || resourceForm.getPasterList() == null) {
            return;
        }
        this.mGroupId = resourceForm.getId();
        this.mListData = (java.util.ArrayList) resourceForm.getPasterList();
    }
}
