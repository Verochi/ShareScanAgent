package com.aliyun.svideo.editor.effects.caption.component;

/* loaded from: classes12.dex */
public class CaptionChooserPanelView extends com.aliyun.svideo.editor.effects.control.BaseChooser {
    private com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.OnItemClickListener mOnItemClickListener;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.this.dealCancel();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.this).mOnEffectActionLister != null) {
                ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.this).mOnEffectActionLister.onComplete();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.OnItemClickListener {
        public AnonymousClass4() {
        }

        @Override // com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter.OnItemClickListener
        public void onItemClick(com.aliyun.svideo.editor.bean.AlivcEditMenus alivcEditMenus) {
            if (alivcEditMenus != com.aliyun.svideo.editor.bean.AlivcEditMenus.AddText || com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.this.mOnEffectChangeListener == null) {
                return;
            }
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.COMPOUND_CAPTION;
            com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.this.mOnEffectChangeListener.onEffectChange(effectInfo);
        }
    }

    public CaptionChooserPanelView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public CaptionChooserPanelView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptionChooserPanelView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealCancel() {
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    private void initListener() {
        this.mOnItemClickListener = new com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.AnonymousClass4();
    }

    private void initTitleView(android.view.View view) {
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_caption);
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_effect_caption);
        view.findViewById(com.aliyun.svideo.editor.R.id.iv_cancel).setOnClickListener(new com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.AnonymousClass1());
        view.findViewById(com.aliyun.svideo.editor.R.id.iv_confirm).setOnClickListener(new com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.AnonymousClass2());
        setOnClickListener(new com.aliyun.svideo.editor.effects.caption.component.CaptionChooserPanelView.AnonymousClass3());
    }

    private java.util.List<com.aliyun.svideo.editor.bean.AlivcEditMenuBean> loadMenus() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.aliyun.svideo.editor.bean.AlivcEditMenuBean("加字幕", com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_roll_caption, com.aliyun.svideo.editor.bean.AlivcEditMenus.AddText));
        return arrayList;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public android.widget.FrameLayout getThumbContainer() {
        return (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.fl_thumblinebar);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.COMPOUND_CAPTION;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_panel_caption, this);
        initTitleView(inflate);
        initListener();
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.aliyun.svideo.editor.R.id.bottom_menu_recycleview);
        com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter bottomMenuAdapter = new com.aliyun.svideo.editor.effects.caption.adapter.BottomMenuAdapter();
        bottomMenuAdapter.setOnItemClickListener(this.mOnItemClickListener);
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(bottomMenuAdapter);
        bottomMenuAdapter.setData(loadMenus());
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isHostPaster(com.aliyun.svideo.editor.editor.AliyunBasePasterController aliyunBasePasterController) {
        return false;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isShowSelectedView() {
        return false;
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView findCaptionEditorPanelView;
        android.view.View rootView = getRootView();
        if (!(rootView instanceof android.view.ViewGroup) || (findCaptionEditorPanelView = com.aliyun.svideo.editor.effects.caption.manager.AlivcEditorViewFactory.findCaptionEditorPanelView((android.view.ViewGroup) rootView)) == null) {
            return;
        }
        findCaptionEditorPanelView.onActivityResult(i, i2, intent);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onBackPressed() {
        super.onBackPressed();
        dealCancel();
    }
}
