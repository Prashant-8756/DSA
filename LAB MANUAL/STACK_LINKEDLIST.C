#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* top = NULL;

int isEmpty() {
    return top == NULL;
}

void push(int value) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        return;
    }
    newNode->data = value;
    newNode->next = top; 
    top = newNode;
    printf("%d pushed to stack\n", value);
}

int pop() {
    if (isEmpty()) {
        printf("Stack Underflow! Cannot pop from an empty stack\n");
        return -1;
    } else {
        Node* temp = top; 
        int value = top->data; 
        top = top->next; 
        free(temp); 
        return value;
    }
}

void display() {
    if (isEmpty()) {
        printf("Stack is empty\n");
    } else {
        Node* current = top; 
        printf("Stack elements are:\n");
        while (current != NULL) {
            printf("%d\n", current->data);
            current = current->next; 
        }
    }
}

int main() {
    int choice, value;

    while (1) {
        printf("\nStack Operations:\n");
        printf("1. Push\n");
        printf("2. Pop\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to push: ");
                scanf("%d", &value);
                push(value);
                break;
            case 2:
                value = pop();
                if (value != -1) {
                    printf("%d popped from stack\n", value);
                }
                break;
            case 3:
                display();
                break;
            case 4:
                // Free the stack before exiting
                while (!isEmpty()) {
                    pop();
                }
                exit(0);
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }
    return 0;
}
