package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes29.dex */
public class RollCaptionSubtitleActivity extends androidx.appcompat.app.AppCompatActivity {
    public static final java.lang.String INTENT_ROLL_CAPTION_SUBTITLE_LIST = "intent_roll_caption_subtitle_list";
    public static final java.lang.String ROLL_CAPTION_FONT_COLOR = "roll_caption_font_color";
    public static final java.lang.String ROLL_CAPTION_USE_FAMILY_COLOR = "roll_caption_use_family_color";
    private android.widget.ImageView mBackImageView;
    private android.widget.ImageView mCommitImageView;
    private android.widget.ImageView mEditColorImageView;
    private int mFontColor;
    private com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView mRollCaptionColorView;
    private androidx.recyclerview.widget.RecyclerView mRollCaptionRecyclerView;
    private com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter mRollCaptionSubtitleAdapter;
    private java.util.ArrayList<com.aliyun.svideo.editor.bean.AlivcRollCaptionSubtitleBean> mSubtitleList;
    private boolean mUseFamilyColor;

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.OnSelectItemChangedListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter.OnSelectItemChangedListener
        public void onSelectItemChanged(int i, int i2, int i3, boolean z) {
            com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mEditColorImageView.setVisibility(i > 0 ? 0 : 8);
            if (i <= 0 || i2 > 0) {
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionColorView.setVisibility(8);
            }
            com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mEditColorImageView.setClickable(i2 == 0);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionColorView.getVisibility() == 0) {
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionColorView.setVisibility(8);
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mEditColorImageView.setVisibility(8);
                if (com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionSubtitleAdapter != null) {
                    com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionSubtitleAdapter.confirmColor();
                }
            } else {
                android.content.Intent intent = new android.content.Intent();
                intent.putExtra(com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.INTENT_ROLL_CAPTION_SUBTITLE_LIST, com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mSubtitleList);
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.setResult(-1, intent);
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.finish();
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mSubtitleList.clear();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionColorView.getVisibility() != 0) {
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionColorView.setVisibility(0);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.OnColorSelectedListener {
        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.OnColorSelectedListener
        public void onColorSelected(int i) {
            if (com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionSubtitleAdapter != null) {
                com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.this.mRollCaptionSubtitleAdapter.setColor(i);
            }
        }
    }

    private void initListener() {
        this.mBackImageView.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.AnonymousClass2());
        this.mCommitImageView.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.AnonymousClass3());
        this.mEditColorImageView.setOnClickListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.AnonymousClass4());
        this.mRollCaptionColorView.setOnColorSelectedListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.AnonymousClass5());
    }

    private void initRecyclerView() {
        this.mRollCaptionRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this, 1, false));
        com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter rollCaptionSubtitleAdapter = new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleAdapter(this.mSubtitleList);
        this.mRollCaptionSubtitleAdapter = rollCaptionSubtitleAdapter;
        if (this.mUseFamilyColor) {
            rollCaptionSubtitleAdapter.setAllColor(this.mFontColor);
        }
        this.mRollCaptionRecyclerView.setAdapter(this.mRollCaptionSubtitleAdapter);
        this.mRollCaptionSubtitleAdapter.setOnSelectItemChangedListener(new com.aliyun.svideo.editor.effectmanager.RollCaptionSubtitleActivity.AnonymousClass1());
    }

    private void initView() {
        this.mBackImageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.aliyun_back_iv);
        this.mCommitImageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_commit);
        this.mEditColorImageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_edit_color);
        this.mRollCaptionRecyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.roll_caption_recyclerview);
        this.mRollCaptionColorView = (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView) findViewById(com.aliyun.svideo.editor.R.id.roll_caption_color_view);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.activity_roll_caption_subtitle);
        this.mFontColor = getIntent().getIntExtra(ROLL_CAPTION_FONT_COLOR, -1);
        this.mSubtitleList = (java.util.ArrayList) getIntent().getSerializableExtra(INTENT_ROLL_CAPTION_SUBTITLE_LIST);
        this.mUseFamilyColor = getIntent().getBooleanExtra(ROLL_CAPTION_USE_FAMILY_COLOR, true);
        initView();
        initRecyclerView();
        initListener();
    }
}
