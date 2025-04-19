#include <stdio.h>
#define MAX 10 
void addMatrices(int a[MAX][MAX], int b[MAX][MAX], int result[MAX][MAX], int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[i][j] = a[i][j] + b[i][j];
        }
    }
}
void multiplyMatrices(int a[MAX][MAX], int b[MAX][MAX], int result[MAX][MAX], int rowsA, int colsA, int colsB) {
    for (int i = 0; i < rowsA; i++) {
        for (int j = 0; j < colsB; j++) {
            result[i][j] = 0; // Initialize the result cell
            for (int k = 0; k < colsA; k++) {
                result[i][j] += a[i][k] * b[k][j];
            }
        }
    }
}

void printMatrix(int matrix[MAX][MAX], int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int a[MAX][MAX], b[MAX][MAX], sum[MAX][MAX], product[MAX][MAX];
    int rowsA, colsA, rowsB, colsB;

    printf("Enter rows and columns for first matrix: ");
    scanf("%d %d", &rowsA, &colsA);
    printf("Enter elements of first matrix:\n");
    for (int i = 0; i < rowsA; i++) {
        for (int j = 0; j < colsA; j++) {
            scanf("%d", &a[i][j]);
        }
    }

    printf("Enter rows and columns for second matrix: ");
    scanf("%d %d", &rowsB, &colsB);
    printf("Enter elements of second matrix:\n");
    for (int i = 0; i < rowsB; i++) {
        for (int j = 0; j < colsB; j++) {
            scanf("%d", &b[i][j]);
        }
    }

    if (rowsA == rowsB && colsA == colsB) {
        addMatrices(a, b, sum, rowsA, colsA);
        printf("Sum of the matrices:\n");
        printMatrix(sum, rowsA, colsA);
    } else {
        printf("Matrices cannot be added due to incompatible dimensions.\n");
    }

    if (colsA == rowsB) {
        multiplyMatrices(a, b, product, rowsA, colsA, colsB);
        printf("Product of the matrices:\n");
        printMatrix(product, rowsA, colsB);
    } else {
        printf("Matrices cannot be multiplied due to incompatible dimensions.\n");
    }

    return 0;
}
