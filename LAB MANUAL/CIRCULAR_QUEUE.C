#include <stdio.h>
#include <stdlib.h>
#define MAX 100
int queue[MAX];
int front = -1;
int rear = -1;
int isFull() {
    return (rear + 1) % MAX == front;
}
int isEmpty() {
    return front == -1;
}
void enqueue(int value) {
    if (isFull()) {
        printf("Queue Overflow! Cannot enqueue %d\n", value);
    } else {
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % MAX;
        queue[rear] = value;
        printf("%d enqueued to queue\n", value);
    }
}
int dequeue() {
    if (isEmpty()) {
        printf("Queue Underflow! Cannot dequeue from an empty queue\n");
        return -1;
    } else {
        int value = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX;
        }
        return value;
    }
}
void display() {
    if (isEmpty()) {
        printf("Queue is empty\n");
    } else {
        printf("Queue elements are:\n");
        int i = front;
        while (1) {
            printf("%d\n", queue[i]);
            if (i == rear) break;
            i = (i + 1) % MAX;
        }
    }
}
int main() {
    int choice, value;
    while (1) {
        printf("\nQueue Operations:\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter value to enqueue: ");
                scanf("%d", &value);
                enqueue(value);
                break;
            case 2:
                value = dequeue();
                if (value != -1) {
                    printf("%d dequeued from queue\n", value);
                }
                break;
            case 3:
                display();
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }
    return 0;
}
