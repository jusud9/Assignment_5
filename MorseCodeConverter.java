
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * The class is tasked to translate 
 * MorseCode from string or file into English
 * and print the MorseCodeTree.
 * @author Jusu Dukuly
 */
public class MorseCodeConverter {
  /**
   * creating a new MorseCodeTree
   */
    private static MorseCodeTree tree=new MorseCodeTree();

    /**
     * To convert MorseCodeTree to English
     * @param code to translate
     * @return code to convert to English
     */
    public static String convertToEnglish(String code) {
        String current = "";
        String[] variety = code.split("/");
        String[][] string = new String[variety.length][];

        for (int i = 0; i < string.length; i++) {
            string[i] = variety[i].split(" ");
        }
        for (int p = 0; p < string.length; p++) {
            for (int k = 0; k < string[p].length; k++) {
                string[p][k] = tree.fetch(string[p][k]);
                current += string[p][k];
            }
            current += (p == string.length - 1) ? "" : " ";
        }

        return current;
    }

    /**
     * The MorseCode will convert the string 
     * into English, from the file created
     * @param codeFile will be translated into English
     * @return codeFile converted in English
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        Scanner sc= new Scanner(codeFile);
        String type = "";
        while (sc.hasNextLine()) {
            type += sc.nextLine();
        }
        return convertToEnglish(type);
    }

    /**
     * To print the nodes in the tree
     * @return representation of string in the tree
     */
    public static String printTree() {
        String printedTree ="";
        for (String element : tree.toArrayList()) {
            printedTree += element + " ";
        }
        return printedTree;
    }

}	