package com.aliyun.svideo.editor.effects.filter;

/* loaded from: classes12.dex */
public class AnimationFilterChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements com.aliyun.svideo.editor.effects.control.OnItemClickListener, com.aliyun.svideo.editor.effects.control.OnItemTouchListener, android.view.View.OnClickListener {
    private boolean isFirstShow;
    private boolean isFirstShowEffect;
    private android.widget.ImageView mCancel;
    private com.aliyun.svideo.editor.effects.CategoryAdapter mCategoryAdapter;
    private androidx.recyclerview.widget.RecyclerView mCategoryList;
    private android.widget.ImageView mComplete;
    private com.aliyun.svideosdk.common.struct.effect.EffectFilter mCurrentEffect;
    private com.aliyun.svideo.editor.effects.filter.EffectAdapter mFilterAdapter;
    private java.util.ArrayList<com.aliyun.svideo.base.Form.ResourceForm> mFilterList4Category;
    private android.widget.FrameLayout mFlThumblinebar;
    private android.widget.ImageView mIvEffectIcon;
    private androidx.recyclerview.widget.RecyclerView mListView;
    private android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> mLoadTask;
    private com.aliyun.svideo.base.EffectParamsAdjustView mParamsAdjustView;
    private android.widget.TextView mTvEffectTitle;
    private com.aliyun.svideo.editor.guide.customView.MultiLamp multiLamp;
    private java.util.ArrayList<com.aliyun.svideo.editor.guide.model.Target> targets;

    /* renamed from: com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
            if (!effectInfo.isCategory || com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.mFilterList4Category.size() <= i) {
                return true;
            }
            com.aliyun.svideo.base.Form.ResourceForm resourceForm = (com.aliyun.svideo.base.Form.ResourceForm) com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.mFilterList4Category.get(i);
            ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this).mCurrID = resourceForm.getId();
            com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.changeCategoryDir(resourceForm);
            com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.mParamsAdjustView.setVisibility(8);
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.effects.CategoryAdapter.OnMoreClickListener
        public void onMoreClick() {
            ((android.app.Activity) com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.getContext()).startActivityForResult(new android.content.Intent(com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.getContext(), (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.MoreAnimationEffectActivity.class), 1004);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.targets.add(new com.aliyun.svideo.editor.guide.model.Target(com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.mFlThumblinebar, "✨滑动选择想要添加效果的位置", com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, new com.aliyun.svideo.editor.guide.shapes.Rectangle(false, 0.0f, false, 0.0f, com.aliyun.svideo.editor.R.mipmap.guide_line_top, false, false)));
            com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.multiLamp.build(com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.targets);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.recyclerview.widget.RecyclerView.ViewHolder findViewHolderForAdapterPosition;
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.mListView.getLayoutManager();
            if (linearLayoutManager == null || linearLayoutManager.findLastCompletelyVisibleItemPosition() < 1 || (findViewHolderForAdapterPosition = com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.mListView.findViewHolderForAdapterPosition(1)) == null || !(findViewHolderForAdapterPosition instanceof com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder)) {
                return;
            }
            com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.targets.add(new com.aliyun.svideo.editor.guide.model.Target(((com.aliyun.svideo.editor.effects.filter.EffectAdapter.FilterViewHolder) findViewHolderForAdapterPosition).itemView, "✨长按可添加效果～", com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, new com.aliyun.svideo.editor.guide.shapes.Rectangle(false, 0.0f, true, com.moji.tool.DeviceTool.dp2px(4.0f), com.aliyun.svideo.editor.R.mipmap.guide_line_top, true, false)));
            com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.multiLamp.build(com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.targets);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.guide.customView.MultiLamp.Callback {
        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideo.editor.guide.customView.MultiLamp.Callback
        public void onTutorialFinished() {
            com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this.multiLamp = null;
        }
    }

    public class MyLoadAsyncTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel>> {
        private MyLoadAsyncTask() {
        }

        public /* synthetic */ MyLoadAsyncTask(com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView animationFilterChooserView, defpackage.n9 n9Var) {
            this();
        }

        @Override // android.os.AsyncTask
        public java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> doInBackground(java.lang.Void... voidArr) {
            return com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(9);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
            super.onPostExecute((com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.MyLoadAsyncTask) list);
            com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView animationFilterChooserView = com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.this;
            animationFilterChooserView.initResourceLocalWithSelectId(((com.aliyun.svideo.editor.effects.control.BaseChooser) animationFilterChooserView).mCurrID, list);
        }
    }

    public AnimationFilterChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public AnimationFilterChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationFilterChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCategoryDir(com.aliyun.svideo.base.Form.ResourceForm resourceForm) {
        if (resourceForm == null || resourceForm.getPath() == null) {
            return;
        }
        java.util.List<java.lang.String> animationFilterListByDir = com.aliyun.svideo.editor.util.EditorCommon.getAnimationFilterListByDir(resourceForm.getPath());
        animationFilterListByDir.add(0, null);
        this.mFilterAdapter.setDataList(resourceForm.getId(), animationFilterListByDir);
        this.mFilterAdapter.notifyDataSetChanged();
    }

    private boolean showEffectParamsUI(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> nodeTree = effectFilter.getNodeTree();
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

    public com.aliyun.svideosdk.common.struct.effect.EffectConfig copyEffectConfig() {
        com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter = new com.aliyun.svideosdk.common.struct.effect.EffectFilter(this.mCurrentEffect.getSource());
        this.mCurrentEffect.copy(effectFilter);
        return effectFilter.getEffectConfig();
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public android.widget.FrameLayout getThumbContainer() {
        return this.mFlThumblinebar;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.FILTER_EFFECT;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_animation_filter, this);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.effect_list_filter);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        this.mFlThumblinebar = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.fl_thumblinebar);
        com.aliyun.svideo.editor.effects.filter.EffectAdapter effectAdapter = new com.aliyun.svideo.editor.effects.filter.EffectAdapter(getContext());
        this.mFilterAdapter = effectAdapter;
        effectAdapter.setOnItemClickListener(this);
        this.mFilterAdapter.setOnItemTouchListener(this);
        this.mListView.setAdapter(this.mFilterAdapter);
        this.mListView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpacesEffectItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.moji_list_item_space)));
        this.mCancel = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.cancel);
        this.mTvEffectTitle = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        this.mIvEffectIcon = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        this.mComplete = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.complete);
        this.mIvEffectIcon.setImageResource(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_effect);
        this.mTvEffectTitle.setText(com.aliyun.svideo.editor.R.string.moji_editor_dialog_animate_tittle);
        this.mComplete.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
        this.mFilterList4Category = new java.util.ArrayList<>();
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.effect_category_view);
        this.mCategoryList = recyclerView;
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.CategoryAdapter categoryAdapter = new com.aliyun.svideo.editor.effects.CategoryAdapter(getContext());
        this.mCategoryAdapter = categoryAdapter;
        this.mCategoryList.setAdapter(categoryAdapter);
        this.mCategoryAdapter.setData(this.mFilterList4Category);
        this.mCategoryAdapter.setOnItemClickListener(new com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.AnonymousClass1());
        this.mCategoryAdapter.setMoreClickListener(new com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.AnonymousClass2());
        this.mParamsAdjustView = (com.aliyun.svideo.base.EffectParamsAdjustView) inflate.findViewById(com.aliyun.svideo.editor.R.id.params_effect_view);
        loadLocalAnimationFilter();
    }

    public void initResourceLocalWithSelectId(int i, java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> list) {
        this.mFilterList4Category = new java.util.ArrayList<>();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel = new com.aliyun.svideo.downloader.FileDownloaderModel();
        com.moji.dynamic.DynamicLoadType dynamicLoadType = com.moji.dynamic.DynamicLoadType.ALI_ANIM_FILTER;
        if (com.moji.dynamic.DynamicLoadManager.isTypeReady(dynamicLoadType)) {
            fileDownloaderModel.setPath(com.moji.dynamic.DynamicLoadManager.getLocalFilePath(com.moji.tool.AppDelegate.getAppContext(), dynamicLoadType));
        } else {
            fileDownloaderModel.setPath(com.aliyun.svideo.editor.util.EditorCommon.QU_DIR + com.aliyun.svideo.editor.util.EditorCommon.QU_ANIMATION_FILTER);
        }
        fileDownloaderModel.setNameEn("default");
        fileDownloaderModel.setName("默认");
        fileDownloaderModel.setId(0);
        list.add(0, fileDownloaderModel);
        com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel2 = new com.aliyun.svideo.downloader.FileDownloaderModel();
        com.moji.dynamic.DynamicLoadType dynamicLoadType2 = com.moji.dynamic.DynamicLoadType.ALI_SPLIT_FILTER;
        if (com.moji.dynamic.DynamicLoadManager.isTypeReady(dynamicLoadType2)) {
            fileDownloaderModel2.setPath(com.moji.dynamic.DynamicLoadManager.getLocalFilePath(com.moji.tool.AppDelegate.getAppContext(), dynamicLoadType2));
        } else {
            fileDownloaderModel2.setPath(com.aliyun.svideo.editor.util.EditorCommon.QU_DIR + com.aliyun.svideo.editor.util.EditorCommon.QU_ANIMATION_SPLIT_SCREEN_FILTER);
        }
        fileDownloaderModel2.setNameEn("split screen");
        fileDownloaderModel2.setName("分屏");
        fileDownloaderModel2.setId(1);
        list.add(fileDownloaderModel2);
        if (list.size() > 0) {
            for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel3 : list) {
                if (new java.io.File(fileDownloaderModel3.getPath()).exists() && !arrayList.contains(java.lang.Integer.valueOf(fileDownloaderModel3.getId()))) {
                    arrayList.add(java.lang.Integer.valueOf(fileDownloaderModel3.getId()));
                    com.aliyun.svideo.base.Form.ResourceForm resourceForm = new com.aliyun.svideo.base.Form.ResourceForm();
                    resourceForm.setPreviewUrl(fileDownloaderModel3.getPreview());
                    resourceForm.setIcon(fileDownloaderModel3.getIcon());
                    resourceForm.setLevel(fileDownloaderModel3.getLevel());
                    resourceForm.setName(fileDownloaderModel3.getName());
                    resourceForm.setNameEn(fileDownloaderModel3.getNameEn());
                    resourceForm.setId(fileDownloaderModel3.getId());
                    resourceForm.setDescription(fileDownloaderModel3.getDescription());
                    resourceForm.setSort(fileDownloaderModel3.getSort());
                    resourceForm.setIsNew(fileDownloaderModel3.getIsnew());
                    resourceForm.setPath(fileDownloaderModel3.getPath());
                    this.mFilterList4Category.add(resourceForm);
                }
            }
        }
        com.aliyun.svideo.base.Form.ResourceForm resourceForm2 = new com.aliyun.svideo.base.Form.ResourceForm();
        resourceForm2.setMore(true);
        this.mFilterList4Category.add(resourceForm2);
        this.mCategoryAdapter.setData(this.mFilterList4Category);
        if (arrayList.size() > 0 && (i == -1 || i == 0 || !arrayList.contains(java.lang.Integer.valueOf(i)))) {
            i = ((java.lang.Integer) arrayList.get(0)).intValue();
        }
        java.util.Iterator<com.aliyun.svideo.base.Form.ResourceForm> it = this.mFilterList4Category.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.aliyun.svideo.base.Form.ResourceForm next = it.next();
            if (next.getId() == i) {
                changeCategoryDir(next);
                break;
            }
            i2++;
        }
        this.mCategoryList.smoothScrollToPosition(i2);
        this.mCategoryAdapter.selectPosition(i2);
        if (this.mCurrID == -1) {
            loadLocalAnimationFilter();
            this.mCurrID = 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("categoryIndex :");
        sb.append(i2);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    public void loadLocalAnimationFilter() {
        com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.MyLoadAsyncTask myLoadAsyncTask = new com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.MyLoadAsyncTask(this, null);
        this.mLoadTask = myLoadAsyncTask;
        myLoadAsyncTask.execute(new java.lang.Void[0]);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.FilterTabClick(1));
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().register(this);
        if (this.isFirstShow) {
            android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_tip_first_show, (android.view.ViewGroup) null, false);
            android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(inflate, -2, -2, true);
            popupWindow.setContentView(inflate);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            int dimensionPixelSize = (0 - getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.alivc_editor_size_effect_list_view)) - com.aliyun.svideo.common.utils.DensityUtils.dip2px(getContext(), 25.0f);
            popupWindow.showAsDropDown(this.mListView, com.aliyun.svideo.common.utils.DensityUtils.dip2px(getContext(), 5.0f), dimensionPixelSize);
            this.isFirstShow = false;
        }
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onBackPressed() {
        com.aliyun.svideo.editor.guide.customView.MultiLamp multiLamp = this.multiLamp;
        if (multiLamp != null) {
            multiLamp.hideGuideView();
            return;
        }
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.ClearAnimationFilter());
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (com.aliyun.svideo.base.utils.FastClickUtil.isFastClick()) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (view == this.mComplete) {
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.ConfirmAnimationFilter());
            com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
            if (onEffectActionLister != null) {
                onEffectActionLister.onComplete();
            }
        } else if (view == this.mCancel) {
            onBackPressed();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.POSTING)
    public void onEventShowAnimationEnd(com.aliyun.svideo.editor.msg.body.ShowAnimationEndMsg showAnimationEndMsg) {
        if (this.isFirstShowEffect) {
            com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SHORTVIDEO_EDIT_GUIDE_SW, "特效滤镜引导");
            this.multiLamp = new com.aliyun.svideo.editor.guide.customView.MultiLamp((android.app.Activity) getContext());
            this.targets = new java.util.ArrayList<>();
            this.mFlThumblinebar.post(new com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.AnonymousClass3());
            this.mListView.post(new com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.AnonymousClass4());
            com.aliyun.svideo.editor.guide.customView.MultiLamp multiLamp = this.multiLamp;
            if (multiLamp != null) {
                multiLamp.addCallback(new com.aliyun.svideo.editor.effects.filter.AnimationFilterChooserView.AnonymousClass5());
            }
            this.isFirstShowEffect = false;
        }
    }

    @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
    public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
        if (i != 0) {
            return false;
        }
        this.mParamsAdjustView.setVisibility(8);
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.DeleteLastAnimationFilter());
        return false;
    }

    @Override // com.aliyun.svideo.editor.effects.control.OnItemTouchListener
    public void onTouchEvent(int i, int i2, com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
        com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar;
        com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar2;
        if (i != 1) {
            if (i != 2 || (overlayThumbLineBar2 = this.mThumbLineBar) == null || overlayThumbLineBar2.isTouching()) {
                return;
            }
            setClickable(true);
            com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter.Builder().effectInfo(effectInfo).index(i2).effectConfig(copyEffectConfig()).build());
            return;
        }
        if (i2 <= 0 || (overlayThumbLineBar = this.mThumbLineBar) == null || overlayThumbLineBar.isTouching()) {
            return;
        }
        setClickable(false);
        effectInfo.streamStartTime = java.util.concurrent.TimeUnit.MILLISECONDS.toMicros(this.mPlayerListener.getCurrDuration());
        if (this.mCurrentEffect == null || !effectInfo.getSource().equals(this.mCurrentEffect.getSource())) {
            this.mCurrentEffect = new com.aliyun.svideosdk.common.struct.effect.EffectFilter(effectInfo.getSource());
        }
        showEffectParamsUI(this.mCurrentEffect);
        com.aliyun.svideo.editor.msg.Dispatcher.getInstance().postMsg(new com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter.Builder().effectInfo(effectInfo).index(i2).effectConfig(copyEffectConfig()).build());
    }

    public void setCurrResourceID(int i) {
        if (i != -1) {
            this.mCurrID = i;
        }
        loadLocalAnimationFilter();
    }

    public void setFirstShow(boolean z) {
        this.isFirstShow = z;
    }

    public void setFirstShowEffect(boolean z) {
        this.isFirstShowEffect = z;
    }
}
