#include <stdio.h>
#include <stdlib.h>

#define MAX 5 

typedef struct Queue {
    int items[MAX];
    int front;
    int rear;
} Queue;

Queue* createQueue() {
    Queue* q = (Queue*)malloc(sizeof(Queue));
    q->front = -1;
    q->rear = -1;
    return q;
}

int isFull(Queue* q) {
    return (q->rear + 1) % MAX == q->front;
}

int isEmpty(Queue* q) {
    return q->front == -1;
}

void insert_queue(Queue* q, int value) {
    if (isFull(q)) {
        printf("Queue is full!\n");
        return;
    }
    if (isEmpty(q)) {
        q->front = 0;
    }
    q->rear = (q->rear + 1) % MAX;
    q->items[q->rear] = value;
    printf("Inserted %d\n", value);
}

int delete_queue(Queue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty!\n");
        return -1;
    }
    int item = q->items[q->front];
    if (q->front == q->rear) {
        q->front = -1;
        q->rear = -1;
    } else {
        q->front = (q->front + 1) % MAX;
    }
    printf("Deleted %d\n", item);
    return item;
}

void display(Queue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty!\n");
        return;
    }
    printf("Queue elements: ");
    for (int i = q->front; i != q->rear; i = (i + 1) % MAX) {
        printf("%d ", q->items[i]);
    }
    printf("%d\n", q->items[q->rear]);
}

int main() {
    Queue* q = createQueue();
    int choice, value;

    do {
        printf("\nMenu:\n");
        printf("1. Insert\n");
        printf("2. Delete\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                insert_queue(q, value);
                break;
            case 2:
                delete_queue(q);
                break;
            case 3:
                display(q);
                break;
            case 4:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 4);
    free(q);
    return 0;
}
