package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunRollCaptionComposer {

    @com.aliyun.Visible
    public interface StyleEditor {
        void done();

        com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor setDefaultTextSize(int i, int i2);

        com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor setTextColor(int i);

        com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor setTextFont(com.aliyun.svideosdk.common.struct.project.Source source);

        @java.lang.Deprecated
        com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor setTextFont(java.lang.String str);

        com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor setTextStrokeColor(int i);
    }

    com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor editCaptionFamilyStyle();

    com.aliyun.svideosdk.editor.AliyunRollCaptionComposer.StyleEditor editCaptionStyle(int i);

    void hide();

    void reset();

    boolean show();

    void updateCaptionList(java.util.List<java.lang.String> list);
}
