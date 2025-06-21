package com.aliyun.svideo.common.baseAdapter;

/* loaded from: classes.dex */
public class BaseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter adapter;
    private java.lang.Object associatedObject;
    private final java.util.LinkedHashSet<java.lang.Integer> childClickViewIds;
    private final java.util.LinkedHashSet<java.lang.Integer> itemChildLongClickViewIds;
    private final java.util.HashSet<java.lang.Integer> nestViews;
    private final android.util.SparseArray<android.view.View> views;

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.common.baseAdapter.BaseViewHolder.this.adapter.getOnItemChildClickListener() != null) {
                com.aliyun.svideo.common.baseAdapter.BaseViewHolder.this.adapter.getOnItemChildClickListener().onItemChildClick(com.aliyun.svideo.common.baseAdapter.BaseViewHolder.this.adapter, view, com.aliyun.svideo.common.baseAdapter.BaseViewHolder.this.getClickPosition());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseViewHolder$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnLongClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(android.view.View view) {
            return com.aliyun.svideo.common.baseAdapter.BaseViewHolder.this.adapter.getOnItemChildLongClickListener() != null && com.aliyun.svideo.common.baseAdapter.BaseViewHolder.this.adapter.getOnItemChildLongClickListener().onItemChildLongClick(com.aliyun.svideo.common.baseAdapter.BaseViewHolder.this.adapter, view, com.aliyun.svideo.common.baseAdapter.BaseViewHolder.this.getClickPosition());
        }
    }

    public BaseViewHolder(android.view.View view) {
        super(view);
        this.views = new android.util.SparseArray<>();
        this.childClickViewIds = new java.util.LinkedHashSet<>();
        this.itemChildLongClickViewIds = new java.util.LinkedHashSet<>();
        this.nestViews = new java.util.HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getClickPosition() {
        if (getLayoutPosition() >= this.adapter.getHeaderLayoutCount()) {
            return getLayoutPosition() - this.adapter.getHeaderLayoutCount();
        }
        return 0;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder addOnClickListener(@androidx.annotation.IdRes int... iArr) {
        for (int i : iArr) {
            this.childClickViewIds.add(java.lang.Integer.valueOf(i));
            android.view.View view = getView(i);
            if (view != null) {
                if (!view.isClickable()) {
                    view.setClickable(true);
                }
                view.setOnClickListener(new com.aliyun.svideo.common.baseAdapter.BaseViewHolder.AnonymousClass1());
            }
        }
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder addOnLongClickListener(@androidx.annotation.IdRes int... iArr) {
        for (int i : iArr) {
            this.itemChildLongClickViewIds.add(java.lang.Integer.valueOf(i));
            android.view.View view = getView(i);
            if (view != null) {
                if (!view.isLongClickable()) {
                    view.setLongClickable(true);
                }
                view.setOnLongClickListener(new com.aliyun.svideo.common.baseAdapter.BaseViewHolder.AnonymousClass2());
            }
        }
        return this;
    }

    public java.lang.Object getAssociatedObject() {
        return this.associatedObject;
    }

    public java.util.HashSet<java.lang.Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    public java.util.HashSet<java.lang.Integer> getItemChildLongClickViewIds() {
        return this.itemChildLongClickViewIds;
    }

    public java.util.Set<java.lang.Integer> getNestViews() {
        return this.nestViews;
    }

    public <T extends android.view.View> T getView(@androidx.annotation.IdRes int i) {
        T t = (T) this.views.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i);
        this.views.put(i, t2);
        return t2;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder linkify(@androidx.annotation.IdRes int i) {
        android.text.util.Linkify.addLinks((android.widget.TextView) getView(i), 15);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setAdapter(@androidx.annotation.IdRes int i, android.widget.Adapter adapter) {
        ((android.widget.AdapterView) getView(i)).setAdapter(adapter);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setAdapter(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter baseQuickAdapter) {
        this.adapter = baseQuickAdapter;
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setAlpha(@androidx.annotation.IdRes int i, float f) {
        getView(i).setAlpha(f);
        return this;
    }

    public void setAssociatedObject(java.lang.Object obj) {
        this.associatedObject = obj;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setBackgroundColor(@androidx.annotation.IdRes int i, @androidx.annotation.ColorInt int i2) {
        getView(i).setBackgroundColor(i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setBackgroundRes(@androidx.annotation.IdRes int i, @androidx.annotation.DrawableRes int i2) {
        getView(i).setBackgroundResource(i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setChecked(@androidx.annotation.IdRes int i, boolean z) {
        android.view.KeyEvent.Callback view = getView(i);
        if (view instanceof android.widget.Checkable) {
            ((android.widget.Checkable) view).setChecked(z);
        }
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setEnabled(@androidx.annotation.IdRes int i, boolean z) {
        getView(i).setEnabled(z);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setGone(@androidx.annotation.IdRes int i, boolean z) {
        getView(i).setVisibility(z ? 0 : 8);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setImageBitmap(@androidx.annotation.IdRes int i, android.graphics.Bitmap bitmap) {
        ((android.widget.ImageView) getView(i)).setImageBitmap(bitmap);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setImageDrawable(@androidx.annotation.IdRes int i, android.graphics.drawable.Drawable drawable) {
        ((android.widget.ImageView) getView(i)).setImageDrawable(drawable);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setImageResource(@androidx.annotation.IdRes int i, @androidx.annotation.DrawableRes int i2) {
        ((android.widget.ImageView) getView(i)).setImageResource(i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setMax(@androidx.annotation.IdRes int i, int i2) {
        ((android.widget.ProgressBar) getView(i)).setMax(i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setNestView(@androidx.annotation.IdRes int... iArr) {
        for (int i : iArr) {
            this.nestViews.add(java.lang.Integer.valueOf(i));
        }
        addOnClickListener(iArr);
        addOnLongClickListener(iArr);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setOnCheckedChangeListener(@androidx.annotation.IdRes int i, android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ((android.widget.CompoundButton) getView(i)).setOnCheckedChangeListener(onCheckedChangeListener);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setOnItemLongClickListener(@androidx.annotation.IdRes int i, android.widget.AdapterView.OnItemLongClickListener onItemLongClickListener) {
        ((android.widget.AdapterView) getView(i)).setOnItemLongClickListener(onItemLongClickListener);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setOnItemSelectedClickListener(@androidx.annotation.IdRes int i, android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ((android.widget.AdapterView) getView(i)).setOnItemSelectedListener(onItemSelectedListener);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setProgress(@androidx.annotation.IdRes int i, int i2) {
        ((android.widget.ProgressBar) getView(i)).setProgress(i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setProgress(@androidx.annotation.IdRes int i, int i2, int i3) {
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) getView(i);
        progressBar.setMax(i3);
        progressBar.setProgress(i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setRating(@androidx.annotation.IdRes int i, float f) {
        ((android.widget.RatingBar) getView(i)).setRating(f);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setRating(@androidx.annotation.IdRes int i, float f, int i2) {
        android.widget.RatingBar ratingBar = (android.widget.RatingBar) getView(i);
        ratingBar.setMax(i2);
        ratingBar.setRating(f);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setTag(@androidx.annotation.IdRes int i, int i2, java.lang.Object obj) {
        getView(i).setTag(i2, obj);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setTag(@androidx.annotation.IdRes int i, java.lang.Object obj) {
        getView(i).setTag(obj);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setText(@androidx.annotation.IdRes int i, @androidx.annotation.StringRes int i2) {
        ((android.widget.TextView) getView(i)).setText(i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setText(@androidx.annotation.IdRes int i, java.lang.CharSequence charSequence) {
        ((android.widget.TextView) getView(i)).setText(charSequence);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setTextColor(@androidx.annotation.IdRes int i, @androidx.annotation.ColorInt int i2) {
        ((android.widget.TextView) getView(i)).setTextColor(i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setTypeface(@androidx.annotation.IdRes int i, android.graphics.Typeface typeface) {
        android.widget.TextView textView = (android.widget.TextView) getView(i);
        textView.setTypeface(typeface);
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setTypeface(android.graphics.Typeface typeface, int... iArr) {
        for (int i : iArr) {
            android.widget.TextView textView = (android.widget.TextView) getView(i);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.BaseViewHolder setVisible(@androidx.annotation.IdRes int i, boolean z) {
        getView(i).setVisibility(z ? 0 : 4);
        return this;
    }
}
