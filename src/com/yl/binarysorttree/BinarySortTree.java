package com.yl.binarysorttree;


/**
 * @author candk
 * @Description
 * @date 3/25/21 - 11:29 AM
 */
public class BinarySortTree {

    private Node root;

    public BinarySortTree() {
    }

    public BinarySortTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 当子树不平衡时会触发root结点的旋转
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树");
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    public boolean removeNode(int value) {
        if (root == null) {
            return false;
        }

        Node targetNode = search(value);
        if (targetNode == null) {
            System.out.println("找不到结点！");
            return false;
        }

        //如果二叉树只有一个根结点
        if (root.left == null && root.right == null) {
            root = null;
            return true;
        }

        Node parent = searchParent(value);

        //如果要删除结点为叶子结点
        if (targetNode.left == null && targetNode.right == null) {
            if (targetNode == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;
        }

        //一个子树的情况
        if (targetNode.left != null && targetNode.right == null) {
            if (parent != null) {
                if (targetNode == parent.left) {
                    parent.left = targetNode.left;
                } else {
                    parent.right = targetNode.left;
                }
            } else {
                root = targetNode.left;
            }
            return true;
        }

        if (targetNode.left == null) {
            if (parent != null) {
                if (targetNode == parent.left) {
                    parent.left = targetNode.right;
                } else {
                    parent.right = targetNode.right;
                }
            } else {
                root = targetNode.right;
            }
            return true;
        }

        //两个子树情况
        Node targetSubTreeMinNode = targetNode.right.subTreeMinValue();
        int minValue = targetSubTreeMinNode.value;
        removeNode(targetSubTreeMinNode.value);
        targetNode.value = minValue;
        return true;

    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new Node(i));
        }

        bst.removeNode(10);

        bst.infixOrder();
    }
}