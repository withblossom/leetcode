package cn.yy.leetcode.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTree {
    Node head;

    public BinaryTree() {
    }

    public BinaryTree(int val) {
        head = new Node(val);
    }

    public static void binaryTreePaths(Node node, ArrayList<String> strings, StringBuilder builder) {
        builder.append(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder newBuilder = new StringBuilder();
            for (int i = 0; i < builder.length() - 1; i++) {
                newBuilder.append(builder.charAt(i)).append('-').append('>');
            }
            newBuilder.append(builder.charAt(builder.length() - 1));
            strings.add(newBuilder.toString());
            return;
        }
        if (node.left != null) {
            binaryTreePaths(node.left, strings, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (node.right != null) {
            binaryTreePaths(node.right, strings, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void binaryTreePaths(Node node, ArrayList<String> strings, String s) {
        s += node.val;
        if (node.left == null && node.right == null) {
            strings.add(s);
            return;
        }
        if (node.left != null) {
            binaryTreePaths(node.left, strings, s + "->");
        }
        if (node.right != null) {
            binaryTreePaths(node.right, strings, s + "->");
        }
    }

    public static ArrayList<String> binaryTreePaths(Node node) {
        ArrayList<String> strings = new ArrayList<>();
        if (node == null) {
            return strings;
        }
//        binaryTreePaths(node,strings,new StringBuilder());
        binaryTreePaths(node, strings, "");
        return strings;
    }

    public static boolean isSymmetry(Node l, Node r) {
        if (l == null && r == null) {
            return true;
        } else if (l == null) {
            return false;
        } else if (r == null) {
            return false;
        } else if (l.val != r.val) {
            return false;
        }
        return isSymmetry(l.left, r.right)
                && isSymmetry(l.right, r.left);
    }

    public static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    public static int minDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        if (node.left == null) {
            return right + 1;
        }
        if (node.right == null) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

    public static int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return countNodes(node.left) + countNodes(node.right) + 1;
    }

    public static int isBalanced(Node node) {
        if (node == null) {
            return 0;
        }
        int left = isBalanced(node.left);
        if (left == -1) return -1;
        int right = isBalanced(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > -1) return -1;
        return Math.max(left, right) + 1;
    }

    public static int sumOfLeftLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        int left = sumOfLeftLeaves(node.left);
        int right = sumOfLeftLeaves(node.right);
        int mid = 0;
        if (node.left != null && node.left.left == null && node.left.right == null) {
            mid += node.left.val;
        }
        return mid + left + right;
    }

    public static int findLeftValue(Node node) {
        if (node == null) {
            return 0;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        int val = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Node temp = queue.removeFirst();
                if (i == 0) {
                    val = temp.val;
                }
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }
            }
        }
        return val;
    }

    public static boolean hasPathSum(Node node, int sum) {
        if (node == null) {
            return false;
        }
        if (sum == node.val && node.left == null && node.right == null) {
            return true;
        }
        return hasPathSum(node.left, sum - node.val)
                || hasPathSum(node.right, sum - node.val);
    }

    public static Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private static Node buildTree(HashMap<Integer, Integer> map, int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int mid = postorder[postEnd - 1];
        int index = map.get(mid);
        Node node = new Node(mid);
        int len = index - inBegin;
        node.left = buildTree(map, inorder, inBegin, index, postorder, postBegin, postBegin + len);
        node.right = buildTree(map, inorder, index + 1, inEnd, postorder, postBegin + len, postEnd - 1);
        return node;
    }

    public static Node constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    public static Node constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }
        int maxIndex = l;// 最大值所在位置
        int maxVal = nums[maxIndex];// 最大值
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        Node node = new Node(maxVal);
        node.left = constructMaximumBinaryTree(nums, l, maxIndex);
        node.right = constructMaximumBinaryTree(nums, maxIndex + 1, r);
        return node;
    }

    public static Node mergeTrees(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node node = new Node(node1.val + node2.val);
        node.left = mergeTrees(node1.left, node2.left);
        node.right = mergeTrees(node1.right, node2.right);
        return node;
    }

    public static Node searchTree(Node node, int val) {
        if (node == null || node.val == val) {
            return node;
        }
        Node t = searchTree(node.left, val);
        if (t != null) {
            return t;
        }
        return searchTree(node.left, val);
    }

    public static Node searchBST(Node node, int val) {
        if (node == null || node.val == val) {
            return node;
        }
        if (val > node.val) return searchBST(node.right, val);
        return searchBST(node.left, val);
    }

    public static boolean isValidBST(Node node) {
        if (node == null) {
            return true;
        }
        boolean left = isValidBST(node.left);
        if (pre != null && pre.val > node.val) {
            return false;
        }
        pre = node;
        boolean right = isValidBST(node.right);
        return left && right;
    }

    static int res = Integer.MAX_VALUE;

    public static void getMinimumDifference(Node node){
        if (node == null){
            return;
        }
        getMinimumDifference(node.left);
        if (pre != null){
            res = Math.min(node.val - pre.val, res);
        }
        pre = node;
        getMinimumDifference(node.right);
    }

    static int max = Integer.MIN_VALUE;
    static int count = 1;
    static Node pre;
    public static void findMode(Node node,ArrayList<Integer> list){
        if (node == null){
            return;
        }
        findMode(node.left,list);
        if (pre == null) { // 第一个节点
            count = 1;
        } else if (pre.val == node.val) { // 与前一个节点数值相同
            count++;
        } else { // 与前一个节点数值不同
            count = 1;
        }
        pre = node; // 更新上一个节点

        if (count == max) { // 如果和最大值相同，放进result中
            list.add(node.val);
        }

        if (count > max) { // 如果计数大于最大值频率
            max = count;   // 更新最大频率
            list.clear();     // 很关键的一步，不要忘记清空result，之前result里的元素都失效了
            list.add(node.val);
        }
        findMode(node.right,list);
    }

    /*
        0
      1  2
     3  6 4
    5
     */
    public static void main(String[] args) {
//        Node node = new Node(0);
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        Node node6 = new Node(6);
//        node.left = node1;
//        node.right = node2;
//        node1.left = node3;
//        node2.right = node4;
//        node3.left = node5;
//        node2.left = node6;

//        System.out.println(sumOfLeftLeaves(node));
//        System.out.println(findLeftValue(node));
//        getMinimumDifference(node,null);
//        System.out.println(res);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node22 = new Node(2);
        node1.right=node2;
        node2.left=node22;
        ArrayList<Integer> list = new ArrayList<>();
        findMode(node1,list);
        System.out.println(list);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    
}
