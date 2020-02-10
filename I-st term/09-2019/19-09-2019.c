#include <stdio.h>
#include <stdlib.h>

struct vector_t {
    int count;
    int *items;
};
#define vector_t struct vector_t

void init(vector_t *v){
    v->count = 0;
    v->items = NULL;
}

void push(vector_t *v, int item){
    v->items = (int *) realloc (v->items, sizeof(int) * (++v->count));
    v->items[v->count - 1] = item;
}

void to_digits(int num){
    if (num >= 1 && num <= 9){
        printf("%d\n", num);
    } else {
        int digits[100];
        int i = 0;

        while (num != 0){
            digits[i++] = num % 10;
            num /= 10;
        }

        i--;

        while (i >= 1){
            printf("%d, ", digits[i--]);
        }
        
        printf("%d\n", digits[i]);
    }
}

int main(int argc, char *argv[]){

    // to_digits(100);
    // to_digits(452);

    int num;
    int num_of_nums = atoi(argv[1]);
    vector_t numbers;

    init(&numbers);

    for (int i = 0; i < num_of_nums; i++){
        scanf("%d", &num);
        push(&numbers, num);
    }

    for (int i = 0; i < num_of_nums; i++){
        to_digits(numbers.items[i]);
    }

    return 0;
}