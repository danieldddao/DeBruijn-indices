package lambdaCalculus.project.tree;

import java.util.List;

/**
 * Implementation of a Tree:
 *    Each node has one String stored in the instance variable data.
 *    The instance variables left and right are the left and right children of the node.
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
   * Method to get the data from this node.
   * @return the data from this node
   **/
   public String getData( )
   {
      return data;
   }
   
   
   /**
   * Method to get the left child of this node.
   * @return a the left child of this node (or NULL if there is no left child)
   **/
   public Tree<String> getLeft( )
   {
      return left;                                               
   } 
   
   
//   /**
//   * Method to get the data from the leftmost node of the tree.
//   * @return the data from the deepest leftmost node of the tree.
//   **/
//   public E getLeftmostData( )
//   {
//      if (left == null)
//         return data;
//      else
//         return left.getLeftmostData( );
//   }


   /**
    * Method to get the right child of this node.
    * @return a the right child of this node (or NULL if there is no right child)
    **/
   public Tree<String> getRight( )
   {
      return right;                                               
   }


//   /**
//    * Method to get the data from the rightmost node of the tree.
//    * @return the data from the deepest rightmost node of the tree.
//    **/
//   public E getRightmostData( )
//   {
//      if (left == null)
//         return data;
//      else
//         return left.getRightmostData( );
//   }

//   /**
//    * Method to determine whether a node is a leaf.
//    * @return
//    *   TRUE if this node is a leaf
//    *   FALSE if this node is not a leaf.
//    **/
//   public boolean isLeaf( )
//   {
//      return (left == null) && (right == null);
//   }

//   /**
//   * Uses an inorder traversal to print the data from each node at or below this node of the binary tree.
//   **/
//   public void inorderPrint( )
//   {
//      if (left != null)
//         left.inorderPrint( );
//      System.out.println(data);
//      if (right != null)
//         right.inorderPrint( );
//   }
//
//   /**
//   * Uses a preorder traversal to print the data from each node at or below
//   * this node of the binary tree.
//   **/
//   public void preorderPrint( )
//   {
//      System.out.println(data);
//      if (left != null)
//         left.preorderPrint( );
//      if (right != null)
//         right.preorderPrint( );
//   }
//
//   /**
//   * Uses a postorder traversal to print the data from each node at or below
//   * this node of the binary tree.
//   **/
//   public void postorderPrint( )
//   {
//      if (left != null)
//         left.postorderPrint( );
//      if (right != null)
//         right.postorderPrint( );
//      System.out.println(data);
//   }
//
//   /**
//   * Uses an inorder traversal to print the data from each node at or below this node of the binary tree, with indentations to indicate the depth of each node.
//   * @param depth: the depth of this node (with 0 for root, 1 for the root's children, and so on)
//   **/
//   public void print(int depth)
//   {
//      int i;
//
//      // Print the indentation and the data from the current node
//      for (i = 1; i <= depth; i++)
//         System.out.print("    ");
//      System.out.println(data);
//
//      // Print the left subtree
//      if (left != null)
//         left.print(depth+1);
//      else if (right != null)
//      {
//         for (i = 1; i <= depth+1; i++)
//            System.out.print("    ");
//         System.out.println("--");
//      }
//
//      // Print the right subtree
//      if (right != null)
//         right.print(depth+1);
//      else if (left != null)
//      {
//         for (i = 1; i <= depth+1; i++)
//            System.out.print("    ");
//         System.out.println("--");
//      }
//   }
   

//   /**
//   * Remove the leftmost most node of the tree with this node as its root.
//   **/
//   public Tree<E> removeLeftmost( )
//   {
//      if (left == null)
//         return right;
//      else
//      {
//         left = left.removeLeftmost( );
//         return this;
//      }
//   }
//
//
//   /**
//   * Remove the rightmost most node of the tree with this node as its root.
//   **/
//   public Tree<E> removeRightmost( )
//   {
//      if (right == null)
//         return left;
//      else
//      {
//         right = right.removeRightmost( );
//         return this;
//      }
//   }
       
//   /**
//   * Method to set the data in this node.
//   * @param newData: the new data to place in this node
//   **/
//   public void setData(E newData)
//   {
//      data = newData;
//   }
   
   
   /**
   * Method to set the link to the left child of this node.
   * @param newLeft: the new left child of this node
   **/
   public void setLeft(Tree<String> newLeft)
   {                    
      left = newLeft;
   }
    
    
   /**
   * Method to set the link to the right child of this node.
   * @param newRight: the new right child of this node
   **/
   public void setRight(Tree<String> newRight)
   {                    
      right = newRight;
   }  
    
    
//   /**
//   * Method to copy a tree.
//   * @param source: the tree that will be copied
//   * @return
//   *     a copy of the tree.
//   **/
//   public static <E> Tree<E> treeCopy(Tree<E> source)
//   {
//      Tree<E> leftCopy, rightCopy;
//
//      if (source == null)
//         return null;
//      else
//      {
//         leftCopy = treeCopy(source.left);
//         rightCopy = treeCopy(source.right);
//         return new Tree<E>(source.data, leftCopy, rightCopy);
//      }
//   }
   

//   /**
//   * Method to count the number of nodes in a binary tree.
//   * @param root: the root of a tree.
//   * @return
//   *   the number of nodes in the tree.
//   **/
//   public static <E> long treeSize(Tree<E> root)
//   {
//      if (root == null)
//         return 0;
//      else
//         return 1 + treeSize(root.left) + treeSize(root.right);
//   }

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
}