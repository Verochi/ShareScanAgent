package com.aliyun.svideosdk.editor.draft;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public abstract class AliyunDraftManager {
    private static volatile com.aliyun.svideosdk.editor.draft.DraftManagerImpl sDraftManagerManager;

    public static com.aliyun.svideosdk.editor.draft.AliyunDraftManager getInstance(android.content.Context context) {
        if (sDraftManagerManager == null) {
            synchronized (com.aliyun.svideosdk.editor.draft.AliyunDraftManager.class) {
                if (sDraftManagerManager == null) {
                    java.io.File file = new java.io.File(context.getExternalFilesDir(null).getAbsolutePath() + java.io.File.separator + com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.DRAFT_DIR);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    sDraftManagerManager = new com.aliyun.svideosdk.editor.draft.DraftManagerImpl(file.getAbsolutePath());
                }
            }
        }
        return sDraftManagerManager;
    }

    public abstract com.aliyun.svideosdk.editor.draft.AliyunDraft copy(java.lang.String str);

    public abstract void deleteDraft(java.lang.String str);

    public abstract void downloadDraft(java.io.File file, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceDownloader aliyunDraftResourceDownloader);

    public abstract com.aliyun.svideosdk.editor.draft.AliyunDraft getDraft(java.lang.String str);

    public abstract com.aliyun.svideosdk.editor.draft.AliyunDraft getDraftByPath(java.lang.String str);

    public abstract java.util.List<com.aliyun.svideosdk.editor.draft.AliyunDraft> getDraftList();

    public abstract void getDraftListByAsync(com.aliyun.svideosdk.editor.draft.AliyunDraftListCallback aliyunDraftListCallback);

    public abstract void preLoadDraft(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceLoader aliyunDraftResourceLoader);

    public abstract void rename(java.lang.String str, java.lang.String str2);

    public abstract void setProjectId(java.lang.String str, java.lang.String str2);

    public abstract void updateCover(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.common.struct.project.Source source);

    public abstract void uploadDraft(com.aliyun.svideosdk.editor.draft.AliyunDraft aliyunDraft, com.aliyun.svideosdk.editor.draft.AliyunDraftResourceUploader aliyunDraftResourceUploader);
}
