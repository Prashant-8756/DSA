#include <stdio.h>
#include <stdlib.h>
struct Node {
    int data;
    struct Node* next;
    struct Node* pre;
};

typedef struct Node NODE;

NODE* createNode(int data) {
    NODE* newNode = (NODE*)malloc(sizeof(NODE));
    newNode->data = data;
    newNode->next = NULL;
    newNode->pre = NULL;
    return newNode;
}

NODE* head = NULL;
NODE* tail = NULL;

void insertAtBeginning(int data) {
    NODE* newNode = createNode(data);
    if (head == NULL) {
        head = tail = newNode;
    } else {
        newNode->next = head;
        head->pre = newNode;
        head = newNode;
    }
}

void insertAtEnd(int data) {
    NODE* newNode = createNode(data);
    if (tail == NULL) {
        head = tail = newNode;
    } else {
        tail->next = newNode;
        newNode->pre = tail;
        tail = newNode;
    }
}

void insertAtPosition(int data, int position) {
    if (position == 1) {
        insertAtBeginning(data);
        return;
    }
    
    NODE* newNode = createNode(data);
    NODE* current = head;
    for (int i = 1; current != NULL && i < position - 1; i++) {
        current = current->next;
    }
    
    if (current == NULL) {
        printf("Position out of bounds. Inserting at the end.\n");
        insertAtEnd(data);
    } else {
        newNode->next = current->next;
        newNode->pre = current;
        if (current->next != NULL) {
            current->next->pre = newNode;
        }
        current->next = newNode;
        if (newNode->next == NULL) {
            tail = newNode; // Update tail if inserted at the end
        }
    }
}

void deleteAtBeginning() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }
    NODE* temp = head;
    head = head->next;
    if (head != NULL) {
        head->pre = NULL;
    } else {
        tail = NULL; // List is now empty
    }
    free(temp);
}

void deleteAtEnd() {
    if (tail == NULL) {
        printf("List is empty.\n");
        return;
    }
    NODE* temp = tail;
    tail = tail->pre;
    if (tail != NULL) {
        tail->next = NULL;
    } else {
        head = NULL; // List is now empty
    }
    free(temp);
}

void deleteAtPosition(int position) {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }
    
    if (position == 1) {
        deleteAtBeginning();
        return;
    }
    
    NODE* current = head;
    for (int i = 1; current != NULL && i < position; i++) {
        current = current->next;
    }
    
    if (current == NULL) {
        printf("Position out of bounds.\n");
        return;
    }
    
    if (current->pre != NULL) {
        current->pre->next = current->next;
    }
    if (current->next != NULL) {
        current->next->pre = current->pre;
    }
    
    if (current == tail) {
        tail = current->pre; // Update tail if deleted last node
    }
    
    free(current);
}

void displayList() {
    NODE* current = head;
    if (current == NULL) {
        printf("List is empty.\n");
        return;
    }
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

int main() {
    int choice, data, position;

    while (1) {
        printf("\nMenu:\n");
        printf(" 1. Insert at Beginning\n");
        printf("2. Insert at End\n");
        printf("3. Insert at Position\n");
        printf("4. Delete at Beginning\n");
        printf("5. Delete at End\n");
        printf("6. Delete at Position\n");
        printf("7. Display List\n");
        printf("8. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter data to insert at beginning: ");
                scanf("%d", &data);
                insertAtBeginning(data);
                break;
            case 2:
                printf("Enter data to insert at end: ");
                scanf("%d", &data);
                insertAtEnd(data);
                break;
            case 3:
                printf("Enter data and position to insert: ");
                scanf("%d %d", &data, &position);
                insertAtPosition(data, position);
                break;
            case 4:
                deleteAtBeginning();
                break;
            case 5:
                deleteAtEnd();
                break;
            case 6:
                printf("Enter position to delete: ");
                scanf("%d", &position);
                deleteAtPosition(position);
                break;
            case 7:
                displayList();
                break;
            case 8:
                printf("Exiting...\n");
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
    return 0;
}
