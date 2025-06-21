package com.aliyun.svideo.editor.effects.imv;

/* loaded from: classes12.dex */
public class ImvAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private static final int EFFECT_MORE = 2;
    private static final int EFFECT_NONE = 0;
    private static final int EFFECT_RESOURCE = 1;
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mItemClick;
    private com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder mSelectedHolder;
    private int selectId;
    java.util.List<com.aliyun.svideo.base.Form.IMVForm> mDataList = new java.util.ArrayList();
    private int mSelectedPos = 0;

    /* renamed from: com.aliyun.svideo.editor.effects.imv.ImvAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder val$iMVViewHolder;

        public AnonymousClass1(com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder iMVViewHolder) {
            this.val$iMVViewHolder = iMVViewHolder;
        }

        @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget
        public void onResourceReady(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.val$iMVViewHolder.mImage.setImageDrawable(drawable);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.imv.ImvAdapter$2, reason: invalid class name */
    public class AnonymousClass2 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder val$iMVViewHolder;

        public AnonymousClass2(com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder iMVViewHolder) {
            this.val$iMVViewHolder = iMVViewHolder;
        }

        @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget
        public void onResourceReady(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.val$iMVViewHolder.mImage.setImageDrawable(drawable);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.imv.ImvAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            android.content.Intent intent = new android.content.Intent(com.aliyun.svideo.editor.effects.imv.ImvAdapter.this.mContext, (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.MoreMVActivity.class);
            intent.putExtra("selected_id", com.aliyun.svideo.editor.effects.imv.ImvAdapter.this.selectId);
            ((android.app.Activity) com.aliyun.svideo.editor.effects.imv.ImvAdapter.this.mContext).startActivityForResult(intent, 1002);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.imv.ImvAdapter$4, reason: invalid class name */
    public class AnonymousClass4 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder val$iMVViewHolder;

        public AnonymousClass4(com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder iMVViewHolder) {
            this.val$iMVViewHolder = iMVViewHolder;
        }

        @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget
        public void onResourceReady(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.val$iMVViewHolder.mImage.setImageDrawable(drawable);
        }
    }

    public static class IMVViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.FrameLayout frameLayout;
        com.aliyun.svideo.base.widget.CircularImageView mImage;
        android.widget.ImageView mIvSelectState;
        android.widget.TextView mName;

        public IMVViewHolder(android.view.View view) {
            super(view);
            this.mImage = (com.aliyun.svideo.base.widget.CircularImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
            this.mName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_name);
            this.mIvSelectState = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_select_state);
        }
    }

    public ImvAdapter(android.content.Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataList.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i == getItemCount() - 1 ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder iMVViewHolder = (com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder) viewHolder;
        java.lang.String string = this.mContext.getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_none_effect);
        int itemViewType = getItemViewType(i);
        iMVViewHolder.itemView.setOnClickListener(this);
        if (itemViewType == 0) {
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_none).into(iMVViewHolder.mImage, new com.aliyun.svideo.editor.effects.imv.ImvAdapter.AnonymousClass1(iMVViewHolder));
        } else if (itemViewType == 2) {
            string = this.mContext.getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_mv_more);
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_more).into(iMVViewHolder.mImage, new com.aliyun.svideo.editor.effects.imv.ImvAdapter.AnonymousClass2(iMVViewHolder));
            iMVViewHolder.itemView.setOnClickListener(new com.aliyun.svideo.editor.effects.imv.ImvAdapter.AnonymousClass3());
        } else {
            com.aliyun.svideo.base.Form.IMVForm iMVForm = this.mDataList.get(i);
            java.lang.String name = iMVForm.getName();
            if (!com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(this.mContext) && iMVForm.getNameEn() != null) {
                name = iMVForm.getNameEn();
            }
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, iMVForm.getIcon()).into(iMVViewHolder.mImage, new com.aliyun.svideo.editor.effects.imv.ImvAdapter.AnonymousClass4(iMVViewHolder));
            string = name;
        }
        if (this.mSelectedPos == i) {
            iMVViewHolder.mImage.setVisibility(8);
            iMVViewHolder.mIvSelectState.setVisibility(0);
            this.mSelectedHolder = iMVViewHolder;
        } else {
            iMVViewHolder.mImage.setVisibility(0);
            iMVViewHolder.mIvSelectState.setVisibility(8);
        }
        iMVViewHolder.mName.setText(string);
        iMVViewHolder.itemView.setTag(viewHolder);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder iMVViewHolder;
        int adapterPosition;
        if (this.mItemClick != null && this.mSelectedPos != (adapterPosition = (iMVViewHolder = (com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder) view.getTag()).getAdapterPosition())) {
            setEffectInfo(iMVViewHolder, adapterPosition);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        android.view.View inflate = android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_effect, viewGroup, false);
        com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder iMVViewHolder = new com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder(inflate);
        iMVViewHolder.frameLayout = (android.widget.FrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.resource_image);
        return iMVViewHolder;
    }

    public void setData(java.util.List<com.aliyun.svideo.base.Form.IMVForm> list) {
        if (list == null) {
            return;
        }
        this.mDataList = list;
        notifyDataSetChanged();
    }

    public void setEffectInfo(com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder iMVViewHolder, int i) {
        if (this.mSelectedPos == i || iMVViewHolder == null) {
            return;
        }
        com.aliyun.svideo.editor.effects.imv.ImvAdapter.IMVViewHolder iMVViewHolder2 = this.mSelectedHolder;
        if (iMVViewHolder2 != null) {
            iMVViewHolder2.mImage.setVisibility(0);
            this.mSelectedHolder.mIvSelectState.setVisibility(8);
        }
        iMVViewHolder.mImage.setVisibility(8);
        iMVViewHolder.mIvSelectState.setVisibility(0);
        this.mSelectedPos = i;
        this.mSelectedHolder = iMVViewHolder;
        setEffecteffective(i);
    }

    public void setEffecteffective(int i) {
        if (i < 0 || i >= this.mDataList.size()) {
            return;
        }
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
        effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.MV;
        effectInfo.list = this.mDataList.get(i).getAspectList();
        int id = this.mDataList.get(i).getId();
        effectInfo.id = id;
        this.selectId = id;
        com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener = this.mItemClick;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(effectInfo, id);
        }
    }

    public void setEffecteffectiveAndNotify(int i) {
        notifyItemChanged(this.mSelectedPos);
        notifyItemChanged(i);
        this.mSelectedPos = i;
        setEffecteffective(i);
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }

    public void setSelectedPos(int i) {
        this.mSelectedPos = i;
        if (this.mDataList.size() >= i) {
            this.selectId = this.mDataList.get(i).getId();
        }
    }
}
