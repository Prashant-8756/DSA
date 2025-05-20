#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* front = NULL;
struct Node* rear = NULL;

int isEmpty() {
    return front == NULL;
}

void enqueue(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = NULL;

    if (isEmpty()) {
        front = newNode; 
    } else {
        rear->next = newNode; 
    }
    rear = newNode; 
    printf("%d enqueued to queue\n", value);
}

int dequeue() {
    if (isEmpty()) {
        printf("Queue Underflow! Cannot dequeue from an empty queue\n");
        return -1;
    } else {
        struct Node* temp = front; 
        int value = front->data; 
        front = front->next; 
        free(temp); 
        return value;
    }
}

void display() {
    if (isEmpty()) {
        printf("Queue is empty\n");
    } else {
        struct Node* current = front; 
        printf("Queue elements are:\n");
        while (current != NULL) {
            printf("%d\n", current->data);
            current = current->next; 
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
