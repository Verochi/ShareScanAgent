package com.aliyun.svideo.editor.effects.filter;

/* loaded from: classes12.dex */
public class EffectAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnTouchListener {
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.effects.filter.EffectAdapter";
    private android.content.Context mContext;
    private android.view.GestureDetector mDetector;
    private int mGroupId;
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mItemClick;
    private com.aliyun.svideo.editor.effects.control.OnItemTouchListener mItemTouchListener;
    private android.view.View pressView;
    private java.util.List<java.lang.String> mFilterList = new java.util.ArrayList();
    private boolean isAdding = false;

    /* renamed from: com.aliyun.svideo.editor.effects.filter.EffectAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.GestureDetector.SimpleOnGestureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(android.view.MotionEvent motionEvent) {
            super.onShowPress(motionEvent);
            java.lang.String unused = com.aliyun.svideo.editor.effects.filter.EffectAdapter.TAG;
            if (com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.isAdding || com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mItemTouchListener == null || com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.pressView == null) {
                return;
            }
            com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder filterViewHolder = (com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder) com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.pressView.getTag();
            int adapterPosition = filterViewHolder.getAdapterPosition();
            filterViewHolder.mIvSelectState.setVisibility(0);
            filterViewHolder.mIvSelectLayerMask.setVisibility(0);
            filterViewHolder.mImage.setSelected(true);
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT;
            effectInfo.setPath((java.lang.String) com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mFilterList.get(adapterPosition));
            com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source((java.lang.String) com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mFilterList.get(adapterPosition));
            source.setId(java.lang.String.valueOf(adapterPosition));
            if (source.getPath() != null) {
                java.lang.String path = source.getPath();
                java.lang.String str = java.io.File.separator;
                if (path.contains(str)) {
                    boolean z = com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mGroupId <= 1;
                    source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getResUri(z ? "app" : com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_ANIMATION_EFFECTS, java.lang.String.valueOf(com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mGroupId), source.getPath().substring(source.getPath().lastIndexOf(str) + 1)));
                }
            }
            effectInfo.setSource(source);
            effectInfo.id = adapterPosition;
            com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mItemTouchListener.onTouchEvent(1, adapterPosition, effectInfo);
            com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.isAdding = true;
            com.moji.tool.VibratorTool.vibrate(50L);
            com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_SPECISL_CK, com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.getFilterName(source.getPath()));
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.filter.EffectAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ androidx.recyclerview.widget.RecyclerView.ViewHolder val$holder;

        public AnonymousClass2(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            this.val$holder = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mItemClick != null) {
                int adapterPosition = this.val$holder.getAdapterPosition();
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT;
                effectInfo.setPath((java.lang.String) com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mFilterList.get(adapterPosition));
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source((java.lang.String) com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mFilterList.get(adapterPosition));
                source.setId(java.lang.String.valueOf(adapterPosition));
                effectInfo.setSource(source);
                effectInfo.id = adapterPosition;
                com.aliyun.svideo.editor.effects.filter.EffectAdapter.this.mItemClick.onItemClick(effectInfo, adapterPosition);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.filter.EffectAdapter$3, reason: invalid class name */
    public class AnonymousClass3 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder val$filterViewHolder;

        public AnonymousClass3(com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder filterViewHolder) {
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

    public EffectAdapter(android.content.Context context) {
        this.mContext = context;
        this.mDetector = new android.view.GestureDetector(this.mContext, new com.aliyun.svideo.editor.effects.filter.EffectAdapter.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getFilterName(java.lang.String str) {
        java.lang.String str2;
        com.aliyun.svideo.base.Form.I18nBean currentEffectI18n = com.aliyun.svideo.editor.util.EditorCommon.getCurrentEffectI18n(str, "name");
        if (currentEffectI18n != null) {
            return com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(this.mContext) ? currentEffectI18n.getZh_cn() : currentEffectI18n.getEn();
        }
        if (com.aliyun.svideo.common.utils.LanguageUtils.isCHEN(this.mContext)) {
            str2 = str + "/config.json";
        } else {
            java.lang.String str3 = str + "/configEn.json";
            if (new java.io.File(str3).exists()) {
                str2 = str3;
            } else {
                str2 = str + "/config.json";
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.io.FileReader fileReader = new java.io.FileReader(new java.io.File(str2));
            while (true) {
                int read = fileReader.read();
                if (read == -1) {
                    break;
                }
                sb.append((char) read);
            }
            fileReader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        try {
            return new org.json.JSONObject(sb.toString()).optString("name");
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
        com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder filterViewHolder = (com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder) viewHolder;
        java.lang.String string = this.mContext.getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_animate_revoke);
        java.lang.String str = this.mFilterList.get(i);
        if (str == null || "".equals(str)) {
            filterViewHolder.mResourceView.setVisibility(8);
            filterViewHolder.mBackView.setVisibility(0);
            filterViewHolder.mBackName.setText(string);
            filterViewHolder.mBackImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.moji_svideo_icon_effect_back);
            filterViewHolder.itemView.setOnTouchListener(null);
            filterViewHolder.line.setVisibility(0);
            filterViewHolder.mCardView.setCardBackgroundColor(android.graphics.Color.parseColor("#33FFFFFF"));
            filterViewHolder.itemView.setOnClickListener(new com.aliyun.svideo.editor.effects.filter.EffectAdapter.AnonymousClass2(viewHolder));
        } else {
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
            filterViewHolder.itemView.setOnTouchListener(this);
            java.lang.String filterName = getFilterName(str);
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, str + "/icon.png").into(filterViewHolder.mImage, new com.aliyun.svideo.editor.effects.filter.EffectAdapter.AnonymousClass3(filterViewHolder));
            filterViewHolder.mName.setText(filterName);
        }
        filterViewHolder.itemView.setTag(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        android.view.View inflate = android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.moji_editor_item_effect, viewGroup, false);
        com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder filterViewHolder = new com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder(inflate);
        filterViewHolder.frameLayout = (android.widget.FrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.resource_image);
        filterViewHolder.setIsRecyclable(false);
        return filterViewHolder;
    }

    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("getAction");
        sb.append(motionEvent.getAction());
        this.mDetector.onTouchEvent(motionEvent);
        int actionMasked = androidx.core.view.MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3 || actionMasked == 6) {
                if (!this.isAdding) {
                    this.pressView = null;
                    return true;
                }
                if (view != this.pressView) {
                    return true;
                }
                if (this.mItemTouchListener != null) {
                    com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder filterViewHolder = (com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder) view.getTag();
                    int adapterPosition = filterViewHolder.getAdapterPosition();
                    com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                    effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT;
                    effectInfo.setPath(this.mFilterList.get(adapterPosition));
                    com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(this.mFilterList.get(adapterPosition));
                    source.setId(java.lang.String.valueOf(adapterPosition));
                    effectInfo.setSource(source);
                    if (source.getPath() != null) {
                        java.lang.String path = source.getPath();
                        java.lang.String str = java.io.File.separator;
                        if (path.contains(str)) {
                            boolean contains = source.getPath().contains("aliyun_svideo_animation_filter/");
                            source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getResUri(contains ? "app" : com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_ANIMATION_EFFECTS, java.lang.String.valueOf(this.mGroupId), source.getPath().substring(source.getPath().lastIndexOf(str) + 1)));
                        }
                    }
                    effectInfo.id = adapterPosition;
                    this.mItemTouchListener.onTouchEvent(2, adapterPosition, effectInfo);
                    filterViewHolder.mImage.setVisibility(0);
                    filterViewHolder.mIvSelectState.setVisibility(8);
                    filterViewHolder.mIvSelectLayerMask.setVisibility(8);
                    this.isAdding = false;
                }
                this.pressView = null;
            }
        } else {
            if (this.isAdding) {
                return false;
            }
            if (this.pressView == null) {
                this.pressView = view;
            }
        }
        return true;
    }

    public void setDataList(int i, java.util.List<java.lang.String> list) {
        this.mGroupId = i;
        this.mFilterList.clear();
        this.mFilterList.addAll(list);
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }

    public void setOnItemTouchListener(com.aliyun.svideo.editor.effects.control.OnItemTouchListener onItemTouchListener) {
        this.mItemTouchListener = onItemTouchListener;
    }
}
