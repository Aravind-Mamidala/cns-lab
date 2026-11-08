
#include <stdio.h>

int main() {

    char *str = "Hello World";
    int i;

    printf("AND operation:\n");

    for(i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] & 127);
    }

    printf("\nXOR operation:\n");

    for(i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] ^ 127);
    }

    return 0;
}
