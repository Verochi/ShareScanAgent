package com.aliyun.svideo.editor.effects.rollcaption;

/* loaded from: classes12.dex */
public class RollCaptionEffectChooseView extends com.aliyun.svideo.editor.effects.control.BaseChooser {
    private com.aliyun.svideosdk.editor.AliyunRollCaptionComposer mAliyunRollCaptionComposer;
    private com.aliyun.svideo.editor.effects.rollcaption.RollCaptionAdapter mCaptionAdapter;
    private int mCurrentColor;
    private com.aliyun.svideosdk.common.struct.project.Source mFontSource;
    private android.widget.ImageView mRollCaptionApplyImageView;
    private android.widget.LinearLayout mRollCaptionChooser;
    private android.widget.TextView mRollCaptionClearTextView;
    private android.widget.TextView mRollCaptionColorTextView;
    private com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView mRollCaptionColorView;
    private androidx.recyclerview.widget.RecyclerView mRollCaptionFontRecyclerView;
    private android.widget.TextView mRollCaptionFontTextView;
    private java.util.ArrayList<java.lang.String> mRollCaptionList;
    private android.widget.TextView mRollCaptionSubtitleTextView;
    private java.util.ArrayList<com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean> mSubtitleBeans;
    private boolean mUseFamilyColor;

    /* renamed from: com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            android.content.Intent intent = new android.content.Intent(com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.getContext(), (java.lang.Class<?>) com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.class);
            intent.putExtra(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.ROLL_CAPTION_USE_FAMILY_COLOR, com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mUseFamilyColor);
            intent.putExtra(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.ROLL_CAPTION_FONT_COLOR, com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mCurrentColor);
            if (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionList != null) {
                intent.putExtra(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.INTENT_ROLL_CAPTION_SUBTITLE_LIST, com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mSubtitleBeans);
            }
            ((android.app.Activity) com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.getContext()).startActivityForResult(intent, 1006);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionChooser.setVisibility(8);
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionFontRecyclerView.setVisibility(8);
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionColorView.setVisibility(0);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionChooser.setVisibility(8);
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionFontRecyclerView.setVisibility(0);
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionColorView.setVisibility(8);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mCurrentColor = -1;
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mFontSource = null;
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mUseFamilyColor = true;
            if (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer != null) {
                com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer.reset();
                com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer.hide();
            }
            if (((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this).mOnEffectActionLister != null) {
                ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this).mOnEffectActionLister.onCancel();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer.reset();
            if (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer != null) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mSubtitleBeans == null || com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mUseFamilyColor) {
                    java.util.ArrayList arrayList2 = com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionList;
                    if (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mSubtitleBeans != null) {
                        arrayList2 = new java.util.ArrayList();
                        java.util.Iterator it = com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mSubtitleBeans.iterator();
                        while (it.hasNext()) {
                            com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean = (com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean) it.next();
                            arrayList2.add(alivcRollCaptionSubtitleBean.getShowTime() + alivcRollCaptionSubtitleBean.getContent());
                        }
                    }
                    com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer.updateCaptionList(arrayList2);
                    com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer.editCaptionFamilyStyle().setTextColor(com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mCurrentColor).setTextFont(com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mFontSource).done();
                } else {
                    java.util.Iterator it2 = com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mSubtitleBeans.iterator();
                    while (it2.hasNext()) {
                        com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean2 = (com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean) it2.next();
                        arrayList.add(alivcRollCaptionSubtitleBean2.getShowTime() + alivcRollCaptionSubtitleBean2.getContent());
                    }
                    com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer.updateCaptionList(arrayList);
                    com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor styleEditor = null;
                    for (int i = 0; i < com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mSubtitleBeans.size(); i++) {
                        styleEditor = com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer.editCaptionStyle(i);
                        styleEditor.setTextFont(com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mFontSource);
                        styleEditor.setTextColor(((com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean) com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mSubtitleBeans.get(i)).getColor());
                    }
                    if (styleEditor != null) {
                        styleEditor.done();
                    }
                }
                com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mAliyunRollCaptionComposer.show();
                if (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mOnEffectChangeListener != null) {
                    com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
                    effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.ROLL_CAPTION;
                    com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mOnEffectChangeListener.onEffectChange(effectInfo);
                }
                if (((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this).mOnEffectActionLister != null) {
                    ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this).mOnEffectActionLister.onCancel();
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView$6, reason: invalid class name */
    public class AnonymousClass6 implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
        public AnonymousClass6() {
        }

        @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
        public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
            com.aliyun.svideosdk.common.struct.project.Source source = effectInfo.fontSource;
            if (source != null) {
                com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mFontSource = source;
            } else {
                com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mFontSource = new com.aliyun.svideosdk.common.struct.project.Source(effectInfo.fontPath);
            }
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionChooser.setVisibility(0);
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionFontRecyclerView.setVisibility(8);
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionColorView.setVisibility(8);
            return false;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView$7, reason: invalid class name */
    public class AnonymousClass7 implements com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.OnColorSelectedListener {
        public AnonymousClass7() {
        }

        @Override // com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.OnColorSelectedListener
        public void onColorSelected(int i) {
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mUseFamilyColor = true;
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionChooser.setVisibility(0);
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mRollCaptionColorView.setVisibility(8);
            com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.this.mCurrentColor = i;
        }
    }

    public RollCaptionEffectChooseView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public RollCaptionEffectChooseView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RollCaptionEffectChooseView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentColor = -1;
        this.mUseFamilyColor = true;
    }

    private void initListener() {
        this.mRollCaptionSubtitleTextView.setOnClickListener(new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.AnonymousClass1());
        this.mRollCaptionColorTextView.setOnClickListener(new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.AnonymousClass2());
        this.mRollCaptionFontTextView.setOnClickListener(new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.AnonymousClass3());
        this.mRollCaptionClearTextView.setOnClickListener(new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.AnonymousClass4());
        this.mRollCaptionApplyImageView.setOnClickListener(new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.AnonymousClass5());
        this.mCaptionAdapter.setOnItemClickListener(new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.AnonymousClass6());
        this.mRollCaptionColorView.setOnColorSelectedListener(new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionEffectChooseView.AnonymousClass7());
    }

    private void initRecyclerView() {
        this.mRollCaptionFontRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.rollcaption.RollCaptionAdapter rollCaptionAdapter = new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionAdapter(getContext());
        this.mCaptionAdapter = rollCaptionAdapter;
        rollCaptionAdapter.showFontData();
        this.mRollCaptionFontRecyclerView.setAdapter(this.mCaptionAdapter);
    }

    private void parseRollCaptionLrc() {
        this.mRollCaptionList = new java.util.ArrayList<>();
        this.mSubtitleBeans = new java.util.ArrayList<>();
        this.mRollCaptionList.add("[00:01.32]我来到，你的城市");
        this.mRollCaptionList.add("[00:03.06]走过你来时的路");
        this.mRollCaptionList.add("[00:04.67]想像着，没我的日子");
        this.mRollCaptionList.add("[00:06.42]你是怎样的孤独");
        this.mRollCaptionList.add("[00:08.80]昨天已经");
        java.util.Iterator<java.lang.String> it = this.mRollCaptionList.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean alivcRollCaptionSubtitleBean = new com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean();
            java.lang.String[] split = next.split("]", 2);
            alivcRollCaptionSubtitleBean.setShowTime(split[0] + "]");
            alivcRollCaptionSubtitleBean.setContent(split[1]);
            this.mSubtitleBeans.add(alivcRollCaptionSubtitleBean);
        }
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_roll_caption, this);
        this.mRollCaptionChooser = (android.widget.LinearLayout) findViewById(com.aliyun.svideo.editor.R.id.roll_caption_chooser);
        this.mRollCaptionColorView = (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView) findViewById(com.aliyun.svideo.editor.R.id.roll_caption_color_view);
        this.mRollCaptionFontRecyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.roll_caption_font_recyclerview);
        this.mRollCaptionSubtitleTextView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_roll_caption_subtitle);
        this.mRollCaptionColorTextView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_roll_caption_color);
        this.mRollCaptionFontTextView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_roll_caption_font);
        this.mRollCaptionClearTextView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.roll_caption_clear_tv);
        this.mRollCaptionApplyImageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.roll_caption_apply_iv);
        initRecyclerView();
        initListener();
        parseRollCaptionLrc();
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.widget.LinearLayout linearLayout = this.mRollCaptionChooser;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView = this.mRollCaptionColorView;
        if (rollCaptionColorView != null) {
            rollCaptionColorView.setVisibility(8);
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRollCaptionFontRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public void setAliyunRollCaptionComposer(com.aliyun.svideosdk.editor.AliyunRollCaptionComposer aliyunRollCaptionComposer) {
        this.mAliyunRollCaptionComposer = aliyunRollCaptionComposer;
    }

    public void setSubtitleList(java.util.ArrayList<com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean> arrayList) {
        this.mSubtitleBeans = arrayList;
    }

    public void setUseFamilyColor(boolean z) {
        this.mUseFamilyColor = z;
    }
}
