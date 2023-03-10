package 堆Heap;

public class MyHeap {
    private int[] a;//数组，从下标1开始存储数据
    private int n;//堆可以存储的最大数据个数
    private int count;//堆中已经存储的数据个数

    public MyHeap(int capacity){
        a = new int[capacity+1];
        n=capacity;
        count = 0;
    }

    //1、插入数据，并从下往上堆化
    public void insert(int data){
        //堆满了
        if(count>=n) {return;}
        ++count;
        a[count]=data;
        int i = count;
        while(i/2>0 && a[i]>a[i/2]){
            swap(a,i,i/2);
            i=i/2;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp=array[j];
        array[j]=array[i];
        array[i]=temp;
    }

    public void removeMax(){
        if(count ==0) {return;}
        a[1]=a[count];
        --count;
        heapity(a,count,1);
    }

    //2、自上往下堆化
    private void heapity(int[] a2, int n, int i) {
        while(true){
            int MaxPos=i;
            if(i*2<=n && a[i]<a[i*2]) {MaxPos=i*2;}
            if(i*2+1<=n && a[MaxPos]<a[i*2+1]) {MaxPos=i*2+1;}

            if(MaxPos==i) {break;}
            swap(a, i, MaxPos);
            i=MaxPos;
        }
    }


}
