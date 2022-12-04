
 /**
 * The class represents each node in the MorseCodeTree
 * @author Jusu Dukuly
 * @param <T> parameterized class
 */
public class TreeNode<T> {
	/**
	 * Data fields
	 */
    protected TreeNode<T> left;
    protected T data;
    protected TreeNode<T> right;

    /**
     * Create a new TreeNode with left and right child 
     * set to null and data set to the dataNode
     * @param dataNode data to be set for node
     */
    public TreeNode(T dataNode) {
        data = dataNode;
        left=null;
        right=null;
    }

    /**
     * Constructor that makes a deep copy
     * @param node to deep copy from
     */
    public TreeNode(TreeNode<T> node) {
        left =node.left;
        data = node.data;
        right =node.right;
    }

    /**
     * Get data of current node
     * @return data of current node
     */
    public T getData() {
        return data;
    }
}