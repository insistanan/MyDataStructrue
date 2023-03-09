package 队列Queue;

import Handler.ananException;
import 链表LInkedList.danxianglianbiao;

public class MyQueueByLinkedList {
    //头节点和尾节点
    private danxianglianbiao head,tail;
    private int queSize = 0;

    /**
     * 初始化队列
     */
    public MyQueueByLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * 得到长度
     *
     * @return int
     */
    public int getLength(){
        return this.queSize;
    }

    /**
     * 是空
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return getLength() == 0;
    }

    /**
     * 入队
     *
     * @param num 全国矿工工会
     */
    public void push(int num){
        danxianglianbiao node = new danxianglianbiao(num);
        //如果队列为空，则令头尾节点都指向该节点
        if (head == null){
            head = node;
            tail = node;
        }
        //队列不为空，则将该节点添加到尾节点之后
        else{
            tail.setNext(node);
            tail = node;
        }

    }

    /**
     * 出队
     *
     * @return int
     */
    public int pop() throws  ananException{
        if (queSize == 0){
            throw new ananException("队列为空，无法出队");
        }
        int val = head.getVal();
        head = head.getNext();
        return val;
    }

    /**
     * 到数组
     *
     * @return {@link int[]}
     */
    public int[] toArray(){
        int[] arr = new int[queSize];
        danxianglianbiao tmp = head;
        for (int i = 0; i < queSize; i++) {
            arr[i] = tmp.getVal();
            tmp = tmp.getNext();
        }
        return arr;
    }



}
