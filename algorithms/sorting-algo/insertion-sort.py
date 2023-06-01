import random
def insertion_sort(A):
    N = len(A)
    is_sorted = True
    for i in range(1,len(A)):
        key = A[i]
        j = i-1
        while j >= 0 and key < A[j]:
            A[j+1] = A[j]
            j-=1
        A[j+1] = key

if  __name__ == '__main__' :
    A = [random.randint(-100,100) for _ in range(10)]
    print(f"Before sorting with insertion sort -> {A}")
    insertion_sort(A)
    print(f"After sorting with insertion sort -> {A}")

    
