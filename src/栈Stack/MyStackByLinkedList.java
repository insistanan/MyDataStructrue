package 栈Stack;

import Handler.ananException;
import 链表LInkedList.danxianglianbiao;

public class MyStackByLinkedList {
    private danxianglianbiao stack;

    public MyStackByLinkedList() {
        stack = new danxianglianbiao();
    }

    /**
     * 得到长度
     *
     * @return int
     */
    public int getLength(){
        return stack.getLength();
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return stack.linkedListIsEmpty();
    }

    /**
     * 访问栈顶元素
     *
     * @return int
     * @throws ananException 安安例外
     */
    public int peek() throws  ananException{
        if (isEmpty()){
            throw new ananException("EmptyStackException");
        }
        return stack.getHead().getVal();
    }

    /**
     * 入栈
     *
     * @param num 全国矿工工会
     */
    public void push(int num){
        danxianglianbiao node = new danxianglianbiao(num);
        try {
            stack.insertNode(node,0);
        } catch (ananException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 出栈
     *
     * @return int
     * @throws ananException 安安例外
     */
    public int pop() throws  ananException{
        if (isEmpty()){
            throw new ananException("EmptyStackException");
        }
        int n = stack.getHead().getVal();
        stack.deleteNodeByIndex(1);
        return n;
    }

    /**
     * 将栈转换到数组返回
     *
     * @return {@link int[]}
     * @throws ananException 安安例外
     */
    public int[] toArray() throws  ananException {
        if (isEmpty()){
            throw new ananException("EmptyStackException");
        }
        int[] arr = new int[getLength()];
        danxianglianbiao tmp = stack;
        for (int i = 0; i < getLength(); i++) {
            tmp = tmp.getNext();
            arr[i] = tmp.getVal();
        }
        return arr;
    }
}
