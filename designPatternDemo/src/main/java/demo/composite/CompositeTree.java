package demo.composite;

/**
 * Created by kouyang on 6/4/2015.
 */
public class CompositeTree {
    CompositeTreeNode root;

    public CompositeTree(String name) {
        this.root = new CompositeTreeNode(name);
    }

    public CompositeTreeNode getRoot() {
        return root;
    }
}
