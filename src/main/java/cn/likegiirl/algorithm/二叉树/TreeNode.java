package cn.likegiirl.algorithm.二叉树;


/**
 * 二叉树，Node结构
 */
public class TreeNode {

    /**
     * 父节点ID
     */
    private String parentId;

    /**
     * ID
     */
    private String id;

    /**
     * 值
     */
    private Object value;

    /**
     * 左节点
     */
    private TreeNode leftChildren;

    /**
     * 右节点
     */
    private TreeNode rightChildren;

    public TreeNode() {
        super();
    }

    public TreeNode(String id, Object value) {
        this.id = id;
        this.value = value;
    }

    public TreeNode(String parentId, String id, Object value) {
        this.parentId = parentId;
        this.id = id;
        this.value = value;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public TreeNode getLeftChildren() {
        return leftChildren;
    }

    public void setLeftChildren(TreeNode leftChildren) {
        this.leftChildren = leftChildren;
    }

    public TreeNode getRightChildren() {
        return rightChildren;
    }

    public void setRightChildren(TreeNode rightChildren) {
        this.rightChildren = rightChildren;
    }
}
