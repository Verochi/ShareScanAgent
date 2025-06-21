package com.aliyun.svideo.editor.effects.caption.manager;

/* loaded from: classes12.dex */
public class AlivcEditorViewFactory {
    private static final java.lang.String TAG = "AliEditorViewFactory";

    public static com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView findCaptionEditorPanelView(android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        return (com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView) viewGroup.findViewWithTag("CaptionEditorPanelView");
    }

    @androidx.annotation.Nullable
    public static com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView obtainCaptionBorderView(android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = (com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView) viewGroup.findViewById(com.aliyun.svideo.editor.R.id.aliyun_edit_overlay);
        if (aliyunPasterCaptionBorderView != null) {
            return aliyunPasterCaptionBorderView;
        }
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView2 = (com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView) android.view.View.inflate(viewGroup.getContext(), com.aliyun.svideo.editor.R.layout.alivc_editor_view_caption_controller, null);
        viewGroup.addView(aliyunPasterCaptionBorderView2, -1, -1);
        return aliyunPasterCaptionBorderView2;
    }

    public static com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView obtainCaptionEditorPanelView(android.view.ViewGroup viewGroup, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        if (viewGroup == null) {
            return null;
        }
        com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView findCaptionEditorPanelView = findCaptionEditorPanelView(viewGroup);
        if (findCaptionEditorPanelView != null) {
            return findCaptionEditorPanelView;
        }
        com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView captionEditorPanelView = new com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView(viewGroup.getContext(), onCaptionChooserStateChangeListener);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        captionEditorPanelView.setTag("CaptionEditorPanelView");
        viewGroup.addView(captionEditorPanelView, layoutParams);
        return captionEditorPanelView;
    }
}
