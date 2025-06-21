package androidx.fragment.app;

/* loaded from: classes.dex */
public class ListFragment extends androidx.fragment.app.Fragment {
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    android.widget.ListAdapter mAdapter;
    java.lang.CharSequence mEmptyText;
    android.view.View mEmptyView;
    android.widget.ListView mList;
    android.view.View mListContainer;
    boolean mListShown;
    android.view.View mProgressContainer;
    android.widget.TextView mStandardEmptyView;
    private final android.os.Handler mHandler = new android.os.Handler();
    private final java.lang.Runnable mRequestFocus = new androidx.fragment.app.ListFragment.AnonymousClass1();
    private final android.widget.AdapterView.OnItemClickListener mOnClickListener = new androidx.fragment.app.ListFragment.AnonymousClass2();

    /* renamed from: androidx.fragment.app.ListFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.widget.ListView listView = androidx.fragment.app.ListFragment.this.mList;
            listView.focusableViewAvailable(listView);
        }
    }

    /* renamed from: androidx.fragment.app.ListFragment$2, reason: invalid class name */
    public class AnonymousClass2 implements android.widget.AdapterView.OnItemClickListener {
        public AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            androidx.fragment.app.ListFragment.this.onListItemClick((android.widget.ListView) adapterView, view, i, j);
        }
    }

    private void ensureList() {
        if (this.mList != null) {
            return;
        }
        android.view.View view = getView();
        if (view == null) {
            throw new java.lang.IllegalStateException("Content view not yet created");
        }
        if (view instanceof android.widget.ListView) {
            this.mList = (android.widget.ListView) view;
        } else {
            android.widget.TextView textView = (android.widget.TextView) view.findViewById(INTERNAL_EMPTY_ID);
            this.mStandardEmptyView = textView;
            if (textView == null) {
                this.mEmptyView = view.findViewById(android.R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.mProgressContainer = view.findViewById(INTERNAL_PROGRESS_CONTAINER_ID);
            this.mListContainer = view.findViewById(INTERNAL_LIST_CONTAINER_ID);
            android.view.View findViewById = view.findViewById(android.R.id.list);
            if (!(findViewById instanceof android.widget.ListView)) {
                if (findViewById != null) {
                    throw new java.lang.RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new java.lang.RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            android.widget.ListView listView = (android.widget.ListView) findViewById;
            this.mList = listView;
            android.view.View view2 = this.mEmptyView;
            if (view2 != null) {
                listView.setEmptyView(view2);
            } else {
                java.lang.CharSequence charSequence = this.mEmptyText;
                if (charSequence != null) {
                    this.mStandardEmptyView.setText(charSequence);
                    this.mList.setEmptyView(this.mStandardEmptyView);
                }
            }
        }
        this.mListShown = true;
        this.mList.setOnItemClickListener(this.mOnClickListener);
        android.widget.ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            this.mAdapter = null;
            setListAdapter(listAdapter);
        } else if (this.mProgressContainer != null) {
            setListShown(false, false);
        }
        this.mHandler.post(this.mRequestFocus);
    }

    private void setListShown(boolean z, boolean z2) {
        ensureList();
        android.view.View view = this.mProgressContainer;
        if (view == null) {
            throw new java.lang.IllegalStateException("Can't be used with a custom content view");
        }
        if (this.mListShown == z) {
            return;
        }
        this.mListShown = z;
        if (z) {
            if (z2) {
                view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_out));
                this.mListContainer.startAnimation(android.view.animation.AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.mListContainer.clearAnimation();
            }
            this.mProgressContainer.setVisibility(8);
            this.mListContainer.setVisibility(0);
            return;
        }
        if (z2) {
            view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_in));
            this.mListContainer.startAnimation(android.view.animation.AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.mListContainer.clearAnimation();
        }
        this.mProgressContainer.setVisibility(0);
        this.mListContainer.setVisibility(8);
    }

    @androidx.annotation.Nullable
    public android.widget.ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    @androidx.annotation.NonNull
    public android.widget.ListView getListView() {
        ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        ensureList();
        return this.mList.getSelectedItemPosition();
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.Nullable
    public android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.content.Context requireContext = requireContext();
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(requireContext);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(requireContext);
        linearLayout.setId(INTERNAL_PROGRESS_CONTAINER_ID);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new android.widget.ProgressBar(requireContext, null, android.R.attr.progressBarStyleLarge), new android.widget.FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
        android.widget.FrameLayout frameLayout2 = new android.widget.FrameLayout(requireContext);
        frameLayout2.setId(INTERNAL_LIST_CONTAINER_ID);
        android.widget.TextView textView = new android.widget.TextView(requireContext);
        textView.setId(INTERNAL_EMPTY_ID);
        textView.setGravity(17);
        frameLayout2.addView(textView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        android.widget.ListView listView = new android.widget.ListView(requireContext);
        listView.setId(android.R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new android.widget.FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(@androidx.annotation.NonNull android.widget.ListView listView, @androidx.annotation.NonNull android.view.View view, int i, long j) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        ensureList();
    }

    @androidx.annotation.NonNull
    public final android.widget.ListAdapter requireListAdapter() {
        android.widget.ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new java.lang.IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        ensureList();
        android.widget.TextView textView = this.mStandardEmptyView;
        if (textView == null) {
            throw new java.lang.IllegalStateException("Can't be used with a custom content view");
        }
        textView.setText(charSequence);
        if (this.mEmptyText == null) {
            this.mList.setEmptyView(this.mStandardEmptyView);
        }
        this.mEmptyText = charSequence;
    }

    public void setListAdapter(@androidx.annotation.Nullable android.widget.ListAdapter listAdapter) {
        boolean z = this.mAdapter != null;
        this.mAdapter = listAdapter;
        android.widget.ListView listView = this.mList;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.mListShown || z) {
                return;
            }
            setListShown(true, requireView().getWindowToken() != null);
        }
    }

    public void setListShown(boolean z) {
        setListShown(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        setListShown(z, false);
    }

    public void setSelection(int i) {
        ensureList();
        this.mList.setSelection(i);
    }
}
