package com.aliyun.svideo.editor.effects.lut;

/* loaded from: classes12.dex */
public class LutAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mItemClick;
    private com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder mSelectedHolder;
    private int mSelectedPos = 0;
    private java.util.List<java.lang.String> mFilterList = new java.util.ArrayList();

    /* renamed from: com.aliyun.svideo.editor.effects.lut.LutAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder val$filterViewHolder;

        public AnonymousClass1(com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder filterViewHolder) {
            this.val$filterViewHolder = filterViewHolder;
        }

        @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget
        public void onResourceReady(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.val$filterViewHolder.mImage.setImageDrawable(drawable);
        }
    }

    public static class FilterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.FrameLayout frameLayout;
        com.aliyun.svideo.base.widget.CircularImageView mImage;
        android.widget.ImageView mIvSelectState;
        android.widget.TextView mName;

        public FilterViewHolder(android.view.View view) {
            super(view);
            this.mImage = (com.aliyun.svideo.base.widget.CircularImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
            this.mName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_name);
            this.mIvSelectState = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_select_state);
        }
    }

    public LutAdapter(android.content.Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mFilterList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        java.lang.String str;
        com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder filterViewHolder = (com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder) viewHolder;
        java.lang.String string = this.mContext.getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_none_effect);
        java.lang.String str2 = this.mFilterList.get(i);
        if (com.aliyun.svideo.editor.contant.EditorConstants.EFFECT_FILTER_LOCAL_LUT_CLEAR.equals(str2)) {
            filterViewHolder.mImage.setImageResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_none);
            string = this.mContext.getString(com.aliyun.svideo.editor.R.string.alivc_svideo_filter_lut_remove);
        } else if (com.aliyun.svideo.editor.contant.EditorConstants.EFFECT_FILTER_LOCAL_LUT_ADD.equals(str2)) {
            filterViewHolder.mImage.setImageResource(com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_local_lut);
            string = this.mContext.getString(com.aliyun.svideo.editor.R.string.alivc_svideo_filter_lut_add);
        } else {
            int lastIndexOf = str2.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            if (lastIndexOf > 0) {
                java.lang.String substring = str2.substring(0, lastIndexOf);
                str = substring + java.io.File.separator + com.aliyun.svideo.editor.contant.CaptionConfig.COOL_TEXT_FILE_ICON_NAME;
                int lastIndexOf2 = substring.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                if (lastIndexOf2 > 0) {
                    string = com.aliyun.svideo.editor.contant.EditorConstants.LUT_FILE_SEQ_TO_NAME.get(substring.substring(lastIndexOf2 + 1));
                }
            } else {
                str = "";
                string = "";
            }
            if (filterViewHolder != null) {
                new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, str).into(filterViewHolder.mImage, new com.aliyun.svideo.editor.effects.lut.LutAdapter.AnonymousClass1(filterViewHolder));
            }
        }
        if (this.mSelectedPos > this.mFilterList.size()) {
            this.mSelectedPos = 0;
        }
        if (this.mSelectedPos == i) {
            filterViewHolder.mImage.setVisibility(8);
            filterViewHolder.mIvSelectState.setVisibility(0);
            this.mSelectedHolder = filterViewHolder;
        } else {
            filterViewHolder.mImage.setVisibility(0);
            filterViewHolder.mIvSelectState.setVisibility(8);
        }
        filterViewHolder.mName.setText(string);
        filterViewHolder.itemView.setTag(viewHolder);
        filterViewHolder.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder filterViewHolder;
        int adapterPosition;
        java.lang.String substring;
        int lastIndexOf;
        com.aliyun.svideo.base.widget.CircularImageView circularImageView;
        if (this.mItemClick != null && this.mSelectedPos != (adapterPosition = (filterViewHolder = (com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder) view.getTag()).getAdapterPosition())) {
            com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder filterViewHolder2 = this.mSelectedHolder;
            if (filterViewHolder2 != null && (circularImageView = filterViewHolder2.mImage) != null) {
                circularImageView.setVisibility(0);
                this.mSelectedHolder.mIvSelectState.setVisibility(8);
            }
            filterViewHolder.mImage.setVisibility(8);
            filterViewHolder.mIvSelectState.setVisibility(0);
            this.mSelectedPos = adapterPosition;
            this.mSelectedHolder = filterViewHolder;
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT;
            java.lang.String str = this.mFilterList.get(adapterPosition);
            com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(str);
            int lastIndexOf2 = str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            if (lastIndexOf2 > 0 && (lastIndexOf = (substring = str.substring(0, lastIndexOf2)).lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) > 0) {
                source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getAppResUri(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_LUT, "0", substring.substring(lastIndexOf + 1)));
            }
            source.setId(java.lang.String.valueOf(adapterPosition));
            effectInfo.setSource(source);
            effectInfo.id = adapterPosition;
            this.mItemClick.onItemClick(effectInfo, adapterPosition);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        android.view.View inflate = android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_effect, viewGroup, false);
        com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder filterViewHolder = new com.aliyun.svideo.editor.effects.lut.LutAdapter.FilterViewHolder(inflate);
        filterViewHolder.frameLayout = (android.widget.FrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.resource_image);
        return filterViewHolder;
    }

    public void setDataList(java.util.List<java.lang.String> list) {
        this.mFilterList.clear();
        this.mFilterList.add(com.aliyun.svideo.editor.contant.EditorConstants.EFFECT_FILTER_LOCAL_LUT_CLEAR);
        this.mFilterList.add(com.aliyun.svideo.editor.contant.EditorConstants.EFFECT_FILTER_LOCAL_LUT_ADD);
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mFilterList.addAll(list);
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }

    public void setSelectedPos(int i) {
        this.mSelectedPos = i;
    }
}
