package com.aliyun.svideosdk.editor.draft;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunTemplateDraftManager {
    private static volatile com.aliyun.svideosdk.editor.draft.DraftManagerImpl sDraftManagerManager;

    public static com.aliyun.svideosdk.editor.draft.AliyunDraftManager getInstance(android.content.Context context) {
        if (sDraftManagerManager == null) {
            synchronized (com.aliyun.svideosdk.editor.draft.AliyunDraftManager.class) {
                if (sDraftManagerManager == null) {
                    java.io.File file = new java.io.File(context.getExternalFilesDir(null).getAbsolutePath() + java.io.File.separator + com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.TEMPLATE_DRAFT_DIR);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    sDraftManagerManager = new com.aliyun.svideosdk.editor.draft.DraftManagerImpl(file.getAbsolutePath());
                }
            }
        }
        return sDraftManagerManager;
    }
}
