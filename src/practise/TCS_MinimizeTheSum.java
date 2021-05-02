package practise;

import java.util.Scanner;

public class TCS_MinimizeTheSum { 
    private int[] Heap; 
    private int size; 
    private int maxsize; 
  
    public TCS_MinimizeTheSum(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    } 
  
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    private void swap(int fpos, int spos) 
    { 
        int tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  
    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos] < Heap[leftChild(pos)] ||  
            Heap[pos] < Heap[rightChild(pos)]) { 
  
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  
    public void insert(int element) 
    { 
        Heap[++size] = element; 
  
        int current = size; 
        while (Heap[current] > Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
   
    public int extractMax() 
    { 
        int popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
  
    public static void main(String[] arg) 
    { 
    	Scanner scan = new Scanner(System.in);
		int arrSize = scan.nextInt();
		int maxOps = scan.nextInt();
		TCS_MinimizeTheSum maxHeap = new TCS_MinimizeTheSum(arrSize+1); 
		for(int i=0; i<arrSize; i++) {
			maxHeap.insert(scan.nextInt());
		}

		while(maxOps > 0) {
			int max = maxHeap.extractMax();
			maxHeap.insert(Math.floorDiv(max, 2));
			maxOps--;
		}
		
		System.out.println(maxHeap.sum());
      }

	public int sum() {
		int sum = 0;
		for(int i=1; i<=size; i++) {
			sum += Heap[i];
		}
		return sum;
	} 
} 