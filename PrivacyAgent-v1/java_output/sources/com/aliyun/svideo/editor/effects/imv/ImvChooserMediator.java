package com.aliyun.svideo.editor.effects.imv;

/* loaded from: classes12.dex */
public class ImvChooserMediator extends com.aliyun.svideo.editor.effects.control.BaseChooser implements com.aliyun.svideo.editor.effects.control.OnItemClickListener {
    private int currentId;
    private com.aliyun.svideo.editor.effects.imv.ImvAdapter mImvAdapter;
    java.util.List<com.aliyun.svideo.base.Form.IMVForm> mImvList;
    private androidx.recyclerview.widget.RecyclerView mListView;
    private android.widget.TextView mTvEffectTitle;

    public ImvChooserMediator(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ImvChooserMediator(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImvChooserMediator(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private com.aliyun.svideo.base.Form.AspectForm addAspectForm(com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel) {
        com.aliyun.svideo.base.Form.AspectForm aspectForm = new com.aliyun.svideo.base.Form.AspectForm();
        aspectForm.setAspect(fileDownloaderModel.getAspect());
        aspectForm.setDownload(fileDownloaderModel.getDownload());
        aspectForm.setMd5(fileDownloaderModel.getMd5());
        aspectForm.setPath(fileDownloaderModel.getPath());
        return aspectForm;
    }

    private int getIndexById(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.mImvList.size(); i3++) {
            if (this.mImvList.get(i3).getId() == i) {
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        this.mImvList = new java.util.ArrayList();
        this.mImvList.add(new com.aliyun.svideo.base.Form.IMVForm());
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_mv, this);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.effect_list_filter);
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.imv.ImvAdapter imvAdapter = new com.aliyun.svideo.editor.effects.imv.ImvAdapter(getContext());
        this.mImvAdapter = imvAdapter;
        imvAdapter.setOnItemClickListener(this);
        this.mImvAdapter.setData(this.mImvList);
        this.mListView.setAdapter(this.mImvAdapter);
        this.mListView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.effect_title_tv);
        this.mTvEffectTitle = textView;
        textView.setText(com.aliyun.svideo.editor.R.string.alivc_editor_effect_mv);
        android.graphics.drawable.Drawable drawable = getContext().getResources().getDrawable(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_tab_mv);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mTvEffectTitle.setCompoundDrawables(drawable, null, null, null);
    }

    public void initResourceLocalWithSelectId(int i) {
        this.mImvList.clear();
        this.mImvList.add(new com.aliyun.svideo.base.Form.IMVForm());
        java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> resourceByType = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(3);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList<com.aliyun.svideo.downloader.FileDownloaderModel> arrayList3 = new java.util.ArrayList();
        if (resourceByType != null && resourceByType.size() > 0) {
            for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : resourceByType) {
                if (new java.io.File(fileDownloaderModel.getPath()).exists()) {
                    arrayList3.add(fileDownloaderModel);
                }
            }
            com.aliyun.svideo.base.Form.IMVForm iMVForm = null;
            java.util.ArrayList arrayList4 = null;
            for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel2 : arrayList3) {
                if (!arrayList2.contains(java.lang.Integer.valueOf(fileDownloaderModel2.getId()))) {
                    if (iMVForm != null) {
                        iMVForm.setAspectList(arrayList4);
                        arrayList.add(iMVForm);
                    }
                    arrayList2.add(java.lang.Integer.valueOf(fileDownloaderModel2.getId()));
                    iMVForm = new com.aliyun.svideo.base.Form.IMVForm();
                    arrayList4 = new java.util.ArrayList();
                    iMVForm.setId(fileDownloaderModel2.getId());
                    iMVForm.setName(fileDownloaderModel2.getName());
                    iMVForm.setNameEn(fileDownloaderModel2.getNameEn());
                    iMVForm.setKey(fileDownloaderModel2.getKey());
                    iMVForm.setLevel(fileDownloaderModel2.getLevel());
                    iMVForm.setTag(fileDownloaderModel2.getTag());
                    iMVForm.setCat(fileDownloaderModel2.getCat());
                    iMVForm.setIcon(fileDownloaderModel2.getIcon());
                    iMVForm.setPreviewPic(fileDownloaderModel2.getPreviewpic());
                    iMVForm.setPreviewMp4(fileDownloaderModel2.getPreviewmp4());
                    iMVForm.setDuration(fileDownloaderModel2.getDuration());
                    iMVForm.setType(fileDownloaderModel2.getSubtype());
                }
                arrayList4.add(addAspectForm(fileDownloaderModel2));
            }
            if (iMVForm != null) {
                iMVForm.setAspectList(arrayList4);
                arrayList.add(iMVForm);
            }
        }
        this.mImvList.addAll(arrayList);
        this.mImvAdapter.setData(this.mImvList);
        com.aliyun.svideo.editor.effects.imv.ImvAdapter imvAdapter = this.mImvAdapter;
        com.aliyun.svideo.editor.effects.control.EditorService editorService = this.mEditorService;
        com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.MV;
        imvAdapter.setSelectedPos(getIndexById(editorService.getEffectIndex(uIEditorPage)));
        this.mListView.scrollToPosition(getIndexById(this.mEditorService.getEffectIndex(uIEditorPage)));
        java.util.Iterator<com.aliyun.svideo.base.Form.IMVForm> it = this.mImvList.iterator();
        int i2 = -1;
        while (it.hasNext()) {
            i2++;
            if (it.next().getId() == i) {
                this.mImvAdapter.setEffecteffectiveAndNotify(i2);
                return;
            }
        }
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return false;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isShowSelectedView() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mEditorService == null) {
            this.mEditorService = new com.aliyun.svideo.editor.effects.control.EditorService();
        }
        initResourceLocalWithSelectId(-1);
    }

    @Override // com.aliyun.svideo.editor.effects.control.OnItemClickListener
    public boolean onItemClick(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo, int i) {
        if (this.mOnEffectChangeListener == null) {
            return true;
        }
        this.mEditorService.addTabEffect(com.aliyun.svideo.editor.effects.control.UIEditorPage.MV, i);
        this.mEditorService.addTabEffect(com.aliyun.svideo.editor.effects.control.UIEditorPage.AUDIO_MIX, 0);
        this.mOnEffectChangeListener.onEffectChange(effectInfo);
        this.mImvAdapter.notifyDataSetChanged();
        return true;
    }

    public void setCurrResourceID(int i) {
        if (i != -1) {
            this.mCurrID = i;
        }
        initResourceLocalWithSelectId(this.mCurrID);
    }
}
