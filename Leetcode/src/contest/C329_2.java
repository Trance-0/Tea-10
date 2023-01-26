package contest;

public class C329_2 {
    // Java program to implement Max Heap

// Main class
public class MaxHeap {
	private int[][] Heap;
	private int size;
	private int maxsize;
    private int key;

	// Constructor to initialize an
	// empty max heap with given maximum
	// capacity
	public MaxHeap(int maxsize,int arrsize,int key)
	{
		// This keyword refers to current instance itself
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize][arrsize];
        this.key=key;
	}

	// Method 1
	// Returning position of parent
	private int parent(int pos) { return (pos - 1) / 2; }

	// Method 2
	// Returning left children
	private int leftChild(int pos) { return (2 * pos) + 1; }

	// Method 3
	// Returning right children
	private int rightChild(int pos)
	{
		return (2 * pos) + 2;
	}

	// Method 4
	// Returning true of given node is leaf
	private boolean isLeaf(int pos)
	{
		if (pos > (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	// Method 5
	// Swapping nodes
	private void swap(int fpos, int spos)
	{
		int[] tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// Method 6
	// Recursive function to max heapify given subtree
	private void maxHeapify(int pos)
	{
		if (isLeaf(pos))
			return;

		if (Heap[pos][key] < Heap[leftChild(pos)][key]
			|| Heap[pos][key] < Heap[rightChild(pos)][key]) {

			if (Heap[leftChild(pos)][key]
				> Heap[rightChild(pos)][key]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	// Method 7
	// Inserts a new element to max heap
	public void insert(int[] element)
	{
		Heap[size] = element;

		// Traverse up and fix violated property
		int current = size;
		while (Heap[current][key] > Heap[parent(current)][key]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}

	// Method 8
	// To display heap
	public void print()
	{

		for (int i = 0; i < size / 2; i++) {

			System.out.print("Parent Node : " + Heap[i]);

			if (leftChild(i)
				< size) // if the child is out of the bound
						// of the array
				System.out.print(" Left Child Node: "
								+ Heap[leftChild(i)]);

			if (rightChild(i)
				< size) // if the right child index must not
						// be out of the index of the array
				System.out.print(" Right Child Node: "
								+ Heap[rightChild(i)]);

			System.out.println(); // for new line
		}
	}

	// Method 9
	// Remove an element from max heap
	public int[] extractMax()
	{
		int[] popped = Heap[0];
		Heap[0] = Heap[--size];
		maxHeapify(0);
		return popped;
	}
}

    public int[][] sortTheStudents(int[][] score, int k) {
        int m=score.length,n=score[0].length;
        int[][]result=new int[m][n];
        MaxHeap a=new MaxHeap(m*2, n, k);
        for(int i=0;i<m;i++){
            a.insert(score[i]);
        }
        for(int i=0;i<m;i++){
            result[i]=a.extractMax();
        }
        return result;
    }
}
