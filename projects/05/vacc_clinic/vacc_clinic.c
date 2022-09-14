/*
 * Justin Voss
 * CS 323
 * 3/18/22
 */

#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
#include <stdbool.h>

#define NUM_VIALS 6
#define SHOTS_PER_VIAL 6
#define NUM_CLIENTS (NUM_VIALS * SHOTS_PER_VIAL)
#define NUM_NURSES 6
#define NUM_STATIONS NUM_NURSES
#define NUM_REGISTRATIONS_SIMULTANEOUSLY 4

/* global variables */
pthread_mutex_t mutex;
sem_t register_semaphore, full, empty, client_semaphore, nurse_semaphore;

int registers_free = 4; // new variable to keep track of registers while lowering them based on availability
int vials_left = NUM_VIALS;  // keep track of vials when they are lowered each time
int in = 0; // in and out variables to keep track of buffer array indexes
int out = 0;
int buffer[NUM_STATIONS];  // a buffer to be used for the stations


int get_rand_in_range(int lower, int upper) {  
    return (rand() % (upper - lower + 1)) + lower;
}

char *time_str;
char *curr_time_s() {
    time_t t;
    time(&t);
    time_str = ctime(&t);
    // replace ending newline with end-of-string.
    time_str[strlen(time_str) - 1] = '\0';
    return time_str;
}

// lower and upper are in seconds.
void walk(int lower, int upper) {
    usleep(get_rand_in_range(lower* 1000000,upper* 1000000) );  // gives a function that waits a certain amount of time
}

// arg is the nurses station number.
void *nurse(void *arg) {
    long int id = (long int)arg;  // id used for displaying the current nurse
    fprintf(stderr, "%s: nurse %ld started\n", curr_time_s(), id);

        while (vials_left > 0) {  // only runs if there are vials
            
             if (vials_left == 0){  // gets out of loop once vials == 0
                 break;
             }
            else{
                fprintf(stderr, "%s: nurse %ld walking to get a vial\n", curr_time_s(), id);
                walk(1,3);  // waits for a few seconds
                pthread_mutex_lock(&mutex);
                vials_left -= 1;
                pthread_mutex_unlock(&mutex);
            }
                fprintf(stderr, "%s: nurse %ld got a vial. Number of vials left =  %d \n", curr_time_s(), id, vials_left);
                walk(1,3); // waits for a few seconds
                fprintf(stderr, "%s: nurse %ld got back at station. \n", curr_time_s(), id);

            for (int i=0; i < SHOTS_PER_VIAL;i++){  // for each shot in the o5vial, a nurse gives shots
                fprintf(stderr, "%s: nurse %ld tells the waiting queue that she/he is available \n", curr_time_s(), id);
                fprintf(stderr, "%s: nurse %ld waiting for a client to arrive\n", curr_time_s(), id);

                // semaphore and buffer info found at https://shivammitra.com/c/producer-consumer-problem-in-c/#
                // registering
                sem_wait(&empty);  // waits for an available semaphore
                pthread_mutex_lock(&mutex);  // locks a semaphore to protect the bounded buffer
                buffer[in] = id;
                in = (in+1) % NUM_STATIONS;
                pthread_mutex_unlock(&mutex); // unlocks semaphore
                sem_post(&full);  // signals a buffer has data to consume

                // getting a shot
                sem_wait(&client_semaphore);  // nurse waits for client
                fprintf(stderr, "%s: nurse %ld sees client is ready. Giving shot now. \n", curr_time_s(), id);
                walk(5,5); // waits for 5 seconds
                fprintf(stderr, "%s: nurse %ld gave client the shot. \n", curr_time_s(), id);

                sem_post(&client_semaphore);  // lets client go
                sem_post(&nurse_semaphore);  // lets the nurse itself go

            }
        }
    fprintf(stderr, "%s: nurse %ld is done\n", curr_time_s(), id);
    pthread_exit(NULL);  // exits the pthread
}

void *client(void *arg) {
    long int id = (long int)arg;  // id used for displaying current client
    bool registered = false;  // a boolean to keep track of if something is registered

    fprintf(stderr, "%s: client %ld has arrived and is walking to register\n", curr_time_s(), id);
    fprintf(stderr, "%s: client %ld waiting to register\n", curr_time_s(), id);
    walk(3,10); // waits for a few seconds

    while (registered == false){  // if a client is not registered, it will register
    if(registers_free > 0)  // as long as the free registers are not 0
        {
            sem_wait(&register_semaphore);  // waits for register semaphore
            registers_free -= 1;  // decrements a register
            fprintf(stderr, "%s: client %ld is registering\n", curr_time_s(), id);
            walk(3,10); // waits for a few seconds
            registered = true;  // the client is now registered
            fprintf(stderr, "%s: client %ld is done registering. Now walking to the next queue.\n", curr_time_s(), id);
            registers_free += 1;   // now a register is added
            sem_post(&register_semaphore);  // register is released
            
        }
    }
    walk(3,10); // waits for a few seconds
    sem_wait(&full);  
    pthread_mutex_lock(&mutex);  // lock the critical section that can have race conditions

    int station = buffer[out]; // buffer for a station
    fprintf(stderr, "%s: client %ld got assigned to station %d\n", curr_time_s(), id, station);
    out = (out + 1) % NUM_STATIONS; // increments the buffer
    walk(1,2); // waits for a few seconds
    pthread_mutex_unlock(&mutex);  // unlocks the semaphore from the critical section

    fprintf(stderr, "%s: client %ld is ready for the shot from nurse %d\n", curr_time_s(), id, station);

    sem_post(&empty);  // signals that an empty semaphore is ready
    sem_post(&client_semaphore); // let the nurse know the client is ready
    sem_wait(&nurse_semaphore); // wait for the nurse to be ready
    sem_post(&nurse_semaphore); // release the nurse semaphore

    fprintf(stderr, "%s: client %ld got the shot! It hurt, but it is a sacrifice I'm willing to make! \n", curr_time_s(), id);
    fprintf(stderr, "%s: client %ld leaves the clinic!\n", curr_time_s(), id);

    pthread_exit(NULL);
}

int main() {
    
    pthread_t nursethread[NUM_NURSES], clientthread[NUM_CLIENTS];  // initialize pthreads
    sem_init(&register_semaphore,0, NUM_REGISTRATIONS_SIMULTANEOUSLY);  //initialize semaphores
    sem_init(&empty,0,0);
    sem_init(&full,0,NUM_STATIONS);
    sem_init(&client_semaphore,0,0);
    sem_init(&nurse_semaphore,0,0);
    srand(time(0));

    // create a thread for each nurse
    for(int i = 0; i < NUM_NURSES; i++) {  
        pthread_create(&nursethread[i], NULL, nurse, (void*) (intptr_t) i);
    }
    // create a thread for each client
    for(int i = 0; i < NUM_CLIENTS; i++) {
        pthread_create(&clientthread[i], NULL, client, (void*) (intptr_t) i);
    }
    // join the client threads
    for(int i = 0; i < NUM_CLIENTS; i++) {
        pthread_join(clientthread[i], NULL);
    }
    // join the nurse threads
    for(int i = 0; i < NUM_NURSES; i++) {
        pthread_join(nursethread[i], NULL);
    }
    // when it is done, destroy the semaphores and exit the threads
    pthread_mutex_destroy(&mutex);
    sem_destroy(&empty);
    sem_destroy(&full);
    sem_destroy(&register_semaphore);
    sem_destroy(&nurse_semaphore);
    sem_destroy(&client_semaphore);
    pthread_exit(0);
}
