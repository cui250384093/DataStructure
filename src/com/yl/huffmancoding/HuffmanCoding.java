package com.yl.huffmancoding;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.*;

/**
 * @author candk
 * @Description 赫夫曼编码(前缀编码)
 * @date 3/24/21 - 10:21 AM
 */
public class HuffmanCoding {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java !";

        System.out.println(str);
        byte[] bytes = strToHuffmanCodes(str);
        String b = huffmanCodeToString(bytes);
        System.out.println(b);


    }

    /**
     * 将string 转化为赫夫曼编码
     * @param str 待压缩字符串
     * @return 赫夫曼编码
     */
    public static byte[] strToHuffmanCodes(String str) {
        ArrayList<Node> nodes = getHuffmanNodes(str);
        Node root = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getHuffmanCodes(root);
        return zip(str, huffmanCodes);
    }

    /**
     *
     * @param str 原始字符串
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的byte[]
     */
    private static byte[] zip(String str, Map<Byte, String> huffmanCodes) {
        byte[] bytes = str.getBytes();
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuilder.toString());

        int len = (stringBuilder.length() % 8 == 0)? stringBuilder.length() / 8: stringBuilder.length() / 8 + 1;
        byte[] huffmanCodeBytes = new byte[len];

        for (int i = 0, index = 0; i < stringBuilder.length(); i += 8, index++) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
        }

        return huffmanCodeBytes;
    }

    private static String huffmanCodeToString(byte[] huffmanCode) {
        ArrayList<Byte> byteArrayList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < huffmanCode.length - 1; i++) {
            stringBuilder.append(String.format("%8s", Integer.toBinaryString(huffmanCode[i] & 0xFF)).replace(' ', '0'));
        }
        //TODO: 最后一个字节待优化
        String str = Integer.toBinaryString(huffmanCode[huffmanCode.length - 1] | 256).replace(' ', '0');
        String sub = str.substring(str.length() - 0);
        stringBuilder.append(sub);

        String huffmanString = new String(stringBuilder);
        HashMap<String, Byte> byteHashMap = new HashMap<>(10);
        for (Byte key : huffmanCodes.keySet()) {
            byteHashMap.put(huffmanCodes.get(key), key);
        }
        System.out.println(huffmanString);
        for (int i = 1, index = 0; i <= huffmanString.length(); i++) {
            String substring = huffmanString.substring(index, i);
            if (byteHashMap.get(substring) != null) {
                byteArrayList.add(byteHashMap.get(substring));
                index = i;
            }
        }

        byte[] huffmanBytes = new byte[byteArrayList.size()];
        for (int i = 0; i < byteArrayList.size(); i++) {
            huffmanBytes[i] = byteArrayList.get(i);
        }

        return new String(huffmanBytes);
    }



    /**
     * 获取赫夫曼表
     */
    static HashMap<Byte, String> huffmanCodes = new HashMap<>(10);
    /**
     * 生成赫夫曼编码时，需要去拼接路径，用来存储某个叶子结点的路径
     */
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入huffmanCodes集合
     * @param node 传入结点
     * @param code 路径：左子结点是0，右子结点是1
     * @param stringBuilder 用于拼接路径
     */
    private static void getHuffmanCodes(@NotNull Node node, String code, StringBuilder stringBuilder) {

        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node.data == null) {
            getHuffmanCodes(node.left, "0", stringBuilder1);
            getHuffmanCodes(node.right, "1", stringBuilder1);
        } else {
            huffmanCodes.put(node.data, stringBuilder1.toString());
        }
    }

    private static Map<Byte, String> getHuffmanCodes(Node root) {
        if (root == null) {
            return null;
        }

        getHuffmanCodes(root.left, "0", stringBuilder);
        getHuffmanCodes(root.right, "1", stringBuilder);

        return huffmanCodes;
    }

    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("Tree is empty!");
        }
    }

    public static ArrayList<Node> getHuffmanNodes(String str) {
        byte[] bytes = str.getBytes();
        HashMap<Byte, Integer> hm = new HashMap<>(10);
        ArrayList<Node> nodes = new ArrayList<>();

        for (byte b : bytes) {
            hm.put(b, hm.containsKey(b)? hm.get(b) + 1: 1);
        }

        for (Byte key : hm.keySet()) {
            nodes.add(new Node(hm.get(key), key));
        }

        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.weight + rightNode.weight, null);

            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);

        }
        return  nodes.get(0);
    }
}
