package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public interface SelectorContainer {
    void add(org.apache.tools.ant.types.selectors.FileSelector fileSelector);

    void addAnd(org.apache.tools.ant.types.selectors.AndSelector andSelector);

    void addContains(org.apache.tools.ant.types.selectors.ContainsSelector containsSelector);

    void addContainsRegexp(org.apache.tools.ant.types.selectors.ContainsRegexpSelector containsRegexpSelector);

    void addCustom(org.apache.tools.ant.types.selectors.ExtendSelector extendSelector);

    void addDate(org.apache.tools.ant.types.selectors.DateSelector dateSelector);

    void addDepend(org.apache.tools.ant.types.selectors.DependSelector dependSelector);

    void addDepth(org.apache.tools.ant.types.selectors.DepthSelector depthSelector);

    void addDifferent(org.apache.tools.ant.types.selectors.DifferentSelector differentSelector);

    void addFilename(org.apache.tools.ant.types.selectors.FilenameSelector filenameSelector);

    void addMajority(org.apache.tools.ant.types.selectors.MajoritySelector majoritySelector);

    void addModified(org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector modifiedSelector);

    void addNone(org.apache.tools.ant.types.selectors.NoneSelector noneSelector);

    void addNot(org.apache.tools.ant.types.selectors.NotSelector notSelector);

    void addOr(org.apache.tools.ant.types.selectors.OrSelector orSelector);

    void addPresent(org.apache.tools.ant.types.selectors.PresentSelector presentSelector);

    void addSelector(org.apache.tools.ant.types.selectors.SelectSelector selectSelector);

    void addSize(org.apache.tools.ant.types.selectors.SizeSelector sizeSelector);

    void addType(org.apache.tools.ant.types.selectors.TypeSelector typeSelector);

    void appendSelector(org.apache.tools.ant.types.selectors.FileSelector fileSelector);

    org.apache.tools.ant.types.selectors.FileSelector[] getSelectors(org.apache.tools.ant.Project project);

    boolean hasSelectors();

    int selectorCount();

    java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements();
}
