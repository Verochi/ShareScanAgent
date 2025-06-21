package com.aliyun.svideo.editor.effects.transition;

/* loaded from: classes12.dex */
public class TransitionChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser {
    public static final int EFFECT_CIRCLE = 8;
    public static final int EFFECT_CUSTOM = 9;
    public static final int EFFECT_DOWN = 2;
    public static final int EFFECT_FADE = 6;
    public static final int EFFECT_FIVE_STAR = 7;
    public static final int EFFECT_LEFT = 3;
    public static final int[] EFFECT_LIST = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    public static final int EFFECT_NONE = 0;
    public static final int EFFECT_RIGHT = 4;
    public static final int EFFECT_SHUTTER = 5;
    public static final int EFFECT_UP = 1;
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MIN_COUNT = 2;
    public static final java.lang.String TRANSITION_PAYLOAD = "transition_payload";
    private com.aliyun.svideo.editor.effects.CategoryAdapter mCategoryAdapter;
    private androidx.recyclerview.widget.RecyclerView mCategoryRecycleView;
    private com.aliyun.svideo.editor.effects.control.EffectInfo mCurrentEffectInfo;
    private com.aliyun.svideo.editor.effects.transition.TransitionChooserView.MyLoadAsyncTask mLoadTask;
    private com.aliyun.svideo.editor.effects.transition.TransitionChooserView.OnPreviewListener mOnPreviewListener;
    private com.aliyun.svideo.base.EffectParamsAdjustView mParamsAdjustView;
    private com.aliyun.svideo.editor.effects.transition.TransitionAdapter mTransitionAdapter;
    private com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter mTransitionEffectAdapter;
    private com.aliyun.svideo.editor.effects.transition.TransitionEffectCache mTransitionEffectCache;
    private java.util.ArrayList<com.aliyun.svideo.base.Form.ResourceForm> mTransitionList4Category;
    private androidx.recyclerview.widget.RecyclerView mTransitionView;

    /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionChooserView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
            if (!effectInfo.isCategory || com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mTransitionList4Category.size() <= i) {
                return false;
            }
            com.aliyun.svideo.base.Form.ResourceForm resourceForm = (com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mTransitionList4Category.get(i);
            ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this).mCurrID = resourceForm.getId();
            com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.changeCategoryDir(resourceForm);
            return false;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionChooserView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener
        public void onMoreClick() {
            ((android.app.Activity) com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.getContext()).startActivityForResult(new android.content.Intent(com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.getContext(), (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.MoreTransitionEffectActivity.class), 1005);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionChooserView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
            int selectPosition = com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mTransitionAdapter.getSelectPosition();
            effectInfo.clipIndex = selectPosition;
            if (selectPosition == -1) {
                return false;
            }
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TRANSITION;
            if (effectInfo.transitionType == 9) {
                com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.showEffectParamsUI(effectInfo.transitionBase);
            } else {
                com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mParamsAdjustView.setVisibility(8);
            }
            com.aliyun.svideo.editor.effects.transition.TransitionChooserView transitionChooserView = com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this;
            if (transitionChooserView.mOnEffectChangeListener != null) {
                transitionChooserView.mCurrentEffectInfo = effectInfo;
                com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mOnEffectChangeListener.onEffectChange(effectInfo);
            }
            com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.addLocalCacheType(effectInfo);
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionChooserView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.base.EffectParamsAdjustView.OnAdjustListener {
        public AnonymousClass4() {
        }

        @Override // com.aliyun.svideo.base.EffectParamsAdjustView.OnAdjustListener
        public void onAdjust() {
            if (com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mParamsAdjustView.getVisibility() == 0 && com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mCurrentEffectInfo != null && com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mCurrentEffectInfo.transitionType == 9) {
                com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mCurrentEffectInfo.isUpdateTransition = true;
                com.aliyun.svideo.editor.effects.transition.TransitionChooserView transitionChooserView = com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this;
                transitionChooserView.mOnEffectChangeListener.onEffectChange(transitionChooserView.mCurrentEffectInfo);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionChooserView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.dealCancel();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionChooserView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this).mOnEffectActionLister != null) {
                ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this).mOnEffectActionLister.onComplete();
            }
            com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mTransitionEffectCache.commitCache();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.transition.TransitionChooserView$7, reason: invalid class name */
    public class AnonymousClass7 implements com.aliyun.svideo.editor.effects.transition.TransitionAdapter.OnSelectListener {
        public AnonymousClass7() {
        }

        @Override // com.aliyun.svideo.editor.effects.transition.TransitionAdapter.OnSelectListener
        public void onSelect(android.widget.ImageView imageView, int i, boolean z) {
            if (com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.mTransitionEffectCache != null) {
                com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this.checkEffect(imageView, i, z);
            }
        }
    }

    public class MyLoadAsyncTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> {
        private MyLoadAsyncTask() {
        }

        public /* synthetic */ MyLoadAsyncTask(com.aliyun.svideo.editor.effects.transition.TransitionChooserView transitionChooserView, defpackage.w33 w33Var) {
            this();
        }

        @Override // android.os.AsyncTask
        public java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> doInBackground(java.lang.Void... voidArr) {
            return com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(10);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
            super.onPostExecute((com.aliyun.svideo.editor.effects.transition.TransitionChooserView.MyLoadAsyncTask) list);
            com.aliyun.svideo.editor.effects.transition.TransitionChooserView transitionChooserView = com.aliyun.svideo.editor.effects.transition.TransitionChooserView.this;
            transitionChooserView.initResourceLocalWithSelectId(((com.aliyun.svideo.editor.effects.control.BaseChooser) transitionChooserView).mCurrID, list);
        }
    }

    public interface OnPreviewListener {
        void onPreview(int i, long j, boolean z);
    }

    public TransitionChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public TransitionChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransitionChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTransitionList4Category = new java.util.ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocalCacheType(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        this.mTransitionEffectCache.put(effectInfo.clipIndex, effectInfo);
        this.mTransitionAdapter.notifyItemChanged(effectInfo.clipIndex, TRANSITION_PAYLOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCategoryDir(com.aliyun.svideo.base.Form.ResourceForm resourceForm) {
        int i;
        java.util.List<java.lang.String> list = null;
        if (resourceForm != null && resourceForm.getPath() != null) {
            java.util.List<java.lang.String> animationFilterListByDir = com.aliyun.svideo.editor.util.EditorCommon.getAnimationFilterListByDir(resourceForm.getPath());
            animationFilterListByDir.add(0, null);
            list = animationFilterListByDir;
        }
        this.mTransitionEffectAdapter.setData(resourceForm.getId(), list);
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = this.mCurrentEffectInfo;
        if (effectInfo == null || (i = effectInfo.transitionType) == 0) {
            this.mTransitionEffectAdapter.setSelectPosition(0);
        } else if (i == 9) {
            this.mTransitionEffectAdapter.setCustomSelectPosition(effectInfo.getSource().getPath());
        } else {
            this.mTransitionEffectAdapter.setSelectPosition(i);
        }
        this.mTransitionEffectAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkEffect(android.widget.ImageView imageView, int i, boolean z) {
        int i2;
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = this.mTransitionEffectCache.get(i);
        int i3 = effectInfo != null ? effectInfo.transitionType : 0;
        switch (i3) {
            case 0:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_none_selector);
                break;
            case 1:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_translate_up_selector);
                break;
            case 2:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_translate_down_selector);
                break;
            case 3:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_translate_left_selector);
                break;
            case 4:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_translate_right_selector);
                break;
            case 5:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_shutter_selector);
                break;
            case 6:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_fade_selector);
                break;
            case 7:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_fivepointstar_selector);
                break;
            case 8:
                imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_circle_selector);
                break;
            case 9:
                if (effectInfo.getSource() != null && effectInfo.getSource().getPath() != null) {
                    imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_custom_selector);
                    break;
                } else {
                    imageView.setImageResource(com.aliyun.svideo.editor.R.drawable.aliyun_svideo_video_edit_transition_none_selector);
                    break;
                }
                break;
        }
        if (z) {
            this.mCurrentEffectInfo = effectInfo;
            if (effectInfo == null || (i2 = effectInfo.transitionType) == 0) {
                this.mTransitionEffectAdapter.setSelectPosition(0);
                this.mParamsAdjustView.setVisibility(8);
            } else if (i2 != 9 || effectInfo.transitionBase == null) {
                this.mTransitionEffectAdapter.setSelectPosition(i3);
                this.mParamsAdjustView.setVisibility(8);
            } else {
                this.mTransitionEffectAdapter.setCustomSelectPosition(effectInfo.getSource().getPath());
                showEffectParamsUI(this.mCurrentEffectInfo.transitionBase);
            }
            if (this.mOnPreviewListener == null || i3 == 0 || this.mTransitionAdapter.getSelectPosition() == -1) {
                return;
            }
            this.mOnPreviewListener.onPreview(i, 0L, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealCancel() {
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
        effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.TRANSITION;
        effectInfo.mutiEffect = new java.util.ArrayList();
        java.util.LinkedHashMap<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo> recover = this.mTransitionEffectCache.recover();
        if (recover.size() == 0) {
            com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
            if (onEffectActionLister != null) {
                onEffectActionLister.onCancel();
                return;
            }
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, com.aliyun.svideo.editor.effects.control.EffectInfo>> it = recover.entrySet().iterator();
        while (it.hasNext()) {
            effectInfo.mutiEffect.add(it.next().getValue());
        }
        this.mOnEffectChangeListener.onEffectChange(effectInfo);
    }

    private void initTitleView(android.view.View view) {
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_transition);
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_transition_tittle);
        view.findViewById(com.aliyun.svideo.editor.R.id.iv_cancel).setOnClickListener(new com.aliyun.svideo.editor.effects.transition.TransitionChooserView.AnonymousClass5());
        view.findViewById(com.aliyun.svideo.editor.R.id.iv_confirm).setOnClickListener(new com.aliyun.svideo.editor.effects.transition.TransitionChooserView.AnonymousClass6());
    }

    public static com.aliyun.svideosdk.editor.AliyunISourcePartManager isClipLimit(com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor) {
        com.aliyun.svideosdk.editor.AliyunISourcePartManager sourcePartManager = aliyunIEditor.getSourcePartManager();
        if (sourcePartManager.getMediaPartCount() < 2) {
            return null;
        }
        return sourcePartManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean showEffectParamsUI(com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> nodeTree = transitionBase.getNodeTree();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (nodeTree == null || nodeTree.size() == 0) {
            this.mParamsAdjustView.setVisibility(8);
            return false;
        }
        java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> it = nodeTree.iterator();
        while (it.hasNext()) {
            java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params> params = it.next().getParams();
            if (params != null && params.size() != 0) {
                for (com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params params2 : params) {
                    com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum type = params2.getType();
                    if (type == com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.INT || type == com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.FLOAT) {
                        arrayList.add(params2);
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            this.mParamsAdjustView.setVisibility(8);
        } else {
            this.mParamsAdjustView.setVisibility(0);
            this.mParamsAdjustView.setData(arrayList);
        }
        return arrayList.size() != 0;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_transition, this);
        initTitleView(inflate);
        this.mTransitionView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.transition_view);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.transition_effect_view);
        this.mCategoryRecycleView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.transition_category_list);
        this.mCategoryAdapter = new com.aliyun.svideo.editor.effects.CategoryAdapter(getContext());
        this.mCategoryRecycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        this.mCategoryRecycleView.setAdapter(this.mCategoryAdapter);
        this.mCategoryAdapter.setData(this.mTransitionList4Category);
        this.mCategoryAdapter.setOnItemClickListener(new com.aliyun.svideo.editor.effects.transition.TransitionChooserView.AnonymousClass1());
        this.mCategoryAdapter.setMoreClickListener(new com.aliyun.svideo.editor.effects.transition.TransitionChooserView.AnonymousClass2());
        com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter transitionEffectAdapter = new com.aliyun.svideo.editor.effects.transition.TransitionEffectAdapter(getContext());
        this.mTransitionEffectAdapter = transitionEffectAdapter;
        transitionEffectAdapter.setOnItemClickListener(new com.aliyun.svideo.editor.effects.transition.TransitionChooserView.AnonymousClass3());
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        recyclerView.setAdapter(this.mTransitionEffectAdapter);
        loadLocalTransitionEffect();
        com.aliyun.svideo.base.EffectParamsAdjustView effectParamsAdjustView = (com.aliyun.svideo.base.EffectParamsAdjustView) inflate.findViewById(com.aliyun.svideo.editor.R.id.params_effect_view);
        this.mParamsAdjustView = effectParamsAdjustView;
        effectParamsAdjustView.setOnAdjustListener(new com.aliyun.svideo.editor.effects.transition.TransitionChooserView.AnonymousClass4());
    }

    public void initResourceLocalWithSelectId(int i, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
        int i2;
        this.mTransitionList4Category = new java.util.ArrayList<>();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        fileDownloaderModel.setNameEn("default");
        fileDownloaderModel.setName("默认");
        fileDownloaderModel.setId(0);
        list.add(0, fileDownloaderModel);
        if (list.size() > 0) {
            for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel2 : list) {
                if ("default".equals(fileDownloaderModel2.getNameEn()) || new java.io.File(fileDownloaderModel2.getPath()).exists()) {
                    if (!arrayList.contains(java.lang.Integer.valueOf(fileDownloaderModel2.getId()))) {
                        arrayList.add(java.lang.Integer.valueOf(fileDownloaderModel2.getId()));
                        com.aliyun.svideo.base.Form.ResourceForm resourceForm = new com.aliyun.svideo.base.Form.ResourceForm();
                        resourceForm.setPreviewUrl(fileDownloaderModel2.getPreview());
                        resourceForm.setIcon(fileDownloaderModel2.getIcon());
                        resourceForm.setLevel(fileDownloaderModel2.getLevel());
                        resourceForm.setName(fileDownloaderModel2.getName());
                        resourceForm.setNameEn(fileDownloaderModel2.getNameEn());
                        resourceForm.setId(fileDownloaderModel2.getId());
                        resourceForm.setDescription(fileDownloaderModel2.getDescription());
                        resourceForm.setSort(fileDownloaderModel2.getSort());
                        resourceForm.setIsNew(fileDownloaderModel2.getIsnew());
                        resourceForm.setPath(fileDownloaderModel2.getPath());
                        this.mTransitionList4Category.add(resourceForm);
                    }
                }
            }
        }
        com.aliyun.svideo.base.Form.ResourceForm resourceForm2 = new com.aliyun.svideo.base.Form.ResourceForm();
        boolean z = true;
        resourceForm2.setMore(true);
        this.mTransitionList4Category.add(resourceForm2);
        this.mCategoryAdapter.setData(this.mTransitionList4Category);
        if (arrayList.size() > 0 && (i == -1 || i == 0 || !arrayList.contains(java.lang.Integer.valueOf(i)))) {
            i = ((java.lang.Integer) arrayList.get(0)).intValue();
        }
        com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = this.mTransitionEffectCache.get(0);
        this.mCurrentEffectInfo = effectInfo;
        if (effectInfo == null || effectInfo.getSource() == null || this.mCurrentEffectInfo.getSource().getPath() == null) {
            i2 = 0;
        } else {
            java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = this.mTransitionList4Category.iterator();
            i2 = 0;
            loop1: while (it.hasNext()) {
                com.aliyun.svideo.base.Form.ResourceForm next = it.next();
                java.util.List<java.lang.String> animationFilterListByDir = com.aliyun.svideo.editor.util.EditorCommon.getAnimationFilterListByDir(next.getPath());
                if (animationFilterListByDir != null) {
                    java.util.Iterator<java.lang.String> it2 = animationFilterListByDir.iterator();
                    while (it2.hasNext()) {
                        if (this.mCurrentEffectInfo.getSource().getPath().equals(it2.next())) {
                            changeCategoryDir(next);
                            break loop1;
                        }
                    }
                }
                i2++;
            }
        }
        z = false;
        if (!z) {
            java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it3 = this.mTransitionList4Category.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                com.aliyun.svideo.base.Form.ResourceForm next2 = it3.next();
                if (next2.getId() == i) {
                    changeCategoryDir(next2);
                    break;
                }
                i2++;
            }
        }
        this.mCategoryRecycleView.smoothScrollToPosition(i2);
        this.mCategoryAdapter.selectPosition(i2);
        if (this.mCurrID == -1) {
            loadLocalTransitionEffect();
            this.mCurrID = 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("categoryIndex :");
        sb.append(i2);
    }

    public void initTransitionAdapter(com.aliyun.svideosdk.editor.AliyunISourcePartManager aliyunISourcePartManager) {
        this.mTransitionEffectCache = this.mEditorService.getTransitionEffectCache(aliyunISourcePartManager);
        com.aliyun.svideo.editor.effects.transition.TransitionAdapter transitionAdapter = new com.aliyun.svideo.editor.effects.transition.TransitionAdapter(getContext(), this.mTransitionEffectCache);
        this.mTransitionAdapter = transitionAdapter;
        transitionAdapter.setOnSelectListener(new com.aliyun.svideo.editor.effects.transition.TransitionChooserView.AnonymousClass7());
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mTransitionView.setLayoutManager(linearLayoutManager);
        this.mTransitionView.setAdapter(this.mTransitionAdapter);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    public void loadLocalTransitionEffect() {
        com.aliyun.svideo.editor.effects.transition.TransitionChooserView.MyLoadAsyncTask myLoadAsyncTask = new com.aliyun.svideo.editor.effects.transition.TransitionChooserView.MyLoadAsyncTask(this, null);
        this.mLoadTask = myLoadAsyncTask;
        myLoadAsyncTask.execute(new java.lang.Void[0]);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onBackPressed() {
        super.onBackPressed();
        dealCancel();
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onRemove() {
        super.onRemove();
        com.aliyun.svideo.editor.effects.transition.TransitionAdapter transitionAdapter = this.mTransitionAdapter;
        if (transitionAdapter != null) {
            transitionAdapter.release();
        }
    }

    public void setCurrResourceID(int i) {
        if (i != -1) {
            this.mCurrID = i;
        }
        loadLocalTransitionEffect();
        com.aliyun.svideo.editor.effects.transition.TransitionAdapter transitionAdapter = this.mTransitionAdapter;
        if (transitionAdapter != null) {
            transitionAdapter.notifyDataSetChanged();
        }
    }

    public void setOnPreviewListener(com.aliyun.svideo.editor.effects.transition.TransitionChooserView.OnPreviewListener onPreviewListener) {
        this.mOnPreviewListener = onPreviewListener;
    }
}
