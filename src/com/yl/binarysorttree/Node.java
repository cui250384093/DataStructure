package com.yl.binarysorttree;

/**
 * @author candk
 * @Description
 * @date 3/25/21 - 11:30 AM
 */
public class Node {

    int value;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }

        //递归添加
        if(node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        //当添加完一个结点后，如果右子树的高度-左子树的高度>1，坐旋转
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
            }
            leftRotate();
        } else if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
            }
            rightRotate();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value) {
        if (this.left != null && this.left.value == value) {
            return this;
        } else if (this.right != null && this.right.value == value) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if ((value >= this.value && this.right != null)){
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    /**
     * 当前结点为根结点的子树的最小值结点
     * @return
     */
    public Node subTreeMinValue() {
        if (this.left == null) {
            return this;
        } else {
            return this.left.subTreeMinValue();
        }
    }


    /**
     * 左子树的高度
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 右子树的高度
     * @return
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public int height() {
        return Math.max(left == null ? 0: left.height(), right == null? 0: right.height()) + 1;
    }

    /**
     * 平衡二叉树左旋
     * 1. 创建一个新的结点newNode，值等于当前结点的值 Node newNode = new Node(value)
     * 2. 把新结点的左子树设置为当前结点的左子树 newNode.left = left
     * 3. 把新结点的右子树设置为当前结点的右子树的左子树 newNode.right = right.left
     * 4. 把当前结点的值替换为右子结点的值 value = right.value
     * 5. 把当前结点的右子树设置为右子树的右子树 right = right.right
     * 6. 把当前结点的左子树设置为新结点 left = newNode
     *
     */
    public void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    /**
     *  平衡二叉树右旋
     *  1. 创建一个新的结点newNode，值等于当前结点的值 Node newNode = new Node(value)
     *  2. 将新结点右子树设置为当前结点的右子树 newNode.right = right
     *  3. 将新结点的左子树设置为当前结点的左子树的右子树 newNode.left = left.right
     *  4. 将当前结点的值替换为左子节点的值 value = left.value
     *  5. 将当前结点的左子树替换为左子树的左子树 left = left.left
     *  6. 将当前结点的右子树设置为新结点 right = newNode
     *
     */
    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
}
