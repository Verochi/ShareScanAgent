package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public class TrackSelectionView extends android.widget.LinearLayout {
    public com.google.android.exoplayer2.ui.TrackNameProvider A;
    public android.widget.CheckedTextView[][] B;
    public com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo C;
    public int D;
    public com.google.android.exoplayer2.source.TrackGroupArray E;
    public boolean F;

    @androidx.annotation.Nullable
    public java.util.Comparator<com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo> G;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.TrackSelectionView.TrackSelectionListener H;
    public final int n;
    public final android.view.LayoutInflater t;
    public final android.widget.CheckedTextView u;
    public final android.widget.CheckedTextView v;
    public final com.google.android.exoplayer2.ui.TrackSelectionView.ComponentListener w;
    public final android.util.SparseArray<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> x;
    public boolean y;
    public boolean z;

    public class ComponentListener implements android.view.View.OnClickListener {
        public ComponentListener() {
        }

        public /* synthetic */ ComponentListener(com.google.android.exoplayer2.ui.TrackSelectionView trackSelectionView, com.google.android.exoplayer2.ui.TrackSelectionView.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.exoplayer2.ui.TrackSelectionView.this.onClick(view);
        }
    }

    public static final class TrackInfo {
        public final int a;
        public final int b;
        public final com.google.android.exoplayer2.Format c;

        public TrackInfo(int i, int i2, com.google.android.exoplayer2.Format format) {
            this.a = i;
            this.b = i2;
            this.c = format;
        }
    }

    public interface TrackSelectionListener {
        void onTrackSelectionChanged(boolean z, java.util.List<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> list);
    }

    public TrackSelectionView(android.content.Context context) {
        this(context, null);
    }

    public TrackSelectionView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        this.x = new android.util.SparseArray<>();
        setSaveFromParentEnabled(false);
        android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.n = resourceId;
        obtainStyledAttributes.recycle();
        android.view.LayoutInflater from = android.view.LayoutInflater.from(context);
        this.t = from;
        com.google.android.exoplayer2.ui.TrackSelectionView.ComponentListener componentListener = new com.google.android.exoplayer2.ui.TrackSelectionView.ComponentListener(this, null);
        this.w = componentListener;
        this.A = new com.google.android.exoplayer2.ui.DefaultTrackNameProvider(getResources());
        this.E = com.google.android.exoplayer2.source.TrackGroupArray.EMPTY;
        android.widget.CheckedTextView checkedTextView = (android.widget.CheckedTextView) from.inflate(android.R.layout.simple_list_item_single_choice, (android.view.ViewGroup) this, false);
        this.u = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(com.google.android.exoplayer2.ui.R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(componentListener);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(com.google.android.exoplayer2.ui.R.layout.exo_list_divider, (android.view.ViewGroup) this, false));
        android.widget.CheckedTextView checkedTextView2 = (android.widget.CheckedTextView) from.inflate(android.R.layout.simple_list_item_single_choice, (android.view.ViewGroup) this, false);
        this.v = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(com.google.android.exoplayer2.ui.R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(componentListener);
        addView(checkedTextView2);
    }

    public static int[] c(int[] iArr, int i) {
        int[] copyOf = java.util.Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i;
        return copyOf;
    }

    public static int[] d(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length - 1];
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 != i) {
                iArr2[i2] = i3;
                i2++;
            }
        }
        return iArr2;
    }

    public static /* synthetic */ int e(java.util.Comparator comparator, com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo trackInfo, com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo trackInfo2) {
        return comparator.compare(trackInfo.c, trackInfo2.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick(android.view.View view) {
        if (view == this.u) {
            g();
        } else if (view == this.v) {
            f();
        } else {
            h(view);
        }
        k();
        com.google.android.exoplayer2.ui.TrackSelectionView.TrackSelectionListener trackSelectionListener = this.H;
        if (trackSelectionListener != null) {
            trackSelectionListener.onTrackSelectionChanged(getIsDisabled(), getOverrides());
        }
    }

    public final void f() {
        this.F = false;
        this.x.clear();
    }

    public final void g() {
        this.F = true;
        this.x.clear();
    }

    public boolean getIsDisabled() {
        return this.F;
    }

    public java.util.List<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> getOverrides() {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.x.size());
        for (int i = 0; i < this.x.size(); i++) {
            arrayList.add(this.x.valueAt(i));
        }
        return arrayList;
    }

    public final void h(android.view.View view) {
        this.F = false;
        com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo trackInfo = (com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo) com.google.android.exoplayer2.util.Assertions.checkNotNull(view.getTag());
        int i = trackInfo.a;
        int i2 = trackInfo.b;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride = this.x.get(i);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.C);
        if (selectionOverride == null) {
            if (!this.z && this.x.size() > 0) {
                this.x.clear();
            }
            this.x.put(i, new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride(i, i2));
            return;
        }
        int i3 = selectionOverride.length;
        int[] iArr = selectionOverride.tracks;
        boolean isChecked = ((android.widget.CheckedTextView) view).isChecked();
        boolean i4 = i(i);
        boolean z = i4 || j();
        if (isChecked && z) {
            if (i3 == 1) {
                this.x.remove(i);
                return;
            } else {
                this.x.put(i, new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride(i, d(iArr, i2)));
                return;
            }
        }
        if (isChecked) {
            return;
        }
        if (i4) {
            this.x.put(i, new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride(i, c(iArr, i2)));
        } else {
            this.x.put(i, new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride(i, i2));
        }
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"mappedTrackInfo"})
    public final boolean i(int i) {
        return this.y && this.E.get(i).length > 1 && this.C.getAdaptiveSupport(this.D, i, false) != 0;
    }

    public void init(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int i, boolean z, java.util.List<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> list, @androidx.annotation.Nullable java.util.Comparator<com.google.android.exoplayer2.Format> comparator, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.TrackSelectionView.TrackSelectionListener trackSelectionListener) {
        this.C = mappedTrackInfo;
        this.D = i;
        this.F = z;
        this.G = comparator == null ? null : new com.google.android.exoplayer2.ui.v(comparator);
        this.H = trackSelectionListener;
        int size = this.z ? list.size() : java.lang.Math.min(list.size(), 1);
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride = list.get(i2);
            this.x.put(selectionOverride.groupIndex, selectionOverride);
        }
        l();
    }

    public final boolean j() {
        return this.z && this.E.length > 1;
    }

    public final void k() {
        this.u.setChecked(this.F);
        this.v.setChecked(!this.F && this.x.size() == 0);
        for (int i = 0; i < this.B.length; i++) {
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride = this.x.get(i);
            int i2 = 0;
            while (true) {
                android.widget.CheckedTextView[] checkedTextViewArr = this.B[i];
                if (i2 < checkedTextViewArr.length) {
                    if (selectionOverride != null) {
                        this.B[i][i2].setChecked(selectionOverride.containsTrack(((com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo) com.google.android.exoplayer2.util.Assertions.checkNotNull(checkedTextViewArr[i2].getTag())).b));
                    } else {
                        checkedTextViewArr[i2].setChecked(false);
                    }
                    i2++;
                }
            }
        }
    }

    public final void l() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.C == null) {
            this.u.setEnabled(false);
            this.v.setEnabled(false);
            return;
        }
        this.u.setEnabled(true);
        this.v.setEnabled(true);
        com.google.android.exoplayer2.source.TrackGroupArray trackGroups = this.C.getTrackGroups(this.D);
        this.E = trackGroups;
        this.B = new android.widget.CheckedTextView[trackGroups.length][];
        boolean j = j();
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray = this.E;
            if (i >= trackGroupArray.length) {
                k();
                return;
            }
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroupArray.get(i);
            boolean i2 = i(i);
            android.widget.CheckedTextView[][] checkedTextViewArr = this.B;
            int i3 = trackGroup.length;
            checkedTextViewArr[i] = new android.widget.CheckedTextView[i3];
            com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo[] trackInfoArr = new com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo[i3];
            for (int i4 = 0; i4 < trackGroup.length; i4++) {
                trackInfoArr[i4] = new com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo(i, i4, trackGroup.getFormat(i4));
            }
            java.util.Comparator<com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo> comparator = this.G;
            if (comparator != null) {
                java.util.Arrays.sort(trackInfoArr, comparator);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                if (i5 == 0) {
                    addView(this.t.inflate(com.google.android.exoplayer2.ui.R.layout.exo_list_divider, (android.view.ViewGroup) this, false));
                }
                android.widget.CheckedTextView checkedTextView = (android.widget.CheckedTextView) this.t.inflate((i2 || j) ? android.R.layout.simple_list_item_multiple_choice : android.R.layout.simple_list_item_single_choice, (android.view.ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.n);
                checkedTextView.setText(this.A.getTrackName(trackInfoArr[i5].c));
                if (this.C.getTrackSupport(this.D, i, i5) == 4) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setTag(trackInfoArr[i5]);
                    checkedTextView.setOnClickListener(this.w);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.B[i][i5] = checkedTextView;
                addView(checkedTextView);
            }
            i++;
        }
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.y != z) {
            this.y = z;
            l();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.z != z) {
            this.z = z;
            if (!z && this.x.size() > 1) {
                for (int size = this.x.size() - 1; size > 0; size--) {
                    this.x.remove(size);
                }
            }
            l();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.u.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(com.google.android.exoplayer2.ui.TrackNameProvider trackNameProvider) {
        this.A = (com.google.android.exoplayer2.ui.TrackNameProvider) com.google.android.exoplayer2.util.Assertions.checkNotNull(trackNameProvider);
        l();
    }
}
