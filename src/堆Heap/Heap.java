package 堆Heap;

import java.util.*;

/**
 * 堆
 * 堆是一棵限定条件下的完全二叉树，分为大顶堆MaxHeap和小顶堆MinHeap
 * 给定索引i，那么其左子结点索引为 2i+1、右子结点索引为2i+2、父结点索引为（i-1）/2（向下整除）。
 * 当索引越界时，代表空结点或结点不存在。
 * @author insis
 * @date 2023/03/10
 */
public class Heap {
    /* 初始化堆 */
    public Heap(){
        // 初始化小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();
        //Java 优先队列（PriorityQueue）

        // 初始化大顶堆（使用 lambda 表达式修改 Comparator 即可）
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        /* 元素入堆 */
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(5);
        maxHeap.add(4);
    }


    /* 获取堆顶元素 */
    public int peek(Queue<Integer> heap){
        return heap.peek();
    }


    /* 输入列表并建堆 */
    public Queue<Integer> createHeap(int[] arr){
        //1 3 2 5 4
        Queue minHeap = new PriorityQueue<>(Arrays.asList(arr));
        return minHeap;
    }

    //用数组表示
    public List<Integer> initByArray(){
        List<Integer> list = new ArrayList<>();
        return list;
    }

    /* 获取左子结点索引 */
    int left(int i) {
        return 2 * i + 1;
    }

    /* 获取右子结点索引 */
    int right(int i) {
        return 2 * i + 2;
    }

    /* 获取父结点索引 */
    int parent(int i) {
        return (i - 1) / 2; // 向下整除
    }



}
