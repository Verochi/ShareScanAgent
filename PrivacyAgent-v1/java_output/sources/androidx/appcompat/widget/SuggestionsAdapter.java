package androidx.appcompat.widget;

/* loaded from: classes.dex */
class SuggestionsAdapter extends androidx.cursoradapter.widget.ResourceCursorAdapter implements android.view.View.OnClickListener {
    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final java.lang.String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable.ConstantState> mOutsideDrawablesCache;
    private final android.content.Context mProviderContext;
    private int mQueryRefinement;
    private final androidx.appcompat.widget.SearchView mSearchView;
    private final android.app.SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private android.content.res.ColorStateList mUrlColor;

    public static final class ChildViewCache {
        public final android.widget.ImageView mIcon1;
        public final android.widget.ImageView mIcon2;
        public final android.widget.ImageView mIconRefine;
        public final android.widget.TextView mText1;
        public final android.widget.TextView mText2;

        public ChildViewCache(android.view.View view) {
            this.mText1 = (android.widget.TextView) view.findViewById(android.R.id.text1);
            this.mText2 = (android.widget.TextView) view.findViewById(android.R.id.text2);
            this.mIcon1 = (android.widget.ImageView) view.findViewById(android.R.id.icon1);
            this.mIcon2 = (android.widget.ImageView) view.findViewById(android.R.id.icon2);
            this.mIconRefine = (android.widget.ImageView) view.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public SuggestionsAdapter(android.content.Context context, androidx.appcompat.widget.SearchView searchView, android.app.SearchableInfo searchableInfo, java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (android.database.Cursor) null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    private android.graphics.drawable.Drawable checkIconCache(java.lang.String str) {
        android.graphics.drawable.Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private java.lang.CharSequence formatUrl(java.lang.CharSequence charSequence) {
        if (this.mUrlColor == null) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            this.mProviderContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, typedValue, true);
            this.mUrlColor = this.mProviderContext.getResources().getColorStateList(typedValue.resourceId);
        }
        android.text.SpannableString spannableString = new android.text.SpannableString(charSequence);
        spannableString.setSpan(new android.text.style.TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private android.graphics.drawable.Drawable getActivityIcon(android.content.ComponentName componentName) {
        android.content.pm.PackageManager packageManager = this.mProviderContext.getPackageManager();
        try {
            android.content.pm.ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            android.graphics.drawable.Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Invalid icon resource ");
            sb.append(iconResource);
            sb.append(" for ");
            sb.append(componentName.flattenToShortString());
            return null;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.toString();
            return null;
        }
    }

    private android.graphics.drawable.Drawable getActivityIconWithCache(android.content.ComponentName componentName) {
        java.lang.String flattenToShortString = componentName.flattenToShortString();
        if (!this.mOutsideDrawablesCache.containsKey(flattenToShortString)) {
            android.graphics.drawable.Drawable activityIcon = getActivityIcon(componentName);
            this.mOutsideDrawablesCache.put(flattenToShortString, activityIcon != null ? activityIcon.getConstantState() : null);
            return activityIcon;
        }
        android.graphics.drawable.Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.mProviderContext.getResources());
    }

    public static java.lang.String getColumnString(android.database.Cursor cursor, java.lang.String str) {
        return getStringOrNull(cursor, cursor.getColumnIndex(str));
    }

    private android.graphics.drawable.Drawable getDefaultIcon1() {
        android.graphics.drawable.Drawable activityIconWithCache = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        return activityIconWithCache != null ? activityIconWithCache : this.mProviderContext.getPackageManager().getDefaultActivityIcon();
    }

    private android.graphics.drawable.Drawable getDrawable(android.net.Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return getDrawableFromResourceUri(uri);
                } catch (android.content.res.Resources.NotFoundException unused) {
                    throw new java.io.FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            java.io.InputStream openInputStream = this.mProviderContext.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new java.io.FileNotFoundException("Failed to open " + uri);
            }
            try {
                return android.graphics.drawable.Drawable.createFromStream(openInputStream, null);
            } finally {
                try {
                    openInputStream.close();
                } catch (java.io.IOException unused2) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Error closing icon stream for ");
                    sb.append(uri);
                }
            }
        } catch (java.io.FileNotFoundException e) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Icon not found: ");
            sb2.append(uri);
            sb2.append(", ");
            sb2.append(e.getMessage());
            return null;
        }
        java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
        sb22.append("Icon not found: ");
        sb22.append(uri);
        sb22.append(", ");
        sb22.append(e.getMessage());
        return null;
    }

    private android.graphics.drawable.Drawable getDrawableFromResourceValue(java.lang.String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = java.lang.Integer.parseInt(str);
            java.lang.String str2 = "android.resource://" + this.mProviderContext.getPackageName() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + parseInt;
            android.graphics.drawable.Drawable checkIconCache = checkIconCache(str2);
            if (checkIconCache != null) {
                return checkIconCache;
            }
            android.graphics.drawable.Drawable drawable = androidx.core.content.ContextCompat.getDrawable(this.mProviderContext, parseInt);
            storeInIconCache(str2, drawable);
            return drawable;
        } catch (android.content.res.Resources.NotFoundException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Icon resource not found: ");
            sb.append(str);
            return null;
        } catch (java.lang.NumberFormatException unused2) {
            android.graphics.drawable.Drawable checkIconCache2 = checkIconCache(str);
            if (checkIconCache2 != null) {
                return checkIconCache2;
            }
            android.graphics.drawable.Drawable drawable2 = getDrawable(android.net.Uri.parse(str));
            storeInIconCache(str, drawable2);
            return drawable2;
        }
    }

    private android.graphics.drawable.Drawable getIcon1(android.database.Cursor cursor) {
        int i = this.mIconName1Col;
        if (i == -1) {
            return null;
        }
        android.graphics.drawable.Drawable drawableFromResourceValue = getDrawableFromResourceValue(cursor.getString(i));
        return drawableFromResourceValue != null ? drawableFromResourceValue : getDefaultIcon1();
    }

    private android.graphics.drawable.Drawable getIcon2(android.database.Cursor cursor) {
        int i = this.mIconName2Col;
        if (i == -1) {
            return null;
        }
        return getDrawableFromResourceValue(cursor.getString(i));
    }

    private static java.lang.String getStringOrNull(android.database.Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private void setViewDrawable(android.widget.ImageView imageView, android.graphics.drawable.Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void setViewText(android.widget.TextView textView, java.lang.CharSequence charSequence) {
        textView.setText(charSequence);
        if (android.text.TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void storeInIconCache(java.lang.String str, android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            this.mOutsideDrawablesCache.put(str, drawable.getConstantState());
        }
    }

    private void updateSpinnerState(android.database.Cursor cursor) {
        android.os.Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(android.view.View view, android.content.Context context, android.database.Cursor cursor) {
        androidx.appcompat.widget.SuggestionsAdapter.ChildViewCache childViewCache = (androidx.appcompat.widget.SuggestionsAdapter.ChildViewCache) view.getTag();
        int i = this.mFlagsCol;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (childViewCache.mText1 != null) {
            setViewText(childViewCache.mText1, getStringOrNull(cursor, this.mText1Col));
        }
        if (childViewCache.mText2 != null) {
            java.lang.String stringOrNull = getStringOrNull(cursor, this.mText2UrlCol);
            java.lang.CharSequence formatUrl = stringOrNull != null ? formatUrl(stringOrNull) : getStringOrNull(cursor, this.mText2Col);
            if (android.text.TextUtils.isEmpty(formatUrl)) {
                android.widget.TextView textView = childViewCache.mText1;
                if (textView != null) {
                    textView.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            } else {
                android.widget.TextView textView2 = childViewCache.mText1;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    childViewCache.mText1.setMaxLines(1);
                }
            }
            setViewText(childViewCache.mText2, formatUrl);
        }
        android.widget.ImageView imageView = childViewCache.mIcon1;
        if (imageView != null) {
            setViewDrawable(imageView, getIcon1(cursor), 4);
        }
        android.widget.ImageView imageView2 = childViewCache.mIcon2;
        if (imageView2 != null) {
            setViewDrawable(imageView2, getIcon2(cursor), 8);
        }
        int i3 = this.mQueryRefinement;
        if (i3 != 2 && (i3 != 1 || (i2 & 1) == 0)) {
            childViewCache.mIconRefine.setVisibility(8);
            return;
        }
        childViewCache.mIconRefine.setVisibility(0);
        childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
        childViewCache.mIconRefine.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(android.database.Cursor cursor) {
        if (this.mClosed) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.mText1Col = cursor.getColumnIndex("suggest_text_1");
                this.mText2Col = cursor.getColumnIndex("suggest_text_2");
                this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void close() {
        changeCursor(null);
        this.mClosed = true;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public java.lang.CharSequence convertToString(android.database.Cursor cursor) {
        java.lang.String columnString;
        java.lang.String columnString2;
        if (cursor == null) {
            return null;
        }
        java.lang.String columnString3 = getColumnString(cursor, "suggest_intent_query");
        if (columnString3 != null) {
            return columnString3;
        }
        if (this.mSearchable.shouldRewriteQueryFromData() && (columnString2 = getColumnString(cursor, "suggest_intent_data")) != null) {
            return columnString2;
        }
        if (!this.mSearchable.shouldRewriteQueryFromText() || (columnString = getColumnString(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return columnString;
    }

    public android.graphics.drawable.Drawable getDrawableFromResourceUri(android.net.Uri uri) throws java.io.FileNotFoundException {
        int parseInt;
        java.lang.String authority = uri.getAuthority();
        if (android.text.TextUtils.isEmpty(authority)) {
            throw new java.io.FileNotFoundException("No authority: " + uri);
        }
        try {
            android.content.res.Resources resourcesForApplication = this.mProviderContext.getPackageManager().getResourcesForApplication(authority);
            java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new java.io.FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = java.lang.Integer.parseInt(pathSegments.get(0));
                } catch (java.lang.NumberFormatException unused) {
                    throw new java.io.FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new java.io.FileNotFoundException("More than two path segments: " + uri);
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new java.io.FileNotFoundException("No resource found for: " + uri);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
            throw new java.io.FileNotFoundException("No package found for authority: " + uri);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public android.view.View getDropDownView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (java.lang.RuntimeException e) {
            android.view.View newDropDownView = newDropDownView(this.mProviderContext, getCursor(), viewGroup);
            if (newDropDownView != null) {
                ((androidx.appcompat.widget.SuggestionsAdapter.ChildViewCache) newDropDownView.getTag()).mText1.setText(e.toString());
            }
            return newDropDownView;
        }
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    public android.database.Cursor getSearchManagerSuggestions(android.app.SearchableInfo searchableInfo, java.lang.String str, int i) {
        java.lang.String suggestAuthority;
        java.lang.String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        android.net.Uri.Builder fragment = new android.net.Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        java.lang.String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        java.lang.String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new java.lang.String[]{str};
        } else {
            fragment.appendPath(str);
        }
        java.lang.String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", java.lang.String.valueOf(i));
        }
        return this.mProviderContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (java.lang.RuntimeException e) {
            android.view.View newView = newView(this.mProviderContext, getCursor(), viewGroup);
            if (newView != null) {
                ((androidx.appcompat.widget.SuggestionsAdapter.ChildViewCache) newView.getTag()).mText1.setText(e.toString());
            }
            return newView;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public android.view.View newView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
        android.view.View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new androidx.appcompat.widget.SuggestionsAdapter.ChildViewCache(newView));
        ((android.widget.ImageView) newView.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        java.lang.Object tag = view.getTag();
        if (tag instanceof java.lang.CharSequence) {
            this.mSearchView.onQueryRefine((java.lang.CharSequence) tag);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public android.database.Cursor runQueryOnBackgroundThread(java.lang.CharSequence charSequence) {
        java.lang.String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.mSearchView.getVisibility() == 0 && this.mSearchView.getWindowVisibility() == 0) {
            try {
                android.database.Cursor searchManagerSuggestions = getSearchManagerSuggestions(this.mSearchable, charSequence2, 50);
                if (searchManagerSuggestions != null) {
                    searchManagerSuggestions.getCount();
                    return searchManagerSuggestions;
                }
            } catch (java.lang.RuntimeException unused) {
            }
        }
        return null;
    }

    public void setQueryRefinement(int i) {
        this.mQueryRefinement = i;
    }
}
