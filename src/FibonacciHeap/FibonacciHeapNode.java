package FibonacciHeap;

class FibonacciHeapNode
{
    FibonacciHeapNode child, left, right, parent;
    int element;

    // Конструктор
    public FibonacciHeapNode(int element)
    {
        this.right = this;
        this.left = this;
        this.element = element;
    }

}