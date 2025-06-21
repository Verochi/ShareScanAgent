package com.aliyun.svideo.editor.effects.paint;

/* loaded from: classes12.dex */
public class PaintChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements android.view.View.OnClickListener {
    private android.widget.ImageView mCancel;
    private com.aliyun.svideo.editor.effects.paint.ColorAdapter mColorAdapter;
    private android.widget.ImageView mComplete;
    private int mCurrentColor;
    private android.graphics.Paint mCurrentPaint;
    private float mCurrentSize;
    private android.widget.ImageView mIvEffectIcon;
    private androidx.recyclerview.widget.RecyclerView mListView;
    private android.widget.FrameLayout mPaintOne;
    private com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect mPaintSelect;
    private android.widget.FrameLayout mPaintThree;
    private android.widget.FrameLayout mPaintTwo;
    private android.widget.TextView mTvEffectTitle;
    private java.util.Map<java.lang.Float, android.view.View> mViews;

    /* renamed from: com.aliyun.svideo.editor.effects.paint.PaintChooserView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect
        public void onColorSelect(int i) {
            com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mCurrentColor = i;
            com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mCurrentPaint.setColor(i);
            com.aliyun.svideo.editor.effects.paint.PaintChooserView paintChooserView = com.aliyun.svideo.editor.effects.paint.PaintChooserView.this;
            paintChooserView.mEditorService.setPaint(paintChooserView.mCurrentPaint);
            if (com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mViews.get(java.lang.Float.valueOf(com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mCurrentSize)) != null) {
                ((android.view.View) com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mViews.get(java.lang.Float.valueOf(com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mCurrentSize))).setBackgroundDrawable(com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.getCurrentCircle());
            }
            if (com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mPaintSelect != null) {
                com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mPaintSelect.onColorSelect(i);
            }
        }

        @Override // com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect
        public void onSizeSelect(float f) {
            if (com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mPaintSelect != null) {
                com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mPaintSelect.onSizeSelect(f);
            }
        }

        @Override // com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect
        public void onUndo() {
            if (com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mPaintSelect != null) {
                com.aliyun.svideo.editor.effects.paint.PaintChooserView.this.mPaintSelect.onUndo();
            }
        }
    }

    public interface PaintSelect {
        void onColorSelect(int i);

        void onSizeSelect(float f);

        void onUndo();
    }

    public PaintChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public PaintChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaintChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentColor = -1;
    }

    private void clearPaint() {
        android.widget.FrameLayout frameLayout = this.mPaintOne;
        int i = com.aliyun.svideo.editor.R.color.alivc_common_bg_transparent;
        frameLayout.setBackgroundResource(i);
        this.mPaintTwo.setBackgroundResource(i);
        this.mPaintThree.setBackgroundResource(i);
    }

    private void fillViews() {
        this.mViews.put(java.lang.Float.valueOf(dip2px(getContext(), 5.0f)), this.mPaintOne);
        this.mViews.put(java.lang.Float.valueOf(dip2px(getContext(), 10.0f)), this.mPaintTwo);
        this.mViews.put(java.lang.Float.valueOf(dip2px(getContext(), 15.0f)), this.mPaintThree);
    }

    private float getApproximate(float f, java.lang.Float[] fArr) {
        if (fArr == null) {
            return -1.0f;
        }
        if (fArr.length == 1) {
            return fArr[0].floatValue();
        }
        int i = 0;
        while (true) {
            if (i >= fArr.length) {
                i = -1;
                break;
            }
            if (fArr[i].floatValue() > f) {
                break;
            }
            if (fArr[i].floatValue() == f) {
                return f;
            }
            i++;
        }
        if (i == -1) {
            return fArr[fArr.length - 1].floatValue();
        }
        if (i == 0) {
            return fArr[0].floatValue();
        }
        int i2 = i - 1;
        return (f - fArr[i2].floatValue() < fArr[i].floatValue() - f ? fArr[i2] : fArr[i]).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.drawable.Drawable getCurrentCircle() {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(this.mCurrentColor);
        return gradientDrawable;
    }

    public float dip2px(android.content.Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        this.mViews = new java.util.HashMap();
        this.mCurrentPaint = new android.graphics.Paint();
        android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_paint, (android.view.ViewGroup) this, true);
        this.mTvEffectTitle = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        this.mIvEffectIcon = imageView;
        imageView.setImageResource(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_paint);
        this.mTvEffectTitle.setText(com.aliyun.svideo.editor.R.string.alivc_editor_effect_paint);
        this.mCancel = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.cancel);
        this.mComplete = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.complete);
        this.mListView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.aliyun.svideo.editor.R.id.color_list);
        this.mPaintOne = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.paint_one);
        this.mPaintTwo = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.paint_two);
        this.mPaintThree = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.paint_three);
        fillViews();
        this.mCurrentSize = dip2px(getContext(), 5.0f);
        this.mCurrentPaint.setColor(this.mCurrentColor);
        this.mCurrentPaint.setStrokeWidth(this.mCurrentSize);
        this.mCancel.setOnClickListener(this);
        this.mComplete.setOnClickListener(this);
        this.mPaintOne.setOnClickListener(this);
        this.mPaintTwo.setOnClickListener(this);
        this.mPaintThree.setOnClickListener(this);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.aliyun.svideo.editor.effects.control.EditorService editorService = this.mEditorService;
        if (editorService != null && editorService.getPaint() != null) {
            android.graphics.Paint paint = this.mEditorService.getPaint();
            this.mCurrentPaint = paint;
            if (paint != null) {
                this.mCurrentColor = paint.getColor();
                this.mCurrentSize = this.mCurrentPaint.getStrokeWidth();
                this.mCurrentSize = getApproximate(this.mCurrentSize, (java.lang.Float[]) this.mViews.keySet().toArray(new java.lang.Float[this.mViews.keySet().size()]));
            }
        }
        if (this.mViews.get(java.lang.Float.valueOf(this.mCurrentSize)) != null) {
            this.mViews.get(java.lang.Float.valueOf(this.mCurrentSize)).setBackgroundDrawable(getCurrentCircle());
        }
        com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect paintSelect = this.mPaintSelect;
        if (paintSelect != null) {
            paintSelect.onColorSelect(this.mCurrentColor);
            this.mPaintSelect.onSizeSelect(this.mCurrentSize);
        }
        this.mListView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false));
        com.aliyun.svideo.editor.effects.paint.ColorAdapter colorAdapter = new com.aliyun.svideo.editor.effects.paint.ColorAdapter(getContext());
        this.mColorAdapter = colorAdapter;
        colorAdapter.setPaintSelect(new com.aliyun.svideo.editor.effects.paint.PaintChooserView.AnonymousClass1());
        this.mColorAdapter.setSelectedPos(this.mCurrentColor);
        this.mListView.setAdapter(this.mColorAdapter);
        this.mListView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onBackPressed() {
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.aliyun.svideo.editor.R.id.cancel) {
            com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
            if (onEffectActionLister != null) {
                onEffectActionLister.onCancel();
            }
        } else if (id == com.aliyun.svideo.editor.R.id.complete) {
            com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister2 = this.mOnEffectActionLister;
            if (onEffectActionLister2 != null) {
                onEffectActionLister2.onComplete();
            }
        } else {
            clearPaint();
            if (id == com.aliyun.svideo.editor.R.id.paint_one) {
                this.mCurrentSize = dip2px(getContext(), 5.0f);
            } else if (id == com.aliyun.svideo.editor.R.id.paint_two) {
                this.mCurrentSize = dip2px(getContext(), 10.0f);
            } else if (id == com.aliyun.svideo.editor.R.id.paint_three) {
                this.mCurrentSize = dip2px(getContext(), 15.0f);
            }
            if (this.mViews.get(java.lang.Float.valueOf(this.mCurrentSize)) != null) {
                this.mViews.get(java.lang.Float.valueOf(this.mCurrentSize)).setBackgroundDrawable(getCurrentCircle());
            }
            com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect paintSelect = this.mPaintSelect;
            if (paintSelect != null) {
                paintSelect.onSizeSelect(this.mCurrentSize);
            }
            this.mCurrentPaint.setStrokeWidth(this.mCurrentSize);
            this.mCurrentPaint.setColor(this.mCurrentColor);
            this.mEditorService.setPaint(this.mCurrentPaint);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setPaintSelectListener(com.aliyun.svideo.editor.effects.paint.PaintChooserView.PaintSelect paintSelect) {
        this.mPaintSelect = paintSelect;
    }
}
