#include <stdio.h>
#include <stdlib.h>
#define MAX 5
int deque[MAX];
int front = -1;
int rear = -1;
int isEmpty() {
    return (front == -1);
}
int isFull() {
    return ((rear + 1) % MAX == front);
}
void insertFront(int value) {
    if (isFull()) {
        printf("Deque is full.\n");
        return;
    }
    if (isEmpty()) {
        front = rear = 0;
    } else {
        front = (front - 1 + MAX) % MAX;
    }
    deque[front] = value;
}
void insertEnd(int value) {
    if (isFull()) {
        printf("Deque is full.\n");
        return;
    }
    if (isEmpty()) {
        front = rear = 0;
    } else {
        rear = (rear + 1) % MAX;
    }
    deque[rear] = value;
}
void deleteFront() {
    if (isEmpty()) {
        printf("Deque is empty.\n");
        return;
    }
    if (front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % MAX;
    }
}
void deleteEnd() {
    if (isEmpty()) {
        printf("Deque is empty.\n");
        return;
    }
    if (front == rear) {
        front = rear = -1;
    } else {
        rear = (rear - 1 + MAX) % MAX;
    }
}
void display() {
    if (isEmpty()) {
        printf("Deque is empty.\n");
        return;
    }
    printf("Deque elements: ");
    int i = front;
    while (1) {
        printf("%d ", deque[i]);
        if (i == rear) break;
        i = (i + 1) % MAX;
    }
    printf("\n");
}
int main() {
    int choice, value;
    while (1) {
        printf("\nMenu:\n");
        printf("1. Insert at Front\n");
        printf("2. Insert at End\n");
        printf("3. Delete from Front\n");
        printf("4. Delete from End\n");
        printf("5. Display Deque\n");
        printf("6. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter value to insert at front: ");
                scanf("%d", &value);
                insertFront(value);
                break;
            case 2:
                printf("Enter value to insert at end: ");
                scanf("%d", &value);
                insertEnd(value);
                break;
            case 3:
                deleteFront();
                break;
            case 4:
                deleteEnd();
                break;
            case 5:
                display();
                break;
            case 6:
                printf("Exiting...\n");
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
    return 0;
}
