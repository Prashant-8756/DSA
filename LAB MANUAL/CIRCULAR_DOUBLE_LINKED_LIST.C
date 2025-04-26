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
void insertEnd(int data) {
    NODE* newNode = createNode(data);
    if (head == NULL) {
        head = newNode;
        tail = newNode;
        newNode->next = head; 
        newNode->pre = head;  
    } else {
        tail->next = newNode; 
        newNode->pre = tail;  
        newNode->next = head; 
        head->pre = newNode;  
        tail = newNode;       
    }
}
void insertBeginning(int data) {
    NODE* newNode = createNode(data);
    if (head == NULL) {
        head = newNode;
        tail = newNode;
        newNode->next = head; 
        newNode->pre = head;  
    } else {
        newNode->next = head; 
        newNode->pre = tail;  
        head->pre = newNode;  
        tail->next = newNode; 
        head = newNode;       
    }
}
void insertAtPosition(int data, int position) {
    if (position <= 0) {
        printf("Position should be greater than 0. Inserting at the beginning instead.\n");
        insertBeginning(data);
        return;
    }

    NODE* newNode = createNode(data);
    if (head == NULL) {
        head = newNode;
        tail = newNode;
        newNode->next = head; 
        newNode->pre = head;  
    } else {
        NODE* temp = head;
        for (int i = 1; i < position && temp->next != head; i++) {
            temp = temp->next;
        }
        newNode->next = temp->next; 
        newNode->pre = temp;        
        temp->next->pre = newNode;  
        temp->next = newNode;       
        if (temp == tail) {         
            tail = newNode;
        }
    }
}
void deleteAtBeginning() {
    if (head == NULL) {
        printf("List is empty. Cannot delete.\n");
        return;
    }
    if (head == tail) { 
        free(head);
        head = NULL;
        tail = NULL;
    } else {
        NODE* temp = head;
        head = head->next; 
        head->pre = tail;  
        tail->next = head; 
        free(temp);        
    }
}
void deleteAtEnd() {
    if (head == NULL) {
        printf("List is empty. Cannot delete.\n");
        return;
    }
    if (head == tail) { 
        free(head);
        head = NULL;
        tail = NULL;
    } else {
        NODE* temp = tail;
        tail = tail->pre; 
        tail->next = head;
        head ->pre = tail;
        free(temp); 
    }
}
void deleteAtPosition(int position) {
    if (head == NULL) {
        printf("List is empty. Cannot delete.\n");
        return;
    }
    if (position <= 0) {
        printf("Position should be greater than 0.\n");
        return;
    }

    NODE* temp = head;
    for (int i = 1; i < position && temp->next != head; i++) {
        temp = temp->next;
    }

    if (temp == head) {
        deleteAtBeginning();
    } else if (temp == tail) {
        deleteAtEnd();
    } else {
        temp->pre->next = temp->next; 
        temp->next->pre = temp->pre; 
        free(temp); 
    }
}
void displayList() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }
    NODE* temp = head;
    do {
        printf("%d ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("\n");
}
void freeList() {
    if (head == NULL) return;
    NODE* current = head;
    NODE* nextNode;
    do {
        nextNode = current->next;
        free(current);
        current = nextNode;
    } while (current != head);
    head = NULL;
    tail = NULL;
}
int main() {
    int choice, data, position;

    while (1) {
        printf("\nMenu:\n");
        printf(" 1. Insert at Beginning\n");
        printf(" 2. Insert at End\n");
        printf(" 3. Insert at Position\n");
        printf(" 4. Delete at Beginning\n");
        printf(" 5. Delete at End\n");
        printf(" 6. Delete at Position\n");
        printf(" 7. Display List\n");
        printf(" 8. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter data to insert at beginning: ");
                scanf("%d", &data);
                insertBeginning(data);
                break;
            case 2:
                printf("Enter data to insert at end: ");
                scanf("%d", &data);
                insertEnd(data);
                break;
            case 3:
                printf("Enter data to insert and position: ");
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
                freeList();
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
    return 0;
}
