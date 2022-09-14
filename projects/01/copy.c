/*
 * copy.c copies the contents of one file and puts it in another file
 *     * Completed by: Justin Voss
 *      * Date: 1/19/22
 *       **********************************************************/


#include <stdio.h>
#include <stdlib.h>
/*
 * copy.c copies the contents of one file and puts it in another file.
 *     * Completed by: Justin Voss
 *      * Date: 1/21/22
 *       **********************************************************/


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>


// to get command line arguments: https://www.geeksforgeeks.org/command-line-arguments-in-c-cpp/
int main (int argc, char *argv[]){
    char* src = argv[1];
    char* dest = argv[2];
    FILE *sp; //  source pointer
    FILE * dp; // dest pointer


    // make a struct to be used to check if a file is regular
    //http://codewiki.wikidot.com/c:system-calls:stat
    struct stat stat1;
    stat(src, &stat1);

    // Sees if the file is regular
    // https://www.linuxquestions.org/questions/programming-9/how-to-know-if-it%27s-regular-file-in-c-217832/
    if (S_ISREG(stat1.st_mode)) {
        
        // checks for every system call against every error code using perror.
        /* Perror implemented from https://www.tutorialspoint.com/c_standard_library/c_function_perror.htm */
    
        // This will check if the dest already exists
        if( access( dest, F_OK ) == 0 ) /* https://stackoverflow.com/questions/230062/whats-the-best-way-to-check-if-a-file-exists-in-c */
        { 
            perror("Error: Destination file already exists");
            exit(-1);
        }

        // https://www.geeksforgeeks.org/c-program-copy-contents-one-file-another-file/
        // checks if the source file is readable
        sp = fopen(src, "r");
        if (sp == NULL)    
        {
            perror("Source file not found" );
            exit(-1);
        }



        // Copy Section:

        // https://www.geeksforgeeks.org/c-program-copy-contents-one-file-another-file/
        // opens the destination file to start writing
        dp = fopen(dest, "w");

        // https://www.geeksforgeeks.org/c-program-copy-contents-one-file-another-file/
        // Copies one file to another, using a while loop and fput and fget to get characters from a file and put it in another.
        char c = fgetc(sp);
        while (c != EOF)
        {
            fputc(c, dp);
            c = fgetc(sp);
        }
    }
    //  If it is not a regular file
    else { 
        perror("Error: Not a regular file");
        exit(-1);
        }
        
    return(0);
}