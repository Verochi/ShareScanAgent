package com.aliyun.svideo.editor.effects.rollcaption;

/* loaded from: classes12.dex */
public class RollCaptionColorView extends android.widget.FrameLayout {
    private com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.OnColorSelectedListener mListener;
    private androidx.recyclerview.widget.RecyclerView mRollCaptionColorRecyclerView;

    /* renamed from: com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.OnRollCaptionColorItemClickListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter.OnRollCaptionColorItemClickListener
        public void onItemClick(int i) {
            if (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.this.mListener != null) {
                com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.this.mListener.onColorSelected(i);
            }
        }
    }

    public interface OnColorSelectedListener {
        void onColorSelected(int i);
    }

    public RollCaptionColorView(android.content.Context context) {
        this(context, null);
    }

    public RollCaptionColorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RollCaptionColorView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_roll_caption_view, this);
        this.mRollCaptionColorRecyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.roll_caption_color_recyclerview);
        initRecyclerView();
    }

    private void initRecyclerView() {
        this.mRollCaptionColorRecyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter rollCaptionColorAdapter = new com.aliyun.svideo.editor.effectmanager.RollCaptionColorAdapter(getContext());
        this.mRollCaptionColorRecyclerView.setAdapter(rollCaptionColorAdapter);
        rollCaptionColorAdapter.setOnRollCaptionColorItemClickListener(new com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.AnonymousClass1());
    }

    public void setOnColorSelectedListener(com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView.OnColorSelectedListener onColorSelectedListener) {
        this.mListener = onColorSelectedListener;
    }
}
