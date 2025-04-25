#include <stdio.h>
#include <stdlib.h>
typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* head = NULL; 
Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (!newNode) {
        printf("Memory allocation failed\n");
        return NULL;
    }
    newNode->data = data;
    newNode->next = newNode; 
    return newNode;
}
void insertBeginning(int data) {
    Node* newNode = createNode(data);
    if (head == NULL) {
        head = newNode; 
    } else {
        Node* temp = head;
        while (temp->next != head) {
            temp = temp->next; 
        }
        temp->next = newNode; 
    }
    newNode->next = head; 
    head = newNode; 
}
void insertEnd(int data) {
    Node* newNode = createNode(data);
    if (head == NULL) {
        head = newNode; 
    } else {
        Node* temp = head;
        while (temp->next != head) {
            temp = temp->next; 
        }
        temp->next = newNode; 
    }
    newNode->next = head; 
}
void insertAtPosition(int data, int position) {
    if (position == 0) {
        insertBeginning(data);
        return;
    }

    Node* newNode = createNode(data);
    Node* temp = head;

    for (int i = 0; i < position - 1; i++) {
        if (temp->next == head) {
            printf("Position out of bounds. Inserting at the end instead.\n");
            insertEnd(data);
            return;
        }
        temp = temp->next;
    }

    newNode->next = temp->next; 
    temp->next = newNode; 
}
void deleteAtBeginning() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    Node* temp = head;
    if (temp->next == head) {
        free(temp);
        head = NULL; 
    } else {
        Node* last = head;
        while (last->next != head) {
            last = last->next; 
        }
        last->next = temp->next; 
        free(temp);
        head = last->next; 
    }
}
void deleteAtEnd() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    Node* temp = head;
    if (temp->next == head) {
        free(temp);
        head = NULL; 
    } else {
        Node* prev = NULL;
        while (temp->next != head) {
            prev = temp;
            temp = temp->next; 
        }
        prev->next = head; 
        free(temp);
    }
}
void deleteAtPosition(int position) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    if (position == 0) {
        deleteAtBeginning();
        return;
    }

    Node* temp = head;
    Node* prev = NULL;

    for (int i = 0; i < position; i++) {
        if (temp->next == head) {
            printf("Position out of bounds. Unable to delete.\n");
            return;
        }
        prev = temp;
        temp = temp->next;
    }

    prev->next = temp->next; 
    free(temp); 
}
void displayList() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    Node* temp = head;
    do {
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("(head)\n");
}
int main() {
    int choice, data, position;

    while (1) {
        printf("1. Insert at Beginning\n");
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
                printf("Enter data: ");
                scanf("%d", &data);
                insertBeginning(data);
                break;
            case 2:
                printf("Enter data: ");
                scanf("%d", &data);
                insertEnd(data);
                break;
            case 3:
                printf("Enter data and position: ");
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
                printf("Enter position: ");
                scanf("%d", &position);
                deleteAtPosition(position);
                break;
            case 7:
                displayList();
                break;
            case 8:
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
