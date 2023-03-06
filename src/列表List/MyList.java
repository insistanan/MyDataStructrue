package 列表List;

import Handler.ananException;

import java.util.*;

public class MyList {

    private int[] nums;
    //列表容量
    private int capacity = 10;
    //列表长度
    private int size = 0;
    //列表扩容倍数
    private int extendRatio = 2;

    public MyList() {
        this.nums = new int[capacity];
    }

    public MyList(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        this.capacity = this.size+100;
    }

    /**
     * 获取列表长度
     *
     * @return int
     */
    public int size(){
        return this.size;
    }

    /**
     * 获得列表容量
     *
     * @return int
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * 访问元素
     *
     * @param index 指数
     * @return int
     * @throws ananException 安安例外
     */
    public int get(int index) throws ananException {
        //判断数组越界问题
        if (index < 0 || index >= size()){
            throw new ananException("数组越界");
        }
        return nums[index];
    }

    /**
     * 更新元素
     *
     * @param index 指数
     * @param num   全国矿工工会
     * @throws ananException 安安例外
     */
    public void set(int index,int num) throws ananException{
        //判断数组越界问题
        if (index < 0 || index >= size()){
            throw new ananException("数组越界");
        }
        nums[index] = num;
    }

    /**
     * 尾部添加元素
     *
     * @param num 全国矿工工会
     */
    public void add(int num){
        if (size == capacity()){
            extendCapacity();
        }
        nums[size] = num;
        size++;
    }

    /**
     * 指定位置后添加元素
     *
     * @param index 指数
     * @param num   全国矿工工会
     * @throws ananException 安安例外
     */
    public void add(int index,int num) throws ananException{
        //判断数组越界问题
        if (index < 0 || index >= size()){
            throw new ananException("数组越界");
        }
        //扩容问题
        if (size() == capacity()){
            extendCapacity();
        }
        // 将索引 index 以及之后的元素都向后移动一位
        for (int i = size()-1; i >=index ; i--) {
            nums[i+1] = nums[i];
        }
        nums[index] = num;
        size++;
    }

    /**
     * 扩容
     */
    private void extendCapacity() {
        //新建一个长度为size的数组，并将原数组拷贝到新数组
        nums = Arrays.copyOf(nums,capacity()*extendRatio);
        //更新列表容量
        this.capacity = nums.length;
    }

    /**
     * 获取容量
     *
     * @return int
     */
    private int capacity() {
        return this.capacity;
    }

    /**
     * 删除指定元素
     *
     * @param index 指数
     * @throws ananException 安安例外
     */
    public int remove(int index) throws ananException{
        if (index< 0 || index >= size()){
            throw  new ananException("数组越界");
        }
        int num = nums[index];
        //将索引index之后的元素都向前移动一位
        for (int i = index; i < size-1; i++) {
            nums[i] = nums[i+1];
        }
        //更新元素数量
        size--;
        //返回被删除元素
        return num;
    }

    /**
     * 将列表转换为数组
     *
     * @return {@link int[]}
     */
    public int[] toArray(){
        int[] arr = new int[size()];
        for (int i = 0; i < size(); i++) {
            arr[i] = nums[i];
        }
        return arr;
    }


    public static void main(String[] args) {
        //初始化列表
        //无初始值
        List<Integer> list = new ArrayList<>();
        Integer[] numbers = new Integer[]{1,2,3,4,5,8,6,7,9};
        //有初始值
        List<Integer> L1 = new ArrayList<>(Arrays.asList(numbers));
        //遍历列表
        //1.
        for (int i = 0; i < L1.size(); i++) {
            System.out.println(L1.get(i));
        }
        //2.
        for (Integer num:L1
             ) {
            System.out.println(num);
        }
        //拼接两个列表
        List<Integer> L2 = new ArrayList<>(Arrays.asList(new Integer[]{10,11,12,3}));
        //将列表L2拼接到L1之后
        L1.addAll(L2);

        //排序列表
        Collections.sort(L1);

        System.out.println("-----------------------------");
        Iterator<Integer> iterator = L1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
