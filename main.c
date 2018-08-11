#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <conio.h>
int main() {
    int minute;
    int time1;
    int i = 0;
    while(1){
        time_t rawtime = time(NULL);
        struct tm * timeinfo = localtime(&rawtime);
        time1 = timeinfo -> tm_hour;
        minute = timeinfo -> tm_min;
        int seconds = timeinfo -> tm_sec;
        if(minute == 0) {
            if (seconds == 0) {
                printf("%s\n", "This Shit works");
                printf("%s\n", asctime(timeinfo));
                if (time1 == 0) {

                }
            }
        }else if(minute % 15 == 0){
            i = minute;
            if(seconds == 0) {
                if (i == 15) {
                    //TODO: Add quarter hour, half hour, and 3/4 hour sound
                    printf("%s\n", "This Shit works");
                    printf("%s", asctime(timeinfo));
                } else if (i == 30) {
                    printf("%s\n", "This Shit works");
                    printf("%s\n", asctime(timeinfo));
                } else if (i == 45) {
                    printf("%s\n", "This Shit works");
                    printf("%s\n", asctime(timeinfo));
                }
            }
        }
        //time ( &rawtime );
        //printf("\r%s",asctime (timeinfo));
        fflush(stdout);
        sleep(1);
    }
    return 0;
}