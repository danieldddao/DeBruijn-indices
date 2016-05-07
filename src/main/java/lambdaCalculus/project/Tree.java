package lambdaCalculus.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of a Tree:
 *    Each node has one String stored in the instance variable data.
 *    The instance variables left and right are the left and right children of the node.
 *
 * + Credit to michal.kreuzman (http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram) for tree printing.
 */
public class Tree<String>
{
   private String data;
   private Tree<String> left, right;

   public Tree(String initialData, Tree<String> initialLeft, Tree<String> initialRight)
   {
      data = initialData;
      left = initialLeft;
      right = initialRight;
   }       

   /**
   * Method to get the data from the root of tree.
   **/
   public String getData( )
   {
      return data;
   }

   /**
   * Method to get the left child of this tree.
   **/
   public Tree<String> getLeft( )
   {
      return left;                                               
   } 

   /**
    * Method to get the right child of this tree.
    **/
   public Tree<String> getRight( )
   {
      return right;                                               
   }

   /**
   * Method to set the left child of this tree.
   **/
   public void setLeft(Tree<String> newLeft)
   {                    
      left = newLeft;
   }
    
    
   /**
   * Method to set the right child of this tree.
   **/
   public void setRight(Tree<String> newRight)
   {                    
      right = newRight;
   }

    /**
     * Build the Lambda Tree based on the list of small sub-trees
     * If the node is an application, it will build "LEFT" sub-tree of the application first.
     * @param list: the list of small sub-trees.
     * @return
     *   the tree built based on the list of small sub-tree.
     **/
    public Tree<String> buildTreeFromLeft (List<Tree<String>> list) {
        Tree<String> tree = null;
        try {
            if (list.size() == 1) {
                tree = list.remove(0);
            } else if (list.get(0).getData().equals("λ")) {
                tree = list.remove(0);
                tree.setRight(buildTreeFromLeft(list));
            } else if (list.get(0).getData().equals("@")) {
                tree = list.remove(0);
                tree.setLeft(buildTreeFromLeft(list));
                tree.setRight(buildTreeFromLeft(list));
            } else {
                tree = list.remove(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tree;
    }

    /**
     * Build the Lambda Tree based on the list of smaller sub-trees
     * If the node is an application, it will build "RIGHT" sub-tree of the application first.
     * @param list: the list of small sub-trees.
     * @return
     *   the tree built based on the list of small sub-tree.
     **/
    public Tree<String> buildTreeFromRight (List<Tree<String>> list) {
        Tree<String> tree = null;
        try {
            if (list.size() == 1) {
                tree = list.remove(0);
            } else if (list.get(0).getData().equals("λ")) {
                tree = list.remove(0);
                tree.setRight(buildTreeFromRight(list));
            } else if (list.get(0).getData().equals("@")) {
                tree = list.remove(0);
                tree.setRight(buildTreeFromRight(list));
                tree.setLeft(buildTreeFromRight(list));
            } else {
                tree = list.remove(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tree;
    }

    /**
     * Find max level of the tree
     */
    private int findMaxLevel(Tree<String> tree) {
        if (tree == null)
            return 0;
        else
            return Math.max(findMaxLevel(tree.getLeft()), findMaxLevel(tree.getRight())) + 1;
    }

    /**
     * Method to print out the white space based on "ct"
     */
    private void printWS(int ct) {
        for (int i = 0; i < ct; i++)
            System.out.print(" ");
    }

    /**
     * Method to check if all trees in the listTree are null
     */
    private boolean areAllTreesNull(List<Tree<String>> listTree) {
        for (Tree<String> tree : listTree) {
            if (tree != null)
                return false;
        }
        return true;
    }

    private void printTreeHelper(List<Tree<String>> treeList, int lvl, int maxLvl) {
        if (treeList.isEmpty() || areAllTreesNull(treeList))
            return ;

        int floor = maxLvl - lvl;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWS(firstSpaces);

        List<Tree<String>> newNodes = new ArrayList<Tree<String>>();
        for (Tree<String> node : treeList) {
            if (node != null) {
                System.out.print(node.getData());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWS(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < treeList.size(); j++) {
                printWS(firstSpaces - i);
                if (treeList.get(j) == null) {
                    printWS(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (treeList.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    printWS(1);

                printWS(i + i - 1);

                if (treeList.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    printWS(1);

                printWS(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printTreeHelper(newNodes, lvl + 1, maxLvl);
    }

    /**
     * Method to print out the tree
     **/
    public void printTree() {
        Tree<String> thisTree = new Tree<String>(getData(), getLeft(), getRight());
        printTreeHelper(Collections.singletonList(thisTree), 1, findMaxLevel(thisTree));
    }
}