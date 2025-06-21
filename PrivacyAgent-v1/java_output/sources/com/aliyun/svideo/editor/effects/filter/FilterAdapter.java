package com.aliyun.svideo.editor.effects.filter;

/* loaded from: classes12.dex */
public class FilterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mItemClick;
    private com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder mSelectedHolder;
    private int mSelectedPos = 0;
    private java.util.List<java.lang.String> mFilterList = new java.util.ArrayList();

    /* renamed from: com.aliyun.svideo.editor.effects.filter.FilterAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder val$filterViewHolder;

        public AnonymousClass1(com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder filterViewHolder) {
            this.val$filterViewHolder = filterViewHolder;
        }

        @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget
        public void onResourceReady(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.val$filterViewHolder.mImage.setImageDrawable(drawable);
        }
    }

    public static class FilterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.FrameLayout frameLayout;
        android.view.View line;
        android.widget.ImageView mBackImage;
        android.widget.TextView mBackName;
        android.widget.LinearLayout mBackView;
        androidx.cardview.widget.CardView mCardView;
        android.widget.ImageView mImage;
        android.widget.ImageView mIvSelectLayerMask;
        android.widget.ImageView mIvSelectState;
        android.widget.TextView mName;
        android.widget.LinearLayout mResourceView;

        public FilterViewHolder(android.view.View view) {
            super(view);
            this.mBackView = (android.widget.LinearLayout) view.findViewById(com.aliyun.svideo.editor.R.id.ll_back_view);
            this.mResourceView = (android.widget.LinearLayout) view.findViewById(com.aliyun.svideo.editor.R.id.ll_resource_view);
            this.mBackImage = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_back_view);
            this.mBackName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_back_name);
            this.mImage = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
            this.mName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_name);
            this.mIvSelectState = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_select_state);
            this.mIvSelectLayerMask = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_select_layer_mask);
            this.mCardView = (androidx.cardview.widget.CardView) view.findViewById(com.aliyun.svideo.editor.R.id.card_view);
            this.mIvSelectState.setImageResource(com.aliyun.svideo.editor.R.mipmap.moji_svideo_icon_effect_confirm);
            this.line = view.findViewById(com.aliyun.svideo.editor.R.id.line);
        }
    }

    public FilterAdapter(android.content.Context context) {
        this.mContext = context;
    }

    private java.lang.String getFilterName(java.lang.String str) {
        java.lang.String str2;
        if (com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(this.mContext)) {
            str2 = str + "/config.json";
        } else {
            str2 = str + "/configEn.json";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            java.io.FileReader fileReader = new java.io.FileReader(new java.io.File(str2));
            while (true) {
                int read = fileReader.read();
                if (read == -1) {
                    break;
                }
                stringBuffer.append((char) read);
            }
            fileReader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        try {
            return new org.json.JSONObject(stringBuffer.toString()).optString("name");
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mFilterList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        int parseColor;
        int parseColor2;
        com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder filterViewHolder = (com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder) viewHolder;
        java.lang.String string = this.mContext.getString(com.aliyun.svideo.editor.R.string.moji_editor_dialog_none_effect);
        java.lang.String str = this.mFilterList.get(i);
        if (str == null || "".equals(str)) {
            if (i == this.mSelectedPos) {
                filterViewHolder.mBackImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.moji_svideo_icon_effect_confirm);
                this.mSelectedHolder = filterViewHolder;
            } else {
                filterViewHolder.mBackImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.moji_svideo_effect_none);
            }
            filterViewHolder.mBackName.setText(string);
            filterViewHolder.mResourceView.setVisibility(8);
            filterViewHolder.mBackView.setVisibility(0);
            filterViewHolder.line.setVisibility(0);
            filterViewHolder.mIvSelectState.setVisibility(8);
            filterViewHolder.mCardView.setCardBackgroundColor(android.graphics.Color.parseColor("#33FFFFFF"));
            filterViewHolder.mIvSelectLayerMask.setVisibility(8);
        } else {
            if (i == this.mSelectedPos) {
                filterViewHolder.mIvSelectLayerMask.setVisibility(0);
                filterViewHolder.mIvSelectState.setVisibility(0);
            } else {
                filterViewHolder.mIvSelectLayerMask.setVisibility(8);
                filterViewHolder.mIvSelectState.setVisibility(8);
            }
            filterViewHolder.mResourceView.setVisibility(0);
            filterViewHolder.mBackView.setVisibility(8);
            filterViewHolder.line.setVisibility(8);
            int i2 = (i - 1) % 5;
            if (i2 == 0) {
                parseColor = android.graphics.Color.parseColor("#D49696");
                parseColor2 = android.graphics.Color.parseColor("#CCD49696");
            } else if (i2 == 1) {
                parseColor = android.graphics.Color.parseColor("#B39478");
                parseColor2 = android.graphics.Color.parseColor("#CCB39478");
            } else if (i2 == 2) {
                parseColor = android.graphics.Color.parseColor("#EF7979");
                parseColor2 = android.graphics.Color.parseColor("#CCEF7979");
            } else if (i2 != 3) {
                parseColor = android.graphics.Color.parseColor("#48525E");
                parseColor2 = android.graphics.Color.parseColor("#CC48525E");
            } else {
                parseColor = android.graphics.Color.parseColor("#E2AD45");
                parseColor2 = android.graphics.Color.parseColor("#CCE2AD45");
            }
            filterViewHolder.mCardView.setCardBackgroundColor(parseColor);
            filterViewHolder.mIvSelectLayerMask.setBackgroundColor(parseColor2);
            java.lang.String filterName = getFilterName(str);
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, str + "/icon.png").into(filterViewHolder.mImage, new com.aliyun.svideo.editor.effects.filter.FilterAdapter.AnonymousClass1(filterViewHolder));
            filterViewHolder.mName.setText(filterName);
        }
        if (this.mSelectedPos > this.mFilterList.size()) {
            this.mSelectedPos = 0;
        }
        filterViewHolder.itemView.setTag(viewHolder);
        filterViewHolder.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (this.mItemClick != null) {
            com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder filterViewHolder = (com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder) view.getTag();
            int adapterPosition = filterViewHolder.getAdapterPosition();
            java.lang.String str = this.mFilterList.get(adapterPosition);
            java.lang.String str2 = this.mFilterList.get(this.mSelectedPos);
            if (this.mSelectedPos != adapterPosition) {
                if (str == null || "".equals(str)) {
                    filterViewHolder.mBackImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.moji_svideo_icon_effect_confirm);
                    filterViewHolder.mIvSelectLayerMask.setVisibility(8);
                    filterViewHolder.mIvSelectState.setVisibility(8);
                    com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder filterViewHolder2 = this.mSelectedHolder;
                    if (filterViewHolder2 != null) {
                        filterViewHolder2.mIvSelectState.setVisibility(8);
                        this.mSelectedHolder.mIvSelectLayerMask.setVisibility(8);
                    }
                } else {
                    filterViewHolder.mIvSelectState.setVisibility(0);
                    filterViewHolder.mIvSelectLayerMask.setVisibility(0);
                    if (this.mSelectedHolder != null) {
                        if (str2 == null || "".equals(str2)) {
                            this.mSelectedHolder.mBackImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.moji_svideo_effect_none);
                        }
                        this.mSelectedHolder.mIvSelectState.setVisibility(8);
                        this.mSelectedHolder.mIvSelectLayerMask.setVisibility(8);
                    }
                    com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_FILTER_CK, getFilterName(str));
                }
                notifyDataSetChanged();
                this.mSelectedPos = adapterPosition;
                this.mSelectedHolder = filterViewHolder;
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT;
                effectInfo.setPath(this.mFilterList.get(adapterPosition));
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(this.mFilterList.get(adapterPosition));
                source.setId(java.lang.String.valueOf(adapterPosition));
                if (source.getPath() != null) {
                    java.lang.String path = source.getPath();
                    java.lang.String str3 = java.io.File.separator;
                    if (path.contains(str3)) {
                        source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getAppResUri("filter", source.getPath().substring(source.getPath().lastIndexOf(str3) + 1)));
                    }
                }
                effectInfo.setSource(source);
                effectInfo.id = adapterPosition;
                this.mItemClick.onItemClick(effectInfo, adapterPosition);
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        android.view.View inflate = android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.moji_editor_item_effect, viewGroup, false);
        com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder filterViewHolder = new com.aliyun.svideo.editor.effects.filter.FilterAdapter.FilterViewHolder(inflate);
        filterViewHolder.frameLayout = (android.widget.FrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.resource_image);
        return filterViewHolder;
    }

    public void setDataList(java.util.List<java.lang.String> list) {
        this.mFilterList.clear();
        this.mFilterList.add(null);
        this.mFilterList.addAll(list);
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }

    public void setSelectedPos(int i) {
        this.mSelectedPos = i;
    }
}
