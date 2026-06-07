package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CreateBTFromArray {
    public static void main(String[] args) {
        int[][] descriptions = new int[][] { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 },
                { 80, 19, 1 } };
        new Solution().createBinaryTree(descriptions);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Base class
        if (descriptions.length == 0) {
            return null; // means no node are present
        }
        // create two sets 1. parents -> where all parent and child node present
        // 2. childs -> where all child node present.
        Set<Integer> parents = new HashSet<>();
        Set<Integer> childs = new HashSet<>();
        // create a parentsChildMap where all map[parent] store the all child pair with
        // their directions
        Map<Integer, List<List<Integer>>> parentChild = new HashMap<>();

        for (int[] descript : descriptions) {
            parents.add(descript[0]);
            parents.add(descript[1]);
            childs.add(descript[1]);
            List<Integer> pair = new ArrayList<>();
            pair.add(descript[1]);
            pair.add(descript[2]);
            if (!parentChild.containsKey(descript[0])) {
                List<List<Integer>> childList = new ArrayList<>();
                childList.add(pair);
                parentChild.put(descript[0], childList);
            } else {
                parentChild.get(descript[0]).add(pair);
            }

        }
        // find the root node - which node is not present in childs set but present in
        // parents set
        int rootValue = -1;
        for (int element : parents) {
            if (!childs.contains(element)) {
                rootValue = element;
            }
        }
        if (rootValue == -1) {
            return null;
        }
        // create a root node
        TreeNode root = new TreeNode(rootValue);
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (!bfs.isEmpty()) {
            TreeNode parent = bfs.poll();
            // find its child
            if (parentChild.containsKey(parent.val)) {
                List<List<Integer>> allchild = parentChild.get(parent.val);
                for (List<Integer> eachChild : allchild) {
                    TreeNode childNode = new TreeNode(eachChild.get(0));
                    bfs.add(childNode);
                    if (eachChild.get(1) == 1) {
                        // left child
                        parent.left = childNode;
                    } else {
                        parent.right = childNode;
                    }
                }
            }
        }

        return root;
    }
}
