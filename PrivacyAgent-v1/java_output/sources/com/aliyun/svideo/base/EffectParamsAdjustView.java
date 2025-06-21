package com.aliyun.svideo.base;

/* loaded from: classes.dex */
public class EffectParamsAdjustView extends android.widget.FrameLayout {
    private com.aliyun.svideo.base.EffectParamsAdjustView.Adapter mAdapter;
    java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params> mData;
    private com.aliyun.svideo.base.EffectParamsAdjustView.OnAdjustListener mOnAdjustListener;

    /* renamed from: com.aliyun.svideo.base.EffectParamsAdjustView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ValueTypeEnum;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.values().length];
            $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ValueTypeEnum = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.INT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$struct$effect$ValueTypeEnum[com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.FLOAT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public class Adapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aliyun.svideo.base.EffectParamsAdjustView.Adapter.MyViewHolder> {

        /* renamed from: com.aliyun.svideo.base.EffectParamsAdjustView$Adapter$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.svideo.base.widget.beauty.listener.AbstractOnProgressFloatChangeListener {
            final /* synthetic */ com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params val$params;

            public AnonymousClass1(com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params params) {
                this.val$params = params;
            }

            @Override // com.aliyun.svideo.base.widget.beauty.listener.AbstractOnProgressFloatChangeListener
            public void onProgressFloatChange(int i, float f) {
                int i2 = com.aliyun.svideo.base.EffectParamsAdjustView.AnonymousClass1.$SwitchMap$com$aliyun$svideosdk$common$struct$effect$ValueTypeEnum[this.val$params.getType().ordinal()];
                if (i2 == 1) {
                    this.val$params.getValue().updateINT(java.lang.Integer.valueOf(i));
                } else if (i2 == 2) {
                    this.val$params.getValue().updateFLOAT(java.lang.Float.valueOf(f));
                }
                if (com.aliyun.svideo.base.EffectParamsAdjustView.this.mOnAdjustListener != null) {
                    com.aliyun.svideo.base.EffectParamsAdjustView.this.mOnAdjustListener.onAdjust();
                }
            }
        }

        public class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            private android.widget.TextView mName;
            private com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar mSeekBar;

            private MyViewHolder(android.view.View view) {
                super(view);
                this.mName = (android.widget.TextView) view.findViewById(com.aliyun.svideo.base.R.id.tv_effect_params_name);
                this.mSeekBar = (com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar) view.findViewById(com.aliyun.svideo.base.R.id.seekbar_effect_params);
            }

            public /* synthetic */ MyViewHolder(com.aliyun.svideo.base.EffectParamsAdjustView.Adapter adapter, android.view.View view, defpackage.p90 p90Var) {
                this(view);
            }
        }

        private Adapter() {
        }

        public /* synthetic */ Adapter(com.aliyun.svideo.base.EffectParamsAdjustView effectParamsAdjustView, defpackage.q90 q90Var) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return com.aliyun.svideo.base.EffectParamsAdjustView.this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(com.aliyun.svideo.base.EffectParamsAdjustView.Adapter.MyViewHolder myViewHolder, int i) {
            com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params params = com.aliyun.svideo.base.EffectParamsAdjustView.this.mData.get(i);
            myViewHolder.mName.setText(com.aliyun.svideo.base.EffectParamsAdjustView.this.mData.get(i).getName());
            java.lang.Object[] value = params.getValue().getValue();
            java.lang.Object[] value2 = params.getMaxValue().getValue();
            java.lang.Object[] value3 = params.getMinValue().getValue();
            myViewHolder.mSeekBar.setProgressChangeListener(new com.aliyun.svideo.base.EffectParamsAdjustView.Adapter.AnonymousClass1(params));
            int i2 = com.aliyun.svideo.base.EffectParamsAdjustView.AnonymousClass1.$SwitchMap$com$aliyun$svideosdk$common$struct$effect$ValueTypeEnum[params.getType().ordinal()];
            if (i2 == 1) {
                myViewHolder.mSeekBar.setFloatProgress(false);
                myViewHolder.mSeekBar.setMin(((java.lang.Integer) value3[0]).intValue());
                myViewHolder.mSeekBar.setMax(((java.lang.Integer) value2[0]).intValue());
                myViewHolder.mSeekBar.setIndicatorAndProgress((int) (((((java.lang.Integer) value[0]).intValue() - ((java.lang.Integer) value3[0]).intValue()) / (((java.lang.Integer) value2[0]).intValue() - ((java.lang.Integer) value3[0]).intValue())) * 100.0f), ((java.lang.Integer) value[0]).intValue());
                return;
            }
            if (i2 != 2) {
                return;
            }
            myViewHolder.mSeekBar.setFloatProgress(true);
            myViewHolder.mSeekBar.setMin(((java.lang.Float) value3[0]).floatValue());
            myViewHolder.mSeekBar.setMax(((java.lang.Float) value2[0]).floatValue());
            myViewHolder.mSeekBar.setIndicatorAndProgress((int) (((((java.lang.Float) value[0]).floatValue() - ((java.lang.Float) value3[0]).floatValue()) / (((java.lang.Float) value2[0]).floatValue() - ((java.lang.Float) value3[0]).floatValue())) * 100.0f), ((java.lang.Float) value[0]).floatValue());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public com.aliyun.svideo.base.EffectParamsAdjustView.Adapter.MyViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            return new com.aliyun.svideo.base.EffectParamsAdjustView.Adapter.MyViewHolder(this, android.view.LayoutInflater.from(com.aliyun.svideo.base.EffectParamsAdjustView.this.getContext()).inflate(com.aliyun.svideo.base.R.layout.aliyun_svideo_effect_params_item, (android.view.ViewGroup) com.aliyun.svideo.base.EffectParamsAdjustView.this, false), null);
        }
    }

    public interface OnAdjustListener {
        void onAdjust();
    }

    public EffectParamsAdjustView(android.content.Context context) {
        this(context, null);
    }

    public EffectParamsAdjustView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EffectParamsAdjustView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mData = new java.util.ArrayList();
        init();
    }

    private void init() {
        androidx.recyclerview.widget.RecyclerView recyclerView = new androidx.recyclerview.widget.RecyclerView(getContext());
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 1, false));
        recyclerView.setLayoutParams(new androidx.recyclerview.widget.RecyclerView.LayoutParams(-1, -2));
        com.aliyun.svideo.base.EffectParamsAdjustView.Adapter adapter = new com.aliyun.svideo.base.EffectParamsAdjustView.Adapter(this, null);
        this.mAdapter = adapter;
        recyclerView.setAdapter(adapter);
        addView(recyclerView);
    }

    public void setData(java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params> list) {
        this.mData.clear();
        this.mData.addAll(list);
        this.mAdapter.notifyDataSetChanged();
    }

    public void setOnAdjustListener(com.aliyun.svideo.base.EffectParamsAdjustView.OnAdjustListener onAdjustListener) {
        this.mOnAdjustListener = onAdjustListener;
    }
}
