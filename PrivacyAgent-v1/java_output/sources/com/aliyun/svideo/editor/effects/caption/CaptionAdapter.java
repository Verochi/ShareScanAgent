package com.aliyun.svideo.editor.effects.caption;

/* loaded from: classes12.dex */
public class CaptionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.view.View.OnClickListener {
    private static final int CAPTION_TYPE = 6;
    private static final int FONT_TYPE = 1;
    public static final java.lang.String SYSTEM_FONT = "system_font";
    private android.content.Context mContext;
    private int mGroupId;
    private boolean mIsShowFont;
    private com.aliyun.svideo.editor.effects.control.OnItemClickListener mItemClick;
    private com.aliyun.svideo.base.Form.ResourceForm mResourceForm;
    private java.util.ArrayList<com.aliyun.svideo.base.Form.PasterForm> data = new java.util.ArrayList<>();
    private java.util.ArrayList<java.lang.Integer> ids = new java.util.ArrayList<>();
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.form.FontForm> fontData = new java.util.concurrent.CopyOnWriteArrayList<>();

    /* renamed from: com.aliyun.svideo.editor.effects.caption.CaptionAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<android.graphics.drawable.Drawable> {
        final /* synthetic */ com.aliyun.svideo.editor.effects.caption.CaptionAdapter.CaptionViewHolder val$captionViewHolder;

        public AnonymousClass1(com.aliyun.svideo.editor.effects.caption.CaptionAdapter.CaptionViewHolder captionViewHolder) {
            this.val$captionViewHolder = captionViewHolder;
        }

        @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget
        public void onResourceReady(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.val$captionViewHolder.mImage.setImageDrawable(drawable);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.CaptionAdapter$2, reason: invalid class name */
    public class AnonymousClass2 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
        final /* synthetic */ com.aliyun.svideo.base.Form.PasterForm val$form;
        final /* synthetic */ int val$index;

        public AnonymousClass2(com.aliyun.svideo.base.Form.PasterForm pasterForm, int i) {
            this.val$form = pasterForm;
            this.val$index = i;
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onFinish(int i, java.lang.String str) {
            com.aliyun.common.logger.Logger.getDefaultLogger().d("downloadId..." + i + "  path..." + str, new java.lang.Object[0]);
            if (com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.mItemClick != null) {
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.CAPTION;
                effectInfo.setPath(str);
                effectInfo.fontPath = com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.getFontByPaster(this.val$form).getUrl();
                com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.mItemClick.onItemClick(effectInfo, this.val$index);
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onProgress(int i, long j, long j2, long j3, int i2) {
            com.aliyun.common.logger.Logger.getDefaultLogger().d("downloadId..." + i + "  progress..." + i2, new java.lang.Object[0]);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.CaptionAdapter$3, reason: invalid class name */
    public class AnonymousClass3 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            com.aliyun.svideosdk.common.struct.form.FontForm fontForm;
            super.onSuccess((com.aliyun.svideo.editor.effects.caption.CaptionAdapter.AnonymousClass3) str);
            try {
                fontForm = (com.aliyun.svideosdk.common.struct.form.FontForm) new com.aliyun.common.jasonparse.JSONSupportImpl().readValue(str, com.aliyun.svideosdk.common.struct.form.FontForm.class);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                fontForm = null;
            }
            if (fontForm != null) {
                if (!com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.ids.contains(java.lang.Integer.valueOf(fontForm.getId()))) {
                    com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.fontData.add(fontForm);
                    com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.ids.add(java.lang.Integer.valueOf(fontForm.getId()));
                }
                com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.CaptionAdapter$4, reason: invalid class name */
    public class AnonymousClass4 extends com.aliyun.svideo.downloader.FileDownloaderCallback {
        final /* synthetic */ com.aliyun.svideosdk.common.struct.form.FontForm val$form;
        final /* synthetic */ int val$index;

        public AnonymousClass4(com.aliyun.svideosdk.common.struct.form.FontForm fontForm, int i) {
            this.val$form = fontForm;
            this.val$index = i;
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onFinish(int i, java.lang.String str) {
            com.aliyun.common.logger.Logger.getDefaultLogger().d("downloadId..." + i + "  path..." + str, new java.lang.Object[0]);
            if (com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.mItemClick != null) {
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FONT;
                effectInfo.setPath(null);
                effectInfo.fontPath = str;
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(str);
                source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri("font", java.lang.String.valueOf(this.val$form.getId())));
                effectInfo.fontSource = source;
                com.aliyun.svideo.editor.effects.caption.CaptionAdapter.this.mItemClick.onItemClick(effectInfo, this.val$index);
            }
        }

        @Override // com.aliyun.svideo.downloader.FileDownloaderCallback
        public void onProgress(int i, long j, long j2, long j3, int i2) {
            com.aliyun.common.logger.Logger.getDefaultLogger().d("downloadId..." + i + "  progress..." + i2, new java.lang.Object[0]);
        }
    }

    public static class CaptionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.FrameLayout frameLayout;
        com.aliyun.svideo.base.widget.CircularImageView mImage;

        public CaptionViewHolder(android.view.View view) {
            super(view);
            this.mImage = (com.aliyun.svideo.base.widget.CircularImageView) view.findViewById(com.aliyun.svideo.editor.R.id.resource_image_view);
        }
    }

    public CaptionAdapter(android.content.Context context) {
        this.mContext = context;
    }

    private void downloadFont(com.aliyun.svideosdk.common.struct.form.FontForm fontForm, int i) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel.setEffectType(1);
        fileDownloaderModel.setName(fontForm.getName());
        fileDownloaderModel.setUrl(fontForm.getUrl());
        fileDownloaderModel.setId(fontForm.getId());
        fileDownloaderModel.setLevel(fontForm.getLevel());
        fileDownloaderModel.setSort(fontForm.getSort());
        fileDownloaderModel.setMd5(fontForm.getMd5());
        fileDownloaderModel.setBanner(fontForm.getBanner());
        fileDownloaderModel.setIcon(fontForm.getIcon());
        fileDownloaderModel.setIsunzip(1);
        com.aliyun.svideo.downloader.DownloaderManager.getInstance().startTask(com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl()).getTaskId(), new com.aliyun.svideo.editor.effects.caption.CaptionAdapter.AnonymousClass4(fontForm, i));
    }

    private void downloadPaster(com.aliyun.svideo.base.Form.PasterForm pasterForm, int i) {
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel.setEffectType(6);
        fileDownloaderModel.setIcon(this.mResourceForm.getIcon());
        fileDownloaderModel.setId(this.mResourceForm.getId());
        fileDownloaderModel.setDescription(this.mResourceForm.getDescription());
        fileDownloaderModel.setIsnew(this.mResourceForm.getIsNew());
        fileDownloaderModel.setName(this.mResourceForm.getName());
        fileDownloaderModel.setLevel(this.mResourceForm.getLevel());
        fileDownloaderModel.setPreview(this.mResourceForm.getPreviewUrl());
        fileDownloaderModel.setSubname(pasterForm.getName());
        fileDownloaderModel.setSubicon(pasterForm.getIcon());
        fileDownloaderModel.setUrl(pasterForm.getDownloadUrl());
        fileDownloaderModel.setSubid(pasterForm.getId());
        fileDownloaderModel.setFontid(pasterForm.getFontId());
        fileDownloaderModel.setSort(pasterForm.getSort());
        fileDownloaderModel.setSubpreview(pasterForm.getPreviewUrl());
        fileDownloaderModel.setMd5(pasterForm.getMD5());
        fileDownloaderModel.setIsunzip(1);
        com.aliyun.svideo.downloader.DownloaderManager.getInstance().startTask(com.aliyun.svideo.downloader.DownloaderManager.getInstance().addTask(fileDownloaderModel, fileDownloaderModel.getUrl()).getTaskId(), new com.aliyun.svideo.editor.effects.caption.CaptionAdapter.AnonymousClass2(pasterForm, i));
    }

    private void getFont(int i) {
        java.lang.String str = "https://m-api.qupaicloud.com/api/res/get/1/" + i;
        java.lang.String str2 = "?packageName=" + this.mContext.getApplicationInfo().packageName;
        com.aliyun.common.logger.Logger.getDefaultLogger().d("pasterUrl url = " + str + str2, new java.lang.Object[0]);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(str2);
        com.aliyun.common.qupaiokhttp.HttpRequest.get(sb.toString(), new com.aliyun.svideo.editor.effects.caption.CaptionAdapter.AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideosdk.common.struct.form.FontForm getFontByPaster(com.aliyun.svideo.base.Form.PasterForm pasterForm) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.form.FontForm> it = this.fontData.iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.common.struct.form.FontForm next = it.next();
            if (next.getId() == pasterForm.getFontId()) {
                return next;
            }
        }
        return null;
    }

    private void getFontFromLocal() {
        for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(1)) {
            com.aliyun.svideosdk.common.struct.form.FontForm fontForm = new com.aliyun.svideosdk.common.struct.form.FontForm();
            fontForm.setLevel(fileDownloaderModel.getLevel());
            fontForm.setIcon(fileDownloaderModel.getIcon());
            fontForm.setBanner(fileDownloaderModel.getBanner());
            fontForm.setId(fileDownloaderModel.getId());
            fontForm.setMd5(fileDownloaderModel.getMd5());
            fontForm.setName(fileDownloaderModel.getName());
            fontForm.setType(fileDownloaderModel.getEffectType());
            fontForm.setUrl(fileDownloaderModel.getUrl());
            fontForm.setSort(fileDownloaderModel.getSort());
            this.fontData.add(fontForm);
            this.ids.add(java.lang.Integer.valueOf(fontForm.getId()));
        }
        com.aliyun.svideosdk.common.struct.form.FontForm fontForm2 = new com.aliyun.svideosdk.common.struct.form.FontForm();
        fontForm2.setIcon("system_font");
        this.fontData.add(0, fontForm2);
    }

    public void clearData() {
        this.data.clear();
        this.fontData.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mIsShowFont ? this.fontData.size() : this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mIsShowFont ? 1 : 6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.caption.CaptionAdapter.CaptionViewHolder captionViewHolder = (com.aliyun.svideo.editor.effects.caption.CaptionAdapter.CaptionViewHolder) viewHolder;
        java.lang.String icon = getItemViewType(i) == 6 ? this.data.get(i).getIcon() : getItemViewType(i) == 1 ? this.fontData.get(i).getIcon() : "";
        if ("system_font".equals(icon)) {
            captionViewHolder.mImage.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_system_font_icon);
        } else {
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, icon).into(captionViewHolder.mImage, new com.aliyun.svideo.editor.effects.caption.CaptionAdapter.AnonymousClass1(captionViewHolder));
        }
        captionViewHolder.itemView.setTag(viewHolder);
        captionViewHolder.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int adapterPosition = ((com.aliyun.svideo.editor.effects.caption.CaptionAdapter.CaptionViewHolder) view.getTag()).getAdapterPosition();
        int itemViewType = getItemViewType(adapterPosition);
        if (itemViewType == 6) {
            com.aliyun.svideo.base.Form.PasterForm pasterForm = this.data.get(adapterPosition);
            java.lang.String pathByUrl = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getPathByUrl(pasterForm.getDownloadUrl());
            if (pathByUrl == null || pathByUrl.isEmpty()) {
                downloadPaster(pasterForm, adapterPosition);
            } else if (this.mItemClick != null) {
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.CAPTION;
                effectInfo.setSource(new com.aliyun.svideosdk.common.struct.project.Source(pathByUrl));
                effectInfo.getSource().setId(java.lang.String.valueOf(pasterForm.getId()));
                effectInfo.getSource().setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getResUri(effectInfo.getSource().getPath().contains("aliyun_svideo_caption/") ? "app" : com.aliyun.svideo.editor.util.AlivcResUtil.HOST_CLOUD, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_BUBBLE, java.lang.String.valueOf(this.mGroupId), effectInfo.getSource().getId()));
                com.aliyun.svideosdk.common.struct.form.FontForm fontByPaster = getFontByPaster(pasterForm);
                if (fontByPaster == null) {
                    effectInfo.fontPath = null;
                    effectInfo.fontSource = null;
                } else {
                    java.lang.String pathByUrl2 = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getPathByUrl(fontByPaster.getUrl());
                    effectInfo.fontPath = pathByUrl2;
                    com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(pathByUrl2);
                    source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri("font", java.lang.String.valueOf(fontByPaster.getId())));
                    effectInfo.fontSource = source;
                }
                this.mItemClick.onItemClick(effectInfo, adapterPosition);
            }
        } else if (itemViewType == 1) {
            com.aliyun.svideosdk.common.struct.form.FontForm fontForm = this.fontData.get(adapterPosition);
            if (!"system_font".equals(fontForm.getIcon())) {
                java.lang.String pathByUrl3 = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getPathByUrl(fontForm.getUrl());
                if (pathByUrl3 == null || pathByUrl3.isEmpty()) {
                    downloadFont(fontForm, adapterPosition);
                } else if (this.mItemClick != null) {
                    com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo2 = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                    effectInfo2.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FONT;
                    effectInfo2.setPath(null);
                    effectInfo2.fontPath = pathByUrl3;
                    com.aliyun.svideosdk.common.struct.project.Source source2 = new com.aliyun.svideosdk.common.struct.project.Source(pathByUrl3);
                    source2.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri("font", java.lang.String.valueOf(fontForm.getId())));
                    effectInfo2.fontSource = source2;
                    this.mItemClick.onItemClick(effectInfo2, adapterPosition);
                }
            } else if (this.mItemClick != null) {
                com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo3 = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                effectInfo3.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.FONT;
                effectInfo3.setPath(null);
                effectInfo3.fontPath = "system_font";
                this.mItemClick.onItemClick(effectInfo3, adapterPosition);
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        android.view.View inflate = android.view.LayoutInflater.from(this.mContext).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_paster, viewGroup, false);
        com.aliyun.svideo.editor.effects.caption.CaptionAdapter.CaptionViewHolder captionViewHolder = new com.aliyun.svideo.editor.effects.caption.CaptionAdapter.CaptionViewHolder(inflate);
        captionViewHolder.frameLayout = (android.widget.FrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.resource_image);
        return captionViewHolder;
    }

    public void setData(com.aliyun.svideo.base.Form.ResourceForm resourceForm) {
        if (resourceForm == null || resourceForm.getPasterList() == null) {
            return;
        }
        this.mIsShowFont = false;
        this.mResourceForm = resourceForm;
        this.mGroupId = resourceForm.getId();
        this.data = (java.util.ArrayList) resourceForm.getPasterList();
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(com.aliyun.svideo.editor.effects.control.OnItemClickListener onItemClickListener) {
        this.mItemClick = onItemClickListener;
    }

    public void showFontData() {
        this.mIsShowFont = true;
        this.fontData.clear();
        getFontFromLocal();
        java.util.Iterator<com.aliyun.svideo.base.Form.PasterForm> it = this.data.iterator();
        while (it.hasNext()) {
            getFont(it.next().getFontId());
        }
        notifyDataSetChanged();
    }
}
