//
//  shell.h
//  CS232 Command Shell
//
//  Created by Victor Norman on 1/20/15.
//  Copyright (c) 2015 Victor Norman. All rights reserved.
//

#ifndef __CS232_Command_Shell__shell__
#define __CS232_Command_Shell__shell__

#include <iostream>
#include <string>
#include "path.h"
#include "commandline.h"
#include "prompt.h"

using namespace std;

class Shell
{
public:
    Shell();
    ~Shell();
    void run();

private:
    Path path;
    char** envp;
    Prompt prompt;
    char* homeDir;
    void otherCommand(CommandLine * commandLine,string commandString, int pathValue);

};

#endif /* defined(__CS232_Command_Shell__shell__) */