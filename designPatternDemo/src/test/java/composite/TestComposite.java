package composite;

import demo.composite.CompositeTree;
import demo.composite.CompositeTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by kouyang on 6/4/2015.
 */
public class TestComposite {
    @Test
    public void testName() throws Exception {
        CompositeTree tree = new CompositeTree("A");
        CompositeTreeNode nodeB = new CompositeTreeNode("B");
        CompositeTreeNode nodeC = new CompositeTreeNode("C");
        nodeB.add(nodeC);
        tree.getRoot().add(nodeB);
        outputTree(tree.getRoot());
    }

    private void outputTree(CompositeTreeNode node) {
        if (node == null) return;
//        System.out.println(node.getName());
        Enumeration<CompositeTreeNode> enumeration = node.getChildren();
        List<CompositeTreeNode> subNodes = new ArrayList<CompositeTreeNode>();
        while (enumeration.hasMoreElements()) {
            CompositeTreeNode subNode = enumeration.nextElement();
            subNodes.add(subNode);
            System.out.println(subNode.getName());
        }
        for (CompositeTreeNode subNode : subNodes) {
            outputTree(subNode);
        }
    }
}
