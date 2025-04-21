#include <stdio.h>
#define MAX 10 // Define maximum size for the matrices
void transposeSquareMatrix(int matrix[MAX][MAX], int size) {
    for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
            // Swap elements
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}
void transposeNonSquareMatrix(int matrix[MAX][MAX], int transposed[MAX][MAX], int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            transposed[j][i] = matrix[i][j];
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
    int matrix[MAX][MAX], transposed[MAX][MAX];
    int rows, cols;

    printf("Enter number of rows and columns for the matrix: ");
    scanf("%d %d", &rows, &cols);
    printf("Enter elements of the matrix:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

    if (rows == cols) {
        printf("Original Square Matrix:\n");
        printMatrix(matrix, rows, cols);
        
        transposeSquareMatrix(matrix, rows);
        
        printf("Transposed Square Matrix:\n");
        printMatrix(matrix, rows, cols);
    } else {
        printf("Original Matrix:\n");
        printMatrix(matrix, rows, cols);
        
        transposeNonSquareMatrix(matrix, transposed, rows, cols);
        
        printf("Transposed Matrix:\n");
        printMatrix(transposed, cols, rows); // Note: transposed dimensions are swapped
    }

    return 0;
}
