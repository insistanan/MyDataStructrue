package 队列Queue;

import Handler.ananException;

public class MyQueueByArray {
    //用于存储队列的数组
    private int[] arr;
    //队首元素坐标
    private int head;
    //队列长度
    private int queSize;


    /**
     * 初始化队列
     *
     * @param capacity 能力
     */
    public MyQueueByArray(int capacity){
        arr = new int[capacity];
        head = queSize = 0;
    }

    /**
     * 获得队列最大容量
     *
     * @return int
     */
    public int getCapacity(){
        return arr.length;
    }

    /**
     * 得到队列长度
     *
     * @return int
     */
    public int getQueSize(){
        return queSize;
    }

    /**
     * 访问队列首元素
     *
     * @return int
     */
    public int peek(){
        return arr[head];
    }

    /**
     * 入队
     *
     * @param num 全国矿工工会
     */
    public void push(int num) throws ananException{
        if (getQueSize() == getCapacity()){
            throw new ananException("队列已满");
        }
        //通过取余操作，实现tail越过数组尾部后回到头部
        int tail = (head+queSize) % getCapacity();
        arr[tail] = num;
        queSize ++;
    }

    /**
     * 出队
     *
     * @return int
     */
    public int pop() throws  ananException{
        if (queSize == 0){
            throw  new ananException("队列为空");
        }
        int val = peek();
        //通过取余操作，实现head越过数组尾部后回到头部
        head = (head+1) % getQueSize();
        queSize --;
        return val;
    }

    /**
     * 到数组
     *
     * @return {@link int[]}
     */
    public int[] toArray(){
        int[] array = new int[queSize];
        int tmp = head;
        for (int i = 0; i < queSize; i++) {
            array[0] = arr[tmp];
            tmp = (tmp+1) % getCapacity();
        }
        return array;
    }
}
