//
//  path.cpp
//  CS232 Command Shell
//
//  Created by Justin Voss on 1/20/15.
//

#include <unistd.h>
#include <stdlib.h>
#include <string>
#include "path.h"
#include <sys/types.h>
#include <dirent.h>
#include <vector>
#include <cstring>
#include <sstream>

Path::Path(){
    char c = ':';
    string currentDirectory;

    string pPath = getenv("PATH"); // https://www.programiz.com/cpp-programming/library-function/cstdlib/getenv#:~:text=C%2B%2B%20feholdexcept()-,C%2B%2B%20getenv(),it%20returns%20a%20null%20pointer.
    
        stringstream sstream(pPath); //https://www.cplusplus.com/reference/sstream/stringstream/stringstream/
        string word;
        while (getline(sstream, word, c)){  //goes until the end of the line, puts it on the directory vector
            directories.push_back(word);
        }
    
}


int Path::find(const string& program) const {
    struct dirent *readdir(DIR *dirp); // reads a directory https://linux.die.net/man/3/readdir
    DIR * directory;
    struct dirent * item;

    for (int i = 0; i < directories.size(); i++) {  // goes through the vector of directories
        directory = opendir(directories[i].c_str()); // opens a directory https://man7.org/linux/man-pages/man3/opendir.3.html
    
        if (directory = opendir (directories.at(i).c_str()))  // checks if open https://man7.org/linux/man-pages/man3/opendir.3.html
        {
            // read every directory until it gets to the file
            while ((item = readdir(directory)) != NULL){  // if the directory is there https://stackoverflow.com/questions/44164436/check-if-item-on-directory-is-folder-in-c
                if (item->d_name == program)
                    { 
                        return i; 
                    } // https://stackoverflow.com/questions/22160807/file-d-name-into-a-variable-in-c
                }
        }
        closedir(directory);
    }
    return -1;
}
string Path::getDirectory(int i){
    return directories.at(i);
}