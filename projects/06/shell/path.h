//
//  path.h
//  CS232 Command Shell
//
//  Created by Justin Voss on 1/20/15.
//

#ifndef __CS232_Command_Shell__path__
#define __CS232_Command_Shell__path__

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Path
{
public:
    Path();
    int find(const string& program) const;
    string getDirectory(int i);
private:
    vector<string> directories;
};

#endif /* defined(__CS232_Command_Shell__path__) */