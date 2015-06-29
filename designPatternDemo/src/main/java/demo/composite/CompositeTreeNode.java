package demo.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by kouyang on 6/4/2015.
 */
public class CompositeTreeNode {
    private String name;
    private CompositeTreeNode parent;
    private Vector<CompositeTreeNode> children = new Vector<CompositeTreeNode>();

    public CompositeTreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompositeTreeNode getParent() {
        return parent;
    }

    public void setParent(CompositeTreeNode parent) {
        this.parent = parent;
    }

    public void add(CompositeTreeNode node) {
        children.add(node);
    }

    public void remove(CompositeTreeNode node) {
        children.remove(node);
    }

    public Enumeration<CompositeTreeNode> getChildren() {
        return children.elements();
    }
}
