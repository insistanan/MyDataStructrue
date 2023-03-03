package 链表LInkedList;

import Handler.ananException;

/**
 * 我的单向链表（带头节点的单链表）
 *
 * @author insis
 * @date 2023/03/03
 */
public class danxianglianbiao {
    //节点值
    int val;
    //指向下一个节点的指针（引用）
    danxianglianbiao next;
    //构造函数


    public danxianglianbiao() {
    }

    public danxianglianbiao(int val) {
        this.val = val;
    }

    /**
     * 初始化链表（空的单链表）
     *
     * @return {@link danxianglianbiao}
     */
    public static danxianglianbiao initLinkedList(){
        //生成头节点
        danxianglianbiao root = new danxianglianbiao(0);
        root.next = null;
        return root;
    }

    /**
     * 获取链表长度
     *
     * @return int
     */
    public int getLength(){
        int length = 0;
        danxianglianbiao tmp = this;
        tmp = tmp.next;
        while((tmp != null)){
            tmp = tmp.next;
            length++;
        }
        return length;
    }

    /**
     * 链表是否为空
     *
     * @return ture 为空
     * @return false 非空
     */
    public boolean linkedListIsEmpty(){
        if (this.next == null){
            //为空
            return true;
        }
        //非空
        return false;
    }

    /**
     * 清空链表
     *
     */
    public void destroyLinkedList(){
        this.next = null;
        //Java垃圾回收自动帮我们处理垃圾
    }

    /**
     * 得到指定位置的节点的值
     *
     * @param index 指数
     * @return int
     * @throws ananException 安安例外
     */
    public int getNode(int index) throws ananException {
        if (index > this.getLength() || index <= 0){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为0或负数");
        }
        int value = 0;
        danxianglianbiao tmp = this.next;
        for (int i = 0; i < index; i++) {
            value = tmp.val;
            tmp = tmp.next;
        }
        return value;
    }

    /**
     * 根据值查找节点序号
     *
     * @param value 价值
     * @return int 如果找不到，返回0
     */
    public int getNodeIndexByValue(int value){
        int result = 1;
        danxianglianbiao tmp = this.next;
        while(tmp != null){
            if (tmp.val == value){
                //返回位置序号
                return result;
            }
            else {
                tmp = tmp.next;
            }
        }
        //如果查到尾还没找到，返回0
        return 0;
    }

    /**
     * 根据值查找节点
     *
     * @param value 价值
     * @return {@link danxianglianbiao}
     */
    public danxianglianbiao getNodeByValue(int value){
        danxianglianbiao tmp = this.next;
        while(tmp != null){
            if (tmp.val == value){
                return tmp;
            }else {
                tmp = tmp.next;
            }
        }
        //如果没找到，返回空
        return null;
    }

    /**
     * 指定位置后插入节点
     *
     * @param node 节点
     */
    public void insertNode(danxianglianbiao node,int index) throws ananException{
        //先要找到该位置的节点
        if (index > this.getLength() || index < 0){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为负数");
        }
        danxianglianbiao tmp = this;
        //找到目标节点
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        //执行插入
        node.next = tmp.next;
        tmp.next = node;
    }

    /**
     * 指定位置后插入节点（链式调用）
     *
     * @param node  节点
     * @param index 指数
     * @return {@link danxianglianbiao}
     * @throws ananException 安安例外
     */
    public danxianglianbiao insertNodeL(danxianglianbiao node,int index) throws  ananException{
        //先要找到该位置的节点
        if (index > this.getLength() || index < 0){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为负数");
        }
        danxianglianbiao tmp = this;
        //找到目标节点
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        //执行插入
        node.next = tmp.next;
        tmp.next = node;
        return this;
    }

    /**
     * 删除指定位置的节点
     *
     * @param index 指数
     * @throws ananException 安安例外
     */
    public void deleteNodeByIndex(int index)throws ananException{
        if (index > this.getLength() || index <= 0){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为0或负数");
        }
        danxianglianbiao tmp = this;
        //找到目标节点前一个节点
        for (int i = 0; i < index-1; i++) {
            tmp = tmp.next;
        }
        //执行删除
        tmp.next = tmp.next.next;
    }

    /**
     * 删除指定位置的节点（链式调用）
     *
     * @param index 指数
     * @return {@link danxianglianbiao}
     * @throws ananException 安安例外
     */
    public danxianglianbiao deleteNodeByIndexL(int index)throws ananException{
        if (index > this.getLength() || index <= 0){
            throw new ananException("error,可能是链表没有那么长，或者输入位置为0或负数");
        }
        danxianglianbiao tmp = this;
        //找到目标节点前一个节点
        for (int i = 0; i < index-1; i++) {
            tmp = tmp.next;
        }
        //执行删除
        tmp.next = tmp.next.next;
        return this;
    }

    /**
     * 生成链表（通过数组尾插法）
     *
     * @param arr 数组
     * @return {@link danxianglianbiao}
     */
    public danxianglianbiao createLinkedListByTail(int[] arr){
        danxianglianbiao root = this;
        //初始化各个节点并构建引用指向
        for (int i = 0; i < arr.length; i++) {
            root.next = new danxianglianbiao(arr[i]);
        }
        return this;
    }

    /**
     * 生成链表（通过数组头插法）
     *
     * @param arr 数组
     * @return {@link danxianglianbiao}
     */
    public danxianglianbiao createLinkedListByHead(int[] arr){
        danxianglianbiao root = this;
        //初始化各个节点并构建引用指向
        for (int i = 0; i < arr.length; i++) {
            danxianglianbiao node = new danxianglianbiao(arr[i]);
            node.next = root.next;
            root.next = node;
        }
        return this;
    }


}
