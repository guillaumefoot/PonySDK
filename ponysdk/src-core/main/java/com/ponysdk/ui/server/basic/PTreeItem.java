
package com.ponysdk.ui.server.basic;

import java.util.ArrayList;
import java.util.List;

import com.ponysdk.core.instruction.Add;
import com.ponysdk.core.instruction.Remove;
import com.ponysdk.core.instruction.Update;
import com.ponysdk.ui.terminal.Dictionnary.PROPERTY;
import com.ponysdk.ui.terminal.WidgetType;

/**
 * An item that can be contained within a {@link PTree}. Each tree item is assigned a unique DOM id in order
 * to support ARIA.
 * <p>
 * <h3>Example</h3> {@example http://ponysdk.com/sample/#Tree}
 * </p>
 */
public class PTreeItem extends PObject {

    private PTree tree;

    private boolean isRoot = false;

    private String html;

    private final List<PTreeItem> children = new ArrayList<PTreeItem>();

    private boolean selected;

    private boolean open;

    private PWidget widget;

    PTreeItem(final boolean isRoot) {
        this.isRoot = isRoot;
        create.put(PROPERTY.ROOT, isRoot);
    }

    public PTreeItem() {
        this(false);
    }

    public PTreeItem(final String html) {
        this();
        this.html = html;
        create.put(PROPERTY.TEXT, html);
    }

    public PTreeItem(final PWidget widget) {
        this();
        this.widget = widget;
    }

    private void setWidget() {
        if (widget == null) return;

        if (widget.getParent() != null) {
            widget.removeFromParent();
        }

        if (tree != null) {
            tree.orphan(widget);
            final Remove remove = new Remove(widget.getID(), tree.getID());
            widget.getUIContext().stackInstruction(remove);
        }

        if (tree != null) {
            tree.adopt(widget, this);
            final Add add = new Add(widget.getID(), getID());
            add.put(PROPERTY.WIDGET, true);
            widget.getUIContext().stackInstruction(add);
        }
    }

    @Override
    protected WidgetType getWidgetType() {
        return WidgetType.TREE_ITEM;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public String getHtml() {
        return html;
    }

    public void setHTML(final String html) {
        this.html = html;
        final Update update = new Update(ID);
        update.put(PROPERTY.TEXT, html);
        getUIContext().stackInstruction(update);
    }

    final void setTree(final PTree tree) {
        this.tree = tree;
        if (isRoot) {
            final Add add = new Add(tree.getID(), getID());
            add.put(PROPERTY.ROOT, true);
            getUIContext().stackInstruction(add);
        }
        setWidget();
    }

    public PTree getTree() {
        return tree;
    }

    public int getChildCount() {
        return children.size();
    }

    public PTreeItem insertItem(final int beforeIndex, final PTreeItem item) {
        children.add(beforeIndex, item);
        item.setTree(tree);
        final Add add = new Add(item.getID(), getID());
        add.put(PROPERTY.INDEX, beforeIndex);
        getUIContext().stackInstruction(add);
        return item;
    }

    public PTreeItem addItem(final PTreeItem item) {
        return insertItem(getChildCount(), item);
    }

    public PTreeItem addItem(final String itemHtml) {
        return addItem(new PTreeItem(itemHtml));
    }

    public boolean removeItem(final PTreeItem item) {
        final Remove add = new Remove(tree.getID(), getID());
        getUIContext().stackInstruction(add);
        return children.remove(item);
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
        final Update update = new Update(ID);
        update.put(PROPERTY.SELECTED, selected);
        getUIContext().stackInstruction(update);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setState(final boolean open) {
        this.open = open;
        final Update update = new Update(ID);
        update.put(PROPERTY.STATE, open);
        getUIContext().stackInstruction(update);
    }

    public boolean getState() {
        return open;
    }

    public PTreeItem getChild(final int index) {
        return children.get(index);
    }

    public PWidget getWidget() {
        return widget;
    }

}