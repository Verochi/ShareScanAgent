package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public class DislikeListView extends android.widget.ListView {
    private com.bykv.vk.openvk.api.proto.EventListener mOnItemClickBridge;
    private android.widget.AdapterView.OnItemClickListener mOnItemClickListener;
    private android.widget.AdapterView.OnItemClickListener mOnItemClickListenerInner;

    /* renamed from: com.bytedance.sdk.openadsdk.DislikeListView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.AdapterView.OnItemClickListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            if (com.bytedance.sdk.openadsdk.DislikeListView.this.getAdapter() == null || com.bytedance.sdk.openadsdk.DislikeListView.this.getAdapter().getItem(i) == null || !(com.bytedance.sdk.openadsdk.DislikeListView.this.getAdapter().getItem(i) instanceof com.bytedance.sdk.openadsdk.FilterWord)) {
                java.lang.IllegalArgumentException illegalArgumentException = new java.lang.IllegalArgumentException("adapter数据异常，必须为FilterWord");
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
                throw illegalArgumentException;
            }
            com.bytedance.sdk.openadsdk.FilterWord filterWord = (com.bytedance.sdk.openadsdk.FilterWord) com.bytedance.sdk.openadsdk.DislikeListView.this.getAdapter().getItem(i);
            if (!filterWord.hasSecondOptions()) {
                if (com.bytedance.sdk.openadsdk.DislikeListView.this.mOnItemClickListener != null) {
                    com.bytedance.sdk.openadsdk.DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i, j);
                }
                if (com.bytedance.sdk.openadsdk.DislikeListView.this.mOnItemClickBridge != null) {
                    com.bytedance.sdk.openadsdk.DislikeListView.this.mOnItemClickBridge.onEvent(0, com.bykv.vw.vw.vw.vw.vw.vw().vw(com.bykv.vw.vw.vw.vw.wg.vw().vw(0, filterWord.getId()).vw(1, filterWord.getName()).wg()).wg());
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
        }
    }

    public DislikeListView(android.content.Context context) {
        super(context);
        this.mOnItemClickListenerInner = new com.bytedance.sdk.openadsdk.DislikeListView.AnonymousClass1();
        init();
    }

    public DislikeListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListenerInner = new com.bytedance.sdk.openadsdk.DislikeListView.AnonymousClass1();
        init();
    }

    public DislikeListView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnItemClickListenerInner = new com.bytedance.sdk.openadsdk.DislikeListView.AnonymousClass1();
        init();
    }

    private void init() {
        super.setOnItemClickListener(this.mOnItemClickListenerInner);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener instanceof com.bykv.vk.openvk.api.proto.EventListener) {
            this.mOnItemClickBridge = (com.bykv.vk.openvk.api.proto.EventListener) onItemClickListener;
        } else {
            this.mOnItemClickListener = onItemClickListener;
        }
    }
}
