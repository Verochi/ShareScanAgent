package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
public class FileDownloadBroadcastHandler {
    public static final java.lang.String ACTION_COMPLETED = "filedownloader.intent.action.completed";
    public static final java.lang.String KEY_MODEL = "model";

    public static com.liulishuo.filedownloader.model.FileDownloadModel parseIntent(android.content.Intent intent) {
        if (ACTION_COMPLETED.equals(intent.getAction())) {
            return (com.liulishuo.filedownloader.model.FileDownloadModel) intent.getParcelableExtra("model");
        }
        throw new java.lang.IllegalArgumentException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("can't recognize the intent with action %s, on the current version we only support action [%s]", intent.getAction(), ACTION_COMPLETED));
    }

    public static void sendCompletedBroadcast(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (fileDownloadModel.getStatus() != -3) {
            throw new java.lang.IllegalStateException();
        }
        android.content.Intent intent = new android.content.Intent(ACTION_COMPLETED);
        intent.putExtra("model", fileDownloadModel);
        com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().sendBroadcast(intent);
    }
}
