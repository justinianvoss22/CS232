#include<stdio.h>
#include<string.h>
int main(){
int c;
int nch = 0;
int size = 10;
char *buf[size];
if(buf == NULL)
    {
    fprintf(stderr, "out of memory\n");
    exit(1);
    }

while((c = getchar()) != EOF)
    {
    if(nch >= size-1)
        {
        /* time to make it bigger */
        size += 10;
        buf = realloc(buf, size);
        if(buf == NULL)
            {
            fprintf(stderr, "out of memory\n");
            exit(1);
            }
        }

    buf[nch++] = c;
    }

buf[nch++] = '\0';

printf("\"%s\"", buf);

}