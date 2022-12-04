import java.util.ArrayList;

/**
 * The class is responsible to build the MorseCodeTree,
 * which on the other hand, will be translated into English
 * @author Jusu Dukuly
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    private TreeNode<String> root;

    /**
     * The constructor to implement data from the buildTree method
     * @param - calls the buildTree method
     */
    public MorseCodeTree() {
        buildTree();
    }
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }
   
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                root.left = new TreeNode<>(letter);
            } else if (code.equals("-")) {
                root.right = new TreeNode<>(letter);
            }
        } else {
            if (code.charAt(0) == '.') {
                addNode(root.left, code.substring(1), letter);
            } else if (code.charAt(0) == '-') {
                addNode(root.right, code.substring(1), letter);
            }
        }
    }

    @Override
    public void buildTree() {
        root = new TreeNode<>("");

        insert("." , "e");
        insert("-" , "t");

        insert(".." , "i");
        insert(".-" , "a");
        insert("-." , "n");
        insert("--" , "m");

        insert("..." , "s");
        insert("..-" , "u");
        insert(".-." , "r");
        insert(".--" , "w");
        insert("-.." , "d");
        insert("-.-" , "k");
        insert("--." , "g");
        insert("---" , "o");

        insert("...." , "h");
        insert("...-" , "v");
        insert("..-." , "f");
        insert(".-.." , "l");
        insert(".--." , "p");
        insert(".---" , "j");
        insert("-..." , "b");
        insert("-..-" , "x");
        insert("-.-." , "c");
        insert("-.--" , "y");
        insert("--.." , "z");
        insert("--.-" , "q");
    }

    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        String letter = "";
        if (code.length() == 1) {
            if (code.equals(".")) {
                letter = root.left.data;
            } else if (code.equals("-")) {
                letter = root.right.data;
            }
        } else {
            if (!code.isEmpty()) {
                if (code.charAt(0) == '.') {
                    letter = fetchNode(root.left, code.substring(1));
                } else if (!code.isEmpty() && code.charAt(0) == '-') {
                    letter = fetchNode(root.right, code.substring(1));
                }
            }
        }
        return letter;
    }
    @Override
    public void insert(String code, String letter) {
        addNode(root, code, letter);
        return;
    }

    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (!(root == null)) {
            LNRoutputTraversal(root.left, list);
            list.add(root.data);
            LNRoutputTraversal(root.right, list);
        }
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = new TreeNode<>(newNode);
    }

    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> treeList = new ArrayList<>();
        LNRoutputTraversal(root, treeList);
        return treeList;
    }

    @Override
    public MorseCodeTree update() {
        throw new UnsupportedOperationException("It is not supported");
    }

    @Override
    public MorseCodeTree delete(String data) {
        throw new UnsupportedOperationException("It is not supported");
    }
}