//
//  shell.cpp
//  CS232 Command Shell
//
//  Created by Justin Voss on 1/20/15.
//

#include <unistd.h>
#include <stdlib.h>
#include <string>
#include "shell.h"
#include <sys/types.h>  // type definitions, e.g., pid_t
#include <sys/wait.h>   // wait()
#include <signal.h>     // signal name constants and kill()
#include <iostream>
#include <vector>
// constructor
Shell::Shell(){
    path = Path();
    prompt = Prompt();
}

// deconstructor
Shell::~Shell(){
    path.~Path();
    prompt.~Prompt();
   // delete envp;
  //  delete homeDir;
}

// runs the shell
void Shell::run(){
    while(true){
        cout << prompt.get() << flush;
        CommandLine * commandLine = new CommandLine(cin);
        if (commandLine->getCommand() != NULL){
            string commandString = commandLine->getCommand();
            if (commandString == "cd"){
                
                char * directory = commandLine->getArgVector(1); // gets the first arg
                
                int item = chdir(directory); // change directory https://stackoverflow.com/questions/10792227/c-change-working-directory-from-user-input
                if (item != -1){
                    prompt = Prompt();
                }
                else{cout << "No directory found" << endl;}
            }
            else if (commandString == "pwd"){
                cout << prompt.get() << endl;
            }
            
           else if (commandString == "exit"){
                exit(0);
            }
            else{
                int pathValue = path.find(commandString);
                if (pathValue != -1){ // if a valid command somewhere, it takes arguments into the otherCommand function to create a new process with fork
                   otherCommand(commandLine,commandString, pathValue);
                }
                else{  // if not a valid command, returns a message
                    cout << "Invalid command" << endl;
                    }
            }

        }
        delete commandLine;
    }
}

// otherCommand executes any other command  by finding it using the path index
// Parameters: a CommandLine, commandLine, a string, commandString, and a pathValue
// Returns: executes the command, or prints a message saying that process is invalid
void Shell::otherCommand(CommandLine * commandLine,string commandString, int pathValue){
    pid_t c_pid = fork(); //creating a child process https://www.delftstack.com/howto/cpp/cpp-fork/#:~:text=Use%20fork()%20to%20Create%20Two%20Processes%20Within%20the%20Program%20in%20C%2B%2B,-The%20fork%20function&text=The%20function%20creates%20a%20new,executing%20in%20separate%20memory%20spaces.
    if(c_pid == 0){
        string fileName = path.getDirectory(pathValue) + "/" + commandString;
        execve(fileName.c_str(), commandLine->getArgVector(), NULL); // replace process with new process https://stackoverflow.com/questions/10068327/what-does-execve-do
        exit(1);
    }
    else if(c_pid < 0)
        {
            cout << "Invalid child process" << endl;
        }
    else{
        if(commandLine->noAmpersand()){
            waitpid(c_pid,NULL,0); // waits for the child process. https://linux.die.net/man/2/waitpid
        }                          // if there is no ampersand, the user is able to put another input in right away.
    } //goes back up to the top of the while loop
        
}
