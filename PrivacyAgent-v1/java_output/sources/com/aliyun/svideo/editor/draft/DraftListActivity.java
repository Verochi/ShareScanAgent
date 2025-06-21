package com.aliyun.svideo.editor.draft;

/* loaded from: classes29.dex */
public class DraftListActivity extends androidx.fragment.app.FragmentActivity {
    public static final int REQUEST_IMAGE = 2021;
    public static java.lang.String SERVER_ADD_PROJECT_URL = null;
    public static java.lang.String SERVER_DELETE_URL = null;
    public static java.lang.String SERVER_GET_PROJECTS_URL = null;
    public static java.lang.String SERVER_UPLOAD_URL = null;
    public static java.lang.String SERVER_URL_DEFAULT = "http://30.211.64.221:5000/";
    public static java.lang.String SERVER_USER_NAME_DEFAULT = "Coder.Pi";
    private com.aliyun.svideosdk.editor.draft.AliyunDraft curCoverDraft;
    private com.aliyun.svideo.editor.draft.LocalDraftAdapter mLocalDraftAdapter;
    private com.google.android.material.tabs.TabLayout mTabLayout;
    private androidx.viewpager.widget.ViewPager mViewPager;

    /* renamed from: com.aliyun.svideo.editor.draft.DraftListActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.draft.DraftListActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.DraftListActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.draft.DraftListActivity.this.showConfigDialog();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.DraftListActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        final /* synthetic */ com.google.android.material.bottomsheet.BottomSheetDialog val$bottomSheetDialog;
        final /* synthetic */ android.view.View.OnClickListener val$onClickListener;
        final /* synthetic */ java.lang.Object val$tag;

        public AnonymousClass3(java.lang.Object obj, android.view.View.OnClickListener onClickListener, com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog) {
            this.val$tag = obj;
            this.val$onClickListener = onClickListener;
            this.val$bottomSheetDialog = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            view.setTag(this.val$tag);
            this.val$onClickListener.onClick(view);
            this.val$bottomSheetDialog.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.DraftListActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        final /* synthetic */ com.google.android.material.bottomsheet.BottomSheetDialog val$bottomSheetDialog;
        final /* synthetic */ android.view.View.OnClickListener val$onClickListener;
        final /* synthetic */ java.lang.Object val$tag;

        public AnonymousClass4(java.lang.Object obj, android.view.View.OnClickListener onClickListener, com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog) {
            this.val$tag = obj;
            this.val$onClickListener = onClickListener;
            this.val$bottomSheetDialog = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            view.setTag(this.val$tag);
            this.val$onClickListener.onClick(view);
            this.val$bottomSheetDialog.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.draft.DraftListActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.OnCloudDraftConfigListener {
        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.OnCloudDraftConfigListener
        public void onConfig(java.lang.String str, java.lang.String str2) {
            com.aliyun.svideo.editor.draft.DraftListActivity.this.getApplicationContext().getSharedPreferences("cloud_draft_config", 0).edit().putString("server_url", str).putString("user_name", str2).commit();
            com.aliyun.svideo.editor.draft.DraftListActivity.this.initCloudConfig(str, str2);
            com.aliyun.svideo.editor.draft.DraftListActivity.this.initData();
        }
    }

    private java.lang.String getRealPathFromURI(android.net.Uri uri) {
        android.database.Cursor query;
        int columnIndex;
        java.lang.String str = null;
        if (uri == null) {
            return null;
        }
        java.lang.String scheme = uri.getScheme();
        if (scheme != null && !"file".equals(scheme)) {
            if (!"content".equals(scheme) || (query = getContentResolver().query(uri, new java.lang.String[]{"_data"}, null, null, null)) == null) {
                return null;
            }
            if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
                str = query.getString(columnIndex);
            }
            query.close();
            return str;
        }
        return uri.getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCloudConfig(java.lang.String str, java.lang.String str2) {
        SERVER_GET_PROJECTS_URL = str + "get_projects/" + str2;
        SERVER_ADD_PROJECT_URL = str + "add_project/" + str2;
        SERVER_DELETE_URL = str + "delete_project/" + str2;
        SERVER_UPLOAD_URL = str + "upload_resource/" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        com.aliyun.svideo.editor.util.EditorCommon.copySelf(this.mTabLayout.getContext(), "svideo_res");
        this.mViewPager.setAdapter(new com.aliyun.svideo.editor.draft.DraftPagerAdapter(getSupportFragmentManager()));
        this.mTabLayout.setupWithViewPager(this.mViewPager);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.lang.String charSequence;
        super.onActivityResult(i, i2, intent);
        if (i == 2021) {
            if (i2 != -1 || this.curCoverDraft == null) {
                charSequence = getText(com.aliyun.svideo.editor.R.string.alivc_svideo_draft_cover_cancel).toString();
            } else {
                java.lang.String realPathFromURI = getRealPathFromURI(intent.getData());
                if (com.aliyun.common.utils.StringUtils.isEmpty(realPathFromURI)) {
                    charSequence = getText(com.aliyun.svideo.editor.R.string.alivc_svideo_draft_cover_failed).toString();
                } else {
                    com.aliyun.svideosdk.editor.draft.AliyunDraftManager.getInstance(getApplication()).updateCover(this.curCoverDraft, new com.aliyun.svideosdk.common.struct.project.Source(realPathFromURI));
                    this.mLocalDraftAdapter.notifyDataSetChanged();
                    charSequence = "";
                }
            }
            if (!com.aliyun.common.utils.StringUtils.isEmpty(charSequence)) {
                android.widget.Toast.makeText(this, charSequence, 0).show();
            }
            this.curCoverDraft = null;
            this.mLocalDraftAdapter = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_draft_list);
        this.mTabLayout = (com.google.android.material.tabs.TabLayout) findViewById(com.aliyun.svideo.editor.R.id.tab_layout);
        this.mViewPager = (androidx.viewpager.widget.ViewPager) findViewById(com.aliyun.svideo.editor.R.id.view_pager);
        findViewById(com.aliyun.svideo.editor.R.id.alivc_back_btn).setOnClickListener(new com.aliyun.svideo.editor.draft.DraftListActivity.AnonymousClass1());
        findViewById(com.aliyun.svideo.editor.R.id.alivc_draft_config_btn).setOnClickListener(new com.aliyun.svideo.editor.draft.DraftListActivity.AnonymousClass2());
        android.content.SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("cloud_draft_config", 0);
        initCloudConfig(sharedPreferences.getString("server_url", SERVER_URL_DEFAULT), sharedPreferences.getString("user_name", SERVER_USER_NAME_DEFAULT));
        initData();
    }

    public void showCloudMenu(android.view.View.OnClickListener onClickListener, java.lang.Object obj) {
        com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(this);
        com.aliyun.svideo.editor.draft.DraftListActivity.AnonymousClass4 anonymousClass4 = new com.aliyun.svideo.editor.draft.DraftListActivity.AnonymousClass4(obj, onClickListener, bottomSheetDialog);
        android.view.View inflate = android.view.View.inflate(this, com.aliyun.svideo.editor.R.layout.alivc_editor_cloud_draft_bottom_sheet, null);
        inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_delete_btn).setOnClickListener(anonymousClass4);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.show();
    }

    public void showConfigDialog() {
        android.content.SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("cloud_draft_config", 0);
        java.lang.String string = sharedPreferences.getString("server_url", SERVER_URL_DEFAULT);
        java.lang.String string2 = sharedPreferences.getString("user_name", SERVER_USER_NAME_DEFAULT);
        com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment cloudDraftConfigDialogFragment = new com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment();
        cloudDraftConfigDialogFragment.setServerUrl(string);
        cloudDraftConfigDialogFragment.setUserName(string2);
        cloudDraftConfigDialogFragment.setOnCloudDraftConfigListener(new com.aliyun.svideo.editor.draft.DraftListActivity.AnonymousClass5());
        cloudDraftConfigDialogFragment.show(getSupportFragmentManager(), com.aliyun.svideo.editor.draft.CloudDraftConfigDialogFragment.class.getSimpleName());
    }

    public void showMenu(boolean z, android.view.View.OnClickListener onClickListener, java.lang.Object obj) {
        com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(this);
        com.aliyun.svideo.editor.draft.DraftListActivity.AnonymousClass3 anonymousClass3 = new com.aliyun.svideo.editor.draft.DraftListActivity.AnonymousClass3(obj, onClickListener, bottomSheetDialog);
        android.view.View inflate = android.view.View.inflate(this, com.aliyun.svideo.editor.R.layout.alivc_editor_draft_bottom_sheet, null);
        inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_rename_btn).setOnClickListener(anonymousClass3);
        inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_update_cover_btn).setOnClickListener(anonymousClass3);
        inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_copy_btn).setOnClickListener(anonymousClass3);
        inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_delete_btn).setOnClickListener(anonymousClass3);
        int i = com.aliyun.svideo.editor.R.id.alivc_backup_btn;
        inflate.findViewById(i).setOnClickListener(anonymousClass3);
        if (z) {
            inflate.findViewById(i).setVisibility(8);
        } else {
            inflate.findViewById(i).setVisibility(0);
        }
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.show();
    }

    public void showRenameDialog(java.lang.String str, com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.OnRenameListener onRenameListener) {
        com.aliyun.svideo.editor.draft.DraftRenameDialogFragment draftRenameDialogFragment = new com.aliyun.svideo.editor.draft.DraftRenameDialogFragment();
        draftRenameDialogFragment.setOnRenameListener(onRenameListener);
        draftRenameDialogFragment.setDraftName(str);
        draftRenameDialogFragment.show(getSupportFragmentManager(), com.aliyun.svideo.editor.draft.DraftRenameDialogFragment.class.getSimpleName());
    }

    public void updateCover(com.aliyun.svideo.editor.draft.LocalDraftAdapter localDraftAdapter, com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft) {
        this.mLocalDraftAdapter = localDraftAdapter;
        this.curCoverDraft = aliyunDraft;
        android.content.Intent intent = new android.content.Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 2021);
    }
}
