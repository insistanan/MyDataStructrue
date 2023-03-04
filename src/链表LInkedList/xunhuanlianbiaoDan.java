package 链表LInkedList;

import Handler.ananException;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的循环单链表
 *
 * @author insis
 * @date 2023/03/04
 */
public class xunhuanlianbiaoDan {
    int val;
    xunhuanlianbiaoDan next;

    public xunhuanlianbiaoDan() {
    }

    public xunhuanlianbiaoDan(int val) {
        this.val = val;
    }

    /**
     * 初始化一个空的双向单链表
     *
     * @return {@link xunhuanlianbiaoDan}
     */
    public static xunhuanlianbiaoDan init(){
        xunhuanlianbiaoDan root = new xunhuanlianbiaoDan(0);
        root.next = null;
        return root;
    }

    /**
     * 得到长度
     *
     * @return int
     */
    public int getLength(){
        if (this.next == null) {return 0;}
        int length = 1;
        xunhuanlianbiaoDan tmp = this.next;
        while(tmp.next != this.next){
            tmp = tmp.next;
            length ++;
        }
        return length;
    }

    /**
     * 得到首节点
     *
     * @return {@link xunhuanlianbiaoDan}
     */
    public xunhuanlianbiaoDan getHead(){
        return this.next;
    }

    /**
     * 得到尾节点
     *
     * @return {@link xunhuanlianbiaoDan}
     */
    public xunhuanlianbiaoDan getTail(){
        xunhuanlianbiaoDan tmp = this.next;
        while(tmp.next != this.next){
            tmp = tmp.next;
        }
        return tmp;
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
     * 得到指定位置的节点
     *
     * @param index 指数
     * @return {@link xunhuanlianbiaoDan}
     */
    public xunhuanlianbiaoDan getNodeByIndex(int index) throws ananException {
        if (index <= 0 ){ throw new ananException("error,位置输入为0或负数");}
        int length = this.getLength();
        //取余来循环
        int n = ( index % length );
        xunhuanlianbiaoDan tmp = this;
        for (int i = 0; i < n; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * 获取指定值的所有节点位置，以数组形式返回
     *
     * @param value 价值
     * @return {@link int[]}
     */
    public int[] getIndexsByValue(int value){
        List<Integer> list = new ArrayList<>();
        xunhuanlianbiaoDan tmp = this.next;
        if (this.linkedListIsEmpty()){
            return null;
        }
        int n = 1;
        while(tmp.next != this.next){
            if (tmp.val == value){
                list.add(n);
            }
            tmp = tmp.next;
            n++;
        }
        //判断尾节点的值是否符合
        if (tmp.val == value){
            list.add(n);
        }
        //转成数组进行返回
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 指定位置之后插入（链式调用）
     *
     * @param index 位置
     * @param node  节点
     * @return {@link xunhuanlianbiaoDan}
     * @throws ananException 安安例外
     */
    public xunhuanlianbiaoDan insertByIndexTail(int index,xunhuanlianbiaoDan node) throws ananException{
        if (index < 0 ){
            throw new ananException("错误，不能在这个位置插入");
        }
        if (index == 0){
            //如果位置是0，那么就是插入在头节点之后，首节点之前
            node.next = this.next;
            //判断循环链表是否为空链表，才好进行下一步尾节点的指针操作
            if (!this.linkedListIsEmpty()){
                //链表不为空链表，要进行尾部重新循环的指针切换
                //尾节点指向插入的节点
                this.getTail().next = node;
            }
            //链表为空链表，不用进行尾节点指针操作，那么直接把新节点插在头节点之后即可
            //头节点指向插入的节点
            this.next = node;
        }
        else {
            //首先判断链表是否为空链表，如果为空链表，那么就直接插后面
            if (this.linkedListIsEmpty()){
                this.next = node;
                node.next = node;
            }
            else{
                //现在是不为空链表的情况，那么即使index远大于链表长度，我们取余即可插入
                int length = this.getLength();
                int n = index % length;
                //去找到相对位置上的节点，在其后插入即可
                //这里还有情况，如果n为0，也就是在尾节点插入，那么要处理循环的问题
                if (n == 0){
                    xunhuanlianbiaoDan tail = this.getTail();
                    node.next = tail.next;
                    tail.next = node;
                }
                else {
                    xunhuanlianbiaoDan tmp = this;
                    for (int i = 0; i < n; i++) {
                        tmp = tmp.next;
                    }
                    //找到目标节点，在其后插入即可
                    node.next = tmp.next;
                    tmp.next = node;
                }
            }
        }
        return this;
    }

    /**
     * 指定位置之前插入（链式调用）
     *
     * @param index 位置
     * @param node  节点
     * @return {@link xunhuanlianbiaoDan}
     * @throws ananException 安安例外
     */
    public xunhuanlianbiaoDan insertNodeByIndexHead(int index,xunhuanlianbiaoDan node) throws  ananException{
        if (index <= 0 ){
            throw new ananException("错误，不能在这个位置插入");
        }
        if (index == 1){
            //插入在头节点之后，首节点之前
            //先判断是否为空链表
            if (!this.linkedListIsEmpty()){
                this.getTail().next = node;
                node.next = this.getHead();
                this.next = node;
            }
            else {
                this.next = node;
                node.next = node;
            }
        }
        else {
            int length = this.getLength();
            int n = index % length;
            if (length == 0){
                this.next = node;
                node.next = node;
            }
            else {
                xunhuanlianbiaoDan tmp = this;
                if (n == 0){
                    for (int i = 0; i < length - 1; i++) {
                        tmp = tmp.next;
                    }
                    node.next = tmp.next;
                    tmp.next = node;
                } else if (n == 1) {
                    this.getTail().next = node;
                    node.next = this.getHead();
                    this.next = node;
                }
                else {
                    for (int i = 0; i < n-1; i++) {
                        tmp = tmp.next;
                    }
                    node.next = tmp.next;
                    tmp.next = node;
                }
            }
        }
        return this;
    }

    /**
     * 删除指定位置的节点
     *
     * @param index 指数
     * @return {@link xunhuanlianbiaoDan}
     * @throws ananException 安安例外
     */
    public xunhuanlianbiaoDan deleteByIndex(int index) throws ananException{
        if (index <= 0){
            throw new ananException("错误，此位置不能删除");
        }
        if (this.linkedListIsEmpty()){
            System.out.println("链表为空，删无可删");
            return this;
        }
        int length = this.getLength();
        int n = index % length;
        xunhuanlianbiaoDan tmp = this;
        if (n == 0){
            for (int i = 0; i < length - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
        } else if (n == 1) {
            this.getTail().next = this.next.next;
            this.next = this.next.next;
        }else {
            for (int i = 0; i < n-1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
        }
        return this;
    }


}


