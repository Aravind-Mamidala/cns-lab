#include <stdio.h>

int main() {

    char str[] = "Hello World";
    int i;

    for(i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] ^ 0);
    }

    return 0;
}
