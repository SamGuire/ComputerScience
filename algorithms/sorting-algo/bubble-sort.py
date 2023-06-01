import random
def bubble_sort(A):
    N = len(A)
    for i in range(len(A)):
        for j in range(len(A)-1):
            if A[j] > A[j+1] :
                A[j],A[j+1] = A[j+1],A[j]

if __name__ == '__main__':
    A = [random.randint(-100,100) for _ in range(10)]
    print(f"Before soritng with bubblesort -> {A}")
    bubble_sort(A)
    print(f"After soritng with bubblesort -> {A}")

