package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public abstract class TTDislikeDialogAbstract extends android.app.Dialog {
    private android.view.View vw;

    public TTDislikeDialogAbstract(android.content.Context context) {
        super(context);
    }

    public TTDislikeDialogAbstract(android.content.Context context, int i) {
        super(context, i);
    }

    public abstract int getLayoutId();

    public abstract android.view.ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(getLayoutId(), (android.view.ViewGroup) null);
            this.vw = inflate;
            if (inflate == null) {
                return;
            }
            android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
            android.view.View view = this.vw;
            if (layoutParams == null) {
                layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            vw();
        } catch (java.lang.Exception unused) {
        }
    }

    @java.lang.Deprecated
    public void setDislikeModel(com.bytedance.sdk.openadsdk.TTDislikeController tTDislikeController) {
    }

    @java.lang.Deprecated
    public void startPersonalizePromptActivity() {
    }

    public void vw() {
        if (this.vw == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
            throw new java.lang.IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
        }
        for (int i : tTDislikeListViewIds) {
            android.view.View findViewById = this.vw.findViewById(i);
            if (findViewById == null) {
                throw new java.lang.IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
            }
            if (!(findViewById instanceof com.bytedance.sdk.openadsdk.DislikeListView)) {
                throw new java.lang.IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
            }
        }
    }
}
